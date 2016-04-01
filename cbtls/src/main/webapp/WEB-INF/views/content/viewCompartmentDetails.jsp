<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">View Current Compartment Details</h1>
  <div class="row">
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Total Compartments :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label"><span id="approximateAvg"></span> (Approximate Average)</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					&nbsp;
				  </div>
				  <div class="col-md-8">
				  	<label class="control-label">Information is available on following compartments only </label>
					<table class="table table-striped">
					    <thead>
					      <tr>
					        <th>Compartment Number</th>
					        <th>Crowd Density</th>
					      </tr>
					    </thead>
					    <tbody id="tableAppend">
					      
					      
					    </tbody>
					  </table>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Overall Crowd Density :-</label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label" id="overallCrowdDensity">
							
					</label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
					<div class="col-md-4">
					<label class="control-label">&nbsp;</label>
				  </div>
				  <div class="col-md-8">
					<label class="control-label">Above Details Are based on <span id="noOfFeedBacks"></span> Feedbacks</label>
				  </div>
	        </div>
		</div>
		<div style="clear: both;"></div>
		
		<hr />
		
		
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-2">
					<input class="btn btn-primary" value="Go Back" onclick="goBack()" type="button">
				  </div>
	        </div>
		</div>
		
		<input type="hidden" id="trainLineId" value="${trainStationScheduleDTO.trainLineDTO.trainLineId}" />
		<input type="hidden" id="trainStationScheduleId" value="${trainStationScheduleDTO.trainStationScheduleId}" />
		<input type="hidden" id="trainScheduleId" value="${trainStationScheduleDTO.trainSchedule.trainScheduleId}" />
	
		
		
		
	</div>
    
  </div>
  	<form action="getViewTrainLocation.htm" id="viewTrainLocation" method="post"></form>
    
<script type="text/javascript">
$(function() {
	viewCompartmentDetails();
});

function goBack(){
	$('#viewTrainLocation').submit();
	
}

function viewCompartmentDetails(){
	var trainStationScheduleId=$('#trainStationScheduleId').val();
	var trainScheduleId=$('#trainScheduleId').val();
	
	var dto=new ViewCompartmentDetailRequestDTO(trainScheduleId,trainStationScheduleId);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'viewCompartmentDetails.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.resultsAvailableStatus=='RESULTS_FOUND' || data.resultsAvailableStatus=='RESULTS_FOUND'){

		        	$('#overallCrowdDensity').html(getcrowdDensity(data.overallCrowdDensity));
		        	$('#noOfFeedBacks').html(data.noOfFeedBacks);
		        	$('#approximateAvg').html(data.totalCompartments);

		        	var appendText='';
		        	
		        	$( data.detailItems ).each(function( index,item ) {
		        		appendText=appendText + '<tr><td>' +item.comaprtmentNumber + '</td><td>';

		        		appendText=appendText + getcrowdDensity(item.crowdDensity);
				        	
			        	appendText=appendText + '</td></tr>'
		        	});
		        	

		        	$('#tableAppend').html(appendText);

					
				}else{
					alert('No data available for this schedule!')
				}
		    }
	    });
}

function getcrowdDensity(crowdDensity){
	if(crowdDensity==1){
		return appendLowButton();
	}else if(crowdDensity==2){
		return appendMediumButton();
	}else if(crowdDensity==3){
		return appendHighButton();
	}else{
		return appendVeryHighButton();
	}
}

function ViewCompartmentDetailRequestDTO(trainScheduleId,trainStationScheduleId){
	this.trainStationScheduleId=trainStationScheduleId;
	this.trainScheduleId=trainScheduleId;
}

function appendHighButton(){
 	return '<button class="btn btn-warning active" type="button"><span class="badge">High</span></button>';
}

function appendVeryHighButton(){
 	return '<button class="btn btn-danger active" type="button"><span class="badge">Very High</span></button>';
}

function appendLowButton(){
 	return '<button class="btn btn-success active" type="button"><span class="badge">Low</span></button>';
}

function appendMediumButton(){
 	return '<button class="btn btn-default active" type="button"><span class="badge">Medium</span></button>';
}
</script>
