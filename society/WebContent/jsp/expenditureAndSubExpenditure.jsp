<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.society.hibernate.Complaint_EnquiryHibernate"%>
<%@page import="com.society.dao.Complaint_EnquiryDao"%>
<%@page import="java.util.Date"%>

<%@page import="com.society.hibernate.MemberDetailsHibernate"%>
<%@page import="com.society.dao.MemberDetailsDao"%>

<%@page import="com.society.dao.ExpenditureDetailsDao"%>
<%@page import="java.util.List"%>
<%@page import="com.society.hibernate.ExpenditureDetailsBean"%>
<%@page import="com.society.dao.ExpenditureDetailsDao"%>



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

        
        	<script type="text/javascript"src="/society/staticContent/js/expenditureDetails.js"></script>
        
        
        <script type="text/javascript">
          		 function complaint_EnquiryList()
          		 {
          		 	window.location = "Complaint_EnquiryList.jsp";
          		 }
          		</script> 
        
        
        <script type="text/javascript">
          		 function clientResponseList()
          		 {
          		 	window.location = "clientResponseList.jsp";
          		 }
          		</script> 
          		
          		<script type="text/javascript">
					function editClientEnquiry()
					{
						window.location = "EditClientEnquiry.jsp";

					}

          		</script>
          		<script type="text/javascript">
					function subExpList()
					{
						window.location="expenditureAndSubExpenditureList.jsp";
					}
					
					function expList()
					{
						window.location="addExpenditureList.jsp";
					}
          		</script>
          		
          		<script type="text/javascript"src="/society/staticContent/js/expenditureDetails.js"></script>


        <script type="text/javascript">	
		function cheakForExpenditure(){
			<%
				ExpenditureDetailsDao exp = new ExpenditureDetailsDao();
					List cList1 =exp.getAllExpenseNames();
			%>
			var expenditureName = $('#expenseName').val();
    		var upExpenditureName = expenditureName.toUpperCase();
    		var duplicate;
			<%
			for(int i=0;i< cList1.size();i++){
				ExpenditureDetailsBean cat=(ExpenditureDetailsBean)cList1.get(i);
			%>
			var subCat = "<%=cat.getExpenseName()%>";
			var subcatName=document.getElementById("expenseName").value;
			var UpValue = subCat.toUpperCase();
			if(upExpenditureName == UpValue)
			{
					duplicate = "found";
			}
			if(subcatName == subCat){
				alert("Expenditure already exist...Duplicate Not allowed");
				location.reload();
				return false;
			}
			<%
			}
			%>
			if(duplicate == "found"){
    			document.expenseDetails.btn.disabled = true;	
				alert("Expenditure Name Already Exist..!!!");
				location.reload();
				document.expenseDetails.btn.disabled = false;
    			return false;
    		}
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
		    if (charCode!=32 && (charCode < 65 || charCode > 90) && (charCode < 97 || charCode > 122)) {
		        return false;
		    }
		    return true;
			}


		</script>
		
	<style>
		.leftmanu
		{
		    width: 190px;
		    background: #c50000a6;
		    color:  white;
		}
	</style>

