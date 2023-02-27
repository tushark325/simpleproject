function CarPaymentValidation(){
	if(document.carPaymentForm.fk_car_id.value == "")
	{
		alert("Select Car Number.");
		return false;
	}	
	if(document.carPaymentForm.paidBy.value == "")
	{
		alert("Enter Paid By.");
		return false;
	}	
	if(document.carPaymentForm.carPaymentDate.value == "")
	{
		alert("Select Car Payment Date.");
		return false;
	}	
	if(document.carPaymentForm.paymentMode.value == "")
	{
		alert(" Enter Payment Mode.");
		return false;
	}	
	if(document.carPaymentForm.bankName.value == "")
	{
		alert("Enter bank Name.");
		return false;
		CarPaymentInfo();
	}	
	if(document.carPaymentForm.amount.value == "")
	{
		alert("Enter Amount.");
		return false;
		
	}	
	CarPaymentInfo();
}
	

//add purchase order details
function purchaseOrderInfo(){
	
	var params = {}
	
	var customerName= $('#customerName').val();
	var purchaseDate= $('#purchaseDate').val();
	var regard= $('#regard').val();
	var cost= $('#cost').val();
	var reference= $('#reference').val();
	var detail = $('#detail').val();
	var requirement = $('#requirement').val();
	
	params["customerName"] = customerName;
	params["purchaseDate"] = purchaseDate;
	params["regard"] = regard;
	params["cost"] = cost;
	params["reference"] = reference;
	params["detail"] = detail;
	params["requirement"] = requirement;
	
    params["methodName"] = "PurchaseOrderInfo";
	
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



//------------Grid Start of PURCHASE ORDER RECEIVE-----------------

// Grid validation of product name in Purchase Order Receive
function getGridForProductInRecive(){
	
	if(document.product.productname.value=="" || document.product.productname.value==null)
	{
		alert('Please enter product name===');
		return false;
		
	}
	getGridAsForProduct();
}

// get Grid of Purchase Order Receive
function getGridAsForProduct()
{
		var params={};
		var count=0;
		var newrow;
		var rowId;
		
		var productname=$('#productname').val();
		
		params["productname"] = productname;
		
		params["methodName"] ="gridForPurchase";
		
		 $.post('/society/jsp/utility/controller.jsp',params,function(data)
				{
			  var jsonData = $.parseJSON(data);
				
		     // $("#list4").jqGrid("clearGridData", true).trigger("reloadGrid");
			
	        
		     $.each(jsonData,function(i,v)
				{
		    	 count = jQuery("#list4").jqGrid('getGridParam', 'records'); 
			     var rowdata =$("#list4").jqGrid('getGridParam','data');
			     var ids = jQuery("#list4").jqGrid('getDataIDs');
				 
				
				  var prodName,com,packing,unit;
				  for (var j = 0; j < count; j++) 
				  {
					  prodName = rowdata[j].productName;
					
					 var rowId = ids[j];
					 var rowData = jQuery('#list4').jqGrid ('getRowData', rowId);
					
					if (prodName == jsonData.offer.productName) 
					{
				    	newrow=false;
						alert("Product Name Already Inserted !!!");
						var grid = jQuery("#list4");
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
						
					  //$("#list4").addRowData(i,jsonData[i]);
					  $("#list4").addRowData(count,jsonData.offer);
						
					 }
			
			
			$("#list4").jqGrid({
				datatype: "local",
				
				colNames:['Product Name','Buy Price','Quantity','Total'],
				colModel:[ 
					
	               
				     {	name:'productName',
				    	 width:70,
				    	 editable: true
					},
					
					{	name:'buyPrice',
				    	 width:50,
				    	 editable: true
					},
				       
				   
					{	name:'quantity',
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
				width: 800,
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
				        	    var rowId =$("#list4").jqGrid('getGridParam','selrow');  
		                        var rowData = jQuery("#list4").getRowData(rowId);
		                    	var quantity = rowData['quantity'];
		                    	var buyPrice = rowData['buyPrice'];
		                    	
		                    	var tota = quantity * buyPrice;
	                    		$("#list4").jqGrid("setCell", rowId, "total", tota);
	                    		
	                    		var Total =0;
	                    		var count = jQuery("#list4").jqGrid('getGridParam', 'records');
	        		        	var allRowsInGrid1 = $('#list4').getGridParam('data');
	        		        	var AllRows=JSON.stringify(allRowsInGrid1);
	        		        	for (var k = 0; k < count; k++) {
	        		        		var Total1 = allRowsInGrid1[k].total;
	        		        		Total = +Total + +Total1;
	        		        	}
	        		        	document.getElementById("subTotal1").value = Total;
	        		        	document.getElementById("grossTotal1").value = Total;
	        		        	
		        	},
	           
				pager: "#jqGridPager",
				
				
				
			});
			
		
			//$("#list4").addRowData(i+1,jsonData[i]);
			if(count==0 || count==null)
			{
				 // $("#list4").addRowData(i,jsonData[i]);
				  $("#list4").addRowData(0,jsonData.offer);
			}
			

	     
			 $('#list4').navGrid('#jqGridPager',

		                { edit: true, add: false, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
		                
		                {
		                    editCaption: "The Edit Dialog",
		                   
		                    afterSubmit: function () {
								
		                      var grid = $("#list4"),
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
			                    var rowId =$("#list4").jqGrid('getGridParam','selrow');  
			                       var rowData = jQuery("#list4").getRowData(rowId);
			                    	var quantity = rowData['quantity'];
			                    	var buyPrice = rowData['buyPrice'];
			                    	
			                    	var tota = quantity * buyPrice;
		                 		$("#list4").jqGrid("setCell", rowId, "total", tota);
		                 		
	                 		var Total =0;
	                 		var count = jQuery("#list4").jqGrid('getGridParam', 'records');
	     		        	var allRowsInGrid1 = $('#list4').getGridParam('data');
	     		        	var AllRows=JSON.stringify(allRowsInGrid1);
	     		        	for (var k = 0; k < count; k++) {
	     		        		var Total1 = allRowsInGrid1[k].total;
	     		        		Total = +Total + +Total1;
	     		        	}
	     		        	
	     		        	document.getElementById("subTotal1").value = Total;
	     		        	document.getElementById("grossTotal1").value = Total;
	     		       	
        		        	document.getElementById("gst1").value = "";
        		        	document.getElementById("gstAmount").value = "";
        		        	
	     		        	
		                  }
		                });
				   });
			})
	}

//-----------End Grid of PURCHASE ORDER RECEIVE


//Start ------------Gst Amount And Gross Total------------

/*function getGstTotal()
{
	//var gstAmount;
	

	
	var gst = $('#gst').val();
	var subTotal = $('#subTotal').val();
	

	var gstAmt = (subTotal)*( gst)/100;
	
	document.getElementById('gstAmount').value = gstAmt;
	
	 var grossTotal = +subTotal + +gstAmt;
	 
	 document.getElementById('grossTotal').value = gstAmt;
}
*/



function getGstAmountTotal()
{

	
	var gst1 = $('#gst1').val();
	var subTotal1 = $('#subTotal1').val();
	
	var gstAmount = (gst1)*(subTotal1)/100;

	document.getElementById('gstAmount').value = gstAmount;
	
	var grossTotal1 = +subTotal1 + +gstAmount;
	
	document.getElementById('grossTotal1').value = grossTotal1;
}





function purchaseOrderDetailasValidation()
{
/*	if(document.product.vendor.checked=="" && document.product.client.checked=="")
	{
		alert("Please Select Type");
		return false;
	}*/
	if(document.product.vendorName.value=="" || document.product.vendorName.value==null)
	{
		alert("Please Select Name");
		return false;
	}
	if(document.product.poBillNo.value=="" || document.product.poBillNo.value==null)
	{
		alert("Please Enter Bill/Challan No");
		return false;
	}
	if(document.product.purchasedate.value=="" || document.product.purchasedate.value==null)
	{
		alert("Please Select Purchase Date");
		return false;
	}
	if(document.product.expectpaymentdate.value=="" || document.product.expectpaymentdate.value==null)
	{
		alert("Please Select Expect Payment Date");
		return false;
	}
	
	var count = jQuery("#list4").jqGrid('getGridParam', 'records');
	
	
	if(count<= 0)
	{
		alert('please enter product name.....');
		return false;
	}
	
	var allRowsInGrid = $('#list4').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	
	for(var i=0;i<count;i++)
	{	
		var buyPrice = allRowsInGrid[i].buyPrice;
		var quantity = allRowsInGrid[i].quantity;

/*		
		if(buyPrice=="" || buyPrice==null)
		{
			alert("Please Enter Buy Price In Grid");
			return false;
		}
		var checkBuyPrice = /^[0-9]*\.[0-9]{2}$/;
		if(buyPrice.match(checkBuyPrice))
		{	
			if(quantity=="" || quantity==null)
			{
				alert("Please Enter Quantity in Grid");
				return false;
			}
			var checkQuantity = /^[0-9]+$/;
			if(quantity.match(checkQuantity))
			{
			/*	if(document.product.gst1.value=="")
				{
					alert("Please Enter Gst %");
					return false;
				}
			*/
/*			}
			else
			{
				alert("Please Enter Numbers in Quantity in Grid");
				return false;
			}
		}
		else
		{
			alert("Please Enter Number in Buy Price in Grid");
			return false;
		}
*/	}
	
	purchaseOrderDetailas();
	
}

function purchaseOrderDetailas()
{	
	var params={};
	
	var input1 = document.getElementById('vendorName'),
	list = document.getElementById('vendorList_Drop'),
	i,fk_vendor_id;
	
	for (i = 0; i < list.options.length; ++i)
	{
		if (list.options[i].value === input1.value) 
		{
			fk_vendor_id = list.options[i].getAttribute('data-value');
		}
	}
	
	var count = jQuery("#list4").jqGrid('getGridParam', 'records');
	var allRowsInGrid = $('#list4').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	
	for(var i=0;i<count;i++)
	{
		var productName = allRowsInGrid[i].productDiscription;
		params["productName"+i]=productName;
		
		var  buyPrice = allRowsInGrid[i].buyPrice;
		params["buyPrice"+i]=buyPrice;
		
		var quantity = allRowsInGrid[i].quantity;
		params["quantity"+i]=quantity;
		
		var total = allRowsInGrid[i].total;
		params["total"+i]=total;
		
	}

	var vendorName = $('#vendorName').val();
	/*var type1 = $('#vendor').val();
	var type2= $('#client').val();*/
	
	var poBillNo = $('#poBillNo').val();
	
	
	
	
	
	var purchasedate = $('#purchasedate').val();
	var expectpaymentdate = $('#expectpaymentdate').val();	
	var subTotal1 = $('#subTotal1').val();
	var gst1 = $('#gst1').val();
	var gstAmount = $('#gstAmount').val();
	var grossTotal1 = $('#grossTotal1').val();
	
	/*if(document.getElementById('vendor').checked)
	{
		params["type"] = type1;
	}
	
	if(document.getElementById('client').checked)
	{
		params["type"] = type2;
	}
	*/
	
	params["vendorId"] = fk_vendor_id;
	params["vendorName"] = vendorName;
	params["poBillNo"] = poBillNo;
	params["purchasedate"] = purchasedate;
	params["expectpaymentdate"] = expectpaymentdate;
	params["subTotal1"] = subTotal1;
	params["gst1"] = gst1;
	params["gstAmount"] = gstAmount;
	params["grossTotal1"] = grossTotal1;
	
	params["count"] = count;
	
	/*params["methodName"] = "purchaseDetailas";*/
	params["methodName"] ="purchaseDetailas";
	
	 $.post('/society/jsp/utility/controller.jsp',params,function(data)
	 { 
 		alert(data);
 		location.reload();
	 }).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	})

}



function getVendorName()
{

	
	//var type = document.getElementById('vendor').value;
	
	$("#vendorList_Drop").empty();
	$("#vendorList_Drop").append($("<option></option>").attr("value","").text("Select product"));
	var params= {};
	
	params["methodName"] = "getAllVendorName";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)	
			{ var count = 1;

			var jsonData = $.parseJSON(data);
			$.each(jsonData,function(i,v)
					{
				$("#vendorList_Drop").append($("<option></option>").attr("value",(v.vendorName)).attr("data-value",(v.vendorId))); 
				count++;
					});
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {

				}
			});
}

