<%@page import="com.society.dao.UserDetailsDao"%>

<%@page import="com.society.hibernate.UserDetailasHibernate"%>
<%@page import="com.society.helper.UserDetailsHelper"%>
<%@page import="com.society.utility.HibernateUtility"%>
<%@page import="com.society.utility.PropertiesHelper"%>


<%boolean isHome = false;%>
<%@include file="commons/header.jsp"%>
          		
<%
         String name = "";
		if (session != null) {
			
			if (session.getAttribute("user") != null) {
			    name = (String) session.getAttribute("user");
				out.print("Hello, " + name );
				
				
			} else {
				
				response.sendRedirect("/society/jsp/login.jsp");
			     out.println("Please Login ");
			}
		}
	%>
	<%
	
	
	   HibernateUtility hbu=HibernateUtility.getInstance();
	   Session session1=hbu.getHibernateSession();
	   
	   org.hibernate.Query query = session1.createQuery("from UserDetailasHibernate where userName =:name");
	   query.setParameter("name", name);
	   UserDetailasHibernate userDetail = (UserDetailasHibernate) query.uniqueResult();
	   String type = userDetail.getTypeId();
	   
	   
	
	%>
    
	
	<%
    
      if(type.equals("admin")){
    	  
     %>
<script type="text/javascript">
	    function ChooseContact(){
			//document.getElementById("buyPrice")(data.options[data.selectedIndex].getAttribute("myid"));
			//document.cat.categoryName.value == (data.options[data.selectedIndex].getAttribute("value"));
	
	        <%
	        UserDetailsHelper usrHelper = new UserDetailsHelper();
		   		List usrList = usrHelper.getAlluserName();
			%>
	
			<%
				for(int i=0;i<usrList.size();i++){
					UserDetailasHibernate usr = (UserDetailasHibernate)usrList.get(i);
    		%>

    		var value ="<%=usr.getUserName()%>";
				if(document.getElementById("userName").value == value)
					{
					    document.getElementById("btn").disabled = true;	
						alert("User Name Not Available..Plz Try Another Name!!!");
				        location.reload();
					}
   			<%
				}
    		%>
		}
	</script>

<meta charset="utf-8">
<head>
<script type="text/javascript" src="/society/staticContent/js/userDetails.js"></script>
	<script type="text/javascript">
	
	function openLogin(){
		 window.location = '/society/jsp/login.jsp';
	}
	
	</script>
	
	<script type="text/javascript">
          		 function userlist()
          		 {
          		 window.location = "userList.jsp";
          		 }
          		</script>
	</head>
	<div class="container-fluid">
 <div class="row header_margin_top">
			    <div align="center">
			  		<h2 class="form-name style_heading" style="margin-top: 80px">User Details</h2>
			  	</div>
			  	</div>
			 
    </div>
     <div class="row">
		     <div class="col-sm-offset col-md">
				  		<hr style="border-top-color:#c1b1b1;">
		     </div>	
    </div>
      <div class="container col-sm-offset-2" >
        <form class="form-horizontal" method="post" action="" name="usd"><!-- Value of 'name' attribute is used in userDetails.js  -->
          <fieldset>
          		<div class="row form-group">
           	 		<div class="col-md-6">
              			<%@include file="commons/clock.jsp" %>
           		 	</div>
				</div>
			 <div class="row form-group">
           		<label class="col-md-2 control-label" for="firstName">First Name<sup>*</sup></label>  
		           	 <div class="col-md-3">
            			<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
              				
							<%
							UserDetailsDao cdd11 = new UserDetailsDao();
           						List cList11 =cdd11.getAllUsers();
							
							%>
							<input list="firstName_drop" id="firstName"  class="form-control">
				<datalist id="firstName_drop">
							<%
					           for(int i=0;i<cList11.size();i++){
					        	   UserDetailasHibernate cat11=(UserDetailasHibernate)cList11.get(i);
							%>
		
							<option data-value="<%=cat11.getPkUserDetailsId()%>" value="<%=cat11.getFirstName()%>">
							<%
				      			}
				    		%>
			              	
            			</datalist>
            			</div>
            		</div>

				<label class="col-md-2 control-label" for="lastName">Last Name<sup>*</sup></label>  
           	 		<div class="col-md-3">
            			<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
              				
							<%
							UserDetailsDao cdd1 = new UserDetailsDao();
           						List cList1 =cdd1.getAllUsers();
							
							%>
							<input list="lastName_drop" id="lastName"  class="form-control">
				<datalist id="lastName_drop">
							<%
					           for(int i=0;i<cList1.size();i++){
					        	   UserDetailasHibernate cat1=(UserDetailasHibernate)cList1.get(i);
							%>
		
							<option data-value="<%=cat1.getPkUserDetailsId()%>" value="<%=cat1.getLastName()%>">
							<%
				      			}
				    		%>
			              	
            			</datalist>
            			</div>
            		</div>
				
            	<!-- <label class="col-md-2 control-label" for="middleName"> Middle Name<sup>*</sup></label>  
            		<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
              					<input id="middleName" name="middleName" placeholder="Middle Name" class="form-control input-md" type="text" >
            			</div>
					</div> -->
			</div>
			
			 <div class="row form-group">

	           <label class="col-md-2 control-label" for="contactNo">Contact No.<sup>*</sup></label>  
           	 		<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-earphone"></i>
							</span>
              				<input id="contactNo"  maxlength="10" name="contactNo" placeholder="10 digit Contact No." class="form-control input-md" type="text">
            			</div>
            		</div>
            		
            	 	<div class="row form-group">
			<label class="col-md-2 control-label" for="pan">Re-Password<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							No.
							</span>
              				<input id="password2" name="password2" placeholder="Re-Enter Password" class="form-control input-md" type="text" autofocus  onchange="validatePassword()">
            			</div>
            		</div>
            	
            	 
            	<!--  <label class="col-md-2 control-label" for="address1">Address <sup>*</sup></label>  
	            <div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-map-marker"></i>
						</span>
              			<input id="address1" name="address1 " placeholder="Address Line 1" class="form-control input-md" type="text" >
            		</div>
				</div>-->
			</div>
		
		
			<div class="row form-group">
				
				<label class="col-md-2 control-label" for="city">User Name<sup>*</sup></label>  
		            <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
	              			<input id="userName" name="userName " placeholder="User Name" class="form-control input-md" type="text" autofocus onchange="return ChooseContact();" >
	            		</div>
					</div>
				
				<label class="col-md-2 control-label" for="pan">Password<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							No.
							</span>
              				<input id="password" name="password" placeholder="Password" class="form-control input-md" type="text" >
            			</div>
            		</div>
            		
            		</div>
			
			</div>
		
			<!--  
			<div class="row form-group">
			<label class="col-md-2 control-label" for="pan">Re-Password<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							No.
							</span>
              				<input id="password2" name="password2" placeholder="Re-Enter Password" class="form-control input-md" type="text" autofocus  onchange="validatePassword()">
            			</div>
            		</div>-->
            		
            		
            		 <!--  
            	<label class="col-md-2 control-label" for="city">City<sup>*</sup></label>  
	            <div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-map-marker"></i>
						</span>
              			<input id="city" name="city " placeholder="City" class="form-control input-md" type="text" >
            		</div>
				</div>-->
			
			<div class="row form-group">
				<label class="col-md-2 control-label" for="pan">PAN No.<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							No.
							</span>
              				<input id="pan" name="pan" placeholder="PAN Number" class="form-control input-md" type="text" required="">
            			</div>
            		</div>
            		
                  <label class="col-md-2 control-label" for="city">Type :<sup>*</sup></label>  
	               <div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-map-marker"></i>
						</span>
              			 <select class="form-control" id="typeId">
										<option value="selected">--Select Type--</option>
										<option value="admin">Chairman</option>
										<option value="account">Secretary</option>
										<option value="member">Member</option>
							</select>
            		</div>
				</div>
			
			</div>
			
			<div class="row form-group" style="display:none">
			 <label class="col-md-2 control-label" for="city">Modules :<sup>*</sup></label>  
	               <div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
						</span>
						  
						  <input type="checkbox" id="Master" name="mod" value="none" checked="checked">
						  <label for="Master"> Master</label><br>
  						 
				</div>
				</div>
			</div>
			
 			<div class="form-group row">
            	<div class="col-md-10 text-center">
            		 <!--  userDetails() function is implemented in  userDetails.js -->
            		 
            		 <input style=" height: 40px; width: 150; font-size: 20" type="button" id="btn" name="btn" style="font-size: 20" class="btn btn-large btn-success button-height-width"  onclick="regUserDetails();" value="Submit">
		            <input style=" height: 40px; width: 150; font-size: 20" type="reset" style="font-size: 20" class="btn btn-large btn-danger  button-height-width" id="save" name="btn" value="Cancel" onclick="reset()">
            		 
            	<!-- 	 
    	          <button id="save" name="btn" class="btn btn-large btn-success glyphicon glyphicon-save  button-height-width"  onclick="regUserDetails()"><h4> Submit</h4></button>
              	<button class="btn btn-large btn-danger glyphicon glyphicon-remove-circle  button-height-width" type="reset"  onclick="reset()"><h4> Cancel</h4> </button> -->
        	    <input type="button" id="btn1" style=" height: 40px; width: 150; font-size: 20" class="btn btn-large btn-success button-height-width" name="btn1" onclick="openLogin()" value="Login">
        	    
        	     <input style=" height: 40px; width: 150; font-size: 20" type="button" id="btn4" name="btn4" style="font-size: 20" class="btn btn-large btn-success button-height-width"  onclick="userlist();" value="User List">
        	    
        	    </div>
          	</div>
		</fieldset>
      </form>
    </div>
    
   <%--  <%@include file="commons/newFooter.jsp" %> --%>
    
     <%
      }else
    
            {
    	 
    	  out.println("<span class=\"myspan\">You Can Not view This Page</span>");
    	
          }
    
    	%>
    
<%-- <%@include file="commons/footer.jsp" %> --%>