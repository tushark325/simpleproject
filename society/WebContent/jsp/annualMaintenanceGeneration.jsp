
<%@page import="java.util.List"%>
<%@page import="com.society.hibernate.AnnualMaintenanceDetailsHibernate"%>
<%@page import="com.society.dao.AnnualMaintenanceDao"%>

<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="/society/staticContent/js/jquery-1.12.3.min.js"></script>
     <link rel="stylesheet" href="/society/staticContent/css/jquery-ui.min.css">
     <link rel="stylesheet" href="/society/staticContent/css/ui.jqgrid.min.css">
     <!-- <link rel="stylesheet" href="/AgriSoft/staticContent/css/ui.jqgrid.css"> -->
     
     <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/cupertino/jquery-ui.css" type="text/css"/>
     <link rel="stylesheet" href="/society/staticContent/css/ui.jqgrid.css">
	 <script type="text/javascript" src="/society/staticContent/js/jquery.min.js"></script>
    <script type="text/javascript" src="/society/staticContent/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/society/staticContent/js/jquery-ui.js"></script>
    <script type="text/javascript" src="/society/staticContent/js/jqueryUi.js"></script>
    <script type="text/javascript" src="/society/staticContent/js/jquery.jqgrid.min.js"></script>
    
<!-- 	<script type="text/javascript"src="/society/staticContent/js/expenditureDetails.js"></script>
 -->
 
 	<script type="text/javascript"src="/society/staticContent/js/annualMaintenance.js"></script>


		</head>
		<body>

		<div class="container-fluid">

				<div class="row header_margin_top">
					<div align="center">
						<h2 class="form-name style_heading" style="margin-top: 80px">Annual Maintenance Contract</h2>
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
	<form class="form-horizontal" method="post" action="" name="expenseDetails">
		<!-- Value of 'name' attribute is used in customerDetails.js  -->
		<fieldset>
<div class="row">
		<div class="row form-group">
		<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">Annual Maintenance Name:<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
	
							<%
								AnnualMaintenanceDao cdd = new AnnualMaintenanceDao();
	       						List cList =cdd.getAllAnnualMaintenceNames();
							%>
							
							<input list="cat_drop" id="annualMaintenanceName" class="form-control" onchange="cheakForExpenditure()">
							<datalist id="cat_drop">
							<%
					           for(int i=0;i<cList.size();i++){
					        	   AnnualMaintenanceDetailsHibernate cat=(AnnualMaintenanceDetailsHibernate)cList.get(i);
							%>
							<option data-value="<%=cat.getPkAnnualExpenseDetailsId()%>"
								value="<%=cat.getAnnualMaintenanceName()%>">
								<%
				      			}
				    		%>
							
						</datalist>
						</div>
					</div>
		
					<div class="col-sm-2" align="right">
						<label class="control-label">Start Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> 
							<input type="date" id='startdate2' name="startdate2" class="form-control"/>
						</div>
					</div>
       			</div> 
			
		
			
		<div class="row form-group">
				<div class="col-sm-3" align="right">
						<label class="control-label">End Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> 
							<input type="date" id='enddate2' name="enddate2" class="form-control"/>
						</div>
					</div>
		
				<div class="col-sm-2" align="right">
						<label class="control-label" for="employeename" style="text-align:  right;">Vendor Name:</label>
				</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
	
							<input type="text" id='vendorName' name="vendorName" class="form-control" placeholder="Enter vendor name" />
						
						</div>
					</div>
	   		</div> 
	   		
	   		<div class="row form-group">
				<div class="col-sm-3" align="right">
						<label class="control-label">Amount:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='amount' name="amount" class="form-control" placeholder="Enter amount"/>
						</div>
					</div>
			</div> 
			
			
			<div class="row form-group">
				<div class="col-md-3" align="right">
						<label class="control-label" for="employeename" style="text-align:  right;">Description:</label>
				</div>
					<div class="col-md-8">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
	
							<!-- <input type="text" id='descrition' name="descrition" class="form-control" placeholder="Enter Descrition" /> -->
						<textarea rows="2" cols="15" id='descrition' name="descrition" class="form-control" placeholder="Enter Descrition"></textarea>
						
						</div>
					</div>
	   		</div> 
		</div>	
			
			<div class="container" align="center">
				<!-- <div class="col-md-10 text-center"> -->
					<input type="button" id="save" name="btn" style="font-size: 25" class="btn btn-success btn-lg btnn " onclick="validationAddAnnualMaintenceGeneration()" value="Submit"> 
					<input id="save" name="btn" style="font-size: 25" class="btn btn-danger btn-lg btnn" type="reset" onclick="reset()" value="Cancel">
				<!-- </div> -->
			</div>
		</fieldset>
	</form>
</div>

<%@include file="commons/newFooter.jsp" %> 
