/**
  根据正则表达式生成，增加表字段注释
  。。。
 */


# 影片种类/类型  (电影、电视剧...)
alter table type_video
    comment '影片种类';

alter table type_video
    modify column id tinyint unsigned not null comment '影片类型ID';
# 影片类型中文名
alter table type_video
    modify column name_zh varchar(255) not null default '' comment '影片类型中文名';
# 影片类型英文名
alter table type_video
    modify column name_en varchar(255) not null default '' comment '影片类型英文名';


# 电影奖项
alter table award_movie
    comment '电影奖项';

alter table award_movie
    modify column id varchar(255) not null comment '电影奖项ID';
# 奖项名称
alter table award_movie
    modify column name_zh varchar(255) not null default '' comment '电影奖项中文名';


# 电影类型
alter table type_movie
    comment '电影类型';

alter table type_movie
    modify column id smallint unsigned not null comment '电影类型ID';
# 类型中文名
alter table type_movie
    modify column name_zh varchar(255) not null default '' comment '电影类型中文名';



# 2.公共电影关系表---------------------------------------

# IMDB电影相关 ---------------------------------------------------------------------------------

# 1.IMDB电影基础表---------------------------------------

# IMDB电影 
alter table movie_imdb
    comment 'IMDB电影';

alter table movie_imdb
    modify column id bigint unsigned not null comment 'IMDB电影ID';
# 豆瓣电影ID 0:未更新 1：已更新但无对应豆瓣电影
alter table movie_imdb
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID 0-未匹配 1-已匹配';
# 影片种类/类型  (电影、电视剧、电视剧的单集...)
alter table movie_imdb
    modify column id_type_video tinyint unsigned not null default 1 comment '影片种类';
# IMDB电影英文名
alter table movie_imdb
    modify column name_en varchar(255) not null default '' comment 'IMDB电影英文名';
# IMDB电影发行年份 、 电视剧首集播放年份
alter table movie_imdb
    modify column start_year smallint(4) unsigned not null default 0 comment 'IMDB电影发行年份';
# 是否是成人电影 0-不是 1-是
alter table movie_imdb
    modify column is_adult tinyint(2) not null default 0 comment '是否是成人电影 0-不是 1-是';
# IMDB电影原始名
alter table movie_imdb
    modify column name_origin varchar(255) not null default '' comment 'IMDB电影原始名';
# IMDB电影片长 分钟
alter table movie_imdb
    modify column runtime smallint unsigned not null default 0 comment 'IMDB电影片长 /m';
# imdb海报 https://m.media-amazon.com/images/M/ + url
alter table movie_imdb
    modify column url_poster varchar(1000) not null default '' comment 'IMDB海报链接';
# 简介
alter table movie_imdb
    modify column summary text comment '简介';


# IMDB电影评分
alter table rate_imdb
    comment 'IMDB电影评分';

# tt+id comment 'cccc';id至少7个数字（不够7个在id前面添0）
alter table rate_imdb
    modify column id bigint unsigned not null comment 'IMDB电影ID tt+00xxx(7)';
# IMDB评分
alter table rate_imdb
    modify column imdb_score decimal(3, 1) not null default 0.0 comment 'IMDB评分';
# IMDB评分人数
alter table rate_imdb
    modify column imdb_vote int unsigned not null default 0 comment 'IMDB评分人数';
# 烂番茄新鲜度
alter table rate_imdb
    modify column tomato_score decimal(3, 1) not null default 0.0 comment '烂番茄新鲜度';
# MTC评分
alter table rate_imdb
    modify column mtc_score decimal(3, 1) not null default 0.0 comment 'MTC评分';



# 2.IMDB电影关系表---------------------------------------

# IMDB电影-电影类型
alter table movie_imdb_to_type_movie
    comment 'IMDB电影-影片类型';

alter table movie_imdb_to_type_movie
    modify column id_movie_imdb bigint unsigned not null comment 'IMDB电影ID';
alter table movie_imdb_to_type_movie
    modify column id_type_movie smallint unsigned not null comment '影片类型ID';



# 豆瓣电影相关 ---------------------------------------------------------------------------------

# 1.豆瓣电影基础表---------------------------------------

# 豆瓣电影 
alter table movie_douban
    comment '豆瓣电影';

alter table movie_douban
    modify column id bigint unsigned not null comment '豆瓣电影ID';
# 影片种类/类型-ID  (电影、电视剧、电视剧的单集...)
alter table movie_douban
    modify column id_type_video tinyint unsigned not null default 1 comment '影片类型ID';
# 豆瓣电影的IMDB-ID 0：未匹配 1：没有对应的IMDB电影
alter table movie_douban
    modify column id_movie_imdb bigint unsigned not null default 0 comment 'IMDB电影ID 0-未匹配 1-已匹配';
# 上映时间
alter table movie_douban
    modify column start_year smallint(4) unsigned not null default 0 comment '上映时间 /year';
# 豆瓣电影中文名
alter table movie_douban
    modify column name_zh varchar(255) not null default '' comment '豆瓣电影中文名';
# 豆瓣电影原始名
alter table movie_douban
    modify column name_origin varchar(255) not null default '' comment '豆瓣电影原始名';
# 豆瓣电影运行片长 分钟
alter table movie_douban
    modify column runtime smallint unsigned not null default 0 comment '豆瓣电影运行片长 /m';
# 豆瓣电影海报ID
alter table movie_douban
    modify column url_poster bigint unsigned not null default 0 comment '豆瓣电影海报ID';
# 简介
alter table movie_douban
    modify column summary text comment '简介';
# 已看人数
alter table movie_douban
    modify column have_seen int unsigned not null default 0 comment '已看人数';
