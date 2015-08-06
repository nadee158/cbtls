<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html lang="en">
    <head>
    	<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    	<meta name="description" content="Community Based Train Locating System">
   		 <meta name="author" content="Nadeeshani Senevirathna">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
        <link rel="icon" type="image/png" href="images/favicon.ico" />
        
        <!-- Bootstrap Core CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>" />
	    <!-- MetisMenu CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/metisMenu.min.css"/>" />
	    <!-- Custom CSS -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/sb-admin-2.css"/>" />
	    <!-- Custom Fonts -->
	    <link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>" />
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
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
    
    <!-- jQuery -->
    <script type="text/javascript" src='<c:url value="/js/jquery-2.1.4.min.js"/>'></script>
    <!-- Bootstrap Core JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/bootstrap.min.js"/>'></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/metisMenu.min.js"/>'></script>
    <!-- Custom Theme JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/sb-admin-2.js"/>'></script>
    
</html>
