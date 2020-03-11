# 豆瓣电影Plus RESTful-API文档
Version |  Update Time  | Status | Author |  Description
------|--------|-----|------|-------
2.0.0||create|humingk|创建RESTful-API文档

## 豆瓣影人API
### 豆瓣影人基础信息
**URL:** http://localhost:8081/v2/celebrity/douban/bases

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
curl -X GET -i http://localhost:8081/v2/celebrity/douban/bases?id=967
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
	"code":912,
	"msg":"u8b1j8",
	"data":{
		"id":457,
		"urlCelebrityDouban":"tn8dxs",
		"idCelebrityImdb":"vsdkc6",
		"urlCelebrityImdb":"k9vdlf",
		"nameZh":"ggmu37",
		"nameOrigin":"b8b446",
		"sex":"hkdzwl",
		"birthDate":"2020-02-28",
		"urlPortrait":"eyhezq",
		"summary":"50kwoc"
	}
}
```

### 豆瓣影人详细信息
**URL:** http://localhost:8081/v2/celebrity/douban/details

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
limit|int32|相关电影限制数(默认10)|false|-

**Request-example:**
```
curl -X GET -i http://localhost:8081/v2/celebrity/douban/details?id=304&limit=10
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
└─movieListOrderByScore|array|与豆瓣影人相关的豆瓣电影列表 order by score|-
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
└─movieListOrderByStartYear|array|与豆瓣影人相关的豆瓣电影列表 order by start year|-
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
	"code":827,
	"msg":"3o52qy",
	"data":{
		"base":{
			"id":492,
			"urlCelebrityDouban":"gbhhpj",
			"idCelebrityImdb":"6cl2yw",
			"urlCelebrityImdb":"x730wi",
			"nameZh":"wbw5rs",
			"nameOrigin":"cuuacv",
			"sex":"filxpc",
			"birthDate":"2020-02-28",
			"urlPortrait":"wfvyhz",
			"summary":"oxtjr5"
		},
		"aliasList":[
			{
				"nameAlias":"5ai8i2",
				"isNikename":"7b3xc4"
			}
		],
		"imageList":[
			{
				"id":580,
				"urlImageSqxs":"k49kca",
				"urlImageS":"jyhanw",
				"urlImageM":"e616i3",
				"urlImageL":"n6d6pm",
				"sort":"e6jfxs",
				"length":550,
				"width":761
			}
		],
		"movieListOrderByScore":[
			{
				"id":820,
				"urlMovieDouban":"r6swtj",
				"idTypeVideo":"l1znmv",
				"typeVideo":"d1nc6o",
				"idMovieImdb":"mnv2w2",
				"urlMovieImdb":"asztrl",
				"startYear":28240,
				"nameZh":"l2h5mp",
				"nameOrigin":"vfz6yi",
				"runtime":22047,
				"urlPoster":"ghulre",
				"haveSeen":860,
				"wannaSee":483,
				"summary":"e04u92",
				"idProfession":"k94wps",
				"profession":"vuk1gw",
				"sort":19924
			}
		],
		"movieListOrderByStartYear":[
			{
				"id":784,
				"urlMovieDouban":"n0gth4",
				"idTypeVideo":"lcozxi",
				"typeVideo":"ibii5d",
				"idMovieImdb":"dek0yh",
				"urlMovieImdb":"1pkl7p",
				"startYear":1321,
				"nameZh":"r2xo1d",
				"nameOrigin":"iye01n",
				"runtime":6789,
				"urlPoster":"w6uqhh",
				"haveSeen":580,
				"wannaSee":348,
				"summary":"vibqou",
				"idProfession":"p3l0e2",
				"profession":"su3zb5",
				"sort":290
			}
		],
		"awardList":[
			{
				"idMovieDouban":565,
				"idAwardMovie":"wz56gu",
				"nameZh":"rp5j0c",
				"urlAward":"8yi0le",
				"idCelebrityDouban":442,
				"urlCelebrityDouban":"1ohgjs",
				"typeAward":"xh452x",
				"awardTh":8367,
				"isNominated":"6cqh22"
			}
		]
	}
}
```

### 豆瓣影人合作过的影人基础信息
**URL:** http://localhost:8081/v2/celebrity/douban/cooperators_bases

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
curl -X GET -i http://localhost:8081/v2/celebrity/douban/cooperators_bases?id=849&offset=0&limit=10
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
	"code":910,
	"msg":"epmxw7",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## IMDB影人API
### IMDB影人基础信息
**URL:** http://localhost:8081/v2/celebrity/imdb/bases

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
curl -X GET -i http://localhost:8081/v2/celebrity/imdb/bases?id=890
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
	"code":836,
	"msg":"2bx5pl",
	"data":{
		"id":"38",
		"nameEn":"ilyvxz",
		"birthYear":9620,
		"idCelebrityDouban":641
	}
}
```

