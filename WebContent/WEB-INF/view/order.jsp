<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="/SpringMVCFormValidationPruebas/orderSuccess"
	method="post" modelAttribute="order">

	<!--  <table>
		<tr>
			<td>Id user (number):</td>
			<td><form:input path="idUser" /></td>
			<td><form:errors path="idUser" cssClass="error" /></td>
		</tr>
	
		<tr>
			<td>Enter order status:</td>
			<td><form:input path="idOrderStatus" /></td>
			<td><form:errors path="idOrderStatus" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Enter order description:</td>
			<td><form:input path="orderDesc" /></td>
			<td><form:errors path="orderDesc" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Enter destination:</td>
			<td><form:input path="destino" /></td>
			<td><form:errors path="destino" cssClass="error" /></td>
		</tr>

		<tr>
			<td><input  type="submit" value="Confirm"></td>
		</tr>
	</table> -->

	<p class="h4 mb-4">Order</p>
	<!-- Id user -->
	<form:input path="idUser" type="number" class="form-control  mb-4"
		placeholder="User id" />
		
	<!-- Id order status (hidden) -->
	<form:input path="idOrderStatus" type="hidden"
		class="form-control  mb-4" value="1" />

	<!-- Username -->
	<form:input path="orderDesc" type="text" class="form-control  mb-4"
		placeholder="Order description" />

	<!-- Username -->
	<form:input path="destino" type="number" class="form-control  mb-4"
		placeholder="Destiny of the order" />

	<!-- Sign up button -->
	<button class="btn btn-info my-4 btn-block peach-gradient"
		type="submit" value="Confirm">Confirm</button>


</form:form>