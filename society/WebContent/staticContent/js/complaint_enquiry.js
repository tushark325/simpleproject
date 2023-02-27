function getDetailsOfMwmber()
{
	$("#buildingName").append($("<input/>").attr("value","").text());
	$("#wingName").append($("<input/>").attr("value","").text());
	$("#floorNo").append($("<input/>").attr("value","").text());
	$("#flatNo").append($("<input/>").attr("value","").text());
	$("#email").append($("<input/>").attr("value","").text());
	
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
			      document.getElementById("email").value = v.emailId;
			      
			});
		}).error(function(jqXHR, textStatus, errorThrown){
			if(textStatus==="timeout") {

			}
		});
			
}

// get description
function getDescriptionOfMember()
{
	/*$("#typeList_Drop").empty();
	$("#typeList_Drop").append($("<option></option>").attr("value","").text("Select Type"));
*/
	$("#typeForFollwUp").append($("<input/>").attr("value","").text());
	$("#emailId").append($("<input/>").attr("value","").text());
	$("#description2").append($("<input/>").attr("value","").text());
	
	var params= {};
	
	var input1 = document.getElementById('fk_member_id2'),
	list = document.getElementById('memberNameList2'),
	i,fkMemberid2;
	for (i = 0; i < list.options.length; ++i)
	{
		if (list.options[i].value === input1.value) 
		{
			fkMemberid2 = list.options[i].getAttribute('data-value');
		}
	}
	
	var memberName  = $('#fk_member_id2').val();
	if(fkMemberid2 == "" || fkMemberid2 == null || fkMemberid2 == undefined)
	{
		fkMemberid = "0";
	}
	
	var CNoSelected = document.getElementById("complaintNo");
	var CNoValue = CNoSelected.options[CNoSelected.selectedIndex].value;
	
	params["CNoValue"] = CNoValue;
	params["fkMemberid"] = fkMemberid2;
	params["memberName"] = memberName;
	
	params["methodName"] = "getMemberDescription";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$.each(jsonData,function(i,v)
		{
			  document.getElementById("emailId").value = v.email;
			  document.getElementById("description2").value = v.description;
			  document.getElementById("typeForFollwUp").value = v.type;
				  
			});
		}).error(function(jqXHR, textStatus, errorThrown){
			if(textStatus==="timeout") {

			}
		});
}

