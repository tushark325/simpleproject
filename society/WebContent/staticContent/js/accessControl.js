//fetch username and password from userDetails
function getUserDetails(){
	var params= {};
	var name= $('#EmpName').val();
	
	var userId=name.split(",")[0];
	var username=name.split(",")[1];


	$("#userName").append($("<input/>").attr("value","").text());
	$("#password").append($("<input/>").attr("value","").text());
	
	
	params["userId"]= userId;
	//params["empname"]= empname;
	params["methodName"] = "getUserDetailsToAccessControl";

	$.post('/society/jsp/utility/controller.jsp',params,function(data){

		var jsonData = $.parseJSON(data);
		var moduleData;
		var catmap = jsonData.list;
		$.each(jsonData,function(i,v)
				{
			document.getElementById("userName").value = v.userName;
			document.getElementById("password").value = v.password;
//			document.getElementById("shopname").value = v.shopName;
			moduleData =v.module;
			const moduleInfo = moduleData.split(",");
			Checkbox(moduleInfo);
				});
	}).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {

		}
	});

}

function Checkbox(moduleInfo)
{
	const ModuleData = moduleInfo;

	var modvalue = new Array();
	$(document).ready(function() {

	  $("input:checkbox[name=mod]").each(function() {
		  modvalue.push($(this).val());
	  });

	  });
	
	for(i=0;i<=modvalue.length-1;i++)
		{
		for(j=0;j<=moduleInfo.length-1;j++)
			{
				if(modvalue[i]==moduleInfo[j])
				{
					var module= modvalue[i];
					 document.getElementById(module).checked = true;
				}
			}
		 }
}




//save Access Control
function AddAccessControlDetails(){

	document.getElementById("save").disabled = true;
	
	//var EmpName = $('#EmpName').val();
	//var employeeName = EmpName.split(",")[1];
	
	var userName = $('#userName').val();
	var password = $('#password').val();
	
	
	var module = AddModule();

	var params = {};



	//params["EmpName"] =employeeName;
	params["userName"] =userName;
	params["password"] =password;
	params["module"]=module;

	params["methodName"] = "AddAccessControl";
	
	$.post('/society/jsp/utility/controller.jsp',params,function(data) 			 	    	
		{
		  alert("Data Added Successfully !");
		
		if(document.cstd)
		{
			document.cstd.reset();
			document.getElementById("savebtnbtn").disabled = true;
		}
	}
	).error(function(jqXHR, textStatus, errorThrown){
		if(textStatus==="timeout") {
			$(loaderObj).hide();
			$(loaderObj).find('#errorDiv').show();
		}
	});

}

//Get the mChecked Module data from screen

function AddModule()
{
	
	var selected = new Array();

	$(document).ready(function() {

	  $("input:checkbox[name=mod]:checked").each(function() {
	       selected.push($(this).val());
	  });

	});
	
	let module = selected.toString();
	return module;
	}
