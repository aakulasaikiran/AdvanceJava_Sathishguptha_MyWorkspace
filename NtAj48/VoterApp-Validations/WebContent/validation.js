  function validate(frm){
		 alert("client side form validations");
		 //change  vflag value to "yes"  indicating client side form validations are done
		 frm.vflag.value="yes";
		//empty error messages
		document.getElementById("nameErr").innerHTML="";
		document.getElementById("ageErr").innerHTML="";
		//read form data
		var name=frm.pname.value;
		var age=frm.page.value;
		//client side form validations 
		if(name==""){
			document.getElementById("nameErr").innerHTML="person name is required";
			frm.pname.focus();
			return false;
		}
		if(age==""){
        document.getElementById("ageErr").innerHTML="person age is required";
				frm.page.focus();
			return false;
		}
		else{
           if(isNaN(age)){
			 document.getElementById("ageErr").innerHTML="person age must be numeric value";
			   	frm.page.focus();
			   return false;
		   }
		}//else
		return true;
	}//function
