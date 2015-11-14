<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title><s:text name='page.title.searchTrain' /></title>
<link rel="stylesheet" media="screen"
	href="<%=request.getContextPath()%>/css/bootstrap_common.css" />
<%-- <link rel="stylesheet" media="screen"
	href="<%=request.getContextPath()%>/css/styles.css" /> --%>
<%-- <link rel="stylesheet" media="screen"
	href="<%=request.getContextPath()%>/css/jquery-ui-1.10.3.custom.min.css" /> --%>

<%-- <script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui-1.10.3.custom.min.js"></script> --%>

	<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/css/bootstrap_common.css" />
	<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/css/styles.css" />
	<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.3.custom.min.css" />
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.10.3.custom.min.js"></script>


<jsp:include page="scripts.jsp" />	
	

	


<script type="text/javascript">
	function showHideTrainList(value,showHideValue) {
		if(showHideValue == 1)
			$("#moreLessTr_"+value).html('<a href="javascript:showHideTrainList('+value+',0);"><b><s:text name="label.slr.less"></s:text></b></a>');
		else
			$("#moreLessTr_"+value).html('<a href="javascript:showHideTrainList('+value+',1);"><b><s:text name="label.slr.more"></s:text></b></a>');
		
		$("#trainListTr_"+value).slideToggle("slow");
		$("#trainListDiv_" + value).slideToggle("slow");
	}
</script>

<style type="text/css">
.table thead th {
	vertical-align: middle;
	background-color: #91B9D3;
}

.table th,.table td {
	line-height: 15px;
	padding: 4px;
	vertical-align: middle;
	text-align: left;
}

.hero-unit {
	padding: 5px;
	margin-bottom: 5px;
	font-size: 12px;
}

.btn {
	font-size: 12px;
}

