# 创建测试专用数据库
# 1. 通过movie_structure.sql（更名）创建movie_test库
# 2. 执行以下SQL
# 3. 导出movie_test库（更名）

# 测试电影个数
set @num = 250;

use movie_test;

# movie douban
prepare movie_douban from
    '
    insert ignore into movie_douban
    select *
    from movie.movie_douban
    where id in (select t.id from (select id from movie.movie_douban order by have_seen desc limit ?) as t);
    ';
execute movie_douban using @num;

insert ignore into alias_movie_douban
select *
from movie.alias_movie_douban
where id_movie_douban in (select id from movie_douban);

insert ignore into movie_douban_to_award_movie
select *
from movie.movie_douban_to_award_movie
where id_movie_douban in (select id from movie_douban);

insert ignore into award_movie
select *
from movie.award_movie
where id in (select id_award_movie from movie_douban_to_award_movie);

insert ignore into comment_movie_douban
select *
from movie.comment_movie_douban
where id_movie_douban in (select id from movie_douban);

insert ignore into image_movie_douban
select *
from movie.image_movie_douban
where id_movie_douban in (select id from movie_douban);

insert ignore into movie_douban_to_review_movie_douban
select *
from movie.movie_douban_to_review_movie_douban
where id_movie_douban in (select id from movie_douban);

insert ignore into review_movie_douban
select *
from movie.review_movie_douban
where id in (select id_review_movie_douban from movie_douban_to_review_movie_douban);

insert ignore into movie_douban_to_type_movie
select *
from movie.movie_douban_to_type_movie
where id_movie_douban in (select id from movie_douban);

insert ignore into type_movie
select *
from movie.type_movie
where id in (select id_type_movie from movie_douban_to_type_movie);

insert ignore into rate_movie_douban
select *
from movie.rate_movie_douban
where id in (select id from movie_douban);

insert ignore into tag_movie
select *
from movie.tag_movie
where id_movie_douban in (select id from movie_douban);

insert ignore into trailer_movie_douban
select *
from movie.trailer_movie_douban
where id_movie_douban in (select id from movie_douban);

# celebrity douban
insert ignore into movie_douban_to_celebrity_douban
select *
from movie.movie_douban_to_celebrity_douban
where id_movie_douban in (select id from movie_douban);

insert ignore into celebrity_douban
select *
from movie.celebrity_douban
where id in (
    select id_celebrity_douban
    from movie_douban_to_celebrity_douban
);

insert ignore into alias_celebrity_douban
select *
from movie.alias_celebrity_douban
where id_celebrity_douban in (select id from celebrity_douban);

insert ignore into image_celebrity_douban
select *
from movie.image_celebrity_douban
where id_celebrity_douban in (select id from celebrity_douban);

insert ignore into celebrity_douban_to_classic_douban
select *
from movie.celebrity_douban_to_classic_douban;

insert ignore into classic_douban
select *
from movie.classic_douban;

# movie imdb

insert ignore into movie_imdb
select *
from movie.movie_imdb
where id in (select id_movie_imdb from movie_douban);

insert ignore into rate_imdb
select *
from movie.rate_imdb
where id in (select id from movie_imdb);

insert ignore into movie_imdb_to_type_movie
select *
from movie.movie_imdb_to_type_movie;

insert ignore into type_video
select *
from movie.type_video;

# celebrity imdb

insert ignore into movie_imdb_to_celebrity_imdb
select *
from movie.movie_imdb_to_celebrity_imdb
where id_movie_imdb in (select id from movie_imdb);

insert ignore into celebrity_imdb
select *
from movie.celebrity_imdb
where id in (select id_celebrity_imdb from movie_imdb_to_celebrity_imdb);

insert ignore into profession
select *
from movie.profession;

# zhihu movie

insert ignore into movie_zhihu
select *
from movie.movie_zhihu
where id_movie_douban in (select id from movie_douban);

insert ignore into question_zhihu
select *
from movie.question_zhihu
where id_movie_douban in (select id from movie_douban);

# resource movie

# insert ignore into type_resource
# select *
# from movie.type_resource;
#
# insert ignore into website_resource
# select *
# from movie.website_resource;
#
# insert ignore into resource_movie
# select *
# from movie.resource_movie
# where id_movie_douban in (select id from movie_douban);

# scene movie

insert ignore into movie_scene
select *
from movie.movie_scene
where id_movie_douban in (select id from movie_douban);

insert ignore into scene_detail
select *
from movie.scene_detail
where id_movie_scene in (select id from movie_scene);

insert ignore into scene
select *
from movie.scene
where id_movie_scene in (select id from movie_scene);

insert ignore into image_scene_detail
select *
from movie.image_scene_detail
where id_scene_detail in (select id from scene_detail);

# scene celebrity

insert ignore into scene_detail_to_celebrity_scene
select *
from movie.scene_detail_to_celebrity_scene
where id_scene_detail in (select id from scene_detail);

insert ignore into movie_scene_to_celebrity_scene
select *
from movie.movie_scene_to_celebrity_scene
where id_movie_scene in (select id from movie_scene);

insert ignore into celebrity_scene
select *
from movie.celebrity_scene
where id in (select id_celebrity_scene from movie_scene_to_celebrity_scene)
   or id in (select id_celebrity_scene from scene_detail_to_celebrity_scene);

# scene place
insert ignore into place_scene
select *
from movie.place_scene
where id in (select id_place_scene from scene);

insert ignore into type_place_scene
select *
from movie.type_place_scene;

insert ignore into continent_scene
select *
from movie.continent_scene
where id in (select id_continent_scene from place_scene);

insert ignore into country_scene
select *
from movie.country_scene
where id in (select id_country_scene from place_scene);

insert ignore into city_scene
select *
from movie.city_scene
where id in (select id_city_scene from place_scene);

insert ignore into state_scene
select *
from movie.state_scene
where id in (select id_state_scene from place_scene);

insert ignore into image_place_scene
select *
from movie.image_place_scene
where id in (select id from place_scene);

insert ignore into place_scene_to_type_place_scene
select *
from movie.place_scene_to_type_place_scene
where id_place_scene in (select id from place_scene);

# user douban

insert ignore into user_douban_to_classic_douban
select *
from movie.user_douban_to_classic_douban;

insert ignore into user_douban_to_review_movie_douban
select *
from movie.user_douban_to_review_movie_douban
where id_review_movie_douban in (select id from review_movie_douban);

insert ignore into user_douban_to_movie_douban
select *
from movie.user_douban_to_movie_douban
where id_movie_douban in (select id from movie_douban);

insert ignore into user_douban
select *
from movie.user_douban
where id in (select id_user_douban from user_douban_to_classic_douban)
   or id in (select id_user_douban from user_douban_to_movie_douban)
   or id in (select id_user_douban from user_douban_to_review_movie_douban);

# user

insert ignore into user
select *
from movie.user;

insert ignore into role
select *
from movie.role;

insert ignore into permission
select *
from permission;

insert ignore into user_to_role
select *
from movie.user_to_role;

insert ignore into role_to_permission
select *
from movie.role_to_permission;

# 其他

insert ignore into message
select *
from movie.message;

