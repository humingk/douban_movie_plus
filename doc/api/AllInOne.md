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
curl -X GET -i https://api.doubans.com/v2/movie/resource/bases?id=327
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
└─websiteColor|string|电影资源网站主题色rgb|-
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
	"code":750,
	"msg":"aqo537",
	"data":[
		{
			"id":304,
			"idMovieDouban":320,
			"urlMovieDouban":"t0dpuo",
			"idMovieImdb":533,
			"urlMovieImdb":"drm3wu",
			"idWebsiteResource":23046,
			"websiteResource":"n5n99p",
			"websiteColor":"z34g8t",
			"urlWebsiteResource":"e94q36",
			"idTypeResource":3825,
			"typeResource":"l1heq3",
			"nameZh":"leexhy",
			"createYear":5154,
			"nameOrigin":"u8t39l",
			"urlResource":"uuixup"
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
curl -X GET -i https://api.doubans.com/v2/movie/zhihu/bases?id=939
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zhihuScore|number|知乎推荐度|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zhihuColor|string|知乎推荐度主题色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zhihuVote|int32|知乎评分票数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maoyanScore|number|猫眼评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maoyanColor|string|猫眼评分主题色|-
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
	"code":310,
	"msg":"78wttn",
	"data":{
		"topic":{
			"id":144,
			"urlZhihuTopic":"ug7dg8",
			"idMovieDouban":373,
			"urlMovieDouban":"1bh876",
			"nameZh":"3mcjwb",
			"zhihuScore":786,
			"zhihuColor":"z15c94",
			"zhihuVote":51,
			"maoyanScore":901,
			"maoyanColor":"0dahuk"
		},
		"questionList":[
			{
				"id":731,
				"urlZhihuQuestion":"c02jop",
				"idMovieDouban":38,
				"urlMovieDouban":"kc44ff",
				"nameZh":"ao66w2",
				"answerNum":784
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
curl -X GET -i https://api.doubans.com/v2/movie/bases?id=209
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
	"code":991,
	"msg":"a0u02f",
	"data":{
		"douban":{
			"id":814,
			"urlMovieDouban":"6j6pze",
			"idTypeVideo":"d0cmcf",
			"typeVideo":"8mwlv0",
			"idMovieImdb":"zrdjny",
			"urlMovieImdb":"k6zqil",
			"startYear":20772,
			"nameZh":"ldd0wc",
			"nameOrigin":"eabvki",
			"runtime":17027,
			"urlPoster":"0gd6yw",
			"haveSeen":368,
			"wannaSee":326,
			"summary":"3uwptr"
		},
		"imdb":{
			"id":"58",
			"urlMovieImdb":"8v1zto",
			"idTypeVideo":"kd9pj0",
			"typeVideo":"dp3ekm",
			"nameEn":"ned2ap",
			"startYear":14699,
			"isAdult":"21tyh5",
			"nameOrigin":"28dx6q",
			"runtime":13194,
			"urlPoster":"rcmn5q",
			"idMovieDouban":848,
			"summary":"40v311"
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
curl -X GET -i https://api.doubans.com/v2/movie/details?id=522
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rateColor|string|评分主题色|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imdbColor|string|IMDB评分主题色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imdbVote|int32|IMDB评分人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tomatoScore|number|烂番茄新鲜度|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tomatoColor|string|烂番茄新鲜度主题色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mtcScore|number|MTC评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mtcColor|string|MTC评分主题色|-
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
	"code":978,
	"msg":"u03tei",
	"data":{
		"douban":{
			"base":{
				"id":348,
				"urlMovieDouban":"41vyvj",
				"idTypeVideo":"m4ww1t",
				"typeVideo":"vw0m2a",
				"idMovieImdb":"t77g6a",
				"urlMovieImdb":"exkxy7",
				"startYear":17604,
				"nameZh":"wv6tkl",
				"nameOrigin":"30jk23",
				"runtime":25847,
				"urlPoster":"8aei9q",
				"haveSeen":533,
				"wannaSee":977,
				"summary":"wd2own"
			},
			"rate":{
				"id":671,
				"score":289,
				"vote":182,
				"rateColor":"4n2mjc",
				"score5":269,
				"score4":132,
				"score3":513,
				"score2":229,
				"score1":835
			},
			"aliasList":[
				"9ipj5t"
			],
			"typeList":[
				"q518az"
			],
			"tagList":[
				"yhyaml"
			],
			"celebrityList":[
				{
					"id":690,
					"urlCelebrityDouban":"m88x6t",
					"idCelebrityImdb":"0jki4k",
					"urlCelebrityImdb":"88mq4h",
					"nameZh":"z4qgpt",
					"nameOrigin":"2pcgcz",
					"sex":"adaz44",
					"birthDate":"2020-05-02",
					"urlPortrait":"vdlka9",
					"summary":"haqw4f",
					"relationList":[
						{
							"idMovieDouban":278,
							"idCelebrityDouban":996,
							"idProfession":"3w3yc6",
							"profession":"htlqaz",
							"sort":28778
						}
					]
				}
			],
			"trailerList":[
				{
					"id":225,
					"idMovieDouban":824,
					"urlTrailer":"j0a89i",
					"urlVideo":"gq7kc1"
				}
			],
			"imageList":[
				{
					"id":620,
					"urlImageSqxs":"r0xfwa",
					"urlImageS":"72denl",
					"urlImageM":"178b9r",
					"urlImageL":"ztb9nm",
					"sort":"8n3brk",
					"length":613,
					"width":251
				}
			],
			"classicList":[
				{
					"id":"58",
					"idMovieDouban":274,
					"urlMovieDouban":"kenfqy",
					"content":"w100zc",
					"happenTime":441,
					"agreeVote":724,
					"user":{
						"idUserDouban":"m8pghf",
						"idClassicDouban":"8nni8a",
						"nameZhUserDouban":"rr2n56",
						"recordDatetime":1588394965694,
						"description":"olbzdn"
					},
					"celebrity":{
						"idCelebrityDouban":987,
						"idClassicDouban":"am2haa",
						"nameZhCelebrityDouban":"do6cai"
					}
				}
			],
			"reviewList":[
				{
					"id":524,
					"idUserDouban":"rkx9sz",
					"nameUserDouban":"lf8gap",
					"urlUserDouban":"om8a6w",
					"urlReview":"4m06lr",
					"agreeVote":219,
					"againstVote":89,
					"createDatetime":"2020-05-02 12:49:25",
					"title":"ajh4md",
					"content":"3m2zu9"
				}
			],
			"awardList":[
				{
					"idMovieDouban":745,
					"idAwardMovie":"trw65v",
					"nameZh":"i4uhku",
					"urlAward":"58nxeu",
					"idCelebrityDouban":27,
					"urlCelebrityDouban":"f84z0f",
					"typeAward":"al9i34",
					"awardTh":27836,
					"isNominated":"b8imb6"
				}
			],
			"commentList":[
				{
					"idMovieDouban":259,
					"idUserDouban":"ss2ji5",
					"nameUserDouban":"4b2sbb",
					"urlUserDouban":"wbkq7q",
					"agreeVote":26129,
					"createDate":"2020-05-02",
					"content":"cryzya"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"58",
				"urlMovieImdb":"iem8ix",
				"idTypeVideo":"e0ch14",
				"typeVideo":"sgyg57",
				"nameEn":"6sz6ml",
				"startYear":6362,
				"isAdult":"25ux14",
				"nameOrigin":"km94bq",
				"runtime":32625,
				"urlPoster":"206qax",
				"idMovieDouban":487,
				"summary":"5dbh2g"
			},
			"rate":{
				"idMovieImdb":"852282",
				"imdbScore":495,
				"imdbColor":"nutj8x",
				"imdbVote":713,
				"tomatoScore":99,
				"tomatoColor":"48kh8s",
				"mtcScore":843,
				"mtcColor":"iiwxnf"
			},
			"typeList":[
				"r7w6zr"
			],
			"celebrityList":[
				{
					"idCelebrityImdb":"bnt4ye",
					"urlCelebrityImdb":"ah2qpc",
					"idCelebrityDouban":312,
					"urlCelebrityDouban":"hi6u83",
					"nameEn":"3jlau2",
					"birthYear":27406,
					"relationList":[
						{
							"idMovieImdb":694,
							"idCelebrityImdb":811,
							"idProfession":"1tlbq1",
							"profession":"0aiayd"
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
curl -X GET -i https://api.doubans.com/v2/movie/rate/details?id=611
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rateColor|string|评分主题色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score5|number|豆瓣5星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score4|number|豆瓣4星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score3|number|豆瓣3星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score2|number|豆瓣2星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score1|number|豆瓣1星比例|-
└─idMovieImdb|string|IMDB电影ID|-
└─urlMovieImdb|string|IMDB电影链接|-
└─imdbScore|number|IMDB评分|-
└─imdbVote|int32|IMDB评分人数|-
└─imdbColor|string|IMDB评分主题色|-
└─tomatoScore|number|烂番茄新鲜度|-
└─tomatoColor|string|烂番茄新鲜度主题色|-
└─mtcScore|number|MTC评分|-
└─mtcColor|string|MTC评分主题色|-
└─idMovieZhihu|int64|知乎电影ID|-
└─urlZhihuTopic|string|知乎话题链接|-
└─zhihuScore|number|知乎评分|-
└─zhihuVote|int32|知乎评分票数|-
└─zhihuColor|string|知乎推荐度主题色|-
└─maoyanScore|number|猫眼评分|-
└─maoyanColor|string|猫眼评分主题色|-

**Response-example:**
```
{
	"code":119,
	"msg":"4acl6i",
	"data":{
		"bases":{
			"id":470,
			"urlMovieDouban":"8nyj3u",
			"idTypeVideo":"upjy1q",
			"typeVideo":"zb4my5",
			"idMovieImdb":"vegz2y",
			"urlMovieImdb":"ud1o7j",
			"startYear":17113,
			"nameZh":"0x6210",
			"nameOrigin":"49h0o4",
			"runtime":6956,
			"urlPoster":"qcn9d0",
			"haveSeen":294,
			"wannaSee":361,
			"summary":"i0jmcq"
		},
		"doubanRate":{
			"id":451,
			"score":471,
			"vote":193,
			"rateColor":"1u9e6l",
			"score5":303,
			"score4":562,
			"score3":647,
			"score2":879,
			"score1":168
		},
		"idMovieImdb":"849goc",
		"urlMovieImdb":"qgst9k",
		"imdbScore":779,
		"imdbVote":311,
		"imdbColor":"080xdr",
		"tomatoScore":943,
		"tomatoColor":"xu9xpt",
		"mtcScore":870,
		"mtcColor":"foozgk",
		"idMovieZhihu":692,
		"urlZhihuTopic":"mr0ge0",
		"zhihuScore":790,
		"zhihuVote":360,
		"zhihuColor":"0t7epl",
		"maoyanScore":386,
		"maoyanColor":"nilyjd"
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
curl -X GET -i https://api.doubans.com/v2/movie/douban/bases?id=372
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
	"code":226,
	"msg":"7cmux9",
	"data":{
		"id":390,
		"urlMovieDouban":"axjt4p",
		"idTypeVideo":"545yhm",
		"typeVideo":"ibxo9p",
		"idMovieImdb":"yb0il2",
		"urlMovieImdb":"03rrep",
		"startYear":1576,
		"nameZh":"7ovscu",
		"nameOrigin":"umwvzr",
		"runtime":2505,
		"urlPoster":"c6zdps",
		"haveSeen":941,
		"wannaSee":726,
		"summary":"w64w35"
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
curl -X GET -i https://api.doubans.com/v2/movie/douban/details?id=29
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rateColor|string|评分主题色|-
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
	"code":1,
	"msg":"4y7mzw",
	"data":{
		"base":{
			"id":669,
			"urlMovieDouban":"vdms6s",
			"idTypeVideo":"bwks48",
			"typeVideo":"a8fuuu",
			"idMovieImdb":"jexi1i",
			"urlMovieImdb":"ytyecf",
			"startYear":23795,
			"nameZh":"uxm91v",
			"nameOrigin":"uvd8ne",
			"runtime":17732,
			"urlPoster":"i2ktuw",
			"haveSeen":891,
			"wannaSee":251,
			"summary":"xg6jtw"
		},
		"rate":{
			"id":655,
			"score":373,
			"vote":511,
			"rateColor":"si3w7n",
			"score5":560,
			"score4":251,
			"score3":153,
			"score2":192,
			"score1":357
		},
		"aliasList":[
			"1j523v"
		],
		"typeList":[
			"pmgxdn"
		],
		"tagList":[
			"njxfuy"
		],
		"celebrityList":[
			{
				"id":135,
				"urlCelebrityDouban":"kzaj07",
				"idCelebrityImdb":"r5agli",
				"urlCelebrityImdb":"dkftfh",
				"nameZh":"bno4mq",
				"nameOrigin":"x3uese",
				"sex":"qkqo1r",
				"birthDate":"2020-05-02",
				"urlPortrait":"8xnazj",
				"summary":"tdfvc0",
				"relationList":[
					{
						"idMovieDouban":109,
						"idCelebrityDouban":983,
						"idProfession":"eifbhs",
						"profession":"iesw4u",
						"sort":24123
					}
				]
			}
		],
		"trailerList":[
			{
				"id":23,
				"idMovieDouban":542,
				"urlTrailer":"089kgy",
				"urlVideo":"6mffwl"
			}
		],
		"imageList":[
			{
				"id":205,
				"urlImageSqxs":"x4pzfh",
				"urlImageS":"kjarn8",
				"urlImageM":"7l585x",
				"urlImageL":"rgdbaf",
				"sort":"d22w3v",
				"length":117,
				"width":927
			}
		],
		"classicList":[
			{
				"id":"58",
				"idMovieDouban":457,
				"urlMovieDouban":"8aukap",
				"content":"1b4wsd",
				"happenTime":361,
				"agreeVote":783,
				"user":{
					"idUserDouban":"eduf7i",
					"idClassicDouban":"f3mf9k",
					"nameZhUserDouban":"159qnh",
					"recordDatetime":1588394965694,
					"description":"k2jzf4"
				},
				"celebrity":{
					"idCelebrityDouban":976,
					"idClassicDouban":"vmdqsb",
					"nameZhCelebrityDouban":"vm2mg6"
				}
			}
		],
		"reviewList":[
			{
				"id":847,
				"idUserDouban":"6ktxzs",
				"nameUserDouban":"uo8gjv",
				"urlUserDouban":"1c92p3",
				"urlReview":"c3xpcu",
				"agreeVote":118,
				"againstVote":113,
				"createDatetime":"2020-05-02 12:49:25",
				"title":"66sd48",
				"content":"csglsd"
			}
		],
		"awardList":[
			{
				"idMovieDouban":878,
				"idAwardMovie":"y6r3ma",
				"nameZh":"l5zfoo",
				"urlAward":"x6gfow",
				"idCelebrityDouban":116,
				"urlCelebrityDouban":"kxdzug",
				"typeAward":"0jni5g",
				"awardTh":2012,
				"isNominated":"yk6tpf"
			}
		],
		"commentList":[
			{
				"idMovieDouban":582,
				"idUserDouban":"arzebl",
				"nameUserDouban":"so6uly",
				"urlUserDouban":"mespsd",
				"agreeVote":2475,
				"createDate":"2020-05-02",
				"content":"1i1p9h"
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
curl -X GET -i https://api.doubans.com/v2/movie/imdb/bases?id=741
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
	"code":667,
	"msg":"lk1gjd",
	"data":{
		"id":"58",
		"urlMovieImdb":"6bqja3",
		"idTypeVideo":"v6w4l3",
		"typeVideo":"1to1j2",
		"nameEn":"2xss7x",
		"startYear":24030,
		"isAdult":"3ofxiw",
		"nameOrigin":"t0wiu4",
		"runtime":8581,
		"urlPoster":"xq65q6",
		"idMovieDouban":789,
		"summary":"ssparz"
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
curl -X GET -i https://api.doubans.com/v2/movie/imdb/details?id=958
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imdbColor|string|IMDB评分主题色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imdbVote|int32|IMDB评分人数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tomatoScore|number|烂番茄新鲜度|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tomatoColor|string|烂番茄新鲜度主题色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mtcScore|number|MTC评分|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mtcColor|string|MTC评分主题色|-
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
	"code":129,
	"msg":"vrdw0o",
	"data":{
		"base":{
			"id":"58",
			"urlMovieImdb":"khkjvl",
			"idTypeVideo":"682flk",
			"typeVideo":"4fopdj",
			"nameEn":"qcqqqn",
			"startYear":19069,
			"isAdult":"x59qnd",
			"nameOrigin":"jmyihu",
			"runtime":28440,
			"urlPoster":"tihggi",
			"idMovieDouban":10,
			"summary":"1sunai"
		},
		"rate":{
			"idMovieImdb":"51zht6",
			"imdbScore":976,
			"imdbColor":"mov8av",
			"imdbVote":874,
			"tomatoScore":337,
			"tomatoColor":"tqr74i",
			"mtcScore":756,
			"mtcColor":"joj3bi"
		},
		"typeList":[
			"1ji8vw"
		],
		"celebrityList":[
			{
				"idCelebrityImdb":"1urpye",
				"urlCelebrityImdb":"pob2fs",
				"idCelebrityDouban":595,
				"urlCelebrityDouban":"cii183",
				"nameEn":"8jh10g",
				"birthYear":18385,
				"relationList":[
					{
						"idMovieImdb":520,
						"idCelebrityImdb":153,
						"idProfession":"qctbjm",
						"profession":"ggjukb"
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
curl -X GET -i https://api.doubans.com/v2/search/resource/details?offset=0&keyword=gfnd33&limit=10
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
└─websiteColor|string|电影资源网站主题色rgb|-
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
	"code":458,
	"msg":"9uphd8",
	"data":[
		{
			"id":246,
			"idMovieDouban":972,
			"urlMovieDouban":"wdsyyg",
			"idMovieImdb":465,
			"urlMovieImdb":"o9vx9b",
			"idWebsiteResource":26892,
			"websiteResource":"hktfrn",
			"websiteColor":"nemhnp",
			"urlWebsiteResource":"rt4n0a",
			"idTypeResource":19713,
			"typeResource":"z4ww4g",
			"nameZh":"ojzfgv",
			"createYear":30848,
			"nameOrigin":"jyhzfr",
			"urlResource":"6oiki7"
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
curl -X GET -i https://api.doubans.com/v2/search/place/scene/tips?limit=10&offset=0&keyword=d1cjqr
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
	"code":554,
	"msg":"whsl2v",
	"data":[
		{
			"id":306,
			"longitude":210,
			"latitude":906,
			"nameZh":"zzm7le",
			"nameEn":"gavwpc",
			"nameOther":"q2rlc7",
			"alias":"bocizp",
			"addressZh":"0elfdp",
			"addressEn":"leek5t",
			"description":"5b9vi0",
			"areaZh":"6ve7pl",
			"areaEn":"hignwy",
			"phone":"15136623396",
			"urlPoster":"puxy7v",
			"urlEarth":"hnlycp",
			"urlSatellite":"ouemap",
			"urlMap":"l1sf2f"
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
curl -X GET -i https://api.doubans.com/v2/search/douban/tips?limit=10&offset=0&keyword=wwdt7g
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rateColor|string|评分主题色|-
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
	"code":756,
	"msg":"h2n04h",
	"data":{
		"movieList":[
			{
				"base":{
					"id":118,
					"urlMovieDouban":"3txypd",
					"idTypeVideo":"w2dzf5",
					"typeVideo":"8unwvt",
					"idMovieImdb":"9e3385",
					"urlMovieImdb":"44to8p",
					"startYear":10030,
					"nameZh":"hfsh6c",
					"nameOrigin":"g7y4x5",
					"runtime":24830,
					"urlPoster":"vrrdsx",
					"haveSeen":594,
					"wannaSee":124,
					"summary":"h93kgz"
				},
				"rate":{
					"id":45,
					"score":738,
					"vote":316,
					"rateColor":"b2zywg",
					"score5":702,
					"score4":249,
					"score3":305,
					"score2":717,
					"score1":592
				},
				"aliasList":[
					"pxb4mc"
				]
			}
		],
		"celebrityList":[
			{
				"base":{
					"id":806,
					"urlCelebrityDouban":"aqp4mx",
					"idCelebrityImdb":"s0dtpf",
					"urlCelebrityImdb":"te0i8f",
					"nameZh":"4q784y",
					"nameOrigin":"kz6iqg",
					"sex":"uqgrja",
					"birthDate":"2020-05-02",
					"urlPortrait":"155ajz",
					"summary":"bex0fo"
				},
				"aliasList":[
					{
						"nameAlias":"cz14v0",
						"isNikename":"dd3ndy"
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
curl -X GET -i https://api.doubans.com/v2/search/douban/details?keyword=eivu2l&offset=0&limit=10
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rateColor|string|评分主题色|-
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
	"code":298,
	"msg":"de17ny",
	"data":{
		"movieList":[
			{
				"base":{
					"id":821,
					"urlMovieDouban":"0r600l",
					"idTypeVideo":"tw6aj2",
					"typeVideo":"5t87qi",
					"idMovieImdb":"c89ql3",
					"urlMovieImdb":"n27f17",
					"startYear":21368,
					"nameZh":"kmned0",
					"nameOrigin":"9mkpfc",
					"runtime":30469,
					"urlPoster":"8hhixe",
					"haveSeen":733,
					"wannaSee":268,
					"summary":"f73658"
				},
				"rate":{
					"id":428,
					"score":3,
					"vote":907,
					"rateColor":"khmex2",
					"score5":630,
					"score4":943,
					"score3":370,
					"score2":82,
					"score1":660
				},
				"aliasList":[
					"3fvsmo"
				],
				"typeList":[
					"1sdsh4"
				],
				"celebrityList":[
					{
						"id":363,
						"urlCelebrityDouban":"dnh6ox",
						"idCelebrityImdb":"4bnt1r",
						"urlCelebrityImdb":"iq5pqt",
						"nameZh":"u7rajf",
						"nameOrigin":"cxizxl",
						"sex":"9bkm4x",
						"birthDate":"2020-05-02",
						"urlPortrait":"ay814u",
						"summary":"yj5jwa",
						"relationList":[
							{
								"idMovieDouban":578,
								"idCelebrityDouban":551,
								"idProfession":"xzfexn",
								"profession":"fcz2vu",
								"sort":22343
							}
						]
					}
				]
			}
		],
		"celebrityList":[
			{
				"base":{
					"id":267,
					"urlCelebrityDouban":"xbrfx6",
					"idCelebrityImdb":"x8zcwn",
					"urlCelebrityImdb":"zmk6wb",
					"nameZh":"u8a3tn",
					"nameOrigin":"3n7v2m",
					"sex":"jcinj8",
					"birthDate":"2020-05-02",
					"urlPortrait":"156h88",
					"summary":"k6s2ec"
				},
				"aliasList":[
					{
						"nameAlias":"nb1dpd",
						"isNikename":"geb1qa"
					}
				],
				"movieList":[
					{
						"id":131,
						"urlMovieDouban":"vj7sw7",
						"idTypeVideo":"zbnkvf",
						"typeVideo":"pc1jm2",
						"idMovieImdb":"5qmjkj",
						"urlMovieImdb":"wjcayx",
						"startYear":9633,
						"nameZh":"l2cpcl",
						"nameOrigin":"rln0ni",
						"runtime":15404,
						"urlPoster":"ru08ig",
						"haveSeen":877,
						"wannaSee":661,
						"summary":"j7yhgz",
						"relationList":[
							{
								"idMovieDouban":735,
								"idCelebrityDouban":732,
								"idProfession":"jfptvo",
								"profession":"ws7768",
								"sort":6395
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
curl -X GET -i https://api.doubans.com/v2/search/movie/douban/tips?offset=0&keyword=vmk3l3&limit=10
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rateColor|string|评分主题色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score5|number|豆瓣5星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score4|number|豆瓣4星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score3|number|豆瓣3星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score2|number|豆瓣2星比例|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─score1|number|豆瓣1星比例|-
└─aliasList|array|豆瓣电影别名列表|-

**Response-example:**
```
{
	"code":510,
	"msg":"544vyl",
	"data":[
		{
			"base":{
				"id":136,
				"urlMovieDouban":"ehbpur",
				"idTypeVideo":"0kiywn",
				"typeVideo":"px8tye",
				"idMovieImdb":"0nhp2l",
				"urlMovieImdb":"j1tufg",
				"startYear":18732,
				"nameZh":"ib6eg6",
				"nameOrigin":"bpu3jc",
				"runtime":9947,
				"urlPoster":"sopjqg",
				"haveSeen":159,
				"wannaSee":724,
				"summary":"gwvyw8"
			},
			"rate":{
				"id":442,
				"score":445,
				"vote":383,
				"rateColor":"kwz0d3",
				"score5":229,
				"score4":912,
				"score3":900,
				"score2":647,
				"score1":183
			},
			"aliasList":[
				"5urmn3"
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
curl -X GET -i https://api.doubans.com/v2/search/movie/douban/details?limit=10&offset=0&keyword=escgbp
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rateColor|string|评分主题色|-
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
	"code":44,
	"msg":"c2ooz5",
	"data":[
		{
			"base":{
				"id":932,
				"urlMovieDouban":"n794o4",
				"idTypeVideo":"fkpk86",
				"typeVideo":"kzj282",
				"idMovieImdb":"07rfuu",
				"urlMovieImdb":"lubxmz",
				"startYear":5059,
				"nameZh":"bzsoaf",
				"nameOrigin":"c6hpea",
				"runtime":17895,
				"urlPoster":"nt6a5u",
				"haveSeen":276,
				"wannaSee":955,
				"summary":"smq8j9"
			},
			"rate":{
				"id":578,
				"score":852,
				"vote":809,
				"rateColor":"29rvzq",
				"score5":275,
				"score4":508,
				"score3":748,
				"score2":221,
				"score1":899
			},
			"aliasList":[
				"pr0cua"
			],
			"typeList":[
				"hhsu4h"
			],
			"celebrityList":[
				{
					"id":940,
					"urlCelebrityDouban":"zef29b",
					"idCelebrityImdb":"eedno5",
					"urlCelebrityImdb":"l9p0ok",
					"nameZh":"8xw5m6",
					"nameOrigin":"pnhs72",
					"sex":"16jbzw",
					"birthDate":"2020-05-02",
					"urlPortrait":"7fqs87",
					"summary":"87ir9i",
					"relationList":[
						{
							"idMovieDouban":817,
							"idCelebrityDouban":657,
							"idProfession":"ftsl9f",
							"profession":"5e2cgt",
							"sort":23616
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
curl -X GET -i https://api.doubans.com/v2/search/celebrity/douban/tips?offset=0&keyword=72ixfq&limit=10
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
	"code":179,
	"msg":"a8v5a4",
	"data":[
		{
			"base":{
				"id":466,
				"urlCelebrityDouban":"0pcjhk",
				"idCelebrityImdb":"9v52wz",
				"urlCelebrityImdb":"8y6l0j",
				"nameZh":"q08z5r",
				"nameOrigin":"3tz5w2",
				"sex":"v62j13",
				"birthDate":"2020-05-02",
				"urlPortrait":"xtd2gt",
				"summary":"h3qzh7"
			},
			"aliasList":[
				{
					"nameAlias":"fe2scb",
					"isNikename":"01jo4g"
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
curl -X GET -i https://api.doubans.com/v2/search/celebrity/douban/details?offset=0&keyword=u0ihfd&limit=10
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
	"code":20,
	"msg":"tddel6",
	"data":[
		{
			"base":{
				"id":707,
				"urlCelebrityDouban":"oh83ge",
				"idCelebrityImdb":"34c8kc",
				"urlCelebrityImdb":"iks386",
				"nameZh":"9ggz3j",
				"nameOrigin":"uszv6y",
				"sex":"fje5h8",
				"birthDate":"2020-05-02",
				"urlPortrait":"pg7l8z",
				"summary":"lmht7h"
			},
			"aliasList":[
				{
					"nameAlias":"nhyix3",
					"isNikename":"gb6jo6"
				}
			],
			"movieList":[
				{
					"id":824,
					"urlMovieDouban":"r83x3r",
					"idTypeVideo":"xj374t",
					"typeVideo":"krpbbb",
					"idMovieImdb":"nvrhvc",
					"urlMovieImdb":"a8nhko",
					"startYear":3676,
					"nameZh":"acws9b",
					"nameOrigin":"0y6jfm",
					"runtime":26987,
					"urlPoster":"d2xnjs",
					"haveSeen":995,
					"wannaSee":621,
					"summary":"ahqz72",
					"relationList":[
						{
							"idMovieDouban":285,
							"idCelebrityDouban":850,
							"idProfession":"tqvakz",
							"profession":"7tdpkm",
							"sort":10528
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
curl -X GET -i https://api.doubans.com/v2/search/movie/scene/tips?limit=10&keyword=kqvcuj&offset=0
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
	"code":459,
	"msg":"4qy54o",
	"data":[
		{
			"id":409,
			"urlMovieScene":"9re9mr",
			"idMovieDouban":574,
			"urlMovieDouban":"r37m46",
			"nameZh":"cidufd",
			"nameEn":"51audw",
			"startYear":21173,
			"description":"2zyyka",
			"urlMap":"2lxbkf"
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
curl -X GET -i https://api.doubans.com/v2/celebrity/douban/bases?id=106
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
	"code":459,
	"msg":"fmji42",
	"data":{
		"id":428,
		"urlCelebrityDouban":"b0v2rw",
		"idCelebrityImdb":"znhub3",
		"urlCelebrityImdb":"jh8mju",
		"nameZh":"9ah57v",
		"nameOrigin":"nbotit",
		"sex":"l6crlc",
		"birthDate":"2020-05-02",
		"urlPortrait":"c8j9q6",
		"summary":"s5s6e5"
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
curl -X GET -i https://api.doubans.com/v2/celebrity/douban/details?limit=10&id=792
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
	"code":579,
	"msg":"4l5ash",
	"data":{
		"base":{
			"id":194,
			"urlCelebrityDouban":"f1hjgf",
			"idCelebrityImdb":"qm3217",
			"urlCelebrityImdb":"2urkcz",
			"nameZh":"poqbf8",
			"nameOrigin":"bxal2y",
			"sex":"d5k6hj",
			"birthDate":"2020-05-02",
			"urlPortrait":"bem9ck",
			"summary":"wh6kv8"
		},
		"aliasList":[
			{
				"nameAlias":"c7pn9p",
				"isNikename":"ufkx21"
			}
		],
		"imageList":[
			{
				"id":160,
				"urlImageSqxs":"kp0cnz",
				"urlImageS":"s63qze",
				"urlImageM":"uyl71v",
				"urlImageL":"s2sryu",
				"sort":"zj1c3c",
				"length":880,
				"width":172
			}
		],
		"movieListOrderByScore":[
			{
				"id":434,
				"urlMovieDouban":"n65qym",
				"idTypeVideo":"6ih19p",
				"typeVideo":"xs2h0y",
				"idMovieImdb":"efvtq8",
				"urlMovieImdb":"293fkc",
				"startYear":4376,
				"nameZh":"tbgt9j",
				"nameOrigin":"azjk8i",
				"runtime":10884,
				"urlPoster":"s6qva4",
				"haveSeen":274,
				"wannaSee":589,
				"summary":"j8oaa3",
				"relationList":[
					{
						"idMovieDouban":363,
						"idCelebrityDouban":456,
						"idProfession":"z3j6j5",
						"profession":"eowwsi",
						"sort":22323
					}
				]
			}
		],
		"movieListOrderByStartYear":[
			{
				"id":540,
				"urlMovieDouban":"bcja85",
				"idTypeVideo":"os0hpu",
				"typeVideo":"p75cen",
				"idMovieImdb":"sytxa1",
				"urlMovieImdb":"qus8ln",
				"startYear":22674,
				"nameZh":"x57ytv",
				"nameOrigin":"h4peo8",
				"runtime":4541,
				"urlPoster":"wgxe7b",
				"haveSeen":509,
				"wannaSee":956,
				"summary":"vonw3r",
				"relationList":[
					{
						"idMovieDouban":293,
						"idCelebrityDouban":659,
						"idProfession":"3yhws8",
						"profession":"mj40sr",
						"sort":15884
					}
				]
			}
		],
		"awardList":[
			{
				"idMovieDouban":895,
				"idAwardMovie":"pxulv7",
				"nameZh":"ep4vs8",
				"urlAward":"ji7s2w",
				"idCelebrityDouban":268,
				"urlCelebrityDouban":"yjscxm",
				"typeAward":"3b6o78",
				"awardTh":30302,
				"isNominated":"ryr6ix"
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
curl -X GET -i https://api.doubans.com/v2/celebrity/douban/cooperators_bases?limit=10&offset=0&id=898
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
	"code":219,
	"msg":"k0991k",
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
curl -X GET -i https://api.doubans.com/v2/celebrity/bases?id=442
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
	"code":234,
	"msg":"0op51b",
	"data":{
		"douban":{
			"id":148,
			"urlCelebrityDouban":"mmmr86",
			"idCelebrityImdb":"jouybu",
			"urlCelebrityImdb":"ns6dwy",
			"nameZh":"i93no5",
			"nameOrigin":"wdqdpf",
			"sex":"icnrok",
			"birthDate":"2020-05-02",
			"urlPortrait":"chxive",
			"summary":"cngz1i"
		},
		"imdb":{
			"id":"58",
			"nameEn":"tasdmf",
			"birthYear":15681,
			"idCelebrityDouban":623
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
curl -X GET -i https://api.doubans.com/v2/celebrity/details?id=777&doubanLimit=10&imdbLimit=10
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
	"code":875,
	"msg":"qtrla7",
	"data":{
		"douban":{
			"base":{
				"id":471,
				"urlCelebrityDouban":"kwvusk",
				"idCelebrityImdb":"yhskj9",
				"urlCelebrityImdb":"gz5l5n",
				"nameZh":"wian69",
				"nameOrigin":"5f2ga2",
				"sex":"4gpbkw",
				"birthDate":"2020-05-02",
				"urlPortrait":"w09lbw",
				"summary":"iibqz3"
			},
			"aliasList":[
				{
					"nameAlias":"qvrbsl",
					"isNikename":"jr43r6"
				}
			],
			"imageList":[
				{
					"id":809,
					"urlImageSqxs":"ahm3xm",
					"urlImageS":"xdx9iv",
					"urlImageM":"3vm3gp",
					"urlImageL":"chk1lp",
					"sort":"288ef1",
					"length":32,
					"width":382
				}
			],
			"movieListOrderByScore":[
				{
					"id":348,
					"urlMovieDouban":"v50h1x",
					"idTypeVideo":"yn30cm",
					"typeVideo":"ejmb5q",
					"idMovieImdb":"qlnzw2",
					"urlMovieImdb":"sp8670",
					"startYear":13929,
					"nameZh":"an5iwi",
					"nameOrigin":"fs30gj",
					"runtime":2211,
					"urlPoster":"0zi95o",
					"haveSeen":404,
					"wannaSee":324,
					"summary":"gjnqlt",
					"relationList":[
						{
							"idMovieDouban":31,
							"idCelebrityDouban":644,
							"idProfession":"6wyjz1",
							"profession":"5q1tkz",
							"sort":23508
						}
					]
				}
			],
			"movieListOrderByStartYear":[
				{
					"id":343,
					"urlMovieDouban":"7jtz4t",
					"idTypeVideo":"jj85lz",
					"typeVideo":"cd20l0",
					"idMovieImdb":"mp2f5p",
					"urlMovieImdb":"fi1hnl",
					"startYear":13539,
					"nameZh":"8gt8gw",
					"nameOrigin":"n9i8oa",
					"runtime":14125,
					"urlPoster":"nij7sj",
					"haveSeen":204,
					"wannaSee":323,
					"summary":"q4jaqt",
					"relationList":[
						{
							"idMovieDouban":505,
							"idCelebrityDouban":734,
							"idProfession":"s8xc7v",
							"profession":"ac5cde",
							"sort":4475
						}
					]
				}
			],
			"awardList":[
				{
					"idMovieDouban":158,
					"idAwardMovie":"ujircx",
					"nameZh":"30y2id",
					"urlAward":"3btre6",
					"idCelebrityDouban":152,
					"urlCelebrityDouban":"0xhz0q",
					"typeAward":"g4a9l3",
					"awardTh":411,
					"isNominated":"1qzg1b"
				}
			]
		},
		"imdb":{
			"base":{
				"id":"58",
				"nameEn":"pfvumi",
				"birthYear":31216,
				"idCelebrityDouban":395
			},
			"movieList":[
				{
					"id":"58",
					"idTypeVideo":"hvjzct",
					"typeVideo":"cs4hpw",
					"nameEn":"ejvqy1",
					"startYear":23702,
					"isAdult":"a8bus6",
					"nameOrigin":"jh3xb1",
					"runtime":4364,
					"urlPoster":"0m9zfz",
					"idMovieDouban":494,
					"summary":"guumfw",
					"relationList":[
						{
							"idMovieImdb":8,
							"idCelebrityImdb":295,
							"idProfession":"m4z3ri",
							"profession":"pvwfpv"
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
curl -X GET -i https://api.doubans.com/v2/celebrity/imdb/bases?id=181
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
	"code":358,
	"msg":"hglk39",
	"data":{
		"id":"58",
		"nameEn":"2rnfiq",
		"birthYear":6918,
		"idCelebrityDouban":776
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
curl -X GET -i https://api.doubans.com/v2/celebrity/imdb/details?limit=10&id=549
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
	"code":779,
	"msg":"z2kb1p",
	"data":{
		"base":{
			"id":"58",
			"nameEn":"dozg83",
			"birthYear":31760,
			"idCelebrityDouban":735
		},
		"movieList":[
			{
				"id":"58",
				"idTypeVideo":"of2c0d",
				"typeVideo":"zuc3s3",
				"nameEn":"pzut3r",
				"startYear":1572,
				"isAdult":"1l9w6z",
				"nameOrigin":"dcpnia",
				"runtime":3098,
				"urlPoster":"fy0c8x",
				"idMovieDouban":540,
				"summary":"pl122i",
				"relationList":[
					{
						"idMovieImdb":975,
						"idCelebrityImdb":16,
						"idProfession":"t6ovos",
						"profession":"908f0k"
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
curl -X GET -i https://api.doubans.com/v2/scene/fotoplace/bases?id=112
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
	"code":492,
	"msg":"g9kwxy",
	"data":{
		"base":{
			"id":20,
			"urlMovieScene":"3m4uo7",
			"idMovieDouban":463,
			"urlMovieDouban":"r7o1di",
			"nameZh":"ai21og",
			"nameEn":"okybc0",
			"startYear":15294,
			"description":"yo7zsl",
			"urlMap":"7vg0bi"
		},
		"sceneList":[
			{
				"base":{
					"id":911,
					"idMovieScene":303,
					"idPlaceScene":565,
					"nameZh":"hov9x8",
					"happenTime":249
				},
				"place":{
					"base":{
						"id":895,
						"longitude":587,
						"latitude":907,
						"nameZh":"kpb1d2",
						"nameEn":"zw905m",
						"nameOther":"dgdfvo",
						"alias":"126rfj",
						"addressZh":"jwbsbn",
						"addressEn":"8vgniq",
						"description":"62v82q",
						"areaZh":"vsdtyk",
						"areaEn":"8xatd5",
						"phone":"15136623396",
						"urlPoster":"3xmgaa",
						"urlEarth":"abd1vj",
						"urlSatellite":"1ff3zt",
						"urlMap":"kj5bbm"
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
curl -X GET -i https://api.doubans.com/v2/scene/fotoplace/details?id=122
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
	"code":478,
	"msg":"3gn4et",
	"data":{
		"base":{
			"id":933,
			"urlMovieScene":"7kjrif",
			"idMovieDouban":508,
			"urlMovieDouban":"hwyfmr",
			"nameZh":"kmlpq5",
			"nameEn":"2p6v6v",
			"startYear":18102,
			"description":"61doah",
			"urlMap":"t4uq4s"
		},
		"sceneList":[
			{
				"base":{
					"id":726,
					"idMovieScene":516,
					"urlMovieScene":"choe2i",
					"idPlaceScene":280,
					"nameZh":"k6xigs",
					"happenTime":272
				},
				"sceneDetailList":[
					{
						"base":{
							"id":76,
							"idScene":671,
							"idMovieScene":315,
							"happenTime":234,
							"description":"f87l89"
						},
						"imageList":[
							{
								"id":296,
								"idSceneDetail":129,
								"urlImage":"lzwgcv"
							}
						],
						"celebrityList":[
							{
								"id":2,
								"idCelebrityDouban":732,
								"urlCelebrityDouban":"uh03w5",
								"nameZh":"s9wpzf",
								"nameEn":"4wh4zc",
								"idSceneDetail":972
							}
						]
					}
				],
				"place":{
					"base":{
						"id":394,
						"longitude":634,
						"latitude":423,
						"nameZh":"fk3dnf",
						"nameEn":"ehd41q",
						"nameOther":"x9meot",
						"alias":"8padrj",
						"addressZh":"s8u8i9",
						"addressEn":"tn3rel",
						"description":"3pimf5",
						"areaZh":"petabx",
						"areaEn":"m13m1w",
						"phone":"15136623396",
						"urlPoster":"yi1ak1",
						"urlEarth":"oc7aky",
						"urlSatellite":"p7qy1d",
						"urlMap":"pd9htv"
					},
					"imageList":[
						{
							"id":478,
							"idPlaceScene":767,
							"urlImage":"aafalc",
							"description":"6mlyk7"
						}
					],
					"typeList":[
						"2dby02"
					],
					"continent":"zrf3zu",
					"country":"kxbnbx",
					"city":"wrf7h3",
					"state":"g92u83"
				}
			}
		]
	}
}
```


