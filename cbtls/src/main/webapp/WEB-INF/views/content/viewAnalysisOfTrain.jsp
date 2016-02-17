<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">View Analysis of Train</h1>
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
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Average Delay Past Ten Days :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">10 min</label>
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
					  <span class="badge">High</span>
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
					  1st Class <span class="badge">250</span>
					</button>
					<button class="btn btn-primary active" type="button">
					  2nd Class <span class="badge">120</span>
					</button>
					<button class="btn btn-primary active" type="button">
					  3rd Class <span class="badge">35</span>
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
		
		
		
		
		
	</div>
    
  </div>
    <form action="viewTrainScheduleDetails.htm" id="viewTrainScheduleDetails" method="post"></form>
    
<script type="text/javascript">
function goBack(){
	$('#viewTrainScheduleDetails').submit();
	
}



</script>
