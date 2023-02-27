function vendorDetailValidation()
{	
	if(document.vendorForm.firstName.value == "")
	{
		alert("Enter Vendor first name.");
		return false;
	}	
	var letterNumber = /^[a-zA-Z, ]+$/;
	if(document.vendorForm.firstName.value.match(letterNumber))
	{
		if(document.vendorForm.lastName.value == "")
		{
			alert("Enter Vendor last name.");
			return false;
		}	
		var letterNumber = /^[a-zA-Z, ]+$/;
		if(document.vendorForm.lastName.value.match(letterNumber))
		{		
			if ( document.vendorForm.enquiryDate.value == "" )
		    {
		  	       alert("Please Select Date");
		          return false;
		    }
			 if ( document.vendorForm.contactNo.value == "" )
			 {
		       alert("Please Enter Contact Number");
		       return false;
			 }
			 if(document.vendorForm.contactNo.value.length == 10)
			 {
			 var letterNumberCn = /^[0-9]{10}$/;
			 if(document.vendorForm.contactNo.value.match(letterNumberCn))
			 {
			 	if(document.vendorForm.address.value == "")
				{
					alert("Please Enter Vendor Address.");
					return false;
				}	
				var letterNumber = /^[a-zA-Z0-9, ]+$/;
				/*if(document.vendorForm.address.value.match(letterNumber))
				{*/
				 
					/*if(document.vendorForm.companyName.value == "")
					{
						alert("Enter Company Name.");
						return false;
					}
					var letterNumber = /^[a-zA-Z, ]+$/;
					if(document.vendorForm.companyName.value.match(letterNumber))
					{
					
						if(document.vendorForm.companyAddress.value == "")
						{
							alert("Enter Company Address.");
							return false;
						}
						var letterNumber = /^[a-zA-Z, ]+$/;
						if(document.vendorForm.companyName.value.match(letterNumber))
						{*/
							/*if(document.vendorForm.contactPersonName.value == "")
							{
								alert("Enter Contact Person Name.");
								return false;
							}	*/
							var letterNumber = /^[a-zA-Z, ]+$/;
				   			 /*if(document.vendorForm.contactPersonName.value.match(letterNumber))
				   			 {*/
				   				if(document.vendorForm.companyNumber.value == "")
				   				{
				   					alert("Enter Company Number.");
				   					return false;
				   				}	
				   				 var letterNumber = /^[0-9]{10}$/;
				   	   			 if(document.vendorForm.companyNumber.value.match(letterNumber))
				   	   			 {
				   							 
				   					if ( document.vendorForm.emailId.value == "" )
								    {
								  	       alert("Please Enter Email Id");
								  	       return false;
								    }
					   				 var letterNumber = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
					  	        	 if(document.vendorForm.emailId.value.match(letterNumber) || document.vendorForm.emailId.value == null ||  document.vendorForm.emailId.value == "")
					  	        	 {
				  	       
	   				 
						   				 if ( document.vendorForm.PANNum.value == "" )
						        		  {
								  	        alert("Please Enter Pan Number");
								  	        return false;
						        		  } 
						   				   var letterNumber = /^[a-zA-Z0-9, ]+$/;
				  	        			   if(document.vendorForm.PANNum.value.match(letterNumber))
					  	        			   {
					  	        				   	vendorDetails();
				  	        			   }
								
						  		 		else
										{
											alert("Enter a Valid Pan Number..!!");
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
								alert("Enter 10 digit Numbers Only in Company Number..!!");
								return false;
							}
						/*}
		   			 	else
						{
							alert("Enter Alphabets Only in Contact Person Name..!!")
							return false;
						}*/
					}
									
					/*else
					{
						alert("Enter Alphabates Only in Company Address..!!");
						return false;
					}	
				}
				else
					{
						alert("Enter Alphabets Only in Company Name..!!");
						return false;
					}
				}
			*/
				else
				{
					alert("Enter Alphabates Only in Address..!!");
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
				alert("Enter Alphabets Only in Vendor last name..!!");
				return false;
			}
		}												
		else
		{
			alert("Enter Alphabets Only in Vendor first name..!!");
			return false;
		}
	}	

function vendorDetails()
{	
	//document.vendorForm.btn.disabled = true;

				var firstName = $('#firstName').val();
				var middleName = $('#middleName').val();
				var lastName = $('#lastName').val();
				var enquiryDate = $('#enquiryDate').val();
				var contactNo  = $('#contactNo').val();
				var address = $('#address').val();
				var emailId = $('#emailId').val();
				var zipCode = $('#zipCode').val();
				var country = $('#country').val();
				var state = $('#state').val();
				var PANNum = $('#PANNum').val();
				var CIMNo = $('#CIMNo').val();
				var gstInNo = $('#gstInNo').val();
				
				var alternateContactNo = $('#alternateContactNumber').val();
				var contactPersonName = $('#contactPersonName').val();
				var companyName = $('#companyName').val();
				var emengencyContactNo = $('#emergenctContactNumber').val();
				var companyAddress = $('#companyAddress').val();
				//var permanentAddress = $('#permanentAddress').val();
				var companyNumber = $('#companyNumber').val();
				
				
				var params = {};
				
				params["alternateContactNo"] = alternateContactNo;
				params["contactPersonName"] = contactPersonName;
				params["companyName"] = companyName;
				params["emengencyContactNo"] = emengencyContactNo;
				params["companyAddress"] = companyAddress;
				//params["permanentAddress"] = permanentAddress;
				params["companyNumber"] = companyNumber;
				
				
				params["firstName"] = firstName;
				params["middleName"] = middleName;
				params["lastName"] = lastName;
			
				params["enquiryDate"] = enquiryDate;
				params["contactNo"] =contactNo;
				params["address"] = address;
				params["emailId"] = emailId;
				params["zipCode"] =zipCode;
				params["country"] =country;
				params["state"] = state;
				params["PANNum"] =PANNum;
				params["CIMNo"] =CIMNo;
				params["gstInNo"] = gstInNo;
				
				params["methodName"] = "vendorDetailsM";
			 	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			 			{
					 		alert(data);
					 		location.reload();
	 			}
	 	
	 	    	).error(function(jqXHR, textStatus, errorThrown){
	 	    		if(textStatus==="timeout") {
	 	    			$(loaderObj).hide();
	 	    			$(loaderObj).find('#errorDiv').show();
	 	    		}
	 	    	})
	}


//////////////////////Reports///////////////////////////

//************ Client Enquiry Report **************//*
//****** Between Two dates **********//*

function getClientDetailsBetTwoDays(){
	var params= {};
	var clientName= $('#fk_client_id').val();
	var fisDate = $("#fisDate").val();
	var endDate = $("#endDate").val();

	var input1 = document.getElementById('fk_client_id'),
	list = document.getElementById('clientNameList'),
	i,fkClientId;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkClientId = list.options[i].getAttribute('data-value');
		}
	}
	
	params["clientName"]= clientName;
	params["fisDate"]= fisDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getClientReportBetweenTwoDates";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear table
		$('#clientBetweenTwoDates').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#clientBetweenTwoDates').DataTable( {

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
			          {"data": "enquiryDate", "width": "5%" ,"defaultContent": ""},
			          {"data": "contactNo" , "width": "5%" ,"defaultContent": ""},
			          {"data": "address", "width": "5%" ,"defaultContent": ""},
			          {"data": "emailId" , "width": "5%" ,"defaultContent": ""},
			          {"data": "comment" , "width": "5%" ,"defaultContent": ""},
			          {"data": "referenceBy" , "width": "5%" ,"defaultContent": ""},
			          
			        
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Double Date Wise Client Enquiry Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );
		var mydata = catmap;
		$('#clientBetweenTwoDates').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}


