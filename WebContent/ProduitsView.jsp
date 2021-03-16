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
<body class="container" style="margin-top:90px">
<% if (request.getAttribute("success") != null){ %>
<p class="alert alert-success">${success}</p>
<% } %>
<% if (request.getAttribute("fail") != null){ %>
<p class="alert alert-danger"">${fail}</p>
<% } %>
<% if (session.getAttribute("admin") != null){ %>
<a href="./AjoutProduit.jsp" class="btn btn-info btn-md">Add a product</a>
<% } %>
<div class="dropdown" style="float:right">
  <button  class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown">Sort By
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="./TriServlet?tri=name">Name</a></li>
    <li><a href="./TriServlet?tri=price">Price - cheapest</a></li>
  </ul>
</div>
<br><br>
<table  width="80%" class="table">
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Action</th>
</tr>
<c:forEach items="${modele.produits}" var="p">
<tr>
<td>${p.idProduit}</td>
<td>${p.nomProduit}</td>
<td>${p.prix}</td>
<td>${p.quantite}</td>
<td><% if (session.getAttribute("admin") != null){ %>
<a href="./ServletSupprimerProduit?id=${p.idProduit}">Remove</a><br>
<a href="./ServletRedirectModif?id=${p.idProduit}">Update</a><br><% } else { %>
<a href="./AjouterProduitPanier?id=${p.idProduit}">Add to cart</a><% } %></td>

</tr>
</c:forEach>
</table>

</body>
</html>