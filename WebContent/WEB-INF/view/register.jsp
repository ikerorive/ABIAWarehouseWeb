<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3 align="center">${headerMessage}</h3>
<form:form action="/SpringMVCFormValidationPruebas/registerSuccess"
	method="post" modelAttribute="user">

	<table>
		<tr>
			<td>Enter Role (number):</td>
			<td><form:input path="idRole" /></td>
			<td><form:errors path="idRole" cssClass="error" /></td>
		</tr>
	
		<tr>
			<td>Enter Username:</td>
			<td><form:input path="username" /></td>
			<td><form:errors path="username" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Enter Password:</td>
			<td><form:input path="password" /></td> <!-- <td><form:password path="password" /></td> -->
			<td><form:errors path="password" cssClass="error" /></td>
		</tr>

		<tr>
			<td><input  type="submit" value="Confirm"></td>
		</tr>
	</table>
</form:form>
