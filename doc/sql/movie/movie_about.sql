/*

关于movie


 id含有 auto_increment 属性的表，id=1均为默认值-未知
 id不含有 auto_increment 属性的表，id=0均为默认值-未知

---2020-02-15---

 PS:大大大大大BUG
 1. celebrity_scene 与 movie_scene_to_celebrity_scene 不匹配！
 2. netease 歌单、专辑评论
 3. movie_zhihu id重复:
 select * from movie_zhihu where id in(
 select id from movie_zhihu group by id HAVING count(id)>2);
=>
 | 19551395 |           1453238 | 海贼王       |           8   |           44 |            9.4 |
| 19551395 |           2026970 | 海贼王       |           8   |           44 |            9.4 |
| 19551395 |           2058851 | 海贼王       |           8   |           44 |            9.4 |
只有第一个是匹配的，仅保留第一个
改变表结构：

 原因：用豆瓣电影名搜索知乎电影的时候，在匹配到相应话题的时候，应该再判断一下相似度（两个名字重复字符所占比例），再决定是否录入

这个表要重新爬一下。


 Tips(数据库更改):
 1. movie_scene url_map 去除重复部分 http://cache.fotoplace.cc/mocation/staticmap/e684c03600b64032a6654e2e5ee1551f.png
update movie_scene set url_map=replace(url_map,"http://cache.fotoplace.cc/mocation/staticmap/","")
update movie_scene set url_map=replace(url_map,".png","")

 2. image_scene_detail url_image http://cache.fotoplace.cc/mocation/old_discovery/4a427158de67487197e599b7516fa4a1.JPG
 update image_scene_detail set url_image=replace(url_image,"http://cache.fotoplace.cc/mocation/","")

 3. place_scene
 url_poster: http://cache.fotoplace.cc/mocation/170223/3/1487846840535972906.jpg
 update place_scene set url_poster=replace(url_poster,"http://cache.fotoplace.cc/mocation/","")
 update place_scene set url_earth=replace(url_earth,"http://cache.fotoplace.cc/mocation/","")
 update place_scene set url_satellite=replace(url_satellite,"http://cache.fotoplace.cc/mocation/","")

update place_scene set url_map=replace(url_map,"http://cache.fotoplace.cc/mocation/staticmap/","")
update place_scene set url_map=replace(url_map,".png","")

4. image_place_scene url_image
 update image_place_scene set url_image=replace(url_image,"http://cache.fotoplace.cc/mocation/","")

5. celebrity 图片 小数点
 */