# 想看人数
alter table movie_douban
    modify column wanna_see int unsigned not null default 0 comment '想看人数';
# 是否有对应的网易云音乐 0:未匹配 1:没有 2：有
alter table movie_douban
    modify column is_netease tinyint(2) not null default 0 comment '是否匹配到网易云音乐 0-未匹配 1-匹配无 2-匹配有';
# 是否有对应的知乎电影话题或问题 0:未匹配 1:没有 2：有
alter table movie_douban
    modify column is_zhihu tinyint(2) not null default 0 comment '是否匹配到知乎话题或问题 0-未匹配 1-匹配无 2-匹配有';


# 豆瓣电影评分
alter table rate_movie_douban
    comment '豆瓣电影评分';

alter table rate_movie_douban
    modify column id bigint unsigned not null comment '豆瓣电影ID';
# 豆瓣电影评分 0.0 ~ 10.0
alter table rate_movie_douban
    modify column score decimal(3, 1) not null default 0.0 comment '豆瓣电影评分';
# 豆瓣电影评分人数
alter table rate_movie_douban
    modify column vote int unsigned not null default 0 comment '豆瓣电影评分人数';
# 豆瓣5星 %
alter table rate_movie_douban
    modify column score5 decimal(3, 1) not null default 0.0 comment '豆瓣5星比例';
# 豆瓣4星 %
alter table rate_movie_douban
    modify column score4 decimal(3, 1) not null default 0.0 comment '豆瓣4星比例';
# 豆瓣3星 %
alter table rate_movie_douban
    modify column score3 decimal(3, 1) not null default 0.0 comment '豆瓣3星比例';
# 豆瓣2星 %
alter table rate_movie_douban
    modify column score2 decimal(3, 1) not null default 0.0 comment '豆瓣2星比例';
# 豆瓣1星 %
alter table rate_movie_douban
    modify column score1 decimal(3, 1) not null default 0.0 comment '豆瓣1星比例';


# 电影别名
alter table alias_movie_douban
    comment '电影别名';

alter table alias_movie_douban
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID';
# 豆瓣电影别称
alter table alias_movie_douban
    modify column name_alias varchar(255) not null default '' comment '电影别名';


# 豆瓣电影预告片
alter table trailer_movie_douban
    comment '豆瓣电影预告片';

alter table trailer_movie_douban
    modify column id bigint unsigned not null comment '豆瓣电影预告片ID';
# 豆瓣电影ID
alter table trailer_movie_douban
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID';
# 预告片mp4链接
alter table trailer_movie_douban
    modify column url_video varchar(1000) not null default '' comment '预告片mp4链接';


# 豆瓣电影经典台词
alter table classic_douban
    comment '豆瓣电影经典台词';

alter table classic_douban
    modify column id varchar(255) not null comment '豆瓣电影经典台词ID';
# 豆瓣电影ID
alter table classic_douban
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID';
# 经典台词内容
alter table classic_douban
    modify column content varchar(1000) not null default '' comment '经典台词内容';
# 经典台词在影片中的出现时间 分钟
alter table classic_douban
    modify column happen_time int unsigned not null default 0 comment '经典台词在影片中的出现时间 /m';
# 经典台词获得的票数
alter table classic_douban
    modify column agree_vote int unsigned not null default 0 comment '经典台词获得的赞同数';


# 豆瓣电影短评
alter table comment_movie_douban
    comment '豆瓣电影短评';

alter table comment_movie_douban
    modify column id_movie_douban bigint unsigned not null comment '豆瓣电影ID';
alter table comment_movie_douban
    modify column id_user_douban varchar(255) not null comment '豆瓣用户ID';
# 投票数
alter table comment_movie_douban
    modify column agree_vote smallint not null default 0 comment '投票数';
# 短评日期
alter table comment_movie_douban
    modify column create_date bigint not null default 0 comment '短评日期 /unix';
# 短评内容
alter table comment_movie_douban
    modify column content varchar(1000) not null default '' comment '短评内容';


# 豆瓣电影影评
alter table review_movie_douban
    comment '豆瓣电影影评';

alter table review_movie_douban
    modify column id bigint unsigned not null comment '豆瓣电影影评ID';
# 赞同数
alter table review_movie_douban
    modify column agree_vote int unsigned not null default 0 comment '赞同数';
# 反对数
alter table review_movie_douban
    modify column against_vote int unsigned not null default 0 comment '反对数';
# 影评日期时间
alter table review_movie_douban
    modify column create_datetime bigint not null default 0 comment '影评日期时间 /unix';
# 影评标题
alter table review_movie_douban
    modify column title varchar(255) not null default '' comment '影评标题';
# 影评内容
alter table review_movie_douban
    modify column content text comment '影评内容';


# 豆瓣电影标签
alter table tag_movie
    comment '豆瓣电影标签';

alter table tag_movie
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID';
alter table tag_movie
    modify column name_zh varchar(255) not null default '' comment '电影标签中文名';



# 2.豆瓣电影关系表---------------------------------------

# 豆瓣电影-电影类型
alter table movie_douban_to_type_movie
    comment '豆瓣电影-电影类型';

alter table movie_douban_to_type_movie
    modify column id_movie_douban bigint unsigned not null comment '豆瓣电影ID';
alter table movie_douban_to_type_movie
    modify column id_type_movie smallint unsigned not null comment '影片类型ID';


# 豆瓣电影-奖项
alter table movie_douban_to_award_movie
    comment '豆瓣电影-奖项';

