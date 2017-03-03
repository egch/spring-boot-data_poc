<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>people</title>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' rel='stylesheet'>
</head>

<body>
		<div class='container'>
		<h2>People</h2>
		<ol>
          <c:forEach var="person" items="${people}">
            <li><c:out value="${person.firstName} ${person.lastName}" />
             <a href="<spring:url value="/person/new?id=${person.id}" />">update</a>
             <a href="<spring:url value="/person/delete?id=${person.id}" />">delete</a>
            </li>
          </c:forEach>
        </ol>
         <a href="<spring:url value="/person/new" />">Create New Person</a>
		</div>

</body>
</html>