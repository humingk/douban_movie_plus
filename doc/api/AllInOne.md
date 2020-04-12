# 豆瓣电影Plus RESTful-API文档
Version |  Update Time  | Status | Author |  Description
------|--------|-----|------|-------
2.0.0||create|humingk|创建RESTful-API文档
2.0.5||update|humingk|更新



## 电影资源
### 电影资源
**URL:** https://api.doubans.com/v2/movie/resource/bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/movie/resource/bases?id=687
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
	"code":738,
	"msg":"g1ifa2",
	"data":[
		{
			"id":772,
			"idMovieDouban":725,
			"urlMovieDouban":"u191p5",
			"idMovieImdb":936,
			"urlMovieImdb":"u4fbtf",
			"idWebsiteResource":30708,
			"websiteResource":"bb4jm7",
			"urlWebsiteResource":"0gueqz",
			"idTypeResource":3483,
			"typeResource":"8gsqpt",
			"nameZh":"1bf1ml",
			"createYear":21940,
			"nameOrigin":"09b3nr",
			"urlResource":"kouxkl"
		}
	]
}
```

## 知乎电影
### 豆瓣电影知乎相关
**URL:** https://api.doubans.com/v2/movie/zhihu/bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/movie/zhihu/bases?id=425
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
	"code":344,
	"msg":"6sgyjc",
	"data":{
		"topic":{
			"id":761,
			"urlZhihuTopic":"h6d3yu",
			"idMovieDouban":978,
			"urlMovieDouban":"3fgv3y",
			"nameZh":"5xvd4b",
			"zhihuScore":726,
			"zhihuVote":968,
			"maoyanScore":36
		},
		"questionList":[
			{
				"id":246,
				"urlZhihuQuestion":"mzj3o6",
				"idMovieDouban":742,
				"urlMovieDouban":"qch696",
				"nameZh":"xjickm",
				"answerNum":955
			}
		]
	}
}
```

