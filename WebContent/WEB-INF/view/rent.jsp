<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Najam</title>
    </head>
    <body>
        <div class="container">

            <c:import url="navbar.jsp"/>

            <form:form action="rent" modelAttribute="rent" method="POST">
                <h1>Podatci</h1>

                <div class="form-group">
                    <label for="firstName">Ime:</label>
                    <input type="text" id="firstName" required="required"/>
                </div>

                <div class="form-group">
                    <label for="lastName">Prezime:</label>
                    <input type="text" id="lastName" required="required"/>
                </div>

                <div class="form-group">
                    <label for="oib">OIB:</label>
                    <input type="number" id="oib" required="required"/>
                </div>

                <div class="form-group">
                    <label for="birthDate">Datum rođenja:</label>
                    <input type="text" class="datepicker" id="birthDate" required="required"/>
                </div>

                <div class="form-actions">
                    <button type="submit" class="btn">Rezerviraj</button>
                </div>

            </form:form>

        </div>

    </body>
    <script !src="">
        $(document).ready(function() {
            $( ".birthDate" ).datepicker();
        } );
    </script>
</html>
