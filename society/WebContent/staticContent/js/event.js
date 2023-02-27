 function validationEvent()
{
	var eventname = $('#addevent').val();
	var date = $('#date').val();
	var contribution= $('#contribution').val();
    var description= $('#descrip').val();
    
	if(eventname=="" || eventname==null || eventname==undefined)
	{
		alert("Please enter event name");
		return false;
	}
	
	if(date=="" || date==null || date==undefined)
	{
		alert("Please enter date");
		return false;
	}
	
	if(contribution=="" || contribution==null || contribution==undefined || contribution==/^d{10}$/)
	{
		alert("Please enter event contribution");
		return false;
	}
	
	
//	if(description=="" || description==null || description==undefined )
//	{
//		alert("Please enter event description");
//		return false;
//	}
	
	

	eventAdd(); 
	eventList();
}

function eventAdd() {
	
	var eventname = $('#addevent').val();
	var date = $('#date').val();
	var contribution= $('#contribution').val();
    var description= $('#descrip').val();

	var params= {};
	
	params["eventName"] = eventname;
	params["date"] = date;
	params["contribution"] = contribution;
	params["description"] = description;
	
	params["methodName"] = "eventDetails";
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


//get event list
function eventList()
{
	var params= {};

	params["methodName"] = "getEventList";
	$.post('/society/jsp/utility/controller.jsp',params,function(data)
	{		
		$('#list').dataTable().fnClearTable();

		var jsonData = $.parseJSON(data);
		var catmap = jsonData.list;

		$(document).ready(function() {
			$('#list').DataTable( {

				"bPaginate": false,
				

				
				fnRowCallback : function(nRow, aData, iDisplayIndex){
					$("th:first", nRow).html(iDisplayIndex +1);
					return nRow;
				},

				"footerCallback": function ( row, data, start, end, display ) {
					var api = this.api(), data;

					// Remove the formatting to get integer data for summation
					var intVal = function ( i ) {
						return typeof i === 'string' ?
								i.replace(/[\$,]/g, '')*1 :
									typeof i === 'number' ?
											i : 0;
					};

					/*// Total over this page
					pageTotal = api
					.column( 5 )
					.data()
					.reduce( function (a, b) {
						return intVal(a) + intVal(b);
					}, 0 );

					// Update footer
					$( api.column( 5 ).footer() ).html(

							'Rs'+' '+parseFloat(pageTotal).toFixed(2)

					);
					console.log( pageTotal);*/
				},

				destroy: true,
				searching: true,			      
				columns: [
					{"data": "eventName" , "width": "5%" ,"defaultContent": ""},
			          {"data": "date" , "width": "10%" ,"defaultContent": ""},
			          {"data": "contribution" , "width": "10%" ,"defaultContent": ""},
			          {"data": "description" , "width": "10%" ,"defaultContent": ""},
			         
		          ],
				          
				          dom : 'Bfrtip',
				          buttons : [ 
				                     { extend: 'copyHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Event Details Report";
				                    	 }, },
				                     { extend: 'excelHtml5', footer: true,
					                    	 title : function() {
					                    		 return "Event Details Report";
					                    	 }, },
				                     { extend: 'csvHtml5', footer: true,
						                    	 title : function() {
						                    		 return "Event Details Report";
						                    	 }, },
				                     { extend : 'pdfHtml5', footer: true,
				                    	 title : function() {
				                    		 return "Event Details Report";
				                    	 },
				                    	 orientation : 'landscape',
				                    	 pageSize : 'LEGAL',
				                    	 titleAttr : 'PDF' 
				                     }]
					} );
				});

		
		var mydata = catmap;
		$('#list').dataTable().fnAddData(mydata);
			}).error(function(jqXHR, textStatus, errorThrown){
				if(textStatus==="timeout") {
					$(loaderObj).hide();
					$(loaderObj).find('#errorDiv').show();
				}
			
			});
}

function eventMemberValidation()
{
	var eventName= $('#fk_member_id').val();

	if(eventName=="" || eventName==null)
	{
		alert("Please Select event");
		return false;
	}
	getDetailsOfMwmber();
}


function getDetailsOfMwmber()
{
//	$("#buildingName").append($("<input/>").attr("value","").text());
	$("#wingName").append($("<input/>").attr("value","").text());
//	$("#floorNo").append($("<input/>").attr("value","").text());
//	$("#flatNo").append($("<input/>").attr("value","").text());
	
	var params= {};
	
	var input1 = document.getElementById('fk_member_id'),
	list = document.getElementById('memeberNameList'),
	i,fkMemberid;
	for (i = 0; i < list.options.length; ++i)
	{
		if (list.options[i].value === input1.value) 
		{
			fkMemberid = list.options[i].getAttribute('data-value');
		}
	}
	
	params["fkMemberid"] = fkMemberid;
	
	params["methodName"] = "getEventContribution";

	$.post('/society/jsp/utility/controller.jsp',params,function(data)
			{
				var jsonData = $.parseJSON(data);
				var catmap = jsonData.list;
	
				$.each(jsonData,function(i,v)
			{
				  document.getElementById("buildingName").value = v.buildingName;
			      document.getElementById("wingName").value = v.wingName;
			      document.getElementById("floorNo").value = v.floorNo;
			      document.getElementById("flatNo").value = v.flatNo;
			      
			});
		}).error(function(jqXHR, textStatus, errorThrown){
			if(textStatus==="timeout") {

			}
		});
			
}

