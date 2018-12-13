<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3 align="center">${headerMessage}</h3>
<form:form action="/SpringMVCFormValidationPruebas/loginSuccess"
	method="post" modelAttribute="userCredential">

	<table>
		<tr>
			<td>Enter Username:</td>
			<td><form:input path="username" /></td>
			<td><form:errors path="username" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Enter Password:</td>
			<td><form:password path="password" /></td>
			<td><form:errors path="password" cssClass="error" /></td>
		</tr>

		<tr>
			<td><input  type="submit" value="Login"></td>
		</tr>
	</table>
</form:form>
