<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title><s:text name='page.title.searchTrain'/></title>
	<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/css/bootstrap_common.css" />
	<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/css/styles.css" />
	<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.3.custom.min.css" />
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.10.3.custom.min.js"></script>
	
	<jsp:include page="scripts.jsp" />
	
	<script type="text/javascript">

	$(function() {
		$("#searchDateId").datepicker({
			dateFormat : "dd/mm/yy",
			showOn: 'button', 
			buttonImage: 'images/calendar.png', 
			buttonImageOnly: true,
			minDate : 0
		});
	});
	
	function formSubmit(){

		clearPreviousError();
		
		var startStationId = $('#startStation').val();
		var endStationId = $('#endStation').val();
		var startTime = $('#startTime').val();
		var endTime = $('#endTime').val();
		var locale = $('#selectedLocaleId').val();

		// Set english as default locale
		if (locale == "") {
			locale = "en";
		}
		
		var isErrorOccurred = false;
		
		if (startStationId == -1){
			isErrorOccurred = true;

			$("#startStationDiv").attr("class", "control-group error");
			$("#startStationErrorSpan").css("display", "block");
			$("#startStationErrorSpan").text("<s:text name='error.message.startStationNotSelected'/>");
		}
		
		if (endStationId == -1){
			isErrorOccurred = true;

			$("#endStationDiv").attr("class", "control-group error");
			$("#endStationErrorSpan").css("display", "block");
			$("#endStationErrorSpan").text("<s:text name='error.message.endStationNotSelected'/>");
		}

		if (startStationId != -1 && endStationId != -1 && startStationId == endStationId) {
			isErrorOccurred = true;

			$("#startStationDiv").attr("class", "control-group error");
			$("#startStationErrorSpan").css("display", "block");
			$("#startStationErrorSpan").text("<s:text name='error.message.startAndEndStationSame'/>");

			$("#endStationDiv").attr("class", "control-group error");
			$("#endStationErrorSpan").css("display", "block");
			$("#endStationErrorSpan").text("<s:text name='error.message.startAndEndStationSame'/>");
		}

		if (startTime != -1 && endTime != -1) {
			if (!checkValidity(startTime, endTime)) {				
				isErrorOccurred = true;

				$("#startTimeDiv").attr("class", "control-group error");
				$("#startTimeErrorSpan").css("display", "block");
				$("#startTimeErrorSpan").text("<s:text name='error.message.startTimeGreaterThanEndTime'/>");

				$("#endTimeDiv").attr("class", "control-group error");
				$("#endTimeErrorSpan").css("display", "block");
				$("#endTimeErrorSpan").text("<s:text name='error.message.startTimeGreaterThanEndTime'/>");
			}
		}
		
		if (!isErrorOccurred){
			document.forms[0].action = "searchTrain.action?lang=" + locale;
			document.forms[0].submit();
		}
	}

	function checkValidity(startTime, endTime) {

		var isValid = true;

		var sptTime = String(startTime).split(":");
		var hour = sptTime[0];
		var minute = sptTime[1];
		var second = sptTime[2];

		// new Date(year, month, day, hours, minutes, seconds, milliseconds)
		var startTimeDate = new Date(0, 0, 0, hour, minute, second, 0);

		sptTime = String(endTime).split(":");
		hour = sptTime[0];
		minute = sptTime[1];
		second = sptTime[2];

		var endTimeDate = new Date(0, 0, 0, hour, minute, second, 0);

		if (startTimeDate >= endTimeDate) {
			isValid = false;
		}

		return isValid;
	}

	function clearPreviousError() {

		$("#startStationDiv").attr("class", "control-group");
		$("#startStationErrorSpan").text("");
		$("#startStationErrorSpan").css("display", "none");
		
		$("#endStationDiv").attr("class", "control-group");
		$("#endStationErrorSpan").text("");
		$("#endStationErrorSpan").css("display", "none");

		$("#startTimeDiv").attr("class", "control-group");
		$("#startTimeErrorSpan").text("");
		$("#startTimeErrorSpan").css("display", "none");
		
		$("#endTimeDiv").attr("class", "control-group");
		$("#endTimeErrorSpan").text("");
		$("#endTimeErrorSpan").css("display", "none");		

		$("#searchDateDiv").attr("class", "control-group");
		$("#searchDateErrorSpan").text("");
		$("#searchDateErrorSpan").css("display", "none");		
	}

	function resetPage() {
		clearPreviousError();

		// Reset all field values
		$("#startStation").val('-1');
		$("#endStation").val('-1');
		$("#startTime").val('-1');
		$("#endTime").val('-1');
		$("#searchDateId").val('');
	}
	</script>
	
	<style type="text/css">	
	.ui-widget-header {
		
	   	background: #ADD8E6;
	   	color: #000;
	}
	
	.ui-datepicker .ui-state-default {
		color: #000304;
	}
	
	.ui-datepicker .ui-state-highlight {   
	   	border: 1px solid #CCCCCC;
	   	background: #F6F6F6;
	}
	
	label, input, button, select, textarea {
    	font-size: 12px;
    }
    
    select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input {
	    font-size: 12px;
	}
	
	.btn {
    	font-size: 12px;
	}
	
	.form-horizontal .control-label {
    	text-align: left;
	}
	
	.hero-unit {
		padding: 10px;
		margin-bottom: 10px; 
		font-size: 12px;
		line-height: 10px;
	}
	
	select {
 	   width: 175px;
	}
	
	input, textarea, .uneditable-input {
    	 width: 160px;
	}
	
	
	.ui-datepicker-trigger{
		cursor: pointer;
	}
	</style>
	
	<script>
