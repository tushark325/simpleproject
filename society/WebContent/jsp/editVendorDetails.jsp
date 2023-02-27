<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<%@page import="com.society.hibernate.VendorDetailsHibernate"%>
<%@page import="com.society.dao.VendorDetailsDao"%>
<html>
<head>

		<script type="text/javascript" src="/society/staticContent/js/jquery-1.12.3.min.js"></script>
		<link rel="stylesheet" href="/society/staticContent/css/jquery-ui.min.css">
		<link rel="stylesheet" href="/society/staticContent/css/ui.jqgrid.css">
		<script type="text/javascript" src="/society/staticContent/js/jquery.min.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jquery-ui-min.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jquery-ui.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jqueryUi.js"></script>
		<script type="text/javascript" src="/society/staticContent/js/jquery.jqgrid.min.js"></script>
		
        <script src="/society/staticContent/js/vendorDetails.js"></script>
        
        <script type="text/javascript">
          		 function vendorList()
          		 {
          		 window.location = "vendorList.jsp";
          		 }
          		</script> 
          		
          		<script type="text/javascript">
					function back()
					{
						window.location = "VendorDetails.jsp";	
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
				<h2 class="form-name style_heading" style="margin-top: 80px">Edit Vendor Details</h2>
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
		

    <form class="form-horizontal" name="vendorForm">
		
		<div class="row">
				<div class="form-group">
					<label class="col-md-3 control-label" for="employeename">Vendor Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<%
								VendorDetailsDao sdd3 = new VendorDetailsDao();
								List sList4 = sdd3.getAllVendorNames();
							%>
							<input list="vendorNameList" id="fk_vendor_id" class="form-control" onchange="getVendorListForEdit()">
							<datalist id="vendorNameList">
								<%
									for (int i = 0; i < sList4.size(); i++) {
									VendorDetailsHibernate sup = (VendorDetailsHibernate) sList4.get(i);
								%>

								<option data-value="<%=sup.getPkVendorDetailsId()%>"
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
				<div class="form-group">
					<label class="col-md-3 control-label" for="employeename">First Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<input type="text" id='firstName' name="firstName" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter first name">
							
						</div>
					</div>
				

					<div class="col-sm-2" align="right">
						<label class="control-label">Middle Name:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-calendar"></i>
							</span>
                            <input type="text" id='middleName' name="middleName" class="form-control" placeholder="Enter middle name" />
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="row">
				<div class="form-group">
					<label class="col-md-3 control-label" for="employeename">Last Name<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<input type="text" id='lastName' name="lastName" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter last name">
							
						</div>
					</div>
				

					<div class="col-sm-2" align="right">
						<label class="control-label">Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-calendar"></i>
							</span>
                            <input type="date" id='enquiryDate' name="enquiryDate" class="form-control" placeholder="Select Date" />
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Contact Number:<sup>*</sup></label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> 
							<input type="text" id='contactNo' name="contactNo" maxlength="10" onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Contact Number">
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">Address:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> <input type="text" id='address' name="address"
								class="form-control" placeholder="Enter Address">
						</div>
					</div>
				</div>
			</div>
			
		<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Alternate Contact Number:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='alternateContactNumber' maxlength="10" name="alternateContactNumber" onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Alternate Contact Number">
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">Emergency Contact Number:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> <input type="text" id='emergenctContactNumber' maxlength="10" name="emergenctContactNumber" onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Emergency Contact Number">
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Company Name:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> 
							<input type="text" id='companyName' name="companyName" class="form-control" placeholder="Enter Company Name" />
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Company Address:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-calendar"></i>
							</span>
                            <input type="text" id='companyAddress' name="companyAddress" class="form-control" placeholder="Enter Company Address" />
						</div>
					</div>
				</div>
			</div>			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right" hidden="true">
						<label class="control-label">Contact Person Name:<sup>*</sup></label>
					</div>
					<div class="col-md-3" hidden="true">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='contactPersonName' name="contactPersonName" value="NA" readonly="readonly" onkeypress="return isAlphabetsWithSpace(event)"
								class="form-control" placeholder="Enter Contact Person Number">
						</div>
					</div>
					
					<div class="col-sm-3" align="right">
						<label class="control-label">Company Number:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='companyNumber' name="companyNumber" maxlength="10" onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Company Number">
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">GSTIN Number:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
						 <input type="text" id='gstInNo' name="gstInNo"	class="form-control" placeholder="Enter GSTIN Number">
						</div>
					</div>
					
					
				</div>
			</div>
			
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Zip Code:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-envelope"></i>
							</span> 
							<input type="text" id='zipCode' name="zipCode" maxlength="6" onkeypress="return isNumber(event)" class="form-control" placeholder="Enter Zip Code"> 
						</div>
					</div>
					
			         <div class="col-sm-2" align="right">
						<label class="control-label">Email:<sup>*</sup></label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-envelope"></i>
							</span> 
							<input type="text" id='emailId' name="emailId" class="form-control" placeholder="Enter Email Id">
						</div>
					</div>
			     </div>
			</div>
					
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Country:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
						 <input type="text" id='country' name="country"	onkeypress="return isAlphabetsWithSpace(event)" class="form-control" placeholder="Enter Country">
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">State:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
					 <input type="text" id='state' name="state"	class="form-control" onkeypress="return isAlphabetsWithSpace(event)" placeholder="Enter State">
						</div>
					</div>
				</div>
			</div>
					
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">PAN Number:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
						 <input type="text" id='PANNum' name="PANNum"class="form-control" maxlength="10"  placeholder="Enter PAN Number">
						</div>
					</div>
					
			         <div class="col-sm-2" align="right">
						<label class="control-label">CIN Number:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
					 <input type="text" id='CIMNo' name="gstInNo"	class="form-control" placeholder="Enter CIM Number">
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group">
					<!-- <div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">GSTIN Number:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
						 <input type="text" id='gstInNo' name="gstInNo"	class="form-control" placeholder="Enter GSTIN Number">
						</div>
					</div>
 -->

				</div>
			</div>
			
			<div class="container" align="center">
				<input type="button" class="btn btn-success btn-lg btnn" value="Update" name="btn" onclick="updateVendorDetail()"> 
				<input type="button" class="btn btn-danger btn-lg btnn" value="Cancel" onclick="reset()">
				<input type="button" class="btn btn-primary btn-lg btnn" value="Back" onclick="back()">
			</div>
		</form>
	</div>
</body>
</html>

<%@include file="commons/newFooter.jsp"%>
