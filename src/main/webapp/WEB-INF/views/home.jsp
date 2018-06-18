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
      <li><a href="${pageContext.request.contextPath}/jobs">Par métier</a></li>
      <li><a href="${pageContext.request.contextPath}/modules">Par module</a></li>
      <li><a href="${pageContext.request.contextPath}/prerequis">Avec notes</a></li>
      <c:if test="${isAdmin}">
      <li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
      </c:if>
      <c:if test="${sessionScope.user != null}">
      <li><a href="${pageContext.request.contextPath}/logout">Deconnexion</a></li>
      </c:if>
    </ul>
  </div>
  </nav>
  
</body>
</html>

