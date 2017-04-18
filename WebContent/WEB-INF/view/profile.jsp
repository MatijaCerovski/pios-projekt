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

    <a href="${pageContext.request.contextPath}/add/accommodation" class="btn btn-info" role="button">Add Accommodation</a><hr>

    <table id="accommodations">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Choose Date</th>
            <th>Add</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${accommodations}" var="accommodation">
            <tr>
                <form action="/add/accommodation/date" method="post">
                    <td>${accommodation.accommodationId}</td>
                    <td>${accommodation.name}</td>
                    <td>
                        <label>From</label>
                        <input type="text" class="from" name="from">
                        <label>to</label>
                        <input type="text" class="to" name="to">
                    </td>
                    <td><input type="submit" value="Add date"></td>
                    <input type="hidden" name="accommodationId" value="${accommodation.accommodationId}">
                    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                </form>
            </tr>
        </c:forEach>
        </tbody>

    </table>


</div>

</body>

<script>
    $( function() {
        var dateFormat = "dd/mm/yy",
            from = $( ".from" )
                .datepicker({
                    defaultDate: "+1w",
                    changeMonth: true,
                    numberOfMonths: 1
                })
                .on( "change", function() {
                    to.datepicker( "option", "minDate", getDate( this ) );
                }),
            to = $( ".to" ).datepicker({
                defaultDate: "+1w",
                changeMonth: true,
                numberOfMonths: 1
            })
                .on( "change", function() {
                    from.datepicker( "option", "maxDate", getDate( this ) );
                });

        function getDate( element ) {
            var date;
            try {
                date = $.datepicker.parseDate( dateFormat, element.value );
            } catch( error ) {
                date = null;
            }

            return date;
        }
    } );
</script>

</html>
