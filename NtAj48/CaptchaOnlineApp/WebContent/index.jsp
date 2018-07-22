<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

    <html>
      <body>
        <form action="process.jsp" method="post">
        <%
          //ReCaptcha c = ReCaptchaFactory.newReCaptcha("your_public_key", "your_private_key", false);
        ReCaptcha captcha = ReCaptchaFactory.newReCaptcha("6LcnaSgUAAAAAGZLBleMKJS3sNBVMmMe3Ovd75CU", "6LcnaSgUAAAAAF1KB3JuHu_iRFUlgtWZsM_1b_VE", false);
          out.print(captcha.createRecaptchaHtml(null, null));
        %>
        <input type="submit" value="submit" />
        </form>
      </body>
    </html>
