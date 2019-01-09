<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<String> list = (ArrayList) request.getAttribute("products");

	request.setAttribute("alist", list);
%>

<c:forEach items="${alist}" var="listItem">

	<div class="custom-control custom-checkbox">
		<input type="checkbox" class="custom-control-input"
			id="${listItem.idProduct}"> <label class="custom-control-label"
			for="${listItem.idProduct}">${listItem.name}</label>
	</div>

</c:forEach>

<a class="btn peach-gradient" href="#">Add to cart</a>