# 获奖豆瓣电影ID
alter table movie_douban_to_award_movie
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID';
# 获奖奖项ID
alter table movie_douban_to_award_movie
    modify column id_award_movie varchar(255) not null default 'unknown' comment '获奖奖项ID';
# 获奖豆瓣影人ID
alter table movie_douban_to_award_movie
    modify column id_celebrity_douban bigint unsigned not null default 0 comment '获奖豆瓣影人ID';
# 奖项的类别中文名 (最佳XXX...)
alter table movie_douban_to_award_movie
    modify column type_award varchar(255) not null default '未知' comment '奖项的类别中文名';
# 获奖奖项届数
alter table movie_douban_to_award_movie
    modify column award_th smallint unsigned not null default 1 comment '获奖奖项届数';
# 是否提名 0-仅提名，未获奖 1-获奖者，非提名
alter table movie_douban_to_award_movie
    modify column is_nominated tinyint(2) not null default 0 comment '是否被提名 0-仅提名未获奖 1-已提名且获奖';


# 豆瓣电影-影评
alter table movie_douban_to_review_movie_douban
    comment '豆瓣电影-影评';

alter table movie_douban_to_review_movie_douban
    modify column id_movie_douban bigint unsigned not null comment '豆瓣电影ID';
alter table movie_douban_to_review_movie_douban
    modify column id_review_movie_douban bigint unsigned not null comment '电影影评ID';



# 电影 end ========================================================================================

# 影人 start ========================================================================================

# 公共影人相关 ---------------------------------------------------------------------------------

# 1.公共影人基础表---------------------------------------

# 影人职业
alter table profession
    comment '影人职业';

alter table profession
    modify column id tinyint unsigned not null comment '影人职业ID';
# 职业中文名
alter table profession
    modify column name_zh varchar(255) not null default '' comment '职业中文名';
# 职业英文名
alter table profession
    modify column name_en varchar(255) not null default '' comment '职业英文名';



# 2.公共影人关系表---------------------------------------

# IMDB影人相关 ---------------------------------------------------------------------------------

# 1.IMDB影人基础表---------------------------------------

# IMDB影人
alter table celebrity_imdb
    comment 'IMDB影人';
# nm+id comment 'cccc';id至少7个数字（不够7个在id前面添0）
alter table celebrity_imdb
    modify column id bigint unsigned not null comment 'IMDB影人ID nm++00xxx(7)';
# 豆瓣影人ID 0:未更新 1:已更新但无对应豆瓣影人
alter table celebrity_imdb
    modify column id_celebrity_douban bigint unsigned not null default 0 comment '豆瓣影人ID 0-未匹配 1-已匹配';
# 英文名
alter table celebrity_imdb
    modify column name_en varchar(255) not null default '' comment 'IMDB影人英文名';
# 出生年份
alter table celebrity_imdb
    modify column birth_year smallint(4) unsigned not null default 0 comment '出生年份 /year';



# 2.IMDB影人关系表---------------------------------------

# IMDB电影-影人
alter table movie_imdb_to_celebrity_imdb
    comment 'IMDB电影-影人';

alter table movie_imdb_to_celebrity_imdb
    modify column id_movie_imdb bigint unsigned not null comment 'IMDB电影ID';
alter table movie_imdb_to_celebrity_imdb
    modify column id_celebrity_imdb bigint unsigned not null comment 'IMDB影人ID';
# 该IMDB影人在该IMDB电影中的职位
alter table movie_imdb_to_celebrity_imdb
    modify column id_profession tinyint unsigned not null comment '该影人在该电影中的职位';


# 豆瓣影人相关 ---------------------------------------------------------------------------------

# 1.豆瓣影人基础表---------------------------------------

# 豆瓣影人
alter table celebrity_douban
    comment '豆瓣影人';

alter table celebrity_douban
    modify column id bigint unsigned not null comment '豆瓣影人ID';
# IMDB-ID 0：未匹配 1：没有对应的IMDB影人
alter table celebrity_douban
    modify column id_celebrity_imdb bigint unsigned not null default 0 comment 'IMDB影人ID 0-未匹配 1-已匹配';
# 中文名
alter table celebrity_douban
    modify column name_zh varchar(255) not null default '' comment '豆瓣影人中文名';
# 英文名
alter table celebrity_douban
    modify column name_origin varchar(255) not null default '' comment '豆瓣影人英文名';
# 性别 0-女 1-男 2-其他
alter table celebrity_douban
    modify column sex tinyint(2) not null default 2 comment '性别 0-女 1-男 2-未知';
# 生日日期
alter table celebrity_douban
    modify column birth_date bigint not null default 0 comment '生日日期 /unix';
# 豆瓣影人海报ID
alter table celebrity_douban
    modify column url_portrait bigint unsigned not null default 0 comment '豆瓣影人海报ID';
# 影人简介
alter table celebrity_douban
    modify column summary text comment '影人简介';


# 影人别名
alter table alias_celebrity_douban
    comment '影人别名';

alter table alias_celebrity_douban
    modify column id_celebrity_douban bigint unsigned not null default 0 comment '豆瓣影人ID';
# 豆瓣影人别称
alter table alias_celebrity_douban
    modify column name_alias varchar(255) not null default '' comment '豆瓣影人别称';
# 是否为昵称 0-本名 1-昵称
alter table alias_celebrity_douban
    modify column is_nikename tinyint(2) not null default 0 comment '是否为昵称 0-本名 1-昵称';



# 2.豆瓣影人关系表---------------------------------------

# 豆瓣电影-影人
alter table movie_douban_to_celebrity_douban
    comment '豆瓣电影-影人';

alter table movie_douban_to_celebrity_douban
    modify column id_movie_douban bigint unsigned not null comment '豆瓣电影ID';
