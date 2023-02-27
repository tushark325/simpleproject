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

function validationAddNotice_CircularDetails()
{
	var designation = $('#designation').val();
	var fk_member_id = $('#fk_member_id').val();
	var date2 = $('#date2').val();
	var subject = $('#subject').val();
	var description = $('#description').val();

	if(designation=="" || designation==null)
	{
		alert("Please select send to");
		return false;
	}
	
	if(designation=="Individual")
	{
		if(fk_member_id=="" || fk_member_id==null || fk_member_id==undefined)
		{
			alert("Please select member name");
			return false;
		}
		
	}
	
	if(subject=="" || subject==null)
	{
		alert("Please subject");
		return false;
	}
	
	if(description=="" || description==null)
	{
		alert("Please description");
		return false;
	}
	
	addNotice_CircularDetails()
}



function addNotice_CircularDetails() 
{

	var sendTo = $('#designation').val();
	var date2 = $('#date2').val();
	var subject = $('#subject').val();
	var description = $('#description').val();
	var memberName = $('#fk_member_id').val();
	
	var input1 = document.getElementById('fk_member_id'),
	list = document.getElementById('memeberNameList'),
	i,fkMemberId;
	
	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
			fkMemberId = list.options[i].getAttribute('data-value');
		}
	}
	
	if(fkMemberId=="" || fkMemberId==null || fkMemberId==undefined)
	{
		fkMemberId = "00";
	}
	
	if(memberName=="" || memberName==null || memberName==undefined)
	{
		memberName = "N/A";
	}
	var params = {};
	
	params["fkMemberId"] = fkMemberId;
	params["memberName"] = memberName;
	params["sendTo"] = sendTo;
	params["date2"] = date2;
	params["subject"] = subject;
	params["description"] = description;
	
	params["methodName"] = "addNotice_CircularDetails";

	$.post('/society/jsp/utility/controller.jsp', params, function(data) 
	{
		alert(data);
		window.open("Notice_CircularPDF.jsp");
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
	if(document.expenseDetails.expenseName.value == "")
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

//List Of notice_circular list 
function notice_circularList()
{
	var params= {};

	params["methodName"] = "notice_circularList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#notice_circularList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#notice_circularList').DataTable( {
				
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
					          {"data": "sendTo" , "width": "5%" ,"defaultContent": ""},
					          {"data": "memberName", "width": "5%" ,"defaultContent": ""},
					          {"data": "date", "width": "5%" ,"defaultContent": ""},
					          {"data": "subject", "width": "5%" ,"defaultContent": ""},
					          {"data": "description", "width": "5%" ,"defaultContent": ""},
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
			                    		 return "Notice Circular List";
			                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Notice Circular List";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Notice Circular List";
					                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Notice Circular List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#notice_circularList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

