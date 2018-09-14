<%--
  Created by IntelliJ IDEA.
  User: humin
  Date: 2018/9/13
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="login" action="login.action">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="account"></td>

        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="radio" name="role" value="user">User</td>
            <td><input type="radio" name="role" value="admin">Admin</td>
            <td><input type="submit" value="login"></td>
        </tr>
    </table>
</form>

</body>
</html>
