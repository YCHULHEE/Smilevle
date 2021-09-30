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

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>


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
    			width:600,
    			height:400,
    			tooltip: {textStyle: {color: '#444444'}, trigger:'focus'}
      };
	
      
      var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));
   
      chart.draw(data, options);
      

      
      google.visualization.events.addListener(chart, 'select', selectHandler);
      
     

      function selectHandler() {
    	  var localName = data.getValue(chart.getSelection()[0].row, 0);
    	  google.load("visualization", "1", {packages:["corechart"]}); 
          google.setOnLoadCallback(drawChart); 
          
          function drawChart() {       
    	  $.ajax(
    	        	{  
    	   				type:"POST",
    	              url: "/selectChart", 
    	              dataType: "text",
    	              contentType: "application/x-www-form-urlencoded; charset=UTF-8",
    	              data: localName,
    	              success: function selectChart(data) {
    	            	 
    	            	  /* var arrNumber = new Array();
    	            	  arrNumber = data; */
    	            	 var data3 = data.replace(/'/g, '"');
    	            	 var data2 = google.visualization.arrayToDataTable(JSON.parse(data3)); 
    	                 var options2 = { title: localName }; 
    	                 var chart2 = new google.visualization.PieChart(document.getElementById("employee_piechart")); 
    	                 chart2.draw(data2, options2); 
    	              }
    	        	});  
    	          }
     
      		
    	  
 	  }
      


      
      /* function selectChart() {
    	 alert("hi");
    	 var data2 = google.visualization.arrayToDataTable( [["Employee","Rating"],["Suresh",25],["Amit",56],["Rahul",37],["Lucky",71],["Pooja",11],["Manoj",49]] ); 
         var options2 = { title: data.getValue(chart.getSelection()[0].row, 0) }; 
         var chart2 = new google.visualization.PieChart(document.getElementById("employee_piechart")); 
         chart2.draw(data2, options2); 
      } */
      
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
				<div>
					<div id="chart_div" style="display: inline-block;"></div>
					<div id="employee_piechart" style="width:550px; height: 400px; display: inline-block;"></div>
				</div>
		</section>
	</div>

</body>
</html>
