<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-lg-3 sidebar">
	<div class="sidebar-wrap bg-light ftco-animate">
		<h3 class="heading mb-4">Find City</h3>
		<form action="tour_search.do" method="get">
			<div class="fields">
				<div class="form-group">
					<input type="text" class="form-control" name="searchWord"
						placeholder="이름으로 검색">
				</div>
				<input type="hidden" name="where" value="${tourData.tourVO.contentTypeId}">
				<div class="form-group">
					<div class="select-wrap one-third">
						<div class="icon">
							<span class="ion-ios-arrow-down"></span>
						</div>
						<select name="areaCode" class="form-control"
							placeholder="Keyword search" >
							<c:forEach var="map" items="${areaMap}">
								<option value="${map.key}" ${map.key == areaCode ? 'selected="selected"' : '' }>${map.value}</option>
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
								<option value="${map.key}" ${map.key == smallCategory ? 'selected="selected"' : '' }>${map.value}</option>
							</c:forEach>
						</select>
						<input type="hidden" name="where" value="${where}">
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