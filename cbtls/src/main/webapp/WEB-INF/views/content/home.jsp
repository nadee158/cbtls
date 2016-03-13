 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
 <div class="row">

 <!-- Blog Post Content Column -->
 <div class="col-lg-12">

     <h3 class="page-header"><spring:message code="label.searchTrain"/></h3>

		<form:form id="mainForm" cssClass="form-horizontal" role="form" action="searchTrainAdvanced.htm" onsubmit="return validateForm()" modelAttribute="trainSearchDTO" method="post" >
			  <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label">Train Line</label>
			    <div class="col-sm-10">
			    	<select class="form-control" id="trainLine" onchange="loadTrainStations(this.value)">
			    	</select>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label"><spring:message code="label.startStation"/></label>
			    <div class="col-sm-10">
			    	<select class="form-control" name="startStation" id="startStation">
			    	</select>
			    	<input type="hidden" name="startStationName" id="startStationName" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label"><spring:message code="label.endStation"/></label>
			    <div class="col-sm-10">
			    	<select class="form-control" name="endStation" id="endStation">
			    	</select>
			    	<input type="hidden" name="endStationName" id="endStationName" />
			    </div>
			  </div>
			  <div class="form-group" id="midButtonPanel">
				<label class="col-md-3 control-label"></label>
					<div class="col-md-8">
						<input class="btn btn-primary" onclick="loadNextTrain()" value='<spring:message code="label.nextTrain"/>' type="button">
						<span></span>
						<input class="btn btn-primary" onclick="loadTodaySchedule()" value='<spring:message code="label.todaySchedule"/>' type="button">
						<span></span>
						<input class="btn btn-primary" onclick="showAdvancedFilter()" value='<spring:message code="label.advancedFilter"/>' type="button">
					</div>
		      </div>
		      <input type="hidden" name="searchType" id="searchType" />
			  <div id="advancedFilter" style="display: none;">
			  
				  <div class="form-group">
				    <label for="datepicker" class="col-sm-2 control-label">Pick a Date and time</label>
				    <div class="col-sm-10">
					    <p id="datepairExample">
						    <input type="text" id="startDate" class="date start" name="startDate" style="width: 20%"  />
						    <input type="text" id="startTime" class="time start" name="startTime" style="width: 20%"  /> to
						    <input type="text" id="endTime" class="time end" name="endTime" style="width: 20%"  />
						    <input type="text" id="endDate" class="date end" name="endDate" style="width: 20%"  />
						</p>
				    </div>
				  </div>
				  				  
			  	  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-5">
				      <input type="button" class="btn btn-primary" onclick="advancedSerch()" value="Search" />
				      <input type="button" class="btn btn-primary"  value="Cancel" onclick="return hideAdvancedFilter()" />
				    </div>
				  </div> 			  	
			  </div>			  			  
			  
		</form:form>
    
		<input type="hidden" id="hiddenpicker"/>
 </div>

 

</div>
<!-- /.row -->
<script type="text/javascript">
$(function() {
    $('#datepairExample .time').timepicker({
        'showDuration': true,
        'timeFormat': 'g:ia'
    });

    $('#datepairExample .date').datepicker({
        'format': 'dd/mm/yyyy',
        'autoclose': true
    });

    $('#hiddenpicker').timepicker({
        timeFormat: 'H:i:s',
    });

    // initialize datepair
    $('#datepairExample').datepair();

    loadTrainLines();
  });

function loadTrainLines(){
	$('#trainLine').append('<option value="0">Select</option>')
	$.getJSON( "listTrainLines.json", function( data ) {
		var appendText='';
		$(data).each(function(index,item) {
			appendText=appendText + '<option value="' + item.trainLineId + '">' + item.trainLineName + '</option>';
	    });
		$('#trainLine').append(appendText);
	});
}


function loadTrainStations(trainLineId){
	if(!(trainLineId<=0)){
		$('#startStation').append('<option value="0">Select</option>');
		$('#endStation').append('<option value="0">Select</option>');
		
		$.getJSON( "listTrainStationsByTrainLine.json",{trainLineId : trainLineId}, function( data ) {
			var appendText='';
			$(data).each(function(index,item) {
				appendText=appendText + '<option value="' + item.trainStationId + '">' + item.trainStationName + '</option>';
		    });
			$('#startStation').append(appendText);
			$('#endStation').append(appendText);
		});
	}
}

function showAdvancedFilter(){
	$('#advancedFilter').show();
	$('#midButtonPanel').hide();
}

function hideAdvancedFilter(){
	$('#advancedFilter').hide();
	$('#midButtonPanel').show();
}

function validateForm(){
	$('#startStationName').val($("#startStation option:selected").text());
	$('#endStationName').val($("#endStation option:selected").text());
	return true;
}

function loadNextTrain(){
	var fromStationId=parseInt($.trim($('#startStation').val()));
	var toStationId=parseInt($.trim($('#endStation').val()));
	if(!(fromStationId==0 || toStationId==0)){
		if(!(fromStationId==toStationId)){
			// in dd/MM/yyyy
			var searchedDate=$.datepicker.formatDate('dd/mm/yy', new Date());
			// in HH:mm
			
			$('#hiddenpicker').timepicker('setTime', new Date());
			var fromTime=$('#hiddenpicker').val();
			// in HH:mm
			var toTime="23:59:59";
			searchTrainSchedule(fromStationId, toStationId, searchedDate, fromTime, toTime);
			
		}else{
			alert('From and To Stations cant be same!');
		}
	}else{
		alert('Please select from station and to station!');
	}
	
	

	//$('#datepairExample .date').datepicker( "setDate", new Date());
	//$('#searchType').val('Next Train');
	//$('#mainForm').attr('action','searchTrain.htm');
	//$('#mainForm').submit();
}

function advancedSerch(){
	
}

function searchTrainSchedule(fromStationId,toStationId,searchedDate,fromTime,toTime){
	var trainScheduleSearchDTO=new TrainScheduleSearchDTO(fromStationId,toStationId,searchedDate,fromTime,toTime);
	 	$.ajax({
	        url: 'searchTrainSchedules.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(trainScheduleSearchDTO),
	        dataType: 'json',
	        success: function (data) {
				console.log(data);
		    }
	    });
}

function TrainScheduleSearchDTO(fromStationId,toStationId,searchedDate,fromTime,toTime){
	this.fromStationId=fromStationId;
	this.toStationId=toStationId;
	this.searchedDate=searchedDate;
	this.fromTime=fromTime;
	this.toTime=toTime;
}

function loadTodaySchedule(){
	$('#datepairExample .date').datepicker( "setDate", new Date());
	$('#searchType').val('Today Schedule');
	$('#mainForm').attr('action','searchTrain.htm');
	$('#mainForm').submit();
}

</script>
