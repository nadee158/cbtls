 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<div class="container" style="padding-top: 0px;">
	<h3 class="page-header">Update Compartment Details</h3>
	
	<form id="mainForm" class="form-horizontal" role="form" action="searchTrainAdvanced.htm" onsubmit="return validateForm()" method="post" >
			 <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Compartment Number</label>
			    <div class="col-sm-7">
			    	<input type="text" class="form-control" value="0" name="compartmentNumber" id="compartmentNumber" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Total Compartments</label>
			    <div class="col-sm-7">
			    	<input type="text" class="form-control" value="0" name="totalCompartments" id="totalCompartments" />
			    </div>
			  </div>			  
			  <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Crowd Density of Compartment</label>
			    <div class="col-sm-7">
			    	<select class="form-control" name="trainStatus" id="trainStatus">
			   	  		 	<option value="1">Low</option>
			   	  		 	<option value="2">Medium</option>
			   	  		 	<option value="3">High</option>
			   	  		 	<option value="3">Very High</option>
			    	</select>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Overall Crowd Density</label>
			    <div class="col-sm-7">
			    	<select class="form-control" name="trainStatus" id="trainStatus">
			   	  		 	<option value="1">Low</option>
			   	  		 	<option value="2">Medium</option>
			   	  		 	<option value="3">High</option>
			   	  		 	<option value="3">Very High</option>
			    	</select>
			    </div>
			  </div>
			  <div class="form-group" id="midButtonPanel">	
			  		<label for="startStation" class="col-sm-3 control-label">&nbsp;</label>			
					<div class="col-sm-7">
						<input class="btn btn-primary" value="Update" type="button"/>
						<span></span>
						<input class="btn btn-primary" value="Go Back" onclick="goBack()" type="button"/>
					</div>
		      </div>
	 </form>
	


</div>
<form action="activeUpdateLocation.htm" id="activeUpdateLocation" method="post"></form>
<script type="text/javascript">
$(function() {

    $('#compartmentNumber').bootstrapNumber({

    	// default, danger, success , warning, info, primary
    	upClass: 'danger',
    	downClass: 'success',
    	center: true
     });

    $('#totalCompartments').bootstrapNumber({

    	// default, danger, success , warning, info, primary
    	upClass: 'danger',
    	downClass: 'success',
    	center: true
     });

  });

function goBack(){
	$('#activeUpdateLocation').submit();
	
}
 </script>