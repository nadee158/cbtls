 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<div class="container" style="padding-top: 0px;">
	<h3 class="page-header">Set Notification Alarm</h3>
	
	<form id="mainForm" class="form-horizontal" role="form" action="searchTrainAdvanced.htm" onsubmit="return validateForm()" method="post" >
			 <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label">Select Destination Station</label>
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
			    <label for="startStation" class="col-sm-3 control-label">Select An Option</label>
			    <div class="col-sm-7">
			    	<div class="radio">
					  <label><input type="radio" name="optradio">Set Distance to Ring Alarm</label>
					</div>
					<div class="radio">
					  <label><input type="radio" name="optradio">Ring Alarm Before 1 Station</label>
					</div>
					<div class="radio disabled">
					  <label><input type="radio" name="optradio" disabled>Ring Alarm at the Station</label>
					</div>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="startStation" class="col-sm-3 control-label">Distance to set Alarm(in Km)</label>
			    <div class="col-sm-7">
			    	<input type="text" class="form-control" value="0" name="distanceToSetAlarm" id="distanceToSetAlarm" />
			    </div>
			  </div>			  
			  
			  <div class="form-group" id="midButtonPanel">	
			  		<label for="startStation" class="col-sm-3 control-label">&nbsp;</label>			
					<div class="col-sm-7">
						<input class="btn btn-primary" value="Set Alarm" type="button"/>
						<span></span>
						<input class="btn btn-primary" value="Go Back" onclick="goBack()" type="button"/>
					</div>
		      </div>
	 </form>
	


</div>
<form action="activeUpdateLocation.htm" id="activeUpdateLocation" method="post"></form>
<script type="text/javascript">
$(function() {

    $('#"distanceToSetAlarm"').bootstrapNumber({

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