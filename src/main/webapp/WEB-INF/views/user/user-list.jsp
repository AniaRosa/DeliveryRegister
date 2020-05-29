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
    <%@include file="/WEB-INF/views/head.jsp"%>
</head>
<body class="bg">
    <div class="container">
        <%@include file="/WEB-INF/views/logo.jsp"%>
        <sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
             <table class="list">
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
                                <a href="/user/edit/${user.id}" class="link">Edytuj</a>
                                <br>
                                <a href="/user/confirm-delete/${user.id}" class="link">Usuń</a>
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
