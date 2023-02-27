<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.society.helper.MemberMonthlyContributionCostHelper"%>
<%@page import="com.society.dao.MemberMonthlyContributionCostDao"%>
<%@page import="com.society.hibernate.UserDetailasHibernate"%>
<%@page import="com.society.utility.HibernateUtility"%>
<%@page import="com.society.hibernate.UserDetailsBean"%>
<%@page import="com.society.utility.PropertiesHelper"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ page contentType="text/html; charset=utf-8" language="java" %>

 --%>
<% 
   String abc = "english";
   if (session != null) {
   
   if (session.getAttribute("lan") != null) {
	   abc = (String) session.getAttribute("lan");
   }}
   else{
	   abc="english";
   }
 %>

<% String  contextPath=request.getContextPath(); %>
<% String path=""; if(isHome)path="JSP\\"; %>
<%@page import="org.hibernate.Session"%>

<%@page import="java.util.List"%>
<%@ page session="true"%>
<html>


<% 
 
 			 		 String type1= "";
                     String name1 = "";
		             if (session != null) {
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
<meta name="viewport" content="width=device-width , initial-scale=1">
<title>Embel Technologies Pvt Ltd.</title>
<script src="/society/staticContent/js/logout.js"></script>

<script type="text/javascript" src="/society/staticContent/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/society/staticContent/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/society/staticContent/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/society/staticContent/css/style.css" />
<link href="/staticContent/css/popUp.css" rel="stylesheet" type="text/css"/>

<!----------------------- Offline glyphicons used for footer.jsp-------------------------------------------------------- -->

<link href="/society/staticContent/css/bootstrap.css" rel="stylesheet">
<link href="/society/staticContent/css/bootstrap.min.css" rel="stylesheet">
<link href="/society/staticContent/css/bootstrap-theme.css" rel="stylesheet">
<link href="/society/staticContent/css/bootstrap-theme.min.css" rel="stylesheet">

	<!--  <link rel="shortcut icon" sizes="1800x1800" href="/society/staticContent/img/logo.jpg"/> -->

	<!-- <img src="/society/staticContent/img/Embel.jpg"/> -->


<!-- Font awesome (social icon) -->
<link href="/society/staticContent/css/font-awesome.css" rel="stylesheet">
<link href="/society/staticContent/css/font-awesome.min.css" rel="stylesheet">

<script type="text/javascript" src="/society/staticContent/js/bootstrap.js"> </script>
<script type="text/javascript" src="/society/staticContent/js/bootstrap.min.js"> </script>
<script type="text/javascript" src="/society/staticContent/js/jquery.min.js"> </script>

<!-- this js file is used to shortcut  -->

<script type="text/javascript"
	src="/society/staticContent/js/shortcut.js"> </script>

<link
	href="/society/staticContent/fonts/glyphicons-halflings-regular.eot">
<link
	href="/society/staticContent/fonts/glyphicons-halflings-regular.svg">
<link
	href="/society/staticContent/fonts/glyphicons-halflings-regular.ttf">
<link
	href="/society/staticContent/fonts/glyphicons-halflings-regular.woff">
<link
	href="/society/staticContent/fonts/glyphicons-halflings-regular.woff2">

<!-- Font awesome (social icon) -->
<link href="/society/staticContent/fonts/fontawesome-webfont.eot">
<link href="/society/staticContent/fonts/fontawesome-webfont.svg">
<link href="/society/staticContent/fonts/fontawesome-webfont.ttf">
<link href="/society/staticContent/fonts/fontawesome-webfont.woff">
<link href="/society/staticContent/fonts/fontawesome-webfont.woff2">
<link href="/society/staticContent/fonts/FontAwesome.otf">

<!------------------------------------------ Shortcut.jsp styles -------------------------------------------------->

<script type="text/javascript"
	src="/society/staticContent/js/bootstrap.js"> </script>
<script type="text/javascript" src="/society/staticContent/js/bootstrap.min.js"> </script>
<link href="/society/staticContent/css/bootstrap.css" rel="stylesheet">
<link href="/society/staticContent/css/bootstrap.min.css" rel="stylesheet">
<link href="/society/staticContent/css/bootstrap-theme.css" rel="stylesheet">
<link href="/society/staticContent/css/bootstrap-theme.min.css" rel="stylesheet">

<!-------------------------------- header style -------------------------------------------------------------------------------------------------------->

<link rel="stylesheet" href="/society/staticContent/css/font-awesome.min.css">
<script src="/society/staticContent/js/prefixfree.min.js"></script>
<script src="/society/staticContent/js/modernizr.min.js"></script>

	<script src="/society/staticContent/js/logout.js"></script>


 			


<style>

@import
	url(http://fonts.googleapis.com/css?family=roboto:400,400italic,600,700,800)
	;

*, html, body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre,
	form, label, fieldset, input, p, blockquote, th, td {
	margin: 0;
	padding: 0;
}

article, aside, figure, footer, header, hgroup, nav, section {
		display: block;
}


* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

html {
	-webkit-font-smoothing: antialiased;
}

a {
	color: #BA0707;
	text-decoration: none;
}

a:hover {
	color: #BA0707;
}

body {
	color: #E95546;
	font: 14px "roboto", Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	line-height: 1;
	width: 100%;
}

nav {
	display: block;
	background: #8c7674
	
}

.menu {
	display: block;
}

.menu li {
	display: inline-block;
	position: relative;
	z-index: 100;
}

.menu li:first-child {
	margin-left: 0;
}

.menu li a {
	font-weight: 600;
	text-decoration: none;
	padding: 20px 15px;
	display: block;
	color: #fff;
	transition: all 0.2s ease-in-out 0s;
}

.menu li a:hover, .menu li:hover>a {
	color: #fff;
	background: cadetblue;
}

.menu ul {
	visibility: hidden;
	opacity: 0;
	margin: 0;
	padding: 0;
	width: 170px;
	position: absolute;
	left: 0px;
	background: #fff;
	z-index: 99;
	transform: translate(0, 20px);
	transition: all 0.2s ease-out;
}

.menu ul:after {
	bottom: 100%;
	left: 20%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
	border-color: rgba(255, 255, 255, 0);
	border-bottom-color: #fff;
	border-width: 6px;
	margin-left: -6px;
}

.menu ul li {
	display: block;
	float: none;
	background: none;
	margin: 0;
	padding: 0;
}

.menu ul li a {
	font-size: 15px;
	font-weight: bold;
	display: block;
	color: #797979;
	background: #fff;
}

.menu ul li a:hover, .menu ul li:hover>a {
	background: #FC6D58;
	color: #fff;
}

.menu li:hover>ul {
	visibility: visible;
	opacity: 1;
	transform: translate(0, 0);
}

.menu ul ul {
	left: 169px;
	top: 0px;
	visibility: hidden;
	opacity: 0;
	transform: translate(20px, 20px);
	transition: all 0.2s ease-out;
}

.menu ul ul:after {
	left: -6px;
	top: 10%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
	border-color: rgba(255, 255, 255, 0);
	border-right-color: #fff;
	border-width: 6px;
	margin-top: -6px;
}

.menu li>ul ul:hover {
	visibility: visible;
	opacity: 1;
	transform: translate(0, 0);
}

.responsive-menu {
	display: none;
	width: 100%;
	padding: 20px 15px;
	background: #E95546;
	color: #fff;
	text-transform: uppercase;
	font-weight: 600;
}

.responsive-menu:hover {
	background: #E95546;
	color: #fff;
	text-decoration: none;
}

a.homer {
	background: #ab8da0;
	 background-color:black;
	}

@media ( min-width : 768px) and (max-width: 979px) {
	.mainWrap {
		width: 768px;
	}
	.menu ul {
		top: 37px;
	}
	.menu li a {
		font-size: 12px;
	}
	a.homer {
		 background: #E95546; 
		
	}
}

@media ( max-width : 767px) {
	.mainWrap {
		width: auto;
		padding: 50px 20px;
	}
	.menu {
		display: none;
	}
	.responsive-menu {
		display: block;
	}
	nav {
		margin: 0;
		background: none;
	}
	.menu li {
		display: block;
		margin: 0;
	}
	.menu li a {
		background: #fff;
		/* color: #797979; */
	}
	.menu li a:hover, .menu li:hover>a {
		background: #8c7674;
		color: #fff;
	}
	.menu ul {
		visibility: hidden;
		opacity: 0;
		top: 0;
		left: 0;
		width: 100%;
		transform: initial;
	}
	.menu li:hover>ul {
		visibility: visible;
		opacity: 1;
		position: relative;
		transform: initial;
	}
	.menu ul ul {
		left: 0;
		transform: initial;
	}
	.menu li>ul ul:hover {
		transform: initial;
	}
}	
.scroll-bar-bar{

height: 950%;
  width: 100vh;
  border: 1px solid grey;
  font-family: "montserrat", sans-serif;
  overflow: auto; 

}
.navbar{
background-color:black;
}
	
</style>
</head>


<body style="margin-bottom: 125px;">

	<nav class="navbar navbar-fixed-top"> <a id="resp-menu"
		class="responsive-menu" href="#"><i class="fa fa-reorder"></i></a>
	<ul class="menu">

		<li><a class="homer" href="#"><i class="fa fa-home"></i>HOME</a></li>
 
		<li><a href="<%=path%>MemberDetails.jsp"><i class="fa fa-address-book-o"></i>Administration</a>
			 <ul class="sub-menu scroll-bar-bar">
				<li><a href="<%=path%>MemberDetails.jsp" accesskey="t">Member Details</a></li>
				<li><a href="<%=path%>VendorDetails.jsp" accesskey="t">Vendor Details</a></li>
				<li><a href="<%=path%>EmployeeDetails.jsp" accesskey="t">Employee Details</a></li>
				<li><a href="<%=path%>Complaint_Enquiry.jsp" accesskey="t">Complaint/Enquiry</a></li>
				<li><a href="<%=path%>PurchaseOrderCreate.jsp" accesskey="t">Purchase Order</a></li>
			<%-- 	<li><a href="<%=path%>Quotation.jsp" accesskey="t">Quotation Details</a></li> --%>
				<li><a href="<%=path%>PurchaseOrderRecive.jsp" accesskey="t">Received PO</a></li>
				<li><a href="<%=path%>expenditureAndSubExpenditure.jsp" accesskey="t">Expenditure Details</a></li>
				<li><a href="<%=path%>VisitorForm.jsp" accesskey="t">Visitor Details</a></li>
				<li><a href="<%=path%>ServentDetails.jsp" accesskey="t">Servent Details</a></li>
				<li><a href="<%=path%>EmployeeLeave.jsp" accesskey="t">Employee Leave</a></li>
				
				<li><a href="<%=path%>userDetails.jsp" accesskey="t">User Details</a></li>
			    <li><a href="<%=path%>accessControl.jsp" accesskey="t">Access Control</a></li>
			    
			    <li><a href="<%=path%>Events.jsp" accesskey="t">Events</a></li>
				
			</ul>
		</li>
		
	   <li><a href="<%=path%>MemberMonthlyContributionCost.jsp"><i class="fa fa-rupee"></i> Maintenance</a>
		<ul class="sub-menu">
			    <li><a href="<%=path%>MemberMonthlyContributionCost.jsp" accesskey="t">Member Monthly Contribution Cost</a></li>
			    <li><a href="<%=path%>CorpusFund.jsp" accesskey="t">Corpus Fund</a></li>
			    <li><a href="<%=path%>AMC.jsp" accesskey="t">AMC</a></li>
			    
			    <%-- <li><a href="<%=path%>annualMaintenance.jsp" accesskey="t">Annual Maintenance</a></li>
			    <li><a href="<%=path%>annualMaintenanceGeneration.jsp" accesskey="t">Annual Maintenance Contract</a></li> --%>
			    
			</ul>
		</li>
		
		<li><a href="<%=path%>CahBankBook.jsp"><i class="fa fa-address-book-o"></i>CashBook</a>
			<%-- <ul class="sub-menu">
				<li><a href="<%=path%>CahBankBook.jsp" accesskey="t">CashBook Details</a></li>
				
			</ul> --%>
		</li>
		
		<li><a href="<%=path%>Billing.jsp"><i class="fa fa-address-book-o"></i>Billing</a>
			<%-- <ul class="sub-menu">
				<li><a href="<%=path%>Billing.jsp" accesskey="t">Billing Details</a></li>
			</ul> --%>
		</li>
		
		<li><a href="<%=path%>MemberDetailsReport.jsp"><i class="fa fa-address-book-o"></i>Reports</a>
			<ul class="sub-menu">
			    <li><a style="padding: 10px 15px;" href="<%=path%>MemberDetailsReport.jsp" accesskey="t">Member Details Report</a></li>
			    <li><a style="padding: 10px 15px;" href="<%=path%>maintenanceReport.jsp" accesskey="t">Maintenance Report</a></li>
			    <li><a style="padding: 10px 15px;" href="<%=path%>AMCReport.jsp" accesskey="t">AMC Report</a></li>
			    <li><a style="padding: 10px 15px;" href="<%=path%>PurchaseOrderCreateReport.jsp" accesskey="t">Purchase Order Report</a></li>
			    <li><a style="padding: 10px 15px;" href="<%=path%>AllPaymentReports.jsp" accesskey="t">CashBook Report</a></li>
			    <li><a style="padding: 10px 15px;" href="<%=path%>EmployeeLeaveReport.jsp" accesskey="t">Employee Leave Report</a></li>
			    <li><a style="padding: 10px 15px;" href="<%=path%>AllVisitorReport.jsp" accesskey="t">All Visitor Report</a></li>
			    <li><a style="padding: 10px 15px;" href="<%=path%>VreportsBetweenTwoDates.jsp" accesskey="t">Visitor Report Between Two Dates</a></li>
			    <%-- <li><a style="padding: 10px 15px;" href="<%=path%>ClientEnquiryReport.jsp" accesskey="t">Client Enquiry Details Report</a></li> --%>
				<%-- <li><a style="padding: 10px 15px;" href="<%=path%>EmployeePaymentReport.jsp" accesskey="t">Employee Payment Report</a></li> --%>
				<%-- <li><a style="padding: 10px 15px;" href="<%=path%>ExpenditurePaymentReport.jsp" accesskey="t">Expenditure Payment Report</a></li> --%>
				<%-- <li><a style="padding: 10px 15px;" href="<%=path%>PurchaseOrderReceiveReport.jsp" accesskey="t">Received PO Report</a></li> --%>
<%-- 				 <li><a style="padding: 10px 15px;" href="<%=path%>QuotationReport.jsp" accesskey="t">Quotation Report</a></li> --%>			
 			    <%-- <li><a style="padding: 10px 15px;" href="<%=path%>ClientFollowUpReport.jsp" accesskey="t">Client FollowUp Report</a></li> --%>
			    <%-- <li><a style="padding: 10px 15px;" href="<%=path%>ClientPaymentReport.jsp" accesskey="t">Client Payment Report</a></li> --%>
			    <%-- <li><a style="padding: 10px 15px;" href="<%=path%>PreviousEmployeeDetailsReport.jsp" accesskey="t">Previous Employee Details Report</a></li> --%>
				
				
			</ul>
		</li>
		
		<li><a href="<%=path%>Notice_Circular.jsp"><i class="fa fa-certificate"></i>Circular/Notice</a>
		<ul class="sub-menu">
		 	    <li><a href="<%=path%>Notice_Circular.jsp" accesskey="t">Circular/Notice</a></li> 
			 <%--  <li><a href="<%=path%>ExperienceLetter.jsp" accesskey="t">Experience Letter</a></li>--%>
			 
			 <!-- create new page in circular notice for events then pass path -->
			     <li><a href="<%=path%>EventCircular.jsp" accesskey="t">Events/Functions</a></li> 
			</ul> 
		</li>

		<li><a href="#" onclick="Logout()"><i class="glyphicon glyphicon-log-out"></i>Logout</a></li>
</ul>
	</nav>

	<script src="/society/staticContent/js/jquery-2.1.3.min.js"></script>
	<script>
$(document).ready(function(){ 
	var touch 	= $('#resp-menu');
	var menu 	= $('.menu');
 
	$(touch).on('click', function(e) {
		e.preventDefault();
		menu.slideToggle();
	});
	
	$(window).resize(function(){
		var w = $(window).width();
		if(w > 767 && menu.is(':hidden')) {
			menu.removeAttr('style');
		}
	});
	
});
</script>
	<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

	<!-- header end -->