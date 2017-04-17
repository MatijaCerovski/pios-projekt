<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css' />" rel="stylesheet">
    <link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link href="<c:url value='/resources/js/bootstrap.min.js' />" rel="script">

</head>
<body>
    <nav class="navbar navbar-inverse">

        <div class="container-fluid">

            <!-- Logo -->
            <div class="navbar-header">
                <a href="#" class="navbar navbar-brand">Najam najam</a>
            </div>

            <!--Items -->
            <c:set var="page" value="${requestScope['javax.servlet.forward.servlet_path']}"/>
            <div>
                <ul class="nav navbar-nav">
                    <li class="${page == '/' ? 'active':''}"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li class="${page == '/admin' ? 'active':''}"><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                    <c:choose>
                        <c:when test="${not empty pageContext.request.userPrincipal}">
                            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="${page == '/login' ? 'active':''}"><a href="${pageContext.request.contextPath}/login">Login</a></li>
                        </c:otherwise>

                    </c:choose>

                    <li class="${page == '/register' ? 'active':''}"><a href="${pageContext.request.contextPath}/register">Register</a></li>

                </ul>

            </div>

        </div>

    </nav>
</body>


<script !src="">
    $(document).ready(function() {
        $('#accommodations').DataTable();
        $('#orders').DataTable();
        $('#users').DataTable();
        $('.datepicker').datepicker();
    } );
</script>