# 豆瓣电影Plus RESTful-API文档
Version |  Update Time  | Status | Author |  Description
------|--------|-----|------|-------
2.0.0||create|humingk|创建RESTful-API文档

[TOC]

## 豆瓣影人API
### 基础信息
豆瓣影人基础信息，包括影人图片
**URL:** https://localhost/celebrity/douban/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 基础信息
豆瓣影人基础信息，包括影人图片

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|影人豆瓣ID|true|-

**Request-example:**

```
curl -X GET -i https://localhost/celebrity/douban/bases?id=699
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":176,
	"msg":"zmax8p",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 基础信息列表
豆瓣影人基础信息列表,包括影人图片
**URL:** https://localhost/celebrity/douban/bases_list

**Type:** GET


**Content-Type:** application/json; charset=utf-8

**Description:** 基础信息列表
豆瓣影人基础信息列表,包括影人图片

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
idList|array||false|

**Request-example:**
```
curl -X GET -i https://localhost/celebrity/douban/bases_list
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":701,
	"msg":"h3zyj3",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 详细信息
豆瓣影人详细信息,包括影人图片、基础信息、参演电影基础信息（电影海报、基础信息）、影人简介
**URL:** https://localhost/celebrity/douban/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 详细信息
豆瓣影人详细信息,包括影人图片、基础信息、参演电影基础信息（电影海报、基础信息）、影人简介

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|影人豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i https://localhost/celebrity/douban/details?id=703
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":908,
	"msg":"8bf6wb",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 奖项
豆瓣影人奖项，包括电影基础信息、奖项信息
**URL:** https://localhost/celebrity/douban/awards

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 奖项
豆瓣影人奖项，包括电影基础信息、奖项信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|No comments found.|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/celebrity/douban/awards?id=989&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":673,
	"msg":"s0u8xy",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 合作影人基础信息
<p>
豆瓣影人合作过的影人基础信息，包括影人照片、基础信息、相关电影基础信息（电影海报、基础信息）
**URL:** https://localhost/celebrity/douban/cooperators_bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 合作影人基础信息
<p>
豆瓣影人合作过的影人基础信息，包括影人照片、基础信息、相关电影基础信息（电影海报、基础信息）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    影人豆瓣ID|true|-
offset|int32|合作次数偏移量（默认0）|false|-
limit|int32| 合作次数限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/celebrity/douban/cooperators_bases?id=163&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":58,
	"msg":"h92h3c",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 搜索结果
豆瓣影人搜索结果,根据影人名称字符串找出豆瓣影人的基本信息列表
**URL:** https://localhost/celebrity/douban/search_details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 搜索结果
豆瓣影人搜索结果,根据影人名称字符串找出豆瓣影人的基本信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32| 偏移量（默认0）|false|-
limit|int32|  限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/celebrity/douban/search_details?keyword=cs252b&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":678,
	"msg":"gq553j",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## IMDB影人API
## 音乐API
### 获取与豆瓣电影相关的网易云音乐播放信息
**URL:** https://localhost/music/netease/plays

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取与豆瓣电影相关的网易云音乐播放信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|               电影豆瓣ID|true|-
songLimit|int32|        歌曲数目限制数（默认8）|false|-
playlistLimit|int32|    歌单数目限制数（默认1）|false|-
playlistSongLimit|int32|歌单内歌曲数目限制数（默认8）|false|-
albumLimit|int32|       专辑数目限制数（默认1）|false|-
albumSongLimit|int32|   专辑内歌曲数目限制数（默认8）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/music/netease/plays?id=586&songLimit=8&playlistLimit=1&playlistSongLimit=8&albumLimit=1&albumSongLimit=8
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":889,
	"msg":"z9941p",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 获取网易云音乐热门评论
**URL:** https://localhost/music/netease/hot_comments

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取网易云音乐热门评论

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    网易云音乐歌曲ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认8）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/music/netease/hot_comments?id=333&offset=0&limit=8
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":285,
	"msg":"gaq522",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 知乎API

### 与豆瓣电影相关的知乎问题
**URL:** https://localhost/movie/zhihu/questions

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 与豆瓣电影相关的知乎问题

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/zhihu/questions?id=342&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":214,
	"msg":"u7f26x",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 电影模块评分API
### 电影所有评分信息(包括豆瓣、IMDB、MTC、猫眼、知乎、烂番茄新鲜度等)
**URL:** https://localhost/movie/rate/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 电影所有评分信息(包括豆瓣、IMDB、MTC、猫眼、知乎、烂番茄新鲜度等)

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/rate/details?id=985
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":393,
	"msg":"nk5h7k",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 电影场景API
### 获取电影场景详情
**URL:** https://localhost/mvoie/scene/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取电影场景详情

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/mvoie/scene/details?id=596&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":368,
	"msg":"dphpna",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 豆瓣电影API
