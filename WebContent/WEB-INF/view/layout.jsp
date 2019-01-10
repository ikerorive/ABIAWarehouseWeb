<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
<!-- Bootstrap core CSS -->
<!--  <link href="resources/MDB-Free_4.6.0/css/bootstrap.min.css"
	rel="stylesheet">-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<!-- Material Design Bootstrap -->
<link href="resources/MDB-Free_4.6.0/css/mdb.min.css" rel="stylesheet">
<!-- Your custom styles (optional) -->
<link rel="stylesheet" href="resources/css/stylesheet.css" />


<script src="resources/js/topnav.js"></script>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>

	<header id="header"> <tiles:insertAttribute name="header" />
	</header>
	<div id="section" align="center">
		<tiles:insertAttribute name="body" />
	</div>
	<footer style="clear: both"> <tiles:insertAttribute
		name="footer" /> </footer>


	<!-- SCRIPTS -->
	<!-- JQuery -->
	<script type="text/javascript"
		src="resources/MDB-Free_4.6.0/js/jquery-3.3.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="resources/MDB-Free_4.6.0/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="resources/MDB-Free_4.6.0/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="resources/MDB-Free_4.6.0/js/mdb.min.js"></script>
	<script>
		$(function() {
			$('[data-toggle="popover"]').popover()
		})
		console.log("popover enabled")
	</script>
</body>
</html>
