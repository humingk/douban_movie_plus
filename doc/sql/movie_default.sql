/*
 默认值以及测试

 */

use movie;

insert into award_movie
values ('unknown', '未知');

insert into movie_imdb(id, name_en)
values (0, 'unknown');

insert into movie_douban(id, name_zh, name_origin)
values (0, '未知', 'unknown');

insert into classic_douban
values (0, 0, '', 0, 0);

insert into celebrity_imdb(id, name_en)
values (0, 'unknown');

insert into celebrity_douban(id, name_zh, name_origin)
values (0, '未知', 'unknown');

insert into movie_scene(id, id_movie_douban, name_zh, name_en)
values (0, 0, '未知', 'unknown');

insert into celebrity_scene(id, id_celebrity_douban, name_zh, name_en)
values (0, 0, '未知', 'unknown');

insert into scene(id, name_zh)
values (0, '未知');

insert into scene_detail(id, description)
values (0, '未知');

insert into role
values (1, '未知', 'unknown');

insert into user_douban
values (0, '未知');

insert into website_resource(id, name_zh)
values (1, '未知');

insert into resource_movie(id, name_zh)
values (1, '未知');

insert into place_scene(id, name_zh, name_en)
values (0, '未知', 'unknown');

insert into continent_scene
values (0, '未知', 'unknown');

insert into country_scene
values (0, '未知', 'unknown');

insert into state_scene
values (0, '未知', 'unknown');

insert into city_scene
values (0, '未知', 'unknown');

insert into song_netease
values (0, '');

insert into artist_netease(id, name_zh)
values (0, '');

insert into user_netease(id, name_zh)
values (0, '未知');

# 场景地点类型
insert into type_place_scene(id, name_zh)
values (100, '未知'),
       (0, '旅游景点'),
       (1, '历史建筑'),
       (2, '餐饮'),
       (3, '商铺'),
       (4, '自然风光'),
       (5, '民居'),
       (6, '酒店'),
       (7, '地标'),
       (8, '宗教场所'),
       (9, '街道'),
       (10, '影视基地'),
       (11, '公园'),
       (12, '演艺场所'),
       (13, '展馆'),
       (14, '交通站'),
       (15, '商用建筑'),
       (16, '广场'),
       (17, '政府机关'),
       (18, '医疗机构'),
       (19, ''),
       (20, '工厂'),
       (21, '体育场馆'),
       (22, '金融机构'),
       (23, '港口'),
       (24, '社会福利机构'),
       (25, '墓地'),
       (26, '学校');

# 影片类型
insert ignore into type_video
values (1, '未知', 'unknown'),
       (2, '电影', 'movie'),
       (3, '电视剧', 'tv series'),
       (4, '短片', 'short'),
       # 来自IMDB
       (5, '迷你电视剧', 'tv mini series'),
       (6, '电视短片', 'tv short'),
       (7, '电视特辑', 'tv special'),
       (8, '电视电影', 'tvMovie'),
       (9, '视频', 'video'),
       (10, '视频游戏', 'video game');

# 资源网站
insert into website_resource
values (2, '爱奇艺视频', 'https://www.iqiyi.com'),
       (3, '腾讯视频', 'https://v.qq.com'),
       (4, '哔哩哔哩', 'https://www.bilibili.com'),
       (5, '搜狐视频', 'https://tv.sohu.com'),
       (6, '优酷视频', 'https://www.youku.com'),
       (7, '1905电影网', 'https://vip.1905.com'),
       (8, '芒果TV', 'https://www.mgtv.com'),
       (9, '西瓜视频', 'https://www.ixigua.com'),
       (10, 'AcFun', 'https://www.acfun.cn'),

       (101, '电影天堂', 'https://www.dy2018.com'),
       (102, 'LOL电影天堂', 'https://www.loldytt.com'),
       (103, 'BT电影天堂', 'http://www.btbtdy.me'),
       (104, 'xl720', 'https://www.xl720.com'),
       (105, '6v电影网', 'http://www.hao6v.com'),
       (106, '狗带TV', 'http://www.goodaitv.com'),
       (107, '在线之家', 'http://www.zxzjs.com'),
       (108, '比热大雄', 'https://www.btdx8.com'),
       (109, '', ''),
       (110, '', ''),
       (111, '', '');

