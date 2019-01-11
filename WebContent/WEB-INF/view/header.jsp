<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a href="/SpringMVCFormValidationPruebas/"><img
		src="resources/img/ABIAiconWHITE.png" height="36" width="36"></a>
	&emsp;
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"
				href="/SpringMVCFormValidationPruebas/login">Login</a></li>
			<!--<li class="nav-item"><a class="nav-link"
				href="/SpringMVCFormValidationPruebas/register">Register</a></li>-->
			<c:if test="${not empty user}">
				<c:choose>
					<c:when test="${user.idRole==1}">
						<li class="nav-item"><a class="nav-link"
							href="/SpringMVCFormValidationPruebas/productSelection">Customer</a></li>
					</c:when>
					<c:when test="${user.idRole==2}">
						<li class="nav-item"><a class="nav-link"
							href="/SpringMVCFormValidationPruebas/register">Operator</a></li>
					</c:when>
					<c:when test="${user.idRole==3}">
						<li class="nav-item"><a class="nav-link"
							href="/SpringMVCFormValidationPruebas/register">Manager</a></li>
					</c:when>
				</c:choose>

			</c:if>
		</ul>
	</div>
</nav>

