<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="home.jsp" />
<html>
<head>
<title>Job Page</title>
</head>
<body>
	<div class="container main">
		<div class="row">
			<div class="col-md-4">
				<div class="blue-container">
					<h3>Choisissez votre parcours par métier</h3>
					<br>
					<p>Selectionnez des métiers qui vous intéressent.</p>
				</div>
				<div class="grey-container">
					<h3>Filtrer par domaine</h3>
					<br>
					<script type="text/javascript">
						var job_domaines = new Map();
					</script>
					<c:if test="${!empty listJobs}">
						<form:form id="jobForm" action="/job/findParcoursByJobId"
							method="POST" modelAttribute="job">
							<c:if test="${!empty listDomaines}">
								<c:forEach items="${listDomaines}" var="domaine">
									<label class="checkbox-container" for="-${domaine.id}">${domaine.name}<input
										type="checkbox" class="domaine" id="-${domaine.id}"
										value="${domaine.id}"> <span class="checkmark"></span>
									</label>
								</c:forEach>
							</c:if>
							<br>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<h3>Liste des métiers</h3>
				<br>
				<c:forEach items="${listJobs}" var="job">
					<script type="text/javascript">
						job_domaines.set('${job.id}', []);
					</script>
					<c:forEach items="${job.domaines}" var="domaine">
						<script type="text/javascript">
							job_domaines.get('${job.id}').push(
									parseInt('${domaine.id}'));
						</script>
					</c:forEach>
					<div class="checkbox-row">
						<form:label for="${job.id}" class="${job.id}" path="jobsId">
							<span class="checkbox-container"> ${job.name} <form:checkbox
									value="${job.id}" id="${job.id}" class="job" path="jobsId" />
								<span class="checkmark"></span>

							</span>
						</form:label>
					</div>
				</c:forEach>
				<br> <input type="submit" value="Chercher mon parcours" />
				</form:form>
				</c:if>
			</div>
		</div>
	</div>
	<%@include file="footer.html"%>
</body>
</html>

<script type="text/javascript">
	$('.domaine')
			.change(
					function() {
						var c = document.getElementById("jobForm")
								.getElementsByTagName('input');
						arr = []
						// loop on all checkboxes to see which domaines are checked
						for (var i = 0; i < c.length; i++) {
							if (c[i].type == 'checkbox') {
								if (c[i].checked) {
									arr.push(parseInt(c[i].value));
								}
							}
						}
						var selected = false;
						// loop on all jobs to hide the ones which do not belong to the domaines chosen
						var jobs = $(".job");
						jobs
								.get()
								.forEach(
										function(opt, i, jobs) {
											//for (var i = 0; i < $('.job').length; i++) {
											//var opt = document.getElementById('jobSelect').options[i];
											if (arr.length > 0) {
												// check if domaines checked are in job's domaines
												if (arr.filter(function(n) {
													return job_domaines.get(
															opt.value).indexOf(
															n) !== -1;
												}).length > 0) {
													opt.style.display = "initial";
													$("." + opt.value)[0].style.display = "initial";
													if (!selected) {
														// select the first on the list
														document
																.getElementById('jobSelect').selectedIndex = i;
														selected = true;
													}
												} else {
													opt.style.display = "none";
													console.log($("."
															+ opt.value));
													$("." + opt.value)[0].style.display = "none";
												}
											} else {
												// if no checkboxe is checked, display all jobs
												opt.style.display = "initial";
												$("." + opt.value)[0].style.display = "initial";
											}
										})
					});
</script>

