<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="home.jsp" />
<html>
<head>
<title>Module Page</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
<div class="row">
 <div class="col-md-3">
 <h3>Choisissez votre parcours par module</h3><br>
 <p>Selectionnez des modules qui vous intéressent.</p>
 </div>
  <div class="col-md-1">
 </div>
  <div class="col-md-8">
	<h3>Modules List</h3>
	<script type="text/javascript"> var module_domaines = new Map(); </script>
	<c:if test="${!empty listModules}">
		<form:form id="moduleForm" action="/module/findParcoursByModuleId"
			method="POST" modelAttribute="module">
			<c:forEach items="${listModules}" var="module">
				<label><form:checkbox value="${module.id}" path="modulesId" />${module.name}</label><br>
			</c:forEach>
			<br>
			<input type="submit" value="Chercher mon parcours" />
		</form:form>
	</c:if>
	</div>
	</div>
	</div>
	<%@include  file="footer.html" %>
</body>
</html>



