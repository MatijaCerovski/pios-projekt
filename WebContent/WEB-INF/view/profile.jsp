<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Matija
  Date: 17.4.2017.
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>

<div class="container">

    <c:import url="navbar.jsp"/>

    <div class="username">
        <security:authorize access="isAuthenticated()">
            <h1>Authenticated as [<security:authentication property="principal.username" />]</h1>
        </security:authorize>
    </div>


    <table id="accommodations">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Add</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${accommodations}" var="accommodation">
            <tr>
                <td>${accommodation.accommodationId}</td>
                <td>${accommodation.name}</td>
                <td><input type="text" class="datepicker" id="startDate" required="required"/></td>
                <td><input type="text" class="datepicker" id="endDate" required="required"/></td>
                <td>Prazno</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>


</div>

</body>

<script !src="">
    $(document).ready(function() {
        $( ".startDate" ).datepicker();
        $( ".endDate" ).datepicker();
    } );
</script>
</html>
