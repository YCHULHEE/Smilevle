<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet">

    <link rel="stylesheet" href="/static/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/animate.css">
    
    <link rel="stylesheet" href="/static/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/static/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/static/css/magnific-popup.css">

    <link rel="stylesheet" href="/static/css/aos.css">

    <link rel="stylesheet" href="/static/css/ionicons.min.css">

    <link rel="stylesheet" href="/static/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="/static/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="/static/css/flaticon.css">
    <link rel="stylesheet" href="/static/css/icomoon.css">
    <link rel="stylesheet" href="/static/css/style.css">

 <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
    	$(document).ready(function(){
    	   $("#myModal").modal({
    		   backdrop: 'static',
    		   keyboard: false
    	   });
    	   $('#toList').click(function() {
				$(location).attr('href','/myResSelect');
			});
    	});    	   
    </script>
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">삭제 완료!</h4>
	      </div>
	      <div class="modal-body">
			삭제를 완료했습니다!
	      </div>
	      <div class="modal-footer">
		<button type="button" id="toList" class="btn btn-default"  onclick="location.href='/myResSelect'">이전창으로</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script src="/static/js/jquery.min.js"></script>
	<script src="/static/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/static/js/popper.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/jquery.easing.1.3.js"></script>
	<script src="/static/js/jquery.waypoints.min.js"></script>
	<script src="/static/js/jquery.stellar.min.js"></script>
	<script src="/static/js/owl.carousel.min.js"></script>
	<script src="/static/js/jquery.magnific-popup.min.js"></script>
	<script src="/static/js/aos.js"></script>
	<script src="/static/js/jquery.animateNumber.min.js"></script>
	<script src="/static/js/bootstrap-datepicker.js"></script>
	<script src="/static/js/jquery.timepicker.min.js"></script>
	<script src="/static/js/scrollax.min.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="/static/js/google-map.js"></script>
	<script src="/static/js/main.js"></script>
</body>
</html>