function viewPopup(url, title) {
window.open(url, title, "width=500, height=450");
return false;
}
</script>
</head>

<body>
<div id="es-container" class="es-container">
	<!-- HEADER SECTION START -->
	<s:if test="!isCountryPortalTheme">
		<jsp:include page="header.jsp" />
	</s:if>
	<!-- HEADER SECTION END -->
	
	<!-- MAIN CONTENT START -->
	<div id="es-content" class="es-content">
	
	
			<div class="es-eservice-title">
						
								<s:text name='page.title.searchTrain'/>
							
						<div class="tittle-help-icon">
							<a href="javascript:void(0);"> <img
								src="<%=request.getContextPath()%>/assets/images/help.png"
								class="tittle-help-icon-img"></a>
						</div>
					</div>
					
					
					
		<form class="form-horizontal" action="searchTrain.action" method="post" id="search_form_id">
			<s:hidden name="selectedLocale" id="selectedLocaleId"></s:hidden>
			
			
			<div class="jumbotron">
			
			<div class="row">
				<div class="col-xs-12 col-sm-2 col-md-2">
  				  			<label class="control-label" for="startStation">
				    			<strong><s:text name='label.start.station'/>:&nbsp;<font color="red">*</font></strong>
				    		</label>
				    		</div>
				    		
				<div class="col-xs-12 col-sm-3 col-md-3">
				    		<div class="control-group" id="startStationDiv">
  				  				<s:select name="searchCriteria.startStationID" id="startStation" cssClass="es-select"
  				  					headerKey="-1" headerValue="--- Select ---" 
				      				list="allStations" listKey="stationID" listValue="stationName" >
					  			</s:select>
					  			<span class="help-inline" id="startStationErrorSpan" style="display: none;"></span>
					  		</div>
  				</div>
  				
				<div class="col-xs-12 col-sm-2 col-md-2">
  				  			<label class="control-label" for="endStation">
				    			<strong><s:text name='label.end.station'/>:&nbsp;<font color="red">*</font></strong>
				    		</label>
  				 </div> 		
  				  		
  				 <div class="col-xs-12 col-sm-3 col-md-3"> 		
  				  		<div class="control-group" id="endStationDiv">
  				  				<s:select name="searchCriteria.endStationID" id="endStation" cssClass="es-select"
  				  					headerKey="-1" headerValue="--- Select ---" 
				      				list="allStations" listKey="stationID" listValue="stationName">
					  			</s:select>
					  			<span class="help-inline" id="endStationErrorSpan" style="display: none;"></span>
					  		</div>
				</div>
				
			</div>
			
			
		<!-- SECOND RAW -->
		
		<div class="row">
				<div class="col-xs-12 col-sm-2 col-md-2">
  				  			<label class="control-label" for="startTime"><strong><s:text name='label.start.time'/>:</strong></label>
  				</div>
  				 
  				<div class="col-xs-12 col-sm-3 col-md-3">
  				  		<div class="control-group" id="startTimeDiv">
  				  				<s:select name="searchCriteria.startTime" id="startTime" cssClass="es-select"
  				  					headerKey="-1" headerValue="--- Select ---" list="startTimePickerList">
				      			</s:select>
				      			<span class="help-inline" id="startTimeErrorSpan" style="display: none;"></span>
				      		</div>
				</div>	
				      		
				      		
				<div class="col-xs-12 col-sm-2 col-md-2">
  				  			<label class="control-label" for="endTime"><strong><s:text name='label.end.time'/>:</strong></label>
  				 </div> 
  				 			
  				 <div class="col-xs-12 col-sm-3 col-md-3">			
  				  		<div class="control-group" id="endTimeDiv">
  				  				<s:select name="searchCriteria.endTime" id="endTime" cssClass="es-select"
  				  					headerKey="-1" headerValue="--- Select ---" list="endTimePickerList">
				       			</s:select>  
				       			<span class="help-inline" id="endTimeErrorSpan" style="display: none;"></span>
				       		</div>
  				  		
  				  		
  				  		
  				  	</div>	
  				  	
					</div>
			
			
			<!-- THIRD RAW -->
			
			
			<div class="row">
				<div class="col-xs-12 col-sm-2 col-md-2">
			
  				  			<label class="control-label" for="searchDate"><strong><s:text name='label.search.date'/>:</strong></label>
  				  			
  				  </div>
  				  <div class="col-xs-12 col-sm-3 col-md-3">
  				  			<div class="control-group" id="searchDateDiv">
  				  				<s:textfield name="searchDate" id="searchDateId" readonly="true"/>
				      			<span class="help-inline" id="searchDateErrorSpan" style="display: none;"></span>
				      		</div>
  				  		
				
				</div>
				</div>
			
