<%@page import="java.util.List"%>
<%@page import="com.society.hibernate.EmployeeDetailsHibernate"%>
<%@page import="com.society.dao.EmployeeDetailsDao"%>
<%@page import="com.society.hibernate.ExpenditureDetailsBean"%>
<%@page import="com.society.dao.ExpenditureDetailsDao"%>
<%@page import="com.society.dao.VendorDetailsDao"%>
<%@page import="com.society.hibernate.VendorDetailsHibernate"%>
<%@page import="com.society.dao.ClientEnquiryDao"%>
<%@page import="com.society.hibernate.ClientEnquiryHibernate"%>
<%@page import="com.society.hibernate.MemberBillingHibernate"%>
<%@page import="com.society.dao.MemberDetailsDao"%>
<%@page import="com.society.hibernate.MemberMonthlyContributionCostHibernate"%>
<%@page import="com.society.dao.MemberMonthlyContributionCostDao"%>
<%@page import="com.society.hibernate.AnnualMaintenanceDetailsHibernate"%>
<%@page import="com.society.dao.AnnualMaintenanceDao"%>
<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.dao.MaintenanceDetailsDao"%>
<%@page import="com.society.hibernate.MemberMaintenancePaymentHibernate"%>
<%@page import="com.society.hibernate.AnnualMaintenceGenerationHibernate"%>
<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="/society/staticContent/css/tabDemo.css">
	
<!-- 	<script type="text/javascript" src="/society/staticContent/js/cashbankbook.js"></script>
 -->	
	<script type="text/javascript"src="/society/staticContent/js/annualMaintenance.js"></script>
			
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
	
       <!-- <script>
			function employeePaymentList()
			{
				 window.location = "EmployeePaymentList.jsp";
			}		
		</script>
		
		<script>
			function vendorPaymentList()
			{
				 window.location = "VendorPaymentList.jsp";
			}		
		</script>
		<script>
			function ClientPaymentList()
			{
				 window.location = "ClientPaymentList.jsp";
			}		
		</script>
		-->
		
		<script>
			function AnnualMaintenanceFollowUpList()
			{
				window.location = "AnnualMaintenanceFollowUpList.jsp";
			}
		</script> 
		
		<script>
			function AnnualMaintenanceContractList()
			{
				window.location = "AnnualMaintenanceContractList.jsp";
			}
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
		    if ((charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122))) {
		        return false;
		    }
		    return true;
			}
		</script>
		
		
		<script type="text/javascript">
			function isAlphabetsWithSpace(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode!=32 && (charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122))) {
		        return false;
		    }
		    return true;
		</script>
		
        <script type="text/javascript">	
			function cheakForExpenditure(){
			<%
				AnnualMaintenanceDao exp = new AnnualMaintenanceDao();
					List cList1 =exp.getAllAnnualMaintenceNames();
			%>
			var annualMaintenanceName = $('#annualMaintenanceName').val();
    		var upExpenditureName = annualMaintenanceName.toUpperCase();
    		var duplicate;
			<%
			for(int i=0;i< cList1.size();i++){
				AnnualMaintenanceDetailsHibernate cat=(AnnualMaintenanceDetailsHibernate)cList1.get(i);
			%>
			var subCat = "<%=cat.getAnnualMaintenanceName()%>";
			var subcatName=document.getElementById("annualMaintenanceName").value;
			var UpValue = subCat.toUpperCase();
			if(upExpenditureName == UpValue)
			{
					duplicate = "found";
			}
			if(subcatName == subCat){
				alert("Expenditure already exist...Duplicate Not allowed");
				location.reload();
				return false;
			}
			<%
			}
			%>
			if(duplicate == "found"){
    			document.expenseDetails.btn.disabled = true;	
				alert("Expenditure Name Already Exist..!!!");
				location.reload();
				document.expenseDetails.btn.disabled = false;
    			return false;
    			}
			}
		 </script>
				
	<style>
		.leftmanu
		{
		    width: 190px;
		    background: #c50000a6;
		    color:  white;
		}
		
		.hide
		{
			display: none;
		}
	</style>
	
<script type="text/javascript">
// hide div(div include textbox AND label)
function ch(){
       document.getElementById('WingInfo').style.display = 'none';
		}
		
function yesnoCheck() {
	    if (document.getElementById('WingWise').checked) {
	    	  document.getElementById('WingInfo').style.display = 'block';
	    }
	    else
	    {
	    	 document.getElementById('WingInfo').style.display = 'none';
		}
	}
