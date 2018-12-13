<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background: linear-gradient(to top, #2980b9, #6dd5fa, #ffffff);
	background-repeat: no-repeat;
	background-attachment: fixed;
}
</style>
</head>
<body>
	<div align="right">
		<tiles:insertAttribute name="header" />
	</div>
	<div align="center">
		<tiles:insertAttribute name="body" />
	</div>
	<div style="clear: both" align="center">
		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>
