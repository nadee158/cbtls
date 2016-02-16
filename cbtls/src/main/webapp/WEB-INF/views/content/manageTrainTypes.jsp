 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Manage Train Stations</h1>
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
		   <a href="javascript:addNewStation()" class="btn btn-success btn-sm">
	          <span class="glyphicon glyphicon-plus"></span> Add New Station 
	        </a>
	  </div>
	  <div class="panel-body">
	  	<div id="bulkUploadForm" style="display: none;">
	  		<form:form cssClass="form-horizontal" role="form" action="saveTrainStation.htm" modelAttribute="trainStation" method="post" >
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
	  	<div id="addNewStationForm" style="display: none;">
		  <form:form cssClass="form-horizontal" role="form" action="saveTrainStation.htm" modelAttribute="trainStation" method="post" >
			  <div class="form-group">
			    <label for="trainStationReferenceId" class="col-sm-2 control-label">Reference Id</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="trainStationReferenceId" id="trainStationReferenceId" placeholder="Station Reference Id">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="trainStationCode" class="col-sm-2 control-label">Station Code</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="trainStationCode" id="trainStationCode" placeholder="Station Code">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="trainStationName" class="col-sm-2 control-label">Station Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="trainStationName" id="trainStationName" placeholder="Station Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="trainStationContactNumber" class="col-sm-2 control-label">Contact Number</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="trainStationContactNumber" id="trainStationContactNumber" placeholder="Station Contact Number">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="latitude" class="col-sm-2 control-label">Latitude</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="geoLocation.latitude" id="latitude" placeholder="Latitude">
			    </div>
			  </div>	
			   <div class="form-group">
			    <label for="longitude" class="col-sm-2 control-label">Longitude</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="geoLocation.longitude" id="longitude" placeholder="Longitude">
			    </div>
			  </div>			  
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-5">
			      <input type="submit" class="btn btn-primary" value="Add Station" />
			      <input type="button" class="btn btn-primary" value="Cancel" onclick="return cancelAdding()" />
			    </div>
			  </div>
			</form:form>
	  	</div>
	    <div class="table-responsive">
			  <table class="table  table-striped">
			  		<thead>
			  			<tr>
				  			<th>Station Reference Id</th>
				  			<th>Station Code</th>
				  			<th>Station Name</th>
				  			<th>Station Contact Number</th>
				  			<th>Latitude</th>
				  			<th>Longitude</th>
				  			<th>Edit</th>	
				  			<th>Delete</th>	  			
			  			</tr>
			  		</thead>
			  		<tbody>
			  			<c:choose>
				  			<c:when test="${!empty trainStations}">
					  			<c:forEach items="${trainStations}" var="trainStation">
					  				<tr>
					  					<td>${trainStation.trainStationReferenceId}</td>
					  					<td>${trainStation.trainStationCode}</td>
					  					<td>${trainStation.trainStationName}</td>
					  					<td>${trainStation.trainStationContactNumber}</td>
					  					<td>${trainStation.geoLocation.latitude}</td>
					  					<td>${trainStation.geoLocation.longitude }</td>
					  					<td>
					  						<a href="#" class="btn btn-primary btn-sm">
									          <span class="glyphicon glyphicon-edit"></span> Edit 
									        </a>
					  					</td>
					  					<td>
					  						<a href="javascript:deleteTrainStation(${trainStation.trainStationId})" class="btn btn-danger btn-sm">
									          <span class="glyphicon glyphicon-trash"></span> Delete
									        </a>
									        <form action="deleteTrainStation.htm" method="post" id="hiddenFormDelete_${trainStation.trainStationId}">
									          	<input type="hidden" name="trainStationId" value="${trainStation.trainStationId}" >
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
function addNewStation(){
	$('#addNewStationForm').show();
	$('#bulkUploadForm').hide();
}

function deleteTrainStation(trainStationId){
	$('#hiddenFormDelete_' + trainStationId).submit();
}

function cancelAdding(){
	$('#addNewStationForm').hide();
}

function cancelBulkUpload(){
	$('#bulkUploadForm').hide();
}

function bulkUpload(){
	$('#addNewStationForm').hide();
	$('#bulkUploadForm').show();
}

</script>