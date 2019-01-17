<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link href="resources/MDB-Free_4.6.0/css/mdb.min.css" rel="stylesheet">
<!-- JQuery -->
<script src="resources/MDB-Free_4.6.0/js/jquery-3.3.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script src="resources/MDB-Free_4.6.0/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script src="resources/MDB-Free_4.6.0/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script src="resources/MDB-Free_4.6.0/js/mdb.min.js"></script>
<!-- Your custom styles (optional) -->
<link rel="stylesheet" href="resources/css/stylesheet.css">

<link rel="stylesheet" type="text/css" href="resources/css/dc.css">

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>

	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>
	<div id="section">
		<tiles:insertAttribute name="body" />
	</div>
	<div>
		<tiles:insertAttribute name="footer" />
	</div>


	<!-- SCRIPTS -->


	<script>
		$(function() {
			$('[data-toggle="popover"]').popover()
		})
		console.log("popover enabled")
	</script>
</body>
</html>
