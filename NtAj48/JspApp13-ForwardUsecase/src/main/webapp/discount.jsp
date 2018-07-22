

<%
   //get Additional bill Amount
  float billAmt=Float.parseFloat(request.getParameter("bAmt"));
  //provide 20% discount on billAmt
  float discount=billAmt*0.2f;
  //calc final bill Amount
  float finalAmt=billAmt-discount;  
%>
  <!-- Display Detials -->
  <b>Item name:::</b> <%=request.getParameter("iname") %> <br>
 <br> <b>Item price:::</b> <%=request.getParameter("iprice") %> <br>
  <br><b>Item Qty:::</b> <%=request.getParameter("iqty") %> <br>
  <br><b>Bill Amount::</b><%=billAmt %>
  <br><b>Discount:::</b> <%=discount%> <br>
  <br><b>Final Bill Amount::<%=finalAmt%>
  
  <br><b> <a href="form.html">home</a></b>
    