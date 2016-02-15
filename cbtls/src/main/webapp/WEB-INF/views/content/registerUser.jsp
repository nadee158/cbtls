<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>User Registration</h3>
<form:form cssClass="form-horizontal" role="form" action="registerUser.htm" modelAttribute="systemUser" method="post" >
  <div class="form-group">
    <label class="control-label col-sm-2" for="userDisplayName">Full name :</label>
    <div class="col-sm-10">
      <input type="text" name="userDisplayName" class="form-control" id="userDisplayName" placeholder="Enter Full Name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="userDisplayName">Email :</label>
    <div class="col-sm-10">
      <input type="email" name="emailAddress" class="form-control" id="emailAddress" placeholder="Enter Email">
    </div>
  </div>	
  <div class="form-group">
    <label class="control-label col-sm-2" for="userName">User Name :</label>
    <div class="col-sm-10">
      <input type="text" name="userName" class="form-control" id="userName" placeholder="Enter user name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-10"> 
      <input type="password" name="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="conpwd">Confirm Password:</label>
    <div class="col-sm-10"> 
      <input type="password" class="form-control" id="conpwd" placeholder="Confirm password">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form:form>