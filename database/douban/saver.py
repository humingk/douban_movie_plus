# !/usr/bin/env python
# -*- coding: utf-8 -*-
import pymysql
import logging
import spider
import douban.config as config 

class saver(spider.Saver):

    def __init__(self):
        try:
            self.db=pymysql.connect("localhost",config.user_name,config.user_pwd,"douban_movie",charset=config.database_charset)
        except pymysql.err as e:
            logging("open your mysql please...")
            logging(e)
        self.cursor=self.db.cursor()
        return
    # override
    def item_save(self, url: str, keys: dict, item: (list, tuple)):

        if keys["type"]=="new_tag" or keys["type"]=="all_tag":
            if item:
                try:
                    # 电影简情
                    #sql = "INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("movie", "movie_id", "name", item[0], repr(str(item[1])))
                    for it in item:
                        sql = "INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("movie", "movie_id", "name", it[0], repr(str(it[1])))

                        self.cursor.execute(sql)
                    self.db.commit()
                except Exception as e:
                    logging("insert into mysql failed...")
                    logging(e)
            #print("saver new_tag or all_tag ============================")
        elif keys["type"]=="movie_detail":
            if item:
                try:
                    # 电影详情
                    #sql_movie="INSERT IGNORE INTO %s (%s,%s,%s,%s,%s) VALUES (%s,%s,%s,%s,%s)" % ("movie","movie_id","name","douban_rate","imdb_id","alias",item[0],repr(str(item[1])),item[2],repr(str(item[3])),repr(str(item[4])))
                    sql_movie="UPDATE %s SET %s = %s ,%s = %s, %s = %s WHERE %s = %s " % ("movie","douban_rate",item[2],"imdb_id",repr(str(item[3])),"alias",repr(str(item[4])),"movie_id",item[0])
                    self.cursor.execute(sql_movie)
                    # 导演
                    for it in item[5]:
                        sql_actor="INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("actor","actor_id","name",it[0],repr(str(it[1])))
                        sql_movie_director="INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("movie_director","movie_id","director_id",item[0],it[0])
                        self.cursor.execute(sql_actor)
                        self.cursor.execute(sql_movie_director)
                    # 编剧
                    for it in item[6]:
                        sql_actor="INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("actor","actor_id","name",it[0],repr(str(it[1])))
                        sql_movie_writer="INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("movie_writer","movie_id","writer_id",item[0],it[0])
                        self.cursor.execute(sql_actor)
                        self.cursor.execute(sql_movie_writer)
                    # 主演
                    for it in item[7]:
                        sql_actor="INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("actor","actor_id","name",it[0],repr(str(it[1])))
                        sql_movie_leadingactor="INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("movie_leadingactor","movie_id","leadingactor_id",item[0],it[0])
                        self.cursor.execute(sql_actor)
                        self.cursor.execute(sql_movie_leadingactor)
                    # 类型
                    for it in item[8]:
                        sql_type = "INSERT IGNORE INTO %s (%s) VALUES (%s)" % ("type", "type_name",repr(str(it)))
                        sql_movie_type = "INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("movie_type", "type_name", "movie_id", repr(str(it)), item[0])
                        self.cursor.execute(sql_type)
                        self.cursor.execute(sql_movie_type)
                    # 标签
                    for it in item[9]:
                        sql_tag = "INSERT IGNORE INTO %s (%s) VALUES (%s)" % ("tag", "tag_name",repr(str(it)))
                        sql_movie_tag = "INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("movie_tag", "tag_name", "movie_id", repr(str(it)), item[0])
                        self.cursor.execute(sql_tag)
                        self.cursor.execute(sql_movie_tag)
                    # 上映时间
                    for it in item[10]:
                        sql_releasetime = "INSERT IGNORE INTO %s (%s,%s) VALUES (%s,%s)" % ("releasetime", "movie_id","time_area",item[0],repr(str(it)))
                        self.cursor.execute(sql_releasetime)
                    self.db.commit()
                except Exception as e:
                    logging("insert into mysql failed...")
                    logging(e)
            #print("movie: "+str(item[1]))
            #print("saver movie_detail ============================")
        elif keys["type"]=="actor_detail":
            if item:
                try:
                    # 人物详情
                    #sql_actor="INSERT IGNORE INTO %s (%s,%s,%s,%s,%s,%s,%s,%s) VALUES (%s,%s,%s,%s,%s,%s,%s,%s)" % ("actor","actor_id","name","sex","homeplace","birthday","occupation","alias","imdb_id",item[0]["id"],repr(str(item[0]["name"])),repr(str(item[0]["sex"])),repr(str(item[0]["hm"])),repr(str(item[0]["bir"])),repr(str(item[0]["occ"])),repr(str(item[0]["alias"])),repr(str(item[0]["imdb"])))
                    sql_actor="UPDATE %s SET %s = %s, %s = %s,%s = %s ,%s = %s, %s = %s ,%s = %s  WHERE %s = %s " % ("actor","sex",repr(str(item[0]["sex"])),"homeplace",repr(str(item[0]["hm"])),"birthday",repr(str(item[0]["bir"])),"occupation",repr(str(item[0]["occ"])),"alias",repr(str(item[0]["alias"])),"imdb_id",repr(str(item[0]["imdb"])),"actor_id",repr(item[0]["id"]))
                    self.cursor.execute(sql_actor)
                    self.db.commit()
                except Exception as e:
                    logging("insert into mysql failed...")
                    logging(e)
            #print("actor: "+str(item[0]["name"]))
            #print("saver actor_detail ============================")
        return 1


