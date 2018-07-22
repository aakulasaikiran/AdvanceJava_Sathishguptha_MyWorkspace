<%@page isELIgnored="false" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

 <c:forEach var="p" items="${paramValues}">
   <br>Param name::  ${p.key} <br>
     Param values::
    <c:forEach var="pv"  items="${p.value}">
        ${pv}
    </c:forEach>
 
 </c:forEach>