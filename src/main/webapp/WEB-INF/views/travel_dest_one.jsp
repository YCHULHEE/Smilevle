<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>DirEngine - Free Bootstrap 4 Template by Colorlib</title>
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

	<jsp:include page="include/common/menu.jsp" flush="false" />
	<!-- END nav -->

	<div class="hero-wrap js-fullheight"
		style="background-image: url('images/bg_3.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-center justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-9 ftco-animate text-center"
					data-scrollax=" properties: { translateY: '70%' }">
					<p class="breadcrumbs"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
						<span class="mr-2"><a href="index.html">Home</a></span> <span>Tour</span>
					</p>
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Tourlist</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 sidebar">
					<div class="sidebar-wrap bg-light ftco-animate">
						<h3 class="heading mb-4">Find City</h3>
						<form action="#">
							<div class="fields">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Destination, City">
								</div>
								<div class="form-group">
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<select name="" id="" class="form-control"
											placeholder="Keyword search">
											<option value="">Select Location</option>
											<option value="">San Francisco USA</option>
											<option value="">Berlin Germany</option>
											<option value="">Lodon United Kingdom</option>
											<option value="">Paris Italy</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<input type="text" id="checkin_date" class="form-control"
										placeholder="Date from">
								</div>
								<div class="form-group">
									<input type="text" id="checkin_date" class="form-control"
										placeholder="Date to">
								</div>
								<div class="form-group">
									<div class="range-slider">
										<span> <input type="number" value="25000" min="0"
											max="120000" /> - <input type="number" value="50000" min="0"
											max="120000" />
										</span> <input value="1000" min="0" max="120000" step="500"
											type="range" /> <input value="50000" min="0" max="120000"
											step="500" type="range" />
										</svg>
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
					<div class="row">
						<div class="col-md-12 ftco-animate">
							<div class="single-slider owl-carousel">
								<c:forEach var="image" items="${travelDestData.imageList}">
									<div class="item">
										<div class="hotel-img"
											style="background-image: url(${image});"></div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="col-md-12 hotel-single mt-4 mb-5 ftco-animate">
							<span>관광지</span>
							<h2>${travelDestData.travelDest.title}</h2>
							<p class="rate mb-5">
								<span class="loc"><a
									href="https://map.naver.com/v5/?c=${travelDestData.travelDest.mapX},${travelDestData.travelDest.mapY},15,0,0,0,dh"><i
										class="icon-map"></i>${travelDestData.travelDest.address}</a></span> <span
									class="star"> <i class="icon-star"></i> <i
									class="icon-star"></i> <i class="icon-star"></i> <i
									class="icon-star"></i> <i class="icon-star-o"></i> 8 Rating
								</span></br> <span>${travelDestData.travelDestContent.homePage}</span>
							<p>${travelDestData.travelDestContent.content}</p>
						</div>
						<div class="col-md-12 hotel-single ftco-animate mb-5 mt-4">

						</div>

						<div class="col-md-12 hotel-single ftco-animate mb-5 mt-5">
							<h4 class="mb-4">Related Hotels</h4>
							<div class="row">
								<div class="col-md-4">
									<div class="destination">
										<a href="hotel-single.html" class="img img-2"
											style="background-image: url(images/hotel-1.jpg);"></a>
										<div class="text p-3">
											<div class="d-flex">
												<div class="one">
													<h3>
														<a href="hotel-single.html">Hotel, Italy</a>
													</h3>
													<p class="rate">
														<i class="icon-star"></i> <i class="icon-star"></i> <i
															class="icon-star"></i> <i class="icon-star"></i> <i
															class="icon-star-o"></i> <span>8 Rating</span>
													</p>
												</div>
												<div class="two">
													<span class="price per-price">$40<br> <small>/night</small></span>
												</div>
											</div>
											<p>Far far away, behind the word mountains, far from the
												countries</p>
											<hr>
											<p class="bottom-area d-flex">
												<span><i class="icon-map-o"></i> Miami, Fl</span> <span
													class="ml-auto"><a href="#">Book Now</a></span>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 댓글 출력 -->
					</div>
					<div class="pt-5 mt-5">
						<h3 class="mb-5">6 Comments</h3>
						<ul class="comment-list">
							<li class="comment">
								<div class="vcard bio">
									<img src="images/person_1.jpg" alt="Image placeholder">
								</div>
								<div class="comment-body">
									<h3>John Doe</h3>
									<div class="meta">June 27, 2018 at 2:21pm</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Pariatur quidem laborum necessitatibus, ipsam impedit
										vitae autem, eum officia, fugiat saepe enim sapiente iste
										iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
									<p>
										<a href="#" class="reply">Reply</a>
									</p>
								</div>

								<ul class="children">
									<li class="comment">
										<div class="vcard bio">
											<img src="images/person_1.jpg" alt="Image placeholder">
										</div>
										<div class="comment-body">
											<h3>John Doe</h3>
											<div class="meta">June 27, 2018 at 2:21pm</div>
											<p>Lorem ipsum dolor sit amet, consectetur adipisicing
												elit. Pariatur quidem laborum necessitatibus, ipsam impedit
												vitae autem, eum officia, fugiat saepe enim sapiente iste
												iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
											<p>
												<a href="#" class="reply">Reply</a>
											</p>
										</div>


										<ul class="children">
											<li class="comment">
												<div class="vcard bio">
													<img src="images/person_1.jpg" alt="Image placeholder">
												</div>
												<div class="comment-body">
													<h3>John Doe</h3>
													<div class="meta">June 27, 2018 at 2:21pm</div>
													<p>Lorem ipsum dolor sit amet, consectetur adipisicing
														elit. Pariatur quidem laborum necessitatibus, ipsam
														impedit vitae autem, eum officia, fugiat saepe enim
														sapiente iste iure! Quam voluptas earum impedit
														necessitatibus, nihil?</p>
													<p>
														<a href="#" class="reply">Reply</a>
													</p>
												</div>

												<ul class="children">
													<li class="comment">
														<div class="vcard bio">
															<img src="images/person_1.jpg" alt="Image placeholder">
														</div>
														<div class="comment-body">
															<h3>John Doe</h3>
															<div class="meta">June 27, 2018 at 2:21pm</div>
															<p>Lorem ipsum dolor sit amet, consectetur
																adipisicing elit. Pariatur quidem laborum
																necessitatibus, ipsam impedit vitae autem, eum officia,
																fugiat saepe enim sapiente iste iure! Quam voluptas
																earum impedit necessitatibus, nihil?</p>
															<p>
																<a href="#" class="reply">Reply</a>
															</p>
														</div>
													</li>
												</ul>
													<ul class="children">
													<li class="comment">
														<div class="vcard bio">
															<img src="images/person_1.jpg" alt="Image placeholder">
														</div>
														<div class="comment-body">
															<h3>John Doe</h3>
															<div class="meta">June 27, 2018 at 2:21pm</div>
															<p>Lorem ipsum dolor sit amet, consectetur
																adipisicing elit. Pariatur quidem laborum
																necessitatibus, ipsam impedit vitae autem, eum officia,
																fugiat saepe enim sapiente iste iure! Quam voluptas
																earum impedit necessitatibus, nihil?</p>
															<p>
																<a href="#" class="reply">Reply</a>
															</p>
														</div>
													</li>
												</ul>
											</li>
										</ul>
									</li>
								</ul>
							</li>

							<li class="comment">
								<div class="vcard bio">
									<img src="images/person_1.jpg" alt="Image placeholder">
								</div>
								<div class="comment-body">
									<h3>John Doe</h3>
									<div class="meta">June 27, 2018 at 2:21pm</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Pariatur quidem laborum necessitatibus, ipsam impedit
										vitae autem, eum officia, fugiat saepe enim sapiente iste
										iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
									<p>
										<a href="#" class="reply">Reply</a>
									</p>
								</div>
							</li>
						</ul>
						<!-- END comment-list -->

						<!-- 댓글 달기 -->

						<div class="comment-form-wrap pt-5">
							<h3 class="mb-5">댓글(10)</h3>
							<form action="#" class="p-5 bg-light">
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
							</form>
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
	<script src="js/range.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>

</body>
</html>