<%@page import="com.nt.beans.StudentBean"  %>

<!-- Locate Bean class -->
<jsp:useBean id="st" class="com.nt.beans.StudentBean" scope="session"/>

<br>sno:: <jsp:getProperty property="sno" name="st"/>
<br>sname:: <jsp:getProperty property="sname" name="st"/>
<br>Avg:: <jsp:getProperty property="avg" name="st"/>

