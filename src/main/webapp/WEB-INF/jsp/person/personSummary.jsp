<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Person Details</title>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' rel='stylesheet'>
</head>

<body>
		<div class='container'>
		<h2>Person Details</h2>
		<c:out value="${person.firstName}" /><br>
		<c:out value="${person.lastName}" />

		</div>

</body>
</html>