function getClientName()
{
	
	//var type = document.getElementById('client').value;
	
		$("#vendorList_Drop").empty();
		$("#vendorList_Drop").append($("<option></option>").attr("value","").text("Select product"));
		var params= {};
		
		params["methodName"] = "getAllClientName";
		$.post('/society/jsp/utility/controller.jsp',params,function(data)	
				{ var count = 1;

				var jsonData = $.parseJSON(data);
				$.each(jsonData,function(i,v)
						{
					$("#vendorList_Drop").append($("<option></option>").attr("value",(v.firstName+" "+ v.lastName)).attr("data-value",(v.clientId))); 
					count++;
						});
				}).error(function(jqXHR, textStatus, errorThrown){
					if(textStatus==="timeout") {

					}
				});
	
}

//----------- Grid Start of PURCHASE CREATE----------------

/*// Validation for Product Description in purchase order create for Grid
function getGridForProductValidation()
{
	if(document.po.productdescription.value=="" || document.po.productdescription.value==null)
	{
		alert('please enter product name . . .');
		return false;
	}
	getGridForProduct();
}
*/


// Grid for Product Description in purchase order create
function getGridForProduct()
{
	var params={};
	var count=0;
	var newrow;
	var rowId;
	
	var productDescription = $('#productdescription').val();
	
	params["productDescription"] = productDescription;
	
	params["methodName"] = "gridForProductDescription";
	
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
				  prodName = rowdata[j].productDescription;
				
				 var rowId = ids[j];
				 var rowData = jQuery('#product_grid').jqGrid ('getRowData', rowId);
					
				if (!prodName == jsonData.offer.productDescription) 
				{
						newrow=true;
			    	
						alert("Product Name Already Inserted !!!");
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
			
			colNames:['Product Description','Quantity','Unit Price','Total'],
			colModel:[ 
				
               
			     {	name:'productDescription',
			    	 width:200,
			    	
			       	 editable: true
			    	
				},
				
				{	name:'quantity',
			    	 width:200,
			    	
			    	 editable: true
			    	 
				},
			       
			   
				{	name:'unitPrice',
					width:200,
					
					editable: true
					
				},
				{	name:'total',
					width:200,
					
					 
				}
				
			],
			
			
			sortorder : 'desc',
			loadonce: false,
			viewrecords: true,
			width: 700,
//			height: 350,
			
			shrinkToFit:true,
            rowheight: 300,
			
            hoverrows: true,
	        rownumbers: true,
            rowNum: 10,
            'cellEdit':true,
         	 afterSaveCell: function  grossTotal() {
			       /* 	Calculation of total after editing quantity*/
			        	   
			        	   // $(this).trigger('reloadGrid');
			        	    var rowId =$("#product_grid").jqGrid('getGridParam','selrow');  
	                        var rowData = jQuery("#product_grid").getRowData(rowId);
	                    	var quantity = rowData['quantity'];
	                    	var unitPrice = rowData['unitPrice'];
	                    	
	                    	var tota = quantity * unitPrice;
                    		$("#product_grid").jqGrid("setCell", rowId, "total", tota);
                    		
                    		var Total =0;
                    		var count = jQuery("#product_grid").jqGrid('getGridParam', 'records');
        		        	var allRowsInGrid1 = $('#product_grid').getGridParam('data');
        		        	var AllRows=JSON.stringify(allRowsInGrid1);
        		        	for (var k = 0; k < count; k++) {
        		        		var Total1 = allRowsInGrid1[k].total;
        		        		Total = +Total + +Total1;
        		        	}
        		        	document.getElementById("subtotal").value = Total;
        		        	document.getElementById("gst").value = "";
         		        	document.getElementById("vat").value = "";
         		        	document.getElementById("grossTotal").value = Total;
        		   
	                    	
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
		                    	var quantity = rowData['quantity'];
		                    	var unitPrice = rowData['unitPrice'];
		                    	
		                    	var tota = quantity * unitPrice;
	                 		$("#product_grid").jqGrid("setCell", rowId, "total", tota);
	                 		
                 		var Total =0;
                 		var count = jQuery("#product_grid").jqGrid('getGridParam', 'records');
     		        	var allRowsInGrid1 = $('#product_grid').getGridParam('data');
     		        	var AllRows=JSON.stringify(allRowsInGrid1);
     		        	for (var k = 0; k < count; k++) {
     		        		var Total1 = allRowsInGrid1[k].total;
     		        		Total = +Total + +Total1;
     		        	}
     		        	document.getElementById("subtotal").value = Total;
     		        	document.getElementById("gst").value = "";
     		        	document.getElementById("vat").value = "";
     		        	document.getElementById("grossTotal").value = Total;
     		        	 
		                    
		               }
	                    
	                 
	                    
	                });
		 
		 
			   });
			
		})
}

