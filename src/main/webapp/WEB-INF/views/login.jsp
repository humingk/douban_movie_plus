<%--
  Created by IntelliJ IDEA.
  User: humin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="text/javascript">

    </script>

</head>
<body>

<form id="user_login" action="/user/login" method="post">
    email:<input type="text" name="email"><br>
    password:<input type="password" name="password"><br>
    <input type="submit" value="login">
</form>

</body>
</html>
