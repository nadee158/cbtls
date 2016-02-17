 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
 <div class="row">

 <!-- Blog Post Content Column -->
 <div class="col-lg-12">

     <h3 class="page-header"><spring:message code="label.searchTrain"/></h3>

		<form:form id="mainForm" cssClass="form-horizontal" role="form" action="searchTrainAdvanced.htm" onsubmit="return validateForm()" modelAttribute="trainSearchDTO" method="post" >
			  <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label"><spring:message code="label.startStation"/></label>
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
			    <label for="startStation" class="col-sm-2 control-label"><spring:message code="label.endStation"/></label>
			    <div class="col-sm-10">
			    	<select class="form-control" name="endStation" id="endStation">
			    		<c:forEach items="${trainStations}" var="trainStation">
			   	  		 	<option value="${trainStation.trainStationId}">${trainStation.trainStationName}</option>
			   	  		</c:forEach>
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
						    <input type="text" class="date start" name="startDate" style="width: 20%"  />
						    <input type="text" class="time start" name="startTime" style="width: 20%"  /> to
						    <input type="text" class="time end" name="endTime" style="width: 20%"  />
						    <input type="text" class="date end" name="endDate" style="width: 20%"  />
						</p>
				    </div>
				  </div>
				  				  
			  	  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-5">
				      <input type="submit" class="btn btn-primary" value="Search" />
				      <input type="button" class="btn btn-primary"  value="Cancel" onclick="return hideAdvancedFilter()" />
				    </div>
				  </div> 			  	
			  </div>			  			  
			  
		</form:form>
    

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

    // initialize datepair
    $('#datepairExample').datepair();
  });




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
	$('#datepairExample .date').datepicker( "setDate", new Date());
	$('#searchType').val('Next Train');
	$('#mainForm').attr('action','searchTrain.htm');
	$('#mainForm').submit();
}

function loadTodaySchedule(){
	$('#datepairExample .date').datepicker( "setDate", new Date());
	$('#searchType').val('Today Schedule');
	$('#mainForm').attr('action','searchTrain.htm');
	$('#mainForm').submit();
}

</script>
