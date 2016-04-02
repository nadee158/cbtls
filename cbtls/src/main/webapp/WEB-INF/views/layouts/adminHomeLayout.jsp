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
	    <link href='<c:url value="/css/bootstrap.min.css" />' rel="stylesheet">
	    <!-- MetisMenu CSS -->
	    <link href='<c:url value="/css/metisMenu.min.css" />' rel="stylesheet">
	    <!-- Timeline CSS -->
	    <link href='<c:url value="/css/timeline.css" />' rel="stylesheet">
	    <!-- Custom CSS -->
	    <link href='<c:url value="/css/sb-admin-2.css" />' rel="stylesheet">
	    <!-- Morris Charts CSS -->
	    <link href='<c:url value="/css/morris.css" />' rel="stylesheet">
	    <!-- Custom Fonts -->
	    <link href='<c:url value="/css/font-awesome.min.css" />' rel="stylesheet" type="text/css">
	    
	    <link href='<c:url value="/css/fileinput.min.css" />' rel="stylesheet">
	    
	    <link href='<c:url value="/css/star-rating.min.css" />' rel="stylesheet" type="text/css">
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    
	     <!-- jQuery -->
	    <script src='<c:url value="/js/jquery-2.1.4.min.js" />' type="text/javascript"></script>
	    <!-- Bootstrap Core JavaScript -->
	    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
	    <!-- Metis Menu Plugin JavaScript -->
	    <script src='<c:url value="/js/metisMenu.min.js" />' type="text/javascript"></script>
	    <!-- Morris Charts JavaScript -->
	    <script src='<c:url value="/js/raphael-min.js" />' type="text/javascript"></script>
	    <script src='<c:url value="/js/morris.min.js" />' type="text/javascript"></script>
	    <script src='<c:url value="/js/morris-data.js" />' type="text/javascript"></script>
	    <!-- Custom Theme JavaScript -->
	    <script src='<c:url value="/js/sb-admin-2.js" />' type="text/javascript"></script>
	    
	    <script src='<c:url value="/js/fileinput.min.js" />' type="text/javascript"></script>
    </head>

   <!--BACKGROUND -->
   <body>
     <div id="wrapper">
   	 	<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="sideBar" />
		</nav>
      	<tiles:insertAttribute name="body" />	
       </div>
       
    
   </body>
</html>