alter table movie_douban_to_celebrity_douban
    modify column id_celebrity_douban bigint unsigned not null comment '豆瓣影人ID';
# 该豆瓣影人在该豆瓣电影中的职位
alter table movie_douban_to_celebrity_douban
    modify column id_profession tinyint unsigned not null default 1 comment '该影人在该电影中的职位';
# 该豆瓣影人在该豆瓣电影中的主演顺序
alter table movie_douban_to_celebrity_douban
    modify column sort smallint unsigned not null default 0 comment '该影人在该电影中的演员排列顺序';


# 豆瓣电影经典台词-影人
alter table celebrity_douban_to_classic
    comment '豆瓣电影经典台词-影人';

alter table celebrity_douban_to_classic
    modify column id_celebrity_douban bigint unsigned not null comment '豆瓣影人ID';
alter table celebrity_douban_to_classic
    modify column id_classic_douban varchar(255) not null comment '豆瓣电影经典台词ID';



# 影人 end ========================================================================================

# 片场 start ========================================================================================

# 电影片场相关 ---------------------------------------------------------------------------------

# 1.电影片场基础表---------------------------------------

# 场景电影
alter table movie_scene
    comment '场景电影';

alter table movie_scene
    modify column id bigint unsigned not null comment '场景电影ID';
# 场景电影对应的豆瓣电影ID 0:未匹配 1:已匹配
alter table movie_scene
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID 0-未匹配 1-已匹配';
# 场景电影中文名
alter table movie_scene
    modify column name_zh varchar(255) not null default '' comment '场景电影中文名';
# 场景电影英文名
alter table movie_scene
    modify column name_en varchar(255) not null default '' comment '场景电影英文名';
# 上映时间
alter table movie_scene
    modify column start_year smallint(4) unsigned not null default 0 comment '上映时间 /year';
# 场景电影拍摄地点大致描述
alter table movie_scene
    modify column description varchar(1000) not null default '' comment '场景电影拍摄地点大致描述';
# 场景电影地点分布图链接
alter table movie_scene
    modify column url_map varchar(1000) not null default '' comment '场景电影地点分布图链接';


# 场景影人
alter table celebrity_scene
    comment '场景影人';

alter table celebrity_scene
    modify column id bigint unsigned not null comment '场景影人ID';
# 场景电影对应的豆瓣影人ID 0:未匹配 1:已匹配
alter table celebrity_scene
    modify column id_celebrity_douban bigint unsigned not null default 0 comment '豆瓣影人ID 0-未匹配 1-已匹配';
# 场景影人中文名
alter table celebrity_scene
    modify column name_zh varchar(255) not null default '' comment '场景影人中文名';
# 场景影人英文名
alter table celebrity_scene
    modify column name_en varchar(255) not null default '' comment '场景影人英文名';


# 场景
alter table scene
    comment '场景';

alter table scene
    modify column id bigint unsigned not null comment '场景ID';
# 场景对应的场景电影ID
alter table scene
    modify column id_movie_scene bigint unsigned not null default 0 comment '场景电影ID';
# 场景对应的地点ID
alter table scene
    modify column id_place_scene bigint unsigned not null default 0 comment '地点ID';
# 场景中文名
alter table scene
    modify column name_zh varchar(255) not null default '' comment '场景中文名';
# 场景发生在电影中的时间 秒
alter table scene
    modify column happen_time int unsigned not null default 0 comment '场景发生在电影中的时间 /s';


# 场景详情 （一个场景可能对应多个场景详情）
alter table scene_detail
    comment '场景详情';

alter table scene_detail
    modify column id bigint unsigned not null comment '场景详情ID';
# 场景详情对应的场景ID
alter table scene_detail
    modify column id_scene bigint unsigned not null default 0 comment '场景ID';
# 场景详情对应的场景电影ID
alter table scene_detail
    modify column id_movie_scene bigint unsigned not null default 0 comment '场景电影ID';
# 场景发生在电影中的时间 秒
alter table scene_detail
    modify column happen_time int unsigned not null default 0 comment '场景发生在电影中的时间 /s';
# 场景描述
alter table scene_detail
    modify column description varchar(1000) not null default '' comment '场景描述';



# 2.电影片场关系表---------------------------------------

# 场景电影-场景影人
alter table movie_scene_to_celebrity_scene
    comment '场景电影-场景影人';

alter table movie_scene_to_celebrity_scene
    modify column id_movie_scene bigint unsigned not null comment '场景电影ID';
alter table movie_scene_to_celebrity_scene
    modify column id_celebrity_scene bigint unsigned not null comment '场景影人ID';


# 场景详情-场景影人
alter table scene_detail_to_celebrity_scene
    comment '场景详情-场景影人';

alter table scene_detail_to_celebrity_scene
    modify column id_scene_detail bigint unsigned not null comment '场景详情ID';
alter table scene_detail_to_celebrity_scene
    modify column id_celebrity_scene bigint unsigned not null comment '场景影人ID';



# 片场 end ========================================================================================

# 用户 start ========================================================================================

# 公共用户相关 ---------------------------------------------------------------------------------

# 1.公共用户基础表---------------------------------------

# 用户
alter table user
    comment '用户';

alter table user
    modify column id varchar(255) not null comment '用户ID';
# 邮箱
alter table user
    modify column email varchar(255) not null comment '邮箱';
# 密码
alter table user
    modify column password varchar(255) not null comment '密码';


# 用户角色
alter table role
    comment '用户角色';

alter table role
    modify column id tinyint unsigned not null auto_increment comment '用户角色ID';
