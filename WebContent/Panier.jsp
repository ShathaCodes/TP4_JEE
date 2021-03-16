<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="nav.jsp"/>
</head>
<body>
<div class="container" style="margin-top:90px">
<% if (request.getAttribute("success") != null){ %>
<p class="alert alert-success">${success}</p>
<% } %>
<h2>Your Cart</h2>
<a href="./SupprimerPanier" class="btn btn-danger btn-md">Remove All</a><br>
<table width="80%" class=table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Action</th>
</tr>
<c:set var="total" value="${0}"/>
<c:forEach items="${sessionScope.panier.produits}" var="p">
<tr>
<td>${p.idProduit}</td>
<td>${p.nomProduit}</td>
<td>${p.prix}</td>
<td><a href="./SupprimerProduitPanier?id=${p.idProduit}">Remove</a><br>
</tr>
<c:set var="total" value="${total +p.prix}" />
</c:forEach>
<tr>
<td><b>Total</b></td>
<td></td>
<td><b><c:out value = "${total}"/></b></td>
<td></td>
</tr>
</table>
</div>
</body>
</html>