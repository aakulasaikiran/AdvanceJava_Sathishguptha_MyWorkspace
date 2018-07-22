
<% //read form data
  float pAmt=Float.parseFloat(request.getParameter("pAmt"));
  float rate=Float.parseFloat(request.getParameter("rate"));
  float time=Float.parseFloat(request.getParameter("time")); %>
  
  <!-- create or locate Java bean class object -->
  <jsp:useBean id="dto" 
               class="com.nt.dto.IntrAmtDetailsDTO"
                scope="request"/>
                
  <!-- set form data to bean properties -->
  <jsp:setProperty name="dto" property="*"/>
  
  <!-- pass dto to service class -->
  <jsp:useBean id="service"  class="com.nt.service.IntrAmtCalculatorService" scope="application"/>
  <%
     service.calcIntrAmt(dto);
   %>
  <!-- Display details.... -->
  <br> Principle Amount :::<jsp:getProperty property="pAmt" name="dto"/>
  <br> Rate of Intrest :::<jsp:getProperty property="rate" name="dto"/> 
  <br> time  ::: <jsp:getProperty property="time" name="dto"/>
  <br> Intr Amount:: <jsp:getProperty property="intrAmt" name="dto"/>
   
  
                  
  
  