# 角色名称
alter table role
    modify column name_zh varchar(255) not null default '' comment '角色名称';
# 角色描述
alter table role
    modify column description varchar(255) not null default '' comment '角色描述';


# 用户权限
alter table permission
    comment '用户权限';

alter table permission
    modify column id int unsigned not null auto_increment comment '用户权限ID';
# 权限名称
alter table permission
    modify column name_zh varchar(255) not null default '' comment '权限名称';
# 权限路径
alter table permission
    modify column path_src varchar(255) not null comment '权限路径';
# 权限描述
alter table permission
    modify column description varchar(255) not null default '' comment '权限描述';



# 2.公共用户关系表---------------------------------------

# 用户-角色
alter table user_to_role
    comment '用户-角色';

alter table user_to_role
    modify column id_user varchar(255) not null comment '用户ID';
alter table user_to_role
    modify column id_role tinyint unsigned not null comment '角色ID';


# 角色-权限
alter table role_to_permission
    comment '角色-权限';

alter table role_to_permission
    modify column id_role tinyint unsigned not null comment '角色ID';
alter table role_to_permission
    modify column id_permission int unsigned not null comment '权限ID';



# 豆瓣用户相关 ---------------------------------------------------------------------------------

# 1.豆瓣用户基础表---------------------------------------

# 豆瓣用户
alter table user_douban
    comment '豆瓣用户';

alter table user_douban
    modify column id varchar(255) not null comment '豆瓣用户ID';
# 名字
alter table user_douban
    modify column name_zh varchar(255) not null default '' comment '豆瓣名字中文名';



# 2.豆瓣用户关系表---------------------------------------

# 豆瓣用户-电影
alter table user_douban_to_movie_douban
    comment '豆瓣用户-电影';

alter table user_douban_to_movie_douban
    modify column id_user_douban varchar(255) not null comment '豆瓣用户ID';
alter table user_douban_to_movie_douban
    modify column id_movie_douban bigint unsigned not null comment '豆瓣电影ID';
# 用户对电影的评分 0.0 ～ 10.0
alter table user_douban_to_movie_douban
    modify column score decimal(3, 1) not null default 0.0 comment '用户对电影的评分';
# 标记用户是否想看 0-未标记 1-已想看
alter table user_douban_to_movie_douban
    modify column is_wish tinyint(2) not null default 0 comment '是否想看 0-未标记 1-已想看';
# 标记用户是否看过 0-未标记 1-已看过
alter table user_douban_to_movie_douban
    modify column is_seen tinyint(2) not null default 0 comment '是否看过 0-未标记 1-已看过';


# 用户-影评
alter table user_douban_to_review_movie_douban
    comment '豆瓣用户-豆瓣影评';

alter table user_douban_to_review_movie_douban
    modify column id_user_douban varchar(255) not null comment '豆瓣用户ID';
alter table user_douban_to_review_movie_douban
    modify column id_review_movie_douban bigint unsigned not null comment '豆瓣影评ID';


# 豆瓣电影经典台词-豆瓣用户
alter table user_douban_to_classic_douban
    comment '豆瓣电影经典台词-豆瓣用户';

alter table user_douban_to_classic_douban
    modify column id_user_douban varchar(255) not null comment '豆瓣用户ID';
alter table user_douban_to_classic_douban
    modify column id_classic_douban varchar(255) not null comment '豆瓣电影经典台词ID';
alter table user_douban_to_classic_douban
    modify column guest varchar(255) not null default '' comment '未登录用户昵称';
# 豆瓣用户收录时间
alter table user_douban_to_classic_douban
    modify column record_datetime bigint not null default 0 comment '豆瓣用户收录时间 /unix';
# 豆瓣用户评价
alter table user_douban_to_classic_douban
    modify column description varchar(1000) not null default '' comment '豆瓣用户评价';



# 用户 end ========================================================================================

# 资源 start ========================================================================================

# 电影资源相关 ---------------------------------------------------------------------------------

# 1.电影资源基础表---------------------------------------

# 电影资源网站 
alter table website_resource
    comment '电影资源网站';

# <100:正版在线 >100:盗版
alter table website_resource
    modify column id smallint unsigned not null comment '电影资源网站ID ID<100-正版 ID>100-盗版';
# 网站中文名
alter table website_resource
    modify column name_zh varchar(255) not null default '' comment '网站中文名';
# 网站官网地址
alter table website_resource
    modify column website_src varchar(255) not null default '' comment '网站官网地址';


# 电影资源类型 (免费播放、vip免费播放、磁力链接...)
alter table type_resource
    comment 'cccc';

# <100:在线  >100:离线
alter table type_resource
    modify column id smallint unsigned not null comment '电影资源类型ID ID<100-在线  ID>100-离线';
# 资源类型中文名
alter table type_resource
    modify column name_zh varchar(255) not null default '' comment '资源类型中文名';


# 电影资源
alter table resource_movie
    comment '电影资源';

alter table resource_movie
    modify column id bigint unsigned not null auto_increment comment '电影资源ID';
# 资源对应的电影 0:未匹配 1:已匹配
alter table resource_movie
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID 0-未匹配 1-已匹配';
# 资源对应IMDB的ID
alter table resource_movie
    modify column id_movie_imdb bigint unsigned not null default 0 comment 'IMDB电影ID 0-未匹配 1-已匹配';
# 资源所属网站 <100:正版在线 >100:盗版
alter table resource_movie
    modify column id_website_resource smallint unsigned not null default 1 comment '电影资源网站ID ID<100-正版 ID>100-盗版';
# 资源所属类型 <100:在线  >100:离线
alter table resource_movie
    modify column id_type_resource smallint unsigned not null default 100 comment '电影资源类型ID ID<100-在线  ID>100-离线';