### IMDB影人详细信息
**URL:** http://localhost:8081/v2/celebrity/imdb/details

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
curl -X GET -i http://localhost:8081/v2/celebrity/imdb/details?id=174
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
	"code":956,
	"msg":"su731r",
	"data":{
		"base":{
			"id":"38",
			"nameEn":"4j6o4i",
			"birthYear":17033,
			"idCelebrityDouban":943
		},
		"movieList":[
			{
				"id":"38",
				"idTypeVideo":"5ixmqz",
				"typeVideo":"r7cheh",
				"nameEn":"jo0wsr",
				"startYear":32371,
				"isAdult":"srhec7",
				"nameOrigin":"9v5j44",
				"runtime":16291,
				"urlPoster":"9uhva5",
				"idMovieDouban":378,
				"summary":"4xj4lk",
				"idProfession":"44kpb4",
				"profession":"pu9k2l"
			}
		]
	}
}
```

## 影人API
### 影人基础信息
**URL:** http://localhost:8081/v2/celebrity/bases

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
curl -X GET -i http://localhost:8081/v2/celebrity/bases?id=422
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
	"code":314,
	"msg":"ejv8v8",
	"data":{
		"douban":{
			"id":849,
			"urlCelebrityDouban":"qe6ll8",
			"idCelebrityImdb":"7r88fu",
			"urlCelebrityImdb":"oor2jj",
			"nameZh":"ptkswm",
			"nameOrigin":"9cuh36",
			"sex":"xh4wk6",
			"birthDate":"2020-02-28",
			"urlPortrait":"9mtpf3",
			"summary":"wyiwpg"
		},
		"imdb":{
			"id":"38",
			"nameEn":"q5zt6z",
			"birthYear":27291,
			"idCelebrityDouban":226
		}
	}
}
```

