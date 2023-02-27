 <%--<%@page import="com.society.hibernate.shopDetailsBean"--%>
<%--<%@page import="com.society.dao.shopDetailsDao"--%>

<%@page import="com.society.dao.UserDetailsDao"%>
<%@page import="com.society.utility.PropertiesHelper"%>
<%@page import="com.society.hibernate.UserDetailsBean"%>
<%@page import="com.society.helper.UserDetailsHelper"%>
<%@page import="com.society.utility.HibernateUtility"%>
<%--<%@page import="com.society.hibernate.shopDetailsBean"--%>
<%@page import="com.society.hibernate.UserDetailasHibernate"%>

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
				//response.sendRedirect("processSoft/WebContent/jsp/login.jsp");
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
					 //   document.getElementById("btn").disabled = true;	
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

<!-- <script type="text/javascript" src="/AgriSoft/staticContent/js/userDetails.js"></script> -->
<script type="text/javascript" src="/society/staticContent/js/accessControl.js"></script>
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
 
 <div class="row header_margin_top">
			    <div class="bill-heading" align="center">
			  		<h2 class="form-name style_heading" style="margin-top: 80px">Access Control</h2>
</div>
 </div>

     <div class="row">
		     <div class="col-sm-offset col-md">
				  		<hr style="border-top-color:#c1b1b1;">
		     </div>	
    </div>
    
      <div class="container "  >
       <div class="col-sm-offset-2">
        <form class="form-horizontal " method="post" action="" name="usd" ><!-- Value of 'name' attribute is used in userDetails.js  -->
          <fieldset>
          		<div class="row form-group">
           	 		<div class="col-md-6">
              			<%@include file="commons/clock.jsp" %>
           		 	</div>
				</div>
		
			 <div class="row form-group">
           		<label class="col-md-2 control-label" for="firstName">Employee Name<sup>*</sup></label>  
		           	 <div class="col-md-3">
            			<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
              				
							 <%
							UserDetailsDao cdd11 = new UserDetailsDao();
           						List cList11 =cdd11.getAllUsers();
							
							%> 
							<input list="EmpName_drop" id="EmpName"  class="form-control" onchange="getUserDetails()">
				<datalist id="EmpName_drop">
							 <%
					           for(int i=0;i<cList11.size();i++){
					        	   UserDetailasHibernate cat11=(UserDetailasHibernate)cList11.get(i);
							%>
		
							<option data-value="<%=cat11.getPkUserDetailsId()%>" value="<%=cat11.getPkUserDetailsId()%>,<%=cat11.getFirstName()%> <%=cat11.getLastName()%>">
							<%
				      			}
				    		%> 
			              	
            			</datalist>
            			</div>
            		</div>

			</div>
			
	
		
			<div class="row form-group">
				<label class="col-md-2 control-label" for="city">User Name<sup>*</sup></label>  
		            <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
	              			<input id="userName" name="userName " placeholder="User Name" class="form-control input-md" type="text" autofocus onchange="return ChooseContact();" readonly="readonly" >
	            		</div>
					</div>
				
				<label class="col-md-2 control-label" for="pan">Password<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i>
							</span>
              				<input id="password" name="password" placeholder="Password" class="form-control input-md" type="text" readonly="readonly">
            			</div>
            		</div>
			</div>
			
			
			<div class="row form-group">
            		
                  <label class="col-md-2 control-label" for="city">Modules :<sup>*</sup></label>  
	               <div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
						</span>
              			  <!-- <select class="form-control" id="type" >
										<option value="selected">--Select Type--</option>
										<option value="admin">Admin</option>
										<option value="deo">DEO</option>
										<option value="finance">Account</option>
										<option value="salesman">Salesman</option>
							</select> -->
						<!-- <input type="checkbox" class="form-control" id="type2"> -->
						   
						
						 <!--  <input type="text" id="modulesBox"/><br> -->
						 
						  
						  <input type="checkbox" id="Master" name="mod" value="Master">
						  <label for="Master"> Administration</label><br>
  						  
  						  <input type="checkbox" id="Purchase" name="mod" value="Purchase">
  						  <label for="Purchase">Maintenance</label><br>
  						  
  						 <!--  <input type="checkbox" id="Packing" name="mod" value="Packing">
  						  <label for="Packing"> Packing</label><br> -->
  						  
  						  <input type="checkbox" id="Billing" name="mod" value="Billing">
  						  <label for="Billing">Billing</label><br>
  						  
  						 <!--  <input type="checkbox" id="Stock" name="mod" value="Stock">
  						  <label for="Stock"> Stock </label><br> -->
  						  
  						  <input type="checkbox" id="Cashbook" name="mod" value="Cashbook">
  						  <label for="Cashbook"> CashBook </label><br>
  						  
  						  <input type="checkbox" id="Reports" name="mod" value="Reports">
						  <label for="Reports"> Reports </label><br>
  						  
  						  <input type="checkbox" id="HR" name="mod" value="HR">
  						  <label for="HR">Circular/Notice </label><br>  
  						  
  						  
				</div>
				</div>
				
					<%-- <label class="col-md-2 control-label" for="shopname">Shop Name<sup>*</sup></label>  
           			 <div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">
							<i
							class="glyphicon glyphicon-home"></i>
							</span>
							
							<%
									shopDetailsDao dao=new shopDetailsDao();
           							List shoplist =dao.getAllShop();
							
							%>
							
              				<input  list="Shop_drop" id="shopname" name="shopname" placeholder="Shop Name" class="form-control input-md" type="text" readonly="readonly"  required>
            			
            				<datalist id="Shop_drop">
            				<%
					           for(int i=0;i<shoplist.size();i++){
					        	   shopDetailsBean bean=(shopDetailsBean)shoplist.get(i);
							%>
		
							<option data-value="<%=bean.getShopId()%>" value="<%=bean.getShopId()%>,<%=bean.getShopName()%>">
							<%
				      			}
				    		%>
			              	
            			</datalist>
            			
            			
            			</div>
            		</div> --%>
				
			</div>
			<br>
			<br>
			
 			<div class="form-group row">
            	<div class="col-md-10 text-center">
            		 <!--  userDetails() function is implemented in  userDetails.js -->
            		
            	     <!-- <input type="button" id="save" name="btn" style="font-size: 20px;width: 100px;
                      height: 40px;padding: 0 10px;" class="btn btn-large btn-success glyphicon glyphicon-save  button-height-width" onclick=" AddAccessControlDetails()"  value="Submit"> -->
                       <input type="button" id="savebtnbtn" name="btn" style="font-size: 20px;width: 100px;
                      height: 40px;padding: 0 10px;" class="btn btn-large btn-success glyphicon glyphicon-save  button-height-width" onclick="AddAccessControlDetails(), reset()"  value="Submit">
		             <input id="save" name="btn" style="font-size: 20px;width: 100px;
                      height: 40px;padding: 0 10px;" class="btn btn-large btn-danger glyphicon glyphicon-remove-circle  button-height-width"  type="reset"  onclick="reset()" value="Cancel">
		             <input id="btn1" name="btn" style="font-size: 20px;width: 100px;
                      height: 40px;padding: 0 10px;" class="btn btn-large btn-success glyphicon glyphicon-remove-circle  button-height-width"  type="reset"  onclick="openLogin()" value="Login">
               <!--       	<input style="font-size: 20; height: 40px; width: 150" type="button" value="User List" id="listBtn" class="btn btn-primary" onclick="userlist()" /> -->
             <!--  	<input style=" font-size: 20;height: 40px; width: 150" type="button" value="Edit" id="listBtn" class="btn btn-primary" onclick="editEmployee()" />  -->
        	 <!--    		  <input type="button" id="btn1"  class="btn btn-large btn-success button-height-width" name="btn1" onclick="userlist()" value="User List">-->
        	  <input type="button" id="listBtn" name="btn" style="font-size: 20px;width: 100px;
                      height: 40px;padding: 1px;" class="btn btn-large btn-success glyphicon glyphicon-save  button-height-width" onclick="userlist()"  value="User List">
		             
        	    </div>
          	</div>
		</fieldset>
      </form>
      </div>
    </div>
      <%
      }else
    
            {
    	       out.println("<span class=\"myspan\">You Can Not view This Page</span>");
    	
            }
    	%> 
<%@include file="commons/newFooter.jsp" %>