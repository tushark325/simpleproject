function QuotationValidation(){
	
	if(!(document.quotation.vendor.checked || document.quotation.client.checked))
	{
		alert("Select Type.");
		return false;
		
	}
	
	if(document.quotation.vendorName.value == "")
	{
		alert("Select Vendor Name.");
		return false;
	}	
	if(document.quotation.quotDate.value == "")
	{
		alert("Select Date");
		return false;
	}	
	

	var count = jQuery("#list4").jqGrid('getGridParam', 'records');
	
	if(count <= 0)
	{
		alert("Please Enter Description");
		return false;
	}
	
	
	var allRowsInGrid = $('#list4').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);

	
	for(var i=0;i<count;i++)
	{
		
		var unit = allRowsInGrid[i].unit;
		var unitPrice = allRowsInGrid[i].unitPrice;
		var quantity = allRowsInGrid[i].quantity;

		
			if(unitPrice=="" || unitPrice==null)
			{
				alert("Please Enter Unit Price in Grid");
			}
			var letterNumber = /^[0-9]+$/;
			if(unitPrice.match(letterNumber))
			{
		
				if(quantity=="" || quantity==null)
				{
					alert("Please Enter quantity in Grid");
				}
					var letterNumber = /^[0-9]+$/;
					if(quantity.match(letterNumber))
					{
/*
						if(document.quotation.gst1.value == "")
						{
							alert("Please Enter Gst");
							return false;
						}*/
						
					}
		
				else
				{
					alert("Enter Numbers Only in Quantity..!!");
					return false;
				
				}
			}
			
			else
			{
				alert("Enter Numbers Only in Unit Price in Grid..!!");
				return false;
			
			}

		
	}
	

	QuotationDetails();
	
	
}
	

//add Quotation Details
function QuotationDetails(){
	
	var params = {};
	
	var count = jQuery("#list4").jqGrid('getGridParam', 'records');
	var allRowsInGrid = $('#list4').getGridParam('data');//to get all rows of grid
	var AllRows=JSON.stringify(allRowsInGrid);
	
	var vendorName= $('#vendorName').val();
	//var billingPeriodFrom= $('#billingPeriodFrom').val();
	var quotDate= $('#quotDate').val();
	var uploadFile = $('#uploadFile').val();
	
	
	var companyname = $('#companyname').val();
	var companyaddress = $('#companyaddress').val();
	var city = $('#city').val();
	var state = $('#state').val();
	var zip = $('#zip').val();
	var phoneno = $('#phoneno').val();
	var subTotal1 = $('#subTotal1').val();
	var gst1 = $('#gst1').val();
	var gstAmount = $('#gstAmount').val();
	var afterGstTotal1 = $('#afterGstTotal1').val();
	var discount = $('#discount').val();
	var discountAmount = $('#discountAmount').val();
	var grossTotal1 = $('#grossTotal1').val();
	var quotationNo = $('#quotationNo').val();
	
	
	var type1 = $('#vendor').val();
	var type2 = $('#client').val();
	
	
	var input1 = document.getElementById('vendorName'),
	list = document.getElementById('vendorList_Drop'),
	i,fkVendorId;

	for (i = 0; i < list.options.length; ++i) {
	if (list.options[i].value === input1.value) {
		fkVendorId = list.options[i].getAttribute('data-value');
		}
	}
	

	for(var i=0;i<count;i++)
	{
		var description = allRowsInGrid[i].description;
		params["description"+i]=description;

		var unitPrice = allRowsInGrid[i].unitPrice;
		params["unitPrice"+i]=unitPrice;
		
		var quantity = allRowsInGrid[i].quantity;
		params["quantity"+i]=quantity;
		
		var total = allRowsInGrid[i].total;
		params["total"+i]=total;
		
		
	}
	
	
	if(document.quotation.vendor.checked)
	{
		params["type"] = type1;
		
	}
	
	if(document.quotation.client.checked)
	{
		params["type"] = type2;
		
	}
	
	
	if(document.quotation.client.checked)
	{
		params["afterGstTotal1"] = "0";
	}
/*	
	
	if(afterGstTotal1=="")
	{
		params["type"] = type2;
	}*/
	
	params["quotationNo"] = quotationNo;
	
	params["fkVendorId"] = fkVendorId;
	params["vendorName"] = vendorName;
	params["quotDate"] = quotDate;

	params["uploadFile"] = uploadFile;
	
	params["companyname"] = companyname;
	params["companyaddress"] = companyaddress;
	params["city"] = city;
	params["state"] = state;
	params["zip"] = zip;
	params["phoneno"] = phoneno;
	params["subTotal1"] = subTotal1;
	params["gst1"] = gst1;
	params["gstAmount"] = gstAmount;
	params["discount"] = discount;
	params["discountAmount"] = discountAmount;
	params["grossTotal1"] = grossTotal1;
	
	
	params["count"] = count;
	
    params["methodName"] = "QuotationInfo";
	
    $.post('/society/jsp/utility/controller.jsp',params,function(data) 
 	    	{
		 		alert(data);
		 		window.open("QuotationPDF.jsp");
		 		location.reload();
 			}
 	
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	})
}

