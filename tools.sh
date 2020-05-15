#!/bin/bash

RUN_SERVER=/home/humingk/run
OUTPUT_SERVER=/home/humingk/git/douban_movie_plus/doc/log
# jar
export SERVER_EUREKA_JAR=$RUN_SERVER/movie-server-eureka-*
export SERVER_CONFIG_JAR=$RUN_SERVER/movie-server-config-*
export SERVER_AUTH_JAR=$RUN_SERVER/movie-server-auth-*
export SERVER_MOVIE_JAR=$RUN_SERVER/movie-server-movie-*
export SERVER_SEARCH_JAR=$RUN_SERVER/movie-server-search-*
export SERVER_SCENE_JAR=$RUN_SERVER/movie-server-scene-*
export SERVER_CELEBRITY_JAR=$RUN_SERVER/movie-server-celebrity-*
export SERVER_USER_JAR=$RUN_SERVER/movie-server-user-*
export SERVER_GATEWAY_JAR=$RUN_SERVER/movie-server-gateway-*
# 端口
export SERVER_EUREKA_PORT=8761
export SERVER_CONFIG_PORT=8888
export SERVER_AUTH_PORT=8006
export SERVER_MOVIE_PORT=10101
export SERVER_SEARCH_PORT=10105
export SERVER_SCENE_PORT=10106
export SERVER_CELEBRITY_PORT=10104
export SERVER_USER_PORT=10103
export SERVER_GATEWAY_PORT=9527
# jvm参数       堆最大   堆初始化 年轻3/8 线程大小 年轻代并发回收垃圾  年轻垃圾回收线程数(cpu)
JVM_128_256=" -Xmx128m -Xms128m -Xmn48m -Xss256k -XX:+UseParallelGC -XX:ParallelGCThreads=1 "
JVM_160_256=" -Xmx160m -Xms160m -Xmn64m -Xss256k -XX:+UseParallelGC -XX:ParallelGCThreads=1 "
JVM_256_256=" -Xmx256m -Xms256m -Xmn96m -Xss256k -XX:+UseParallelGC -XX:ParallelGCThreads=1 "
JVM_300_256=" -Xmx300m -Xms300m -Xmn112m -Xss256k -XX:+UseParallelGC -XX:ParallelGCThreads=1 "
JVM_300_512=" -Xmx300m -Xms300m -Xmn112m -Xss512k -XX:+UseParallelGC -XX:ParallelGCThreads=1 "
JVM_428_256=" -Xmx428m -Xms428m -Xmn160m -Xss256k -XX:+UseParallelGC -XX:ParallelGCThreads=1 "
JVM_428_428=" -Xmx428m -Xms428m -Xmn160m -Xss428k -XX:+UseParallelGC -XX:ParallelGCThreads=1 "
JVM_428_512=" -Xmx428m -Xms428m -Xmn160m -Xss512k -XX:+UseParallelGC -XX:ParallelGCThreads=1 "
JVM_512_512=" -Xmx512m -Xms512m -Xmn192m -Xss512k -XX:+UseParallelGC -XX:ParallelGCThreads=1 "

# 功能函数
# ------------------------------

# 更改项目版本
function version_change() {
  sed -n '28p;29q' pom.xml | sed 's/<version>\(.*\)<\/version>/当前版本号为: \1/g'
  read -p "请输入新版本号:" new_version
  mvn -f "pom.xml" versions:set -DoldVersion=* -DnewVersion="$new_version" -DprocessAllModules=true -DallowSnapshots=true -DgenerateBackupPoms=false
  if [ $? -eq 0 ]; then
    echo "更改版本成功，新版本号: "$new_version
  else
    echo "更改版本失败"
  fi
}

