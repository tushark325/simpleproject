/*
 * Name : Sonal Bharti Date : 1/06/2018 Method Name : EmployeeValidation()
 * Reason : Employee Details Validation in cashBook
 */

function EmployeePaymentValidation() {

	var employeeName= $('#fk_employee_id').val();
	var month = $('#month').val();
	var paymentMode = $('#paymentMode2').val();
	var empCreditAmt = $("#empPay").val();
	var empAccName = $("#personName2").val();
	var empPaymentReason = $("#reason2").val();
	var paymentType2 = $("#paymentType2").val();
	

	/*if (employeeName != null && employeeName != "") 
	{*/
	
	if(document.emp.fk_employee_id.value !="")
	{
	  if (month != null && month != "") 
	  {
		if (paymentMode != null && paymentMode != "") 
		{
		var creditAmtRegExp = /^[0-9]+([.][0-9]+)?$/;
		if (empCreditAmt != null && empCreditAmt != "" && empCreditAmt != " ") 
		{
			if (empCreditAmt.match(creditAmtRegExp)) 
			{
				if (Number(empCreditAmt) > 0) 
				{
					if (empPaymentReason != "" && empPaymentReason != " " && empPaymentReason != null) 
					{
						if (paymentType2 != "selected2" && paymentType2 != "" && paymentType2 != " " && paymentType2 != "selected") 
						{
							employeePayment();
						} else
						{
							alert("Select Payment Type Credti or debit");
						}
					} 
					else 
					{
						alert("Enter Payment Reason.");
					}
				} 
				else
				{
					alert("Credit Amount should be grater than 1");
				}
			} 
			else 
			{
				alert("Please Enter valid Credit Amount");
			}
		} 
		else 
		{
			alert("Please Enter Credit Amount");
		}
	  }
		else 
		{
			alert("Please Select Payment Mode");
		}
	  }
	  else
		  {
		  	alert("Please Select Month");
		  }
	  }
	else 
	{
			alert("Please Select Employee Name");
						
/*			$.getScript('/society/staticContent/js/bootbox.min.js', function(){
				
				var msg="Please Select Employee Name";
				var dialog = bootbox.dialog({
				//title: "Embel Technologies Says :",
			    message: '<p class="text-center">'+msg.fontcolor("red").fontsize(5)+'</p>',
			    closeButton: false
			});

				setTimeout(function() {
				dialog.modal('hide');
			}, 1500);
			
			return false;
			
			});
		*/
	}
	  
}

//Adding Employee Payment
function employeePayment(){

	document.getElementById("btn3").disabled = true;

	var employeeName= $('#fk_employee_id').val();
	
	//alert("hi this is employee"+employeeName);
	
	var empPay= $('#empPay').val();
	var personName= $('#personName2').val();
	var reason= $('#reason2').val();
	var paymentMode = $('#paymentMode2').val();
	var chequeNum = $('#chequeNum2').val();
	var nameOnCheck = $('#nameOnCheck2').val();
	var bankName = $('#bankName2').val();
	var cardNum = $('#cardNum2').val();
	var accNum = $('#accNum2').val();
	var paymentType = $('#paymentType2').val();
	
	var month = $('#month').val();
	
	var input1 = document.getElementById('fk_employee_id'),
	list = document.getElementById('employeeNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkEmployeeid = list.options[i].getAttribute('data-value');
		}
	}
	
	var params= {};

	params["fk_employee_id"] = fkEmployeeid;
	params["employeeName"] = employeeName;
	params ["empPay"] = empPay;
	params ["personName"] = personName;
	params ["reason"] = reason;
	params ["paymentMode"] = paymentMode;
	params ["chequeNum"] = chequeNum;
	params ["nameOnCheck"] = nameOnCheck;
	params ["bankName"] = bankName;
	params ["cardNum"] = cardNum;
	params ["accNum"] = accNum;
	params ["paymentType"] = paymentType;

	params ["month"] = month;
	
	params["methodName"] = "regEmpCashBook";

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
	});
}

/*//Expenditure validation
function expensePaymentValidation() {

	var expenseName = $("#expenseName").val();
	var serviceProvider = $("#serviceProvider").val();
	var contactNumber = $("#contactNumber").val();
	var expAmount = $("#expAmount").val();
	var accountantName = $("#accountantName").val();

	if (expenseName != null && expenseName != "" && expenseName != " ") 
	{
		if (serviceProvider != null && serviceProvider != "" && serviceProvider != " ") 
		{
			if (contactNumber != null && contactNumber != "" && contactNumber != " ") 
			{
				var phoneno = /^\d{10}$/;
				if (contactNumber.match(phoneno)) 
				{
					if(expAmount.match(amount))
					{
						addExpense();
					}
		
					else
					{
						alert("Please Enter Number in Expenditure Amount");
					}
				}
				else 
				{
					alert("Contact No Must be 10 digit.");
				}
			} 
			else 
			{
				alert("Enter Contact Number");
			}
		} 
		else 
		{
			alert("Enter Service Provider");
		}
	} 
	else 
	{
		alert("please Select Expenditure Name");
	}
}*/

/********************Validation Expenditure Payment****************/
function validationExpense()
{
	var expenseName = $('#expenseName').val();
	var subExpenditureName = $('#subExpNameId').val();
	var serviceProvider = $('#serviceProvider').val();
	var expAmount = $('#expAmount').val();

	if(expenseName=="" || expenseName==null || expenseName==undefined)
	{
		alert("Select expenditure name");
		return false;
	}
	if(subExpenditureName=="" || subExpenditureName==null || subExpenditureName==undefined)
	{
		alert("Select sub expenditure name");
		return false;
	}
	if(serviceProvider=="" || serviceProvider==null || serviceProvider==undefined)
	{
		alert("Enter service provider name");
		return false;
	}
	if(expAmount=="" || expAmount==null || expAmount==undefined)
	{
		alert("Enter amount");
		return false;
	}
	
	addExpense();
}

