 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Manage Train Lines</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    
    <c:if test="${!empty status}">
	    <c:if test="${status=='error'}">
	    	<div class="alert alert-warning alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  <strong>Warning!</strong> The requested operation failed from backend.
			</div>
	    </c:if>
	    <c:if test="${status=='success'}">
	    	<div class="alert alert-success alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  <strong>Successful!</strong> The requested operation was successful.
			</div>
	    </c:if>
    </c:if>
    
    <div class="panel panel-default">
	  <div class="panel-heading" style="text-align: right;">
	  		<a href="javascript:bulkUpload()" class="btn btn-success btn-sm">
	          <span class="glyphicon glyphicon-plus"></span> Bulk Upload
	        </a>
		   <a href="javascript:addNewLine()" class="btn btn-success btn-sm">
	          <span class="glyphicon glyphicon-plus"></span> Add New Train Line 
	        </a>
	  </div>
	  <div class="panel-body">
	  	<div id="bulkUploadForm" style="display: none;">
	  		<form:form cssClass="form-horizontal" role="form" action="saveTrainLine.htm" modelAttribute="trainLine" method="post" >
				<div class="form-group">
				    <label class="control-label">Select File</label>
				    <div class="col-sm-10">
				      <input id="input-1a" type="file" class="file" data-show-preview="false">
				    </div>
				  </div>
				<div class="form-group">
				    <div class="col-sm-offset-2 col-sm-5">
				        <input type="button" class="btn btn-primary" value="Cancel" onclick="return cancelBulkUpload()" />
				    </div>
			  	</div>
	  		</form:form>
	  	</div>
	  	<div id="addNewLineForm" style="display: none;">
		  <form:form cssClass="form-horizontal" role="form" action="saveTrainLine.htm" modelAttribute="trainLine" method="post" >
			  <div class="form-group">
			    <label for="trainLineName" class="col-sm-2 control-label">Line Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="trainLineName" id="trainLineName" placeholder="Line Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="startStation" class="col-sm-2 control-label">Start Station</label>
			    <div class="col-sm-10">
			   	  <select class="form-control" name="startStation" id="startStation">
			   	  	<c:forEach items="${trainStations}" var="trainStation">
			   	  		 <option value="${trainStation.trainStationId}">${trainStation.trainStationName}</option>
			   	  	</c:forEach>
			      </select>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="endStation" class="col-sm-2 control-label">End Station</label>
			    <div class="col-sm-10">
			   	  <select class="form-control" name="endStation" id="endStation">
			   	  	<c:forEach items="${trainStations}" var="trainStation">
			   	  		 <option value="${trainStation.trainStationId}">${trainStation.trainStationName}</option>
			   	  	</c:forEach>
			      </select>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-5">
			      <input type="submit" class="btn btn-primary" value="Add Train Line" />
			      <input type="button" class="btn btn-primary" value="Cancel" onclick="return cancelAdding()" />
			    </div>
			  </div>
			</form:form>
	  	</div>
	    <div class="table-responsive">
			  <table class="table  table-striped">
			  		<thead>
			  			<tr>
				  			<th>Train Line Id</th>
				  			<th>Train Line Name</th>
				  			<th>Start Station</th>
				  			<th>End Station</th>
				  			<th>Edit</th>	
				  			<th>Delete</th>	  			
			  			</tr>
			  		</thead>
			  		<tbody>
			  			<c:choose>
				  			<c:when test="${!empty trainLines}">
					  			<c:forEach items="${trainLines}" var="trainLine">
					  				<tr>
					  					<td>${trainLine.trainLineId}</td>
					  					<td>${trainLine.trainLineName}</td>
					  					<td>${trainLine.startStation.trainStationName}</td>
					  					<td>${trainLine.endStation.trainStationName}</td>
					  					<td>
					  						<a href="#" class="btn btn-primary btn-sm">
									          <span class="glyphicon glyphicon-edit"></span> Edit 
									        </a>
					  					</td>
					  					<td>
					  						<a href="javascript:deleteTrainLine(${trainLine.trainLineId})" class="btn btn-danger btn-sm">
									          <span class="glyphicon glyphicon-trash"></span> Delete
									        </a>
									        <form action="deleteTrainLine.htm" method="post" id="hiddenFormDelete_${trainLine.trainLineId}">
									          	<input type="hidden" name="trainLineId" value="${trainLine.trainLineId}" >
									         </form> 
					  					</td>
					  				</tr>
					  			</c:forEach>
				  			</c:when>
				  			<c:otherwise>
				  				<tr><td colspan="8" style="text-align: center;">No Data is Available!</td></tr>
				  			</c:otherwise>
			  			</c:choose>
			  		</tbody>
			  </table>
			</div>
	  </div>
	</div>
    
    
    
    
</div>
<!-- /#page-wrapper -->
<script type="text/javascript">
function addNewLine(){
	$('#addNewLineForm').show();
	$('#bulkUploadForm').hide();
}

function deleteTrainLine(trainLineId){
	$('#hiddenFormDelete_' + trainLineId).submit();
}

function cancelAdding(){
	$('#addNewLineForm').hide();
}

function cancelBulkUpload(){
	$('#bulkUploadForm').hide();
}

function bulkUpload(){
	$('#addNewLineForm').hide();
	$('#bulkUploadForm').show();
}

</script>