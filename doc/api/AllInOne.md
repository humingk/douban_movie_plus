# 豆瓣电影Plus RESTful-API文档
Version |  Update Time  | Status | Author |  Description
------|--------|-----|------|-------
2.0.0||create|humingk|创建RESTful-API文档

## 豆瓣影人API
### 豆瓣影人基础信息
**URL:** http://localhost:8080/celebrity/douban/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括影人头像,影人简介等

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣影人ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/bases?id=645
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─id|int64|豆瓣影人ID|-
└─urlCelebrityDouban|string|豆瓣影人链接|-
└─idCelebrityImdb|string|IMDB影人ID|-
└─urlCelebrityImdb|string|IMDB影人链接|-
└─nameZh|string|豆瓣影人中文名|-
└─nameOrigin|string|豆瓣影人英文名|-
└─sex|string|性别|-
└─birthDate|string|生日日期|-
└─urlPortrait|string|豆瓣影人海报链接|-
└─summary|string|影人简介|-

**Response-example:**
```
{
	"code":925,
	"msg":"6k0n9s",
	"data":{
		"id":422,
		"urlCelebrityDouban":"l9rv2r",
		"idCelebrityImdb":"xmrm5v",
		"urlCelebrityImdb":"5cks9t",
		"nameZh":"2lil2b",
		"nameOrigin":"pz8drh",
		"sex":"uvj4t2",
		"birthDate":"2020-02-16",
		"urlPortrait":"3sar5y",
		"summary":"d8hegg"
	}
}
```

### 豆瓣影人详细信息
**URL:** http://localhost:8080/celebrity/douban/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括影人基础信息，别称，图片，相关的豆瓣电影，获得的奖项

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣影人ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/details?id=772
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─base|object|豆瓣影人基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityImdb|string|IMDB影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣影人中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sex|string|性别|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthDate|string|生日日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPortrait|string|豆瓣影人海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|影人简介|-
└─aliasList|array|豆瓣影人别称列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameAlias|string|豆瓣影人别称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isNikename|string|是否为昵称 0-本名 1-昵称|-
└─imageList|array|豆瓣影人图片列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣图片ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageSqxs|string|豆瓣图片链接 sqxs|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageS|string|豆瓣图片链接 s|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageM|string|豆瓣图片链接 m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageL|string|豆瓣图片链接 L|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|string|序号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─length|int32|Large版本的长 /px|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─width|int32|Large版本的宽 /px|-
└─movieList|array|与豆瓣影人相关的豆瓣电影列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片类型ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieImdb|string|IMDB电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|上映时间 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣电影中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|豆瓣电影运行片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|豆瓣电影海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─haveSeen|int32|已看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─wannaSee|int32|想看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
└─awardList|array|豆瓣影人-电影奖项|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idAwardMovie|string|获奖奖项ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|奖项中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlAward|string|奖项链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|获奖豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeAward|string|奖项的类别中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─awardTh|int16|获奖奖项届数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isNominated|string|是否提名 0-仅提名未获奖 1-已提名且获奖|-

