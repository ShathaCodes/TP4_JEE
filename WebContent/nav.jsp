<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="./index.jsp"><kbd>TP6</kbd></a>
    </div>
    <div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="./index.jsp">Home</a></li>
          <li><a href="./AffichageProduits">Products</a></li>
          <% if (session.getAttribute("admin") != null){ %>
      <li><a href="./ServletAffichage"><span class="glyphicon glyphicon-user"></span>Users</a></li>
    <% } %>
        </ul>
        <% if (session.getAttribute("user") == null){ %>

    <ul class="nav navbar-nav navbar-right">
      <li><a href="./AjoutUser.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="./Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
    <% } else{ %>

    <ul class="nav navbar-nav navbar-right">
      <li><a href="./Bienvenue.jsp"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
      <% if (session.getAttribute("panier") != null){ %>
      <li><a href="./Panier.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    <% } %>
    <li><a href="./ServletLogout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
    <% } %>
    <form class="navbar-form navbar-left" action="controleur" method="post">
      <div class="input-group">
			<input type="text" name="motCle" value="${modele.motCle}" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
  </div>
  </div>
  </div>
</nav>

</body>
</html>