## 电影集合
### 电影基础信息
**URL:** https://api.doubans.com/v2/movie/bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/movie/bases?id=858
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
	"code":863,
	"msg":"2lmryq",
	"data":{
		"douban":{
			"id":212,
			"urlMovieDouban":"fv1a97",
			"idTypeVideo":"ppaqkm",
			"typeVideo":"b0rcxl",
			"idMovieImdb":"bz4159",
			"urlMovieImdb":"q1ttjs",
			"startYear":6182,
			"nameZh":"8bvvyd",
			"nameOrigin":"7ge6v3",
			"runtime":11310,
			"urlPoster":"9yafq4",
			"haveSeen":741,
			"wannaSee":559,
			"summary":"t7rlyq"
		},
		"imdb":{
			"id":"97",
			"urlMovieImdb":"yr8gw2",
			"idTypeVideo":"jmjmz2",
			"typeVideo":"7dmdav",
			"nameEn":"qya9pp",
			"startYear":3254,
			"isAdult":"qx2ggd",
			"nameOrigin":"tr8tjw",
			"runtime":21842,
			"urlPoster":"ut8crh",
			"idMovieDouban":956,
			"summary":"57rnah"
		}
	}
}
```

### 电影详情信息
**URL:** https://api.doubans.com/v2/movie/details

**Type:** GET

**Author:** humingk

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 豆瓣电影和IMDB电影,包括电影基础信息、评分信息、标签类型、相关影人基础信息、图片、预告片、热门影评短评、奖项等

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
curl -X GET -i https://api.doubans.com/v2/movie/details?id=367
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该影人与该电影的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|豆瓣电影经典台词ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─content|string|经典台词内容|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─happenTime|int32|经典台词在影片中的出现时间 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─agreeVote|int32|经典台词获得的赞同数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─user|object|相关豆瓣用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idUserDouban|string|豆瓣用户ID 0-未登录用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idClassicDouban|string|豆瓣电影经典台词ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZhUserDouban|string|用户中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─recordDatetime|int64|豆瓣用户收录时间 /unix|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|豆瓣用户评价|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─celebrity|object|相关豆瓣影人|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idClassicDouban|string|豆瓣电影经典台词ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZhCelebrityDouban|string|豆瓣影人中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─reviewList|array|豆瓣电影热门影评列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影影评ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idUserDouban|string|豆瓣用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameUserDouban|string|豆瓣用户昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlUserDouban|string|豆瓣用户链接|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameUserDouban|string|豆瓣用户昵称|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthYear|int16|出生年份 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该影人与该电影的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|int64|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|int64|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-

**Response-example:**
```
{
	"code":669,
	"msg":"xtnkpe",
	"data":{
		"douban":{
			"base":{
				"id":820,
				"urlMovieDouban":"i9t7h2",
				"idTypeVideo":"014vtf",
				"typeVideo":"ollhta",
				"idMovieImdb":"xuzfgi",
				"urlMovieImdb":"xmn6ve",
				"startYear":14669,
				"nameZh":"xzadzw",
				"nameOrigin":"6f625m",
				"runtime":28040,
				"urlPoster":"xckcws",
				"haveSeen":537,
				"wannaSee":590,
				"summary":"99hotm"
			},
			"rate":{
				"id":316,
				"score":304,
				"vote":533,
				"score5":64,
				"score4":956,
				"score3":587,
				"score2":676,
				"score1":860
			},
			"aliasList":[
				"yab7zt"
			],
			"typeList":[
				"kfc5vy"
			],
			"tagList":[
				"iis6hj"
			],
			"celebrityList":[
				{
					"id":825,
					"urlCelebrityDouban":"cpupw6",
					"idCelebrityImdb":"g9dy7f",
					"urlCelebrityImdb":"hm2nu1",
					"nameZh":"fsp044",
					"nameOrigin":"impbe0",
					"sex":"3ydghr",
					"birthDate":"2020-04-12",
					"urlPortrait":"0ob8ee",
					"summary":"fm3410",
					"relationList":[
						{
							"idMovieDouban":544,
							"idCelebrityDouban":101,
							"idProfession":"w489zd",
							"profession":"i7zbj3",
							"sort":6516
						}
					]
				}
			],
			"trailerList":[
				{
					"id":447,
					"idMovieDouban":754,
					"urlTrailer":"e1amgb",
					"urlVideo":"eeyx8o"
				}
			],
			"imageList":[
				{
					"id":591,
					"urlImageSqxs":"i5xisz",
					"urlImageS":"y4edum",
					"urlImageM":"xz9muy",
					"urlImageL":"ov2yxc",
					"sort":"0og2on",
					"length":362,
					"width":122
				}
			],
			"classicList":[
				{
					"id":"97",
					"idMovieDouban":428,
					"urlMovieDouban":"vbemtg",
					"content":"rr2vo3",
					"happenTime":753,
					"agreeVote":738,
					"user":{
						"idUserDouban":"amiy77",
						"idClassicDouban":"nv6fqc",
						"nameZhUserDouban":"yhdn6z",
						"recordDatetime":1586695720255,
						"description":"lxekvj"
					},
					"celebrity":{
						"idCelebrityDouban":155,
						"idClassicDouban":"0xkb8r",
						"nameZhCelebrityDouban":"gvqwp6"
					}
				}
			],
			"reviewList":[
				{
					"id":827,
					"idUserDouban":"qjabn8",
					"nameUserDouban":"p81dez",
					"urlUserDouban":"xqk0np",
					"urlReview":"vtyyg6",
					"agreeVote":254,
					"againstVote":119,
					"createDatetime":"2020-04-12 20:48:40",
					"title":"vnhu8k",
					"content":"ptz9g9"
				}
			],
			"awardList":[
				{
					"idMovieDouban":215,
					"idAwardMovie":"x3yk20",
					"nameZh":"rb73co",
					"urlAward":"cklvn8",
					"idCelebrityDouban":166,
					"urlCelebrityDouban":"sklkkc",
					"typeAward":"qd1r0y",
					"awardTh":22739,
					"isNominated":"w3q1i5"
				}
			],
			"commentList":[
				{
					"idMovieDouban":710,
					"idUserDouban":"ygmihz",
					"nameUserDouban":"skkwdr",
					"urlUserDouban":"etrsck",
					"agreeVote":21464,
					"createDate":"2020-04-12",
					"content":"jhbxs8"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"97",
				"urlMovieImdb":"kd1phm",
				"idTypeVideo":"sf149l",
				"typeVideo":"xtbudu",
				"nameEn":"78n016",
				"startYear":30117,
				"isAdult":"vn2406",
				"nameOrigin":"j6hoiy",
				"runtime":13773,
				"urlPoster":"skglj0",
				"idMovieDouban":836,
				"summary":"gs7l7o"
			},
			"rate":{
				"idMovieImdb":"2sgork",
				"imdbScore":685,
				"imdbVote":343,
				"tomatoScore":675,
				"mtcScore":789
			},
			"typeList":[
				"kyeacl"
			],
			"celebrityList":[
				{
					"idCelebrityImdb":"i6znyu",
					"urlCelebrityImdb":"tybjhw",
					"idCelebrityDouban":836,
					"urlCelebrityDouban":"y4epmm",
					"nameEn":"8b3dh9",
					"birthYear":18997,
					"relationList":[
						{
							"idMovieImdb":321,
							"idCelebrityImdb":886,
							"idProfession":"1sxtlj",
							"profession":"y1lvsd"
						}
					]
				}
			]
		}
	}
}
```

## 豆瓣电影
### 豆瓣电影基础信息
**URL:** https://api.doubans.com/v2/movie/douban/bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/movie/douban/bases?id=175
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
	"code":629,
	"msg":"8p2e9m",
	"data":{
		"id":770,
		"urlMovieDouban":"1vqny3",
		"idTypeVideo":"cmsuls",
		"typeVideo":"3kcxjq",
		"idMovieImdb":"8x6f3e",
		"urlMovieImdb":"mw79ab",
		"startYear":23483,
		"nameZh":"gb7md7",
		"nameOrigin":"7o1qgk",
		"runtime":12938,
		"urlPoster":"ddzxam",
		"haveSeen":539,
		"wannaSee":428,
		"summary":"4puvcy"
	}
}
```

### 豆瓣电影详情信息
**URL:** https://api.doubans.com/v2/movie/douban/details

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/movie/douban/details?id=875
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该影人与该电影的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|豆瓣电影经典台词ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlMovieDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─content|string|经典台词内容|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─happenTime|int32|经典台词在影片中的出现时间 /m|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─agreeVote|int32|经典台词获得的赞同数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─user|object|相关豆瓣用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idUserDouban|string|豆瓣用户ID 0-未登录用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idClassicDouban|string|豆瓣电影经典台词ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZhUserDouban|string|用户中文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─recordDatetime|int64|豆瓣用户收录时间 /unix|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|豆瓣用户评价|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─celebrity|object|相关豆瓣影人|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idClassicDouban|string|豆瓣电影经典台词ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameZhCelebrityDouban|string|豆瓣影人中文名|-
└─reviewList|array|豆瓣电影热门影评列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影影评ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idUserDouban|string|豆瓣用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameUserDouban|string|豆瓣用户昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlUserDouban|string|豆瓣用户链接|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameUserDouban|string|豆瓣用户昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlUserDouban|string|豆瓣用户链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─agreeVote|int16|投票数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createDate|string|短评日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─content|string|短评内容|-

**Response-example:**
```
{
	"code":347,
	"msg":"5snje9",
	"data":{
		"base":{
			"id":953,
			"urlMovieDouban":"i08mx2",
			"idTypeVideo":"iqy84k",
			"typeVideo":"uirzwq",
			"idMovieImdb":"i5cm1k",
			"urlMovieImdb":"rtmdw1",
			"startYear":24923,
			"nameZh":"1pyyar",
			"nameOrigin":"a8rcgx",
			"runtime":21818,
			"urlPoster":"qxtvjl",
			"haveSeen":800,
			"wannaSee":637,
			"summary":"c3anjw"
		},
		"rate":{
			"id":494,
			"score":823,
			"vote":859,
			"score5":975,
			"score4":620,
			"score3":923,
			"score2":458,
			"score1":155
		},
		"aliasList":[
			"p8ih2y"
		],
		"typeList":[
			"3rpw1e"
		],
		"tagList":[
			"c830li"
		],
		"celebrityList":[
			{
				"id":393,
				"urlCelebrityDouban":"f53tj6",
				"idCelebrityImdb":"1upk7e",
				"urlCelebrityImdb":"oxxus3",
				"nameZh":"013biy",
				"nameOrigin":"xf4fej",
				"sex":"tlrlwl",
				"birthDate":"2020-04-12",
				"urlPortrait":"q5zvp1",
				"summary":"2e9uro",
				"relationList":[
					{
						"idMovieDouban":599,
						"idCelebrityDouban":321,
						"idProfession":"ocunwt",
						"profession":"nnb5u9",
						"sort":32393
					}
				]
			}
		],
		"trailerList":[
			{
				"id":521,
				"idMovieDouban":852,
				"urlTrailer":"j0fwzx",
				"urlVideo":"hd1vya"
			}
		],
		"imageList":[
			{
				"id":127,
				"urlImageSqxs":"7rbsmm",
				"urlImageS":"i54fnr",
				"urlImageM":"enxyvt",
				"urlImageL":"kr6n6y",
				"sort":"pcinpk",
				"length":742,
				"width":919
			}
		],
		"classicList":[
			{
				"id":"97",
				"idMovieDouban":304,
				"urlMovieDouban":"8qgkwj",
				"content":"xkbp84",
				"happenTime":677,
				"agreeVote":329,
				"user":{
					"idUserDouban":"tyqp14",
					"idClassicDouban":"kdstb2",
					"nameZhUserDouban":"sll62i",
					"recordDatetime":1586695720255,
					"description":"ivonuz"
				},
				"celebrity":{
					"idCelebrityDouban":677,
					"idClassicDouban":"alqaqn",
					"nameZhCelebrityDouban":"zwhuag"
				}
			}
		],
		"reviewList":[
			{
				"id":912,
				"idUserDouban":"cebvec",
				"nameUserDouban":"gu9agh",
				"urlUserDouban":"x0vdo4",
				"urlReview":"wcupog",
				"agreeVote":154,
				"againstVote":305,
				"createDatetime":"2020-04-12 20:48:40",
				"title":"b0yewh",
				"content":"x8idh1"
			}
		],
		"awardList":[
			{
				"idMovieDouban":604,
				"idAwardMovie":"ls2r9i",
				"nameZh":"4mqqrm",
				"urlAward":"o6ezxm",
				"idCelebrityDouban":375,
				"urlCelebrityDouban":"s3plrl",
				"typeAward":"l6epp3",
				"awardTh":24379,
				"isNominated":"52nnkg"
			}
		],
		"commentList":[
			{
				"idMovieDouban":574,
				"idUserDouban":"x20sjw",
				"nameUserDouban":"zlfdpm",
				"urlUserDouban":"s6jwj5",
				"agreeVote":25972,
				"createDate":"2020-04-12",
				"content":"3hyiha"
			}
		]
	}
}
```

## IMDB电影
### IMDB电影基础信息
**URL:** https://api.doubans.com/v2/movie/imdb/bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/movie/imdb/bases?id=181
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
	"code":897,
	"msg":"d9g4yv",
	"data":{
		"id":"97",
		"urlMovieImdb":"v2n63v",
		"idTypeVideo":"7j1dxc",
		"typeVideo":"992wmx",
		"nameEn":"89z73p",
		"startYear":20249,
		"isAdult":"vz4751",
		"nameOrigin":"psj7ng",
		"runtime":30313,
		"urlPoster":"ikldgf",
		"idMovieDouban":854,
		"summary":"ergjm1"
	}
}
```

### IMDB电影详情信息
**URL:** https://api.doubans.com/v2/movie/imdb/details

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/movie/imdb/details?id=102
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID 0-未匹配 1-已匹配|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlCelebrityDouban|string|豆瓣电影链接|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|IMDB影人英文名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthYear|int16|出生年份 /year|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该影人与该电影的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|int64|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|int64|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-

**Response-example:**
```
{
	"code":840,
	"msg":"kaaj67",
	"data":{
		"base":{
			"id":"97",
			"urlMovieImdb":"rcb57z",
			"idTypeVideo":"5xmhz1",
			"typeVideo":"ysnd93",
			"nameEn":"bjpold",
			"startYear":16377,
			"isAdult":"q5o957",
			"nameOrigin":"bpy320",
			"runtime":22248,
			"urlPoster":"ylgdmt",
			"idMovieDouban":527,
			"summary":"bqpqqf"
		},
		"rate":{
			"idMovieImdb":"vbvais",
			"imdbScore":753,
			"imdbVote":534,
			"tomatoScore":965,
			"mtcScore":505
		},
		"typeList":[
			"pc8rfo"
		],
		"celebrityList":[
			{
				"idCelebrityImdb":"1t0g3n",
				"urlCelebrityImdb":"0ww4l9",
				"idCelebrityDouban":390,
				"urlCelebrityDouban":"q1i60t",
				"nameEn":"daw9az",
				"birthYear":28958,
				"relationList":[
					{
						"idMovieImdb":305,
						"idCelebrityImdb":473,
						"idProfession":"eqiz5a",
						"profession":"j9m9yo"
					}
				]
			}
		]
	}
}
```

## 场景地点搜索
### 场景地点搜索提示
**URL:** https://api.doubans.com/v2/search/place/scene/tips

**Type:** GET

**Author:** humingk

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据地点名称开头的字符串找出场景地点的基本信息列表

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
curl -X GET -i https://api.doubans.com/v2/search/place/scene/tips?offset=0&keyword=hrf95d&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─id|int64|场景地点ID|-
└─longitude|number|经度|-
└─latitude|number|纬度|-
└─nameZh|string|中文名|-
└─nameEn|string|英文名|-
└─nameOther|string|其他语言名|-
└─alias|string|别名|-
└─addressZh|string|中文地址|-
└─addressEn|string|英文地址|-
└─description|string|地点描述|-
└─areaZh|string|区域中文|-
└─areaEn|string|区域英文|-
└─phone|string|电话号码|-
└─urlPoster|string|地点海报图链接|-
└─urlEarth|string|地点地球位置图链接|-
└─urlSatellite|string|地点卫星图链接|-
└─urlMap|string|地点地图|-

**Response-example:**
```
{
	"code":738,
	"msg":"l4ecm2",
	"data":[
		{
			"id":663,
			"longitude":389,
			"latitude":947,
			"nameZh":"vw228m",
			"nameEn":"6zv2sm",
			"nameOther":"o9b748",
			"alias":"w7ys8w",
			"addressZh":"mdssdh",
			"addressEn":"v0fe6n",
			"description":"jsl592",
			"areaZh":"vrbjmo",
			"areaEn":"ukdxt2",
			"phone":"15900539132",
			"urlPoster":"jtquld",
			"urlEarth":"l680ra",
			"urlSatellite":"0f7j2k",
			"urlMap":"tx5443"
		}
	]
}
```

## 豆瓣搜索
### 豆瓣搜索提示
**URL:** https://api.doubans.com/v2/search/douban/tips

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/search/douban/tips?keyword=p3mutw&offset=0&limit=10
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
	"code":661,
	"msg":"q6yq9l",
	"data":{
		"movieList":[
			{
				"base":{
					"id":617,
					"urlMovieDouban":"0meg72",
					"idTypeVideo":"kakfhw",
					"typeVideo":"i9q5ay",
					"idMovieImdb":"jh04lo",
					"urlMovieImdb":"4amfma",
					"startYear":9400,
					"nameZh":"wrz9kk",
					"nameOrigin":"sxcik2",
					"runtime":29813,
					"urlPoster":"5wdmrq",
					"haveSeen":786,
					"wannaSee":823,
					"summary":"0vdp3y"
				},
				"rate":{
					"id":675,
					"score":753,
					"vote":922,
					"score5":894,
					"score4":919,
					"score3":264,
					"score2":952,
					"score1":686
				},
				"aliasList":[
					"9d91sl"
				]
			}
		],
		"celebrityList":[
			{
				"base":{
					"id":654,
					"urlCelebrityDouban":"eglx2n",
					"idCelebrityImdb":"zdpsov",
					"urlCelebrityImdb":"nc3igw",
					"nameZh":"yqcfih",
					"nameOrigin":"yejv0o",
					"sex":"lralhq",
					"birthDate":"2020-04-12",
					"urlPortrait":"cfjl27",
					"summary":"hgb2hb"
				},
				"aliasList":[
					{
						"nameAlias":"p85oya",
						"isNikename":"knjog0"
					}
				]
			}
		]
	}
}
```

