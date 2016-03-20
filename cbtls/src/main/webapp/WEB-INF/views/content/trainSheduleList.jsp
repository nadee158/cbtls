<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">Train Schedule</h1>
  <div class="row">
	<div class="col-md-8 col-sm-6 col-xs-12">
		<div class="form-group">
          <label class="col-lg-12 control-label" style="text-align:center;">
          	<h3>${trainScheduleSearchDTO.fromStationName} - ${trainScheduleSearchDTO.toStationName}</h3>
          </label>
        </div>
       	<div class="form-group">
          <label class="col-lg-12 control-label" style="text-align:center;"><h4>
          		${trainScheduleSearchDTO.searchTypeText}
          </h4></label>
        </div>
       	 <c:if test="${! empty trainScheduleSearchDTO.fromTime}">
	        <div class="form-group">
	          <label class="col-lg-12 control-label" style="text-align:center;"><h4>
	          		(From ${trainScheduleSearchDTO.fromTime}
	          		to ${trainScheduleSearchDTO.toTime}
	          		On ${trainScheduleSearchDTO.searchedDate})
	          </h4></label>
	        </div>
        </c:if>
		
		
		<div class="col-lg-12" style="max-width: 100%;">	
			<div class="table-responsive" style="max-width: 100%;">
				<table class="table table-bordered" style="max-width: 100%;">
					<thead>
						<tr>
							<th class="text-center"><strong>Arrival at Station</strong></th>
							<th class="text-center"><strong>Daparture from Station</strong></th>
							<th class="text-center"><strong>Arrival at Destination</strong></th>
							<th class="text-center"><strong>Duration(h)</strong></th>	
							<th class="text-center"><strong>View</strong></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr>
								<td><fmt:formatDate value="${item.arrivalTime}"  pattern="hh:mm a" /></td>
								<td><fmt:formatDate value="${item.departureTime}"  pattern="hh:mm a" /></td>
								<td><fmt:formatDate value="${item.arrivalAtDestinationTime}"  pattern="hh:mm a" /></td>
								<td>${item.duration}</td>
								<td>
									<input class="btn btn-primary" value="View" onclick="viewTrainScheduleDetails(${item.trainStationScheduleId})" type="button">
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br />
		<div class="form-group">
			<div class="col-lg-6" style="text-align:left;">&nbsp;</div>
			  <div class="col-lg-3">
				<input class="btn btn-primary" value="View Recomandations" onclick="viewRecommendations()" type="button">
			  </div>
			  <div class="col-lg-3">
				<input class="btn btn-primary" value="Search Again" onclick="serchAgain()" type="button">
			  </div>
        </div>
	</div>
    
    <form action="viewRecommendations.htm" id="viewRecommendations" method="post"></form>
    <form action="viewTrainScheduleDetails.htm" id="viewTrainScheduleDetails" method="post"></form>
    
  </div>
</div>
<script type="text/javascript">
function serchAgain(){
	window.location='home.htm';
	
}

function viewRecommendations(){
	$('#viewRecommendations').submit();
}

function viewTrainScheduleDetails(trainStationScheduleId){

	 $.ajax({
	        url: 'searchTrainScheduleDetails.json',
	        type: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(trainStationScheduleId),
	        dataType: 'json',
	        success: function (data) {
	        	$('#viewTrainScheduleDetails').submit();
		    }
	    });
	
}
</script>