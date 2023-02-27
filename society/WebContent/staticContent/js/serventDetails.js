/*function employeedetails(){
	
	if(document.empd.firstName.value == "")
	{
		alert("Enter Employee First Name.");
		return false;
		
		
			$.getScript('/embelSoft/staticContent/js/bootbox.min.js', function() 
			{
		
			//alert("HIIIII");
	
			var msg="Please Enter First Name";
			var dialog = bootbox.dialog({
				//title: "Embel Technologies Says :",
			    message: '<p class="text-center">'+msg.fontcolor("red").fontsize(5)+'<img src="/embelSoft/staticContent/img/s1.jpg" height="50" width="50"/></p>',
				message: '<p class="text-center">'+msg.fontcolor("red").fontsize(5)+'</p>',
				closeButton: false
			});
			
			setTimeout(function() {
				dialog.modal('hide');
			}, 1500);
			
			return false;
			
			
				});
		
		
		
	}	
	  var letterNumber = /^[a-zA-Z, ]+$/;
	  if(document.empd.firstName.value.match(letterNumber))
		{
		   if(document.empd.lastName.value == "")
			{
				alert("Enter Employee Last Name.");
				return false;
			}	
			var letterNumber = /^[a-zA-Z, ]+$/;
			if(document.empd.lastName.value.match(letterNumber))
			{
				if ( document.empd.dob.value == "" )
			    {
			         
			  	       alert("Please Select Date Birth");
			          return false;
			    }
				
				if( document.empd.contactNo.value == "" )
	   			 {
				   	      alert("Please Enter Contact Number");
			  	          return false;
	   			 }
   			 
	   			 var letterNumber = /^[0-9]{10}$/;
	   			 if(document.empd.contactNo.value.match(letterNumber))
	   			 {

    				if ( document.empd.emailId.value == "" )
				    {
				          alert("Please Enter Email Id");
				          return false;
				    }
					var letterNumber = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  	        	 if(document.empd.emailId.value.match(letterNumber) || document.empd.emailId.value == null ||  document.empd.emailId.value == "")
	  	        	 {
	  	        		if(document.empd.address.value == "")
	        				{
	        					alert("Please Enter Employee Address.");
	        					return false;
	        				}
	        				
   	        				var letterNumber = /^[a-zA-Z0-9, ]+$/;
   	        				if(document.empd.address.value.match(letterNumber))
   	        				{
   	        				   if ( document.empd.confirmEmail.value == "" )
	   	     				   {
	   	     				         alert("Please Enter Confirmation Email Id");
	   	     				         return false;
	   	     				   }
	   	     				   var letterNumber = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	   	     	  	           if(document.empd.confirmEmail.value.match(letterNumber) || document.empd.confirmEmail.value == null ||  document.empd.confirmEmail.value == "")
	   	     	  	           {
	   	     	  	        	if ( document.empd.zipCode.value == "" )
							    {
							         
							  	      alert("Please Enter Zip Code");
							          return false;
							    }
								var letterNumber = /^[0-9]{6}$/;
								if(document.empd.zipCode.value.match(letterNumber))
								{
								 
									if ( document.empd.adharNumber.value == "" )
		  	        			    {
						  	          alert("Please Enter Adhar Number");
						  	          return false;
		  	        			    }
			        				  
			        				 var letterNumber = /^[0-9]{12}$/;
		  	        			     if(document.empd.adharNumber.value.match(letterNumber))
		  	        			     {
	  	        					   if ( document.empd.panNumber.value == "" )
	  		   	        			   {
	  						  	          alert("Please Enter Pan Number");
	  						  	          return false;
	  		   	        			   } 
	  	  	        				   var letterNumber =  /^([a-zA-Z0-9]{10})?$/;
	  		   	        			   if(document.empd.panNumber.value.match(letterNumber))
	  	  	        				    { 
		  		   	        				
		  		   	        				if(document.empd.education.value == "")
				   	        				{
				   	        					alert("Please Enter Employee  Highest Education.");
				   	        					return false;
				   	        				}
				   	        				  var letterNumber = /^[a-zA-Z, ]+$/;
				   	        				  if(document.empd.education.value.match(letterNumber))
				   	        				  {
	  	        		 
						   						if(document.empd.designation.value == "")
												{
													alert("Enter Designation.");
													return false;
												}
												var letterNumber = /^[a-zA-Z ]+$/;
											    if(document.empd.designation.value.match(letterNumber))
											    {
				   			
				   	        					  if( document.empd.dateOfJoining.value == "" )
												  {
												         
											  	       alert("Please Select Date of Joining");
											          return false;
											       }
					   	        					  
					   	        					if ( document.empd.salary.value == "" )
					   			   	        		 {
					   						         
					   						  	       alert("Please Enter Salary.");
					   						          return false;
					   			   	        		 }
					   			   	        		 var letterNumber = /^[0-9]+$/;
					   			   	        		 if(document.empd.salary.value.match(letterNumber))
					   			   	        		 {
					   			   	        			
					   			   	        			 if( document.empd.description1.value == "" )
													    {
					   			   	        				 alert("Please Enyter Description 8.1");
					   			   	        				 return false;
													    }
					   			   	        			 
					   			   	        			 if( document.empd.description2.value == "" )
													    {
						   			   	        			alert("Please Enyter Description 8.2");
					   			   	        				 return false;
					   			   	        				 
													    }
					   			   	        			 
						   			   	        	
															empDetails();
					   			   	        		  
					   			   	        		 }
									
										
	   			   	        		 
				   			   	        		 else
				   								{
				   									alert("Enter Numbers Only in Salary..!!");
				   									return false;
				   								}
				   							}
			        				
	   	        						else
											{
												alert("Enter Alphabets Only in Designation..!!");
												return false;
											}
										    
										}
				   	        				  
		   	        				else
									{
										alert("Enter Alphabates Only in Highest Education..!!");
										return false;
									}	
		   	        			 }
	   	        	
	  		   	        			   
		   	        			else
								{
									alert("Please Enter Valid Pan Number..");
									return false;
								}	
			        			}		     
		  	        			     
  	        				else
  							{
  								alert("Enter 12 digit Numbers Only in Adhar Number..!!");
  								return false;
  							}	
  						}
								
						else
						{
							alert("Enter 6 Digit Numbers Only in Zip Code..!!");
							return false;
						}
					}				
   	     	         else
   	  				{
   	  					alert("Enter a Valid Confirm Email Adress..!!");
   	  					return false;
   	  				}
   	  			}
        				
				else
				{
					alert("Enter Alphabates Only in Address..!!");
					return false;
				}	
			 }
    			
	  	        	 
        	 else
				{
					alert("Enter a Valid Email Adress..!!");
					return false;
				}
			}
	  	        	 
		 else
			{
				alert("Enter 10 digit Numbers Only in Contact Number..!!");
				return false;
				}	
			}
														
		else
			{
				alert("Enter Alphabets Only in Last Name..!!");
				return false;
			}
		}

	
	else
		{
			alert("Enter Alphabets Only in First Name..!!");
			return false;
		}
	}	

*/
	

