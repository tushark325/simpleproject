<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.dao.MaintenanceDetailsDao"%>
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

	<!-- <script type="text/javascript" src="/society/staticContent/js/memberDetails.js"></script> -->
	
	<script type="text/javascript" src="/society/staticContent/js/annualMaintenance.js"></script>

    <script>
	     $(document).ready(function(){
	    	 getMaintenanceAssociationReport();
		}); 
	</script>
	
    <body id="dt_example" class="master_form_img">
    
    <div class="container">
    
	
 		<div class="row">
			<div align="center" style="margin-top: 75px">
				  <h2 class="form-name style_heading">Maintenance Income Report</h2>
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
		    <li><a data-toggle="tab" href="#twoDates"><h4 style="color:blue">Wing Wise</h4></a></li>
		    <li><a data-toggle="tab" href="#home"><h4 style="color:blue">Building Wise</h4></a></li>
		    <li><a data-toggle="tab" href="#member"><h4 style="color:blue">Member Wise</h4></a></li>
		 <!--    <li><a data-toggle="tab" href="#year"><h4 style="color:blue">Yearly</h4></a></li>
		    <li><a data-toggle="tab" href="#month"><h4 style="color:blue">Monthly</h4></a></li> -->
	   </ul>
 	 
 	  	<div class="tab-content" style="float: left">
 	 
 	 
 	 
 	 
 	<!------------------------------ Maintenance Report By Association  --------------------------------------->

 <div id="association" class="tab-pane in active">		
	<form class="form-horizontal" method="post" action="" name="dates">
		
		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>



 	<div id="association" class="tab-pane fade in active">		
			
	<table class="table table-bordered table-striped table-condensed cf" id="asociation" class="display" style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
						   <th>Sr No</th>
						   <th>First Name</th>
						   <th>Last Name</th>
						   <th>Wing Name</th>
						   <th>Building Name</th>
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
		
	 
 		<!----------------------------------- Maintenance Report By Building--------------------------------->

 <div id="home" class="tab-pane fade">		
	<form class="form-horizontal" method="post" action="" name="dates">
 	

		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>

 <div id="home" class="tab-pane fade in active">		
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
											MaintenanceDetailsDao exdd = new MaintenanceDetailsDao();
											List buidList = exdd.getBuildingName();
										%>
										<input list="buil_drop" id="buildingName" class="form-control">
										<datalist id="buil_drop">
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
							
					<div class="row">
						<div class="form-group">
							<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label" for="expenditureName">Start Date:</label>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
									 <i class="glyphicon glyphicon-calendar"></i>
									</span>
										<input type="date" id="startDateBuilding" name="startDateBuilding" class="form-control">	
												
								</div>
							</div>
							
							
						<div class="col-md-2" align="right">
								<label class="control-label" for="expenditureName">End Date:</label>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
									 <i class="glyphicon glyphicon-calendar"></i>
									</span>
										<input type="date" id="endDateBuilding" name="endDateBuilding" class="form-control">	
								</div>
							</div>
					    </div>
					</div>
			
      <div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMaintenanceReportBuildingWise()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf" id="BuildingWise" class="display" style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
						   <th>Sr No</th>
						   <th>First Name</th>
						   <th>Last Name</th>
						   <th>Wing Name</th>
						   <th>Building Name</th>
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
			
		</table>
		</div>
		</form>
		</div>
		
 <!-------------------------------- Maintenance Report By Wing------------------------->

 <div id="twoDates" class="tab-pane">		
	<form class="form-horizontal" method="post" action="" name="dates">
		
		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>



 	<div id="home" class="tab-pane fade in active">		
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
											MaintenanceDetailsDao exdd2 = new MaintenanceDetailsDao();
											List wingList = exdd2.getWingName();
										%>
										<input list="wing_drop" id="wingName" class="form-control">
										<datalist id="wing_drop">
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
							
							
					<div class="row">
						<div class="form-group">
							<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label" for="expenditureName">Start Date:</label>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
									 <i class="glyphicon glyphicon-calendar"></i>
									</span>
										<input type="date" id="startDateWing" name="startDateWing" class="form-control">	
												
								</div>
							</div>
							
							
						<div class="col-md-2" align="right">
								<label class="control-label" for="expenditureName">End Date:</label>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
									 <i class="glyphicon glyphicon-calendar"></i>
									</span>
										<input type="date" id="endDateWing" name="endDateWing" class="form-control">	
												
								</div>
							</div>
					    </div>
					</div>
							
      <div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMaintenanceReportWingWise()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf" id="wingWise" class="display" style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
						   <th>Sr No</th>
						   <th>First Name</th>
						   <th>Last Name</th>
						   <th>Wing Name</th>
						   <th>Building Name</th>
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
		
		
		
				
  <!----------------------------------- Maintenance Report By Member Name------------------------------>

 <div id="member" class="tab-pane">		
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
						<label class="control-label" for="expenditureName">Wing Name:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								 <i class="glyphicon glyphicon-stats"></i>
							</span>
									<%
										MaintenanceDetailsDao exdd222 = new MaintenanceDetailsDao();
										List wingList222 = exdd222.getWingName();
									%>
									<input list="wing_drop22" id="wingName22" class="form-control" onchange="getBuildingNamebyWingName()">
									<datalist id="wing_drop22">
									<%
										for (int i = 0; i < wingList222.size(); i++) {
											MemberDetailsHibernate expbean = (MemberDetailsHibernate) wingList222.get(i);
									%>
									<option data-value="<%=expbean.getPkMemId()%>"
										value="<%=expbean.getWingName() %>">
										<%
											}
										%>
											
									 </datalist>
									</div>
								  </div>
								  
								
					<div class="col-md-2" align="right">
						<label class="control-label" for="expenditureName">Building Name:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								 <i class="glyphicon glyphicon-stats"></i>
							</span>
								<input list="building_drop22" id="buildingName22" class="form-control" onchange="getMemberByWingAndBuilding()">
								<datalist id="building_drop22">
						</div>
					</div>
				</div>
			</div>
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
										<%-- <%
											MaintenanceDetailsDao sdd22 = new MaintenanceDetailsDao();
											List sList22 = sdd22.getAllMemberForReport();
										%>
											<input list="memNameList" id="fk_Member_id" class="form-control">
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
								
									</datalist> --%>
									
											<input list="memNameList" id="fk_Member_id" class="form-control">
											<datalist id="memNameList">
									
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
						   <th>Wing Name</th>
						   <th>Building Name</th>
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
		
		
		
		
		
