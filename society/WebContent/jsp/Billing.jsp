<%@page import="java.text.DateFormat"%>
<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.dao.MemberDetailsDao"%>
<%@page import="com.society.hibernate.ClientEnquiryHibernate" %>
<%@page import="com.society.dao.ClientEnquiryDao" %>
<%@page import="com.society.dao.MemberBillingDao" %>
<%@page import="com.society.bean.HrBillingBean" %>
<%@page import="com.society.dao.AssociationBillingDao" %>
<%@page import="com.society.bean.ProductBillingBean" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@page import="com.society.bean.AssociationBillingBean" %>



<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>

		<script type="text/javascript" src="/society/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/society/staticContent/css/shree.css">
		<link rel="stylesheet"href="/society/staticContent/css/jquery-ui.min.css">
		<link rel="stylesheet"href="/society/staticContent/css/ui.jqgrid.min.css">
		<link rel="stylesheet"href="/society/staticContent/y_css/jquery-ui.css">
		<link rel="stylesheet" href="/society/staticContent/css/ui.jqgrid.css">
		<script type="text/javascript"src="/society/staticContent/js/jquery.min.js"></script>
		<script type="text/javascript"src="/society/staticContent/js/jquery-ui-min.js"></script>
		<script type="text/javascript"src="/society/staticContent/js/jquery-ui.js"></script>
		<script type="text/javascript"src="/society/staticContent/js/jqueryUi.js"></script>
		<script type="text/javascript"src="/society/staticContent/js/jquery.jqgrid.min.js"></script>
				
	<style>
	.leftmanu{
	
    width: 190px;
    background: #c50000a6;
    color:  white;

	}
	</style>

 
<%
     	String pattern = "yyyy-MM-dd";
	  	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	  	String todayDate = simpleDateFormat.format(new Date());
	  	System.out.println(todayDate);
	%>
 
 
 	<!-- for Hr Billing -->
	<script>
		function clearHrCalculation()
		{
			document.hrBilling.gst.value="";
			document.hrBilling.vat.value="";
			document.hrBilling.grossTotal1.value="";
		}

	</script>
	
	 	<!-- for Hr Billing -->
	<script>
		function clearProductCalculation()
		{
			document.productForm.gst1.value="";
			document.productForm.vat1.value="";
			document.productForm.grossTotal2.value="";
		}

	</script>

	<script>
	function hrBillingList()
	{
		window.location="MemberBillingList.jsp";
	}

	</script>
	
	<script type="text/javascript">
	function associationBillingList()
	{
		window.location="AssociationBillingList.jsp";
	}
	
	</script>
	
	<script>
		function resets()
		{
			location.reload(true);
		}

	</script>

	<!-- <script>
		function clearField()
		{
			document.hrBilling.description.value="";
			document.productForm.description1.value="";
		}
	
	</script>
 -->	
	<script src="/society/staticContent/js/billing.js"></script>
	

