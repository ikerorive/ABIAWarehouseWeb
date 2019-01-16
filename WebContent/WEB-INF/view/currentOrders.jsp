<script>
	var miArray=<%=session.getAttribute("jsonPrueba")%>;
	for (var i = 0; i < miArray.length; i+=1) {
		  console.log("En el índice '" + i + "' hay este valor: " + miArray[i].ORDERDESC);
		}
	
</script>
<p>
	'<%=session.getAttribute("jsonPrueba")%></p>