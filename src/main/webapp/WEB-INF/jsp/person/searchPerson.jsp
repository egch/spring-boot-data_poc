<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Search  User</title>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' rel='stylesheet'>
</head>
<body>
    <div class='container'>
    <h4>Search User</h4>

    <form:form method="POST" action="/person/search" modelAttribute="form">
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
         </div>

            <input type="submit" />
        </div>
    </form:form>
    </div>
</body>
</html>