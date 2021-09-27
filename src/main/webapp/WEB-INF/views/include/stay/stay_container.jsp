<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="ftco-section bg-light">
	<div class="container">
		<div class="row justify-content-start mb-5 pb-3">
			<div class="col-md-7 heading-section ftco-animate">
				<h2 class="mb-4">
					<strong>지금 HOT한 숙박업소는? </strong> Stay
				</h2>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="destination-slider owl-carousel ftco-animate">
				<c:forEach var="stay" items="${stayList}">
					<div class="col-sm col-md-6 col-lg ftco-animate">
						<div class="destination" >
							<a href="tourOne?where=32&contentId=${stay.contentId}"
								class="img img-2 d-flex justify-content-center align-items-center"
								style="border: 1px solid #dee2e6; background-image: url(${stay.firstImage})">
								<div
									class="icon d-flex justify-content-center align-items-center">
									<span class="icon-search2"></span>
								</div>
							</a>
							<div class="text p-3">
								<div class="d-flex">
									
										<h3>
											<a href="tourOne?where=32&contentId=${stay.contentId}">${stay.title}</a>
										</h3>
									
									<!-- <div class="two">
										
									</div> -->
								</div>
								<p class="days">
									<span>${stay.address}</span>
								</p>
								<p class="bottom-area d-flex">
									<span></span> <span class="ml-auto"><a href="#">예약하기</a><span>  </span><a href="/review_write?stayId=${stay.contentId }" id="write">리뷰작성</a></span>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>