

// Calculations for GST and Gross Total for HR Billing
function CalculateGstAmount() 
{
	var subTotal = $('#subTotal').val();
	var gst = $('#gst').val();
	var Total = Number(subTotal) * Number(gst);
	var vat = (Total) / 100;
	document.getElementById("vat").value = vat;

	var grossTotal1 = Number(subTotal) + Number(vat);
	document.getElementById("grossTotal1").value = grossTotal1;

}




// Calculations for GST and Gross Total for product Billing
function CalculateGstAmount1() {
	
	var subTotal1 = $('#subTotal1').val();
	var gst1 = $('#gst1').val();
	var Total1 = Number(subTotal1) * Number(gst1);
	var vat1 = (Total1) / 100;
	document.getElementById("vat1").value = vat1;

	var grossTotal2 = Number(subTotal1) + Number(vat1);
	document.getElementById("grossTotal2").value = grossTotal2;

}

// Validation for Product Billing
function associationBillingDetailsValidation()
{	
	if(document.productForm.name.value=="")
	{
		alert('Please enter name. . .');
		return false;
	}
	if(document.productForm.billingDate1.value=="")
	{
		alert('Please Select Billing Date. . .');
		return false;

	}

	var count = jQuery("#productGrid").jqGrid('getGridParam', 'records');
	if(count <= 0)
	{
		alert('Please Enter Description. . .');
		return false;

	}
	var allRowsInGrid = $('#productGrid').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	
	for(var i=0;i<count;i++)
	{
		var quantity = allRowsInGrid[i].quantity;
		var buyPrice = allRowsInGrid[i].buyPrice;
		
		if(quantity=="" || quantity==null)
		{
			alert("Please Enter Quantity in Grid");
			return false;
		}
		var letterNumber = /^[0-9]+$/;
		if(quantity.match(letterNumber))
		{
			if(buyPrice=="" || buyPrice==null)
			{
				alert("Please Enter Buy Price in Grid");
				return false;
			}
			var letterNumber = /^[0-9]+$/;
			if(buyPrice.match(letterNumber))
			{
				/*if(document.productForm.gst1.value=="")
				{
					alert('Please Enter Gst %. . .');
					return false;

				}*/
			}			
			else
			{
				alert("Please Enter Number in Buy Price in Grid");
				return false;
			}	
		
		}
		else
		{
			alert("Please Enter Number in Quantity in Grid");
			return false;
		}
	}
	
	associationBillingDetails();
}


