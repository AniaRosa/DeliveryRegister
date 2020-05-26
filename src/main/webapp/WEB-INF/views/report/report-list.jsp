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
    <title>DELIVERY REGISTER Spis opłat</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body class="bg">

<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
     <table align="center">
         <tr>
             <th>Data</th>
             <th>Opłata</th>
             <th>Opis</th>
             <th>Użytkownik</th>
             <th>Akcja</th>
         </tr>
            <c:forEach items="${fees}" var="fee" >
                <tr>
                    <td>    ${fee.date} </td>
                    <td>    ${fee.fee} </td>
                    <td>    ${fee.description}  </td>
                    <td>    ${fee.user.username}  </td>
                    <td>
                        <a href="/car-fee/edit/${fee.id}" class="button">Edytuj</a>
                        <a href="/car-fee/confirm-delete/${fee.id}" class="button">Usuń</a>
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