//------------Grid End of PURCHASE CREATE------------------




//Start-------------Gst and Gross Total Calculation of PURCHASE ORDER CREATE--------------
function getVatTotal()
{
	var vatValue;
	//var gst = document.getElementById('gst').val();
	
	var checkValue = /^[0-9]+\.?[0-9]*$/;
	
	var gst = $('#gst').val();
	var subTotal = $('#subtotal').val();
	
	if(gst.match(checkValue))
	{
		vatValue = (gst)*(subTotal)/100;
		
		document.getElementById('vat').value=vatValue;
		
		
		var grossTotal = +subTotal + +vatValue;
		
		document.getElementById('grossTotal').value=grossTotal;
	}
	else
	{
		var subTotal = $('#subtotal').val();
		
		alert("Please Enter Valid GST Percentage");
		document.getElementById('gst').value="0";
		document.getElementById('vat').value="0";
		document.getElementById('grossTotal').value=subTotal;
		return false;
	}
}

//---------------End Calculation------------




//Start-------------Gst and Gross Total Calculation of PURCHASE ORDER CREATE--------------
function getVatTotalAfterDelete()
{
	var vatValue;
	//var gst = document.getElementById('gst').val();
	var gst = $('#gst').val();
	var subTotal = $('#subtotal').val();
	
	
	vatValue = (gst)*(subTotal)/100;
	
	document.getElementById('vat').value=vatValue;
	
	
	var grossTotal = +subTotal + +vatValue;
	
	document.getElementById('grossTotal').value=grossTotal;

}

