  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
 
 
 
 <div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">View Train Analysis</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    
    	<form:form id="mainForm" cssClass="form-horizontal" role="form" action="adminSearchTrain.htm" onsubmit="return validateForm()" modelAttribute="trainSearchDTO" method="post" >
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
			  <div id="advancedFilter">
			  
				  <div class="form-group">
				    <label for="datepicker" class="col-sm-2 control-label">Pick the date range</label>
				    <div class="col-sm-10">
					    <p id="datepairExample">
						    <input type="text" id="startDate" class="date start" name="startDate" style="width: 20%"  />
						    <input type="text" id="endDate" class="date end" name="endDate" style="width: 20%"  />
						</p>
				    </div>
				  </div>
				  				  
			  	  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-5">
				      <input type="button" class="btn btn-primary" onclick="loadSchedules()" value="Search" />
				    </div>
				  </div> 			  	
			  </div>			  			  
			  
		</form:form>
		
		
		
		<div class="col-lg-12" style="max-width: 100%;">	
			<div class="table-responsive" style="max-width: 100%;">
				<table class="table table-bordered table-striped" style="max-width: 100%;">
					<thead>
						<tr>
							<th class="text-center"><strong>Arrival at Station</strong></th>
							<th class="text-center"><strong>Departure from Station</strong></th>
							<th class="text-center"><strong>Arrival at Destination</strong></th>
							<th class="text-center"><strong>Duration(h)</strong></th>	
							<th class="text-center"><strong>View</strong></th>
						</tr>
					</thead>
					<tbody id="appendDiv">
					</tbody>
				</table>
			</div>
		</div>
		
		<div id="canvas-holder1">
		        <canvas id="chart1" height="500" width="600"></canvas>
		</div>
		
		<div id="canvas-holder2">
		        <canvas id="chart2" height="500" width="600"></canvas>
		</div>
		
		<input type="hidden" id="hiddenpicker"/>
		<input type="hidden" id="hiddenpickerOne"/>
		
		 
    
</div>
<!-- /#page-wrapper -->
<script type="text/javascript">
$(function() {
    $('#datepairExample .date').datepicker({
        'format': 'dd/mm/yyyy',
        'autoclose': true
    });

    // initialize datepair
    $('#datepairExample').datepair();

    $('#hiddenpicker').timepicker({
        timeFormat: 'h:i A',
    });

    $('#hiddenpickerOne').timepicker({
        timeFormat: 'h.i',
    });

    loadTrainLines();
  });

function loadTrainLines(){
	$('#trainLine').html('<option value="0">Select</option>')
	$.getJSON( "listTrainLinesAdmin.json", function( data ) {
		var appendText='';
		$(data).each(function(index,item) {
			appendText=appendText + '<option value="' + item.trainLineId + '">' + item.trainLineName + '</option>';
	    });
		$('#trainLine').append(appendText);
	});
}


function loadTrainStations(trainLineId){
	if(!(trainLineId<=0)){
		$('#startStation').html('<option value="0">Select</option>');
		$('#endStation').html('<option value="0">Select</option>');
		
		$.getJSON( "listTrainStationsByTrainLineAdmin.json",{trainLineId : trainLineId}, function( data ) {
			var appendText='';
			$(data).each(function(index,item) {
				appendText=appendText + '<option value="' + item.trainStationId + '">' + item.trainStationName + '</option>';
		    });
			$('#startStation').append(appendText);
			$('#endStation').append(appendText);
		});
	}
}



function AdminSearchDTO(fromStationId,toStationId,searchedFromDate,searchedToDate,trainLineId,trainStationScheduleId){
	this.fromStationId=fromStationId;
	this.toStationId=toStationId;
	this.searchedFromDate=searchedFromDate;
	this.searchedToDate=searchedToDate;
	this.trainLineId=trainLineId;
	this.trainStationScheduleId=trainStationScheduleId;
}

