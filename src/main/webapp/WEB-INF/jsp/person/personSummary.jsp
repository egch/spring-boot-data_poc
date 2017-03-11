
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

		 <div class="container-fluid">
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
