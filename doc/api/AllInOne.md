# 豆瓣电影Plus RESTful-API文档
Version |  Update Time  | Status | Author |  Description
------|--------|-----|------|-------
2.0.0||create|humingk|创建RESTful-API文档



## 豆瓣影人API
### 豆瓣影人基础信息
**URL:** http://localhost:8080/celebrity/douban/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括影人图片

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|影人豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/bases?id=329
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
	"code":584,
	"msg":"acskvp",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣影人基础信息列表
**URL:** http://localhost:8080/celebrity/douban/bases_list

**Type:** GET


**Content-Type:** application/json; charset=utf-8

**Description:** 包括影人图片

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
idList|array||false|

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/bases_list
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
	"code":138,
	"msg":"a5czj3",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣影人详细信息
**URL:** http://localhost:8080/celebrity/douban/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括影人图片、基础信息、参演电影基础信息（电影海报、基础信息）、影人简介

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|影人豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/details?id=213
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
	"code":970,
	"msg":"k8bshm",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣影人奖项
**URL:** http://localhost:8080/celebrity/douban/awards

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括电影基础信息、奖项信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    豆瓣影人ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/awards?id=488&offset=0&limit=10
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
	"code":736,
	"msg":"bedeem",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣影人合作过的影人基础信息
**URL:** http://localhost:8080/celebrity/douban/cooperators_bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括影人照片、基础信息、相关电影基础信息（电影海报、基础信息）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    影人豆瓣ID|true|-
offset|int32|合作次数偏移量（默认0）|false|-
limit|int32| 合作次数限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/cooperators_bases?id=704&offset=0&limit=10
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
	"code":75,
	"msg":"jqp2z6",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣影人搜索结果
**URL:** http://localhost:8080/celebrity/douban/search_details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据影人名称字符串找出豆瓣影人的基本信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32| 偏移量（默认0）|false|-
limit|int32|  限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/search_details?keyword=oong3d&offset=0&limit=10
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
	"code":82,
	"msg":"52r2ja",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## IMDB影人API
## 音乐API
### 豆瓣电影网易云音乐相关播放信息
**URL:** http://localhost:8080/music/netease/plays

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影网易云音乐相关播放信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


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
curl -X GET -i http://localhost:8080/music/netease/plays?id=611&songLimit=8&playlistLimit=1&playlistSongLimit=8&albumLimit=1&albumSongLimit=8
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
	"code":66,
	"msg":"rm57wy",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 网易云音乐热门评论
**URL:** http://localhost:8080/music/netease/hot_comments

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 网易云音乐热门评论

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    网易云音乐歌曲ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认8）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/music/netease/hot_comments?id=615&offset=0&limit=8
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
	"code":171,
	"msg":"8f8ey6",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 知乎API
### 豆瓣电影知乎相关问题
**URL:** http://localhost:8080/movie/zhihu/questions

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影知乎相关问题

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/zhihu/questions?id=801&offset=0&limit=10
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
	"code":260,
	"msg":"282pio",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 电影模块评分API
### 电影评分信息
**URL:** http://localhost:8080/movie/rate/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括豆瓣、IMDB、MTC、猫眼、知乎、烂番茄新鲜度等

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/rate/details?id=408
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
	"code":704,
	"msg":"9v4baw",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 电影场景API
### 电影场景详情
**URL:** http://localhost:8080/mvoie/scene/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 电影场景详情

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/mvoie/scene/details?id=162&offset=0&limit=10
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
	"code":357,
	"msg":"z7vj3g",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 豆瓣电影API
### 豆瓣电影基础信息
**URL:** http://localhost:8080/movie/douban/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括电影海报,电影年份，电影简介等基础信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/bases?id=248
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─id|int64|豆瓣电影ID|-
└─typeVideo|string|影片类型|-
└─idMovieImdb|string|IMDB电影ID 0-未匹配 1-已匹配|-
└─startYear|int16|上映时间 /year|-
└─nameZh|string|豆瓣电影中文名|-
└─nameOrigin|string|豆瓣电影原始名|-
└─runtime|int16|豆瓣电影运行片长 /m|-
└─urlPoster|string|豆瓣电影海报ID|-
└─haveSeen|int32|已看人数|-
└─wannaSee|int32|想看人数|-
└─summary|string|简介|-

**Response-example:**
```
{
	"code":274,
	"msg":"31wu9i",
	"data":{
		"id":894,
		"typeVideo":"ln2x48",
		"idMovieImdb":"rracvg",
		"startYear":7748,
		"nameZh":"il3omv",
		"nameOrigin":"kz1uo2",
		"runtime":9151,
		"urlPoster":"kpxzfn",
		"haveSeen":471,
		"wannaSee":227,
		"summary":"2q4xdw"
	}
}
```

### 豆瓣电影基础信息列表
**URL:** http://localhost:8080/movie/douban/bases_list

**Type:** GET


**Content-Type:** application/json; charset=utf-8

