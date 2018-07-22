<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.nt.dto.BookDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
 
 <script language="JavaScript">
   function showPrint(){
     frames.focus();
     frames.print();
   }
 </script> 
 
 <c:choose>
   <c:when test="${!empty booksList}">
    <table border="1">
      <tr style="color:red"><th>BookID</th><th>BookName</th><th>Author</th><th>status</th><th>category</th></tr>
      <c:forEach var="dto" items="${booksList}">
        <tr>
          <td>${dto.bookId}</td>
          <td>${dto.bookName}</td>
          <td>${dto.authorName}</td>
          <td>${dto.status}</td>
          <td>${dto.category}</td>
        </tr>
      </c:forEach>
   </c:when>
   <c:otherwise>
     <h1 style="color:red">No Books Found </h1>
   </c:otherwise>
 </c:choose>
 
  <a href="search.html">home</a> &nbsp;&nbsp;&nbsp; 
  <a href="javaScript:showPrint()">print</a>
  
 