//---------------End Calculation------------


//validation for purchase Order Create Info

function purchaseOrderCreateValidation()
{
	var vendorname = $('#fk_vendor_id').val();
	
	if(vendorname=="" || vendorname==null || vendorname==undefined)
	{
		alert("Please select vendor name");
		return false;
	}
		
	var count = jQuery("#product_grid").jqGrid('getGridParam', 'records');
	if(count <= 0)
	{
		alert('please enter product name . . .');
		return false;
	}
	var allRowsInGrid = $('#product_grid').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	

	for(var i=0;i<count;i++)
	{		
		var  quantity = allRowsInGrid[i].quantity;
		var unitPrice = allRowsInGrid[i].unitPrice;		
		
		if(quantity=="" || quantity==null)
		{
			alert("Please Enter Quantity In Grid");
			return false;
		}
		
		var letterNumber = /^[0-9]+$/;
		if(quantity.match(letterNumber))
		{
			
			if(unitPrice=="" || unitPrice==null)
			{
				alert("Please Enter Unit Price In Grid");
				return false;
			}
			var letterNumber = /^[0-9]+$/;
			if(unitPrice.match(letterNumber))
			{
				
			 	if(document.po.gst.value=="" || document.po.gst.value==null)
				{
					alert('Please Enter Gst %');
					return false;
				}				
			}
			else
			{
				alert("Please Enter Numbers in Quantity");
				return false;
			}			
		}
		else
		{
			alert("Please Enter Numbers in Quantity");
			return false;
		}		
	}

	purchaseOrderCreateInfo();
	
}

