<% boolean isHome=false;%>
<%@include file="commons/header.jsp"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.society.hibernate.UserDetailasHibernate"%>

<%@page import="com.society.utility.HibernateUtility"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.society.helper.MemberMonthlyContributionCostHelper"%>
<%@page import="com.society.dao.MemberMonthlyContributionCostDao"%>

<html>
  			<%
 			 		 /* String type1= "";
                     String name1 = ""; */
		             if (session != null)
		             {
				         if (session.getAttribute("user") != null) 
				         {
						    String  name = (String) session.getAttribute("user");
						 	      
				              HibernateUtility hbu1=HibernateUtility.getInstance();
				              Session session2=hbu1.getHibernateSession();
				   
				              org.hibernate.Query query1 = session2.createSQLQuery("select * from user_login where UserName =:usr");
				              query1.setParameter("usr", name1);
				              UserDetailasHibernate userDetail1 = (UserDetailasHibernate) query1.uniqueResult();
			             } 
				         else 
				         {
			                 out.println("<script>");
						     out.println("alert('Please Enter valid User Name And Password');");
							 out.println("location='/society/jsp/login.jsp;'");
						     out.println("</script>");  
							
							 /* 
								 out.println("alert('Please Enter valid User Name And Password');");
								 
								 
							 response.sendRedirect("/society/jsp/login.jsp");
						
						      */
						     /* out.println("Please Login "); */
					     }
		           }
		           else
	                {
	            	 
		            	 /*     out.println("<script>");
						     out.println("alert('Please Enter valid User Name And Password');");
							 out.println("</script>");  
						 */	 
					     	// response.sendRedirect("/society/jsp/login.jsp");
					     
					  
						 out.println("<script>");
					     out.println("alert('Please Enter valid User Name And Password');");
					     out.println("location='/society/jsp/login.jsp;'");
					     out.println("</script>");  
					     
					     //out.println("Please Login ");
			        }
	           %> 
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
		
         <script src="/society/staticContent/js/memberDetails.js"></script>

             <script type="text/javascript">
          		 function memberList()
          		 {
          			 window.location = "memberList.jsp";
          		 }
          		</script> 
          	
          		<script type="text/javascript">
					function edit()
					{
						window.location = "EditMemberDetails.jsp"
					}
          		</script>
          		
          		
        <script>
				function lettersonly(input) {
		
					var regex = /[^a-z ]/gi;
					input.value = input.value.replace(regex, "");
		
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
			function check()
			{
		        var email = document.getElementById("emailId").value
		        var cEmail = document.getElementById("confirmEmail").value

				if(email != cEmail)
				{
					document.getElementById("confirmEmail").focus()
				}
			}	
		</script>

	<script type="text/javascript">
			function sendMail()
			{

				try {
					<%
	
						SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd");
						String todayDate = simpleformat.format(new Date());	
				
						String[] todayDate2 = todayDate.split("-");
						
						String firtDate = todayDate2[2];
						Integer dt = Integer.parseInt(firtDate);
						
						if(dt == 01)
						{
							MemberMonthlyContributionCostHelper mmcch = new MemberMonthlyContributionCostHelper();
							mmcch.sendMailMonthly();
						}
					%>
				} catch (e) {
					// TODO: handle exception
				}
			}
		
	</script>
	
	<script type="text/javascript">
		function changeStatus()
		{
			try
			{				
				<%
			 		SimpleDateFormat simpleformat2 = new SimpleDateFormat("yyyy-MM-dd");
					String todayDate22 = simpleformat2.format(new Date());	
			
					String[] todayDate222 = todayDate22.split("-");
					
					String firtDate22 = todayDate222[2];
					Integer dt22 = Integer.parseInt(firtDate22);
					
					if(dt22 != 01)
					{
						MemberMonthlyContributionCostHelper mmcch = new MemberMonthlyContributionCostHelper();
						mmcch.changeStatusOfMail();
					}				
				%>
			}
			catch (e)
			{
				// TODO: handle exception
			}
		}

	</script>	
</head>
<body onLoad="sendMail();changeStatus()">

	<div class="container-fluid">
		<div class="row header_margin_top">
			<div align="center">
				<h2 class="form-name style_heading" style="margin-top: 80px">Member Details</h2>
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
						<label class="control-label">Designation:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">   
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<select id="position" class="form-control textInput">
								<option value="">--Select--</option>
						<!--		<option value="Chairman">Chairman</option>-->
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
							</span> 
							<input type="text" id='contactNo' maxlength="10" name="contactNo" onkeypress="return isNumber(event)"
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
								class="form-control" placeholder="Enter Alternate Email"><!--  onblur="check()" -->
						</div>
					</div>
				</div>
				</div>
				
				
			<div class="row">
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-1" align="right">
						<label class="control-label">Aadhar No:</label>
					</div>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='adharNo' name="adharNo" class="form-control" maxlength="12" placeholder="Enter Adhar Number" onkeypress="return isNumber(event)">
						</div>
					</div>

				<div class="col-sm-2" align="right">
						<label class="control-label">PAN NO:</label>
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
						<label class="control-label">Wing Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> 
							<input type="text" id='wingName' name="wingName"
								class="form-control textInput" placeholder="Enter wing name" style="text-transform:uppercase" />
								<div id="name_error" class="val_error"></div>
						</div>
					</div>

					<div class="col-sm-2" align="right">
						<label class="control-label">Building Name:<sup>*</sup></label>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span> <input type="text" id='buildingName' name="buildingName"
								class="form-control" placeholder="Enter building name" style="text-transform:uppercase">
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
								class="form-control textInput" placeholder="Enter Floor No" style="text-transform:uppercase" />
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
								class="form-control" placeholder="Enter Flat No" style="text-transform:uppercase" />
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
							<input type="number" id='sba' name="sba" class="form-control textInput" placeholder="Enter built up area" />
								
						</div>
					</div>

				</div>
			</div>

			<div class="row">
				<div class="form-group">

				</div>
			</div>			   

			<div class="container" align="center">
				<input type="button"  class="btn btn-success btn-lg btnn" value="Save" name="btn" onclick="validationmemberDetails()"> 
				<input type="button"  class="btn btn-danger btn-lg btnn" value="Cancel" onclick="reset()">
			 	<input type="button"  value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="memberList()">
				<input type="button"  value="Edit" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="edit()">			
			</div>
		</form>
		</div>
	</div>
</body>
</html>

<%@include file="commons/newFooter.jsp"%>
