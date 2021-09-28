<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.smilevle.config.util.AreacodeConverter"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>리뷰 목록</title>
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
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

</head>
<body>

	<jsp:include page="/WEB-INF/views/include/common/menu.jsp" />
	<!-- END nav -->

	<div class="hero-wrap js-fullheight"
		style="background-image: url(/static/images/bg_9.jpg);">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-center justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-9 text-center ftco-animate"
					data-scrollax=" properties: { translateY: '70%' }">
					<p class="breadcrumbs"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
						<span class="mr-2"><a href="index.do">Home</a></span> <span>Review</span>
					</p>
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Review</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 sidebar">
					<div class="sidebar-wrap bg-light ftco-animate">
						<h3 class="heading mb-4">리뷰 검색</h3>
						<form action="/review" method="get">
							<div class="fields">
								<div class="form-group">
									<input type="text" class="form-control" id="searchWord"
										name="searchWord" placeholder="숙소 이름으로 검색">
								</div>
								<div class="form-group">
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<select id="searchAreacode" name="searchAreacode"
											class="custom-select">
											<option value="">지역</option>
											<c:forEach var="map"
												items="${AreacodeConverter.getAreaMap() }">
												<option value='${map.value }'>${map.key }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<h3 class="heading mb-4">별점</h3>
								<div class="form-check">
									<input type="radio" class="form-check-input" id="starRate1" name="starRate" value="5.0">
									<label class="form-check-label" for="starRate1">
										<p class="rate">
											<span><i class="icon-star"></i><i class="icon-star"></i><i
												class="icon-star"></i><i class="icon-star"></i><i
												class="icon-star"></i></span>
										</p>
									</label>
								</div>
								<div class="form-check">
									<input type="radio" class="form-check-input" id="starRate2" name="starRate" value="4.0">
									<label class="form-check-label" for="starRate2">
										<p class="rate">
											<span><i class="icon-star"></i><i class="icon-star"></i><i
												class="icon-star"></i><i class="icon-star"></i><i
												class="icon-star-o"></i></span>
										</p>
									</label>
								</div>
								<div class="form-check">
									<input type="radio" class="form-check-input" id="starRate3" name="starRate" value="3.0">
									<label class="form-check-label" for="starRate3">
										<p class="rate">
											<span><i class="icon-star"></i><i class="icon-star"></i><i
												class="icon-star"></i><i class="icon-star-o"></i><i
												class="icon-star-o"></i></span>
										</p>
									</label>
								</div>
								<div class="form-check">
									<input type="radio" class="form-check-input" id="starRate4" name="starRate" value="2.0">
									<label class="form-check-label" for="starRate4">
										<p class="rate">
											<span><i class="icon-star"></i><i class="icon-star"></i><i
												class="icon-star-o"></i><i class="icon-star-o"></i><i
												class="icon-star-o"></i></span>
										</p>
									</label>
								</div>
								<div class="form-check">
									<input type="radio" class="form-check-input" id="starRate5" name="starRate" value="1.0">
									<label class="form-check-label" for="starRate5">
										<p class="rate">
											<span><i class="icon-star"></i><i class="icon-star-o"></i><i
												class="icon-star-o"></i><i class="icon-star-o"></i><i
												class="icon-star-o"></i></span>
										</p>
									</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="${authUser.memberId }" id="myId" name="myId"> <label
										class="form-check-label" for="myId"> 내가 쓴 글 </label>
								</div>
								<div class="form-group">
									<input type="submit" value="Search"
										class="btn btn-primary py-3 px-5">
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="col-lg-9">
					<div class="row">
						<c:if test="${reviewPageVO.hasNoReviews() }">
							<div class="text-center">
								<h2>리뷰 게시글이 존재하지 않습니다!</h2>
							</div>
						</c:if>
						<c:forEach var="review" items="${reviewPage}">
							<div class="col-md-3 d-flex ftco-animate">
								<div class="blog-entry align-self-stretch">
								<c:choose>
									<c:when test="${review.photoUrl eq null }">
									<a
										onClick="location.href='review_read?no=${review.reviewNo }&pageNo=${reviewPageVO.pageNo }'"
										class="block-20"
										style="background-image: url(/static/images/no_image.jpg); cursor: pointer;"></a>
									</c:when>
									<c:otherwise>
									<a
										onClick="location.href='review_read?no=${review.reviewNo}&pageNo=${reviewPageVO.pageNo }'"
										class="block-20"
										style="background-image: url('${review.photoUrl}'); cursor: pointer;"></a>
									</c:otherwise>
								</c:choose>	
									<div class="text p-4 d-block">
										<span class="tag">${AreacodeConverter.getKey(review.areacode) }</span>
										<h3 class="heading mt-3">
											<a
												onClick="location.href='review_read?no=${review.reviewNo }&pageNo=${reviewPageVO.pageNo }'"
												style="cursor: pointer;">${review.title }</a>
										</h3>
										<div class="meta mb-3">
											<div>
												<h6>
													<fmt:formatDate value="${review.regDate}"
														pattern="yyyy.MM.dd" />
												</h6>
											</div>
											<div>${review.writerName }</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="col text-center">
				<nav>
					<div class="block-27">
						<ul>
							<c:if test="${reviewPageVO.startPage > 5 }">
								<li><a id="prevBtn" href="review?pageNo=${reviewPageVO.startPage - 1 }"
									aria-label="이전"> <span>&lt;</span>
								</a></li>
							</c:if>
							<c:forEach var="pNo" begin="${reviewPageVO.startPage }"
								end="${reviewPageVO.endPage }">
								<c:choose>
									<c:when test="${pNo == reviewPageVO.pageNo }">
										<li class="active"><a class="pageBtn" href="review?pageNo=${pNo }">${pNo }</a></li>
									</c:when>
									<c:otherwise>
										<li><a class="pageBtn" href="review?pageNo=${pNo }">${pNo }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${reviewPageVO.endPage < reviewPageVO.lastPage }">
								<li><a id="nextBtn" href="review?pageNo=${reviewPageVO.startPage + 5 }"
									aria-label="다음"> <span>&gt;</span>
								</a></li>
							</c:if>
						</ul>
					</div>
				</nav>
			</div>
		</div>
	</section>

	<footer class="ftco-footer ftco-bg-dark ftco-section">
		<jsp:include page="/WEB-INF/views/include/common/footer.jsp"
			flush="false" />
	</footer>



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
	<script src="/static/js/page.js"></script>
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