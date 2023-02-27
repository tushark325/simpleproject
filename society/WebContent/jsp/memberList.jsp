<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.bean.GetMemberDetailsBean"%>
<%@page import="com.society.dao.MemberDetailsDao" %>
<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<html>
<head>
  	<script src="/society/staticContent/js/memberDetails.js"></script>
  	
  	
  	<!-- <script>
	     $(document).ready(function(){
	    	 memberList();
	}); 
	</script> -->
	
	
	<script type="text/javascript">
		 function Back() {
				 window.location = "MemberDetails.jsp";
		}
	
	</script>
	
	<script type="text/javascript">
		  $('#memDetails').dataTable({
		      "bInfo" : false,
		      scrollX: true,
		  });

	  </script>

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
		
		
					     <style type="text/css">
					      td {
					       color:  black;
					      }
					     </style>
</head>

<body onload="memberList()">
   <div class="container-fluid" style="min-height:300px;">

		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Member List</h2>
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

		<div id="dataTab">
		<table class="table table-bordered table-striped table-condensed cf"
					id="memDetails" class="display"
					style="border: 2px solid black; border-collapse: collapse;">
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
									<th>Aadhar No</th>
									<th>Pan No</th>
									<th>Wing Name</th>
									<th>Building Name</th>
									<th>Floor No</th>
									<th>Flat No</th>
									<th>Super BuiltUp Area</th>
								</tr>
								
						</thead>
						<tfoot>
						</tfoot>
					</table>
					</div>
	<div class="wrapper" align="center">
		<input type="button" style=" font-size: 25" value="Back" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="Back()" /> 
	</div>
	
	<%@include file="commons/newFooter.jsp" %>
	
</div>
</body>
</html>