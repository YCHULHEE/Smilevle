<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자모드</title>
	
	<script src="/static/resources/js/jquery-3.2.1.min.js"></script>
	
	<link rel="stylesheet" href="/static/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/static/bootstrap/bootstrap-theme.min.css">
	<script src="/static/bootstrap/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="/static/css/admin/index.css">
	
	<link rel="icon" href="/static/images/gun.png" />
	
</head>

<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="include/header.jsp"%>
			</div>
		</header>
	
		<nav id="nav">
			<div id="nav_box">
				<%@ include file="include/nav.jsp"%>
			</div>
		</nav>
	
		<section id="container">
			<aside>
				<%@ include file="include/aside.jsp"%>
			</aside>
			<div id="container_box"></div>
		</section>
	</div>
	
	<footer id="footer">
		<div id="footer_box">
			<%@ include file="include/footer.jsp"%>
		</div>
	</footer>
	
</body>
</html>
