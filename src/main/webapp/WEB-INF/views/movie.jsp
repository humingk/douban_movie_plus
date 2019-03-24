<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: humin
  Date: 2019/3/17
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>豆瓣电影-首页</title>
</head>
<body>

<form:form method="post" action="/index">
<table>
    <tr>
        <td><form:label path="alias">alias</form:label></td>
        <td><form:input path="alias"></form:input></td>
        <td><input type="submit" value="search"></td>
    </tr>
</table>

</form:form>

</body>
</html>
