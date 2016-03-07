 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Manage Train Types</h1>
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
	  		<form:form cssClass="form-horizontal" role="form" action="saveTrainType.htm" modelAttribute="trainType" method="post" >
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
		  <form:form cssClass="form-horizontal" role="form" action="saveTrainType.htm" modelAttribute="trainType" method="post" >
			  <div class="form-group">
			    <label for="trainStationReferenceId" class="col-sm-2 control-label">Train Type Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="trainTypeName" id="trainTypeName" placeholder="Station Reference Id">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-5">
			      <input type="submit" class="btn btn-primary" value="Add Type" />
			      <input type="button" class="btn btn-primary" value="Cancel" onclick="return cancelAdding()" />
			    </div>
			  </div>
			</form:form>
	  	</div>
	    <div class="table-responsive">
			  <table class="table  table-striped">
			  		<thead>
			  			<tr>
				  			<th>Train Type Name</th>
				  			<th>Edit</th>	
				  			<th>Delete</th>	  			
			  			</tr>
			  		</thead>
			  		<tbody>
			  			<c:choose>
				  			<c:when test="${!empty trainTypes}">
					  			<c:forEach items="${trainTypes}" var="trainType">
					  				<tr>
					  					<td>${trainType.trainTypeName}</td>
					  					<td>
					  						<a href="#" class="btn btn-primary btn-sm">
									          <span class="glyphicon glyphicon-edit"></span> Edit 
									        </a>
					  					</td>
					  					<td>
					  						<a href="javascript:deleteTrainType(${trainType.trainTypeId})" class="btn btn-danger btn-sm">
									          <span class="glyphicon glyphicon-trash"></span> Delete
									        </a>
									        <form action="deleteTrainType.htm" method="post" id="hiddenFormDelete_${trainType.trainTypeId}">
									          	<input type="hidden" name="trainTypeId" value="${trainType.trainTypeId}" >
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

function deleteTrainType(trainTypeId){
	$('#hiddenFormDelete_' + trainTypeId).submit();
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