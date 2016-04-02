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
					<input class="btn btn-primary" onclick="provideFeedBack()" value="Provide Feed Back" type="button">
					<span></span>
					<input class="btn btn-primary" value="Search Again"  onclick="serchAgain()" type="button">
				 
	        </div>
		</div>
		
		<input type="hidden" id="trainLineId" value="${trainStationScheduleDTO.trainLineDTO.trainLineId}" />
		<input type="hidden" id="trainStationScheduleId" value="${trainStationScheduleDTO.trainStationScheduleId}" />
		<input type="hidden" id="trainScheduleId" value="${trainStationScheduleDTO.trainSchedule.trainScheduleId}" />
		
	</div>
    
  </div>
  	<form action="getActiveUpdateLocation.htm" id="activeUpdateLocation" method="post"></form>
  	<form action="getPassiveUpdateLocation.htm" id="passiveUpdateLocation" method="post"></form>
    <form action="viewTrainScheduleDetails.htm" id="viewTrainScheduleDetails" method="post"></form>
    <form action="getViewAnalysisOfTrain.htm" id="viewAnalysisOfTrain" method="post"></form>
    <form action="getViewTrainLocation.htm" id="viewTrainLocation" method="post"></form>
     <form action="getFavourites.htm" id="getFavourites" method="post"></form>
     
     
     <!-- Trigger the modal with a button -->
  	<button type="button" id="btn_modal_open" style="display: none;" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">
  		Open Modal
  	</button>

	  <!-- Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog">
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Provide Feedback on Train schedule</h4>
	        </div>
	        <div class="modal-body">
	          <table class="table">
	          	<tr>
	          		<td><label for="rating" class="control-label">Rate Train schedule<span id="userNameDiv"></span></label></td>
	          		<td>
						<input id="rating" class="rating rating-loading" data-show-clear="false" data-show-caption="true" data-min="0" data-max="5" data-step="1">
						<input type="hidden" id="userIdHidden" />
	          		</td>
	          	</tr>
	          	<tr>
	          		<td><label for="rating" class="control-label">Comment</label></td>
	          		<td>
		          		<textarea rows="5" cols="60" id="comment"></textarea>
	          		</td>
	          	</tr>
	          </table>
	        </div>
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" onclick="updateRankSchedule()">Update</button>
	          	<button type="button" id="modal_close" class="btn btn-primary" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
    <script src='<c:url value="/js/star-rating.js" />' type="text/javascript"></script>
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

function provideFeedBack(){
	
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


function provideFeedBack(){
	$('#btn_modal_open').click();
}

function TrainScheduleCommentDTO(trainScheduleId,trainStationScheduleId,rating,comment){
	this.trainScheduleId=trainScheduleId;
	this.trainStationScheduleId=trainStationScheduleId;
	this.rating=rating;
	this.comment=comment;
}



function updateRankSchedule(){
	var trainStationScheduleId=$('#trainStationScheduleId').val();
	var trainScheduleId=$('#trainScheduleId').val();
	var rating=parseInt($('#rating').val());
	var comment=$('#comment').val();
	
	var dto=new TrainScheduleCommentDTO(trainScheduleId,trainStationScheduleId,rating,comment);

	 $.ajax({
	        url: 'saveComment.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.RESULT=='success' || data.RESULT=='SUCCESS'){
					alert('Rating is successfully submitted. Thank you!');					
				}else{
					alert('Could not submit rating, Please try again')
				}
				$('#modal_close').click();
		    }
	    });

	
}


</script>
