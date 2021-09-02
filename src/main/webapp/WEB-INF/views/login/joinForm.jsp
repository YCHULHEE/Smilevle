<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
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
    
    <!-- <script>
    function setCookie(cookieName, value, exdays){
    	var exdate = new Date();
    	exdate.setDate(exdate.getDate() + exdays);
    	var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    	document.cookie = cookieName + "=" + cookieValue;
    }

    function deleteCookie(cookieName){
    	var expireDate = new Date();
    	expireDate.setDate(expireDate.getDate() - 1);
    	document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
    }

    function getCookie(cookieName) {
    	cookieName = cookieName + '=';
    	var cookieData = document.cookie;
    	var start = cookieData.indexOf(cookieName);
    	var cookieValue = '';
    	if(start != -1){
    		start += cookieName.length;
    		var end = cookieData.indexOf(';', start);
    		if(end == -1)end = cookieData.length;
    		cookieValue = cookieData.substring(start, end);
    	}
    	return unescape(cookieValue);
    }
    
    function frm_submit(){
     	//스크롤 위치 저장
     	var scrollPoint = (document.documentElement && document.documentElement.scrollTop) 
    		|| document.body.scrollTop;

    	setCookie("category", "mainScrollPoint"); // 쿠키에서 사용할 category에 사용자 정의 카테고리명 세팅
    	setCookie("scrollPoint", scrollPoint); // 쿠키에 스크롤 위치 세팅

    	$("#frm").submit();
    }
    
    var category = getCookie("category"); //setCookie("category")로 세팅한 category 변수 명
    var scrollPoint = getCookie("scrollPoint"); //setCookie("scrollPoint")로 세팅한 스크롤 위치
    var currentCategory = "mainScrollPoint"; //이벤트 발생 후 새로 로드된 현재 페이지의 카테고리 지정
    
    if (category != "" && category != 'undefined' 
   	&& category == currentCategory && scrollPoint != "" && scrollPoint != 'undefined') {
       
    	window.scroll(0, scrollPoint); 
    	//body.scrollTop(scrollPoint);
    }

   // 쿠키 삭제
   deleteCookie("category"); //또는 setCookie("category", "");
   deleteCookie("scrollPoint"); //또는 setCookie("scrollPoint", "");
	</script>
	



	
	<script>
	/* $("#loginCard").submit(function() {
		 	var offset = $("#loginCard").offset();
	        $('html, body').animate({scrollTop : offset.top}, 400);
			}); */
			
			$("#loginCard).submit(function() {

			alert("test");

			});
	</script>
	
<script type="text/javascript">
	function check() {		
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/; /* 이메일 유효성 검사 */
		3
		 var passcheck = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;   /* 비밀번호 유효성 검사 */
		
			if(exptext.test(email)==false){
				alert("메일형식이 올바르지 않습니다.");
				document.addjoin.email.focus();
				return false;					
			}
			
			if (passcheck.test(password)==false) {			        
			    alert("비밀번호 형식을 지켜주세요.\n비밀번호는 숫자, 소문자, 대문자를 1개이상, 6~20자리 이내로 입력해주세요.");
			    document.addjoin.password.focus();
			    return false;
			}
	}	
</script>
 -->


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
			<div class="login-card" id="loginCard">
			
			<form action="join.do" method="post" id="loginCard" onsubmit="check();">
			<p>
				아이디:<input type="text" name="id" placeholder="ID" value="${param.id}">
				<c:if test="${errors.id}">ID를 입력하세요.</c:if>
				<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
			</p>
			<p>
				이름:<input type="text" name="name" placeholder="Name" value="${param.name}">
				<c:if test="${errors.name}">이름을 입력하세요.</c:if>
			</p>
			<p>
				암호:<input type="password" name="password" id="password" placeholder="숫자,소문자,대문자 1개이상 6~20자리">
				<c:if test="${errors.password}">암호를 입력하세요.</c:if>
			</p>
			<p>
				확인:<input type="password" name="confirmPassword" >
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
				전화번호:<input type="text" name="phonenum" placeholder="Phone Number" value="${param.phonenum}">
				<c:if test="${errors.phonenum}">전화번호를 입력하세요.</c:if>
			</p>
			
			
			<input type="submit" class="login login-submit" value="가입" onclick="fnMove()">
			</form>
			</div>
			
			</div>
    </section>

    <footer class="ftco-footer ftco-bg-dark ftco-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">dirEngine</h2>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-5">
              <h2 class="ftco-heading-2">Information</h2>
              <ul class="list-unstyled">
                <li><a href="#" class="py-2 d-block">About</a></li>
                <li><a href="#" class="py-2 d-block">Service</a></li>
                <li><a href="#" class="py-2 d-block">Terms and Conditions</a></li>
                <li><a href="#" class="py-2 d-block">Become a partner</a></li>
                <li><a href="#" class="py-2 d-block">Best Price Guarantee</a></li>
                <li><a href="#" class="py-2 d-block">Privacy and Policy</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Customer Support</h2>
              <ul class="list-unstyled">
                <li><a href="#" class="py-2 d-block">FAQ</a></li>
                <li><a href="#" class="py-2 d-block">Payment Option</a></li>
                <li><a href="#" class="py-2 d-block">Booking Tips</a></li>
                <li><a href="#" class="py-2 d-block">How it works</a></li>
                <li><a href="#" class="py-2 d-block">Contact Us</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>



<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
  <script src="js/jquery.min.js"></script>
  <script src="js/join.js"></script>
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