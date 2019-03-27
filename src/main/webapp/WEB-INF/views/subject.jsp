<%--
  Created by IntelliJ IDEA.
  User: humin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        body {
            background-color: black;
            color: white;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script type="text/javascript">

        var urlMovieId=1292720;
        $.ajax( {
            type : "post",
            url : "/search/searchByUrl",
            dataType:"application/json",
            data:urlMovieId,
            success : function(data) {
                $("#movie_alias").html(data.alias);
            }
        });

        <%--var test = "${movieAll.releasetimes[0].timeArea}";--%>


        <%--var movieAll = {--%>
            <%--movie_id:${movieAll.movieId},--%>
            <%--movie_name: "${movieAll.name}",--%>
            <%--movie_rate:${movieAll.rate},--%>
            <%--movie_alias: "${movieAll.alias}",--%>
            <%--movie_imdbId: "${movieAll.imdbId}",--%>
            <%--movie_releasetimes: [{--%>
                <%--timeArea: "${movieAll.releasetimes[0].timeArea}"--%>
            <%--}]--%>
        <%--};--%>


    </script>

</head>
<body>
<table>
    <tr>
        <div id="movie_name"></div>
    </tr>
    <tr>
        <div id="movie_alias">test1</div>
    </tr>
    <tr>
        <div id="movie_releasetimes">test2</div>
    </tr>
</table>

</body>
</html>