# 资源类型
insert into type_resource
values (0, '未知'),
       (2, '在线免费'),
       (3, 'VIP免费'),
       (4, '单片付费'),
       (5, '用劵/单片付费'),

       (101, '在线'),
       (102, '网盘'),

       (111, '蓝光'),
       (112, '1080P'),
       (113, '1280超清'),
       (114, '1024超清'),
       (115, '720P'),
       (116, '1280高清'),
       (117, '1024高清'),

       (1000, '未知');
# 影人类型
insert into profession
values (1, '未知', 'unknown'),
       (2, '导演', 'director'),
       (3, '编剧', 'writer'),
       (4, '演员', 'starring'),
       # 来自IMDB
       (5, '男演员', 'actor'),
       (6, '女演员', 'actress'),
       (7, '存档胶片', 'archive_footage'),
       (8, '存档声音', 'archive_sound'),
       (9, '摄影师', 'cinematographer'),
       (10, '作曲家', 'composer'),
       (11, '编辑', 'editor'),
       (12, '制片人', 'producer'),
       (13, '美工', 'production_designer'),
       (14, '自己？', 'self');

# 电影类型
insert into type_movie
values (1, '未知'),
       (2, '剧情'),
       (3, '喜剧'),
       (4, '爱情'),
       (5, '动作'),
       (6, '惊悚'),
       (7, '动画'),
       (8, '犯罪'),
       (9, '纪录片'),
       (10, '短片'),
       (11, '恐怖'),
       (12, '悬疑'),
       (13, '科幻'),
       (14, '冒险'),
       (15, '奇幻'),
       (16, '家庭'),
       (17, '战争'),
       (18, '历史'),
       (19, '传记'),
       (20, '音乐'),
       (21, '同性'),
       (22, '古装'),
       (23, '歌舞'),
       (24, '运动'),
       (25, '情色'),
       (26, '儿童'),
       (27, '武侠'),
       (28, '西部'),
       (29, '真人秀'),
       (30, '黑色电影'),
       (31, '灾难'),
       (32, '脱口秀'),
       (33, '舞台艺术'),
       (34, '戏曲'),
       (35, '鬼怪');

/**
  测试值
 */

# 台词
insert into classic_douban
values ('0B5E86CE-55D2-5942-5A93-D6D03A961ABC', 1291561, '在这里没有工作的人，会被汤婆婆变成动物的。', 0, 0),
       ('2C50254A-1210-772F-8090-FD9536A53619', 1291561, '曾经发生过的事情是不会忘记的，只是想不起来而已', 0, 0),
       ('416B8DCC-42ED-2B17-0B6A-1A18D3ADDB4C', 1291561, '我拿金子给你吧，我决定不给其他任何人 只给小千一个人。', 0, 0),
       ('C3538117-7D57-65AA-FE70-4548D79CDB06', 1291561, '无脸男其实心地很善良，但是在汤婆婆哪里，他会变坏的。', 0, 0);
insert into user_douban_to_classic_douban
values ('humingk', '0B5E86CE-55D2-5942-5A93-D6D03A961ABC', '小明也来过', 1586417661, '测试'),
       ('humingk', '2C50254A-1210-772F-8090-FD9536A53619', '小明也来过', 1586417661, '测试'),
       ('humingk', '416B8DCC-42ED-2B17-0B6A-1A18D3ADDB4C', '小明也来过', 1586417661, '测试'),
       ('humingk', 'C3538117-7D57-65AA-FE70-4548D79CDB06', '小明也来过', 1586417661, '测试');
insert into celebrity_douban_to_classic_douban
values (1023337, '0B5E86CE-55D2-5942-5A93-D6D03A961ABC', '柊瑠美'),
       (1023337, 'C3538117-7D57-65AA-FE70-4548D79CDB06', '柊瑠美'),
       (1387991, '416B8DCC-42ED-2B17-0B6A-1A18D3ADDB4C', '中村彰男');


