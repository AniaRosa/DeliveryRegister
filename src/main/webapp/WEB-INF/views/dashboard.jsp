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
    <title>DELIVERY REGISTER</title>
    <%@include file="head.jsp"%>
</head>
<body class="bg">
    <div class="container">
        <%@include file="logo.jsp"%>
            <table>
                <sec:authorize access="hasAnyRole('ADMIN', 'MANAGER', 'DRIVER')">
                    <tr>
                        <td><a href="/route/form/deliveries-number/0" class="button">Dodaj trasę</a></td>
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
                        <td><a href="/car-fee/form" class="button">Dodaj opłatę</a></td>
                        <td><a href="/user/form-driver" class="button">Dodaj użytkownika</a></td>
                        <td><a href="/reports/form" class="button">Pobierz raport</a></td>
                    </tr>
                    <tr>
                        <td><a href="/car-fee/list" class="button">Edytuj opłatę</a></td>
                        <td><a href="/user/list" class="button">Edytuj użytkownika</a></td>
                        <td></td>
                    </tr>
                </sec:authorize>

                <sec:authorize access="hasRole('ADMIN')">
                    <tr style="height: 20px"></tr>
                    <tr>
                        <td><a href="/user/form-manager" class="button">Dodaj managera</a></td>
                        <td><a href="/user/form-admin" class="button">Dodaj admina</a></td>
                        <td></td>
                    </tr>
                </sec:authorize>
            </table>
        <br>
        <br>
    </div>
</body>
</html>
