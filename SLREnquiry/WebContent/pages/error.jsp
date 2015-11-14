<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title><s:text name='page.title.searchTrain'/></title>
	<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
	<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/css/styles.css" />
	<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.3.custom.min.css" />
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.10.3.custom.min.js"></script>
	
	<script type="text/javascript">
	</script>
	
	<style type="text/css">	
	    
	</style>
	
</head>

<body>
<div id="es-container">
	<jsp:include page="header.jsp" />
	
	<div id="es-content" class="container" >
		<fieldset>
			<legend>&nbsp;&nbsp;<strong><s:text name='page.title.errorPage'/></strong></legend>
			<div class="control-group">
				<h4><font color="red"><s:text name="error.message.systemError" /></font></h4>
			</div>

			<div class="control-group">
    			<a href="<s:url action='homeAction'/>">
					<span><s:text name='enquiry.home'/></span>
				</a>
			</div>
		</fieldset>
		<div id="push"></div>
	</div>
	
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>