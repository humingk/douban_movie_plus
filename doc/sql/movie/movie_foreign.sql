alter table movie_imdb
    add foreign key (id_movie_douban) references movie_douban (id);
alter table movie_imdb
    add foreign key (id_type_video) references type_video (id);
alter table movie_imdb_to_type_movie
    add foreign key (id_movie_imdb) references movie_imdb (id);
alter table movie_imdb_to_type_movie
    add foreign key (id_type_movie) references type_movie (id);
alter table movie_douban
    add foreign key (id_movie_imdb) references movie_imdb (id);
alter table movie_douban
    add foreign key (id_type_video) references type_video (id);
alter table alias_movie_douban
    add foreign key (id_movie_douban) references movie_douban (id);
alter table trailer_movie_douban
    add foreign key (id_movie_douban) references movie_douban (id);
alter table classic_douban
    add foreign key (id_movie_douban) references movie_douban (id);
alter table comment_movie_douban
    add foreign key (id_movie_douban) references movie_douban (id);
alter table comment_movie_douban
    add foreign key (id_user_douban) references user_douban (id);
alter table rate_movie_douban
    add foreign key (id) references movie_douban (id);
alter table movie_douban_to_type_movie
    add foreign key (id_movie_douban) references movie_douban (id);
alter table movie_douban_to_type_movie
    add foreign key (id_type_movie) references type_movie (id);
alter table movie_douban_to_award_movie
    add foreign key (id_movie_douban) references movie_douban (id);
alter table movie_douban_to_award_movie
    add foreign key (id_award_movie) references award_movie (id);
alter table movie_douban_to_award_movie
    add foreign key (id_celebrity_douban) references celebrity_douban (id);
alter table tag_movie
    add foreign key (id_movie_douban) references movie_douban (id);
alter table movie_douban_to_review_movie_douban
    add foreign key (id_movie_douban) references movie_douban (id);
alter table movie_douban_to_review_movie_douban
    add foreign key (id_review_movie_douban) references review_movie_douban (id);
alter table rate_imdb
    add foreign key (id) references movie_imdb (id);
alter table movie_imdb_to_celebrity_imdb
    add foreign key (id_movie_imdb) references movie_imdb (id);
alter table movie_imdb_to_celebrity_imdb
    add foreign key (id_celebrity_imdb) references celebrity_imdb (id);
alter table movie_imdb_to_celebrity_imdb
    add foreign key (id_profession) references profession (id);

alter table celebrity_imdb
    add foreign key (id_celebrity_douban) references celebrity_douban (id);
alter table celebrity_douban
    add foreign key (id_celebrity_imdb) references celebrity_imdb (id);
alter table alias_celebrity_douban
    add foreign key (id_celebrity_douban) references celebrity_douban (id);
alter table movie_douban_to_celebrity_douban
    add foreign key (id_movie_douban) references movie_douban (id);
alter table movie_douban_to_celebrity_douban
    add foreign key (id_celebrity_douban) references celebrity_douban (id);
alter table movie_douban_to_celebrity_douban
    add foreign key (id_profession) references profession (id);
alter table celebrity_douban_to_classic
    add foreign key (id_celebrity_douban) references celebrity_douban (id);
alter table celebrity_douban_to_classic
    add foreign key (id_classic_douban) references classic_douban (id);
alter table movie_scene
    add foreign key (id_movie_douban) references movie_douban (id);
alter table celebrity_scene
    add foreign key (id_celebrity_douban) references celebrity_douban (id);
alter table scene
    add foreign key (id_movie_scene) references movie_scene (id);
alter table scene
    add foreign key (id_place_scene) references place_scene (id);
alter table scene_detail
    add foreign key (id_movie_scene) references movie_scene (id);
alter table scene_detail
    add foreign key (id_scene) references scene (id);
alter table user_to_role
    add foreign key (id_user) references user (id);
alter table user_to_role
    add foreign key (id_role) references role (id);
alter table movie_scene_to_celebrity_scene
    add foreign key (id_movie_scene) references movie_scene (id);