/********************Adding Expenditure Payment****************/
function addExpense()
{
	//document.exp.btn4.disabled = true;
	
	var expenseName = $('#expenseName').val();
	var subExpenditureName = $('#subExpNameId').val();
	var serviceProvider = $('#serviceProvider').val();
	var contactNumber = $('#contactNumber').val();
	var expAmount = $('#expAmount').val();
	var accountantName = $('#accountantName').val();
	var descriptionForExp = $('#descriptionForExp').val();
	
	var input = document.getElementById('expenseName'),
     list = document.getElementById('exp_drop'),
   	i,fkExpId;
		for (i = 0; i < list.options.length; ++i) 
		{
		     if (list.options[i].value === input.value)
		     {
		    	 fkExpId = list.options[i].getAttribute('data-value');
		     }
		}
		
		
	   var input2 = document.getElementById('subExpNameId'),
     list2 = document.getElementById('subExp_drop'),
   	j,fkSubEx;
		for (j = 0; j < list2.options.length; ++j) 
		{
		     if (list2.options[j].value === input2.value)
		     {
		    	 fkSubEx = list2.options[j].getAttribute('data-value');
		     }
		}	
		
		if(fkSubEx == "" || fkSubEx == null || fkSubEx == undefined || fkSubEx == " ")
		{
			alert("Sub Expenditure Is Not Registered");
			return false;
		}
		
		if(contactNumber=="" || contactNumber==null || contactNumber==undefined)
		{
			contactNumber='0';
		}
		if(accountantName=="" || accountantName==null || accountantName==undefined)
		{
			accountantName='N/A';
		}
		if(descriptionForExp=="" || descriptionForExp==null || descriptionForExp==undefined)
		{
			descriptionForExp='N/A';
		}

	var params= {};

	params ["fkExpId"] = fkExpId;
	params ["fkSubExpId"] = fkSubEx;
	params ["expenseName"] = expenseName;
	params ["subExpenditureName"] = subExpenditureName;
	params ["serviceProvider"] = serviceProvider;
	params ["expAmount"] = expAmount;
	params ["contactNumber"] = contactNumber;
	params ["accountantName"] = accountantName;
	params ["descriptionForExp"] = descriptionForExp;
	
	params["methodName"] = "regExpenseCashBook";

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
	});
}

//////////////////////Reports///////////////////////////

//************ Employee Payment Report **************//*
//****** Between Two dates **********//*

function getTeacherPaymentDetailsBetTwoDaysValidation()
{
	var employeeName= $('#fk_employee_id').val();
	var startDate = $("#fisDate").val();
	var endDate = $("#endDate").val();
	
	if(employeeName=="" || employeeName==null) 
	{
		alert("Please Select Employee Name");
		return false;
	}
	
	if(startDate=="" || startDate==null) 
	{
		alert("Please Select start Date");
		return false;
	}
	
	if(endDate=="" || endDate==null) 
	{
		alert("Please Select end Date");
		return false;
	}
	
	getTeacherPaymentDetailsBetTwoDays();	
}

function getTeacherPaymentDetailsBetTwoDays()
{
	var params= {};
	var employeeName= $('#fk_employee_id').val();
	var startDate = $("#fisDate").val();
	var endDate = $("#endDate").val();

	var input1 = document.getElementById('fk_employee_id'),
	list = document.getElementById('employeeNameList'),
	i,fkEmployeeid;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkEmployeeid = list.options[i].getAttribute('data-value');
		}
	}
	
	params["employeeName"]= employeeName;
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getTeacherPaymentReportBetweenTwoDates";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear table
		$('#empBetweenTwoDates').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#empBetweenTwoDates').DataTable( {

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
				          {"data": "employeeName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "insertDate", "width": "5%" ,"defaultContent": ""},
				          {"data": "paymentType", "width": "5%" ,"defaultContent": ""},
				          {"data": "paymentMode" , "width": "5%" ,"defaultContent": ""},
				          {"data": "paymentAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "accountantName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "accountantName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "bankName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "reason" , "width": "5%" ,"defaultContent": ""},
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Employee Payment Report By Employee Name Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Employee Payment Report By Employee Name Wise";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Employee Payment Report By Employee Name Wise";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
							                    	 title : function() {
							                    		 return "Employee Payment Report By Employee Name Wise";
							                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );
		var mydata = catmap;
		$('#empBetweenTwoDates').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

//++++++++++++++++++++++++++++++++++++++

//************ Employee Payment Report **************//*
//****** Between  dates Only **********//*

function getPaymentDetailsBetDaysValidation()
{
	var startDate = $("#fisDate2").val();
	var endDate = $("#endDate2").val();
	
	if(startDate=="" || startDate==null)
	{
		alert("Please select start date");
		return false;
	}
	
	if(endDate=="" || endDate==null)
	{
		alert("Please select end date");
		return false;
	}
	
	getPaymentDetailsBetDays();
	
}



function getPaymentDetailsBetDays()
{
	var params= {};
	var startDate = $("#fisDate2").val();
	var endDate = $("#endDate2").val();
	
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getPaymentReportBetweenDates";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear table
		$('#BetweenDates').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#BetweenDates').DataTable( {

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
				          {"data": "employeeName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "insertDate", "width": "5%" ,"defaultContent": ""},
				          {"data": "paymentType", "width": "5%" ,"defaultContent": ""},
				          {"data": "paymentMode" , "width": "5%" ,"defaultContent": ""},
				          {"data": "paymentAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "accountantName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "accountNumber" , "width": "5%" ,"defaultContent": ""},
				          {"data": "bankName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "reason" , "width": "5%" ,"defaultContent": ""},
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Employee Payment Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );
		var mydata = catmap;
		$('#BetweenDates').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

	
}




//************ Expense Payment Report **************//*
//************ Between Two Dates *************//*
function getExpensePaymentDetailsBetTwoDays()
{
	var params= {};
	//var expenseName= $('#expenseName').val();
	var startDate = $("#fisDate442").val();
	var endDate = $("#endDate442").val();
	
	var input = document.getElementById('expenseName'),
	list = document.getElementById('exp_drop'),
	i,fkRootexpId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkRootexpId = list.options[i].getAttribute('data-value');
		}
	}
	
	
	var input = document.getElementById('sub_ExpenseName'),
	list = document.getElementById('subExp_drop'),
	i,fkSubexpId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkSubexpId = list.options[i].getAttribute('data-value');
		}
	}


	params["fkRootexpId"]= fkRootexpId; 
	params["fkSubExpId"]= fkSubexpId; 
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getExpenditurePaymentReportBetweenTwoDates";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#expenseBetweenTwoDates').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#expenseBetweenTwoDates').DataTable( {

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
					.column( 3 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 3 ).footer() ).html(

							parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);	

					// Total over this page
					pageTotal1 = api
					.column( 4 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 4 ).footer() ).html(

							parseFloat(pageTotal1).toFixed(2)

					);
					console.log( pageTotal);
					var creditAmt =  parseFloat(pageTotal).toFixed(2);
					var debitAmt =  parseFloat(pageTotal1).toFixed(2);
					var remainAmt = +creditAmt - +debitAmt;

					// Update footer
					$( api.column( 5 ).footer() ).html(

							parseFloat(remainAmt).toFixed(2)

					);
				},
				destroy: true,
				searching: true,			      
				columns: [

						  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
					      {"data": "expenseName", "width": "5%" ,"defaultContent": ""},
					      {"data": "subExpenseName", "width": "5%" ,"defaultContent": ""},
					      {"data": "serviceProviderName", "width": "5%" ,"defaultContent": ""},
				          {"data": "expAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "insertDate" , "width": "5%" ,"defaultContent": ""}, 
				          
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Expenditure Payment Report Name Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Expenditure Payment Report Name Wise";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Expenditure Payment Report Name Wise";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Expenditure Payment Report Name Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#expenseBetweenTwoDates').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}



//************ Between Two Dates *************//*
function getExpensePaymentDetailsBetDays(){
	var params= {};
	
	var startDate2 = $("#fisDate422").val();
	var endDate2 = $("#endDate422").val();

	params["fisDate"]= startDate2;
	params["endDate"]= endDate2;
	
	params["methodName"] = "getExpenditurePaymentReportBetweenDates";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#expenseBetweenDates22').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#expenseBetweenDates22').DataTable( {

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
					.column( 3 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 3 ).footer() ).html(

							parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);	

					// Total over this page
					pageTotal1 = api
					.column( 4 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 4 ).footer() ).html(

							parseFloat(pageTotal1).toFixed(2)

					);
					console.log( pageTotal);
					var creditAmt =  parseFloat(pageTotal).toFixed(2);
					var debitAmt =  parseFloat(pageTotal1).toFixed(2);
					var remainAmt = +creditAmt - +debitAmt;

					// Update footer
					$( api.column( 5 ).footer() ).html(

							parseFloat(remainAmt).toFixed(2)

					);
				},
				destroy: true,
				searching: true,			      
				columns: [

							{"data": "srNo", "width": "5%" ,"defaultContent": ""},
					        {"data": "expenseName", "width": "5%" ,"defaultContent": ""},
					        {"data": "subExpenseName", "width": "5%" ,"defaultContent": ""},
					        {"data": "serviceProviderName", "width": "5%" ,"defaultContent": ""},
				            {"data": "expAmount" , "width": "5%" ,"defaultContent": ""},
				            {"data": "insertDate" , "width": "5%" ,"defaultContent": ""}, 
				          
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Expenditure Payment Report Date Range Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Expenditure Payment Report Date Range Wise";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Expenditure Payment Report Date Range Wise";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Expenditure Payment Report Date Range Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#expenseBetweenDates22').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}


// get Bill Number By Vendor_Name FOR Vendor for PO
function getTotalAndBalanceAmountVendorId()
{
	
	/*$("#billList_Drop").empty();
	$("#billList_Drop").append($("<option></option>").attr("value","").text("Select Bill"));
	*/
	$("#totalAmount").append($("<input/>").attr("value","").text());
	$("#balanceAmount").append($("<input/>").attr("value","").text());
	
	var params= {};
	
		var input1 = document.getElementById('fk_vendor_id'), list = document
		.getElementById('vendorNameList'), i, fkClientId;
	    for (i = 0; i < list.options.length; ++i) 
	    {
	    	if (list.options[i].value === input1.value) 
	    	{
	    		fkVendorId = list.options[i].getAttribute('data-value');
	    	}
	    }
    
	var vendorName = $('#fk_vendor_id').val();
	
	params["fkVendorId"] = fkVendorId;
	params["vendorName"] = vendorName;
	
	params["methodName"] = "getTotalAndBalanceAmountVendorId";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{ var count = 1;
				var total=0;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
						
						document.getElementById("balanceAmount").value=v.balanceStatus;
						
						$("#billList_Drop").append($("<option></option>").attr("value",(v.billNo))); 
						total = +total+ +v.grossTotal;
						count++;
						
					});
			document.getElementById("totalAmount").value = total;
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
	
}

