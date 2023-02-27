<%@page import="com.society.hibernate.ClientEnquiryHibernate"%>
<%@page import="com.society.dao.ClientEnquiryDao"%>
<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>

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
    
        <script src="/society/staticContent/js/clientEnquiry.js"></script>
        
        <script type="text/javascript">
          		 function clientEnquiryList()
          		 {
          		 	window.location = "clientEnquiryList.jsp";
          		 }
          		</script> 
        
        
        <script type="text/javascript">
          		 function clientResponseList()
          		 {
          		 	window.location = "clientResponseList.jsp";
          		 }
          		</script> 
          		
          		<script type="text/javascript">
					function back()
					{
						window.location = "ClientEnquiry.jsp";

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
<div class="container-fluid" > 
<div class="row" style="min-height:300px;">
    <div  class="col-md-12">
        <h3>Left Tabs</h3>
        <hr/>
        <div class="col-md-2">
         <!--    <ul class="nav nav-tabs">
                <li class=""><a href="#enquiry" data-toggle="tab">Client Enquiry Details</a></li>
                <li><a href="#response" data-toggle="tab">Client Response</a></li>
            </ul> -->
        </div>
				<div class="col-xs-9">
					<!-- Tab panes -->
					<div class="tab-content">
					
					<!---------Client Enquiry ---------->
<div class="tab-pane active" id="enquiry">
  <form class="form-horizontal" method="post" action="" name="clientEnqForm">
   	    	 <div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Client Enquiry Details</h2>
			  	</div>
		     <div class="row">
				     <div class="col-sm-offset-1 col-md-10">
						  		<hr style="border-top-color:#c1b1b1;">
				     </div>	
		   		 </div>
		    </div>


		<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Client Name:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> 
							<%
								ClientEnquiryDao dao = new ClientEnquiryDao();
								List list = dao.getAllClientNames();
								
							%>
							
							<input list="clientNameList" id="fk_client_id" class="form-control" onchange="getClientDetailsForEdit()">
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


				</div>
			</div>


		
		<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">First Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id='firstName' name="firstName" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter First Name" />
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Middle Name:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id='middleName' name="middleName" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter Middle Name">
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Last Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id='lastName' name="lastName" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter Last Name">
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Enquiry Date:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-calendar"></i>
							</span>
                            <input type="date" id='enquiryDate' name="enquiryDate" class="form-control" placeholder="Select Enquiry Date" />
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Business Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id='businessName' name="businessName" 
								class="form-control" placeholder="Enter Business Name">
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Business Address:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-calendar"></i>
							</span>
                            <input type="text" id='businessAddress' name="businessAddress" class="form-control" placeholder="Enter Business Address" />
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Contact Number:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='contactNo' name="contactNo" maxlength="10" onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Contact Number">
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">Email:<sup>*</sup></label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-envelope"></i>
							</span> <input type="text" id='emailId' name="emailId"
								class="form-control" placeholder="Enter Email Id">
						</div>
					</div>





				</div>
			</div>
			
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">City:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='city' name="city" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter City">
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">State:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> <input type="text" id='state' name="state" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter State">
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
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='zipcode' name="zipcode" maxlength="6" onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Zip Code">
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">Country:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> <input type="text" id='country' name="country" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter Country">
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
							</span> <input type="text" id='alternativeContactNo' name="alternativeContactNo" maxlength="10" onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Alternate Contact Number">
						</div>
					</div>
					
					<div class="col-sm-2" align="right">
						<label class="control-label">Product Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> <input type="text" id='productName' name="productName" onkeypress="return isAlphabetsWithSpace(event)"
								class="form-control" placeholder="Enter Product Name">
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group">
				<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Reference By:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id='referenceBy' name="referenceBy"
								class="form-control" placeholder="Enter Reference By">
						</div>
					</div>
		
					<div class="col-sm-2" align="right">
						<label class="control-label">Comment:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='comment' name="comment"
								class="form-control" placeholder="Enter Comment">
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group">
	
		
			<div class="col-sm-2 col-sm-offset-1" align="right">
                 <label class="control-label">Upload PDF File:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">
							<i class="glyphicon glyphicon-pencil"></i>
							</span>
						  <input type="file" id='uploadFile' name="uploadFile" class="form-control" placeholder="upload File .pdf">
					 	</div>
					 </div>
				</div>
			</div>


			<div class="container" align="center">
				<input type="button" class="btn btn-success btn-lg btnn" value="Update" name="btn" onclick="updateClientEnquiryDetail()"> 
				<input type="button" class="btn btn-danger btn-lg btnn" value="Cancel" onclick="reset()">
				<input type="button" value="Back" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="back()">
				<!-- <input type="button"  value="Edit" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="edit()"> -->
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
</html>		