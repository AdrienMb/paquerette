<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="home.jsp" />
<html>
<head>
    <title>Parcours Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>


<div class="container">
 <h3>Parcours liés à votre recherche</h3><br>
 
<c:forEach items="${listParcours}" var="parcours">
<div class="col-md-4 parcours">
        <a href="${parcours.key.link}">${parcours.key.name}</a> <br>Correspondance : ${parcours.value}%<br>
        </div>
</c:forEach>
</div>
<%@include  file="footer.html" %>
</body>
</html>