<div class="col-md-12"></div>	
			
			<!-- FOURTH ROW -->
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-4" style="font-size: 11px;">	<s:text name="enquiry.mandatory.fields" /></div>
				</div>
				
				<div class="col-md-12"><br></div>	
			
				<!-- FIFTH ROW -->
			<div class="row">
				<div class="col-md-6">	
  				  			<button type="button" class="es-button" onclick="formSubmit();"><span><s:text name='button.search' /></span></button> 
				      		<button type="button" class="es-button" onclick="resetPage();"><span><s:text name='button.reset' /></span></button>
  				  	</div>
				</div>
			
				<div class="row">
				<div class="col-md-6"></div>
				</div>
				
			
			
			
			
			
			<!-- Loading social medic icons -->

					<div class="row">

						<div class="col-xs-6 col-sm-3">
							<div class="display-change login-images" STYLE="padding-left:0px">
								<img
									src="<%=request.getContextPath()%>/assets/images/1919web banner-small.jpg">
							</div>
						</div>
						
						<div class="col-xs-6 col-sm-9">
						<div class="social-row ">
		<span class="social-buttons">
			<a onclick="viewPopup('https://www.facebook.com/sharer/sharer.php?u=http://cp.lankagate.gov.lk/?inner-url=http://cp.lankagate.gov.lk/services/slr/schedule?lang=en&appcode=cp&gen_from=sch','Facebook')">
				<img title="Facebook" src="<%=request.getContextPath()%>/assets/images/facebookIcon.png" class="social-image-round">
			</a>
		</span>
		
		<span class="social-buttons">
			<a onclick="viewPopup('https://twitter.com/intent/tweet?url=http://cp.lankagate.gov.lk/?inner-url=http://cp.lankagate.gov.lk/services/slr/schedule?lang=en&appcode=cp&gen_from=sch','Twitter')">
				<img title="Twitter" src="<%=request.getContextPath()%>/assets/images/twitterIcon.png" class="social-image-round">
			</a>
		</span>
		
		<span class="social-buttons">
			<a onclick="viewPopup('https://plus.google.com/share?url=http://cp.lankagate.gov.lk/?inner-url=http://cp.lankagate.gov.lk/services/slr/schedule?lang=en&appcode=cp&gen_from=sch','Google+')">
				<img title="Google+" src="<%=request.getContextPath()%>/assets/images/googlePlusIcon.png" class="social-image-round">
			</a>
		</span>
		
		<span class="social-buttons">
			<a onclick="viewPopup('http://www.linkedin.com/shareArticle?mini=true&amp;url=http://cp.lankagate.gov.lk/?inner-url=http://cp.lankagate.gov.lk/services/slr/schedule?lang=en&appcode=cp&gen_from=sch','LinkedIn')">
				<img title="LinkedIn" src="<%=request.getContextPath()%>/assets/images/linkedInIcon.png" class="social-image-round">
			</a>

	
		</span>                                
	</div>
	
	</div>

