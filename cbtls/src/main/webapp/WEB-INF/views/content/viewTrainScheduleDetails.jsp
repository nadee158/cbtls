<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">Train Schedule Details</h1>
  <div class="row">
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Expected Time of Arrival(ETA) at Station 1 :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">10.30 a.m</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Expected Time of Arrival(ETA) at Station 2 :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">11.00 a.m</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Total Distance of Journey :-</label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">11 km</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Total Duration of Journey :-</label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">30 Mins</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Train Type :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">Long Distance</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Train Frequency :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">Daily</label>
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
					<input class="btn btn-primary" value="Add to Favorites" type="button">
					<span></span>
					<input class="btn btn-primary" value="Search Again"  onclick="serchAgain()" type="button">
				 
	        </div>
		</div>
		
		
		
	</div>
    
  </div>
  	<form action="activeUpdateLocation.htm" id="activeUpdateLocation" method="post"></form>
  	<form action="passiveUpdateLocation.htm" id="passiveUpdateLocation" method="post"></form>
    <form action="viewTrainScheduleDetails.htm" id="viewTrainScheduleDetails" method="post"></form>
    <form action="viewAnalysisOfTrain.htm" id="viewAnalysisOfTrain" method="post"></form>
    <form action="viewTrainLocation.htm" id="viewTrainLocation" method="post"></form>
    
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
</script>