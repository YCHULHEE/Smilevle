<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Smilevle</title>
    <meta charset="utf-8">
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
  </head>
  <body>
    
  <jsp:include page="/WEB-INF/views/include/common/menu.jsp"/>
    <!-- END nav -->
    
    <div class="hero-wrap js-fullheight" style="background-image: url('/static/images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-start" data-scrollax-parent="true">
          <div class="col-md-9 ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
            <h1 class="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><strong>With 스마이블 <br></strong> 안전한 국내 여행 떠나요</h1>
            <p data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">가고 싶은 곳 궁금한 곳 찾아보세요!</p>
            <div class="block-17 my-4">
              <form action="/tour_search" method="get" class="d-block d-flex">
                <div class="fields d-block d-flex">
                  <div class="textfield-search one-third">
                  	<input name="searchWord" type="text" class="form-control" placeholder="Ex) 숙소, 여행지, 볼거리 ">
                  </div>
                  <div class="select-wrap one-third">
                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                    <select name="where" class="form-control" placeholder="Keyword search">
                      <c:forEach var="map" items="${itemMap}">
								<option value="${map.key}" ${map.key == areaCode ? 'selected="selected"' : '' }>${map.value}</option>
					 </c:forEach>
                    </select>
                  </div>
                </div>
                <input type="submit" class="search-submit btn btn-primary" value="검색">  
              </form>
            </div>
            <p class="browse d-md-flex">
			<span class="d-flex justify-content-md-center align-items-md-center"><a href="#"><i class="flaticon-hotel"></i><strong>숙소</strong></a></span> 
			<span class="d-flex justify-content-md-center align-items-md-center"><a href="#"><i class="flaticon-meeting-point"></i><strong>여행지</strong></a></span> 
			<span class="d-flex justify-content-md-center align-items-md-center"><a href="#"><i class="flaticon-support"></i><strong>볼거리</strong></a></span>
                </p>
          </div>
        </div>
      </div>
    </div>
	
	<jsp:include page="/WEB-INF/views/include/travel/travel_dest_container.jsp"/>
    <jsp:include page="/WEB-INF/views/include/stay/stay_container.jsp"/> 
	<!--  이벤트 표시 -->
  	<jsp:include page="/WEB-INF/views/include/event/event_container.jsp"/>

	
   <!-- 푸터  -->
   <jsp:include page="/WEB-INF/views/include/common/footer.jsp" flush="false"/>

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="/static/js/jquery.min.js"></script>
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