//add and store info of purchase Order Create Info
function purchaseOrderCreateInfo()
{
	var params = {};
	
	var count = jQuery("#product_grid").jqGrid('getGridParam', 'records');
	var allRowsInGrid = $('#product_grid').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	

	for(var i=0;i<count;i++)
	{
		var productDescription = allRowsInGrid[i].productDescription;
		params["productDescription"+i]=productDescription;
		
		var  quantity = allRowsInGrid[i].quantity;
		params["quantity"+i]=quantity;
		
		var unitPrice = allRowsInGrid[i].unitPrice;
		params["unitPrice"+i]=unitPrice;
		
		var total = allRowsInGrid[i].total;
		params["total"+i]=total;
		
	}
	
	var input1 = document.getElementById('fk_vendor_id'),
	list = document.getElementById('vendorNameList'),
	i,fk_vendor_id;
	
	for (i = 0; i < list.options.length; ++i)
	{
		if (list.options[i].value === input1.value) 
		{
			fk_vendor_id = list.options[i].getAttribute('data-value');
		}
	}
	
	var vendorname = $('#fk_vendor_id').val();
	var vendorcompanyname = $('#vendorcompanyname').val();
	var contactno = $('#contactno').val();
	var streetaddress = $('#streetaddress').val();
	var city = $('#city').val();
	var zipcode = $('#zipcode').val();
	var phone = $('#phone').val();
	var fax = $('#fax').val();
	var subtotal = $('#subtotal').val();
	var gst = $('#gst').val();
	var vat = $('#vat').val();
	var grossTotal = $('#grossTotal').val();
	var companyAddress = $('#companyAddress').val();
	var gstinNumber = $('#gstinNumber').val();
	var panNumber = $('#panNumber').val();
	var cinNumber = $('#cinNumber').val();
	
	if(city=="")
	{
		city = "N/A";
	}
	
	if(zipcode=="")
	{
		zipcode = "N/A";
	}
	
	
	if(streetaddress=="")
	{
		streetaddress = "N/A";
	}
	
	params["count"] = count;	
	params["vendorname"] = vendorname;
	//params["fk_vendor_id"] = fk_vendor_id;
	params["vendorcompanyname"] = vendorcompanyname;
	params["contactno"] = contactno;
	params["streetaddress"] = streetaddress;
	params["city"] = city;
	params["zipcode"] = zipcode;
	params["phone"] = phone;
	params["fax"] = fax;
	params["subtotal"] = subtotal;
	params["gst"] = gst;
	params["vat"] = vat;
	params["grossTotal"] = grossTotal;	
	params["companyAddress"] = companyAddress;
	params["gstinNumber"] = gstinNumber;
	params["panNumber"] = panNumber;
	params["cinNumber"] = cinNumber;

	params["methodName"] ="purchaseOrderReciveInfo";
	
	 $.post('/society/jsp/utility/controller.jsp',params,function(data){
		 
		 		alert(data);
		 		window.open("Purchase_Order_RecivePDF.jsp");
		 		location.reload(true);
			}
	
	    	).error(function(jqXHR, textStatus, errorThrown){
	    		if(textStatus==="timeout") {
	    			$(loaderObj).hide();
	    			$(loaderObj).find('#errorDiv').show();
	    		
	    		}
	    	})
	    		    
}