<%-- 		
			<!------------ Maintenance Report By Yearly---------->

 <div id="year" class="tab-pane">		
	<form class="form-horizontal" method="post" action="" name="member">
		
		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>



 	<div id="year" class="tab-pane fade in active">		
			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label" for="expenditureName">Year:</label>
								</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							 <i class="glyphicon glyphicon-user"></i>
							</span>
										<%
											MaintenanceDetailsDao sdd222 = new MaintenanceDetailsDao();
											List sList222 = sdd222.getAllYearForReport();
										%>
											<input list="yearList" id="Year_id" class="form-control" onchange="getMonthAndAmount()" onfocus="this.value=''">
											<datalist id="yearList">
										<%
											for (int i = 0; i < sList222.size(); i++){
												MemberMaintenancePaymentHibernate sup = (MemberMaintenancePaymentHibernate) sList222.get(i);
										%>

											<option data-value="<%=sup.getFkMemId() %>"
											value="<%=sup.getYear()%>">

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
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMaintenanceReportYearly()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf" id="yearly" class="display" style="border: 2px solid black; border-collapse: collapse;">
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



			<!------------ Maintenance Report By Month---------->

 <div id="month" class="tab-pane">		
	<form class="form-horizontal" method="post" action="" name="month">
		
		<div class="row">
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		</div>



 	<div id="month" class="tab-pane fade in active">		
			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label" for="expenditureName">Year:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							 <i class="glyphicon glyphicon-hand-right"></i>
							</span>
										<%
											MaintenanceDetailsDao sdd2222 = new MaintenanceDetailsDao();
											List sList2222 = sdd2222.getAllYearForReport();
										%>
											<input list="yearList2" id="Year_id2" class="form-control" onchange="getMonthbyYear()" onfocus="this.value=''">
											<datalist id="yearList2">
										<%
											for (int i = 0; i < sList2222.size(); i++){
												MemberMaintenancePaymentHibernate sup = (MemberMaintenancePaymentHibernate) sList2222.get(i);
										%>

											<option data-value="<%=sup.getFkMemId() %>"
											value="<%=sup.getYear()%>">

										<%
											}
										%>
								
							</datalist>
							</div>
						</div>
						
				<div class="col-md-2" align="right">
					<label class="control-label" for="expenditureName">Month:</label>
				</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							 <i class="glyphicon glyphicon-hand-right"></i>
							</span>
											
								<input list="monthList2" id="month2" class="form-control" onfocus="this.value=''">
								<datalist id="monthList2"></datalist>	
										
							</div>
					</div>
				</div>
			</div>

      <div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMaintenanceReportMonthly()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf" id="monthly" class="display" style="border: 2px solid black; border-collapse: collapse;">
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
		
    </table>
		</div>
		</form>
		</div>



 --%>

		</div>
		</div>
	</body>
</html>