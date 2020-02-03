echo "========== 豆瓣电影Plus 脚本工具 =========="
echo " 0. 更改项目版本"
echo " 1. 生成RSA密钥对"
echo "-----------------------------------------"
read -p "请选择脚本:" tool
if [ $tool -eq 0 ]
then
  read -p "请输入新版本号:" new_version
  mvn -f "pom.xml" versions:set -DoldVersion=* -DnewVersion="$new_version" -DprocessAllModules=true -DallowSnapshots=true -DgenerateBackupPoms=false
elif [ $tool -eq 1 ]
then
  # 生成jks (另需要秘钥口令和秘钥库口令)
  keytool -genkey -alias oauth2 -keyalg RSA -keystore ./doc/key/oauth2.jks -keysize 2048  -dname "CN=humingk,OU=org,O=doubans,L=Beijing,S=Beijing,C=China"
  # PKCS12
  keytool -importkeystore -srckeystore ./doc/key/oauth2.jks -destkeystore ./doc/key/oauth2.jks -deststoretype pkcs12
  # 生成公钥
  keytool -list -rfc --keystore ./doc/key/oauth2.jks | openssl x509 -inform pem -pubkey > ./doc/key/public.txt
fi
exit 0