# 资源中文名(电影名)
alter table resource_movie
    modify column name_zh varchar(255) not null default '' comment '资源中文名';
# 电影年代
alter table resource_movie
    modify column create_year smallint(4) not null default 0 comment '电影年代 /year';
# 资源原始名
alter table resource_movie
    modify column name_origin varchar(255) not null default '' comment '资源原始名';
# 资源链接
/*
 id_type = 101 and
    id_website < 100        https://www.douban.com/link2/?url= + {d_} url
    id_website = 107        http://www.zxzjs.com/video/ + {z_} 2563 + -1-1.html
                            name_origin = name_zh
    id_website = 106        http://www.goudaitv.com/vodplay/ + {g_} 123729 + -1-1.html
    id_website = 105        https://www.66s.cc/ + {v_} xijupian/12348 + .html
    id_website = 101        https://www.dy2018.com/player/index.php?id=https:// + {t_} mu.qqxy100.com/ts/2/36629394919260160 + /index.m3u8
    id_website = 103        http://www.btbtdy.me/play/ + {b_} 16943-0-0 + .html

 */
alter table resource_movie
    modify column url_resource varchar(1000) not null default '' comment '资源链接';



# 2.电影资源关系表---------------------------------------


# 图片资源相关 ---------------------------------------------------------------------------------

# 1.图片资源基础表---------------------------------------

/*
 豆瓣电影图片链接格式: https://img3.doubanio.com/view/photo/l/public/p2567198874.webp
 域名： img1、img3、img9
 图片类型: l、m、sqxs、s_ratio_poster

 */

# 图片（豆瓣电影-电影图片）
alter table image_movie_douban
    comment '豆瓣电影图片';

alter table image_movie_douban
    modify column id bigint unsigned not null comment '豆瓣电影图片ID';
# 豆瓣电影ID
alter table image_movie_douban
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID';
# 序号
alter table image_movie_douban
    modify column sort tinyint unsigned not null default 0 comment '序号';
# 长
alter table image_movie_douban
    modify column length int unsigned not null default 0 comment '长 /px';
# 宽
alter table image_movie_douban
    modify column width int unsigned not null default 0 comment '宽 /px';


# 图片（豆瓣电影-影人图片）
alter table image_celebrity_douban
    comment '豆瓣影人图片';

alter table image_celebrity_douban
    modify column id bigint unsigned not null comment '豆瓣影人图片';
# 豆瓣影人ID
alter table image_celebrity_douban
    modify column id_celebrity_douban bigint unsigned not null default 0 comment '豆瓣影人ID';
# 序号
alter table image_celebrity_douban
    modify column sort tinyint unsigned not null default 0 comment '序号';
# 长
alter table image_celebrity_douban
    modify column length int unsigned not null default 0 comment '长 /px';
# 宽
alter table image_celebrity_douban
    modify column width int unsigned not null default 0 comment '宽 /px';


# 图片（场景地点-地点图片）
alter table image_place_scene
    comment '场景地点图片';

alter table image_place_scene
    modify column id bigint unsigned not null auto_increment comment '场景地点图片ID';
# 场景地点ID
alter table image_place_scene
    modify column id_place_scene bigint unsigned not null default 0 comment '场景地点ID';
# 图片链接
alter table image_place_scene
    modify column url_image varchar(1000) not null default '' comment '图片链接';
# 图片描述
alter table image_place_scene
    modify column description varchar(255) not null default '' comment '图片描述';


# 图片（场景-场景详情的剧照）
alter table image_scene_detail
    comment '场景详情剧照';

alter table image_scene_detail
    modify column id bigint unsigned not null auto_increment comment '场景详情剧照ID';
# 场景详情ID
alter table image_scene_detail
    modify column id_scene_detail bigint unsigned not null default 0 comment '场景详情ID';
# 图片链接
alter table image_scene_detail
    modify column url_image varchar(1000) not null default '' comment '图片链接';



# 2.图片资源关系表---------------------------------------

# 资源 end ========================================================================================

# 区域 start ========================================================================================

# 场景区域相关 ---------------------------------------------------------------------------------

# 1.地点区域基础表---------------------------------------

# 地点
alter table place_scene
    comment '场景地点';

alter table place_scene
    modify column id bigint unsigned not null comment '场景地点ID';
# 地点范围-洲-ID
alter table place_scene
    modify column id_continent_scene tinyint unsigned not null default 0 comment '地点范围-洲-ID';
# 地点范围-国家-ID
alter table place_scene
    modify column id_country_scene smallint unsigned not null default 0 comment '地点范围-国家-ID';
# 地点范围-州/省-ID
alter table place_scene
    modify column id_state_scene int unsigned not null default 0 comment '地点范围-州/省-ID';
# 地点范围-城市-ID
alter table place_scene
    modify column id_city_scene int unsigned not null default 0 comment '地点范围-城市-ID';

# 经度
alter table place_scene
    modify column longitude decimal(11, 8) not null default 0.00000000 comment '经度';
# 纬度
alter table place_scene
    modify column latitude decimal(11, 8) not null default 0.00000000 comment '纬度';

# 中文名
alter table place_scene
    modify column name_zh varchar(255) not null default '' comment '中文名';
# 英文名
alter table place_scene
    modify column name_en varchar(255) not null default '' comment '英文名';
# 其他语言名
alter table place_scene
    modify column name_other varchar(255) not null default '' comment '其他语言名';
# 别名
alter table place_scene
    modify column alias varchar(255) not null default '' comment '别名';
# 中文地址
alter table place_scene
    modify column address_zh varchar(255) not null default '' comment '中文地址';
