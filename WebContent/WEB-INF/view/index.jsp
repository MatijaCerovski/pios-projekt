<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>

        <title>Home Page</title>

    </head>
    <body>

        <div class="container">

            <c:import url="navbar.jsp"/>


            <table id="accommodations">
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
</html>