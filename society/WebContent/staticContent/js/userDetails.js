//validateing password with re-password

function validatePassword(){
       	 var password=$('#password').val(); 
        }
 //Ading user detail
function regUserDetails(){
        		if(document.usd.firstName.value == "")
        		{
        			alert("Enter User's First Name.");
        			return false;
        		}	
        		var letterNumber = /^[a-zA-Z, ]+$/;
        		if(document.usd.firstName.value.match(letterNumber))
        		{
        			
        			/* var letterNumber = /^[a-zA-Z, ]+$/;
        			if(document.usd.middleName.value.match(letterNumber))
        			{
        				 */if(document.usd.lastName.value == "")
        				{
        					alert("Enter User's Last Name.");
        					return false;
        				}	
        				var letterNumber = /^[a-zA-Z, ]+$/;
        				if(document.usd.lastName.value.match(letterNumber))
        				{
        					
        		   	        			 if ( document.usd.contactNo.value == "")
        		   	        			 {
        						  	       alert("Please Enter Contact Number");
        						  	       return false;
        		   	        			 }
        		   	        			 var letterNumber = /^[0-9]{10}$/;
        		   	        			 if(document.usd.contactNo.value.match(letterNumber))
        		   	        			 {
                                               if ( document.usd.userName.value == "" )
    										    {
    										         
    										  	      alert("Please Enter user name.");
    										          return false;
    										    }
                                               var letterNumber = /^[a-zA-Z0-9, ]+$/;
    											if(document.usd.userName.value.match(letterNumber))
    											{
    												if ( document.usd.password.value == "" )
    												{
   										         
    													alert("Please Enter password.");
    													return false;
		  										    }
													
        											if ( document.usd.pan.value == "" )
        										    {
        										         
        										  	      alert("Please Enter PAN Number");
        										          return false;
        										    }
        											
        											if ( document.usd.typeId.value == "" )
       										    {
        										         
        										  	      alert("Please Select User Type");
        										          return false;
        										    }
        											var letterNumber = /^[a-zA-Z0-9]+$/;
        											if(document.usd.pan.value.match(letterNumber))
        											{
        				                               	usrDetails();
        										}
        										
           											else
            											{
            													alert("Enter Numbers And Alphabates Only in user name field..!!");
            													return false;
            												}
            											}
            											
            											else
        											{
        													alert("Enter Numbers And Alphabates Only in PanCard Number field..!!");
      													return false;
        												}
       											}
        											
        		   	        			 else
        									{
           										alert("Enter 10 digit Numbers Only in contact number field..!!");
       										return false;
      										}	
       									}
        		   	        		 		
       				else
        					{
       						alert("Enter Alphabets Only in last name field..!!");
       						return false;
        					}
       				}
        													
        		else
        			{
        				alert("Enter Alphabets Only in first name field..!!");
        				return false;
        			}

        		}	
        		
   function usrDetails(){

        		document.usd.btn.disabled = true;
        			
        		var params = {};
        		
        		   // var pkUserDetailsId = $('#pkUserDetailsId').val();
        			var firstName = $('#firstName').val();
        			var lastName  = $('#lastName').val();
        			var pancardNumber = $('#pan').val();
        			var contactNo = $('#contactNo').val();
        			var typeId= $('#typeId').val();
        			var userName = $('#userName').val();
        			var password = $('#password').val();

        		//	params["pkUserDetailsId"] = pkUserDetailsId;
        			params["firstName"] = firstName;
        			params["lastName"] = lastName;
        			params["pan"] =pancardNumber;
        			params["contactNo"] = contactNo;
        			params ["typeId"] = typeId;
        			params["userName"] = userName;
        			params["password"] = password;

        			
        			params["methodName"] = "regUserDetails";
        										          
        			$.post('/society/jsp/utility/controller.jsp',params,function(data)
        		 	    	{
        		 				alert(data);
        		 				if(document.usd)
        		 				{
        		 					document.usd.reset();
        		 				}	
        		 				document.usd.btn.disabled =false;
        		 			}
        		 	    	).error(function(jqXHR, textStatus, errorThrown){
        		 	    		if(textStatus==="timeout") {
        		 	    			$(loaderObj).hide();
        		 	    			$(loaderObj).find('#errorDiv').show();
        		 	    		}
        		 	    	});
        		 			
        		}

        		
        		
        	function reset()
        	{
        	document.usd.reset();	

        	}
        	
        	
        	function AddModule()
        	{
        		var selected = new Array();

        		$(document).ready(function() {

       		  $("input:checkbox[name=mod]:checked").each(function() {
        		       selected.push($(this).val());
        		  });

        		});
        		
        		let module = selected.toString();
      	    	return module;
      		}