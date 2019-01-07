<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/SpringMVCFormValidationPruebas/taskSuccess"
	method="post" modelAttribute="task">

	<p class="h4 mb-4">Task</p>

	<form:input path="idOrder" type="number" class="form-control  mb-4"
		placeholder="Order id" />
		
	<form:input path="idProduct" type="number" class="form-control  mb-4"
		placeholder="Product id" />

	<form:input path="idVehicle" type="number" class="form-control  mb-4"
		placeholder="Vehicle id" />

	<form:input path="idStatus" type="number" class="form-control  mb-4"
		placeholder="Status id of the task" />

	<!-- Sign up button -->
	<button class="btn btn-info my-4 btn-block peach-gradient"
		type="submit" value="Confirm">Confirm</button>

</form:form>