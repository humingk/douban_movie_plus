<%--
  Created by IntelliJ IDEA.
  User: humin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>


    <%--bootstrap框架 jquery--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">

    <meta name="viewport" content="width=device-width,
            initial-scale=1.0",maximum-scale=1.0, user-scalable=no">

</head>
<body>
<table>

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


<script type="text/javascript">
    // 本项目的url
    var url_base = "http://localhost:8080";

    // neteaseMusic api url
    var url_netease = "http://localhost:3000";

    // IMDB OMDB api url
    var url_omdb = "http://www.omdbapi.com";
    var apikey_omdb = "apikey=e409ce71";

    // IMDB url
    var url_imdb = "https://www.imdb.com";

    // 豆瓣V2 API url apiKey
    var url_douban = "https://api.douban.com";
    var apikey_douban = "apikey=0b2bdeda43b5688921839c8ecb20399b";

    // 豆瓣V2 API url apikey 备用
    var url_douban_bak="https://douban.uieee.com";
    var apikey_douban_bak="apikey=0df993c66c0c636e29ecbb5344252a4a";

    // 吉卜力工作室 API
    var url_gbl="https://ghibliapi.herokuapp.com";

    // 时光网 API url
    var url_time="https://api-m.mtime.cn";

    var currentUser=${sessionScope.currentUser};

    /**
     * js执行顺序
     *
     *
     */
    $(document).ready(function () {
        // 当前电影豆瓣ID
        var urlId = /\d{5,}/.exec(document.URL);
        // 获取豆瓣API数据 并决定是否添加数据库
        getMovieDoubanApi(urlId);

        //-------------------------
        console.log("session currentUser: ");
        console.log(currentUser);

    });

    // 电影基本资料
    function setMovieBase(movieAllJson) {
        $("#movie_name").append("影名     " + movieAllJson["name"]);
        $("#movie_alias").append("别称     " + movieAllJson["alias"]);
        $("#movie_rate").append("评分     " + movieAllJson["rate"]);
        if (movieAllJson["imdbId"]!="") {
            $("#movie_imdbId").append("IMDB     " + "<a href='" + url_imdb + "/title/" + movieAllJson["imdbId"] + "'>" + movieAllJson["imdbId"] + "</a>");
        }
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
            url: url_douban + "/v2/movie/subject/" + movieId + "?" + apikey_douban,
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
                // ===============================================================
                console.log("douban API data:");
                console.log(result);

                // 判断数据库中是否有此电影，没有则添加
                if (${movieAllString}["message"] == "OK") {

                    // ===============================================================
                    console.log("movieAll base data:");
                    console.log(${movieAllString});

                    // 设置movieAll base
                    setMovieBase(${movieAllString}["data"]);

                    // IMDB api 获取
                    // 豆瓣API JSON中没有IMDB_ID信息
                    if (${movieAllString}["data"]["imdbId"] != "") {
                        getImdbApi(${movieAllString}["data"]["imdbId"]);
                    }

                } else if (${movieAllString}["message"] == "ADD") {
                    addMovieAll(result);
                }

                // 更新后台数据库评分 movieId rate
                updateRate(result["id"], result["rating"]["average"]);
                $("#movie_rate").html("评分     " + result["rating"]["average"]);

                // 网易云音乐api 之doubanAPI获取
                getNeteaseMusic(result["name"]);

                // 展示API中的数据
                $("#movie_poster").append("<img src='" + result["images"]["large"] + "' rel='noreferrer'>");
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
            url: url_base + "/subject/updateRate?movieId=" + movieId + "&rate=" + rate,
            success: function (result) {
                // ===============================================================
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
            "imdbId": "",
            "alias": data["aka"].toString().replace(/,/g, "/"),
            "directors": [],
            "writers": [],
            "leadingactors": [],
            "types": [],
            "tags": [],
            "releasetimes": []
        };
        addMovieActors(movieAll.directors, data["directors"]);
        addMovieActors(movieAll.leadingactors, data["casts"]);
        $.each(data["pubdates"], function (i, releasetime) {
            movieAll.releasetimes.push({"timeArea": releasetime});
        });
        $.each(data["genres"], function (i, type) {
            movieAll.types.push({"typeName": type});
        });
        $.each(data["tags"], function (i, tag) {
            movieAll.tags.push({"tagName": tag});
        });
        // 异步上传movieAll
        $.ajax({
            url: url_base + "/subject/addMovieAll",
            type: "POST",
            data: JSON.stringify(movieAll),
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                // ===============================================================
                console.log("add movieAll success");
                setMovieBase(movieAll);

            }
        });
    }

    // 回传的movieAll添加actor信息
    function addMovieActors(mActors, dActors) {
        $.each(dActors, function (i) {
            mActors.push({"actorId": dActors[i]["id"], "name": dActors[i]["name"]});
        });
    }


    // 获取网易云音乐 电影相关搜索信息
    function getNeteaseMusic(movieName) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url_netease + "/search/suggest?keywords=" + movieName,
            success: function (result) {
                // ===============================================================
                console.log("netease movie search:");
                console.log(result);
                if ("result" in result) {
                    if ("songs" in result["result"]) {
                        var song_id = result["result"]["songs"][0]["id"];
                        getMusicComments(song_id);
                    }
                    if ("albums" in result["result"]) {
                        var album_id = result["result"]["albums"][0]["id"];
                        getMusicAlbums(album_id);
                    }
                    if ("playlists" in result["result"]) {
                        var playlist_id = result["result"]["playlists"][0]["id"];
                        getMusicPlaylists(playlist_id);
                    }
                }
            }
        });
    }

    // 获取网易云音乐 歌曲评论
    function getMusicComments(song_id) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url_netease + "/comment/music?id=" + song_id,
            success: function (result) {
                // ===============================================================
                console.log("netease song comments:");
                console.log(result);

            }
        });
    }

    // 获取网易云音乐 专辑评论
    function getMusicAlbums(album_id) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url_netease + "/comment/album?id=" + album_id,
            success: function (result) {
                // ===============================================================
                console.log("netease album comments:");
                console.log(result);

            }
        });
    }

    // 获取网易云音乐 歌单评论
    function getMusicPlaylists(playlist_id) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url_netease + "/comment/playlist?id=" + playlist_id,
            success: function (result) {
                // ===============================================================
                console.log("netease playlist comments:");
                console.log(result);

            }
        });
    }

    // IMDB
    function getImdbApi(imdbId) {
        $.ajax({
            url: url_omdb + "/?" + apikey_omdb + "&plot=full&i=" + imdbId,
            type: "GET",
            dataType: "json",
            success: function (result) {
                // ===============================================================
                console.log("IMDB API data:");
                console.log(result);

            }
        });
    }

</script>


</body>
</html>