function vendorList()
{
	var params= {};

	params["methodName"] = "getAllVendorList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{		
		$('#list').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#list').DataTable( {

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

					/*// Total over this page
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
					console.log( pageTotal);*/
				},

				destroy: true,
				searching: true,			      
				columns: [
						      {"data": "srNo" , "width": "5%" ,"defaultContent": ""},
					          {"data": "firstName" , "width": "10%" ,"defaultContent": ""},
					          {"data": "middleName" , "width": "10%" ,"defaultContent": ""},
					          {"data": "lastName" , "width": "10%" ,"defaultContent": ""},
					          {"data": "enquiryDate", "width": "8%" ,"defaultContent": ""},
					          {"data": "contactNo", "width": "5%" ,"defaultContent": ""},
					          {"data": "address", "width": "10%" ,"defaultContent": ""},
					          {"data": "zipCode" , "width": "5%" ,"defaultContent": ""},
					          {"data": "emailId" , "width": "5%" ,"defaultContent": ""},
					          {"data": "country" , "width": "5%" ,"defaultContent": ""},
					          {"data": "state" , "width": "5%" ,"defaultContent": ""},
					          {"data": "PANNum" , "width": "5%" ,"defaultContent": ""},
					          {"data": "CIMNo", "width": "5%" ,"defaultContent": ""},
					          {"data": "gstInNo", "width": "5%" ,"defaultContent": ""},
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Details Report";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Vendor Details Report";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Vendor Details Report";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Details Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#list').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			
			});
}