function getVendorDetails()
{
	
	var input = document.getElementById('fk_vendor_id'),
	list = document.getElementById('vendorNameList'),

	i,fkRootSupId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkVendorId = list.options[i].getAttribute('data-value');
		}
	}
	
	
	var param ={};
	
	param["vendorId"] = fkVendorId;
	
	param["methodName"] = "getVendorInfo";
	
	$.post('/society/jsp/utility/controller.jsp',param,function(data){
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
				
					document.getElementById("vendorcompanyname").value = v.vendorCompanyName;
					document.getElementById("contactno").value = v.contactNumber;
					document.getElementById("streetaddress").value = v.streetAddress;
					document.getElementById("companyAddress").value = v.vendorCompanyAddress;
					document.getElementById("gstinNumber").value = v.gstInNumber;
					document.getElementById("panNumber").value = v.panNumber;
					document.getElementById("cinNumber").value = v.cimNumber;
					
					
				});
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
		}
	});	
}

function purchaseOrderCreateList()
{

	var params= {};

	params["methodName"] = "getAllPurchaseOrderCreateList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#purchaseOrderCreatelist').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#purchaseOrderCreatelist').DataTable( {

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
/*
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
					console.log( pageTotal);*/
				},

				destroy: true,
				searching: true,			      
				columns: [
						  {"data": "srNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "VendorName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "vendorCompanyName", "width": "5%" ,"defaultContent": ""},
				          {"data": "contactNumber", "width": "5%" ,"defaultContent": ""},
				          {"data": "billNo", "width": "5%" ,"defaultContent": ""},
				        /*  {"data": "streetAddress", "width": "5%" ,"defaultContent": ""},
				          {"data": "city" , "width": "5%" ,"defaultContent": ""},
				          {"data": "zipCode" , "width": "5%" ,"defaultContent": ""},
				          {"data": "phone" , "width": "5%" ,"defaultContent": ""},
				          {"data": "fax" , "width": "5%" ,"defaultContent": ""},*/
				          
				          {"data": "productDescription" , "width": "5%" ,"defaultContent": ""},
				          {"data": "quantity", "width": "5%" ,"defaultContent": ""},
				          {"data": "unitPrice", "width": "5%" ,"defaultContent": ""},
				          {"data": "total" , "width": "5%" ,"defaultContent": ""},
				          {"data": "subTotal" , "width": "5%" ,"defaultContent": ""},
				          {"data": "gst" , "width": "5%" ,"defaultContent": ""},
				          {"data": "vat" , "width": "5%" ,"defaultContent": ""},
				          {"data": "grossTotal" , "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Purchase Order Report";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Purchase Order Report";
				                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Purchase Order Report";
				                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Purchase Order Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#purchaseOrderCreatelist').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});


}

function purchaseOrderReceiveList()
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
				          {"data": "vendorName" , "width": "5%" ,"defaultContent": ""},
				        /*  {"data": "type", "width": "5%" ,"defaultContent": ""},*/
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
				                    		 return "Receive PO List";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					});
				});

		
		var mydata = catmap;
		$('#purchaseOrderReceiveList').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});


}


