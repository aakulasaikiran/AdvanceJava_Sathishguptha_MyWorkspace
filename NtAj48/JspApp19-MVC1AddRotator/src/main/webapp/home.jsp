<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="service"  class="com.nt.service.AddRotatorService" scope="session"/>

<%
   service.nextAdvertisement();
   response.setHeader("refresh","2");
 %>

<!-- Dispalay add as graphical hyperlink -->
<a href="<jsp:getProperty name="service" property="url"/>">
   <img width="900" height="400" src="<jsp:getProperty name="service" property="image"/>"/>
</a>

