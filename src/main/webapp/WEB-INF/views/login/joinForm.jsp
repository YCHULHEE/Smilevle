<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Smilevle</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet">

    <link rel="stylesheet" href="/static/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/animate.css">
    
    <link rel="stylesheet" href="/static/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/static/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/static/css/magnific-popup.css">

    <link rel="stylesheet" href="/static/css/aos.css">

    <link rel="stylesheet" href="/static/css/ionicons.min.css">

    <link rel="stylesheet" href="/static/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="/static/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="/static/css/flaticon.css">
    <link rel="stylesheet" href="/static/css/icomoon.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/login.css" type="text/css"/>
    


</head>
<body>
<jsp:include page="/WEB-INF/views/include/common/menu.jsp"/>
  
   <div class="hero-wrap js-fullheight" style="background-image: url('/static/images/bg_2.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9 text-center ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
           		<h1>Smilevle</h1><br>         
          </div>
        </div>
      </div>
    </div>


 <section class="ftco-section bg-light">
    	<div class="container">
			<div class="login-card" id="loginCard">
			
			<form action="/join" method="post" id="loginCard" onsubmit="check();">
			<p>
				아이디:<input type="text" name="memberId" placeholder="ID" value="${param.memberId}" maxlength="20">
				<c:if test="${errors.memberId}">ID를 입력하세요.</c:if>
				<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
			</p>
			<p>
				이름:<input type="text" name="name" placeholder="Name" value="${param.name}" maxlength="30">
				<c:if test="${errors.name}">이름을 입력하세요.</c:if>
			</p>
			<p>
				암호:<input type="password" name="password" id="password" placeholder="숫자,소문자,대문자 1개이상 6~20자리" maxlength="25">
				<c:if test="${errors.password}">암호를 입력하세요.</c:if>
			</p>
			<p>
				확인:<input type="password" name="confirmPassword" maxlength="25" >
				<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
				<c:if test="${errors.notMatch}">
				<script >
					alert('암호와 확인이 일치하지 않습니다.')
				</script>
				암호와 확인이 일치하지 않습니다.</c:if>
			</p>
			<p>
				이메일:<input type="text" name="email" id="email" placeholder="abc@a.a" value="${param.email}">
				<c:if test="${errors.email}">이메일을 입력하세요.</c:if>
			</p>
			<p>
				성별:<br/><input type="radio" name="gender" value="male" checked>남자
				<input type="radio" name="gender" value="female">여자
			</p>
			<p>
				생년월일:<br/><input type="date" name="birthday" value="2021-08-18">
			</p>
			<p>
				전화번호:<input type="text" name="phonenum" placeholder="Phone Number" value="${param.phonenum}" maxlength="11">
				<c:if test="${errors.phonenum}">전화번호를 입력하세요.</c:if>
			</p>
			
			
			<input type="submit" class="login login-submit" value="가입" />
			</form>
			</div>
			
			</div>
    </section>

    <jsp:include page="/WEB-INF/views/include/common/footer.jsp"
		flush="false" />
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>



<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
  <script src="/static/js/jquery.min.js"></script>
  <script src="/static/js/join.js"></script>
  <script src="/static/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="/static/js/popper.min.js"></script>
  <script src="/static/js/bootstrap.min.js"></script>
  <script src="/static/js/jquery.easing.1.3.js"></script>
  <script src="/static/js/jquery.waypoints.min.js"></script>
  <script src="/static/js/jquery.stellar.min.js"></script>
  <script src="/static/js/owl.carousel.min.js"></script>
  <script src="/static/js/jquery.magnific-popup.min.js"></script>
  <script src="/static/js/aos.js"></script>
  <script src="/static/js/jquery.animateNumber.min.js"></script>
  <script src="/static/js/bootstrap-datepicker.js"></script>
  <script src="/static/js/jquery.timepicker.min.js"></script>
  <script src="/static/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="/static/js/google-map.js"></script>
  <script src="/static/js/main.js"></script>
</body>
</html>