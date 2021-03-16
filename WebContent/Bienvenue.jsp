<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="nav.jsp"/>
</head>
<body >
<div class="container" style="margin-top:90px">
<h1>Welcome!</h1>
<% if (request.getAttribute("success") != null){ %>
<p class="alert alert-success">${success}</p>
<% } %>
<a href="./ModifierUser.jsp" class="btn btn-md btn-info">Update</a>&ensp;<a href="./ServletSupprimerUser?id=${sessionScope.user.idUser}" class="btn btn-md btn-danger">Delete my account</a><br><br>
<ul class="list-group">
<li class="list-group-item">Login : ${sessionScope.user.login}</li>
<li class="list-group-item">Password : ${sessionScope.user.pass}</li>
<li class="list-group-item">Name : ${sessionScope.user.name}</li>
<li class="list-group-item">Email : ${sessionScope.user.email}</li>
<li class="list-group-item">Ville : ${sessionScope.user.ville}</li>
</ul>
</div>
</body>
</html>