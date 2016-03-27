 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<div class="container" style="padding-top: 0px;">
	<h3 class="page-header">Update Train Location - (I am in the train)</h3>
	<h4 id="demo"></h4>
	<form id="mainForm" class="form-horizontal" role="form" action="searchTrainAdvanced.htm" onsubmit="return validateForm()" method="post" >
			  <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label">Previous Station</label>
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
			    <label for="startStation" class="col-sm-2 control-label">Current Status of Train</label>
			    <div class="col-sm-10">
			    	<select class="form-control" name="trainStatus" id="trainStatus">
			   	  		 	<option value="1">In the Station</option>
			   	  		 	<option value="2">On the Move</option>
			   	  		 	<option value="3">Stopped</option>
			    	</select>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="mapdiv" class="col-sm-2 control-label">Current Location</label>
			    <div class="col-sm-10">
			    	<div id="mapholder" style="width: 600px;height: 300px;"></div>
			    </div>
			  </div>
			  <div class="form-group" id="midButtonPanel">				
					<div class="col-md-12">
						<input class="btn btn-primary" onclick="updateTrainLocationOnce()" value="Update Once" type="button"/>
						<span></span>
						<input class="btn btn-primary" onclick="updateAndTrackTrain()" value="Update And Track Train" type="button"/>
						<span></span>
						<input class="btn btn-primary" value="Update Compartment Details" onclick="updateCompartmentDetails()" type="button"/>
						<span></span>
						<input class="btn btn-primary" value="Set Alarm Clock" onclick="setNotificationAlarm()"  type="button"/>
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
<form action="getUpdateCompartmentDetails.htm" id="updateCompartmentDetails" method="post"></form>
<form action="getNotificationAlarm.htm" id="setNotificationAlarm" method="post"></form>
 <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>   
<script type="text/javascript">
$(function() {
	var trainLineId=$('#trainLineId').val();
	loadTrainStations(trainLineId);
	getLocation();
});

function goBack(){
	$('#viewTrainScheduleDetails').submit();
	
}

function updateCompartmentDetails(){
	$('#updateCompartmentDetails').submit();
}

function setNotificationAlarm(){
	$('#setNotificationAlarm').submit();
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

function updateTrainLocationOnce(){
	updateTrainLocation();
}
//every 5 mins
function updateAndTrackTrain(){
	setInterval(updateTrainLocation, (((1*1000)*60)*5));
}

function ActiveTrainLocationUpdateDTO(trainStationScheduleId,latitude,longitude,trainScheduleId,lastStationId,locatedType){
	this.trainStationScheduleId=trainStationScheduleId;
	this.latitude=latitude;
	this.longitude=longitude;
	this.trainScheduleId=trainScheduleId;
	this.lastStationId=lastStationId;
	this.locatedType=locatedType;
}

function updateTrainLocation(){
	var trainStationScheduleId=$('#trainStationScheduleId').val();
	var latitude=$('#latitude').val();
	var longitude= $('#longitude').val();
	var trainScheduleId=$('#trainScheduleId').val();
	var lastStationId=$('#startStation').val();
	if(lastStationId==0){
		alert('Please select a station!');
		return false;
	}
	var locatedType=$('#trainStatus').val();
	var dto=new ActiveTrainLocationUpdateDTO(trainStationScheduleId, latitude, longitude, trainScheduleId, lastStationId, locatedType);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'activeUpdateTrainLocation.json',
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

    var coords = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    
    var options = {
      zoom: 15,
      center: coords,
      mapTypeControl: false,
      navigationControlOptions: {
      	style: google.maps.NavigationControlStyle.SMALL
      },
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("mapholder"), options);

    var marker = new google.maps.Marker({
        position: coords,
        map: map,
        title:"You are here!"
    });
   
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
