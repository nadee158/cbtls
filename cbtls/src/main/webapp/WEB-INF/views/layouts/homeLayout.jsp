<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
        <link rel="icon" type="image/png" href="images/favicon.ico" />

        <link rel="stylesheet" type="text/css" href="<c:url value="style/style.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="style/alert.css"/>" />	
        <link rel="stylesheet" type="text/css" href="<c:url value="style/light.css"/>" />

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        
        <script type="text/javascript">
            $(document).ready(function() {            	
            	prepareAlertBlock();
            });
        </script>

		<script type="text/javascript" src='<c:url value="js/scrollpagination.js"  ></c:url>'></script>
    </head>

    <!--BACKGROUND -->
    <body class="tundra" style="background-color:#ffffff; margin:0px;">
        <div style="background-color:#ffffff;">
            <div id="page_wrapper_home_search">
                <div id="header_wrapper_home_search">
                    <!--HEADER & SEARCH-->
                    <tiles:insertAttribute name="header" />				
                </div>
                <div id="middle_wrapper">			
                    <!--SEARCH RESULT-->
                    <tiles:insertAttribute name="body" />				
                </div>
                <div style="clear: both"></div>
            </div>

        </div>
    </body>
</html>
