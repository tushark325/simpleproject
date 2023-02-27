<%@page import="com.society.hibernate.VisitorsDetailsHibernate"%>
<%@page import="com.society.bean.VisitorDetailsBean"%>
<%@page import="com.society.dao.VisitorsDetailsDao"%>

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
	
	<script src="/society/staticContent/js/visitorsDetails.js"></script>

   <!--  <script>
	     $(document).ready(function(){
	    	 getVisitorReportBetTwoDate();
		}); 
	</script> -->
	
    <body id="dt_example" class="master_form_img">
    
    <div class="container">
    
	
 		<div class="row">
			<div align="center" style="margin-top: 75px">
				  <h2 class="form-name style_heading">Visitor Report Between Two Date</h2>
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
								<label class="control-label" for="expenditureName">Start Date:</label>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
									 <i class="glyphicon glyphicon-calendar"></i>
									</span>
										<input type="date" id="startDateVis" name="startDateVis" class="form-control">	
												
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
										<input type="date" id="endDateVis" name="endDateVis" class="form-control">	
												
								</div>
							</div>
					    </div>
					</div>
							
      <div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getVisitorReportBetTwoDate()" value="Search" />
			</div>
	  </div>

	<table class="table table-bordered table-striped table-condensed cf" id="VisitReport" class="display" style="border: 2px solid black; border-collapse: collapse;">
					<thead>
						<tr>
						   <th>Sr No</th>
								    <th>Member Name</th>
									<th>Visitor Name</th>
									<th>Contact No</th>
								   	<th>Vehicle No</th>
									<th>Building Name</th>
								    <th>Wing Name</th>
									<th>Floor No</th>
									<th>Flat No</th>
								   	<th>Date</th>
								   	<th>In Time</th>
								   	<th>Out Time</th> 	
								   	<th>Reason</th>
							
						</tr>
				   </thead>
				<!-- <tfoot>
						
				</tfoot> -->
			<!-- </form> -->
			
		</table>
		</div>
		</form>
		</div>
		
	</div>
</body>
</html>