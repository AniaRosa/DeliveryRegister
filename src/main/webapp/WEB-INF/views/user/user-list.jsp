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
             <th>Imię</th>
             <th>Nazwisko</th>
             <th>Nazwa użytkownika</th>
             <th>Rola</th>
             <th>Akcja</th>
         </tr>
            <c:forEach items="${users}" var="user" >
                <tr>
                    <td>    ${user.firstName} </td>
                    <td>    ${user.lastName} </td>
                    <td>    ${user.username}  </td>
                    <td>    ${user.role.name}  </td>
                    <td>
                        <a href="/user/edit/${user.id}" class="button">Edytuj</a>
                        <a href="/user/confirm-delete/${user.id}" class="button">Usuń</a>
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
