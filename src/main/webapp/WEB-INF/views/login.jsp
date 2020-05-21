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
    <link href="/css/main.css" rel="stylesheet">
</head>
<body class="bg">
<form method="post">
    <div align="center"><label> User Name: <input type="text" name="username"/> </label></div>
    <div align="center"><label> Password: <input type="password" name="password"/> </label></div>
    <div align="center"><button>Zaloguj</button></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
