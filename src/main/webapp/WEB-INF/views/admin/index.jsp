<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>관리자모드</title>

<script src="/static/resources/js/jquery-3.2.1.min.js"></script>

<link rel="stylesheet" href="/static/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/bootstrap/bootstrap-theme.min.css">
<script src="/static/bootstrap/bootstrap.min.js"></script>

<link rel="stylesheet" href="/static/css/admin/index.css">

<link rel="icon" href="/static/images/gun.png" />
<script type='text/javascript'
	src='https://www.gstatic.com/charts/loader.js'></script>
<script type='text/javascript'>
     google.charts.load('current', {
       'packages': ['geochart'],
       // Note: Because markers require geocoding, you'll need a mapsApiKey.
       // See: https://developers.google.com/chart/interactive/docs/basic_load_libs#load-settings
       'mapsApiKey': 'AIzaSyD3Guaksw7kwaeRqFlqjnXR2vpV6ehb2KI'
     });
     google.charts.setOnLoadCallback(drawMarkersMap);

      function drawMarkersMap() {
      var data = google.visualization.arrayToDataTable([
        ['도시',   '업체수']
        ${totalCountList}
      ]);
      

      var options = {
    		  backgroundColor: {fill:'#FFFFFF',stroke:'#FFFFFF' ,strokeWidth:0 },
    			colorAxis:  {minValue: 0, maxValue: 80,  colors: ['F08080', '8FBC8F', '228FBD']},
    			legend: 'none',	
    			backgroundColor: {fill:'#FFFFFF',stroke:'#FFFFFF' ,strokeWidth:0 },	
    			datalessRegionColor: '#f5f5f5',
    			displayMode: 'regions', 
    			enableRegionInteractivity: 'true', 
    			resolution: 'provinces',
    			sizeAxis: {minValue: 1, maxValue:1,minSize:10,  maxSize: 10},
    			region:'KR', //country code
    			keepAspectRatio: true,
    			width:900,
    			height:500,
    			tooltip: {textStyle: {color: '#444444'}, trigger:'focus'}
      };

      var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    };
    </script>
</head>

<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="include/aside.jsp"%>
			</aside>
			<div id="container_box">
				<h2>서비스 업체 현황</h2>
				<div id="chart_div" style="width: 900px; height: 500px;"></div>
			</div>
		</section>
	</div>

	<footer id="footer">
		<div id="footer_box">
			<%@ include file="include/footer.jsp"%>
		</div>
	</footer>

</body>
</html>
