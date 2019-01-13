<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<String> list = (ArrayList) request.getAttribute("products");

	request.setAttribute("alist", list);
%>
<script>
	function selectProducts() {
		console.log("selected products");
		var checkedBoxes = document
				.querySelectorAll('input[type=checkbox]:checked');
		console.log(checkedBoxes);
		var data1 = [ document.getElementById("destiny").value,
				document.getElementById("description").value ];
		var array = [];
		for (x = 0; x < checkedBoxes.length; x++) {
			array[x] = checkedBoxes[x].id;
		}

		var data = data1.concat(array);
		console.log("DATA " + data);
		$.ajax({
			url : '/SpringMVCFormValidationPruebas/selectProducts',
			type : "POST",
			dataType : 'json',
			data : "data=" + data,
			success : function(data) {

			}
		});

	}
</script>
<p class="h4 mb-4 p-2">Select products</p>
<input id="destiny" class="form-control  mb-4" placeholder="Destiny" />
<input id="description" class="form-control  mb-4"
	placeholder="Description" />

<div class="input-group md-form form-sm form-2 pl-0">
	<input id="searchProduct"
		class="form-control my-0 py-1 amber-border text-white" type="text"
		placeholder="Search" aria-label="Search">
	<div class="input-group-append">
		<span onclick="searchProducts();"
			class="input-group-text amber" id="basic-text1"><i
			class="fas fa-search text-gray" aria-hidden="true"></i></span>
	</div>
</div>

<form id="products" action="selectProducts">
	<c:forEach items="${alist}" var="listItem">
		<div id="productList" class="${listItem.name}">
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

	<a id="productSearchButton" class="btn peach-gradient"
		onclick="selectProducts();">Add to cart</a>



</form>

<script>
	document.getElementById("searchProduct").addEventListener("keydown",
			function(e) {
				if (e.keyCode == 13) {
					searchProducts();
				}
			});

	function searchProducts() {
		if (document.getElementById("searchProduct").value != "") {
			$("#products").children().hide();
			$(
					"div[class*='"
							+ document.getElementById("searchProduct").value
							+ "']").show();
			$("#productSearchButton").show();
		} else {
			$("#products").children().show();
		}
	}
</script>