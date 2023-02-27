function validateDates(date2, cutOffDate, maintainanceType)
{
	var splitDate = date2.split("-");
	var splitCutOffDate = cutOffDate.split("-");
	
	var date1 = splitDate[2];
	var cutOffyear = splitCutOffDate[0];
	var cutOffMonth =  splitCutOffDate[1]
	var cutOffDate = splitCutOffDate[2];
	
	if(date1 == "01")
	{}
	else
	{
		alert("Please Select Start Date of Month");
		return false;
	}	
	if(cutOffMonth > 1 && cutOffMonth < 8)
	{	
		for(var cutOffMonthStart = 1;  cutOffMonthStart <= 7; cutOffMonthStart++)
		{
			if(cutOffMonth == "02")
			{
				if((0 == cutOffyear % 4) && (0 != cutOffyear % 100) || (0 == cutOffyear % 400))
				{
					if(cutOffDate == "29")
					{
						if(maintainanceType == "monthly")
						{
							MemberMonthlyContribution();
							break;
						}
						else if(maintainanceType == "sbaWise")
						{
							MemberMonthlyContributionBySBA();
							break;
						}
					}
					else
					{
						alert("Please Select End Date of Month");
						return false;
					}					
				}
				else if(cutOffDate == "28")
				{
					if(maintainanceType == "monthly")
					{
						MemberMonthlyContribution();
						break;
					}
					else if(maintainanceType == "sbaWise")
					{
						MemberMonthlyContributionBySBA();
						break;
					}
				}
				else
				{
					alert("Please Select End Date of Month");
					return false;
				}						
			}
			if(cutOffMonth != "02")
			{	
				if(cutOffMonth%2 == 0)
				{
					if(cutOffDate == "30")
					{
						if(maintainanceType == "monthly")
						{
							MemberMonthlyContribution();
							break;
						}
						else if(maintainanceType == "sbaWise")
						{
							MemberMonthlyContributionBySBA();
							break;
						}
					}
					else
					{
						alert("Please Select End Date of Month");
						return false;
					}
				}
				else if(cutOffMonth%2 != 0)
				{
					if(cutOffDate == "31")
					{
						if(maintainanceType == "monthly")
						{
							MemberMonthlyContribution();
							break;
						}
						else if(maintainanceType == "sbaWise")
						{
							MemberMonthlyContributionBySBA();
							break;
						}
					}
					else
					{
						alert("Please Select End Date of Month");
						return false;
					}
				}
			}
		}
	}
	else if(cutOffMonth > 7 && cutOffMonth < 13)
	{
		for(var cutOffMonthStart = 8;  cutOffMonthStart <= 12; cutOffMonthStart++)
		{
			if(cutOffMonth%2 == 0)
			{
				if(cutOffDate == "31")
				{
					if(maintainanceType == "monthly")
					{
						MemberMonthlyContribution();
						break;
					}
					else if(maintainanceType == "sbaWise")
					{
						MemberMonthlyContributionBySBA();
						break;
					}
				}
				else
				{
					alert("Please Select End Date of Month");
					return false;
				}
			}
			else if(cutOffMonth%2 != 0)
			{
				if(cutOffDate == "30")
				{
					if(maintainanceType == "monthly")
					{
						MemberMonthlyContribution();
						break;
					}
					else if(maintainanceType == "sbaWise")
					{
						MemberMonthlyContributionBySBA();
						break;
					}
				}
				else
				{
					alert("Please Select End Date of Month");
					return false;
				}
			}		
		}	
	}
}

//validation for Member Monthly Contribution
function validationMemberMonthlyContribution()
{
	var monthlyContributionCost = $('#monthlyContributionCost').val();
	var date2 = $('#date2').val();
	var cutOffDate = $('#cutOffDate').val();
	var maintainanceType = "monthly";
	
	if(monthlyContributionCost=="" || monthlyContributionCost==null || monthlyContributionCost==undefined)
	{
		alert('Please enter monthly contribution cost');
		return false;
	}
	if(cutOffDate=="" || cutOffDate==null || cutOffDate==undefined)
	{
		alert('Please select cutOffDate');
		return false;
	}
	
	validateDates(date2, cutOffDate, maintainanceType);
}

