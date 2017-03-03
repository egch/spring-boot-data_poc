<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h1>Create new user</h1>

    <form:form method="POST" action="/person/new" modelAttribute="form">
        <form:errors path="" element="div" />
        <form:hidden path="id"/>
        <div>
            <form:label path="firstName">First Name</form:label>
            <form:input path="firstName" />
            <form:errors path="firstName" />
        </div>
        <div>
            <form:label path="lastName">Last Name</form:label>
            <form:input path="lastName" />
            <form:errors path="lastName" />
        <div>
            <input type="submit" />
        </div>
    </form:form>
</body>
</html>