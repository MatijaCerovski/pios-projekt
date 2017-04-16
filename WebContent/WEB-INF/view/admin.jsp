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
    <link href="<c:url value='https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css' />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
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



    <table id="users">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Iznajmi</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${accommodations}" var="accommodation">
            <tr>
                <td>${accommodation.accommodationId}</td>
                <td>${accommodation.name}</td>
                <td><a href="${pageContext.request.contextPath}/details/${accommodation.accommodationId}">Details</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>


    <!-- Site footer -->
    <footer class="footer">
        <p>&copy; 2016 Company, Inc.</p>
    </footer>

</div> <!-- /container -->

</body>

<script !src="">
    $(document).ready(function() {
        $('#users').DataTable();
    } );
</script>

</html>
