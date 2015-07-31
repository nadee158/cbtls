<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<form method="post" action="<c:url value='/login_check' />" onsubmit="return true" class="form-signin">
		<h2 class="form-signin-heading">Please sign in</h2>
		
		<label for="inputEmail" class="sr-only">UserName</label>
		<input type="text" class="form-control" id="inputEmail" name="username" placeholder="UserName" required autofocus/>
			
		<label for="inputPassword" class="sr-only">Password</label>
		<input type="password" name="password" class="form-control" id="password" placeholder="Password" required />
			
		<div class="checkbox">
			<label> <input type="checkbox" name='_spring_security_remember_me' value="remember-me">
				Remember me
			</label>
		</div>
		<input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in" />



	</form>

	<c:if test="${not empty param.login_error}">
		<div style="margin-top: 30px;" class="error_message">INVALID
			USERNAME, OR PASSWORD</div>
	</c:if>

</div>
<!-- /container -->