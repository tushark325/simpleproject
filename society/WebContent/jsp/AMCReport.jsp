<%@page import="com.society.hibernate.AnnualMaintenanceDetailsHibernate"%>
<%@page import="com.society.dao.AnnualMaintenanceDao"%>
<%@page import="com.society.hibernate.AnnualMaintenanceFollowUpHibernate"%>

<%@page import="java.util.List"%>
<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="/society/staticContent/css/tabDemo.css">
	
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
	
  		<script type="text/javascript"src="/society/staticContent/js/annualMaintenance.js"></script>

		    <script>
			     $(document).ready(function(){
			    	 annualMaintenanceContractReport();
				}); 
			</script>
			
			<script>
			     $(document).ready(function(){
			    	 annualMaintenanceFollowUpReport();
				}); 
			</script>
				
				
	<style>
		.leftmanu
		{
		    width: 190px;
		    background: #c50000a6;
		    color:  white;
		}
	</style>


<body onload="pageLoad()">
<div class="container-fluid" > 
  <div class="row" style="min-height:300px;">
    <div  class="col-md-12">
        <h3>Left Tabs</h3>
        <hr/>
        <div class="col-md-2">
            <!-- required for floating -->
            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
                <li class=""><a class="leftmanu" href="#messages" data-toggle="tab" >Annual Maintenance Contract</a></li>
                 <li><a class="leftmanu" href="#vendor" data-toggle="tab">Annual Maintenance FollowUp</a></li>
             
              <!-- <li><a class="leftmanu" href="#client" data-toggle="tab">Client Payment</a></li>
               <li><a class="leftmanu" href="#settings" data-toggle="tab">Expenditure Payment</a></li>
                <li><a class="leftmanu" href="#member" data-toggle="tab">Member Payment</a></li> -->
                
            </ul>
        </div>
        <div class="col-xs-9">
            <!-- Tab panes -->
    <div class="tab-content">
    	
    	
         
  <!----------------------- Annual Maintenance Contract Report----------------------->
	
   <div class="tab-pane active" id="messages">
           		<form class="form-horizontal" method="post" action="" name="emp">
   	    	 <div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Annual Maintenance Contract Report</h2>
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
					     <div class="col-sm-offset-1 col-md-10">
							  <hr style="border-top-color:#c1b1b1;">
					     </div>	
		   		     </div>
		       </div>
			 	
		 	
 		 <div id="building" class="tab-pane fade in active">		
	<!-- <form class="form-horizontal"> -->
		<div class="row form-group">
				<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">Annual Maintenance Name:<sup>*</sup>
				</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
	
							<%
								AnnualMaintenanceDao cdd222 = new AnnualMaintenanceDao();
	       						List cList222 =cdd222.getAllAnnualMaintenceNames();
							%>
							
							<input list="cat_drop22" id="annualMaintenanceName" class="form-control">
							<datalist id="cat_drop22">
							<%
					           for(int i=0;i<cList222.size();i++){
					        	   AnnualMaintenanceDetailsHibernate cat=(AnnualMaintenanceDetailsHibernate)cList222.get(i);
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
     					
			
      <div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="annualMaintenanceContractReport()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf"
			id="annualMaintenanceContractReport" class="display" style="border: 2px solid black; border-collapse: collapse;">
			<thead>
			<tr>
				
					<th>Sr No</th>
					<th>Maintenance Name</th>
					<th>Start Date</th>
	                <th>End Date</th>
	                <th>Vendor Name</th>
	                <th>Amount</th>
	                <th>Description</th>
	                
				</tr>
			</thead>

		</table>
		</div>
			     
			      				  
            </form>    	    
 </div>
 
 
 	<!--------------- Annual Maintenance FollowUp Report ----------------->
 	
   <div class="tab-pane" id="vendor">
           		<form class="form-horizontal" method="post" action="" name="emp">
   	    	 <div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Annual Maintenance FollowUp Report</h2>
			  	</div>
	
					<div class="form-group" align="right">
						<div class="col-sm-offset-8 col-md-4 control-label">
							<div id="date">
								<label id="demo2"></label>
								<script>
									var date2 = new Date();
									document.getElementById("demo2").innerHTML = date2.toDateString();
								</script>
							</div>
						</div>
					</div>
		
		
		             <div class="row">
					     <div class="col-sm-offset-1 col-md-10">
							  <hr style="border-top-color:#c1b1b1;">
					     </div>	
		   		     </div>
		       </div>
			 	
		 	
 		 <div id="building" class="tab-pane fade in active">		
	<!-- <form class="form-horizontal"> -->
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
	       						List cList22 =cdd22.getAllAnnualMaintenceFollowUpNames();
							%>
							
							<input list="cat_drop222" id="annualMaintenanceFollowUpName" class="form-control">
							<datalist id="cat_drop222">
							<%
					           for(int i=0;i<cList22.size();i++){
					        	   AnnualMaintenanceFollowUpHibernate cat=(AnnualMaintenanceFollowUpHibernate)cList22.get(i);
							%>
							<option data-value="<%=cat.getFkMaintenanceId() %>"
								value="<%=cat.getAnnualMaintenanceName()%>">
								<%
				      			}
				    		%>
							
						</datalist>
						</div>
					</div>

       			</div> 
     					
			
      <div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="annualMaintenanceFollowUpReport()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf"
			id="annualMaintenanceFollorUpReport" class="display" style="border: 2px solid black; border-collapse: collapse;">
			<thead>
			<tr>
				
					<th>Sr No</th>
					<th>Annual Maintenance Name</th>
					<th>Maintenance FollowUp Date</th>
	                <th>Vendor Name</th>
	                <th>Type</th>
	                <th>Wing Name</th>
	                <th>Building Name</th>
	                <th>Description</th>
	                
				</tr>
			</thead>

		</table>
		</div>
			     
			      				  
            </form>    	    
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