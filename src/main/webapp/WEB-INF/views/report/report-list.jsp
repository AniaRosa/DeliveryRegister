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
    <p align="center" class="errorMessage">${error}</p>
     <table align="center">
         <tr>
             <th>Data</th>
             <th>Opłata</th>
             <th>Opis</th>
             <th>Użytkownik</th>
         </tr>
            <c:forEach items="${feesList1}" var="fee" >
                <tr>
                    <td>    ${fee.date} </td>
                    <td>    ${fee.fee} </td>
                    <td>    ${fee.description}  </td>
                    <td>    ${fee.user.username}  </td>
                </tr>
            </c:forEach>
         <tr>
             <th>Suma: </th>
             <th>${feesTotal1}</th>
             <td></td>
             <td></td>
         </tr>
         <tr>
             <th>Przychód z dostaw: </th>
             <th>${income1}</th>
             <td></td>
             <td></td>
         </tr>
         <c:if test="${type == '2'}">
             <tr>
                 <td> ------------------------------- </td>
                 <td> ------------------------------- </td>
                 <td> ------------------------------- </td>
                 <td> ------------------------------- </td>
             </tr>
             <c:forEach items="${feesList2}" var="fee" >
                 <tr>
                     <td>    ${fee.date} </td>
                     <td>    ${fee.fee} </td>
                     <td>    ${fee.description}  </td>
                     <td>    ${fee.user.username}  </td>
                 </tr>
             </c:forEach>
             <tr>
                 <th>Suma: </th>
                 <th>${feesTotal2}</th>
                 <td></td>
                 <td></td>
             </tr>
             <tr>
                 <th>Przychód z dostaw: </th>
                 <th>${income2}</th>
                 <td></td>
                 <td></td>
             </tr>
         </c:if>
        </table>
    <table align="center">
        <tr>
            <th><a href="/dashboard" class="button">Powrót do strony głównej</a></th>
        </tr>
    </table>
</sec:authorize>

</body>
</html>
