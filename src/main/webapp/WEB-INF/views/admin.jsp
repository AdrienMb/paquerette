<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="home.jsp" />
<html>
<head>
<title>Admin</title>
</head>
<body>
	<div class="container">
		<h1>Admin</h1>
		<div class="row align-items-start">
			<div class="col-md-6">
				<h3>Jobs List</h3>
				<c:if test="${!empty listJobs}">
					<table class="tg">
						<tr>
							<th width="0">ID</th>
							<th width="80">Job Name</th>

						</tr>
						<c:forEach items="${listJobs}" var="job">
							<tr>
								<td>${job.id}</td>
								<td>${job.name}</td>
								<td><a href="<c:url value='/admin/jobs/edit/${job.id}' />">Edit</a>
									<a href="<c:url value='/admin/jobs/remove/${job.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:url var="addAction" value="/admin/jobs/add"></c:url>
				<form:form action="${addAction}" commandName="job">
					<c:if test="${!empty job.name}">
						<form:label path="id">
							<spring:message text="ID" />
						</form:label>
						<form:input path="id" readonly="true" size="8" disabled="true" />
						<form:hidden path="id" />
					</c:if>
					<form:label path="name">
						<spring:message text="Name" />
					</form:label>
					<form:input path="name" />
					<c:if test="${!empty job.name}">
						<input type="submit" value="<spring:message text="Edit Job"/>" />
					</c:if>
					<c:if test="${empty job.name}">
						<input type="submit" value="<spring:message text="Add Job"/>" />
					</c:if>
				</form:form>
				<br>
			</div>
			<div class="col-md-6">
				<h3>Jobs-Domaines List</h3>
				<c:if test="${!empty listJobDomaines}">
					<table class="tg">
						<tr>
							<th width="0">Job_id</th>
							<th width="80">Domaine_id</th>

						</tr>
						<c:forEach items="${listJobDomaines}" var="jobdomaine">
							<tr>
								<td>${jobdomaine.job_id}</td>
								<td>${jobdomaine.domaine_id}</td>
								<td>
									<%-- <a href="<c:url value='/admin/jobparcours/edit/${jobparcours.job_id}/jobdomaine/${jobparcours.jobdomaine}' />" >Edit</a> --%>
									<a
									href="<c:url value='/admin/jobdomaine/remove/${jobdomaine.job_id}/domaine_id/${jobdomaine.domaine_id}' />">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:url var="addJobDomaine" value="/admin/jobdomaine/add"></c:url>
				<form:form action="${addJobDomaine}" commandName="jobdomaine">
					<form:label path="job_id">
						<spring:message text="job_id" />
					</form:label>
					<form:input path="job_id" />
					<form:label path="domaine_id">
						<spring:message text="domaine_id" />
					</form:label>
					<form:input path="domaine_id" />
					<%--     <c:if test="${!empty jobparcours.job_id && jobparcours.job_id != 0 && !empty jobparcours.parcours_id && jobparcours.parcours_id != 0}">
        <input type="submit"
            value="<spring:message text="Edit Job-Parcours"/>" />
    </c:if> --%>
					<c:if
						test="${!(!empty jobdomaine.job_id && jobdomaine.job_id != 0 && !empty jobdomaine.domaine_id && jobdomaine.domaine_id != 0)}">
						<input type="submit"
							value="<spring:message text="Add Job-Domaine"/>" />
					</c:if>
				</form:form>
			</div>
			<div class="col-md-6">
				<h3>Jobs-Parcours List</h3>
				<c:if test="${!empty listJobParcours}">
					<table class="tg">
						<tr>
							<th width="0">Job_id</th>
							<th width="80">Parcours_id</th>

						</tr>
						<c:forEach items="${listJobParcours}" var="jobparcours">
							<tr>
								<td>${jobparcours.job_id}</td>
								<td>${jobparcours.parcours_id}</td>
								<td>
									<%-- <a href="<c:url value='/admin/jobparcours/edit/${jobparcours.job_id}/parcours_id/${jobparcours.parcours_id}' />" >Edit</a> --%>
									<a
									href="<c:url value='/admin/jobparcours/remove/${jobparcours.job_id}/parcours_id/${jobparcours.parcours_id}' />">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:url var="addJobParcours" value="/admin/jobparcours/add"></c:url>
				<form:form action="${addJobParcours}" commandName="jobparcours">
					<form:label path="job_id">
						<spring:message text="job_id" />
					</form:label>
					<form:input path="job_id" />
					<form:label path="parcours_id">
						<spring:message text="parcours_id" />
					</form:label>
					<form:input path="parcours_id" />
					<%--     <c:if test="${!empty jobparcours.job_id && jobparcours.job_id != 0 && !empty jobparcours.parcours_id && jobparcours.parcours_id != 0}">
        <input type="submit"
            value="<spring:message text="Edit Job-Parcours"/>" />
    </c:if> --%>
					<c:if
						test="${!(!empty jobparcours.job_id && jobparcours.job_id != 0 && !empty jobparcours.parcours_id && jobparcours.parcours_id != 0)}">
						<input type="submit"
							value="<spring:message text="Add Job-Parcours"/>" />
					</c:if>
				</form:form>
				<br>
			</div>
		</div>
		<div class="row align-items-end">
		<div class="col-md-6">
				<h3>Parcours List</h3>
				<c:if test="${!empty listParcours}">
					<table class="tg">
						<tr>
							<th width="0">ID</th>
							<th width="80">Parcours Name</th>

						</tr>
						<c:forEach items="${listParcours}" var="parcours">
							<tr>
								<td>${parcours.id}</td>
								<td>${parcours.name}</td>
								<td><a
									href="<c:url value='/admin/parcours/edit/${parcours.id}' />">Edit</a>
									<a
									href="<c:url value='/admin/parcours/remove/${parcours.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:url var="addParcours" value="/admin/parcours/add"></c:url>
				<form:form action="${addParcours}" commandName="parcours">
					<c:if test="${!empty parcours.name}">
						<form:label path="id">
							<spring:message text="ID" />
						</form:label>
						<form:input path="id" readonly="true" size="8" disabled="true" />
						<form:hidden path="id" />
					</c:if>
					<form:label path="name">
						<spring:message text="Name" />
					</form:label>
					<form:input path="name" />
					<c:if test="${!empty parcours.name}">
						<input type="submit"
							value="<spring:message text="Edit Parcours"/>" />
					</c:if>
					<c:if test="${empty parcours.name}">
						<input type="submit" value="<spring:message text="Add Parcours"/>" />
					</c:if>
				</form:form>
				<br>
			</div>
			<div class="col-md-6">
				<h3>Domaines List</h3>
				<c:if test="${!empty listDomaines}">
					<table class="tg">
						<tr>
							<th width="0">ID</th>
							<th width="80">Domaine Name</th>

						</tr>
						<c:forEach items="${listDomaines}" var="domaine">
							<tr>
								<td>${domaine.id}</td>
								<td>${domaine.name}</td>
								<td><a
									href="<c:url value='/admin/domaines/edit/${domaine.id}' />">Edit</a>
									<a
									href="<c:url value='/admin/domaines/remove/${domaine.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:url var="addDomaine" value="/admin/domaines/add"></c:url>
				<form:form action="${addDomaine}" commandName="domaine">
					<c:if test="${!empty domaine.name}">
						<form:label path="id">
							<spring:message text="ID" />
						</form:label>
						<form:input path="id" readonly="true" size="8" disabled="true" />
						<form:hidden path="id" />
					</c:if>
					<form:label path="name">
						<spring:message text="Name" />
					</form:label>
					<form:input path="name" />
					<c:if test="${!empty domaine.name}">
						<input type="submit" value="<spring:message text="Edit Domaine"/>" />
					</c:if>
					<c:if test="${empty domaine.name}">
						<input type="submit" value="<spring:message text="Add Domaine"/>" />
					</c:if>
				</form:form>
				<br>
			</div>
			<div class="col-md-6">
				<h3>Modules List</h3>
				<c:if test="${!empty listModules}">
					<table class="tg">
						<tr>
							<th width="0">ID</th>
							<th width="80">Module Name</th>

						</tr>
						<c:forEach items="${listModules}" var="module">
							<tr>
								<td>${module.id}</td>
								<td>${module.name}</td>
								<td><a
									href="<c:url value='/admin/modules/edit/${module.id}' />">Edit</a>
									<a
									href="<c:url value='/admin/modules/remove/${module.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:url var="addModule" value="/admin/modules/add"></c:url>
				<form:form action="${addModule}" commandName="module">
					<c:if test="${!empty module.name}">
						<form:label path="id">
							<spring:message text="ID" />
						</form:label>
						<form:input path="id" readonly="true" size="8" disabled="true" />
						<form:hidden path="id" />
					</c:if>
					<form:label path="name">
						<spring:message text="Name" />
					</form:label>
					<form:input path="name" />
					<c:if test="${!empty module.name}">
						<input type="submit" value="<spring:message text="Edit Module"/>" />
					</c:if>
					<c:if test="${empty module.name}">
						<input type="submit" value="<spring:message text="Add Module"/>" />
					</c:if>
				</form:form>
				<br>
			</div>
		</div>
	</div>
</body>
</html>