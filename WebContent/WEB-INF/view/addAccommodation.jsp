<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Matija
  Date: 3/7/2017
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Accommodation</title>

    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/bootstrap.min.js' />" rel="stylesheet">

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
                    <li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/add/accommodation">Add Accommodation</a></li>
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



    <form:form action="/add/accommodation" modelAttribute="accommodation" method="POST" enctype="multipart/form-data">
        <h1>Add Accommodation</h1>
        <p>
            Accommodation name
            <form:input path="name" id="name" required="required"
                        type="text" placeholder="Accommodation name"/>
            <form:errors path="name" element="div"/>
        </p>

        <p>
            Select images
            <form:input path="images" id="images" required="required"
                        type="file" multiple="multiple"/>
            <form:errors path="images" element="div"/>
        </p>


        <!--<input type="file" name="images" multiple/><br/>-->

        <p>
            <input type="submit" value="Add"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

    </form:form>


    <!-- Site footer -->
    <footer class="footer">
        <p>&copy; 2016 Company, Inc.</p>
    </footer>

</div> <!-- /container -->


</body>
</html>
