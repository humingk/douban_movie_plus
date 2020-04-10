<div align="center">
<img src="./doc/image/logo.png" style="width: 500px"/>
</div>
<div align="center">
<a href="https://travis-ci.org/humingk/douban_movie_plus"><img src="https://travis-ci.org/humingk/douban_movie_plus.svg?branch=master" alt="Build Status"></a>
<a href="https://codecov.io/gh/humingk/douban_movie_plus"><img src="https://codecov.io/gh/humingk/douban_movie_plus/branch/master/graph/badge.svg" alt="codecov]"></a>
<a href=""><img src="./doc/image/license-GPL-blue.svg"></a>
<a href=""><img src="./doc/image/language-Java-green.svg"></a>
</div>

## 网站地址

<https://movie.doubans.com>

---

### 2.0版本正在开发中，1.0版本详见分支 [v1.0](https://github.com/humingk/douban_movie_plus/tree/v1.0)

## 使用相关

- 推荐从豆瓣电影官网访问，例如二级域名`douban`后加`s`即可跳转 [https://movie.douban`s`.com/subject/1889243](https://movie.doubans.com/subject/1889243)


- 调用本项目后端API服务你的前端应用，[API调用文档说明](https://movie.doubans.com/api)


- 聊天吹水提建议，欢迎加入QQ豆瓣电影Plus交流群 `476584154`，口令：`doubans`

## 开发相关

### 前端Vue开发

前端开发文档详见 [douban_movie_vue](https://github.com/humingk/douban_movie_vue)

### 后端Spring开发

#### 0. 代码规范
- [谷歌Java](https://github.com/google/google-java-format) or [阿里巴巴Java](https://github.com/alibaba/p3c)

#### 1. fork

#### 2. clone (替换用户名，且一定要加上--depth)
`git clone -b dev --depth 1 https://github.com/humingk/douban_movie_plus`

or

`git clone -b dev --depth 1 git@github.com:humingk/douban_movie_plus.git`

#### 3. maven导入项目
- JDK 1.8
- Maven 3.6.1

#### 4. RabbitMQ配置
RabbitMQ依赖erlang,注意版本依赖
- [RabbitMQ下载](https://github.com/rabbitmq/rabbitmq-server/releases)
- RabbitMQ配置文件 `./doc/config/rabbitmq-dev.yml`
- [erlang下载](https://www.erlang.org/downloads)

#### 5. Redis配置
- [Redis下载](https://redis.io/download)
- Redis配置文件 `./doc/config/redis-dev.yml`

#### 6. MysSQL配置

- 导入movie数据库

    `sudo mysql -uroot -p movie < ./doc/sql/movie_import.sql`

- 导入测试数据

    `sudo mysql -uroot -p movie < ./doc/sql/movie_default.sql`

- MySQL配置文件 

    `./doc/config/mysql-dev.yml`

#### 7. NeteaseCloudMusicApi服务 (**暂时方案**)
`./tools.sh`

#### 8. zipkin服务 (**非必要**)

`./tools.sh`

#### 9. 修改部分配置文件绝对路径 (**非必要**)

- oauth2秘钥 key.location `./doc/config/oauth2-server-dev.yml`
- api文档生成器配置文件 plugin-configFile `./pom.xml`
- api文档输出 outPath `./doc/api/smart-doc.json`
- Mybatis通用插件 targetPackage `./movie-dal/src/main/resources/mybatis/generatorConfig.xml`

#### 10. server启动顺序

eureka -> config -> zipkin -> server list -> gateway

#### 11. New Pull Request请提交到**dev**分支

## 声明

- 本项目的目标用户为**深度电影迷**

- 如有侵权请联系本人,将立即删除对应条目

- 免费提供doubans三级域名book,music等解析，用你的作品联系我

- 本项目有很多很多需要改进的地方！欢迎大家一起完善这个项目
