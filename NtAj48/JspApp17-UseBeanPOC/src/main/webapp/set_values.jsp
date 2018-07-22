<%@page import="com.nt.beans.StudentBean" %>

<!-- create/Locate Java Bean class object -->
<jsp:useBean id="st"  class="com.nt.beans.StudentBean" scope="session"/>

<!-- set values to bean properties -->
<%-- <jsp:setProperty name="st" property="sno" value="101"/>
<jsp:setProperty name="st" property="sname" value="raja"/>
<jsp:setProperty name="st" property="avg" value="89.45f"/> --%>

<%-- <jsp:setProperty name="st" property="sno" param="stno"/>
<jsp:setProperty name="st" property="sname" param="stname"/>
<jsp:setProperty name="st" property="avg" param="stavg"/> --%>

<jsp:setProperty name="st" property="*"/>

<br>
 <b><i>Values are Set.....</i></b>