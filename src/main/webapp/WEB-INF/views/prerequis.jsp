<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Note Page</title>
</head>
<body>
<h3>Prerequis List</h3>
<form:form action="/prerequis/findParcoursByprerequis"
			method="POST" modelAttribute="prerequis">
			
		<%-- <c:forEach items="${listPrerequis}" varStatus="i">
           <form:input path="fooList[${i.index}].name" type="text"/>
    </c:forEach> --%>
<c:forEach items="${listPrerequis}" varStatus="i" var = "prerequis">
<%-- <c:out value="${ status.count }" /> : <c:out value="${ prerequis.requis }" /> --%>
        <h4>${prerequis.name}
        <form:input  type="number" class="prerequis" name="${prerequis.requis}" path ="requis" /> <br>
        <form:input type="hidden" class="prerequis" name="${prerequis.id}" value="${prerequis.id}"  path ="id" /> <br>
        
</c:forEach> 
<button type= "submit">submit</button>
</form:form>
</body>
</html>