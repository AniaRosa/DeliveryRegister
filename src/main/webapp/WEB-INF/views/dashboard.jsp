<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 18.05.2020
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELIVERY REGISTER Pulpit</title>
    <link href="/css/main.css" rel="stylesheet">

</head>
<body class="bg">

<table align="center">
    <sec:authorize access="hasAnyRole('ADMIN', 'MANAGER', 'DRIVER')">
        <tr>
            <td><a href="/route/form/deliveries-number" class="button">Dodaj trasę</a></td>
            <td><a href="/odometer-reading/form" class="button">Dodaj stan licznika</a></td>
            <td><a href="/refuel/form" class="button">Dodaj tankowanie</a></td>
        </tr>
        <tr>
            <td><a href="/route/list" class="button">Edytuj trasę</a></td>
            <td><a href="/odometer-reading/list" class="button">Edytuj stan licznika</a></td>
            <td><a href="/refuel/list" class="button">Edytuj tankowanie</a></td>
        </tr>
    </sec:authorize>

    <sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
        <tr style="height: 20px"></tr>
        <tr>
            <td><a href="/add-fee" class="button">Dodaj opłatę</a></td>
            <td><a href="/add-driver" class="button">Dodaj użytkownika</a></td>
            <td><a href="/get-reports" class="button">Pobierz raport</a></td>
        </tr>
        <tr>
            <td><a href="/edit-fee" class="button">Edytuj opłatę</a></td>
            <td><a href="/edit-driver" class="button">Edytuj użytkownika</a></td>
            <td></td>
        </tr>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
        <tr style="height: 20px"></tr>
        <tr>
            <td></td>
            <td><a href="/add-manager" class="button">Dodaj managera</a></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><a href="/edit-manager" class="button">Edytuj managera</a></td>
            <td></td>
        </tr>
    </sec:authorize>
</table>

</body>
</html>
