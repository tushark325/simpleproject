<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.hibernate.EventDetailsHibernate"%>
<%@page import="com.society.dao.EventDetailsDao"%>
<%@page import="com.society.dao.EmployeeDetailsDao"%>
<%@page import="com.society.hibernate.ExpenditureDetailsBean"%>
<%@page import="com.society.dao.ExpenditureDetailsDao"%>
<%@page import="com.society.dao.VendorDetailsDao"%>
<%@page import="com.society.hibernate.VendorDetailsHibernate"%>
<%@page import="com.society.dao.ClientEnquiryDao"%>
<%@page import="com.society.hibernate.ClientEnquiryHibernate"%>
<%@page import="com.society.hibernate.MemberBillingHibernate"%>
<%@page import="com.society.dao.MemberDetailsDao"%>
<%@page import="com.society.hibernate.MemberMonthlyContributionCostHibernate"%>
<%@page import="com.society.dao.MemberMonthlyContributionCostDao"%>
<%@page import="com.society.hibernate.AnnualMaintenceGenerationHibernate"%>
<%@page import="java.util.List"%>

<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/society/staticContent/css/tabDemo.css">
<script type="text/javascript" src="/society/staticContent/js/cashbankbook.js"></script>
<script src="/society/staticContent/js/event.js">
<!--

//-->
</script>

<script>

function eventListPage()
{
	window.location = "EventList.jsp";
	}
</script>
		<script>
			function memberMonthlyContributionbCostPaymentList()
			{
				 window.location = "memberMonthlyContributionCostPaymentList.jsp";
			}		
		</script>
		<script>
			function vendorPaymentListForAMC()
			{
				 window.location = "VendorPaymentListForAMC.jsp";
			}		
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
		    if ((charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122))) {
		        return false;
		    }
		    return true;
			}
		</script>
		<script type="text/javascript">
			function isAlphabetsWithSpace(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode!=32 && (charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122))) {
		        return false;
		    }
		    return true;
			}
		</script>
		
	
	<style>
		.leftmanu
		{
		    width: 190px;
		    background: #c50000a6;
		    color:  white;
		}
	</style>


<body onload="pageLoad();pageLoadV()">
<div class="container-fluid" > 
<div class="row" style="min-height:300px;">
    <div  class="col-md-12">
        <h3>Left Tabs</h3>
        <hr/>
        <div class="col-md-2">
            <!-- required for floating -->
            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
              <!--   <li class=""><a class="leftmanu" href="#messages" data-toggle="tab" >Add Event</a></li>
                 <li><a class="leftmanu" href="#vendor" data-toggle="tab">List Events</a></li> -->
                 
                 
