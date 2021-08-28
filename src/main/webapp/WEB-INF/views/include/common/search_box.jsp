<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<c:forEach var="areaMap" items="${areaMap}">
								<option value="">${areaMap.key}</option>
							</c:forEach>
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
						</span> <input value="1000" min="0" max="120000" step="500" type="range" />
						<input value="50000" min="0" max="120000" step="500" type="range" />
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
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">
					<p class="rate">
						<span><i class="icon-star"></i><i class="icon-star"></i><i
							class="icon-star"></i><i class="icon-star"></i><i
							class="icon-star"></i></span>
					</p>
				</label>
			</div>
			<div class="form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">
					<p class="rate">
						<span><i class="icon-star"></i><i class="icon-star"></i><i
							class="icon-star"></i><i class="icon-star"></i><i
							class="icon-star-o"></i></span>
					</p>
				</label>
			</div>
			<div class="form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">
					<p class="rate">
						<span><i class="icon-star"></i><i class="icon-star"></i><i
							class="icon-star"></i><i class="icon-star-o"></i><i
							class="icon-star-o"></i></span>
					</p>
				</label>
			</div>
			<div class="form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">
					<p class="rate">
						<span><i class="icon-star"></i><i class="icon-star"></i><i
							class="icon-star-o"></i><i class="icon-star-o"></i><i
							class="icon-star-o"></i></span>
					</p>
				</label>
			</div>
			<div class="form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">
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