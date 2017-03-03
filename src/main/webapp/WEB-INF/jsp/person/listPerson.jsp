<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>people</title>
</head>
<h2>People</h2>
<body>
		<div>
		<ul>
          <c:forEach var="person" items="${people}">
            <li><c:out value="${person.firstName} ${person.lastName}" />
             <a href="<spring:url value="/person/new?id=${person.id}" />">update</a>
            </li>
          </c:forEach>
        </ul>
		</div>
		 <a href="<spring:url value="/person/new" />">Create New Person</a>
</body>
</html>