### 豆瓣电影基础信息（包括电影海报、基础信息）
**URL:** https://localhost/movie/douban/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影基础信息（包括电影海报、基础信息）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/douban/bases?id=399
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":532,
	"msg":"her6el",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影基础信息列表（包括电影海报、基础信息）
**URL:** https://localhost/movie/douban/bases_list

**Type:** GET


**Content-Type:** application/json; charset=utf-8

**Description:** 豆瓣电影基础信息列表（包括电影海报、基础信息）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
idList|array||false|

**Request-example:**
```
curl -X GET -i https://localhost/movie/douban/bases_list
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":499,
	"msg":"hel7c3",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影详情信息(包括电影海报、基础信息、剧情简介)
**URL:** https://localhost/movie/douban/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影详情信息(包括电影海报、基础信息、剧情简介)

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/douban/details?id=580
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":861,
	"msg":"fctves",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影图片
**URL:** https://localhost/movie/douban/images

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影图片

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/douban/images?id=615
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":468,
	"msg":"j9bzdv",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影热门短评
**URL:** https://localhost/movie/douban/hot_comments

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影热门短评

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/douban/hot_comments?id=580&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":463,
	"msg":"woi0ju",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影热门影评
**URL:** https://localhost/movie/douban/hot_reviews

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影热门影评

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/douban/hot_reviews?id=373&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":427,
	"msg":"7rjaz5",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影搜索提示
<p>
根据电影名称开头的字符串找出豆瓣电影的基本信息列表
**URL:** https://localhost/movie/douban/search_tips

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影搜索提示
<p>
根据电影名称开头的字符串找出豆瓣电影的基本信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32| 偏移量（默认0）|false|-
limit|int32|  限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/douban/search_tips?keyword=w5ydhr&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":598,
	"msg":"z19mvm",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影搜索结果
<p>
根据电影名称字符串找出豆瓣电影的基本信息列表
**URL:** https://localhost/movie/douban/search_details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影搜索结果
<p>
根据电影名称字符串找出豆瓣电影的基本信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32| 偏移量（默认0）|false|-
limit|int32|  限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/douban/search_details?keyword=j1v7yq&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":95,
	"msg":"f8vhjd",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## IMDB电影API
### IMDB电影详情信息(包括电影海报、包括基础信息、剧情简介)
**URL:** https://localhost/movie/imdb/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** IMDB电影详情信息(包括电影海报、包括基础信息、剧情简介)

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/imdb/details?id=370
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":238,
	"msg":"vlbg25",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 电影资源API
### 电影资源详情（包括正版资源、盗版资源、在线资源、离线资源）
**URL:** https://localhost/movie/resource/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 电影资源详情（包括正版资源、盗版资源、在线资源、离线资源）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/movie/resource/details?id=540&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":278,
	"msg":"t88q9n",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 普通用户相关API
### auth 登录
**URL:** https://localhost/user/login

**Type:** POST


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** auth 登录

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
email|string|   用户邮箱|true|-
password|string|密码|true|-

**Request-example:**
```
curl -X POST -i https://localhost/user/login  --data 'email=昊然.刘@hotmail.com&password=qs9t05'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":944,
	"msg":"296y63",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### github 第三方登录
**URL:** https://localhost/user/github_login

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** github 第三方登录

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-example:**
```
curl -X GET -i https://localhost/user/github_login
```

**Response-example:**
```
This api return nothing.
```

### github 第三方登录 回调方法
**URL:** https://localhost/user/github_callback

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** github 第三方登录 回调方法

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
code|string| 授权码（授权码模式）|true|-
state|string|github_login传入的state|true|-

**Request-example:**
```
curl -X GET -i https://localhost/user/github_callback?code=88872&state=6oqli2
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":424,
	"msg":"y9bmv8",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 用户注册
**URL:** https://localhost/user/register

**Type:** POST


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 用户注册

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|      豆瓣个人域名(可选,默认随机UUID)|false|-
email|string|   邮箱|true|-
password|string|密码|true|-

**Request-example:**
```
curl -X POST -i https://localhost/user/register  --data 'id=&email=昊然.刘@hotmail.com&password=gw5mdo'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":986,
	"msg":"gdoxwa",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 当前用户信息
**URL:** https://localhost/user/user_info

**Type:** GET


**Content-Type:** application/json; charset=utf-8

**Description:** 当前用户信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
name|string|No comments found.|false|-

**Request-example:**
```
curl -X GET -i https://localhost/user/user_info
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":199,
	"msg":"jrfaeh",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 更新豆瓣用户ID
**URL:** https://localhost/user/update_id

**Type:** PUT


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 更新豆瓣用户ID

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|豆瓣用户ID|true|-

**Request-example:**
```
curl -X PUT -i https://localhost/user/update_id  --data 'id=59'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":626,
	"msg":"w1dwbx",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## ROOT用户相关API
### 普通用户列表
**URL:** https://localhost/root/users_list

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 普通用户列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|部分API需要认证访问|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://localhost/root/users_list?offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-

**Response-example:**
```
{
	"code":185,
	"msg":"flbfwt",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```