// get Vendor Name For DropDown

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
						/*$("#vendorList_Drop").append($("<option></option>").attr("value",(v.vendorName))); */
						$("#vendorList_Drop").append($("<option></option>").attr("value",(v.vendorName)).attr("data-value",(v.vendorId)));
						count++;
					});
			}).error(function(jqXHR, textStatus, errorThrown)
					{
						if(textStatus==="timeout") {

				}
			});
}

//get Client Name For DropDown

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
					/*$("#vendorList_Drop").append($("<option></option>").attr("value",(v.firstName+" "+ v.lastName)));*/
					$("#vendorList_Drop").append($("<option></option>").attr("value",(v.firstName+" "+ v.lastName)).attr("data-value",(v.clientId)));
					count++;
						});
				}).error(function(jqXHR, textStatus, errorThrown){
					if(textStatus==="timeout") {

					}
				});
	
}

// Gst,Discount,ect.. Calculation

function getGstAmountTotal()
{
	var gst = $('#gst1').val();
	var sub_Total = $('#subTotal1').val();
	var discount = $('#discount').val();
	var vat = (gst) * (sub_Total)/100;
	document.getElementById('gstAmount').value = vat;
	
	
	var total = +sub_Total + +vat;
	
	var total2 = total.toFixed(2);
	
	document.getElementById('afterGstTotal1').value = total;
	document.getElementById('grossTotal1').value = total2;
	
	
	
	
	if(!discount==0)
	{
		var discount = $('#discount').val();
		var afterGstTotal = $('#afterGstTotal1').val();
		
		var discountAmount = (afterGstTotal)*(discount)/100;
		
		var grossTotal = +afterGstTotal - +discountAmount;
		
		var total22 = grossTotal.toFixed(2);
		
		document.getElementById('discountAmount').value = discountAmount;
		document.getElementById('grossTotal1').value = total22;
		
	}
	
	/*
		var grossTotal = +afterGstTotal - +discountAmount;
		document.getElementById('grossTotal1').value = grossTotal;
	*/
}

function getDiscountAmountTotal()
{
	
	
	var afterGstTotal = $('#afterGstTotal1').val();
	var discount = $('#discount').val();
	var discountAmount = (afterGstTotal)*(discount)/100;
	document.getElementById('discountAmount').value = discountAmount;
	
	var grossTotal = +afterGstTotal - +discountAmount;
	
	/*var total = +sub_Total + +vat;*/
	
	var total222 = grossTotal.toFixed(2);

	
	document.getElementById('grossTotal1').value = total222;
	
}



//------------------ Grid for Product Description---------------
// Grid Validation
function getGridForProductDescription()
{
	if(document.quotation.taskInText.value=="" && document.quotation.taskInText.value == null)
	{
		alert('please enter description. . .');
		return false;
	}
	getGridProductDescription()
	
}