function loadSchedules(){

	var trainLineId=$('#trainLine').val();
	var fromStationId=parseInt($.trim($('#startStation').val()));
	var toStationId=parseInt($.trim($('#endStation').val()));
	var searchedFromDate=$('#startDate').val();
	var searchedToDate=$('#endDate').val();
	var dto=new AdminSearchDTO(fromStationId,toStationId,searchedFromDate,searchedToDate,trainLineId,0);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'searchTrainSchedulesList.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.length){
					//console.log(data);
					var appendText='';
				   $.each(data,function(index,item){
					   $('#hiddenpicker').timepicker('setTime', new Date(item.arrivalTime));
					   var arrivalTime=$('#hiddenpicker').val();

					   $('#hiddenpicker').timepicker('setTime', new Date(item.departureTime));
					   var departureTime=$('#hiddenpicker').val();

					   $('#hiddenpicker').timepicker('setTime', new Date(item.arrivalAtDestinationTime));
					   var arrivalAtDestinationTime=$('#hiddenpicker').val();

					   appendText=appendText + '<tr>'
						 + '<td>' + arrivalTime  + '</td>'
						 + '<td>' +  departureTime + '</td>'
						 + '<td>' + arrivalAtDestinationTime + '</td>'
						 + '<td>' + item.duration + '</td>'
						 + '<td>'
							 + '<input class="btn btn-primary" style="padding: 2px 4px;" value="View" onclick="advancedSerch(' + item.trainStationScheduleId + ')" type="button">'
						 + '</td>'
					 	+ '</tr>';
				   })
					$('#appendDiv').html(appendText);
				   
				}else{
					alert('No data available!.')
				}
		    }
	    });
	
}

var ctx1 = document.getElementById("chart1").getContext("2d");
var ctx = document.getElementById("chart2").getContext("2d");

function advancedSerch(trainStationScheduleId){

	var trainLineId=$('#trainLine').val();
	var fromStationId=parseInt($.trim($('#startStation').val()));
	var toStationId=parseInt($.trim($('#endStation').val()));
	var searchedFromDate=$('#startDate').val();
	var searchedToDate=$('#endDate').val();
	var dto=new AdminSearchDTO(fromStationId,toStationId,searchedFromDate,searchedToDate,trainLineId,trainStationScheduleId);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'searchTrainSchedulesAnalytics.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.status=='RESULTS_FOUND' || data.status=='RESULTS_FOUND'){
					//console.log(data);
					$.each(data.datasets,function(indexOuter,itemOuter){
						$.each(itemOuter.data,function(indexInner,itemInner){
							var incrementVal=indexInner*2;
							$('#hiddenpickerOne').timepicker('setTime', new Date(itemInner));
							var time=$('#hiddenpickerOne').val();
							itemOuter.fillColor='rgba(255,255,255,0)';
							itemOuter.strokeColor = "rgba(" + (220 - incrementVal)  + "," + (220 - incrementVal) + "," + (220 - incrementVal) + ",1)";
							itemOuter.pointColor = "rgba(" + (220 - incrementVal)  + "," + (220 - incrementVal) + "," + (220 - incrementVal) + ",1)";
							
							itemOuter.data[indexInner]=time;
						});
					});
					var myBarChart = new Chart(ctx1).Bar(data, options);
					var myLineChart = new Chart(ctx).Line(data, options);
				}else{
					alert('No data available!.')
				}
		    }
	    });
	
}

var options={
	    //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
	    scaleBeginAtZero : true,

	    //Boolean - Whether grid lines are shown across the chart
	    scaleShowGridLines : true,

	    //String - Colour of the grid lines
	    scaleGridLineColor : "rgba(0,0,0,.05)",

	    //Number - Width of the grid lines
	    scaleGridLineWidth : 1,

	    //Boolean - Whether to show horizontal lines (except X axis)
	    scaleShowHorizontalLines: true,

	    //Boolean - Whether to show vertical lines (except Y axis)
	    scaleShowVerticalLines: true,

	    //Boolean - If there is a stroke on each bar
	    barShowStroke : true,

	    //Number - Pixel width of the bar stroke
	    barStrokeWidth : 2,

	    //Number - Spacing between each of the X value sets
	    barValueSpacing : 5,

	    //Number - Spacing between data sets within X values
	    barDatasetSpacing : 1,

	    bezierCurve : false
	    

	    
	}
</script>