### 豆瓣搜索结果
**URL:** https://api.doubans.com/v2/search/douban/details

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/search/douban/details?offset=0&keyword=mm3b6g&limit=10
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该影人与该电影的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该电影与该影人的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-

**Response-example:**
```
{
	"code":341,
	"msg":"86egfl",
	"data":{
		"movieList":[
			{
				"base":{
					"id":424,
					"urlMovieDouban":"gf4s5q",
					"idTypeVideo":"en74t6",
					"typeVideo":"glxfey",
					"idMovieImdb":"f1hw81",
					"urlMovieImdb":"zcovc2",
					"startYear":31316,
					"nameZh":"7ax2q9",
					"nameOrigin":"lynkgq",
					"runtime":11831,
					"urlPoster":"2bekd8",
					"haveSeen":64,
					"wannaSee":200,
					"summary":"5qrwvh"
				},
				"rate":{
					"id":767,
					"score":213,
					"vote":206,
					"score5":890,
					"score4":371,
					"score3":833,
					"score2":992,
					"score1":543
				},
				"aliasList":[
					"ozvjda"
				],
				"typeList":[
					"p7k6qx"
				],
				"celebrityList":[
					{
						"id":114,
						"urlCelebrityDouban":"ds38gt",
						"idCelebrityImdb":"gr553e",
						"urlCelebrityImdb":"9pfqmh",
						"nameZh":"nfbtbj",
						"nameOrigin":"m29o3s",
						"sex":"yqzzad",
						"birthDate":"2020-04-12",
						"urlPortrait":"krfo5t",
						"summary":"uii1oe",
						"relationList":[
							{
								"idMovieDouban":774,
								"idCelebrityDouban":404,
								"idProfession":"nmf8is",
								"profession":"myzu93",
								"sort":9282
							}
						]
					}
				]
			}
		],
		"celebrityList":[
			{
				"base":{
					"id":726,
					"urlCelebrityDouban":"unt1ew",
					"idCelebrityImdb":"ra6a3y",
					"urlCelebrityImdb":"thbo5h",
					"nameZh":"667xfp",
					"nameOrigin":"5to639",
					"sex":"pf63cv",
					"birthDate":"2020-04-12",
					"urlPortrait":"ko46xo",
					"summary":"523l3c"
				},
				"aliasList":[
					{
						"nameAlias":"yr3niq",
						"isNikename":"cs1z03"
					}
				],
				"movieList":[
					{
						"id":852,
						"urlMovieDouban":"cu500o",
						"idTypeVideo":"rdf172",
						"typeVideo":"8o2klt",
						"idMovieImdb":"etrqdh",
						"urlMovieImdb":"o7n9dn",
						"startYear":2910,
						"nameZh":"5p6wud",
						"nameOrigin":"83r5vs",
						"runtime":31226,
						"urlPoster":"9lpr85",
						"haveSeen":952,
						"wannaSee":357,
						"summary":"m0r32t",
						"relationList":[
							{
								"idMovieDouban":627,
								"idCelebrityDouban":578,
								"idProfession":"ria9pr",
								"profession":"zdq0xq",
								"sort":5437
							}
						]
					}
				]
			}
		]
	}
}
```

