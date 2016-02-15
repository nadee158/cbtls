<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>  

     <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home.htm">CBTLS</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="admin/adminHome.htm"><spring:message code="label.adminDashboard"/></a>
                    </li>                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <sec:authorize access="isAnonymous()">
                        	<spring:message code="label.userProfile"/>
                        </sec:authorize>	
                        <sec:authorize access="isAuthenticated()">
                        	<spring:message code="label.youAreLoggedInAs"/> <sec:authentication property="principal.username" />
                        </sec:authorize>
                        <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                        	<sec:authorize access="isAnonymous()">
	                            <li>
	                                <a href="userLogin.htm"><spring:message code="label.signIn"/></a>
	                            </li>
	                            <li>
	                                <a href="registerUser.htm"><spring:message code="label.signUp"/></a>
	                            </li>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
	                            <li>
	                                <a href="user/userProfile.htm"><spring:message code="label.updateProfile"/></a>
	                            </li>
	                            <li>
	                            	<a href="<c:url value="/j_spring_security_logout" />"><spring:message code="label.logout"/></a>
	                            </li>
                            </sec:authorize>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="label.select.language"/><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="?lang=en"><spring:message code="label.english"/></a>
                            </li>
                            <li>
                                <a href="?lang=si"><spring:message code="label.sinhala"/></a>
                            </li>
                            <li>
                                <a href="?lang=ta"><spring:message code="label.tamil"/></a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>