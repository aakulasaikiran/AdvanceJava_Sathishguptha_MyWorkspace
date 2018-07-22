<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

  <c:set var="email" value="nataraz@gmail.com" scope="session"/>
  
  value :: <c:out value="${email}"/> <br>
  
  <c:remove var="email" scope="session"/>
  
  value :: <c:out value="${email}"/>

