# !/usr/bin/env python
# -*- coding: utf-8 -*-
import re
import string
import requests
import requests.adapters
import random
from lxml import etree
import json
import spider
import douban.config as config


class fetcher(spider.Fetcher):

    def __init__(self,max_repeat=3,sleep_time=0):
        spider.Fetcher.__init__(self, max_repeat, sleep_time)
        self.session=requests.Session()
        """
        mount
        调用会注册一个传输适配器的特定实例到一个前缀上面
        加载以后
        任何使用该会话的 HTTP 请求
        只要其 URL 是以给定的前缀开头，该传输适配器就会被使用到
        """
        self.session.mount("https://movie.douban.com",requests.adapters.HTTPAdapter(pool_connections=100, pool_maxsize=100))
        self.session.headers.clear()
        self.session.cookies.clear()
        header_info={
            "Host": "movie.douban.com",
            "Cookie": self.get_cookie()
        }
        self.session.headers={**config.header,**header_info}
        return
    # 更换cookie
    def get_cookie(self):
        return "bid=%s" % "".join(random.sample(string.ascii_letters + string.digits, 11))
    # override
    def url_fetch(self, priority: int, url: str, keys: dict, deep: int, repeat: int, proxies=None):
        response = self.session.get(url,proxies=proxies, timeout=(3.05, 10))
        self.session.headers.update({"User-Agent": config.get_random_UserAgents()})
        self.session.headers.update({"Cookie":self.get_cookie()})
        """
        if response.status_code != 200:
            self.session.headers.update({"User-Agent": config.get_random_UserAgents()})
            self.session.headers.update({"Cookie":self.get_cookie()})
            logging.warning("all_fetcher change cookie and user-agent:"+response.status_code)
        """

        # when IP was restricted , still return 200
        if keys["type"]=="new_tag":
            if json.loads(re.sub(r"\\","",response.text))["subjects"]:
                return  1,True,(response.status_code,response.url,re.sub(r"\\","",response.text))
            else:
                return  0,False,(403,response.url,re.sub(r"\\","",response.text))

        else:
            if len(response.text)>10000:
                return  1,True,(response.status_code,response.url,response.text)
            else:
                if etree.HTML(response.text).xpath("//div[@id='content']/h1/text()"):

                    return  1,True,(response.status_code,response.url,response.text)
                else:
                    return  0,False,(403,response.url,response.text)

        #print(response.text)
        #print(proxies)
        #return  1,True,(response.status_code,response.url,re.sub(r"\\","",response.text))

if __name__ == "__main__":
    f=fetcher()
    print(f.url_fetch(url="https://movie.douban.com/tag/动作",keys={"type":"all_tag"},repeat=3,priority=1,deep=0))
