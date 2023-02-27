<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.society.dao.MemberDetailsDao"%>
<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.hibernate.UserDetailasHibernate"%>
<%@page import="com.society.utility.HibernateUtility"%>

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
		
<!-- 		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 -->		<!-- <script type="text/javascript" src="/staticContent/js/bootbox.js"></script> -->
		
    <!--   <link rel="shortcut icon" href="/society/staticContent/img/s1.jpg" /> -->
	
	       <script src="/society/staticContent/js/memberDetails.js"></script>

             <script type="text/javascript">
          		 function memberList()
          		 {
          			 window.location = "memberList.jsp";
          		 }
          		 /* function editEmployee() {
          			 window.location = "editEmployeeDetails.jsp";
				} */
          		</script> 
          		<script type="text/javascript">
					function back()
					{
						window.location = "MemberDetails.jsp"
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

</head>
<body onLoad="notifyMe()">

	<div class="container-fluid">
		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Edit Member Details</h2>
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
		<div class="row form-group">
           <div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Member Name:<sup>*</sup></label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
			               
			               <%-- <% for(int count=0; count<eqArray.size(); count++){ %>
                            <option value="<%= eqArray.get(count) %>" <%= (eqArray.get(count).equals("eqName"))?"selected":"" %> ><%= eqArray.get(count) %></option>  
                            <%
                            } 
                            %> --%>
			               
							<%
								MemberDetailsDao sdd33 = new MemberDetailsDao();
								List sList44 = sdd33.getAllMemberForCashBook();
							%>
							<input list="memeberNameList" id="fk_member_id" class="form-control" onchange="getMemberDetailsForEdit()">
							<datalist id="memeberNameList">
							
								<%
									for (int i = 0; i < sList44.size(); i++) 
									{
									  
									 MemberDetailsHibernate sup = (MemberDetailsHibernate) sList44.get(i);
								%>
                                
								<option data-value="<%=sup.getPkMemId()%>" 
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
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Designation:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<select id="position" class="form-control textInput">
								<option value="">--Select--</option>
								<option value="Chairman">Chairman</option>
								<option value="Secretary">Secretary</option>
								<option value="Member">Member</option>
							</select>
							 
							<!-- <input type="text" id='firstName' name="firstName"  onkeypress="return isAlphabets(event)" class="form-control textInput" placeholder="Enter First Name"  />
							 -->	
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
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" id='lastName' name="lastName" onkeypress="return isAlphabets(event)"
								class="form-control" placeholder="Enter Last Name">
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Date Of Birth:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="date" id='dob' name="dob" class="form-control"
								placeholder="Enter Date Of Birth">
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
							</span> <input type="text" id='contactNo' maxlength="10" name="contactNo" onkeypress="return isNumber(event)"
								class="form-control" placeholder="Enter Contact Number">
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Alternate Contact Number:</label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <input type="text" id='altContactNo'  maxlength="10" name="altContactNo" onkeypress="return isNumber(event)"
								class="form-control"
								placeholder="Enter Alternate Contact Number">
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
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



				<div class="col-sm-2" align="right">
						<label class="control-label">Alternate Email:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-envelope"></i>
							</span> <input type="text" id='confirmEmail' name="confirmEmail"
								class="form-control" placeholder="Enter Confirmation Email"><!--  onblur="check()" -->
						</div>
					</div>
				</div>
				</div>
				
				
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Adhar No:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='adharNo' name="adharNo" class="form-control" maxlength="12" placeholder="Enter Adhar Number">
						</div>
					</div>

				<div class="col-sm-2" align="right">
						<label class="control-label">PAN No:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
							 <input type="text" id='panNo' name="panNo" class="form-control" placeholder="Enter Pan Number">
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
								class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='buildingName' name="buildingName"
								class="form-control textInput" placeholder="Enter Building Name"  />
								<div id="name_error" class="val_error"></div>
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Wing Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='wingName' name="wingName"
								class="form-control" placeholder="Enter Wing Name">
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
							<input type="text" id='floorNo' name="floorNo" 
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
							</span> <input type="text" id='flatNo' name="flatNo"
								class="form-control" placeholder="Enter Flat No">
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Super BuiltUp Area:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='sba' name="sba" class="form-control textInput" placeholder="Enter bult up area" onkeypress="return isNumber(event)"/>
								
						</div>
					</div>

				</div>
			</div>

			<div class="row">
				<div class="form-group">

				</div>
			</div>

			    </div>

			<div class="container" align="center">
				<input type="button"  class="btn btn-success btn-lg btnn" value="Update" name="btn" onclick="updateMemberDetails()"> 
				<input type="button"  class="btn btn-danger btn-lg btnn" value="Cancel" onclick="reset()">
				<input type="button"  value="Back" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="back()">
				
			<!-- 	<input type="button"  value="Edit" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="edit()"> -->
			
			</div>
		</form>
		</div>
	</div>
</body>
</html>

<%@include file="commons/newFooter.jsp"%>
