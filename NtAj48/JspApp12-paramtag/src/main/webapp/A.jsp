

<b> from Start of A.jsp</b> <br>
<%
  int x=10;
  int y=x*x;
 %>
<jsp:forward page="B.jsp"> 
   <jsp:param name="bkName"  value="TIJ" />
   <jsp:param name="bAmt" value="<%=y%>" />
</jsp:forward>

<b> from end of A.jsp</b>