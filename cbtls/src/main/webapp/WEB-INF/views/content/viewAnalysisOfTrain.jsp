<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">View Analysis of Train</h1>
  <div class="row">
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Expected Time of Arrival(ETA) at <span id="stationOne"></span> :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label" id="etaAtStation1">10.30 a.m</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Expected Time of Arrival(ETA) at <span id="stationTwo"></span> :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label" id="etaAtStation2">11.00 a.m</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Total Distance of Journey :-</label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label" id="totalDistance">11 km</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Total Duration of Journey :-</label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label" id="duration">30 Mins</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Train Type :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label" id="trainType">Long Distance</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Train Frequency :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label" id="frequency">Daily</label>
				  </div>
	        </div>
		</div>
		<div style="clear: both;"></div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Average Delay Past Ten Days :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label" id="averageDelay">10 min</label>
				  </div>
	        </div>
		</div>
		<div style="clear: both;"></div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Average Crowd Density Past Ten Days :- </label>
				  </div>
				  <div class="col-md-3">
				  <button class="btn btn-danger active" type="button">
					  <span class="badge" id="averageCrowdDensity">High</span>
					</button>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-12">
					&nbsp;
				  </div>
	        </div>
		</div>
		<div style="clear: both;"></div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Ticket Prices :- </label>
				  </div>
				  <div class="col-md-7">
					<button class="btn btn-primary active" type="button">
					  1st Class <span class="badge" id="ticketPriceFirstClass">250</span>
					</button>
					<button class="btn btn-primary active" type="button">
					  2nd Class <span class="badge" id="ticketPriceSecondClass">120</span>
					</button>
					<button class="btn btn-primary active" type="button">
					  3rd Class <span class="badge" id="ticketPriceThirdClass">35</span>
					</button>
				  </div>
	        </div>
		</div>
		<div style="clear: both;"></div>
		
		<hr />
		
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-3">
					<input class="btn btn-primary" value="OK" onclick="goBack()" type="button">
				  </div>
				  <div class="col-md-3">
					
				  </div>
	        </div>
		</div>
		
		<input type="hidden" id="trainLineId" value="${trainStationScheduleDTO.trainLineDTO.trainLineId}" />
		<input type="hidden" id="trainStationScheduleId" value="${trainStationScheduleDTO.trainStationScheduleId}" />
		<input type="hidden" id="trainScheduleId" value="${trainStationScheduleDTO.trainSchedule.trainScheduleId}" />
		
		
		
	</div>
    
  </div>
    <form action="viewTrainScheduleDetails.htm" id="viewTrainScheduleDetails" method="post"></form>
    
<script type="text/javascript">
$(function() {
	viewAnalysisOfTrain();
});

function goBack(){
	$('#viewTrainScheduleDetails').submit();
}

function viewAnalysisOfTrain(){
	var trainStationScheduleId=$('#trainStationScheduleId').val();
	var trainScheduleId=$('#trainScheduleId').val();
	
	var dto=new AnalysisOfTrainrequestDTO(trainScheduleId,trainStationScheduleId);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'viewAnalysisOfTrain.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.status=='RESULTS_FOUND' || data.status=='RESULTS_FOUND'){
		        	$('#etaAtStation1').html(data.etaAtStation1);
		        	$('#etaAtStation2').html(data.etaAtStation2);
		        	$('#totalDistance').html(data.totalDistance);
		        	$('#duration').html(data.duration);
		        	$('#trainType').html(data.trainType);
		        	$('#frequency').html(data.frequency);
		        	$('#averageDelay').html(data.averageDelay);
		        	$('#averageCrowdDensity').html(data.averageCrowdDensity);
		        	$('#ticketPriceFirstClass').html(data.ticketPriceFirstClass);
		        	$('#ticketPriceSecondClass').html(data.ticketPriceSecondClass);
		        	$('#ticketPriceThirdClass').html(data.ticketPriceThirdClass);

		        	$('#stationOne').html(data.stationOne);
		        	$('#stationTwo').html(data.stationTwo);
		        	
		        	
				}else{
					alert('No data available for this schedule!')
				}
		    }
	    });
}

function AnalysisOfTrainrequestDTO(trainScheduleId,trainStationScheduleId){
	this.trainStationScheduleId=trainStationScheduleId;
	this.trainScheduleId=trainScheduleId;
}



</script>
