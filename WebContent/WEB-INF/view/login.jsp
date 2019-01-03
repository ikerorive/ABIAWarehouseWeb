<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/SpringMVCFormValidationPruebas/loginSuccess"
	method="post" modelAttribute="userCredential"
	class="text-center p-5">
	<!-- 
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
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>-->


	<p class="h4 mb-4">Sign in</p>

	<!-- Email -->
	<form:input path="username" type="text" id="defaultLoginFormName"
		class="form-control mb-4" placeholder="Username"/>

	<!-- Password -->
	<form:input path="password" type="password" id="defaultLoginFormPassword"
		class="form-control mb-4" placeholder="Password"/>

	<!-- Sign in button -->
	<button class="btn btn-info btn-block my-4 peach-gradient" type="submit">Sign
		in</button>

	<!-- Register -->
	<p>
		Not a member? <a href="/SpringMVCFormValidationPruebas/register">Register</a>
	</p>

	<!-- Default form login -->
</form:form>


