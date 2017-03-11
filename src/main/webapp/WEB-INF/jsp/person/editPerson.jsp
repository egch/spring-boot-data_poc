<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <div class="container-fluid">
    <h4><spring:message code="person.editPerson" /></h4>

    <spring:url value="/person/${form.id}" var="actionURL"/>

    <form:form method="POST" action="${actionURL}"  modelAttribute="form">
        <form:errors path="" element="div" />

        <div>
            <form:label path="firstName"><spring:message code="person.firstName" /></form:label>
            <form:input path="firstName" />
            <form:errors path="firstName" />
        </div>
        <div>
            <form:label path="lastName"><spring:message code="person.lastName" /></form:label>
            <form:input path="lastName" />
            <form:errors path="lastName" />
        <div>
            <input type="submit" />
        </div>
    </form:form>
    </div>
