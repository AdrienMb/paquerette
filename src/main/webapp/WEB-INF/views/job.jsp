<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Job Page</title>
</head>
<body>

<h3>Jobs List</h3>
<c:if test="${!empty listJobs}">
    <form:form action="/job/findParcoursByJobId" method="POST" modelAttribute="job">
        <form:select path="id">
            <c:forEach items="${listJobs}" var="job">
                    <form:option value="${job.id}">${job.name}</form:option>
            </c:forEach>
        </form:select>
        <input type="submit" value="Chercher mon parcours"/>
    </form:form>
</c:if>
</body>
</html>