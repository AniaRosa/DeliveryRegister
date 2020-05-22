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
    <title>DELIVERY REGISTER Dodawanie trasy</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body class="bg">

<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER', 'DRIVER')">

    <form action="/route/form" method="get">
        <table align="center">
            <tr>
                <td>Zaznacz liczbę dostaw:
                    <input type="radio" id="1" name="numberOfDeliveries" value="1">
                    <label for="1">1</label>
                    <input type="radio" id="2" name="numberOfDeliveries" value="2">
                    <label for="2">2</label>
                    <input type="radio" id="3" name="numberOfDeliveries" value="3">
                    <label for="3">3</label>
                    <input type="radio" id="4" name="numberOfDeliveries" value="4">
                    <label for="4">4</label>
                </td>
            </tr>
            <tr>
                <td>
                <button>Dalej ...</button>
                </td>
            </tr>

        </table>
    </form>
    <table align="center">
        <tr>
            <th><a href="/dashboard" class="button">Powrót do strony głównej</a></th>
        </tr>
    </table>
</sec:authorize>

</body>
</html>
