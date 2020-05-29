<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 19.05.2020
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELIVERY REGISTER Dodawanie opłaty</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
</head>
<body class="bg">
    <div class="container">
        <%@include file="/WEB-INF/views/logo.jsp"%>
    <sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">

        <form:form method="post" action="/user/form-driver" modelAttribute="user">
            <table>
                <tr>
                    <td class="errorMessage">${usernameExists}</td>
                </tr>
                <tr>
                    <td>Imię: <form:input path="firstName" />
                        <form:errors path="firstName" cssClass="errorMessage" /></td>
                </tr>
                <tr>
                    <td>Nazwisko: <form:input path="lastName" />
                        <form:errors path="lastName" cssClass="errorMessage" /></td>
                </tr>
                <tr>
                    <td>Nazwa użytkownika: <form:input path="username" />
                        <form:errors path="username" cssClass="errorMessage" /></td>
                </tr>
                <tr>
                    <td>Hasło: <form:input path="password" />
                        <form:errors path="password" cssClass="errorMessage" /></td>
                </tr>
                <tr style="height: 20px"></tr>

                    <p><form:hidden path="id" /></p>
                <tr>
                    <td><button class="button">Prześlij!</button></td>
                </tr>

            </table>
        </form:form>
        <table>
            <tr>
                <td><a href="/dashboard" class="button">Powrót do strony głównej</a></td>
            </tr>
        </table>
    </sec:authorize>
        <br>
        <br>
    </div>
</body>
</html>
