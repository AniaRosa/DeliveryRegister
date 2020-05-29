<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 15.05.2020
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delivery Register Login</title>
    <%@include file="head.jsp"%>
</head>
<body class="bg">
    <div class="container">
        <%@include file="logo.jsp"%>
        <form method="post">
            <table>
                <tr>
                    <td>User Name: <input type="text" name="username"/> </td>
                </tr>
                <tr>
                    <td> Password: <input type="password" name="password"/> </td>
                </tr>
                <tr>
                    <td><button class="button">Zaloguj</button></td>
                </tr>
            </table>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <br>
        <br>
    </div>
</body>
</html>
