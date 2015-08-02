<!DOCTYPE html>
<html lang="en">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <head>
    	<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
        <link rel="icon" type="image/png" href="images/favicon.ico" />

        <link rel="stylesheet" type="text/css" href="<c:url value="css/bootstrap.min.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="css/bootstrap-theme.min.css"/>" />	
        <link rel="stylesheet" type="text/css" href="<c:url value="css/jquery-ui.min.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="css/signin.css"/>" />
        
    </head>

    <body>
        <div>
            <div>                
                <div>			
                    <tiles:insertAttribute name="body" />				
                </div>
                <div style="clear: both"></div>
            </div>

        </div>
    </body>
    <script type="text/javascript" src='<c:url value="js/jquery-2.1.4.min.js"/>' />
    <script type="text/javascript" src="<c:url value="js/ie-emulation-modes-warning.js"/>" />
    <script type="text/javascript" src="<c:url value="js/npm.js"/>" />
    <script type="text/javascript" src="<c:url value="js/ie10-viewport-bug-workaround.js"/>" />
</html>
