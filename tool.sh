echo "========== 豆瓣电影Plus 脚本工具 =========="
echo "[0]  更改项目版本"
echo "[1]  生成RSA密钥对"
echo "[2]  启动zipkin服务"
echo "========================================="
read -p "请选择脚本:" choose
if [ $choose -eq 0 ]; then
  read -p "请输入新版本号:" new_version
  mvn -f "pom.xml" versions:set -DoldVersion=* -DnewVersion="$new_version" -DprocessAllModules=true -DallowSnapshots=true -DgenerateBackupPoms=false
elif [ $choose -eq 1 ]; then
  # 生成jks (另需要秘钥口令和秘钥库口令)
  keytool -genkey -alias oauth2 -keyalg RSA -keystore ./doc/key/oauth2.jks -keysize 2048 -dname "CN=humingk,OU=org,O=doubans,L=Beijing,S=Beijing,C=China"
  # PKCS12
  keytool -importkeystore -srckeystore ./doc/key/oauth2.jks -destkeystore ./doc/key/oauth2.jks -deststoretype pkcs12
  # 生成公钥
  keytool -list -rfc --keystore ./doc/key/oauth2.jks | openssl x509 -inform pem -pubkey >./doc/key/public.txt
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
  read -p "你希望后台运行吗? [Y/n]" is_back
  if [ "$is_back" = "n" ]; then
    eval $exec
  else
    exec_new="nohup "$exec" >>./doc/log/zipkin-server.log 2>&1 &"
    eval $exec_new
  fi
fi
exit 0
