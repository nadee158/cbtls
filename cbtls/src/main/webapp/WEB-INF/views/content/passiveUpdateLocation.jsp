 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<div class="container" style="padding-top: 0px;">
	<h3 class="page-header">Update Train Location - (I am outside the train)</h3>
	<h4 id="demo"></h4>
	<form id="mainForm" class="form-horizontal" role="form" action="searchTrainAdvanced.htm" onsubmit="return validateForm()" method="post" >
			  <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label">Last Station Passed</label>
			    <div class="col-sm-10">
			    	<select class="form-control" name="startStation" id="startStation">
			    		<c:forEach items="${trainStations}" var="trainStation">
			   	  		 	<option value="${trainStation.trainStationId}">${trainStation.trainStationName}</option>
			   	  		</c:forEach>
			    	</select>
			    	<input type="hidden" name="startStationName" id="startStationName" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label">Select Located time</label>
			    <div class="col-sm-10">
			    	<p id="datepairExample">
			    		<input type="text" class="time start" name="startTime" id="startTime" />
			    	</p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label">Current Status of Train</label>
			    <div class="col-sm-10">
			    	<select class="form-control" name="trainStatus" id="trainStatus">
			   	  		 	<option value="1">In the Station</option>
			   	  		 	<option value="2">On the Move</option>
			   	  		 	<option value="3">Stopped</option>
			    	</select>
			    </div>
			  </div>
			  <div class="form-group" id="midButtonPanel">				
					<div class="col-md-12">
						<input class="btn btn-primary" onclick="updateTrainLocation()" value="Update Location" type="button"/>
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
<form action="viewTrainScheduleDetails.htm" id="viewTrainScheduleDetails" method="post"></form>
<script type="text/javascript">
$(function() {
    $('#datepairExample .time').timepicker({
        'showDuration': true,
        'timeFormat': 'g:i a'
    });

    var trainLineId=$('#trainLineId').val();
	loadTrainStations(trainLineId);
	getLocation();

});

function goBack(){
	$('#viewTrainScheduleDetails').submit();
}

function loadTrainStations(trainLineId){
	if(!(trainLineId<=0)){
		$('#startStation').html('<option value="0">Select</option>');
		
		$.getJSON( "listTrainStationsByTrainLine.json",{trainLineId : trainLineId}, function( data ) {
			var appendText='';
			$(data).each(function(index,item) {
				appendText=appendText + '<option value="' + item.trainStationId + '">' + item.trainStationName + '</option>';
		    });
			$('#startStation').append(appendText);
		});
	}
}

function updateTrainLocation(){
	var trainStationScheduleId=$('#trainStationScheduleId').val();
	var latitude=$('#latitude').val();
	var longitude= $('#longitude').val();
	var trainScheduleId=$('#trainScheduleId').val();
	var lastStationId=$('#startStation').val();
	var locatedTime=$('#startTime').val();
	if(lastStationId==0){
		alert('Please select a station!');
		return false;
	}
	var locatedType=$('#trainStatus').val();
	var dto=new PassiveTrainLocationUpdateDTO(trainStationScheduleId, latitude, longitude, trainScheduleId, lastStationId, locatedType,locatedTime);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'passiveUpdateTrainLocation.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.RESULT=='success' || data.RESULT=='SUCCESS'){
					alert('Train location was successfully updated! Thank you.')
					$('#viewTrainScheduleDetails').submit();
				}else{
					alert('Could not update the train location! Please try later.')
				}
		    }
	    });
	
}

function PassiveTrainLocationUpdateDTO(trainStationScheduleId,latitude,longitude,
		trainScheduleId,lastStationId,locatedType,locatedTime){
	this.trainStationScheduleId=trainStationScheduleId;
	this.latitude=latitude;
	this.longitude=longitude;
	this.trainScheduleId=trainScheduleId;
	this.lastStationId=lastStationId;
	this.locatedType=locatedType;
	this.locatedTime=locatedTime;
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