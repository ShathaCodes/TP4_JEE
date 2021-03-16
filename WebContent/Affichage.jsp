<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<jsp:include page="nav.jsp"/>
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="margin-top:90px">
<a href="./AjoutUser.jsp" class="btn btn-info btn-md">Add a user</a>
<h1>List of all users</h1>
<table class="table" width="80%">
<tr>
<th>ID</th>
<th>Name</th>
<th>Login</th>
<th>Password</th>
<th>Email</th>
<th>Ville</th>
<th>Action</th>
</tr>
<c:forEach items="${users}" var="item">
<tr>
<td>${item.idUser}</td>
<td>${item.name}</td>
<td>${item.login}</td>
<td>${item.pass}</td>
<td>${item.email}</td>
<td>${item.ville}</td>
<td><a href="./ServletSupprimerUser?id=${item.idUser}">Remove</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>