<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<style type="text/css">
#map_canvas{
    width: 600px;
    height: 500px;
}
</style>
<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">View Train Location (current/last known)</h1>
  <div class="row">
		
		
<div >
    
    <div id="map_canvas"></div>

   
  </div>
		
		<hr />
		
		<div class="col-lg-12">
			<div class="form-group">
				<input class="btn btn-primary" value="View Compartment Details" onclick="viewCompartmentDetails()" type="button">
				<span></span>
				<input class="btn btn-primary" value="Go Back" onclick="goBack()" type="button"/>
	        </div>
		</div>
		
		
		
		<input type="hidden" id="trainLineId" value="${trainStationScheduleDTO.trainLineDTO.trainLineId}" />
		<input type="hidden" id="trainStationScheduleId" value="${trainStationScheduleDTO.trainStationScheduleId}" />
		<input type="hidden" id="trainScheduleId" value="${trainStationScheduleDTO.trainSchedule.trainScheduleId}" />
		
		<input type="hidden" id="latitude" />
		<input type="hidden" id="longitude" />
		
	</div>
	
	<!-- Trigger the modal with a button -->
  	<button type="button" id="btn_modal_open" style="display: none;" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">
  		Open Modal
  	</button>

	  <!-- Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog">
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Rate User</h4>
	        </div>
	        <div class="modal-body">
	          <table class="table">
	          	<tr>
	          		<td><label for="rating" class="control-label">Rate User <span id="userNameDiv"></span></label></td>
	          		<td>
						<input id="rating" class="rating-loading" >
						<input type="hidden" id="userIdHidden" />
	          		</td>
	          	</tr>
	          	<tr>
	          		<td><label for="rating" class="control-label">Comment</label></td>
	          		<td>
		          		<textarea rows="5" cols="60" id="comment"></textarea>
	          		</td>
	          	</tr>
	          </table>
	        </div>
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" onclick="updateRankUser()">Update</button>
	          	<button type="button" id="modal_close" class="btn btn-primary" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
    
  </div>
    <form action="viewTrainScheduleDetails.htm" id="viewTrainScheduleDetails" method="post"></form>
    <form action="getViewCompartmentDetails.htm" id="viewCompartmentDetails" method="post"></form>
    
    

<script src="http://maps.google.com/maps/api/js?sensor=false&.js" type="text/javascript"></script>
<script src='<c:url value="/js/star-rating.js" />' type="text/javascript"></script>

<script type="text/javascript">
var map;
var global_markers = [];  
function goBack(){
	$('#viewTrainScheduleDetails').submit();
}

function viewCompartmentDetails(){
	$('#viewCompartmentDetails').submit();
}


$(function() {
	initialize();

	$('#rating').rating({
        step: 1,
        starCaptions: {1: 'Very Poor', 2: 'Poor', 3: 'Ok', 4: 'Good', 5: 'Very Good'},
        starCaptionClasses: {1: 'text-danger', 2: 'text-warning', 3: 'text-info', 4: 'text-primary', 5: 'text-success'}
    });
});



function ViewTrainlocationRequestDTO(trainStationScheduleId,trainScheduleId,trainLineId){
	this.trainStationScheduleId=trainStationScheduleId;
	this.trainScheduleId=trainScheduleId;
	this.trainLineId=trainLineId;
}

function getTrainLocation(){
	var trainStationScheduleId=$('#trainStationScheduleId').val();
	var trainScheduleId=$('#trainScheduleId').val();
	var trainLineId=$('#trainLineId').val();
	var dto=new ViewTrainlocationRequestDTO(trainStationScheduleId, trainScheduleId, trainLineId);
	//alert(JSON.stringify(dto));
	 $.ajax({
	        url: 'viewTrainLocation.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.status=='success' || data.status=='SUCCESS'){
					console.log(data);
					addMarker(data.locationDTOs);
				}else{
					alert(data.message)
				}
				$('#modal_close').click();
		    }
	    });
}

var infowindow = new google.maps.InfoWindow({});

function initialize() {
    geocoder = new google.maps.Geocoder();
    var latlng = new google.maps.LatLng(6.9270801544, 79.861198425);
    var myOptions = {
        zoom: 12,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    getTrainLocation();
    window.setInterval(function () {
    	getTrainLocation();
    }, (100000));
}

function rankUser(updatedUserId){
	//$('#userNameDiv').html(providedUserName);
	$('#userIdHidden').val(updatedUserId);
	$('#btn_modal_open').click();
}

function RankUserDTO(systemUserId,ranking,comment){
	this.systemUserId=systemUserId;
	this.ranking=ranking;
	this.comment=comment;
}

function updateRankUser(){
	var systemUserId=parseInt($('#userIdHidden').val());
	var ranking=parseInt($('#rating').val());
	var comment=$('#comment').val();
	var dto=new RankUserDTO(systemUserId,ranking,comment);

	 $.ajax({
	        url: 'rankUser.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(dto),
	        dataType: 'json',
	        success: function (data) {
		        if(data.RESULT=='success' || data.RESULT=='SUCCESS'){
					alert('Rating is successfully submitted. Thank you!');					
				}else{
					alert('Could not submit rating, Please try again')
				}
				$('#modal_close').click();
		    }
	    });

	
}

function addMarker(locationDTOs) {
	global_markers=[];
    for (var i = 0; i < locationDTOs.length; i++) {
        var locationDTO=locationDTOs[i];
        // obtain the attribues of each marker
        var lat = parseFloat(locationDTO.latitude);
        var lng = parseFloat(locationDTO.longitude);
        
        var trailhead_name = locationDTO.providedUserName;

        var myLatlng = new google.maps.LatLng(lat, lng);

        var contentString = '<html><body><div>'
			       	 + '<table class="table table-striped">'
					 + '<tr>'
						 + '<td>Updated User</td>'
						 + '<td>' + locationDTO.providedUserName + '</td>'
					 + '</tr>'
					 + '<tr>'
						 + '<td>Updated Time</td>'
						 + '<td>' + locationDTO.updatedTime + '</td>'
					 + '</tr>'
					 + '<tr>'
						 + '<td>Ranking</td>'
						 + '<td>' + locationDTO.rank + '</td>'
					 + '</tr>'
					 + '<tr>'
						 + '<td colspan="2"><input class="btn btn-primary" value="Rank User" onclick="rankUser(' + locationDTO.updatedUserId +')" type="button"/></td>'
					 + '</tr>'
				 + '</table>'
			 + '</div></body></html>';

        var marker = new google.maps.Marker({
            position: myLatlng,
            map: map,
            title: "Coordinates: " + lat + " , " + lng + " | Trailhead name: " + trailhead_name
        });

        marker['infowindow'] = contentString;

        global_markers[i] = marker;

        google.maps.event.addListener(global_markers[i], 'click', function() {
            infowindow.setContent(this['infowindow']);
            infowindow.open(map, this);
        });
    }
}



</script>