// Adding Product Billing
function associationBillingDetails()
{

	/* document.exp.btn.disabled = true; */
	var params = {};
	
	var count = jQuery("#productGrid").jqGrid('getGridParam', 'records');
	var allRowsInGrid = $('#productGrid').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	
	for(var i=0;i<count;i++)
	{
		var description = allRowsInGrid[i].description;
		params["description"+i] = description;
		
		var quantity = allRowsInGrid[i].quantity;
		params["quantity"+i] = quantity;
		
		var buyPrice = allRowsInGrid[i].buyPrice;
		params["buyPrice"+i] = buyPrice;
		
		var total = allRowsInGrid[i].total;
		params["total"+i] = total;
		
	}

	var name = $('#name').val();
	var billingDate = $('#billingDate1').val(); 
	var grossTotal2 = $('#grossTotal2').val();

	params["count"] = count;
	params["name"] = name;
	params["billingDate"] = billingDate;
	params["grossTotal2"] = grossTotal2;
	
	params["methodName"] = "associationBillingInfo";

	$.post('/society/jsp/utility/controller.jsp', params, function(data)
			{
					alert(data);
					window.open("AssociationBillingPDF.jsp");
					location.reload();
					
	}).error(function(jqXHR, textStatus, errorThrown) {
		if (textStatus === "timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}





//Hr Billing Grid
function getHrBillingGrid()
{
	if(document.hrBilling.description.value=="" || document.hrBilling.description.value==null)
		{
			alert('enter description. . .');
			return false;
		
		}
	
	
	getHrBillingGridAsPerDescription();
	
}

function getHrBillingGridAsPerDescription()
	{
		var params={};
		var count=0;
		var newrow;
		var rowId;
		
		var description=$('#description').val();
		
		document.hrBilling.description.value="";
		params["description"] = description;
		
		params["methodName"] ="gridForHrBill";
		
		 $.post('/society/jsp/utility/controller.jsp',params,function(data)
				{
			  var jsonData = $.parseJSON(data);
				
		      // $("#jqgrid").jqGrid("clearGridData", true).trigger("reloadGrid");
			
	        
		     $.each(jsonData,function(i,v)
				{
		    	 
		    	 
		    	 count = jQuery("#jqgrid").jqGrid('getGridParam', 'records'); 
			     var rowdata =$("#jqgrid").jqGrid('getGridParam','data');
			     var ids = jQuery("#jqgrid").jqGrid('getDataIDs');
			     
				
				  var prodName,com,packing,unit;
				  for (var j = 0; j < count; j++) 
				  {
					  prodName = rowdata[j].description;
					
					 var rowId = ids[j];
					 var rowData = jQuery('#jqgrid').jqGrid ('getRowData', rowId);
					
					if (prodName == jsonData.offer.description) 
					{
				    	newrow=false;
						alert("Product Name Already Inserted !!!");
						var grid = jQuery("#jqgrid");
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
						
					  //$("#jqgrid").addRowData(i,jsonData[i]);
					  $("#jqgrid").addRowData(count,jsonData.offer);
						
					 }
			
		
			$("#jqgrid").jqGrid({
				datatype: "local",
				
				colNames:['Description'/*,'Quantity','Buy Price'*/,'Amount'],
				colModel:[ 
					

				     {	name:'description',
				    	 width:100,
				    	 editable: true
				    	
					},
					
	/*				   
					{	name:'quantity',
						width:50,
						editable: true
						
					},
					
					{	name:'buyPrice',
				    	 width:50,
				    	 editable: true
					},
				       */
				
					{	name:'total',
						width:30,
						editable: true
						
					}
					
				],
					
				
				sortorder : 'desc',
				loadonce: false,
				viewrecords: true,
				width: 400,
				//height: 350,
				shrinkToFit:true,
	            rowheight: 300,
	            hoverrows: true,
		        rownumbers: true,
	            rowNum: 10,
	            'cellEdit':true,
	         	 afterSaveCell: function  grossTotal() {
				       /* 	Calculation of total after editing quantity*/
				        	   
				        	   // $(this).trigger('reloadGrid');
				        	    var rowId =$("#jqgrid").jqGrid('getGridParam','selrow');  
		                        var rowData = jQuery("#jqgrid").getRowData(rowId);
		                        var total = rowData['total'];
		                        /*	var quantity = rowData['quantity'];
		                    	var buyPrice = rowData['buyPrice'];
		                    	
		                    	var tota = quantity * buyPrice;
	                    		$("#jqgrid").jqGrid("setCell", rowId, "total", tota);
	                    	*/	
	                    		var Total =0;
	                    		var count = jQuery("#jqgrid").jqGrid('getGridParam', 'records');
	        		        	var allRowsInGrid1 = $('#jqgrid').getGridParam('data');
	        		        	var AllRows=JSON.stringify(allRowsInGrid1);
	        		        	for (var k = 0; k < count; k++) {
	        		        		var Total1 = allRowsInGrid1[k].total;
	        		        		Total = +Total + +Total1;
	        		        	}
	        		        	/*document.getElementById("subTotal").value = Total;
	        		        	document.getElementById("gst").value = "";
		     		        	document.getElementById("vat").value = "";*/
		     		        	document.getElementById("grossTotal1").value = Total;
		     		        	
		                    	
		        	},
	           
				pager: "#jqGridPager",
				
				
				
			});
			
		
			//$("#jqgrid").addRowData(i+1,jsonData[i]);
			if(count==0 || count==null)
			{
				 // $("#jqgrid").addRowData(i,jsonData[i]);
				  $("#jqgrid").addRowData(0,jsonData.offer);
			}
			

	     
			 $('#jqgrid').navGrid('#jqGridPager',
		                
		                { edit: true, add: false, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
		                
		                {
		                    editCaption: "The Edit Dialog",
		                   
		                    afterSubmit: function () {
								
		                      var grid = $("#jqgrid"),
							  intervalId = setInterval(
								 function() {
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
			                    var rowId =$("#jqgrid").jqGrid('getGridParam','selrow');  
			                       var rowData = jQuery("#jqgrid").getRowData(rowId);
			                       var total = rowData['total'];
			                    	/*var quantity = rowData['quantity'];
			                    	var buyPrice = rowData['buyPrice'];
			                    	
			                    	var tota = quantity * buyPrice;
		                 		$("#jqgrid").jqGrid("setCell", rowId, "total", tota);*/
		                 		
	                 		var Total =0;
	                 		var count = jQuery("#jqgrid").jqGrid('getGridParam', 'records');
	     		        	var allRowsInGrid1 = $('#jqgrid').getGridParam('data');
	     		        	var AllRows=JSON.stringify(allRowsInGrid1);
	     		        	for (var k = 0; k < count; k++) {
	     		        		var Total1 = allRowsInGrid1[k].total;
	     		        		Total = +Total + +Total1;
	     		        	}
	     		   /*     	document.getElementById("subTotal").value = Total;
	     		        	
	     		        	document.getElementById("gst").value = "";
	     		        	document.getElementById("vat").value = "";*/
	     		        	
	     		        	document.getElementById("grossTotal1").value = Total;
	     		        	
		                  }
		                });
			 
				});
				
			})

	
	}	
	
	
//Add Member Billing validation 
function addMemberBillValidation()
{
	
	if(document.hrBilling.fk_member_id.value==""){
		alert("Please Select Member Name");
		 return false;
	 }

	
	if(document.hrBilling.billingDate.value=="")
	{
		alert("Please Select Billing Date");
		 return false;
	 }
	
/*	if(document.hrBilling.billingPeriodFrom.value=="")
	{
		alert("Please Select Billing Peroiod From Date");
		 return false;
	 }
	
	
	if(document.hrBilling.billingPeriodTo.value=="")
	{
		alert("Please Select Billing Period To Date");
		 return false;
	 }*/
	
	var count = jQuery("#jqgrid").jqGrid('getGridParam', 'records');
	
	
	if(count <= 0)
	{
		 alert("Please Enter description");
		 return false;
	}
	
	
	var count = jQuery("#jqgrid").jqGrid('getGridParam', 'records');
	var allRowsInGrid = $('#jqgrid').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	
	for(var i=0;i<count;i++)
	{

			var total = allRowsInGrid[i].total;
			
			
			if(total=="" || total==null)
			{
				alert("Please Enter Amount in Grid");
				return false;
			}
			var letterNumber = /^[0-9]+$/;
			if(total.match(letterNumber))
			{
			
			}
			else
			{
				alert("Please Enter Numbers in Quantity in Grid");
				return false;
			}
	}

	addMemberBillDetails();
		
	
}

//Add MemberBill Info
function addMemberBillDetails()
{
	var params = {};
	var count = jQuery("#jqgrid").jqGrid('getGridParam', 'records');
	var allRowsInGrid = $('#jqgrid').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	
	for(var i=0;i<count;i++)
	{

		
		var description = allRowsInGrid[i].description;
		params["description"+i] = description;
		
		var total = allRowsInGrid[i].total;
		params["total"+i] = total;

	}

	//var billno = $('#billno').val();
	
	var memberName = $('#fk_member_id').val();
	var billingDate = $('#billingDate').val();
	var grossTotal1 =$('#grossTotal1').val();
	
	var input1 = document.getElementById('fk_member_id'),
	list = document.getElementById('memeberNameList'), i, fkMemberId;

	for (i = 0; i < list.options.length; ++i) 
	{
		if (list.options[i].value === input1.value) 
		{
			fkMemberId = list.options[i].getAttribute('data-value');
		}
	}
	
	params["count"] = count;
	
	params["fkMemberId"] = fkMemberId; 
	params["memberName"] = memberName;
	params["billingDate"] = billingDate;
	params["grossTotal1"] = grossTotal1;
	//params["billno"] = billno;
	
	params["methodName"] = "MemberBillingDetails";

	$.post('/society/jsp/utility/controller.jsp', params, function(data) 
	{
		alert(data);
			window.open("MemberBillingPDF.jsp");
			/*window.open("VendorBillingPDF.jsp");*/
		location.reload();
		
	}).error(function(jqXHR, textStatus, errorThrown) {
		if (textStatus === "timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});

}



//get Product Billing Grid validation
function getProductBillingGrid()
{
	if(document.productForm.description1.value=="" || document.productForm.description1.value==null)
		{
			alert('Enter description. . .');
			return false;
		
		}
	getProductGridAsPerDescription();
	
}

//get Product Billing Grid
function getProductGridAsPerDescription()
	{
		var params={};
		var count=0;
		var newrow;
		var rowId;
		
		var description=$('#description1').val();
		
		document.productForm.description1.value="";

		params["description"] = description;
		
		params["methodName"] ="gridForProductBill";
		
		 $.post('/society/jsp/utility/controller.jsp',params,function(data)
				{
			  var jsonData = $.parseJSON(data);
				
		      // $("#productGrid").jqGrid("clearGridData", true).trigger("reloadGrid");
			
	        
		     $.each(jsonData,function(i,v)
				{
		    	 
		    	 
		    	 count = jQuery("#productGrid").jqGrid('getGridParam', 'records'); 
			     var rowdata =$("#productGrid").jqGrid('getGridParam','data');
			     var ids = jQuery("#productGrid").jqGrid('getDataIDs');
			     
				
				  var prodName,com,packing,unit;
				  for (var j = 0; j < count; j++) 
				  {
					  prodName = rowdata[j].description;
					
					 var rowId = ids[j];
					 var rowData = jQuery('#productGrid').jqGrid ('getRowData', rowId);
					
					if (prodName == jsonData.offer.description) 
					{
				    	newrow=false;
						alert("Product Name Already Inserted !!!");
						var grid = jQuery("#productGrid");
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
						
					  //$("#productGrid").addRowData(i,jsonData[i]);
					  $("#productGrid").addRowData(count,jsonData.offer);
						
					 }
			
			
			$("#productGrid").jqGrid({
				datatype: "local",
				
				colNames:['Description','Quantity','Sale Price','Total'],
				colModel:[ 
					
	               
				     {	name:'description',
				    	 width:70,
				    	 editable: true
				    	
					},
					
					   
					{	name:'quantity',
						width:50,
						editable: true
						
					},
					
					{	name:'buyPrice',
				    	 width:50,
				    	 editable: true
					},
				       
				
					{	name:'total',
						width:70,
						
					}
					
				],
					
				
				sortorder : 'desc',
				loadonce: false,
				viewrecords: true,
				width: 700,
				//height: 350,
				shrinkToFit:true,
	            rowheight: 300,
	            hoverrows: true,
		        rownumbers: true,
	            rowNum: 10,
	            'cellEdit':true,
	         	 afterSaveCell: function  grossTotal() {
				       /* 	Calculation of total after editing quantity*/
				        	   
				        	   // $(this).trigger('reloadGrid');
				        	    var rowId =$("#productGrid").jqGrid('getGridParam','selrow');  
		                        var rowData = jQuery("#productGrid").getRowData(rowId);
		                    	var quantity = rowData['quantity'];
		                    	var buyPrice = rowData['buyPrice'];
		                    	
		                    	var tota = quantity * buyPrice;
	                    		$("#productGrid").jqGrid("setCell", rowId, "total", tota);
	                    		
	                    		var Total =0;
	                    		var count = jQuery("#productGrid").jqGrid('getGridParam', 'records');
	        		        	var allRowsInGrid1 = $('#productGrid').getGridParam('data');
	        		        	var AllRows=JSON.stringify(allRowsInGrid1);
	        		        	for (var k = 0; k < count; k++) {
	        		        		var Total1 = allRowsInGrid1[k].total;
	        		        		Total = +Total + +Total1;
	        		        	}
	        		        	
		     		        	document.getElementById("grossTotal2").value = Total;
		                    	
		        	},
	           
				pager: "#jqGridPager1",
				
			});
			
		
			//$("#productGrid").addRowData(i+1,jsonData[i]);
			if(count==0 || count==null)
			{
				 // $("#productGrid").addRowData(i,jsonData[i]);
				  $("#productGrid").addRowData(0,jsonData.offer);
			}
			

	     
			 $('#productGrid').navGrid('#jqGridPager1',
		                
		                { edit: true, add: false, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
		                
		                {
		                    editCaption: "The Edit Dialog",
		                   
		                    afterSubmit: function () {
								
		                      var grid = $("#productGrid"),
							  intervalId = setInterval(
								 function() {
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
			                    var rowId =$("#productGrid").jqGrid('getGridParam','selrow');  
			                       var rowData = jQuery("#productGrid").getRowData(rowId);
			                    	var quantity = rowData['quantity'];
			                    	var buyPrice = rowData['buyPrice'];
			                    	
			                    	var tota = quantity * buyPrice;
		                 		$("#productGrid").jqGrid("setCell", rowId, "total", tota);
		                 		
	                 		var Total =0;
	                 		var count = jQuery("#productGrid").jqGrid('getGridParam', 'records');
	     		        	var allRowsInGrid1 = $('#productGrid').getGridParam('data');
	     		        	var AllRows=JSON.stringify(allRowsInGrid1);
	     		        	for (var k = 0; k < count; k++) {
	     		        		var Total1 = allRowsInGrid1[k].total;
	     		        		Total = +Total + +Total1;
	     		        	}
	     		  
	     		        	document.getElementById("grossTotal2").value = Total;
	     		        	
		                  }
		                });
			 
				});
				
			})

	
	}	




//List Of member billing
function memberBillingList()
{
	var params= {};

	params["methodName"] = "getAllMemberBillingList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#memBillingList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#memBillingList').DataTable( {
				
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
					          {"data": "memberName" , "width": "7%" ,"defaultContent": ""},
					          {"data": "date", "width": "5%" ,"defaultContent": ""},
					          {"data": "description", "width": "5%" ,"defaultContent": ""},
					          {"data": "amount", "width": "5%" ,"defaultContent": ""},
					          {"data": "grossTotal", "width": "5%" ,"defaultContent": ""},
					          {"data": "billNo", "width": "5%" ,"defaultContent": ""},
					          
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
		$('#memBillingList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}



//List Of association billing
function assocationBillingList()
{
	var params= {};

	params["methodName"] = "getAllAssociationBillingList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#associationBillingList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#associationBillingList').DataTable( {
				
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
					          {"data": "name" , "width": "7%" ,"defaultContent": ""},
					          {"data": "dateOfBilling", "width": "5%" ,"defaultContent": ""},
					          {"data": "description", "width": "5%" ,"defaultContent": ""},
					          {"data": "quantity", "width": "5%" ,"defaultContent": ""},
					          {"data": "salePrice", "width": "5%" ,"defaultContent": ""},
					          {"data": "subTotal", "width": "5%" ,"defaultContent": ""},
					          {"data": "total", "width": "5%" ,"defaultContent": ""},
					          {"data": "billNo", "width": "5%" ,"defaultContent": ""},
					          
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
		$('#associationBillingList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}
	
/*

function hrBillingList()
{


	var params= {};
	
	params["methodName"] = "getExpenditurePaymentList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		
		$('#hrBillingList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#hrBillingList').DataTable( {

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
				        
				          {"data": "vendorName", "width": "5%" ,"defaultContent": ""},
				          {"data": "dateOfBilling", "width": "5%" ,"defaultContent": ""},
				          {"data": "dateOfBillingFrom", "width": "5%" ,"defaultContent": ""},
				          {"data": "dateOfBillingTo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "description" , "width": "5%" ,"defaultContent": ""},
				          {"data": "quantity" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "buyPrice" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "total" , "width": "5%" ,"defaultContent": ""},
				          {"data": "subTotal" , "width": "5%" ,"defaultContent": ""},
				          {"data": "gst" , "width": "5%" ,"defaultContent": ""},
				          {"data": "vat" , "width": "5%" ,"defaultContent": ""},
				          {"data": "grossTotal" , "width": "5%" ,"defaultContent": ""},
				          
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Hr Billing Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#hrBillingList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

*/
/*
function productBillingList()
{




	var params= {};

	params["methodName"] = "getPurchaseOrderReceiveList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#purchaseOrderReceiveList').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#purchaseOrderReceiveList').DataTable( {

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
				          {"data": "vendorName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "type", "width": "5%" ,"defaultContent": ""},
				          {"data": "billNo", "width": "5%" ,"defaultContent": ""},
				          {"data": "purchaseDate", "width": "5%" ,"defaultContent": ""},
				          {"data": "expectPaymentDate" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "productName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "buyPrice" , "width": "5%" ,"defaultContent": ""},
				          {"data": "quantity" , "width": "5%" ,"defaultContent": ""},
				          {"data": "total" , "width": "5%" ,"defaultContent": ""},
				          {"data": "subSotal", "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "gst", "width": "5%" ,"defaultContent": ""},
				          {"data": "gstAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "grossTotal" , "width": "5%" ,"defaultContent": ""},
				          {"data": "balanceStatus" , "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Quotation Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#purchaseOrderReceiveList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});

}*/