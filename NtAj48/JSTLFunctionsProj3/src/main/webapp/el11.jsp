<%@page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="msg"  value="welcome to  JSTL" scope="request"/>

UpperCase :: ${fn:toUpperCase(msg)} <br>
LowerCase :: ${fn:toLowerCase(msg)} <br>
SubString :: ${fn:substring(msg,0,4)} <br>
