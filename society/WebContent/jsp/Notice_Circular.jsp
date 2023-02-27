<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.dao.MemberDetailsDao"%>
<%@page import="java.util.List"%>
<%@page import="com.society.hibernate.AnnualMaintenanceDetailsHibernate"%>
<%@page import="com.society.dao.AnnualMaintenanceDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

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
    
	<script type="text/javascript"src="/society/staticContent/js/notice_circular.js"></script>

		<script type="text/javascript">
			function notice_circularList()
			{
				window.location = "notice_circularList.jsp";
			}
		</script>
		
		
		</head>
		<body>

		<div class="container-fluid">

				<div class="row header_margin_top">
					<div align="center">
						<h2 class="form-name style_heading" style="margin-top: 80px">Notice/Circular</h2>
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
		
				<%
				  	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				  	String todayDate = simpleDateFormat.format(new Date());
				%>
				
				
		<div class="row">
				<div class="form-group">


				</div>
			</div>
				
		
			<div class="row">
				<div class="form-group">

					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Send To:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<select id="designation" class="form-control textInput">
								<option value="">--Select--</option>
								<option value="All">All</option>
								<option value="Chairman">Chairman</option>
								<option value="Secretary">Secretary</option>
								<option value="Member">Member</option>
								<option value="Individual">Individual</option>
							</select>
							 
							<!-- <input type="text" id='firstName' name="firstName"  onkeypress="return isAlphabets(event)" class="form-control textInput" placeholder="Enter First Name"  />
							 -->	
						</div>
					</div>
			
					<div class="col-sm-2" align="right">
						<label class="control-label">Date:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> 
							<input type="date" id='date2' name="date2" value="<%=todayDate%>" class="form-control" placeholder="Enter Middle Name">
						</div>
					</div>
				</div>
			</div>
		
		
	 <script>
		$(document).ready(function(){
	  		 $("#designation").change(function(){
	       	$(this).find("option:selected").each(function(){
		       	
	           	if($(this).attr("value")=="Individual"){
	           	$("#card_no2").show(); 
	           	}
	          	 else{
	          		$("#card_no2").hide(); 
	            }
	       });
	      }).change();
		 });	
		</script>

		<div class="row">
			<div id="card_no2" class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Member Name:<sup>*</sup></label>
					</div>
    				<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> 
							<%
								MemberDetailsDao sdd33 = new MemberDetailsDao();
								List sList44 = sdd33.getAllMemberForCashBook();
							%>
							<input list="memeberNameList" id="fk_member_id" class="form-control" onchange="getDetailsOfMwmber()">
							<datalist id="memeberNameList">
								<%
									for (int i = 0; i < sList44.size(); i++) {
										MemberDetailsHibernate sup = (MemberDetailsHibernate) sList44.get(i);
								%>

								<option data-value="<%=sup.getPkMemId() %>"
								value="<%=sup.getFirstName()%> <%=sup.getLastName()%> <%=sup.getContactNo()%>">

									<%
										}
									%>
								
							</datalist>
						</div>
					</div>
					</div>
				</div>
	

	<div class="row">	
		<div class="row form-group">
			<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">Subject:<sup>*</sup>
					</label>
					<div class="col-md-8">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
	
							<input type="text" id='subject' name="subject" class="form-control" placeholder="Enter Subject" />
						<!-- <textarea rows="2" cols="15" id='descrition' name="descrition" class="form-control" placeholder="Enter Descrition"></textarea>
						 -->
						</div>
					</div>
	
			       	</div>
			     </div>  	
			     
			     
			     
			<div class="row">	
		<div class="row form-group">
			<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">Description:<sup>*</sup>
					</label>
					<div class="col-md-8">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
	
						<!-- 	<input type="text" id='descrition' name="descrition" class="form-control" placeholder="Enter Subject" /> -->
						<textarea rows="2" cols="15" id='description' name="description" class="form-control" placeholder="Enter Description"></textarea>
						
						</div>
					</div>
	
			       	</div>
			     </div>
			     
			     
			  </fieldset>
			  </form>
			       	
			       	
			       	 
	      <%--  	<div class="row form-group">
			<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">Member Name:<sup>*</sup>
					</label>
					</div>
					
					<%
						MemberDetailsDao sdd3 = new MemberDetailsDao();
						List sList4 = sdd3.getAllMember();
					%>
					
					<%
							for (int i = 0; i < sList4.size(); i++) 
							{
								MemberDetailsHibernate sup = (MemberDetailsHibernate) sList4.get(i);
					%>
								
					<div id="dataTab">
					<table class="table table-bordered table-striped table-condensed cf"
					style="border: 2px solid black; border-collapse: collapse;">
					
					
				<tr>
					<td> 
						<input TYPE=checkbox name="location[]" VALUE=Cricket >
					</td>	 
					<td>	
						<%=sup.getFirstName()%> <%=sup.getLastName() %>
					</td>
				</tr>
						<%
							}
						%>
			</table>
			</div> --%>
			
			<div class="container" align="center">
				<input type="button" id="save" name="btn" style="font-size: 25; width: 128px;" class="btn btn-success btn-lg btnn " onclick="validationAddNotice_CircularDetails()" value="Print / Email"> 
				<input id="save" name="btn" style="font-size: 25" class="btn btn-danger btn-lg btnn" type="reset" onclick="reset()" value="Cancel">
				<input type="button"  value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="notice_circularList()">
				
		</div>
		</fieldset>
	</form>
</div>

<%@include file="commons/newFooter.jsp" %> 
