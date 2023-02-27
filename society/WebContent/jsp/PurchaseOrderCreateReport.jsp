
<%@page import="com.society.dao.PurchaseOrderDao" %>
<%@page import="com.society.bean.PurchaseOrderCreateBean" %>
<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<html>
<head>
  	<!-- <script src="/society/staticContent/js/employeeDetails.js"></script> -->
  	
  	<script src="/society/staticContent/js/purchaseOrderDetails.js"></script>
       
         
  	 <script>
	     $(document).ready(function(){
	    	 purchaseOrderCreateList();
		}); 
	</script>
	
  	
  	
<script type="text/javascript">
	 function Back() 
	 {
			 window.location = "PurchaseOrderCreate.jsp";
	 }

</script>

<script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"></script> 
 <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/buttons/1.3.1/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/pdfmake.min.js"></script>

<script type="text/javascript" src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.27/build/vfs_fonts.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"> 
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.dataTables.min.css">
		
		
			

<!-- 	<!-- For datatable to pdf,print,excel etc conversion -->
		<script type="text/javascript" src="/society/staticContent/jsForReport/jquery-1.12.4.js"></script> 
		 <script type="text/javascript" src="/society/staticContent/jsForReport/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="/society/staticContent/jsForReport/dataTables.buttons.min.js"></script>
		<script type="text/javascript" src="/society/staticContent/jsForReport/buttons.flash.min.js"></script>
		<script type="text/javascript" src="/society/staticContent/jsForReport/jszip.min.js"></script>
		<script type="text/javascript" src="/society/staticContent/jsForReport/pdfmake.min.js"></script>
		
		<script type="text/javascript" src="/society/staticContent/jsForReport/vfs_fonts.js"></script>
		<script type="text/javascript" src="/society/staticContent/jsForReport/buttons.html5.min.js"></script>
		<script type="text/javascript" src="/society/staticContent/jsForReport/buttons.print.min.js"></script>
		<link rel="stylesheet" href="/society/staticContent/cssForReport/jquery.dataTables.min.css"> 
		<link rel="stylesheet" href="/society/staticContent/cssForReport/buttons.dataTables.min.css"> 
					  
					  
					     <style type="text/css">
					      td {
					       color:  black;
					      }
					     </style>
</head>


   <div class="container-fluid" style="min-height:300px;">

				<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Purchase Order Report</h2>
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
			<div class="col-sm-offset-1 col-md-10">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

	<div id="date">
		<label id="demo"></label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div>

	<div id="demo_jui">
	   <table class="table table-bordered table-striped table-condensed cf"
			id="purchaseOrderCreatelist" class="display" style="border: 2px solid black; border-collapse: collapse;">
			<thead>
			<tr>
					<th>Sr No</th>
					<th>Vendor_Name</th>
					<th>Vendor Company Name</th>
	                <th>Contact No.</th>
	                <th>Bill No</th>
	                <!-- 
		                <th>Street Address</th>
		                <th>City</th>
		                <th>Zip Code</th> 	                
		                <th>Phone</th>
						<th>Fax</th>
					-->
					<th>Product Description</th>
					<th>Quantity</th>
					<th>Unit Price</th>
					<th>Total</th>
	                <th>Sub Total</th>
	                <th>GST (%)</th>	
	                <th>Gst Amount</th>
					<th>Gross Total</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<%@include file="commons/newFooter.jsp" %>
	
</div>