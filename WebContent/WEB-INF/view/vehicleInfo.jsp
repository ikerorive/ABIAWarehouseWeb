<div class="container" style="width: 100%">

	

	<!--Vehicle-->
	<div id="chart-ring-vehicle" style="width: 100%"></div>

	<div style="padding: 100px"; >
		<div align="left" style="color: #ff8000">
			<input id="last" class="btn" type="Button" value="Last"
				onclick="javascript:last()" /> <input id="next" class="btn"
				type="button" value="Next" onclick="javascript:next()" /> Showing <span
				id="begin"></span>-<span id="end"></span> of <span id="size"></span>
			<span id="totalsize"></span>
		</div>
		<!--tabla-->
		<table id="table" class="table table-striped";></table>

	</div>


	<script type="text/javascript" src="resources/js/d3.js"></script>
	<script type="text/javascript" src="resources/js/crossfilter.js"></script>
	<script type="text/javascript" src="resources/js/dc.js"></script>
	<script type="text/javascript">
		var data =<%=session.getAttribute("dataTaskVehicle")%>;
		console.log(data);
		
		var spenderRowChart = dc.rowChart("#chart-ring-vehicle");

		var table = dc.dataTable('#table');

		var spendData=[];
		for (var i = 0; i < data.length; i += 1) {
			var x= {
					Name : data[i].idVEHICLE,
					date : data[i].FINISHDATE,
					Posicion : data[i].POSNAME,
					Order : data[i].ORDERDESC,
					Spent : '1'
				}
			spendData.push(x);
		}

		// set crossfilter
		var ndx = crossfilter(spendData), orderDim = ndx.dimension(function(d) {
			return d.Order
		}), yearDim = ndx.dimension(function(d) {
			return +d.Year;
		}),

		spendDim = ndx.dimension(function(d) {
			return Math.floor(d.Spent);
		}), nameDim = ndx.dimension(function(d) {
			return d.Name;
		}), proDim = ndx.dimension(function(d) {
			return d.Productos;
		}), spendPerYear = yearDim.group().reduceSum(function(d) {
			return +d.Spent;
		}), spendPerName = nameDim.group().reduceSum(function(d) {
			return +d.Spent;
		}), spendHist = spendDim.group().reduceCount();
		spenPerOrder = orderDim.group().reduceSum(function(d) {
			return +d.Spent;
		}), spenPerProduc = proDim.group().reduceSum(function(d) {
			return +d.Spent;
		}),

		spenderRowChart.dimension(nameDim).group(spendPerName).elasticX(true)
		.controlsUseVisibility(true);

		table.dimension(spendDim).group(function(d) {
			return d.value;
		}).size(Infinity).sortBy(function(d) {
			return +d.Spent;
		}).showGroups(false).columns([ 'Name', 
			{
			label : 'Order',
			format : function(d) {
				return d.Order;
			}
		},
		'date','Posicion'
		
		/* 'Year', {
			label : 'Product',
			format : function(d) {
				return d.Productos;
			}
		} */]).order(d3.ascending).on('preRender', update_offset).on('preRedraw',
				update_offset).on('pretransition', display);
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