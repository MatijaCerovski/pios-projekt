<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div class="container">

    <c:import url="navbar.jsp"/>

    <form:form action="login" method="POST">
        <legend>Please Login</legend>

        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"/>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"/>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn">Log in</button>
        </div>
    </form:form>

</div>

</body>
</html>
