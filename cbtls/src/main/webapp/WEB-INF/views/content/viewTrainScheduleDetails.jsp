<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">Train Schedule Details</h1>
  <div class="row">
  		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Train Details :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">
						Train no. ${trainStationScheduleDTO.trainSchedule.trainNumber}
						From ${trainStationScheduleDTO.trainSchedule.startStation.trainStationName} 
						to ${trainStationScheduleDTO.trainSchedule.endStation.trainStationName}
					</label>
				  </div>
	        </div>
		</div>
  		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Start Station :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">${trainStationScheduleDTO.fromTrainStation.trainStationName}</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Destination Station :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">${trainStationScheduleDTO.toTrainStation.trainStationName}</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Expected Time of Arrival(ETA) at Start Station :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label"><fmt:formatDate value="${trainStationScheduleDTO.arrivalTime}"  pattern="hh:mm a" /></label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Expected Time of Arrival(ETA) at Destination :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label"><fmt:formatDate value="${trainStationScheduleDTO.arrivalAtDestinationTime}"  pattern="hh:mm a" /></label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Total Distance of Journey :-</label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">${trainStationScheduleDTO.distance} Km</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Total Duration of Journey :-</label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">${trainStationScheduleDTO.duration}</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Train Type :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">${trainStationScheduleDTO.trainSchedule.trainType}</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Train Frequency :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">${trainStationScheduleDTO.trainSchedule.trainFrequency}</label>
				  </div>
	        </div>
		</div>
		<div style="clear: both;"></div>
		
		<hr />
		
		<div class="col-lg-12">
			<div class="form-group">
				  <input class="btn btn-primary" value="Update Train Location(I am in the train)" onclick="activeUpdateLocation()" type="button">
					<span></span>
					<input class="btn btn-primary" value="Update Train Location(I am outside the train)" onclick="passivelyUpdateLocation()" type="button">
					<span></span>
	        </div>
		</div>
		
		
		<div class="col-lg-12">
			<div class="form-group">
				  	<input class="btn btn-primary" value="View Train Location" onclick="viewTrainLocation()" type="button">
					<span></span>
					<input class="btn btn-primary" value="View analysis of the train" onclick="viewAnalysisOfTrain()" type="button">
					<span></span>
					<input class="btn btn-primary" onclick="addToFavourites()" value="Add to Favorites" type="button">
					<span></span>
					<input class="btn btn-primary" value="Search Again"  onclick="serchAgain()" type="button">
				 
	        </div>
		</div>
		
		<input type="hidden" id="trainStationScheduleId" value="${trainStationScheduleDTO.trainStationScheduleId}" />
		
	</div>
    
  </div>
  	<form action="getActiveUpdateLocation.htm" id="activeUpdateLocation" method="post"></form>
  	<form action="getPassiveUpdateLocation.htm" id="passiveUpdateLocation" method="post"></form>
    <form action="viewTrainScheduleDetails.htm" id="viewTrainScheduleDetails" method="post"></form>
    <form action="getViewAnalysisOfTrain.htm" id="viewAnalysisOfTrain" method="post"></form>
    <form action="getViewTrainLocation.htm" id="viewTrainLocation" method="post"></form>
     <form action="getFavourites.htm" id="getFavourites" method="post"></form>
    
<script type="text/javascript">
function activeUpdateLocation(){
	$('#activeUpdateLocation').submit();
	
}


function passivelyUpdateLocation(){
	$('#passiveUpdateLocation').submit();
	
}

function viewRecommendations(){
	$('#viewRecommendations').submit();
}

function viewTrainScheduleDetails(){
	$('#viewTrainScheduleDetails').submit();
}

function viewAnalysisOfTrain(){
	$('#viewAnalysisOfTrain').submit();
}

function viewTrainLocation(){
	$('#viewTrainLocation').submit();
}

function serchAgain(){
	window.location='home.htm';
}

function addToFavourites(){
	var trainStationScheduleId=$('#trainStationScheduleId').val();
	var dto=new FavouriteScheduleDTO(trainStationScheduleId);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'addToFavourite.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.RESULT=='success' || data.RESULT=='SUCCESS'){
					alert('Successfully added to favourites! Thank you.')
					$('#getFavourites').submit();
				}else{
					alert('Could not add to favourites! Please try later.')
				}
		    }
	  });
}

function FavouriteScheduleDTO(trainStationScheduleId){
	this.trainStationScheduleId=trainStationScheduleId;
}
</script>