# 英文地址
alter table place_scene
    modify column address_en varchar(255) not null default '' comment '英文地址';
# 地点描述
alter table place_scene
    modify column description varchar(1000) not null default '' comment '地点描述';
# 区域中文
alter table place_scene
    modify column area_zh varchar(255) not null default '' comment '区域中文';
# 区域英文
alter table place_scene
    modify column area_en varchar(255) not null default '' comment '区域英文';
# 电话号码
alter table place_scene
    modify column phone varchar(255) not null default '' comment '电话号码';
# 地点海报图链接
alter table place_scene
    modify column url_poster varchar(1000) not null default '' comment '地点海报图链接';
# 地点地球位置图链接
alter table place_scene
    modify column url_earth varchar(1000) not null default '' comment '地点地球位置图链接';
# 地点卫星图链接
alter table place_scene
    modify column url_satellite varchar(1000) not null default '' comment '地点卫星图链接';
# 地点地图
alter table place_scene
    modify column url_map varchar(1000) not null default '' comment '地点地图';


# 场景地点类型 (场景地点专属)
alter table type_place_scene
    comment '场景地点类型';

alter table type_place_scene
    modify column id tinyint unsigned not null comment '场景地点类型ID';
# 地点类型名称
alter table type_place_scene
    modify column name_zh varchar(255) not null default '' comment '地点类型名称中文名';


# 洲 (场景专属)
alter table continent_scene
    comment '洲';

alter table continent_scene
    modify column id tinyint unsigned not null comment '洲ID';
# 洲中文名
alter table continent_scene
    modify column name_zh varchar(255) not null default '' comment '洲中文名';
# 洲英文名
alter table continent_scene
    modify column name_en varchar(255) not null default '' comment '洲英文名';


# 国家（场景专属）
alter table country_scene
    comment '国家';

alter table country_scene
    modify column id smallint unsigned not null comment '国家ID';
# 国家中文名
alter table country_scene
    modify column name_zh varchar(255) not null default '' comment '国家中文名';
# 国家英文名
alter table country_scene
    modify column name_en varchar(255) not null default '' comment '国家英文名';


# 州/省(场景地点专属)
alter table state_scene
    comment '州/省';

alter table state_scene
    modify column id int unsigned not null comment '州/省ID';
# 州中文名
alter table state_scene
    modify column name_zh varchar(255) not null default '' comment '州中文名';
# 州英文名
alter table state_scene
    modify column name_en varchar(255) not null default '' comment '州英文名';


# 城市(场景地点专属)
alter table city_scene
    comment '城市';

alter table city_scene
    modify column id int unsigned not null comment '城市ID';
# 城市中文名
alter table city_scene
    modify column name_zh varchar(255) not null default '' comment '城市中文名';
# 城市英文名
alter table city_scene
    modify column name_en varchar(255) not null default '' comment '城市英文名';



# 2.地点区域关系表---------------------------------------

# 场景地点-场景地点类型
alter table place_scene_to_type_place_scene
    comment '场景地点-场景地点类型';

alter table place_scene_to_type_place_scene
    modify column id_place_scene bigint unsigned NOT NULL comment '场景地点ID';
alter table place_scene_to_type_place_scene
    modify column id_type_place_scene tinyint unsigned NOT NULL comment '场景地点类型ID';



# 区域 end ========================================================================================

# 音乐 start ========================================================================================

# 1.网易云音乐基础表---------------------------------------

# 网易云音乐对应的电影
alter table movie_netease
    comment '网易云音乐电影';

# 电影ID
alter table movie_netease
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID';
# 网易云音乐ID
alter table movie_netease
    modify column id_netease bigint unsigned not null default 0 comment '网易云音乐ID';
# 类型 0:未知 1:歌曲 2:歌单 3;专辑
alter table movie_netease
    modify column netease_type tinyint unsigned not null default 0 comment '匹配类型 0-未知 1-歌曲 2-歌单 3-专辑';
# 权值 1-10 依次降低
alter table movie_netease
    modify column sort tinyint unsigned not null default 0 comment '排序 1-10 依次降低';


# 歌曲
alter table song_netease
    comment '网易云音乐歌曲';

alter table song_netease
    modify column id bigint unsigned NOT NULL comment '网易云音乐歌曲ID';
# 歌曲中文名
alter table song_netease
    modify column name_zh varchar(255) not null default '' comment '歌曲中文名';


# 网易云音乐歌手
alter table artist_netease
    comment '网易云音乐歌手';

alter table artist_netease
    modify column id bigint unsigned NOT NULL comment '网易云音乐歌手ID';
# 歌手中文名
alter table artist_netease
    modify column name_zh varchar(255) not null default '' comment '歌手中文名';
# 歌手照片  http://p1.music.126.net/ + url_cover
alter table artist_netease
    modify column url_portrait varchar(1000) not null default '' comment '歌手照片链接';


# 网易云音乐用户
alter table user_netease
    comment '网易云音乐用户';

alter table user_netease
    modify column id bigint unsigned NOT NULL comment '网易云音乐用户ID';
# 用户中文名
alter table user_netease
    modify column name_zh varchar(255) not null default '' comment '用户中文名';


# 网易云音乐歌单
alter table playlist_netease
    comment '网易云音乐歌单';

alter table playlist_netease
    modify column id bigint unsigned NOT NULL comment '网易云音乐歌单ID';
# 歌单中文名
alter table playlist_netease
    modify column name_zh varchar(255) not null default '' comment '歌单中文名';
# 歌单歌曲总数
alter table playlist_netease
    modify column total smallint unsigned NOT NULL default 0 comment '歌单歌曲总数';
