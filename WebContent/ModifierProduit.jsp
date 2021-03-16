<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="nav.jsp"/>
</head>
<body>
<div class="container" style="margin-top:90px">
<h1>Update a product : </h1>
<form method="GET" action="./ServletModifierProduit">
<div class="form-group">
    <label for="id">Id</label>
<input type="number" id="id" name="id" value="${prod.idProduit}" readonly="readonly" class="form-control">
  </div>
  <div class="form-group">
    <label for="name">Name</label>
<input type="text" id="name" name="name" class="form-control" value="${prod.nomProduit}">
  </div>
  <div class="form-group">
    <label for="prix">Price</label>
<input type="number" id="prix" name="prix" class="form-control" value="${prod.prix}">
  </div>
  <div class="form-group">
    <label for="quant">Quantity</label>
<input type="number" id="quant" name="quant" class="form-control" value="${prod.quantite}">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>