### 影人详细信息
**URL:** http://localhost:8081/v2/celebrity/details

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
curl -X GET -i http://localhost:8081/v2/celebrity/details?id=156
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─movieListOrderByScore|array|与豆瓣影人相关的豆瓣电影列表 order by score|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─movieListOrderByStartYear|array|与豆瓣影人相关的豆瓣电影列表 order by start year|-
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
	"code":82,
	"msg":"r4saan",
	"data":{
		"douban":{
			"base":{
				"id":129,
				"urlCelebrityDouban":"3k5hzu",
				"idCelebrityImdb":"kc4osg",
				"urlCelebrityImdb":"y5gjr5",
				"nameZh":"bx6827",
				"nameOrigin":"kjfcwx",
				"sex":"rg0015",
				"birthDate":"2020-02-28",
				"urlPortrait":"ag96pa",
				"summary":"1j9af4"
			},
			"aliasList":[
				{
					"nameAlias":"8exj2p",
					"isNikename":"zka4yj"
				}
			],
			"imageList":[
				{
					"id":222,
					"urlImageSqxs":"4vdobm",
					"urlImageS":"0j1o00",
					"urlImageM":"b86rzp",
					"urlImageL":"j2myla",
					"sort":"rhq8ie",
					"length":674,
					"width":935
				}
			],
			"movieListOrderByScore":[
				{
					"id":955,
					"urlMovieDouban":"8khqgr",
					"idTypeVideo":"4m1zfu",
					"typeVideo":"5uopma",
					"idMovieImdb":"sufaz0",
					"urlMovieImdb":"2gofes",
					"startYear":6904,
					"nameZh":"d9gczb",
					"nameOrigin":"iefokg",
					"runtime":24576,
					"urlPoster":"gv94i8",
					"haveSeen":356,
					"wannaSee":919,
					"summary":"2sti3a",
					"idProfession":"si6zg9",
					"profession":"w1iiot",
					"sort":9060
				}
			],
			"movieListOrderByStartYear":[
				{
					"id":186,
					"urlMovieDouban":"87xcm9",
					"idTypeVideo":"qpwh8w",
					"typeVideo":"hjf77g",
					"idMovieImdb":"ysiw2v",
					"urlMovieImdb":"7nhtij",
					"startYear":19522,
					"nameZh":"dyd8ym",
					"nameOrigin":"7ea59i",
					"runtime":5595,
					"urlPoster":"8h9lke",
					"haveSeen":607,
					"wannaSee":773,
					"summary":"3w1cjn",
					"idProfession":"f720iu",
					"profession":"y1v35x",
					"sort":17317
				}
			],
			"awardList":[
				{
					"idMovieDouban":842,
					"idAwardMovie":"9h87l8",
					"nameZh":"giog87",
					"urlAward":"06iwg3",
					"idCelebrityDouban":317,
					"urlCelebrityDouban":"tqmevj",
					"typeAward":"r5a9h0",
					"awardTh":1278,
					"isNominated":"48e828"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"38",
				"nameEn":"gccn9e",
				"birthYear":7369,
				"idCelebrityDouban":37
			},
			"movieList":[
				{
					"id":"38",
					"idTypeVideo":"sqx14t",
					"typeVideo":"cfyfvb",
					"nameEn":"df0pne",
					"startYear":19297,
					"isAdult":"h8gijk",
					"nameOrigin":"4winjv",
					"runtime":8219,
					"urlPoster":"g44ssf",
					"idMovieDouban":646,
					"summary":"zw0w55",
					"idProfession":"vpldje",
					"profession":"q78arl"
				}
			]
		}
	}
}
```

## 豆瓣搜索API
### 豆瓣搜索提示
**URL:** http://localhost:8081/v2/search/douban/search_tips

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据名称开头的字符串找出豆瓣电影、豆瓣影人等基本信息列表

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
curl -X GET -i http://localhost:8081/v2/search/douban/search_tips?keyword=23k17g&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─movieList|array|豆瓣电影搜索提示列表|-
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
└─celebrityList|array|豆瓣影人搜索提示列表|-
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

**Response-example:**
```
{
	"code":52,
	"msg":"i5bkpu",
	"data":{
		"movieList":[
			{
				"base":{
					"id":894,
					"urlMovieDouban":"k48j24",
					"idTypeVideo":"itj7op",
					"typeVideo":"29bg0q",
					"idMovieImdb":"2vbd4n",
					"urlMovieImdb":"z50nlh",
					"startYear":8629,
					"nameZh":"eknl48",
					"nameOrigin":"yq7dgf",
					"runtime":32493,
					"urlPoster":"yj5mg4",
					"haveSeen":130,
					"wannaSee":436,
					"summary":"ra21bd"
				},
				"rate":{
					"id":161,
					"score":718,
					"vote":437,
					"score5":285,
					"score4":658,
					"score3":907,
					"score2":125,
					"score1":651
				},
				"aliasList":[
					"1ytvlz"
				]
			}
		],
		"celebrityList":[
			{
				"base":{
					"id":637,
					"urlCelebrityDouban":"huj4lr",
					"idCelebrityImdb":"rdy7du",
					"urlCelebrityImdb":"8441jo",
					"nameZh":"9fajee",
					"nameOrigin":"dhrkqb",
					"sex":"1ftumu",
					"birthDate":"2020-02-28",
					"urlPortrait":"3xkz5h",
					"summary":"whra3m"
				},
				"aliasList":[
					{
						"nameAlias":"vkzzgz",
						"isNikename":"jxzxd9"
					}
				]
			}
		]
	}
}
```

### 豆瓣搜索结果
**URL:** http://localhost:8081/v2/search/douban/search_details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据名称字符串找出豆瓣电影、豆瓣影人等基本信息列表

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
curl -X GET -i http://localhost:8081/v2/search/douban/search_details?keyword=hjp3ds&offset=0&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─movieList|array|豆瓣电影搜索结果列表|-
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
└─celebrityList|array|豆瓣影人搜索结果列表|-
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

**Response-example:**
```
{
	"code":927,
	"msg":"mqpkj8",
	"data":{
		"movieList":[
			{
				"base":{
					"id":70,
					"urlMovieDouban":"2p3tmi",
					"idTypeVideo":"gj2x8x",
					"typeVideo":"ek895s",
					"idMovieImdb":"b5gv4i",
					"urlMovieImdb":"5mclzx",
					"startYear":7889,
					"nameZh":"qsxkw1",
					"nameOrigin":"hyx6ci",
					"runtime":8886,
					"urlPoster":"uq0p6d",
					"haveSeen":46,
					"wannaSee":740,
					"summary":"a5bxx5"
				},
				"rate":{
					"id":644,
					"score":131,
					"vote":895,
					"score5":391,
					"score4":426,
					"score3":699,
					"score2":472,
					"score1":3
				},
				"aliasList":[
					"m3xi76"
				],
				"typeList":[
					"7829kk"
				],
				"celebrityList":[
					{
						"id":456,
						"urlCelebrityDouban":"dmhkxx",
						"idCelebrityImdb":"f154v9",
						"urlCelebrityImdb":"k7i1yk",
						"nameZh":"l5bpqo",
						"nameOrigin":"qsh07b",
						"sex":"ejp7vz",
						"birthDate":"2020-02-28",
						"urlPortrait":"7jtvdd",
						"summary":"d7u45f",
						"idProfession":"yalhn6",
						"profession":"cj5ag8",
						"sort":14677
					}
				]
			}
		],
		"celebrityList":[
			{
				"base":{
					"id":649,
					"urlCelebrityDouban":"rqcmb9",
					"idCelebrityImdb":"jv0lbp",
					"urlCelebrityImdb":"tq0oah",
					"nameZh":"3jt6ci",
					"nameOrigin":"xwapr6",
					"sex":"04c8kj",
					"birthDate":"2020-02-28",
					"urlPortrait":"s6h54e",
					"summary":"u8lclj"
				},
				"aliasList":[
					{
						"nameAlias":"8zic2c",
						"isNikename":"tflqr1"
					}
				],
				"movieList":[
					{
						"id":82,
						"urlMovieDouban":"im3cgf",
						"idTypeVideo":"9136q1",
						"typeVideo":"2xu4v2",
						"idMovieImdb":"6serpf",
						"urlMovieImdb":"zf4jar",
						"startYear":6932,
						"nameZh":"ukabs7",
						"nameOrigin":"u63apw",
						"runtime":11907,
						"urlPoster":"ieeal6",
						"haveSeen":402,
						"wannaSee":979,
						"summary":"yhy4fx",
						"idProfession":"64wlfp",
						"profession":"kv00c6",
						"sort":28946
					}
				]
			}
		]
	}
}
```

## 豆瓣影人搜索API
### 豆瓣影人搜索提示
**URL:** http://localhost:8081/v2/search/celebrity/douban/search_tips

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据影人名称开头的字符串找出豆瓣影人的基本信息列表

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
curl -X GET -i http://localhost:8081/v2/search/celebrity/douban/search_tips?keyword=rcvqoy&offset=0&limit=10
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

**Response-example:**
```
{
	"code":137,
	"msg":"t78560",
	"data":[
		{
			"base":{
				"id":788,
				"urlCelebrityDouban":"qrxkvk",
				"idCelebrityImdb":"8u6916",
				"urlCelebrityImdb":"eigs5s",
				"nameZh":"ep3hr1",
				"nameOrigin":"tz7ism",
				"sex":"p3lfqb",
				"birthDate":"2020-02-28",
				"urlPortrait":"i2q3ys",
				"summary":"r2eufm"
			},
			"aliasList":[
				{
					"nameAlias":"ohztl3",
					"isNikename":"mgs46p"
				}
			]
		}
	]
}
```

### 豆瓣影人搜索结果
**URL:** http://localhost:8081/v2/search/celebrity/douban/search_details

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
curl -X GET -i http://localhost:8081/v2/search/celebrity/douban/search_details?keyword=macg1v&offset=0&limit=10
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

**Response-example:**
```
{
	"code":233,
	"msg":"qd8blt",
	"data":[
		{
			"base":{
				"id":622,
				"urlCelebrityDouban":"h0nvaj",
				"idCelebrityImdb":"vdmlyn",
				"urlCelebrityImdb":"yegf9s",
				"nameZh":"jhkdn3",
				"nameOrigin":"1ew7zs",
				"sex":"ropgud",
				"birthDate":"2020-02-28",
				"urlPortrait":"w7yqr3",
				"summary":"mlekxy"
			},
			"aliasList":[
				{
					"nameAlias":"bikkyc",
					"isNikename":"036ko2"
				}
			],
			"movieList":[
				{
					"id":851,
					"urlMovieDouban":"dw5liq",
					"idTypeVideo":"1ypgp2",
					"typeVideo":"cjp3xr",
					"idMovieImdb":"f4xp5l",
					"urlMovieImdb":"qeqw6t",
					"startYear":15279,
					"nameZh":"y8ozr7",
					"nameOrigin":"rqohve",
					"runtime":26734,
					"urlPoster":"lzoxmm",
					"haveSeen":317,
					"wannaSee":350,
					"summary":"4hiueu",
					"idProfession":"9ulhwe",
					"profession":"sfi3pm",
					"sort":3778
				}
			]
		}
	]
}
```

## 豆瓣电影搜索API
### 豆瓣电影搜索提示
**URL:** http://localhost:8081/v2/search/movie/douban/search_tips

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
curl -X GET -i http://localhost:8081/v2/search/movie/douban/search_tips?keyword=eka4zs&offset=0&limit=10
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

**Response-example:**
```
{
	"code":336,
	"msg":"9oaql7",
	"data":[
		{
			"base":{
				"id":57,
				"urlMovieDouban":"gvl280",
				"idTypeVideo":"423cop",
				"typeVideo":"5i7p7z",
				"idMovieImdb":"ryktdv",
				"urlMovieImdb":"n93a2n",
				"startYear":26199,
				"nameZh":"1y61i0",
				"nameOrigin":"bvn4cd",
				"runtime":32348,
				"urlPoster":"tmkr5g",
				"haveSeen":429,
				"wannaSee":412,
				"summary":"ff4cie"
			},
			"rate":{
				"id":68,
				"score":203,
				"vote":318,
				"score5":957,
				"score4":165,
				"score3":862,
				"score2":82,
				"score1":555
			},
			"aliasList":[
				"vve19e"
			]
		}
	]
}
```

### 豆瓣电影搜索结果
**URL:** http://localhost:8081/v2/search/movie/douban/search_details

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
curl -X GET -i http://localhost:8081/v2/search/movie/douban/search_details?keyword=agl5lb&offset=0&limit=10
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

**Response-example:**
```
{
	"code":981,
	"msg":"sgmk95",
	"data":[
		{
			"base":{
				"id":557,
				"urlMovieDouban":"6owa3g",
				"idTypeVideo":"aibjqz",
				"typeVideo":"f06wst",
				"idMovieImdb":"xxvn7t",
				"urlMovieImdb":"bq8d4q",
				"startYear":25221,
				"nameZh":"dbw4t0",
				"nameOrigin":"zxc3ef",
				"runtime":16990,
				"urlPoster":"o2nqqm",
				"haveSeen":717,
				"wannaSee":352,
				"summary":"ozco8v"
			},
			"rate":{
				"id":913,
				"score":816,
				"vote":914,
				"score5":304,
				"score4":347,
				"score3":858,
				"score2":847,
				"score1":549
			},
			"aliasList":[
				"y1adu9"
			],
			"typeList":[
				"2xr1o9"
			],
			"celebrityList":[
				{
					"id":881,
					"urlCelebrityDouban":"8lbfnc",
					"idCelebrityImdb":"c0jq5a",
					"urlCelebrityImdb":"0z83h5",
					"nameZh":"gns8i7",
					"nameOrigin":"448u9w",
					"sex":"8sqc2i",
					"birthDate":"2020-02-28",
					"urlPortrait":"garnn5",
					"summary":"qzzilt",
					"idProfession":"hwtqhn",
					"profession":"nlmazd",
					"sort":10236
				}
			]
		}
	]
}
```

## Plus搜索API
### Plus搜索提示
**URL:** http://localhost:8081/v2/search/search_tips

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据名称开头的字符串找出豆瓣电影、豆瓣影人、网易云音乐等基本信息列表

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
curl -X GET -i http://localhost:8081/v2/search/search_tips?keyword=37sfrx&offset=0&limit=10
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
	"code":884,
	"msg":"2zjlk9",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### Plus搜索结果
**URL:** http://localhost:8081/v2/search/search_details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据名称字符串找出豆瓣电影、豆瓣影人、网易云音乐等基本信息列表

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
curl -X GET -i http://localhost:8081/v2/search/search_details?keyword=w1bdwb&offset=0&limit=10
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
	"code":23,
	"msg":"5cos7s",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 音乐API
## 知乎API
### 豆瓣电影知乎相关
**URL:** http://localhost:8081/v2/movie/zhihu/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括知乎话题、知乎评分、猫眼评分、知乎问题列表等

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
curl -X GET -i http://localhost:8081/v2/movie/zhihu/bases?id=158
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─topic|object|知乎话题|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|知乎电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlZhihuTopic|string|知乎话题链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|知乎电影中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zhihuScore|number|知乎评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zhihuVote|int32|知乎评分票数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maoyanScore|number|猫眼评分|-
└─questionList|array|知乎问题列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|知乎问题ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlZhihuQuestion|string|知乎问题链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|知乎问题中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─answerNum|int32|回答数 0-默认 1-文章|-

**Response-example:**
```
{
	"code":69,
	"msg":"iu0nnr",
	"data":{
		"topic":{
			"id":487,
			"urlZhihuTopic":"sjyf4e",
			"idMovieDouban":279,
			"urlMovieDouban":"auvtp5",
			"nameZh":"n2d04v",
			"zhihuScore":6,
			"zhihuVote":888,
			"maoyanScore":77
		},
		"questionList":[
			{
				"id":750,
				"urlZhihuQuestion":"vf2dml",
				"idMovieDouban":254,
				"urlMovieDouban":"sg52ob",
				"nameZh":"utgm9a",
				"answerNum":893
			}
		]
	}
}
```

## 豆瓣电影API
### 豆瓣电影基础信息
**URL:** http://localhost:8081/v2/movie/douban/bases

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
curl -X GET -i http://localhost:8081/v2/movie/douban/bases?id=764
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
	"code":338,
	"msg":"1u201t",
	"data":{
		"id":641,
		"urlMovieDouban":"qovg5t",
		"idTypeVideo":"crystt",
		"typeVideo":"6u3ll5",
		"idMovieImdb":"59gtck",
		"urlMovieImdb":"43pc74",
		"startYear":6028,
		"nameZh":"8g6bei",
		"nameOrigin":"qf8f17",
		"runtime":17200,
		"urlPoster":"7i6i8t",
		"haveSeen":142,
		"wannaSee":896,
		"summary":"gyrcyc"
	}
}
```

