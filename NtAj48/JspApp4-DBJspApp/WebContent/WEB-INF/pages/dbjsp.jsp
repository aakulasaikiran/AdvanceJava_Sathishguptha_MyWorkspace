<%@page import="java.sql.*"%>
<%!
 Connection con=null;
  PreparedStatement ps1=null,ps2=null;
 private static final String INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
 private static final String GET_STUDENTS="SELECT SNO,SNAME,SADD FROM STUDENT";
 
  public void jspInit(){
   ServletConfig cg=null;
   String driver=null,url=null,user=null,pwd=null;
  
   try{
   //get Access to ServletConfig object
    cg=getServletConfig();
    //read init param value from web.xml file
    driver=cg.getInitParameter("driver");
    url=cg.getInitParameter("url");
    user=cg.getInitParameter("dbuser");
    pwd=cg.getInitParameter("dbpwd");
    //register Driver
    Class.forName(driver);
    //Establish the connection
    con=DriverManager.getConnection(url,user,pwd);
    //create PreparedStatement objects
    ps1=con.prepareStatement(INSERT_QUERY);
    ps2=con.prepareStatement(GET_STUDENTS);       
   }//try
   catch(SQLException se){
     se.printStackTrace();
   }
   catch(ClassNotFoundException cnf){
    cnf.printStackTrace();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }//jspInit()
 %>
 
 <%
    String param=null;
    String name=null,addrs=null;
    int sno=0;
    int result=0;
    ResultSet rs=null;
    //read additional req param (s1)value
    param=request.getParameter("s1");
    //Differetiate request processing logic for Button,hyperlink
    if(param.equalsIgnoreCase("register")){
     //read form data
     sno=Integer.parseInt(request.getParameter("sno"));
     name=request.getParameter("sname");
     addrs=request.getParameter("sadd");
     //set values (form data) to Insert query params
     ps1.setInt(1,sno);
     ps1.setString(2,name);
     ps1.setString(3,addrs);
     //execute the Query
     result=ps1.executeUpdate();
     //process the Result
      if(result==0){ %>
        <h1>Registration failed</h1>
      <%
       }//if
       else{
       %>
        <h1>Registration Succeded</h1>
   <%     
     }//else
    }//if
    else{
       //execute select query
       rs=ps2.executeQuery(); %>
       <table border="1" width="100" height="200">
         <tr><th>sno</th><th>sname</th><th>sadd</th></tr>
       <%
       //process ResultSet and dispaly content as html table
       while(rs.next()){ %>
         <tr>
          <td><%=rs.getInt(1) %></td>
          <td><%=rs.getString(2) %></td>
          <td><%=rs.getString(3) %></td>
          </tr>
      <% } //while %>
         </table>      
      <% }//else
         %>
    <br> <a href="input.html">home</a>
 <%!
    public void jspDestroy(){
    try{
      if(ps2!=null)
       ps2.close();
    }//try
    catch(SQLException se){
      se.printStackTrace();
      }
      
      try{
      if(ps1!=null)
       ps1.close();
    }//try
    catch(SQLException se){
      se.printStackTrace();
      }
      
      try{
      if(con!=null)
       con.close();
    }//try
    catch(SQLException se){
      se.printStackTrace();
      }
      
    }//jspDestroy()
  %>    
     
 
 
 
    
    
