<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Module Page</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

	<h3>Modules List</h3>
	<script type="text/javascript"> var module_domaines = new Map(); </script>
	<c:if test="${!empty listModules}">
		<form:form id="moduleForm" action="/module/findParcoursByModuleId"
			method="POST" modelAttribute="module">
			<c:forEach items="${listModules}" var="module">
				<input type="checkbox" value="${module.id}">${module.name}<br>
			</c:forEach>
			<br>
			<input type="submit" value="Chercher mon parcours" />
		</form:form>
	</c:if>
</body>
</html>