function MemberMonthlyContribution()
{
	//document.expenseDetails.save.disabled = true;
	
	document.getElementById("save").disabled=true;
	
	/*
		document.getElementById("save").onclick = function() {
		    //disable
		    this.disabled = true;
	
		    //do some validation stuff
		}
	*/
	
	var monthlyContributionCost = $('#monthlyContributionCost').val();
	var date = $('#date2').val();
	var cutOffDate = $('#cutOffDate').val();
	var sbaPerPrice = $('#cutOffDate').val();
	var maintainanceType = "monthly";
	
	var params = {};
	
	params["monthlyContributionCost"] = monthlyContributionCost;
	params["date"] = date;
	params["cutOffDate"] = cutOffDate;
	params["sbaPerPrice"] = sbaPerPrice;
	params["maintainanceType"] = maintainanceType;
	
	params["methodName"] = "addMemberMonthlyContribution";

	$.post('/society/jsp/utility/controller.jsp', params, function(data) 
	{
		alert(data);
		document.getElementById("save").disabled=false;
		location.reload();
		
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
	
// document.expenseDetails.save.disabled = false;	

/*	
	document.getElementById("save").onclick = function() {
	    //disable
	    this.disabled = false;

	    //do some validation stuff
	}
*/	
}

//List Of monthly Contribution Cost List 
function monthlyContributionCostList()
{
	var params= {};

	params["methodName"] = "monthlyContributionCostList";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{
		$('#monthlyContributionCostList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#monthlyContributionCostList').DataTable( {
				
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
					          {"data": "monthly_contribution_cost" , "width": "5%" ,"defaultContent": ""},
					          {"data": "date", "width": "5%" ,"defaultContent": ""},
					          {"data": "month", "width": "5%" ,"defaultContent": ""},
					          {"data": "cutOffDate", "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Monthly Contribution Cost List";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Monthly Contribution Cost List";
				                    	 },	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'EXCEL' 
				                    	 },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Monthly Contribution Cost List";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Monthly Contribution Cost List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#monthlyContributionCostList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

//List Of Member Monthly Contributionb Cost Payment List
function memberMonthlyContributionbCostPaymentList()
{
	var params= {};
	
	params["methodName"] = "memberMonthlyContributionbCostPaymentList";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{		
		$('#memberMonthlyContributionbCostPaymentList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function()
		{
			$('#memberMonthlyContributionbCostPaymentList').DataTable({
				
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
					      	  {"data": "srNo", "width": "1%" ,"defaultContent": ""},
					          {"data": "memberName", "width": "5%" ,"defaultContent": ""},
					          {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "month", "width": "5%" ,"defaultContent": ""},
					          {"data": "monthAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
					          {"data": "date" , "width": "5%" ,"defaultContent": ""},
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Member Monthly Contributironb Cost Payment List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#memberMonthlyContributionbCostPaymentList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

//validation for Member Monthly Contribution By SBA
function validationMemberMonthlyContributionBySBA()
{
	
	//document.getElementById("saveForsba").disabled=true;
	
	var SBAPerPrice = $('#sbaPerPrice').val();
	var dateForSBA = $('#dateForSBA').val();
	var cutOffDaysForSBA = $('#cutOffDaysForSBA').val();
	var maintainanceType = "sbaWise";
	
	var splitDate = dateForSBA.split("-");
	var date1 = splitDate[2];
	
	

	if(SBAPerPrice=="" || SBAPerPrice==null || SBAPerPrice==undefined)
	{
		alert("Please Select SBA Per Price");
		return false;
	}
	
	if(date1 == "01")
	{}
	else
	{
		alert("Please Select Start Date of Month");
		return false;
	}
	
	var ToDate = new Date();
	var first_date = new Date(ToDate.getFullYear(), ToDate.getMonth(), 1);

	if (new Date(dateForSBA).getTime() <= first_date.getTime()) {
	    alert("The Date must be Bigger or Equal to today date");
	    return false;
	}
    else
    {}
    
	if(cutOffDaysForSBA =="" || cutOffDaysForSBA == null || cutOffDaysForSBA == undefined)
	{
		alert('Please Select Cut Off Days For Penalty');
		return false;
	}
	
	MemberMonthlyContributionBySBA();
	
	//validateDates(dateForSBA, cutOffDate, maintainanceType)	
}

function MemberMonthlyContributionBySBA()
{
	document.getElementById("saveForSBA").disabled=true;
	
	var sbaPerPrice = $('#sbaPerPrice').val();
	var dateForSBA = $('#dateForSBA').val();
	var cutOffDaysForSBA = $('#cutOffDaysForSBA').val();
	var maintainanceType = "sbaWise";
	
	var params = {};
	
	params["sbaPerPrice"] = sbaPerPrice;
	params["dateForSBA"] = dateForSBA;
	params["cutOffDaysForSBA"] = cutOffDaysForSBA;
	params["maintainanceType"] = maintainanceType;
	
	params["methodName"] = "MemberMonthlyContributionBySBA";

	$.post('/society/jsp/utility/controller.jsp', params, function(data)
	{
		alert(data);
		document.getElementById("saveForSBA").disabled=false;
		location.reload();
	}).error(function(jqXHR, textStatus, errorThrown)
	{
		if(textStatus==="timeout")
		{
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}

//List Of monthly Contribution Cost By SBA List 
function monthlyContributionCostBySBAList()
{
	var params= {};

	params["methodName"] = "monthlyContributionCostBySBAList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{
		$('#monthlyContributionCostList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#monthlyContributionCostList').DataTable({
				
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
					          {"data": "monthlyContributionCostBySBA" , "width": "5%" ,"defaultContent": ""},
					          {"data": "date", "width": "5%" ,"defaultContent": ""},
					          {"data": "month", "width": "5%" ,"defaultContent": ""},
					          {"data": "cutOffDays", "width": "5%" ,"defaultContent": ""},
					          {"data": "cutOffDate", "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Monthly Contribution Cost List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#monthlyContributionCostList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}

//update Member Monthly Contribution Cost
function updateMemberMonthlyContribution()
{
		var monthlyContributionCost = $('#monthlyContributionCost').val();
		var cutOffDate = $('#cutOffDate').val();
		
		/*var input = document.getElementById('fk_member_id'),
	     list = document.getElementById('memeberNameList'),
	     	i,fkMemberId;
		 		for (i = 0; i < list.options.length; ++i) 
		 		{
				     if (list.options[i].value === input.value) 
				     {
				    	 fkMemberId = list.options[i].getAttribute('data-value');
				     }
		 		}*/
	
		var params = {};
		
		params["monthlyContributionCost"] = monthlyContributionCost;
		params["cutOffDate"] = cutOffDate;
	
	
		params["methodName"] = "updateMemberMonthlyContribution";
	 	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	 	    	{
	 				alert(data);
	 				location.reload();
	 				/*if(document.empd)
	 				{
	 					document.empd.reset();
	 				}	*/
	 				
	 			//	window.open("TestPdf.jsp");
	 			//	document.empd.btn.disabled =false;
	 			}
	 	    	).error(function(jqXHR, textStatus, errorThrown){
	 	    		if(textStatus==="timeout") {
	 	    			$(loaderObj).hide();
	 	    			$(loaderObj).find('#errorDiv').show();
	 	    		}
	 	    	});
	 			
}

//update Member Monthly Contribution Cost SBA
function updateMemberMonthlyContributionSBA()
{
		var sbaPerPrice = $('#sbaPerPrice').val();
		var startDate = $('#startDate').val();
		
		/*var input = document.getElementById('fk_member_id'),
	     list = document.getElementById('memeberNameList'),
	     	i,fkMemberId;
		 		for (i = 0; i < list.options.length; ++i) 
		 		{
				     if (list.options[i].value === input.value) 
				     {
				    	 fkMemberId = list.options[i].getAttribute('data-value');
				     }
		 		}*/
	
		var params = {};
		
		params["sbaPerPrice"] = sbaPerPrice;
		params["startDate"] = startDate;
	
		params["methodName"] = "updateMemberMonthlyContributionSBA";
	 	$.post('/society/jsp/utility/controller.jsp',params,function(data)
    	{
			alert(data);
			location.reload();
			/*
 				if(document.empd)
 				{
 					document.empd.reset();
 				}
			*/
		//	window.open("TestPdf.jsp");
		//	document.empd.btn.disabled =false;
	}).error(function(jqXHR, textStatus, errorThrown){
	if(textStatus==="timeout") {
		$(loaderObj).hide();
		$(loaderObj).find('#errorDiv').show();
	}
});
	 			
}