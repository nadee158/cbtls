<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container" style="padding-top: 0px;">
  <h1 class="page-header">View Recommendations</h1>
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
		<div class="form-group">
          <label class="col-lg-12 control-label" style="text-align:center;">Trains are listed based on ranking from best to worst </label>
        </div>
		<div class="form-group">
          <label class="col-lg-12 control-label" style="text-align:center;">The ranking based on analysis of historical data</label>
        </div>
		<div class="col-lg-12" style="max-width: 100%;">	
			<div class="table-responsive" style="max-width: 100%;">
				<table class="table table-bordered" style="max-width: 100%;">
					<thead>
						<tr>
							<th class="text-center"><strong>Rank</strong></th>
							<th class="text-center"><strong>Expected Arrival at Destination</strong></th>
							<th class="text-center"><strong>Average Reported Delay</strong></th>	
							<th class="text-center"><strong>Average Crowd Density</strong></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center">1</td>
							<td class="text-center">11.30 a.m</td>
							<td class="text-center">5 min</td>	
							<td class="text-center">Medium</td>
						</tr>
						<tr>
							<td class="text-center">2</td>
							<td class="text-center">12.30 a.m</td>
							<td class="text-center">10 min</td>	
							<td class="text-center">High</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<br />
		<div class="form-group">
			<div class="col-lg-5" style="text-align:left;">&nbsp;</div>
			  <div class="col-lg-2">
				<input class="btn btn-primary" value="Go Back To Search" onclick="serchAgain()" type="button">
			  </div>
			<div class="col-lg-5" style="text-align:left;">&nbsp;</div>
        </div>
	</div>
    
  </div>
</div>

<script type="text/javascript">
function serchAgain(){
	window.location='home.htm';
	
}
</script>