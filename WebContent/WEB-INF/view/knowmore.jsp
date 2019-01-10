<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<String> list = (ArrayList) request.getAttribute("products");

	request.setAttribute("alist", list);
%>
<script>
	function selectProducts() {
		console.log("selected products")
		var checkedBoxes = document
				.querySelectorAll('input[type=checkbox]:checked');
		console.log(checkedBoxes);

	}
</script>

<form id="products" action="selectProducts">
	<c:forEach items="${alist}" var="listItem">
		<div id="productList">
			<div class="custom-control custom-checkbox">
				<input type="checkbox" class="custom-control-input"
					id="${listItem.idProduct}"> <label
					class="custom-control-label" for="${listItem.idProduct}">${listItem.name}</label>


			</div>

			&nbsp; &nbsp; &nbsp; &nbsp; <i class="fas fa-info-circle"
				data-toggle="popover" data-content="${listItem.description}"
				data-trigger="hover"></i>
		</div>
	</c:forEach>

	<a class="btn peach-gradient" onclick="selectProducts();">Add to
		cart</a>

</form>