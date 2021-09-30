<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<title>관리자모드</title>

<script src="/static/js/jquery-3.2.1.min.js"></script>

<link rel="stylesheet" href="/static/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/bootstrap/bootstrap-theme.min.css">
<script src="/static/bootstrap/bootstrap.min.js"></script>

<link rel="stylesheet" href="/static/css/admin/index.css">
<link rel="stylesheet" href="/static/css/admin/goods/list.css">

<link rel="icon" href="/static/images/gun.png" />

<style>
#pageBtn1 {
	float: left;
}

ul li {
	list-style-type: none;
	display: inline;
	line-height: 30px;
}
</style>

</head>

<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="../include/aside.jsp"%>
			</aside>

			<div id="container_box">
				<table>
					<thead>

						<tr>
							<th>번호</th>
							<th>썸네일</th>
							<th style="width: 500px">이름</th>
							<th style="width: 500px">카테고리</th>
							<th style="width: 500px">주소</th>
							<th style="width: 400px">전화번호</th>
							<th style="width: 550px">조회수</th>
							<th style="width: 300px">수정/삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.tourList}" var="stay">
							<tr>
								<td>${stay.contentId}</td>
								<td><img src="${stay.firstImage}" style="height: 100px"></td>
								<td><a href="/tourOne?contentId=${stay.contentId}">${stay.title}</a></td>
								<%-- <td>${list.cateCode }</td> --%>
								<td>${itemMap.get(stay.smallCategory)}</td>
								<td>${stay.address}</td>
								<td>${stay.tel}</td>
								<c:choose>
									<c:when test="${stay.readCnt >= 20000}">
										<td style="color: red; width: 200px;">${stay.readCnt}(인기있는
											숙소!)</td>
									</c:when>
									<c:when test="${stay.readCnt >= 2000}">
										<td style="width: 200px;">${stay.readCnt}</td>
									</c:when>
									<c:when test="${stay.readCnt  >= 0 }">
										<td style="width: 200px;">${stay.readCnt}(새로생긴 숙소!)</td>
									</c:when>
								</c:choose>

								<td><ul>
										<li class="btn btn-default" style="margin-bottom: 8px;">
											<a style="color: black;"
											href="modify?contentId=${stay.contentId}">수정</a>
										</li>
										<li class="btn btn btn-danger"><a style="color: white;"
											href="delete?contentId=${stay.contentId}"
											onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a></li>
									</ul></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="row mt-5">
					<div class="col text-center">
						<div class="block-27 pageBtn1">
							</br>
							<div>
								<ul>
									<c:if test="${page.hasStays()}">
										<c:if test="${page.startPage > 5}">
											<li><a id="prevBtn">&lt;</a></li>
										</c:if>
										<c:forEach var="pNo" begin="${page.startPage}"
											end="${page.endPage}">
											<c:choose>
												<c:when test="${pNo eq pageNo}">
													<li class="active btn btn-default"><a class="pageBtn">${pNo}</a></li>
												</c:when>
												<c:otherwise>
													<li><a class="pageBtn btn btn-default">${pNo}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<c:if test="${page.endPage < page.totalPages}">
											<li><a id="nextBtn">&gt;</a></li>
										</c:if>
									</c:if>
								</ul>
							</div>
							</br>
							<form action="list" method="get">
								<div class="fields">
									<div class="form-group">
										<select style="width: 120px; height: 30px;" name="areaCode"
											class="" placeholder="Keyword search">
											<c:forEach var="map" items="${areaMap}">
												<option value="${map.key}"
													${map.key == areaCode ? 'selected="selected"' : '' }>${map.value}</option>
											</c:forEach>
										</select> <select name="smallCategory" class=""
											placeholder="Keyword search"
											style="width: 120px; height: 30px;">
											<c:forEach var="map" items="${itemMap}">
												<option value="${map.key}"
													${map.key == smallCategory ? 'selected="selected"' : '' }>${map.value}</option>
											</c:forEach>
										</select> <input type="text" class="" name="searchWord"
											placeholder="이름으로 검색" style="width: 200px; height: 30px;">
										<input type="hidden" name="where" value="${where}"> <input
											type="submit" value="검색" class="btn btn-primary py-3 px-5">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<%@ include file="../include/TopBtn.jsp"%>

	<script src="/static/js/page.js"></script>
</body>
</html>