### 豆瓣电影详情信息
**URL:** http://localhost:8081/v2/movie/douban/details

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
curl -X GET -i http://localhost:8081/v2/movie/douban/details?id=484
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
	"code":371,
	"msg":"fedrpk",
	"data":{
		"base":{
			"id":875,
			"urlMovieDouban":"wmo24q",
			"idTypeVideo":"jtlby3",
			"typeVideo":"wffknd",
			"idMovieImdb":"dnt59e",
			"urlMovieImdb":"78h09z",
			"startYear":24840,
			"nameZh":"8kd4yj",
			"nameOrigin":"hnkcfm",
			"runtime":2955,
			"urlPoster":"nywl23",
			"haveSeen":530,
			"wannaSee":436,
			"summary":"kll1k0"
		},
		"rate":{
			"id":649,
			"score":544,
			"vote":123,
			"score5":882,
			"score4":445,
			"score3":447,
			"score2":294,
			"score1":601
		},
		"aliasList":[
			"3tuzlf"
		],
		"typeList":[
			"9jqge6"
		],
		"tagList":[
			"r8pxgv"
		],
		"celebrityList":[
			{
				"id":614,
				"urlCelebrityDouban":"mumh13",
				"idCelebrityImdb":"jk0fv6",
				"urlCelebrityImdb":"jiwcd9",
				"nameZh":"vvzvcx",
				"nameOrigin":"6296t6",
				"sex":"pixemm",
				"birthDate":"2020-02-28",
				"urlPortrait":"cpjddo",
				"summary":"30ezza",
				"idProfession":"uyj4yn",
				"profession":"x9ey3u",
				"sort":26005
			}
		],
		"trailerList":[
			{
				"id":215,
				"idMovieDouban":684,
				"urlTrailer":"wxxsr1",
				"urlVideo":"lec9yc"
			}
		],
		"imageList":[
			{
				"id":833,
				"urlImageSqxs":"skjv6l",
				"urlImageS":"smq0rh",
				"urlImageM":"vmm16p",
				"urlImageL":"9hm1kw",
				"sort":"gr4ubs",
				"length":354,
				"width":969
			}
		],
		"classicList":[
			{
				"id":219,
				"idMovieDouban":498,
				"content":"a8hmhr",
				"happenTime":903,
				"agreeVote":643
			}
		],
		"reviewList":[
			{
				"id":768,
				"urlReview":"1ngwnz",
				"agreeVote":252,
				"againstVote":204,
				"createDatetime":"2020-02-28 18:00:46",
				"title":"nkjvlo",
				"content":"kdag7n"
			}
		],
		"awardList":[
			{
				"idMovieDouban":994,
				"idAwardMovie":"hcx88g",
				"nameZh":"ftbeam",
				"urlAward":"x1uka0",
				"idCelebrityDouban":419,
				"urlCelebrityDouban":"yo2pti",
				"typeAward":"zh0ezi",
				"awardTh":10182,
				"isNominated":"zupfm4"
			}
		],
		"commentList":[
			{
				"idMovieDouban":916,
				"idUserDouban":"da43ze",
				"urlUserDouban":"wirxre",
				"agreeVote":13861,
				"createDate":"2020-02-28",
				"content":"1wdmaf"
			}
		]
	}
}
```

## IMDB电影API
### IMDB电影基础信息
**URL:** http://localhost:8081/v2/movie/imdb/bases

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
curl -X GET -i http://localhost:8081/v2/movie/imdb/bases?id=82
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
	"code":931,
	"msg":"bz84sj",
	"data":{
		"id":"38",
		"urlMovieImdb":"gejl9f",
		"idTypeVideo":"opltwe",
		"typeVideo":"gi1od0",
		"nameEn":"sycvky",
		"startYear":5412,
		"isAdult":"9j4iso",
		"nameOrigin":"84crxo",
		"runtime":30280,
		"urlPoster":"7bcvqj",
		"idMovieDouban":473,
		"summary":"gayijj"
	}
}
```

