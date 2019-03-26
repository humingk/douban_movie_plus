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
    </style>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>search</title>


</head>
<body>


<table>
    <c:forEach items="${movieAlls}" var="movieAll">
        <tr>
            <td>name:</td>
            <td><c:out value="${movieAll.name}"></c:out></td>

        </tr>
        <tr>
            <td>alias:</td>
            <td><c:out value="${movieAll.alias}"></c:out></td>

        </tr>
        <c:forEach items="${movieAll.releasetimes}" var="releasetime">
            <tr>
                <td>releasetime:</td>
                <td><c:out value="${releasetime.timeArea}"></c:out></td>
            </tr>
        </c:forEach>
    </c:forEach>
</table>

</body>
</html>