</script>

</head>

<body onload="ch()">
<div class="container-fluid" > 
<div class="row" style="min-height:300px;">
    <div  class="col-md-12">
        <h3>Left Tabs</h3>
        <hr/>
        <div class="col-md-2">
            <!-- required for floating -->
            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
                 <li class=""><a class="leftmanu" href="#messages" data-toggle="tab" >Annual Maintenance</a></li>
                 <li><a class="leftmanu" href="#vendor22" data-toggle="tab">Annual Maintenance Contract</a></li>
                 <li><a class="leftmanu" href="#client22" data-toggle="tab">Annual Maintenance FollowUp</a></li>
                 
            </ul>
        </div>
        <div class="col-xs-9">
            <!-- Tab panes -->
    <div class="tab-content">
    	
    	
         
	<!------------ Annual Maintenance ---------->
	
       <div class="tab-pane active" id="messages">
      	<form class="form-horizontal" method="post" action="" name="expenseDetails">
      	    <div class="row">
			     <div align="center">
			  		<h2 class="form-name style_heading">Annual Maintenance</h2>
			  	 </div>
			  
			
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
						 <hr style="border-top-color:#c1b1b1;">
		    		</div>	
		   		</div>
		   
		    

		    
		<!-- Value of 'name' attribute is used in customerDetails.js  -->
		<fieldset>
			<div class="row form-group">
				<label class="col-md-3 control-label" for="expenseName">Annual Maintenance Name<sup>*</sup>
				</label>
				<div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="	glyphicon glyphicon-hand-right"></i>
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
			</div>
		<div class="form-group row">
			<div class="col-md-10 text-center">
				<input type="button" id="save" name="btn" style="font-size: 25" class="btn btn-success btn-lg btnn " onclick="validationAnnualExpenseDetails()" value="Submit"> 
				<input id="save" name="btn" style="font-size: 25" class="btn btn-danger btn-lg btnn" type="reset" onclick="reset()" value="Cancel">
				</div>
			</div>
		</fieldset>
	</form>    	    
 </div>
 
 
 	<!--------------- Annual Maintenance Contract  ----------------->
 	
  <div class="tab-pane" id="vendor22">
		<form class="form-horizontal" method="post" action="" name="expenseDetails">
		
      	    <div class="row">
			     <div align="center">
			  		<h2 class="form-name style_heading">Annual Maintenance Contract</h2>
			  	 </div>
			  
			
					<div class="form-group" align="right">
						<div class="col-sm-offset-6 col-md-5 control-label">
							<div id="date">
								<label id="demo2"></label>
								<script>
									   var date2 = new Date();
									   document.getElementById("demo2").innerHTML = date2.toDateString();
									</script>
							</div>
						</div>
					</div>
				</div>
			  	 
		    	 <div class="row">
				     <div class="col-sm-offset-1 col-md-10">
						 <hr style="border-top-color:#c1b1b1;">
		    		</div>	
		   		</div>
		
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
								AnnualMaintenanceDao cdd22 = new AnnualMaintenanceDao();
	       						List cList22 =cdd22.getAllAnnualMaintenceNames();
							%>
							
							<input list="cat_drop2" id="annualMaintenanceName2" class="form-control" onfocus="this.value=''">
							<datalist id="cat_drop2">
							<%
					           for(int i=0;i<cList22.size();i++){
					        	   AnnualMaintenanceDetailsHibernate cat=(AnnualMaintenanceDetailsHibernate)cList22.get(i);
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
						<label class="control-label" for="employeename" style="text-align:  right;">Vendor Name:<sup>*</sup></label>
				</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
								<%
									VendorDetailsDao sdd33 = new VendorDetailsDao();
									List sList44 = sdd33.getAllVendorDetails();
								%>
									<input list="vendorNameList" id="vendorName" class="form-control" onfocus="this.value=''">
									<datalist id="vendorNameList">
								<%
									for (int i = 0; i < sList44.size(); i++) {
										VendorDetailsHibernate sup = (VendorDetailsHibernate) sList44.get(i);
								%>
										<option data-value="<%=sup.getPkVendorDetailsId() %>"
										value="<%=sup.getFirstName()%> <%=sup.getLastName()%> <%=sup.getContactNo()%>">
								<%
									}
								%>
							<!-- <input type="text" id='vendorName' name="vendorName" class="form-control" placeholder="Enter vendor name" /> -->
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
								class="glyphicon glyphicon-hand-right"></i>
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
				    <input type="button" style="font-size:25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="AnnualMaintenanceContractList()">
				
				
				<!-- </div> -->
			</div>
		</fieldset>
	</form>
	</div>
 
 
 <!--------------------------------- Annual Maintenance FollowUp ------------------------------->
 	
  <div class="tab-pane" id="client22">
		<form method="post" action="" name="exp22">
			<div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Annual Maintenance FollowUp</h2>
			  	</div>
		     <div class="row">
				     <div class="col-sm-offset-1 col-md-10">
						  		<hr style="border-top-color:#c1b1b1;">
				     </div>	
		   		 </div>
		    </div>
		    
		<div class="row form-group">
				<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">Annual Maintenance Name:<sup>*</sup>
				</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
		
								<%
									AnnualMaintenanceDao cdd222 = new AnnualMaintenanceDao();
		       						List cList222 =cdd222.getAllAnnualMaintenceGenerationNames();
								%>
							
							<input list="cat_drop22" id="annualMaintenanceNameFollowUp" class="form-control" onchange="getVendorNameForFollowUp()" onfocus="this.value=''">
							<datalist id="cat_drop22">
							
								<%
						           for(int i=0;i<cList222.size();i++){
						        	   AnnualMaintenceGenerationHibernate cat=(AnnualMaintenceGenerationHibernate)cList222.get(i);
								%>
								<option data-value="<%=cat.getFkAnnualMaintenceId() %>"
									value="<%=cat.getAnnualMaintenceName() %>">
									<%
					      			}
					    		%>
							
						</datalist>
						</div>
					</div>
		
					<div class="col-sm-2" align="right">
						<label class="control-label">Maintenance Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> 
							<input type="date" id='maintenanceFollowUpDate' name="maintenanceFollowUpDate" class="form-control"/>
						</div>
					</div>
       			</div> 
     					    
			<div class="row form-group">
				<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">Vendor Name:</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
						
							<input type="text" id="vendorNameFollwUp" name="vendorNameFollwUp" readonly="readonly" class="form-control"> 	
						</div>
					</div>
       	   </div> 

       			
      		<div class="row form-group">
				<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">Type:<sup>*</sup>
				</label>
					<div class="col-sm-4">
						<div class="col-md-4 col-xs-6 ">
							<label class="radio-inline">
							 <input type="radio" name="type" id="Association" value="Association" onclick="javascript:yesnoCheck();" style="margin-left: -70px;"/>
							 <h4 style="margin-top: 0px;margin-left:11px;">Association</h4>
							</label>
						</div>
						
						<div class="col-md-6 col-xs-6 col-md-offset-2">
							<label class="radio-inline">
							 <input type="radio" name="type" id="WingWise" value="WingWise" onclick="javascript:yesnoCheck();" style="margin-left: -101px;"/>
							 <h4 style="margin-top: 0px;margin-right: 300px;margin-left:33px;">Wing</h4>
							</label>
						</div>
						</div>
	  			</div> 
	       	   
       	   
		<div id="WingInfo">
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
								<input list="building_drop22" id="buildingName22" class="form-control" onchange="getGridForMaintenanceFollowUp()">
								<datalist id="building_drop22">
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
	   <div class="table-responsive	row col-md-offset-1" style="margin-left: 265px;margin-top: 26px;">
				<table id="product_grid" ></table>
				<div id="jqGridPager"></div>
		  </div>
		  

				
		<div class="form-group row">
            <div class="col-md-10 text-center" style="margin-top: 29px;margin-left: 126px;">
            <input type="button" id="save" name="btn4" style="font-size: 25" class="btn btn-success btn-lg btnn "  onclick="validationMaintenanceFollowUpDetails(); return false;" value="Submit">
		    <input type="reset" id="btn2" style="font-size: 25" class="btn btn-danger btn-lg btnn" name="btn4" onclick="location.reload()" value="Cancel">
		    <input type="button" style="font-size:25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="AnnualMaintenanceFollowUpList()">
      
      
       <!--     <input type="button" font-size="25" value="List" id="listBtn" class="btn btn-primary btn-lg btn-large button-height-width" onclick="expenditurePaymentList()"> -->
            </div>
        </div> 
     </form>
	</div>

	        
        </div>
     </form>
	</div>
 		</div>	
   </div>
  </div> 
 </div>
</div>
        <%@include file="commons/newFooter.jsp" %> 	
</div>
</body>
</html>		