#!/bin/bash

echo "========== 豆瓣电影Plus 脚本工具 =========="
echo "[0]  更新项目版本"
echo "[1]  生成RSA密钥对"
echo "[2]  启动zipkin服务"
echo "[3]  更新API文档"
echo "[4]  手动删除target目录"
echo "[5]  导出数据库建表语句"
echo "[6]  导出数据库备份文件"
echo "[7]  启动MusicApi服务"
echo "==========================================="
read -p "请选择脚本:" choose

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
  if [ ! -f "./run/zipkin.jar" ]; then
    curl -sSL https://zipkin.io/quickstart.sh | bash -s
  fi
  exec="java -jar ./run/zipkin.jar
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
    rm ./movie-dal/src/main/java/org/humingk/movie/dal/entity/*
    rm ./movie-dal/src/main/java/org/humingk/movie/dal/mapper/auto/*
    rm ./movie-dal/src/main/resources/mapper/auto/*
    mysqldump -h localhost -P 3306 -uroot -p -d --databases movie >./doc/sql/movie_import.sql
    if [ $? -eq 0 ]; then
      echo "导出成功 => ./doc/movie_import.sql"
    else
      echo "导出失败..."
    fi
  fi
}

function export_database_backup(){
    date=$(date "+%Y%m%d")
    sudo mysqldump -h localhost -P 3306 -uroot -p --databases movie > ~/Documents/备份/movie${date}.sql
}

# 启动NeteaseCloudMusicApi服务
function netease_start() {
  if [ ! -d "./run/NeteaseCloudMusicApi" ]; then
    git clone --depth 1 https://github.com/Binaryify/NeteaseCloudMusicApi ./run/
    cd ./run/NeteaseCloudMusicApi && npm install && cd ../..
  fi
  exec="PORT=10102 node ./run/NeteaseCloudMusicApi/app.js"
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
esac
