<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse"%>

<html>
<body>
	<% //get Ip Addrsess of Client Machine
        String remoteAddr = request.getRemoteAddr();
        //Connect to ReCaptcha server
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LcnaSgUAAAAAF1KB3JuHu_iRFUlgtWZsM_1b_VE");

        //get challege content and its response content
        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        
        ReCaptchaResponse res = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (res.isValid()) {
          out.print("Answer was entered correctly!");
        } else {
          out.print("Answer was wrong");
        }
      %>
</body>
</html>