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
	var annualMaintenanceName = $('#annualMaintenanceName2').val();
	var startdate2 = $('#startdate2').val();
	var enddate2 = $('#enddate2').val();
	var amount = $('#amount').val();
	var vendorname = $('#vendorName').val();
	
	if(vendorname=="" || vendorname==null || vendorname==undefined)
	{
			alert('Please select vendor name');
			return false;
	}
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
	if(amount=="" || amount==null || amount==undefined)
	{
		alert("Please enter amount");
		return false;
	}
	
	addAnnualMaintenceGeneration();
}


function addAnnualMaintenceGeneration()
{
	var annualMaintenanceName = $('#annualMaintenanceName2').val();
	var startdate2 = $('#startdate2').val();
	var enddate2 = $('#enddate2').val();
	var descrition = $('#descrition').val();
	var vendorName = $('#vendorName').val();
	var amount = $('#amount').val();
	
	
	var input1 = document.getElementById('annualMaintenanceName2'),
	list = document.getElementById('cat_drop2'),
	i,fkMaintenceId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
			fkMaintenceId = list.options[i].getAttribute('data-value');
		}
	}
	
	var input1 = document.getElementById('vendorName'),
	list = document.getElementById('vendorNameList'),
	i,fkMaintenceId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
			fkVendorId = list.options[i].getAttribute('data-value');
		}
	}
	var params = {};
	
	if(descrition=="" || descrition==null || descrition==undefined)
	{
		descrition="N/A"
	}
	if(vendorName=="" || vendorName==null || vendorName==undefined)
	{
		vendorName="N/A"
	}
	params["fkMaintenceId"] = fkMaintenceId;
	params["annualMaintenanceName"] = annualMaintenanceName;
	params["startdate2"] = startdate2;
	params["enddate2"] = enddate2;
	params["descrition"] = descrition;
	params["vendorName"] = vendorName;
	params["amount"] = amount;
	params["fkVendorId"] = fkVendorId;
	
	params["methodName"] = "addAnnualExpenseGenerationDetails";
	
	$.post('/society/jsp/utility/controller.jsp', params, function(data) 
	{
		alert(data);
		$('#vendor22').load(document.URL +  ' #vendor22');
	}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}

