 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<div class="container" style="padding-top: 0px;">
	<h3 class="page-header">Set Notification Alarm</h3>
	<h4 id="demo"></h4>
	<form id="mainForm" class="form-horizontal" role="form" action="searchTrainAdvanced.htm" onsubmit="return validateForm()" method="post" >
			 <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label">Select Destination Station</label>
			    <div class="col-sm-10">
			    	<select class="form-control" name="destinationStation" id="destinationStation">
			    		<c:forEach items="${trainStations}" var="trainStation">
			   	  		 	<option value="${trainStation.trainStationId}">${trainStation.trainStationName}</option>
			   	  		</c:forEach>
			    	</select>
			    	<input type="hidden" name="startStationName" id="startStationName" />
			    </div>
			  </div>
			 
			 <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Select An Option</label>
			    <div class="col-sm-7">
			    	<div class="radio">
					  <label><input type="radio" name="alarmType" value="1">Set Distance to Ring Alarm</label>
					</div>
					<div class="radio">
					  <label><input type="radio" name="alarmType" value="2">Ring Alarm Before 1 Station</label>
					</div>
					<div class="radio disabled">
					  <label><input type="radio" name="alarmType" value="3">Ring Alarm at the Station</label>
					</div>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Distance to set Alarm(in Km)</label>
			    <div class="col-sm-7">
			    	<input type="text" class="form-control" value="0" name="distanceToStation" id="distanceToStation" />
			    </div>
			  </div>			  
			  
			  <div class="form-group" id="midButtonPanel">	
			  		<label for="startStation" class="col-sm-3 control-label">&nbsp;</label>			
					<div class="col-sm-7">
						<input class="btn btn-primary" onclick="setAlarm()" value="Set Alarm" type="button"/>
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

    $('#distanceToStation').bootstrapNumber({

    	// default, danger, success , warning, info, primary
    	upClass: 'danger',
    	downClass: 'success',
    	center: true
     });

    var trainLineId=$('#trainLineId').val();
    loadTrainStations(trainLineId);
	//getLocation();

  });

function loadTrainStations(trainLineId){
	if(!(trainLineId<=0)){
		$('#destinationStation').html('<option value="0">Select</option>');
		
		$.getJSON( "listTrainStationsByTrainLine.json",{trainLineId : trainLineId}, function( data ) {
			var appendText='';
			$(data).each(function(index,item) {
				appendText=appendText + '<option value="' + item.trainStationId + '">' + item.trainStationName + '</option>';
		    });
			$('#destinationStation').append(appendText);
		});
	}
}

function setAlarm(){
	var destinationStation=$('#destinationStation').val();
	var alarmType=$('input[name=alarmType]:checked').val();
	var distanceToStation=$('#distanceToStation').val();
	if(destinationStation==0){
		alert('Please select a station!');
		return false;
	}
	var dto=new NotificationAlarmDTO(destinationStation,alarmType,distanceToStation);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'setNotificationAlarm.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.RESULT=='success' || data.RESULT=='SUCCESS'){
					alert('Alarm was successfully set! Thank you.')
					$('#activeUpdateLocation').submit();
				}else{
					alert('Could not set the alarm! Please try later.')
				}
		    }
	    });
}


function NotificationAlarmDTO(destinationStation,alarmType,distanceToStation){
	this.destinationStation=destinationStation;
	this.alarmType=alarmType;
	this.distanceToStation=distanceToStation;
}

function goBack(){
	$('#activeUpdateLocation').submit();
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