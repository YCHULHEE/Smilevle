<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="/static/js/jquery-3.2.1.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
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

<link rel="stylesheet" href="/static/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/static/css/jquery.timepicker.css">


<link rel="stylesheet" href="/static/css/flaticon.css">
<link rel="stylesheet" href="/static/css/icomoon.css">
<link rel="stylesheet" href="/static/css/style.css">

<link rel="stylesheet" href="/static/css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="/static/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="/static/css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="/static/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="/static/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="/static/css/style1.css" type="text/css">


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
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">예약 페이지</h1>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div align="center">
		<%-- <c:if test="${today.time lt reservationVO.checkOutDate.time + 24 * 60 * 60 * 1000 * 30 }"> --%>
			<form action="/deleteRes" >
			
			<div style="width: 60%;" id="container">
			<table class="table table-hover">
					<thead>

						<tr align="center">
							<th>예약번호</th>
							<th>호텔이름</th>
							<th>등록일자</th>
							<th>예약날짜</th>
							<th> </th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="reservationVO" items="${reservationVO}">
						<input type="hidden" id="resNum" name="resNum" value="${reservationVO.resNum }">
							<tr align="center">
								<td>${reservationVO.resNum}</td>
								<td>${reservationVO.title}</td>
								<td><fmt:formatDate value="${reservationVO.regDate}" pattern="yyyy년 MM월 dd일" /></td>
								<td><fmt:formatDate value="${reservationVO.checkInDate}" pattern="yyyy년 MM월 dd일" /> ~  <fmt:formatDate value="${reservationVO.checkOutDate}" pattern="yyyy년 MM월 dd일" /></td>
								<c:if test="${reservationVO.checkInDate gt today }">
									<td><button type="submit" class="btn btn-danger">예약취소</button></td>
								</c:if>
								<c:if test="${reservationVO.checkInDate le today }">
									<td><button type="button" id="toList" class="btn btn-default"  onclick="location.href='/review_write?stayId=${reservationVO.contentId }'">리뷰작성</button></td>
								</c:if>  
								
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</form>
			<br>
			<br>
	<%-- 	</c:if> --%>

		
	</div>
	
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
	<script src="/static/js/jquery.timepicker.min.js"></script>
	<script src="/static/js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="/static/js/google-map.js"></script>
	<script src="/static/js/main.js"></script>
</body>
</html>