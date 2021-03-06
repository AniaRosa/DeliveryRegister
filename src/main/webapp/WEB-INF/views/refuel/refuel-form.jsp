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
    <title>DELIVERY REGISTER Dodawanie odczytu licznika</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
</head>
<body class="bg">
    <div class="container">
        <%@include file="/WEB-INF/views/logo.jsp"%>
    <sec:authorize access="hasAnyRole('ADMIN', 'MANAGER', 'DRIVER')">

        <form:form method="post" action="/refuel/form" modelAttribute="refuel">
            <table>
                <tr>
                    <td>Rodzaj paliwa: <form:select path="fuelType" items="${fuelTypes}" />
                        <form:errors path="fuelType" cssClass="errorMessage" />
                    </td>
                    <td>Ilość: <form:input path="quantity" />
                        <form:errors path="quantity" cssClass="errorMessage" />
                    </td>
                    <td>Koszt: <form:input path="price" />
                        <form:errors path="price" cssClass="errorMessage" />
                    </td>
                </tr>

                <tr style="height: 20px"></tr>

                    <p><form:hidden path="id" /></p>
                    <p><form:hidden path="user" /></p>
                    <p><form:hidden path="date" /></p>
                    <p><form:hidden path="time" /></p>

                <tr>
                    <td></td>
                    <td><button class="button">Prześlij!</button></td>
                    <td></td>
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