// get Amount By Bill No FOR Vendor
function getTotalByBillNo()
{
	var billNo = $('#billNo').val();
	
	$("#billAmount").append($("<input/>").attr("value","").text());
	
	var params={};
	
	params["billNo"] = billNo;
	params["methodName"] = "getTotalAmountByBillNo";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
		{

			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			$.each(jsonData,function(i,v)
					{
					document.getElementById("billAmount").value = v.billAmount;
					document.getElementById("balanceAmount").value = v.balanceStatus;
					
					
					});
		}).error(function(jqXHR, textStatus, errorThrown){
			if(textStatus==="timeout") {
			}
		});
	
}

// validation FOR Vendor Payment Details 
function vendorPaymentValidation()
{
	var vendorName = $('#fk_vendor_id').val();
	/*var billNoV = $('#billNo').val();*/
	var paidAmount = $('#paidAmount').val();
	
	if(vendorName=="" || vendorName==null)
	{
		alert("Please Select Vendor Name");
		return false;
	}
	
/*	if(billNoV=="" || billNoV==null)
	{
		alert("Please Select Bill No");
		return false;
	}*/
	
	if(paidAmount=="" || paidAmount==null)
	{
		alert("Please Enter Paid Amount");
		return false;
	}
	
	var balanceAmount =parseInt( $('#balanceAmount').val());
	var paidAmount = parseInt($('#paidAmount').val());

	if(balanceAmount < paidAmount || paidAmount==null)
	{
		alert('Please enter paid amount less than Or equal to Balance Amount...');
		return false;
	}
	vendorPaymentDetailas();
}


// Add Vendor Payment Details
function vendorPaymentDetailas()
{
	var input1 = document.getElementById('fk_vendor_id'), list = document
	.getElementById('vendorNameList'), i, fkClientId;

    for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input1.value) {
	fkVendorId = list.options[i].getAttribute('data-value');
    }
    }
    
    var vendorName = $('#fk_vendor_id').val();
    var totalAmount = $('#totalAmount').val();
   /* var billNo = $('#billNo').val();
    var billAmount = $('#billAmount').val();*/
    var balanceAmount = $('#balanceAmount').val();
    var paidAmount = $('#paidAmount').val();
    var descriptionForPO = $('#descriptionForPO').val();
    
    if(descriptionForPO=="" || descriptionForPO==null || descriptionForPO==undefined)
    {
    	descriptionForPO="N/A";
    }
    
    var params={};
    
    params["fkVendorId"] = fkVendorId;
    params["vendorName"] = vendorName;
    params["totalAmount"] = totalAmount;
   /* params["billNo"] = billNo;
    params["billAmount"] = billAmount;*/
    params["balanceAmount"] = balanceAmount;
    params["paidAmount"] = paidAmount;
    params["descriptionForPO"] = descriptionForPO;
    
    params["methodName"] = "vendorPaymentDetailas";
    
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
				alert(data);
				window.open("VendorPOPaymentReceiptPDF.jsp");
				location.reload();
			}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
  
}