function validationServentDetails()
{
	var firstName = $('#firstName').val();
	var lastName = $('#lastName').val();
	var contactNo  = $('#contactNo').val();
	var address = $('#address').val();
	var memberName = $('#fk_member_id').val();
	var joiningDate = $('#joiningDate').val();
	var buildingName = $('#buildingName').val();
	var wingName = $('#wingName').val();
	var floorNo = $('#floorNo').val();
	var flatNo = $('#flatNo').val();
	
	if(firstName=="" || firstName==null || firstName==undefined)
	{
		alert("Please enter first name");
		return false;
	}
	if(lastName=="" || lastName==null || lastName==undefined)
	{
		alert("Please enter last name");
		return false;
	}
	if(contactNo == "" || contactNo == null)
	{
		alert("Please Enter Servent Contact No");
		return false;
	}
	else
	{
		if(contactNo.length == 10)
		{}
		else
		{
			alert("Please Enter Valid Servent Contact No");
			return false;
		}
	}
	if(address=="" || address==null || address==undefined)
	{
		alert("Please enter address");
		return false;
	}
	if(memberName=="" || memberName==null || memberName==undefined)
	{
		alert("Please select member name");
		return false;
	}
	if(joiningDate=="" || joiningDate==null || joiningDate==undefined)
	{
		alert("Please select joining jate");
		return false;
	}	
	if(buildingName=="" || buildingName==null || buildingName==undefined)
	{
		alert("Please enter building name");
		return false;
	}
	if(wingName=="" || wingName==null || wingName==undefined)
	{
		alert("Please enter wing name");
		return false;
	}
	if(floorNo=="" || floorNo==null || floorNo==undefined)
	{
		alert("Please enter floor no");
		return false;
	}
	if(flatNo=="" || flatNo==null || flatNo==undefined)
	{
		alert("Please enter flat no");
		return false;
	}
	
	serventDetails();
}


//Add Employee Details
function serventDetails()
{
	document.getElementById("saveBtn").disabled=true;
	
	var firstName = $('#firstName').val();
	var middleName = $('#middleName').val();
	var lastName = $('#lastName').val();
	var contactNo  = $('#contactNo').val();
	var altContactNo  = $('#altContactNo').val();
	var memberName = $('#fk_member_id').val();
	var joiningDate = $('#joiningDate').val();
	var buildingName = $('#buildingName').val();
	var wingName = $('#wingName').val();
	var floorNo = $('#floorNo').val();
	var flatNo = $('#flatNo').val();
	var address = $('#address').val();
	
	var input = document.getElementById('fk_member_id'),
	list = document.getElementById('memeberNameList'),
    i,fkMemberId;
 	for (i = 0; i < list.options.length; ++i) 
 	{
		if (list.options[i].value === input.value) {
			fkMemberId = list.options[i].getAttribute('data-value');
		}
	}
 	var params = {};
	if(middleName=="" || middleName==null || middleName==undefined)
	{
		middleName="N/A";
	}
	if(altContactNo=="" || altContactNo==null || altContactNo==undefined)
	{
		altContactNo="0";
	}
	params["firstName"] = firstName;
	params["middleName"] =middleName;
	params["lastName"] =lastName;
	params["contactNo"] =contactNo;
	params["altContactNo"] =altContactNo;
	params["fkMemberId"] = fkMemberId;
	params["memberName"] = memberName;
	params["joiningDate"] =joiningDate;
	params["buildingName"] =buildingName;
	params["wingName"] =wingName;
	params["floorNo"] = floorNo;
	params["flatNo"] = flatNo;
	params["address"] = address;
	
	params["methodName"] = "serventDetails";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	 	    {
	 			alert(data);
	 			if(document.empd)
	 			{
					document.getElementById("saveBtn").disabled=false;
	 				document.empd.reset();
	 			}
	 		}
	 	    ).error(function(jqXHR, textStatus, errorThrown){
	 	    	if(textStatus==="timeout") {
	 	    		$(loaderObj).hide();
	 	    		$(loaderObj).find('#errorDiv').show();
	 	    	}
	 	    });
}


