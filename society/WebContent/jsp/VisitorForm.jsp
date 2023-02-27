<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.society.hibernate.UserDetailasHibernate"%>
<%@page import="com.society.utility.HibernateUtility"%>
<%@page import="com.society.hibernate.VisitorsDetailsHibernate"%>
<%@page import="com.society.dao.VisitorsDetailsDao"%>
<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.dao.MemberDetailsDao"%>

<html>
<head>

<meta charset="utf-8">

		<script type="text/javascript" src="/society/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/society/staticContent/css/jquery-ui.min.css">
		<link rel="stylesheet" href="/society/staticContent/css/ui.jqgrid.css">
		<script type="text/javascript" src="/society/staticContent/js/jquery.min.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jquery-ui-min.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jquery-ui.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jqueryUi.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jquery.jqgrid.min.js"></script>		
		<link href="/staticContent/css/StyleValidation.css" rel="stylesheet" type="text/css"/>
		<link href="/staticContent/css/RadioButtonStyle.css" rel="stylesheet" type="text/css"/>		
		<script type="text/javascript" src="/staticContent/js/bootbox.min.js"></script>
		<script type="text/javascript" src="/staticContent/js/bootstrap.js"></script>  
         <script src="/society/staticContent/js/visitorsDetails.js"></script>

<script type="text/javascript"> 
function display_c(){
var refresh=1000; // Refresh rate in milli seconds
mytime=setTimeout('display_ct()',refresh)
}

function display_ct()
{
	var x = new Date()
	var hrs;
	var mins;
	var s;
	
	if(x.getHours() < 10)
	{
		hrs = "0"+x.getHours();
	}
	else
	{
		hrs = x.getHours();
	}
	
	if(x.getMinutes() < 10)
	{
		mins = "0"+x.getMinutes();
	}
	else
	{
		mins = x.getMinutes();
	}
	
	if(x.getSeconds() < 10)
	{
		s = "0"+x.getSeconds();
	}
	else
	{
		s = x.getSeconds();
	}
	
	var x1 = hrs+ ":" +  mins + ":" +  s;
	document.getElementById('inTime').value = x1;
	document.getElementById('outTime2').value = x1;	
	
	display_c();
}
</script>

             <script type="text/javascript">
          		 function visotorList()
          		 {
          			 window.location = "visitorTodayList.jsp";
          		 }
          		 /* function editEmployee() {
          			 window.location = "editEmployeeDetails.jsp";
				} */
          		</script> 
   		<script type="text/javascript">
				function edit()
				{
					window.location = "EditEmployeeDetails.jsp"
				}
   		</script>
   		
        <script>
				function lettersonly(input)
				{		
					var regex = /[^a-z ]/gi;
					input.value = input.value.replace(regex, "");
		
				}
		
				/* function numbersonly(input) {
					var regex = /[^0-9 .]/gi;
					input.value = input.value.replace(regex, "");
				} */
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

		
			function nameVerify(){

					if(firstName.value !=""){

						firstName.style.border = "1px solid #5E6E66";
						name_error.innerHTML="";
						return true;
						}


				}
			
		</script>
		
		
<script type="text/javascript">
function pageLoad(){
	$("#billingAmount").show();
	$("#maintenanceAmount").hide(); 
}
function openCashCustomerBilling() {
	$("#billingAmount").show();
	$("#maintenanceAmount").hide();
}
function openCreditCustomerBilling() {
	$("#maintenanceAmount").show();
	$("#billingAmount").hide();
}
</script>
	
</head>
<body onload="pageLoad(); display_c();">
	<div class="container-fluid">
		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Visitor Details</h2>
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
	
	<div id="wrqpper">
		<form class="form-horizontal" name="empd" onsubmit="Validate()">


<%
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate = simpleFormat.format(new Date());

