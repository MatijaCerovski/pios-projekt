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

            <form:form action="rent" modelAttribute="rentForm" method="POST">
                <h1>Podatci</h1>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="firstName" class="pull-right">Ime:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="text" class="form-control" id="firstName" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="lastName" class="pull-right">Prezime:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="text" class="form-control" id="lastName" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="oib" class="pull-right">OIB:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="number" class="form-control" id="oib" required="required" maxlength="11"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="birthDate" class="pull-right">Datum rođenja:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="text" class="form-control datepicker" id="birthDate" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="city" class="pull-right">Grad/mjesto:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="text" class="form-control" id="city" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="zipCode" class="pull-right">Poštanski broj:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="number" class="form-control" id="zipCode" required="required" maxlength="5"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="street" class="pull-right">Ulica:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="text" class="form-control" id="street" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="houseNumber" class="pull-right">Kućni broj:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="text" class="form-control" id="houseNumber" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="phone" class="pull-right">Telefon:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="number" class="form-control" id="phone"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="mobilePhone" class="pull-right control-label">Mobitel:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="number" class="form-control" id="mobilePhone" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="email" class="pull-right">E-mail:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <input type="email" class="form-control" id="email" required="required"/>
                    </div>
                </div>

                <div class="form-actions col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <button type="" class="btn pull-right btn-danger">Odustani</button>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <button type="submit" class="btn btn-success">Rezerviraj</button>
                    </div>
                </div>

            </form:form>

        </div>

    </body>
    <script src="/resources/js/rent.js"></script>

</html>
