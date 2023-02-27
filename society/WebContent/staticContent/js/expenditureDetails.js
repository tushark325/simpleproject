//Adding expense detail
function addExpenseDetails()
{
	if(document.expenseDetails.expenseName.value == "")
	{
		alert("Please Enter Expense Name");
		return false;
	}	
	var letterNumber = /^[a-zA-Z0-9, ]+$/;
	if(document.expenseDetails.expenseName.value.match(letterNumber))
	{
		addExpense();
	}
	else
	{
		alert("Enter Alphabates And Numbers Only in Expense name field..!!");
		return false;
	}	
}

function addExpense() 
{

	//document.expenseDetails.btn.disabled = true;
	var expenseName = $('#expenseName').val();
	var params = {};

	params["expenseName"] = expenseName;
	params["methodName"] = "addExpenseDetails";

	$.post('/society/jsp/utility/controller.jsp', params, function(data) 
			{
		alert(data);
		location.reload();
			}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}

function reset() {
	document.expenseDetails.reset();
}

function addExpenseForBillingAndGoodsReceive() {

	document.expenseDetails1.btn1.disabled = true;
	var expenseName = $('#expenseNameForBilling').val();
	var params = {};

	params["expenseName"] = expenseName;
	params["methodName"] = "addExpenseDetailsForBilling";

	$.post('/Fertilizer/jsp/utility/controller.jsp', params, function(data) {
		alert(data);
		if (document.expenseDetails1) {
			document.expenseDetails1.reset();
		}
		document.expenseDetails1.btn1.disabled = false;
	}).error(function(jqXHR, textStatus, errorThrown) {
		if (textStatus === "timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});

}

function validationAnnualExpenseDetails()
{
	var annualMaintenanceName = $('#annualMaintenanceName').val();
	
	if(annualMaintenanceName == "" || annualMaintenanceName== null || annualMaintenanceName==undefined)
	{
		alert("Please Enter Expense Name");
		return false;
	}	
	addAnnualExpenseDetails();
}

function addAnnualExpenseDetails()
{
	var annualMaintenanceName = $('#annualMaintenanceName').val();
	var params = {};

	params["annualMaintenanceName"] = annualMaintenanceName;
	params["methodName"] = "addAnnualExpenseDetails";

	$.post('/society/jsp/utility/controller.jsp', params, function(data) 
			{
		alert(data);
		location.reload();
			}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
	
}

function validationAddAnnualMaintenceGeneration()
{
	var annualMaintenanceName = $('#annualMaintenanceName').val();
	var startdate2 = $('#startdate2').val();
	var enddate2 = $('#enddate2').val();

	if(annualMaintenanceName=="" || annualMaintenanceName==null || annualMaintenanceName==undefined)
	{
		alert("Please select annual maintenance name");
		return false;
	}
	
	if(startdate2=="" || startdate2==null || startdate2==undefined)
	{
		alert("Please select start date");
		return false;
	}
	
	
	if(enddate2=="" || enddate2==null || enddate2==undefined)
	{
		alert("Please select end date");
		return false;
	}
	addAnnualMaintenceGeneration();
}


function addAnnualMaintenceGeneration()
{
	var annualMaintenanceName = $('#annualMaintenanceName').val();
	var startdate2 = $('#startdate2').val();
	var enddate2 = $('#enddate2').val();
	var descrition = $('#descrition').val();
	
	
	var input1 = document.getElementById('annualMaintenanceName'),
	list = document.getElementById('cat_drop'),
	i,fkMaintenceId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
			fkMaintenceId = list.options[i].getAttribute('data-value');
		}
	}
	
	var params = {};
	
	if(descrition=="" || descrition==null || descrition==undefined)
	{
		descrition="N/A"
	}
	
	
	
	params["fkMaintenceId"] = fkMaintenceId;
	params["annualMaintenanceName"] = annualMaintenanceName;
	params["startdate2"] = startdate2;
	params["enddate2"] = enddate2;
	params["descrition"] = descrition;
	
	params["methodName"] = "addAnnualExpenseGenerationDetails";
	
	$.post('/society/jsp/utility/controller.jsp', params, function(data) 
			{
				alert(data);
				location.reload();
			}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
	
}


function validateSubExpenditure()
{
	var expenditureName = $('#expenseName2').val();
	var subExpenditureName = $('#subExpenditure').val();
	
	if(expenditureName=="" || expenditureName==null || expenditureName==undefined)
	{
		alert("Please select expenditure name");
		return false;
	}
	if(subExpenditureName=="" || subExpenditureName==null || subExpenditureName==undefined)
	{
		alert("Please enter sub expenditure Name");
		return false;
	}
	
	addSubExpenditureDetails();
	
}

// add Sub Expenditure Details
function addSubExpenditureDetails()
{
	var expenditureName = $('#expenseName2').val();
	var subExpenditureName = $('#subExpenditure').val();
	var description = $('#description').val();
	
	var params = {};
	
	var input = document.getElementById('expenseName2'),
    list = document.getElementById('cat_drop2'),
	i,fkExpenditureId;
	for (i = 0; i < list.options.length; ++i) 
	{
	     if (list.options[i].value === input.value) 
	     {
	    	 fkExpenditureId = list.options[i].getAttribute('data-value');
	     }
	}
	
	if(description=="" || description==null || description==undefined)
	{
		description="N/A";
	}
	
	params["fkExpenditureId"] = fkExpenditureId;
	params["expenditureName"] = expenditureName;
	params["subExpenditureName"] = subExpenditureName;
	params["description"] = description;
	
	params["methodName"] = "addSubExpenditureDetails";

	$.post('/society/jsp/utility/controller.jsp', params, function(data) 
			{
		alert(data);
		location.reload();
			}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}


// Add Expenditure List
function addExpenditureList(){
	

	var params= {};

	params["methodName"] = "addExpenditureList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		$('#addExpList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#addExpList').DataTable({
				
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
							  {"data": "pkExpenseDetailsId" , "width": "2%" ,"defaultContent": ""},	
							  {"data": "expenseName", "width": "5%" ,"defaultContent": ""},
					          {"data": "insertDate", "width": "5%" ,"defaultContent": ""},
					       		          
					          
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
		$('#addExpList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}


//List Of Expenditure And Sub Expenditure List
function expenditureAndSubExpenditureList()
{
	var params= {};

	params["methodName"] = "expenditureAndSubExpenditureList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		$('#expAndSubExpList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#expAndSubExpList').DataTable({
				
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
							  {"data": "expenditureName", "width": "5%" ,"defaultContent": ""},
					          {"data": "subExpenditureName", "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "7%" ,"defaultContent": ""},
					          
					          
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
		$('#expAndSubExpList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}