// Get Total Amount And Bill No By Client ID FOR Client

function getTotalAmountByClientName()
{
	
	
	$("#billList_Drop2").empty();
	$("#billList_Drop2").append($("<option></option>").attr("value","").text("Select Bill"));
	var params= {};
	
	var input1 = document.getElementById('fk_client_id'), list = document
	.getElementById('clientNameList'), i, fkClientId2;

    for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input1.value) {
	fkClientId2 = list.options[i].getAttribute('data-value');
    }
    }
    params["fkClientId2"] = fkClientId2;
    
    params["methodName"] = "getAllBillNoByClientName";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{ var count = 1;
				var total=0;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
						$("#billList_Drop2").append($("<option></option>").attr("value",(v.billNo))); 
						total = +total+ +v.grossTotal;
						count++;
						
					});
			document.getElementById("totalAmount2").value = total;
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
	
}

// Get Amount By Bill No For Client
function getTotalByBillForClient()
{
	
	var billNo2 = $('#billNo2').val();
	
	$("#billAmount2").append($("<input/>").attr("value","").text());
	

	var params={};
	
	params["billNo2"] = billNo2;
	params["methodName"] = "getTotalAmountByBillNoForClient";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
		{

			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			$.each(jsonData,function(i,v)
					{
	
					document.getElementById("billAmount2").value = v.billAmount;
					document.getElementById("balanceAmount2").value = v.balanceStatus;
					
					
					});
		}).error(function(jqXHR, textStatus, errorThrown){
			if(textStatus==="timeout") {
			}
		});
	
}

//validation For Client Payment Details
function clientPaymentValidation()
{
	
	var clientName = $('#fk_client_id').val();
	var billNoC = $('#billNo2').val();
	var paidAmount2 = $('#paidAmount2').val();
	
	if(clientName=="" || clientName==null)
	{
		alert("Please Select Client Name");
		return false;
	}
	
	if(billNoC=="" || billNoC==null)
	{
		alert("Please Select Bill No");
		return false;
	}
	
	if(paidAmount2=="" || paidAmount2==null)
	{
		alert("Please Enter Paid Amount");
		return false;
	}
	

	var balanceAmount2 = parseInt($('#balanceAmount2').val());
	var paidAmount2 = parseInt($('#paidAmount2').val());
		
	if(balanceAmount2 < paidAmount2)
	{
		alert('Please enter paid amount less than Or equal to Balance Amount...');
		return false;
	}
	
	clientPaymentDetailas();
}

// Add Client Payment Details
function clientPaymentDetailas()
{
	var input1 = document.getElementById('fk_client_id'), list = document
	.getElementById('clientNameList'), i, fkClientId2;

    for (i = 0; i < list.options.length; ++i) {
    if (list.options[i].value === input1.value) {
	fkClientId2 = list.options[i].getAttribute('data-value');
    }
    }
    
    
    var clientName = $('#fk_client_id').val();
    var totalAmount2 = $('#totalAmount2').val();
    var billNo2 = $('#billNo2').val();
    var billAmount2 = $('#billAmount2').val();
    var balanceAmount2 = $('#balanceAmount2').val();
    var paidAmount2 = $('#paidAmount2').val();
    
    	
    var params={};
    
    params["fkClientId2"] = fkClientId2;
    params["clientName"] = clientName;
    params["totalAmount2"] = totalAmount2;
    params["billNo2"] = billNo2;
    params["billAmount2"] = billAmount2;
    params["balanceAmount2"] = balanceAmount2;
    params["paidAmount2"] = paidAmount2;
    
    params["methodName"] = "clientPaymentDetails";
    
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
	});
}