# 生成RSA密钥对
function rsa_create() {
  read -p "你确定要覆盖生成RSA密钥对？[y/n]:" choose_sure_rsa
  if [ "$choose_sure_rsa" = "y" ]; then
    # 生成jks (另需要秘钥口令和秘钥库口令)
    keytool -genkey -alias oauth2 -keyalg RSA -keystore ./doc/key/oauth2.jks -keysize 2048 -dname "CN=humingk,OU=org,O=doubans,L=Beijing,S=Beijing,C=China"
    # PKCS12
    keytool -importkeystore -srckeystore ./doc/key/oauth2.jks -destkeystore ./doc/key/oauth2.jks -deststoretype pkcs12
    # 生成公钥
    keytool -list -rfc --keystore ./doc/key/oauth2.jks | openssl x509 -inform pem -pubkey >./doc/key/public.txt
    echo "密钥生成路径: ./doc/key/"
  fi
}

# 启动zipkin服务
function zipkin_start() {
  if [ ! -f "./zipkin.jar" ]; then
    curl -sSL https://zipkin.io/quickstart.sh | bash -s
  fi
  exec="java -jar ./zipkin.jar
      --zipkin.collector.rabbitmq.addresses=localhost
      --zipkin.collector.rabbitmq.port=6572
      --zipkin.collector.rabbitmq.username=guest
      --zipkin.collector.rabbitmq.password=guest
      --STORAGE_TYPE=mysql
      --MYSQL_HOST=localhost
      --MYSQL_TCP_PORT=3306
      --MYSQL_DB=movie
      --MYSQL_USER=root
      --MYSQL_PASS=1233"
  read -p "你希望后台运行Zipkin服务吗? [y/n]:" choose_back
  if [ "$choose_back" = "n" ]; then
    eval $exec
  else
    exec_new="nohup "$exec" >>./doc/log/zipkin-server.log 2>&1 &"
    eval $exec_new
    if [ $? -eq 0 ]; then
      echo "zipkin已在后台运行，查看进程：ps -ef | grep zipkin"
    else
      echo "zipkin运行失败"
    fi
  fi
}

# 更新API文档
function api_update() {
  read -p "你确定要更新API文档吗？[y/n]:" choose_update_api
  if [ "$choose_update_api" = "y" ]; then
  sed -i "s/@RestController/\/\/\ @RestController/g" $(grep annotation -rl ./movie-common/src/main/java/org/humingk/movie/common/controller/MyErrorController.java)
  sed -i "s/@RestController/\/\/\ @RestController/g" $(grep annotation -rl ./movie-server-gateway/src/main/java/org/humingk/movie/server/gateway/controller/FallbackController.java)
  sed -i "s/\/\/\ import/import/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
  sed -i "s/\/\/\ @RestController/@RestController/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
  echo "部署环境..."
  echo "正在生成文档..."
  mvn -pl movie-api -Dfile.encoding=UTF-8 smart-doc:html||true
  mvn -pl movie-api -Dfile.encoding=UTF-8 smart-doc:markdown||true
  mvn -pl movie-api -Dfile.encoding=UTF-8 smart-doc:postman||true
  sed -i "s/\/\/\ @RestController/@RestController/g" $(grep annotation -rl ./movie-common/src/main/java/org/humingk/movie/common/controller/MyErrorController.java)
  sed -i "s/\/\/\ @RestController/@RestController/g" $(grep annotation -rl ./movie-server-gateway/src/main/java/org/humingk/movie/server/gateway/controller/FallbackController.java)
  sed -i "s/import\ org.springframework.web.bind.annotation.RestController;/\/\/\ import\ org.springframework.web.bind.annotation.RestController;/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
  sed -i "s/@RestController/\/\/\ @RestController/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
  echo "撤销环境..."
  fi
}

function export_database_sql_create() {
  read -p "你确定要导出数据库建表SQL语句吗？[y/n]:" choose_export
  if [ "$choose_export" = "y" ]; then
    mysqldump -h localhost -P 3306 -uroot -p -d --databases movie >./doc/sql/movie_import.sql
    if [ $? -eq 0 ]; then
      echo "导出成功 => ./doc/movie_import.sql"
    else
      echo "导出失败..."
    fi
  fi
}

