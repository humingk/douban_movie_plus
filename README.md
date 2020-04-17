<div align="center">
<img src="./doc/image/logo.png" width="500"/>
</div>
<div align="center">
<a target="_blank" href="https://travis-ci.org/humingk/douban_movie_plus"><img src="https://travis-ci.org/humingk/douban_movie_plus.svg?branch=master" alt="Build Status"></a>
<img src="./doc/image/license-GPL-blue.svg">
<img src="./doc/image/language-Java-green.svg">
</div>

## 使用方法

- 推荐从豆瓣电影官网访问，二级域名`douban`后加`s`即可跳转 [https://movie.douban`s`.com/subject/1889243](https://movie.doubans.com/subject/1889243)


- 调用本项目API服务你的前端应用 [API文档 (html)](https://movie.doubans.com/api) ，[API文档 (md)](./doc/api/AllInOne.md) ，[Postman测试 (json)](./doc/api/postman.json)


- 聊天吹水提建议，欢迎加入QQ豆瓣电影Plus交流群 `476584154` ，口令：`doubans`

## 开发流程

### 前端开发 (Vue)

[前端仓库](https://github.com/humingk/douban_movie_vue)

### 后端开发 (Spring)

#### 0. 代码规范

- [谷歌Java](https://github.com/google/google-java-format) or [阿里巴巴Java](https://github.com/alibaba/p3c)

#### 1. fork

#### 2. clone (替换用户名)

`git clone -b dev --depth 1 https://github.com/humingk/douban_movie_plus`

or

`git clone -b dev --depth 1 git@github.com:humingk/douban_movie_plus.git`

#### 3. 导入项目

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

#### 6. MysSQL配置

- 导入movie数据库
    `sudo mysql -uroot -p movie < ./doc/sql/movie_import.sql`

- 导入测试数据
    `sudo mysql -uroot -p movie < ./doc/sql/movie_default.sql`

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

#### 8. MusicApi服务 (**暂时方案**)

`./tools.sh`

#### 9. zipkin服务 (**非必要**)

`./tools.sh`

#### 10. server启动顺序

`eureka -> config -> zipkin -> server list -> gateway`

#### 11. 测试

测试前启动euraka和config服务

`mvn test`

#### 12. 请提交到**dev**分支

## 声明

- 本项目仅供学习交流，如有侵权请联系本人,将立即删除

- 免费提供doubans三级域名book,music等解析

- 本项目有很多很多需要改进的地方！欢迎大家一起完善这个项目
