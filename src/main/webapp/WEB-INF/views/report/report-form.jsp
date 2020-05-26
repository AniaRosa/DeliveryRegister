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
    <link href="/css/main.css" rel="stylesheet">
</head>
<body class="bg">

<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">

    <form:form method="post" action="/reports/form" modelAttribute="report">
        <table align="center">
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
            <td><button>Dalej ... </button></td>
        </table>
    </form:form>
    <table align="center">
        <tr>
            <th><a href="/dashboard" class="button">Powrót do strony głównej</a></th>
        </tr>
    </table>
</sec:authorize>

</body>
</html>