// get Vendor Details for Edit
function getVendorListForEdit()
{
	
	$("#firstName").append($("<input/>").attr("value","").text());
	$("#middleName").append($("<input/>").attr("value","").text());
	$("#lastName").append($("<input/>").attr("value","").text());
	
	$("#enquiryDate").append($("<input/>").attr("value","").text());
	$("#contactNo").append($("<input/>").attr("value","").text());
	$("#address").append($("<input/>").attr("value","").text());
	$("#alternateContactNumber").append($("<input/>").attr("value","").text());
	$("#emergenctContactNumber").append($("<input/>").attr("value","").text());
	$("#companyName").append($("<input/>").attr("value","").text());
	$("#companyAddress").append($("<input/>").attr("value","").text());
	$("#contactPersonName").append($("<input/>").attr("value","").text());
	$("#companyNumber").append($("<input/>").attr("value","").text());
	$("#zipCode").append($("<input/>").attr("value","").text());
	$("#emailId").append($("<input/>").attr("value","").text());
	$("#country").append($("<input/>").attr("value","").text());
	$("#state").append($("<input/>").attr("value","").text());
	$("#PANNum").append($("<input/>").attr("value","").text());
	$("#CIMNo").append($("<input/>").attr("value","").text());
	$("#gstInNo").append($("<input/>").attr("value","").text());
	$("#permanentAddress").append($("<input/>").attr("value","").text());
	
	
	
	var params= {};
	
	var input1 = document.getElementById('fk_vendor_id'),
	list = document.getElementById('vendorNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkEmployeeid = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fk_vendor_id"] = fkEmployeeid;
	params["methodName"] = "getVendorDetailsForEdit";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data){
		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		$.each(jsonData,function(i,v)
				
				{
			
			
				  document.getElementById("firstName").value = v.firstName;
				  document.getElementById("middleName").value = v.middleName;
				  document.getElementById("lastName").value = v.lastName;
				  document.getElementById("enquiryDate").value = v.enquiryDate;
			      document.getElementById("contactNo").value = v.contactNo;
			      document.getElementById("address").value = v.address;
			      document.getElementById("alternateContactNumber").value = v.alternateContactNo;
			      document.getElementById("emergenctContactNumber").value = v.emergencyContactNo;
			      document.getElementById("companyName").value = v.companyName;
			      document.getElementById("companyAddress").value = v.companyAddress;
			      document.getElementById("contactPersonName").value = v.contactPersonName;
			      document.getElementById("companyNumber").value = v.companyNumber;
			      document.getElementById("zipCode").value = v.zipCode;
			      document.getElementById("emailId").value = v.emailId;
			      document.getElementById("country").value = v.country;
			      document.getElementById("state").value = v.state;
			      document.getElementById("PANNum").value = v.PANNum;
			      document.getElementById("CIMNo").value = v.CIMNo;
			      document.getElementById("gstInNo").value = v.gstInNo;
			      document.getElementById("permanentAddress").value = v.permanentAddress;
			     
		      
				});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
 	    	
}

// update Vendor Details
function updateVendorDetail()
{
	
	var params= {};
	
	var input1 = document.getElementById('fk_vendor_id'),
	list = document.getElementById('vendorNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkVendorid = list.options[i].getAttribute('data-value');
		}
	}
	
	var vendorName = $('#fk_vendor_id').val();
	
	var firstName = $('#firstName').val();
	var middleName = $('#middleName').val();
	var lastName = $('#lastName').val();
	
	var enquiryDate = $('#enquiryDate').val();
	var contactNo  = $('#contactNo').val();
	var address = $('#address').val();
	var emailId = $('#emailId').val();
	var zipCode = $('#zipCode').val();
	var country = $('#country').val();
	var state = $('#state').val();
	var PANNum = $('#PANNum').val();
	var CIMNo = $('#CIMNo').val();
	var gstInNo = $('#gstInNo').val();
	var alternateContactNo = $('#alternateContactNumber').val();
	var contactPersonName = $('#contactPersonName').val();
	var companyName = $('#companyName').val();
	var emengencyContactNo = $('#emergenctContactNumber').val();
	var companyAddress = $('#companyAddress').val();
	//var permanentAddress = $('#permanentAddress').val();
	var companyNumber = $('#companyNumber').val();
	

	
	params["vendorName"] = vendorName;
	
	params["firstName"] = firstName;
	params["middleName"] = middleName;
	params["lastName"] = lastName;
	
	params["fkVendorid"] = fkVendorid;
	params["enquiryDate"] = enquiryDate;
	params["contactNo"] =contactNo;
	params["address"] = address;
	params["emailId"] = emailId;
	params["zipCode"] =zipCode;
	params["country"] =country;
	params["state"] = state;
	params["PANNum"] =PANNum;
	params["CIMNo"] =CIMNo;
	params["gstInNo"] = gstInNo;
	params["alternateContactNo"] = alternateContactNo;
	params["contactPersonName"] = contactPersonName;
	params["companyName"] = companyName;
	params["emengencyContactNo"] = emengencyContactNo;
	params["companyAddress"] = companyAddress;
	//params["permanentAddress"] = permanentAddress;
	params["companyNumber"] = companyNumber;
	
	params["methodName"] = "updateVendorDetails";
 	$.post('/society/jsp/utility/controller.jsp',params,function(data)
 			{
 		alert(data);
 		location.reload();
		}

 	).error(function(jqXHR, textStatus, errorThrown){
 		if(textStatus==="timeout") {
 			$(loaderObj).hide();
 			$(loaderObj).find('#errorDiv').show();
 		}
 	})
}