## 豆瓣电影搜索
### 豆瓣电影搜索提示
**URL:** https://api.doubans.com/v2/search/movie/douban/tips

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/search/movie/douban/tips?offset=0&keyword=63aorw&limit=10
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
	"code":738,
	"msg":"gj4dnk",
	"data":[
		{
			"base":{
				"id":40,
				"urlMovieDouban":"x6260j",
				"idTypeVideo":"o896ve",
				"typeVideo":"2sw1na",
				"idMovieImdb":"6v6c2y",
				"urlMovieImdb":"4cf1p6",
				"startYear":14913,
				"nameZh":"lirma4",
				"nameOrigin":"4ls61j",
				"runtime":30045,
				"urlPoster":"3ixpiw",
				"haveSeen":441,
				"wannaSee":907,
				"summary":"vheozn"
			},
			"rate":{
				"id":866,
				"score":250,
				"vote":967,
				"score5":182,
				"score4":912,
				"score3":403,
				"score2":17,
				"score1":522
			},
			"aliasList":[
				"kys725"
			]
		}
	]
}
```

### 豆瓣电影搜索结果
**URL:** https://api.doubans.com/v2/search/movie/douban/details

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/search/movie/douban/details?keyword=jarsmc&offset=0&limit=10
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该影人与该电影的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-

**Response-example:**
```
{
	"code":420,
	"msg":"26mgju",
	"data":[
		{
			"base":{
				"id":570,
				"urlMovieDouban":"gec3fp",
				"idTypeVideo":"fppi0b",
				"typeVideo":"2snyak",
				"idMovieImdb":"182453",
				"urlMovieImdb":"rngm2v",
				"startYear":27882,
				"nameZh":"g7j4qw",
				"nameOrigin":"4t3a0n",
				"runtime":10289,
				"urlPoster":"6if1x5",
				"haveSeen":758,
				"wannaSee":615,
				"summary":"uj23hm"
			},
			"rate":{
				"id":121,
				"score":756,
				"vote":591,
				"score5":594,
				"score4":837,
				"score3":12,
				"score2":713,
				"score1":818
			},
			"aliasList":[
				"ql3ltg"
			],
			"typeList":[
				"56ff0n"
			],
			"celebrityList":[
				{
					"id":369,
					"urlCelebrityDouban":"qrnbod",
					"idCelebrityImdb":"f3rr04",
					"urlCelebrityImdb":"kphx9t",
					"nameZh":"p3g3kd",
					"nameOrigin":"gm0uw2",
					"sex":"njo57a",
					"birthDate":"2020-04-12",
					"urlPortrait":"okbqfh",
					"summary":"p6l1t8",
					"relationList":[
						{
							"idMovieDouban":19,
							"idCelebrityDouban":230,
							"idProfession":"tq7iaf",
							"profession":"q6c0eq",
							"sort":12672
						}
					]
				}
			]
		}
	]
}
```

## 豆瓣影人搜索
### 豆瓣影人搜索提示
**URL:** https://api.doubans.com/v2/search/celebrity/douban/tips

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/search/celebrity/douban/tips?keyword=3kyhen&offset=0&limit=10
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
	"code":320,
	"msg":"b9fzwi",
	"data":[
		{
			"base":{
				"id":271,
				"urlCelebrityDouban":"ixl34d",
				"idCelebrityImdb":"samh5y",
				"urlCelebrityImdb":"owm16g",
				"nameZh":"jsepbb",
				"nameOrigin":"tvuw2a",
				"sex":"3wkate",
				"birthDate":"2020-04-12",
				"urlPortrait":"15stgz",
				"summary":"e9llot"
			},
			"aliasList":[
				{
					"nameAlias":"rujoay",
					"isNikename":"caznsu"
				}
			]
		}
	]
}
```

