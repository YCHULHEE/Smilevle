<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>숙박</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Alex+Brush"
	rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">


<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<jsp:include page="/WEB-INF/views/include/common/menu.jsp" />
	<!-- END nav -->

	<div class="hero-wrap js-fullheight"
		style="background-image: url('images/bg_5.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-center justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-9 ftco-animate text-center"
					data-scrollax=" properties: { translateY: '70%' }">
					<p class="breadcrumbs"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
						<span class="mr-2"><a href="index.do">Home</a></span> <span>숙소</span>
					</p>
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">나와 오늘 여행 갈래?</h1>
				</div>
			</div>
		</div>
	</div>


	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				
				<jsp:include page="/WEB-INF/views/include/common/search_box.jsp" />
				
				<div class="col-lg-9">
					<div class="row">
						<c:forEach var="stay" items="${stayPage.stayList}">
							<div class="col-md-4 ftco-animate">
								<div class="destination">
									<a href="stayOne.do?contentId=${stay.contentId}"
										class="img img-2 d-flex justify-content-center align-items-center"
										style="background-image: url(${stay.firstImage});">
										<div
											class="icon d-flex justify-content-center align-items-center">
											<span class="icon-search2"></span>
										</div>
									</a>
									<div class="text p-3">
										<div class="d-flex">
											<div class="one">
												<h3>
													<a href="stayOne.do?contentId=${stay.contentId}">${stay.title}</a>
												</h3>
												<p class="rate">
													<i class="icon-star"></i> <i class="icon-star"></i> <i
														class="icon-star"></i> <i class="icon-star"></i> <i
														class="icon-star-o"></i> <span>8 Rating</span>
												</p>
											</div>
											<div class="two">
												<p class="bottom-area d-flex">
												<span class="ml-auto"><a href="#">예약</a></span></p>
											</div>
										</div>
										<div class="four">
										<p class="rate">
											${stay.tel}
										</p>
										<i class="icon-map-o"></i><a href="https://map.naver.com/v5/?c=${stay.mapX},${stay.mapY},15,0,0,0,dh"
										 style="color: #4d4d4d">${stay.address}</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
			
								<ul>
									<c:if test="${stayPage.hasStays()}">
										<c:if test="${stayPage.startPage > 5}">
											<li><a href="stay.do?pageNo=${stayPage.startPage - 5}">&lt;</a></li>
										</c:if>
										<c:forEach var="pNo" begin="${stayPage.startPage}"
												end="${stayPage.endPage}">
											<c:choose>
												<c:when test="${pNo eq pageNo}">
													<li class="active"><span>${pNo}</span></li>
												</c:when>
												<c:otherwise>
													<li><a href="stay.do?pageNo=${pNo}">${pNo}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<c:if test="${stayPage.endPage < stayPage.totalPages}">
											<li><a href="stay.do?pageNo=${stayPage.startPage + 5}">&gt;</a></li>
										</c:if>
									</c:if>
								</ul>

								
							</div>
						</div>
					</div>
				</div>
				<!-- .col-md-8 -->
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


	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/jquery.timepicker.min.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>

</body>
</html>