<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="nav.jsp"/>
</head>
<body class="container" style="margin-top:90px">
<h1>Register: </h1>
<form method="GET" action="./ServletAjoutUser">
<div class="form-group">
    <label for="name">Name</label>
<input type="text" id="name" name="name" class="form-control">
  </div>
<div class="form-group">
    <label for="login">Login</label>
<input type="text" id="login" name="login"  class="form-control">
  </div>
  <div class="form-group">
  <label for="pass">Password</label>
<input type="password" id="pass" name="pass" class="form-control" >
  </div>
  <div class="form-group">
   <label for="email">Email</label>
<input type="text" id="email" name="email" class="form-control">
  </div>
  <div class="form-group">
    
<label for="ville">Ville</label>
<input type="text" id="ville" name="ville" class="form-control">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>