**Description:** 包括电影海报,电影年份，电影简介等基础信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
idList|array||false|

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/bases_list
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─id|int64|豆瓣电影ID|-
└─typeVideo|string|影片类型|-
└─idMovieImdb|string|IMDB电影ID 0-未匹配 1-已匹配|-
└─startYear|int16|上映时间 /year|-
└─nameZh|string|豆瓣电影中文名|-
└─nameOrigin|string|豆瓣电影原始名|-
└─runtime|int16|豆瓣电影运行片长 /m|-
└─urlPoster|string|豆瓣电影海报ID|-
└─haveSeen|int32|已看人数|-
└─wannaSee|int32|想看人数|-
└─summary|string|简介|-

**Response-example:**
```
{
	"code":96,
	"msg":"ykyqrw",
	"data":[
		{
			"id":998,
			"typeVideo":"k5h7w9",
			"idMovieImdb":"kpddtr",
			"startYear":27905,
			"nameZh":"delgom",
			"nameOrigin":"att03c",
			"runtime":31502,
			"urlPoster":"r8vgb5",
			"haveSeen":902,
			"wannaSee":335,
			"summary":"zc0si5"
		}
	]
}
```

### 豆瓣电影详情信息
**URL:** http://localhost:8080/movie/douban/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括电影海报、基础信息、剧情简介

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/details?id=436
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
	"code":161,
	"msg":"madukl",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影图片
**URL:** http://localhost:8080/movie/douban/images

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影图片

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/images?id=690
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
	"code":833,
	"msg":"5bwmpc",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影热门短评
**URL:** http://localhost:8080/movie/douban/hot_comments

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影热门短评

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/hot_comments?id=460&offset=0&limit=10
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
	"code":139,
	"msg":"tpzm0m",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影热门影评
**URL:** http://localhost:8080/movie/douban/hot_reviews

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影热门影评

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/hot_reviews?id=483&offset=0&limit=10
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
	"code":387,
	"msg":"0yz8o8",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影搜索提示
**URL:** http://localhost:8080/movie/douban/search_tips

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据电影名称开头的字符串找出豆瓣电影的基本信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32| 偏移量（默认0）|false|-
limit|int32|  限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/search_tips?keyword=ksy0ei&offset=0&limit=10
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
	"code":268,
	"msg":"vjs5su",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 豆瓣电影搜索结果
**URL:** http://localhost:8080/movie/douban/search_details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据电影名称字符串找出豆瓣电影的基本信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32| 偏移量（默认0）|false|-
limit|int32|  限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/search_details?keyword=nk7umy&offset=0&limit=10
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
	"code":614,
	"msg":"np1yuo",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## IMDB电影API
### IMDB电影详情信息
**URL:** http://localhost:8080/movie/imdb/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括电影海报、包括基础信息、剧情简介

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|电影豆瓣ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/imdb/details?id=415
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
	"code":768,
	"msg":"vu68wm",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 电影资源API
### 电影资源详情
**URL:** http://localhost:8080/movie/resource/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括正版资源、盗版资源、在线资源、离线资源

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|    电影豆瓣ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/resource/details?id=337&offset=0&limit=10
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
	"code":282,
	"msg":"ptpe3y",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 普通用户相关API
### 普通登录
**URL:** http://localhost:8080/user/login

**Type:** POST


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 普通登录

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
email|string|   用户邮箱|true|-
password|string|密码|true|-

**Request-example:**
```
curl -X POST -i http://localhost:8080/user/login  --data 'email=胤祥.苏@gmail.com&password=rciwph'
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
	"code":59,
	"msg":"yob65s",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### github 第三方登录
**URL:** http://localhost:8080/user/github_login

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** github 第三方登录

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-example:**
```
curl -X GET -i http://localhost:8080/user/github_login
```

**Response-example:**
```
This api return nothing.
```

### github 第三方登录 回调方法
**URL:** http://localhost:8080/user/github_callback

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** github 第三方登录 回调方法

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
code|string| 授权码（授权码模式）|true|-
state|string|github_login传入的state|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/user/github_callback?code=90870&state=d6m1j0
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
	"code":412,
	"msg":"7w8wcn",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 用户注册
**URL:** http://localhost:8080/user/register

**Type:** POST


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 用户注册

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|      豆瓣个人域名(可选,默认随机UUID)|false|-
email|string|   邮箱|true|-
password|string|密码|true|-

**Request-example:**
```
curl -X POST -i http://localhost:8080/user/register  --data 'id=&email=胤祥.苏@gmail.com&password=2ftqla'
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
	"code":460,
	"msg":"7s94o0",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 用户信息
**URL:** http://localhost:8080/user/user_info

**Type:** GET


**Content-Type:** application/json; charset=utf-8

**Description:** 用户信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
name|string|No comments found.|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/user/user_info
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
	"code":518,
	"msg":"drhyab",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 更新豆瓣用户ID
**URL:** http://localhost:8080/user/update_id

**Type:** PUT


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 更新豆瓣用户ID

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|豆瓣用户ID|true|-

**Request-example:**
```
curl -X PUT -i http://localhost:8080/user/update_id  --data 'id=47'
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
	"code":257,
	"msg":"8ou655",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## ROOT用户相关API
### 普通用户列表
**URL:** http://localhost:8080/root/users_list

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 普通用户列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
offset|int32|偏移量（默认0）|false|-
limit|int32| 限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/root/users_list?offset=0&limit=10
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
	"code":982,
	"msg":"t7q9w0",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```