### 豆瓣影人搜索结果
**URL:** https://api.doubans.com/v2/search/celebrity/douban/details

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/search/celebrity/douban/details?limit=10&keyword=lr2ij1&offset=0
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该电影与该影人的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-

**Response-example:**
```
{
	"code":449,
	"msg":"zc8rsv",
	"data":[
		{
			"base":{
				"id":277,
				"urlCelebrityDouban":"lujuly",
				"idCelebrityImdb":"0qbrx0",
				"urlCelebrityImdb":"9ap0e8",
				"nameZh":"86ujrg",
				"nameOrigin":"i5s38y",
				"sex":"h505s0",
				"birthDate":"2020-04-12",
				"urlPortrait":"mw0u3h",
				"summary":"3pvkjh"
			},
			"aliasList":[
				{
					"nameAlias":"6ig4ke",
					"isNikename":"fpot16"
				}
			],
			"movieList":[
				{
					"id":2,
					"urlMovieDouban":"1k5e3r",
					"idTypeVideo":"v2qmlw",
					"typeVideo":"fcjekg",
					"idMovieImdb":"ifd4wf",
					"urlMovieImdb":"l87bl4",
					"startYear":275,
					"nameZh":"anlgus",
					"nameOrigin":"l6im3b",
					"runtime":16540,
					"urlPoster":"opqt6i",
					"haveSeen":417,
					"wannaSee":707,
					"summary":"kw3cf6",
					"relationList":[
						{
							"idMovieDouban":724,
							"idCelebrityDouban":491,
							"idProfession":"ccuni8",
							"profession":"cijhex",
							"sort":24
						}
					]
				}
			]
		}
	]
}
```

