<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.dao.MemberDetailsDao"%>
<%@page import="com.society.hibernate.MemberMaintenancePaymentHibernate"%>

<%
	boolean isHome = false;
%>
<%@include file="commons/header.jsp"%>
<%@page import="java.util.List"%>
<head>

<!-- For datatable to pdf,print,excel etc conversion -->
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

	 <!-- 
	 	  <script type="text/javascript" src="/society/staticContent/js/memberDetails.js"></script>
	      <script type="text/javascript" src="/society/staticContent/js/annualMaintenance.js"></script>
	 -->
	<script type="text/javascript" src="/society/staticContent/js/memberDetails.js"></script>
	
    <script>
	     $(document).ready(function(){
	    	 memberList();
		}); 
	</script>
	
    <body id="dt_example" class="master_form_img">
    
    <div class="container">
	
 		<div class="row">
			<div align="center" style="margin-top: 75px">
				  <h2 class="form-name style_heading">Member Report</h2>
			</div>
			
		</div>
		
		<div class="form-group" align="right">
			<div class="col-sm-offset-8 col-md-4 control-label">
				<div id="date">
					<label id="demo"></label>
					<script>
						var date = new Date();
						document.getElementById("demo").innerHTML = date.toDateString();
					</script>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>
		
		<ul class="nav nav-tabs">
		    <li class="active"><a data-toggle="tab" href="#association"><h4 style="color:blue">Association</h4></a></li>
		    <li><a data-toggle="tab" href="#wing"><h4 style="color:blue">Wing Wise</h4></a></li>
		    <li><a data-toggle="tab" href="#building"><h4 style="color:blue">Building Wise</h4></a></li>
		<!--     <li><a data-toggle="tab" href="#member"><h4 style="color:blue">Member Wise</h4></a></li> -->
	   </ul>
	   
 	 
 	  	<div class="tab-content" style="float: left">
 	 
 	 
 	  <!--------------------------  Member Report By Building  --------------------------->

	 <div id="association" class="tab-pane fade in active">		
		<form class="form-horizontal" method="post" action="" name="building">
			<div class="row">
				<div class="col-md-12">
					<hr style="border-top-color: #c1b1b1;">
				</div>
			</div>
	
	 <div id="association" class="tab-pane fade in active">		
	<table class="table table-bordered table-striped table-condensed cf" id="memDetails" class="display" style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
						    <th>Sr No</th>
						    <th>First Name</th>
							<th>Middle Name</th>
							<th>Last Name</th>
							<th>Position</th>
							<th>Date_Of_Birth</th>
							<th>Contact Number</th>
							<th>Alternate Contact Number</th>
							<th>Email</th>
							<th>Adhar No</th>
							<th>Pan No</th>
							<th>Wing Name</th>
							<th>Building Name</th>
							<th>Floor No</th>
							<th>Flat No</th>
							<th>SBA</th>
						   
						</tr>
				   </thead>
			
		</table>
		</div>
		</form>
		</div>
	 
 	<!---------------------------- Member Report By Building ------------------------------->

	 <div id="building" class="tab-pane">		
		<form class="form-horizontal" method="post" action="" name="building">
			<div class="row">
				<div class="col-md-12">
					<hr style="border-top-color: #c1b1b1;">
				</div>
			</div>
	
	 <div id="building" class="tab-pane fade in active">		
	<!-- <form class="form-horizontal"> -->
			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label" for="expenditureName">Building Name:</label>
								</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							 <i class="glyphicon glyphicon-stats"></i>
							</span>
										<%
											MemberDetailsDao exdd = new MemberDetailsDao();
											List buidList = exdd.getBuildingName();
										%>
										<input list="buil_drop" id="buildingName" class="form-control">
										<datalist id="buil_drop" onfocus="this.value=''">
											<%
												for (int i = 0; i < buidList.size(); i++) {
													MemberDetailsHibernate expbean = (MemberDetailsHibernate) buidList.get(i);
											%>
											<option data-value="<%=expbean.getPkMemId()%>"
												value="<%=expbean.getBuildingName() %>">
												<%
													}
												%>
											
										</datalist>
									</div>
								</div>
								

								</div>
							</div>
			
      <div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMemberReportBuildingWise()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf" id="BuildingWise" class="display" style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
						   <th>Sr No</th>
						   <th>First Name</th>
						   <th>Middle Name</th>
						   <th>Last Name</th>
						   <th>Date_Of_Birth</th>
						   <th>Contact No</th>
						   <th>Alternate Contact No</th>
						   <th>Email ID</th>
						   <th>Position</th>
						   <th>Adhar NO</th>
						   <th>PAN NO</th>
						   <th>Wing Name</th>
						   <th>Building Name</th>
						   <th>Floor No</th>
						   <th>Flat No</th>
						   <th>SBA</th>
						</tr>
				   </thead>
			
		</table>
		</div>
		</form>
		</div>
		
		
   <!--------------------------------------- Member Report By Wing---------------------------->

 <div id="wing" class="tab-pane">		
	<form class="form-horizontal" method="post" action="" name="wing">
		
		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

 	<div id="wing" class="tab-pane fade in active">		
			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label" for="expenditureName">Wing Name:</label>
								</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							 <i class="glyphicon glyphicon-stats"></i>
							</span>
										<%
											MemberDetailsDao exdd2 = new MemberDetailsDao();
											List wingList = exdd.getWingName();
										%>
										<input list="wing_drop" id="wingName" class="form-control">
										<datalist id="wing_drop" onfocus="this.value=''">
										<%
											for (int i = 0; i < wingList.size(); i++) {
												MemberDetailsHibernate expbean = (MemberDetailsHibernate) wingList.get(i);
										%>
										<option data-value="<%=expbean.getPkMemId()%>"
											value="<%=expbean.getWingName() %>">
											<%
												}
											%>
											
										</datalist>
									</div>
								  </div>

								</div>
							</div>

      <div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMemberReportWingWise()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf" id="wingWise" class="display" style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
						   <th>Sr No</th>
						   <th>First Name</th>
						   <th>Middle Name</th>
						   <th>Last Name</th>
						   <th>Date_Of_Birth</th>
						   <th>Contact No</th>
						   <th>Alternate Contact No</th>
						   <th>Email ID</th>
						   <th>Position</th>
						   <th>Adhar NO</th>
						   <th>PAN NO</th>
						   <th>Wing Name</th>
						   <th>Building Name</th>
						   <th>Floor No.</th>
						   <th>Flat No.</th>
						   <th>SBA</th>
						</tr>
				   </thead>

			
		</table>
		</div>
		</form>
		</div>
		
		
		
				
 		<!------------ Maintenance Report By Member Name---------->

 <%-- <div id="member" class="tab-pane">		
	<form class="form-horizontal" method="post" action="" name="member">
		
		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>



 	<div id="member" class="tab-pane fade in active">		
			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label" for="expenditureName">Member Name:</label>
								</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							 <i class="glyphicon glyphicon-user"></i>
							</span>
										<%
											MaintenanceDetailsDao sdd22 = new MaintenanceDetailsDao();
											List sList22 = sdd22.getAllMemberForReport();
										%>
											<input list="memNameList" id="fk_Member_id" class="form-control" onchange="getMonthAndAmount()" onfocus="this.value=''">
											<datalist id="memNameList">
										<%
											for (int i = 0; i < sList22.size(); i++){
												MemberMaintenancePaymentHibernate sup = (MemberMaintenancePaymentHibernate) sList22.get(i);
										%>

											<option data-value="<%=sup.getFkMemId() %>"
											value="<%=sup.getMemberName()+" "+sup.getContactNo()%>">

										<%
											}
										%>
								
							</datalist>
									</div>
								  </div>

								</div>
							</div>

      <div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMaintenanceReportMemberWise()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf" id="memWise" class="display" style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
						   <th>Sr No</th>
						   <th>First Name</th>
						   <th>Last Name</th>
						   <th>Building Name</th>
						   <th>Wing Name</th>
						   <th>Floor No.</th>
						   <th>Flat No.</th>
						   <th>Amount</th>
						   <th>Date</th>
							
						</tr>
				   </thead>
				<tfoot>
						<th colspan="7" style="text-align: right">Total:</th>
						<th></th>
						<th></th>
						
				</tfoot>
			<!-- </form> -->
			
		</table>
		</div>
		</form>
		</div>
		
 --%>		
		
	
		</div>
		</div>
	</body>
</html>