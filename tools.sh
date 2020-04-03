#!/bin/bash
base_path=/home/humingk/git/douban_movie_plus/

echo "========== 豆瓣电影Plus 脚本工具 =========="
echo "[0]  更改项目版本"
echo "[1]  生成RSA密钥对"
echo "[2]  启动zipkin服务"
echo "[3]  更新API文档(暂时bug,记得结束后运行[5])"
echo "[4]  强制部署[3]需要的环境"
echo "[5]  强制撤销[3]部署的环境"
echo "[6]  删除target目录"
echo "[7]  导出数据库建表SQL语句"
echo "[8]  启动NeteaseCloudMusicApi服务"
echo "========================================="
read -p "请选择脚本:" choose

# 功能函数
# ------------------------------

# 更改项目版本
function version_change() {
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
  exec="java -jar zipkin.jar
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
  read -p "你希望后台运行吗? [y/n]:" choose_back
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
  echo "请选择生成文档类型"
  echo "-------------------"
  echo "[0] adoc"
  echo "[1] html"
  echo "[2] markdown"
  echo "[3] postman"
  echo "-------------------"
  read -p "请选择类型：" choose_api
  env_create
  # 执行mvn
  exec_api="mvn -Dfile.encoding=UTF-8 smart-doc:"
  case $choose_api in
  0)
    exec $exec_api"adoc"
    ;;
  1)
    exec $exec_api"html"
    ;;
  2)
    exec $exec_api"markdown"
    ;;
  3)
    exec $exec_api"postman"
    ;;
  esac
  # env_release
}

# 部署环境配置
function env_create() {
  read -p "你确定要部署API环境配置吗？[y/n]:" choose_sure_api_env_create
  if [ "$choose_sure_api_env_create" = "y" ]; then
    echo "配置环境..."
    # pom
    sed -i "s/<module>/<\!--<module>/g" ./pom.xml
    sed -i "s/<\/module>/<\/module>-->/g" ./pom.xml
    sed -i "s/<\!--<module>movie-api<\/module>-->/<module>movie-api<\/module>/g" ./pom.xml
    sed -i "s/<\!--<module>movie-dal<\/module>-->/<module>movie-dal<\/module>/g" ./pom.xml
    sed -i "s/<\!--<module>movie-common<\/module>-->/<module>movie-common<\/module>/g" ./pom.xml
    # controller
    sed -i "s/@RestController/\/\/\ @RestController/g" $(grep annotation -rl ./movie-common/src/main/java/org/humingk/movie/common/controller/MyErrorController.java)
    sed -i "s/@RestController/\/\/\ @RestController/g" $(grep annotation -rl ./movie-server-gateway/src/main/java/org/humingk/movie/server/gateway/controller/FallbackController.java)
    sed -i "s/\/\/\ import/import/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
    sed -i "s/\/\/\ @RestController/@RestController/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
  fi
}

# 撤销环境配置
function env_release() {
  read -p "你确定要撤销部署API环境配置吗？[y/n]:" choose_sure_api_env_release
  if [ "$choose_sure_api_env_release" = "y" ]; then
    echo "撤销配置环境..."
    # pom
    sed -i "s/<\!--<module>/<module>/g" ./pom.xml
    sed -i "s/<\/module>-->/<\/module>/g" ./pom.xml
    # controller
    sed -i "s/\/\/\ @RestController/@RestController/g" $(grep annotation -rl ./movie-common/src/main/java/org/humingk/movie/common/controller/MyErrorController.java)
    sed -i "s/\/\/\ @RestController/@RestController/g" $(grep annotation -rl ./movie-server-gateway/src/main/java/org/humingk/movie/server/gateway/controller/FallbackController.java)
    sed -i "s/import\ org.springframework.web.bind.annotation.RestController;/\/\/\ import\ org.springframework.web.bind.annotation.RestController;/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
    sed -i "s/@RestController/\/\/\ @RestController/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
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

function export_database_sql_create() {
  read -p "你确定要导出数据库建表SQL语句吗？[y/n]:" choose_export
  if [ "$choose_export" = "y" ]; then
    mysqldump -h localhost -P 3306 -uroot -p -d --databases movie >./doc/sql/export_movie.sql
    if [ $? -eq 0 ]; then
      echo "导出成功 => ./doc/export_movie.sql"
    else
      echo "导出失败..."
    fi
  fi
}

# 启动NeteaseCloudMusicApi服务
function netease_start() {
  if [ ! -d "./NeteaseCloudMusicApi" ]; then
    git clone --depth 1 https://github.com/Binaryify/NeteaseCloudMusicApi
    cd NeteaseCloudMusicApi && npm install && cd ..
  fi
  exec="PORT=10102 node ./NeteaseCloudMusicApi/app.js"
  read -p "你希望后台运行吗? [y/n]:" choose_back
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


# main
# ------------------------------
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
  env_create
  ;;
5)
  env_release
  ;;
6)
  delete_target
  ;;
7)
  export_database_sql_create
  ;;
8)
  netease_start
  ;;
esac
