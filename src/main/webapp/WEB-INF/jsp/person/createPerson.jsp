<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <script type="text/javascript" src="/bower_components/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="/bower_components/moment/min/moment.min.js"></script>
  <script type="text/javascript" src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />

<title><spring:message code="person.create" /></title>
 <script type="text/javascript">
        $(function () {
            $('#datetimepicker1')
            .datetimepicker({
               format: 'YYYY-MM-DD'
             });
         });
 </script>
</head>
<body>
    <div class='container'>
    <h4><spring:message code="person.create" /></h4>

    <spring:url value="/person" var="actionURL"/>

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
            </div>
            <div>
                <form:label path="birthdate"><spring:message code="person.birthdate" /></form:label>
                <div class='input-group date' id='datetimepicker1'>
                                <form:input path="birthdate" class="form-control"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                 </div>
                <form:errors path="birthdate" />
            </div>

        <input type="submit" />
        </form:form>
    </div>
</body>
</html>