<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.hibernate.EmployeeDetailsHibernate"%>
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
		<script>
			function employeePaymentList()
			{
				 window.location = "EmployeePaymentList.jsp";
			}		
		</script>
		<script>
			function vendorPaymentList()
			{
				 window.location = "VendorPaymentList.jsp";
			}		
		</script>
		<script>
			function ClientPaymentList()
			{
				 window.location = "ClientPaymentList.jsp";
			}		
		</script>
		<script>
			function expenditurePaymentList()
			{
				window.location = "ExpendirurePaymentList.jsp";
			}
		</script>
		<script>
			function memberPaymentList()
			{
				window.location = "MemberPaymentList.jsp";
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
			  		<h2 class="form-name style_heading">Add Event/Function</h2>
			  	</div>
		     <div class="row">
				     <div class="col-sm-offset-1 col-md-10">
						  		<hr style="border-top-color:#c1b1b1;">
				     </div>	
		   		 </div>
		    </div>
		    
    	     	 <div class="row form-group">
           				 <label class="col-md-2 control-label" for="addevent">Event Name<sup>*</sup></label> 
           				  
          				<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
										<i class="glyphicon glyphicon-user"></i>
									</span>
									
				 <%-- 					
						 <%
							    EmployeeDetailsDao sdd3 = new EmployeeDetailsDao();
								List sList4 = sdd3.getAllMainEmployeeForLeave();
							 %> 
							    --%>
							 	<input list="addeventlist" id="addevent" class="form-control" onfocus="this.value=''">
								<datalist id="addeventlist">
								
								<%--  <%
										for (int i = 0; i < sList4.size(); i++) 
										{
											EmployeeDetailsHibernate sup = (EmployeeDetailsHibernate) sList4.get(i);
								 %>

									<option data-value="<%=sup.getPkEmpId()%>"
									value="<%=sup.getFirstName()%>  <%=sup.getLastName()%>">
									
									<%
						  				}
									%>
								</datalist>    --%> 
							</div>
						</div>
						
            
           		 <label class="col-md-2 control-label" for="date">Date:<sup>*</sup></label>  
	          			<div class="col-md-3">
						 <div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
	           		 	 <input id="date" name="date" placeholder="Enter Date" class="form-control input-md" type="date">
	           		 </div>
				</div>
			</div>
			
			
			
			
			 <label class="col-md-2 control-label" for="date">Contribution:<sup>*</sup></label>  
	          			<div class="col-md-3">
						 <div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
	           		 	 <input id="contribution" name="contribution" placeholder="Enter Contribution" class="form-control input-md" type="number">
	           		 </div>
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
			     
			     
			   <div class="row form-group">
					<label class="col-md-2 control-label" for="description">Description:</label>  
	          			<div class="col-md-3">
							<div class="input-group">
								<span class="input-group-addon">
								 <i class="glyphicon glyphicon-hand-right"></i>
								</span>
	           		 	 <input id="descrip" name="description" placeholder="Description" class="form-control input-md" type="text">
	           		       </div>
				      </div>
				      
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
            <input type="button" id="btn3" name="btn3" class="btn btn-success btn-lg btnn" onclick="validationEvent()" value="Submit">
		    <input type="reset" id="btn3" class="btn btn-danger btn-lg btnn" name="btn2" value="Cancel">
			<input type="button"  value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="eventListPage()">
          </div>
        </div>    
         </form>    	    
 </div>
 
 	<%-- <!--------------- List Event ----------------->
 	
 	
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
		    
		    
		 <!-- Vendor Amount of PO  -->
		    
		<div id="poAmount">    
		<div class="row form-group">
           	<label class="col-md-2 control-label" for="employeename">Vendor Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<%
								VendorDetailsDao sdd4 = new VendorDetailsDao();
								List sList5 = sdd4.getAllVendorNames();
							%>
							<input list="vendorNameList" id="fk_vendor_id" class="form-control" onchange="getTotalAndBalanceAmountVendorId()">
							<datalist id="vendorNameList">
							<%
								for (int i = 0; i < sList5.size(); i++) {
								VendorDetailsHibernate sup = (VendorDetailsHibernate) sList5.get(i);
							%>
								<option data-value="<%=sup.getPkVendorDetailsId()%>"
								value="<%=sup.getFirstName()%> <%=sup.getLastName()%> <%=sup.getContactNo()%>">
							<%
								}
							%>
							</datalist>
						</div>
					</div>
					<div>
           	 	<label class="col-md-2 control-label" for="serviceProvider">Total Amount:</label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px; width: 27px"></i>
							
								</span>
             				<input id="totalAmount" name="totalAmount" readonly="readonly" placeholder="Total Amount" class="form-control input-md" type="text" >	
           				 </div>
					</div>
			</div>
			</div>
			
		<!-- 	<div class="row form-group">
					<label class="col-md-2 control-label" for="contactNumber">Bill No:<sup>*</sup></label>  
      			<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>

							<input list="billList_Drop" id="billNo" class="form-control" onchange="getTotalByBillNo()">
							<datalist id="billList_Drop"></datalist>

							
						</div>
					</div>
					
				<label class="col-md-2 control-label" for="expCredit">Bill Amount:<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="billAmount" readonly="readonly" name="billAmount" placeholder="Bill Amount" class="form-control input-md" type="text"  >
             					 
           				 </div>
					</div>
			</div>
				 -->
				 <div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<div class="input-group">
							
							
	           			</div>
					</div>
			
				<label class="col-md-2 control-label" for="expDebit">Balance Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="balanceAmount" name="balanceAmount" placeholder="Balance Amount" readonly="readonly" class="form-control input-md" type="text">
           				 </div>
					</div>
			
			</div>	
			
			
			<div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<div class="input-group">
							
							
	           			</div>
					</div>
			
				<label class="col-md-2 control-label" for="expDebit">Paid Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="paidAmount" name="paidAmount" placeholder="Paid Amount" onkeypress="return isNumber(event)" class="form-control input-md" type="text">
           				 </div>
					</div>
			</div>	
			
			
					<div class="row form-group">
           	<label class="col-md-2 control-label" for="employeename">Description:
					</label>
					<div class="col-md-8">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
							<textarea id="descriptionForPO" name="descriptionForPO" placeholder="Enter description" class="form-control" rows="3" cols="15"></textarea>
						</div>
					</div>
			</div>
				
		<div class="form-group row">
            <div class="col-md-10 text-center">
            <input type="button" id="save" name="btn4" style="font-size: 25" class="btn btn-success btn-lg btnn "  onclick="vendorPaymentValidation(); return false;" value="Submit">
		    <input type="reset" id="btn2" style="font-size: 25" class="btn btn-danger btn-lg btnn" name="btn4" value="Cancel">
      		<input type="button" style="font-size:25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="vendorPaymentList()">
     
       <!--     <input type="button" font-size="25" value="List" id="listBtn" class="btn btn-primary btn-lg btn-large button-height-width" onclick="expenditurePaymentList()"> -->
            </div>
        </div> 
        </div>
       
          <!--------------------------------- Vendor Amount of AMC ------------------------------------>  
		    
		<div id="amcAmount">    
		<div class="row form-group">
           	<label class="col-md-2 control-label" for="employeename">Vendor Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<%
								VendorDetailsDao sdd42 = new VendorDetailsDao();
								List sList52 = sdd42.getAllVendorNamesForAMC();
							%>
							<input list="vendorNameListForAMC" id="fk_vendor_idForAMC" class="form-control" onchange="getTotalAndBalanceAmountVendorIdForAMC()">
							<datalist id="vendorNameListForAMC">
								<%
									for (int i = 0; i < sList52.size(); i++) {
										AnnualMaintenceGenerationHibernate sup = (AnnualMaintenceGenerationHibernate) sList52.get(i);
								%>
									<option data-value="<%=sup.getFkVendorId() %>"
									value="<%=sup.getVendorName()%> <%=sup.getContactNo()%>">
								<%
									}
								%>
								
							</datalist>
						</div>
					</div>
					<div>
           	 	<label class="col-md-2 control-label" for="serviceProvider">Total Amount:</label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px; width: 27px"></i>
							
								</span>
             				<input id="totalAmountForAMC" name="totalAmountForAMC" readonly="readonly" placeholder="Total Amount" class="form-control input-md" type="text" >	
           				 </div>
					</div>
			</div>
			</div>
			
		<!-- 	<div class="row form-group">
					<label class="col-md-2 control-label" for="contactNumber">Bill No:<sup>*</sup></label>  
      			<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>

							<input list="billList_Drop" id="billNo" class="form-control" onchange="getTotalByBillNo()">
							<datalist id="billList_Drop"></datalist>

							
						</div>
					</div>
					
				<label class="col-md-2 control-label" for="expCredit">Bill Amount:<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="billAmount" readonly="readonly" name="billAmount" placeholder="Bill Amount" class="form-control input-md" type="text"  >
             					 
           				 </div>
					</div>
			</div>
				 
			<div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<div class="input-group">
	           			</div>
					</div>
			
				<label class="col-md-2 control-label" for="expDebit">Balance Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="balanceAmountForAMC" name="balanceAmountForAMC" placeholder="Balance Amount" readonly="readonly" class="form-control input-md" type="text">
           				 </div>
					</div>
			</div>	
			<div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<div class="input-group">
							
							
	           			</div>
					</div>
				<label class="col-md-2 control-label" for="expDebit">Paid Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="paidAmountForAMC" name="paidAmountForAMC" placeholder="Paid Amount" onkeypress="return isNumber(event)" class="form-control input-md" type="text">
           				 </div>
					</div>
			</div>	
			<div class="row form-group">
           		<label class="col-md-2 control-label" for="employeename">Description:
					</label>
					<div class="col-md-8">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
								<textarea id="descriptionForAMC" name="descriptionForAMC" placeholder="Enter description" rows="3" cols="15" class="form-control"></textarea>
							</div>
					</div>

			</div>
			
				
		<div class="form-group row">
            <div class="col-md-10 text-center">
            <input type="button" id="save" name="btn4" style="font-size: 25" class="btn btn-success btn-lg btnn "  onclick="vendorPaymentForAMCValidation(); return false;" value="Submit">
		    <input type="button" id="btn2" style="font-size: 25" class="btn btn-danger btn-lg btnn" name="btn4" onclick="location.reload()" value="Cancel">
      		<input type="button" style="font-size:25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="vendorPaymentListForAMC()">
     
       <!--     <input type="button" font-size="25" value="List" id="listBtn" class="btn btn-primary btn-lg btn-large button-height-width" onclick="expenditurePaymentList()"> -->
            </div>
        </div> 
        </div>
        
      </form>
	</div>
 
 
 
 
 
 <!--------------- Client Payment ----------------->
 	
  <div class="tab-pane" id="client">
		<form method="post" action="" name="exp">
			<div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Client Payment</h2>
			  	</div>
		     <div class="row">
				     <div class="col-sm-offset-1 col-md-10">
						  		<hr style="border-top-color:#c1b1b1;">
				     </div>	
		   		 </div>
		    </div>
		    
		<div class="row form-group">
           	<label class="col-md-2 control-label" for="employeename">Client Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
			
							<%
								ClientEnquiryDao dao = new ClientEnquiryDao();
								List list = dao.getAllClientNames();
								
							%>
							
							<input list="clientNameList" id="fk_client_id" class="form-control" onchange="getTotalAmountByClientName()">
							<datalist id="clientNameList">
								<%
									for (int i = 0; i < list.size(); i++) {
										ClientEnquiryHibernate sup = (ClientEnquiryHibernate) list.get(i);
								%>

								<option data-value="<%=sup.getPkClientEnquiryId() %>"
								value="<%=sup.getFirstName()+" "+sup.getLastName()%>">

									<%
										}
									%>
								
							</datalist>
						</div>
					</div>
					
					<div>
           	 	<label class="col-md-2 control-label" for="serviceProvider">Total Amount</label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             				<input id="totalAmount2" name="totalAmount" readonly="readonly" placeholder="Total Amount" class="form-control input-md" type="text" >	
           				 </div>
					</div>
			</div>
			</div>
			
			<div class="row form-group">
					<label class="col-md-2 control-label" for="contactNumber">Bill No:<sup>*</sup></label>  
      			<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>

							<input list="billList_Drop2" id="billNo2" class="form-control" onchange="getTotalByBillForClient()">
							<datalist id="billList_Drop2"></datalist>

							
						</div>
					</div>
					
				<label class="col-md-2 control-label" for="expCredit">Bill Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="billAmount2" readonly="readonly" name="billAmount2" placeholder="Bill Amount" class="form-control input-md" type="text"  >
             					 
           				 </div>
					</div>
			</div>
				
			<div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<div class="input-group">
							
							
	           			</div>
					</div>
			
				<label class="col-md-2 control-label" for="expDebit">Balance Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="balanceAmount2" name="balanceAmount2" placeholder="Balance Amount" readonly="readonly" class="form-control input-md" type="text">
           				 </div>
					</div>
			</div>	
			
			
			<div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<div class="input-group">
							
							
	           			</div>
					</div>
			
				<label class="col-md-2 control-label" for="expDebit">Paid Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="paidAmount2" name="paidAmount2" placeholder="Paid Amount" onkeypress="return isNumber(event)" class="form-control input-md" type="text">
           				 </div>
					</div>
			</div>	
			
			
				
		<div class="form-group row">
            <div class="col-md-10 text-center">
            <input type="button" id="save" name="btn4" style="font-size: 25" class="btn btn-success btn-lg btnn "  onclick="clientPaymentValidation(); return false;" value="Submit">
		    <input type="reset" id="btn2" style="font-size: 25" class="btn btn-danger btn-lg btnn" name="btn4" value="Cancel">
		    <input type="button" style="font-size:25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="ClientPaymentList()">
       <!--     <input type="button" font-size="25" value="List" id="listBtn" class="btn btn-primary btn-lg btn-large button-height-width" onclick="expenditurePaymentList()"> -->
            </div>
        </div> 
     </form>
	</div>
 
  
  
  <!-----------------------------   Event Bill ------------------------>
       
    
     <div class="tab-pane" id="settings">
		<form method="post" action="" name="exp">
			<div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Event Bill</h2>
			  	</div>
				     <div class="row">
					     <div class="col-sm-offset-1 col-md-10">
						  		<hr style="border-top-color:#c1b1b1;">
					     </div>	
				   	</div>
		    </div>
		<div class="row form-group">
           	<label class="col-md-2 control-label" for="eventname">Select Event<sup>*</sup></label>  
        		 <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="	glyphicon glyphicon-hand-right"></i>
							</span>
							
							<%
								ExpenditureDetailsDao exdd = new ExpenditureDetailsDao();
	         					List exList =exdd.getAllExpenseName();
							%>
							
							<input list="exp_drop" id="expenseName" class="form-control" onchange="getSubExpenditureName()">
							<datalist id="exp_drop">
							
							<%
				           	     for(int i=0;i<exList.size();i++)
				           	     {
				        	   		ExpenditureDetailsBean expbean =(ExpenditureDetailsBean)exList.get(i);
							%>
							<option data-value="<%=expbean.getPkExpenseDetailsId()%>" value="<%=expbean.getExpenseName() %>">
							<%
				      			}
				    		%>
							</datalist>          	
						</div>
        		</div>
        		
           	 	<label class="col-md-2 control-label" for="wing">Select Wing<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-hand-right"></i>
							</span>
								<input list="subExp_drop" id="wingId" class="form-control">
								<datalist id="subExp_drop"></datalist>
           				 </div>
					</div>
			</div>			
			
			<div class="row form-group">
				<label class="col-md-2 control-label" for="contactNumber">Select Wing-Member<sup>*</sup></label>  
          			 <div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-hand-right"></i>
						</span>
            				<input id="serviceProvider" name="serviceProvider" placeholder="Wing-Member" class="form-control input-md" type="text" >	
          				 </div>
				</div>
				
				<label class="col-md-2 control-label" for="expCredit">Payment Mode</label>  
          			 <div class="col-md-3">
					<div class="input-group">
						 <span class="input-group-addon">
							<i class="glyphicon glyphicon-hand-right"></i>
						  </span>
            					 <input id="contactNumber" name="contactNumber" placeholder="Payment Mode" onkeypress="return isNumber(event)" maxlength="10" class="form-control input-md" type="text" >
          				 </div>
				</div>
			</div>
			
			
				<div class="row form-group">
					 <label class="col-md-2 control-label" for="contactNumber">Event Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							  <span class="input-group-addon">-
								<i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							  </span>
             					  <input type="text" id="expAmount" name="expAmount" placeholder="Amount" class="form-control input-md" >
           				 </div>
           				 
					</div>
					
					 <label class="col-md-2 control-label" for="expCredit">Member Name </label>  -
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							  </span>
	           		 			 <input id="accountantName" name="personName" placeholder="Member Name" class="form-control input-md" type="text">
           				 </div>
           				
					</div>
					
					

			</div>
			
			<div class="row form-group">
					 <label class="col-md-2 control-label" for="contactNumber">Description</label>  
           			 <div class="col-md-8">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-hand-right"></i>
							</span>
             					<textarea id="descriptionForExp" name="descriptionForExp" class="form-control" placeholder="Enter description" rows="3" cols="15"></textarea>
             			 </div>
					</div>

					

			</div>
			
				
		<div class="form-group row">
            <div class="col-md-10 text-center">
            <input type="button" id="save" name="btn4" style="font-size: 25" class="btn btn-success btn-lg btnn "  onclick="validationExpense(); return false;" value="Submit">
		    <input type="reset" id="btn2" style="font-size: 25" class="btn btn-danger btn-lg btnn" name="btn4" value="Cancel">
           <input type="button" font-size="25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="expenditurePaymentList()">
            </div>
        </div> 
     </form>
	</div>
	
	

	
 <!------------------------------------------ Member Billing Payment -------------------------------------->
 	
  <div class="tab-pane" id="member">
		<form method="post" action="" name="exp">
			<div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Member Payment</h2>
			  	</div>
		     <div class="row">
				     <div class="col-sm-offset-1 col-md-10">
						  		<hr style="border-top-color:#c1b1b1;">
				     </div>	
		   		 </div>
		    </div>
		    

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
		    
		    
		<div class="textalign" style="margin-left: 201px;margin-bottom: 29px;">
   			<label class="col-md-offset-1">
       		 <input type="radio" checked name="customertype" id="customertype" checked="checked" onclick="openCashCustomerBilling()">Billing</input> 
          </label>
    	 <label class="col-md-offset-3">
        	 <input type="radio" name="customertype" id="customertype" onclick="openCreditCustomerBilling()">Maintenance</input> 
        	 </label>
         </div>
		    
		<div id="billingAmount">    
		<div class="row form-group">
           	<label class="col-md-2 control-label" for="employeename">Member Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
			
							<%
								MemberDetailsDao sdd33 = new MemberDetailsDao();
								List sList44 = sdd33.getAllMemberBillForCashBook();
							%>
							<input list="memeberNameList" id="fk_member_id" class="form-control" onchange="getTotalAndBalanceAmountByMemberID()" onfocus="this.value=''">
							<datalist id="memeberNameList">
								<%
									for (int i = 0; i < sList44.size(); i++) {
										MemberBillingHibernate sup = (MemberBillingHibernate) sList44.get(i);
								%>

								<option data-value="<%=sup.getFkMemberId()%>"
								value="<%=sup.getMemberName()%> <%=sup.getContactNo()%>">

									<%
										}
									%>
								
							</datalist>
						</div>
					</div>
					
					<div>
           	 	<label class="col-md-2 control-label" for="serviceProvider">Total Amount</label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             				<input id="totalAmount222" name="totalAmount" readonly="readonly" placeholder="Total Amount" class="form-control input-md" type="text" >	
           				 </div>
					</div>
			</div>
			</div>
			
<!-- 			<div class="row form-group">
					<label class="col-md-2 control-label" for="contactNumber">Bill No:<sup>*</sup></label>  
      			<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>

							<input list="billList_Drop2" id="billNo2" class="form-control" onchange="getTotalByBillForClient()">
							<datalist id="billList_Drop2"></datalist>

							
						</div>
					</div>
					
				<label class="col-md-2 control-label" for="expCredit">Bill Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="billAmount2" readonly="readonly" name="billAmount2" placeholder="Bill Amount" class="form-control input-md" type="text"  >
             					 
           				 </div>
					</div>
			</div> -->
				
			<div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<div class="input-group">
			   			</div>
					</div>
			
				<label class="col-md-2 control-label" for="expDebit">Balance Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
								</span>
             					 <input id="balanceAmount222" name="balanceAmount22" placeholder="Balance Amount" readonly="readonly" class="form-control input-md" type="text">
           				 </div>
					</div>
			</div>	
			
			
			<div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<div class="input-group">
							<!-- <span class="input-group-addon">
								 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							</span>
             					<textarea id="description" placeholder="Enter description" name="description" class="form-control" rows="2" cols="15"></textarea>
							
	           			 --></div>
	           		 </div>
					<label class="col-md-2 control-label" for="expDebit">Paid Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="paidAmount22" name="paidAmount2" placeholder="Paid Amount" onkeypress="return isNumber(event)" class="form-control input-md" type="text">
           				 </div>
					</div>
			</div>	
				<div class="row form-group">
				 	<label class="col-md-2 control-label" for="personName">Description:</label>  
	          			 <div class="col-md-8">
							<div class="input-group">
								<span class="input-group-addon">
									 <i class="fa fa-hand-o-right" style="font-size:18px;width: 27px"></i>
								</span>
             						<textarea id="description" placeholder="Enter description" name="description" class="form-control" rows="2" cols="15"></textarea>
							</div>
						 </div>

					</div>
				
		<div class="form-group row">
            <div class="col-md-10 text-center">
	            <input type="button" id="save" name="btn4" style="font-size: 25;width: 128px;" class="btn btn-success btn-lg btnn" onclick="memberPaymentValidation(); return false;" value="Print / Email">
			    <input type="reset" id="btn2" style="font-size: 25" class="btn btn-danger btn-lg btnn" name="btn4" value="Cancel">
			    <input type="button" font-size="25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="memberPaymentList()">
            </div>
        </div>
        
        </div>
        
   <!---------------------------------- Member Maintenance Payment --------------------------------->
        
         <div id="maintenanceAmount">
         	<div class="row form-group">
           	<label class="col-md-2 control-label" for="employeename">Member Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
			
							<%
								MemberMonthlyContributionCostDao sdd22 = new MemberMonthlyContributionCostDao();
								List sList22 = sdd22.getAllMemberMaintenanceForCashBook();
							%>
							<input list="memMainNameList" id="fk_memberMain_id" class="form-control" onchange="getMonthAndAmount()" onfocus="this.value=''">
							<datalist id="memMainNameList">
								<%
										for (int i = 0; i < sList22.size(); i++) 
										{
											MemberDetailsHibernate sup = (MemberDetailsHibernate) sList22.get(i);
											/* System.out.println(sup.getPkMemContriCostId());
											System.out.println(sup.getFirstName());
											System.out.println(sup.getLastName());
											System.out.println(sup.getContactNo()); */
											System.out.println("sup.getPkMemId() ===> "+sup.getPkMemId());
								%>

										<option data-value="<%=sup.getPkMemId()%>" value="<%=sup.getFirstName()+" "+sup.getLastName()+" "+sup.getContactNo()%>">

									<%
										}
									%>
								
							</datalist>
						</div>
					</div>
					
			<div>
			    <label class="col-md-2 control-label" for="expDebit">Balance Amount<sup>*</sup></label> 
           	 	<!-- <label class="col-md-2 control-label" for="serviceProvider">Total Amount</label>   -->
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							 </span>
							  <input id="balanceAmountMem" name="balanceAmountMem" placeholder="Balance Amount" readonly="readonly" class="form-control input-md" type="text">
             				 <div hidden="true">
             				 	<input id="totalAmountMem" name="totalAmountMem" readonly="readonly" class="form-control input-md" type="text">
             				 </div>	
           			   </div>
					</div>
			</div>
			</div>
			
			<div class="row form-group">
					<label class="col-md-2 control-label" for="contactNumber">Month:<sup>*</sup></label>  
      			<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>

							<input list="monthList" id="month22" class="form-control" onchange="getAmountByAmount()" onfocus="this.value=''">
							<datalist id="monthList"></datalist>							
						</div>
					</div>
					
				<label class="col-md-2 control-label" for="expCredit">Month Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="monthAmount" readonly="readonly" name="monthAmount" placeholder="Month Amount" class="form-control input-md" type="text"  >
             			 </div>
					</div>
			</div>
				
			<div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<div class="input-group">
							
							
	           			</div>
					</div>
			
				<!-- <label class="col-md-2 control-label" for="expDebit">Balance Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							</span>
             					 <input id="balanceAmountMem" name="balanceAmountMem" placeholder="Balance Amount" readonly="readonly" class="form-control input-md" type="text">
           				 </div>
					</div> -->
			</div>	
			
			
			<div class="row form-group">
				 <label class="col-md-2 control-label" for="personName"></label>  
	          		 <div class="col-md-3">
						<!-- <div class="input-group">
							<span class="input-group-addon">
								 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							</span>
             					<textarea id="description" placeholder="Enter description" name="description" class="form-control" rows="2" cols="15"></textarea>
							
	           			</div> -->
	           			 
					 </div>
			
					<label class="col-md-2 control-label" for="expDebit">Paid Amount<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							 <span class="input-group-addon">
							 <i class="fa fa-rupee" style="font-size:18px;width: 27px"></i>
							
								</span>
             					 <input id="paidAmountMem" name="paidAmountMem" placeholder="Paid Amount" onkeypress="return isNumber(event)" class="form-control input-md" type="text">
           				 </div>
					</div>
			</div>	
			
			
				<div class="row form-group">
				 	<label class="col-md-2 control-label" for="personName">Description:</label>  
	          			 <div class="col-md-8">
							<div class="input-group">
								<span class="input-group-addon">
									 <i class="fa fa-hand-o-right" style="font-size:18px;width: 27px"></i>
								</span>
             						<textarea id="descriptionMem" placeholder="Enter description" name="descriptionMem" class="form-control" rows="2" cols="15"></textarea>
							</div>
						 </div>

					</div>
				 
			<div class="form-group row">
	            <div class="col-md-10 text-center">
		            <input type="button" id="save" name="btn4" style="font-size: 25;width: 128px;" class="btn btn-success btn-lg btnn " onclick="validationMemberMainPaymentDetails(); return false;" value="Print / Email">
				    <input type="reset" id="btn2" style="font-size: 25" class="btn btn-danger btn-lg btnn" name="btn4" value="Cancel">
				    <input type="button" font-size="25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="memberMonthlyContributionbCostPaymentList()">
	            </div>
	        </div>
	        
        </div>
     </form>
	</div>
 		</div>	
   </div>
  </div> 
 </div>
</div> --%>
        <%@include file="commons/newFooter.jsp" %> 	
</div>
</body>
</html>			