function getGridProductDescription()
{
	var params={};
	var count=0;
	var newrow;
	var rowId;
	
	var description = $('#taskInText').val()

	params["description"] = description;
	
	params["methodName"] ="gridForQuotation";
	
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
				  prodName = rowdata[j].description;
				  
				 var rowId = ids[j];
				 var rowData = jQuery('#list4').jqGrid ('getRowData', rowId);
				
				if (prodName == jsonData.offer.description) 
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
			
			colNames:['Description','Unit Price','Quantity','Total'],
			colModel:[ 
				
               
			    {	name:'description',
			    	 width:70,
			    	 editable: true
			    	
				},

				
				{	name:'unitPrice',
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
	                    	var buyPrice = rowData['unitPrice'];
	                    	
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
        		        	document.getElementById("gst1").value = "0";
         		        	document.getElementById("gstAmount").value = "0";
         		        	document.getElementById("afterGstTotal1").value = "0";
         		        	document.getElementById("discount").value = "0";
         		        	document.getElementById("discountAmount").value = "0";
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
		                    	var buyPrice = rowData['unitPrice'];
		                    	
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
     		        	
     		        	document.getElementById("gst1").value = "0";
     		        	document.getElementById("gstAmount").value = "0";
     		        	document.getElementById("afterGstTotal1").value = "0";
     		        	document.getElementById("discount").value = "0";
     		        	document.getElementById("discountAmount").value = "0";
     		        	document.getElementById("grossTotal1").value = Total;
	                  }
	                });
		 
		 
			   });
			
		})
}


function getVendor_ClietDetails()
{
	
	if(document.quotation.vendor.checked)
	{
		var params = {};
		
		$("#companyname").append($("<input/>").attr("value","").text());
		$("#companyaddress").append($("<input/>").attr("value","").text());
			
		var vendoName = $('#vendorName').val();
	
		var input1 = document.getElementById('vendorName'),
		list = document.getElementById('vendorList_Drop'),
		i,fkVendorId;
		
		for (i = 0; i < list.options.length; ++i) {
			if (list.options[i].value === input1.value) {
				fkVendorId = list.options[i].getAttribute('data-value');
				}
			}
			
		params["fk_vendor_id"] = fkVendorId;
		params["vendoName"] = vendoName;
		
		params["methodName"] = "getVendorDetailsForEdit";
		
		
		$.post('/society/jsp/utility/controller.jsp',params,function(data){
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			$.each(jsonData,function(i,v)
					
					{
				
					  document.getElementById("companyname").value = v.companyName;
				      document.getElementById("companyaddress").value = v.companyAddress;
				   
					});
				}).error(function(jqXHR, textStatus, errorThrown){
					if(textStatus==="timeout") {

					}
				});
	 	  
		
	}
	
	if(document.quotation.client.checked)
	{

		var params = {};
		
		$("#companyname").append($("<input/>").attr("value","").text());
		$("#companyaddress").append($("<input/>").attr("value","").text());
		$("#city").append($("<input/>").attr("value","").text());
	
		
		
		var input1 = document.getElementById('vendorName'),
		list = document.getElementById('vendorList_Drop'),
		i,fkVendorId;
		
		for (i = 0; i < list.options.length; ++i) {
			if (list.options[i].value === input1.value) {
				fkClientId = list.options[i].getAttribute('data-value');
				}
			}
		
		params["fkClientid"] = fkClientId;
		
		params["methodName"] = "getClientDetailsForEdit";
		
		$.post('/society/jsp/utility/controller.jsp',params,function(data){
			
			var jsonData = $.parseJSON(data);
			var catmap = jsonData.list;
			
			$.each(jsonData,function(i,v)
					
					{
				
					  document.getElementById("companyname").value = v.businessName;
				      document.getElementById("companyaddress").value = v.businessAddress;
				      document.getElementById("city").value = v.address;
				 
					});
				}).error(function(jqXHR, textStatus, errorThrown){
					if(textStatus==="timeout") {

					}
				});
		
	}
	
}

function quotationList()
{


	var params= {};

	params["methodName"] = "getQuotationList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#quotationList22').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#quotationList22').DataTable( {

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
				          {"data": "type", "width": "5%" ,"defaultContent": ""},
				          {"data": "dateOfQuotation", "width": "5%" ,"defaultContent": ""},
				          {"data": "quotationNo", "width": "5%" ,"defaultContent": ""},
				          {"data": "companyName", "width": "5%" ,"defaultContent": ""},
				          {"data": "companyAddress" , "width": "5%" ,"defaultContent": ""},
				          
				         /* {"data": "city" , "width": "5%" ,"defaultContent": ""},*/
				          {"data": "state" , "width": "5%" ,"defaultContent": ""},
				          {"data": "zip" , "width": "5%" ,"defaultContent": ""},
				          {"data": "phoneNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "description", "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "unitPrice" , "width": "5%" ,"defaultContent": ""},
				          {"data": "quantity" , "width": "5%" ,"defaultContent": ""},
				          {"data": "total" , "width": "5%" ,"defaultContent": ""},
				          {"data": "subTotal" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "gst" , "width": "5%" ,"defaultContent": ""},
				          {"data": "gstAmount" , "width": "5%" ,"defaultContent": ""},
				         /* {"data": "totalWithGst" , "width": "5%" ,"defaultContent": ""},*/
				          {"data": "discount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "discountAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "grossTotal" , "width": "5%" ,"defaultContent": ""},
				          
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
		$('#quotationList22').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
	
}


