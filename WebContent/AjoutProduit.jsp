<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="nav.jsp"/>
</head>

<div class="container" style="margin-top:90px">
<h1>Add another product: </h1>
<form method="GET" action="./ServletAjoutProduit">
  <div class="form-group">
    <label for="name">Name</label>
<input type="text" id="name" name="name" class="form-control">
  </div>
  <div class="form-group">
    <label for="prix">Price</label>
<input type="number" id="prix" name="prix" class="form-control">
  </div>
  <div class="form-group">
    <label for="quant">Quantity</label>
<input type="number" id="quant" name="quant" class="form-control">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>

</form>
</div>
</body>
</html>