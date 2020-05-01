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

       (100, '未知'),

       (101, '在线'),
       (102, '网盘'),

       (111, '蓝光'),
       (112, '1080P'),
       (113, '1280超清'),
       (114, '1024超清'),
       (115, '720P'),
       (116, '1280高清'),
       (117, '1024高清');

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
