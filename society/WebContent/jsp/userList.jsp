<%@page import="java.util.List"%>
  	<% boolean isHome=false;%>
	<%@include file="commons/header.jsp"%>

<%@page import="org.hibernate.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.society.hibernate.UserDetailasHibernate"%>
<%@page import="com.society.utility.HibernateUtility"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.society.helper.MemberMonthlyContributionCostHelper"%>
<%@page import="com.society.dao.MemberMonthlyContributionCostDao"%>
<%@page import="com.society.hibernate.UserDetailsBean"%>
<%@page import="com.society.dao.UserDetailsDao"%>
<%@page import="com.society.helper.UserDetailsHelper"%>
<%@page import="com.society.bean.GetUserDetails"%>
          		
	
	<link href="/society/WebContent/staticContent/css/dataTa.css" rel="stylesheet" type="text/css" media="all" />
	<link href="/society/staticContent/css/dataTables.jqueryui.min.css"  rel="stylesheet" type="text/css" media="all">
	<link rel="stylesheet" href="/society/staticContent/css/tabDemo.css">
 	<link rel="stylesheet" href="/society/staticContent/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/society/staticContent/css/ui.jqgrid.min.css">
    
    <script src="/society/staticContent/js/jquery.min.js"></script>
    <script src="/society/staticContent/js/jquery.jqgrid.min.js"></script>
	<script src="/society/staticContent/js/jquery.dataTables.js" type="text/javascript"></script>
	<script type="text/javascript" src="/society/staticContent/js/jqueryUi.js"></script>
	
	
	
<html>
	<head>
	
		<title>User List</title>
		
  		
  		<script type="text/javascript">
  			function Back()
  			{
  				window.location = "userDetails.jsp" ;
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
		  
					  
					     <style type="text/css">
					      td {
					       color:  black;
					      }
					     </style>
		

	</head>

	

	<script type="text/javascript"> 
		$(document).ready(function () {
	         var table=$("#list").dataTable();
			 var tableTools = new $.fn.dataTable.TableTools(table, {
				 'sSwfPath':'//cdn.datatables.net/tabletools/2.2.4/swf/copy_csv_xls_pdf.swf',
				 	'aButtons':['copy','print','csv',{
					 'sExtends':'xls',
					 'sFileName':'Data.xls',
					 'sButtonText': 'Save to Excel'
						}
					]
				});
					$(tableTools.fnContainer()).insertBefore('#list_wrapper');
			});
	</script>

<body id="dt_example" style="min-height:300px;">
		
		<div class="row header_margin_top">
				    <div align="center">
				  		<h2 class="form-name style_heading" style="margin-top: 80px">User List</h2>
				  	</div>
				 	
			     <div class="row">
					     <div class="col-sm-offset-1 col-md-10">
							  		<hr style="border-top-color:#c1b1b1;">
					     </div>	
			   		 </div>
		</div>
		</div>
	
			    
	<%
	UserDetailsDao dao=new UserDetailsDao();
	List list12=dao.getUserList();
	%>
	
	<div id="date">
		<label id="demo"></label>
		<script>
			var date = new Date();
			document.getElementById("demo").innerHTML = date.toDateString();
		</script>
	</div>
	
	<div id="demo_jui" class="table table-bordered table-striped table-condensed cf" >
		<table id="list" class="display" style="border: 2px solid black; border-collapse: collapse;">
			<thead>
				<tr>
				
				      <th>User Details Id</th>
					<th>First Name</th>      
					<th>Last Name</th>   
					<th>Pan Card Number</th>         
	                <th>Contact No</th>
	                <th>TypeId</th>
					<th>User Name</th>
					<th>Password</th>
		</tr>
			</thead>
			
			<tbody>
   				<%
					for(int i=0;i<list12.size();i++){
						 UserDetailasHibernate sr=( UserDetailasHibernate)list12.get(i);
				%>
				
				<tr>
				    <td class="align"><%=sr.getPkUserDetailsId()%></td>
					<td class="align"><%=sr.getFirstName()%></td>
					<td class="align"><%=sr.getLastName()%></td>
					<td class="align"><%=sr.getPancardNumber()%></td>
					<td class="align"><%=sr.getContactNumber()%></td>
					<td class="align"><%=sr.getTypeId()%></td>	
					<td class="align"><%=sr.getUserName()%></td>
					<td class="align"><%=sr.getPassword()%></td>
						
				</tr>
	
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	
	<div class="wrapper" align="center">
		<!-- <input type="button" value="Back" id="listBtn" class="btn btn-primary" onclick="Back()" /> -->
		<!-- <input style=" font-size: 25;height: 65px; width: 180" type="button" value="Back" id="listBtn" class="btn btn-primary" onclick="Back()" />  -->
		<input type="button" value="Back" id="listBtn" style="font-size: 30;height: 50px; width: 500" class="btn btn-primary btn-lg btnn" onclick="Back()" /> 
	</div>
	
</body>

</html>