# 歌单播放次数
alter table playlist_netease
    modify column play_count int unsigned NOT NULL default 0 comment '歌单播放次数';
# 封面照片 http://p1.music.126.net/ + url_cover
alter table playlist_netease
    modify column url_cover varchar(1000) not null default '' comment '封面照片链接';
# 歌单描述
alter table playlist_netease
    modify column description varchar(1000) not null default '' comment '歌单描述';


# 网易云音乐专辑
alter table album_netease
    comment '网易云音乐专辑';

alter table album_netease
    modify column id bigint unsigned NOT NULL comment '网易云音乐专辑ID';
# 专辑中文名
alter table album_netease
    modify column name_zh varchar(255) not null default '' comment '专辑中文名';
# 专辑歌曲总数
alter table album_netease
    modify column total smallint unsigned NOT NULL default 0 comment '专辑歌曲总数';
# 封面照片 http://p1.music.126.net/ + url_cover
alter table album_netease
    modify column url_cover varchar(1000) not null default '' comment '封面照片链接';


# 网易云音乐专辑热门评论
alter table comment_netease
    comment '网易云音乐专辑热门评论';

# id为0 comment 'cccc';则此歌暂无评论
alter table comment_netease
    modify column id bigint unsigned not null default 0 comment '网易云音乐专辑热门评论ID 0-暂无评论';
# 歌曲ID
alter table comment_netease
    modify column id_song_netease bigint unsigned not null default 0 comment '歌曲ID';
# 网易云音乐用户ID
alter table comment_netease
    modify column id_user_netease bigint unsigned not null default 0 comment '网易云音乐用户ID';
# 创建时间
alter table comment_netease
    modify column create_datetime bigint not null default 0 comment '创建时间 /unix';
# 评论内容
alter table comment_netease
    modify column content varchar(1000) NOT NULL default '' comment '评论内容';
# 赞同数
alter table comment_netease
    modify column agree_vote int unsigned NOT NULL default 0 comment '赞同数';



# 1.网易云音乐关系表---------------------------------------

# 网易云音乐歌曲-歌单
alter table song_netease_to_playlist_netease
    comment '网易云音乐歌曲-歌单';

alter table song_netease_to_playlist_netease
    modify column id_song_netease bigint unsigned NOT NULL comment '网易云音乐歌曲ID';
alter table song_netease_to_playlist_netease
    modify column id_playlist_netease bigint unsigned NOT NULL comment '网易云音乐歌单ID';
# 歌曲在歌单中的流行度 0-100
alter table song_netease_to_playlist_netease
    modify column song_pop tinyint(3) unsigned NOT NULL default 0 comment '歌曲在歌单中的流行度 0-100';


# 网易云音乐歌曲-专辑
alter table song_netease_to_album_netease
    comment '网易云音乐歌曲-专辑';

alter table song_netease_to_album_netease
    modify column id_song_netease bigint unsigned NOT NULL comment '网易云音乐歌曲ID';
alter table song_netease_to_album_netease
    modify column id_album_netease bigint unsigned NOT NULL comment '网易云音乐专辑ID';


# 网易云音乐歌手-专辑
alter table artist_netease_to_album_netease
    comment '网易云音乐歌手-专辑';

alter table artist_netease_to_album_netease
    modify column id_artist_netease bigint unsigned NOT NULL comment '网易云音乐歌手ID';
alter table artist_netease_to_album_netease
    modify column id_album_netease bigint unsigned NOT NULL comment '网易云音乐专辑ID';


# 网易云音乐歌手-歌曲
alter table artist_netease_to_song_netease
    comment '网易云音乐歌手-歌曲';

alter table artist_netease_to_song_netease
    modify column id_artist_netease bigint unsigned NOT NULL comment '网易云音乐歌手ID';
alter table artist_netease_to_song_netease
    modify column id_song_netease bigint unsigned NOT NULL comment '网易云音乐歌曲ID';



# 音乐 end ========================================================================================

# 知乎 start ========================================================================================

# 1.知乎基础表---------------------------------------

# 知乎电影
alter table movie_zhihu
    comment '知乎电影';

# 知乎话题ID https://www.zhihu.com/topic/ + id + /hot
alter table movie_zhihu
    modify column id bigint unsigned not null default 0 comment '知乎电影ID';
# 豆瓣电影ID
alter table movie_zhihu
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID';
# 知乎电影中文名
alter table movie_zhihu
    modify column name_zh varchar(255) not null default '' comment '知乎电影中文名';
# 知乎评分
alter table movie_zhihu
    modify column zhihu_score decimal(3, 1) not null default 0.0 comment '知乎评分';
# 知乎评分票数
alter table movie_zhihu
    modify column zhihu_vote int unsigned not null default 0 comment '知乎评分票数';
# 猫眼评分
alter table movie_zhihu
    modify column maoyan_score decimal(3, 1) not null default 0.0 comment '猫眼评分';


# 知乎问题
alter table question_zhihu
    comment '知乎问题';

# https://www.zhihu.com/question/ + id
alter table question_zhihu
    modify column id bigint unsigned not null comment '知乎问题ID';
# 豆瓣电影ID
alter table question_zhihu
    modify column id_movie_douban bigint unsigned not null default 0 comment '豆瓣电影ID';
# 知乎问题中文名
alter table question_zhihu
    modify column name_zh varchar(255) not null default '' comment '知乎问题中文名';
# 回答数 0:默认 1:文章
alter table question_zhihu
    modify column answer_num int unsigned not null default 0 comment '回答数 0-默认 1-文章';


# 知乎 end ========================================================================================
