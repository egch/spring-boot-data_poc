<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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