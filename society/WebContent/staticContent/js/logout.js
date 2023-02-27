function Logout()
{
	var params = {};
	params["methodName"] = "logout";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{   
		alert("Logged Out Successfully!!!");
		
				window.location.replace("/society/jsp/login.jsp");
			}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}


/*function login()
{
	var uname = $("#uname").val();
	var pass = $("#pass").val();
	var params = {};

	params["uname"] = uname;.
	params["pass"] = pass;
	params["methodName"] = "login";

	
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			
			{   
				//alert("login Successfully!!!");
				window.location.replace("/society/jsp/EmployeeDetails.jsp");
			}
	
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}*/

function login()
{	
	document.getElementById("save").disabled=true;
	
	var uname = $("#uname").val();
	var pass = $("#pass").val();
	var params = {};

	params["uname"] = uname;
	params["pass"] = pass;
	params["methodName"] = "login";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{
		document.getElementById("save").disabled=false;
		window.location.replace("/society/jsp/MemberDetails.jsp");
	}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});
}



function signUp() {	
	window.location = "/society/jsp/SignUp.jsp";
}

