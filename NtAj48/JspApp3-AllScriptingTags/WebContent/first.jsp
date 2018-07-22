
<!-- <%! public String generateWishMessage(String user){
     java.util.Calendar calendar=null;
     int hour=0;
     //int a=10;
     //get System Date
     calendar=java.util.Calendar.getInstance();
     //get current hour of the day (24hrs format)
     hour=calendar.get(java.util.Calendar.HOUR_OF_DAY);
     //generate wish Message
     if(hour<12)
      return "Good Morning::"+user;
     else if(hour<=16)
       return "Good AfterNoon::"+user;
    /*  else if(hour<=20)
       return "Good evening::"+user; */
     else
       return "Good night::"+user;
  }//method
  %> -->
  
  <%-- <h1>Welcome to jsp</h1>  --%>
  <br>
  Date and time ::<!--   <%=new java.util.Date()%> --> <br>
  <% String name="raja"; %> <br>
  Wish Message:: <%=generateWishMessage(name)%>
  
  <br>
  request obj class name:: <%=request.getClass() %> <br>
  out obj class name :: <%=out.getClass() %> <br>
  
  
  
  
  