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
		style="background-image: url('/static/images/bg_4.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-center justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-9 ftco-animate text-center"
					data-scrollax=" properties: { translateY: '70%' }">
					<p class="breadcrumbs"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
						<span class="mr-2"><a href="index.do">Home</a></span> <span>볼거리</span>
					</p>
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">오늘의 볼거리는?</h1>
				</div>
			</div>
		</div>
	</div>


	<section class="ftco-section ftco-degree-bg">
		<div class="container-fluid">
			<div class="row">

				<div class="col-lg-3 sidebar">
					<div class="sidebar-wrap bg-light ftco-animate">
						<h3 class="heading mb-4">Find City</h3>
						<form action="event" method="get">
							<div class="fields">
								<div class="form-group">
									<input type="text" class="form-control" name="searchWord"
										placeholder="이름으로 검색">
								</div>
								<div class="form-group">
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<select name="areaCode" class="form-control"
											placeholder="Keyword search">
											<c:forEach var="map" items="${areaMap}">
												<option value="${map.key}"
													${map.key == areaCode ? 'selected="selected"' : '' }>${map.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<select name="smallCategory" class="form-control"
											placeholder="Keyword search">
											<c:forEach var="map" items="${itemMap}">
												<option value="${map.key}"
													${map.key == smallCategory ? 'selected="selected"' : '' }>${map.value}</option>
											</c:forEach>
										</select> <input type="hidden" name="where" value="${where}">
									</div>
								</div>
								<div class="form-group">
									<input type="submit" value="Search"
										class="btn btn-primary py-3 px-5">
								</div>
							</div>
						</form>
					</div>
					<div class="sidebar-wrap bg-light ftco-animate">
						<h3 class="heading mb-4">Star Rating</h3>
						<form method="post" class="star-rating">
							<div class="form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">
									<p class="rate">
										<span><i class="icon-star"></i><i class="icon-star"></i><i
											class="icon-star"></i><i class="icon-star"></i><i
											class="icon-star"></i></span>
									</p>
								</label>
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">
									<p class="rate">
										<span><i class="icon-star"></i><i class="icon-star"></i><i
											class="icon-star"></i><i class="icon-star"></i><i
											class="icon-star-o"></i></span>
									</p>
								</label>
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">
									<p class="rate">
										<span><i class="icon-star"></i><i class="icon-star"></i><i
											class="icon-star"></i><i class="icon-star-o"></i><i
											class="icon-star-o"></i></span>
									</p>
								</label>
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">
									<p class="rate">
										<span><i class="icon-star"></i><i class="icon-star"></i><i
											class="icon-star-o"></i><i class="icon-star-o"></i><i
											class="icon-star-o"></i></span>
									</p>
								</label>
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">
									<p class="rate">
										<span><i class="icon-star"></i><i class="icon-star-o"></i><i
											class="icon-star-o"></i><i class="icon-star-o"></i><i
											class="icon-star-o"></i></span>
									</p>
								</label>
							</div>
						</form>
					</div>
				</div>


				<div class="col-lg-9">
					<div class="col-lg-10">
					<div class="row d-flex">
						<c:forEach var="item" items="${page.tourList}">
							<div class="col-md-4 d-flex ftco-animate">
								<div class="blog-entry align-self-stretch">
									<a href="tourOne?where=32&contentId=${item.contentId}" class="block-20"
										style="border: 1px solid #dee2e6; background-image: url(${item.firstImage})"> </a>
									<div class="text p-4 d-block">
										<span>여행지</span>
										<h3 class="heading mt-3">
											<a href="tourOne?where=32&contentId=${item.contentId}">${item.title}</a>
										</h3>
										<div class="meta mb-3">
											<div>
												<a href="https://map.naver.com/v5/?c=${item.mapX},${item.mapY},15,0,0,0,dh">${item.address}</a>
											</div>
												<div>
												</div>
											<div>
											</div>
										</div>
										<div class="width-large"><a href="tourOne.do?where=32&contentId=${item.contentId}" class="meta-chat"><span> 조회수 </span><span
													class="icon-chat"></span> ${item.readCnt}</a></div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
								<ul>
									<c:if test="${page.hasStays()}">
										<c:if test="${page.startPage > 5}">
											<li><a id="prevBtn">&lt;</a></li>
										</c:if>
										<c:forEach var="pNo" begin="${page.startPage}"
											end="${page.endPage}">
											<c:choose>
												<c:when test="${pNo eq pageNo}">
													<li class="active"><a class="pageBtn">${pNo}</a></li>
												</c:when>
												<c:otherwise>
													<li><a class="pageBtn">${pNo}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<c:if test="${page.endPage < page.totalPages}">
											<li><a id="nextBtn">&gt;</a></li>
										</c:if>
									</c:if>
								</ul>
							</div>
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
	
	<script src="/static/js/page.js"></script>
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