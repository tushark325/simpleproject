<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<%@page import="com.society.hibernate.VendorDetailsHibernate"%>
<%@page import="com.society.dao.VendorDetailsDao"%>
<%@page import="com.society.dao.PurchaseOrderDao"%>
<%@page import="com.society.hibernate.PurchaseOrderCreateHibernate"%>
<%@page import="com.society.hibernate.PurchaseHibernate"%>
<%@page import="com.society.hibernate.VendorPaymentDetailsHibernate"%>
<html>
<head>
				
<script type="text/javascript"
	src="/society/staticContent/js/jquery-1.12.3.min.js"></script>

<link rel="stylesheet" href="/society/staticContent/css/shree.css">

<link rel="stylesheet"
	href="/society/staticContent/css/jquery-ui.min.css">

<link rel="stylesheet"
	href="/society/staticContent/css/ui.jqgrid.min.css">

<link rel="stylesheet"
	href="/society/staticContent/y_css/jquery-ui.css">

<link rel="stylesheet" href="/society/staticContent/css/ui.jqgrid.css">

<script type="text/javascript"
	src="/society/staticContent/js/jquery.min.js"></script>

<script type="text/javascript"
	src="/society/staticContent/js/jquery-ui-min.js"></script>

<script type="text/javascript"
	src="/society/staticContent/js/jquery-ui.js"></script>

<script type="text/javascript"
	src="/society/staticContent/js/jqueryUi.js"></script>

<script type="text/javascript"
	src="/society/staticContent/js/jquery.jqgrid.min.js"></script>
		
		
		
		
	<!-- 	<script type="text/javascript" src="/society/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/society/staticContent/css/jquery-ui.min.css">
		<link href="/staticContent/css/ui.jqgrid.min.css" rel="stylesheet" type="text/css"/>
		<link href="/staticContent/y_css/jquery-ui.css" rel="stylesheet" type="text/css"/>
		<link href="/staticContent/css/ui.jqgrid.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="/society/staticContent/js/jquery.min.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jquery-ui.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/cupertino/jquery-ui.css" type="text/css"/>
		<link rel="stylesheet" href="/society/staticContent/css/ui.jqgrid.css">
		<script type="text/javascript" src="/society/staticContent/js/jquery.jqgrid.min.js"></script>
		
	 -->	
        
         <script src="/society/staticContent/js/purchaseOrderDetails.js"></script>
         
         
         <script type="text/javascript">

   		 function purchaseOrderList()
          		 {
          			 window.location = "PurchaseOrderReceiveList.jsp";
          		 }
      
          		</script> 
	<script>
		function resets()
		{
			location.reload(true);
		}

	</script>

        <script>
				function lettersonly(input) {
		
					var regex = /[^a-z ]/gi;
					input.value = input.value.replace(regex, "");
		
				}
		
				/* function numbersonly(input) {
					var regex = /[^0-9 .]/gi;
					input.value = input.value.replace(regex, "");
				} */
		</script>
		
		<script type="text/javascript">
			function isNumber(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		        return false;
		    }
		    return true;
		}
	</script>
		
		<script type="text/javascript">
			function isAlphabets(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if ((charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122)) {
		        return false;
		    }
		    return true;
			}


		</script>
		
		
		<script type="text/javascript">
			function isAlphabetsWithSpace(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode!=32 && (charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122)) {
		        return false;
		    }
		    return true;
			}


		</script>
		
		<script type="text/javascript">
				function clearFiled()
				{
					document.getElementById("productname").value="";
				}

		</script>


</head>
<body>

	<div class="container-fluid">
		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Received PO</h2>
			</div>
		</div>

		<div class="row">
			<div class="form-group" align="right">
				<div class="col-sm-offset-6 col-md-5 control-label">
					<div id="date">
						<label id="demo"></label>
						<script>
							   var date = new Date();
							   document.getElementById("demo").innerHTML = date.toDateString();
							</script>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-1 col-md-10" align="right">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

		<form class="form-horizontal" name="product">

<!-- 				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="center">
						<label class="control-label" for="billType">Type:<sup
							style="color: red;">*</sup></label>
					</div>
					
					
					<div class="col-sm-4" >
						<div class="col-md-4 col-xs-6 ">
							<label class="radio-inline">
							 <input type="radio" name="type" id="vendor" value="vendor" onclick="getVendorName()" style=" margin-left: -70px;"/>
							 <h4 style="margin-top: 0px;">Vendor</h4>
							</label>
						</div>
						
						
						
						<div class="col-md-6 col-xs-6 col-md-ffset-1 ">
							<label class="radio-inline">
							 <input type="radio" name="type" id="client" value="client" onclick="getClientName()" style="margin-left: -70px;"/>
							 <h4 style="margin-top: 0px;">Client</h4>
							</label>
						</div>
						</div>
						
					 </div> -->
				 
			<div class="row">
				<div class="form-group">
					
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Vendor Name:<sup>*</sup></label>
					</div>
					
				<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<%
								VendorDetailsDao sdd4 = new VendorDetailsDao();
								List sList5 = sdd4.getAllVendorNames();
							%>
							<input list="vendorList_Drop" id="vendorName" class="form-control" placeholder="Vendor Name" >
							<datalist id="vendorList_Drop">
							<%
								for (int i = 0; i < sList5.size(); i++) {
								VendorDetailsHibernate sup = (VendorDetailsHibernate) sList5.get(i);
							%>

							<option data-value="<%=sup.getPkVendorDetailsId()%>"
							value="<%=sup.getFirstName()%> <%=sup.getLastName()%> <%=sup.getContactNo()%>">

							<%
								}
							%>		
							</datalist>					
