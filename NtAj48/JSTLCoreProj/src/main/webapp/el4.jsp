<%@page isELIgnored="false" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!-- Tranditional loop -->
<c:forEach var="i" begin="1" end="10" step="1">
    2 * ${i} = ${2*i} <br>
</c:forEach>
<br><br><br>
<!-- Enhance loop -->
<jsp:scriptlet>
 String names[]={"raja","rani","ramesh","rathod"}; 
    request.setAttribute("nameList",names);
</jsp:scriptlet>
 
 
 <b> The names are::</b>
 <c:forEach var="nam" items="${nameList}">
     ${nam}, <br>
</c:forEach>
 
<br><br><br>
<!-- Enhance loop -->
<jsp:scriptlet>
 <![CDATA[
  List<String> courses=new ArrayList<String>(); 
     courses.add("java"); courses.add(".net"); courses.add("php");
    request.setAttribute("crsList",courses);
    ]]>
</jsp:scriptlet>
 
 
 <b> The courses are::</b>
 <c:forEach var="crs" items="${crsList}">
     ${crs}, <br>
</c:forEach>
 
 
 
