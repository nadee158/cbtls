<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">View Current Compartment Details</h1>
  <div class="row">
		<div class="col-lg-12">
			<div class="form-group">
				  <div class="col-md-4">
					<label class="control-label">Total Compartments :- </label>
				  </div>
				  <div class="col-md-3">
					<label class="control-label">10 (Approximate Average)</label>
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
					    <tbody>
					      <tr>
					        <td>2</td>
					        <td><button class="btn btn-danger active" type="button">
							  <span class="badge">High</span>
							</button>
						  	</td>
					      </tr>
					      <tr>
					        <td>3</td>
					        <td><button class="btn btn-danger active" type="button">
							  <span class="badge">High</span>
							</button></td>
					      </tr>
					      <tr>
					        <td>6</td>
					        <td><button class="btn btn-warning active" type="button">
							  <span class="badge">Medium</span>
							</button></td>
					      </tr>
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
					<label class="control-label"><button class="btn btn-danger active" type="button">
							  <span class="badge">High</span>
							</button></label>
				  </div>
	        </div>
		</div>
		<div class="col-lg-12">
			<div class="form-group">
					<div class="col-md-4">
					<label class="control-label">&nbsp;</label>
				  </div>
				  <div class="col-md-8">
					<label class="control-label">Above Details Are based on 5 Feedbacks</label>
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
		
		
		
	</div>
    
  </div>
  	<form action="viewTrainLocation.htm" id="viewTrainLocation" method="post"></form>
    
<script type="text/javascript">
function goBack(){
	$('#viewTrainLocation').submit();
	
}
</script>