### IMDB电影详情信息
**URL:** http://localhost:8081/v2/movie/imdb/details

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
curl -X GET -i http://localhost:8081/v2/movie/imdb/details?id=770
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
	"code":315,
	"msg":"f4kf78",
	"data":{
		"base":{
			"id":"38",
			"urlMovieImdb":"ao4a4z",
			"idTypeVideo":"djd49x",
			"typeVideo":"44m42o",
			"nameEn":"gjph4s",
			"startYear":30289,
			"isAdult":"pfpnz7",
			"nameOrigin":"sgdusv",
			"runtime":32233,
			"urlPoster":"2a055m",
			"idMovieDouban":788,
			"summary":"p5ukr8"
		},
		"rate":{
			"idMovieImdb":"p5i226",
			"imdbScore":573,
			"imdbVote":930,
			"tomatoScore":398,
			"mtcScore":714
		},
		"typeList":[
			"qmqjy4"
		],
		"celebrityList":[
			{
				"idCelebrityImdb":"wpevhk",
				"urlCelebrityImdb":"mio8js",
				"idMovieImdb":"tp6ecq",
				"idCelebrityDouban":523,
				"urlCelebrityDouban":"iy6c81",
				"nameEn":"8dvzma",
				"birthYear":30787,
				"idProfession":"ryue6m",
				"profession":"fuxafg"
			}
		]
	}
}
```

## 电影资源API
### 电影资源
**URL:** http://localhost:8081/v2/movie/resource/bases

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

**Request-example:**
```
curl -X GET -i http://localhost:8081/v2/movie/resource/bases?id=486
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─id|int64|电影资源ID|-
└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
└─urlMovieDouban|string|豆瓣电影链接|-
└─idMovieImdb|int64|IMDB电影ID 0-未匹配 1-已匹配|-
└─urlMovieImdb|string|IMDB电影链接|-
└─idWebsiteResource|int16|电影资源网站ID ID<100-正版 ID>100-盗版|-
└─websiteResource|string|电影资源网站名称|-
└─urlWebsiteResource|string|电影资源网站官网链接|-
└─idTypeResource|int16|电影资源类型ID ID<100-在线 ID>100-离线|-
└─typeResource|string|电影资源类型|-
└─nameZh|string|资源中文名|-
└─createYear|int16|电影年代 /year|-
└─nameOrigin|string|资源原始名|-
└─urlResource|string|资源链接|-

