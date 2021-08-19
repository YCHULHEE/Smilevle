<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="ftco-section bg-light">
	<div class="container">
		<div class="row justify-content-start mb-5 pb-3">
			<div class="col-md-7 heading-section ftco-animate">
				<span class="subheading">Special Offers</span>
				<h2 class="mb-4">
					<strong>여행자 클럽</strong> Review
				</h2>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="destination-slider owl-carousel ftco-animate">
			<c:forEach var="stay" items="${stayList}">
				<div class="col-sm col-md-6 col-lg ftco-animate">
					<div class="destination">
						<a href="#" class="img img-2 d-flex justify-content-center align-items-center"
						style="background-image: url(${stay.firstImage})">
							<div class="icon d-flex justify-content-center align-items-center">
								<span class="icon-search2"></span>
							</div>
						</a>
						<div class="text p-3">
							<div class="d-flex">
								<div class="one">
									<h3>
										<a href="#">${stay.title}</a>
									</h3>
									<p class="rate">
										<i class="icon-star"></i> <i class="icon-star"></i> <i
											class="icon-star"></i> <i class="icon-star"></i> <i
											class="icon-star-o"></i> <span>8 Rating</span>
									</p>
								</div>
								<div class="two">
									<span class="price">$200</span>
								</div>
							</div>
							<p>Far far away, behind the word mountains, far from the
								countries</p>
							<p class="days">
								<span>${stay.address }</span>
							</p>
							<hr>
							<p class="bottom-area d-flex">
								<span><i class="icon-map-o"></i> San Franciso, CA</span> <span
									class="ml-auto"><a href="#">Discover</a></span>
							</p>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>