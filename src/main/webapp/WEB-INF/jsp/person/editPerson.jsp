    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


          <script type="text/javascript">
                $(function () {
                    $('#datetimepicker1')
                    .datetimepicker({
                       format: 'YYYY-MM-DD'
                     });
                 });
          </script>

          <spring:url value="/person/${form.id}" var="actionURL"/>
          <div class="container-fluid">
            <h3><spring:message code="person.editPerson" /></h3>
            <div class="row">
              <div class="col-md-6 col-sm-6 col-xs-12">

                  <form:form method="POST" action="${actionURL}"  modelAttribute="form">
                  <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                  <div class="form-group form-group-lg">
                    <form:label path="firstName" class="control-label"><spring:message code="person.firstName"  /></form:label>
                    <form:input path="firstName" class="form-control"/>
                  </div>
                  <div class="form-group form-group-lg">
                      <form:label path="lastName" class="control-label"><spring:message code="person.lastName"  /></form:label>
                      <form:input path="lastName" class="form-control"/>
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