/*
function clientEnquiryDetail()
{
	
	if(document.clientEnqForm.firstName.value == "")
	{
		alert("Enter First Name.");
		
		return false;
	}	
	var letterNumber = /^[a-zA-Z, ]+$/;
	if(document.clientEnqForm.firstName.value.match(letterNumber))
	{
		
			if(document.clientEnqForm.lastName.value == "")
			{
				alert("Enter Last Name.");
		
				return false;
			}	
			var letterNumber = /^[a-zA-Z, ]+$/;
			if(document.clientEnqForm.lastName.value.match(letterNumber))
			{
			  if ( document.clientEnqForm.enquiryDate.value == "" )
			    {     
			  	       alert("Please Select Date of Enquiry");
		
			          return false;
			    }
			
				if(document.clientEnqForm.businessName.value == "")
				{
					alert("Enter Business Name.");
		

					return false;
				}
				
				if(document.clientEnqForm.businessAddress.value == "")
				{
					alert("Enter Business Address.");
		
					return false;
				}
				
				 if ( document.clientEnqForm.contactNo.value == "" )
       			 {
		  	       alert("Please Enter Contact Number");
		  	       return false;
       			 }
	       			 var letterNumber = /^[0-9]{10}$/;
	       			 if(document.clientEnqForm.contactNo.value.match(letterNumber))
	       			 {
       				
	       				if(document.clientEnqForm.address.value == "")
	       				{
	       					alert("Please Enter Client Address.");
	       					return false;
	       				}	
	       				
	       				if(document.clientEnqForm.city.value == "")
	       				{
	       					alert("Please Enter City.");
	       					return false;
	       				}	
	       				var letterNumber = /^[a-zA-Z, ]+$/;
						if(document.clientEnqForm.city.value.match(letterNumber))
						{
	       			
							if(document.clientEnqForm.productName.value == "")
							{
								alert("Enter Product Name.");
								
								return false;
							}
							  if(document.clientEnqForm.emailId.value == "")
							  {
									alert("Enter Email Id.");
							
									return false;
							   }	
								var letterNumber = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				  	        	 if(document.clientEnqForm.emailId.value.match(letterNumber) || document.clientEnqForm.emailId.value == null ||  document.clientEnqForm.emailId.value == "")
				  	        	 {
			   	        				clientEnquiryDetails();
								 }
												
		   	        	 else
							{
								alert("Enter a Valid Email Adress..!!");
								return false;
							}
						}
						
						else
						{
							alert("Enter Alphabets Only in City..!!");
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


// validation of complaint and enqiry 
function validationAddMemberComplaint_EnquiryDetails()
{
	var memberName = $('#fk_member_id').val();
	var todayDate = $('#todayDate').val();
	var description = $('#description').val();
	var type = $('#type').val();
	
	if(memberName=="" || memberName==null || memberName==undefined)
	{
		alert("please select member name");
		return false;
	}
	if(todayDate=="" || todayDate==null || todayDate==undefined)
	{
		alert("please select today date");
		return false;
	}
	if(type=="" || type==null || type==undefined)
	{
		alert("please select type");
		return false;
	}
	
	if(description=="" || description==null || description==undefined)
	{
		alert("please enter description");
		return false;
	}
	
	addMemberComplaint_EnquiryDetails();	
}


//Adding Client Enquiry Details
function addMemberComplaint_EnquiryDetails()
{		
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

		var memberName = $('#fk_member_id').val();
		var todayDate = $('#todayDate').val();
		var buildingName = $('#buildingName').val();
		var wingName = $('#wingName').val();
		var floorNo  = $('#floorNo').val();
		var flatNo = $('#flatNo').val();
		var description = $('#description').val();		
		var type = $('#type').val();
		var email = $('#email').val();
		
		if(fkMemberid=="" || fkMemberid == null || fkMemberid == undefined)
		{
			fkMemberid = "0";
		}
		if(buildingName=="" || buildingName == null || buildingName == undefined)
		{
			buildingName = "N/A";
		}
		if(wingName=="" || wingName == null || wingName == undefined)
		{
			wingName = "N/A";
		}
		if(floorNo=="" || floorNo == null || floorNo == undefined)
		{
			floorNo = "N/A";
		}
		if(flatNo=="" || flatNo == null || flatNo == undefined)
		{
			flatNo = "N/A";
		}
		if(email=="" || email == null || email == undefined)
		{
			email = "N/A";
		}
		
		var params = {};
		
		params["fkMemberid"] = fkMemberid;
		params["todayDate"] = todayDate;
		params["memberName"] = memberName;
		params["buildingName"] = buildingName;
		params["wingName"] = wingName;
		params["floorNo"] = floorNo;
		params["flatNo"] = flatNo;
		params["description"] = description;
	
		params["type"] = type;
		params["email"] = email;
		
		params["methodName"] = "addMemberComplaint_EnquiryDetails";
	 	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	 	    	{
	 				alert(data);
	 				location.reload();
	 			/*	if(document.clientEnqForm)
	 				{
	 					document.clientEnqForm.reset();
	 				}*/	
	 				document.clientEnqForm.btn.disabled =false;
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
   document.clientEnqForm.reset();	
}


// validation of follow up
function validationAddComplaint_EnquiryFollowUpDetails()
{
	var memberName = $('#fk_member_id2').val();
	var todayDate2 = $('#todayDate2').val();
	var description2 = $('#description2').val();
	var status = $('#status').val();
	
	if(memberName=="" || memberName==null || memberName==undefined)
	{
		alert("Please select name");
		return false;
	}
	if(todayDate2=="" || todayDate2==null || todayDate2==undefined)
	{
		alert("Please select date");
		return false;
	}
	if(description2=="" || description2==null || description2==undefined)
	{
		alert("Please enter description");
		return false;
	}
	if(status=="" || status==null || status==undefined)
	{
		alert("Please select status");
		return false;
	}
	addComplaint_EnquiryFollowUpDetails();	
}

