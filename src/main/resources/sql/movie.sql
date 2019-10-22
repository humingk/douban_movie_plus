/*
 电影数据库

 author:	humingk

 目录简介：

 区域：
 地点区域相关

 电影：
 公共电影相关
 IMDB电影相关
 豆瓣电影相关

 人物：
 公共人物相关
 IMDB人物相关
 豆瓣人物相关

 片场：
 电影片场相关

 资源：
 电影正版资源相关
 电影盗版资源相关
 图片资源相关

 用户：
 公共用户相关
 豆瓣用户相关

 */

# 创建数据库
drop database if exists douban_movie;
create database douban_movie;
use douban_movie;


# 区域 start ========================================================================================

# 地点区域相关 ---------------------------------------------------------------------------------

# 1.地点区域基础表---------------------------------------

# 地点表
create table place
(
    place_id     bigint unsigned   not null,
    # 地点类型
    ptype_id     smallint unsigned not null default 9999,
    # 地点范围-洲
    continent_id tinyint unsigned  not null default 99,
    # 地点范围-国家
    country_id   smallint unsigned not null default 9999,
    # 地点范围-州/省
    state_id     int unsigned      not null default 99999999,
    # 地点范围-城市
    cite_id      int unsigned      not null default 99999999,
    # 地点范围-地区
    area_id      int unsigned      not null default 99999999,
    # 主页图ID
    cover_id     bigint unsigned   not null default '',

    primary key (place_id),
    foreign key (ptype_id) references ptype (ptype_id),
    foreign key (continent_id) references continent (continent_id),
    foreign key (country_id) references country (country_id),
    foreign key (state_id) references state (state_id),
    foreign key (cite_id) references cite (cite_id),
    foreign key (area_id) references area (area_id),
    foreign key (cover_id) references image (image_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 洲表
create table continent
(
    continent_id int unsigned not null,
    # 洲中文名
    cname        varchar(255) not null default '',
    # 洲英文名
    ename        varchar(255) not null default '',

    primary key (continent_id),
    index (cname),
    index (ename)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 国家表
create table country
(
    country_id int unsigned not null,
    # 国家中文名
    cname      varchar(255) not null default '',
    # 国家英文名
    ename      varchar(255) not null default '',

    primary key (country_id),
    index (cname),
    index (ename)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 州/省表
create table state
(
    state_id int unsigned not null,
    # 州中文名
    cname    varchar(255) not null default '',
    # 州英文名
    ename    varchar(255) not null default '',

    primary key (state_id),
    index (cname),
    index (ename)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 城市表
create table cite
(
    cite_id int unsigned not null,
    # 城市中文名
    cname   varchar(255) not null default '',
    # 城市英文名
    ename   varchar(255) not null default '',

    primary key (cite_id),
    index (cname),
    index (ename)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 地区表
create table area
(
    area_id int unsigned not null,
    # 地区中文名
    cname   varchar(255) not null default '',
    # 地区英文名
    ename   varchar(255) not null default '',

    primary key (area_id),
    index (cname),
    index (ename)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 地区表(豆瓣电影专属)
create table darea
(
    darea_id int unsigned not null auto_increment,
    # 地区中文名
    cname    varchar(255) not null default '',

    primary key (darea_id),
    index (cname)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 地点详情表
create table place_detail
(
    place_id    bigint unsigned not null,
    # 经度
    longitude   decimal(10, 8)  not null default '0.00000000',
    # 纬度
    latitude    decimal(10, 8)  not null default '0.00000000',
    # 中文名
    cname       varchar(255)    not null default '',
    # 英文名
    ename       varchar(255)    not null default '',
    # 其他语言名
    oname       varchar(255)    not null default '',
    # 别名
    alias       varchar(255)    not null default '',
    # 中文地址
    caddress    varchar(255)    not null default '',
    # 英文地址
    eaddress    varchar(255)    not null default '',
    # 地点描述
    description varchar(65535)  not null default '',
    # 电话号码
    phone       varchar(255)    not null default '',

    primary key (place_id),
    index (longitude),
    index (latitude),
    index (cname),
    index (ename),
    index (oname),
    index (alias),
    index (caddress),
    index (eaddress),
    index (description(10)),
    index (phone)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 地点类型表
create table ptype
(
    ptype_id int unsigned not null,
    # 地点类型名称
    cname    varchar(255) not null default '',

    primary key (ptype_id),
    index (cname)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.地点区域关系表---------------------------------------


# 区域 end ========================================================================================

# 电影 start ========================================================================================

# 公共电影相关 ---------------------------------------------------------------------------------

# 1.公共电影基础表---------------------------------------

# 影片种类/类型 (电影、电视剧、电视剧的单集...)
create table vtype
(
    vtype_id tinyint unsigned not null auto_increment,
    # 影片类型中文名
    cname    varchar(255)     not null default '',
    # 影片类型英文名
    ename    varchar(255)     not null default '',

    primary key (vtype_id),
    index (cname),
    index (ename)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影奖项
create table award
(
    award_id smallint unsigned not null,
    # 奖项名称
    cname    varchar(255)      not null default '',

    primary key (award_id),
    index (cname)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影奖项类别 (最佳影片、最佳男主角...)
create table atype
(
    atype_id smallint unsigned not null,
    # 奖项类别名称
    cname    varchar(255)      not null default '',

    primary key (atype_id),
    index (cname)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影类型
create table mtype
(
    mtype_id smallint unsigned not null auto_increment,
    # 类型中文名
    cname    varchar(255)      not null default '',
    # 类型英文名
    ename    varchar(255)      not null default '',

    primary key (mtype_id),
    index (cname),
    index (ename)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影标签
create table mtag
(
    mtag_id int unsigned not null auto_increment,
    # 标签中文名
    cname   varchar(255) not null default '',
    # 标签英文名
    ename   varchar(255) not null default '',

    primary key (mtag_id),
    index (cname),
    index (ename)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影短评表
create table comment
(
    comment_id bigint unsigned not null,
    # 短评内容
    content    varchar(65535)  not null default '',
    # 短评日期
    date       date,
    # 投票数
    vote       smallint        not null default 0,

    primary key (comment_id),
    index (content(10)),
    index (date),
    index (vote)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影影评表
create table review
(
    review_id bigint unsigned not null,
    # 影评内容
    content   text,
    # 影评日期时间
    datetime  datetime,
    # 赞同数
    agree     smallint unsigned default 0,
    # 反对数
    against   smallint unsigned default 0,

    primary key (review_id),
    index (content(20)),
    index (datetime),
    index (agree),
    index (against)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.公共电影关系表---------------------------------------

# IMDB电影相关 ---------------------------------------------------------------------------------

# 1.IMDB电影基础表---------------------------------------

# IMDB电影表
create table imovie
(
    imovie_id bigint unsigned  not null,
    # 影片种类/类型 0-未知 (电影、电视剧、电视剧的单集...)
    vtype_id  tinyint unsigned not null default 0,

    primary key (imovie_id),
    foreign key (vtype_id) references vtype (vtype_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# IMDB电影详情表
create table imovie_detail
(
    imovie_id   bigint unsigned   not null,
    # IMDB电影发行年份 、 电视剧首集播放年份
    year        year,
    # 是否是成人电影 0-不是 1-是
    adult       tinyint(1)        not null default 0,
    # IMDB电影英文名
    ename       varchar(255)      not null default '',
    # IMDB电影原始名
    origin_name varchar(255)      not null default '',
    # IMDB电影片长
    runtime     smallint unsigned not null default 0,
    # IMDB电影IMDB评分
    rate        decimal(10, 2)    not null default 0.0,
    # IMDB电影IMDB评分人数
    rate_vote   int unsigned      not null default 0,

    primary key (imovie_id),
    index (year),
    index (adult),
    index (ename),
    index (origin_name),
    index (runtime),
    index (rate),
    index (rate_vote)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.IMDB电影关系表---------------------------------------

# IMDB电影-电影类型
create table imovie_mtype
(
    imovie_id bigint unsigned   not null,
    mtype_id  smallint unsigned not null auto_increment,

    primary key (imovie_id, mtype_id),
    foreign key (imovie_id) references imovie (imovie_id),
    foreign key (mtype_id) references mtype (mtype_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# IMDB电影-剧集
create table episode_imovie
(
    # 当前剧集ID
    episode_id  bigint unsigned  not null,
    # 当前剧集所属的电视剧ID
    imovie_id   bigint unsigned  not null,
    # 当前剧集所属季 1-默认第一季
    season_num  tinyint unsigned not null default 1,
    # 当前剧集所属集 1-默认第一集
    episode_num tinyint unsigned not null default 1,

    primary key (episode_id),
    foreign key (episode_id) references imovie (imovie_id),
    foreign key (imovie_id) references imovie (imovie_id),
    index (season_num),
    index (episode_num)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影相关 ---------------------------------------------------------------------------------

# 1.豆瓣电影基础表---------------------------------------

# 豆瓣电影表
create table dmovie
(
    dmovie_id bigint unsigned  not null,
    # 豆瓣电影的IMDB-ID
    imovie_id bigint unsigned  not null,
    # 豆瓣电影的类型ID
    vtype_id  tinyint unsigned not null,

    primary key (dmovie_id),
    foreign key (imovie_id) references imovie (imovie_id),
    foreign key (vtype_id) references vtype (vtype_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影详情表
create table dmovie_detail
(
    dmovie_id   bigint unsigned   not null,
    # 豆瓣电影中文名
    cname       varchar(255)      not null default '',
    # 豆瓣电影英文名
    ename       varchar(255)      not null default '',
    # 豆瓣电影其他文名
    oname       varchar(255)      not null default '',
    # 豆瓣电影别称 以/为间隔的字符串
    alias       varchar(65535)    not null default '',
    # 豆瓣电影评分 0.0 ~ 10.0
    rate        decimal(2, 1)     not null default 0.0,
    # 豆瓣电影评分人数
    rate_vote   int unsigned      not null default 0,
    # 豆瓣电影运行片长 分钟
    runtime     smallint unsigned not null default 0,
    # 豆瓣电视剧总集数 1-默认为一集（电影）
    episode_sum smallint unsigned not null default 1,

    primary key (dmovie_id),
    index (cname),
    index (ename),
    index (oname),
    index (alias),
    index (rate),
    index (rate_vote),
    index (runtime),
    index (episode_sum)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.豆瓣电影关系表---------------------------------------

# 豆瓣电影-电影类型
create table dmovie_mtype
(
    dmovie_id bigint unsigned   not null,
    mtype_id  smallint unsigned not null,

    primary key (dmovie_id, mtype_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    foreign key (mtype_id) references mtype (mtype_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-奖项
create table dmovie_award
(
    # 获奖豆瓣电影ID
    dmovie_id   bigint unsigned   not null,
    # 获奖奖项ID
    award_id    smallint unsigned not null,
    # 获奖奖项届数
    award_th    smallint unsigned not null default 0,
    # 获奖奖项类型ID
    atype_id    smallint unsigned not null,
    # 获奖豆瓣人物ID
    dpersion_id bigint unsigned   not null,

    # 获奖年份
    year        year,

    primary key (dmovie_id, award_id, award_th, atype_id, dpersion_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    foreign key (award_id) references award (award_id),
    foreign key (atype_id) references atype (atype_id),
    foreign key (dpersion_id) references dperson (dperson_id),
    index (award_th),
    index (year)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-制片地区
create table dmovie_darea
(
    dmovie_id bigint unsigned not null,
    # 豆瓣电影的制片地区
    darea_id  int unsigned    not null,
    # 豆瓣电影在当前地区的上映日期
    date      date,

    primary key (dmovie_id, darea_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    foreign key (darea_id) references darea (darea_id),
    index (date)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-电影标签
create table dmovie_mtag
(
    dmovie_id bigint unsigned not null,
    mtag_id   int unsigned    not null,

    primary key (dmovie_id, mtag_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    foreign key (mtag_id) references mtag (mtag_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-短评
create table dmovie_comment
(
    dmovie_id  bigint unsigned not null,
    comment_id bigint unsigned not null,

    primary key (dmovie_id, comment_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    foreign key (comment_id) references comment (comment_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-影评
create table dmovie_review
(
    dmovie_id bigint unsigned not null,
    review_id bigint unsigned not null,

    primary key (dmovie_id, review_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    foreign key (review_id) references review (review_id)
) ENGINE = InnoDB
  default charset = utf8mb4;


# 电影 end ========================================================================================


# 人物 start ========================================================================================

# 公共人物相关 ---------------------------------------------------------------------------------

# 1.公共人物基础表---------------------------------------

# 人物职业表
create table profession
(
    profession_id tinyint unsigned not null,
    # 职业中文名
    cname         varchar(255)     not null default '',
    # 职业英文名
    ename         varchar(255)     not null default '',

    primary key (profession_id),
    index (cname),
    index (ename)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.公共人物关系表---------------------------------------

# IMDB人物相关 ---------------------------------------------------------------------------------

# 1.IMDB人物基础表---------------------------------------

# IMDB人物表
create table iperson
(
    # nm+id,id至少7个数字（不够7个在id前面添0）
    iperson_id bigint unsigned not null,
    # 英文名
    ename      varchar(255)    not null default '',
    # 出生年份
    birth_year year,
    # 死亡年份
    death_year year,

    primary key (iperson_id),
    index (ename),
    index (birth_year),
    index (death_year)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.IMDB人物关系表---------------------------------------

# IMDB人物-职业
create table iperson_profession
(
    iperson_id    bigint unsigned not null,
    profession_id int unsigned    not null,

    primary key (iperson_id, profession_id),
    foreign key (iperson_id) references iperson (iperson_id),
    foreign key (profession_id) references profession (profession_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# IMDB电影-人物
create table imovie_ipersion
(
    imovie_id     bigint unsigned  not null,
    iperson_id    bigint unsigned  not null,
    # 该IMDB人物在该IMDB电影中的职位
    profession_id tinyint unsigned not null,

    primary key (imovie_id, iperson_id, profession_id),
    foreign key (imovie_id) references imovie (imovie_id),
    foreign key (iperson_id) references iperson (iperson_id),
    foreign key (profession_id) references profession (profession_id)
) ENGINE = InnoDB
  default charset = utf8mb4;


# 豆瓣人物相关 ---------------------------------------------------------------------------------

# 1.豆瓣人物基础表---------------------------------------

# 豆瓣人物表
create table dperson
(
    dperson_id bigint unsigned not null,
    # 演员 IMDB-ID
    iperson_id bigint unsigned not null,
    # 演员出生 国家
    country_id int unsigned    not null,
    # 演员出生 州/省
    state_id   int unsigned    not null,
    # 演员出生 城市
    cite_id    int unsigned    not null,

    primary key (dperson_id),
    foreign key (iperson_id) references iperson (iperson_id),
    foreign key (country_id) references country (country_id),
    foreign key (state_id) references state (state_id),
    foreign key (cite_id) references cite (cite_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣人物详情表
create table dperson_detail
(
    dperson_id  bigint unsigned not null,
    # 中文名
    cname       varchar(255)    not null default '',
    # 英文名
    ename       varchar(255)    not null default '',
    # 其他外文名
    oname       varchar(255)    not null default '',
    # 更多中文名 以 / 为间隔
    cname_more  varchar(65535)  not null default '',
    # 更多外文名 以 / 为间隔
    oname_more  varchar(65535)  not null default '',
    # 性别 0-女 1-男 2-其他
    sex         tinyint(1)      not null default 2,
    # 生日
    birthday    date,
    # 描述
    description varchar(65535)  not null default '',

    primary key (dperson_id),
    index (cname),
    index (ename),
    index (oname),
    index (cname_more),
    index (oname_more),
    index (sex),
    index (birthday),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.豆瓣人物关系表---------------------------------------

# 豆瓣人物-职业 (导演、编剧...)
create table dperson_profession
(
    dperson_id    bigint unsigned not null,
    profession_id int unsigned    not null,

    primary key (dperson_id, profession_id),
    foreign key (dperson_id) references dperson (dperson_id),
    foreign key (profession_id) references profession (profession_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣电影-人物
create table dmovie_dpersion
(
    dmovie_id     bigint unsigned not null,
    dpersion_id   bigint unsigned not null,
    # 该豆瓣人物在该豆瓣电影中的职位
    profession_id int unsigned    not null,

    primary key (dmovie_id, dpersion_id, profession_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    foreign key (dpersion_id) references dperson (dperson_id),
    foreign key (profession_id) references profession (profession_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 人物 end ========================================================================================


# 片场 start ========================================================================================

# 电影片场相关 ---------------------------------------------------------------------------------

# 1.电影片场基础表---------------------------------------

# 场景表
create table scene
(
    scene_id  bigint unsigned not null,
    # 场景对应的豆瓣电影ID
    dmovie_id bigint unsigned not null,
    # 场景对应的地点ID
    place_id  bigint unsigned not null,

    primary key (scene_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    foreign key (place_id) references place (place_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 场景详情表
create table scene_detail
(
    scene_id    bigint unsigned not null,
    # 场景发生在电影中的时间(秒)
    time        int unsigned    not null default 0,
    # 场景描述
    description varchar(65535)  not null default '',


    primary key (scene_id),
    index (description(10)),
    index (time)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.电影片场关系表---------------------------------------


# 片场 end ========================================================================================


# 资源 start ========================================================================================

# 电影正版资源相关 ---------------------------------------------------------------------------------

# 1.电影正版资源基础表---------------------------------------

# 正版网站表 (爱奇艺...)
create table lwebsite
(
    lwebsite_id tinyint unsigned not null,
    # 正版网站中文名
    cname       varchar(255)     not null default '',
    # 正版网站英文名
    ename       varchar(255)     not null default '',
    # 正版网站官网
    url         varchar(255)     not null default '',

    primary key (lwebsite_id),
    index (cname),
    index (ename),
    index (url)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 正版网站影片观看类型表 (vip免费播放...)
create table wtype
(
    wtype_id tinyint unsigned not null,
    # 正版网站影片观看类型中文名
    cname    varchar(255)     not null default '',

    primary key (wtype_id),
    index (cname)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.电影正版资源关系表---------------------------------------

# 豆瓣电影-正版网站
create table dmovie_lwebsite
(
    dmovie_id   bigint unsigned  not null,
    lwebsite_id tinyint unsigned not null,
    # 观看类型
    wtype_id    tinyint unsigned not null,
    # url跳转关键字
    keyword     varchar(65535)   not null default '',

    primary key (dmovie_id, lwebsite_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    foreign key (lwebsite_id) references lwebsite (lwebsite_id),
    foreign key (wtype_id) references wtype (wtype_id),
    index (keyword)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 电影盗版资源相关 ---------------------------------------------------------------------------------

# 1.电影盗版资源基础表---------------------------------------

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

# 2.电影盗版资源关系表---------------------------------------


# 图片资源相关 ---------------------------------------------------------------------------------

# 1.图片资源基础表---------------------------------------

# 图片类型表
create table itype
(
    itype_id tinyint unsigned not null,
    # 图片类型名称
    cname    varchar(255)     not null default '',
    # 图片来源 (url+image_id 即为图片地址)
    url      varchar(255)     not null default '',

    primary key (itype_id),
    index (cname),
    index (url)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 图片表
create table image
(
    image_id bigint unsigned  not null,
    # 图片的类型
    itype_id tinyint unsigned not null,

    primary key (image_id),
    foreign key (itype_id) references itype (itype_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 图片详情表
create table image_detail
(
    image_id    bigint unsigned not null,
    # 图片描述
    description varchar(255)    not null default '',
    # 图片大小 kb
    size        int unsigned    not null default 0,

    primary key (image_id),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;


# 2.图片资源关系表---------------------------------------


# 资源 end ========================================================================================


# 用户 start ========================================================================================

# 公共用户相关 ---------------------------------------------------------------------------------

# 1.公共用户基础表---------------------------------------

# 用户角色表
create table role
(
    role_id     tinyint unsigned not null auto_increment,
    # 角色名称
    cname       varchar(255)     not null default '',
    # 角色描述
    description varchar(255)     not null default '',

    primary key (role_id),
    index (cname),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 用户权限表
create table permission
(
    permission_id int unsigned not null auto_increment,
    # 权限名称
    cname         varchar(255) not null default '',
    # 权限路径
    url           varchar(255) not null,
    # 权限描述
    description   varchar(255) not null default '',

    primary key (permission_id),
    index (cname),
    unique (url),
    index (description(10))
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.公共用户关系表---------------------------------------

# 角色-权限
create table role_permission
(
    role_id       tinyint unsigned not null,
    permission_id int unsigned     not null,

    primary key (role_id, permission_id),
    foreign key (role_id) references role (role_id),
    foreign key (permission_id) references permission (permission_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣用户相关 ---------------------------------------------------------------------------------

# 1.豆瓣用户基础表---------------------------------------

# 豆瓣用户表
create table duser
(
    duser_id int unsigned not null,
    # 域名
    domain   varchar(20),
    # 名字
    cname    varchar(255) not null,
    # md5加密格式的密码
    password varchar(255) not null,
    # 注册手机号
    phone    varchar(255) not null default '',
    # 注册邮箱
    email    varchar(255) not null default '',

    primary key (duser_id),
    unique (domain),
    index (cname),
    index (password),
    unique (phone),
    unique (email)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 2.豆瓣用户关系表---------------------------------------

# 豆瓣用户-角色
create table duser_role
(
    duser_id int unsigned     not null,
    role_id  tinyint unsigned not null,

    primary key (duser_id, role_id),
    foreign key (duser_id) references duser (duser_id),
    foreign key (role_id) references role (role_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣用户-电影
create table duser_dmovie
(
    duser_id  int unsigned    not null,
    dmovie_id bigint unsigned not null,
    # 用户对电影的评分 0.0 ～ 10.0
    rate      decimal(2, 1)   not null default 0.0,
    # 标记用户是否想看 0-未标记 1-已想看
    wish      tinyint(1)      not null default 0,
    # 标记用户是否看过 0-未标记 1-已看过
    seen      tinyint(1)      not null default 0,

    primary key (duser_id, dmovie_id),
    foreign key (duser_id) references duser (duser_id),
    foreign key (dmovie_id) references dmovie (dmovie_id),
    index (rate)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 豆瓣用户-短评
create table duser_comment
(
    duser_id   int unsigned    not null,
    comment_id bigint unsigned not null,

    primary key (duser_id, comment_id),
    foreign key (duser_id) references duser (duser_id),
    foreign key (comment_id) references comment (comment_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 用户-影评
create table duser_review
(
    duser_id  int unsigned    not null,
    review_id bigint unsigned not null,

    primary key (duser_id, review_id),
    foreign key (duser_id) references duser (duser_id),
    foreign key (review_id) references review (review_id)
) ENGINE = InnoDB
  default charset = utf8mb4;

# 用户 end ========================================================================================








