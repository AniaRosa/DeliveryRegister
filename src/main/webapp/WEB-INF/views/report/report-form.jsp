<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
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
    <title>DELIVERY REGISTER Parametry raportu</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
</head>
<body class="bg">
    <div class="container">
        <%@include file="/WEB-INF/views/logo.jsp"%>
    <sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
        <p align="center" class="errorMessage">${error}</p>

        <form:form method="post" action="/reports/form" modelAttribute="report">
            <table>
                <tr>
                    <td>Rodzaj raportu: </td>
                    <td><form:select path="type" items="${types}" /></td>
                </tr>
                <tr>
                    <td>Zakres: </td>
                    <td>
                        <form:select path="months" items="${months}" multiple="true" />
                        <form:select path="years" items="${years}" multiple="true" />
                    </td>
                </tr>
            </table>
            <table align="center">
                <td><button class="button">Dalej ... </button></td>
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
