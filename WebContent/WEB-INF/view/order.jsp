<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3 align="center">${headerMessage}</h3>
<form:form action="/SpringMVCFormValidationPruebas/orderSuccess"
	method="post" modelAttribute="order">

	<table>
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
	</table>
</form:form>