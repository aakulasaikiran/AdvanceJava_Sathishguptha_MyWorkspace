<%@page import="nl.captcha.Captcha"%>
<%  //get ur  answer
   String answer=request.getParameter("answer"); 
     //get challenge
   Captcha captcha=(Captcha)session.getAttribute(Captcha.NAME);
   
   if(captcha.isCorrect(answer)){
     out.println("Valid response"); 
   }
   else{
   out.println("InValid response");
    }
%>