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
<link rel="stylesheet" href="/static/css/admin/shop/orderList.css">

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
				<ul class="orderList">
					<c:forEach items="${page.reservationList}" var="list">
						<li>
							<div>
								<p>
									<span>주문번호</span><a href="#"></a>${list.resNum}</p>
								<p>
									<span>숙박명</span>${list.title}</p>
								<p>
									<span>주문자아이디</span>${list.memberId}</p>
								<p>
									<span>체크인날짜</span>
									<fmt:formatDate value="${list.checkInDate}"
										pattern="YYYY-MM-dd" />
								</p>
								<p>
									<span>체크아웃날짜</span>
									<fmt:formatDate value="${list.checkOutDate}"
										pattern="YYYY-MM-dd" />
								</p>
								<p>
									<span>예약날짜</span>
									<fmt:formatDate value="${list.regDate}" pattern="YYYY-MM-dd" />
								</p>			
								<p align="right">
									<a class="btn btn btn-default" style="color: black;" href="/deleteRes?resNum=${list.resNum}"
										onclick="return confirm('정말로 삭제하시겠습니까?');">예약 취소</a>
								</p>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</section>
	</div>

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
					<div class="fields" style="margin-left: 100px">
						<div class="form-group">

							</select> <select name="" class="" placeholder="Keyword search"
								style="width: 120px; height: 30px;">
								<option value="memberId" selected="selected">아이디</option>
								<option value="No">주문번호</option>
							</select> <input type="text" class="" name="memberId" placeholder="검색"
								style="width: 200px; height: 30px;"><input type="submit"
								value="검색" class="btn btn-primary py-3 px-5">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@ include file="../include/TopBtn.jsp"%>
	<script src="/static/js/page.js"></script>
</body>
</html>