// Get Vendor Records
function getVendorDetailas()
{

	var params= {};
	var vendor= $('#vendor').val();
	
	params["vendor"]= vendor;
	
	params["methodName"] = "getVendorRecords";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear table
		$('#typeWiseReport').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		$(document).ready(function() {
			$('#typeWiseReport').DataTable( {

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
/*
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
					console.log( pageTotal);*/
				},

				destroy: true,
				searching: true,			      
				columns: [
					
					  {"data": "srNo" , "width": "5%" ,"defaultContent": ""},
					  {"data": "vendorName" , "width": "5%" ,"defaultContent": ""},
			          {"data": "type", "width": "5%" ,"defaultContent": ""},
			          {"data": "billNo", "width": "5%" ,"defaultContent": ""},
			          {"data": "purchaseDate", "width": "5%" ,"defaultContent": ""},
			          {"data": "expectPaymentDate" , "width": "5%" ,"defaultContent": ""},
			          {"data": "productName", "width": "5%" ,"defaultContent": ""},
			          {"data": "buyPrice" , "width": "5%" ,"defaultContent": ""},
			          {"data": "quantity" , "width": "5%" ,"defaultContent": ""},
			          {"data": "total" , "width": "5%" ,"defaultContent": ""},
			          {"data": "subSotal" , "width": "5%" ,"defaultContent": ""},
			          {"data": "gst" , "width": "5%" ,"defaultContent": ""},
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
				                    		 return "Receive PO Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     } ]
			} );
		} );
		var mydata = catmap;
		$('#typeWiseReport').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}



// Get Client Records