**Response-example:**
```
{
	"code":134,
	"msg":"gvok6j",
	"data":[
		{
			"id":868,
			"idMovieDouban":796,
			"urlMovieDouban":"ck0uaa",
			"idMovieImdb":351,
			"urlMovieImdb":"axjlnm",
			"idWebsiteResource":9792,
			"websiteResource":"3p63ix",
			"urlWebsiteResource":"z8ryz3",
			"idTypeResource":1687,
			"typeResource":"wh14qm",
			"nameZh":"wgam06",
			"createYear":30673,
			"nameOrigin":"lh9a9s",
			"urlResource":"f3sfbb"
		}
	]
}
```

## 电影API
### 电影基础信息
**URL:** http://localhost:8081/v2/movie/bases

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
curl -X GET -i http://localhost:8081/v2/movie/bases?id=86
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
	"code":394,
	"msg":"7nba6k",
	"data":{
		"douban":{
			"id":908,
			"urlMovieDouban":"d06qwr",
			"idTypeVideo":"w9wyh3",
			"typeVideo":"id9tef",
			"idMovieImdb":"544smy",
			"urlMovieImdb":"t7q5w5",
			"startYear":5858,
			"nameZh":"uu0xpb",
			"nameOrigin":"jg0fz3",
			"runtime":20483,
			"urlPoster":"hjv18x",
			"haveSeen":548,
			"wannaSee":441,
			"summary":"zo1ejb"
		},
		"imdb":{
			"id":"38",
			"urlMovieImdb":"ktxklj",
			"idTypeVideo":"lqbfj0",
			"typeVideo":"axkjqz",
			"nameEn":"hgkowb",
			"startYear":19751,
			"isAdult":"o18s2h",
			"nameOrigin":"w96dzh",
			"runtime":31484,
			"urlPoster":"h5a7rw",
			"idMovieDouban":477,
			"summary":"qntl92"
		}
	}
}
```

### 电影详情信息
**URL:** http://localhost:8081/v2/movie/details

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
curl -X GET -i http://localhost:8081/v2/movie/details?id=693
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
	"code":446,
	"msg":"clp044",
	"data":{
		"douban":{
			"base":{
				"id":650,
				"urlMovieDouban":"fkn88g",
				"idTypeVideo":"bg7jme",
				"typeVideo":"cxm5u9",
				"idMovieImdb":"hq5afe",
				"urlMovieImdb":"7kw51a",
				"startYear":8759,
				"nameZh":"siel9e",
				"nameOrigin":"lth1bp",
				"runtime":28089,
				"urlPoster":"eal127",
				"haveSeen":607,
				"wannaSee":366,
				"summary":"m22v6k"
			},
			"rate":{
				"id":401,
				"score":291,
				"vote":542,
				"score5":718,
				"score4":325,
				"score3":738,
				"score2":975,
				"score1":36
			},
			"aliasList":[
				"w7nalr"
			],
			"typeList":[
				"pc5jfm"
			],
			"tagList":[
				"5q1185"
			],
			"celebrityList":[
				{
					"id":626,
					"urlCelebrityDouban":"yl7soq",
					"idCelebrityImdb":"whmgv9",
					"urlCelebrityImdb":"6sg2ll",
					"nameZh":"e1brrw",
					"nameOrigin":"8co3t1",
					"sex":"kqlae0",
					"birthDate":"2020-02-28",
					"urlPortrait":"k7fjhf",
					"summary":"e1kre8",
					"idProfession":"2jy352",
					"profession":"45hjli",
					"sort":32207
				}
			],
			"trailerList":[
				{
					"id":523,
					"idMovieDouban":188,
					"urlTrailer":"c8rr88",
					"urlVideo":"p8j0zp"
				}
			],
			"imageList":[
				{
					"id":611,
					"urlImageSqxs":"6skdww",
					"urlImageS":"na8ez9",
					"urlImageM":"8q3j4j",
					"urlImageL":"ekzpkg",
					"sort":"81ppwi",
					"length":214,
					"width":295
				}
			],
			"classicList":[
				{
					"id":708,
					"idMovieDouban":654,
					"content":"rscss7",
					"happenTime":200,
					"agreeVote":830
				}
			],
			"reviewList":[
				{
					"id":753,
					"urlReview":"ludvj9",
					"agreeVote":433,
					"againstVote":250,
					"createDatetime":"2020-02-28 18:00:46",
					"title":"oxsfus",
					"content":"9ekh6e"
				}
			],
			"awardList":[
				{
					"idMovieDouban":679,
					"idAwardMovie":"6dpa5j",
					"nameZh":"e893dp",
					"urlAward":"m899i6",
					"idCelebrityDouban":254,
					"urlCelebrityDouban":"9ys534",
					"typeAward":"pdtaww",
					"awardTh":28744,
					"isNominated":"4ncmkd"
				}
			],
			"commentList":[
				{
					"idMovieDouban":435,
					"idUserDouban":"fb4rwh",
					"urlUserDouban":"bll67z",
					"agreeVote":372,
					"createDate":"2020-02-28",
					"content":"fh2w8s"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"38",
				"urlMovieImdb":"4ws9y2",
				"idTypeVideo":"btsudu",
				"typeVideo":"oqe2fb",
				"nameEn":"61y74m",
				"startYear":11352,
				"isAdult":"ocmtc0",
				"nameOrigin":"qygib0",
				"runtime":564,
				"urlPoster":"jv7vuh",
				"idMovieDouban":939,
				"summary":"3cl1mm"
			},
			"rate":{
				"idMovieImdb":"4xbmkf",
				"imdbScore":61,
				"imdbVote":70,
				"tomatoScore":679,
				"mtcScore":393
			},
			"typeList":[
				"jsrgq0"
			],
			"celebrityList":[
				{
					"idCelebrityImdb":"fqrv5n",
					"urlCelebrityImdb":"sqcqpo",
					"idMovieImdb":"yzc9i6",
					"idCelebrityDouban":420,
					"urlCelebrityDouban":"vd46ct",
					"nameEn":"0xgxgq",
					"birthYear":16110,
					"idProfession":"p7ohsz",
					"profession":"339wo1"
				}
			]
		}
	}
}
```

