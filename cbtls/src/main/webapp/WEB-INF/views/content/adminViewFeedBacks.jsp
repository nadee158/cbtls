  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <h1 class="page-header">View Feedback</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
  
     <div class="row">
        <div class="col-lg-12">
        	<table class="table table-striped">
        		<tr>
        			<th>User Name</th>
        			<th>Date of Feedback</th>
        			<th>Rating</th>
        			<th>Comment</th>
        			<th>Activate/Deactivate</th>
        		</tr>
        		<c:forEach items="${feedBacks}" var="feedBack">
	        		<tr>
	        			<td class="wrapword">${feedBack.updatedUserName}</td>
	        			<td class="wrapword"><fmt:formatDate value="${feedBack.updatedDate}" pattern="dd/MM/yyyy hh:mm a"/></td>
	        			<td class="wrapword">
	        				<input value="${feedBack.rating}" 
	        				class="rating rating-loading" data-min="0" data-max="5" data-step="1" data-readonly="true" data-size="xs">
	        			</td>
	        			<td>${feedBack.comment}</td>
	        			<td>
	        				<input class="btn btn-primary" value="Deactivate" type="button"/>
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
<script src='<c:url value="/js/star-rating.js" />' type="text/javascript"></script>
<script type="text/javascript">
</script>