**Response-example:**
```
{
	"code":113,
	"msg":"asq24i",
	"data":{
		"base":{
			"id":718,
			"urlCelebrityDouban":"qdvaem",
			"idCelebrityImdb":"izic7f",
			"urlCelebrityImdb":"5a2phz",
			"nameZh":"8v7qnu",
			"nameOrigin":"1hngn8",
			"sex":"6biatv",
			"birthDate":"2020-02-16",
			"urlPortrait":"5y6li8",
			"summary":"prgiyc"
		},
		"aliasList":[
			{
				"nameAlias":"ucllxw",
				"isNikename":"h1gvdr"
			}
		],
		"imageList":[
			{
				"id":519,
				"urlImageSqxs":"1xejco",
				"urlImageS":"fqomjv",
				"urlImageM":"d4n1zl",
				"urlImageL":"xv7tnt",
				"sort":"4y8u5u",
				"length":94,
				"width":125
			}
		],
		"movieList":[
			{
				"id":891,
				"urlMovieDouban":"wmx9at",
				"idTypeVideo":"ou4q71",
				"typeVideo":"sm53x8",
				"idMovieImdb":"ztwrec",
				"urlMovieImdb":"59wqfn",
				"startYear":20358,
				"nameZh":"3utssp",
				"nameOrigin":"67ue35",
				"runtime":30925,
				"urlPoster":"ylsfrp",
				"haveSeen":816,
				"wannaSee":487,
				"summary":"wn6xfy",
				"idProfession":"ujafle",
				"profession":"dh3qxe",
				"sort":11723
			}
		],
		"awardList":[
			{
				"idMovieDouban":883,
				"idAwardMovie":"hp5bls",
				"nameZh":"tvjccn",
				"urlAward":"rb97k6",
				"idCelebrityDouban":115,
				"urlCelebrityDouban":"rqd94v",
				"typeAward":"pw1wkv",
				"awardTh":26871,
				"isNominated":"14buxy"
			}
		]
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
id|int64|豆瓣影人ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/awards?id=667&offset=0&limit=10
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
	"code":905,
	"msg":"lx18cw",
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
id|int64|豆瓣影人ID|true|-
offset|int32|合作次数偏移量（默认0）|false|-
limit|int32|合作次数限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/cooperators_bases?id=742&offset=0&limit=10
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
	"code":940,
	"msg":"g1f30x",
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
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/douban/search_details?keyword=pv18qx&offset=0&limit=10
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
	"code":826,
	"msg":"y7868f",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## IMDB影人API
### IMDB影人基础信息
**URL:** http://localhost:8080/celebrity/imdb/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 简略

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|IMDB影人ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/imdb/bases?id=37
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─id|string|IMDB影人ID|-
└─nameEn|string|IMDB影人英文名|-
└─birthYear|int16|出生年份 /year|-
└─idCelebrityDouban|int64|豆瓣影人ID 0-未匹配 1-已匹配|-

**Response-example:**
```
{
	"code":465,
	"msg":"w7vspl",
	"data":{
		"id":"87",
		"nameEn":"zo2eyq",
		"birthYear":30126,
		"idCelebrityDouban":571
	}
}
```

### IMDB影人详细信息
**URL:** http://localhost:8080/celebrity/imdb/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括影人基础信息，相关的IMDB电影

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|IMDB影人ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/imdb/details?id=44
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─base|object|IMDB影人基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthYear|int16|出生年份 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID 0-未匹配 1-已匹配|-
└─movieList|array|与IMDB影人相关的IMDB电影|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片类型ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB电影英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|IMDB电影发行年份|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isAdult|string|是否是成人电影 0-不是 1-是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|IMDB电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|IMDB电影片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|IMDB海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-

**Response-example:**
```
{
	"code":604,
	"msg":"ma0v5p",
	"data":{
		"base":{
			"id":"87",
			"nameEn":"18hto3",
			"birthYear":21712,
			"idCelebrityDouban":42
		},
		"movieList":[
			{
				"id":"87",
				"idTypeVideo":"5d5r2y",
				"typeVideo":"asxlps",
				"nameEn":"fgkwoi",
				"startYear":28071,
				"isAdult":"0b91dp",
				"nameOrigin":"g8s31f",
				"runtime":6883,
				"urlPoster":"t9bryp",
				"idMovieDouban":284,
				"summary":"6d1km1",
				"idProfession":"sxeybt",
				"profession":"lo2dru"
			}
		]
	}
}
```

## 影人API
### 影人基础信息
**URL:** http://localhost:8080/celebrity/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括影人头像,影人简介等

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣影人ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/bases?id=359
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─douban|object|豆瓣影人基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityImdb|string|IMDB影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣影人中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sex|string|性别|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthDate|string|生日日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPortrait|string|豆瓣影人海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|影人简介|-
└─imdb|object|IMDB影人基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthYear|int16|出生年份 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID 0-未匹配 1-已匹配|-

**Response-example:**
```
{
	"code":967,
	"msg":"xgkn6a",
	"data":{
		"douban":{
			"id":109,
			"urlCelebrityDouban":"vo1xwv",
			"idCelebrityImdb":"jgwnbz",
			"urlCelebrityImdb":"ptv28c",
			"nameZh":"vvepry",
			"nameOrigin":"1fd4o6",
			"sex":"4hgddo",
			"birthDate":"2020-02-16",
			"urlPortrait":"kb08tr",
			"summary":"rof3rh"
		},
		"imdb":{
			"id":"87",
			"nameEn":"vfsknk",
			"birthYear":5311,
			"idCelebrityDouban":337
		}
	}
}
```

### 影人详细信息
**URL:** http://localhost:8080/celebrity/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括影人基础信息，别称，图片，相关的电影，获得的奖项

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣影人ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/celebrity/details?id=861
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─douban|object|豆瓣影人详细信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─base|object|豆瓣影人基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityImdb|string|IMDB影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣影人中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sex|string|性别|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthDate|string|生日日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPortrait|string|豆瓣影人海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|影人简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─aliasList|array|豆瓣影人别称列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameAlias|string|豆瓣影人别称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isNikename|string|是否为昵称 0-本名 1-昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imageList|array|豆瓣影人图片列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣图片ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageSqxs|string|豆瓣图片链接 sqxs|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageS|string|豆瓣图片链接 s|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageM|string|豆瓣图片链接 m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageL|string|豆瓣图片链接 L|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|string|序号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─length|int32|Large版本的长 /px|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─width|int32|Large版本的宽 /px|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─movieList|array|与豆瓣影人相关的豆瓣电影列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片类型ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieImdb|string|IMDB电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|上映时间 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣电影中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|豆瓣电影运行片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|豆瓣电影海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─haveSeen|int32|已看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─wannaSee|int32|想看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─awardList|array|豆瓣影人-电影奖项|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idAwardMovie|string|获奖奖项ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|奖项中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlAward|string|奖项链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|获奖豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeAward|string|奖项的类别中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─awardTh|int16|获奖奖项届数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isNominated|string|是否提名 0-仅提名未获奖 1-已提名且获奖|-
└─imdb|object|IMDB影人详细信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─base|object|IMDB影人基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthYear|int16|出生年份 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─movieList|array|与IMDB影人相关的IMDB电影|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片类型ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB电影英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|IMDB电影发行年份|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isAdult|string|是否是成人电影 0-不是 1-是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|IMDB电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|IMDB电影片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|IMDB海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-

**Response-example:**
```
{
	"code":65,
	"msg":"wsm48t",
	"data":{
		"douban":{
			"base":{
				"id":254,
				"urlCelebrityDouban":"8sg7mf",
				"idCelebrityImdb":"7un791",
				"urlCelebrityImdb":"y7bdnf",
				"nameZh":"hnc250",
				"nameOrigin":"g7yhcx",
				"sex":"e05ja7",
				"birthDate":"2020-02-16",
				"urlPortrait":"9l0orl",
				"summary":"s2sr0w"
			},
			"aliasList":[
				{
					"nameAlias":"roxc1x",
					"isNikename":"64rk4x"
				}
			],
			"imageList":[
				{
					"id":756,
					"urlImageSqxs":"3xchfu",
					"urlImageS":"6q1sa6",
					"urlImageM":"vi3v55",
					"urlImageL":"hrqqqz",
					"sort":"n9ek4r",
					"length":600,
					"width":29
				}
			],
			"movieList":[
				{
					"id":341,
					"urlMovieDouban":"5vf64y",
					"idTypeVideo":"e3hex6",
					"typeVideo":"7qectf",
					"idMovieImdb":"trebvj",
					"urlMovieImdb":"7zprel",
					"startYear":1320,
					"nameZh":"9q5ohk",
					"nameOrigin":"ttcd9r",
					"runtime":17243,
					"urlPoster":"e5w1g8",
					"haveSeen":276,
					"wannaSee":823,
					"summary":"6wve9f",
					"idProfession":"dprgpj",
					"profession":"o8of1a",
					"sort":10675
				}
			],
			"awardList":[
				{
					"idMovieDouban":457,
					"idAwardMovie":"0a0j16",
					"nameZh":"f6epgu",
					"urlAward":"9yw6sd",
					"idCelebrityDouban":252,
					"urlCelebrityDouban":"6w1nsc",
					"typeAward":"euegep",
					"awardTh":17700,
					"isNominated":"o3exmj"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"87",
				"nameEn":"mughr4",
				"birthYear":8421,
				"idCelebrityDouban":990
			},
			"movieList":[
				{
					"id":"87",
					"idTypeVideo":"zywmwa",
					"typeVideo":"6bf9l4",
					"nameEn":"e1d3h9",
					"startYear":9408,
					"isAdult":"l3s2fs",
					"nameOrigin":"yp2qsk",
					"runtime":2281,
					"urlPoster":"m7jasx",
					"idMovieDouban":235,
					"summary":"a24jt9",
					"idProfession":"773l00",
					"profession":"nbb83b"
				}
			]
		}
	}
}
```

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
id|int64|豆瓣电影ID|true|-
songLimit|int32|歌曲数目限制数（默认8）|false|-
playlistLimit|int32|歌单数目限制数（默认1）|false|-
playlistSongLimit|int32|歌单内歌曲数目限制数（默认8）|false|-
albumLimit|int32|专辑数目限制数（默认1）|false|-
albumSongLimit|int32|专辑内歌曲数目限制数（默认8）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/music/netease/plays?id=87&songLimit=8&playlistLimit=1&playlistSongLimit=8&albumLimit=1&albumSongLimit=8
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
	"code":795,
	"msg":"hy2v0m",
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
id|int64|网易云音乐歌曲ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认8）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/music/netease/hot_comments?id=562&offset=0&limit=8
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
	"code":465,
	"msg":"oiecb6",
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
id|int64|豆瓣电影ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/zhihu/questions?id=287&offset=0&limit=10
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
	"code":688,
	"msg":"i3qggf",
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
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/rate/details?id=350
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
	"code":318,
	"msg":"m3ceti",
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
id|int64|豆瓣电影ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/mvoie/scene/details?id=478&offset=0&limit=10
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
	"code":975,
	"msg":"xnyye4",
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

**Description:** 包括电影海报,电影简介等基础信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/bases?id=972
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─id|int64|豆瓣电影ID|-
└─urlMovieDouban|string|豆瓣电影链接|-
└─idTypeVideo|string|影片类型ID|-
└─typeVideo|string|影片类型|-
└─idMovieImdb|string|IMDB电影ID|-
└─urlMovieImdb|string|IMDB电影链接|-
└─startYear|int16|上映时间 /year|-
└─nameZh|string|豆瓣电影中文名|-
└─nameOrigin|string|豆瓣电影原始名|-
└─runtime|int16|豆瓣电影运行片长 /m|-
└─urlPoster|string|豆瓣电影海报链接|-
└─haveSeen|int32|已看人数|-
└─wannaSee|int32|想看人数|-
└─summary|string|简介|-

**Response-example:**
```
{
	"code":853,
	"msg":"l1f54o",
	"data":{
		"id":848,
		"urlMovieDouban":"bff0ys",
		"idTypeVideo":"podq2d",
		"typeVideo":"ue9qgn",
		"idMovieImdb":"c0k9aw",
		"urlMovieImdb":"r1uqaf",
		"startYear":23065,
		"nameZh":"ip4hrm",
		"nameOrigin":"21913l",
		"runtime":26109,
		"urlPoster":"lnco63",
		"haveSeen":351,
		"wannaSee":713,
		"summary":"r7uekj"
	}
}
```

### 豆瓣电影详情信息
**URL:** http://localhost:8080/movie/douban/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括电影基础信息、评分信息、标签类型、相关影人基础信息、图片、预告片、热门影评短评、j奖项等

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/details?id=110
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─base|object|豆瓣电影基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片类型ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieImdb|string|IMDB电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|上映时间 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣电影中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|豆瓣电影运行片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|豆瓣电影海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─haveSeen|int32|已看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─wannaSee|int32|想看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-
└─rate|object|豆瓣电影评分信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score|number|豆瓣电影评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─vote|int32|豆瓣电影评分人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score5|number|豆瓣5星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score4|number|豆瓣4星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score3|number|豆瓣3星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score2|number|豆瓣2星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score1|number|豆瓣1星比例|-
└─aliasList|array|豆瓣电影别名列表|-
└─typeList|array|豆瓣电影-类型列表|-
└─tagList|array|豆瓣电影标签列表|-
└─celebrityList|array|豆瓣电影影人列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityImdb|string|IMDB影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣影人中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sex|string|性别|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthDate|string|生日日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPortrait|string|豆瓣影人海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|影人简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
└─trailerList|array|豆瓣电影预告片列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影预告片ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlTrailer|string|预告片豆瓣链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlVideo|string|预告片mp4链接|-
└─imageList|array|豆瓣电影图片列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣图片ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageSqxs|string|豆瓣图片链接 sqxs|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageS|string|豆瓣图片链接 s|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageM|string|豆瓣图片链接 m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageL|string|豆瓣图片链接 L|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|string|序号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─length|int32|Large版本的长 /px|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─width|int32|Large版本的宽 /px|-
└─classicList|array|豆瓣电影经典台词列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影经典台词ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─content|string|经典台词内容|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─happenTime|int32|经典台词在影片中的出现时间 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─agreeVote|int32|经典台词获得的赞同数|-
└─reviewList|array|豆瓣电影热门影评列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影影评ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlReview|string|影评链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─agreeVote|int32|赞同数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─againstVote|int32|反对数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createDatetime|string|影评日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─title|string|影评标题|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─content|string|影评内容|-
└─awardList|array|豆瓣电影奖项列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idAwardMovie|string|获奖奖项ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|奖项中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlAward|string|奖项链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|获奖豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeAward|string|奖项的类别中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─awardTh|int16|获奖奖项届数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isNominated|string|是否提名 0-仅提名未获奖 1-已提名且获奖|-
└─commentList|array|豆瓣电影热门评论列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idUserDouban|string|豆瓣用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlUserDouban|string|豆瓣用户链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─agreeVote|int16|投票数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createDate|string|短评日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─content|string|短评内容|-

**Response-example:**
```
{
	"code":335,
	"msg":"02fqsw",
	"data":{
		"base":{
			"id":953,
			"urlMovieDouban":"5jm1dv",
			"idTypeVideo":"wbb7bb",
			"typeVideo":"kjkrh9",
			"idMovieImdb":"2qltsg",
			"urlMovieImdb":"aenbcx",
			"startYear":18148,
			"nameZh":"m3vxbo",
			"nameOrigin":"gyl77m",
			"runtime":1995,
			"urlPoster":"587p1j",
			"haveSeen":427,
			"wannaSee":646,
			"summary":"oyv16y"
		},
		"rate":{
			"id":375,
			"score":868,
			"vote":486,
			"score5":761,
			"score4":769,
			"score3":223,
			"score2":531,
			"score1":354
		},
		"aliasList":[
			"tthfgb"
		],
		"typeList":[
			"4nctc0"
		],
		"tagList":[
			"gwqkgb"
		],
		"celebrityList":[
			{
				"id":602,
				"urlCelebrityDouban":"nu4dm1",
				"idCelebrityImdb":"q1my5r",
				"urlCelebrityImdb":"jgeo8r",
				"nameZh":"wydhwj",
				"nameOrigin":"7uk1ur",
				"sex":"q49zkb",
				"birthDate":"2020-02-16",
				"urlPortrait":"fplnyk",
				"summary":"1tktdi",
				"idProfession":"n7gty6",
				"profession":"7ea6kf",
				"sort":13673
			}
		],
		"trailerList":[
			{
				"id":209,
				"idMovieDouban":597,
				"urlTrailer":"k76mk1",
				"urlVideo":"bhuwvf"
			}
		],
		"imageList":[
			{
				"id":812,
				"urlImageSqxs":"z8ke17",
				"urlImageS":"xplyi4",
				"urlImageM":"o0lic2",
				"urlImageL":"xd505g",
				"sort":"chwf79",
				"length":529,
				"width":914
			}
		],
		"classicList":[
			{
				"id":657,
				"idMovieDouban":927,
				"content":"qx18wq",
				"happenTime":762,
				"agreeVote":858
			}
		],
		"reviewList":[
			{
				"id":363,
				"urlReview":"phv2jp",
				"agreeVote":224,
				"againstVote":937,
				"createDatetime":"2020-02-16 23:04:34",
				"title":"io16ub",
				"content":"h5ejui"
			}
		],
		"awardList":[
			{
				"idMovieDouban":628,
				"idAwardMovie":"dgexzu",
				"nameZh":"jc12gl",
				"urlAward":"ls7mde",
				"idCelebrityDouban":81,
				"urlCelebrityDouban":"sz9d0j",
				"typeAward":"qjiscn",
				"awardTh":17619,
				"isNominated":"ldi5rg"
			}
		],
		"commentList":[
			{
				"idMovieDouban":76,
				"idUserDouban":"apjvqt",
				"urlUserDouban":"jm7uqs",
				"agreeVote":31766,
				"createDate":"2020-02-16",
				"content":"uf450g"
			}
		]
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
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/images?id=226
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
	"code":169,
	"msg":"rdjs3d",
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
id|int64|豆瓣电影ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/hot_comments?id=779&offset=0&limit=10
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
	"code":125,
	"msg":"ifci4o",
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
id|int64|豆瓣电影ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/hot_reviews?id=728&offset=0&limit=10
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
	"code":399,
	"msg":"gj4i26",
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
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/search_tips?keyword=mld4ek&offset=0&limit=10
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
	"code":256,
	"msg":"4f2npe",
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
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/douban/search_details?keyword=qjnj3j&offset=0&limit=10
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
	"code":905,
	"msg":"eueny8",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## IMDB电影API
### IMDB电影基础信息
**URL:** http://localhost:8080/movie/imdb/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括电影海报、电影简介等

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|IMDB电影ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/imdb/bases?id=336
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─id|string|IMDB电影ID|-
└─urlMovieImdb|string|IMDB电影链接|-
└─idTypeVideo|string|影片种类ID|-
└─typeVideo|string|影片种类|-
└─nameEn|string|IMDB电影英文名|-
└─startYear|int16|IMDB电影发行年份|-
└─isAdult|string|是否是成人电影 0-不是 1-是|-
└─nameOrigin|string|IMDB电影原始名|-
└─runtime|int16|IMDB电影片长 /m|-
└─urlPoster|string|IMDB海报链接|-
└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
└─summary|string|简介|-

**Response-example:**
```
{
	"code":327,
	"msg":"4aualf",
	"data":{
		"id":"87",
		"urlMovieImdb":"xv9qow",
		"idTypeVideo":"jalabr",
		"typeVideo":"ob8xy3",
		"nameEn":"7ryu1m",
		"startYear":16574,
		"isAdult":"93dqvg",
		"nameOrigin":"3pd687",
		"runtime":17580,
		"urlPoster":"6rn9uw",
		"idMovieDouban":301,
		"summary":"xcys8o"
	}
}
```

### IMDB电影详情信息
**URL:** http://localhost:8080/movie/imdb/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括电影基础信息、评分、相关影人信息等

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|IMDB电影ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/imdb/details?id=591
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─base|object|IMDB电影基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieImdb|string|IMDB电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片种类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片种类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB电影英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|IMDB电影发行年份|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isAdult|string|是否是成人电影 0-不是 1-是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|IMDB电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|IMDB电影片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|IMDB海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-
└─rate|object|IMDB电影评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imdbScore|number|IMDB评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imdbVote|int32|IMDB评分人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tomatoScore|number|烂番茄新鲜度|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mtcScore|number|MTC评分|-
└─typeList|array|IMDB电影类型列表|-
└─celebrityList|array|IMDB电影影人列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityImdb|string|IMDB影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthYear|int16|出生年份 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-

**Response-example:**
```
{
	"code":983,
	"msg":"bs0s2s",
	"data":{
		"base":{
			"id":"87",
			"urlMovieImdb":"a9blal",
			"idTypeVideo":"awgkhb",
			"typeVideo":"mz505k",
			"nameEn":"526ca4",
			"startYear":10226,
			"isAdult":"vsrtl9",
			"nameOrigin":"twg0r6",
			"runtime":24608,
			"urlPoster":"6jv08i",
			"idMovieDouban":469,
			"summary":"dgpebf"
		},
		"rate":{
			"idMovieImdb":"4v2o09",
			"imdbScore":330,
			"imdbVote":346,
			"tomatoScore":541,
			"mtcScore":863
		},
		"typeList":[
			"8y683h"
		],
		"celebrityList":[
			{
				"idCelebrityImdb":"632k45",
				"urlCelebrityImdb":"eqbkz7",
				"idMovieImdb":"4jnk9g",
				"idCelebrityDouban":588,
				"urlCelebrityDouban":"rolrr6",
				"nameEn":"d3kkf2",
				"birthYear":3148,
				"idProfession":"y8nwjx",
				"profession":"woy7v6"
			}
		]
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
id|int64|豆瓣电影ID|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/resource/details?id=84&offset=0&limit=10
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
	"code":213,
	"msg":"dq5613",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 电影API
### 电影基础信息
**URL:** http://localhost:8080/movie/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影和IMDB电影,包括电影海报,电影简介等基础信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/bases?id=713
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─douban|object|豆瓣电影基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片类型ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieImdb|string|IMDB电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|上映时间 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣电影中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|豆瓣电影运行片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|豆瓣电影海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─haveSeen|int32|已看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─wannaSee|int32|想看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-
└─imdb|object|IMDB电影基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieImdb|string|IMDB电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片种类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片种类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB电影英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|IMDB电影发行年份|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isAdult|string|是否是成人电影 0-不是 1-是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|IMDB电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|IMDB电影片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|IMDB海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-

**Response-example:**
```
{
	"code":673,
	"msg":"imy5wo",
	"data":{
		"douban":{
			"id":812,
			"urlMovieDouban":"7t3351",
			"idTypeVideo":"kvhwj3",
			"typeVideo":"sooa0l",
			"idMovieImdb":"3l3qj5",
			"urlMovieImdb":"mb3lji",
			"startYear":18359,
			"nameZh":"xdbxpv",
			"nameOrigin":"uidsg0",
			"runtime":31764,
			"urlPoster":"umyh0n",
			"haveSeen":276,
			"wannaSee":641,
			"summary":"7io7yn"
		},
		"imdb":{
			"id":"87",
			"urlMovieImdb":"8o6mw1",
			"idTypeVideo":"t5m1t4",
			"typeVideo":"jk5oq6",
			"nameEn":"9uzi5z",
			"startYear":6931,
			"isAdult":"cwbl9y",
			"nameOrigin":"twsvm9",
			"runtime":32266,
			"urlPoster":"3vcl8u",
			"idMovieDouban":36,
			"summary":"5ya42q"
		}
	}
}
```

### 电影详情信息
**URL:** http://localhost:8080/movie/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影和IMDB电影,包括电影基础信息、评分信息、标签类型、相关影人基础信息、图片、预告片、热门影评短评、j奖项等

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/movie/details?id=365
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─douban|object|豆瓣电影详细信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─base|object|豆瓣电影基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片类型ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieImdb|string|IMDB电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|上映时间 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣电影中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|豆瓣电影运行片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|豆瓣电影海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─haveSeen|int32|已看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─wannaSee|int32|想看人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rate|object|豆瓣电影评分信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score|number|豆瓣电影评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─vote|int32|豆瓣电影评分人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score5|number|豆瓣5星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score4|number|豆瓣4星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score3|number|豆瓣3星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score2|number|豆瓣2星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score1|number|豆瓣1星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─aliasList|array|豆瓣电影别名列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeList|array|豆瓣电影-类型列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tagList|array|豆瓣电影标签列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─celebrityList|array|豆瓣电影影人列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityImdb|string|IMDB影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|豆瓣影人中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|豆瓣影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sex|string|性别|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthDate|string|生日日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPortrait|string|豆瓣影人海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|影人简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trailerList|array|豆瓣电影预告片列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影预告片ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlTrailer|string|预告片豆瓣链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlVideo|string|预告片mp4链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imageList|array|豆瓣电影图片列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣图片ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageSqxs|string|豆瓣图片链接 sqxs|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageS|string|豆瓣图片链接 s|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageM|string|豆瓣图片链接 m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImageL|string|豆瓣图片链接 L|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|string|序号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─length|int32|Large版本的长 /px|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─width|int32|Large版本的宽 /px|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classicList|array|豆瓣电影经典台词列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影经典台词ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─content|string|经典台词内容|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─happenTime|int32|经典台词在影片中的出现时间 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─agreeVote|int32|经典台词获得的赞同数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─reviewList|array|豆瓣电影热门影评列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影影评ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlReview|string|影评链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─agreeVote|int32|赞同数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─againstVote|int32|反对数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createDatetime|string|影评日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─title|string|影评标题|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─content|string|影评内容|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─awardList|array|豆瓣电影奖项列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idAwardMovie|string|获奖奖项ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|奖项中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlAward|string|奖项链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|获奖豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeAward|string|奖项的类别中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─awardTh|int16|获奖奖项届数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isNominated|string|是否提名 0-仅提名未获奖 1-已提名且获奖|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─commentList|array|豆瓣电影热门评论列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idUserDouban|string|豆瓣用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlUserDouban|string|豆瓣用户链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─agreeVote|int16|投票数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createDate|string|短评日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─content|string|短评内容|-
└─imdb|object|IMDB电影详细信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─base|object|IMDB电影基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieImdb|string|IMDB电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idTypeVideo|string|影片种类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeVideo|string|影片种类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB电影英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|IMDB电影发行年份|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isAdult|string|是否是成人电影 0-不是 1-是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOrigin|string|IMDB电影原始名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─runtime|int16|IMDB电影片长 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|IMDB海报链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─summary|string|简介|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rate|object|IMDB电影评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imdbScore|number|IMDB评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imdbVote|int32|IMDB评分人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tomatoScore|number|烂番茄新鲜度|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mtcScore|number|MTC评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeList|array|IMDB电影类型列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─celebrityList|array|IMDB电影影人列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|string|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityImdb|string|IMDB影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|string|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthYear|int16|出生年份 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-

**Response-example:**
```
{
	"code":79,
	"msg":"el430l",
	"data":{
		"douban":{
			"base":{
				"id":141,
				"urlMovieDouban":"cqrz7c",
				"idTypeVideo":"4hopu5",
				"typeVideo":"y22xof",
				"idMovieImdb":"h04rgh",
				"urlMovieImdb":"lohngz",
				"startYear":27457,
				"nameZh":"16q6jt",
				"nameOrigin":"3o34v8",
				"runtime":13485,
				"urlPoster":"s8ec97",
				"haveSeen":626,
				"wannaSee":465,
				"summary":"auwcax"
			},
			"rate":{
				"id":327,
				"score":842,
				"vote":814,
				"score5":151,
				"score4":862,
				"score3":731,
				"score2":40,
				"score1":192
			},
			"aliasList":[
				"x2uzol"
			],
			"typeList":[
				"64w4yz"
			],
			"tagList":[
				"h705dn"
			],
			"celebrityList":[
				{
					"id":638,
					"urlCelebrityDouban":"b1xe8a",
					"idCelebrityImdb":"jp70gu",
					"urlCelebrityImdb":"apoieb",
					"nameZh":"2d6txk",
					"nameOrigin":"kq6m4p",
					"sex":"svebby",
					"birthDate":"2020-02-16",
					"urlPortrait":"ytjd7u",
					"summary":"dfx2oe",
					"idProfession":"mey6dd",
					"profession":"mndqyb",
					"sort":5815
				}
			],
			"trailerList":[
				{
					"id":850,
					"idMovieDouban":227,
					"urlTrailer":"kzrvpv",
					"urlVideo":"15feq0"
				}
			],
			"imageList":[
				{
					"id":386,
					"urlImageSqxs":"0kntas",
					"urlImageS":"xtsaa2",
					"urlImageM":"3fimyy",
					"urlImageL":"ziicvw",
					"sort":"611ot9",
					"length":188,
					"width":429
				}
			],
			"classicList":[
				{
					"id":956,
					"idMovieDouban":425,
					"content":"uft502",
					"happenTime":498,
					"agreeVote":423
				}
			],
			"reviewList":[
				{
					"id":745,
					"urlReview":"k30i8i",
					"agreeVote":541,
					"againstVote":304,
					"createDatetime":"2020-02-16 23:04:34",
					"title":"lsy1zn",
					"content":"xn22y2"
				}
			],
			"awardList":[
				{
					"idMovieDouban":307,
					"idAwardMovie":"8ra0d6",
					"nameZh":"uo8a33",
					"urlAward":"jeqpny",
					"idCelebrityDouban":0,
					"urlCelebrityDouban":"x32ce3",
					"typeAward":"43j6xs",
					"awardTh":7395,
					"isNominated":"pci8dy"
				}
			],
			"commentList":[
				{
					"idMovieDouban":121,
					"idUserDouban":"35lzig",
					"urlUserDouban":"0r0dt3",
					"agreeVote":15611,
					"createDate":"2020-02-16",
					"content":"8shse8"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"87",
				"urlMovieImdb":"sd234x",
				"idTypeVideo":"apprdm",
				"typeVideo":"8pym36",
				"nameEn":"zvsehf",
				"startYear":10281,
				"isAdult":"drr257",
				"nameOrigin":"fjuw7r",
				"runtime":26423,
				"urlPoster":"fcee5h",
				"idMovieDouban":38,
				"summary":"409ipy"
			},
			"rate":{
				"idMovieImdb":"y57z7m",
				"imdbScore":706,
				"imdbVote":707,
				"tomatoScore":909,
				"mtcScore":763
			},
			"typeList":[
				"jb205e"
			],
			"celebrityList":[
				{
					"idCelebrityImdb":"qsjz7y",
					"urlCelebrityImdb":"bkvrdf",
					"idMovieImdb":"mutvdz",
					"idCelebrityDouban":980,
					"urlCelebrityDouban":"ia5xsh",
					"nameEn":"qshiva",
					"birthYear":4285,
					"idProfession":"fztab1",
					"profession":"w41hne"
				}
			]
		}
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
email|string|用户邮箱|true|-
password|string|密码|true|-

**Request-example:**
```
curl -X POST -i http://localhost:8080/user/login  --data 'email=鹭洋.姚@hotmail.com&password=shhot1'
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
	"code":318,
	"msg":"3thz68",
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
code|string|授权码（授权码模式）|true|-
state|string|github_login传入的state|true|-

**Request-example:**
```
curl -X GET -i http://localhost:8080/user/github_callback?code=33927&state=ndm5oe
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
	"code":516,
	"msg":"i5kpty",
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
id|string|豆瓣个人域名(可选,默认随机UUID)|false|-
email|string|邮箱|true|-
password|string|密码|true|-

**Request-example:**
```
curl -X POST -i http://localhost:8080/user/register  --data 'id=&email=鹭洋.姚@hotmail.com&password=c02nrd'
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
	"code":819,
	"msg":"cgfh7c",
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
	"code":667,
	"msg":"uhexwe",
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
curl -X PUT -i http://localhost:8080/user/update_id  --data 'id=87'
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
	"code":655,
	"msg":"d8ancw",
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
limit|int32|限制数（默认10）|false|-

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
	"code":658,
	"msg":"8bbbbo",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```


