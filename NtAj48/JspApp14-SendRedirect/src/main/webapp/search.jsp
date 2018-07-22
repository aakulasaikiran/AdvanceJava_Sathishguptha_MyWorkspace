
<% //read form data
   String ss=request.getParameter("ss");
   //redirect the url (Google)
   response.sendRedirect("https://www.google.co.in/search?q="+ss);
%>