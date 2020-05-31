<div align="center">
<img src="./doc/image/logo.png" width="500"/>
</div>
<div align="center">
<a target="_blank" href="https://travis-ci.org/humingk/douban_movie_plus"><img src="https://travis-ci.org/humingk/douban_movie_plus.svg?branch=master" alt="Build Status"></a>
<img src="./doc/image/license-GPL-blue.svg">
<img src="./doc/image/language-Java-green.svg">
</div>

## 使用方法

- 从豆瓣电影访问，域名`douban`后加 `s` ，例如： [https://movie.douban`s`.com/subject/1889243](https://movie.doubans.com/subject/1889243)


- 调用本项目API服务你的应用 [API文档 (html)](https://api.doubans.com) ，[API文档 (md)](https://github.com/humingk/douban_movie_plus/blob/master/doc/api/AllInOne.md) ，[Postman测试 (json)](https://github.com/humingk/douban_movie_plus/blob/master/doc/api/postman.json)


- 欢迎加入豆瓣电影Plus交流群 `476584154` 口令 `doubans`

## 开发任务

- 部分前端页面待开发，包括搜索、影人、场景等页面
- 后端API接口功能待丰富，包括影人相关、排行榜、分类等功能
- 音乐模块暂时采用NeteaseCloudMusicApi(数据过多)
- 知乎搜索接口已升级，请求头部分参数加密方式未知
- 数据库结构待改进

## 特别声明

- 本项目仅供学习交流
- 免费提供doubans三级域名book,music等解析
- 本项目有很多需要改进的地方，欢迎大家一起完善这个项目！

## 开发相关

### 前端开发 (Vue)

[前端仓库](https://github.com/humingk/douban_movie_vue)

#### 0. fork

#### 1. clone (替换用户名)

`git clone -b dev --depth 3 https://github.com/humingk/douban_movie_vue`

or

`git clone -b dev --depth 3 git@github.com:humingk/douban_movie_vue.git`

#### 2. 安装

- npm

`npm install`

#### 3. 启动

`npm run serve`

#### 4. 请提交到**dev**分支

### 后端开发 (Spring)

[后端仓库](https://github.com/humingk/douban_movie_plus)

#### 0. 代码规范

- [谷歌Java](https://github.com/google/google-java-format) or [阿里巴巴Java](https://github.com/alibaba/p3c)

#### 1. fork

#### 2. clone (替换用户名)

`git clone -b dev --depth 3 https://github.com/humingk/douban_movie_plus`

or

`git clone -b dev --depth 3 git@github.com:humingk/douban_movie_plus.git`

#### 3. 项目导入

- JDK 1.8
- Maven 3.6.1

#### 4. RabbitMQ配置

RabbitMQ依赖erlang,注意版本

- [erlang下载](https://www.erlang.org/downloads)

- [RabbitMQ下载](https://github.com/rabbitmq/rabbitmq-server/releases)

- RabbitMQ配置文件 `./doc/config/rabbitmq-dev.yml`

#### 5. Redis配置

- [Redis下载](https://redis.io/download)

- Redis配置文件 `./doc/config/redis-dev.yml`

#### 6. MySQL配置

- MySQL >= 8.0
    下载本地测试数据库 [movie_test_8.0.sql](https://github.com/humingk/douban_movie_plus/releases/download/v2.0.11/movie_test_8.0.sql.zip)
- MySQL < 8.0
    下载本地测试数据库 [movie_test_5.x.sql](https://github.com/humingk/douban_movie_plus/releases/download/v2.0.11/movie_test_5.x.sql.zip)
- 解压后导入
    `mysql -uroot -p < movie_test_x.sql`
- MySQL配置文件 
    `./doc/config/mysql-dev.yml`

#### 7. 修改部分配置文件绝对路径

**必要**:
- config服务配置 search-locations `./movie-server-config/src/main/resources/bootstrap.yml`

- logback配置 config `./doc/config/logback-dev.yml`

- logback配置文件 log_home `./doc/config/logback-config.xml`

非必要:
- 项目根路径 base-dir `./pom.xml`

- oauth2秘钥 key.location `./doc/config/oauth2-server-dev.yml`

- api文档输出 outPath `./doc/api/smart-doc.json`

- Mybatis通用插件 targetPackage `./movie-dal/src/main/resources/mybatis/generatorConfig.xml`

#### 8. NeteaseCloudMusicApi服务 (**暂时方案**)

`./tools.sh`

#### 9. zipkin服务 (**非必要**)

`./tools.sh`

#### 10. server启动顺序

`eureka -> config -> zipkin(可选) -> server list -> gateway`

#### 11. 测试

本地测试前请启动euraka和config服务

`mvn test`

#### 12. 请提交到**dev**分支

## 特别感谢

|                                      |                                                             |                                                          |                                                       |
| :----------------------------------: | :---------------------------------------------------------: | :------------------------------------------------------: | :---------------------------------------------------: |
| [豆瓣电影](https://movie.douban.com) |                [IMDB](https://www.imdb.com)                 |           [网易云音乐](https://music.163.com)            |            [片场](http://www.mocation.cc)             |
|    [知乎](https://www.zhihu.com)     | [NCMApi](https://github.com/Binaryify/NeteaseCloudMusicApi) | [smart-doc](https://gitee.com/sunyurepository/smart-doc) | [aplayer](https://github.com/SevenOutman/vue-aplayer) |
|    [OMDB](http://www.omdbapi.com)    |          [烂番茄](https://www.rottentomatoes.com)           |            [MTC](https://www.metacritic.com)             |                      |
|                                      |                                                             |                                                          |                                                       |
