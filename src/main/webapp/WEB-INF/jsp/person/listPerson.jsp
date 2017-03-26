<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="container-fluid text-center">
          <div class="table-responsive">
                <table id="mytable" class="table table-bordred table-striped">
                     <thead>
                         <th><spring:message code="person.firstName"  /></th>
                         <th><spring:message code="person.lastName"  /></th>
                         <th><spring:message code="person.birthdate"  /></th>
                         <th><spring:message code="edit"  /></th>
                         <th><spring:message code="delete"  /></th>
                     </thead>
                     <tbody>
                         <c:forEach var="person" items="${people}">
                             <tr>
                                  <td><c:out value="${person.firstName}" /></td>
                                  <td><c:out value="${person.lastName}" /></td>
                                  <td><c:out value="${person.birthdate}" /></td>
                                  <td><p data-placement="top" data-toggle="tooltip" title="<spring:message code="edit"  />">
                                      <a href="/person/${person.id}/edit" class="btn btn-primary btn-xs" ><span class="glyphicon glyphicon-trash"></span></a></p>
                                  </td>
                                  <td><p data-placement="top" data-toggle="tooltip" title="<spring:message code="delete"  />">
                                    <a href="/person/${person.id}/delete" class="btn btn-danger btn-xs" ><span class="glyphicon glyphicon-trash"></span></a></p>
                                  </td>
                              </tr>
                         </c:forEach>
                     </tbody>
                </table>
          </div>
 </div>






