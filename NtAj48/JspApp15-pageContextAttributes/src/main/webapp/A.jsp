<b> from A.jsp</b>
<% //create diff scopes of attributes
    pageContext.setAttribute("billAmt","2000",pageContext.REQUEST_SCOPE);
    pageContext.setAttribute("username","raja",pageContext.SESSION_SCOPE);
    pageContext.setAttribute("reqCount","100",pageContext.APPLICATION_SCOPE);
  %>
 <!-- Forward request -->  
 <jsp:forward page="B.jsp"/>