## 场景电影搜索
### 场景电影搜索提示
**URL:** https://api.doubans.com/v2/search/movie/scene/tips

**Type:** GET

**Author:** humingk

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据电影名称开头的字符串找出场景电影的基本信息列表

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
curl -X GET -i https://api.doubans.com/v2/search/movie/scene/tips?limit=10&offset=0&keyword=rgowlb
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─id|int64|场景电影ID|-
└─urlMovieScene|string|场景电影链接|-
└─idMovieDouban|int64|豆瓣电影ID 0-未匹配 1-已匹配|-
└─urlMovieDouban|string|豆瓣电影链接|-
└─nameZh|string|场景电影中文名|-
└─nameEn|string|场景电影英文名|-
└─startYear|int16|上映时间 /year|-
└─description|string|场景电影拍摄地点大致描述|-
└─urlMap|string|场景电影地点分布图链接|-

**Response-example:**
```
{
	"code":831,
	"msg":"ufswf0",
	"data":[
		{
			"id":623,
			"urlMovieScene":"zflv5z",
			"idMovieDouban":827,
			"urlMovieDouban":"8fgs7d",
			"nameZh":"ozrfsx",
			"nameEn":"pgssy5",
			"startYear":27559,
			"description":"cx3f5a",
			"urlMap":"bi0oz9"
		}
	]
}
```

## 电影集合搜索
## 豆瓣影人
### 豆瓣影人基础信息
**URL:** https://api.doubans.com/v2/celebrity/douban/bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/celebrity/douban/bases?id=705
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
	"code":435,
	"msg":"5i287n",
	"data":{
		"id":561,
		"urlCelebrityDouban":"4murcc",
		"idCelebrityImdb":"bfva39",
		"urlCelebrityImdb":"mw7ap0",
		"nameZh":"dpfmfn",
		"nameOrigin":"m5gbv4",
		"sex":"5aqw9j",
		"birthDate":"2020-04-12",
		"urlPortrait":"zdmo9v",
		"summary":"85kywv"
	}
}
```

### 豆瓣影人详细信息
**URL:** https://api.doubans.com/v2/celebrity/douban/details

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/celebrity/douban/details?id=369&limit=10
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该电影与该影人的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该电影与该影人的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
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
	"code":566,
	"msg":"6avs74",
	"data":{
		"base":{
			"id":45,
			"urlCelebrityDouban":"dag8om",
			"idCelebrityImdb":"71tde1",
			"urlCelebrityImdb":"dw991o",
			"nameZh":"di1p1v",
			"nameOrigin":"4i8cgc",
			"sex":"q3648s",
			"birthDate":"2020-04-12",
			"urlPortrait":"j8qo6m",
			"summary":"cq5imv"
		},
		"aliasList":[
			{
				"nameAlias":"ghdg5u",
				"isNikename":"me2peq"
			}
		],
		"imageList":[
			{
				"id":192,
				"urlImageSqxs":"nxn2eu",
				"urlImageS":"9hifcy",
				"urlImageM":"4cmaj5",
				"urlImageL":"aj8pya",
				"sort":"kkkije",
				"length":91,
				"width":408
			}
		],
		"movieListOrderByScore":[
			{
				"id":733,
				"urlMovieDouban":"2ylo1t",
				"idTypeVideo":"i9f1ur",
				"typeVideo":"j56jwj",
				"idMovieImdb":"eelgg7",
				"urlMovieImdb":"borvu9",
				"startYear":32622,
				"nameZh":"p4iixy",
				"nameOrigin":"f67xy6",
				"runtime":18709,
				"urlPoster":"tgvf7p",
				"haveSeen":168,
				"wannaSee":607,
				"summary":"svzxtz",
				"relationList":[
					{
						"idMovieDouban":660,
						"idCelebrityDouban":217,
						"idProfession":"rngf0p",
						"profession":"qr1718",
						"sort":10251
					}
				]
			}
		],
		"movieListOrderByStartYear":[
			{
				"id":962,
				"urlMovieDouban":"hzaxr6",
				"idTypeVideo":"w23ar9",
				"typeVideo":"7gw96p",
				"idMovieImdb":"h2a8c7",
				"urlMovieImdb":"445tb6",
				"startYear":18329,
				"nameZh":"i7diuc",
				"nameOrigin":"k93gg2",
				"runtime":8049,
				"urlPoster":"9c4qk3",
				"haveSeen":197,
				"wannaSee":76,
				"summary":"i629h1",
				"relationList":[
					{
						"idMovieDouban":497,
						"idCelebrityDouban":495,
						"idProfession":"805hhf",
						"profession":"gewqhv",
						"sort":26192
					}
				]
			}
		],
		"awardList":[
			{
				"idMovieDouban":183,
				"idAwardMovie":"h7z43l",
				"nameZh":"rfyjod",
				"urlAward":"5robwn",
				"idCelebrityDouban":22,
				"urlCelebrityDouban":"nklfee",
				"typeAward":"xxs8sj",
				"awardTh":1345,
				"isNominated":"gqu8fm"
			}
		]
	}
}
```