/* Edit Servant Details Code */


//getServantDetailsForEdit
function getServantDetailsForEdit()
{
	$("#firstName").append($("<input/>").attr("value","").text());
	$("#middleName").append($("<input/>").attr("value","").text());
	$("#lastName").append($("<input/>").attr("value","").text());
	$("#contactNo").append($("<input/>").attr("value","").text());
	$("#address").append($("<input/>").attr("value","").text());
	$("#altContactNo").append($("<input/>").attr("value","").text());
	$("#fk_member_id").append($("<input/>").attr("value","").text());
	$("#joiningDate").append($("<input/>").attr("value","").text());
	$("#wingName").append($("<input/>").attr("value","").text());
	$("#buildingName").append($("<input/>").attr("value","").text());
	$("#floorNo").append($("<input/>").attr("value","").text());
	$("#flatNo").append($("<input/>").attr("value","").text());
	
	var params= {};
	
	var input = document.getElementById('pk_servant_id'),
        list  = document.getElementById('servantNameList'),
     	        i,pkServantId;
	 		for (i = 0; i < list.options.length; ++i) 
	 		{
			     if (list.options[i].value === input.value) 
			     {
			    	 pkServantId = list.options[i].getAttribute('data-value');
			     }
	 		}
	
	//var employeeName= $('#pk_servant_id').val();
	
	params["pkServantId"]= pkServantId;
	params["methodName"] = "getServantDetailsForEdit";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
				  
				  document.getElementById("firstName").value = v.firstName;
				  document.getElementById("middleName").value = v.middleName;
			      document.getElementById("lastName").value = v.lastName;
			      document.getElementById("contactNo").value = v.contactNo;
			      document.getElementById("address").value = v.address;
			      document.getElementById("altContactNo").value = v.altContactNo;
			      document.getElementById("fk_member_id").value = v.memberName;
			      document.getElementById("joiningDate").value = v.joiningDate;
			      document.getElementById("wingName").value = v.wingName;
			      document.getElementById("buildingName").value = v.buildingName;
			      document.getElementById("floorNo").value = v.floorNo;
			      document.getElementById("flatNo").value = v.flatNo;
			   
		      
				});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
 	    	
}

//validationUpdateServantDetails
function validationUpdateServantDetails()
{
	var firstName = $('#firstName').val();
	var lastName = $('#lastName').val();
	var contactNo  = $('#contactNo').val();
	var address = $('#address').val();
	var memberName = $('#fk_member_id').val();
	var joiningDate = $('#joiningDate').val();
	var buildingName = $('#buildingName').val();
	var wingName = $('#wingName').val();
	var floorNo = $('#floorNo').val();
	var flatNo = $('#flatNo').val();
	
	if(firstName=="" || firstName==null || firstName==undefined)
	{
		alert("Please enter first name");
		return false;
	}
	if(lastName=="" || lastName==null || lastName==undefined)
	{
		alert("Please enter last name");
		return false;
	}
	if(contactNo == "" || contactNo == null)
	{
		alert("Please Enter Servent Contact No");
		return false;
	}
	else
	{
		if(contactNo.length == 10)
		{}
		else
		{
			alert("Please Enter Valid Servent Contact No");
			return false;
		}
	}
	if(address=="" || address==null || address==undefined)
	{
		alert("Please enter address");
		return false;
	}
	if(memberName=="" || memberName==null || memberName==undefined)
	{
		alert("Please select member name");
		return false;
	}
	if(joiningDate=="" || joiningDate==null || joiningDate==undefined)
	{
		alert("Please select joining jate");
		return false;
	}	
	if(buildingName=="" || buildingName==null || buildingName==undefined)
	{
		alert("Please enter building name");
		return false;
	}
	if(wingName=="" || wingName==null || wingName==undefined)
	{
		alert("Please enter wing name");
		return false;
	}
	if(floorNo=="" || floorNo==null || floorNo==undefined)
	{
		alert("Please enter floor no");
		return false;
	}
	if(flatNo=="" || flatNo==null || flatNo==undefined)
	{
		alert("Please enter flat no");
		return false;
	}
	
	updateServantDetails();
}

//updateServantDetails
function updateServantDetails()
{
	document.getElementById("updateBtn").disabled=true;
	
	var input = document.getElementById('pk_servant_id'),
    list  = document.getElementById('servantNameList'),
    i,pkServantId;
	for (i = 0; i < list.options.length; ++i)
	{
		if (list.options[i].value === input.value) 
		{
			pkServantId = list.options[i].getAttribute('data-value');
		}
	}
	
	var firstName = $('#firstName').val();
	var middleName = $('#middleName').val();
	var lastName = $('#lastName').val();
	var contactNo  = $('#contactNo').val();
	var altContactNo  = $('#altContactNo').val();
	var memberName = $('#fk_member_id').val();
	var joiningDate = $('#joiningDate').val();
	var buildingName = $('#buildingName').val();
	var wingName = $('#wingName').val();
	var floorNo = $('#floorNo').val();
	var flatNo = $('#flatNo').val();
	var address = $('#address').val();
	
	var input = document.getElementById('fk_member_id'),
	list = document.getElementById('memeberNameList'),
    i,fkMemberId;
 	for (i = 0; i < list.options.length; ++i) 
 	{
		if (list.options[i].value === input.value) {
			fkMemberId = list.options[i].getAttribute('data-value');
		}
	}
 	var params = {};
	if(middleName=="" || middleName==null || middleName==undefined)
	{
		middleName="N/A";
	}
	if(altContactNo=="" || altContactNo==null || altContactNo==undefined)
	{
		altContactNo="0";
	}
	if(fkMemberId=="" || fkMemberId==null || fkMemberId==undefined)
	{
		fkMemberId="0";
	}
	
	params["pkServantId"] = pkServantId;
	params["firstName"] = firstName;
	params["middleName"] =middleName;
	params["lastName"] =lastName;
	params["contactNo"] =contactNo;
	params["altContactNo"] =altContactNo;
	params["fkMemberId"] = fkMemberId;
	params["memberName"] = memberName;
	params["joiningDate"] =joiningDate;
	params["buildingName"] =buildingName;
	params["wingName"] =wingName;
	params["floorNo"] = floorNo;
	params["flatNo"] = flatNo;
	params["address"] = address;
	
	params["methodName"] = "updateServantDetails";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	 	    {
	 			alert(data);
	 			if(document.empd)
	 			{
					document.getElementById("updateBtn").disabled=false;
	 				document.empd.reset();
	 			}
	 		}
	 	    ).error(function(jqXHR, textStatus, errorThrown){
	 	    	if(textStatus==="timeout") {
	 	    		$(loaderObj).hide();
	 	    		$(loaderObj).find('#errorDiv').show();
	 	    	}
	 	    });
}