<!-- 
							<input list="vendorList_Drop" id="vendorName" class="form-control">
							<datalist id="vendorList_Drop"></datalist> -->
							
						</div>
				</div>
				
				<div class="col-sm-2" align="right">
				
				<label class="control-label" for="poBillNo">Bill/Challan No:<sup>*</sup></label>
				
				</div>
				
				<div class="col-sm-3">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-hand-right"></i>
						</span>
						
						<!--  <select  class="form-control" id="poBillNo" name="poBillNo" placeholder="Select Bill No" onchange="getBillNoByVendorName()"></select>-->
						
							
						
							
							 <input type="text" id="poBillNo" class="form-control" placeholder="Select Bill No" >
						   
							
									
							
					</div>
				</div>
					
					<!-- <div class="col-sm-2" align="right">
						<label class="control-label">Bill/Challan No.:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='billno' name="billno" class="form-control" placeholder="Enter Bill No.">
						</div>
					</div> -->
				</div>
			</div>

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Purchase Order Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span>
						 <input type="date" id='purchasedate' name="purchasedate" class="form-control" placeholder="select date">
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">Expect Payment Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span>
					 <input type="date" id='expectpaymentdate' name="expectpaymentdate" class="form-control" placeholder="select date">
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Product Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
							<textarea rows="2" cols="25" id='productname' class="form-control" placeholder="Enter Product Name"  onchange="getGridForProductInRecive();clearCalculation();clearFiled()"></textarea>
						 <!-- <input type="text" id='productname' name="productname" class="form-control" placeholder="Enter Product Name"  onchange="getGridForProductInRecive()" /> -->
						</div>
					</div>
				
			  </div>
			  
		  <div class="table-responsive	row col-md-offset-1" style="margin-left: 386px;">
				<table id="list4" ></table>
				<div id="jqGridPager"></div>
		  </div>
		  
		        <div class="row form-group"> </div>
		      		<div class="row" style="margin-top:15px;">
						<label class="col-md-2 col-md-offset-6 control-label"  for="subTotal"><h4><b>Sub Total :</b></h4></label>  
				           	 <div class="col-md-2" style=" width: 300px;">
								<div class="input-group">
									<span class="input-group-addon">
										 <i class="fa fa-rupee" style="font-size:18px"></i>
									</span>
		              				<input readonly="readonly" id="subTotal1" name="subTotal1"  class="form-control input-md" type="text" style="font-size: 20px;  height: 35px;">
		            			</div>
		            		</div>
            		</div>	
            		
            		
            		
            		 <div class="row form-group"> </div>
		      		<div class="row" style="margin-top:15px;">
					<label class="col-md-2 col-md-offset-6 control-label"  for="gst"><h4><b>GST :</b></h4></label>  
			           	 <div class="col-md-1" style=" width: 120px;">
							<div class="input-group">
								<span class="input-group-addon">
									%
								</span>
	              				<input id="gst1" name="gst1" value="0" placeholder="gst" readonly="readonly" class="form-control input-md" type="text" onkeypress="return isNumber(event)" style="font-size: 20px;  height: 35px;" onchange="getGstAmountTotal()" >
	            			</div>
	            		</div>
	            		
	            		 <div class="col-md-2" style=" width: 180px;">
							<div class="input-group">
								<span class="input-group-addon">
									 <i class="fa fa-rupee" style="font-size:18px"></i>
								</span>
	              				<input readonly="readonly" id="gstAmount" name="gstAmount"  class="form-control input-md" type="text" style="font-size: 20px;  height: 35px;">
	            			</div>
	            		</div>
	            		
            		</div>	
            		
       <!--      		
            		 <div class="row form-group"> </div>
		      		<div class="row" style="margin-top:15px;">
					<label class="col-md-2 col-md-offset-6 control-label"  for="gstAmount"><h4><b>Gst Amount :</b></h4></label>  
			           	 <div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">
									 <i class="fa fa-rupee" style="font-size:18px"></i>
								</span>
	              				<input readonly="readonly" id="gstAmount" name="gstAmount"  class="form-control input-md" type="text" style="font-size: 25px;  height: 35px;">
	            			</div>
	            		</div>
            		</div>	
            		 -->
            		     		
            		 <div class="row form-group"> </div>
		      		<div class="row" style="margin-top:15px;">
					<label class="col-md-2 col-md-offset-6 control-label"  for="grossTotal"><h4><b>Gross Total</b></h4></label>  
			           	 <div class="col-md-2" style=" width: 300px;">
							<div class="input-group">
								<span class="input-group-addon">
								 <i class="fa fa-rupee" style="font-size:18px"></i>
								</span>
	              				<input readonly="readonly" id="grossTotal1" name="grossTotal1"  class="form-control input-md" type="text" style="font-size: 20px;  height: 55px;">
	            			</div>
	            		</div>
            		</div>
 				</div>
			
			
			<div class="row">
				<div class="form-group">
					
					
				</div>
		   </div>	
		   
		   
			<div class="container" align="center">
				<input type="button" class="btn btn-success btn-lg btnn" value="Save" name="btn" onclick="purchaseOrderDetailasValidation()"> 
				<input type="button" class="btn btn-danger btn-lg btnn" value="Cancel" onclick="resets()" onclick="reset()">
				<input type="button" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="purchaseOrderList()">
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
	function clearCalculation()
	{
		document.product.gst1.value="0";
		document.product.gstAmount.value="0";
		
		
	}


</script>
</html>

<%@include file="commons/newFooter.jsp"%>
		   	