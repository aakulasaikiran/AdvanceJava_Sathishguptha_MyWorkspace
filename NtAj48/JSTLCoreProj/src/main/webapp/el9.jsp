<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:catch var="e">
	<jsp:scriptlet>java.util.Date d = null;
				d.getYear();</jsp:scriptlet>
</c:catch>
problem is :: ${e}
