<!--                  <li><a class="leftmanu" href="#client" data-toggle="tab">Client Payment</a></li>
 -->             <!--    <li><a class="leftmanu" href="#settings" data-toggle="tab">Event Bill</a></li>
                 <li><a class="leftmanu" href="#member" data-toggle="tab">Member Payment</a></li>
                
                 -->
                
            </ul>
        </div>
        <div class="col-xs-9">
            <!-- Tab panes -->
    <div class="tab-content">
         
	<!------------ Add Event ---------->
	
            <div class="tab-pane active" id="messages">
           		<form class="form-horizontal" method="post" action="" name="emp">
   	    	 <div class="row">
			    <div align="center">
			  		 <h2 class="form-name style_heading">Event Contribution</h2> 
			  	</div>
		     <div class="row">
				     <div class="col-sm-offset-1 col-md-10">
						  		<hr style="border-top-color:#c1b1b1;">
				     </div>	
		   		 </div>
		    </div>
		    
    	     	 <div class="row form-group">
           				 <label class="col-md-2 control-label" for="addevent">Select Event <sup>*</sup></label> 
           				  
          				<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
										<i class="glyphicon glyphicon-user"></i>
									</span>
									
				  					
						 <%
							    EventDetailsDao sdd3 = new EventDetailsDao();
								List sList4 = sdd3.getEventList();
							 %> 
							    
							 	<input list="addeventlist" id="addevent" class="form-control" onchange="">
								<datalist id="addeventlist">
								
								  <%
										for (int i = 0; i < sList4.size(); i++) 
										{
											EventDetailsHibernate sup = (EventDetailsHibernate) sList4.get(i);
								 %>

									<option data-value="<%=sup.getPkEventId()%>"
									value="<%=sup.getEventName()%> ">
									
									<%
						  				}
									%>
								</datalist>     
							</div>
						</div>
						
            
           		 <label class="col-md-2 control-label" for="date">Contribution:<sup>*</sup></label>  
	          			<div class="col-md-3">
						 <div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
	           		 	 <input id="contribution" name="contribution" placeholder="Contribution" readonly="readonly" class="form-control input-md" type="number">
	           		 </div>
				</div>
			</div>
			
			
			<div class="row form-group">
           				 <label class="col-md-2 control-label" for="addevent">Select Wing <sup>*</sup></label> 
           				  
          				<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
										<i class="glyphicon glyphicon-user"></i>
									</span>
									
				  					
						 <%  
							    MemberDetailsDao sdd4 = new MemberDetailsDao();
								List sList5 = sdd4.getAllMemberList();
							 %> 
							    
							 	
								 
								 <input list="memeberNameList" id="fk_member_id" class="form-control" onchange="getDetailsOfMwmber()" onfocus="this.value=''">
							<datalist id="memeberNameList">
								  <%
										for (int i = 0; i < sList5.size(); i++) 
										{
											MemberDetailsHibernate sup = (MemberDetailsHibernate) sList5.get(i);
								 %>

									<option data-value="<%=sup.getPkMemId()%>"
									value="<%=sup.getWingName()%> ">
									
									<% 
						  				}
									%>
								</datalist>     
							</div>
						</div>
						
						
						<div class="row form-group">
           				 <label class="col-md-2 control-label" for="addevent">Select Wing Member <sup>*</sup></label> 
           				  
          				<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
										<i class="glyphicon glyphicon-user"></i>
									</span>
									
				  					
						 <%
						 MemberDetailsDao sdd5 = new MemberDetailsDao();
							List sList6 = sdd5.getAllMemberList();
							 %> 
							    
							 	<input list="memeberNameList" id="fk_member_id" class="form-control" onchange="getDetailsOfMwmber()" onfocus="this.value=''">
							<datalist id="memeberNameList">
								<%
									for (int i = 0; i < sList6.size(); i++) {
										MemberDetailsHibernate sup = (MemberDetailsHibernate) sList6.get(i);
								%>

								<option data-value="<%=sup.getPkMemId() %>"
								value="<%=sup.getFirstName()%> <%=sup.getLastName()%> <%=sup.getContactNo()%>">

									<%
										}
									%>
								
							</datalist>
							
							</div>
						</div>
			
		 
		 
			<%-- 
         	  	<div class="row form-group">
					<label class="col-md-2 control-label" for="reason2">Month:<sup>*</sup></label>  
	          			<div class="col-md-3">
							<div class="input-group">
								<span class="input-group-addon">
								 <i class="glyphicon glyphicon-calendar"></i>
								</span>
	           		 			<select class="form-control" id="month">
	           		 			
	           		 				<option selected="selected" value="">--Select Month--</option>
	           		 				<option value="january">January</option>
	           		 				<option value="february">February</option>
	           		 				<option value="march">March</option>
	           		 				<option value="april">April</option>
	           		 				<option value="may">May</option>
	           		 				<option value="june">June</option>
	           		 				<option value="july">July</option>
	           		 				<option value="august">August</option>
	           		 				<option value="september">September</option>
	           		 				<option value="october">October</option>
	           		 				<option value="november">November</option>
	           		 				<option value="december">December</option>
	           		 			
	           		 			
	           		 			</select>
	           		       </div>
				      </div>
								
					<label class="col-md-2 control-label" for="paymentMode"> Payment Mode<sup>*</sup></label>  
	           		       <div class="col-md-3">
							<div class="input-group">
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-hand-right"></i>
										<!-- <i class="fa fa-rupee" style="font-size:18px"></i> -->
								</span>
	           					<select class="form-control" id="paymentMode2">
	           							<option value="" selected="selected">--Select Mode--</option>
										<option value="cash">Cash</option>
										<option value="cheque">Cheque</option>
										<option value="card">Card</option>
										<option value="neft">NEFT</option>
								</select>	
	           				</div>
						</div>
			 	</div>
	 <script>
		$(document).ready(function(){
	  		 $("#paymentMode2").change(function(){
	       	$(this).find("option:selected").each(function(){
		       	
	           	if($(this).attr("value")=="cheque"){
	           	$("#cheque_no2").show(); 
	           	$("#neft_acc_no2").hide(); 
	           	$("#card_no2").hide();
	           	}
	          	 else if($(this).attr("value")=="card"){
	          		$("#card_no2").show(); 	
	          		$("#neft_acc_no2").hide(); 
	        		$("#cheque_no2").hide();
	           }
	          	 else if($(this).attr("value")=="neft"){
	           		$("#neft_acc_no2").show(); 	
	           		$("#card_no2").hide(); 
	        		$("#cheque_no2").hide();
	            }
	          	 else if($(this).attr("value")=="cash"){
	            		$("#neft_acc_no2").hide(); 
	            		$("#cheque_no2").hide();
	            		$("#card_no2").hide(); 
	             }
	        	 else if($(this).attr("value")==""){
	            		$("#neft_acc_no2").hide(); 
	            		$("#cheque_no2").hide();
	            		$("#card_no2").hide(); 
	             }
	       });
	   }).change();
		});	
		</script>
		<div class="row form-group">
				  <label class="col-md-2 control-label" for="paymentMode">Payment Type:</label>  
	           		<div class="col-md-3">
							<div class="input-group">
								<span class="input-group-addon">
										<i class="glyphicon glyphicon-hand-right"></i>
								</span>
	           					<select class="form-control" id="paymentType2">
										<option value="credit" selected="selected">Credit</option>
										<option value="debit">Debit</option>
										
								</select>	
	           				</div>
						</div>
						
				  <div class="col-sm-2" align="right">
						<label class="control-label">Amount:<sup>*</sup></label>
						</div>
						   <div class="col-sm-3">
						   <div class="input-group">
							 <span class="input-group-addon">
							  <i class="fa fa-rupee" style="font-size:18px; width: 27px"></i>
							
								</span>
           					 <input  id="empPay" name="empPay" class="form-control" onkeypress="return isNumber(event)" placeholder="Enter Amount">
           				  </div>
						</div>
			     </div>
			         --%>
			     
			   
				      
				      <%-- 
				      
				      	<div id="cheque_no2" >
				      	
				      	<div class="col-md-3 col-md-offset-2 first" style="padding-bottom: 15px;">	
					 <input class="form-control" type="text" name="nameOnCheck" id="nameOnCheck2" placeholder="Name On check" />  
						</div>
						
						
					<div class="col-md-3 col-md-offset-7 first">	
						<input class="form-control" type="text" name="chequeNum" id="chequeNum2" placeholder="Cheque No." />  
					</div>
					
				</div>
				      
				      <div id="card_no2" class="form-group">
							<div class="col-md-3 col-md-offset-2 first">	
								<input class="form-control" type="text" name="cardNum" id="cardNum2" placeholder="Card No." />  
							</div>
						</div>
						
						
							<div id="neft_acc_no2" class="form-group">
							<div class="col-md-3 col-md-offset-2 first" style="padding-bottom: 15px;">	
								<input class="form-control" type="text" name="bankName" id="bankName2" placeholder="Name Of Bank" />  
							</div>
							
							<div class="col-md-3 col-md-offset-7 first">	
								<input class="form-control" type="text" name="accNum" id="accNum2" placeholder="Account No." />  
							</div>
						</div>
						
						--%>
					
			 	</div>
			     
			      				  
          	<div class="row form-group" >
            	
			</div>
								
        <div class="row form-group ">
           <div class="col-md-10 text-center">
            <input type="button" id="btn3" name="btn3" class="btn btn-success btn-lg btnn" onclick="eventMemberValidation()" value="Save">
		    <input type="reset" id="btn3" class="btn btn-danger btn-lg btnn" name="btn2" value="Cancel">
			<input type="button"  value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="eventListPage()">
          </div>
        </div>    
         </form>    	    
 </div>
 
