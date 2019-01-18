<div class="container" style="width: 100%">

	<table style="width: 100%">
		<tr>
			<td>
				<table id="Table2" style="width: 100%" >
				</table>
			</td>
			<td>
				<!--Vehicle-->
				<div id="chart-ring-vehicle" style="width: 100%"></div>
			</td>
		</tr>
	</table>
	<div style="width: 100%" >
		<div style="color: #ff8000">
			<input id="last" class="btn" type="Button" value="Last"
				onclick="javascript:last()" /> <input id="next" class="btn"
				type="button" value="Next" onclick="javascript:next()" /> Showing <span
				id="begin"></span>-<span id="end"></span> of <span id="size"></span>
			<span id="totalsize"></span>
		</div>
		<!--tabla-->
		<table id="table" class="table table-striped"></table>

	</div>


	<script src="resources/js/d3.js"></script>
	<script src="resources/js/crossfilter.js"></script>
	<script src="resources/js/dc.js"></script>
	<script>
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

		var data =
	<%=session.getAttribute("dataTaskVehicle")%>
		;
		var VehicleRowChart = dc.pieChart("#chart-ring-vehicle");
		var table = dc.dataTable('#table');
		var spendData = [];
		for (var i = 0; i < data.length; i += 1) {
			var x = {
				Name : data[i].idVEHICLE,
				Date : data[i].FINISHDATE,
				Position : data[i].POSNAME,
				Order : data[i].ORDERDESC,
				Spent : '1'
			}
			spendData.push(x);
		}

		// set crossfilter
		var ndx = crossfilter(spendData), spendDim = ndx.dimension(function(d) {//
			return Math.floor(d.Spent);
		}), nameDim = ndx.dimension(function(d) {//
			return d.Name;
		}), spendPerName = nameDim.group().reduceSum(function(d) {//
			return +d.Spent;
		}), spendHist = spendDim.group().reduceCount();

		VehicleRowChart.width(150).dimension(nameDim).group(spendPerName)
				.innerRadius(30).controlsUseVisibility(true);

		table.dimension(spendDim).group(function(d) {
			return d.value;
		}).size(Infinity).sortBy(function(d) {
			return +d.Spent;
		}).showGroups(false).columns([ 'Name', 'Order', 'Date', 'Position' ])
				.order(d3.ascending).on('preRender', update_offset).on(
						'preRedraw', update_offset)
				.on('pretransition', display);

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