</head>
<body>
<div class="container-fluid" > 
<div class="row" style="min-height:300px;">
    <div  class="col-md-12">
        <h3>Left Tabs</h3>
        <hr/>
        <div class="col-md-2">
            <ul class="nav nav-tabs">
                <li class="active"><a class="leftmanu" href="#enquiry" data-toggle="tab">Add Expenditure</a></li>
                <li><a class="leftmanu" href="#response" data-toggle="tab">Add Sub Expenditure</a></li>
            </ul>
        </div>
				<div class="col-xs-9">
					<!-- Tab panes -->
					<div class="tab-content">
					
  <!-------------------------Add Expenditure ------------------------>
					
	<div class="tab-pane active" id="enquiry">
		<form class="form-horizontal" method="post" action="" name="expenseDetails">
		<!-- Value of 'name' attribute is used in customerDetails.js  -->
		<fieldset>
		
		
				<div class="row header_margin_top">
					<div align="center">
						<h2 class="form-name style_heading">Expenditure Details</h2>
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
				
			<div class="row form-group">
				<label class="col-md-3 control-label" for="expenseName">Expenditure Name<sup>*</sup>
				</label>
				<div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="	glyphicon glyphicon-hand-right"></i>
						</span>
						<%
							ExpenditureDetailsDao cdd = new ExpenditureDetailsDao();
           						List cList =cdd.getAllExpenseNames();
							%>
						<input list="cat_drop" id="expenseName" class="form-control" onchange="cheakForExpenditure()">
						<datalist id="cat_drop">
							<%
					           for(int i=0;i<cList.size();i++){
					        	   ExpenditureDetailsBean cat=(ExpenditureDetailsBean)cList.get(i);
							%>
							<option data-value="<%=cat.getPkExpenseDetailsId()%>"
								value="<%=cat.getExpenseName()%>">
								<%
				      			}
				    		%>
							
						</datalist>
					</div>
				</div>
			</div>
		<div class="form-group row">
			<div class="col-md-10 text-center">
				<input type="button" id="save" name="btn" style="font-size: 25" class="btn btn-success btn-lg btnn " onclick="addExpenseDetails()" value="Submit"> 
				<input id="save" name="btn" style="font-size: 25" class="btn btn-danger btn-lg btnn" type="reset" onclick="reset()" value="Cancel">
				<input type="button" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="expList()" value="List">
				</div>
			</div>
		</fieldset>
	</form>
	</div>


	
	<!------------------------ Add Sub Expenditure ---------------->
	
       <div class="tab-pane" id="response">
		<form class="form-horizontal" method="post" action="" name="clientResponseForm">
			<div class="row">
			    <div align="center">
			  		<h2 class="form-name style_heading">Sub Expenditure</h2>
			  	</div>

				  </div>
<!-- 				  
				  <div class="row">
					<div class="form-group" align="right">
						<div class="col-sm-offset-6 col-md-5 control-label">
							<div id="date2">
								<label id="demo2"></label>
								<script>
									   var date2 = new Date();
									   document.getElementById("demo2").innerHTML = date2.toDateString();
									</script>
							</div>
						</div>
					</div>
				</div> -->
				
				
		     	<div class="row">
				     <div class="col-sm-offset-1 col-md-10">
						<hr style="border-top-color:#c1b1b1;">
				     </div>	
		   		 </div>
		   		 
	<div class="row">	    
 		<div class="row form-group">
		<label class="col-md-2 control-label" for="employeename" style="text-align:  right;">Expenditure Name:<sup>*</sup>
					</label>
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
							<%
								ExpenditureDetailsDao cdd2 = new ExpenditureDetailsDao();
           						List cList2 =cdd2.getAllExpenseNames();
							%>
						<input list="cat_drop2" id="expenseName2" class="form-control">
						<datalist id="cat_drop2">
							<%
					           for(int i=0;i<cList2.size();i++){
					        	   ExpenditureDetailsBean cat=(ExpenditureDetailsBean)cList2.get(i);
							%>
							<option data-value="<%=cat.getPkExpenseDetailsId()%>"
								value="<%=cat.getExpenseName()%>">
								<%
				      			}
				    		%>
							</datalist>
						</div>
					</div>
					
					<label class="col-md-2 control-label" for="employeename" style="text-align:  right;">Sub Expenditure Name:<sup>*</sup>
					</label>
					
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
							<input type="text" id="subExpenditure" placeholder="Enter sub expenditure" class="form-control">
						</div>
					</div>
					

       			</div> 
		</div>
		
		
		<div class="row">	    
		 		<div class="row form-group">
				<label class="col-md-2 control-label" for="employeename" style="text-align:  right;">Description:<sup>*</sup>
				</label>
					<div class="col-md-8">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-hand-right"></i>
							</span>
							<textarea id="description" name="description" class="form-control" placeholder="Enter description" rows="3" cols="15"></textarea>
						</div>
					</div>
       			</div> 
		</div>
		
		

				<div class="container" align="center" style=" margin-left: -100px;">
				<input type="button" class="btn btn-success btn-lg btnn" value="Save" name="btn2" onclick="validateSubExpenditure()"> 
				<input type="button" class="btn btn-danger btn-lg btnn" value="Cancel" name="btn2" onclick="location.reload()">
				<input type="button" value="List" id="listBtn" class="btn btn-primary btn-lg btnn" onclick="subExpList()">
				
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