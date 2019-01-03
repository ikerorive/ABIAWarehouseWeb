<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/SpringMVCFormValidationPruebas/registerSuccess"
	method="post" modelAttribute="user"
	class="text-center p-5">
	<!-- 
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
			<td><form:input path="password" /></td>
			<td><form:errors path="password" cssClass="error" /></td>
		</tr>

		<tr>
			<td><input type="submit" class="btn btn-primary" value="Confirm"></td>
		</tr>
	</table>


 -->

	<!-- Role -->
	<!--<form:input path="idRole" type="text" id="defaultRegisterFormName"
		class="form-control mb-4" placeholder="Role" />-->
<p class="h4 mb-4">Sign up</p>
	<!-- Username -->
	<form:input path="username" type="text"
		id="defaultRegisterFormFirstName" class="form-control  mb-4"
		placeholder="Username" />
	<!-- Password -->
	<form:input path="password" type="password"
		id="defaultRegisterFormPassword" class="form-control  mb-4"
		placeholder="Password"
		aria-describedby="defaultRegisterFormPasswordHelpBlock" />

	<select name="idRole" class="browser-default custom-select mb-4">
		<option value="" disabled selected>Select Role</option>
		<option value="1">Customer</option>
		<option value="2">Operator</option>
		<option value="3">Manager</option>
	</select>

	<!-- Sign up button -->
	<button class="btn btn-info my-4 btn-block peach-gradient" type="submit"
		value="Confirm">Sign up</button>

	<!-- Terms of service -->
	<p>
		By clicking <em>Sign up</em> you agree to our <a href=""
			target="_blank">terms of service</a>
</form:form>
