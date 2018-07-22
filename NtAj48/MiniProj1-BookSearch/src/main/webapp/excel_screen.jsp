<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.nt.dto.BookDTO"%>
    
<% //read request attribute value
   List<BookDTO> listDTO=(List<BookDTO>)request.getAttribute("booksList");
   response.setContentType("application/vnd.ms-excel");
   response.addHeader("content-disposition","attachment;fileName=books.xls");
%>
  <h1 style="color:blue">Books Belogning to Category= <%=request.getParameter("category") %></h1>
  
  <%
    if(listDTO.size()!=0){ %>
     <table border="1">
      <tr style="color:red"><th>BookID</th><th>BookName</th><th>Author</th><th>status</th><th>category</th></tr>
      <%
        for(BookDTO dto:listDTO){ %>
         <tr>
          <td><%=dto.getBookId() %></td>
          <td><%=dto.getBookName() %></td>
          <td><%=dto.getAuthorName() %></td>
          <td><%=dto.getStatus() %></td>
          <td><%=dto.getCategory()%></td>
         </tr>
      <%  }//for
        %>
     </table>
   <%
    }//if
    else{ %>
      <h1 style='color:red'>Records not Found </h1>
   <% }
   %>
   <br>
  <a href="search.html">home</a> &nbsp;&nbsp;&nbsp; 
  <a href="javaScript:showPrint()">print</a>
  
 <script language="JavaScript">
   function showPrint(){
     frames.focus();
     frames.print();
   }
 </script> 
  
 