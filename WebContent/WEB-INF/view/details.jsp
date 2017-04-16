<%--
  Created by IntelliJ IDEA.
  User: Matija
  Date: 14.4.2017.
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Details</title>

</head>
<body>

<div class="container">

    <c:import url="navbar.jsp"/>

    <div class="name">
        ${accommodation.name}<hr>
    </div>

    <div class="images">

        <c:forEach items="${accommodation.images}" var="image">
            <img src="${pageContext.request.contextPath}/image/${image.name}" alt=""><hr>
        </c:forEach>
    </div>

    <table id="orders">
        <thead>
        <tr>
            <th>Početak</th>
            <th>Kraj</th>
            <th>Iznajmi</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${accommodation.orders}" var="order">
            <tr>
                <td>${order.startDate}</td>
                <td>${order.endDate}</td>
                <td><a href="#">ToDo</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</div>

</body>
</html>