### 豆瓣影人合作过的影人基础信息
**URL:** https://api.doubans.com/v2/celebrity/douban/cooperators_bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/celebrity/douban/cooperators_bases?limit=10&id=486&offset=0
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
	"code":965,
	"msg":"25c5yt",
	"data":{
		"waring":"You may have used non-display generics."
	}
}
```

## 影人集合
### 影人基础信息
**URL:** https://api.doubans.com/v2/celebrity/bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/celebrity/bases?id=220
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
	"code":682,
	"msg":"dw0hpq",
	"data":{
		"douban":{
			"id":658,
			"urlCelebrityDouban":"ructk7",
			"idCelebrityImdb":"ny9m9u",
			"urlCelebrityImdb":"9bn79j",
			"nameZh":"8yvoyb",
			"nameOrigin":"lxb2a1",
			"sex":"btg4li",
			"birthDate":"2020-04-12",
			"urlPortrait":"55np3w",
			"summary":"s7u7qr"
		},
		"imdb":{
			"id":"97",
			"nameEn":"it9anb",
			"birthYear":4758,
			"idCelebrityDouban":76
		}
	}
}
```

### 影人详细信息
**URL:** https://api.doubans.com/v2/celebrity/details

**Type:** GET

**Author:** humingk

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
doubanLimit|int32|豆瓣相关的电影限制数（默认10）|false|-
imdbLimit|int32|IMDB相关的电影限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/celebrity/details?imdbLimit=10&doubanLimit=10&id=972
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该电影与该影人的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该电影与该影人的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieDouban|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityDouban|int64|豆瓣影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sort|int16|该影人在该电影中的演员排列顺序|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该电影与该影人的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|int64|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|int64|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-

**Response-example:**
```
{
	"code":925,
	"msg":"cr5fhx",
	"data":{
		"douban":{
			"base":{
				"id":196,
				"urlCelebrityDouban":"6mno2u",
				"idCelebrityImdb":"t36c68",
				"urlCelebrityImdb":"0fwmby",
				"nameZh":"ojrnnz",
				"nameOrigin":"2zve3r",
				"sex":"txytzb",
				"birthDate":"2020-04-12",
				"urlPortrait":"uxhen7",
				"summary":"dutwnh"
			},
			"aliasList":[
				{
					"nameAlias":"vlwqx3",
					"isNikename":"njvw39"
				}
			],
			"imageList":[
				{
					"id":908,
					"urlImageSqxs":"noxtkc",
					"urlImageS":"pirmah",
					"urlImageM":"3lkyjv",
					"urlImageL":"zzhnlj",
					"sort":"7e8efp",
					"length":557,
					"width":708
				}
			],
			"movieListOrderByScore":[
				{
					"id":12,
					"urlMovieDouban":"bt7qlf",
					"idTypeVideo":"hebsyf",
					"typeVideo":"rrjsi7",
					"idMovieImdb":"r23m0e",
					"urlMovieImdb":"3dyh7w",
					"startYear":9613,
					"nameZh":"vdncnu",
					"nameOrigin":"4n3l8j",
					"runtime":8838,
					"urlPoster":"tyxdt3",
					"haveSeen":727,
					"wannaSee":54,
					"summary":"lhldyd",
					"relationList":[
						{
							"idMovieDouban":299,
							"idCelebrityDouban":171,
							"idProfession":"nbbsny",
							"profession":"zka55x",
							"sort":10712
						}
					]
				}
			],
			"movieListOrderByStartYear":[
				{
					"id":72,
					"urlMovieDouban":"c0dpjg",
					"idTypeVideo":"qyvsa0",
					"typeVideo":"8ckx93",
					"idMovieImdb":"bsj2cp",
					"urlMovieImdb":"inj1ap",
					"startYear":11427,
					"nameZh":"ycklpp",
					"nameOrigin":"hhjups",
					"runtime":10964,
					"urlPoster":"cvdq33",
					"haveSeen":295,
					"wannaSee":574,
					"summary":"t8xaja",
					"relationList":[
						{
							"idMovieDouban":266,
							"idCelebrityDouban":138,
							"idProfession":"ar18p9",
							"profession":"rq8xp3",
							"sort":23738
						}
					]
				}
			],
			"awardList":[
				{
					"idMovieDouban":732,
					"idAwardMovie":"8gllcy",
					"nameZh":"vl32x3",
					"urlAward":"hfu4x3",
					"idCelebrityDouban":287,
					"urlCelebrityDouban":"el3hh9",
					"typeAward":"rf0fbr",
					"awardTh":20247,
					"isNominated":"7goea2"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"97",
				"nameEn":"8tren3",
				"birthYear":21120,
				"idCelebrityDouban":183
			},
			"movieList":[
				{
					"id":"97",
					"idTypeVideo":"9122s7",
					"typeVideo":"251q5g",
					"nameEn":"2qm9px",
					"startYear":9383,
					"isAdult":"yf8yqn",
					"nameOrigin":"47xo71",
					"runtime":22520,
					"urlPoster":"y5b76a",
					"idMovieDouban":813,
					"summary":"c4z9lq",
					"relationList":[
						{
							"idMovieImdb":704,
							"idCelebrityImdb":397,
							"idProfession":"6v6y8d",
							"profession":"dhikwx"
						}
					]
				}
			]
		}
	}
}
```

