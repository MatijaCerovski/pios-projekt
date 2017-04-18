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

</head>
<body>

<div class="container">

    <c:import url="navbar.jsp"/>

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
