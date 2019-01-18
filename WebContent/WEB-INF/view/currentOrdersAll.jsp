<div class="container" style="width: 100%">

	<table style="width: 100%">
		<tr>
			<td>
				<table id="Table2" style="padding: 20px" border="1b" display:"inline-block">
				</table>
			</td>
			<td>
				<table id="Table3" style="padding: 20px" border="1b" display:"inline-block">
				</table>
			</td>
			<td>
				<!--Productos-->
				<div style="padding: 20px">
					<div id="chart-hist-product" style="width: 100%"></div>
				</div>
			</td>
		</tr>
	</table>
	<div style="width: 100%" >
		<div align="left" style="color: #ff8000">
			<input id="last" class="btn" type="Button" value="Last"
				onclick="javascript:last()" /> <input id="next" class="btn"
				type="button" value="Next" onclick="javascript:next()" /> Showing <span
				id="begin"></span>-<span id="end"></span> of <span id="size"></span>
			<span id="totalsize"></span>
		</div>
		<!--tabla-->
		<table id="table" class="table table-striped"></table>

	</div>


	<script type="text/javascript" src="resources/js/d3.js"></script>
	<script type="text/javascript" src="resources/js/crossfilter.js"></script>
	<script type="text/javascript" src="resources/js/dc.js"></script>
	<script type="text/javascript">
		var data2 =
	<%=session.getAttribute("dataVehicle")%>
		$("#Table2").append(
				'<tr><td><b><u>ID</u></b></td>'
						+ '<td><b><u>Status</u></b></td>'
						+ '<td><b><u>Position</u></b></td>');
		for (var o = 0; o < data2.length; o += 1) {
			$("#Table2").append(
					'<tr>' + '<td align="center" style="dislay: none;">'
							+ data2[o].idVEHICLE + '</td>'
							+ '<td align="center" style="dislay: none;">'
							+ data2[o].STATUSNAME + '</td>'
							+ '<td align="center" style="dislay: none;">'
							+ data2[o].POSNAME + '</td>' + '</tr>');
		}
		var data3 =
	<%=session.getAttribute("dataTask")%>
		$("#Table3").append(
				'<tr><td><b><u>Orden</u></b></td>'
						+ '<td><b><u>Date</u></b></td>'
						+ '<td><b><u>User</u></b></td>'
						+ '<td><b><u>Product</u></b></td>');
		for (var o = 0; o < data3.length; o += 1) {
			$("#Table3").append(
					'<tr>' + '<td align="center" style="dislay: none;">'
							+ data3[o].ORDERDESC + '</td>'
							+ '<td align="center" style="dislay: none;">'
							+ data3[o].DATE + '</td>'
							+ '<td align="center" style="dislay: none;">'
							+ data3[o].USERNAME + '</td>'
							+ '<td align="center" style="dislay: none;">'
							+ data3[o].NAME + '</td>');
		}

		var data =
	<%=session.getAttribute("dataProduct")%>
		;

		var spendHistChart = dc.barChart("#chart-hist-product");//.xAxisLabel('Workstation');

		var table = dc.dataTable('#table');

		var spendData = [];
		for (var i = 0; i < data.length; i += 1) {
			var x = {
				Position : data[i].POSNAME,
				Productos : data[i].NAME,
				ID : data[i].idPRODUCT,
				Spent : '1'
			}
			spendData.push(x);
		}

		// normalize/parse data
		spendData.forEach(function(d) {
			d.Spent = d.Spent.match(/\d+/)[0];
		});

		// set crossfilter
		var ndx = crossfilter(spendData), spendDim = ndx.dimension(function(d) {
			return Math.floor(d.Spent);
		}), posDim = ndx.dimension(function(d) {
			return d.Position;
		}), spendHist = spendDim.group().reduceCount();
		spenPerPos = posDim.group().reduceSum(function(d) {
			return +d.Spent;
		}),

		//barra vertical
		spendHistChart.dimension(posDim).group(spenPerPos).x(d3.scaleBand())
				.xUnits(dc.units.ordinal).elasticY(true).controlsUseVisibility(
						true);

		table.dimension(spendDim).group(function(d) {
			return d.value;
		}).size(Infinity).sortBy(function(d) {
			return +d.Spent;
		}).showGroups(false).columns([ 'ID', {
			label : 'Product',
			format : function(d) {
				return d.Productos;
			}
		}, 'Position' ]).order(d3.ascending).on('preRender', update_offset).on(
				'preRedraw', update_offset).on('pretransition', display);

		var ofs = 0, pag = 5;
		function update_offset() {
			var totFilteredRecs = ndx.groupAll().value();
			var end = ofs + pag > totFilteredRecs ? totFilteredRecs : ofs + pag;
			ofs = ofs >= totFilteredRecs ? Math.floor((totFilteredRecs - 1)
					/ pag)
					* pag : ofs;
			ofs = ofs < 0 ? 0 : ofs;

			table.beginSlice(ofs);
			table.endSlice(ofs + pag);
		}
		function display() {
			var totFilteredRecs = ndx.groupAll().value();
			var end = ofs + pag > totFilteredRecs ? totFilteredRecs : ofs + pag;
			d3.select('#begin').text(end === 0 ? ofs : ofs + 1);
			d3.select('#end').text(end);
			d3.select('#last').attr('disabled', ofs - pag < 0 ? 'true' : null);
			d3.select('#next').attr('disabled',
					ofs + pag >= totFilteredRecs ? 'true' : null);
			d3.select('#size').text(totFilteredRecs);
			if (totFilteredRecs != ndx.size()) {
				d3.select('#totalsize').text(
						"(filtered Total: " + ndx.size() + " )");
			} else {
				d3.select('#totalsize').text('');
			}
		}
		function next() {
			ofs += pag;
			update_offset();
			table.redraw();
		}
		function last() {
			ofs -= pag;
			update_offset();
			table.redraw();
		}
		dc.renderAll();
	</script>

</div>