hr {
	margin: 5px 0;
}
</style>
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
					
					
		<div class="row">
		<div class="col-xs-12 col-sm-11 col-md-11"><legend>
				<span> <s:text name='result.queryString'>
							<s:param value="searchResult.query.startStaionName" />
							<s:param value="searchResult.query.endStaionName" />
							<s:param value="searchResult.query.searchDate" />
							<s:param value="searchResult.query.searchTimeStart" />
							<s:param value="searchResult.query.searchTimeEnd" />
						</s:text>
					</span>
					<%-- <strong><s:text name='page.title.searchResult' /></strong> --%>
				</legend></div>
				
				
			<div class="col-md-1">	
				
				<s:hidden name="selectedLocale" id="selectedLocaleId"></s:hidden>
				
				
				<!-- BACK BUTTON START -->
				
			
				<button type="button" class="es-button" onclick="window.history.go(-1);">
				<span><s:text name='button.back' /></span>
				</button>
					
				
				<!-- BACK BUTTON END -->
						
				</div>
				</div>
				
				<!-- QUERY SECTION END -->

				<!-- MESSAGE SECTION START -->
						<div class="row">
				<div class="col-md-12">
					<strong><s:property
								value="searchResult.message" /></strong>
								</div>
				</div>
				
				
				<div class="row">
					<div class="col-md-12">
					<br>
								</div>
				</div>
				
				<!-- MESSAGE SECTION END -->

				<!-- DIRECT TRAIN SECTION START -->
				<s:if test="searchResult.directTrainList != null && !searchResult.directTrainList.isEmpty()">
							<div class="row">
				<div class="col-md-12">
						<h4><s:text name='result.directTrains' />
						</h4>
						</div></div>
						
						
						<div class="row">
							<div class="col-md-12">
							
							<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th><s:text
											name="result.directTrains.tableHeader.startStation" /></th>
									<th><s:text
											name="result.directTrains.tableHeader.arrivalTime" /></th>
									<th><s:text
											name="result.directTrains.tableHeader.departureTime" /></th>
									<th><s:text
											name="result.directTrains.tableHeader.destinationAndTime" /></th>
									<th><s:text
											name="result.directTrains.tableHeader.endStationAndTime" /></th>
									<th><s:text
											name="result.directTrains.tableHeader.frequency" /></th>
									<th><s:text name="result.directTrains.tableHeader.name" /></th>
									<th><s:text name="result.directTrains.tableHeader.type" /></th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="searchResult.directTrainList"
									var="eachDirectTrain" status="eachDirectTrainStatus">
									<tr>
										<td><s:property value="#eachDirectTrain.startStationName" /></td>
										<td><font color="green"><s:property
													value="#eachDirectTrain.arrivalTime" /></font></td>
										<td><font color="red"><s:property
													value="#eachDirectTrain.depatureTime" /></font></td>
										<td><s:property value="#eachDirectTrain.finalStationName" />
											&nbsp; <s:property
												value="#eachDirectTrain.arrivalTimeFinalStation" /></td>
										<td><s:property value="#eachDirectTrain.endStationName" />
											&nbsp; <s:property
												value="#eachDirectTrain.arrivalTimeEndStation" /></td>
										<td><s:property value="#eachDirectTrain.trainFrequncy" /></td>
										<td><s:property value="#eachDirectTrain.trainName" /></td>
										<td><s:property value="#eachDirectTrain.trainType" /></td>
									</tr>

									<tr style="background: #eee">
										<td colspan="3"><s:if
												test="#eachDirectTrain.classList != null && !#eachDirectTrain.classList.isEmpty()">
												<strong><s:text
														name="result.directTrains.tablefooter.availableClasses" />:</strong>
												<s:iterator value="#eachDirectTrain.classList"
													var="eachClass" status="eachClassStatus">
													<s:property value="#eachClass.className" />
													<s:if test='#eachClassStatus.last != true'>,&nbsp;</s:if>
												</s:iterator>
											</s:if> <s:else>
										&nbsp;
									</s:else></td>
										<td colspan="3"><s:text
												name='result.directTrains.tablefooter.trainEndsText'>
												<%-- <s:param value="#eachDirectTrain.endStationName" />
												<s:param value="#eachDirectTrain.arrivalTimeEndStation" /> --%>
												 <s:param value="#eachDirectTrain.finalStationName" />
												<s:param value="#eachDirectTrain.arrivalTimeFinalStation" />
											</s:text></td>
										<td colspan="2"><strong><s:text
													name='result.directTrains.tablefooter.trainNo' />:</strong> &nbsp;<s:property
												value="#eachDirectTrain.trainNo" /></td>
									</tr>
									<s:if test='#eachDirectTrainStatus.last != true'>
										<tr>
											<td colspan="8"><hr></td>
										</tr>
									</s:if>

								</s:iterator>
							</tbody>
						</table>
						
						</div>
						</div>
					</div>
				</s:if>
				<!-- DIRECT TRAIN SECTION END -->

				<!-- CONNECTING TRAIN SECTION START -->
				<s:if
					test="searchResult.connectingTrainEnvelopList != null && !searchResult.connectingTrainEnvelopList.isEmpty()">
					
					
					<div class="hero-unit">
						<h4>
							<s:text name='result.connectingTrains' />
						</h4>


	<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th><s:text
											name="result.connectingTrains.header.tableHeader.startStation" /></th>
									<th><s:text
											name="result.connectingTrains.header.tableHeader.arrivalTime" /></th>
									<th><s:text
											name="result.connectingTrains.header.tableHeader.departureTime" /></th>
									<th><s:text
											name="result.connectingTrains.header.tableHeader.destination" /></th>
									<th><s:text
											name="result.connectingTrains.header.tableHeader.arrivalTimeDestination" /></th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="searchResult.connectingTrainEnvelopList"
									var="eachConnectingTrainEnvelop"
									status="eachConnectingTrainEnvelopStatus">
									<tr>
										<td><s:property
												value="#eachConnectingTrainEnvelop.header.startName" /></td>
										<td><font color="green"><s:property
													value="#eachConnectingTrainEnvelop.header.startArrivalTime" /></font></td>
										<td><font color="red"><s:property
													value="#eachConnectingTrainEnvelop.header.startDepartureTime" /></font></td>
										<td><s:property
												value="#eachConnectingTrainEnvelop.header.endName" /></td>
										<td><s:property
												value="#eachConnectingTrainEnvelop.header.endArrivalTime" /></td>
										<td id="moreLessTr_<s:property value="%{#eachConnectingTrainEnvelopStatus.index}" />"><a
											href="javascript:showHideTrainList('<s:property value="%{#eachConnectingTrainEnvelopStatus.index}" />',1);"><b><s:text name="label.slr.more"></s:text></b></a></td>
									</tr>
									<tr style="display: none;" id="trainListTr_<s:property value="%{#eachConnectingTrainEnvelopStatus.index}" />">
										<td colspan="6">
										<div id="trainListDiv_<s:property value="%{#eachConnectingTrainEnvelopStatus.index}" />" style="display: none;text-align: left;">
										<span
											id="trainList_<s:property value="%{#eachConnectingTrainEnvelopStatus.index}" />"
											> 
												<div style="height: 20px"></div>
											
											
											<strong>&nbsp;&nbsp;<s:text
														name='result.connectingTrains.trainList' /></strong></span>
											
											
											
											<table class="table"
												id="trainListTable_<s:property value='%{#eachConnectingTrainEnvelopStatus.index}' />"
												>
												<thead>
													<tr>
														<th style="background-color:#66CCFF;"><s:text
																name="result.connectingTrains.trainList.tableHeader.startStation" /></th>
														<th style="background-color:#66CCFF;"><s:text
																name="result.connectingTrains.trainList.tableHeader.startTime" /></th>
														<th style="background-color:#66CCFF;"><s:text
																name="result.connectingTrains.trainList.tableHeader.endStation" /></th>
														<th style="background-color:#66CCFF;"><s:text
																name="result.connectingTrains.trainList.tableHeader.endTime" /></th>
														<th style="background-color:#66CCFF;"><s:text
																name="result.connectingTrains.trainList.tableHeader.name" /></th>
														<th style="background-color:#66CCFF;"><s:text
																name="result.connectingTrains.trainList.tableHeader.trainNo" /></th>
														<th style="background-color:#66CCFF;"><s:text
																name="result.connectingTrains.trainList.tableHeader.availableClasses" /></th>
													</tr>
												</thead>
												<tbody>
												<br>
													<s:iterator
														value="#eachConnectingTrainEnvelop.connectingRouteList"
														var="eachConnectingRoute" status="connectingRouteStatus">
														<tr
															<s:if test='#connectingRouteStatus.first == true'>bgcolor="#D6F5FB"</s:if>>
															<td><s:property
																	value="#eachConnectingRoute.startStation" /></td>
															<td><s:property
																	value="#eachConnectingRoute.startTime" /></td>
															<td><s:property
																	value="#eachConnectingRoute.endStation" /> <s:if
																	test='#eachConnectingRoute.isTransit.equals("1")'>
																	<font color="red"><strong>T</strong></font>
																</s:if></td>
															<td><s:property value="#eachConnectingRoute.endTime" />
															</td>
															<td><s:property
																	value="#eachConnectingRoute.trainName" /></td>
															<td><s:property value="#eachConnectingRoute.trainNo" />
															</td>
															<td><s:if
																	test="#eachConnectingRoute.classList != null && !#eachConnectingRoute.classList.isEmpty()">
																	<s:iterator value="#eachConnectingRoute.classList"
																		var="eachClass" status="eachClassStatus">
																		<s:property value="#eachClass.className" />
																		<s:if test='#eachClassStatus.last == false'>,&nbsp;</s:if>
																	</s:iterator>
																</s:if> <s:else>
											&nbsp;
										</s:else></td>
														</tr>
													</s:iterator>
												</tbody>
											</table>
											 <s:if test='#eachConnectingTrainEnvelopStatus.last != true'>
												<hr>
											</s:if>
											</div>
										</td>
									</tr>
								
							</tbody>
							</s:iterator>
						</table>

</div>
						<div style="height: 20px">
							<span>*&nbsp;<s:text name="enquiry.transit" /></span>
						</div>
						<%-- <div style="height: 20px">
							<span>**&nbsp;<s:text name="enquiry.highlight.firstTrain" /></span>
						</div>
 --%>
					</div>
				</s:if>
				<!-- CONNECTING TRAIN SECTION END -->

				<!-- PRICE SECTION START -->
				<s:if test="priceList != null && !priceList.isEmpty()">
					<div class="hero-unit">
						<h4>
							
							<s:text name="result.ticketPrice" />
						</h4>
						<table>
							<thead>
								<tr>
									<th><s:text
											name="result.ticketPrice.tableHeader.className" /></th>
									<th style="text-align: right;"><s:text name="result.ticketPrice.tableHeader.price" /></th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="priceList" var="eachPrice">
									<tr>
										<td><s:property value="#eachPrice.className" /></td>
										
										<td style="text-align: right;"><s:property value="#eachPrice.priceLKR" /></td>
									</tr>
								</s:iterator>

								<tr>
								
									<td colspan="2"><br><strong><s:text
												name="result.ticketPrice.totalDistance" />:</strong> &nbsp;<s:property
											value="totalDistance" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</s:if>
				<!-- PRICE SECTION END -->
			
			<div id="push"></div>
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
