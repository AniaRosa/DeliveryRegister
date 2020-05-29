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
         <table>
             <tr>
                 <td>Czy na pewno chcesz usunąć poniższy wpis?</td>
             </tr>
             <tr>
                 <td>Data: ${route.date}</td>
             </tr>
             <tr>
                 <td>Czas: ${route.time}</td>
             </tr>
             <tr>
                 <td>Adres startowy: ${route.address1}</td>
             </tr>
             <tr>
                 <td>Adres pierwszej dostawy: ${route.address2}</td>
             </tr>
             <tr>
                 <td>Adres drugiej dostawy: ${route.address3}</td>
             </tr>
             <tr>
                 <td>Adres trzeciej dostawy: ${route.address4}</td>
             </tr>
             <tr>
                 <td>Adres czwartej dostawy: ${route.address5}</td>
             </tr>
             <tr>
                 <td>Adres końcowy: ${route.address6}</td>
             </tr>
             <tr>
                 <td>
                     <a href="/route/delete/${route.id}" class="button">Tak   </a>
                     <a href="/route/list" class="button"> Anuluj</a>
                 </td>
             </tr>
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