## 电影场景API
### 电影场景简略信息

**URL:** http://localhost:8081/v2/scene/fotoplace/bases

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括场景电影基础信息，分布图，场景地点简略信息，场景地点图等

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
curl -X GET -i http://localhost:8081/v2/scene/fotoplace/bases?id=235
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─base|object|场景电影基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieScene|string|场景电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|场景电影中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|场景电影英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|上映时间 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|场景电影拍摄地点大致描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMap|string|场景电影地点分布图链接|-
└─sceneList|array|场景地点简略信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─base|object|场景基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieScene|int64|场景电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idPlaceScene|int64|地点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|场景中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─happenTime|int32|场景发生在电影中的时间 /s|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─place|object|场景地点简略信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─base|object|场景地点基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景地点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─longitude|number|经度|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─latitude|number|纬度|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOther|string|其他语言名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─alias|string|别名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─addressZh|string|中文地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─addressEn|string|英文地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|地点描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaZh|string|区域中文|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaEn|string|区域英文|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─phone|string|电话号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|地点海报图链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlEarth|string|地点地球位置图链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlSatellite|string|地点卫星图链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMap|string|地点地图|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imageList|array|场景地点图片列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景地点图片ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idPlaceScene|int64|场景地点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImage|string|图片链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|图片描述|-

**Response-example:**
```
{
	"code":81,
	"msg":"2a99yb",
	"data":{
		"base":{
			"id":661,
			"urlMovieScene":"sirl4a",
			"idMovieDouban":234,
			"urlMovieDouban":"x0r74k",
			"nameZh":"ys8wd9",
			"nameEn":"2i5t44",
			"startYear":7762,
			"description":"xjh5dp",
			"urlMap":"ezmub2"
		},
		"sceneList":[
			{
				"base":{
					"id":795,
					"idMovieScene":167,
					"idPlaceScene":945,
					"nameZh":"e02xbk",
					"happenTime":154
				},
				"place":{
					"base":{
						"id":54,
						"longitude":127,
						"latitude":379,
						"nameZh":"1aqv9r",
						"nameEn":"5fho6v",
						"nameOther":"8m0gpo",
						"alias":"ips63c",
						"addressZh":"mmgpoh",
						"addressEn":"t3na17",
						"description":"4qq8f8",
						"areaZh":"5sal2q",
						"areaEn":"gslpfw",
						"phone":"15660107066",
						"urlPoster":"96za2j",
						"urlEarth":"l6ae53",
						"urlSatellite":"so0bjn",
						"urlMap":"1iukeu"
					},
					"imageList":[
						{
							"id":423,
							"idPlaceScene":57,
							"urlImage":"wrvphh",
							"description":"l0rjku"
						}
					]
				}
			}
		]
	}
}
```