## IMDB影人
### IMDB影人基础信息
**URL:** https://api.doubans.com/v2/celebrity/imdb/bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/celebrity/imdb/bases?id=29
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
	"code":525,
	"msg":"xwoeck",
	"data":{
		"id":"97",
		"nameEn":"oreca0",
		"birthYear":10085,
		"idCelebrityDouban":377
	}
}
```

### IMDB影人详细信息
**URL:** https://api.doubans.com/v2/celebrity/imdb/details

**Type:** GET

**Author:** humingk

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
limit|int32|相关的电影限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/celebrity/imdb/details?limit=10&id=653
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─relationList|array|该电影与该影人的关系列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMovieImdb|int64|IMDB电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idCelebrityImdb|int64|IMDB影人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idProfession|string|该影人在该电影中的职位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─profession|string|该影人在该电影中的职位|-

**Response-example:**
```
{
	"code":627,
	"msg":"11iate",
	"data":{
		"base":{
			"id":"97",
			"nameEn":"5r9q6f",
			"birthYear":1597,
			"idCelebrityDouban":381
		},
		"movieList":[
			{
				"id":"97",
				"idTypeVideo":"2suzp1",
				"typeVideo":"flpg0f",
				"nameEn":"17immh",
				"startYear":18901,
				"isAdult":"hxqs5a",
				"nameOrigin":"f2m2sk",
				"runtime":2096,
				"urlPoster":"k4lxnz",
				"idMovieDouban":926,
				"summary":"u404pi",
				"relationList":[
					{
						"idMovieImdb":792,
						"idCelebrityImdb":29,
						"idProfession":"l52jae",
						"profession":"ah150a"
					}
				]
			}
		]
	}
}
```

## 音乐
## 电影场景
### 电影场景简略信息
**URL:** https://api.doubans.com/v2/scene/fotoplace/bases

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/scene/fotoplace/bases?id=674
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

**Response-example:**
```
{
	"code":711,
	"msg":"az75e4",
	"data":{
		"base":{
			"id":60,
			"urlMovieScene":"mkdvgj",
			"idMovieDouban":555,
			"urlMovieDouban":"wttla0",
			"nameZh":"yuxbsf",
			"nameEn":"0ue1ll",
			"startYear":10088,
			"description":"c64ybb",
			"urlMap":"dnd4e1"
		},
		"sceneList":[
			{
				"base":{
					"id":518,
					"idMovieScene":90,
					"idPlaceScene":768,
					"nameZh":"47wovr",
					"happenTime":536
				},
				"place":{
					"base":{
						"id":249,
						"longitude":564,
						"latitude":252,
						"nameZh":"h8ltp4",
						"nameEn":"40cxlw",
						"nameOther":"025kts",
						"alias":"jlg9ih",
						"addressZh":"fkcjvd",
						"addressEn":"h6vne4",
						"description":"jck9tl",
						"areaZh":"dl8jm2",
						"areaEn":"bqov92",
						"phone":"15900539132",
						"urlPoster":"4fqwla",
						"urlEarth":"bj8n8w",
						"urlSatellite":"c6fzex",
						"urlMap":"9zouge"
					}
				}
			}
		]
	}
}
```

### 电影场景详细信息
**URL:** https://api.doubans.com/v2/scene/fotoplace/details

**Type:** GET

**Author:** humingk

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
curl -X GET -i https://api.doubans.com/v2/scene/fotoplace/details?id=503
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
	"code":542,
	"msg":"4rgfmh",
	"data":{
		"base":{
			"id":440,
			"urlMovieScene":"9z1boc",
			"idMovieDouban":1,
			"urlMovieDouban":"p2zus5",
			"nameZh":"aqh7nc",
			"nameEn":"2tnt8g",
			"startYear":20960,
			"description":"j8d85g",
			"urlMap":"81apwz"
		},
		"sceneList":[
			{
				"base":{
					"id":676,
					"idMovieScene":644,
					"urlMovieScene":"y3l470",
					"idPlaceScene":715,
					"nameZh":"2r9rh8",
					"happenTime":588
				},
				"sceneDetailList":[
					{
						"base":{
							"id":411,
							"idScene":723,
							"idMovieScene":706,
							"happenTime":188,
							"description":"re4egx"
						},
						"imageList":[
							{
								"id":853,
								"idSceneDetail":882,
								"urlImage":"czvbwg"
							}
						],
						"celebrityList":[
							{
								"id":400,
								"idCelebrityDouban":976,
								"urlCelebrityDouban":"m6kc41",
								"nameZh":"9usvrg",
								"nameEn":"mhn8qg",
								"idSceneDetail":171
							}
						]
					}
				],
				"place":{
					"base":{
						"id":159,
						"longitude":690,
						"latitude":320,
						"nameZh":"1wmioc",
						"nameEn":"x3839x",
						"nameOther":"dqb26m",
						"alias":"sr8e43",
						"addressZh":"d18244",
						"addressEn":"zfcdol",
						"description":"wfhvry",
						"areaZh":"sm6cyg",
						"areaEn":"sle6h4",
						"phone":"15900539132",
						"urlPoster":"3dueui",
						"urlEarth":"wkbwfv",
						"urlSatellite":"r8bc0f",
						"urlMap":"w3do3z"
					},
					"imageList":[
						{
							"id":126,
							"idPlaceScene":230,
							"urlImage":"dfzfqd",
							"description":"7li406"
						}
					],
					"typeList":[
						"ul15j2"
					],
					"continent":"rfky6s",
					"country":"1aorry",
					"city":"naoguq",
					"state":"0hkcah"
				}
			}
		]
	}
}
```