function getClientDetailas()
{

	var params= {};
	var client= $('#client').val();

	params["client"]= client;
	
	params["methodName"] = "getClientRecords";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		//To clear table
		$('#typeWiseReport').dataTable().fnClearTable();

		
		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;
		
		$(document).ready(function() {
			$('#typeWiseReport').DataTable( {

				
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

		/*			// Total over this page
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
					  {"data": "vendorName" , "width": "5%" ,"defaultContent": ""},
			          {"data": "type", "width": "5%" ,"defaultContent": ""},
			          {"data": "billNo", "width": "5%" ,"defaultContent": ""},
			          {"data": "purchaseDate", "width": "5%" ,"defaultContent": ""},
			          {"data": "expectPaymentDate" , "width": "5%" ,"defaultContent": ""},
			          {"data": "productName", "width": "5%" ,"defaultContent": ""},
			          {"data": "buyPrice" , "width": "5%" ,"defaultContent": ""},
			          {"data": "quantity" , "width": "5%" ,"defaultContent": ""},
			          {"data": "total" , "width": "5%" ,"defaultContent": ""},
			          {"data": "subSotal" , "width": "5%" ,"defaultContent": ""},
			          {"data": "gst" , "width": "5%" ,"defaultContent": ""},
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
			                    		 return "Receive PO Report";
			                    	 },
			                    	 orientation : 'landscape',
			                    	 pageSize : 'LEGAL',
			                    	 titleAttr : 'PDF' 
			                     }]
			} );
		} );
		var mydata = catmap;
		$('#typeWiseReport').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
}

function getBillNoByVendorName()
{
	var input = document.getElementById('vendorName'),
	list = document.getElementById('vendorList_Drop'),
	i,fkVendorId;
	for (i = 0; i < list.options.length; ++i) {
		if (list.options[i].value === input.value) {
			fkVendorId = list.options[i].getAttribute('data-value');
		}
	}
	$("#BilllNo_Drop").empty();
	$("#poBillNo").append($("<option></option>").attr("value","").text("Select Bill No"));
	var params= {};
	params["fkVendorId"]= fkVendorId;
	params["methodName"] = "getVendorPoNos";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{
		var jsonData = $.parseJSON(data);
		$.each(jsonData,function(i,v)
		{
			$("#BilllNo_Drop").append($("<option></option>").attr("value",i).text(v.billNo));
		});
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout"){}
	});
}




function getPoInPurchaseReceived()
{
	var poBillNo = $('#poBillNo').val();

	var params = {};
	
	params["poBillNo"] = poBillNo;
	params["methodName"] = "getPurchaseOrderItemByBillNo";
	
	$.post('/society/jsp/utility/controller.jsp',
			params,
			function(data)
			{
				$("#list4").jqGrid("clearGridData");
				var jsonData = $.parseJSON(data);
				var catmap = jsonData.list;
				$.each(jsonData, function(i, v)
				{
					document.getElementById("subTotal1").value = v.subSotal;
					document.getElementById("gst1").value = v.gst;
					document.getElementById("gstAmount").value = v.gstAmount;
					document.getElementById("grossTotal1").value = v.grossTotal;
					document.getElementById("purchasedate").value = v.purchaseOrderDate;
					
					$("#list4").jqGrid(
							{
								datatype : "local",

								colNames : [ "Product Name", "Buy Price", "Quantity", "Total"],

								             colModel : [
								             {
								            	 name : 'productDiscription',
								            	 width : 140,
								            	 editable:false,
								             },
								             {
								            	 name : "buyPrice",
								            	 width : 100,
								            	 editable:false,
								             }, 
								             {
								            	 name : "quantity",
								            	 width : 100,
								            	 editable:false,
								             }, 
								             {
								            	 name : "total",
								            	 width : 100,
								            	 editable:false,
								             }
								             ],

								             loadonce: false,
								             viewrecords: true,
								             width: 700,
								             shrinkToFit: true,
								             rowList : [10,20,50],
								             rownumbers: true,
								             rowNum: 10,
								             'cellEdit':true,
								             afterSaveCell: function () {},								             
								             footerrow: true, // set a footer row
								             gridComplete: function() {},

								             pager : "#jqGridPager",
							});

					$("#list4").addRowData(i, jsonData[i]);

					$('#list4').navGrid(
							'#jqGridPager',
							// the buttons to appear on the toolbar of the grid
							{ edit: true, add: true, del: true, search: true, refresh: false, view: true, position: "left", cloneToTop: false },
							// options for the Edit Dialog
							{
								editCaption : "The Edit Dialog",
								recreateForm : true,
								checkOnUpdate : true,
								checkOnSubmit : true,
								closeAfteredit : true,
								errorTextFormat : function(data) {
									return 'Error: '
									+ data.responseText
								}
							},

							{},

							// options for the Delete Dailog
							{
								closeAfterdel:true,
								recreateForm: true,
								afterComplete: function() {},
								errorTextFormat: function (data) {
									return 'Error: ' + data.responseText
								},
								onSelectRow: function(id) {
									if (id && id !== lastSel) {
										jQuery("#list4").saveRow(lastSel, true, 'clientArray');
										jQuery("#list4").editRow(id, true);
										lastSel = id;
										console.log(id);
									}
								}
							});
				});

			}).error(function(jqXHR, textStatus, errorThrown) {
				if (textStatus === "timeout") {
				}
			});
}