/*
 imdb转化+1.0转化
 */

# imdb转化
# 参考 https://humingk.github.io/mysql-imdb/

# 豆瓣电影1.0中的movie表中的ID转换到2.0的movie_douban表中

# celebrity -> celebrity_imdb

update movie.celebrity_imdb i,douban_movie.actor d
set i.id_celebrity_douban=d.actor_id
where d.imdb_id != 0
  and d.imdb_id = i.id;

# celebrity -> celebrity_douban

insert ignore into movie.celebrity_douban(id, id_celebrity_imdb, name_zh)
select douban_movie.actor.actor_id, douban_movie.actor.imdb_id, douban_movie.actor.name
from douban_movie.actor
where douban_movie.actor.imdb_id != 0;

insert ignore into movie.celebrity_douban(id, id_celebrity_imdb, name_zh)
select douban_movie.actor.actor_id, 1, douban_movie.actor.name
from douban_movie.actor
where douban_movie.actor.imdb_id = 0;

# movie -> movie_imdb
...

 # movie -> movie_douban

 insert ignore into movie.celebrity_douban(id,id_celebrity_imdb,name_zh)
select douban_movie.actor.actor_id, douban_movie.actor.imdb_id, douban_movie.actor.name
from douban_movie.actor
where douban_movie.actor.imdb_id != 0;

insert ignore into movie.celebrity_douban(id, id_celebrity_imdb, name_zh)
select douban_movie.actor.actor_id, 1, douban_movie.actor.name
from douban_movie.actor
where douban_movie.actor.imdb_id = 0;