function delete_target() {
  read -p "你确定要删除target目录吗？[y/n]:" choose_delete_target
  if [ "$choose_delete_target" = "y" ]; then
    rm -rf ./*/target
    rm -rf ./movie-servers/*/target
    rm -rf ./movie-services/*/target
    echo "删除成功..."
  fi
}

function export_database_backup(){
    date=$(date "+%Y%m%d")
    sudo mysqldump -h localhost -P 3306 -uroot -p --databases movie > ~/Documents/备份/movie${date}.sql
}

# 启动NeteaseCloudMusicApi服务
function netease_start() {
  if [ ! -d "./NeteaseCloudMusicApi" ]; then
    git clone --depth 1 https://github.com/Binaryify/NeteaseCloudMusicApi
    cd ./NeteaseCloudMusicApi && npm install && cd ..
  fi
  exec="PORT=10102 node ./NeteaseCloudMusicApi/app.js"
  read -p "你希望后台运行musicApi服务吗? [y/n]:" choose_back
  if [ "$choose_back" = "n" ]; then
    eval $exec
  else
    exec_new="nohup "$exec" >>./doc/log/NeteaseCloudMusicApi-server.log 2>&1 &"
    eval $exec_new
    if [ $? -eq 0 ]; then
      echo "NeteaseCloudMusicApi已在后台运行，查看进程：ps -ef | grep NeteaseCloudMusicApi"
    else
      echo "NeteaseCloudMusicApi运行失败"
    fi
  fi
}

function start_project(){
    # 环境变量
    source /etc/profile
    start_time=$(date +%s%N)
    echo "正在启动项目..."
    # eureka ------------------------------
    echo "正在启动eureka..."
    nohup java -jar $JVM_128_256 $SERVER_EUREKA_JAR >>$OUTPUT_SERVER/eureka.log 2>&1 &
    eureka_pid=`lsof -i:$SERVER_EUREKA_PORT|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$eureka_pid" ]
    do
        eureka_pid=`lsof -i:$SERVER_EUREKA_PORT|grep "LISTEN"|awk '{print $2}'`
    done
    echo "eureka启动成功..."
    # config ------------------------------
    echo "正在启动config..."
    nohup java -jar $JVM_128_256 $SERVER_CONFIG_JAR >>$OUTPUT_SERVER/config.log 2>&1 &
    config_pid=`lsof -i:$SERVER_CONFIG_PORT|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$config_pid" ]
    do
        config_pid=`lsof -i:$SERVER_CONFIG_PORT|grep "LISTEN"|awk '{print $2}'`
    done
    echo "config启动成功..."
#    # auth ------------------------------
#    echo "正在启动auth..."
#    nohup java -jar $JVM_160_256 $SERVER_AUTH_JAR >>$OUTPUT_SERVER/auth.log 2>&1 &
#    auth_pid=`lsof -i:$SERVER_AUTH_PORT|grep "LISTEN"|awk '{print $2}'`
#    until [ -n "$auth_pid" ]
#    do
#        auth_pid=`lsof -i:$SERVER_AUTH_PORT|grep "LISTEN"|awk '{print $2}'`
#    done
#    echo "auth启动成功..."
    # movie ------------------------------
    echo "正在启动movie..."
    nohup java -jar $JVM_256_256 $SERVER_MOVIE_JAR >>$OUTPUT_SERVER/movie.log 2>&1 &
    movie_pid=`lsof -i:$SERVER_MOVIE_PORT|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$movie_pid" ]
    do
        movie_pid=`lsof -i:$SERVER_MOVIE_PORT|grep "LISTEN"|awk '{print $2}'`
    done
    echo "movie启动成功..."
    # search ------------------------------
    echo "正在启动search..."
    nohup java -jar $JVM_256_256 $SERVER_SEARCH_JAR >>$OUTPUT_SERVER/search.log 2>&1 &
    search_pid=`lsof -i:$SERVER_SEARCH_PORT|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$search_pid" ]
    do
        search_pid=`lsof -i:$SERVER_SEARCH_PORT|grep "LISTEN"|awk '{print $2}'`
    done
    echo "search启动成功..."
    # scene ------------------------------
    echo "正在启动scene..."
    nohup java -jar $JVM_256_256 $SERVER_SCENE_JAR >>$OUTPUT_SERVER/scene.log 2>&1 &
    scene_pid=`lsof -i:$SERVER_SCENE_PORT|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$scene_pid" ]
    do
        scene_pid=`lsof -i:$SERVER_SCENE_PORT|grep "LISTEN"|awk '{print $2}'`
    done
    echo "scene启动成功..."
    # celebrity ------------------------------
    echo "正在启动celebrity..."
    nohup java -jar $JVM_256_256 $SERVER_CELEBRITY_JAR >>$OUTPUT_SERVER/celebrity.log 2>&1 &
    celebrity_pid=`lsof -i:$SERVER_CELEBRITY_PORT|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$celebrity_pid" ]
    do
        celebrity_pid=`lsof -i:$SERVER_CELEBRITY_PORT|grep "LISTEN"|awk '{print $2}'`
    done
    echo "celebrity启动成功..."
#    # user ------------------------------
#    echo "正在启动user..."
#    nohup java -jar $JVM_256_256 $SERVER_USER_JAR >>$OUTPUT_SERVER/user.log 2>&1 &
#    user_pid=`lsof -i:$SERVER_USER_PORT|grep "LISTEN"|awk '{print $2}'`
#    until [ -n "$user_pid" ]
#    do
#        user_pid=`lsof -i:$SERVER_USER_PORT|grep "LISTEN"|awk '{print $2}'`
#    done
#    echo "user启动成功..."
    # gateway ------------------------------
    echo "正在启动gateway..."
    nohup java -jar $JVM_512_256 $SERVER_GATEWAY_JAR >>$OUTPUT_SERVER/gateway.log 2>&1 &
    gateway_pid=`lsof -i:$SERVER_GATEWAY_PORT|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$gateway_pid" ]
    do
        gateway_pid=`lsof -i:$SERVER_GATEWAY_PORT|grep "LISTEN"|awk '{print $2}'`
    done
    echo "gateway启动成功..."
    end_time=$(date +%s%N)
    use_time=`echo $end_time $start_time | awk '{ print ($1 - $2) / 1000000000}'`
    date=$(date "+%Y%m%d %H:%M:%S")
    echo "当前时间为${date},服务启动时间为:${use_time}s"
    echo "------------------------------------------------"
}

function stop_project(){
    echo "正在停止项目..."
    server_list[0]=$SERVER_EUREKA_JAR
    server_list[1]=$SERVER_CONFIG_JAR
    server_list[2]=$SERVER_AUTH_JAR
    server_list[3]=$SERVER_MOVIE_JAR
    server_list[4]=$SERVER_USER_JAR
    server_list[5]=$SERVER_CELEBRITY_JAR
    server_list[6]=$SERVER_SCENE_JAR
    server_list[7]=$SERVER_SEARCH_JAR
    server_list[8]=$SERVER_GATEWAY_JAR
    for server in ${server_list[@]}
    do
    server_pid=`ps -ef | grep -w $server | grep -v "grep" | awk '{print $2}'`
    if [ -n "$server_pid" ]; then
    kill -9 $server_pid
    echo "server关闭成功,PID:${server_pid},jar:$server"
    fi
    done
}

# main
# ------------------------------

if [ -n "$1" ]; then
    if [ "$1" = "start" ]; then
    start_project
    elif [ "$1" = "stop" ]; then
    stop_project
    fi
else
    echo "========== 豆瓣电影Plus 脚本工具 =========="
    echo "[0]  更新项目版本"
    echo "[1]  生成RSA密钥对"
    echo "[2]  启动zipkin服务"
    echo "[3]  更新API文档"
    echo "[4]  手动删除target目录"
    echo "[5]  导出数据库建表语句"
    echo "[6]  导出数据库备份文件"
    echo "[7]  启动MusicApi服务"
    echo "[8]  启动项目 start"
    echo "[9]  停止项目 stop"
    echo "==========================================="
    read -p "请选择脚本:" choose
    case $choose in
    0)
      version_change
      ;;
    1)
      rsa_create
      ;;
    2)
      zipkin_start
      ;;
    3)
      api_update
      ;;
    4)
      delete_target
      ;;
    5)
      export_database_sql_create
      ;;
    6)
      export_database_backup
      ;;
    7)
      netease_start
      ;;
    8)
      start_project
      ;;
    9)
      stop_project
      ;;
    esac
fi
