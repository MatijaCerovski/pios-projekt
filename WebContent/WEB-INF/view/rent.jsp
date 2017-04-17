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

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="firstName" class="pull-right">Ime:</label>
                    </div>
                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                        <input type="text" id="firstName" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="lastName" class="pull-right">Prezime:</label>
                    </div>
                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                        <input type="text" id="lastName" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="oib" class="pull-right">OIB:</label>
                    </div>
                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                        <input type="number" id="oib" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="birthDate" class="pull-right">Datum rođenja:</label>
                    </div>
                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                        <input type="text" class="datepicker" id="birthDate" required="required"/>
                    </div>
                </div>

                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"></div>
                <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                    .<br/>
                    .<br/>
                    .<br/>
                </div>

                <div class="form-actions col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <button type="submit" class="btn">Odustani</button>
                    <button type="submit" class="btn">Rezerviraj</button>
                </div>

            </form:form>

        </div>

    </body>
</html>