//End UpdateServantDetails

function reset()
{
   document.empd.reset();
}

/*============= Update employee detail ========*/
function editEmployee(){
	

	
	if(document.empd1.firstName.value == "")
	{
		alert("Enter Employee First Name.");
		return false;
	}	
	var letterNumber = /^[a-zA-Z, ]+$/;
	if(document.empd1.firstName.value.match(letterNumber))
	{
		if(document.empd1.middleName.value == "")
		{
			alert("Enter Employee Middle Name.");
			return false;
		}	
		var letterNumber = /^[a-zA-Z, ]+$/;
		if(document.empd1.middleName.value.match(letterNumber))
		{
			if(document.empd1.lastName.value == "")
			{
				alert("Enter Employee Last Name.");
				return false;
			}	
			var letterNumber = /^[a-zA-Z, ]+$/;
			if(document.empd1.lastName.value.match(letterNumber))
			{
				
				
				var letterNumber = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  	        	 if(document.empd1.emailId.value.match(letterNumber) || document.empd1.emailId.value == null ||  document.empd1.emailId.value == "")
  	        	 {
	   	        	 
	   	        		 if ( document.empd1.salary.value == "" )
	   	        		 {
				         
				  	       alert("Please Enter Salary.");
				          return false;
	   	        		 }
	   	        		 var letterNumber = /^[0-9]+$/;
	   	        		 if(document.empd1.salary.value.match(letterNumber))
	   	        		 {
	   	        			 if ( document.empd1.contactNo.value == "" )
	   	        			 {
					  	       alert("Please Enter Contact Number");
					  	       return false;
	   	        			 }
	   	        			 var letterNumber = /^[0-9]{10}$/;
	   	        			 if(document.empd1.contactNo.value.match(letterNumber))
	   	        			 {
	   	        				if(document.empd1.address.value == "")
	   	        				{
	   	        					alert("Please Enter Employee Address.");
	   	        					return false;
	   	        				}	
	   	        				var letterNumber = /^[a-zA-Z0-9, ]+$/;
	   	        				if(document.empd1.address.value.match(letterNumber))
	   	        				{
	   	        					if ( document.empd1.zipCode.value == "" )
								    {
								         
								  	      alert("Please Enter Zip Code");
								          return false;
								    }
									var letterNumber = /^[0-9]{6}$/;
									if(document.empd1.zipCode.value.match(letterNumber))
									{
										updateEmployeeDetails();
										}
									else
										{
												alert("Enter 6 digit Numbers Only in zip code..!!");
												return false;
											}
										}
									
	   	        				else
									{
										alert("Enter Alphabates Only in address..!!");
										return false;
									}	
								}
										
	   	        			 else
								{
									alert("Enter 10 digit Numbers Only in contact number..!!");
									return false;
									}	
								}
										
	   	        		 else
							{
								alert("Enter Numbers Only in salary..!!");
								return false;
							}
						}
										
	   	        	 else
						{
							alert("Enter a Valid email adress..!!");
							return false;
						}
					}
																
			else
				{
					alert("Enter Alphabets Only in last name..!!");
					return false;
				}
			}
																
		else
			{
				alert("Enter Alphabets Only in middle name..!!");
				return false;
			}
		}
												
	else
		{
			alert("Enter Alphabets Only in first name..!!");
			return false;
		}
	
}
function updateEmployeeDetails(){
	
	document.empd1.btn.disabled = true;
	
	var input = document.getElementById('employee'),
    list = document.getElementById('emp_drop'),
    	i,fkRootEmpId;
	 		for (i = 0; i < list.options.length; ++i) {
			     if (list.options[i].value === input.value) {
			    	 fkRootEmpId = list.options[i].getAttribute('data-value');
			     }
	 		}
	
	//var customerId = document.getElementById("customerId").value;
	
	var firstName = $('#firstName').val();
	var middleName = $('#middleName').val();
	var lastName = $('#lastName').val();				
	var joiningDate = $('#newJoiningDate').val();
	var emailId = $('#emailId').val();
	var salary = $('#salary').val();
	var contactNo = $('#contactNo').val();
	var address = $('#address').val();
	var zipCode = $('#zipCode').val();
	var oldJoiningDate = $('#joiningDate').val();

	
	
	var params = {};
	
	params["EmployeeId"] = fkRootEmpId;
	params["firstName"] = firstName;	
	params["middleName"] = middleName;
	params["lastName"] = lastName;
	params["joiningDate"] = joiningDate;
	params["emailId"] =emailId;
	params["salary"] = salary;
	params["contactNo"] = contactNo;
	params["address"] = address;
	params["zipCode"] = zipCode;
	params["oldJoiningDate"] = oldJoiningDate;
	
	
	params["methodName"] = "updateEmployeeDetails";

	$.post('/Shop/jsp/utility/controller.jsp',params,function(data){
			alert(data);
				if(document.empd1)
				{
					document.empd1.reset();
				}	
				document.empd1.btn.disabled =false;
			}
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		
 	    		/*alert("Data Added Successfully..");
 	    		location.reload();
 				document.ccd.btn.disabled =false;*/
 	    		
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});


}	


