<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="nav.jsp"/>
</head>
<body>

<div class="container" style="margin-top:90px">
<% if (request.getAttribute("echec") != null){ %>
<p style="color:red;">${echec}</p>
<% } %>
<P> Please fill out this form with your name. Thanks!
<FORM METHOD="GET" action="ServletLogin">
  <div class="form-group">
    <label for="exampleInputEmail1">Login</label>
    <INPUT NAME="login" TYPE="TEXT" SIZE=" 12" MAXLENGTH=" 20" class="form-control">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <INPUT NAME="password" TYPE="password" SIZE=" 12" MAXLENGTH=" 20" class="form-control">
      </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>