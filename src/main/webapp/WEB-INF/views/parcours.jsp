<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Parcours Page</title>
</head>
<body>

<h3>Parcours List</h3>
<c:forEach items="${listParcours}" var="parcours">
        <a href="${parcours.link}">${parcours.name}</a><br>
</c:forEach>
</body>
</html>