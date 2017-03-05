<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title><spring:message code="person.list" /></title>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' rel='stylesheet'>
</head>

<body>
		<div class='container'>
		<h2><spring:message code="person.list" /></h2>
		<ol>
          <c:forEach var="person" items="${people}">
            <li><c:out value="${person.firstName} ${person.lastName}" />
             <a href="<spring:url value="/person/${person.id}/edit" />"><spring:message code="edit" /></a>
             <a href="<spring:url value="/person/${person.id}/delete" />"><spring:message code="delete" /></a>
             <a href="<spring:url value="/person/${person.id}" />"><spring:message code="details" /></a>
            </li>
          </c:forEach>
        </ol>
         <a href="<spring:url value="/person/new" />"><spring:message code="person.create" /></a>
		</div>

</body>
</html>