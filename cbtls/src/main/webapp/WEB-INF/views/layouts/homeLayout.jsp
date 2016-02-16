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
	    <!-- Custom Fonts -->
	    <link href='<c:url value="/css/font-awesome.min.css" />' rel="stylesheet" type="text/css">
	     <link href='<c:url value="/css/jquery-ui.min.css" />' rel="stylesheet" type="text/css">
	      <link href='<c:url value="/css/jquery.timepicker.css" />' rel="stylesheet" type="text/css">
	      <link href='<c:url value="/css/bootstrap-datepicker.css" />' rel="stylesheet" type="text/css">
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    <style type="text/css">
	    	body {
			    padding-top: 70px; /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
			}
			
			footer {
			    margin: 50px 0;
			}
	    
	    </style>
	      <!-- jQuery -->
		    <script src='<c:url value="/js/jquery-2.1.4.min.js" />' type="text/javascript"></script>
		    <script src='<c:url value="/js/jquery-ui.js" />' type="text/javascript"></script>
		    <!-- Bootstrap Core JavaScript -->
		    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
		    
		    <script src='<c:url value="/js/jquery.timepicker.js" />' type="text/javascript"></script>
		    <script src='<c:url value="/js/datepair.js" />' type="text/javascript"></script>
		    <script src='<c:url value="/js/jquery.datepair.js" />' type="text/javascript"></script>
		    <script src='<c:url value="/js/bootstrap-datepicker.js" />' type="text/javascript"></script>
		    
    </head>

    <body>
      	  <tiles:insertAttribute name="header" />				
          <!-- Page Content -->
    	  <div class="container">		
             <tiles:insertAttribute name="body" />				
         	<tiles:insertAttribute name="footer" />	
         </div>
         <div style="clear: both"></div>
            
    </body>
    
</html>
