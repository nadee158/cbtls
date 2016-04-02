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
            <h1 class="page-header">Manage Users     </h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
  
     <div class="row">
        <div class="col-lg-12">
        	<table class="table table-striped">
        		<tr>
        			<th>User Name</th>
        			<th>User Display Name</th>
        			<th>Email Address</th>
        			<th>Average Ranking</th>
        			<th>Total Number Of FeedBacks</th>
        			<th>Activate/Deactivate</th>
        			<th>Details</th>
        		</tr>
        		<c:forEach items="${userList}" var="user">
	        		<tr>
	        			<td class="wrapword">${user.userName}</td>
	        			<td class="wrapword">${user.userDisplayName}</td>
	        			<td class="wrapword">${user.emailAddress}</td>
	        			<td>${user.averageRanking}</td>
	        			<td>${user.totalNumberOfFeedBacks}</td>
	        			<td>
	        				<input class="btn btn-primary" value="Deactivate" type="button"/>
	        			</td>
	        			<td>
	        				<input class="btn btn-primary" value="View Details" onclick="viewUserDetails(${user.userId})" type="button"/>
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
function viewUserDetails(userId){

	
}
</script>