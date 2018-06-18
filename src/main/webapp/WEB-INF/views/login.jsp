<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Parcours Isep</title>
    <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="/myapp/resources/style.css">
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img class="logo" src="/myapp/resources/logo.png"/></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/jobs">Par métier</a></li>
    </ul>
  </div>
  </nav>
  
  <div>
    <form:form name="f" action="/login" method="post" modelAttribute="user">               
      <fieldset>
        <label for="username">Identifiant</label>
        <form:input type="text" id="username" path="name"/> <br>      
        <label for="password">Mot de passe</label>
        <form:input type="password" id="password" path="password"/>  <br>  
        <div class="form-actions">
          <button type="submit" class="btn">Log in</button>
        </div>
      </fieldset>
       </form:form>
  </div>
<%@include  file="footer.html" %>
</body>
</html>