<%
 if (session.getAttribute("user") != null) 
{ 
%>
<body>
<div class="container-fluid" > 
<div class="row" style="min-height:300px;">
    <div  class="col-md-12">
        <h3>Left Tabs</h3>
        <hr/>
        <div class="col-md-2">
            <ul class="nav nav-tabs">
                <li class=""><a class="leftmanu" href="#messages" data-toggle="tab">Member Billing</a></li>
                <li><a class="leftmanu" href="#settings" data-toggle="tab">Association Billing</a></li>
            </ul>
        </div>
				<div class="col-xs-9">
					<!-- Tab panes -->
					<div class="tab-content">

<%
		String Hr;
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		
		String d1 = dateobj.toString();
		
		String[] d = d1.split(" ");
	
		String year = d[5];
		String month = d[1];
		
		String HrBill = month+"/"+year+"/"+"1";
	
%>
<%
	MemberBillingDao hrDao = new MemberBillingDao();
	List bill = hrDao.getVendorBill();

	for(int i=0;i<bill.size();i++)
	{
		HrBillingBean bean = (HrBillingBean)bill.get(i);
	
		Hr = bean.getBill();
		String[] HrBil = Hr.split("/");
		
		String lNo = HrBil[2];
		
		int lstNo = Integer.parseInt(lNo);
		
		int LastNo = lstNo + 1;
		
		HrBill = month+"/"+year+"/"+LastNo;
	}
	 

%>

						<!------------ Member Billing ---------->
<div class="tab-pane active" id="messages">
  <form class="form-horizontal" method="post" action="" name="hrBilling">
   	    	 <div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Member Billing</h2>
			  	</div>
		     <div class="row">
				     <div class="col-sm-offset-1 col-md-10">
					 <hr style="border-top-color:#c1b1b1;">
		    </div>	
		   	</div>
		    </div>


		<div align="right" style="margin-right: 150px;" id="billno">
			<h3 style="color: red;font-family: digital-clock-font;">
				Bill No ::
				<%= HrBill%> 
			</h3>
		</div>
		
		<div class="row form-group">
		</div>
		<div class="row">
				<div class="row form-group">
					<label class="col-md-3 control-label" for="employeename">Member Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<%
								MemberDetailsDao sdd3 = new MemberDetailsDao();
								List sList4 = sdd3.getAllMember();
							%>
							<input list="memeberNameList" id="fk_member_id" class="form-control">
							<datalist id="memeberNameList">
								<%
									for (int i = 0; i < sList4.size(); i++) {
										MemberDetailsHibernate sup = (MemberDetailsHibernate) sList4.get(i);
								%>

								<option data-value="<%=sup.getPkMemId()%>"
								value="<%=sup.getFirstName()%> <%=sup.getLastName()%> <%=sup.getContactNo()%>">

									<%
										}
									%>
								
							</datalist>
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
							<input type="date" id='billingDate' name="billingDate" class="form-control" value="<%=todayDate%>" />
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
<!-- 					<div class="form-group">
					
						<div class="col-sm-2 col-sm-offset-1" align="right">
							<label class="control-label">Billing Period From:<sup>*</sup></label>
						</div>
						<div class="col-sm-3">
							<div class="input-group">
								<span class="input-group-addon"> 
								<i class="glyphicon glyphicon-calendar"></i>
								</span>
								<input type="date" id='billingPeriodFrom' name="billingPeriodFrom" class="form-control">
							</div>
						</div> -->

				<div class="row form-group">
					<label class="col-md-3 control-label" for="employeename">Description<sup>*</sup>
					</label>
						<div class="col-md-8">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-pencil "></i>
								</span>
								
								<!-- <textarea id='description' name="description" class="form-control" placeholder="Enter description" onchange="getHrBillingGrid();clearHrCalculation();clearField()" rows="2" cols="10"></textarea> -->
								<textarea rows="3" cols="40" id='description' class="form-control" placeholder="After Enter Description" onchange="getHrBillingGrid();clearHrCalculation();clearField()"></textarea>
								
								<!-- <input type="text" id='description' name="description" class="form-control" placeholder="enter description" onchange="getHrBillingGrid();clearHrCalculation();clearField()" /> -->
							</div>
						</div>

						
					</div>
				</div>
				
				  <div class="table-responsive	row col-md-offset-1" style="PADDING-TOP:  20PX;PADDING-BOTTOM: 15PX; margin-left: 255px;">
					
							<table id="jqgrid" ></table>
							<div id="jqGridPager" ></div>
		  		  </div> 
				
		<!-- 		
      
				 <div class="row form-group" >
					 <label class="col-md-2 col-md-offset-6 control-label"  for="hamaliExpence"><b>Sub Total:</b></label>  
			           	 <div class="col-sm-3">
							<div class="input-group">
								<span class="input-group-addon">
							 		<i class="fa fa-rupee" style="font-size:18px"></i>
							
								</span>
	              				<input id="subTotal" readonly="readonly" name="subTotal" placeholder="Sub Total" style=" width: 80;" class="form-control input-md" type="text">
	            			</div>
	            		</div>
					</div>
					
				<div  class="row form-group">
					<label class="col-md-2 col-md-offset-6 control-label"  for="hamaliExpence" ><b>GST:<sup>*</sup></b></label>  
			           	 <div class="col-sm-3">
							<div class="input-group" >
								<span class="input-group-addon">
									%
								</span>
	              				<input id="gst" name="gst" placeholder=" GST" class="form-control input-md" type="text" onchange="CalculateGstAmount()">
	            			</div>
	            		</div>
					
					</div>
					
					<div  class="row form-group">
					<label class="col-md-2 col-md-offset-6 control-label"  for="hamaliExpence" ><b>GST Amount:</b></label>  
			           	 <div class="col-sm-3">
							<div class="input-group" >
								<span class="input-group-addon">
									 <i class="fa fa-rupee" style="font-size:18px"></i>
							
								</span>
	              				<input id="vat"  readonly="readonly" name="Gst Amount" placeholder=" Gst Amount" class="form-control input-md" type="text">
	            			</div>
	            		</div>
					
					</div>
          	 
          	 -->
          		<div class="row form-group">
					<label class="col-md-offset-6 col-md-2 control-label"  for="grossTotal1"><h4><b>Gross Total:</b></h4></label>  
			           	 <div class="col-sm-3">
							<div class="input-group">
								<span class="input-group-addon">
							 		<i class="fa fa-rupee" style="font-size:18px"></i>
							
								</span>
	              				<input readonly="readonly" id="grossTotal1" name="grossTotal1" placeholder="Gross Total" class="form-control input-md"  type="text" style="font-size: 25px;  height: 55px;" >
	            			</div>
	            		</div>
            	</div>
    
       <div class="row form-group ">
           <div class="col-md-10 text-center">
            <input type="button" id="btn1" name="btn1" style="font-size: 25" class="btn btn-success btn-lg btnn "  onclick="addMemberBillValidation(); return false;" value="Print">
            <input type="reset" id="btn1" name="btn1" style="font-size: 25" class="btn btn-danger btn-lg btnn" onclick="resets()" value="Cancel">
         	<input type="button" font-size="25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="hrBillingList()">
           </div>
        </div>  
        </form>
  </div>



<%
	String pr;
	
		SimpleDateFormat dateFormat11 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj2 = new Date();
		
		String d11 = dateobj.toString();
		
		String[] d12 = d11.split(" ");
		
		String year2 = d12[5];
		String month2 = d12[1];

		 String productBill = month2+"/"+year2+"/"+"1"; 
		
	
	
%>
<%
	AssociationBillingDao proDao = new AssociationBillingDao();
	List billNo = proDao.getBillNo();

	for(int i=0;i<billNo.size();i++)
	{
		AssociationBillingBean bean2 = (AssociationBillingBean)billNo.get(i);
		pr = bean2.getBillNo();
		
		String[] prBill = pr.split("/");
		
		
		// 2 then 1 thrn 0
		String lNo = prBill[0];
		int lstNo = Integer.parseInt(prBill[2]);
		 
		//int lstNo = Integer.parseInt(lNo);
		int lastNo = lstNo + 1;
	
		 productBill = lNo+"/"+year2+"/"+lastNo; 
	   
	}
	

%>

         <!------------------ Association Billing ------------>
       <div class="tab-pane" id="settings">
		<form method="post" action="" name="productForm">
			<div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Association Billing</h2>
			  	</div>
		     <div class="row">
				     <div class="col-md-11">
						<hr style="border-top-color:#c1b1b1;">
				     </div>	
		   	</div>
		    </div>
		 
		 
		    
		<div align="right" style="margin-right: 150px;" id="billno">
		<h3 style="color: red;font-family: digital-clock-font;">
				Bill No ::
				 <%= productBill%>
			</h3>
		</div>
		<div class="row form-group">
		</div>
				
					
			 <div class="row form-group">
				<label class="col-md-2 control-label" for="employeename" style="text-align:  right;">Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							
							<input type="text" id="name" class="form-control" name="name" placeholder="Enter name"> 
			
							<%-- <%
								ClientEnquiryDao dao = new ClientEnquiryDao();
								List list = dao.getAllClientNames();
								
							%>
							
							<input list="clientNameList" id="fk_client_id" class="form-control">
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
								 
							</datalist>--%>
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
							<input type="date" id='billingDate1' name="billingDate1" class="form-control" value="<%=todayDate%>"/>
							</div>
						</div>
					</div>
					
						<div class="row">
					<div class="form-group">
						<div class="col-md-2" align="right">
							<label class="control-label">Description:<sup>*</sup></label>
						</div>
						<div class="col-md-8">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-pencil "></i>
								</span>
								<textarea id='description1' name="description" class="form-control" placeholder="Enter description" onchange="getProductBillingGrid();clearProductCalculation();clearField()" rows="3" cols="40"></textarea>
							
								<!-- <input type="text" id='description1' name="description" class="form-control" placeholder="enter description" onchange="getProductBillingGrid();clearProductCalculation();clearField()" /> -->
							</div>
						</div>


						
					</div>
				</div>
								
				  <div class="table-responsive	row col-md-offset-1" style="PADDING-TOP:  20PX;PADDING-BOTTOM: 15PX;margin-left: 180px;">
					
							<table id="productGrid" ></table>
							<div id="jqGridPager1"></div>
		  		  </div> 
					
 <!--
     <div class="row form-group" >
					 <label class="col-md-2 col-md-offset-6 control-label"><b>Sub Total:</b></label>  
			           	 <div class="col-sm-3">
							<div class="input-group">
								<span class="input-group-addon">
							 		<i class="fa fa-rupee" style="font-size:18px"></i>
							
								</span>
	              				<input id="subTotal1" name="subTotal1" readonly="readonly" placeholder="Sub Total" style=" width: 80;" class="form-control input-md" type="text">
	            			</div>
	            		</div>
					</div>
 					
				<div  class="row form-group">
					<label class="col-md-2 col-md-offset-6 control-label"  for="hamaliExpence" ><b>GST:<sup>*</sup></b></label>  
			           	 <div class="col-sm-3">
							<div class="input-group" >
								<span class="input-group-addon">
									%
								</span>
	              				<input id="gst1" name="gst1" placeholder="GST" class="form-control input-md" type="text" onchange="CalculateGstAmount1()">
	            			</div>
	            		</div>
					</div>
					
					<div  class="row form-group">
					<label class="col-md-2 col-md-offset-6 control-label"  for="hamaliExpence" ><b>GST Amount:</b></label>  
			           	 <div class="col-sm-3">
							<div class="input-group" >
								<span class="input-group-addon">
									 <i class="fa fa-rupee" style="font-size:18px"></i>
							
								</span>
	              				<input id="vat1" name="vat1" placeholder=" Gst Amount" readonly="readonly" class="form-control input-md" type="text">
	            			</div>
	            		</div>
					
					</div> -->
          	
          		<div class="row form-group">
					<label class="col-md-offset-6 col-md-2 control-label"  for="grossTotal1"><h4><b>Gross Total:</b></h4></label>  
			           	 <div class="col-sm-3">
							<div class="input-group">
								<span class="input-group-addon">
									 <i class="fa fa-rupee" style="font-size:18px"></i>
							
								</span>
	              				<input readonly="readonly" id="grossTotal2" name="grossTotal2" placeholder="Gross Total" class="form-control input-md"  type="text" style="font-size: 25px;  height: 55px;" >
	            			</div>
	            		</div>
            	</div>
    
	     <div class="row form-group " style="text-align: center;">
             <input type="button" id="btn2" name="btn2" style="font-size: 25" class="btn btn-success btn-lg btnn " onclick="associationBillingDetailsValidation(); return false;" value="Print">
		    <input type="reset" id="btn2" name="btn2" style="font-size: 25" class="btn btn-danger btn-lg btnn" onclick="resets()" value="Cancel"> 
        	 <input type="button" style="font-size:25" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="associationBillingList()">
        </div>
          
        </div>  
      </form>
		</div>
   </div>
  </div> 
 </div>
</div>
        <%@include file="commons/newFooter.jsp" %> 	
</div>
</body>

<%
}
%>
</html>		