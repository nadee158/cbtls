 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<div class="container" style="padding-top: 0px;">
	<h3 class="page-header">Update Train Location - (I am in the train)</h3>
	
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
			  <div class="form-group" id="midButtonPanel">				
					<div class="col-md-12">
						<input class="btn btn-primary" value="Update Once" type="button"/>
						<span></span>
						<input class="btn btn-primary" value="Update And Track Train" type="button"/>
						<span></span>
						<input class="btn btn-primary" value="Update Compartment Details" onclick="updateCompartmentDetails()" type="button"/>
						<span></span>
						<input class="btn btn-primary" value="Set Alarm Clock" onclick="setNotificationAlarm()"  type="button"/>
						<span></span>
						<input class="btn btn-primary" value="Go Back" onclick="goBack()" type="button"/>
					</div>
		      </div>
	 </form>
	


</div>
<form action="viewTrainScheduleDetails.htm" id="viewTrainScheduleDetails" method="post"></form>
<form action="updateCompartmentDetails.htm" id="updateCompartmentDetails" method="post"></form>
<form action="setNotificationAlarm.htm" id="setNotificationAlarm" method="post"></form>
    
<script type="text/javascript">
function goBack(){
	$('#viewTrainScheduleDetails').submit();
	
}

function updateCompartmentDetails(){
	$('#updateCompartmentDetails').submit();
}

function setNotificationAlarm(){
	$('#setNotificationAlarm').submit();
}


</script>
