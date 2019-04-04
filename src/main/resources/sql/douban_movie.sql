/*
豆瓣电影数据库结构

author:	humingk

*/
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
  index douban_rate (douban_rate),
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
  tag_id    int      NOT NULL auto_increment,
  type_name char(10) NOT NULL DEFAULT '',
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
/**
# 重置自增ID
alter TABLE user auto_increment =1;
alter TABLE role auto_increment =1;
alter TABLE permission auto_increment =1;
alter TABLE comment auto_increment =1;
alter TABLE review auto_increment =1;


# user:
INSERT INTO user(user_id,email,password,name,label,phone) VALUES(1,"hukk@qq.com","1233","小明也来过","humingk","15612331233");
INSERT INTO user(user_id,email,password,name,label,phone) VALUES(2,"kk@qq.com","1233","大明","kk","15612331233");

# role:
insert into role(role_id,name,description) values(1,"admin","管理员用户");
insert into role(role_id,name,description) values(2,"user","普通注册用户");

# user_role:
insert into user_role(user_id,role_id) values(1,1);
insert into user_role(user_id,role_id) values(1,2);
insert into user_role(user_id,role_id) values(2,2);

# permission:
insert into permission(permission_id, url,description) values(1,"/admin/**","管理员页面");
insert into permission(permission_id, url,description) values(2,"/people/**","访问个人主页");


# role_permission:
insert into role_permission(role_id,permission_id) values(1,1);
insert into role_permission(role_id,permission_id) values(1,2);
insert into role_permission(role_id,permission_id) values(2,2);


 */


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
  wish     tinyint(1)  NOT NULL DEFAULT false,
  sean     tinyint(1)  NOT NULL DEFAULT false,
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
# 盗版资源
/*
根据电影名+导演名可以精确定位豆瓣电影ID
eg：

select movie.* from movie
inner join movie_director
on movie.movie_id = movie_director.movie_id
inner join actor
on movie_director.director_id=actor.actor_id
where movie.name like "%间谍%" and actor.name like "%seung%";

 */
/*
quality:
  0 未知

 */
create table resource
(
  resource_id   int          NOT NULL auto_increment,
  name          char(50),
  quality       int          NOT NULL DEFAULT 0,
  content       varchar(100) NOT NULL,
  url           char(10)     NOT NULL DEFAULT '',
  movie_name    char(50)     NOT NULL DEFAULT '',
  director_name char(30)     NOT NULL DEFAULT '',
  primary key (resource_id),
  unique (url),
  unique (content),
  index (movie_name),
  index (director_name)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;


create table movie_resource
(
  movie_id    int      NOT NULL,
  resource_id int(100) NOT NULL,
  primary key (movie_id, resource_id),
  foreign key (movie_id) references movie (movie_id),
  foreign key (resource_id) references resource (resource_id)
) ENGINE = InnoDB
  DEFAULT charset = utf8mb4;

