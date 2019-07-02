#
# 豆瓣电影数据库结构
#
# author:	humingk

# 电影库结构
drop database if exists douban_movie;
create database douban_movie;
use douban_movie;

create table movie
(
    movie_id int          NOT NULL,
    name     char(50)     NOT NULL DEFAULT '',
    rate     float(2, 1)  NOT NULL DEFAULT 0.0,
    imdb_id  char(10)     NOT NULL DEFAULT '',
    alias    varchar(200) NOT NULL DEFAULT '',
    index name (name),
    index douban_rate (rate),
    index alias (alias),
    primary key (movie_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table type
(
    type_id   int     NOT NULL auto_increment,
    type_name char(5) NOT NULL DEFAULT '',
    primary key (type_id),
    index type_name (type_name)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table tag
(
    tag_id   int      NOT NULL auto_increment,
    tag_name char(10) NOT NULL DEFAULT '',
    primary key (tag_id),
    index tag_name (tag_name)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table releasetime
(
    releasetime_id int      NOT NULL auto_increment,
    movie_id       int      NOT NULL,
    time_area      char(20) NOT NULL DEFAULT '',
    index time_area (time_area),
    primary key (releasetime_id),
    foreign key (movie_id) references movie (movie_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table releasetime
(
    releasetime_id int      NOT NULL auto_increment,
    time_area      char(20) NOT NULL DEFAULT '',
    index time_area (time_area),
    primary key (releasetime_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table actor
(
    actor_id   int          NOT NULL,
    name       char(30)     NOT NULL DEFAULT '',
    sex        char(2)      NOT NULL DEFAULT '',
    homeplace  char(20)     NOT NULL DEFAULT '',
    birthday   char(10)     NOT NULL DEFAULT '',
    occupation char(20)     NOT NULL DEFAULT '',
    alias      varchar(200) NOT NULL DEFAULT '',
    imdb_id    char(15)     NOT NULL DEFAULT '',
    index name (name),
    index alias (alias),
    primary key (actor_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table movie_type
(
    type_id  int NOT NULL auto_increment,
    movie_id int NOT NULL,
    primary key (type_id, movie_id),
    foreign key (movie_id) references movie (movie_id),
    foreign key (type_id) references type (type_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;


create table movie_tag
(
    tag_id   int NOT NULL auto_increment,
    movie_id int NOT NULL,
    primary key (tag_id, movie_id),
    foreign key (movie_id) references movie (movie_id),
    foreign key (tag_id) references tag (tag_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table movie_releasetime
(
    movie_id       int NOT NULL,
    releasetime_id int NOT NULL,
    primary key (movie_id, releasetime_id),
    foreign key (movie_id) references movie (movie_id),
    foreign key (releasetime_id) references releasetime (releasetime_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb;

create table movie_director
(
    movie_id    int NOT NULL,
    director_id int NOT NULL,
    primary key (movie_id, director_id),
    foreign key (movie_id) references movie (movie_id),
    foreign key (director_id) references actor (actor_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table movie_writer
(
    movie_id  int NOT NULL,
    writer_id int NOT NULL,
    primary key (movie_id, writer_id),
    foreign key (movie_id) references movie (movie_id),
    foreign key (writer_id) references actor (actor_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table movie_leadingactor
(
    movie_id        int NOT NULL,
    leadingactor_id int NOT NULL,
    primary key (movie_id, leadingactor_id),
    foreign key (movie_id) references movie (movie_id),
    foreign key (leadingactor_id) references actor (actor_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

# 用户结构

create table user
(
    user_id  int       NOT NULL auto_increment,
    label    char(10)  NOT NULL DEFAULT '',
    name     char(50)  NOT NULL DEFAULT '',
    password char(100) NOT NULL DEFAULT '',
    phone    char(15)  NOT NULL DEFAULT '',
    email    char(20)  NOT NULL DEFAULT '',
    primary key (user_id),
    unique (label),
    unique (email),
    index (label),
    index (password),
    index (name),
    index (phone),
    index (email)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

# shiro
create table role
(
    role_id     int          NOT NULL auto_increment,
    name        char(10)     NOT NULL DEFAULT '',
    description varchar(100) NOT NULL DEFAULT '',
    primary key (role_id),
    index (name),
    index (description)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table user_role
(
    user_id int NOT NULL,
    role_id int NOT NULL,
    primary key (user_id, role_id),
    foreign key (user_id) references user (user_id),
    foreign key (role_id) references role (role_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table permission
(
    permission_id int         NOT NULL auto_increment,
    url           char(30)    NOT NULL DEFAULT '',
    description   varchar(50) NOT NULL DEFAULT '',
    primary key (permission_id),
    index (url),
    index (description)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table role_permission
(
    role_id       int NOT NULL,
    permission_id int NOT NULL,
    primary key (role_id, permission_id),
    foreign key (role_id) references role (role_id),
    foreign key (permission_id) references permission (permission_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;


create table user_movie
(
    user_id  int         NOT NULL,
    movie_id int         NOT NULL,
    rate     float(2, 1) NOT NULL DEFAULT 0.0,
    wish     int(1)      NOT NULL DEFAULT 0,
    seen     int(1)      NOT NULL DEFAULT 0,
    primary key (user_id, movie_id),
    foreign key (user_id) references user (user_id),
    foreign key (movie_id) references movie (movie_id),
    index (rate)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

# 评论结构

create table comment
(
    comment_id int          NOT NULL auto_increment,
    comments   varchar(255) NOT NULL DEFAULT '',
    primary key (comment_id),
    index (comments)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table user_comment
(
    user_id    int NOT NULL,
    comment_id int NOT NULL,
    primary key (user_id, comment_id),
    foreign key (user_id) references user (user_id),
    foreign key (comment_id) references comment (comment_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table movie_comment
(
    movie_id   int NOT NULL,
    comment_id int NOT NULL,
    primary key (movie_id, comment_id),
    foreign key (movie_id) references movie (movie_id),
    foreign key (comment_id) references comment (comment_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table review
(
    review_id int         NOT NULL auto_increment,
    rate      float(2, 1) NOT NULL DEFAULT 0.0,
    reviews   text(1000)  NOT NULL,
    primary key (review_id),
    index (rate),
    index (reviews(20))
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table user_review
(
    user_id   int NOT NULL,
    review_id int NOT NULL,
    primary key (user_id, review_id),
    foreign key (user_id) references user (user_id),
    foreign key (review_id) references review (review_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

create table movie_review
(
    movie_id  int NOT NULL,
    review_id int NOT NULL,
    primary key (movie_id, review_id),
    foreign key (movie_id) references movie (movie_id),
    foreign key (review_id) references review (review_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

# 资源信息 ---------------------------

# 关键字列表
/*
 moviemap_flag 是否搜索过电影表列表 0 没有 1 有
 resourcelist_flag 是否搜索过电影资源 0 没有 1 有
 */
create table keyword
(
    keyword       char(50) NOT NULL,
    search_flag   int(1)   NOT NULL default 0,
    resource_flag int(1)   NOT NULL default 0,
    primary key (keyword),
    index moviemap_flag (search_flag),
    index resourcelist_flag (resource_flag)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

# 电影搜索列表
create table search
(
    movie_url   varchar(500) NOT NULL,
    keyword     char(50)     NOT NULL,
    movie_name  varchar(500) NOT NULL default '',
    client_type int(3)       NOT NULL default 0,
    primary key (movie_url, keyword),
    foreign key (keyword) references keyword (keyword),
    index movie_name (movie_name),
    index client_type (client_type)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

# 资源列表
create table resource
(
    resource_url  varchar(500) NOT NULL,
    keyword       char(50)     NOT NULL,
    resource_name varchar(200) NOT NULL default '',
    resource_type int(3)       NOT NULL default 0,
    client_type   int(3)       NOT NULL default 0,
    primary key (resource_url, keyword),
    foreign key (keyword) references keyword (keyword),
    index resource_name (resource_name),
    index resource_type (resource_type),
    index client_type (client_type)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;
