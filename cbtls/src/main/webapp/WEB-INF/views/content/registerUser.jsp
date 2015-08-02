<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<form:form action="registerUser.htm" modelAttribute="systemUser" method="post" >
	<table>
		<tr>
			<td>User Name :</td>
			<td>
				<form:input path="userName" />
			</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td>
				<form:input path="password" />
			</td>
		</tr>
		<tr>
			<td>Full name :</td>
			<td>
				<form:input path="userDisplayName" />
			</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>
				<form:input path="emailAddress" />
			</td>
		</tr>
	</table>
	<input type="submit" />
</form:form>