<!-- End of social medic icons -->




			
			</div>
			
			
			
			</div>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	<%-- 		
			<table style="width:100%;">
  				  	<tr height="10px">
  				  		<td height="10px">
  				  			<label class="control-label" for="startStation">
				    			<strong><s:text name='label.start.station'/>:&nbsp;<font color="red">*</font></strong>
				    		</label>
  				  		</td>
  				  		
  				  		<td height="10px">
  				  			<label class="control-label" for="endStation">
				    			<strong><s:text name='label.end.station'/>:&nbsp;<font color="red">*</font></strong>
				    		</label>
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td>
  				  			<div class="control-group" id="startStationDiv" style="height: 10px">
  				  				<s:select name="searchCriteria.startStationID" id="startStation" 
  				  					headerKey="-1" headerValue="--- Select ---" 
				      				list="allStations" listKey="stationID" listValue="stationName" >
					  			</s:select>
					  			<span class="help-inline" id="startStationErrorSpan" style="display: none;"></span>
					  		</div>
  				  		</td>
  				  		
  				  		<td>
  				  			<div class="control-group" id="endStationDiv" style="height: 10px">
  				  				<s:select name="searchCriteria.endStationID" id="endStation" 
  				  					headerKey="-1" headerValue="--- Select ---" 
				      				list="allStations" listKey="stationID" listValue="stationName">
					  			</s:select>
					  			<span class="help-inline" id="endStationErrorSpan" style="display: none;"></span>
					  		</div>
  				  		</td>
  				  	</tr>
  				  	  	
  				  	<tr>
  				  		<td height="10px">
  				  			<label class="control-label" for="startTime"><strong><s:text name='label.start.time'/>:</strong></label>
  				  		</td>
  				  		
  				  		<td height="10px">
  				  			<label class="control-label" for="endTime"><strong><s:text name='label.end.time'/>:</strong></label>
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td>
  				  			<div class="control-group" id="startTimeDiv" style="height: 10px">
  				  				<s:select name="searchCriteria.startTime" id="startTime" 
  				  					headerKey="-1" headerValue="--- Select ---" list="startTimePickerList">
				      			</s:select>
				      			<span class="help-inline" id="startTimeErrorSpan" style="display: none;"></span>
				      		</div>
  				  		</td>
  				  		
  				  		<td>
  				  			<div class="control-group" id="endTimeDiv" style="height: 10px">
  				  				<s:select name="searchCriteria.endTime" id="endTime" 
  				  					headerKey="-1" headerValue="--- Select ---" list="endTimePickerList">
				       			</s:select>  
				       			<span class="help-inline" id="endTimeErrorSpan" style="display: none;"></span>
				       		</div>
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td colspan="2" style="height: 10px">
  				  			<label class="control-label" for="searchDate"><strong><s:text name='label.search.date'/>:</strong></label>
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td colspan="2">
  				  			<div class="control-group" id="searchDateDiv" style="height: 10px">
  				  				<s:textfield name="searchDate" id="searchDateId" readonly="true"/>
				      			<span class="help-inline" id="searchDateErrorSpan" style="display: none;"></span>
				      		</div>
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td colspan="2" style="height: 10px">
  				  			&nbsp;
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td colspan="2" style="height: 10px">
  				  			<s:text name="enquiry.mandatory.fields" />
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td colspan="2" style="height: 10px">
  				  			&nbsp;
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td colspan="2">
  				  			<button type="button" class="btn btn-primary" onclick="formSubmit();"><span><s:text name='button.search' /></span></button> &nbsp;&nbsp;
				      		<button type="button" class="btn btn-primary" onclick="resetPage();"><span><s:text name='button.reset' /></span></button>
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td colspan="2" style="height: 10px">
  				  			&nbsp;
  				  		</td>
  				  	</tr>
  				  	
  				  	<tr>
  				  		<td colspan="2" style="height: 10px">
  				  			<span><strong><s:text name="enquiry.source" /></strong></span>
  				  		</td>
  				  	</tr>
  				  	
  				  </table> --%>
  				
				
		
		</form>

<div class="row"><div class="md-col-12">
		<div id="push"></div>
	</div>
	
	
	</div>
	<jsp:include page="help.jsp" />
	</div>
	
	<!-- MAIN CONTENT END -->
	
	<!-- FOOTER SECTION START -->
	<s:if test="!isCountryPortalTheme">
		<jsp:include page="footer.jsp" />
	</s:if>
	<!-- FOOTER SECTION END -->
</div>
</body>
</html>