// validation for corpus fund
function validationCorpusFund()
{
	var amount = $('#amount').val();
	
	if(amount=="" || amount==null || amount==undefined)
	{
		alert("Please enter amount");
		return false;
	}
	
	addCorpusFund(); 
}

function addCorpusFund()
{
	var amount = $('#amount').val();
	var date2 = $('#date2').val();

	var params= {};
	
	params["amount"] = amount;
	params["date2"] = date2;
	
	params["methodName"] = "addCorpusFundDetails";
 	$.post('/society/jsp/utility/controller.jsp',params,function(data)
 	    	{
 				alert(data);
 				location.reload();
 				/*if(document.clientEnqForm)
 				{
 					document.clientResponseForm.reset();
 					
 				}*/
 				//location.reload();
 				document.clientEnqForm.btn.disabled =false;
 			}
 	    	).error(function(jqXHR, textStatus, errorThrown){
 	    		if(textStatus==="timeout") {
 	    			$(loaderObj).hide();
 	    			$(loaderObj).find('#errorDiv').show();
 	    		}
 	    	});
 	
	
}