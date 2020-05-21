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
    <link href="/css/main.css" rel="stylesheet">
</head>
<body class="bg">

<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER', 'DRIVER')">
     <table align="center">
         <tr>
             <th>Data</th>
             <th>Godzina</th>
             <th>Stan licznika</th>
             <th>Akcja</th>
         </tr>
            <c:forEach items="${odometerReadingsByDate}" var="reading" >
                <tr>
                    <td>    ${reading.date} </td>
                    <td>    ${reading.time} </td>
                    <td>    ${reading.kms}  </td>
                    <td>
                        <a href="/odometer-reading/edit/${reading.id}" class="button">Edytuj</a>
                        <a href="/odometer-reading/confirm-delete/${reading.id}" class="button">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    <table align="center">
        <tr>
            <th><a href="/dashboard" class="button">Powrót do strony głównej</a></th>
        </tr>
    </table>
</sec:authorize>

</body>
</html>
