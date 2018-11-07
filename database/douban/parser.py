# !/usr/bin/env python
# -*- coding: utf-8 -*-

import json
from lxml import etree
import re
import random
import spider



class parser(spider.Parser):

    # override
    def htm_parse(self, priority: int, url: str, keys: dict, deep: int, content: object):
        status_code,url_now,text=content
        pattern_id = re.compile(r"\d+")
        pattern_imdb=re.compile(r"tt\d+")
        url_list=[]
        save_list=[]

        # 豆瓣新电影链接
        if keys["type"] == "new_tag":
            text_json=json.loads(text)
            for num in range(len(text_json["subjects"])):
                # movie_detail
                url_list.extend([("https://movie.douban.com/subject/"+str(text_json["subjects"][num]["id"]),{"type":"movie_detail"},2)])
                # ID 名称
                save_list.extend([(text_json["subjects"][num]["id"],text_json["subjects"][num]["title"])])

            """
            #url末端页码数递增
            #pattern_start = re.compile(r'\d+')
            #url_list.extend(re.sub("start=\d+", "start=" + str(int(pattern_start.findall(url)[2]) + 500), url))
            """

            #print(url_list)
            #print(save_list)
            #print("parser_new_tag=================================")
            #return 1,url_list,[save_list]
            return 1,[],[save_list]

        # 豆瓣所有的标签
        elif keys["type"] == "all_tag":
            html=etree.HTML(text)
            next_page=html.xpath("//span[@class='next']/link/@href")
            # movie_ID 名称
            save_list.extend([(pattern_id.findall(movie.xpath("./@href")[0])[0],movie.xpath("./@title")[0]) for movie in html.xpath("//a[@class='nbg']")])
            # tag_next_page movie_detail
            if next_page:
                url_list.extend([(next_page[0],{"type":"all_tag"},1)])

                """
                页面所有页链接
                url_list.extend([(page.xpath("./@href")[0],keys,1) for page in next_page])
                url_list.extend([(next_page.xpath("./@href")[0],keys,1)])
                """
            url_list.extend([("https://movie.douban.com/subject/"+str(pattern_id.findall(movie.xpath("./@href")[0])[0]),{"type":"movie_detail"},2) for movie in html.xpath("//a[@class='nbg']")])

            #print(url_list)
            #print(save_list)
            #print("parser_all_tag=================================")
            return 1,url_list,[save_list]
            #return 1,[],[save_list]

        # 电影的页面
        elif keys["type"]=="movie_detail":
            html=etree.HTML(text)

            directors=html.xpath("//div[@id='info']/span[1]/span/a")
            writers=html.xpath("//div[@id='info']/span[2]/span/a")
            leadingactors=html.xpath("//span[@class='actor']/span[2]/a")

            types=html.xpath("//div[@id='info']/span[@property='v:genre']/text()")
            tags=html.xpath("//div[@class='tags-body']/a/text()")
            releasetimes=html.xpath("//span[@property='v:initialReleaseDate']/text()")
            # movie_ID movie_名称 评分 IMDB 又名 [(director_ID,director_name),] [(writer_ID,writer_name),] [(leadingactor_ID,leadingactor_name),] [类型,] [标签,] [上映时间,]
            save_list.append(pattern_id.findall(url)[0])
            save_list.append(html.xpath("//h1/span[@property]/text()")[0].split()[0])
            rate=html.xpath("//strong/text()")
            if rate:
                save_list.append(rate[0])
            else:
                save_list.append(0.0)
            imdb=html.xpath("//div[@id='info']/a/text()")
            if imdb:
                save_list.append(pattern_imdb.findall("".join(imdb))[0])
            else:
                save_list.append(None)
            if html.xpath("//span[text()='集数:']/text()"):
                alias=html.xpath("//div[@id='info']/text()[last()-1]")
            else:
                alias=html.xpath("//div[@id='info']/text()[last()-3]")
            if alias and html.xpath("//span[text()='又名:']/text()"):
                save_list.append(alias[0])
            else:
                save_list.append(None)
            #save_list.append([(pattern_id.findall(director.xpath("@href")[0])[0],director.xpath("text()")[0]) for director in directors])
            save_list.append([((pattern_id.findall(director.xpath("@href")[0])[0],director.xpath("text()")[0]) if re.match("/subject_search",director.xpath("@href")[0])==None else (random.randint(100000000,900000000),director.xpath("text()")[0])) for director in directors])
            save_list.append([(pattern_id.findall(writer.xpath("@href")[0])[0],writer.xpath("text()")[0]) if re.match("/subject_search",writer.xpath("@href")[0])==None else (random.randint(100000000,900000000),writer.xpath("text()")[0]) for writer in writers])
            save_list.append([(pattern_id.findall(leadingactor.xpath("@href")[0])[0],leadingactor.xpath("text()")[0]) if re.match("/subject_search",leadingactor.xpath("@href")[0])==None else (random.randint(100000000,900000000),leadingactor.xpath("text()")[0]) for leadingactor in leadingactors])
            save_list.append([type for type in types])
            save_list.append([tag for tag in tags])
            save_list.append([releasetime for releasetime in releasetimes])
            # (type,) (tag,) (导演,) (编剧,) (主演,)
            url_list.extend([("https://movie.douban.com/tag/"+str(type),{"type":"all_tag"},1,) for type in types])
            url_list.extend([("https://movie.douban.com/tag/"+str(tag),{"type":"all_tag"},1,) for tag in tags])
            url_list.extend([("https://movie.douban.com/celebrity/"+pattern_id.findall(director.xpath("@href")[0])[0],{"type":"actor_detail"},2) if re.match("/subject_search",director.xpath("@href")[0])==None else None for director in directors])
            url_list.extend([("https://movie.douban.com/celebrity/"+pattern_id.findall(writer.xpath("@href")[0])[0],{"type":"actor_detail"},2) if re.match("/subject_search",writer.xpath("@href")[0])==None else None for writer in writers])
            url_list.extend([("https://movie.douban.com/celebrity/"+pattern_id.findall(leadingactor.xpath("@href")[0])[0],{"type":"actor_detail"},2) if re.match("/subject_search",leadingactor.xpath("@href")[0])==None else None for leadingactor in leadingactors])

            #print(url_list)
            #print(save_list)
            #print("parser_movie_detail=================================")

            #return 1,url_list,[save_list]
            return 1,[],[save_list]

        # 演员的页面
        elif keys["type"]=="actor_detail":
            html=etree.HTML(text)

            # actor_ID actor_name sex homeplase birthday occuption alias imdb
            sex_html=html.xpath("//div[@class='info']/ul/li/span[text()='性别']/../text()[2]")
            sex=""
            if sex_html:
                sex=re.sub("\n| |:","",sex_html[0])
            hm_html=html.xpath("//div[@class='info']/ul/li/span[text()='出生地']/../text()[2]")
            hm=""
            if hm_html:
                hm=re.sub("\n| |:","",hm_html[0])
            bir_html=html.xpath("//div[@class='info']/ul/li/span[text()='出生日期']/../text()[2]")
            bir=""
            if bir_html:
                bir=re.sub("\n| |:", "", bir_html[0])
            occ_html=html.xpath("//div[@class='info']/ul/li/span[text()='职业']/../text()[2]")
            occ=""
            if occ_html:
                occ=re.sub("\n| |:", "", occ_html[0])
            alias_1_html=html.xpath("//div[@class='info']/ul/li/span[text()='更多外文名']/../text()[2]")
            alias_1=""
            if alias_1_html:
                alias_1=re.sub("\n| |:", "", alias_1_html[0])
            alias_2_html=html.xpath("//div[@class='info']/ul/li/span[text()='更多中文名']/../text()[2]")
            alias_2=""
            if alias_2_html:
                alias_2=re.sub("\n| |:", "",alias_2_html[0])
            imdb_id_html=html.xpath("//div[@class='info']/ul/li/span[text()='imdb编号']/following-sibling::a/text()")
            imdb_id=""
            if imdb_id_html:
                imdb_id=imdb_id_html[0]
            save_list.append([{"id":pattern_id.findall(url)[0],"name":html.xpath("//h1/text()")[0].split()[0],"sex":sex,"hm":hm,"bir":bir,"occ":occ,"alias":alias_1+alias_2,"imdb":imdb_id}])

            #print(url_list)
            #print(save_list)
            #print("parser_actor_detail=================================")
            #return 1,url_list,save_list
            return 1,[],save_list
