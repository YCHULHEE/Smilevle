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

<link rel="icon" href="/resources/images/gun.png" />

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
			<div id="container_box" align="left">
				<table border="1">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th>성별</th>
							<th>생일</th>
							<th>가입날짜</th>
							<th>회원구분</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.memberList}" var="memberList">
							<tr>
								<td>${memberList.memberId }</td>
								<td>${memberList.name }</td>
								<td>${memberList.phonenum }</td>
								<td>${memberList.email }</td>
								<td style="width: 190px;">${memberList.gender }</td>
								<td style="width: 190px;">${memberList.birthday }</td>
								<td><fmt:formatDate value="${memberList.regDate}"
										pattern="YYYY-MM-dd"/></td>
								<td>${memberList.userType }</td>
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
							
										</select> <select name="type" class=""
											placeholder="Keyword search" style="width: 120px; height: 30px;">
												<option value="memberId" selected="selected">이름</option>
										</select> <input type="text" class="" name="memberId"
											placeholder="검색" style="width: 200px; height: 30px;"> 
											<input type="submit" value="검색"
											class="btn btn-primary py-3 px-5">
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

	<footer id="footer">
		<div id="footer_box"></div>
	</footer>
	<script src="/static/js/page.js"></script>
</body>
</html>
