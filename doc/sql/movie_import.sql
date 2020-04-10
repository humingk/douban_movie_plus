-- MySQL dump 10.13  Distrib 8.0.19, for Linux (x86_64)
--
-- Host: localhost    Database: movie
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Current Database: `movie`
--

CREATE DATABASE /*!32312 IF NOT EXISTS */ `movie` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `movie`;

--
-- Table structure for table `album_netease`
--

DROP TABLE IF EXISTS `album_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album_netease`
(
    `id`        bigint unsigned   NOT NULL COMMENT '网易云音乐专辑ID',
    `name_zh`   varchar(255)      NOT NULL DEFAULT '' COMMENT '专辑中文名',
    `total`     smallint unsigned NOT NULL DEFAULT '0' COMMENT '专辑歌曲总数',
    `url_cover` varchar(1000)     NOT NULL DEFAULT '' COMMENT '封面照片链接',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`),
    KEY `total` (`total`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐专辑';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `alias_celebrity_douban`
--

DROP TABLE IF EXISTS `alias_celebrity_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alias_celebrity_douban`
(
    `id_celebrity_douban` bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣影人ID',
    `name_alias`          varchar(255)    NOT NULL DEFAULT '' COMMENT '豆瓣影人别称',
    `is_nikename`         tinyint         NOT NULL DEFAULT '0' COMMENT '是否为昵称 0-本名 1-昵称',
    PRIMARY KEY (`id_celebrity_douban`, `name_alias`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='影人别名';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `alias_movie_douban`
--

DROP TABLE IF EXISTS `alias_movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alias_movie_douban`
(
    `id_movie_douban` bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `name_alias`      varchar(255)    NOT NULL DEFAULT '' COMMENT '电影别名',
    PRIMARY KEY (`id_movie_douban`, `name_alias`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影别名';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `artist_netease`
--

DROP TABLE IF EXISTS `artist_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist_netease`
(
    `id`           bigint unsigned NOT NULL COMMENT '网易云音乐歌手ID',
    `name_zh`      varchar(255)    NOT NULL DEFAULT '' COMMENT '歌手中文名',
    `url_portrait` varchar(1000)   NOT NULL DEFAULT '' COMMENT '歌手照片链接',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐歌手';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `artist_netease_to_album_netease`
--

DROP TABLE IF EXISTS `artist_netease_to_album_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist_netease_to_album_netease`
(
    `id_artist_netease` bigint unsigned NOT NULL COMMENT '网易云音乐歌手ID',
    `id_album_netease`  bigint unsigned NOT NULL COMMENT '网易云音乐专辑ID',
    PRIMARY KEY (`id_artist_netease`, `id_album_netease`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐歌手-专辑';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `artist_netease_to_song_netease`
--

DROP TABLE IF EXISTS `artist_netease_to_song_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist_netease_to_song_netease`
(
    `id_artist_netease` bigint unsigned NOT NULL COMMENT '网易云音乐歌手ID',
    `id_song_netease`   bigint unsigned NOT NULL COMMENT '网易云音乐歌曲ID',
    PRIMARY KEY (`id_artist_netease`, `id_song_netease`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐歌手-歌曲';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `award_movie`
--

DROP TABLE IF EXISTS `award_movie`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `award_movie`
(
    `id`      varchar(255) NOT NULL COMMENT '电影奖项ID',
    `name_zh` varchar(255) NOT NULL DEFAULT '' COMMENT '电影奖项中文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影奖项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `celebrity_douban`
--

DROP TABLE IF EXISTS `celebrity_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `celebrity_douban`
(
    `id`                bigint unsigned NOT NULL COMMENT '豆瓣影人ID',
    `id_celebrity_imdb` bigint unsigned NOT NULL DEFAULT '0' COMMENT 'IMDB影人ID 0-未匹配 1-已匹配',
    `name_zh`           varchar(255)    NOT NULL DEFAULT '' COMMENT '豆瓣影人中文名',
    `name_origin`       varchar(255)    NOT NULL DEFAULT '' COMMENT '豆瓣影人英文名',
    `sex`               tinyint         NOT NULL DEFAULT '2' COMMENT '性别 0-女 1-男 2-未知',
    `birth_date`        bigint          NOT NULL DEFAULT '0' COMMENT '生日日期 /unix',
    `url_portrait`      bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣影人海报ID',
    `summary`           text COMMENT '影人简介',
    PRIMARY KEY (`id`),
    KEY `id_celebrity_imdb` (`id_celebrity_imdb`),
    KEY `name_zh` (`name_zh`),
    KEY `name_origin` (`name_origin`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣影人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `celebrity_douban_to_classic_douban`
--

DROP TABLE IF EXISTS `celebrity_douban_to_classic_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `celebrity_douban_to_classic_douban`
(
    `id_celebrity_douban`      bigint unsigned NOT NULL COMMENT '豆瓣影人ID',
    `id_classic_douban`        varchar(255)    NOT NULL COMMENT '豆瓣电影经典台词ID',
    `name_zh_celebrity_douban` varchar(255)    NOT NULL DEFAULT '' COMMENT '豆瓣影人中文名',
    PRIMARY KEY (`id_celebrity_douban`, `id_classic_douban`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影经典台词-影人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `celebrity_imdb`
--

DROP TABLE IF EXISTS `celebrity_imdb`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `celebrity_imdb`
(
    `id`                  bigint unsigned   NOT NULL COMMENT 'IMDB影人ID nm++00xxx(7)',
    `name_en`             varchar(255)      NOT NULL DEFAULT '' COMMENT 'IMDB影人英文名',
    `birth_year`          smallint unsigned NOT NULL DEFAULT '0' COMMENT '出生年份 /year',
    `id_celebrity_douban` bigint unsigned   NOT NULL DEFAULT '0' COMMENT '豆瓣影人ID 0-未匹配 1-已匹配',
    PRIMARY KEY (`id`),
    KEY `name_en` (`name_en`),
    KEY `id_celebrity_douban` (`id_celebrity_douban`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='IMDB影人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `celebrity_scene`
--

DROP TABLE IF EXISTS `celebrity_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `celebrity_scene`
(
    `id`                  bigint unsigned NOT NULL COMMENT '场景影人ID',
    `id_celebrity_douban` bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣影人ID 0-未匹配 1-已匹配',
    `name_zh`             varchar(255)    NOT NULL DEFAULT '' COMMENT '场景影人中文名',
    `name_en`             varchar(255)    NOT NULL DEFAULT '' COMMENT '场景影人英文名',
    PRIMARY KEY (`id`),
    KEY `id_celebrity_douban` (`id_celebrity_douban`),
    KEY `name_zh` (`name_zh`),
    KEY `name_en` (`name_en`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景影人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `city_scene`
--

DROP TABLE IF EXISTS `city_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city_scene`
(
    `id`      int unsigned NOT NULL COMMENT '城市ID',
    `name_zh` varchar(255) NOT NULL DEFAULT '' COMMENT '城市中文名',
    `name_en` varchar(255) NOT NULL DEFAULT '' COMMENT '城市英文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`),
    KEY `name_en` (`name_en`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='城市';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `classic_douban`
--

DROP TABLE IF EXISTS `classic_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classic_douban`
(
    `id`              varchar(255)    NOT NULL COMMENT '豆瓣电影经典台词ID',
    `id_movie_douban` bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `content`         varchar(1000)   NOT NULL DEFAULT '' COMMENT '经典台词内容',
    `happen_time`     int unsigned    NOT NULL DEFAULT '0' COMMENT '经典台词在影片中的出现时间 /m',
    `agree_vote`      int unsigned    NOT NULL DEFAULT '0' COMMENT '经典台词获得的赞同数',
    PRIMARY KEY (`id`),
    KEY `id_movie_douban` (`id_movie_douban`),
    KEY `content` (`content`(20)),
    KEY `happen_time` (`happen_time`),
    KEY `agree_vote` (`agree_vote` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影经典台词';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment_movie_douban`
--

DROP TABLE IF EXISTS `comment_movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_movie_douban`
(
    `id_movie_douban` bigint unsigned NOT NULL COMMENT '豆瓣电影ID',
    `id_user_douban`  varchar(255)    NOT NULL COMMENT '豆瓣用户ID',
    `agree_vote`      smallint        NOT NULL DEFAULT '0' COMMENT '投票数',
    `create_date`     bigint          NOT NULL DEFAULT '0' COMMENT '短评日期 /unix',
    `content`         varchar(1000)   NOT NULL DEFAULT '' COMMENT '短评内容',
    PRIMARY KEY (`id_movie_douban`, `id_user_douban`),
    KEY `agree_vote` (`agree_vote` DESC),
    KEY `create_date` (`create_date` DESC),
    KEY `content` (`content`(20))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影短评';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment_netease`
--

DROP TABLE IF EXISTS `comment_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_netease`
(
    `id`              bigint unsigned NOT NULL DEFAULT '0' COMMENT '网易云音乐专辑热门评论ID 0-暂无评论',
    `id_song_netease` bigint unsigned NOT NULL DEFAULT '0' COMMENT '歌曲ID',
    `id_user_netease` bigint unsigned NOT NULL DEFAULT '0' COMMENT '网易云音乐用户ID',
    `create_datetime` bigint          NOT NULL DEFAULT '0' COMMENT '创建时间 /unix',
    `content`         varchar(1000)   NOT NULL DEFAULT '' COMMENT '评论内容',
    `agree_vote`      int unsigned    NOT NULL DEFAULT '0' COMMENT '赞同数',
    PRIMARY KEY (`id_song_netease`, `id`),
    KEY `id_user_netease` (`id_user_netease`),
    KEY `create_datetime` (`create_datetime` DESC),
    KEY `agree_vote` (`agree_vote` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐专辑热门评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `continent_scene`
--

DROP TABLE IF EXISTS `continent_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `continent_scene`
(
    `id`      tinyint unsigned NOT NULL COMMENT '洲ID',
    `name_zh` varchar(255)     NOT NULL DEFAULT '' COMMENT '洲中文名',
    `name_en` varchar(255)     NOT NULL DEFAULT '' COMMENT '洲英文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`),
    KEY `name_en` (`name_en`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='洲';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `country_scene`
--

DROP TABLE IF EXISTS `country_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country_scene`
(
    `id`      smallint unsigned NOT NULL COMMENT '国家ID',
    `name_zh` varchar(255)      NOT NULL DEFAULT '' COMMENT '国家中文名',
    `name_en` varchar(255)      NOT NULL DEFAULT '' COMMENT '国家英文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`),
    KEY `name_en` (`name_en`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='国家';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `image_celebrity_douban`
--

DROP TABLE IF EXISTS `image_celebrity_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_celebrity_douban`
(
    `id`                  bigint unsigned  NOT NULL COMMENT '豆瓣影人图片ID',
    `id_celebrity_douban` bigint unsigned  NOT NULL DEFAULT '0' COMMENT '豆瓣影人ID',
    `sort`                tinyint unsigned NOT NULL DEFAULT '0' COMMENT '序号',
    `length`              int unsigned     NOT NULL DEFAULT '0' COMMENT '长 /px',
    `width`               int unsigned     NOT NULL DEFAULT '0' COMMENT '宽 /px',
    PRIMARY KEY (`id`),
    KEY `id_celebrity_douban` (`id_celebrity_douban`),
    KEY `sort` (`sort`),
    KEY `length` (`length` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣影人图片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `image_movie_douban`
--

DROP TABLE IF EXISTS `image_movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_movie_douban`
(
    `id`              bigint unsigned  NOT NULL COMMENT '豆瓣电影图片ID',
    `id_movie_douban` bigint unsigned  NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `sort`            tinyint unsigned NOT NULL DEFAULT '0' COMMENT '序号',
    `length`          int unsigned     NOT NULL DEFAULT '0' COMMENT '长 /px',
    `width`           int unsigned     NOT NULL DEFAULT '0' COMMENT '宽 /px',
    PRIMARY KEY (`id`),
    KEY `id_movie_douban` (`id_movie_douban`),
    KEY `sort` (`sort`),
    KEY `length` (`length` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影图片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `image_place_scene`
--

DROP TABLE IF EXISTS `image_place_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_place_scene`
(
    `id`             bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '场景地点图片ID',
    `id_place_scene` bigint unsigned NOT NULL DEFAULT '0' COMMENT '场景地点ID',
    `url_image`      varchar(1000)   NOT NULL DEFAULT '' COMMENT '图片链接',
    `description`    varchar(255)    NOT NULL DEFAULT '' COMMENT '图片描述',
    PRIMARY KEY (`id`),
    KEY `id_place_scene` (`id_place_scene`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 29903
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景地点图片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `image_scene_detail`
--

DROP TABLE IF EXISTS `image_scene_detail`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_scene_detail`
(
    `id`              bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '场景详情剧照ID',
    `id_scene_detail` bigint unsigned NOT NULL DEFAULT '0' COMMENT '场景详情ID',
    `url_image`       varchar(1000)   NOT NULL DEFAULT '' COMMENT '图片链接',
    PRIMARY KEY (`id`),
    KEY `id_scene_detail` (`id_scene_detail`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 103845
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景详情剧照';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_douban`
--

DROP TABLE IF EXISTS `movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_douban`
(
    `id`            bigint unsigned   NOT NULL COMMENT '豆瓣电影ID',
    `id_type_video` tinyint unsigned  NOT NULL DEFAULT '1' COMMENT '影片类型ID',
    `id_movie_imdb` bigint unsigned   NOT NULL DEFAULT '0' COMMENT 'IMDB电影ID 0-未匹配 1-已匹配',
    `start_year`    smallint unsigned NOT NULL DEFAULT '0' COMMENT '上映时间 /year',
    `name_zh`       varchar(255)      NOT NULL DEFAULT '' COMMENT '豆瓣电影中文名',
    `name_origin`   varchar(255)      NOT NULL DEFAULT '' COMMENT '豆瓣电影原始名',
    `runtime`       smallint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣电影运行片长 /m',
    `url_poster`    bigint unsigned   NOT NULL DEFAULT '0' COMMENT '豆瓣电影海报ID',
    `summary`       text COMMENT '简介',
    `have_seen`     int unsigned      NOT NULL DEFAULT '0' COMMENT '已看人数',
    `wanna_see`     int unsigned      NOT NULL DEFAULT '0' COMMENT '想看人数',
    `is_netease`    tinyint           NOT NULL DEFAULT '0' COMMENT '是否匹配到网易云音乐 0-未匹配 1-匹配无 2-匹配有',
    `is_zhihu`      tinyint           NOT NULL DEFAULT '0' COMMENT '是否匹配到知乎话题或问题 0-未匹配 1-匹配无 2-匹配有',
    PRIMARY KEY (`id`),
    KEY `id_type_video` (`id_type_video`),
    KEY `id_movie_imdb` (`id_movie_imdb`),
    KEY `start_year` (`start_year`),
    KEY `name_zh` (`name_zh`),
    KEY `name_origin` (`name_origin`),
    KEY `have_seen` (`have_seen` DESC),
    KEY `wanna_see` (`wanna_see` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_douban_to_award_movie`
--

DROP TABLE IF EXISTS `movie_douban_to_award_movie`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_douban_to_award_movie`
(
    `id_movie_douban`     bigint unsigned   NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `id_award_movie`      varchar(255)      NOT NULL DEFAULT 'unknown' COMMENT '获奖奖项ID',
    `id_celebrity_douban` bigint unsigned   NOT NULL DEFAULT '0' COMMENT '获奖豆瓣影人ID',
    `type_award`          varchar(255)      NOT NULL DEFAULT '未知' COMMENT '奖项的类别中文名',
    `award_th`            smallint unsigned NOT NULL DEFAULT '1' COMMENT '获奖奖项届数',
    `is_nominated`        tinyint           NOT NULL DEFAULT '0' COMMENT '是否被提名 0-仅提名未获奖 1-已提名且获奖',
    PRIMARY KEY (`id_movie_douban`, `id_award_movie`, `id_celebrity_douban`, `type_award`, `award_th`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影-奖项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_douban_to_celebrity_douban`
--

DROP TABLE IF EXISTS `movie_douban_to_celebrity_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_douban_to_celebrity_douban`
(
    `id_movie_douban`     bigint unsigned   NOT NULL COMMENT '豆瓣电影ID',
    `id_celebrity_douban` bigint unsigned   NOT NULL COMMENT '豆瓣影人ID',
    `id_profession`       tinyint unsigned  NOT NULL DEFAULT '1' COMMENT '该影人在该电影中的职位',
    `sort`                smallint unsigned NOT NULL DEFAULT '0' COMMENT '该影人在该电影中的演员排列顺序',
    PRIMARY KEY (`id_movie_douban`, `id_celebrity_douban`, `id_profession`),
    KEY `sort` (`sort`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影-影人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_douban_to_review_movie_douban`
--

DROP TABLE IF EXISTS `movie_douban_to_review_movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_douban_to_review_movie_douban`
(
    `id_movie_douban`        bigint unsigned NOT NULL COMMENT '豆瓣电影ID',
    `id_review_movie_douban` bigint unsigned NOT NULL COMMENT '电影影评ID',
    PRIMARY KEY (`id_movie_douban`, `id_review_movie_douban`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影-影评';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_douban_to_type_movie`
--

DROP TABLE IF EXISTS `movie_douban_to_type_movie`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_douban_to_type_movie`
(
    `id_movie_douban` bigint unsigned   NOT NULL COMMENT '豆瓣电影ID',
    `id_type_movie`   smallint unsigned NOT NULL COMMENT '影片类型ID',
    PRIMARY KEY (`id_movie_douban`, `id_type_movie`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影-电影类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_imdb`
--

DROP TABLE IF EXISTS `movie_imdb`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_imdb`
(
    `id`              bigint unsigned   NOT NULL COMMENT 'IMDB电影ID',
    `id_type_video`   tinyint unsigned  NOT NULL DEFAULT '1' COMMENT '影片种类',
    `name_en`         varchar(255)      NOT NULL DEFAULT '' COMMENT 'IMDB电影英文名',
    `start_year`      smallint unsigned NOT NULL DEFAULT '0' COMMENT 'IMDB电影发行年份',
    `is_adult`        tinyint           NOT NULL DEFAULT '0' COMMENT '是否是成人电影 0-不是 1-是',
    `name_origin`     varchar(255)      NOT NULL DEFAULT '' COMMENT 'IMDB电影原始名',
    `runtime`         smallint unsigned NOT NULL DEFAULT '0' COMMENT 'IMDB电影片长 /m',
    `url_poster`      varchar(1000)     NOT NULL DEFAULT '' COMMENT 'IMDB海报链接',
    `summary`         text COMMENT '简介',
    `id_movie_douban` bigint unsigned   NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID 0-未匹配 1-已匹配',
    PRIMARY KEY (`id`),
    KEY `id_type_video` (`id_type_video`),
    KEY `name_en` (`name_en`),
    KEY `start_year` (`start_year` DESC),
    KEY `name_origin` (`name_origin`),
    KEY `id_movie_douban` (`id_movie_douban`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='IMDB电影';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_imdb_to_celebrity_imdb`
--

DROP TABLE IF EXISTS `movie_imdb_to_celebrity_imdb`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_imdb_to_celebrity_imdb`
(
    `id_movie_imdb`     bigint unsigned  NOT NULL COMMENT 'IMDB电影ID',
    `id_celebrity_imdb` bigint unsigned  NOT NULL COMMENT 'IMDB影人ID',
    `id_profession`     tinyint unsigned NOT NULL COMMENT '该影人在该电影中的职位',
    PRIMARY KEY (`id_movie_imdb`, `id_celebrity_imdb`, `id_profession`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='IMDB电影-影人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_imdb_to_type_movie`
--

DROP TABLE IF EXISTS `movie_imdb_to_type_movie`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_imdb_to_type_movie`
(
    `id_movie_imdb` bigint unsigned   NOT NULL COMMENT 'IMDB电影ID',
    `id_type_movie` smallint unsigned NOT NULL COMMENT '影片类型ID',
    PRIMARY KEY (`id_movie_imdb`, `id_type_movie`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='IMDB电影-影片类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_netease`
--

DROP TABLE IF EXISTS `movie_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_netease`
(
    `id_movie_douban` bigint unsigned  NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `id_netease`      bigint unsigned  NOT NULL DEFAULT '0' COMMENT '网易云音乐ID',
    `netease_type`    tinyint unsigned NOT NULL DEFAULT '0' COMMENT '匹配类型 0-未知 1-歌曲 2-歌单 3-专辑',
    `sort`            tinyint unsigned NOT NULL DEFAULT '0' COMMENT '排序 1-10 依次降低',
    PRIMARY KEY (`id_movie_douban`, `id_netease`, `netease_type`),
    KEY `sort` (`sort`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐电影';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_scene`
--

DROP TABLE IF EXISTS `movie_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_scene`
(
    `id`              bigint unsigned   NOT NULL COMMENT '场景电影ID',
    `id_movie_douban` bigint unsigned   NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID 0-未匹配 1-已匹配',
    `name_zh`         varchar(255)      NOT NULL DEFAULT '' COMMENT '场景电影中文名',
    `name_en`         varchar(255)      NOT NULL DEFAULT '' COMMENT '场景电影英文名',
    `start_year`      smallint unsigned NOT NULL DEFAULT '0' COMMENT '上映时间 /year',
    `description`     varchar(1000)     NOT NULL DEFAULT '' COMMENT '场景电影拍摄地点大致描述',
    `url_map`         varchar(1000)     NOT NULL DEFAULT '' COMMENT '场景电影地点分布图链接',
    PRIMARY KEY (`id`),
    KEY `id_movie_douban` (`id_movie_douban`),
    KEY `name_zh` (`name_zh`),
    KEY `name_en` (`name_en`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景电影';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_scene_to_celebrity_scene`
--

DROP TABLE IF EXISTS `movie_scene_to_celebrity_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_scene_to_celebrity_scene`
(
    `id_movie_scene`     bigint unsigned NOT NULL COMMENT '场景电影ID',
    `id_celebrity_scene` bigint unsigned NOT NULL COMMENT '场景影人ID',
    PRIMARY KEY (`id_movie_scene`, `id_celebrity_scene`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景电影-场景影人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_zhihu`
--

DROP TABLE IF EXISTS `movie_zhihu`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_zhihu`
(
    `id`              bigint unsigned NOT NULL DEFAULT '0' COMMENT '知乎电影ID',
    `id_movie_douban` bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `name_zh`         varchar(255)    NOT NULL DEFAULT '' COMMENT '知乎电影中文名',
    `zhihu_score`     decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '知乎评分',
    `zhihu_vote`      int unsigned    NOT NULL DEFAULT '0' COMMENT '知乎评分票数',
    `maoyan_score`    decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '猫眼评分',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_movie_douban` (`id_movie_douban`),
    KEY `name_zh` (`name_zh`),
    KEY `zhihu_score` (`zhihu_score` DESC),
    KEY `zhihu_vote` (`zhihu_vote` DESC),
    KEY `maoyan_score` (`maoyan_score` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='知乎电影';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movie_zhihu_copy`
--

DROP TABLE IF EXISTS `movie_zhihu_copy`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_zhihu_copy`
(
    `id`              bigint unsigned NOT NULL DEFAULT '0' COMMENT '知乎电影ID',
    `id_movie_douban` bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `name_zh`         varchar(255)    NOT NULL DEFAULT '' COMMENT '知乎电影中文名',
    `zhihu_score`     decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '知乎评分',
    `zhihu_vote`      int unsigned    NOT NULL DEFAULT '0' COMMENT '知乎评分票数',
    `maoyan_score`    decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '猫眼评分',
    PRIMARY KEY (`id`, `id_movie_douban`),
    KEY `name_zh` (`name_zh`),
    KEY `zhihu_score` (`zhihu_score` DESC),
    KEY `zhihu_vote` (`zhihu_vote` DESC),
    KEY `maoyan_score` (`maoyan_score` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='知乎电影';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission`
(
    `id`          int unsigned NOT NULL AUTO_INCREMENT COMMENT '用户权限ID',
    `name_zh`     varchar(255) NOT NULL DEFAULT '' COMMENT '权限名称',
    `path_src`    varchar(255) NOT NULL COMMENT '权限路径',
    `description` varchar(255) NOT NULL DEFAULT '' COMMENT '权限描述',
    PRIMARY KEY (`id`),
    UNIQUE KEY `path_src` (`path_src`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `place_scene`
--

DROP TABLE IF EXISTS `place_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place_scene`
(
    `id`                 bigint unsigned   NOT NULL COMMENT '场景地点ID',
    `id_continent_scene` tinyint unsigned  NOT NULL DEFAULT '0' COMMENT '地点范围-洲-ID',
    `id_country_scene`   smallint unsigned NOT NULL DEFAULT '0' COMMENT '地点范围-国家-ID',
    `id_state_scene`     int unsigned      NOT NULL DEFAULT '0' COMMENT '地点范围-州/省-ID',
    `id_city_scene`      int unsigned      NOT NULL DEFAULT '0' COMMENT '地点范围-城市-ID',
    `longitude`          decimal(11, 8)    NOT NULL DEFAULT '0.00000000' COMMENT '经度',
    `latitude`           decimal(11, 8)    NOT NULL DEFAULT '0.00000000' COMMENT '纬度',
    `name_zh`            varchar(255)      NOT NULL DEFAULT '' COMMENT '中文名',
    `name_en`            varchar(255)      NOT NULL DEFAULT '' COMMENT '英文名',
    `name_other`         varchar(255)      NOT NULL DEFAULT '' COMMENT '其他语言名',
    `alias`              varchar(255)      NOT NULL DEFAULT '' COMMENT '别名',
    `address_zh`         varchar(255)      NOT NULL DEFAULT '' COMMENT '中文地址',
    `address_en`         varchar(255)      NOT NULL DEFAULT '' COMMENT '英文地址',
    `description`        varchar(1000)     NOT NULL DEFAULT '' COMMENT '地点描述',
    `area_zh`            varchar(255)      NOT NULL DEFAULT '' COMMENT '区域中文',
    `area_en`            varchar(255)      NOT NULL DEFAULT '' COMMENT '区域英文',
    `phone`              varchar(255)      NOT NULL DEFAULT '' COMMENT '电话号码',
    `url_poster`         varchar(1000)     NOT NULL DEFAULT '' COMMENT '地点海报图链接',
    `url_earth`          varchar(1000)     NOT NULL DEFAULT '' COMMENT '地点地球位置图链接',
    `url_satellite`      varchar(1000)     NOT NULL DEFAULT '' COMMENT '地点卫星图链接',
    `url_map`            varchar(1000)     NOT NULL DEFAULT '' COMMENT '地点地图',
    PRIMARY KEY (`id`),
    KEY `id_continent_scene` (`id_continent_scene`),
    KEY `id_country_scene` (`id_country_scene`),
    KEY `id_state_scene` (`id_state_scene`),
    KEY `id_city_scene` (`id_city_scene`),
    KEY `longitude` (`latitude`),
    KEY `latitude` (`longitude`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景地点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `place_scene_to_type_place_scene`
--

DROP TABLE IF EXISTS `place_scene_to_type_place_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place_scene_to_type_place_scene`
(
    `id_place_scene`      bigint unsigned  NOT NULL COMMENT '场景地点ID',
    `id_type_place_scene` tinyint unsigned NOT NULL COMMENT '场景地点类型ID',
    PRIMARY KEY (`id_place_scene`, `id_type_place_scene`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景地点-场景地点类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `playlist_netease`
--

DROP TABLE IF EXISTS `playlist_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist_netease`
(
    `id`          bigint unsigned   NOT NULL COMMENT '网易云音乐歌单ID',
    `name_zh`     varchar(255)      NOT NULL DEFAULT '' COMMENT '歌单中文名',
    `total`       smallint unsigned NOT NULL DEFAULT '0' COMMENT '歌单歌曲总数',
    `play_count`  int unsigned      NOT NULL DEFAULT '0' COMMENT '歌单播放次数',
    `url_cover`   varchar(1000)     NOT NULL DEFAULT '' COMMENT '封面照片链接',
    `description` varchar(1000)     NOT NULL DEFAULT '' COMMENT '歌单描述',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`),
    KEY `play_count` (`play_count` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐歌单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `profession`
--

DROP TABLE IF EXISTS `profession`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profession`
(
    `id`      tinyint unsigned NOT NULL COMMENT '影人职业ID',
    `name_zh` varchar(255)     NOT NULL DEFAULT '' COMMENT '职业中文名',
    `name_en` varchar(255)     NOT NULL DEFAULT '' COMMENT '职业英文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`),
    KEY `name_en` (`name_en`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='影人职业';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question_zhihu`
--

DROP TABLE IF EXISTS `question_zhihu`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_zhihu`
(
    `id`              bigint unsigned NOT NULL COMMENT '知乎问题ID',
    `id_movie_douban` bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `name_zh`         varchar(255)    NOT NULL DEFAULT '' COMMENT '知乎问题中文名',
    `answer_num`      int unsigned    NOT NULL DEFAULT '0' COMMENT '回答数 0-默认 1-文章',
    PRIMARY KEY (`id`),
    KEY `id_movie_douban` (`id_movie_douban`),
    KEY `name_zh` (`name_zh`),
    KEY `answer_num` (`answer_num` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='知乎问题';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rate_imdb`
--

DROP TABLE IF EXISTS `rate_imdb`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate_imdb`
(
    `id`           bigint unsigned NOT NULL COMMENT 'IMDB电影ID tt+00xxx(7)',
    `imdb_score`   decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT 'IMDB评分',
    `imdb_vote`    int unsigned    NOT NULL DEFAULT '0' COMMENT 'IMDB评分人数',
    `tomato_score` decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '烂番茄新鲜度',
    `mtc_score`    decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT 'MTC评分',
    PRIMARY KEY (`id`),
    KEY `imdb_score` (`imdb_score` DESC),
    KEY `imdb_vote` (`imdb_vote` DESC),
    KEY `tomato_score` (`tomato_score` DESC),
    KEY `mtc_score` (`mtc_score` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='IMDB电影评分';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rate_movie_douban`
--

DROP TABLE IF EXISTS `rate_movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate_movie_douban`
(
    `id`     bigint unsigned NOT NULL COMMENT '豆瓣电影ID',
    `score`  decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '豆瓣电影评分',
    `vote`   int unsigned    NOT NULL DEFAULT '0' COMMENT '豆瓣电影评分人数',
    `score5` decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '豆瓣5星比例',
    `score4` decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '豆瓣4星比例',
    `score3` decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '豆瓣3星比例',
    `score2` decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '豆瓣2星比例',
    `score1` decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '豆瓣1星比例',
    PRIMARY KEY (`id`),
    KEY `score` (`score` DESC),
    KEY `vote` (`vote` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影评分';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `resource_movie`
--

DROP TABLE IF EXISTS `resource_movie`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource_movie`
(
    `id`                  bigint unsigned   NOT NULL AUTO_INCREMENT COMMENT '电影资源ID',
    `id_movie_douban`     bigint unsigned   NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID 0-未匹配 1-已匹配',
    `id_movie_imdb`       bigint unsigned   NOT NULL DEFAULT '0' COMMENT 'IMDB电影ID 0-未匹配 1-已匹配',
    `id_website_resource` smallint unsigned NOT NULL DEFAULT '1' COMMENT '电影资源网站ID ID<100-正版 ID>100-盗版',
    `id_type_resource`    smallint unsigned NOT NULL DEFAULT '100' COMMENT '电影资源类型ID ID<100-在线  ID>100-离线',
    `name_zh`             varchar(255)      NOT NULL DEFAULT '' COMMENT '资源中文名',
    `create_year`         smallint          NOT NULL DEFAULT '0' COMMENT '电影年代 /year',
    `name_origin`         varchar(255)      NOT NULL DEFAULT '' COMMENT '资源原始名',
    `url_resource`        varchar(1000)     NOT NULL DEFAULT '' COMMENT '资源链接',
    PRIMARY KEY (`id`),
    UNIQUE KEY `url_resource` (`url_resource`(255)),
    KEY `id_movie_douban` (`id_movie_douban`),
    KEY `id_movie_imdb` (`id_movie_imdb`),
    KEY `id_website_resource` (`id_website_resource`),
    KEY `id_type_resource` (`id_type_resource`),
    KEY `name_zh` (`name_zh`),
    KEY `create_year` (`create_year`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 807861
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `review_movie_douban`
--

DROP TABLE IF EXISTS `review_movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_movie_douban`
(
    `id`              bigint unsigned NOT NULL COMMENT '豆瓣电影影评ID',
    `agree_vote`      int unsigned    NOT NULL DEFAULT '0' COMMENT '赞同数',
    `against_vote`    int unsigned    NOT NULL DEFAULT '0' COMMENT '反对数',
    `create_datetime` bigint          NOT NULL DEFAULT '0' COMMENT '影评日期时间 /unix',
    `title`           varchar(255)    NOT NULL DEFAULT '' COMMENT '影评标题',
    `content`         text COMMENT '影评内容',
    PRIMARY KEY (`id`),
    KEY `agree_vote` (`agree_vote` DESC),
    KEY `against_vote` (`against_vote` DESC),
    KEY `create_datetime` (`create_datetime` DESC),
    KEY `title` (`title`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影影评';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role`
(
    `id`          tinyint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户角色ID',
    `name_zh`     varchar(255)     NOT NULL DEFAULT '' COMMENT '角色名称',
    `description` varchar(255)     NOT NULL DEFAULT '' COMMENT '角色描述',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_to_permission`
--

DROP TABLE IF EXISTS `role_to_permission`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_to_permission`
(
    `id_role`       tinyint unsigned NOT NULL COMMENT '角色ID',
    `id_permission` int unsigned     NOT NULL COMMENT '权限ID',
    PRIMARY KEY (`id_role`, `id_permission`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色-权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `scene`
--

DROP TABLE IF EXISTS `scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene`
(
    `id`             bigint unsigned NOT NULL COMMENT '场景ID',
    `id_movie_scene` bigint unsigned NOT NULL DEFAULT '0' COMMENT '场景电影ID',
    `id_place_scene` bigint unsigned NOT NULL DEFAULT '0' COMMENT '地点ID',
    `name_zh`        varchar(255)    NOT NULL DEFAULT '' COMMENT '场景中文名',
    `happen_time`    int unsigned    NOT NULL DEFAULT '0' COMMENT '场景发生在电影中的时间 /s',
    PRIMARY KEY (`id`),
    KEY `id_movie_scene` (`id_movie_scene`),
    KEY `id_place_scene` (`id_place_scene`),
    KEY `name_zh` (`name_zh`),
    KEY `happen_time` (`happen_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `scene_detail`
--

DROP TABLE IF EXISTS `scene_detail`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene_detail`
(
    `id`             bigint unsigned NOT NULL COMMENT '场景详情ID',
    `id_scene`       bigint unsigned NOT NULL DEFAULT '0' COMMENT '场景ID',
    `id_movie_scene` bigint unsigned NOT NULL DEFAULT '0' COMMENT '场景电影ID',
    `happen_time`    int unsigned    NOT NULL DEFAULT '0' COMMENT '场景发生在电影中的时间 /s',
    `description`    varchar(1000)   NOT NULL DEFAULT '' COMMENT '场景描述',
    PRIMARY KEY (`id`),
    KEY `id_scene` (`id_scene`),
    KEY `id_movie_scene` (`id_movie_scene`),
    KEY `happen_time` (`happen_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景详情';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `scene_detail_to_celebrity_scene`
--

DROP TABLE IF EXISTS `scene_detail_to_celebrity_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene_detail_to_celebrity_scene`
(
    `id_scene_detail`    bigint unsigned NOT NULL COMMENT '场景详情ID',
    `id_celebrity_scene` bigint unsigned NOT NULL COMMENT '场景影人ID',
    PRIMARY KEY (`id_scene_detail`, `id_celebrity_scene`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景详情-场景影人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `song_netease`
--

DROP TABLE IF EXISTS `song_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song_netease`
(
    `id`      bigint unsigned NOT NULL COMMENT '网易云音乐歌曲ID',
    `name_zh` varchar(255)    NOT NULL DEFAULT '' COMMENT '歌曲中文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐歌曲';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `song_netease_to_album_netease`
--

DROP TABLE IF EXISTS `song_netease_to_album_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song_netease_to_album_netease`
(
    `id_song_netease`  bigint unsigned NOT NULL COMMENT '网易云音乐歌曲ID',
    `id_album_netease` bigint unsigned NOT NULL COMMENT '网易云音乐专辑ID',
    PRIMARY KEY (`id_song_netease`, `id_album_netease`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐歌曲-专辑';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `song_netease_to_playlist_netease`
--

DROP TABLE IF EXISTS `song_netease_to_playlist_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song_netease_to_playlist_netease`
(
    `id_song_netease`     bigint unsigned  NOT NULL COMMENT '网易云音乐歌曲ID',
    `id_playlist_netease` bigint unsigned  NOT NULL COMMENT '网易云音乐歌单ID',
    `song_pop`            tinyint unsigned NOT NULL DEFAULT '0' COMMENT '歌曲在歌单中的流行度 0-100',
    PRIMARY KEY (`id_song_netease`, `id_playlist_netease`),
    KEY `song_pop` (`song_pop` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐歌曲-歌单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `state_scene`
--

DROP TABLE IF EXISTS `state_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_scene`
(
    `id`      int unsigned NOT NULL COMMENT '州/省ID',
    `name_zh` varchar(255) NOT NULL DEFAULT '' COMMENT '州中文名',
    `name_en` varchar(255) NOT NULL DEFAULT '' COMMENT '州英文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`),
    KEY `name_en` (`name_en`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='州/省';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tag_movie`
--

DROP TABLE IF EXISTS `tag_movie`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_movie`
(
    `id_movie_douban` bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `name_zh`         varchar(255)    NOT NULL DEFAULT '' COMMENT '电影标签中文名',
    PRIMARY KEY (`id_movie_douban`, `name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影标签';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trailer_movie_douban`
--

DROP TABLE IF EXISTS `trailer_movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trailer_movie_douban`
(
    `id`              bigint unsigned NOT NULL COMMENT '豆瓣电影预告片ID',
    `id_movie_douban` bigint unsigned NOT NULL DEFAULT '0' COMMENT '豆瓣电影ID',
    `url_video`       varchar(1000)   NOT NULL DEFAULT '' COMMENT '预告片mp4链接',
    PRIMARY KEY (`id`),
    KEY `id_movie_douban` (`id_movie_douban`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影预告片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `type_movie`
--

DROP TABLE IF EXISTS `type_movie`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_movie`
(
    `id`      smallint unsigned NOT NULL COMMENT '电影类型ID',
    `name_zh` varchar(255)      NOT NULL DEFAULT '' COMMENT '电影类型中文名',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `type_place_scene`
--

DROP TABLE IF EXISTS `type_place_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_place_scene`
(
    `id`      tinyint unsigned NOT NULL COMMENT '场景地点类型ID',
    `name_zh` varchar(255)     NOT NULL DEFAULT '' COMMENT '地点类型名称中文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='场景地点类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `type_resource`
--

DROP TABLE IF EXISTS `type_resource`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_resource`
(
    `id`      smallint unsigned NOT NULL COMMENT '电影资源类型ID ID<100-在线  ID>100-离线',
    `name_zh` varchar(255)      NOT NULL DEFAULT '' COMMENT '资源类型中文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='cccc';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `type_video`
--

DROP TABLE IF EXISTS `type_video`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_video`
(
    `id`      tinyint unsigned NOT NULL COMMENT '影片类型ID',
    `name_zh` varchar(255)     NOT NULL DEFAULT '' COMMENT '影片类型中文名',
    `name_en` varchar(255)     NOT NULL DEFAULT '' COMMENT '影片类型英文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`),
    KEY `name_en` (`name_en`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='影片种类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user`
(
    `id`       varchar(255) NOT NULL COMMENT '用户ID',
    `email`    varchar(255) NOT NULL COMMENT '邮箱',
    `password` varchar(255) NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`),
    UNIQUE KEY `email` (`email`),
    KEY `password` (`password`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_douban`
--

DROP TABLE IF EXISTS `user_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_douban`
(
    `id`      varchar(255) NOT NULL COMMENT '豆瓣用户ID',
    `name_zh` varchar(255) NOT NULL DEFAULT '' COMMENT '豆瓣名字中文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_douban_to_classic_douban`
--

DROP TABLE IF EXISTS `user_douban_to_classic_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_douban_to_classic_douban`
(
    `id_user_douban`      varchar(255)  NOT NULL COMMENT '豆瓣用户ID 0-未登录用户',
    `id_classic_douban`   varchar(255)  NOT NULL COMMENT '豆瓣电影经典台词ID',
    `name_zh_user_douban` varchar(255)  NOT NULL DEFAULT '' COMMENT '用户中文名',
    `record_datetime`     bigint        NOT NULL DEFAULT '0' COMMENT '豆瓣用户收录时间 /unix',
    `description`         varchar(1000) NOT NULL DEFAULT '' COMMENT '豆瓣用户评价',
    PRIMARY KEY (`id_user_douban`, `id_classic_douban`),
    KEY `record_datetime` (`record_datetime`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣电影经典台词-豆瓣用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_douban_to_movie_douban`
--

DROP TABLE IF EXISTS `user_douban_to_movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_douban_to_movie_douban`
(
    `id_user_douban`  varchar(255)    NOT NULL COMMENT '豆瓣用户ID',
    `id_movie_douban` bigint unsigned NOT NULL COMMENT '豆瓣电影ID',
    `score`           decimal(3, 1)   NOT NULL DEFAULT '0.0' COMMENT '用户对电影的评分',
    `is_wish`         tinyint         NOT NULL DEFAULT '0' COMMENT '是否想看 0-未标记 1-已想看',
    `is_seen`         tinyint         NOT NULL DEFAULT '0' COMMENT '是否看过 0-未标记 1-已看过',
    PRIMARY KEY (`id_user_douban`, `id_movie_douban`, `score` DESC)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣用户-电影';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_douban_to_review_movie_douban`
--

DROP TABLE IF EXISTS `user_douban_to_review_movie_douban`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_douban_to_review_movie_douban`
(
    `id_user_douban`         varchar(255)    NOT NULL COMMENT '豆瓣用户ID',
    `id_review_movie_douban` bigint unsigned NOT NULL COMMENT '豆瓣影评ID',
    PRIMARY KEY (`id_user_douban`, `id_review_movie_douban`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='豆瓣用户-豆瓣影评';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_netease`
--

DROP TABLE IF EXISTS `user_netease`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_netease`
(
    `id`      bigint unsigned NOT NULL COMMENT '网易云音乐用户ID',
    `name_zh` varchar(255)    NOT NULL DEFAULT '' COMMENT '用户中文名',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='网易云音乐用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_to_role`
--

DROP TABLE IF EXISTS `user_to_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_to_role`
(
    `id_user` varchar(255)     NOT NULL COMMENT '用户ID',
    `id_role` tinyint unsigned NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`id_user`, `id_role`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户-角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `website_resource`
--

DROP TABLE IF EXISTS `website_resource`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `website_resource`
(
    `id`          smallint unsigned NOT NULL COMMENT '电影资源网站ID ID<100-正版 ID>100-盗版',
    `name_zh`     varchar(255)      NOT NULL DEFAULT '' COMMENT '网站中文名',
    `website_src` varchar(255)      NOT NULL DEFAULT '' COMMENT '网站官网地址',
    PRIMARY KEY (`id`),
    KEY `name_zh` (`name_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='电影资源网站';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `zipkin_annotations`
--

DROP TABLE IF EXISTS `zipkin_annotations`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zipkin_annotations`
(
    `trace_id_high`         bigint       NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
    `trace_id`              bigint       NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
    `span_id`               bigint       NOT NULL COMMENT 'coincides with zipkin_spans.id',
    `a_key`                 varchar(255) NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
    `a_value`               blob COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
    `a_type`                int          NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
    `a_timestamp`           bigint                DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
    `endpoint_ipv4`         int                   DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
    `endpoint_ipv6`         binary(16)            DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
    `endpoint_port`         smallint              DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
    `endpoint_service_name` varchar(255)          DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
    UNIQUE KEY `trace_id_high` (`trace_id_high`, `trace_id`, `span_id`, `a_key`, `a_timestamp`) COMMENT 'Ignore insert on duplicate',
    KEY `trace_id_high_2` (`trace_id_high`, `trace_id`, `span_id`) COMMENT 'for joining with zipkin_spans',
    KEY `trace_id_high_3` (`trace_id_high`, `trace_id`) COMMENT 'for getTraces/ByIds',
    KEY `endpoint_service_name` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
    KEY `a_type` (`a_type`) COMMENT 'for getTraces and autocomplete values',
    KEY `a_key` (`a_key`) COMMENT 'for getTraces and autocomplete values',
    KEY `trace_id` (`trace_id`, `span_id`, `a_key`) COMMENT 'for dependencies job'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPRESSED;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `zipkin_dependencies`
--

DROP TABLE IF EXISTS `zipkin_dependencies`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zipkin_dependencies`
(
    `day`         date         NOT NULL,
    `parent`      varchar(255) NOT NULL,
    `child`       varchar(255) NOT NULL,
    `call_count`  bigint DEFAULT NULL,
    `error_count` bigint DEFAULT NULL,
    PRIMARY KEY (`day`, `parent`, `child`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPRESSED;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `zipkin_spans`
--

DROP TABLE IF EXISTS `zipkin_spans`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zipkin_spans`
(
    `trace_id_high`       bigint       NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
    `trace_id`            bigint       NOT NULL,
    `id`                  bigint       NOT NULL,
    `name`                varchar(255) NOT NULL,
    `remote_service_name` varchar(255)          DEFAULT NULL,
    `parent_id`           bigint                DEFAULT NULL,
    `debug`               bit(1)                DEFAULT NULL,
    `start_ts`            bigint                DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
    `duration`            bigint                DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
    PRIMARY KEY (`trace_id_high`, `trace_id`, `id`),
    KEY `trace_id_high` (`trace_id_high`, `trace_id`) COMMENT 'for getTracesByIds',
    KEY `name` (`name`) COMMENT 'for getTraces and getSpanNames',
    KEY `remote_service_name` (`remote_service_name`) COMMENT 'for getTraces and getRemoteServiceNames',
    KEY `start_ts` (`start_ts`) COMMENT 'for getTraces ordering and range'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPRESSED;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2020-04-09 14:16:00
