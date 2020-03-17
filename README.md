<div align="center">
<img src="./doc/image/logo3.png"/>
</div>
<div align="center">
<a href="https://travis-ci.org/humingk/douban_movie"><img src="https://travis-ci.org/humingk/douban_movie.svg?branch=master" alt="Build Status"></a>
<a href="https://codebeat.co/projects/github-com-humingk-douban_movie-master"><img src="https://codebeat.co/badges/d666efdf-fbf8-479f-a8ed-dfcb833f0016" alt="codebeat badge"></a>
<a href="https://codecov.io/gh/humingk/douban_movie"><img src="https://codecov.io/gh/humingk/douban_movie/branch/master/graph/badge.svg" alt="codecov]"></a>
<a href=""><img src="https://img.shields.io/github/license/mashape/apistatus.svg" alt="license"></a>
<a href=""><img src="https://img.shields.io/badge/language-java%20python%20javascript-green.svg" alt="language"></a>
</div>

# 网站地址

https://movie.doubans.com

---



# 2.0版本开发中，1.0版本详见分支 [v1.0](https://github.com/humingk/douban_movie_plus/tree/v1.0)

# 使用方式

- 从豆瓣电影官网访问(**推荐**)

  例如:

  在二级域名 douban 后面加一个s即可跳转访问

  [https://movie.douban`s`.com/subject/1889243](https://movie.doubans.com/subject/1889243)

- 从首页访问

  https://movie.doubans.com

# 1.0项目框架图

![](./doc/image/structure.png)

# 数据库关系模型图

![ER关系图](./doc/image/movie_2.0_er.png)

# 安装相关
### 下载
`git clone --depth 1 https://github.com/humingk/douban_movie_plus`
### maven导入
### 项目基于JDK1.8
### 修改配置文件绝对路径
- tools.sh项目 base_path
`tools.sh`
- oauth2秘钥 key.location
`doc/config/oauth2-server-dev.yml`
- api文档生成器配置文件 plugin-configFile
`pom.xml`
- api文档输出 outPath
`doc/api/smart-doc.json`
- Mybatis通用插件 mysql相关 3个targetPackage
`movie-dal/src/main/resources/mybatis/generatorConfig.xml`
### zipkin服务(2)
`./tools.sh`
### NeteaseCloudMusicApi服务(暂时)(8)
`./tools.sh`
### rabbitmq 
依赖erlang,注意版本
- <https://github.com/rabbitmq/rabbitmq-server/releases>
- <https://www.erlang.org/downloads>
### Redis默认
### MysSQL默认
### server启动顺序
eureka -> config -> zipkin -> servers -> gateway

