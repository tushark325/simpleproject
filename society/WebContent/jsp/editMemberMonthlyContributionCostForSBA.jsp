<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.society.hibernate.AnnualMaintenanceDetailsHibernate"%>
<%@page import="com.society.dao.AnnualMaintenanceDao"%>
<%@page import="com.society.dao.MemberMonthlyContributionCostDao"%>
<%@page import="com.society.hibernate.MonthlyContributionCostBySBAHibernate"%>

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
    
<!-- 	<script type="text/javascript"src="/society/staticContent/js/expenditureDetails.js"></script>
 -->
 
 	<script type="text/javascript"src="/society/staticContent/js/monthlyContribution.js"></script>


<script type="text/javascript">
			function isNumber(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode > 31 && (charCode < 46 || charCode > 57)) {
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

		<script type="text/javascript">
			function back()
			{
				window.location="MemberMonthlyContributionCost.jsp";
			}

		</script>
		
		<script type="text/javascript">
			function back()
			{
				window.location="MemberMonthlyContributionCost.jsp";
			}
		</script>

<!-- 		
<script type="text/javascript">
function pageLoad(){
	$("#monthlyAmount").show();
	$("#SBAWise").hide(); 
}
function openCashCustomerBilling() {
	$("#monthlyAmount").show();
	$("#SBAWise").hide();
}
function openCreditCustomerBilling() {
	$("#SBAWise").show();
	$("#monthlyAmount").hide();
}
</script>
 -->
		</head>
	<body onload="pageLoad()">

		<div class="container-fluid">

				<div class="row header_margin_top">
					<div align="center">
						<h2 class="form-name style_heading" style="margin-top: 80px">Member Monthly Contribution</h2>
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
		<!-- Value of 'name' attribute is used in customerDetails.js  -->
		<fieldset>
		 
		 
<!-- 		  <div class="textalign" style="margin-left: 639px;margin-bottom: 29px;">
   			 <label>
       			 <input type="radio" checked name="customertype" id="customertype" checked="checked" onclick="openCashCustomerBilling()"> 
         		<div class="btn1 btn-sık" ><span>Monthly</span></div>
          	</label>
    	 	<label>
		        <input  type="radio" name="customertype" id="customertype" onclick="openCreditCustomerBilling()"> 
		       	<div class="btn1 btn-sık"><span>SBA Wise</span></div>
	       	</label>
       	  </div>
		 -->
		 
		 
 				   <%
 				  		Double sbaAmount = 0.0;
 				  		Date date = null;
						MemberMonthlyContributionCostDao cdd = new MemberMonthlyContributionCostDao();
      						List cList = cdd.getMonthlyContributionCostAmountForSBA();
				
      				for(int i=0;i<cList.size();i++)
			           {
      					MonthlyContributionCostBySBAHibernate cat=(MonthlyContributionCostBySBAHibernate)cList.get(i);
						
			        	   sbaAmount = cat.getSbaPerPrice();
			        	   date = cat.getCutOffDate();
			        	   
			           }
		    		%>
		    		
	<!--            <script>
		    			document.getElementById("cutOffDate").value = date;
					
		    		</script> -->
	
	  <div id="SBAWise">  	
		<div class="row">
			<div class="row form-group">
			<label class="col-md-3 control-label" for="employeename" style="text-align:  right;">SBA Per Price:<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="fa fa-inr"></i>
							</span>
	
						<input type="text" id="sbaPerPrice" name="sbaPerPrice" value="<%=sbaAmount %>"
								class="form-control" placeholder="Enter SBA per price" onkeypress="return isNumber(event)"/>
							
						</div>
					</div>
		
					<div class="col-sm-2" align="right">
						<label class="control-label">Cut Off Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="fa fa-calendar"></i>
							</span> 
							<input type="date" id='startDate' name="cutOffDateBySBA" class="form-control"/>
						</div>
					</div>
       			</div> 
				
			
				
			<!-- <div class="row form-group">
					<div class="col-sm-3" align="right">
							<label class="control-label">Cut Off Date:<sup>*</sup></label>
						</div>
						<div class="col-sm-3">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="fa fa-calendar"></i>
								</span> 
								<input type="date" id='cutOffDateForSBA' name="cutOffDateBySBA" class="form-control"/>
							</div>
						</div>
		   		</div> 
	 -->	   		
			</div>	
	
	
			<div class="container" align="center">
				<!-- <div class="col-md-10 text-center"> -->
					<input type="button" id="saveForSBA" name="btn" style="font-size: 25" class="btn btn-success btn-lg btnn " onclick="updateMemberMonthlyContributionSBA()" value="Update"> 
					<input id="save2" name="btn" style="font-size: 25" class="btn btn-danger btn-lg btnn" type="reset" onclick="reset()" value="Cancel">
					<input type="button"  value="Back" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="back()">
					
					
				<!-- </div> -->
			</div>
					</div>	
			
		
 	</fieldset>
	</form>
</div>

<%@include file="commons/newFooter.jsp" %> 