//************ Maintenance Report **************//*
//************ Maintenance Building Wise Report *************//*
function getMaintenanceReportBuildingWise()
{
	var params= {};
	var buildingName = $('#buildingName').val();
	var startDateBuilding = $('#startDateBuilding').val();
	var endDateBuilding = $('#endDateBuilding').val();
	
	/*
	var input = document.getElementById('buildingName'),
	list = document.getElementById('buil_drop'),
	i,fkRootBuildId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input.value) 
		{
			fkRootBuildId = list.options[i].getAttribute('data-value');
		}
	}*/
	
	//params["fkRootexpId"]= fkRootBuildId; 
	params["buildingName"]= buildingName;
	params["startDateBuilding"]= startDateBuilding;
	params["endDateBuilding"]= endDateBuilding;
	
	
	params["methodName"] = "getMaintenanceReportBuildingWise";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#BuildingWise').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#BuildingWise').DataTable( {

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
					.column( 7 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 7 ).footer() ).html(

							parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);	
 				
					
				},
				destroy: true,
				searching: true,			      
				columns: [

						  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
					      {"data": "fName", "width": "5%" ,"defaultContent": ""},
					      {"data": "lName", "width": "5%" ,"defaultContent": ""},
				          {"data": "wingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "buildingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "floorNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "flatNo" , "width": "5%" ,"defaultContent": ""}, 
				          {"data": "amount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "date" , "width": "5%" ,"defaultContent": ""},
				          
				          
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report Building Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report Building Wise";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report Building Wise";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report Building Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#BuildingWise').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

//************ Maintenance Report **************//*
//************ Maintenance Wing Wise Report *************//*
function getMaintenanceReportWingWise()
{
	var params= {};
	var wingName = $('#wingName').val();
	var startDateWing = $('#startDateWing').val();
	var endDateWing = $('#endDateWing').val();
	
/*	var input = document.getElementById('wingName'),
	list = document.getElementById('wing_drop'),
	i,fkRootBuildId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input.value) 
		{
			fkRootWingId = list.options[i].getAttribute('data-value');
		}
	}*/
	
	//params["fkRootexpId"]= fkRootBuildId; 
	params["wingName"]= wingName;
	params["startDateWing"]= startDateWing;
	params["endDateWing"]= endDateWing;
	
	
	params["methodName"] = "getMaintenanceReportWingWise";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#wingWise').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#wingWise').DataTable( {

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
					.column( 7 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 7 ).footer() ).html(

							parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);	
				
					
				},
				destroy: true,
				searching: true,			      
				columns: [

						  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
					      {"data": "fName", "width": "5%" ,"defaultContent": ""},
					      {"data": "lName", "width": "5%" ,"defaultContent": ""},
				          {"data": "wingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "buildingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "floorNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "flatNo" , "width": "5%" ,"defaultContent": ""}, 
				          {"data": "amount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "date" , "width": "5%" ,"defaultContent": ""},
				          
				          
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report Wing Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report Wing Wise";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report Wing Wise";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report Wing Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#wingWise').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}





//************ Maintenance Report **************//*
//************ Maintenance Member Wise Report *************//*
function getMaintenanceReportMemberWise()
{
	var params= {};
	var memberName = $('#fk_Member_id').val();
	
	var input = document.getElementById('fk_Member_id'),
	list = document.getElementById('memNameList'),
	i,fkRootMemId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input.value) 
		{
			fkRootMemId = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkMemId"]= fkRootMemId; 
	params["memberName"]= memberName;
	params["methodName"] = "getMaintenanceReportMemberWise";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#memWise').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#memWise').DataTable( {

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
					.column( 7 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 7 ).footer() ).html(

							parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);	
				
					
				},
				destroy: true,
				searching: true,			      
				columns: [

						  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
					      {"data": "fName", "width": "5%" ,"defaultContent": ""},
					      {"data": "lName", "width": "5%" ,"defaultContent": ""},
				          {"data": "wingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "buildingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "floorNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "flatNo" , "width": "5%" ,"defaultContent": ""}, 
				          {"data": "amount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "date" , "width": "5%" ,"defaultContent": ""},
				          
				          
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report By Member Wise";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report By Member Wise";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report By Member Wise";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report By Member Wise";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#memWise').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}




//************ Maintenance Report **************//*
//************ Maintenance Yearly Report *************//*
function getMaintenanceReportYearly()
{
	var params= {};
	var year = $('#Year_id').val();
	
	params["year"]= year;
	params["methodName"] = "getMaintenanceReportYearly";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#yearly').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#yearly').DataTable( {

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
					.column( 7 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 7 ).footer() ).html(

							parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);	
				
					
				},
				destroy: true,
				searching: true,			      
				columns: [

						  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
					      {"data": "fName", "width": "5%" ,"defaultContent": ""},
					      {"data": "lName", "width": "5%" ,"defaultContent": ""},
				          {"data": "buildingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "wingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "floorNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "flatNo" , "width": "5%" ,"defaultContent": ""}, 
				          {"data": "amount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "date" , "width": "5%" ,"defaultContent": ""},
				          
				          
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Expenditure Payment Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#yearly').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}


//get momnth by Year for monthly Report
function getMonthbyYear()
{
	
	$("#monthList2").empty();
	$("#monthList2").append($("<option></option>").attr("value","").text("Select Bill"));
		
	var params= {};
	
    var year = $('#Year_id2').val();
    
    params["year"] = year;
    params["methodName"] = "getMonthbyYear";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{ var count = 1;
				var total=0;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
						$("#monthList2").append($("<option></option>").attr("value",(v.month))); 
						
					});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
	
}



//************ Maintenance Report **************//*
//************ Maintenance monthly Report *************//*
function getMaintenanceReportMonthly()
{
	var params= {};
	var year = $('#Year_id2').val();
	var month = $('#month2').val();
	
	params["year"]= year;
	params["month"]= month;
	params["methodName"] = "getMaintenanceReportMonthly";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#monthly').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#monthly').DataTable( {

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
					.column( 7 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 7 ).footer() ).html(

							parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);	
				
					
				},
				destroy: true,
				searching: true,			      
				columns: [

						  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
					      {"data": "fName", "width": "5%" ,"defaultContent": ""},
					      {"data": "lName", "width": "5%" ,"defaultContent": ""},
				          {"data": "buildingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "wingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "floorNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "flatNo" , "width": "5%" ,"defaultContent": ""}, 
				          {"data": "amount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "date" , "width": "5%" ,"defaultContent": ""},
				          
				          
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Expenditure Payment Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#monthly').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}



//get building name list by wing name
function getBuildingNamebyWingName()
{
	$("#building_drop22").empty();
	$("#building_drop22").append($("<option></option>").attr("value","").text("Select Building"));
	var params= {};
	/*
	var input1 = document.getElementById('fk_memberMain_id'), list = document
	.getElementById('memMainNameList'), i, fkMemMainId;
    for (i = 0; i < list.options.length; ++i) 
    {
    if (list.options[i].value === input1.value) 
	    {
    	fkMemMainId = list.options[i].getAttribute('data-value');
	    }
    }
    */
	
    var wingName = $('#wingName22').val();
    
    params["wingName"] = wingName;
    params["methodName"] = "getBuildingNamebyWingName";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{ var count = 1;
				var total=0;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
						$("#building_drop22").append($("<option></option>").attr("value",(v.buildingName))); 
						
					});
			
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
	
}

//get Member name list by wing name and building name
function getMemberByWingAndBuilding()
{
	$("#memNameList").empty();
	$("#memNameList").append($("<option></option>").attr("value","").text("Select Member Name"));
	var params= {};

	
    var wingName = $('#wingName22').val();
    var buildingName = $('#buildingName22').val();
    
    params["wingName"] = wingName;
    params["buildingName"] = buildingName;
    
    params["methodName"] = "getMemberByWingAndBuilding";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{ var count = 1;
				var total=0;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
						$("#memNameList").append($("<option></option>").attr("value",(v.firstName)+" "+(v.lastName)+" "+(v.contactNumber))); 
						
					});
			
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
}



//************ Association Report **************//*
//************ Maintenance Association Report *************//*
function getMaintenanceAssociationReport()
{
	var params= {};
	
	params["methodName"] = "getMaintenanceAssociationReport";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear Table
		$('#asociation').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#asociation').DataTable( {

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
					.column( 7 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 7 ).footer() ).html(

							parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);	
				
					
				},
				destroy: true,
				searching: true,			      
				columns: [

						  {"data": "srNo", "width": "5%" ,"defaultContent": ""},
					      {"data": "fName", "width": "5%" ,"defaultContent": ""},
					      {"data": "lName", "width": "5%" ,"defaultContent": ""},
					      {"data": "wingName" , "width": "5%" ,"defaultContent": ""},
					      {"data": "buildingName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "floorNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "flatNo" , "width": "5%" ,"defaultContent": ""}, 
				          {"data": "amount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "date" , "width": "5%" ,"defaultContent": ""},
				          
				          
				          ],
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report of Association";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Maintenance Income Report of Association";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Maintenance Income Report of Association";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Maintenance Income Report of Association";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );

		var mydata = catmap;
		$('#asociation').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}


// get vendor name for follow up
function getVendorNameForFollowUp()
{
	$("#vendorNameFollwUp").append($("<input/>").attr("value","").text());	
	
	var params= {};
    var annualMaintenanceName = $('#annualMaintenanceNameFollowUp').val();
    
	var input1 = document.getElementById('annualMaintenanceNameFollowUp'), list = document
	.getElementById('cat_drop22'), i, fkMaintId;
    for (i = 0; i < list.options.length; ++i) 
    {
    	if (list.options[i].value === input1.value) 
	    {
    		fkMaintId = list.options[i].getAttribute('data-value');
	    }
    }
    
    
    params["annualMaintenanceName"] = annualMaintenanceName;
    params["fkMaintId"] = fkMaintId;
    
    params["methodName"] = "getVendorNameForFollowUp";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{ 
				var count = 1;
				var total=0;
				
				var jsonData = $.parseJSON(data);
				$.each(jsonData,function(i,v)
				{
					document.getElementById("vendorNameFollwUp").value = v.vendorName;

				});
		
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
	


}



//Grid for Annual Maintenance FollowUp
function getGridForMaintenanceFollowUp()
{
	var params={};
	var count=0;
	var newrow;
	var rowId;
	
	var wingName = $('#wingName22').val();
	var buildingName = $('#buildingName22').val();
	
	params["wingName"] = wingName;
	params["buildingName"] = buildingName;
	
	params["methodName"] = "getGridForMaintenanceFollowUp";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		  var jsonData = $.parseJSON(data);
			
	     // $("#list4").jqGrid("clearGridData", true).trigger("reloadGrid");
		
        
	     $.each(jsonData,function(i,v)
			{
	    	 count = jQuery("#product_grid").jqGrid('getGridParam', 'records'); 
		     var rowdata =$("#product_grid").jqGrid('getGridParam','data');
		     var ids = jQuery("#product_grid").jqGrid('getDataIDs');
			 
			
			  var prodName,com,packing,unit;
			  for (var j = 0; j < count; j++) 
			  {
				  prodName = rowdata[j].wingName;
				
				 var rowId = ids[j];
				 var rowData = jQuery('#product_grid').jqGrid ('getRowData', rowId);
					
				if (!prodName == jsonData.offer.wingName) 
				{
						newrow=true;
			    	
						alert("Wing Name Already Inserted !!!");
						var grid = jQuery("#product_grid");
				    	grid.trigger("reloadGrid");
				    	break;
				}
				else
				{
					newrow = true;
				}
				
			 }
			  
			  if(newrow == true)
				 {
					
				  //$("#product_grid").addRowData(i,jsonData[i]);
				  $("#product_grid").addRowData(count,jsonData.offer);
					
				 }
		
		
		$("#product_grid").jqGrid({
			datatype: "local",
			
			colNames:['Wing Name','Building Name','Work Description'],
			colModel:[ 
				
               
			     {	name:'wingName',
			    	 width:30,
			    	 editable: true
			    	
				},
				
				{	name:'buildingName',
			    	 width:30,
			    	 editable: true
			    	 
				},
			       
			   
				{	name:'description',
					width:70,
					editable: true
					
				}
				
			],
			
			
			sortorder : 'desc',
			loadonce: false,
			viewrecords: true,
			width: 600,
			//height: 350,
			shrinkToFit:true,
            rowheight: 300,
            hoverrows: true,
	        rownumbers: true,
            rowNum: 10,
            'cellEdit':true,
         	 afterSaveCell: function  grossTotal() 
				{
	        	},
           
			pager: "#jqGridPager",
			
			
			
		});
		
	
		//$("#product_grid").addRowData(i+1,jsonData[i]);
		if(count==0 || count==null)
		{
			 // $("#product_grid").addRowData(i,jsonData[i]);
			  $("#product_grid").addRowData(0,jsonData.offer);
		}
		

     
		 $('#product_grid').navGrid('#jqGridPager',
	                
	                { edit: true, add: false, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
	                
	                {
	                    editCaption: "The Edit Dialog",
	                   
	                    afterSubmit: function () {
							
	                      var grid = $("#product_grid"),
						  intervalId = setInterval(
						   function() 
						   {
						         grid.trigger("reloadGrid",[{current:true}]);
						   },
						   500);
	                	},
						
						 recreateForm: true,
						 checkOnUpdate : true,
						 checkOnSubmit : true,
		                 closeAfterEdit: true,
						
	                    errorTextFormat: function (data) {
	                        return 'Error: ' + data.responseText
	                    }
	                },
	                
	                {
	                    closeAfterAdd: true,
	                    recreateForm: true,
	                    errorTextFormat: function (data) {
	                        return 'Error: ' + data.responseText
	                    }
	                },
	                
	                {
	                	closeAfterdel:true,
	                	checkOnUpdate : true,
						checkOnSubmit : true,
						recreateForm: true,
	                	
						reloadAftersubmit:true,	
	                    errorTextFormat: function (data) {
	                        return 'Error: ' + data.responseText
	                        
	                        
	                    },
		                    afterComplete: function() {
		                    var rowId =$("#product_grid").jqGrid('getGridParam','selrow');  
		                    var rowData = jQuery("#product_grid").getRowData(rowId);
		               }
	                });
			   });
		})
}


function validationMaintenanceFollowUpDetails()
{
	var annualMaintenanceNameFollowUp = $('#annualMaintenanceNameFollowUp').val();
	var maintenanceFollowUpDate = $('#maintenanceFollowUpDate').val();
	var vendorname = $('#vendorName').val();
	
	var wingName = $('#wingName22').val();
	var buildingName = $('#buildingName22').val();
	
	var type1 = $('#Association').val();
	var type2 = $('#WingWise').val();
	
    var type = document.getElementsByName('type');

    /*if(vendorname=="" || vendorname==null || vendorname==undefined)
	{
		alert('Please select vendor name');
		return false;
	}*/
	
	if(annualMaintenanceNameFollowUp=="" || annualMaintenanceNameFollowUp==null || annualMaintenanceNameFollowUp==undefined)
	{
		alert('Please select maintenance name');
		return false;
	}
	if(maintenanceFollowUpDate=="" || maintenanceFollowUpDate==null || maintenanceFollowUpDate==undefined)
	{
		alert('Please select maintenance followup date');
		return false;
	}
	
	
	var genValue = false;

    for(var i=0; i<type.length;i++){
        if(type[i].checked == true){
            genValue = true;    
        }
    }
    if(!genValue){
        alert("Please Choose type");
        return false;
    }
	

	if(document.exp22.Association.checked)
	{
		addMaintenanceFollowUpDetails();
		
	}

	if(document.exp22.WingWise.checked)
	{
		if(wingName=="" || wingName==null || wingName==undefined)
		{
			alert('Please select wing name');
			return false;
		}
		
		if(buildingName=="" || buildingName==null || buildingName==undefined)
		{
			alert('Please select building name');
			return false;
		}
		addMaintenanceFollowUpDetails()
	}
	
}



//add Maintenance FollowUp Details
function addMaintenanceFollowUpDetails()
{
	var params = {};
	
	var count = jQuery("#product_grid").jqGrid('getGridParam', 'records');
	var allRowsInGrid = $('#product_grid').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	
	if(count==null)
	{
		if(wingName=="" || wingName==null || wingName ==undefined)
		{
			wingName="ALL";
			params["wingName"]=wingName;
		}
		
		if(buildingName=="" || buildingName==null || buildingName ==undefined)
		{
			buildingName="ALL";
			params["buildingName"]=buildingName;
		}
		
		if(description=="" || description==null || description ==undefined)
		{
			description="N/A";
			params["description"]=description;

		}

		count='0';	
	}
	else
	{
		for(var i=0;i<count;i++)
		{
			var wingName = allRowsInGrid[i].wingName;
			params["wingName"+i]=wingName;
			
			var buildingName = allRowsInGrid[i].buildingName;
			params["buildingName"+i]=buildingName;
			
			var description = allRowsInGrid[i].description;
			params["description"+i]=description;
		}
	}
	
	var input1 = document.getElementById('annualMaintenanceNameFollowUp'),
	list = document.getElementById('cat_drop22'),
	i,fkMaintenanceId;
	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
			fkMaintenanceId = list.options[i].getAttribute('data-value');
		}
	}
	
	
	var annualMaintenanceNameFollowUp = $('#annualMaintenanceNameFollowUp').val();
	var maintenanceFollowUpDate = $('#maintenanceFollowUpDate').val();
	var vendorNameFollwUp = $('#vendorNameFollwUp').val();
	
	var type1 = $('#Association').val();
	var type2 = $('#WingWise').val();
	
	if(document.exp22.Association.checked)
	{
		params["type"] = type1;
	}
	if(document.exp22.WingWise.checked)
	{
		params["type"] = type2;
	}
	
	params["count"] =count;

	params["fkMaintenanceId"] =fkMaintenanceId;
	params["annualMaintenanceNameFollowUp"] =annualMaintenanceNameFollowUp;
	params["maintenanceFollowUpDate"] =maintenanceFollowUpDate;
	params["vendorNameFollwUp"] =vendorNameFollwUp;
	
	params["methodName"] ="addMaintenanceFollowUpDetails";
	
	 $.post('/society/jsp/utility/controller.jsp',params,function(data){
		 
		 		alert(data);
		 		location.reload(true);
			}
	
	    	).error(function(jqXHR, textStatus, errorThrown){
	    		if(textStatus==="timeout") {
	    			$(loaderObj).hide();
	    			$(loaderObj).find('#errorDiv').show();
	    		
	    		}
	    	})
	    		    
}


//List Of Annual Maintenance Contract List
function AnnualMaintenanceContractList()
{
	var params= {};
	
	params["methodName"] = "AnnualMaintenanceContractList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#annualMaintenanceContractList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#annualMaintenanceContractList').DataTable( {

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
					          {"data": "annualMaintenanceName", "width": "5%" ,"defaultContent": ""},
					          {"data": "startDate", "width": "5%" ,"defaultContent": ""},
					          {"data": "endDate" , "width": "5%" ,"defaultContent": ""},
					          {"data": "vendorName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "amount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},				         
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance Contract List";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Annual Maintenance Contract List";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Annual Maintenance Contract List";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance Contract List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#annualMaintenanceContractList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}


//List Of Annual Maintenance FollowUp List
function AnnualMaintenanceFollowUpList()
{
	var params= {};
	
	params["methodName"] = "AnnualMaintenanceFollowUpList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#annualMaintenanceFollowUpList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#annualMaintenanceFollowUpList').DataTable( {

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
					          {"data": "annualMaintenanceName", "width": "5%" ,"defaultContent": ""},
					          {"data": "followUpDate", "width": "5%" ,"defaultContent": ""},
					          {"data": "vendorName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "type" , "width": "5%" ,"defaultContent": ""},
					          {"data": "wingName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "BuildingName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
					          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance FollowUp List";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Annual Maintenance FollowUp List";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Annual Maintenance FollowUp List";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance FollowUp List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#annualMaintenanceFollowUpList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}



//Annual Maintenance Contract Report
function annualMaintenanceContractReport()
{
	var params= {};
	
	var input1 = document.getElementById('annualMaintenanceName'),
	list = document.getElementById('cat_drop22'),
	i,fkMaintenanceId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
			fkMaintenanceId = list.options[i].getAttribute('data-value');
		}
	}
	
	var annualMaintenanceName = $('#annualMaintenanceName').val();
	
	params["fkMaintenanceId"] = fkMaintenanceId;
	params["annualMaintenanceName"] = annualMaintenanceName;
	
	params["methodName"] = "annualMaintenanceContractReport";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{
		
		$('#annualMaintenanceContractReport').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#annualMaintenanceContractReport').DataTable({

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
					          {"data": "annualMaintenanceName", "width": "5%" ,"defaultContent": ""},
					          {"data": "startDate", "width": "5%" ,"defaultContent": ""},
					          {"data": "endDate" , "width": "5%" ,"defaultContent": ""},
					          {"data": "vendorName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "amount" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				         
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance Contract Report";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance Contract Report";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance Contract Report";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance Contract Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});
		
		var mydata = catmap;
		$('#annualMaintenanceContractReport').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}



//Annual Maintenance Follow Up Report
function annualMaintenanceFollowUpReport()
{
	var params= {};
	
	var input1 = document.getElementById('annualMaintenanceFollowUpName'),
	list = document.getElementById('cat_drop222'),
	i,fkMaintenanceId;
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
			fkMaintenanceId = list.options[i].getAttribute('data-value');
		}
	}
	
	var annualMaintenanceFollowUpName = $('#annualMaintenanceFollowUpName').val();
	
	params["fkMaintenanceId"] = fkMaintenanceId;
	params["annualMaintenanceFollowUpName"] = annualMaintenanceFollowUpName;
	
	params["methodName"] = "annualMaintenanceFollowUpReport";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{
		
		$('#annualMaintenanceFollorUpReport').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#annualMaintenanceFollorUpReport').DataTable({

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
					          {"data": "annualMaintenanceName", "width": "5%" ,"defaultContent": ""},
					          {"data": "followUpDate", "width": "5%" ,"defaultContent": ""},
					          {"data": "vendorName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "type" , "width": "5%" ,"defaultContent": ""},
					          {"data": "wingName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "BuildingName" , "width": "5%" ,"defaultContent": ""},
					          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				         
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance FollowUp Report";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance FollowUp Report";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance FollowUp Report";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Annual Maintenance FollowUp Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#annualMaintenanceFollorUpReport').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}