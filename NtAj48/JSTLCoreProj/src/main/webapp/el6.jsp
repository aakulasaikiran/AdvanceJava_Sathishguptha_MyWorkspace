<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:set var="names"  value="raja,rani,jani,phani,loni,dhoni,bhoni" scope="request"/>

the names are :: <br>
 <c:forTokens var="nam" items="${names}" delims="a">
    ${nam} <br>
 </c:forTokens>

















