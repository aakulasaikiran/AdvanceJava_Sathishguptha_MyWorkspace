
<b> from B.jsp</b>
 <br>billAmt(request)  :: <%=pageContext.findAttribute("billAmt") %> <br>
<br>username(session)  :: <%=pageContext.findAttribute("username") %> <br>
<br> reqCount(appliation)::<%=pageContext.findAttribute("reqCount") %> <br>
<jsp:forward page="C.jsp"/>
 
 