<%--  	<%-- <!--------------- List Event ----------------->
 	
 	
  <div class="tab-pane" id="vendor">
		<form method="post" action="" name="exp">
			<div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">List Event</h2>
			  	</div>
		     <div class="row" >
				     <div class="col-sm-offset-1 col-md-10">
						  		<hr style="border-top-color:#c1b1b1;">
				     </div>	
		   		 </div>
		    </div>
		    
		    
		    
		    
<script type="text/javascript">
function pageLoadV(){
	$("#poAmount").show();
	$("#amcAmount").hide(); 
}
function openVendorBilling() {
	$("#poAmount").show();
	$("#amcAmount").hide();
}
function openVendorAMC() {
	$("#amcAmount").show();
	$("#poAmount").hide();
}
</script>			    
		    
		    
    	<div class="textalign" style="margin-left: 201px;margin-bottom: 29px;">
  			 <label class="col-md-offset-1">
	       		 <input type="radio" checked name="customertype" id="customertype" checked="checked" onclick="openVendorBilling()">PO Amount</input> 
    	      </label>
    		  <label class="col-md-offset-2">
        		 <input  type="radio" name="customertype" id="customertype"	onclick="openVendorAMC()">AMC Amount</input>
        	  </label>
       	<!-- <div class="btn1 btn-sık "><span>AMC Amount</span></div></label> -->
       </div>
		    

 
 

 --%>
 
  
  
 

        <%@include file="commons/newFooter.jsp" %> 	
</div>
</body>
</html>			