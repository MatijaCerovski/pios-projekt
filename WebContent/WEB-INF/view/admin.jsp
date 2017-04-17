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
    <title>Admin</title>
</head>
<body>


<div class="container">

    <c:import url="navbar.jsp"/>

    <security:authorize access="isAuthenticated()">
        authenticated as <security:authentication property="principal.username" />
    </security:authorize>



    <table id="users">
        <thead>
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Role User</th>
            <th>Role Admin</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <c:if test="${user.userRole.size() == '0'}">
                    <td><a href="${pageContext.request.contextPath}/give/roleuser/${user.username}">Add role</a></td>
                    <td><a href="${pageContext.request.contextPath}/give/roleadmin/${user.username}">Add role</a></td>
                </c:if>
                <c:if test="${user.userRole.size() == '1'}">
                    <c:forEach items="${user.userRole}" var="userRole">
                        <c:if test="${userRole.role == 'ROLE_USER'}">
                            <td><a href="${pageContext.request.contextPath}/remove/roleuser/${user.username}">Remove role</a></td>
                            <td><a href="${pageContext.request.contextPath}/give/roleadmin/${user.username}">Add role</a></td>
                        </c:if>
                    </c:forEach>
                </c:if>
                <c:if test="${user.userRole.size() == '1'}">
                    <c:forEach items="${user.userRole}" var="userRole">
                        <c:if test="${userRole.role == 'ROLE_ADMIN'}">
                            <td><a href="${pageContext.request.contextPath}/give/roleuser/${user.username}">Give role</a></td>
                            <td><a href="${pageContext.request.contextPath}/remove/roleadmin/${user.username}">Remove role</a></td>
                        </c:if>
                    </c:forEach>
                </c:if>
                <c:if test="${user.userRole.size() == '2'}">
                    <td><a href="${pageContext.request.contextPath}/remove/roleuser/${user.username}">Remove role</a></td>
                    <td><a href="${pageContext.request.contextPath}/remove/roleadmin/${user.username}">Remove role</a></td>
                </c:if>
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

</html>
