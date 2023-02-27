<%@page import="com.society.dao.UserDetailsDao"%>

<%@page import="com.society.hibernate.UserDetailasHibernate"%>
<%@page import="com.society.helper.UserDetailsHelper"%>
<%@page import="com.society.utility.HibernateUtility"%>
<%@page import="com.society.utility.PropertiesHelper"%>

 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
   
    <title>Login Page</title>
<script src="/society/staticContent/js/jquery-1.12.3.min.js"></script>
<script src="/society/staticContent/js/logout.js"></script>
    <!-- Bootstrap Core CSS -->
    <link href="/society/staticContent/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/society/staticContent/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/society/staticContent/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/society/staticContent/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- jQuery -->
    <script src="/society/staticContent/js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/society/staticContent/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/society/staticContent/js/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->

    <script src="/society/staticContent/js/sb-admin-2.js"></script>
    
    <!-- for the validations.. -->
    <script src="/society/WebContent/staticContent/js/validations2.js"></script>

	
	<script type="text/javascript">
	
	function back() {
	
		//windows.location = "login.jsp";
		window.location = "/society/jsp/login.jsp"
	}
	
	</script>

<script src="/society/staticContent/js/signUp.js"></script>

</head>
<body background="/society/staticContent/img/SocietyBuilding.jpg">

<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default" style="margin-top: 15px">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign UP</h3>
					</div>
					<div class="panel-body" style="width: 100%">
						<form action="Login" method="post">
							<div>
							
							
							
							<div class="col-md-6 col-md-offset-3 form-group">
									<label><span class="glyphicon glyphicon-user"></span>First name:</label>
									<input class="form-control" placeholder="firstname" name="fname"
										id="fname" type="text" autofocus style="height: 30px" >
								</div>
								
								<div class="col-md-6 col-md-offset-3 form-group">
									<label><span class="glyphicon glyphicon-user"></span>Last name:</label>
									<input class="form-control" placeholder="Lastname" name="lname"
										id="lname" type="text" autofocus style="height: 30px">
								</div>
							
							<div class="col-md-6 col-md-offset-3 form-group">
							<label><span class="glyphicon glyphicon-user"></span>Contact No:</label>
									<input class="form-control" placeholder="Contact No" name="contactNo"
										id="contactNo" maxlength="10" name="contactNo" placeholder="10 digit Contact No." class="form-control input-md"  type="text" autofocus style="height: 30px">
							</div>
							
							<div class="col-md-6 col-md-offset-3 form-group">
							<label><span class="glyphicon glyphicon-user"></span>Pan No:</label>
									<input id="pan" name="pan" placeholder="PAN Number" class="form-control input-md" type="text" required="">
            			</div>
							
							
	           <!-- <label class="col-md-2 control-label" for="contactNo">Contact No.<sup>*</sup></label>  
           	 		<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-earphone"></i>
							</span>
              				<input id="contactNo"  maxlength="10" name="contactNo" placeholder="10 digit Contact No." class="form-control input-md" type="text">
            			</div>
            		</div> -->
            		
            	 	
							
								<div class="col-md-6 col-md-offset-3 form-group">
									<label><span class="glyphicon glyphicon-user"></span>User name:</label>
									<input class="form-control" placeholder="Username" name="uname"
										id="uname" type="text" autofocus style="height: 30px">
								</div>
								
								
								<div class="col-md-6 col-md-offset-3 form-group">
									<label><span class="glyphicon glyphicon-eye-open"></span>Password:</label>
									<input class="form-control" placeholder="Password" name="pass"
										id="pass" type="password" value="" style="height: 30px">
								</div>

							<div class="col-md-6 col-md-offset-3 form-group">
									<label><span class="glyphicon glyphicon-eye-open"></span>Re-Password:</label>
									<input class="form-control" placeholder="Re-Password" name="repass"
										id="repass" type="password" value="" style="height: 30px">
								</div>
								


								<!-- Change this to a button or input when using this as a form -->
							
								
								
								
								<button id="save" type="button" onclick="SignUpDetails()" class="btn btn-md btn-lg btn-success" style="margin-left: 50px">
										<!-- <span class="glyphicon glyphicon-ok-circle"></span> --> Submit
									</button>
								
								
								<button type="reset" class="btn btn-md btn-lg btn-danger" style="margin-left: 10px">
										<!-- <span class="glyphicon glyphicon-remove-circle"></span> --> Reset
									</button>
									
									<button type="back" class="btn btn-md btn-lg btn-success"  style="margin-left: 10px" onclick="back()">
										<!-- <span class="glyphicon glyphicon-remove-circle"></span> --> Back
									</button>
									
								
								
								</div>
							</div>
						</form>
					</div>
				</div>

</body>
</html>

