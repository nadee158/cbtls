<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

 <div class="container">
     <div class="row">
         <div class="col-md-4 col-md-offset-4">
             <div class="login-panel panel panel-default">
                 <div class="panel-heading">
                     <h3 class="panel-title">Please Sign In</h3>
                 </div>
                 <div class="panel-body">
                     <form role="form" method="post" action="<c:url value='/login_check' />" onsubmit="return true" class="form-signin">
                         <fieldset>
                             <div class="form-group">
                                 <input class="form-control" type="text" id="inputEmail" name="username" placeholder="UserName" required autofocus />
                             </div>
                             <div class="form-group">
                                 <input class="form-control" type="password" name="password" id="password" placeholder="Password" required>
                             </div>
<!--                              <div class="checkbox"> -->
<!--                                  <label> -->
<!--                                      <input type="checkbox" name='_spring_security_remember_me' value="remember-me"/>Remember Me -->
<!--                                  </label> -->
<!--                              </div> -->
                             <!-- Change this to a button or input when using this as a form -->
                             <input type="submit" class="btn btn-lg btn-success btn-block" value="Login" />
                         </fieldset>
                     </form>
                 </div>
                 <div class="panel-footer">
                 	 <c:if test="${not empty param.login_error}">
					    <div class="alert alert-danger">
				          INVALID USERNAME OR PASSWORD
				       </div>
					</c:if>
                 </div>
             </div>
         </div>
     </div>
 </div>