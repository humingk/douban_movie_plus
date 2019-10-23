/*
 电影数据库

 author:	humingk

 目录简介：

 电影：
 公共电影相关
 IMDB电影相关
 豆瓣电影相关

 名人：
 公共名人相关
 IMDB名人相关
 豆瓣名人相关

 片场：
 电影片场相关

 用户：
 公共用户相关
 豆瓣用户相关

 资源：
 电影资源相关
 图片资源相关
 
 区域：
 地点区域相关
 
 */


# 电影 start ========================================================================================

# 公共电影相关 ---------------------------------------------------------------------------------

# 1.公共电影基础表---------------------------------------

# 影片种类/类型  (电影、电视剧、电视剧的单集...) 0-默认未知
create table type_video
(
    id      tinyint unsigned not null auto_increment primary key,
    # 影片类型中文名
    name_zh varchar(255)     not null default '',
    # 影片类型英文名
    name_en varchar(255)     not null default ''
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影奖项
create table award_movie
(
    id      smallint unsigned not null auto_increment primary key,
    # 奖项名称
    name_zh varchar(255)      not null default ''
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影奖项类别 (最佳影片、最佳男主角...)
create table type_award
(
    id      smallint unsigned not null auto_increment primary key,
    # 奖项类别名称
    name_zh varchar(255)      not null default ''
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影类型
create table type_movie
(
    id      smallint unsigned not null auto_increment primary key,
    # 类型中文名
    name_zh varchar(255)      not null default '',
    # 类型英文名
    name_en varchar(255)      not null default ''
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影标签
create table tag_movie
(
    id      int unsigned not null auto_increment primary key,
    # 标签中文名
    name_zh varchar(255) not null default '',
    # 标签英文名
    name_en varchar(255) not null default ''
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影短评
create table comment_douban
(
    id          bigint unsigned not null primary key,
    # 短评内容
    content     varchar(65535)  not null default '',
    # 投票数
    agree_vote  smallint        not null default 0,
    # 短评日期
    create_date date,

    index (content(20)),
    index (agree_vote desc)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影影评
create table review_douban
(
    id              bigint unsigned not null primary key,
    # 影评内容
    content         varchar(65535)  not null default '',
    # 赞同数
    agree_vote      int unsigned             default 0,
    # 反对数
    against_vote    int unsigned             default 0,
    # 影评日期时间
    create_datetime datetime,

    index (content(50)),
    index (agree_vote desc),
    index (against_vote desc)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.公共电影关系表---------------------------------------

# IMDB电影相关 ---------------------------------------------------------------------------------

# 1.IMDB电影基础表---------------------------------------

# IMDB电影 0-默认
create table movie_imdb
(
    id            bigint unsigned   not null primary key,
    # 影片种类/类型 0-默认未知 (电影、电视剧、电视剧的单集...)
    id_type_video tinyint unsigned  not null default 0,
    # IMDB电影发行年份 、 电视剧首集播放年份
    start_year    year,
    # 是否是成人电影 0-不是 1-是
    is_adult      tinyint(1)        not null default 0,
    # IMDB电影英文名
    name_en       varchar(255)      not null default '',
    # IMDB电影原始名
    name_origin   varchar(255)      not null default '',
    # IMDB电影片长 分钟
    runtime       smallint unsigned not null default 0,

    index (id_type_video),
    index (start_year desc),
    index (is_adult),
    index (name_en),
    index (name_origin)
) ENGINE = InnoDB
  default charset = utf8mb4;

# IMDB电影评分
create table rate_imdb
(
    # tt+id,id至少7个数字（不够7个在id前面添0）
    id           bigint unsigned not null primary key,
    # IMDB评分
    imdb_score   decimal(2, 1)   not null default 0.0,
    # IMDB评分人数
    imdb_vote    int unsigned    not null default 0,
    # MTC评分
    mtc_score    decimal(2, 1)   not null default 0.0,
    # 烂番茄新鲜度
    tomato_score decimal(2, 1)   not null default 0.0,

    index (imdb_score desc),
    index (imdb_vote desc),
    index (mtc_score desc),
    index (tomato_score desc)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.IMDB电影关系表---------------------------------------

# IMDB电影-电影类型
create table movie_imdb_to_type_movie
(
    id_movie_imdb bigint unsigned   not null,
    id_type_movie smallint unsigned not null,

    primary key (id_movie_imdb, id_type_movie)
) ENGINE = InnoDB
  default charset = utf8mb4;

# IMDB电影的剧集 （一部电视剧包含多剧集，电视剧ID和剧集ID在url中是平级关系）
create table episode_imdb
(
    # 剧集ID tt+id,id至少7个数字（不够7个在id前面添0）
    id            bigint unsigned  not null primary key,
    # 当前剧集所属的电视剧ID  tt+id,id至少7个数字（不够7个在id前面添0）
    id_movie_imdb bigint unsigned  not null default 0,
    # 当前剧集所属季 1-默认第一季
    season_num    tinyint unsigned not null default 1,
    # 当前剧集所属集 1-默认第一集
    set_num       tinyint unsigned not null default 1,

    index (id_movie_imdb),
    index (season_num asc),
    index (set_num asc)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影相关 ---------------------------------------------------------------------------------

# 1.豆瓣电影基础表---------------------------------------

# 豆瓣电影 0-默认
create table movie_douban
(
    id                    bigint unsigned   not null primary key,
    # 豆瓣电影的IMDB-ID 0-默认未知
    id_movie_imdb         bigint unsigned   not null default 0,
    # 影片种类/类型-ID 0-默认未知 (电影、电视剧、电视剧的单集...)
    id_type_video         tinyint unsigned  not null default 0,
    # 豆瓣电影海报ID
    id_image_movie_douban bigint unsigned   not null,
    # 豆瓣电影中文名
    name_zh               varchar(255)      not null default '',
    # 豆瓣电影英文名
    name_en               varchar(255)      not null default '',
    # 豆瓣电影其他文名
    name_other            varchar(255)      not null default '',
    # 豆瓣电影别称 以/为间隔的字符串
    name_alias            varchar(65535)    not null default '',
    # 豆瓣电影运行片长 分钟
    runtime               smallint unsigned not null default 0,
    # 豆瓣电视剧总集数 1-默认为一集（电影）(豆瓣电影不同于IMDB，豆瓣的电视剧ID和集为上下级关系)
    set_sum               smallint unsigned not null default 1,

    index (id_movie_imdb),
    index (id_type_video),
    index (name_zh),
    index (name_en),
    index (name_other),
    index (name_alias(255))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影评分 0-默认
create table rate_douban
(
    id           bigint unsigned not null primary key,
    # 豆瓣电影评分 0.0 ~ 10.0
    douban_score decimal(2, 1)   not null default 0.0,
    # 豆瓣电影评分人数
    douban_vote  int unsigned    not null default 0,
    # 豆瓣1星 %
    score1       decimal(3, 2)   not null default 00.0,
    # 豆瓣2星 %
    score2       decimal(3, 2)   not null default 00.0,
    # 豆瓣3星 %
    score3       decimal(3, 2)   not null default 00.0,
    # 豆瓣4星 %
    score4       decimal(3, 2)   not null default 00.0,
    # 豆瓣5星 %
    score5       decimal(3, 2)   not null default 00.0,

    index (douban_score desc),
    index (douban_vote desc),
    index (score1 desc),
    index (score2 desc),
    index (score3 desc),
    index (score4 desc),
    index (score5 desc)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影经典台词
create table classic_douban
(
    id              bigint unsigned not null auto_increment primary key,
    id_movie_douban bigint unsigned not null,
    # 经典台词内容
    content         varchar(65535)  not null default '',
    # 经典台词在影片中的出现时间 分钟
    happen_time     int unsigned    not null default 0,
    # 经典台词获得的票数
    agree_vote      int unsigned    not null default 0,

    index (id_movie_douban),
    index (content(255)),
    index (happen_time asc),
    index (agree_vote desc)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.豆瓣电影关系表---------------------------------------

# 豆瓣电影-电影类型
create table movie_douban_to_type_movie
(
    id_movie_douban bigint unsigned   not null,
    id_movie_type   smallint unsigned not null,

    primary key (id_movie_douban, id_movie_type)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-奖项
create table movie_douban_to_award_movie
(
    # 获奖豆瓣电影ID
    id_movie_douban     bigint unsigned   not null,
    # 获奖奖项ID
    id_award_movie      smallint unsigned not null,
    # 获奖奖项届数 0-默认未知
    award_th            smallint unsigned not null default 0,
    # 获奖奖项类型ID
    id_type_award       smallint unsigned not null,
    # 获奖豆瓣名人ID
    id_celebrity_douban bigint unsigned   not null,
    # 获奖年份
    gain_year           year,

    primary key (id_movie_douban, id_award_movie, award_th, id_type_award, id_celebrity_douban)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-制片地区
create table movie_douban_to_area_douban
(
    id_movie_douban bigint unsigned not null,
    # 豆瓣电影的制片地区ID
    id_area_douban  int unsigned    not null,
    # 豆瓣电影在当前地区的上映日期
    show_date       date,

    primary key (id_movie_douban, id_area_douban),
    index (show_date desc)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-电影标签
create table movie_douban_to_tag_douban
(
    id_movie_douban bigint unsigned not null,
    id_tag_movie    int unsigned    not null,

    primary key (id_movie_douban, id_tag_movie)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-短评
create table movie_douban_to_comment_douban
(
    id_movie_douban   bigint unsigned not null,
    id_comment_douban bigint unsigned not null,

    primary key (id_movie_douban, id_comment_douban)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-影评
create table movie_douban_to_review_douban
(
    id_movie_douban  bigint unsigned not null,
    id_review_douban bigint unsigned not null,

    primary key (id_movie_douban, id_review_douban)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-图片
create table movie_douban_to_image_movie_douban
(
    id_movie_douban       bigint unsigned not null,
    id_image_movie_douban bigint unsigned not null,
    # 此图的描述
    description           varchar(255)    not null default '',

    primary key (id_movie_douban, id_image_movie_douban)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影 end ========================================================================================

# 名人 start ========================================================================================

# 公共名人相关 ---------------------------------------------------------------------------------

# 1.公共名人基础表---------------------------------------

# 名人职业
create table profession
(
    id      tinyint unsigned not null primary key,
    # 职业中文名
    name_zh varchar(255)     not null default '',
    # 职业英文名
    name_en varchar(255)     not null default ''
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.公共名人关系表---------------------------------------

# IMDB名人相关 ---------------------------------------------------------------------------------

# 1.IMDB名人基础表---------------------------------------

# IMDB名人
create table celebrity_imdb
(
    # nm+id,id至少7个数字（不够7个在id前面添0）
    icelebrity_id bigint unsigned not null primary key,
    # 英文名
    name_en       varchar(255)    not null default '',
    # 出生年份
    birth_year    year,
    # 死亡年份
    death_year    year,

    index (name_en),
    index (birth_year),
    index (death_year)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.IMDB名人关系表---------------------------------------

# IMDB电影-名人
create table movie_imdb_to_celebrity_imdb
(
    id_movie_imdb     bigint unsigned  not null,
    id_celebrity_imdb bigint unsigned  not null,
    # 该IMDB名人在该IMDB电影中的职位
    id_profession     tinyint unsigned not null,

    primary key (id_movie_imdb, id_celebrity_imdb, id_profession)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣名人相关 ---------------------------------------------------------------------------------

# 1.豆瓣名人基础表---------------------------------------

# 豆瓣名人
create table celebrity_douban
(
    id                        bigint unsigned not null primary key,
    # IMDB-ID 0-默认未知
    id_celebrity_imdb         bigint unsigned not null default 0,
    # 出生国家 0-默认未知
    id_country_imdb           int unsigned    not null default 0,
    # 出生州/省 0-默认未知
    id_state_imdb             int unsigned    not null default 0,
    # 出生城市 0-默认未知
    id_city_imdb              int unsigned    not null default 0,

    # 豆瓣影人海报ID
    id_image_celebrity_douban bigint unsigned not null,
    # 中文名
    name_zh                   varchar(255)    not null default '',
    # 英文名
    name_en                   varchar(255)    not null default '',
    # 其他外文名
    name_other                varchar(255)    not null default '',
    # 更多中文名 以 / 为间隔
    name_zh_more              varchar(65535)  not null default '',
    # 更多英文名 以 / 为间隔
    name_en_more              varchar(65535)  not null default '',
    # 更多外文名 以 / 为间隔
    name_other_more           varchar(65535)  not null default '',
    # 性别 0-女 1-男 2-其他
    sex                       tinyint(1)      not null default 2,
    # 生日日期
    birth_date                date,
    # 描述
    description               varchar(65535)  not null default '',


    index (id_celebrity_imdb),
    index (id_country_imdb),
    index (id_state_imdb),
    index (id_city_imdb),

    index (id_image_celebrity_douban),
    index (name_zh),
    index (name_en),
    index (name_other),
    index (name_zh_more(255)),
    index (name_en_more(255)),
    index (name_other_more(255)),
    index (sex),
    index (birth_date),
    index (description(20))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.豆瓣名人关系表---------------------------------------

# 豆瓣名人-职业 (导演、编剧...)
create table celebrity_douban_to_profession
(
    id_celebrity_douban bigint unsigned not null,
    id_profession       int unsigned    not null,

    primary key (id_celebrity_douban, id_profession)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-名人
create table movie_douban_to_celebrity_douban
(
    id_movie_douban     bigint unsigned not null,
    id_celebrity_douban bigint unsigned not null,
    # 该豆瓣名人在该豆瓣电影中的职位
    id_profession       int unsigned    not null,

    primary key (id_movie_douban, id_celebrity_douban, id_profession)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣名人-图片
create table celebrity_douban_to_image_celebrity_douban
(
    id_celebrity_douban       bigint unsigned not null,
    id_image_celebrity_douban bigint unsigned not null,
    # 此图的描述
    description               varchar(255)    not null default '',

    primary key (id_celebrity_douban, id_image_celebrity_douban)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影经典台词-名人
create table celebrity_douban_to_classic
(
    id_celebrity_douban bigint unsigned not null,
    id_classic_douban   bigint unsigned not null,

    primary key (id_celebrity_douban, id_classic_douban)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 名人 end ========================================================================================

# 片场 start ========================================================================================

# 电影片场相关 ---------------------------------------------------------------------------------

# 1.电影片场基础表---------------------------------------

# 场景电影
create table movie_scene
(
    id                       bigint unsigned not null primary key,
    # 场景电影对应的豆瓣电影ID
    id_movie_douban          bigint unsigned not null,
    # 场景电影海报ID
    id_image_movie_scene     bigint unsigned not null,
    # 场景电影静态地图ID
    id_image_movie_map_scene bigint unsigned not null,
    # 场景电影拍摄地点大致描述
    description              varchar(65535)  not null default '',

    index (id_movie_douban),
    index (id_image_movie_scene),
    index (id_image_movie_map_scene),
    index (description(20))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 场景名人
create table celebrity_scene
(
    id                  bigint unsigned not null primary key,
    # 场景详情ID
    id_scene            bigint unsigned not null,
    # 场景电影对应的豆瓣名人ID
    id_celebrity_douban bigint unsigned not null,
    # 场景名人中文名
    name_zh             varchar(255)    not null default '',
    # 场景名人英文名
    name_en             varchar(255)    not null default '',

    index (id_scene),
    index (id_celebrity_douban),
    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 场景
create table scene
(
    id             bigint unsigned not null primary key,
    # 场景对应的场景电影ID
    id_movie_scene bigint unsigned not null default 0,
    # 场景对应的地点ID
    id_place       bigint unsigned not null default 0,
    # 场景发生在电影中的时间 秒
    happen_time    int unsigned    not null default 0,
    # 场景描述
    description    varchar(65535)  not null default '',

    index (id_movie_scene),
    index (id_place),
    index (happen_time asc),
    index (description(20))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.电影片场关系表---------------------------------------

# 片场 end ========================================================================================

# 用户 start ========================================================================================

# 公共用户相关 ---------------------------------------------------------------------------------

# 1.公共用户基础表---------------------------------------

# 用户角色
create table role
(
    id          tinyint unsigned not null auto_increment primary key,
    # 角色名称
    name_zh     varchar(255)     not null default '',
    # 角色描述
    description varchar(255)     not null default '',

    index (name_zh),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 用户权限
create table permission
(
    id          int unsigned not null auto_increment primary key,
    # 权限名称
    name_zh     varchar(255) not null default '',
    # 权限路径
    path_src    varchar(255) not null,
    # 权限描述
    description varchar(255) not null default '',

    index (name_zh),
    unique index (path_src),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.公共用户关系表---------------------------------------

# 角色-权限
create table role_to_permission
(
    id_role       tinyint unsigned not null,
    id_permission int unsigned     not null,

    primary key (id_role, id_permission)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣用户相关 ---------------------------------------------------------------------------------

# 1.豆瓣用户基础表---------------------------------------

# 豆瓣用户
create table user_douban
(
    id       int unsigned not null primary key,
    # 域名
    domain   varchar(255),
    # 名字
    name_zh  varchar(255) not null default '',
    # md5加密格式的密码
    password varchar(255) not null default '',
    # 注册手机号
    phone    varchar(255) not null default '',
    # 注册邮箱
    email    varchar(255) not null default '',

    unique index (domain),
    index (name_zh),
    index (password),
    index (phone),
    index (email)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.豆瓣用户关系表---------------------------------------

# 豆瓣用户-角色
create table user_douban_to_role
(
    id_user_douban int unsigned     not null,
    id_role        tinyint unsigned not null,

    primary key (id_user_douban, id_role)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣用户-电影
create table user_douban_to_movie_douban
(
    id_user_douban  int unsigned    not null,
    id_movie_douban bigint unsigned not null,
    # 用户对电影的评分 0.0 ～ 10.0
    score           decimal(2, 1)   not null default 0.0,
    # 标记用户是否想看 0-未标记 1-已想看
    wish            tinyint(1)      not null default 0,
    # 标记用户是否看过 0-未标记 1-已看过
    seen            tinyint(1)      not null default 0,

    primary key (id_user_douban, id_movie_douban),
    index (score desc),
    index (wish),
    index (seen)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣用户-短评
create table user_douban_to_comment_douban
(
    id_user_douban    int unsigned    not null,
    id_comment_douban bigint unsigned not null,

    primary key (id_user_douban, id_comment_douban)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 用户-影评
create table user_douban_to_review_douban
(
    id_user_douban   int unsigned    not null,
    id_review_douban bigint unsigned not null,

    primary key (id_user_douban, id_review_douban)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影经典台词-用户
create table user_douban_to_classic_douban
(
    id_user_douban    int unsigned    not null,
    id_classic_douban bigint unsigned not null,
    # 豆瓣用户收录时间
    record_datetime   datetime,
    # 豆瓣用户评价
    description       varchar(65535)  not null default '',

    primary key (id_user_douban, id_classic_douban),
    index (record_datetime),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 用户 end ========================================================================================

# 资源 start ========================================================================================

# 电影资源相关 ---------------------------------------------------------------------------------

# 1.电影资源基础表---------------------------------------

# 电影资源网站 0-默认未知
create table website_resource
(
    id          tinyint unsigned not null auto_increment primary key,
    # 网站中文名
    name_zh     varchar(255)     not null default '',
    # 网站英文名
    name_en     varchar(255)     not null default '',
    # 网站是否为正版合法网站 0-否 1-是
    is_legal    tinyint(1)       not null default 0,
    # 网站官网地址
    website_src varchar(255)     not null default '',
    # 网站描述
    description varchar(255)     not null default '',

    primary key (id),
    index (name_zh),
    index (name_en),
    index (is_legal)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影资源类型 (vip免费播放、磁力链接...) 0-默认未知
create table type_resource
(
    id        tinyint unsigned not null auto_increment primary key,
    # 资源类型中文名
    name_zh   varchar(255)     not null default '',
    # 资源类型英文名
    name_en   varchar(255)     not null default '',
    # 跳转链接前半部分 （first + keyword + last 即为资源链接）
    src_first varchar(65535)   not null default '',
    # 跳转链接后半部分
    src_last  varchar(65535)   not null default '',

    primary key (id),
    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影资源
create table resource_movie
(
    id                  bigint unsigned  not null auto_increment primary key,
    # 资源对应的电影
    id_movie_douban     bigint unsigned  not null default 0,
    # 资源所属网站
    id_website_resource tinyint unsigned not null default 0,
    # 资源所属类型
    id_type_resource    tinyint unsigned not null default 0,
    # 资源链接的跳转关键字 （first + keyword + last 即为资源链接）
    keyword             varchar(65535)   not null default '',
    # 资源原始名称
    name_origin         varchar(255)     not null default '',
    # 资源描述
    description         varchar(255)     not null default '',

    index (id_movie_douban),
    index (id_website_resource),
    index (id_type_resource),
    index (name_origin),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.电影资源关系表---------------------------------------

/*

# 电影关键字表(可用于 资源搜索、音乐搜索、地区搜索... )
create table keyword
(
    keyword       char(50) not null,
    # 是否搜索过电影表列表 0 没有 1 有
    search_flag   int(1)   not null default 0,
    # 是否搜索过电影资源 0 没有 1 有
    resource_flag int(1)   not null default 0,
    primary key (keyword),
    index moviemap_flag (search_flag),
    index resourcelist_flag (resource_flag)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影搜索列表
create table search
(
    movie_url   varchar(500) not null,
    keyword     char(50)     not null,
    movie_name  varchar(500) not null default '',
    client_type int(3)       not null default 0,
    primary key (movie_url, keyword),
    foreign key (keyword) references keyword (keyword),
    index movie_name (movie_name),
    index client_type (client_type)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 资源列表
create table resource
(
    resource_url  varchar(500) not null,
    keyword       char(50)     not null,
    resource_name varchar(200) not null default '',
    resource_type int(3)       not null default 0,
    client_type   int(3)       not null default 0,
    primary key (resource_url, keyword),
    foreign key (keyword) references keyword (keyword),
    index resource_name (resource_name),
    index resource_type (resource_type),
    index client_type (client_type)
) ENGINE = InnoDB
  default charset = utf8mb4;
*/

# 图片资源相关 ---------------------------------------------------------------------------------

# 1.图片资源基础表---------------------------------------

# 图片资源网站 0-默认未知
create table website_image
(
    id          tinyint unsigned not null auto_increment primary key,
    # 网站中文名
    name_zh     varchar(255)     not null default '',
    # 网站英文名
    name_en     varchar(255)     not null default '',
    # 网站官网地址
    website_src varchar(255)     not null default '',
    # 网站描述
    description varchar(255)     not null default '',

    primary key (id),
    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 图片类型 0-默认未知
create table type_image
(
    id        smallint unsigned not null auto_increment primary key,
    # 图片类型名称
    name_zh   varchar(255)      not null default '',
    # 图片url前半部分 (first + keyword + last 即为图片地址)
    src_first varchar(65535)    not null default '',
    # 图片url后半部分
    src_last  varchar(65535)    not null default '',

    index (name_zh)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 图片（地点所有图片专属）(包括海报) 0-默认未知
create table image_place
(
    id               bigint unsigned     not null auto_increment primary key,
    # 图片的类型 0-默认未知
    id_type_image    smallint unsigned   not null default 0,
    # 图片是否是海报 0-不是 1-是
    is_poster        tinyint(1) unsigned not null default 0,
    # 图片所属网站 0-默认未知
    id_website_image tinyint unsigned    not null default 0,
    # 图片url关键字
    keyword          varchar(255)        not null default '',
    # 图片原始名称
    name_origin      varchar(255)        not null default '',
    # 图片描述
    description      varchar(255)        not null default '',

    index (id_type_image),
    index (is_poster),
    index (id_website_image),
    index (name_origin),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 图片（地点于地球位置专属）0-默认未知
create table image_place_earth
(
    id               bigint unsigned   not null auto_increment primary key,
    # 图片的类型 0-默认未知
    id_type_image    smallint unsigned not null default 0,
    # 图片所属网站 0-默认未知
    id_website_image tinyint unsigned  not null default 0,
    # 图片url关键字
    keyword          varchar(255)      not null default '',
    # 图片原始名称
    name_origin      varchar(255)      not null default '',
    # 图片描述
    description      varchar(255)      not null default '',

    index (id_type_image),
    index (id_website_image),
    index (name_origin),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 图片（场景电影所有地点静态地图专属）0-默认未知
create table image_movie_map_scene
(
    id               bigint unsigned   not null auto_increment primary key,
    # 图片的类型 0-默认未知
    id_type_image    smallint unsigned not null default 0,
    # 图片所属网站 0-默认未知
    id_website_image tinyint unsigned  not null default 0,
    # 图片url关键字
    keyword          varchar(255)      not null default '',
    # 图片原始名称
    name_origin      varchar(255)      not null default '',
    # 图片描述
    description      varchar(255)      not null default '',

    index (id_type_image),
    index (id_website_image),
    index (name_origin),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 图片（豆瓣电影所有图片专属）(包括海报) 0-默认未知
create table image_movie_douban
(
    id               bigint unsigned     not null auto_increment primary key,
    # 图片的类型 0-默认未知
    id_type_image    smallint unsigned   not null default 0,
    # 图片是否是海报 0-不是 1-是
    is_poster        tinyint(1) unsigned not null default 0,
    # 图片所属网站 0-默认未知
    id_website_image tinyint unsigned    not null default 0,
    # 图片url关键字
    keyword          varchar(255)        not null default '',
    # 图片原始名称
    name_origin      varchar(255)        not null default '',
    # 图片描述
    description      varchar(255)        not null default '',

    index (id_type_image),
    index (is_poster),
    index (id_website_image),
    index (name_origin),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 图片（豆瓣名人所有图片专属）(包括海报) 0-默认未知
create table image_celebrity_douban
(
    id               bigint unsigned     not null auto_increment primary key,
    # 图片的类型 0-默认未知
    id_type_image    smallint unsigned   not null default 0,
    # 图片是否是海报 0-不是 1-是
    is_poster        tinyint(1) unsigned not null default 0,
    # 图片所属网站 0-默认未知
    id_website_image tinyint unsigned    not null default 0,
    # 图片url关键字
    keyword          varchar(255)        not null default '',
    # 图片原始名称
    name_origin      varchar(255)        not null default '',
    # 图片描述
    description      varchar(255)        not null default '',

    index (id_type_image),
    index (is_poster),
    index (id_website_image),
    index (name_origin),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 图片（场景电影所有图片专属）(包括海报) 0-默认未知
create table image_movie_scene
(
    id               bigint unsigned     not null auto_increment primary key,
    # 图片是否是海报 0-不是 1-是
    is_poster        tinyint(1) unsigned not null default 0,
    # 图片的类型 0-默认未知
    id_type_image    smallint unsigned   not null default 0,
    # 图片所属网站 0-默认未知
    id_website_image tinyint unsigned    not null default 0,
    # 图片url关键字
    keyword          varchar(255)        not null default '',
    # 图片原始名称
    name_origin      varchar(255)        not null default '',
    # 图片描述
    description      varchar(255)        not null default '',

    index (is_poster),
    index (id_type_image),
    index (id_website_image),
    index (name_origin),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;


# 2.图片资源关系表---------------------------------------

# 资源 end ========================================================================================

# 区域 start ========================================================================================

# 地点区域相关 ---------------------------------------------------------------------------------

# 1.地点区域基础表---------------------------------------

# 洲 (地点专属)
create table continent_place
(
    id      int unsigned not null primary key,
    # 洲中文名
    name_zh varchar(255) not null default '',
    # 洲英文名
    name_en varchar(255) not null default ''
) ENGINE = InnoDB
  default charset = utf8mb4;

# 国家（地点专属）
create table country_place
(
    id      int unsigned not null primary key,
    # 国家中文名
    name_zh varchar(255) not null default '',
    # 国家英文名
    name_en varchar(255) not null default '',

    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 国家（imdb专属）
create table country_imdb
(
    id      int unsigned not null auto_increment primary key,
    # 国家中文名
    name_zh varchar(255) not null default '',
    # 国家英文名
    name_en varchar(255) not null default '',

    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 州/省(地点专属)
create table state_place
(
    id      int unsigned not null primary key,
    # 州中文名
    name_zh varchar(255) not null default '',
    # 州英文名
    name_en varchar(255) not null default '',

    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 州/省(imdb专属)
create table state_imdb
(
    id      int unsigned not null auto_increment primary key,
    # 州中文名
    name_zh varchar(255) not null default '',
    # 州英文名
    name_en varchar(255) not null default '',

    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 城市(地点专属)
create table city_place
(
    id      int unsigned not null primary key,
    # 城市中文名
    name_zh varchar(255) not null default '',
    # 城市英文名
    name_en varchar(255) not null default '',

    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 城市(imdb专属)
create table city_imdb
(
    id      int unsigned not null auto_increment primary key,
    # 城市中文名
    name_zh varchar(255) not null default '',
    # 城市英文名
    name_en varchar(255) not null default '',

    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 地区(地点专属)
create table area_place
(
    id      int unsigned not null primary key,
    # 地区中文名
    name_zh varchar(255) not null default '',
    # 地区英文名
    name_en varchar(255) not null default '',

    index (name_zh),
    index (name_en)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 地区 (豆瓣电影专属)
create table area_douban
(
    id      int unsigned not null auto_increment primary key,
    # 地区中文名
    name_zh varchar(255) not null default '',

    index (name_zh)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 地点类型 (地点专属)
create table type_place
(
    id      int unsigned not null primary key,
    # 地点类型名称
    name_zh varchar(255) not null default '',

    index (name_zh)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 地点 0-默认
create table place
(
    id                   bigint unsigned   not null primary key,
    # 地点类型-id
    id_type_place        smallint unsigned not null default 9999,
    # 地点范围-洲-id
    id_continent_place   tinyint unsigned  not null default 99,
    # 地点范围-国家-id
    id_country_place     smallint unsigned not null default 9999,
    # 地点范围-州/省-id
    id_state_place       int unsigned      not null default 99999999,
    # 地点范围-城市-id
    id_city_place        int unsigned      not null default 99999999,
    # 地点范围-地区-id
    id_area_place        int unsigned      not null default 99999999,

    # 地点的主页海报图-id
    id_image_place       bigint unsigned   not null default 0,
    # 地点位于地球上的位置图-id
    id_image_place_earth bigint unsigned   not null default 0,

    # 经度
    longitude            decimal(10, 8)    not null default 0.00000000,
    # 纬度
    latitude             decimal(10, 8)    not null default 0.00000000,

    # 中文名
    name_zh              varchar(255)      not null default '',
    # 英文名
    name_en              varchar(255)      not null default '',
    # 其他语言名
    name_other           varchar(255)      not null default '',
    # 别名
    alias                varchar(255)      not null default '',
    # 中文地址
    address_zh           varchar(255)      not null default '',
    # 英文地址
    address_en           varchar(255)      not null default '',
    # 地点描述
    description          varchar(65535)    not null default '',
    # 电话号码
    phone                varchar(255)      not null default '',

    index (id_type_place),
    index (id_continent_place),
    index (id_country_place),
    index (id_state_place),
    index (id_city_place),
    index (id_area_place),
    index (id_image_place),
    index (id_image_place_earth),
    index (longitude),
    index (latitude),
    index (alias),
    index (name_zh),
    index (name_en),
    index (name_other),
    index (description(10)),
    index (phone)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.地点区域关系表---------------------------------------

# 地点-图片
create table place_to_image_place
(
    id_place       bigint unsigned not null,
    id_image_place bigint unsigned not null,
    # 此实景图的描述
    description    varchar(255)    not null default '',

    primary key (id_place, id_image_place)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 区域 end ========================================================================================

