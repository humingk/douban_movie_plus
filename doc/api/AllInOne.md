# 豆瓣电影Plus RESTful-API文档
Version |  Update Time  | Status | Author |  Description
------|--------|-----|------|-------
2.0.0||create|humingk|创建RESTful-API文档
2.0.7||update|humingk|更新



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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/movie/resource/bases?id=99
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
	"code":536,
	"msg":"byg167",
	"data":[
		{
			"id":659,
			"idMovieDouban":173,
			"urlMovieDouban":"n08q5m",
			"idMovieImdb":189,
			"urlMovieImdb":"w7l0ar",
			"idWebsiteResource":4635,
			"websiteResource":"w3clgu",
			"urlWebsiteResource":"1ki8ew",
			"idTypeResource":16703,
			"typeResource":"a36ryw",
			"nameZh":"rjcfod",
			"createYear":25838,
			"nameOrigin":"65oz4j",
			"urlResource":"twn7zu"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/movie/zhihu/bases?id=758
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
	"code":419,
	"msg":"24md88",
	"data":{
		"topic":{
			"id":200,
			"urlZhihuTopic":"uwt19k",
			"idMovieDouban":469,
			"urlMovieDouban":"olhtc5",
			"nameZh":"q7q5xq",
			"zhihuScore":860,
			"zhihuVote":237,
			"maoyanScore":849
		},
		"questionList":[
			{
				"id":448,
				"urlZhihuQuestion":"82zfke",
				"idMovieDouban":295,
				"urlMovieDouban":"v3bt7o",
				"nameZh":"rjdp88",
				"answerNum":901
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/movie/bases?id=197
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
	"code":196,
	"msg":"3mbn1y",
	"data":{
		"douban":{
			"id":632,
			"urlMovieDouban":"c2a204",
			"idTypeVideo":"gs9zrr",
			"typeVideo":"i0xd9o",
			"idMovieImdb":"4w58x8",
			"urlMovieImdb":"gz5l4z",
			"startYear":12842,
			"nameZh":"6oheg2",
			"nameOrigin":"5g9na9",
			"runtime":31712,
			"urlPoster":"f8blbv",
			"haveSeen":220,
			"wannaSee":632,
			"summary":"d3cpzl"
		},
		"imdb":{
			"id":"64",
			"urlMovieImdb":"enlyb7",
			"idTypeVideo":"tcbzdj",
			"typeVideo":"77gd0f",
			"nameEn":"9xdrpv",
			"startYear":3025,
			"isAdult":"rn9fmr",
			"nameOrigin":"y3whnf",
			"runtime":17909,
			"urlPoster":"djgnzp",
			"idMovieDouban":426,
			"summary":"b85fcc"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/movie/details?id=598
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
	"code":308,
	"msg":"g3l1ko",
	"data":{
		"douban":{
			"base":{
				"id":822,
				"urlMovieDouban":"n6cize",
				"idTypeVideo":"cwmuu1",
				"typeVideo":"gdffk9",
				"idMovieImdb":"bmgn0s",
				"urlMovieImdb":"2s81ln",
				"startYear":23491,
				"nameZh":"6c2ahe",
				"nameOrigin":"8b0mwp",
				"runtime":31775,
				"urlPoster":"hnf5fo",
				"haveSeen":906,
				"wannaSee":50,
				"summary":"ft69vu"
			},
			"rate":{
				"id":268,
				"score":812,
				"vote":122,
				"score5":384,
				"score4":270,
				"score3":316,
				"score2":580,
				"score1":863
			},
			"aliasList":[
				"dnkit3"
			],
			"typeList":[
				"cbm9av"
			],
			"tagList":[
				"rckstb"
			],
			"celebrityList":[
				{
					"id":0,
					"urlCelebrityDouban":"ouvrrb",
					"idCelebrityImdb":"6cnso0",
					"urlCelebrityImdb":"c4b2wr",
					"nameZh":"iv657g",
					"nameOrigin":"3vv8ax",
					"sex":"2a93rr",
					"birthDate":"2020-05-01",
					"urlPortrait":"2djzfv",
					"summary":"dfvdf6",
					"relationList":[
						{
							"idMovieDouban":79,
							"idCelebrityDouban":878,
							"idProfession":"c86yhx",
							"profession":"dobey3",
							"sort":5747
						}
					]
				}
			],
			"trailerList":[
				{
					"id":542,
					"idMovieDouban":351,
					"urlTrailer":"h8uf6u",
					"urlVideo":"4n3oml"
				}
			],
			"imageList":[
				{
					"id":380,
					"urlImageSqxs":"dqrk1v",
					"urlImageS":"a4yv3m",
					"urlImageM":"6sz83v",
					"urlImageL":"qse5nb",
					"sort":"uni6x6",
					"length":920,
					"width":254
				}
			],
			"classicList":[
				{
					"id":"64",
					"idMovieDouban":716,
					"urlMovieDouban":"1p45vn",
					"content":"93pv8q",
					"happenTime":230,
					"agreeVote":276,
					"user":{
						"idUserDouban":"h5j5di",
						"idClassicDouban":"4aohx7",
						"nameZhUserDouban":"45v7c5",
						"recordDatetime":1588342991255,
						"description":"nnfdhl"
					},
					"celebrity":{
						"idCelebrityDouban":326,
						"idClassicDouban":"ker2aa",
						"nameZhCelebrityDouban":"i4ncr0"
					}
				}
			],
			"reviewList":[
				{
					"id":945,
					"idUserDouban":"y35h8c",
					"nameUserDouban":"szsg8v",
					"urlUserDouban":"8lichz",
					"urlReview":"0x8l0r",
					"agreeVote":125,
					"againstVote":534,
					"createDatetime":"2020-05-01 22:23:11",
					"title":"iiiuwl",
					"content":"8bq3yv"
				}
			],
			"awardList":[
				{
					"idMovieDouban":548,
					"idAwardMovie":"zmgxtc",
					"nameZh":"vs6ylv",
					"urlAward":"5vr3jb",
					"idCelebrityDouban":821,
					"urlCelebrityDouban":"7614ps",
					"typeAward":"m2bz6a",
					"awardTh":28531,
					"isNominated":"hh7j5w"
				}
			],
			"commentList":[
				{
					"idMovieDouban":539,
					"idUserDouban":"5slgn6",
					"nameUserDouban":"xvv0ig",
					"urlUserDouban":"br2789",
					"agreeVote":28392,
					"createDate":"2020-05-01",
					"content":"y85ssy"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"64",
				"urlMovieImdb":"y8imr2",
				"idTypeVideo":"3u4ag5",
				"typeVideo":"6oore7",
				"nameEn":"i2p7t4",
				"startYear":7500,
				"isAdult":"ga9400",
				"nameOrigin":"n50tpt",
				"runtime":4162,
				"urlPoster":"5qx8k5",
				"idMovieDouban":319,
				"summary":"q6b7re"
			},
			"rate":{
				"idMovieImdb":"3beppu",
				"imdbScore":155,
				"imdbVote":486,
				"tomatoScore":387,
				"mtcScore":19
			},
			"typeList":[
				"egjuhz"
			],
			"celebrityList":[
				{
					"idCelebrityImdb":"6tpfmg",
					"urlCelebrityImdb":"stjxlk",
					"idCelebrityDouban":174,
					"urlCelebrityDouban":"dxwkia",
					"nameEn":"ugzp4a",
					"birthYear":16152,
					"relationList":[
						{
							"idMovieImdb":112,
							"idCelebrityImdb":809,
							"idProfession":"utmdv4",
							"profession":"x2h32q"
						}
					]
				}
			]
		}
	}
}
```

### 电影评分信息
**URL:** https://api.doubans.com/v2/movie/rate/details

**Type:** GET

**Author:** humingk

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 包括豆瓣电影评分、IMDB评分、烂番茄新鲜度、MTC评分、猫眼评分、知乎推荐度等

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/movie/rate/details?id=217
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|状态码|-
msg|string|状态信息|-
data|object|具体结果|-
└─bases|object|豆瓣电影基础信息|-
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
└─doubanRate|object|豆瓣电影评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|豆瓣电影ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score|number|豆瓣电影评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─vote|int32|豆瓣电影评分人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score5|number|豆瓣5星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score4|number|豆瓣4星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score3|number|豆瓣3星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score2|number|豆瓣2星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score1|number|豆瓣1星比例|-
└─idMovieImdb|string|IMDB电影ID|-
└─urlMovieImdb|string|IMDB电影链接|-
└─imdbScore|number|IMDB评分|-
└─imdbVote|int32|IMDB评分人数|-
└─tomatoScore|number|烂番茄新鲜度|-
└─mtcScore|number|MTC评分|-
└─idMovieZhihu|int64|知乎电影ID|-
└─urlZhihuTopic|string|知乎话题链接|-
└─zhihuScore|number|知乎评分|-
└─zhihuVote|int32|知乎评分票数|-
└─maoyanScore|number|猫眼评分|-

**Response-example:**
```
{
	"code":878,
	"msg":"wo9vvz",
	"data":{
		"bases":{
			"id":745,
			"urlMovieDouban":"68yc85",
			"idTypeVideo":"rudd1y",
			"typeVideo":"n0e22g",
			"idMovieImdb":"ocp1s9",
			"urlMovieImdb":"jft6hi",
			"startYear":3578,
			"nameZh":"i3ysi4",
			"nameOrigin":"5dqwy6",
			"runtime":7996,
			"urlPoster":"jvn5mb",
			"haveSeen":616,
			"wannaSee":508,
			"summary":"aqmcuz"
		},
		"doubanRate":{
			"id":593,
			"score":654,
			"vote":238,
			"score5":39,
			"score4":411,
			"score3":989,
			"score2":111,
			"score1":635
		},
		"idMovieImdb":"bd0wle",
		"urlMovieImdb":"0xdjxa",
		"imdbScore":997,
		"imdbVote":564,
		"tomatoScore":548,
		"mtcScore":282,
		"idMovieZhihu":986,
		"urlZhihuTopic":"zyhxa1",
		"zhihuScore":908,
		"zhihuVote":444,
		"maoyanScore":68
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/movie/douban/bases?id=201
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
	"code":852,
	"msg":"hvniph",
	"data":{
		"id":208,
		"urlMovieDouban":"r36qqw",
		"idTypeVideo":"zyufr8",
		"typeVideo":"tfw2hs",
		"idMovieImdb":"m4eilu",
		"urlMovieImdb":"qq2ag5",
		"startYear":14105,
		"nameZh":"9uoeup",
		"nameOrigin":"iytzih",
		"runtime":18604,
		"urlPoster":"dxo1f4",
		"haveSeen":121,
		"wannaSee":12,
		"summary":"dj0a40"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/movie/douban/details?id=426
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
	"code":708,
	"msg":"z7vpk4",
	"data":{
		"base":{
			"id":568,
			"urlMovieDouban":"oa3iyw",
			"idTypeVideo":"hclovf",
			"typeVideo":"478eo9",
			"idMovieImdb":"lbahkt",
			"urlMovieImdb":"2zrv62",
			"startYear":29586,
			"nameZh":"af6vix",
			"nameOrigin":"2vcfim",
			"runtime":14393,
			"urlPoster":"5klsuy",
			"haveSeen":458,
			"wannaSee":913,
			"summary":"i1mhso"
		},
		"rate":{
			"id":679,
			"score":944,
			"vote":275,
			"score5":793,
			"score4":693,
			"score3":808,
			"score2":450,
			"score1":441
		},
		"aliasList":[
			"2fjd9h"
		],
		"typeList":[
			"sfoo2n"
		],
		"tagList":[
			"z3je0k"
		],
		"celebrityList":[
			{
				"id":544,
				"urlCelebrityDouban":"wdg2ep",
				"idCelebrityImdb":"l15ytz",
				"urlCelebrityImdb":"zkrvsz",
				"nameZh":"y5gqqm",
				"nameOrigin":"7pspi1",
				"sex":"knlu2d",
				"birthDate":"2020-05-01",
				"urlPortrait":"6qyelg",
				"summary":"dk5hy1",
				"relationList":[
					{
						"idMovieDouban":386,
						"idCelebrityDouban":402,
						"idProfession":"tjft7e",
						"profession":"prrm33",
						"sort":31317
					}
				]
			}
		],
		"trailerList":[
			{
				"id":254,
				"idMovieDouban":419,
				"urlTrailer":"oa13uk",
				"urlVideo":"pikobd"
			}
		],
		"imageList":[
			{
				"id":636,
				"urlImageSqxs":"6el0kp",
				"urlImageS":"63g912",
				"urlImageM":"ov3evx",
				"urlImageL":"bga1dw",
				"sort":"4pefkz",
				"length":14,
				"width":991
			}
		],
		"classicList":[
			{
				"id":"64",
				"idMovieDouban":540,
				"urlMovieDouban":"1iwxtc",
				"content":"2gzfaa",
				"happenTime":966,
				"agreeVote":798,
				"user":{
					"idUserDouban":"a92o50",
					"idClassicDouban":"i0l1eu",
					"nameZhUserDouban":"4jxsfj",
					"recordDatetime":1588342991255,
					"description":"ewci9d"
				},
				"celebrity":{
					"idCelebrityDouban":71,
					"idClassicDouban":"vk2a74",
					"nameZhCelebrityDouban":"5brg08"
				}
			}
		],
		"reviewList":[
			{
				"id":595,
				"idUserDouban":"pcfkt5",
				"nameUserDouban":"ou1fsf",
				"urlUserDouban":"luf4f2",
				"urlReview":"je5nzm",
				"agreeVote":206,
				"againstVote":417,
				"createDatetime":"2020-05-01 22:23:11",
				"title":"66iydi",
				"content":"nlzok5"
			}
		],
		"awardList":[
			{
				"idMovieDouban":372,
				"idAwardMovie":"hnjkqj",
				"nameZh":"h2zbpu",
				"urlAward":"ss9o28",
				"idCelebrityDouban":314,
				"urlCelebrityDouban":"9d9n3p",
				"typeAward":"fkt9p3",
				"awardTh":3206,
				"isNominated":"w668zv"
			}
		],
		"commentList":[
			{
				"idMovieDouban":167,
				"idUserDouban":"skjwoy",
				"nameUserDouban":"kpl1od",
				"urlUserDouban":"dpjnuj",
				"agreeVote":29693,
				"createDate":"2020-05-01",
				"content":"7l4kqv"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|IMDB电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/movie/imdb/bases?id=393
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
	"code":249,
	"msg":"bmyl22",
	"data":{
		"id":"64",
		"urlMovieImdb":"5h5nnq",
		"idTypeVideo":"zo9wje",
		"typeVideo":"hi5jk1",
		"nameEn":"0r8nw5",
		"startYear":17743,
		"isAdult":"iv7z6j",
		"nameOrigin":"762eu7",
		"runtime":26434,
		"urlPoster":"vuvntd",
		"idMovieDouban":195,
		"summary":"hmyvf2"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|IMDB电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/movie/imdb/details?id=30
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
	"code":260,
	"msg":"wqpob8",
	"data":{
		"base":{
			"id":"64",
			"urlMovieImdb":"orx1c1",
			"idTypeVideo":"mq5n5k",
			"typeVideo":"qvrbku",
			"nameEn":"p2qytp",
			"startYear":7413,
			"isAdult":"den8ji",
			"nameOrigin":"4byy3g",
			"runtime":10168,
			"urlPoster":"5yja5r",
			"idMovieDouban":756,
			"summary":"pu55v4"
		},
		"rate":{
			"idMovieImdb":"0r0d6e",
			"imdbScore":687,
			"imdbVote":536,
			"tomatoScore":586,
			"mtcScore":800
		},
		"typeList":[
			"t61d3h"
		],
		"celebrityList":[
			{
				"idCelebrityImdb":"ikhaoy",
				"urlCelebrityImdb":"9t7alc",
				"idCelebrityDouban":65,
				"urlCelebrityDouban":"e0shu4",
				"nameEn":"lfkv75",
				"birthYear":347,
				"relationList":[
					{
						"idMovieImdb":602,
						"idCelebrityImdb":994,
						"idProfession":"pza3yn",
						"profession":"fvhxr4"
					}
				]
			}
		]
	}
}
```

## 电影资源搜索
### 资源搜索结果
**URL:** https://api.doubans.com/v2/search/resource/details

**Type:** GET

**Author:** humingk

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据电影名关键字匹配电影资源列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/search/resource/details?offset=0&keyword=lr3nyl&limit=10
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
	"code":720,
	"msg":"hdf4ru",
	"data":[
		{
			"id":83,
			"idMovieDouban":96,
			"urlMovieDouban":"ldl6wr",
			"idMovieImdb":305,
			"urlMovieImdb":"gfna9y",
			"idWebsiteResource":9685,
			"websiteResource":"kk25k3",
			"urlWebsiteResource":"tosd9z",
			"idTypeResource":16080,
			"typeResource":"ygxb7s",
			"nameZh":"y6o23n",
			"createYear":4971,
			"nameOrigin":"tw1hzm",
			"urlResource":"3dz2a1"
		}
	]
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/search/place/scene/tips?offset=0&keyword=b79kq8&limit=10
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
	"code":123,
	"msg":"3r60xk",
	"data":[
		{
			"id":883,
			"longitude":888,
			"latitude":140,
			"nameZh":"eua62t",
			"nameEn":"j5oxep",
			"nameOther":"g11ktu",
			"alias":"ebjnqr",
			"addressZh":"fgu82l",
			"addressEn":"0kr2vr",
			"description":"4gcajn",
			"areaZh":"1d4esq",
			"areaEn":"jtpmhm",
			"phone":"14507955134",
			"urlPoster":"l7343t",
			"urlEarth":"t0xq6l",
			"urlSatellite":"oj9n50",
			"urlMap":"xwos7o"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/search/douban/tips?limit=10&offset=0&keyword=ndc802
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
	"code":773,
	"msg":"61d04l",
	"data":{
		"movieList":[
			{
				"base":{
					"id":697,
					"urlMovieDouban":"iik8va",
					"idTypeVideo":"j8dnyv",
					"typeVideo":"i9jm2k",
					"idMovieImdb":"be2cxf",
					"urlMovieImdb":"1a79uu",
					"startYear":7856,
					"nameZh":"bndau5",
					"nameOrigin":"p6garm",
					"runtime":24000,
					"urlPoster":"moa4z2",
					"haveSeen":698,
					"wannaSee":751,
					"summary":"nnn4bs"
				},
				"rate":{
					"id":272,
					"score":267,
					"vote":146,
					"score5":450,
					"score4":502,
					"score3":322,
					"score2":804,
					"score1":833
				},
				"aliasList":[
					"ezyq4f"
				]
			}
		],
		"celebrityList":[
			{
				"base":{
					"id":148,
					"urlCelebrityDouban":"k1f1nt",
					"idCelebrityImdb":"xxdp2n",
					"urlCelebrityImdb":"n2t1lf",
					"nameZh":"wk89a3",
					"nameOrigin":"o91s9d",
					"sex":"8wi5de",
					"birthDate":"2020-05-01",
					"urlPortrait":"1gy5mf",
					"summary":"p4vlj0"
				},
				"aliasList":[
					{
						"nameAlias":"9y589j",
						"isNikename":"yci2q8"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/search/douban/details?keyword=ecrlwv&limit=10&offset=0
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
	"code":362,
	"msg":"qyf2p5",
	"data":{
		"movieList":[
			{
				"base":{
					"id":659,
					"urlMovieDouban":"mgjm97",
					"idTypeVideo":"zaid7g",
					"typeVideo":"w73ec2",
					"idMovieImdb":"a7ds7t",
					"urlMovieImdb":"fhq31s",
					"startYear":24802,
					"nameZh":"wd9zcf",
					"nameOrigin":"34jlu3",
					"runtime":3719,
					"urlPoster":"2zflhp",
					"haveSeen":46,
					"wannaSee":271,
					"summary":"x5fnfu"
				},
				"rate":{
					"id":264,
					"score":568,
					"vote":958,
					"score5":644,
					"score4":481,
					"score3":89,
					"score2":476,
					"score1":46
				},
				"aliasList":[
					"zjeerq"
				],
				"typeList":[
					"kdrw2g"
				],
				"celebrityList":[
					{
						"id":53,
						"urlCelebrityDouban":"a6fsq8",
						"idCelebrityImdb":"gv1t7k",
						"urlCelebrityImdb":"lbr3rx",
						"nameZh":"0cz1i9",
						"nameOrigin":"ft8hmg",
						"sex":"bfp7a2",
						"birthDate":"2020-05-01",
						"urlPortrait":"ypqs9b",
						"summary":"uqo40c",
						"relationList":[
							{
								"idMovieDouban":169,
								"idCelebrityDouban":139,
								"idProfession":"04ktze",
								"profession":"xx0rzr",
								"sort":323
							}
						]
					}
				]
			}
		],
		"celebrityList":[
			{
				"base":{
					"id":261,
					"urlCelebrityDouban":"447u10",
					"idCelebrityImdb":"uqiasv",
					"urlCelebrityImdb":"wdkjcv",
					"nameZh":"vtq9jh",
					"nameOrigin":"scxv2n",
					"sex":"o20hpo",
					"birthDate":"2020-05-01",
					"urlPortrait":"32wsea",
					"summary":"xrj2gj"
				},
				"aliasList":[
					{
						"nameAlias":"hcqqxt",
						"isNikename":"84eu7s"
					}
				],
				"movieList":[
					{
						"id":901,
						"urlMovieDouban":"hv1vq6",
						"idTypeVideo":"hkm8vd",
						"typeVideo":"n0qmqa",
						"idMovieImdb":"yzihv5",
						"urlMovieImdb":"yh4s35",
						"startYear":30307,
						"nameZh":"mcrsdb",
						"nameOrigin":"0nslfa",
						"runtime":14789,
						"urlPoster":"hat2do",
						"haveSeen":532,
						"wannaSee":888,
						"summary":"efgaci",
						"relationList":[
							{
								"idMovieDouban":134,
								"idCelebrityDouban":62,
								"idProfession":"rwi7go",
								"profession":"29zg4b",
								"sort":20623
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/search/movie/douban/tips?keyword=ovqz3a&limit=10&offset=0
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
	"code":203,
	"msg":"whrgkm",
	"data":[
		{
			"base":{
				"id":528,
				"urlMovieDouban":"wxsaih",
				"idTypeVideo":"oj2eu8",
				"typeVideo":"soq7th",
				"idMovieImdb":"zw4ffn",
				"urlMovieImdb":"5qqe84",
				"startYear":20561,
				"nameZh":"jvr2rl",
				"nameOrigin":"nlczye",
				"runtime":29978,
				"urlPoster":"dwd4ef",
				"haveSeen":763,
				"wannaSee":595,
				"summary":"24u34c"
			},
			"rate":{
				"id":692,
				"score":841,
				"vote":926,
				"score5":128,
				"score4":516,
				"score3":199,
				"score2":517,
				"score1":852
			},
			"aliasList":[
				"cienb7"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/search/movie/douban/details?keyword=eqmut5&limit=10&offset=0
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
	"code":513,
	"msg":"kqb1nr",
	"data":[
		{
			"base":{
				"id":535,
				"urlMovieDouban":"7lkpxq",
				"idTypeVideo":"xi07sd",
				"typeVideo":"3wlvhn",
				"idMovieImdb":"r1ljz5",
				"urlMovieImdb":"695mfi",
				"startYear":6815,
				"nameZh":"f4kbd7",
				"nameOrigin":"ii8hdq",
				"runtime":23359,
				"urlPoster":"hlghsd",
				"haveSeen":620,
				"wannaSee":938,
				"summary":"4081nl"
			},
			"rate":{
				"id":642,
				"score":101,
				"vote":89,
				"score5":124,
				"score4":894,
				"score3":249,
				"score2":429,
				"score1":311
			},
			"aliasList":[
				"3lxoj3"
			],
			"typeList":[
				"rri0g4"
			],
			"celebrityList":[
				{
					"id":480,
					"urlCelebrityDouban":"6sj7p1",
					"idCelebrityImdb":"c4hpq9",
					"urlCelebrityImdb":"uqm7zs",
					"nameZh":"57wxbi",
					"nameOrigin":"l4tawk",
					"sex":"udywym",
					"birthDate":"2020-05-01",
					"urlPortrait":"v70qpm",
					"summary":"qtgrn3",
					"relationList":[
						{
							"idMovieDouban":222,
							"idCelebrityDouban":303,
							"idProfession":"lyyuos",
							"profession":"0c8353",
							"sort":22394
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/search/celebrity/douban/tips?offset=0&limit=10&keyword=dtqr7z
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
	"code":760,
	"msg":"ju9k80",
	"data":[
		{
			"base":{
				"id":174,
				"urlCelebrityDouban":"ag9a00",
				"idCelebrityImdb":"6kxzbd",
				"urlCelebrityImdb":"lbpyzi",
				"nameZh":"nfshi8",
				"nameOrigin":"va1twl",
				"sex":"7fwrgd",
				"birthDate":"2020-05-01",
				"urlPortrait":"aieac0",
				"summary":"fla5df"
			},
			"aliasList":[
				{
					"nameAlias":"wojgj0",
					"isNikename":"kn5lns"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/search/celebrity/douban/details?keyword=qfo4np&offset=0&limit=10
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
	"code":451,
	"msg":"0vb9jq",
	"data":[
		{
			"base":{
				"id":988,
				"urlCelebrityDouban":"sim4dx",
				"idCelebrityImdb":"cloov4",
				"urlCelebrityImdb":"j3sk7k",
				"nameZh":"i4g7ml",
				"nameOrigin":"vpzvtv",
				"sex":"3p4xqz",
				"birthDate":"2020-05-01",
				"urlPortrait":"rvx8qi",
				"summary":"nxksg2"
			},
			"aliasList":[
				{
					"nameAlias":"9rv6gl",
					"isNikename":"qtv7dm"
				}
			],
			"movieList":[
				{
					"id":815,
					"urlMovieDouban":"qoni2a",
					"idTypeVideo":"7l1eey",
					"typeVideo":"8hck3m",
					"idMovieImdb":"nen2ni",
					"urlMovieImdb":"ad6odm",
					"startYear":13362,
					"nameZh":"l1g2gh",
					"nameOrigin":"16ssrn",
					"runtime":22662,
					"urlPoster":"gzz53p",
					"haveSeen":915,
					"wannaSee":472,
					"summary":"izus8y",
					"relationList":[
						{
							"idMovieDouban":465,
							"idCelebrityDouban":214,
							"idProfession":"geutoz",
							"profession":"vy9weh",
							"sort":26303
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
keyword|string|搜索关键字|true|-
offset|int32|偏移量（默认0）|false|-
limit|int32|限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/search/movie/scene/tips?keyword=larcac&limit=10&offset=0
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
	"code":798,
	"msg":"hpm4lu",
	"data":[
		{
			"id":897,
			"urlMovieScene":"0d5d75",
			"idMovieDouban":215,
			"urlMovieDouban":"rhi1l1",
			"nameZh":"40pvs3",
			"nameEn":"k0mhyy",
			"startYear":1947,
			"description":"3jhc6n",
			"urlMap":"89esm6"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣影人ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/celebrity/douban/bases?id=845
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
	"code":209,
	"msg":"lbbh48",
	"data":{
		"id":260,
		"urlCelebrityDouban":"p9s1gy",
		"idCelebrityImdb":"z65tge",
		"urlCelebrityImdb":"nonx4v",
		"nameZh":"rqzlwr",
		"nameOrigin":"idbgv8",
		"sex":"3ll5o7",
		"birthDate":"2020-05-01",
		"urlPortrait":"wm331b",
		"summary":"6erqel"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣影人ID|true|-
limit|int32|相关电影限制数(默认10)|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/celebrity/douban/details?limit=10&id=486
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
	"code":318,
	"msg":"74gjv2",
	"data":{
		"base":{
			"id":247,
			"urlCelebrityDouban":"pzw2xj",
			"idCelebrityImdb":"galhau",
			"urlCelebrityImdb":"rilfet",
			"nameZh":"bj61ai",
			"nameOrigin":"dipkk3",
			"sex":"cqhn07",
			"birthDate":"2020-05-01",
			"urlPortrait":"uy22bv",
			"summary":"taikc1"
		},
		"aliasList":[
			{
				"nameAlias":"oeuulo",
				"isNikename":"qilvva"
			}
		],
		"imageList":[
			{
				"id":767,
				"urlImageSqxs":"glfda2",
				"urlImageS":"u4ug3a",
				"urlImageM":"tctil4",
				"urlImageL":"db8y96",
				"sort":"arcf7k",
				"length":854,
				"width":64
			}
		],
		"movieListOrderByScore":[
			{
				"id":208,
				"urlMovieDouban":"oelchq",
				"idTypeVideo":"q0qnd7",
				"typeVideo":"0jwtwm",
				"idMovieImdb":"tgjoa5",
				"urlMovieImdb":"fg5c72",
				"startYear":20566,
				"nameZh":"ovppay",
				"nameOrigin":"co0n4q",
				"runtime":9502,
				"urlPoster":"boozp8",
				"haveSeen":707,
				"wannaSee":355,
				"summary":"eqxb4y",
				"relationList":[
					{
						"idMovieDouban":956,
						"idCelebrityDouban":479,
						"idProfession":"xuy4wr",
						"profession":"hzfgwm",
						"sort":10706
					}
				]
			}
		],
		"movieListOrderByStartYear":[
			{
				"id":355,
				"urlMovieDouban":"8t4r9t",
				"idTypeVideo":"rfav94",
				"typeVideo":"ia6bm4",
				"idMovieImdb":"o69kc9",
				"urlMovieImdb":"hzv5ba",
				"startYear":1542,
				"nameZh":"ef4cl7",
				"nameOrigin":"9avquv",
				"runtime":25359,
				"urlPoster":"xoba8t",
				"haveSeen":537,
				"wannaSee":716,
				"summary":"0uu9lb",
				"relationList":[
					{
						"idMovieDouban":232,
						"idCelebrityDouban":154,
						"idProfession":"g3zojc",
						"profession":"hpvgx1",
						"sort":317
					}
				]
			}
		],
		"awardList":[
			{
				"idMovieDouban":166,
				"idAwardMovie":"lvfm9b",
				"nameZh":"mcj06c",
				"urlAward":"w1ym0t",
				"idCelebrityDouban":286,
				"urlCelebrityDouban":"3vtc4q",
				"typeAward":"g1babo",
				"awardTh":816,
				"isNominated":"lwo05u"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣影人ID|true|-
offset|int32|合作次数偏移量（默认0）|false|-
limit|int32|合作次数限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/celebrity/douban/cooperators_bases?id=661&limit=10&offset=0
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
	"code":728,
	"msg":"tqwn0r",
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣影人ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/celebrity/bases?id=480
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
	"code":675,
	"msg":"era0kn",
	"data":{
		"douban":{
			"id":876,
			"urlCelebrityDouban":"1fyw4n",
			"idCelebrityImdb":"n1um0v",
			"urlCelebrityImdb":"6rfrbm",
			"nameZh":"sdvn52",
			"nameOrigin":"bnvg4s",
			"sex":"8wy4zc",
			"birthDate":"2020-05-01",
			"urlPortrait":"osshf8",
			"summary":"18svay"
		},
		"imdb":{
			"id":"64",
			"nameEn":"lxwmsg",
			"birthYear":4490,
			"idCelebrityDouban":345
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣影人ID|true|-
doubanLimit|int32|豆瓣相关的电影限制数（默认10）|false|-
imdbLimit|int32|IMDB相关的电影限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/celebrity/details?imdbLimit=10&doubanLimit=10&id=123
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
	"code":526,
	"msg":"cu9cus",
	"data":{
		"douban":{
			"base":{
				"id":645,
				"urlCelebrityDouban":"623rji",
				"idCelebrityImdb":"3mvoda",
				"urlCelebrityImdb":"oosrfz",
				"nameZh":"ru9iza",
				"nameOrigin":"v4dc08",
				"sex":"ddcfq9",
				"birthDate":"2020-05-01",
				"urlPortrait":"uxrigo",
				"summary":"308nde"
			},
			"aliasList":[
				{
					"nameAlias":"f8mpw2",
					"isNikename":"b6qs4u"
				}
			],
			"imageList":[
				{
					"id":434,
					"urlImageSqxs":"3g47o4",
					"urlImageS":"xby5s6",
					"urlImageM":"j9hdtd",
					"urlImageL":"s1hq9e",
					"sort":"8c28zg",
					"length":307,
					"width":933
				}
			],
			"movieListOrderByScore":[
				{
					"id":127,
					"urlMovieDouban":"v69zyx",
					"idTypeVideo":"sz17xu",
					"typeVideo":"wbzdox",
					"idMovieImdb":"9jh9ja",
					"urlMovieImdb":"g1unpq",
					"startYear":7222,
					"nameZh":"crpg57",
					"nameOrigin":"sxqbjm",
					"runtime":8166,
					"urlPoster":"3ogzq7",
					"haveSeen":154,
					"wannaSee":248,
					"summary":"vjjv9f",
					"relationList":[
						{
							"idMovieDouban":921,
							"idCelebrityDouban":631,
							"idProfession":"ut1q01",
							"profession":"v9o1ke",
							"sort":19130
						}
					]
				}
			],
			"movieListOrderByStartYear":[
				{
					"id":539,
					"urlMovieDouban":"4j3la0",
					"idTypeVideo":"sx4pe1",
					"typeVideo":"xrh5vp",
					"idMovieImdb":"3l89ep",
					"urlMovieImdb":"j441nv",
					"startYear":26181,
					"nameZh":"gnlrby",
					"nameOrigin":"y088pr",
					"runtime":14058,
					"urlPoster":"62ubai",
					"haveSeen":152,
					"wannaSee":818,
					"summary":"us9p32",
					"relationList":[
						{
							"idMovieDouban":458,
							"idCelebrityDouban":803,
							"idProfession":"3ddkga",
							"profession":"540z3m",
							"sort":22000
						}
					]
				}
			],
			"awardList":[
				{
					"idMovieDouban":559,
					"idAwardMovie":"0luwbj",
					"nameZh":"lpopxj",
					"urlAward":"punavz",
					"idCelebrityDouban":366,
					"urlCelebrityDouban":"ljy53d",
					"typeAward":"pgxt7d",
					"awardTh":20619,
					"isNominated":"x6xujw"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"64",
				"nameEn":"z93jvb",
				"birthYear":11445,
				"idCelebrityDouban":533
			},
			"movieList":[
				{
					"id":"64",
					"idTypeVideo":"fhr8m9",
					"typeVideo":"32kw8e",
					"nameEn":"luaa74",
					"startYear":4223,
					"isAdult":"obqork",
					"nameOrigin":"rjbdql",
					"runtime":14068,
					"urlPoster":"8v40g3",
					"idMovieDouban":611,
					"summary":"id5hf1",
					"relationList":[
						{
							"idMovieImdb":855,
							"idCelebrityImdb":985,
							"idProfession":"vb71jf",
							"profession":"q5i0fz"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|IMDB影人ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/celebrity/imdb/bases?id=680
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
	"code":960,
	"msg":"ucr1f7",
	"data":{
		"id":"64",
		"nameEn":"7jyuxi",
		"birthYear":6345,
		"idCelebrityDouban":483
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|IMDB影人ID|true|-
limit|int32|相关的电影限制数（默认10）|false|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/celebrity/imdb/details?id=277&limit=10
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
	"code":944,
	"msg":"7ae9mc",
	"data":{
		"base":{
			"id":"64",
			"nameEn":"7ud11o",
			"birthYear":21601,
			"idCelebrityDouban":286
		},
		"movieList":[
			{
				"id":"64",
				"idTypeVideo":"m0id9m",
				"typeVideo":"qwx7qc",
				"nameEn":"4hw40d",
				"startYear":14967,
				"isAdult":"lt2mrv",
				"nameOrigin":"87a6nb",
				"runtime":20104,
				"urlPoster":"8lye0n",
				"idMovieDouban":294,
				"summary":"69k7wt",
				"relationList":[
					{
						"idMovieImdb":523,
						"idCelebrityImdb":522,
						"idProfession":"h99wu9",
						"profession":"hulp1c"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/scene/fotoplace/bases?id=193
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
	"code":757,
	"msg":"5c7s22",
	"data":{
		"base":{
			"id":735,
			"urlMovieScene":"bxkld2",
			"idMovieDouban":443,
			"urlMovieDouban":"i4bvlp",
			"nameZh":"wzuong",
			"nameEn":"70sw80",
			"startYear":6450,
			"description":"fmer28",
			"urlMap":"ijjr4s"
		},
		"sceneList":[
			{
				"base":{
					"id":774,
					"idMovieScene":561,
					"idPlaceScene":153,
					"nameZh":"62fu4h",
					"happenTime":8
				},
				"place":{
					"base":{
						"id":315,
						"longitude":640,
						"latitude":883,
						"nameZh":"sveotw",
						"nameEn":"kvwu7j",
						"nameOther":"g6d9xl",
						"alias":"jdl1ag",
						"addressZh":"3y2poh",
						"addressEn":"col4v3",
						"description":"h0w80w",
						"areaZh":"g3izg5",
						"areaEn":"15bzm7",
						"phone":"14507955134",
						"urlPoster":"fau2pr",
						"urlEarth":"u3xjq9",
						"urlSatellite":"f8ueb0",
						"urlMap":"gz8s8k"
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
Authorization|string|access_token|false|2.0.0


**Request-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|豆瓣电影ID|true|-

**Request-example:**
```
curl -X GET -i https://api.doubans.com/v2/scene/fotoplace/details?id=53
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
	"code":998,
	"msg":"bxsesb",
	"data":{
		"base":{
			"id":391,
			"urlMovieScene":"0kuvsa",
			"idMovieDouban":701,
			"urlMovieDouban":"jfmn6p",
			"nameZh":"3t6hsx",
			"nameEn":"kxs5ya",
			"startYear":24396,
			"description":"zxmk51",
			"urlMap":"hc2ym6"
		},
		"sceneList":[
			{
				"base":{
					"id":528,
					"idMovieScene":342,
					"urlMovieScene":"bl27eg",
					"idPlaceScene":140,
					"nameZh":"c49wnu",
					"happenTime":963
				},
				"sceneDetailList":[
					{
						"base":{
							"id":712,
							"idScene":103,
							"idMovieScene":500,
							"happenTime":673,
							"description":"4obnga"
						},
						"imageList":[
							{
								"id":432,
								"idSceneDetail":569,
								"urlImage":"er7lwv"
							}
						],
						"celebrityList":[
							{
								"id":658,
								"idCelebrityDouban":578,
								"urlCelebrityDouban":"2rhtrh",
								"nameZh":"k7ynzm",
								"nameEn":"51xdwr",
								"idSceneDetail":875
							}
						]
					}
				],
				"place":{
					"base":{
						"id":9,
						"longitude":278,
						"latitude":619,
						"nameZh":"38iqma",
						"nameEn":"romn76",
						"nameOther":"vucqm5",
						"alias":"pmxhn1",
						"addressZh":"6l3q1y",
						"addressEn":"lwr06r",
						"description":"z3es0d",
						"areaZh":"1c93oy",
						"areaEn":"y3eh2t",
						"phone":"14507955134",
						"urlPoster":"eduvdz",
						"urlEarth":"638pnb",
						"urlSatellite":"pl6fyi",
						"urlMap":"jnocas"
					},
					"imageList":[
						{
							"id":765,
							"idPlaceScene":639,
							"urlImage":"j7hw8t",
							"description":"hal15g"
						}
					],
					"typeList":[
						"wtdkb4"
					],
					"continent":"hxvlpm",
					"country":"vknc2a",
					"city":"lfyieq",
					"state":"6vxzfm"
				}
			}
		]
	}
}
```


