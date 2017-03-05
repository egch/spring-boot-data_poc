<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title><spring:message code="person.summary" /></title>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' rel='stylesheet'>
</head>

<body>
		<div class='container'>
		    <h2><spring:message code="person.summary" /></h2>
            <p>
                <spring:message code="person.firstName" />: <c:out value="${person.firstName}" />
            </p>
            <p>
                <spring:message code="person.lastName" />: <c:out value="${person.lastName}" />
            </p>
            <p>
                <spring:message code="person.birthdate" />: <c:out value="${person.birthdate}" />
            </p>
		</div>

</body>
</html>