// Validation for Employee  Report
function getEmployeeDetailsReportValidation()
{
	var employeeName= $('#fk_employee_id').val();
	
	if(employeeName=="")
	{
		alert("Please Select Employee Name");
		return false;
	}
	getEmployeeDetailsReport();
}

//************ Employee Report **************//*

function getEmployeeDetailsReport(){
	var params= {};
	var employeeName= $('#fk_employee_id').val();
	
	var input1 = document.getElementById('fk_employee_id'),
	list = document.getElementById('employeeNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkEmployeeid = list.options[i].getAttribute('data-value');
		}
	}
	
	params["employeeName"]= employeeName;
	params["methodName"] = "getEmployeeReport";
	
	$.post('/embelSoft/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear table
		$('#empDetails').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#empDetails').DataTable( {

				"bPaginate": false,

				
				fnRowCallback : function(nRow, aData, iDisplayIndex){
					$("th:first", nRow).html(iDisplayIndex +1);
					return nRow;
				},

				"footerCallback": function ( row, data, start, end, display ) {
					var api = this.api(), data;

					// Remove the formatting to get integer data for summation
					var intVal = function ( i ) {
						return typeof i === 'string' ?
								i.replace(/[\$,]/g, '')*1 :
									typeof i === 'number' ?
											i : 0;
					};

					// Total over this page
					pageTotal = api
					.column( 5 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 5 ).footer() ).html(

							'Rs'+' '+parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);
				},

				destroy: true,
				searching: true,			      
				columns: [
				          {"data": "firstName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "middleName", "width": "5%" ,"defaultContent": ""},
				          {"data": "lastName", "width": "5%" ,"defaultContent": ""},
				          {"data": "dob", "width": "5%" ,"defaultContent": ""},
				          {"data": "idNumber" , "width": "5%" ,"defaultContent": ""},
				          {"data": "designation" , "width": "5%" ,"defaultContent": ""},
				          {"data": "contactNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "altContactNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "emailId" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "currentAddress", "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "education", "width": "5%" ,"defaultContent": ""},
				          {"data": "technology" , "width": "5%" ,"defaultContent": ""},
				          {"data": "previousExperience" , "width": "5%" ,"defaultContent": ""},
				          {"data": "salary" , "width": "5%" ,"defaultContent": ""},
				          {"data": "referenceBy" , "width": "5%" ,"defaultContent": ""},
				          {"data": "interviewedBy" , "width": "5%" ,"defaultContent": ""},
				          {"data": "dateOfJoining", "width": "5%" ,"defaultContent": ""},
				          {"data": "prevCompanyName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "zipCode" , "width": "5%" ,"defaultContent": ""},
				          {"data": "confirmEmail" , "width": "5%" ,"defaultContent": ""},
				          {"data": "comment" , "width": "5%" ,"defaultContent": ""},
				          {"data": "employeeCondition" , "width": "5%" ,"defaultContent": ""},
				          {"data": "adharNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "panNumber" , "width": "5%" ,"defaultContent": ""},
				          {"data": "department" , "width": "5%" ,"defaultContent": ""},
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Employee Details Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		
		var mydata = catmap;
		$('#empDetails').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}


// List Of Servent 
function serventList()
{
	var params= {};

	params["methodName"] = "getAllServentList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#serventDetails').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;


		$(document).ready(function() {
			$('#serventDetails').DataTable({
				
				"bPaginate": false,

				fnRowCallback : function(nRow, aData, iDisplayIndex){
					$("th:first", nRow).html(iDisplayIndex +1);
					return nRow;
				},

				"footerCallback": function ( row, data, start, end, display ) {
					var api = this.api(), data;

					// Remove the formatting to get integer data for summation
					var intVal = function ( i ) {
						return typeof i === 'string' ?
								i.replace(/[\$,]/g, '')*1 :
									typeof i === 'number' ?
											i : 0;
									
					};

				},

				destroy: true,
				searching: true,			      
				columns: [
							  {"data": "srNo" , "width": "3%" ,"defaultContent": ""},	
					          {"data": "firstName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "middleName", "width": "5%" ,"defaultContent": ""},
					          {"data": "lastName", "width": "5%" ,"defaultContent": ""},
					          {"data": "contactNo" , "width": "5%" ,"defaultContent": ""},
					          {"data": "address" , "width": "10%" ,"defaultContent": ""},
					          {"data": "altContactNo" , "width": "5%" ,"defaultContent": ""},
					          {"data": "memberName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "wingName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "buildingName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "floorNo" , "width": "5%" ,"defaultContent": ""},
					          {"data": "flatNo" , "width": "5%" ,"defaultContent": ""},
			        
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Servent Details List";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Servent Details List";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Servent Details List";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Servent Details List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#serventDetails').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}



//edit Employee Detailas
function getEmployeeDetailasForEdit()
{
	
	
	$("#firstName").append($("<input/>").attr("value","").text());
	$("#middleName").append($("<input/>").attr("value","").text());
	$("#lastName").append($("<input/>").attr("value","").text());
	$("#dob").append($("<input/>").attr("value","").text());
	$("#idNumber").append($("<input/>").attr("value","").text());
	$("#designation").append($("<input/>").attr("value","").text());
	$("#contactNo").append($("<input/>").attr("value","").text());
	$("#altContactNo").append($("<input/>").attr("value","").text());
	$("#adharNumber").append($("<input/>").attr("value","").text());
	$("#panNumber").append($("<input/>").attr("value","").text());
	$("#emailId").append($("<input/>").attr("value","").text());
	$("#address").append($("<input/>").attr("value","").text());
	$("#education").append($("<input/>").attr("value","").text());
	$("#technology").append($("<input/>").attr("value","").text());
	$("#previousExperience").append($("<input/>").attr("value","").text());
	$("#salary").append($("<input/>").attr("value","").text());
	$("#referenceBy").append($("<input/>").attr("value","").text());
	$("#interviewedBy").append($("<input/>").attr("value","").text());
	$("#dateOfJoining").append($("<input/>").attr("value","").text());
	$("#department").append($("<input/>").attr("value","").text());
	$("#prevCompanyName").append($("<input/>").attr("value","").text());
	$("#zipCode").append($("<input/>").attr("value","").text());
	$("#confirmEmail").append($("<input/>").attr("value","").text());
	$("#comment").append($("<input/>").attr("value","").text());
	$("#employeecondition").append($("<input/>").attr("value","").text());
	$("#placeofposting").append($("<input/>").attr("value","").text());
	
	
	var params= {};
	var employeeName= $('#fk_employee_id').val();
	
	var input1 = document.getElementById('fk_employee_id'),
	list = document.getElementById('employeeNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkEmployeeid = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkEmployeeid"] = fkEmployeeid;
	params["employeeName"] = employeeName;
	params["methodName"] = "getEmployeeDetailsForEdit";
	
	$.post('/embelSoft/jsp/utility/controller.jsp',params,function(data){
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		$.each(jsonData,function(i,v)
				
				
				{
				
				  document.getElementById("firstName").value = v.firstName;
			      document.getElementById("middleName").value = v.middleName;
			      document.getElementById("lastName").value = v.lastName;
			      document.getElementById("dob").value = v.dob;
			      document.getElementById("idNumber").value = v.idNumber;
			      document.getElementById("designation").value = v.designation;
			      
			      document.getElementById("contactNo").value = v.contactNo;
			      document.getElementById("altContactNo").value = v.altContactNo;
			      document.getElementById("adharNumber").value = v.adharNo;
			      document.getElementById("panNumber").value = v.panNumber;
			      document.getElementById("emailId").value = v.emailId;
			      
			      document.getElementById("address").value = v.address;
			      document.getElementById("education").value = v.education;
			      document.getElementById("technology").value = v.technology;
			      document.getElementById("previousExperience").value = v.previousExperience;
			      document.getElementById("salary").value = v.salary;
			      
			      document.getElementById("referenceBy").value = v.referenceBy;
			      document.getElementById("interviewedBy").value = v.interviewedBy;
			      document.getElementById("dateOfJoining").value = v.dateOfJoining;
			      document.getElementById("department").value = v.department;
			      document.getElementById("prevCompanyName").value = v.prevCompanyName;
			      
			      document.getElementById("zipCode").value = v.zipCode;
			      document.getElementById("confirmEmail").value = v.confirmEmail;
			      document.getElementById("comment").value = v.comment;
			      document.getElementById("employeecondition").value = v.employeeCondition;
			      document.getElementById("placeofposting").value = v.placeOfPosting;
			      
			   
		      
				});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
 	    	
}

//update Employee Details
function updateEmployeeDetailas()
{
	var params= {};
	var employeeName= $('#fk_employee_id').val();
	
	var input1 = document.getElementById('fk_employee_id'),
	list = document.getElementById('employeeNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkEmployeeid = list.options[i].getAttribute('data-value');
		}
	}
	
	var firstName= $('#firstName').val();
	var middleName= $('#middleName').val();
	var lastName= $('#lastName').val();
	var dob= $('#dob').val();
	var idNumber= $('#idNumber').val();
	var designation= $('#designation').val();
	var contactNo= $('#contactNo').val();
	var altContactNo= $('#altContactNo').val();
	var adharNumber= $('#adharNumber').val();
	var panNumber= $('#panNumber').val();
	var emailId= $('#emailId').val();
	var address= $('#address').val();
	var education= $('#education').val();
	var technology= $('#technology').val();
	var previousExperience= $('#previousExperience').val();
	var salary= $('#salary').val();
	var referenceBy= $('#referenceBy').val();
	var interviewedBy= $('#interviewedBy').val();
	var dateOfJoining= $('#dateOfJoining').val();
	var department= $('#department').val();
	var prevCompanyName= $('#prevCompanyName').val();
	var zipCode= $('#zipCode').val();
	var confirmEmail= $('#confirmEmail').val();
	var comment= $('#comment').val();
	var employeecondition= $('#employeecondition').val();
	var placeofposting= $('#placeofposting').val();
	
	params["fkEmployeeid"] = fkEmployeeid;
	
	
	params["firstName"] = firstName;
	params["middleName"] =middleName;
	params["lastName"] =lastName;
	params["dob"] = dob;
	params["idNumber"] =idNumber;
	params["designation"] =designation;
	params["contactNo"] =contactNo;
	params["altContactNo"] =altContactNo;
	params["emailId"] = emailId;
	params["address"] = address;
	params["education"] = education;
	params["technology"] = technology;
	params["previousExperience"] =previousExperience;
	params["salary"] =salary;
	params["referenceBy"] =referenceBy;
	params["interviewedBy"] =interviewedBy;
	params["dateOfJoining"] =dateOfJoining;
	params["prevCompanyName"] =prevCompanyName;
	params["zipCode"] = zipCode;
	params["confirmEmail"] =confirmEmail;
	params["comment"] =comment;
	params["employeecondition"] =employeecondition;
	params["adharNumber"] =adharNumber;
	params["panNumber"] =panNumber;
	params["department"]=department;
	params["placeofposting"]=placeofposting;
	
	params["methodName"] = "updateEmployeeDetails";
	
 	$.post('/embelSoft/jsp/utility/controller.jsp',params,function(data)
 	    	{
 				alert(data);
 				if(document.empd)
 				{
 					document.empd.reset();
 				}	
 				document.empd.btn.disabled =false;
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
document.empd.reset();	

}



//Validation for Previous Employee  Report
function getExEmployeeDetailsReportValidation()
{
	var employeeName= $('#fk_employee_id').val();
	
	if(employeeName=="")
	{
		alert("Please Select Employee Name");
		return false;
	}
	getExEmployeeDetailsReport();
}

//************ Previous Employee Report **************//*

function getExEmployeeDetailsReport(){
	var params= {};
	var employeeName= $('#fk_employee_id').val();
	
	var input1 = document.getElementById('fk_employee_id'),
	list = document.getElementById('employeeNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkEmployeeid = list.options[i].getAttribute('data-value');
		}
	}
	
	params["employeeName"]= employeeName;
	params["methodName"] = "getExEmployeeReport";
	
	$.post('/embelSoft/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear table
		$('#exEmpDetails').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#exEmpDetails').DataTable( {

				"bPaginate": false,

				
				fnRowCallback : function(nRow, aData, iDisplayIndex){
					$("th:first", nRow).html(iDisplayIndex +1);
					return nRow;
				},

				"footerCallback": function ( row, data, start, end, display ) {
					var api = this.api(), data;

					// Remove the formatting to get integer data for summation
					var intVal = function ( i ) {
						return typeof i === 'string' ?
								i.replace(/[\$,]/g, '')*1 :
									typeof i === 'number' ?
											i : 0;
					};

					// Total over this page
					pageTotal = api
					.column( 5 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 5 ).footer() ).html(

							'Rs'+' '+parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);
				},

				destroy: true,
				searching: true,			      
				columns: [
				          {"data": "firstName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "middleName", "width": "5%" ,"defaultContent": ""},
				          {"data": "lastName", "width": "5%" ,"defaultContent": ""},
				          {"data": "dob", "width": "5%" ,"defaultContent": ""},
				          {"data": "idNumber" , "width": "5%" ,"defaultContent": ""},
				          {"data": "designation" , "width": "5%" ,"defaultContent": ""},
				          {"data": "contactNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "altContactNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "emailId" , "width": "5%" ,"defaultContent": ""},
				          {"data": "address", "width": "5%" ,"defaultContent": ""},
				          {"data": "education", "width": "5%" ,"defaultContent": ""},
				          {"data": "technology" , "width": "5%" ,"defaultContent": ""},
				          {"data": "previousExperience" , "width": "5%" ,"defaultContent": ""},
				          {"data": "salary" , "width": "5%" ,"defaultContent": ""},
				          {"data": "referenceBy" , "width": "5%" ,"defaultContent": ""},
				          {"data": "interviewedBy" , "width": "5%" ,"defaultContent": ""},
				          {"data": "dateOfJoining", "width": "5%" ,"defaultContent": ""},
				          {"data": "prevCompanyName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "zipCode" , "width": "5%" ,"defaultContent": ""},
				          {"data": "confirmEmail" , "width": "5%" ,"defaultContent": ""},
				          {"data": "comment" , "width": "5%" ,"defaultContent": ""},
				          {"data": "employeeCondition" , "width": "5%" ,"defaultContent": ""},
				          {"data": "adharNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "panNumber" , "width": "5%" ,"defaultContent": ""},
				          {"data": "department" , "width": "5%" ,"defaultContent": ""},
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Previous Employee Details Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		
		var mydata = catmap;
		$('#exEmpDetails').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}


function validationEmployeeLeaveDetails()
{
	var employeeName= $('#fk_employee_id').val();
	var leaveDateFrom= $('#leaveDateFrom').val();
	var type= $('#type').val();
	var leaveDateTo= $('#leaveDateTo').val();
	
	
	if(employeeName=="" || employeeName==null)
	{
		alert("please Select Employee Name");
		return flase;
	}
	
	if(leaveDateFrom=="" || leaveDateFrom==null)
	{
		alert("please Select LeaveDateFrom");
		return flase;
	}
	
	if(type=="" || type==null)
	{
		alert("please Select Type");
		return flase;
	}
	
	
	if(leaveDateTo=="" || leaveDateTo==null)
	{
		alert("please Select LeaveDate To");
		return flase;
	}
	
	
	employeeLeaveDetails();
}

function employeeLeaveDetails()
{
	var params= {};
	var employeeName= $('#fk_employee_id').val();
	
	var input1 = document.getElementById('fk_employee_id'),
	list = document.getElementById('employeeNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
			fkEmployeeid = list.options[i].getAttribute('data-value');
		}
	}
	
	var leaveDateFrom= $('#leaveDateFrom').val();
	var type= $('#type').val();
	var leaveDateTo= $('#leaveDateTo').val();
	var description= $('#description').val();
	var approvedBy= $('#approvedBy').val();

	
	if(description=="" || description==null)
	{
		description="N/A";
	}
	
	
	if(approvedBy=="" || approvedBy==null)
	{
		approvedBy="N/A";
	}
	
	params["fkEmployeeid"] = fkEmployeeid;
	params["employeeName"] = employeeName;
	params["leaveDateFrom"] = leaveDateFrom;
	params["type"] = type;
	params["leaveDateTo"] = leaveDateTo;
	params["description"] = description;
	params["approvedBy"] = approvedBy;
	
	
	params["methodName"] = "employeeLeaveDetails";
	
 	$.post('/embelSoft/jsp/utility/controller.jsp',params,function(data)
 	    	{
 				alert(data);
 				if(document.empd)
 				{
 					document.empd.reset();
 				}	
 				document.empd.btn.disabled =false;
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
document.empd.reset();	

}



//List Of Employee Leave Details 
function employeeLeaveList()
{
	var params= {};

	params["methodName"] = "getAllEmployeeLeaveList";
	$.post('/embelSoft/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#empLeaveDetails').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#empLeaveDetails').DataTable( {
				
				"bPaginate": false,

				fnRowCallback : function(nRow, aData, iDisplayIndex){
					$("th:first", nRow).html(iDisplayIndex +1);
					return nRow;
				},

				"footerCallback": function ( row, data, start, end, display ) {
					var api = this.api(), data;

					// Remove the formatting to get integer data for summation
					var intVal = function ( i ) {
						return typeof i === 'string' ?
								i.replace(/[\$,]/g, '')*1 :
									typeof i === 'number' ?
											i : 0;
									
					};

					// Total over this page
					pageTotal = api
					.column( 5 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
			/*		$( api.column( 5 ).footer() ).html(

							'Rs'+' '+parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);*/
					
				},

				destroy: true,
				searching: true,			      
				columns: [
				          {"data": "employeeName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "leaveDateFrom", "width": "5%" ,"defaultContent": ""},
				          {"data": "leaveDateTo", "width": "5%" ,"defaultContent": ""},
				          {"data": "Type", "width": "5%" ,"defaultContent": ""},
				          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				          {"data": "approvedBy" , "width": "5%" ,"defaultContent": ""},
				         
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Employee Leave List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#empLeaveDetails').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}

// Validation Report Of Employee Leave Details 
function employeeLeaveReportValidation()
{
	var employeeName= $('#fk_employee_id').val();

	if(employeeName=="" || employeeName==null)
	{
		alert("Please Select Employee Name");
		return false;
	}
	employeeLeaveReport();
}




//Report Of Employee Leave Details 
function employeeLeaveReport()
{
	var params= {};
	
	var employeeName= $('#fk_employee_id').val();

	
	var input1 = document.getElementById('fk_employee_id'),
	list = document.getElementById('employeeNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
		fkEmployeeid = list.options[i].getAttribute('data-value');
		}
	}
	
	
	params["fkEmployeeid"] = fkEmployeeid;
	params["employeeName"] = employeeName;
	

	params["methodName"] = "getAllEmployeeLeaveReport";
	$.post('/embelSoft/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#empLeaveDetails').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#empLeaveDetails').DataTable( {
				
				"bPaginate": false,

				fnRowCallback : function(nRow, aData, iDisplayIndex){
					$("th:first", nRow).html(iDisplayIndex +1);
					return nRow;
				},

				"footerCallback": function ( row, data, start, end, display ) {
					var api = this.api(), data;

					// Remove the formatting to get integer data for summation
					var intVal = function ( i ) {
						return typeof i === 'string' ?
								i.replace(/[\$,]/g, '')*1 :
									typeof i === 'number' ?
											i : 0;
									
					};
					
				},

				destroy: true,
				searching: true,			      
				columns: [
				          {"data": "employeeName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "leaveDateFrom", "width": "5%" ,"defaultContent": ""},
				          {"data": "leaveDateTo", "width": "5%" ,"defaultContent": ""},
				          {"data": "Type", "width": "5%" ,"defaultContent": ""},
				          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				          {"data": "approvedBy" , "width": "5%" ,"defaultContent": ""},
				         
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Employee Leave List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#empLeaveDetails').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}

// get memeber flat details 
function getDetailsOfMwmber()
{
	$("#buildingName").append($("<input/>").attr("value","").text());
	$("#wingName").append($("<input/>").attr("value","").text());
	$("#floorNo").append($("<input/>").attr("value","").text());
	$("#flatNo").append($("<input/>").attr("value","").text());
	
	var params= {};
	
	var input1 = document.getElementById('fk_member_id'),
	list = document.getElementById('memeberNameList'),
	i,fkMemberid;
	for (i = 0; i < list.options.length; ++i)
	{
		if (list.options[i].value === input1.value) 
		{
			fkMemberid = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkMemberid"] = fkMemberid;
	
	params["methodName"] = "getMemberDetailsForComOrEnq";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
				var jsonData = $.parseJSON(data);
				var catmap = jsonData.list;
	
				$.each(jsonData,function(i,v)
			{
				  document.getElementById("buildingName").value = v.buildingName;
			      document.getElementById("wingName").value = v.wingName;
			      document.getElementById("floorNo").value = v.floorNo;
			      document.getElementById("flatNo").value = v.flatNo;
			      
			});
		}).error(function(jqXHR, textStatus, errorThrown){
			if(textStatus==="timeout") {

			}
		});
			
}





