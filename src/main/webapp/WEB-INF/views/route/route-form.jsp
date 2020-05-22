<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>DELIVERY REGISTER Dodawanie trasy</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body class="bg">

<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER', 'DRIVER')">

    <form:form method="post" action="/route/form/${numberOfDeliveries}" modelAttribute="route">
        <table align="center">
            <tr>
                <td>
                    *Adres startowy: <form:input path="address1" />
                    <form:errors path="address1" cssClass="errorMessage" /> <br>
                    Adres pierwszej dostawy: <form:input path="address2" />
                    <form:errors path="address2" cssClass="errorMessage" /> <br>
                    Koszt: <form:input path="price2" />
                    <form:errors path="price2" cssClass="errorMessage" /> <br>
                    <c:if test="${numberOfDeliveries > 1}">
                        Adres drugiej dostawy: <form:input path="address3" />
                        <form:errors path="address3" cssClass="errorMessage" /> <br>
                        Koszt: <form:input path="price3" />
                        <form:errors path="price3" cssClass="errorMessage" /> <br>
                    </c:if>
                    <c:if test="${numberOfDeliveries > 2}">
                        Adres trzeciej dostawy: <form:input path="address4" />
                        <form:errors path="address4" cssClass="errorMessage" /> <br>
                        Koszt: <form:input path="price4" />
                        <form:errors path="price4" cssClass="errorMessage" /> <br>
                    </c:if>
                    <c:if test="${numberOfDeliveries > 3}">
                        Adres czwartej dostawy: <form:input path="address5" />
                        <form:errors path="address5" cssClass="errorMessage" /> <br>
                        Koszt: <form:input path="price5" />
                        <form:errors path="price5" cssClass="errorMessage" /> <br>
                    </c:if>
                    *Adres końcowy: <form:input path="address6" />
                    <form:errors path="address6" cssClass="errorMessage" />
                </td>

            </tr>
            <tr>
                <td>
                *JEŻELI INNY NIŻ ADRES PARABARU
                </td>
            </tr>

            <tr style="height: 20px"></tr>

            <p><form:hidden path="id" /></p>
            <p><form:hidden path="user" /></p>
            <p><form:hidden path="date" /></p>
            <p><form:hidden path="time" /></p>

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
