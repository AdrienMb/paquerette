<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Job Page</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<h3>Jobs List</h3>
<script type="text/javascript"> var job_domaines = new Map(); </script>
<c:if test="${!empty listJobs}">
    <form:form id="jobForm" action="/job/findParcoursByJobId" method="POST" modelAttribute="job">
    	<c:if test="${!empty listDomaines}">
    		<c:forEach items="${listDomaines}" var="domaine">
    			<input type="checkbox" value="${domaine.id}">${domaine.name}<br>
    		</c:forEach>
    	</c:if>
    	<br>
        <form:select id="jobSelect" path="id">
            <c:forEach items="${listJobs}" var="job">
            		<script type="text/javascript">job_domaines.set('${job.id}', []);</script>
            		<c:forEach items="${job.domaines}" var="domaine">
            			<script type="text/javascript">job_domaines.get('${job.id}').push(parseInt('${domaine.id}'));</script>
            		</c:forEach>
                    <form:option value="${job.id}">${job.name}</form:option>
            </c:forEach>
        </form:select>
        <input type="submit" value="Chercher mon parcours"/>
    </form:form>
</c:if>
</body>
</html>

<script type="text/javascript">

$('input:checkbox').change(function () {
	var c = document.getElementById("jobForm").getElementsByTagName('input');
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
	for (var i = 0; i < document.getElementById('jobSelect').options.length; i++) {
		var opt = document.getElementById('jobSelect').options[i];
		if (arr.length > 0) {
			// check if domaines checked are in job's domaines
			if (arr.filter(function(n) {return job_domaines.get(opt.value).indexOf(n) !== -1;}).length > 0) {
				opt.style.display = "initial";
				if (!selected) {
					// select the first on the list
					document.getElementById('jobSelect').selectedIndex = i;
					selected = true;
				}
			} else {
				opt.style.display = "none";
			}
		} else {
			// if no checkboxe is checked, display all jobs
			opt.style.display = "initial";
			if (!selected) {
				document.getElementById('jobSelect').selectedIndex = i;
				selected = true;
			}
		}
	}
});

</script>

