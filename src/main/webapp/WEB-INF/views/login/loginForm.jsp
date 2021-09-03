<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/login.css" type="text/css"/>        
  <!--   <script>
		$(document).ready(function(){ 
		$("#submit").click(function(){
		if($("#id").val().length==0){ alert("아이디를 입력하세요."); $("#id").focus(); return false; }
		if($("#password").val().length==0){ alert("비밀번호를 입력하세요."); $("#password").focus(); return false; }
		});
		});
	</script> -->
    
    
  </head>
  <body>
<jsp:include page="/WEB-INF/views/include/common/menu.jsp"/>
  
  
   <div class="hero-wrap js-fullheight" style="background-image: url('images/bg_2.jpg');">
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
    		 <div class="login-card">
				
				<form action="login.do" method="post" onsubmit="check();" >
				
				<c:if test="${errors.idOrPwNotMatch}">
					<script>
						alert('아이디와 패스워드가 일치하지 않습니다.');
					</script>
				</c:if>
				<p>
					아이디:<input type="text" name="id" id="id" placeholder="ID" value="${param.id}">
					<c:if test="${errors.id }">	ID를 입력하세요.</c:if>
				</p>
				<p>
					패스워드:<input type="password" name="password" id="password" placeholder="Password">
					<c:if test="${errors.password }">패스워드를 입력하세요.</c:if>
				</p>
				<input type="submit" class="login login-submit" value="Login" id="submit">
				<a href="/Smilevle/search.do">비밀번호 찾기 </a> &nbsp;/
				<a href="/Smilevle/join.do">회원 가입</a>
				</form>
			</div>
    	</div>
    </section>

    <jsp:include page="/WEB-INF/views/include/common/footer.jsp"
		flush="false" />
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
  <script src="js/login.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
</body>
</html>