%>
<!-- 
		<div class="container">
 
  			<div class="btn-group-vertical">
    		<button type="button" class="btn btn-primary">IN</button>
    		
    		<button type="button" class="btn btn-primary">OUT</button>
    
  			</div>
		</div> -->


	    <div class="textalign" style="margin-left: 639px;margin-bottom: 29px;">
   			 <label>
       		 <input type="radio" checked name="customertype" id="customertype" checked="checked" onclick="openCashCustomerBilling()"> 
         <div  class="btn1 btn-sık" ><span>In</span></div>
          </label>
         
    	 <label class="col-md-offset-1">

        <input  type="radio" name="customertype" id="customertype" onclick="openCreditCustomerBilling()"> 
       	<div class="btn1 btn-sık"><span>Out</span></div></label>
       </div>

		<!------------------------ For In Time ------------------------------>
		
		<div id="billingAmount">   		
		
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Visitor Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> 
							<input type="text" id='visitorName' name="visitorName"  onkeypress="return isAlphabetsWithSpace(event)"
								class="form-control textInput" placeholder="Enter Visitor Name"  />
								<div id="name_error" class="val_error"></div>
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Contact No:<sub>*</sub></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='contactNo' name="contactNo" maxlength="10" 
								class="form-control" placeholder="Enter Contact No">
						</div>
					</div>
				</div>
			</div>
			
						
			<%
			/* 	Calendar cal = Calendar.getInstance();
				Date currentTime = cal.getTime();
				
				Date d = new Date(); 
				Long t = d.getTime();	 
				
				Calendar cal = Calendar. getInstance();
				Date date = cal.getTime();
				DateFormat dateFormat = new SimpleDateFormat("K:mm:ss aa");
				String formattedDate = dateFormat.format(date);
				*/
			%>

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Vehicle No:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='vehicalNo' name="vehicalNo"	class="form-control" placeholder="Enter Vehical No">
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">In Time:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-time"></i>
							</span> <input type="text" id='inTime' name="inTime" readonly="readonly" class="form-control">
						</div>
					</div>
				</div>
			</div>			
		 	
		 <div class="row">
				<div class="form-group">
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
							
							 <!-- <input type="text" id='firstName' name="firstName" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter Name"/> -->
						</div>
					</div>


					<div class="col-sm-2" align="right">
						<label class="control-label">Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span>
							 <input type="date" id='todayDate' name="todayDate" value=<%=todayDate %> class="form-control" readonly="readonly">
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2  col-sm-offset-1" align="right">
						<label class="control-label">Wing Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> <input type="text" id='wingName' name="wingName" readonly="readonly"
								class="form-control" placeholder="Enter Wing Name">
						</div>
					</div>
				
					<div class="col-sm-2" align="right">
						<label class="control-label">Building Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> 
							<input type="text" id='buildingName' name="buildingName" readonly="readonly"
								class="form-control textInput" placeholder="Enter Building Name"  />
								<div id="name_error" class="val_error"></div>
						</div>
					</div>
				</div>
			</div>			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Floor No:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='floorNo' name="floorNo" readonly="readonly"
								class="form-control textInput" placeholder="Enter Floor No"  />
								<div id="name_error" class="val_error"></div>
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Flat No:<sub>*</sub></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='flatNo' name="flatNo" readonly="readonly"
								class="form-control" placeholder="Enter Flat No">
						</div>
					</div>
				</div>
			 </div>
			
			<div class="row">
				<div class="form-group">

			<!--
				<div class="col-sm-2" align="right">
						<label class="control-label">Out Time:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-time"></i>
							</span>
							 <input type="time" id='outTime' name="outTime" class="form-control">
						</div>
					</div>
			-->
				</div>
			</div>
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Reason:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
							<!--  <input type="time" id='vehicalNo' name="vehicalNo" class="form-control" placeholder="Enter Vehical No"> -->
							
							<textarea id="reason" name="reason" placeholder="Enter reason" rows="2" cols="15" class="form-control"></textarea>
							
						</div>
					</div>

				</div>
			 </div>
	
			<div class="row">
				<div class="form-group">

				</div>
			</div>

			<div class="container" align="center">
				<input type="button"  class="btn btn-success btn-lg btnn" value="Save" name="btn" onclick="validationddVisitorsDetails()"> 
				<input type="button"  class="btn btn-danger btn-lg btnn" value="Cancel" onclick="reset()">
		  		<input type="button"  value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="visotorList()"> 
			
			<!-- 	<input type="button"  value="Edit" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="edit()"> -->
			</div>
			</div>
			
	<!---------------------------  For out time ------------------------>
			
	<div id="maintenanceAmount">  
	
	<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Visitor Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> 
							
							 <%
							 	VisitorsDetailsDao sdd3 = new VisitorsDetailsDao();
								List sList4 = sdd3.getVisitorName();
							 %>
							 	<input list="visitorNameList" id="fk_visitor_id" class="form-control" onchange="getVisitorDetails()">
								<datalist id="visitorNameList">
								 <%
										for (int i = 0; i < sList4.size(); i++) 
										{
											VisitorsDetailsHibernate sup = (VisitorsDetailsHibernate) sList4.get(i);
								 %>

									<option data-value="<%=sup.getPkVisitorId() %>"
									value="<%=sup.getVisitorName()%>">
									
									<%
										}
									%>
								</datalist>
							
							
							<!-- <input type="text" id='visitorName' name="visitorName" onkeypress="return isAlphabetsWithSpace(event)"
								class="form-control textInput" placeholder="Enter Visitor Name"  />
								<div id="name_error" class="val_error"></div> -->
						</div>
					</div>

				</div>
			</div>  
	
	
	
	<div class="row">
				<div class="form-group">

					<div class="col-sm-2 col-sm-offset-1"  align="right">
						<label class="control-label">Contact No:<sub>*</sub></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='contactNo2' name="contactNo2" maxlength="10" readonly="readonly"
								class="form-control" placeholder="Contact No">
						</div>
					</div>
					
					
					<div class="col-sm-2" align="right">
						<label class="control-label">Vehicle No:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='vehicalNo2' name="vehicalNo2" readonly="readonly" class="form-control" placeholder="Vehical No">
						</div>
					</div>
				</div>
			</div>
	
	
			<div class="row">
				<div class="form-group">
				
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Building Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> 
							<input type="text" id='buildingName2' name="buildingName2" readonly="readonly"
								class="form-control textInput" placeholder="Building Name"  />
								<div id="name_error" class="val_error"></div>
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">Wing Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> <input type="text" id='wingName2' name="wingName2" readonly="readonly"
								class="form-control" placeholder="Wing Name">
						</div>
					</div>
				</div>
			</div>	
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Floor No:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='floorNo2' name="floorNo2" readonly="readonly"
								class="form-control textInput" placeholder="Floor No"  />
								<div id="name_error" class="val_error"></div>
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Flat No:<sub>*</sub></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='flatNo2' name="flatNo2" readonly="readonly"
								class="form-control" placeholder="Flat No">
						</div>
					</div>
				</div>
			</div>
	
	  		<div class="row">
				<div class="form-group">
				
					<div class="col-sm-2  col-sm-offset-1" align="right">
						<label class="control-label">Member Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id='memName' name="memName" readonly="readonly"
								class="form-control" placeholder="Member Name">
						</div>
					</div>
		
						<div class="col-sm-2" align="right">
						<label class="control-label">Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span>
							 <input type="date" id='todayDate2' readonly="readonly" name="todayDate2" <%-- value="<%=todayDate %>" --%> class="form-control">
						</div>
					</div>
				</div>
			</div>	
			
		 <%
			/* 	Calendar cal = Calendar.getInstance();
				Date currentTime = cal.getTime();
				
				Date d = new Date(); 
				Long t = d.getTime();	 
				
				Calendar cal2 = Calendar. getInstance();
				Date date2 = cal.getTime();
				DateFormat dateFormat2 = new SimpleDateFormat("K:mm:ss aa");
				String formattedDate2 = dateFormat.format(date2);
			*/	
		  %>

			
			
			
			<div class="row">
				<div class="form-group">
				
				  <div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">In Time:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-time"></i>
							</span> 
							<input type="text" id='inTime2' name="inTime2" readonly="readonly" class="form-control" placeholder="In Time">
						</div>
					</div>
					
					
				   <div class="col-sm-2" align="right">
						<label class="control-label">Out Time:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-time"></i>
							</span> <input type="text" id='outTime2' readonly="readonly" name="outTime2" class="form-control">
						</div>
					</div>
					
				</div>
			</div>

			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Reason:<sup>*</sup></label>
					</div>
					<div class="col-sm-8">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
							<!--  <input type="time" id='vehicalNo' name="vehicalNo"	class="form-control" placeholder="Enter Vehical No"> -->
							
							<textarea id="reason2" name="reason2" readonly="readonly" placeholder="Enter reason" rows="2" cols="15" class="form-control"></textarea>
							
						</div>
					</div>

				</div>
			 </div>
			
	
			<div class="row">
				<div class="form-group">

				</div>
			</div>

			  

			<div class="container" align="center">
				<input type="button"  class="btn btn-success btn-lg btnn" value="Save" name="btn" onclick="validationdVisitorsOutDetails()"> 
				<input type="button"  class="btn btn-danger btn-lg btnn" value="Cancel" onclick="location.reload()">
			<!--  	<input type="button"  value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="memberList()"> -->
			
			<!-- 	<input type="button"  value="Edit" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="edit()"> -->
			
			</div>
			</div>
			
			
			
			  </div>
			
			
			
			
			
		</form>
		</div>
	</div>
</body>
</html>

<%@include file="commons/newFooter.jsp"%>