### 电影场景详细信息
**URL:** http://localhost:8081/v2/scene/fotoplace/details

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括场景电影基础信息，分布图，场景详细信息,场景地点详细信息，场景图片等

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
curl -X GET -i http://localhost:8081/v2/scene/fotoplace/details?id=904
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─base|object|场景电影基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieScene|string|场景电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|场景电影中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|场景电影英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─startYear|int16|上映时间 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|场景电影拍摄地点大致描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMap|string|场景电影地点分布图链接|-
└─sceneList|array|场景详细信息列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─base|object|场景基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieScene|int64|场景电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieScene|string|场景电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idPlaceScene|int64|地点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|场景中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─happenTime|int32|场景发生在电影中的时间 /s|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sceneDetailList|array|场景详情详细信息列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─base|object|场景详情基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景详情ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idScene|int64|场景ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieScene|int64|场景电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─happenTime|int32|场景发生在电影中的时间 /s|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|场景描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imageList|array|场景详情图片列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景详情剧照ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idSceneDetail|int64|场景详情ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImage|string|图片链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─celebrityList|array|场景详情的相关场景影人列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣影人链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|场景影人中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|场景影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idSceneDetail|int64|对应的场景详情ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─place|object|场景地点详细信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─base|object|场景地点基础信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景地点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─longitude|number|经度|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─latitude|number|纬度|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZh|string|中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameOther|string|其他语言名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─alias|string|别名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─addressZh|string|中文地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─addressEn|string|英文地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|地点描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaZh|string|区域中文|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaEn|string|区域英文|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─phone|string|电话号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlPoster|string|地点海报图链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlEarth|string|地点地球位置图链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlSatellite|string|地点卫星图链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMap|string|地点地图|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imageList|array|场景地点图片列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|场景地点图片ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idPlaceScene|int64|场景地点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlImage|string|图片链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|图片描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeList|array|场景地点-类型列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─continent|string|场景地点 洲|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─country|string|场景地点 国家|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─city|string|场景地点 城市|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─state|string|场景地点 州/省|-

**Response-example:**
```
{
	"code":654,
	"msg":"bvl5ho",
	"data":{
		"base":{
			"id":415,
			"urlMovieScene":"93lrx5",
			"idMovieDouban":989,
			"urlMovieDouban":"pp8s1l",
			"nameZh":"4iv5b2",
			"nameEn":"w36ifi",
			"startYear":1163,
			"description":"tow4ik",
			"urlMap":"lvlhb7"
		},
		"sceneList":[
			{
				"base":{
					"id":751,
					"idMovieScene":816,
					"urlMovieScene":"ropj10",
					"idPlaceScene":56,
					"nameZh":"z521zv",
					"happenTime":270
				},
				"sceneDetailList":[
					{
						"base":{
							"id":25,
							"idScene":767,
							"idMovieScene":682,
							"happenTime":262,
							"description":"4p7r2c"
						},
						"imageList":[
							{
								"id":740,
								"idSceneDetail":152,
								"urlImage":"vyez6e"
							}
						],
						"celebrityList":[
							{
								"id":180,
								"idCelebrityDouban":510,
								"urlCelebrityDouban":"dqxbr0",
								"nameZh":"sbo8m2",
								"nameEn":"djawmq",
								"idSceneDetail":425
							}
						]
					}
				],
				"place":{
					"base":{
						"id":861,
						"longitude":994,
						"latitude":447,
						"nameZh":"ki50ng",
						"nameEn":"i4sm41",
						"nameOther":"jebrq5",
						"alias":"gsagci",
						"addressZh":"9zgq4l",
						"addressEn":"w4vsku",
						"description":"mwhk94",
						"areaZh":"zyw3z3",
						"areaEn":"fl1cdj",
						"phone":"15660107066",
						"urlPoster":"o50lpg",
						"urlEarth":"ivulkn",
						"urlSatellite":"zzq73f",
						"urlMap":"j2ibno"
					},
					"imageList":[
						{
							"id":106,
							"idPlaceScene":563,
							"urlImage":"03yj06",
							"description":"lpb1iu"
						}
					],
					"typeList":[
						"cfmq2t"
					],
					"continent":"zw5b90",
					"country":"s1c6ys",
					"city":"gzoz4s",
					"state":"mlv5as"
				}
			}
		]
	}
}
```

## 普通用户相关API
### 普通登录
**URL:** http://localhost:8081/v2/user/login

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
curl -X POST -i http://localhost:8081/v2/user/login  --data 'email=金鑫.韦@yahoo.com&password=qecksa'
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
	"code":531,
	"msg":"zfxx1x",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### github 第三方登录
**URL:** http://localhost:8081/v2/user/github_login

**Type:** GET


**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** github 第三方登录

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|-


**Request-example:**
```
curl -X GET -i http://localhost:8081/v2/user/github_login
```

**Response-example:**
```
This api return nothing.
```

### github 第三方登录 回调方法
**URL:** http://localhost:8081/v2/user/github_callback

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
curl -X GET -i http://localhost:8081/v2/user/github_callback?code=42124&state=srdp5f
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
	"code":245,
	"msg":"1skoen",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 用户注册
**URL:** http://localhost:8081/v2/user/register

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
curl -X POST -i http://localhost:8081/v2/user/register  --data 'id=&email=金鑫.韦@yahoo.com&password=9wq1qm'
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
	"code":233,
	"msg":"ao34ih",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 用户信息
**URL:** http://localhost:8081/v2/user/user_info

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
curl -X GET -i http://localhost:8081/v2/user/user_info
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
	"code":42,
	"msg":"5zbuo6",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

### 更新豆瓣用户ID
**URL:** http://localhost:8081/v2/user/update_id

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
curl -X PUT -i http://localhost:8081/v2/user/update_id  --data 'id=38'
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
	"code":290,
	"msg":"mexrxa",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## ROOT用户相关API
### 普通用户列表
**URL:** http://localhost:8081/v2/root/users_list

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
curl -X GET -i http://localhost:8081/v2/root/users_list?offset=0&limit=10
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
	"code":367,
	"msg":"6bcjrn",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```


