<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%-- <%@ page session="true" %> --%>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Parcours Isep</title>
    <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="/myapp/resources/style.css">
	<link rel="icon" href="/myapp/resources/favicon.ico" />
</head>
<body>
<nav class="navbar">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img class="logo" src="/myapp/resources/logo.png"/></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/jobs">Par m�tier</a></li>
    </ul>
  </div>
  </nav>
  
  <div class= "login-form">
    <form:form name="f" action="/login" method="post" modelAttribute="user">               
      <fieldset>
      <h2 class="text-center">Connexion</h2>
        <div class="form-group">
        	<form:input type="text" id="username" path="name" class="form-control" placeholder="Identifiant"/> <br>      
        </div>
        <div class="form-group">
        	<form:input type="password" id="password" path="password" class="form-control" placeholder="Mot de passe"/>  <br>
        </div>
        <div class="form-group">
          <button type="submit" class="btn">Se connecter</button>
        </div>
      </fieldset>
       </form:form>
  </div>
<%@include  file="footer.html" %>
</body>
</html>