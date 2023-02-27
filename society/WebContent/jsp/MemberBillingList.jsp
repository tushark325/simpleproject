<%@page import="com.society.hibernate.EmployeeDetailsHibernate"%>
<%@page import="com.society.bean.MemberBillingBean"%>
<%@page import="com.society.dao.MemberBillingDao"%>
<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<html>
<head>
<!-- 
	<script src="/society/staticContent/js/billing.js"></script>

	 <script>
	     $(document).ready(function()
	    {
	    	 hrBillingList();
		}); 
	 </script>
 -->
  	
<script type="text/javascript">
	 function Back() {
			 window.location = "Billing.jsp";
			
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
			   
					   
		   <script src="/society/staticContent/js/billing.js"></script>
	
					     <style type="text/css">
					      td 
					      {
					      	 color:  black;
					      }
					     </style>
   <script>
	     $(document).ready(function(){
	    	 memberBillingList();
	}); 
	</script>
	
</head>


   <div class="container-fluid" style="min-height:300px;">

				<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Member Billing List</h2>
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
<%-- 	
	<%
		MemberBillingDao dao = new MemberBillingDao();
		List<MemberBillingBean> list = dao.getHrBillingList();
	
	%> --%>


	<div id="demo_jui">
	<div class="table-responsive">
		<table class="table table-bordered table-striped table-condensed cf"
					id="memBillingList" class="display"
					style="border: 2px solid black; border-collapse: collapse;">
			<thead>
			<tr>
					<th>Sr No.</th>
					<th>Member Name</th>
					<th>Date Of Billing</th>
	                <th>Description</th>
	                <th>Total</th>
					<th>Gross Total</th>
					<th>Bill No</th>
					
				</tr>
			</thead>
				</table>
			<%-- <tbody>
		
   				<%
		            	int k=1;
   						Double total=0.0;
					for(int i=0;i<list.size();i++)
					{
						MemberBillingBean sr=(MemberBillingBean)list.get(i);
						
				%>
				
				<tr>
					<td class="align"><%=k++ %></td>
				    <td class="align"><%=sr.getMemberName() %></td>
					<td class="align"><%=sr.getDate() %></td>
					<td class="align"><%=sr.getDescription() %></td>
					<td class="align"><%=sr.getAmount() %></td>
					<td class="align"><%=sr.getGrossTotal() %></td>
					
				</tr>
	
				
				<%
					total =total + sr.getGrossTotal();
					}
				%>
			</tbody> --%>
		<%-- 	<tfoot>
				<th></th><th></th><th></th><th></th>
				<th>Total :</th><th><%=total %></th>
			</tfoot> --%>
	
	</div>
	</div>
	<div class="wrapper" align="center">
		<input type="button" style=" font-size: 25" value="Back" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="Back()" /> 
	</div>
	
	<%@include file="commons/newFooter.jsp" %>
	
</div>