<%--
  Created by IntelliJ IDEA.
  User: humin
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style type="text/css">

        body {
            background-color: black;
            color: white;

        }

        　　 a:link {
            text-decoration: none;
            color: blue
        }

        　　 a:active {
            text-decoration: blink
        }

        　　 a:hover {
            text-decoration: underline;
            color: red
        }

        　　 a:visited {
            text-decoration: none;
            color: green
        }

    </style>

    <style type="text/css">


        　　 </style>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

</head>
<body>
<table>

    <script type="text/javascript">
        var movieAllJson = ${movieAllString}["data"];
        console.log(movieAllJson);

        // js执行顺序
        $(document).ready(function () {
            // 当前电影豆瓣ID
            var urlId = /\d{5,}/.exec(document.URL);
            // 获取豆瓣API数据 并决定是否添加数据库
            getMovieDoubanApi(urlId);
            getNeteaseMusic(movieAllJson["movieId"]);
        });

        // 电影基本资料
        function setMovieBase(movieAllJson) {
            $("#movie_name").append("影名     " + movieAllJson["name"]);
            $("#movie_alias").append("别称     " + movieAllJson["alias"]);
            $("#movie_rate").append("评分     " + movieAllJson["rate"]);
            $("#movie_imdbId").append("IMDB     " + "<a href='https://www.imdb.com/title/" + movieAllJson["imdbId"] + "'>" + movieAllJson["imdbId"] + "</a>");

            MovieOthersAppend(movieAllJson.directors, "name", "celebrity", "actorId", "movie_directors", "导演");
            MovieOthersAppend(movieAllJson.writers, "name", "celebrity", "actorId", "movie_writers", "编剧");
            MovieOthersAppend(movieAllJson.leadingactors, "name", "celebrity", "actorId", "movie_leadingactors", "主演");
            MovieOthersAppend(movieAllJson.types, "typeName", "tag", "typeName", "movie_types", "类型");
            MovieOthersAppend(movieAllJson.tags, "tagName", "tag", "tagName", "movie_tags", "标签");

            $.each(movieAllJson.releasetimes, function (i) {
                if (i == 0) {
                    $("#movie_releasetimes").append("上映时间   ");
                }
                var TimeForRelease = movieAllJson.releasetimes[i]["timeArea"].search("\d{4}");
                // console.log(TimeForRelease);
                $("#movie_releasetimes").append("<span><a href='/tag/" + TimeForRelease + "' target='_blank'>" + movieAllJson.releasetimes[i]["timeArea"] + "</a><span>  /  ")
            });
        }

        // 电影基本资料添加 之添加演员、标签
        function MovieOthersAppend(detail, detailName, url, urlId, location, locationName) {
            $.each(detail, function (i) {
                if (i == 0) {
                    $("#" + location).append(locationName + "   ")
                }
                $("#" + location).append("<span><a href='/" + url + "/" + detail[i][urlId] + "' target='_blank'>" + detail[i][detailName] + "</a></span>  /  ")
            });
        }

        // 豆瓣电影API获取
        function getMovieDoubanApi(movieId) {
            $.ajax({
                type: "GET",
                url: "http://api.douban.com/v2/movie/subject/" + movieId + "?apikey=0b2bdeda43b5688921839c8ecb20399b",
                dataType: "JSONP",
                headers: {
                    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
                    "Accept-Encoding": "gzip, deflate",
                    "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8",
                    "Cache-Control": "max-age=0",
                    "Connection": "keep-alive",
                    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36"
                },
                success: function (result) {
                    console.log(result);

                    // 判断数据库中是否有此电影 ， 没有的话添加
                    if (${movieAllString}["message"] == "OK") {
                        setMovieBase(movieAllJson);
                    } else if (${movieAllString}["message"] == "ADD") {
                        addMovieAll(result);
                    }
                    // 测试===========================================================================
                    addMovieAll(result);
                    // 测试===========================================================================

                    // 更新后台数据库评分 movieId rate
                    updateRate(result["id"], result["rating"]["average"]);
                    $("#movie_rate").html("评分     " + result["rating"]["average"]);

                    // 展示API中的数据
                    $("#movie_poster").append("<img src='" + result["images"]["large"] + "'>");
                    $("#movie_summary").append("<p>" + result["summary"] + "</p>");

                    $.each(result["popular_comments"], function (i, popular_comment) {
                        $("#movie_comments").append(
                            "<div id='movie_popular_comment_" + i + "'>" +
                            "<div id='movie_popular_comment_user_" + i + "'>" +
                            popular_comment["author"]["name"] +
                            "</div>" +
                            "<div id='movie_popular_comment_content" + i + "'>" +
                            popular_comment["content"] +
                            "</div>" +
                            "</div>");
                    });

                    $.each(result["popular_reviews"], function (i, popular_review) {
                        $("#movie_reviews").append(
                            "<div id='movie_popular_review_" + i + "'>" +
                            "<div id='movie_popular_review_user_" + i + "'>" +
                            popular_review["author"]["name"] +
                            "</div>" +
                            "<div id='movie_popular_review_content_" + i + "'>" +
                            popular_review["summary"] +
                            "</div>" +
                            "</div>");
                    });
                }
            });
        }

        // 更新豆瓣电影评分
        function updateRate(movieId, rate) {
            $.ajax({
                type: "GET",
                url: "/subject/updateRate?movieId=" + movieId + "&rate=" + rate,
                success: function (result) {
                    console.log("update rate success");
                }
            });
        }

        // 添加电影信息到数据库
        function addMovieAll(data) {
            var movieAll = {
                "movieId": data["id"],
                "name": data["title"],
                "rate": data["rating"]["average"],
                "imdbId":null,
                "alias":data["aka"].toString().replace(/,/g,"/"),
                "directors":[],
                "writers":null,
                "leadingactors":[],
                "types":[],
                "tags":[],
                "releasetimes":[]
            };
            addMovieActors(movieAll.directors,data["directors"]);
            addMovieActors(movieAll.leadingactors,data["casts"]);
            $.each(data["pubdates"],function (i,releasetime) {
                movieAll.releasetimes.push({"timeArea":releasetime});
            });
            $.each(data["genres"],function (i,type) {
                movieAll.types.push({"typeName":type});
            });
            $.each(data["tags"],function (i,tag) {
               movieAll.tags.push({"tagName":tag});
            });
            console.log(movieAll);
            // 异步上传movieAll
            $.ajax({
                url:"/subject/addMovieAll",
                type:"POST",
                data:JSON.stringify(movieAll),
                dataType : "json",
                contentType : "application/json",
                success:function (result) {
                    console.log("update movieAll success");
                }
            });
        }
        // 回传的movieAll添加actor信息
        function addMovieActors(mActors,dActors) {
            $.each(dActors,function (i) {
                mActors.push({"actorId":dActors[i]["id"],"name":dActors[i]["name"]});
            });
        }


        // 获取网易云音乐 电影相关搜索信息
        function getNeteaseMusic() {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:3000/search/suggest?keywords=" + ${movieAllString}["data"]["name"],
                success: function (result) {
                    console.log(result);
                    if ("songs" in result["result"]) {
                        var music_id = result["result"]["songs"][0]["id"];
                        getMusicComments(music_id);
                    }
                }
            });
        }

        // 获取网易云音乐 对应歌曲评论信息
        function getMusicComments(music_id) {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:3000/comment/music?id=" + music_id,
                success: function (result) {
                    console.log(result);
                }
            });
        }


    </script>

    <div id="movie_poster">

    </div>


    <tr>
        <div id="movie_name"></div>
    </tr>
    <tr>
        <div id="movie_rate"></div>
    </tr>
    <tr>
        <div id="movie_directors"></div>
    </tr>
    <tr>
        <div id="movie_writers"></div>
    </tr>
    <tr>
        <div id="movie_leadingactors"></div>
    </tr>
    <tr>
        <div id="movie_types"></div>
    </tr>
    <tr>
        <div id="movie_tags"></div>
    </tr>
    <tr>
        <div id="movie_releasetimes"></div>
    </tr>
    <tr>
        <div id="movie_alias"></div>
    </tr>
    <tr>
        <div id="movie_imdbId"></div>
    </tr>
</table>

<div id="movie_summary">

    <div id="movie_netease_music">

    </div>


</div>

<div id="movie_comments">

</div>

<div id="movie_reviews">

</div>

</body>
</html>