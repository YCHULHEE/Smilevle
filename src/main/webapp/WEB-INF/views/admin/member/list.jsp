<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

	<title>관리자모드</title>
	
	<script src="/static/css/jquery-3.2.1.min.js"></script>
	
	<link rel="stylesheet" href="/static/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/static/bootstrap/bootstrap-theme.min.css">
	<script src="/static/bootstrap/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="/static/css/admin/index.css">
	<link rel="stylesheet" href="/static/css/admin/goods/list.css">
	
	<link rel="icon" href="/resources/images/gun.png" />
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
						<c:forEach items="${memberList }" var="memberList">
						<tr>
							<td>${memberList.userId }</td>
							<td>${memberList.userName }</td>
							<td>${memberList.userPhon }</td>
							<td>${memberList.userAddr1 }</td>
							<td style="width:190px;">${memberList.userAddr2 }</td>
							<td style="width:190px;">${memberList.userAddr3 }</td>
							<td><fmt:formatDate value="${memberList.regDate }" pattern="YYYY-MM-DD" /></td>
							<td>${memberList.verify }</td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</section>
	</div>
	
	<%@ include file="../include/TopBtn.jsp" %>
	
	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../include/footer.jsp"%>
		</div>
	</footer>

</body>
</html>
