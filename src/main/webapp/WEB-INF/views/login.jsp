<%--
  Created by IntelliJ IDEA.
  User: humin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="https://apps.bdimg.com/libs/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="text/javascript">

    </script>

</head>
<body>

<form id="user_login" action="/loginForm" method="post">
    email:<input type="text" name="email" placeholder="请用邮箱登录"><br>
    password:<input type="password" name="password"><br>
    rememberMe:<input type="checkbox" name="rememberMe"><br>
    <input type="submit" value="login">
</form>
=========================
<form id="user_register" action="/registerForm" method="post">
    email:<input type="text" name="email" placeholder="请用邮箱注册"><br>
    alias:<input type="text" name="name"><br>
    label:<input type="text" name="label"><br>
    phone:<input type="text" name="phone"><br>
    password:<input type="password" name="password"><br>
    <input type="submit" value="register">
</form>

</body>
</html>
