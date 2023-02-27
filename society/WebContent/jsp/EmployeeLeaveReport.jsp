<%@page import="com.society.hibernate.EmployeeLeaveHibernate"%>
<%@page import="com.society.dao.EmployeeDetailsDao"%>
<%
	boolean isHome = false;
%>
<%@include file="commons/header.jsp"%>
<%@page import="java.util.List"%>
<head>
	
	
	<style type="text/css">
	
	div.dataTab 
	{
        width: 80%;
    }
	</style>
	</head>

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

  	<script src="/society/staticContent/js/employeeDetails.js"></script>

    <script>
	     $(document).ready(function(){
	    	 employeeLeaveReport();
		}); 
	</script>

	<script type="text/javascript">

	$(document).ready(function(){
	    $('#empLeaveDetails').DataTable();
	});

	</script>

	
    <!-- <body id="dt_example" class="master_form_img">
     -->
     
     
	<div class="container-fluid" style="min-height:300px;">

		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Employee Leave Details Report</h2>
			</div>
		</div>

<!-- <div class="row"> -->


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
			<div class="col-md-12">
				<hr style="border-top-color: #c1b1b1;">
			</div>
		
	<div id="date">
		<label id="demo"></label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div>
		
		
 <form class="form-horizontal" method="post" action="" name="empReport1">
 
			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
						<label class="control-label" for="employeename">Employee Name:<sup>*</sup></label>  
          				</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							 <i class="glyphicon glyphicon-user"></i>
							</span>
						    <%
							    EmployeeDetailsDao sdd3 = new EmployeeDetailsDao();
								List sList4 = sdd3.getAllMainEmployee();
							 %>
							 <input list="employeeNameList" id="fk_employee_id" class="form-control">
								<datalist id="employeeNameList">
								 <%
									for (int i = 0; i < sList4.size(); i++) {
										EmployeeLeaveHibernate sup = (EmployeeLeaveHibernate) sList4.get(i);
								 %>

								<option data-value="<%=sup.getEmpLeavePkId()%>" 
								             value="<%=sup.getEmpName()%>">
									
									<%
										}
									%>
								</datalist>
							</div>
						</div>
						
					
					<div class="row form-group buttons_margin_top " style=" margin right: 10px; padding-bottom: 10px; margin-right: 420px;">
						<div align="center">
							<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="employeeLeaveReportValidation()" value="Search" />
						</div>
					</div>
					
									
					</div>
				</div>

	<div id="dataTab">
					<table class="table table-bordered table-striped table-condensed cf"
						id="empLeaveDetails" class="display"
						style="border: 2px solid black; border-collapse: collapse;">
						<thead>
							<tr>
								<th>Sr No</th>
							    <th>Employee Name</th>
								<th>Leave Date From</th>
								<th>Leave Date To</th>
								<th>Type</th>
								<th>Description</th>
								<th>Approved By</th>
								
							</tr>
						</thead>
						<tfoot>
						</tfoot>
					</table>
					</div>
			</form>
		</div>
		</div>
