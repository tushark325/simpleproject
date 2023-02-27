<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.society.hibernate.AnnualMaintenanceDetailsHibernate"%>
<%@page import="com.society.dao.AnnualMaintenanceDao"%>
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


 		<script type="text/javascript"src="/society/staticContent/js/corpusFund.js"></script>



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
		    if ((charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122)) {
		        return false;
		    }
		    return true;
			}


		</script>
		
		
		<script type="text/javascript">
			function isAlphabetsWithSpace(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode!=32 && (charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122)) {
		        return false;
		    }
		    return true;
			}


		</script>


		</head>
		<body>

		<div class="container-fluid">

				<div class="row header_margin_top">
					<div align="center">
						<h2 class="form-name style_heading" style="margin-top: 80px">Corpus Fund</h2>
					</div>
				</div>

				<%
					SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd");
					String todayDate = simpleformat.format(new Date());	
			
				%>

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
		<fieldset>
	<div class="row">
		<div class="row form-group">
		<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">Amount:<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="fa fa-inr"></i>
							</span>
								<input type="text" id="amount" name="amount" class="form-control" placeholder="Amount" onkeypress="return isNumber(event)"/>
						</div>
					</div>
		
					<div class="col-sm-2" align="right">
						<label class="control-label">Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="fa fa-calendar"></i>
							</span> 
							<input type="date" id='date2' name="date2" value="<%=todayDate %>" class="form-control"/>
						</div>
					</div>
       			</div> 
		</div>	
			
			<div class="container" align="center">
				<!-- <div class="col-md-10 text-center"> -->
					<input type="button" id="save" name="btn" style="font-size: 25" class="btn btn-success btn-lg btnn " onclick="validationCorpusFund()" value="Submit"> 
					<input id="save" name="btn" style="font-size: 25" class="btn btn-danger btn-lg btnn" type="reset" onclick="reset()" value="Cancel">
				<!-- </div> -->
			</div>
		</fieldset>
	</form>
</div>

<%@include file="commons/newFooter.jsp" %> 
