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
    <title>DELIVERY REGISTER Dodawanie odczytu licznika</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
</head>
<body class="bg">
    <div class="container">
        <%@include file="/WEB-INF/views/logo.jsp"%>
    <sec:authorize access="hasAnyRole('ADMIN', 'MANAGER', 'DRIVER')">
         <table class="list">
             <tr>
                 <th>Data</th>
                 <th>Godzina</th>
                 <th>Rodzaj paliwa</th>
                 <th>Ilość</th>
                 <th>Koszt</th>
                 <th>Akcja</th>
             </tr>
                <c:forEach items="${refuelByDate}" var="refuel" >
                    <tr>
                        <td>    ${refuel.date} </td>
                        <td>    ${refuel.time} </td>
                        <td>    ${refuel.fuelType}  </td>
                        <td>    ${refuel.quantity}  </td>
                        <td>    ${refuel.price}  </td>
                        <td>
                            <a href="/refuel/edit/${refuel.id}" class="link">Edytuj</a>
                            <br>
                            <a href="/refuel/confirm-delete/${refuel.id}" class="link">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
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
