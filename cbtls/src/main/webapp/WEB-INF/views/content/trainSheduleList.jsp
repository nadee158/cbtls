<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">Train Schedule</h1>
  <div class="row">
	<div class="col-md-8 col-sm-6 col-xs-12">
		<div class="form-group">
          <label class="col-lg-12 control-label" style="text-align:center;"><h3>${trainSearchDTO.startStationName} - ${trainSearchDTO.endStationName}</h3></label>
        </div>
        <c:choose>
        	<c:when test="${trainSearchDTO.searchType=='Next Train' || trainSearchDTO.searchType=='Today Schedule'}">
	        	<div class="form-group">
		          <label class="col-lg-12 control-label" style="text-align:center;"><h4>
		          		${trainSearchDTO.searchType}
		          </h4></label>
		        </div>
        	</c:when>
        	<c:otherwise>
	        	 <c:if test="${! empty trainSearchDTO.startDate}">
			        <div class="form-group">
			          <label class="col-lg-12 control-label" style="text-align:center;"><h4>
			          		From <fmt:formatDate pattern="dd/MM/yyyy" value="${trainSearchDTO.startDate}" /> ${trainSearchDTO.startTime}
			          		to <fmt:formatDate pattern="dd/MM/yyyy" value="${trainSearchDTO.endDate}" /> ${trainSearchDTO.endTime}
			          </h4></label>
			        </div>
		        </c:if>
        	</c:otherwise>
        </c:choose>
		
		
		<div class="col-lg-12" style="max-width: 100%;">	
			<div class="table-responsive" style="max-width: 100%;">
				<table class="table table-bordered" style="max-width: 100%;">
					<thead>
						<tr>
							<th class="text-center"><strong>Daparture</strong></th>
							<th class="text-center"><strong>Arrival</strong></th>
							<th class="text-center"><strong>Duration(h)</strong></th>	
							<th class="text-center"><strong>View</strong></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center">10.30 a.m</td>
							<td class="text-center">11.30 a.m</td>
							<td class="text-center">0.30</td>	
							<td class="text-center"><input class="btn btn-primary" value="View" onclick="viewTrainScheduleDetails()" type="button"></td>
						</tr>
						<c:if test="${! (trainSearchDTO.searchType=='Next Train')}">
							<tr>
								<td class="text-center">11.30 a.m</td>
								<td class="text-center">12.30 a.m</td>
								<td class="text-center">0.20</td>	
								<td class="text-center"><input class="btn btn-primary" value="View" onclick="viewTrainScheduleDetails()" type="button"></td>
							</tr>
							<tr>
								<td class="text-center">9.30 a.m</td>
								<td class="text-center">10.20 a.m</td>
								<td class="text-center">0.20</td>	
								<td class="text-center"><input class="btn btn-primary" value="View" onclick="viewTrainScheduleDetails()" type="button"></td>
							</tr>
							<tr>
								<td class="text-center">10.30 a.m</td>
								<td class="text-center">11.30 a.m</td>
								<td class="text-center">0.30</td>	
								<td class="text-center"><input class="btn btn-primary" value="View" onclick="viewTrainScheduleDetails()" type="button"></td>
							</tr>
						</c:if>
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

function viewTrainScheduleDetails(){
	$('#viewTrainScheduleDetails').submit();
}
</script>