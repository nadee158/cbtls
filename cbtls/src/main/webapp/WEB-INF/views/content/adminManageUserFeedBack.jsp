  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <style type="text/css">
  .wrapword{
white-space: -moz-pre-wrap !important;  /* Mozilla, since 1999 */
white-space: -webkit-pre-wrap; /*Chrome & Safari */ 
white-space: -pre-wrap;      /* Opera 4-6 */
white-space: -o-pre-wrap;    /* Opera 7 */
white-space: pre-wrap;       /* css-3 */
word-wrap: break-word;       /* Internet Explorer 5.5+ */
word-break: break-all;
white-space: normal;
}
  
  </style>
 <div id="page-wrapper">
    
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">View User Feedback</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
  
     <div class="row">
        <div class="col-lg-12">
        	<table class="table table-striped">
        		<tr>
        			<th>Train Name</th>
        			<th>Start Station</th>
        			<th>End Station</th>
        			<th>Frequency</th>
        			<th>Type</th>
        			<th>Activate/Deactivate</th>
        			<th>FeedBacks</th>
        		</tr>
        		<c:forEach items="${scheduleList}" var="schedule">
	        		<tr>
	        			<td class="wrapword">${schedule.trainName}</td>
	        			<td class="wrapword">${schedule.startStation.trainStationName}</td>
	        			<td class="wrapword">${schedule.endStation.trainStationName}</td>
	        			<td>${schedule.trainFrequency}</td>
	        			<td>${schedule.trainType.trainTypeName}</td>
	        			<td>
	        				<input class="btn btn-primary" value="Deactivate" type="button"/>
	        			</td>
	        			<td>
	        				<input class="btn btn-primary" value="View Details" onclick="viewFeedBacks(${schedule.trainScheduleId})" type="button"/>
	        			</td>
	        		</tr>
        		</c:forEach>
        	</table>
        </div>
        <div style="clear: both;"></div>
     </div>
     <div style="clear: both;"></div>
      
    <!-- /.row -->
</div>
<!-- /#page-wrapper -->
<script type="text/javascript">
function viewFeedBacks(trainScheduleId){
 window.location='viewFeedBacks.htm?tsid=' + trainScheduleId;
}
</script>