// Vendor Payment Report By Name And Dates
function getVendorPaymentDetailsByName()
{
	var params= {};

	var vendorName = $("#vendorNameForPO").val();
	var startDate = $("#fisDate4").val();
	var endDate = $("#endDate4").val();
	
	
	var input = document.getElementById('vendorNameForPO'),
	list = document.getElementById('ven_dropForPO'),
	i,fkVendorPaymentId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input.value) 
		{
			fkVendorPaymentId = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkVendorPaymentId"]= fkVendorPaymentId;
	params["vendorName"]= vendorName; 
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getVendorPaymentReportBetweenTwoDatesAndName";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#vendorBetweenTwoDates').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function()
		{
			$('#vendorBetweenTwoDates').DataTable( {

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

							  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
						      {"data": "vendorName", "width": "5%" ,"defaultContent": ""},
						      {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""}, 
					          {"data": "remainingAmount" , "width": "5%" ,"defaultContent": ""},
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By Vendor Name By Vendor Name";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Vendor Payment Report For PO By Vendor Name By Vendor Name";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By Vendor Name By Vendor Name";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Vendor Payment Report For PO By Vendor Name By Vendor Name";
					                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#vendorBetweenTwoDates').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
	
	
}

//Vendor Payment Report By Date For PO
function getVendorPaymentDetailsBetDays()
{
	var params= {};
	
	var startDate = $("#fisDate42").val();
	var endDate = $("#endDate42").val();
	
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getVendorPaymentReportBetweenTwoDates";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#vendorBetweenTwoDate').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function()
		{
			$('#vendorBetweenTwoDate').DataTable( {

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

							  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
						      {"data": "vendorName", "width": "5%" ,"defaultContent": ""},
						      {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""}, 
					          {"data": "remainingAmount" , "width": "5%" ,"defaultContent": ""},
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Reports For PO By Date Range Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Vendor Payment Reports For PO By Date Range Wise";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Vendor Payment Reports For PO By Date Range Wise";
					                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Reports For PO By Date Range Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#vendorBetweenTwoDate').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}


//Client Payment Report Date And NameWise
function getClientPaymentDetailsByName()
{

	var clientName = $("#clientName").val();
	var fisDate4 = $("#fisDate4").val();
	var endDate4 = $("#endDate4").val();
	
	
	var params= {};
	
	params["clientName"] = clientName;
	params["fisDate4"] = fisDate4;
	params["endDate4"] = endDate4;
	
	params["methodName"] = "getClientPaymentReportBetweenTwoDatesAndName";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#clientBetweenTwoDatesAndName').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function() {
			
			$('#clientBetweenTwoDatesAndName').DataTable( {

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
				        
					      {"data": "srNo", "width": "2%" ,"defaultContent": ""},
				          {"data": "clientName", "width": "5%" ,"defaultContent": ""},
				          {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
				          {"data": "billNo", "width": "5%" ,"defaultContent": ""},
				          {"data": "billAmount" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""},
				        
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Client Payment Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});
		
		
		var mydata = catmap;
		$('#clientBetweenTwoDatesAndName').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
	

}


//Client Payment Report Date Wise
function getClientPaymentDetailsByDate()
{

	
	var fisDate42 = $("#fisDate42").val();
	var endDate42 = $("#endDate42").val();
	
	
	var params= {};
	
	
	params["fisDate42"] = fisDate42;
	params["endDate42"] = endDate42;
	
	params["methodName"] = "getClientPaymentReportBetweenTwoDates";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#clientBetweenTwoDate').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function() {
			
			$('#clientBetweenTwoDate').DataTable( {

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
				        
					      {"data": "srNo", "width": "2%" ,"defaultContent": ""},
				          {"data": "clientName", "width": "5%" ,"defaultContent": ""},
				          {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
				          {"data": "billNo", "width": "5%" ,"defaultContent": ""},
				          {"data": "billAmount" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""},
				        
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Client Payment Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});
		
		
		var mydata = catmap;
		$('#clientBetweenTwoDate').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
	

}


//validation For Member Payment Details
function memberPaymentValidation()
{
	
	var memberName = $('#fk_member_id').val();
	var paidAmount222 = $('#paidAmount22').val();
	
	if(memberName=="" || memberName==null)
	{
		alert("Please Select Member Name");
		return false;
	}
	if(paidAmount222=="" || paidAmount222==null)
	{
		alert("Please Enter Paid Amount");
		return false;
	}

	var balanceAmount222 = parseInt($('#balanceAmount222').val());
	var paidAmount222 = parseInt($('#paidAmount22').val());
		
	if(balanceAmount222 < paidAmount222)
	{
		alert('Please enter paid amount less than Or equal to Balance Amount...');
		return false;
	}
	memberPaymentDetails();
}

//Add Member Payment Details
function memberPaymentDetails()
{
	var input1 = document.getElementById('fk_member_id'), list = document
	.getElementById('memeberNameList'), i, fkClientId2;

  for (i = 0; i < list.options.length; ++i)
  {
	  if (list.options[i].value === input1.value) 
	  {
		  fkMemberId2 = list.options[i].getAttribute('data-value');
	  }
  }
  var memberName = $('#fk_member_id').val();
  var totalAmount2 = $('#totalAmount222').val();
  var balanceAmount2 = $('#balanceAmount222').val();
  var paidAmount2 = $('#paidAmount22').val();
  var description = $('#description').val();
  	
  if(description==null || description=="" || description==undefined)
  {
	  description="N/A";
  }
  var params={};
  
  params["fkMemberId2"] = fkMemberId2;
  params["memberName"] = memberName;
  params["totalAmount2"] = totalAmount2;
  params["balanceAmount2"] = balanceAmount2;
  params["paidAmount2"] = paidAmount2;
  params["description"] = description;
  
  params["methodName"] = "memberPaymentDetails";
  
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
				alert(data);
				window.open("MemberBillingPaymentReceiptPDF.jsp");
				location.reload();
			}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
  
  
}


//get Total and balance amount by member Id
function getTotalAndBalanceAmountByMemberID()
{
	$("#totalAmount2").empty();
	$("#balanceAmount2").empty();
	
	$("#totalAmount2").append($("<input/>").attr("value","").text());	
	$("#balanceAmount2").append($("<input/>").attr("value","").text());
	
	var params= {};
	var input1 = document.getElementById('fk_member_id'), list = document
	.getElementById('memeberNameList'), i, fkMemberId2;

    for (i = 0; i < list.options.length; ++i) 
    {
	    if (list.options[i].value === input1.value) 
	    {
	    	fkMemberId2 = list.options[i].getAttribute('data-value');
	    }
    }
     params["fkMemberId2"] = fkMemberId2;
    params["methodName"] = "getTotalAndBalanceAmountByMemberID";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{
				
			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
					
						document.getElementById("totalAmount222").value = v.amount;
						document.getElementById("balanceAmount222").value = v.balanceAmount;
						
						
					});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
	
}


// List Of member payment details
function memberPaymentList()
{
	var params= {};
	
	params["methodName"] = "getMemberPaymentList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#memberPaymentList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#memberPaymentList').DataTable( {

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
				          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "remainingAmount" , "width": "5%" ,"defaultContent": ""},
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
				                    		 return "Member Payment Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#memberPaymentList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}


// Vendor payment List
function vendorPaymentList()
{	
	var params= {};
	
	params["methodName"] = "getVendorPaymentList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#vendorPaymentList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		$(document).ready(function() {
			$('#vendorPaymentList').DataTable( {

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
			          
							  {"data": "srNo", "width": "2%" ,"defaultContent": ""},
					          {"data": "vendorName", "width": "5%" ,"defaultContent": ""},
					          {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "remainingAmount" , "width": "5%" ,"defaultContent": ""},
					          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#vendorPaymentList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

// Employee payment List
function employeePaymentList()
{
	var params= {};
	
	params["methodName"] = "getEmployeePaymentList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#employeePaymentList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#employeePaymentList').DataTable( {

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
				        
			          	  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
				          {"data": "employeeName", "width": "5%" ,"defaultContent": ""},
				          {"data": "reason", "width": "5%" ,"defaultContent": ""},
				          {"data": "month" , "width": "5%" ,"defaultContent": ""},
				          {"data": "paymentType" , "width": "5%" ,"defaultContent": ""},
				          {"data": "paymentAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "insertDate" , "width": "5%" ,"defaultContent": ""},
				          {"data": "checkNumber" , "width": "5%" ,"defaultContent": ""},
				          {"data": "cardNumber", "width": "5%" ,"defaultContent": ""},
				          {"data": "accountNumber", "width": "5%" ,"defaultContent": ""},
				          {"data": "paymentMode" , "width": "5%" ,"defaultContent": ""},
				          {"data": "bankName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "nameOnCheck" , "width": "5%" ,"defaultContent": ""},
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Employee Payment Report";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Employee Payment Report";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Employee Payment Report";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Employee Payment Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#employeePaymentList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}


// Client payment List
function clientPaymentList()
{
	var params= {};
	
	params["methodName"] = "getClientPaymentList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#clientPaymentList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function() {
			
			$('#clientPaymentList').DataTable( {

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
				        
					      {"data": "srNo", "width": "2%" ,"defaultContent": ""},
				          {"data": "clientName", "width": "5%" ,"defaultContent": ""},
				          {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
				          {"data": "billNo", "width": "5%" ,"defaultContent": ""},
				          {"data": "billAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""},
				        
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Client Payment Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});
		
		
		var mydata = catmap;
		$('#clientPaymentList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

// get momnth and amount from member monthly cost maintenance
function getMonthAndAmount()
{
	$("#monthList").empty();
	$("#monthList").append($("<option></option>").attr("value","").text("Select Bill"));
	$("#totalAmountMem").append($("<input/>").attr("value","").text());	
	$("#balanceAmountMem").append($("<input/>").attr("value","").text());	
	var params= {};
	
	var input1 = document.getElementById('fk_memberMain_id'), list = document.getElementById('memMainNameList'), i, fkMemMainId;
    for (i = 0; i < list.options.length; ++i) 
    {
    if (list.options[i].value === input1.value) 
	    {
    		fkMemMainId = list.options[i].getAttribute('data-value');
	    }
    }
    
    var memberName = $('#fk_memberMain_id').val();
    
    params["fkMemMainId"] = fkMemMainId;
    params["memberName"] = memberName;
    
    params["methodName"] = "getMonthAndAmountByMemMainId";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
	{
		var count = 1;
				//var total=0;
				var balAmt=0;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
						$("#monthList").append($("<option></option>").attr("value",(v.month)));
					/*	alert(v.balance_amount);
						$("#balanceAmountMem").append($("<input/>").attr("value",(v.balance_amount)));
						document.getElementById("balanceAmountMem").value = v.balance_amount;
						$("#totalAmountMem").append($("<option></option>").attr("value",(v.totalamt))); 
						total = +total+ +v.monthly_contribution_cost;  */
						total = v.totalamt;
						balAmt = v.balance_amount;
						count++;
						
					});

			document.getElementById("balanceAmountMem").value = balAmt;
			document.getElementById("totalAmountMem").value = total;
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
}


//get amount by month from member monthly cost maintenance
function getAmountByAmount()
{	
	$("#monthAmount").append($("<input/>").attr("value","").text());	
	var params= {};
	
	// get member id
	var input1 = document.getElementById('fk_memberMain_id'),
	list = document.getElementById('memMainNameList'), i, fkMemMainId;
	
	for (i = 0; i < list.options.length; ++i) 
    {
    	if (list.options[i].value === input1.value) 
	    {
    		fkMemMainId = list.options[i].getAttribute('data-value');
	    }
    }
    
    var memberName = $('#fk_memberMain_id').val();
    var month = $('#month22').val();
    
    params["fkMemMainId"] = fkMemMainId;
    params["memberName"] = memberName;
    params["month"] = month;
    
    params["methodName"] = "getAmountByAmount";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
	{
		var count = 1;
		var total=0;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
			{
				if(v.monthly_contribution_cost == null || v.monthly_contribution_cost == "" || v.monthly_contribution_cost == " " || v.monthly_contribution_cost == undefined)
				{
			        document.getElementById("monthAmount").value = "";
				}
				else
				{
					document.getElementById("monthAmount").value = v.monthly_contribution_cost;
				}
				//document.getElementById("balanceAmountMem").value = v.balance_amount;
			});
			}).error(function(jqXHR, textStatus, errorThrown){
			if(textStatus==="timeout")
			{}
		});
}


function validationMemberMainPaymentDetails()
{
	 var memberName = $('#fk_memberMain_id').val();
	 var month = $('#month22').val();
	 var padAmt = $('#paidAmountMem').val();
	 
	 if(memberName=="" || memberName==null || memberName==undefined)
	 {
		 alert('Please select member name');
		 return false;
	 }
	 if(month=="" || month==null || month==undefined)
	 {
		 alert('Please select month');
		 return false;
	 }
	 if(padAmt=="" || padAmt==null)
	 {
		 alert('Please enter paid amount');
		 return false;
	 }
	 
	 var balanceAmount2 = parseInt($('#balanceAmountMem').val());
	 var paidAmount2 = parseInt($('#paidAmountMem').val());
	 
	 if(balanceAmount2 < paidAmount2)
	 {
		 alert('Please enter paid amount equal or less than balance amount');
		 return false;
	 }
	 
	 addMemberMainPaymentDetails();
}

//add Member Maintenance Payment Validation details
function addMemberMainPaymentDetails()
{
	var input1 = document.getElementById('fk_memberMain_id'), 
	list = document.getElementById('memMainNameList'), i, fkMemMainId;
	
    for (i = 0; i < list.options.length; ++i) 
    {
    if (list.options[i].value === input1.value) 
	    {
			fkMemMainId = list.options[i].getAttribute('data-value');
	    }
    }
    
    var memberName = $('#fk_memberMain_id').val();
    var totalAmountMem = $('#totalAmountMem').val();
    var month = $('#month22').val();
    var monthAmount = $('#monthAmount').val();
    var balanceAmountMem = $('#balanceAmountMem').val();
    var paidAmountMem = $('#paidAmountMem').val();
    var descriptionMem = $('#descriptionMem').val();
    
    if(descriptionMem=="" || descriptionMem==null || descriptionMem==undefined)
    {
    	descriptionMem = "N/A";
    }
    var params={};
    
    params["fkMemMainId"] = fkMemMainId;
    params["memberName"] = memberName;
    params["totalAmountMem"] = totalAmountMem;
    params["month"] = month;
    params["monthAmount"] = monthAmount;
    params["balanceAmountMem"] = balanceAmountMem;
    params["paidAmountMem"] = paidAmountMem;
    params["descriptionMem"] = descriptionMem;
    
    params["methodName"] = "addMemberMainPaymentDetails";
    
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
				alert(data);
				window.open("MemberMaintenancePaymentReceiptPDF.jsp");
				location.reload();
			}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
  
}




//get Bill Number By Vendor_Name FOR Vendor for AMC
function getTotalAndBalanceAmountVendorIdForAMC()
{
	$("#totalAmountForAMC").append($("<input/>").attr("value","").text());
	$("#balanceAmountForAMC").append($("<input/>").attr("value","").text());
	
	var params= {};
	
	var input1 = document.getElementById('fk_vendor_idForAMC'), list = document
	.getElementById('vendorNameListForAMC'), i, fkClientId;
    for (i = 0; i < list.options.length; ++i) 
    {
    	if (list.options[i].value === input1.value) 
    	{
    		fkVendorId = list.options[i].getAttribute('data-value');
    	}
    }
 
	var vendorName = $('#fk_vendor_idForAMC').val();
	
	params["fkVendorId"] = fkVendorId;
	params["vendorName"] = vendorName;
	
	params["methodName"] = "getTotalAndBalanceAmountVendorIdForAMC";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{ var count = 1;
				var total=0;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
						
						document.getElementById("balanceAmountForAMC").value=v.balanceAmount;
					
						total = +total+ +v.totalAmount;
						count++;
						
					});
			document.getElementById("totalAmountForAMC").value = total;
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
	
}


//validation FOR Vendor Payment For AMC Details 
function vendorPaymentForAMCValidation()
{
	var vendorName = $('#fk_vendor_idForAMC').val();
	var paidAmount = $('#paidAmountForAMC').val();
	
	if(vendorName=="" || vendorName==null)
	{
		alert("Please Select Vendor Name");
		return false;
	}
	
/*	if(billNoV=="" || billNoV==null)
	{
		alert("Please Select Bill No");
		return false;
	}*/
	
	if(paidAmount=="" || paidAmount==null)
	{
		alert("Please Enter Paid Amount");
		return false;
	}
	var balanceAmount =parseInt( $('#balanceAmountForAMC').val());
	var paidAmount = parseInt($('#paidAmountForAMC').val());

	if(balanceAmount < paidAmount || paidAmount==null)
	{
		alert('Please enter paid amount less than Or equal to Balance Amount...');
		return false;
	}
	
	vendorPaymentForAMCDetailas();
}


// Add Vendor Payment For AMC Details
function vendorPaymentForAMCDetailas()
{
	var input1 = document.getElementById('fk_vendor_idForAMC'), list = document
	.getElementById('vendorNameListForAMC'), i, fkClientId;
    for (i = 0; i < list.options.length; ++i) 
    {
	    if (list.options[i].value === input1.value) 
	    {
	    	fkVendorId = list.options[i].getAttribute('data-value');
	    }
    }
    
    var vendorName = $('#fk_vendor_idForAMC').val();
    var totalAmount = $('#totalAmountForAMC').val();
    var balanceAmount = $('#balanceAmountForAMC').val();
    var paidAmount = $('#paidAmountForAMC').val();
    var description = $('#descriptionForAMC').val();
    
    
    if(description=="" || description==null || description==undefined)
    {
    	description ="N/A";
    }
    
    var params={};
    
    params["fkVendorId"] = fkVendorId;
    params["vendorName"] = vendorName;
    params["totalAmount"] = totalAmount;
    params["balanceAmount"] = balanceAmount;
    params["paidAmount"] = paidAmount;
    params["description"] = description;
    
    params["methodName"] = "vendorPaymentForAMCDetailas";
    
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
				alert(data);
				window.open("VendorAMCPaymentReceiptPDF.jsp");
				location.reload();
			}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});  
}

//Vendor payment List for AMC
function vendorPaymentListForAMC()
{	
	var params= {};
	
	params["methodName"] = "vendorPaymentListForAMC";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{	
		$('#vendorPaymentListForAmc').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		$(document).ready(function() {
			$('#vendorPaymentListForAmc').DataTable( {

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
							  {"data": "srNo", "width": "2%" ,"defaultContent": ""},
					          {"data": "vendorName", "width": "5%" ,"defaultContent": ""},
					          {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "remainingAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment List Of AMC";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Vendor Payment List Of AMC";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Vendor Payment List Of AMC";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment List Of AMC";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#vendorPaymentListForAmc').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

//Vendor Payment Report For AMC By Name And Dates
function getVendorPaymentDetailsForAMCByName()
{
	var params= {};

	var vendorName = $("#vendorNameForAMC").val();
	var startDate = $("#fisDate4ForAMC").val();
	var endDate = $("#endDate4ForAMC").val();
	
	var input = document.getElementById('vendorNameForAMC'),
	list = document.getElementById('ven_dropForAMC'),
	i,fkVendorPaymentIdForAMC;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input.value) 
		{
			fkVendorPaymentIdForAMC = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkVendorPaymentId"]= fkVendorPaymentIdForAMC;
	params["vendorName"]= vendorName; 
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getVendorPaymentDetailsForAMCByName";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#vendorBetweenTwoDatesForAMC').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function()
		{
			$('#vendorBetweenTwoDatesForAMC').DataTable( {

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

							  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
						      {"data": "vendorName", "width": "5%" ,"defaultContent": ""},
						      {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""}, 
					          {"data": "remainingAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Reports For AMC By Vendor Name";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Vendor Payment Reports For AMC By Vendor Name";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Vendor Payment Reports For AMC By Vendor Name";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Reports For AMC By Vendor Name";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#vendorBetweenTwoDatesForAMC').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

//Vendor Payment Report By Date For AMC
function getVendorPaymentDetailsBetDaysForAMC()
{
	var params= {};
	
	var startDate = $("#fisDate42ForAMC").val();
	var endDate = $("#endDate42ForAMC").val();
	
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getVendorPaymentDetailsBetDaysForAMC";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#vendorBetweenTwoDateForAMC').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function()
		{
			$('#vendorBetweenTwoDateForAMC').DataTable( {

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

							  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
						      {"data": "vendorName", "width": "5%" ,"defaultContent": ""},
						      {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""}, 
					          {"data": "remainingAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Reports For AMC By Date Range Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Vendor Payment Reports For AMC By Date Range Wise";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Vendor Payment Reports For AMC By Date Range Wise";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Reports For AMC By Date Range Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#vendorBetweenTwoDateForAMC').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}



//Member Payment Report For Billing By Name And Dates
function getMemberPaymentDetailsForBillingByName()
{
	var params= {};

	var memberName = $("#memberNameForBilling").val();
	var startDate = $("#fisDateForBilling").val();
	var endDate = $("#endDateForBilling").val();
	
	var input = document.getElementById('memberNameForBilling'),
	list = document.getElementById('mem_dropForBilling'),
	i,fkMemberPaymentIdForBilling;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input.value) 
		{
			fkMemberPaymentIdForBilling = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkMemberPaymentId"]= fkMemberPaymentIdForBilling;
	params["memberName"]= memberName; 
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getMemberPaymentDetailsForBillingByName";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#memBetweenTwoDates').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function()
		{
			$('#memBetweenTwoDates').DataTable( {

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

							  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
						      {"data": "memberName", "width": "5%" ,"defaultContent": ""},
						      {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""}, 
					          {"data": "remainingAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Member Payment Reports For Billing By Member Name Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Member Payment Reports For Billing By Member Name Wise";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Member Payment Reports For Billing By Member Name Wise";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Member Payment Reports For Billing By Member Name Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#memBetweenTwoDates').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}



//Member Payment Report For Billing By Dates
function getMemberPaymentDetailsForBillingByDates()
{
	var params= {};

	var startDate = $("#fisDate2ForBilling").val();
	var endDate = $("#endDate2ForBilling").val();

	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getMemberPaymentDetailsForBillingByDates";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#memberBetweenTwoDateForBilling').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function()
		{
			$('#memberBetweenTwoDateForBilling').DataTable( {

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

							  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
						      {"data": "memberName", "width": "5%" ,"defaultContent": ""},
						      {"data": "totalAmount", "width": "5%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "5%" ,"defaultContent": ""}, 
					          {"data": "remainingAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By Date Range Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By Date Range Wise";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By Date Range Wise";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By Date Range Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#memberBetweenTwoDateForBilling').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
	
	
}

//Member Payment Report For AMC By Name And Dates
function getMemberPaymentDetailsForAMCByName()
{
	var params= {};

	var memberName = $("#memberNameForAMC").val();
	var startDate = $("#fisDateForAMC").val();
	var endDate = $("#endDateForAMC").val();
	
		var input = document.getElementById('memberNameForAMC'),
		list = document.getElementById('mem_dropForAMC'),
		i,fkMemberPaymentIdForAMC;
		for (i = 0; i < list.options.length; ++i) 
		{
			if (list.options[i].value === input.value) 
			{
				fkMemberPaymentIdForAMC = list.options[i].getAttribute('data-value');
			}
		}
		
	params["fkMemberPaymentId"]= fkMemberPaymentIdForAMC;
	params["memberName"]= memberName; 
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getMemberPaymentDetailsForAMCByName";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#memBetweenTwoDatesForAMC').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		/*var currentBal = 0;
		
		var payment = -$(this).find('.monthAmount').text(); 
		var receipt = +$(this).find('.paidAmount').text();
		currentBal += payment + receipt;    
		$(this).find('.balanceAmount').text(currentBal);*/
		
		$(document).ready(function()
		{
			$('#memBetweenTwoDatesForAMC').DataTable( {

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
					          {"data": "date" , "width": "3%" ,"defaultContent": ""},
					          {"data": "month", "width": "2%" ,"defaultContent": ""},
					          {"data": "monthAmount", "width": "3%" ,"defaultContent": ""},
					          {"data": "paidAmount" , "width": "3%" ,"defaultContent": ""},
					          {"data": "balanceAmount" , "width": "3%" ,"defaultContent": ""}, 
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Member Payment Reports For AMC Member Name Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Member Payment Reports For AMC Member Name Wise";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Member Payment Reports For AMC Member Name Wise";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Member Payment Reports For AMC Member Name Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#memBetweenTwoDatesForAMC').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
	
	
}



//Member Payment Report For AMC Dates Wise
function getMemberPaymentDetailsForAMCByDate()
{
	var params= {};

	var startDate = $("#fisDate22ForAMC").val();
	var endDate = $("#endDate22ForAMC").val();
	
	params["fisDate"]= startDate;
	params["endDate"]= endDate;
	
	params["methodName"] = "getMemberPaymentDetailsForAMCByDate";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#memberBetweenTwoDatesForAMC').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		
		
		$(document).ready(function()
		{
			$('#memberBetweenTwoDatesForAMC').DataTable( {

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
					          {"data": "date" , "width": "8%" ,"defaultContent": ""},
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By date Range Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By date Range Wise";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By date Range Wise";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Payment Report For PO By date Range Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#memberBetweenTwoDatesForAMC').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
	
	
}

// get Sub Expenditure Name for cashbook
function getSubExpenditureName()
{

	$("#subExp_drop").empty();
	$("#subExp_drop").append($("<input/>").attr("value","").text());	
	var params= {};
	
	var input1 = document.getElementById('expenseName'), list = document
	.getElementById('exp_drop'), i, fkExpId;
    for (i = 0; i < list.options.length; ++i) 
    {
		if (list.options[i].value === input1.value) 
	    {
			fkExpId = list.options[i].getAttribute('data-value');
	    }
    }
    
    var expenditureName = $('#expenseName').val();
    
    params["fkExpId"] = fkExpId;
    params["expenditureName"] = expenditureName;
    
    params["methodName"] = "getSubExpenditureName";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
						$("#subExp_drop").append($("<option></option>").attr("value",(v.subExpenditueName)).attr("data-value",(v.pkSubExpId))); 
						
/*						$("#vendorList_Drop").append($("<option></option>").attr("value",(v.vendorName)).attr("data-value",(v.vendorId)));
*/						
					});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
	
}




//List Of Expenditure payment Details 
function expenditurePaymentList()
{
	var params= {};

	params["methodName"] = "getAllExpenditurePaymentList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#expPaymentList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#expPaymentList').DataTable( {
				
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
						
							  {"data": "srNo" , "width": "1%" ,"defaultContent": ""},
					          {"data": "expenseName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "subExpenseName", "width": "5%" ,"defaultContent": ""},
					          {"data": "serviceProviderName", "width": "5%" ,"defaultContent": ""},
					          {"data": "accountantName", "width": "5%" ,"defaultContent": ""},
					          {"data": "contactNumber" , "width": "5%" ,"defaultContent": ""},
					          {"data": "insertDate" , "width": "5%" ,"defaultContent": ""},
					          {"data": "expAmount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
					          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Expenditure Payment List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#expPaymentList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}



//get Sub Expense Name for report
function getSubExpenseName()
{
	
	$("#subExp_drop").empty();
	$("#subExp_drop").append($("<option></option>").attr("value","").text("Select Sub Expense"));
	
	
	/*$("#totalAmount").append($("<input/>").attr("value","").text());
	$("#balanceAmount").append($("<input/>").attr("value","").text());
	*/
	var params= {};
	
	var input1 = document.getElementById('expenseName'), list = document
	.getElementById('exp_drop'), i, fkExpId;
    for (i = 0; i < list.options.length; ++i) 
    {
		if (list.options[i].value === input1.value) 
	    {
			fkExpId = list.options[i].getAttribute('data-value');
	    }
    }
 
	var expenseName = $('#expenseName').val();

	params["fkExpenseId"] = fkExpId;
	params["expenseName"] = expenseName;
	
	params["methodName"] = "getSubExpenseNameByID";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{ var count = 1;
				var total=0;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
							
						$("#subExp_drop").append($("<option></option>").attr("value",(v.subExpenseName)).attr("data-value",(v.fkSubExpId))); 
						
					});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
	
}


