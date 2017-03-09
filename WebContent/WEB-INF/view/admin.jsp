<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Matija
  Date: 3/2/2017
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/js/bootstrap.min.js' />" rel="stylesheet">
    <title>Admin</title>
</head>
<body>


<div class="container">

    <nav class="navbar navbar-inverse">

        <div class="container-fluid">

            <!-- Logo -->
            <div class="navbar-header">
                <a href="#" class="navbar navbar-brand">Najam najam</a>
            </div>

            <!--Items -->

            <div>
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                    <li><a href="${pageContext.request.contextPath}/add/accommodation">Add Accommodation</a></li>
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


    <security:authorize access="isAuthenticated()">
        authenticated as <security:authentication property="principal.username" />
    </security:authorize>


    <!-- Site footer -->
    <footer class="footer">
        <p>&copy; 2016 Company, Inc.</p>
    </footer>

</div> <!-- /container -->

</body>
</html>
