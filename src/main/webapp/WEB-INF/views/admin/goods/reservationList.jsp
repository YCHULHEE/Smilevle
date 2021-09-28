<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

	<title>관리자모드</title>
	
	<script src="/static/js/jquery-3.2.1.min.js"></script>
	
	<link rel="stylesheet" href="/static/bootstrap/bootstrap.min.css">
	<link rel="stylesheet"
		href="/static/bootstrap/bootstrap-theme.min.css">
	<script src="/static/bootstrap/bootstrap.min.js"></script>

	<link rel="stylesheet" href="/static/css/admin/index.css">
	<link rel="stylesheet" href="/static/css/admin/shop/orderList.css">

	<link rel="icon" href="/static/images/gun.png" />
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
				<%@ include file="../include/aside.jsp" %>
			</aside>
			<div id="container_box">
				<ul class="orderList">
					<c:forEach items="${reviewPage}" var="reviewVO">
					<li>
						<div>
							<p><span>주문번호</span><a href="/admin/shop/orderView?n=">${orderList.orderId }</a></p>
							<p><span>숙박명</span>${orderList.orderRec }</p>
							<p><span>주문자</span>${orderList.userId }</p>
							<p><span>주소</span> <br><p style="margin-left:100px;"> </p>
							<p><span>전화번호</span></p>
							<p><span>예약날짜</span>${orderList.delivery }</p>
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
							<div style="margin-right: 300px">
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
							
										</select> <select name="type" class=""
											placeholder="Keyword search" style="width: 120px; height: 30px;">
												<option value="title" selected="selected">숙박명</option>
												<option value="글쓴이">글쓴이</option>
										</select> <input type="text" class="" name="searchWord"
											placeholder="검색" style="width: 200px; height: 30px;"> <input
											type="hidden" name="where" value="${where}">
											<input type="submit" value="검색"
											class="btn btn-primary py-3 px-5">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
	
	<%@ include file="../include/TopBtn.jsp" %>
</body>
</html>