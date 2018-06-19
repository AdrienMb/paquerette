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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>
</head>
<body>
	<div class="container  main">
		<div class="row">
			<div class="col-md-4">
				<div class="blue-container">
					<h3>Choisissez votre parcours par module</h3>
					<br>
					<p>Selectionnez des modules qui vous intéressent.</p>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<h3>Modules List</h3>
				<script type="text/javascript">
					var module_domaines = new Map();
				</script>
				<c:if test="${!empty listModules}">
					<form:form id="moduleForm" action="/module/findParcoursByModuleId"
						method="POST" modelAttribute="module">
						<c:forEach items="${listModules}" var="module">
							<div class="checkbox-row cursor-pointer"> 
								<div class="form-inline">
									<label class="checkbox-container"><form:checkbox
									value="${module.id}" path="modulesId" />${module.name} <span
									class="checkmark"></span> 
									</label> 
								</div>
								<div class="form-inline">
								<i onclick="bootbox.alert(${module.desc});"> 
									<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAECSURBVDhPtVNJCsJAEJwX6A80RsHtC+qz3G4+QXBGclCRGDz7Bj+gV69eRbCjILh2jw2aZMaTFhSErmUWJuIvyA/Cak5CJ6fCiSZ+Z4ZQYdkO19unHQkBBu4YfESIM9Rm5GF7FDqsYJ0IxilhZSxBYR43N2anR90/RWZE2gnHXqDzmba93F4143PyZj0ocRxXV9BNmJC0es0/JuZEV0Gb40I4KhybTL3lWdOkOTIccdxesNhcNE1apMB2hO8F0OK4EFkJZdMlWgvil0jAxiBhtBKmHHuDHgc2r8yBD9oeEqHQ36XokZiOg6veSCMP2+2gO0FzC4P6Z8LvpqMORZZ/CSGeGYqjys9Jb50AAAAASUVORK5CYII="> 
								</i>  
								</div>
							</div> 
						</c:forEach>
						<br>
						<input type="submit" value="Chercher mon parcours" />
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
	<%@include file="footer.html"%>
</body>
</html>



