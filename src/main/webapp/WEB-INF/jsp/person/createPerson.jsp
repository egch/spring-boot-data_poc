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
    <div class="container">
      <div class="container-fluid">
        <h3><spring:message code="person.create" /></h3>
        <div class="row">
          <div class="col-md-6 col-sm-6 col-xs-12">
            <form:form method="POST" action="/person"  modelAttribute="form">
              <div class="form-group form-group-lg">
                <form:label path="firstName" class="control-label"><spring:message code="person.firstName"  /></form:label>
                <input class="form-control" id="firstName" name="firstName" type="text"/>
              </div>
              <div class="form-group form-group-lg">
                  <form:label path="lastName" class="control-label"><spring:message code="person.lastName"  /></form:label>
                  <input class="form-control" id="lastName" name="lastName" type="text"/>
              </div>
              <div class="form-group form-group-lg">
                <form:label path="birthdate" class="control-label"><spring:message code="person.birthdate" /></form:label>
                <div class='input-group date' id='datetimepicker1'>
                  <form:input path="birthdate" class="form-control"/>
                    <span class="input-group-addon">
                     <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
              </div>
              <div class="form-group">
                <div>
                  <button class="btn btn-primary " name="submit" type="submit">
                    Submit
                  </button>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>