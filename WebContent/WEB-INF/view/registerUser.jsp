<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:form action="/SpringMVCFormValidationPruebas/registerSuccess"
	method="post" modelAttribute="user" class="text-center p-5">

	<!-- Role -->
	<!--<form:input path="idRole" type="text" id="defaultRegisterFormName"
		class="form-control mb-4" placeholder="Role" />-->
	<p class="h4 mb-4">Register</p>
	<!-- Username -->
	<form:input path="username" type="text"
		id="defaultRegisterFormFirstName" class="form-control  mb-4"
		placeholder="Username" />
	<!-- Password -->
	<form:input path="password" type="password"
		id="defaultRegisterFormPassword" class="form-control  mb-4"
		placeholder="Password"
		aria-describedby="defaultRegisterFormPasswordHelpBlock" />

	<select id="hideSelect" name="idRole"
		class="browser-default custom-select mb-4">
		<option value="1" selected>Customer</option>
	</select>
	<!-- Sign up button -->
	<button class="btn btn-info my-4 btn-block peach-gradient"
		type="submit" value="Confirm">Sign up</button>

</form:form>