alter table movie_scene_to_celebrity_scene
    add foreign key (id_celebrity_scene) references celebrity_scene (id);
alter table scene_detail_to_celebrity_scene
    add foreign key (id_scene_detail) references scene_detail (id);
alter table scene_detail_to_celebrity_scene
    add foreign key (id_celebrity_scene) references celebrity_scene (id);

alter table user_to_role
    add foreign key (id_user) references user (id);
alter table user_to_role
    add foreign key (id_role) references role (id);
alter table role_to_permission
    add foreign key (id_role) references role (id);
alter table role_to_permission
    add foreign key (id_permission) references permission (id);
alter table user
    add foreign key (id) references user_douban (id);


alter table user_douban_to_movie_douban
    add foreign key (id_user_douban) references user_douban (id);
alter table user_douban_to_movie_douban
    add foreign key (id_movie_douban) references movie_douban (id);
alter table user_douban_to_review_movie_douban
    add foreign key (id_user_douban) references user_douban (id);
alter table user_douban_to_review_movie_douban
    add foreign key (id_review_movie_douban) references review_movie_douban (id);
alter table user_douban_to_classic_douban
    add foreign key (id_user_douban) references user_douban (id);
alter table user_douban_to_classic_douban
    add foreign key (id_classic_douban) references classic_douban (id);

alter table resource_movie
    add foreign key (id_movie_douban) references movie_douban (id);
alter table resource_movie
    add foreign key (id_website_resource) references website_resource (id);
alter table resource_movie
    add foreign key (id_type_resource) references type_resource (id);
alter table resource_movie
    add foreign key (id_movie_imdb) references movie_imdb (id);


alter table image_celebrity_douban
    add foreign key (id_celebrity_douban) references celebrity_douban (id);
alter table image_movie_douban
    add foreign key (id_movie_douban) references movie_douban (id);
alter table image_place_scene
    add foreign key (id_place_scene) references place_scene (id);
alter table image_scene_detail
    add foreign key (id_scene_detail) references scene_detail (id);

alter table place_scene_to_type_place_scene
    add foreign key (id_place_scene) references place_scene (id);
alter table place_scene_to_type_place_scene
    add foreign key (id_type_place_scene) references type_place_scene (id);
alter table place_scene
    add foreign key (id_continent_scene) references continent_scene (id);
alter table place_scene
    add foreign key (id_country_scene) references country_scene (id);
alter table place_scene
    add foreign key (id_state_scene) references state_scene (id);
alter table place_scene
    add foreign key (id_city_scene) references city_scene (id);

alter table movie_netease
    add foreign key (id_movie_douban) references movie_douban (id);
alter table song_netease
    add foreign key (id) references movie_netease (id_netease);
alter table album_netease
    add foreign key (id) references movie_netease (id_netease);
alter table playlist_netease
    add foreign key (id) references movie_netease (id_netease);
alter table comment_netease
    add foreign key (id_song_netease) references song_netease (id);
alter table comment_netease
    add foreign key (id_user_netease) REFERENCES user_netease (id);
alter table song_netease_to_playlist_netease
    add foreign key (id_song_netease) references song_netease (id);
alter table song_netease_to_playlist_netease
    add foreign key (id_playlist_netease) references playlist_netease (id);
alter table song_netease_to_album_netease
    add foreign key (id_song_netease) references song_netease (id);
alter table song_netease_to_album_netease
    add foreign key (id_album_netease) references album_netease (id);
alter table artist_netease_to_album_netease
    add foreign key (id_album_netease) references album_netease (id);
alter table artist_netease_to_album_netease
    add foreign key (id_artist_netease) references artist_netease (id);
alter table artist_netease_to_song_netease
    add foreign key (id_song_netease) references song_netease (id);
alter table artist_netease_to_song_netease
    add foreign key (id_artist_netease) references artist_netease (id);
alter table movie_zhihu
    add foreign key (id_movie_douban) references movie_douban (id);
alter table question_zhihu
    add foreign key (id_movie_douban) references movie_douban (id);
