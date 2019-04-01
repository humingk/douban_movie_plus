<%--
  Created by IntelliJ IDEA.
  User: humin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{
            background-color: black;
            color: white;
        }
    </style>
    <title>autoReflush</title>
</head>
<body>
<script type="text/javascript">
    var movieId=${autoReflush}["data"];
    $("#wait_too_long").append("没有自动跳转？<a id='reflush' href=http://localhost:8080/subject/"+movieId+">点这里手动跳转</a><br>")
</script>

<div id="why" style="font-size:50px;">
    为什么我会来到这个页面？
</div>
<div id="reason" style="font-size: 30px">
    1.查询的电影太新，还没有来得及收录...<br>
    2.查询的电影太冷门，所以没有收录...<br>
</div>

<div id="wait" style="font-size: 40px">
    别担心，正在自动收录，稍等片刻...<br>
</div>

<div id="wait_too_long" style="font-size: 10px">
</div>

</body>
</html>
