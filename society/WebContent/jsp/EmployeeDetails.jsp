<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.society.hibernate.EmployeeDetailsHibernate"%>

<%@page import="com.society.hibernate.UserDetailasHibernate"%>
<%@page import="com.society.utility.HibernateUtility"%>
<%@page import="com.society.dao.EmployeeDetailsDao"%>

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
		
		<script type="text/javascript" src="/staticContent/js/bootbox.min.js"></script>
		<script type="text/javascript" src="/staticContent/js/bootstrap.js"></script>
        <script src="/society/staticContent/js/employeeDetails.js"></script>

         <script type="text/javascript">
   		 function employeeList()
   		 {
   			 window.location = "employeeList.jsp";
 		 }
	 /*  function editEmployee() {
		 window.location = "editEmployeeDetails.jsp";
            } */
    	</script> 
       		
        <!-- <script type="text/javascript">
		function edit()
		{
			window.location = "EditEmployeeDetails.jsp"
		}		

       		</script> -->
       		
       	<script type="text/javascript">
		function editEmployeeDetails()
		{
			window.location = "editEmployeeDetails.jsp"
		}
       	</script>
         		
        <script>
		function lettersonly(input) {

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
		function empvalidation(){
			//alert("ok");
			<%
			EmployeeDetailsDao empdao = new EmployeeDetailsDao(); 
			List empidList = empdao.getAllEmployeeID();
			%>
			var EmpId = $('#empId').val();
			if (EmpId == "" || EmpId == null){
				
			}
			else{
				
			<%
			System.out.println("empidList ==> "+empidList.size());
			
				for(int i=0;i<empidList.size();i++){
					EmployeeDetailsHibernate cdb = (EmployeeDetailsHibernate)empidList.get(i);
			%>
				var empid ="<%=cdb.getEmpId()%>";
				if(EmpId == empid)
				{
					alert("Employee ID is already exist");
					document.getElementById('empId').value="";
					return false;
				}
				<%}%>
		   	}
		}
		</script>
		
</head>
<body onLoad="notifyMe()">

	<div class="container-fluid">
		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Employee Details</h2>
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

			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">First Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> 
							<input type="text" id='firstName' name="firstName"  onkeypress="return isAlphabets(event)"
								   class="form-control textInput" placeholder="Enter First Name"  />
							<div id="name_error" class="val_error"></div>
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
							<span class="input-group-addon">
							 	<i class="glyphicon glyphicon-user"></i>
							</span>
							 <input type="text" id='lastName' name="lastName" onkeypress="return isAlphabets(event)"
								    class="form-control" placeholder="Enter Last Name">
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Employee ID:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> 
								<i class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='empId' name="empId" class="form-control"
								   placeholder="Enter Employee Id" onchange="empvalidation()">
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Work Details:<sup>*</sup></label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> 
								<i class="glyphicon glyphicon-phone"></i>
							</span> 
							<textarea id="workDetails" rows="4" cols="35" placeholder="Enter Work Details" class="form-control"></textarea>
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Aadhar Number:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='adharNumber'  maxlength="12" name="adharNumber" onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Aadhar Number">
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Contact No:<sup>*</sup></label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='contactNo' name="contactNo" maxlength="10"  onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Contact No">
						</div>
					</div>



				<div class="col-sm-2" align="right">
						<label class="control-label">Alternate Contact No:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='alternateContactNo' name="alternateContactNo" maxlength="10"  onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Alternate Contact Nunber">
						</div>
					</div>
				</div>
				
			 </div>
			 		
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Address:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i>
							</span> 
							<!-- <input type="text" id='address' name="address" class="form-control textInput" placeholder="Enter Address"  /> -->	
							<textarea rows="3" cols="15" id='address' name="address" class="form-control textInput" placeholder="Enter Address"></textarea>	
							<!-- <input type="text" id='address' name="address" placeholder="Enter Address" class="form-control"> -->
								
							<!-- 	<div id="name_error" class="val_error"></div> -->
						</div>
					</div>

	
				</div>
			</div>
			
	</form>		
			
			<div class="row">
				<div class="form-group">

				</div>
			</div>

			<div class="container" align="center">
				<input type="button" class="btn btn-success btn-lg btnn" value="Save" name="btn" onclick="validationEmployeeDetails()"> 
				<input type="button" class="btn btn-danger btn-lg btnn" value="Cancel" onclick="reset()">
			 	<input type="button" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="employeeList()">
				<input type="button" value="Edit" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="editEmployeeDetails()">
		
			<!-- 	<input type="button"  value="Edit" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="edit()"> -->
			
			</div>
		
		</div>
	</div>
</body>
</html>

<%@include file="commons/newFooter.jsp"%>
