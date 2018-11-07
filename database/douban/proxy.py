# !/usr/bin/env python
# -*- coding: utf-8 -*-
import json
import requests
import pymysql
import logging
import spider
import  douban.config

class proxy(spider.Proxieser):
    def __init__(self,sleep_time=0):
        self._sleep_time=sleep_time
        try:
            self.db=pymysql.connect("localhost",config.user_name,config.user_pwd,"ipproxy",charset=config.database_charset)
            self.cursor=self.db.cursor()
        except pymysql.err as e:
            logging("open your mysql please...")
            logging(e)
        return

    # override
    def proxies_get(self):
        proxies_list=[]

        #数据库方式获取代理IP

        #sql_1="SELECT ip,port FROM %s WHERE https='yes'" % "free_ipproxy"
        sql_1="SELECT ip,port FROM %s" % "free_ipproxy"
        try:
            self.cursor.execute(sql_1)
            proxies_list.extend([{"https": "https://" + ip[0] + ":" + str(ip[1])} for ip in self.cursor.fetchall()])
        except pymysql.err as e:
            logging("open your mysql please...")
            logging(e)

        #sql_2 = "SELECT ip,port FROM %s WHERE https='yes'" % "httpbin"
        sql_2 = "SELECT ip,port FROM %s" % "httpbin"
        try:
            self.cursor.execute(sql_2)
            proxies_list.extend([{"https": "https://" + ip[0] + ":" + str(ip[1])} for ip in self.cursor.fetchall()])
        except pymysql.err as e:
            logging("open your mysql please...")
            logging(e)
        #print(proxies_list)
        return 1, proxies_list
        #API方式获取代理IP

        """
        response_bin=requests.get("http://127.0.0.1:8000/select?name=httpbin&https=yes")
        response_free=requests.get("http://127.0.0.1:8000/select?name=free_ipproxy&https=yes")
        proxies_list.extend([{"http":"http://"+str(ip["ip"])+":"+str(ip["port"]),"https":"https://"+str(ip["ip"])+":"+str(ip["port"])} for ip in json.loads(response_bin.text)])
        proxies_list.extend([{"http":"http://"+str(ip["ip"])+":"+str(ip["port"]),"https":"https://"+str(ip["ip"])+":"+str(ip["port"])} for ip in json.loads(response_free.text)])
        #print(proxies_list)
        #print("proxy's num = "+str(len(proxies_list)))
        #print("proxy test =======================================")
        
        return 1,proxies_list
        #return 1,[{"https":"https://118.178.170.146:80"}]
        """

if __name__ == "__main__":

    idp=proxy(sleep_time=10)
    idp.proxies_get()
