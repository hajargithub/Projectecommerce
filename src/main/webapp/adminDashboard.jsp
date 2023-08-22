<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <h2 class="text-center">Admin Dashboard</h2>
                <%-- Vérifier si l'administrateur est connecté --%>
                <c:if test="${sessionScope.isAdminLoggedIn}">
        <h1>Hello Admin</h1>
        <a href="logoutServlet">Logout</a>
    </c:if>
    <c:if test="${empty sessionScope.isAdminLoggedIn}">
        <p class="text-danger">Veuillez vous connecter en tant qu'administrateur.</p>
    </c:if>
            </div>
        </div>
    </div>
</body>

</body>
</html>