<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Matija
  Date: 3/4/2017
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<div class="container">

    <c:import url="navbar.jsp"/>

    <form:form action="register" modelAttribute="user" method="POST">
        <h1>Sign up</h1>

        <div class="form-group">
            <label for="username">Your username:</label>
            <form:input path="username" id="username" required="required"
                        type="text" placeholder="makoa" autofocus="autofocus"/>
            <form:errors path="username" element="div"/>
        </div>

        <div class="form-group">
            <label for="email">Your email:</label>
            <form:input path="email" id="email" required="required"
                        type="email" placeholder="makoa@mail.com"/>
            <form:errors path="email" element="div"/>
        </div>

        <div class="form-group">
            <label for="password">Your password:</label>
            <form:input path="password" id="password" required="required"
                        type="password" placeholder="eg. X8df!90EO"/>
            <form:errors path="password" element="div"/>
        </div>

        <div class="form-group">
            <label for="matchingPassword">Please confirm your password:</label>
            <form:input path="matchingPassword" id="matchingPassword"
                        required="required" type="password" placeholder="eg. X8df!90EO"/>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn">Sign up</button>
        </div>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <div class="form-group">
            Already a member ? <a href="login" class="to_register"> Go and
            log in </a>
        </div>
    </form:form>

</div>

</body>
</html>
