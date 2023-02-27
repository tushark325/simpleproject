/**
 * 
 */

 function SignUpDetails(){

        	
        		var params = {};
        		
        		   // var pkUserDetailsId = $('#pkUserDetailsId').val();
        			var firstName = $('#fname').val();
        			var lastName  = $('#lname').val();
        			var pancardNumber = $('#pan').val();
        			var contactNo = $('#contactNo').val();
        			//var typeId= $('#typeId').val();
        			var userName = $('#uname').val();
        			var password = $('#pass').val();

        		//	params["pkUserDetailsId"] = pkUserDetailsId;
        			params["fname"] = firstName;
        			params["lname"] = lastName;
        			params["pan"] =pancardNumber;
        			params["contactNo"] = contactNo;
        			//params ["typeId"] = typeId;
        			params["uname"] = userName;
        			params["pass"] = password;

        			
        			params["methodName"] = "regUserDetails";
        										          
        			$.post('/society/jsp/utility/controller.jsp',params,function(data)
        		 	    	{
        		 				alert(data);
        		 				if(document.usd)
        		 				{
        		 					document.usd.reset();
        		 				}	
//        		 				document.usd.btn.disabled =false;
      		 			}
        		 	    	).error(function(jqXHR, textStatus, errorThrown){
        		 	    		if(textStatus==="timeout") {
        		 	    			$(loaderObj).hide();
        		 	    			$(loaderObj).find('#errorDiv').show();
        		 	    		}
        		 	    	});
        		 			
        		}

        		



