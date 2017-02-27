<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<title>people</title>
</head>
<h2>People</h2>
<body>
		<div>
		<ul>
          <c:forEach var="person" items="${people}">
            <li><c:out value="${person.firstName} ${person.lastName}" /></li>
          </c:forEach>
        </ul>
		</div>
</body>
</html>