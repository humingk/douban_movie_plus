<%--
  Created by IntelliJ IDEA.
  User: humin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script></script>
    <title>${movieAll.name}</title>

    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script type="text/javascript">
    </script>

</head>
<body>

<%--加载演员信息和参加影片信息--%>
<script type="text/javascript">

    var actorJson=${actorString}["data"];
    var moviesByDirectorJson=${moviesByDirectorString}["data"];
    var moviesByWriterJson=${moviesByWriterString}["data"];
    var moviesByLeadingactorJson=${moviesByLeadingactorString}["data"];

    console.log(actorJson);
    console.log(moviesByLeadingactorJson);

    $(document).ready(function () {

        actorDetailAppend("actor_name","名字","name");
        actorDetailAppend("actor_sex","性别","sex");
        actorDetailAppend("actor_birthday","出生日期","birthday");
        actorDetailAppend("actor_homeplace","家乡","homeplace");
        actorDetailAppend("actor_occupation","职业","occupation");
        actorDetailAppend("actor_alias","别称","alias");
        actorDetailAppend("actor_imdbId","IMDB","imdbId");

        actorMoviesAppend(moviesByDirectorJson,"director_movie","作为导演的作品");
        actorMoviesAppend(moviesByWriterJson,"writer_movie","作为编剧的作品");
        actorMoviesAppend(moviesByLeadingactorJson,"leadingactor_movie","作为演员的作品");

    });

    function actorDetailAppend(location,locationName,jsonId) {
        if(actorJson[jsonId]!=""){
            $("#"+location).append(locationName+"  "+actorJson[jsonId]);
        }
    }



    function actorMoviesAppend(detail,location_movie,workAs) {
        $.each(detail,function (i) {
            if(i==0){
                $("#"+location_movie).append(workAs+"<br>");
            }
            $("#"+location_movie).append("<a href='../subject/"+detail[i]["movieId"]+"' target='_blank'>"+detail[i]["name"]+"</a>  /  ");
            $("#"+location_movie).append(" <strong>"+detail[i]["rate"]+"</strong> ");
        });
    }



</script>





<table>
    <tr>
        <td>
        <div id="actor_name"></div>
        </td>
    </tr>
    <tr>
        <td>
        <div id="actor_sex"></div>
        </td>
    </tr>
    <tr>
        <td>
        <div id="actor_homeplace"></div>
        </td>
    </tr>
    <tr>
        <td>
        <div id="actor_birthday"></div>
        </td>
    </tr>
    <tr>
        <td>
        <div id="actor_occupation"></div>
        </td>
    </tr>
    <tr>
        <td>
        <div id="actor_alias"></div>
        </td>
    </tr>
    <tr>
        <td>
        <div id="actor_imdbId"></div>
        </td>
    </tr>
</table>


<table>
    <div id="director_movie">
    <tr>
        <td>
        <div id="director_movie_name"></div>
        </td>
    </tr>
    <tr>
        <td>
        <div id="director_movie_rate"></div>
        </td>
        </div>
    </tr>
</table>


<table>
    <div id="writer_movie"></div>
    <tr>
        <td>
        <div id="writer_movie_name">
        </td>
    </tr>
    <tr>
        <td>
        <div id="writer_movie_rate"></div>
        </td>
    </tr>
    </div>
</table>


<table>
    <div id="leadingactor_movie">
    <tr>
        <td>
        <div id="leadingactor_movie_name"></div>
        </td>
    </tr>
    <tr>
        <td>
        <div id="leadingactor_movie_rate"></div>
        </td>
    </tr>
    </div>
</table>

</body>
</html>
