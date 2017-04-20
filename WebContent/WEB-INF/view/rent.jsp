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

            <form:form action="confirm" modelAttribute="userInfo" method="POST">
                <h1>Podatci</h1>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="name" class="pull-right">Ime:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <form:input path="name" type="text" class="form-control" id="name" value="${userInfo.name}" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="surname" class="pull-right">Prezime:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <form:input path="surname" type="text" class="form-control" id="surname" value="${userInfo.surname}" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="birthDate" class="pull-right">Datum rođenja:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <form:input path="birthDate" type="text" class="form-control datepicker" id="birthDate" value="${userInfo.birthDate}" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="cityTown" class="pull-right">Grad/mjesto:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <form:input path="cityTown" type="text" class="form-control" id="cityTown" value="${userInfo.cityTown}" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="postalCode" class="pull-right">Poštanski broj:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <form:input path="postalCode" type="text" class="form-control" id="postalCode" value="${userInfo.postalCode}" required="required" maxlength="5"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="streetName" class="pull-right">Ulica:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <form:input path="streetName" type="text" class="form-control" id="streetName" value="${userInfo.streetName}" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="streetNumber" class="pull-right">Kućni broj:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <form:input path="streetNumber" type="number" class="form-control" id="streetNumber" value="${userInfo.streetNumber}" required="required"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="phone" class="pull-right">Telefon:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <form:input path="phone" type="number" class="form-control" value="${userInfo.phone}" id="phone"/>
                    </div>
                </div>

                <div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <label for="cellPhone" class="pull-right control-label">Mobitel:</label>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <form:input path="cellPhone" type="number" class="form-control" id="cellPhone" value="${userInfo.cellPhone}" required="required"/>
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
                <form:input path="userInfoId" type="hidden" id="userInfoId" value="${userInfo.userInfoId}"/>
                <form:input path="username" type="hidden" id="username" value="${userInfo.username}"/>
                <input type="hidden" name="orderId" id="orderId" value="${orderID}">

            </form:form>

        </div>

    </body>
    <script src="/resources/js/rent.js"></script>

</html>
