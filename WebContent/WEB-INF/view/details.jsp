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

    <nav class="navbar navbar-inverse">

        <div class="container-fluid">

            <!-- Logo -->
            <div class="navbar-header">
                <a href="#" class="navbar navbar-brand">Najam najam</a>
            </div>

            <!--Items -->

            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                    <c:choose>
                        <c:when test="${not empty pageContext.request.userPrincipal}">
                            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                        </c:otherwise>

                    </c:choose>

                    <li><a href="${pageContext.request.contextPath}/register">Register</a></li>

                </ul>

            </div>

        </div>

    </nav>

    <div class="name">
        ${accommodation.name}<hr>
    </div>

    <div class="images">

            <c:forEach items="${accommodation.images}" var="image">
                <img src="${pageContext.request.contextPath}/image/${image.name}" alt=""><hr>
            </c:forEach>
    </div>

</div>

</body>
</html>
