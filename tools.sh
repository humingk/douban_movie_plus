#!/bin/bash
echo "========== 豆瓣电影Plus 脚本工具 =========="
echo "[0]  更改项目版本"
echo "[1]  生成RSA密钥对"
echo "[2]  启动zipkin服务"
echo "[3]  更新API文档"
echo "========================================="
read -p "请选择脚本:" choose
# -------------------------------------------------------------------
if [ $choose -eq 0 ]; then
  read -p "请输入新版本号:" new_version
  mvn -f "pom.xml" versions:set -DoldVersion=* -DnewVersion="$new_version" -DprocessAllModules=true -DallowSnapshots=true -DgenerateBackupPoms=false
  if [ $? -eq 0 ]; then
    echo "更改版本成功，新版本号: "$new_version
  else
    echo "更改版本失败"
  fi
# -------------------------------------------------------------------
elif [ $choose -eq 1 ]; then
  read -p "你确定要生成RSA密钥对？[y/n]:" choose_sure_rsa
  if [ "$choose_sure_rsa" = "y" ]; then
    # 生成jks (另需要秘钥口令和秘钥库口令)
    keytool -genkey -alias oauth2 -keyalg RSA -keystore ./doc/key/oauth2.jks -keysize 2048 -dname "CN=humingk,OU=org,O=doubans,L=Beijing,S=Beijing,C=China"
    # PKCS12
    keytool -importkeystore -srckeystore ./doc/key/oauth2.jks -destkeystore ./doc/key/oauth2.jks -deststoretype pkcs12
    # 生成公钥
    keytool -list -rfc --keystore ./doc/key/oauth2.jks | openssl x509 -inform pem -pubkey >./doc/key/public.txt
    echo "密钥生成路径: ./doc/key/"
  fi
# -------------------------------------------------------------------
elif [ $choose -eq 2 ]; then
  # 官网下载zipkin的jar包（建议代理下载）
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
# -------------------------------------------------------------------
elif [ $choose -eq 3 ]; then
  read -p "你确定要更新API文档？[y/n]:" choose_sure_api
  if [ "$choose_sure_api" = "y" ]; then
    echo "添加RestController注解..."
    sed -i "s/\/\/import/import/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
    sed -i "s/\/\/@RestController/@RestController/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
    sed -i "s/@RestController/\/\/@RestController/g" $(grep annotation -rl ./movie-common/src/main/java/org/humingk/movie/common/controller/MyErrorController.java)
    sed -i "s/@RestController/\/\/@RestController/g" $(grep annotation -rl ./movie-server-gateway/src/main/java/org/humingk/movie/server/gateway/controller/FallbackController.java)
    # API生成
    echo "进行到movie-api即可中止[Ctrl+C]"
    echo "-------------------"
    echo "[0] adoc"
    echo "[1] html"
    echo "[2] markdown"
    echo "[3] postman"
    echo "-------------------"
    read -p "请选择类型：" choose_api
    exec_api="mvn -Dfile.encoding=UTF-8 smart-doc:"
    if [ $choose_api -eq 0 ]; then
      exec $exec_api"adoc"
    elif [ $choose_api -eq 1 ]; then
      exec $exec_api"html"
    elif [ $choose_api -eq 2 ]; then
      exec $exec_api"markdown"
    elif [ $choose_api -eq 3 ]; then
      exec $exec_api"postman"
    fi
    echo "撤销RestController注解..."
    sed -i "s/import\ org.springframework.web.bind.annotation.RestController;/\/\/import\ org.springframework.web.bind.annotation.RestController;/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
    sed -i "s/@RestController/\/\/@RestController/g" $(grep annotation -rl ./movie-api/src/main/java/org/humingk/movie/api/*/*Api.java)
    sed -i "s/\/\/@RestController/@RestController/g" $(grep annotation -rl ./movie-common/src/main/java/org/humingk/movie/common/controller/MyErrorController.java)
    sed -i "s/\/\/@RestController/@RestController/g" $(grep annotation -rl ./movie-server-gateway/src/main/java/org/humingk/movie/server/gateway/controller/FallbackController.java)
  fi
fi
exit 0
