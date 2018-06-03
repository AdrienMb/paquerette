<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="home.jsp" />
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Admin</h1>
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
            <td><a href="<c:url value='/admin/jobs/edit/${job.id}' />" >Edit</a>
            <a href="<c:url value='/admin/jobs/remove/${job.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<c:url var="addAction" value="/admin/jobs/add" ></c:url>
<form:form action="${addAction}" commandName="job">
    <c:if test="${!empty job.name}">
         <form:label path="id">
             <spring:message text="ID"/>
         </form:label>
         <form:input path="id" readonly="true" size="8"  disabled="true" />
         <form:hidden path="id" />
    </c:if>
    <form:label path="name">
        <spring:message text="Name"/>
    </form:label>
    <form:input path="name" />
    <c:if test="${!empty job.name}">
        <input type="submit"
            value="<spring:message text="Edit Job"/>" />
    </c:if>
    <c:if test="${empty job.name}">
        <input type="submit"
            value="<spring:message text="Add Job"/>" />
    </c:if>  
</form:form>
<br>
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
            <td><a href="<c:url value='/admin/parcours/edit/${parcours.id}' />" >Edit</a>
            <a href="<c:url value='/admin/parcours/remove/${parcours.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<c:url var="addParcours" value="/admin/parcours/add" ></c:url>
<form:form action="${addParcours}" commandName="parcours">
    <c:if test="${!empty parcours.name}">
         <form:label path="id">
             <spring:message text="ID"/>
         </form:label>
         <form:input path="id" readonly="true" size="8"  disabled="true" />
         <form:hidden path="id" />
    </c:if>
    <form:label path="name">
        <spring:message text="Name"/>
    </form:label>
    <form:input path="name" />
    <c:if test="${!empty parcours.name}">
        <input type="submit"
            value="<spring:message text="Edit Parcours"/>" />
    </c:if>
    <c:if test="${empty parcours.name}">
        <input type="submit"
            value="<spring:message text="Add Parcours"/>" />
    </c:if>  
</form:form>
<br>
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
            <td><%-- <a href="<c:url value='/admin/jobparcours/edit/${jobparcours.job_id}/parcours_id/${jobparcours.parcours_id}' />" >Edit</a> --%>
            <a href="<c:url value='/admin/jobparcours/remove/${jobparcours.job_id}/parcours_id/${jobparcours.parcours_id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<c:url var="addJobParcours" value="/admin/jobparcours/add" ></c:url>
<form:form action="${addJobParcours}" commandName="jobparcours">
    <form:label path="job_id">
        <spring:message text="job_id"/>
    </form:label>
     <form:input path="job_id" />
    <form:label path="parcours_id">
        <spring:message text="parcours_id"/>
    </form:label>
    <form:input path="parcours_id" />
<%--     <c:if test="${!empty jobparcours.job_id && jobparcours.job_id != 0 && !empty jobparcours.parcours_id && jobparcours.parcours_id != 0}">
        <input type="submit"
            value="<spring:message text="Edit Job-Parcours"/>" />
    </c:if> --%>
    <c:if test="${!(!empty jobparcours.job_id && jobparcours.job_id != 0 && !empty jobparcours.parcours_id && jobparcours.parcours_id != 0)}">
        <input type="submit"
            value="<spring:message text="Add Job-Parcours"/>" />
    </c:if>  
</form:form>
</body>
</html>