insert into message
values ('top', 'humingk', 'humingk', '0.0.0.0', '聊天吹水提建议，欢迎加入豆瓣电影Plus交流群 476584154 口令 doubans', 7979483471000, 111111);
insert into message
values ('11', 'humingk', '老x', '0.0.0.0', '大哥，你是了解我的', 1577901722000, 1);
insert into message
values ('12', 'humingk', '叶问', '0.0.0.0', '我要打十个', 1577905322000,
        1);
insert into message
values ('13', 'humingk', '酱爆', '0.0.0.0', '我酱爆，在这moment，要爆了~', 1584982801000,
        9);
insert into message
values ('14', 'humingk', '至尊宝', '0.0.0.0', '人家两个男才女貌，哪轮得到你这个妖怪来反对', 1578682922000,
        8);
insert into message
values ('15', 'humingk', '牛夫人', '0.0.0.0', '以前陪我看月亮的时候，叫我小甜甜，现在新人胜旧人啦！叫人家牛夫人', 1584896401000,
        8);
insert into message
values ('16', 'humingk', '9527', '0.0.0.0', '越来越接近秋香姐，今天的心情是大不同啊，大不同', 1583902922000,
        3);
insert into message
values ('17', 'humingk', '星', '0.0.0.0', '一支穿云箭，千军万马来相见', 1581570122000,
        4);
insert into message
values ('18', 'humingk', '凌凌漆', '0.0.0.0', '表面上看这是一个吹风机，实际上它是一个刮胡刀', 1579662122000,
        5);
insert into message
values ('19', 'humingk', '星', '0.0.0.0', '到底是让我打他还是打他妈啊！你搞得我好乱啊！', 1582599722000,
        4);
insert into message
values ('20', 'humingk', '至尊宝', '0.0.0.0', '长夜漫漫，无心睡眠，我以为只有我睡不着觉，没想到晶晶姑娘你也一样', 1585105322000,
        9);
insert into message
values ('21', 'humingk', '何志武', '0.0.0.0', '每个人都有一个习惯，我的习惯是在这里等阿may下班', 1578711722000,
        8);
insert into message
values ('22', 'humingk', '鲁迅', '0.0.0.0', '你抓周树人和我鲁迅有什么关系', 1584982861000,
        7);
insert into message
values ('23', 'humingk', '唐三藏', '0.0.0.0', '人是人他妈生的，妖是妖他妈生的，只要你有一颗善良的心就不再是妖，是人妖', 1581044522000,
        6);
insert into message
values ('24', 'humingk', '讨债的', '0.0.0.0',
        '你以为你躲起来我就找不到你了吗？没有用的，你是那样拉风的男人。不管在什么地方，就好像漆黑中的萤火虫一样，那样的鲜明，那样的出众，你那忧郁的眼神、唏嘘的胡渣子、神乎其技的刀法，还有那杯Dry Martine……都深深地迷住了我',
        1578106922000,
        8);
insert into message
values ('25', 'humingk', '9527', '0.0.0.0', '八目共赏，赏花赏月赏秋香！', 1578366122000,
        5);
insert into message
values ('26', 'humingk', '何金银', '0.0.0.0', '扶老太太过马路我每个星期都做一次，如果是碰到国定假日的话，我还做两三次呢', 1578193322000,
        4);
insert into message
values ('27', 'humingk', '唐伯虎', '0.0.0.0', '落花有意随流水，而流水无心恋落花', 1578538922000,
        7);
insert into message
values ('28', 'humingk', '何金银', '0.0.0.0', '除暴安良是我做市民的责任，积德行善是我的兴趣', 1578508922000,
        3);
insert into message
values ('29', 'humingk', '包龙星', '0.0.0.0', '大家都听到了，是他叫我打我才打的', 1578511922000,
        5);
insert into message
values ('30', 'humingk', '唐三藏', '0.0.0.0', '紫霞在你心目中是不是一个惊叹号？还是一个句号？你脑袋里是不是充满了问号？', 1578538111000,
        5);
insert into message
values ('31', 'humingk', '武状元', '0.0.0.0', '那么在哪里才能买到呢', 1578511122000,
        4);