<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="home.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Note Page</title>
</head>
<body>
<div class="container  main">
<div class="row">
<div class="col-md-4">
				<div class="blue-container">
<h3>Choisissez votre parcours selon vos compétences</h3><br>
 <p>Selectionnez votre niveau dans les différents secteur</p>
 </div>
 </div>
 <div class="col-md-1">
 </div>
  <div class="col-md-7">
<form:form action="/prerequis/findParcoursByprerequis"
			method="POST" modelAttribute="prerequis">	
<c:forEach items="${listPrerequis}" varStatus="i" var = "prerequis">
        <h4>${prerequis.name}</h4>
        <form:input class="prerequis" name="${prerequis.requis}" path ="requis" /> <br>
        <form:input type="hidden" class="prerequis" name="${prerequis.id}" value="${prerequis.id}"  path ="id" /> <br>
        
</c:forEach> 
<input type= "submit" value="Chercher mon parcours">
</form:form>
</div>
</div>
</div>
<%@include  file="footer.html" %>
</body>
</html>
