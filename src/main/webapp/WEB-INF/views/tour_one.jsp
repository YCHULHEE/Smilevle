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
						<span class="mr-2"><a href="/">Home</a></span> <span class="mr-2"><a
							href="/">Smilevle</a></span> <span>Hotel Single</span>
					</p>
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Smilevle</h1>
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
						<div class="col-md-12 ftco-animate">
							<div class="single-slider owl-carousel">
								<c:forEach var="image" items="${tourData.imageList}">
									<div class="item">
										<div class="hotel-img"
											style="border: 1px solid #dee2e6; background-image: url(${image});"></div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="col-md-12 hotel-single mt-4 mb-5 ftco-animate">
							<p class="bottom-area d-flex" style="margin-bottom: 5px"
								align="right">
								<span class="ml-auto"><a class="btn"
									href="/reservation?contentId=${tourData.tourVO.contentId}&title=${tourData.tourVO.title}">예약</a></span>
							</p>
							<span>관광지</span>
							<h2>${tourData.tourVO.title}</h2>
							<p class="rate mb-5">
								<span class="loc"><a
									href="https://map.naver.com/v5/?c=${tourData.tourVO.mapX},${tourData.tourVO.mapY},15,0,0,0,dh"><i
										class="icon-map"></i>${tourData.tourVO.address}</a></span> <span
									class="star"> <i class="icon-star"></i> <i
									class="icon-star"></i> <i class="icon-star"></i> <i
									class="icon-star"></i> <i class="icon-star-o"></i> 8 Rating
								</span></br> <span>${tourData.tourVO.homepage}</span>
							<p>${tourData.tourVO.content}</p>
						</div>
	</section>
	<jsp:include
		page="/WEB-INF/views/include/common/tour_one_container.jsp" />
	<!-- 댓글 출력 -->

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="pt-5 mt-5">

				<!-- END comment-list -->

				<!-- 댓글 달기 -->

				<div class="comment-form-wrap pt-5">
					<!-- 댓글작성 -->
					<!-- <form action="#" class="p-5 bg-light">
				<div class="form-group">
					<input type="hidden" class="form-control" id="name">
				</div>
				<div class="form-group">
					<input type="hidden" class="form-control" id="email">
				</div>

				<div class="form-group">
					<label for="message">댓글</label>
					<textarea name="" id="message" cols="10" rows="2"
						class="form-control"></textarea>
				</div>
				<div class="form-group">
					<input type="submit" value="댓글 작성"
						class="btn py-3 px-4 btn-primary">
				</div>
			</form> -->
				</div>
				<h3 class="mb-5">댓글(10)</h3>

			</div>

		</div>
		<!-- .col-md-8 -->
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