//Vendor Wise Quotation Details

function getVendorDetailas()
{

	var params= {};
	
/*	var vendor = $('#vendor').val();
	
	params["vendor"] = vendor;
*/
	params["methodName"] = "getVendorRecordsOfQuotation";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#typeWiseReportForQuo').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#typeWiseReportForQuo').DataTable( {

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
				          {"data": "dateOfQuotation", "width": "5%" ,"defaultContent": ""},
				          {"data": "quotationNo", "width": "5%" ,"defaultContent": ""},
				          {"data": "companyName", "width": "5%" ,"defaultContent": ""},
				          {"data": "companyAddress" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "city" , "width": "5%" ,"defaultContent": ""},
				          {"data": "state" , "width": "5%" ,"defaultContent": ""},
				          {"data": "zip" , "width": "5%" ,"defaultContent": ""},
				          {"data": "phoneNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "description", "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "unitPrice" , "width": "5%" ,"defaultContent": ""},
				          {"data": "quantity" , "width": "5%" ,"defaultContent": ""},
				          {"data": "total" , "width": "5%" ,"defaultContent": ""},
				          {"data": "subTotal" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "gst" , "width": "5%" ,"defaultContent": ""},
				          {"data": "gstAmount" , "width": "5%" ,"defaultContent": ""},
				         /* {"data": "totalWithGst" , "width": "5%" ,"defaultContent": ""},*/
				          {"data": "discount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "discountAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "grossTotal" , "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Quotation Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#typeWiseReportForQuo').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});
	
}



//Client Wise Quotation Details

function getClientDetailas()
{

	var params= {};
	
/*	var vendor = $('#vendor').val();
	
	params["vendor"] = vendor;
*/
	params["methodName"] = "getClientRecordsOfQuotation";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
		
		$('#typeWiseReportForQuo').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#typeWiseReportForQuo').DataTable( {

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
				          {"data": "vendorName" , "width": "5%" ,"defaultContent": ""},
				          {"data": "type", "width": "5%" ,"defaultContent": ""},
				          {"data": "dateOfQuotation", "width": "5%" ,"defaultContent": ""},
				          {"data": "companyName", "width": "5%" ,"defaultContent": ""},
				          {"data": "companyAddress" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "city" , "width": "5%" ,"defaultContent": ""},
				          {"data": "state" , "width": "5%" ,"defaultContent": ""},
				          {"data": "zip" , "width": "5%" ,"defaultContent": ""},
				          {"data": "phoneNo" , "width": "5%" ,"defaultContent": ""},
				          {"data": "description", "width": "5%" ,"defaultContent": ""},
				          
				         
				          {"data": "unitPrice" , "width": "5%" ,"defaultContent": ""},
				          {"data": "quantity" , "width": "5%" ,"defaultContent": ""},
				          {"data": "total" , "width": "5%" ,"defaultContent": ""},
				          {"data": "subTotal" , "width": "5%" ,"defaultContent": ""},
				          
				          {"data": "gst" , "width": "5%" ,"defaultContent": ""},
				          {"data": "gstAmount" , "width": "5%" ,"defaultContent": ""},
				         /* {"data": "totalWithGst" , "width": "5%" ,"defaultContent": ""},*/
				          {"data": "discount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "discountAmount" , "width": "5%" ,"defaultContent": ""},
				          {"data": "grossTotal" , "width": "5%" ,"defaultContent": ""},
				          
				          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true },
				                     { extend: 'excelHtml5', footer: true },
				                     { extend: 'csvHtml5', footer: true },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Vendor Quotation Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#typeWiseReportForQuo').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			});



	
}



