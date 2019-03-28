<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: humin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <style>
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
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>search</title>

</head>
<body>

<script type="text/javascript">
    var movieAllsJson=${movieAllsString};
    console.log(${movieAllsString});
    console.log(movieAllsJson.length);
    $(document).ready(function () {
        $.each(movieAllsJson,function (movieNum) {
           createMovieList(movieNum,movieAllsJson[movieNum]);
        });

        // 电影简要创建
        function createMovieList(movieAllNum,detail) {
            $("#search_result").append("<div id='movieAll_"+movieAllNum+"'>");

            $("#movieAll_"+movieAllNum).append("<div id='movie_name_"+movieAllNum+"'><a href='../subject/"+detail["movieId"]+"' target='_blank'>"+detail["name"]+"</a></div>");
            $("#movieAll_"+movieAllNum).append("<div id='movie_rate_"+movieAllNum+"'>"+detail["rate"]+"</div>");

            createActorsAndTypes(movieAllNum,detail,"movie_type","types","typeName");
            createActorsAndTypes(movieAllNum,detail,"movie_releasetime","releasetimes","timeArea");
            createActorsAndTypes(movieAllNum,detail,"movie_director","directors","name");
            createActorsAndTypes(movieAllNum,detail,"movie_writer","writers","name");
            createActorsAndTypes(movieAllNum,detail,"movie_leadingactor","leadingactors","name");

            $("#search_result").append("</div>");
        }
        // 演员 类型 上映时间
        function createActorsAndTypes(movieAllNum,detail,ATsDiv,ATdetail,ATvalue) {
            $("#movieAll_"+movieAllNum).append('<div id="'+ATsDiv+"s_"+movieAllNum+'">');
            $.each(detail[ATdetail],function (i,value) {
                $("#"+ATsDiv+"s_"+movieAllNum).append('<div id="'+ATsDiv+"_"+i+'">'+value[ATvalue]+'</div>');
            });
            $("#movieAll_"+movieAllNum).append('</div>');
        }
    });

</script>




<div id="search_result"></div>

</body>
</html>
