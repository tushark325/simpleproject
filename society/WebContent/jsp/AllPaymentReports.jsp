<%@page import="com.society.hibernate.VendorPaymentDetailsHibernate"%>
<%@page import="com.society.dao.VendorPaymentDetailsDao"%>
<%@page import="com.society.hibernate.VendorPaymentDetailsForAMCHibernate"%>
<%@page import="com.society.dao.MemberBillingDao"%>
<%@page import="com.society.hibernate.MemberPaymentDetailsHibernate"%>
<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.hibernate.EmployeeDetailsHibernate"%>
<%@page import="com.society.dao.EmployeeDetailsDao"%>
<%@page import="com.society.hibernate.EmployeePaymentBeanHibernate"%>
<%@page import="com.society.hibernate.ExpenditureDetailsBean"%>
<%@page import="com.society.dao.ExpenditureDetailsDao"%>


<%
	boolean isHome = false;
%>
<%@include file="commons/header.jsp"%>

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
	<script type="text/javascript" src="/society/staticContent/js/cashbankbook.js"></script>		
	<style>
	
.left-tab-new
{
    width: 192px;
    background: #ba0707;
    color:  white;
    border-radius: 0px;

}
</style>
<body class="vColor">
<div class="row" style="min-height: 300px;">
	<div class="col-md-12">
		<h3>Left Tabs</h3>
		<hr />
		<div class="col-md-2">
			<ul class="nav nav-tabs tabs-left">
				<li class="active"><a href="#home" data-toggle="tab" class="left-tab-new">Vendor Payment Reports For PO</a></li>
				<li><a href="#AMC" data-toggle="tab" class="left-tab-new">Vendor Payment Reports For AMC</a></li>
				 <li><a href="#MemberBill" data-toggle="tab" class="left-tab-new">Member Payment Reports For Billing</a></li>
				<li><a href="#MemberAMC" data-toggle="tab" class="left-tab-new">Member Payment Reports For AMC</a></li>
				<li><a href="#Employee" data-toggle="tab" class="left-tab-new">Employee Payment Reports</a></li>
				<li><a href="#Expenditure" data-toggle="tab" class="left-tab-new">Expenditure Payment Reports</a></li>
			</ul>
		</div>
		<div class="col-xs-9">
			<!-- Tab panes -->
			<div class="tab-content">

		<!--++++++++++++++++++++++++++	Vendor Payment reports For PO ++++++++++++++++++++++++++++-->

				<div class="tab-pane active" id="home">
					<div class="row">
						<div align="center">
							<h2 class="form-name style_heading">Vendor Payment Reports For PO</h2>
						</div>
						<div class="row">
							<div class="col-sm-offset-1 col-md-10">
								<hr style="border-top-color: #c1b1b1;">
							</div>
						</div>
					</div>
					
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#vendorName"><h4 style="color: blue">Vendor Name Wise</h4></a></li>
							<li><a data-toggle="tab" href="#supplierSingleDate"><h4 style="color: blue">Range</h4></a></li>
					 	</ul>
					 	
					 	<div class="row">
							<div class="col-sm-offset-1 col-md-10">
								<hr style="border-top-color: #c1b1b1;">
							</div>
						</div>

					<div class="tab-content" style="float: left">

		<!------------------------------------- Vendor Name Wise ---------------------------->
						
					<div id="vendorName" class="tab-pane fade in active">
						<form class="form-horizontal">
								<div class="row">
									<div class="form-group">
										<div class="col-md-2 col-sm-offset-1" align="right">
											<label class="control-label" for="expenditureName">Vendor Name:</label>
										</div>
										<div class="col-md-3">
											<div class="input-group">
												<span class="input-group-addon">
												 <i class="glyphicon glyphicon-user"></i>
												</span>
													<%
													VendorPaymentDetailsDao exdd = new VendorPaymentDetailsDao();
														List vdList = exdd.getAllVendorame();
													%>
													<input list="ven_dropForPO" id="vendorNameForPO" class="form-control">
													<datalist id="ven_dropForPO">
														<%
															for (int i = 0; i < vdList.size(); i++) {
																VendorPaymentDetailsHibernate expbean = (VendorPaymentDetailsHibernate) vdList.get(i);
														%>
														<option data-value="<%=expbean.getFkVendorId() %>"
															value="<%=expbean.getVendorName()%> <%=expbean.getContactNo()%>">
															<%
																}
															%>
															</datalist>
														</div>
													</div>
												 </div>
												</div>
					            <div class="row">
									<div class="form-group">
									
										<div class="col-md-2 col-sm-offset-1" align="right">
													<label class="control-label">Start Date:</label>
														</div>
															<div class="col-sm-3">
																<div class="input-group">
																	<span class="input-group-addon"> <i
																		class="glyphicon glyphicon-calendar"></i>
																	</span> 
																	<input type="date" id="fisDate4" placeholder="Start Date" class="form-control input-md" type="text">
																</div>
															</div>
														<div class="col-md-2" align="right">
															<label class="control-label" for="endDate">End Date:</label>
															</div>
															<div class="col-sm-3">
																<div class="input-group">
																	<span class="input-group-addon"> <i
																		class="glyphicon glyphicon-calendar"></i>
																	</span> 
																	<input type="date" id="endDate4" placeholder="End Date" class="form-control input-md ac_district" type="text">
																</div>
															</div>
														</div>
														</div>
					      <div class="row form-group buttons_margin_top ">
								<div align="center">
									<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getVendorPaymentDetailsByName()" value="Search" />
								</div>
						  </div>
					
						<table class="table table-bordered table-striped table-condensed cf" id="vendorBetweenTwoDates" class="display" style="border: 2px solid black; border-collapse: collapse;">
								<thead>
									<tr>
									    <th>Sr No</th>
										<th>Vendor Name</th>
										<th>Total Amount</th>
						                <th>Balance Amount</th>
						                <th>Paid Amount</th>
										<th>Remaining Amount</th>
									 </tr>
								 </thead>
							</table>
					</form>
				</div>
				
	<!----------------------------- Range Wise For PO--------------------------------->
						
			<div id="supplierSingleDate" class="tab-pane">
				<form class="form-horizontal">
			       <div class="row">
					<div class="form-group">
				
							<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label">Start Date:</label>
							</div>
								<div class="col-sm-3">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-calendar"></i>
										</span> 
										<input type="date" id="fisDate42" placeholder="Start Date" class="form-control input-md" type="text">
									</div>
								</div>
					
									<div class="col-md-2" align="right">
									<label class="control-label" for="endDate">End Date:</label>
									</div>
									<div class="col-sm-3">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-calendar"></i>
											</span> 
											<input type="date" id="endDate42" placeholder="End Date" class="form-control input-md ac_district" type="text">
										</div>
									</div>
								</div>
							</div>
						      <div class="row form-group buttons_margin_top ">
									<div align="center">
										<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getVendorPaymentDetailsBetDays()" value="Search" />
									</div>
							  </div>
						
							<table class="table table-bordered table-striped table-condensed cf" id="vendorBetweenTwoDate" class="display" style="border: 2px solid black; border-collapse: collapse;">
								<thead>
										<tr>
										    <th>Sr No</th>
											<th>Vendor Name</th>
											<th>Total Amount</th>
							                <th>Balance Amount</th>
							                <th>Paid Amount</th>
											<th>Remaining Amount</th>
										</tr>
								</thead>
						
							</table>
							</form>
					</div>
				</div>
			</div>
				
				
	<!--+++++++++++++++++++++++++++   Vendor Payment Reports For AMC +++++++++++++++++++++++--->

			<div class="tab-pane" id="AMC">
				<div class="row">
					<div align="center">
						<h2 class="form-name style_heading">Vendor Payment Reports For AMC</h2>
					</div>
					<div class="row">
						<div class="col-sm-offset-1 col-md-10">
							<hr style="border-top-color: #c1b1b1;">
						</div>
					</div>
				</div>

					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#vendorNameWiseForAMC"><h4 style="color: blue">Vendor Name wise</h4></a></li>
						<li><a data-toggle="tab" href="#BetweenTwoDateForAMC"><h4 style="color: blue">Range</h4></a></li>
					</ul>

					<div class="tab-content" style="float: left">


			<!------------------------- 	Vendor Name wise For AMC---------------------->
						
			<div id="vendorNameWiseForAMC" class="tab-pane fade in active">
					<div class="row">
						<div class="col-sm-offset-1 col-md-10">
							<hr style="border-top-color: #c1b1b1;">
						</div>
					</div>
					<form class="form-horizontal">
						<div class="row">
							<div class="form-group">
								<div class="col-md-2 col-sm-offset-1" align="right">
											<label class="control-label" for="expenditureName">Vendor Name:</label>
											</div>
								<div class="col-md-3">
									<div class="input-group">
										<span class="input-group-addon">
										 <i class="glyphicon glyphicon-user"></i>
										</span>
											<%
												VendorPaymentDetailsDao exdd22 = new VendorPaymentDetailsDao();
												List vdList22 = exdd22.getAllVendorameForAMC();
											%>
												<input list="ven_dropForAMC" id="vendorNameForAMC" class="form-control">
												<datalist id="ven_dropForAMC">
											<%
												for (int i = 0; i < vdList22.size(); i++) {
													VendorPaymentDetailsForAMCHibernate expbean = (VendorPaymentDetailsForAMCHibernate) vdList22.get(i);
											%>
												<option data-value="<%=expbean.getFkVebdorId() %>"
													value="<%=expbean.getVendorName()%> <%=expbean.getContactNo()%>">
											<%
													}
											%>
													</datalist>
												</div>
											</div>
							   			  </div>
										</div>
			            <div class="row">
							<div class="form-group">
								<div class="col-md-2 col-sm-offset-1" align="right">
											<label class="control-label">Start Date:</label>
												</div>
													<div class="col-sm-3">
														<div class="input-group">
															<span class="input-group-addon"> <i
																class="glyphicon glyphicon-calendar"></i>
															</span> 
															<input type="date" id="fisDate4ForAMC" placeholder="Start Date" class="form-control input-md" type="text">
														</div>
													</div>
												<div class="col-md-2" align="right">
													<label class="control-label" for="endDate">End Date:</label>
													</div>
													<div class="col-sm-3">
														<div class="input-group">
															<span class="input-group-addon"> <i
																class="glyphicon glyphicon-calendar"></i>
															</span> 
															<input type="date" id="endDate4ForAMC" placeholder="End Date" class="form-control input-md ac_district" type="text">
														</div>
													</div>
												</div>
							</div>
							
							
			      <div class="row form-group buttons_margin_top ">
						<div align="center">
							<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getVendorPaymentDetailsForAMCByName()" value="Search" />
						</div>
				  </div>
				<table class="table table-bordered table-striped table-condensed cf" id="vendorBetweenTwoDatesForAMC" class="display" style="border: 2px solid black; border-collapse: collapse;">
								<thead>
									<tr>
									    <th>Sr No</th>
										<th>Vendor Name</th>
										<th>Total Amount</th>
						                <th>Balance Amount</th>
						                <th>Paid Amount</th>
										<th>Remaining Amount</th>
										<th>Description</th>
									 </tr>
								 </thead>
					</table>
			</form>
		</div>

			<!----------------------------------------- Date wise For AMC ----------------------------------->
						
			<div id="BetweenTwoDateForAMC" class="tab-pane">
					<div class="row">
					<div class="col-sm-offset-1 col-md-10">
						<hr style="border-top-color: #c1b1b1;">
					</div>
				</div>
						
				<form class="form-horizontal">
			       <div class="row">
					<div class="form-group">
				
							<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label">Start Date:</label>
							</div>
								<div class="col-sm-3">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-calendar"></i>
										</span> 
										<input type="date" id="fisDate42ForAMC" placeholder="Start Date" class="form-control input-md" type="text">
									</div>
								</div>
					
									<div class="col-md-2" align="right">
									<label class="control-label" for="endDateForAMC">End Date:</label>
									</div>
									<div class="col-sm-3">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-calendar"></i>
											</span> 
											<input type="date" id="endDate42ForAMC" placeholder="End Date" class="form-control input-md ac_district" type="text">
										</div>
									</div>
								</div>
							</div>
						      <div class="row form-group buttons_margin_top ">
									<div align="center">
										<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getVendorPaymentDetailsBetDaysForAMC()" value="Search" />
									</div>
							  </div>
						
							<table class="table table-bordered table-striped table-condensed cf" id="vendorBetweenTwoDateForAMC" class="display" style="border: 2px solid black; border-collapse: collapse;">
								<thead>
										<tr>
										    <th>Sr No</th>
											<th>Vendor Name</th>
											<th>Total Amount</th>
							                <th>Balance Amount</th>
							                <th>Paid Amount</th>
											<th>Remaining Amount</th>
											<th>Description</th>
										</tr>
									</thead>
						
							</table>
							</form>
					</div>

						 <!--    for single date -->
					<!--	<div id="customerSingleDate" class="tab-pane">
							<div class="row">
								<div class="col-sm-offset-1 col-md-10">
									<hr style="border-top-color: #c1b1b1;">
								</div>
							</div>
							<form class="form-horizontal" method="post" action=""
								name="custReport">
								<fieldset>
									<div class="row form-group">
										<label class="col-md-3 control-label" for=""> Enter
											Date:<sup>*</sup>
										</label>
										<div class="col-md-4">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-calendar"></i>
												</span> <input type="date" id="fDate1" placeholder="Start Date"
													class="form-control input-md" type="text">
											</div>
										</div>
										<div class="col-md-3">
											<div class="input-group">
												<input type="button" id="btn" name="save"
													class="btn btn-lg btn-success btn-md button_hw button_margin_right"
													onclick="creditCustReportForSingleDate()" value="Search" />
											</div>
										</div>
									</div>
									<div class="table-responsive">
										<table
											class="table table-bordered table-striped table-condensed cf"
											id="customerSingleDatetable" class="display"
											style="border: 2px solid black; border-collapse: collapse;">
											<thead>
												<tr>
													<th>Date</th>
													<th>Customer Name</th>
													<th>Bill Number</th>
													<th>Payment Type</th>
													<th>Payment Mode</th>
													<th>Total Amount</th>
													<th>Payment Amount</th>
													<th>Return Amount</th>
													<th>Balance Amount</th>
													<th>Description</th>
													<th>Account Number</th>
													<th>Bank Name</th>
												</tr>
											</thead>
											<tfoot>
												<tr>
													<th colspan="5" style="text-align: right">Total:</th>
													<th></th>
													<th></th>
													<th></th>
													<th></th>
													<th></th>
													<th></th>
												</tr>
											</tfoot>
										</table>
									</div>
								</fieldset>
							</form>
						</div>
 -->

					<!------ 	Between Two Dates  ----->
					<!-- 		<div id="customerBetweenTwoDate" class="tab-pane fade">
							<div class="row">
								<div class="col-sm-offset-1 col-md-10">
									<hr style="border-top-color: #c1b1b1;">
								</div>
							</div>

							<form class="form-horizontal" method="post" action=""
								name="custReport1">
								<fieldset>
									<div class="row form-group">
										<label class="col-md-2 control-label" for="startDate">
											Start Date:<sup>*</sup>
										</label>
										<div class="col-md-3">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-calendar"></i>
												</span> <input type="date" id="fisDate" placeholder="Start Date"
													class="form-control input-md" type="text">
											</div>
										</div>

										<label class="col-md-2 control-label" for="village">End
											Date:<sup>*</sup>
										</label>
										<div class="col-md-3">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-calendar"></i>
												</span> <input type="date" id="endDate" placeholder="End Date"
													class="form-control input-md ac_district" type="text">
											</div>
										</div>
									</div>

									<div class="row form-group buttons_margin_top ">
										<div align="center">
											<input type="button" id="btn" name="save"
												class="btn btn-lg btn-success btn-md button_hw button_margin_right"
												onclick="getCreditCustomerDetailsBetweenTwoDates()"
												value="Search" />
										</div>
									</div>
									<table
										class="table table-bordered table-striped table-condensed cf"
										id="customerBetweenTwoDates" class="display"
										style="border: 2px solid black; border-collapse: collapse;">
										<thead>
											<tr>
												<th>Date</th>
												<th>First Name</th>
												<th>Last Name</th>
												<th>Bill Number</th>
												<th>Payment Type</th>
												<th>Payment Mode</th>
												<th>Total Amount</th>
												<th>Payment Amount</th>
												<th>Return Amount</th>												
												<th>Balance Amount</th>
												<th>Description</th>
												<th>Account Number</th>
												<th>Bank Name</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th colspan="6" style="text-align: right">Total:</th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
											</tr>
										</tfoot>
									</table>
								</fieldset>
							</form>
						</div> -->
					</div>
				</div>




	<!-- ++++++++++++++++++++++++++++++++++	Employee Payment reports For Billing ++++++++++++++++++++++++++++++-->
	
	
				<div class="tab-pane" id="MemberBill">
					<div class="row">
						<div align="center">
							<h2 class="form-name style_heading">Member Payment Reports For Billing</h2>
						</div>
						<div class="row">
							<div class="col-sm-offset-1 col-md-10">
								<hr style="border-top-color: #c1b1b1;">
							</div>
						</div>
					</div>
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#memberNameWise"><h4 style="color: blue">Member Name Wise</h4></a></li>
						<li><a data-toggle="tab" href="#empBetweenTwoDate"><h4 style="color: blue">Range</h4></a></li>
					</ul>
					<div class="tab-content" style="float: left">


	<!------------------------------------- 	Member Name Wise  For Billing ------------------------------------>
					
				<div id="memberNameWise" class="tab-pane fade in active">
					<div class="row">
						<div class="col-sm-offset-1 col-md-10">
							<hr style="border-top-color: #c1b1b1;">
						</div>
					</div>
					<form class="form-horizontal" method="post" action="" name="empReport1">
						<fieldset>
						<div class="row">
							<div class="form-group">
								<div class="col-md-2 col-sm-offset-1" align="right">
											<label class="control-label" for="expenditureName">Member Name:</label>
											</div>
								<div class="col-md-3">
									<div class="input-group">
										<span class="input-group-addon">
										 <i class="glyphicon glyphicon-user"></i>
										</span>
											<%
												MemberBillingDao exdd222 = new MemberBillingDao();
												List vdList222 = exdd222.getAllMemberForBilling();
											%>
											<input list="mem_dropForBilling" id="memberNameForBilling" class="form-control">
											<datalist id="mem_dropForBilling">
											<%
												for (int i = 0; i < vdList222.size(); i++) {
													MemberPaymentDetailsHibernate expbean = (MemberPaymentDetailsHibernate) vdList222.get(i);
											%>
											<option data-value="<%=expbean.getFkMemberID() %>"
											value="<%=expbean.getMemberName()%> <%=expbean.getContactNo()%>">
											<%
													}
											%>
											</datalist>
										</div>
									</div>
							   	</div>
							</div>
							
			            <div class="row">
							<div class="form-group">
									<div class="col-md-2 col-sm-offset-1" align="right">
										<label class="control-label">Start Date:</label>
									</div>
										<div class="col-sm-3">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-calendar"></i>
												</span> 
												<input type="date" id="fisDateForBilling" placeholder="Start Date" class="form-control input-md" type="text">
											</div>
										</div>
										
										<div class="col-md-2" align="right">
											<label class="control-label" for="endDate">End Date:</label>
										</div>
										<div class="col-sm-3">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-calendar"></i>
												</span> 
												<input type="date" id="endDateForBilling" placeholder="End Date" class="form-control input-md ac_district" type="text">
											</div>
										</div>
								</div>
							</div>
							
								<div class="row form-group buttons_margin_top ">
									<div align="center">
										<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMemberPaymentDetailsForBillingByName()" value="Search" />
									</div>
								</div>

									<table
										class="table table-bordered table-striped table-condensed cf"
										id="memBetweenTwoDates" class="display"
										style="border: 2px solid black; border-collapse: collapse;">
										<thead>
											<tr>
												<th>Sr No</th>
												<th>Member Name</th>
												<th>Total Amount</th>
												<th>Balance Amount</th>
												<th>Paid Amount</th>
												<th>Remaining Amount</th>
												<th>Description</th>
											</tr>
										</thead>
						<!-- 				<tfoot>
											<tr>
												<th colspan="5" style="text-align: right">Total:</th>
												<th></th>
												<th></th>
												<th></th>
											</tr>
										</tfoot> -->
									</table>
								</fieldset>
							</form>
						</div>



	<!-----------------------------    Date Wise For Billing--------------------------->
						
			<div id="empBetweenTwoDate" class="tab-pane">
					<div class="row">
					<div class="col-sm-offset-1 col-md-10">
						<hr style="border-top-color: #c1b1b1;">
					</div>
				</div>
						
				<form class="form-horizontal">
			       <div class="row">
					<div class="form-group">
				
							<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label">Start Date:</label>
							</div>
								<div class="col-sm-3">
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-calendar"></i>
										</span> 
										<input type="date" id="fisDate2ForBilling" placeholder="Start Date" class="form-control input-md" type="text">
									</div>
								</div>
					
									<div class="col-md-2" align="right">
									<label class="control-label" for="endDateForAMC">End Date:</label>
									</div>
									<div class="col-sm-3">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-calendar"></i>
											</span> 
											<input type="date" id="endDate2ForBilling" placeholder="End Date" class="form-control input-md ac_district" type="text">
										</div>
									</div>
								</div>
							</div>
						      <div class="row form-group buttons_margin_top ">
									<div align="center">
										<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMemberPaymentDetailsForBillingByDates()" value="Search" />
									</div>
							  </div>
						
							<table class="table table-bordered table-striped table-condensed cf" id="memberBetweenTwoDateForBilling" class="display" style="border: 2px solid black; border-collapse: collapse;">
								<thead>
									<tr>
										<th>Sr No</th>
										<th>Member Name</th>
										<th>Total Amount</th>
										<th>Balance Amount</th>
										<th>Paid Amount</th>
										<th>Remaining Amount</th>
										<th>Description</th>
									</tr>
								</thead>
							</table>
						</form>
					</div>
					
					
				</div>
			</div>
				
				
				
	<!-- ++++++++++++++++++++++++++++++++++	Member Payment reports For AMC ++++++++++++++++++++++++++++++-->

				<div class="tab-pane" id="MemberAMC">
					<div class="row">
						<div align="center">
							<h2 class="form-name style_heading">Member Payment Reports For AMC</h2>
						</div>

						<div class="row">
							<div class="col-sm-offset-1 col-md-10">
								<hr style="border-top-color: #c1b1b1;">
							</div>
						</div>
					</div>

						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#memberNameWise2"><h4 style="color: blue">Member Name Wise</h4></a></li>
							<li><a data-toggle="tab" href="#memBetweenTwoDate2"><h4 style="color: blue">Range</h4></a></li>
						</ul>

					<div class="tab-content" style="float: left">
						
						
                         	<!-----------------------------    Member Name Wise For AMC  --------------------------->

				<div id="memberNameWise2" class="tab-pane fade in active">
					<div class="row">
						<div class="col-sm-offset-1 col-md-10">
							<hr style="border-top-color: #c1b1b1;">
						</div>
					</div>
					<form class="form-horizontal" method="post" action="" name="empReport1">
						<fieldset>
						<div class="row">
							<div class="form-group">
								<div class="col-md-2 col-sm-offset-1" align="right">
									<label class="control-label" for="expenditureName">Member Name:</label>
								</div>
								<div class="col-md-3">
									<div class="input-group">
										<span class="input-group-addon">
										 <i class="glyphicon glyphicon-user"></i>
										</span>
												<%
													MemberBillingDao exdd2223 = new MemberBillingDao();
													List vdList2223 = exdd2223.getAllMemberForAMC();
												%>
												<input list="mem_dropForAMC" id="memberNameForAMC" class="form-control">
												<datalist id="mem_dropForAMC">
												<%
													for (int i = 0; i < vdList2223.size(); i++) {
														MemberDetailsHibernate expbean = (MemberDetailsHibernate) vdList2223.get(i);
												%>
												<option data-value="<%=expbean.getPkMemId() %>"
												value="<%=expbean.getFirstName()%> <%=expbean.getLastName()%> <%=expbean.getContactNo()%>">
												<%
														}
												%>
												</datalist>
										</div>
									</div>
							   	</div>
							</div>
							
			            <div class="row">
							<div class="form-group">
									<div class="col-md-2 col-sm-offset-1" align="right">
										<label class="control-label">Start Date:</label>
									</div>
										<div class="col-sm-3">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-calendar"></i>
												</span> 
												<input type="date" id="fisDateForAMC" placeholder="Start Date" class="form-control input-md" type="text">
											</div>
										</div>
										
										<div class="col-md-2" align="right">
											<label class="control-label" for="endDate">End Date:</label>
										</div>
										<div class="col-sm-3">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-calendar"></i>
												</span> 
												<input type="date" id="endDateForAMC" placeholder="End Date" class="form-control input-md ac_district" type="text">
											</div>
										</div>
								</div>
							</div>
							
								<div class="row form-group buttons_margin_top ">
									<div align="center">
										<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMemberPaymentDetailsForAMCByName()" value="Search" />
									</div>
								</div>

									<table
										class="table table-bordered table-striped table-condensed cf" id="memBetweenTwoDatesForAMC" class="display"
										style="border: 2px solid black; border-collapse: collapse;">
										<thead>
											 <tr>
												<th>Sr No</th>
												<th>Member Name</th>
												<th>Date</th>
												<th>Month</th>
												<th>Credits  Amount</th>
											    <th>Debits Amount</th>
								                <th>Balance Amount</th>								               
											</tr>
										</thead>
										
						               <!-- <tfoot>
											<tr>
												<th colspan="5" style="text-align: right">Total:</th>
												<th></th>
												<th></th>
												<th></th>
											</tr>
										</tfoot> -->
									</table>
								</fieldset>
							</form>
						</div>

						
	<!-----------------------------   Date Wise For AMC--------------------------->
						
						<div id="memBetweenTwoDate2" class="tab-pane">
						<div class="row">
						<div class="col-sm-offset-1 col-md-10">
							<hr style="border-top-color: #c1b1b1;">
						</div>
					</div>
							
					<form class="form-horizontal">
				       <div class="row">
						<div class="form-group">
					
								<div class="col-md-2 col-sm-offset-1" align="right">
									<label class="control-label">Start Date:</label>
								</div>
									<div class="col-sm-3">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-calendar"></i>
											</span> 
											<input type="date" id="fisDate22ForAMC" placeholder="Start Date" class="form-control input-md" type="text">
										</div>
									</div>
						
										<div class="col-md-2" align="right">
										<label class="control-label" for="endDateForAMC">End Date:</label>
										</div>
										<div class="col-sm-3">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-calendar"></i>
												</span> 
												<input type="date" id="endDate22ForAMC" placeholder="End Date" class="form-control input-md ac_district" type="text">
											</div>
										</div>
									</div>
								</div>
							      <div class="row form-group buttons_margin_top ">
										<div align="center">
											<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getMemberPaymentDetailsForAMCByDate()" value="Search" />
										</div>
								  </div>
							
								<table class="table table-bordered table-striped table-condensed cf" id="memberBetweenTwoDatesForAMC" class="display" style="border: 2px solid black; border-collapse: collapse;">
									<thead>
										 <tr>
											<th>Sr No</th>
											<th>Member Name</th>
											<th>Total Amount</th>
											<th>Month</th>
											<th>Month Amount</th>
							                <th>Paid Amount</th>
							                <th>Balance Amount</th>
							                <th>Description</th>
							                <th>Date</th>
										</tr>
									</thead>
								</table>
							</form>
						</div>
					</div>
				</div>
				
				
				
				
			
			
			
						
	<!-- ++++++++++++++++++++++++++++++++++	Employee Payment reports ++++++++++++++++++++++++++++++-->

				<div class="tab-pane" id="Employee">
					<div class="row">
						<div align="center">
							<h2 class="form-name style_heading">Employee Payment Reports</h2>
						</div>

						<div class="row">
							<!-- <div class="col-sm-offset-1 col-md-10">
								<hr style="border-top-color: #c1b1b1;">
							</div> -->
						</div>
					</div>

				<!-- 		<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#memberNameWise2"><h4 style="color: blue">Member Name Wise</h4></a></li>
							<li><a data-toggle="tab" href="#memBetweenTwoDate2"><h4 style="color: blue">Range</h4></a></li>
						</ul> -->

					<div class="tab-content" style="float: left">
						
						
	<!-----------------------------    Member Name Wise For AMC  --------------------------->

				<div id="memberNameWise2" class="tab-pane fade in active">
					<div class="row">
						<div class="col-sm-offset-1 col-md-10">
							<hr style="border-top-color: #c1b1b1;">
						</div>
					</div>
						
 <form class="form-horizontal" method="post" action="" name="empReport1">
			<div class="row">
				<div class="form-group">
					<div class="col-md-2 col-sm-offset-1" align="right">
						<label class="control-label" for="employeename">Employee Name:<sup>*</sup></label>  
          				</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							 <i class="glyphicon glyphicon-user"></i>
							</span>
						    <%
						  	  EmployeeDetailsDao sdd3 = new EmployeeDetailsDao();
								List sList4 = sdd3.getAllMainEmployeeForEmployeePaymentReport();
							 %>
							 <input list="employeeNameList" id="fk_employee_id" class="form-control">
								<datalist id="employeeNameList">
								 <%
									for (int i = 0; i < sList4.size(); i++) {
										EmployeePaymentBeanHibernate sup = (EmployeePaymentBeanHibernate) sList4.get(i);
								 %>

								<option data-value="<%=sup.getFkEmployeeid() %>"
										value="<%=sup.getEmployeeName() %>">
									
									<%
										}
									%>
								</datalist>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group">
						<div class="col-sm-2 col-sm-offset-1" align="right">
							<label class="control-label">Start Date:<sup>*</sup></label>
						</div>
						<div class="col-sm-3">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-calendar"> </i>
								</span> 
								<input type="date" id="fisDate" placeholder="Start Date" class="form-control input-md" type="text">
							</div>
						</div>

						<div class="col-sm-2" align="right">
							<label class="control-label">End Date:<sup>*</sup></label>
						</div>
						<div class="col-sm-3">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="glyphicon glyphicon-calendar"></i>
								</span>
								 <input type="date" id="endDate" placeholder="End Date" class="form-control input-md ac_district" type="text">
							</div>
						</div>
					</div>
				</div>

		<div class="row form-group buttons_margin_top ">
			<div align="center">
				<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getTeacherPaymentDetailsBetTwoDaysValidation()" value="Search" />
			</div>
		</div>

					<table
						class="table table-bordered table-striped table-condensed cf"
						id="empBetweenTwoDates" class="display"
						style="border: 2px solid black; border-collapse: collapse;">
						<thead>
							<tr>
							    <th>Sr No</th>
							    <th>Employee Name</th>
								<th>Payment Date</th>
								<th>Payment Type</th>
								<th>Payment Mode</th>
								<th>Payment Amount</th>
								<th>Accountant Name</th>
								<th>Account No</th>
								<th>Bank Name</th>
								<th>Reason</th>
							</tr>
						</thead>
						<tfoot>
						
						   <!--
						    <tr>
								<th colspan="5" style="text-align: right">Total:</th>
								<th></th>
								<th></th>
								<th></th>
						   </tr> -->
						
						</tfoot>
					</table>
			</form>

						</div>
	
							
					</div>
				</div>
		
		
		
		
		
		
						
	<!-- ++++++++++++++++++++++++++++++++++	Expenditure Payment reports ++++++++++++++++++++++++++++++-->

				<div class="tab-pane" id="Expenditure">
					<div class="row">
						<div align="center">
							<h2 class="form-name style_heading">Expenditure Payment Reports</h2>
						</div>
						
						
									<div class="form-group" align="right">
					<div class="col-sm-offset-8 col-md-4 control-label">
						<div id="date">
							<label id="demo"></label>
							<script>
								var date = new Date();
								document.getElementById("demo").innerHTML = date.toDateString();
							</script>
						</div>
					</div>
				</div>

						<div class="row">
							<div class="col-sm-offset-1 col-md-10">
								<hr style="border-top-color: #c1b1b1;">
							</div>
						</div>
						

						
					</div>
					

						 <ul class="nav nav-tabs">
						    <li class="active"><a data-toggle="tab" href="#home333"><h4 style="color:blue">Expenditure Name Wise</h4></a></li>
						    <li><a data-toggle="tab" href="#twoDates333"><h4 style="color:blue">Range</h4></a></li>
						 </ul>

					<div class="tab-content" style="float: left">
						
						
	<!-----------------------------    Member Name Wise For AMC  --------------------------->

				<div id="home333" class="tab-pane fade in active">		
			<form class="form-horizontal" method="post" action="" name="dates">
				
				<div class="row">
					<div class="col-md-12">
						<hr style="border-top-color: #c1b1b1;">
					</div>
				</div>
		
		 <div id="home" class="tab-pane fade in active">		
			<form class="form-horizontal">
					<div class="row">
						<div class="form-group">
							<div class="col-md-2 col-sm-offset-1" align="right">
								<label class="control-label" for="expenditureName">Expenditure Name:</label>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
									 <i class="glyphicon glyphicon-stats"></i>
									</span>
										<%
											ExpenditureDetailsDao exdd33 = new ExpenditureDetailsDao();
											List exList = exdd33.getAllExpenseName();
										%>
										<input list="exp_drop" id="expenseName" class="form-control" onchange="getSubExpenseName()">
										<datalist id="exp_drop">
											<%
												for (int i = 0; i < exList.size(); i++) {
													ExpenditureDetailsBean expbean = (ExpenditureDetailsBean) exList.get(i);
											%>
											<option data-value="<%=expbean.getPkExpenseDetailsId()%>"
												value="<%=expbean.getExpenseName()%>">
												<%
													}
												%>
											
										</datalist>
								</div>
								</div>
									
							<div class="col-md-2" align="right">
								<label class="control-label" for="expenditureName">Sub Expenditure Name:</label>
							</div>
							<div class="col-md-3">
								<div class="input-group">
									<span class="input-group-addon">
									 <i class="glyphicon glyphicon-stats"></i>
									</span>
										<input list="subExp_drop" id="sub_ExpenseName" class="form-control">
										<datalist id="subExp_drop">
								</div>
								</div>
						
							</div>
						</div>
		            <div class="row">
						<div class="form-group">
						
							<div class="col-md-2 col-sm-offset-1" align="right">
										<label class="control-label">Start Date:</label>
											</div>
												<div class="col-sm-3">
													<div class="input-group">
														<span class="input-group-addon"> <i
															class="glyphicon glyphicon-calendar"></i>
														</span> 
														<input type="date" id="fisDate442" placeholder="Start Date" class="form-control input-md" type="text">
													</div>
												</div>
						
											<div class="col-md-2" align="right">
												<label class="control-label" for="endDate">End Date:</label>
											</div>
												<div class="col-sm-3">
													<div class="input-group">
														<span class="input-group-addon"> <i
															class="glyphicon glyphicon-calendar"></i>
														</span> 
														<input type="date" id="endDate442" placeholder="End Date" class="form-control input-md ac_district" type="text">
													</div>
												</div>
											</div>
											</div>
		      <div class="row form-group buttons_margin_top ">
					<div align="center">
						<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getExpensePaymentDetailsBetTwoDays()" value="Search" />
					</div>
			  </div>
		
			<table class="table table-bordered table-striped table-condensed cf" id="expenseBetweenTwoDates" class="display" style="border: 2px solid black; border-collapse: collapse;">
							<thead>
								<tr>
								   <th>Sr No</th>
								   <th>Expense Name</th>
								   <th>Sub Expense Name</th>
								   <th>Service Provider</th>
								   <th>Amount</th>
								   <th>Date</th>
									
								</tr>
							</thead>
					</form>
					
				</table>
				</div>
				</form>
		</div>

						
	<!-----------------------------   Date Wise For AMC--------------------------->
						
								
		 <div id="twoDates333" class="tab-pane">		
			<form class="form-horizontal" method="post" action="" name="dates">
		 	
		 			<!-- <div class="form-group" align="right">
					<div class="col-sm-offset-8 col-md-4 control-label">
						<div id="date">
							<label id="demo1"></label>
							<script>
								var date = new Date();
								document.getElementById("demo1").innerHTML = date.toDateString();
							</script>
						</div>
					</div>
				</div>
		 	 -->
		 	
	
				
				<div class="row">
					<div class="col-md-12">
						<hr style="border-top-color: #c1b1b1;">
					</div>
				</div>
		
		 <div id="home" class="tab-pane fade in active">		
			<form class="form-horizontal">
		         <div class="row">
						<div class="form-group">
						
							<div class="col-md-2 col-sm-offset-1" align="right">
										<label class="control-label">Start Date:</label>
											</div>
												<div class="col-sm-3">
													<div class="input-group">
														<span class="input-group-addon"> <i
															class="glyphicon glyphicon-calendar"></i>
														</span> 
														<input type="date" id="fisDate422" placeholder="Start Date" class="form-control input-md" type="text">
													</div>
												</div>
						
						
							<div class="col-md-2" align="right">
												<label class="control-label" for="endDate">End Date:</label>
												</div>
												<div class="col-sm-3">
													<div class="input-group">
														<span class="input-group-addon"> <i
															class="glyphicon glyphicon-calendar"></i>
														</span> 
														<input type="date" id="endDate422" placeholder="End Date" class="form-control input-md ac_district" type="text">
													</div>
												</div>
											</div>
													</div>
				      <div class="row form-group buttons_margin_top ">
							<div align="center">
								<input type="button" id="btn" name="save" class="btn btn-lg btn-success btn-md button_hw button_margin_right" onclick="getExpensePaymentDetailsBetDays()" value="Search" />
							</div>
					  </div>
				
					<table class="table table-bordered table-striped table-condensed cf" id="expenseBetweenDates22" class="display" style="border: 2px solid black; border-collapse: collapse;">
							<thead>
								<tr>
								   <th>Sr No</th>
								   <th>Expense Name</th>
								   <th>Sub Expense Name</th>
								   <th>Service Provider</th>
								   <th>Amount</th>
								   <th>Date</th>
									
								</tr>
							</thead>
					</form>
					
		</table>
		</div>
		</form>
		</div>

							
					</div>
				</div>
				
				
				
				
				
				
			</div>
		</div>
	</div>
</div>

<div class="row footer_margin_top" align="center">
</div>
</body>