// add follow up details
function addComplaint_EnquiryFollowUpDetails()
{
	document.getElementById("save").disabled=true;
	
	var input1 = document.getElementById('fk_member_id2'),
	list = document.getElementById('memberNameList2'),
	i,fkMemberid2;
	for (i = 0; i < list.options.length; ++i)
	{
		if (list.options[i].value === input1.value) 
		{
			fkMemberid2 = list.options[i].getAttribute('data-value');
		}
	}
	
	var CNoSelected = document.getElementById("complaintNo");
	var CNoValue = CNoSelected.options[CNoSelected.selectedIndex].value;

	var memberName = $('#fk_member_id2').val();
	var todayDate2 = $('#todayDate2').val();
	var description2 = $('#description2').val();
	var status = $('#status').val();
	var responseDetails = $('#responseDetails').val();	
	var typeForFollwUp = $('#typeForFollwUp').val();
	var emailId = $('#emailId').val();
	
	if(fkMemberid2=="" || fkMemberid2 == null || fkMemberid2 == undefined)
	{
		fkMemberid2 = "0";
	}
	if(responseDetails=="" || responseDetails == null || responseDetails == undefined)
	{
		responseDetails = "N/A";
	}
	var params = {};
	
	params["fkMemberid"] = fkMemberid2;
	params["todayDate"] = todayDate2;
	params["memberName"] = memberName;
	params["description"] = description2;
	params["status"] = status;
	params["responseDetails"] = responseDetails;
	params["typeForFollwUp"] = typeForFollwUp;
	params["emailId"] = emailId;
	params["CNoValue"] = CNoValue;
	
	params["methodName"] = "addComplaint_EnquiryFollowUpDetails";
 	$.post('/society/jsp/utility/controller.jsp',params,function(data)
 	    	{
 				alert(data);
 				/*if(document.clientEnqForm)
 				{
 					document.clientResponseForm.reset();
 				}*/
 				location.reload();
 				document.getElementById("save").disabled=false; 			
 			}
 	
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
 	
}

function ClientResponseDetailsValidation()
{

	if(document.clientResponseForm.fk_client_id.value == "")
	{
		alert("Please Select Client Name.");
		return false;
	}	
	
	if(document.clientResponseForm.productName1.value == "")
	{
		alert("Please Enter Product Name.");
		return false;
	}	
	
	var letterNumber = /^[a-zA-Z, ]+$/;
	if(document.clientResponseForm.productName1.value.match(letterNumber))
		{
			
			if(document.clientResponseForm.clientResponse.value == "")
			{
				alert("Please Select Client Response.");
				return false;
			}
			
			if(document.clientResponseForm.clientResponse.value == "Followup")
			{
				if(document.clientResponseForm.clientFollowUpDate.value == "")
				{
					alert("Please Select Client Follow Up Date.");
					return false;
				}
			}
			ClientResponseDetails();
		}
	else{
		
		alert("Enter Alphabates Only in Product Name..!!");
		return false;
	}
}

//Adding Client Response
function ClientResponseDetails() {

	/* document.exp.btn.disabled = true; */

	var clientName = $('#fk_client_id').val();

	var businessName1 = $('#businessName1').val();
	var contactPersonName =$('#contactPersonName').val();
	var productName1 = $('#productName1').val();
	
	var clientResponse =$('#clientResponse').val();
	
	var clientFollowUpDate = $('#clientFollowUpDate').val();
	var taskInText = $('#taskInText').val();;

	var input1 = document.getElementById('fk_client_id'), list = document
	.getElementById('clientNameList'), i, fkClientId;

    for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input1.value) {
	fkClientId = list.options[i].getAttribute('data-value');
}
}
    
    alert("IDIDID   -----  ::"+fkClientId);

    if(fkClientId==null || fkClientId=="" || fkClientId == undefined)
    {
    	fkClientId = "0";
    }
    
	var params = {};

	params["fkClientId"] = fkClientId;
	params["clientName"] = clientName;
	
	params["businessName"] = businessName1;
	params["contactPersonName"] = contactPersonName;
	params["productName"] = productName1;
	params["clientResponse"] = clientResponse;
	
	params["clientFollowUpDate"] = clientFollowUpDate;
	params["taskInText"] = taskInText;

	params["methodName"] = "ClientResponseInfo";

	$.post('/society/jsp/utility/controller.jsp', params, function(data) {
		alert(data);
		location.reload();
	}).error(function(jqXHR, textStatus, errorThrown) {
		if (textStatus === "timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}


//////////////////////Reports///////////////////////////
//Validation
function getClientDetailsBetTwoDaysValidation()
{
	var clientName= $('#fk_client_id').val();
	var fisDate = $("#fisDate").val();
	var endDate = $("#endDate").val();
	
	if(clientName=="" || clientName==null)
	{
		alert("Please Select Client Name");
		return false;
	}
	
	if(fisDate=="" || fisDate==null)
	{
		alert("Please Select Start Date");
		return false;
	}
	
	if(endDate=="" || endDate==null)
	{
		alert("Please Select End Date");
		return false;
	}
	
	getClientDetailsBetTwoDays();
}


//************ Client Enquiry Report **************//*
//****** Between Two dates **********//*

function getClientDetailsBetTwoDays()
{
	var params= {};
	var clientName= $('#fk_client_id').val();
	var fisDate = $("#fisDate").val();
	var endDate = $("#endDate").val();

	var input1 = document.getElementById('fk_client_id'),
	list = document.getElementById('clientNameList'),
	i,fkClientId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
			fkClientId = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkClientId"]= fkClientId;
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
					
					  {"data": "srNo" , "width": "5%" ,"defaultContent": ""},
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
				                    		 return "Client Enquiry Report";
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



function clientList()
{

	var params= {};

	params["methodName"] = "getAllClientList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#clientList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#clientList').DataTable( {

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
					   	  {"data": "srNo" , "width": "1%" ,"defaultContent": ""},
				          {"data": "firstName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "middleName", "width": "5%" ,"defaultContent": ""},
				          {"data": "lastName", "width": "5%" ,"defaultContent": ""},
				          {"data": "enquiryDate", "width": "5%" ,"defaultContent": ""},
				          {"data": "contactNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "emailId" , "width": "5%" ,"defaultContent": ""},
				          {"data": "comment" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "referenceBy" , "width": "5%" ,"defaultContent": ""},
				          {"data": "productName", "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Client Enquiry Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#clientList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			
			});

}


// Client response details List
function clientResponseList()
{

	var params= {};

	params["methodName"] = "getAllClientResponseList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#clientResponseList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#clientResponseList').DataTable( {

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
					
						  {"data": "srNo" , "width": "1%" ,"defaultContent": ""},	
				          {"data": "clientName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "businessName", "width": "5%" ,"defaultContent": ""},
				          {"data": "contactPersonName", "width": "5%" ,"defaultContent": ""},
				          {"data": "productName", "width": "5%" ,"defaultContent": ""},
				          {"data": "clientResponse" , "width": "5%" ,"defaultContent": ""},
				          {"data": "clientFollowUpDate" , "width": "5%" ,"defaultContent": ""},
				          {"data": "ResponseDetailas" , "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Client Response";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#clientResponseList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}


function getClientDetailsForEdit()
{
	$("#firstName").append($("<input/>").attr("value","").text());
	$("#middleName").append($("<input/>").attr("value","").text());
	$("#lastName").append($("<input/>").attr("value","").text());
	$("#enquiryDate").append($("<input/>").attr("value","").text());
	$("#businessName").append($("<input/>").attr("value","").text());
	$("#businessAddress").append($("<input/>").attr("value","").text());
	$("#contactNo").append($("<input/>").attr("value","").text());
	//$("#address").append($("<input/>").attr("value","").text());
	$("#city").append($("<input/>").attr("value","").text());
	$("#state").append($("<input/>").attr("value","").text());
	$("#zipcode").append($("<input/>").attr("value","").text());
	$("#country").append($("<input/>").attr("value","").text());
	$("#alternativeContactNo").append($("<input/>").attr("value","").text());
	$("#productName").append($("<input/>").attr("value","").text());
	$("#emailId").append($("<input/>").attr("value","").text());
	$("#comment").append($("<input/>").attr("value","").text());
	$("#referenceBy").append($("<input/>").attr("value","").text());
	
	var params= {};
	//var clientName= $('#fk_client_id').val();
	
	var input1 = document.getElementById('fk_client_id'),
	list = document.getElementById('clientNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkClientid = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkClientid"] = fkClientid;
	
	params["methodName"] = "getClientDetailsForEdit";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
				var jsonData = $.parseJSON(data);
				var catmap = jsonData.list;
	
				$.each(jsonData,function(i,v)
			
			{
		
				  document.getElementById("firstName").value = v.firstName;
			      document.getElementById("middleName").value = v.middleName;
			      document.getElementById("lastName").value = v.lastName;
			      document.getElementById("enquiryDate").value = v.enquiryDate;
			      
			      document.getElementById("businessName").value = v.businessName;
			      document.getElementById("businessAddress").value = v.businessAddress;
			      document.getElementById("contactNo").value = v.contactNo;
			     // document.getElementById("address").value = v.address;
			      
			      document.getElementById("city").value = v.city;
			      document.getElementById("state").value = v.state;
			      document.getElementById("zipcode").value = v.zipCode;
			      document.getElementById("country").value = v.country;
			      document.getElementById("alternativeContactNo").value = v.alternateContactNo;
			      
			      document.getElementById("productName").value = v.productName;
			      document.getElementById("emailId").value = v.emailId;
			      document.getElementById("comment").value = v.comment;
			      document.getElementById("referenceBy").value = v.referenceBy;
			       
	      
			});
		}).error(function(jqXHR, textStatus, errorThrown){
			if(textStatus==="timeout") {

			}
		});
	    	
 			
}


function updateClientEnquiryDetail()
{
	
			
			var input1 = document.getElementById('fk_client_id'),
			list = document.getElementById('clientNameList'),
			i,fkEmployeeid;
		
			for (i = 0; i < list.options.length; ++i) {
			if (list.options[i].value === input1.value) {
				fkClientid = list.options[i].getAttribute('data-value');
				}
			}
			
		
	
			var firstName = $('#firstName').val();
			var middleName = $('#middleName').val();
			var lastName = $('#lastName').val();
			var enquiryDate = $('#enquiryDate').val();
			var contactNo  = $('#contactNo').val();
			var address = $('#address').val();
			var emailId = $('#emailId').val();
			var comment = $('#comment').val();
			var referenceBy = $('#referenceBy').val();
			var uploadFile = $('#uploadFile').val();
			
			var businessName = $('#businessName').val();
			var businessAddress = $('#businessAddress').val();
			var alternativeContactNo = $('#alternativeContactNo').val();
			var productName = $('#productName').val();
			
			var city = $('#city').val();
			var state = $('#state').val();
			var zipcode = $('#zipcode').val();
			var country = $('#country').val();
			
			
			var params = {};
			
			params["fkClientid"] = fkClientid;
			
			params["businessName"] = businessName;
			params["businessAddress"] = businessAddress;
			params["alternativeContactNo"] = alternativeContactNo;
			params["productName"] = productName;
			params["city"] = city;
			params["state"] = state;
			params["zipcode"] = zipcode;
			params["country"] = country;
			params["firstName"] = firstName;
			params["middleName"] =middleName;
			params["lastName"] =lastName;
			params["enquiryDate"] = enquiryDate;
			params["contactNo"] =contactNo;
			params["address"] = address;
			params["emailId"] = emailId;
			params["comment"] =comment;
			params["referenceBy"] =referenceBy;
			params["uploadFile"] = uploadFile;
			
			params["methodName"] = "updateClientEnquiryDetails";
		 	$.post('/society/jsp/utility/controller.jsp',params,function(data)
		 	    	{
		 				alert(data);
		 				if(document.clientEnqForm)
		 				{
		 					document.clientEnqForm.reset();
		 				}	
		 				document.clientEnqForm.btn.disabled =false;
		 			}
		 	    	).error(function(jqXHR, textStatus, errorThrown){
		 	    		if(textStatus==="timeout") {
		 	    			$(loaderObj).hide();
		 	    			$(loaderObj).find('#errorDiv').show();
		 	    		}
		 	    	});
 			

		function reset()
		{
		document.clientEnqForm.reset();	
		
		}

}

function getClientDetails()
{

	$("#businessName1").append($("<input/>").attr("value","").text());
	$("#productName1").append($("<input/>").attr("value","").text());
	
	var params= {};
	//var clientName= $('#fk_client_id').val();
	
	var input1 = document.getElementById('fk_client_id'),
	list = document.getElementById('clientNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkClientid = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkClientid"] = fkClientid;
	
	params["methodName"] = "getClientDetailsForEdit";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
				var jsonData = $.parseJSON(data);
				var catmap = jsonData.list;
	
				$.each(jsonData,function(i,v)
			
			{
		
				  document.getElementById("businessName1").value = v.businessName;
			      document.getElementById("productName1").value = v.productName;
			     
			});
		}).error(function(jqXHR, textStatus, errorThrown){
			if(textStatus==="timeout") {

			}
		});
	    	
	
	
	
}

function clientResponseFollowUpValidation()
{
	var fisDate4 = $('#fisDate4').val();
	var endDate4 = $('#endDate4').val();
	
	if(fisDate4=="")
	{
		alert("Please Select First Date");
		return false;
	}	
	
	if(endDate4=="")
	{
		alert("Please Select Last Date");
		return false;
	}
	
	clientResponseFollowUp();
}




// Repost For ClientFollowUp
function clientResponseFollowUp()
{

	var params= {};
	
	var fisDate4 = $('#fisDate4').val();
	var endDate4 = $('#endDate4').val();
	
	params["firstDate"] = fisDate4;
	params["lastDate"] = endDate4;

	params["methodName"] = "getClientResponseFollowUpReport";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#clientResponseFollowUp').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#clientResponseFollowUp').DataTable( {

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
					
						  {"data": "srNo" , "width": "1%" ,"defaultContent": ""},	
				          {"data": "clientName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "businessName", "width": "5%" ,"defaultContent": ""},
				          {"data": "contactPersonName", "width": "5%" ,"defaultContent": ""},
				          {"data": "productName", "width": "5%" ,"defaultContent": ""},
				          {"data": "clientResponse" , "width": "5%" ,"defaultContent": ""},
				          {"data": "clientFollowUpDate" , "width": "5%" ,"defaultContent": ""},
				          {"data": "ResponseDetailas" , "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Client Follow Up Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#clientResponseFollowUp').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}





//Get for today Client response details List
function todayClientResponseList()
{

	var params= {};

	params["methodName"] = "getAllClientResponseListForToday";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#todayClientResponseList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#todayClientResponseList').DataTable( {

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
					
						  {"data": "srNo" , "width": "1%" ,"defaultContent": ""},	
				          {"data": "clientName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "businessName", "width": "5%" ,"defaultContent": ""},
				          {"data": "clientFollowUpDate" , "width": "5%" ,"defaultContent": ""},
				          {"data": "productName", "width": "5%" ,"defaultContent": ""},
				          {"data": "ResponseDetailas" , "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Client Response";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#todayClientResponseList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}



//List Of complaint Enquiry List
function complaint_EnquiryList()
{
	var params= {};

	params["methodName"] = "complaint_EnquiryList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		$('#complaint_EnquiryList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#complaint_EnquiryList').DataTable({
				
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
							  {"data": "srNo" , "width": "2%" ,"defaultContent": ""},	
					          {"data": "memberName" , "width": "10%" ,"defaultContent": ""},
					          {"data": "date" , "width": "5%" ,"defaultContent": ""},
					          {"data": "wingName", "width": "5%" ,"defaultContent": ""},
					          {"data": "buildingName", "width": "5%" ,"defaultContent": ""},
					          {"data": "floorNo" , "width": "5%" ,"defaultContent": ""},
					          {"data": "flatNo" , "width": "5%" ,"defaultContent": ""},
					          {"data": "type", "width": "5%" ,"defaultContent": ""},
					          {"data": "email", "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "7%" ,"defaultContent": ""},
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Member Details List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#complaint_EnquiryList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}





//List Of complaint Enquiry List
function complaint_EnquiryFollowUpList()
{
	var params= {};

	params["methodName"] = "complaint_EnquiryFollowUpList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		$('#complaint_EnquiryFollowUpList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#complaint_EnquiryFollowUpList').DataTable({
				
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
							  {"data": "srNo" , "width": "2%" ,"defaultContent": ""},	
					          {"data": "memberName" , "width": "10%" ,"defaultContent": ""},
					          {"data": "date" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "7%" ,"defaultContent": ""},
					          {"data": "type", "width": "5%" ,"defaultContent": ""},
					          {"data": "complaintNo", "width": "5%" ,"defaultContent": ""},
					          {"data": "email", "width": "5%" ,"defaultContent": ""},
					          {"data": "status", "width": "5%" ,"defaultContent": ""},
					          {"data": "responseDetails", "width": "5%" ,"defaultContent": ""},
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Complaint_Enquiry Follow Up List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#complaint_EnquiryFollowUpList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}

function getComplaintNoAgaistMemberId()
{
	var input = document.getElementById('fk_member_id2'),
	list = document.getElementById('memberNameList2'),
	i,fkMemberId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkMemberId = list.options[i].getAttribute('data-value');
		}
	}
	$("#complaintNo").empty();
	$("#complaintNo").append($("<option></option>").attr("value","").text("Select Complaint No"));
	var params= {};
	params["fkMemberId"]= fkMemberId;
	params["methodName"] = "getMemberComplaintNos";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{
		var jsonData = $.parseJSON(data);
		$.each(jsonData,function(i,v)
		{
			$("#complaintNo").append($("<option></option>").attr("value",i).text(v.memberComplaintNo));
		});
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout"){}
	});
}


