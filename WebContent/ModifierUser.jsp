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
<body class="container" style="margin-top:90px">
<h1>Update profile: </h1>
<form method="GET" action="./ServletModifierUser">
<div class="form-group">
    <label for="name">Name</label>
<input type="text" id="name" name="name" value="${sessionScope.user.name}" class="form-control">
  </div>
<div class="form-group">
    <label for="login">Login</label>
<input type="text" id="login" name="login" value="${sessionScope.user.login}" class="form-control">
  </div>
  <div class="form-group">
  <label for="pass">Password</label>
<input type="password" id="pass" name="pass" value="${sessionScope.user.pass}" class="form-control" >
  </div>
  <div class="form-group">
   <label for="email">Email</label>
<input type="text" id="email" name="email" value="${sessionScope.user.email}" class="form-control">
  </div>
  <div class="form-group">
    
<label for="ville">Ville</label>
<input type="text" id="ville" name="ville" value="${sessionScope.user.ville}" class="form-control">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>


</form>
</body>
</html>