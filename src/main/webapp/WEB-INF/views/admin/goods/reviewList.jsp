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
							<th>리뷰번호</th>
							<th>썸네일</th>
							<th>이름</th>
							<th>아이디</th>
							<th>주소</th>
							<th>평점</th>
							<th>글작성날짜</th>
							<th>조회수</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reviewPage}" var="review">
							<tr>
								<td>${review.reviewNo}</td>
								<td><img src="${review.photoUrl}" style="height: 100px"></td>
								<td><a href="">${review.title}</a></td>
								<td>${review.writerId}</td>
								<td>${review.rate}</td>
								<td>${review.locationName}</td>
								<td><fmt:formatDate value="${review.modDate}"
										pattern="yyyy-MM-dd" /></td>
								<td>${review.readCnt}</td>
								<td><ul>
										<li class="btn btn btn-danger"><a style="color: white;"
											href="delete?no=${review.reviewNo}"
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
							<div style="margin-right: 300px ">
								<ul>
									<c:if test="${reviewPageVO.startPage > 5 }">
										<li><a id="prevBtn"
											href="review?pageNo=${reviewPageVO.startPage - 1 }"
											aria-label="이전"> <span>&lt;</span>
										</a></li>
									</c:if>
									<c:forEach var="pNo" begin="${reviewPageVO.startPage }"
										end="${reviewPageVO.endPage }">
										<c:choose>
											<c:when test="${pNo == reviewPageVO.pageNo }">
												<li class="active btn btn-default"><a class="pageBtn"
													href="review?pageNo=${pNo }">${pNo } </a></li>
											</c:when>
											<c:otherwise>
												<li class="btn btn-default"><a class="pageBtn" href="review?pageNo=${pNo }" style="color: black">${pNo } </a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:if test="${reviewPageVO.endPage < reviewPageVO.lastPage }">
										<li><a id="nextBtn"
											href="review?pageNo=${reviewPageVO.startPage + 5 }"
											aria-label="다음"> <span>&gt;</span>
										</a></li>
									</c:if>
								</ul>
							</div>
							</br>
							<form action="list" method="get">
								<div class="fields" style="margin-left: 100px">
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
										</select> <input type="text" class="" name="memberId" placeholder="검색"
											style="width: 200px; height: 30px;"> <input
											type="hidden" name="where" value="${where}"> <input
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
