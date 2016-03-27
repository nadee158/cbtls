 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<div class="container" style="padding-top: 0px;">
	<h3 class="page-header">Update Compartment Details</h3>
	<h4 id="demo"></h4>
	<form id="mainForm" class="form-horizontal" role="form" action="searchTrainAdvanced.htm" onsubmit="return validateForm()" method="post" >
			 <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Compartment Number</label>
			    <div class="col-sm-7">
			    	<input type="text" class="form-control" value="0" name="compartmentNumber" id="compartmentNumber" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Total Compartments</label>
			    <div class="col-sm-7">
			    	<input type="text" class="form-control" value="0" name="totalCompartments" id="totalCompartments" />
			    </div>
			  </div>			  
			  <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Crowd Density of Compartment</label>
			    <div class="col-sm-7">
			    	<select class="form-control" name="compartmentDensity" id="compartmentDensity">
			   	  		 	<option value="1">Low</option>
			   	  		 	<option value="2">Medium</option>
			   	  		 	<option value="3">High</option>
			   	  		 	<option value="3">Very High</option>
			    	</select>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Overall Crowd Density</label>
			    <div class="col-sm-7">
			    	<select class="form-control" name="overallDensity" id="overallDensity">
			   	  		 	<option value="1">Low</option>
			   	  		 	<option value="2">Medium</option>
			   	  		 	<option value="3">High</option>
			   	  		 	<option value="3">Very High</option>
			    	</select>
			    </div>
			  </div>
			  <div class="form-group" id="midButtonPanel">	
			  		<label for="startStation" class="col-sm-3 control-label">&nbsp;</label>			
					<div class="col-sm-7">
						<input class="btn btn-primary" onclick="updateCompartmentDetails()" value="Update" type="button"/>
						<span></span>
						<input class="btn btn-primary" value="Go Back" onclick="goBack()" type="button"/>
					</div>
		      </div>
	 </form>
	
	<input type="hidden" id="trainLineId" value="${trainStationScheduleDTO.trainLineDTO.trainLineId}" />
	<input type="hidden" id="trainStationScheduleId" value="${trainStationScheduleDTO.trainStationScheduleId}" />
	<input type="hidden" id="trainScheduleId" value="${trainStationScheduleDTO.trainSchedule.trainScheduleId}" />
	
	<input type="hidden" id="latitude" />
	<input type="hidden" id="longitude" />


</div>
<form action="getActiveUpdateLocation.htm" id="activeUpdateLocation" method="post"></form>
<script type="text/javascript">
$(function() {

    $('#compartmentNumber').bootstrapNumber({

    	// default, danger, success , warning, info, primary
    	upClass: 'danger',
    	downClass: 'success',
    	center: true
     });

    $('#totalCompartments').bootstrapNumber({

    	// default, danger, success , warning, info, primary
    	upClass: 'danger',
    	downClass: 'success',
    	center: true
     });

  });

function goBack(){
	$('#activeUpdateLocation').submit();
}

function updateCompartmentDetails(){
	var trainStationScheduleId=$('#trainStationScheduleId').val();
	var latitude=$('#latitude').val();
	var longitude= $('#longitude').val();
	var trainScheduleId=$('#trainScheduleId').val();

	var compartmentNumber=$('#compartmentNumber').val();
	var compartmentDensity=$('#compartmentDensity').val();
	var totalCompartments=$('#totalCompartments').val();
	var overallDensity=$('#overallDensity').val();
	
	if(compartmentNumber==0 || compartmentDensity==0 || totalCompartments==0 || overallDensity==0){
		alert('Please enter all required data!');
		return false;
	}
	var dto=new CompartmentDetailUpdateDTO(trainStationScheduleId,latitude,longitude,trainScheduleId,
			compartmentNumber,compartmentDensity,
			totalCompartments,overallDensity);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'updateCompartmentDetails.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.RESULT=='success' || data.RESULT=='SUCCESS'){
					alert('Train compartment details were successfully updated! Thank you.')
					$('#activeUpdateLocation').submit();
				}else{
					alert('Could not update the compartment details! Please try later.')
				}
		    }
	    });
}

function CompartmentDetailUpdateDTO(trainStationScheduleId,latitude,longitude,trainScheduleId,
		compartmentNumber,compartmentDensity,
		totalCompartments,overallDensity){
	this.trainStationScheduleId=trainStationScheduleId;
	this.latitude=latitude;
	this.longitude=longitude;
	this.trainScheduleId=trainScheduleId;
	this.compartmentNumber=compartmentNumber;
	this.compartmentDensity=compartmentDensity;
	this.totalCompartments=totalCompartments;
	this.overallDensity=overallDensity;
	
}

var x = document.getElementById("demo");

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError);
    } else { 
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
}

function showPosition(position) {
   var lat = position.coords.latitude;
   var lon= position.coords.longitude;

   $('#latitude').val(lat);
   $('#longitude').val(lon);
}

function showError(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            x.innerHTML = "User denied the request for Geolocation."
            break;
        case error.POSITION_UNAVAILABLE:
            x.innerHTML = "Location information is unavailable."
            break;
        case error.TIMEOUT:
            x.innerHTML = "The request to get user location timed out."
            break;
        case error.UNKNOWN_ERROR:
            x.innerHTML = "An unknown error occurred."
            break;
    }
}
 </script>