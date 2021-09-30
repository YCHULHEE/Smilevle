<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Smilevle</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="/static/js/jquery-3.2.1.min.js"></script>
<link
	href="https://fonts.googleap-is.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Alex+Brush"
	rel="stylesheet">

<link rel="stylesheet" href="/static/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="/static/css/animate.css">

<link rel="stylesheet" href="/static/css/owl.carousel.min.css">
<link rel="stylesheet" href="/static/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/static/css/magnific-popup.css">

<link rel="stylesheet" href="/static/css/aos.css">

<link rel="stylesheet" href="/static/css/ionicons.min.css">

<!-- <link rel="stylesheet" href="/static/css/bootstrap-datepicker.css"> -->
<link rel="stylesheet" href="/static/css/jquery.timepicker.css">


<link rel="stylesheet" href="/static/css/flaticon.css">
<link rel="stylesheet" href="/static/css/icomoon.css">
<link rel="stylesheet" href="/static/css/style.css">

<link rel="stylesheet" href="/static/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="/static/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/static/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="/static/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="/static/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="/static/css/style1.css" type="text/css">





<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="/static/css/bootstrap-datepicker1.css">



</head>
<body>

	<jsp:include page="/WEB-INF/views/include/common/menu.jsp" />
	<!-- END nav -->

	<div class="hero-wrap js-fullheight"
		style="background-image: url('/static/images/bg_5.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-center justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-9 ftco-animate text-center"
					data-scrollax=" properties: { translateY: '70%' }">
					<p class="breadcrumbs"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
						<span class="mr-2"><a href="/">Home</a></span> <span>숙소</span>
					</p>
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">나와
						오늘 여행 갈래?</h1>
				</div>
			</div>
		</div>
	</div>
	<div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
	</div>

	<section class="room-details-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="room-details-item">
						<img src="/static/img/room/room-details.jpg" alt="">
						<div class="rd-text">
							<div class="rd-title">
								<h3>${title}</h3>
								<div class="rdt-right"></div>
							</div>

						</div>
					</div>

				</div>
				<div class="col-lg-4">
					<div class="room-booking">
						<h3>Your Reservation</h3>
						<form id="resForm" action="/insertRes">
							<div class="check-date">							
								<input type="hidden" id="contentId" name="contentId"
									value="${contentId }"> <input type="hidden" id="title"
									name="title" value="${title }"> <label for="date-in">Check
									In:</label> <input type="text" class="dateIn" id="checkInD"
									name="checkInD" readonly="readonly"> <i class="icon_calendar"></i>
							</div>
							 <div class="check-date">
								<label for="date-out">Check Out:</label> <input type="text"
									class="dateOut" id="checkOutD" name="checkOutD" readonly="readonly"> <i
									class="icon_calendar"></i>
							</div> 

							<button type="submit" class="submit">에약하기</button>
							
						</form>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- .section -->

	<jsp:include page="/WEB-INF/views/include/common/footer.jsp"
		flush="false" />



	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>
	<script>
	$(document).ready(function(){ 
		$(".submit").click(function(){
		if($("#checkInD").val().length==0){ alert("체크인 날짜를 입력하세요."); $("#checkInDate").focus(); return false; }
		if($("#checkOutD").val().length==0){ alert("체크아웃 날짜를 입력하세요."); $("#checkOutDate").focus(); return false; }
		});
		
	});
	</script>
	<script>	
		$(function() {
			$('.dateIn').datepicker({
				format : "yyyy-mm-dd", //데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
				//datesDisabled : ['2021-09-29','2021-09-30'],
				startDate : '0d', //달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
				//endDate : '+10d', //달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
				autoclose :false, //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
				calendarWeeks : false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
				clearBtn : true, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
				datesDisabled : ${reservationDate}, //선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함.
				//daysOfWeekDisabled : [ 0, 6 ], //선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
				//daysOfWeekHighlighted : [ 3 ], //강조 되어야 하는 요일 설정
				disableTouchKeyboard : false, //모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
				immediateUpdates : false, //사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
				multidate : false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
				multidateSeparator : ",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
				templates : {
					leftArrow : '&laquo;',
					rightArrow : '&raquo;'
				}, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
				showWeekDays : true,// 위에 요일 보여주는 옵션 기본값 : true
				title : "날짜선택", //캘린더 상단에 보여주는 타이틀
				todayHighlight : true, //오늘 날짜에 하이라이팅 기능 기본값 :false 
				toggleActive : true, //이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
				weekStart : 0,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
				language : "ko" //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
				

			});//datepicker end	
			$('.dateOut').datepicker({
				format : "yyyy-mm-dd", //데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
				//datesDisabled : ['2021-09-29','2021-09-30'],
				startDate : '0d', //달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
				//endDate : '+10d', //달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
				autoclose :false, //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
				calendarWeeks : false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
				clearBtn : true, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
				datesDisabled : ${reservationDate}, //선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함.
				//daysOfWeekDisabled : [ 0, 6 ], //선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
				//daysOfWeekHighlighted : [ 3 ], //강조 되어야 하는 요일 설정
				disableTouchKeyboard : false, //모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
				immediateUpdates : false, //사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
				multidate : false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
				multidateSeparator : ",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
				templates : {
					leftArrow : '&laquo;',
					rightArrow : '&raquo;'
				}, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
				showWeekDays : true,// 위에 요일 보여주는 옵션 기본값 : true
				title : "날짜선택", //캘린더 상단에 보여주는 타이틀
				todayHighlight : true, //오늘 날짜에 하이라이팅 기능 기본값 :false 
				toggleActive : true, //이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
				weekStart : 0,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
				language : "ko" //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.

			});//datepicker end	
		});//ready end
		
		
	</script>
	
	
	<script src="/static/js/jquery-3.2.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/jquery.magnific-popup.min.js"></script>
	<script src="/static/js/jquery.nice-select.min.js"></script>
	<script src="/static/js/jquery-ui.min.js"></script>
	<script src="/static/js/jquery.slicknav.js"></script>
	<script src="/static/js/owl.carousel.min.js"></script>
	<script src="/static/js/main1.js"></script>
	


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
	<script src="/static/js/bootstrap-datepicker.ko.js"></script>
	<script src="/static/js/jquery.timepicker.min.js"></script>
	<script src="/static/js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="/static/js/google-map.js"></script>
	<script src="/static/js/main.js"></script>
	
	
</body>
</html>