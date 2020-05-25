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
    <link href="/css/main.css" rel="stylesheet">
</head>
<body class="bg">

<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">

    <form:form method="post" action="/car-fee/form" modelAttribute="carFee">
        <table align="center">
            <tr>
                <td>Opłata: <form:input path="fee" />
                    <form:errors path="fee" cssClass="errorMessage" /></td>
            </tr>
            <tr>
                <td>Opis: <form:textarea path="description" cols="20" rows="5" />
                    <form:errors path="description" cssClass="errorMessage" /></td>
            </tr>

            <tr style="height: 20px"></tr>

                <p><form:hidden path="id" /></p>
                <p><form:hidden path="user" /></p>
                <p><form:hidden path="date" /></p>
            <tr>
                <td><button>Prześlij!</button></td>
            </tr>

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
