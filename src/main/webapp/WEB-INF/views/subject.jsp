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

    <%--加载movieAllJson--%>
    <script type="text/javascript">
        var movieAllJson = ${movieAllString};

        $(document).ready(function () {

            // 电影基本资料添加
            $("#movie_name").append(    "影名     "+movieAllJson["name"]);
            $("#movie_alias").append(   "别称     "+movieAllJson["alias"]);
            $("#movie_rate").append(    "评分     "+movieAllJson["rate"]);
            $("#movie_imdbId").append(  "IMDB     "+"<a href='https://www.imdb.com/title/"+movieAllJson["imdbId"]+"'>"+movieAllJson["imdbId"]+"</a>");

            MovieOthersAppend(movieAllJson.directors,"name","celebrity","actorId","movie_directors","导演");
            MovieOthersAppend(movieAllJson.writers,"name","celebrity","actorId","movie_writers","编剧");
            MovieOthersAppend(movieAllJson.leadingactors,"name","celebrity","actorId","movie_leadingactors","主演");
            MovieOthersAppend(movieAllJson.types,"typeName","tag","typeName","movie_types","类型");
            MovieOthersAppend(movieAllJson.tags,"tagName","tag","tagName","movie_tags","标签");

            $.each(movieAllJson.releasetimes, function (i) {
                if(i==0){
                    $("#movie_releasetimes").append("上映时间   ");
                }
                var TimeForRelease=movieAllJson.releasetimes[i]["timeArea"].search("\d{4}");
                console.log(TimeForRelease);
                $("#movie_releasetimes").append("<span><a href='/tag/" + TimeForRelease + "' target='_blank'>" + movieAllJson.releasetimes[i]["timeArea"] + "</a><span>  /  ")
            });
        });

        // 演员 和 标签 遍历添加
        function MovieOthersAppend(detail,detailName,url,urlId,location,locationName) {
            $.each(detail, function (i) {
                if(i==0){
                    $("#"+location).append(locationName+"   ")
                }
                $("#"+location).append("<span><a href='/"+url+"/" + detail[i][urlId] + "' target='_blank'>" + detail[i][detailName] + "</a></span>  /  ")
            });
        }

    </script>


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

</body>
</html>
