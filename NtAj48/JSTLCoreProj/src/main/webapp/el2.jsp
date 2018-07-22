<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${!empty param.uname}">
   hello Mr/Miss/Mrs : <c:out value="${param.uname}"/> <br>
   hello Mr/Miss/Mrs :  ${param.uname}
</c:if>
