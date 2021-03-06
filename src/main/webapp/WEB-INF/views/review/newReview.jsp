<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="kr.co.smilevle.util.AreacodeConverter" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>리뷰 작성</title>
    <meta charset="utf-8">
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
    <script src="//cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
  </head>
  <body>
    
  <jsp:include page="/WEB-INF/views/include/common/menu.jsp"/>
    <!-- END nav -->
    
    <div class="hero-wrap js-fullheight" style="background-image: url(images/bg_6.jpg);">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9 text-center ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
            <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index.do">Home</a></span> <span>Review</span></p>
            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Review</h1>
          </div>
        </div>
      </div>
    </div>
    <section class="ftco-section">
    	<div class="container">
    	 	<button class="btn btn-outline-info" onclick="location.href='review.do'">목록으로</button>
    		<div class="container">
    			&nbsp;
    		</div>
    		<h2 class="mb-4">새 글 작성 </h2>
			<form action="review_write.do" method="post">
				<div class="form-group row">
					<label for="inputTitle" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-8">
						<input type="text" name="title" class="form-control" id="inputTitle" value="${param.title }" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputLocation" class="col-sm-2 col-form-label">지역(시/도)</label>
					<div class="col-sm-3">
						<select id="areacode" name="areacode" class="custom-select" id="inputLocation" required>
							<option value="">-지역-</option>
							<c:forEach var="map" items="${AreacodeConverter.getAreaMap() }">
								<option value='${map.value }'>${map.key }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputLocationName" class="col-sm-2 col-form-label">건물 명</label>
					<div class="col-sm-8">
						<input type="text" name="locationName" class="form-control" id="inputLocationName" value="${param.locationName }" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputRate" class="col-sm-2 col-form-label">별점</label>
					<div class="col-sm-2">
						<select id="rate" name="rate" class="custom-select" id="inputRate" required>
							<option value="">-별점-</option>
							<c:forEach var="rate" items="${AreacodeConverter.rates }">
								<option value='${rate }'> ${rate } </option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="context">내용</label>
					<textarea name="content" id="content" class="form-control" required></textarea>
					<script type="text/javascript">
					 CKEDITOR.replace('content', 
								{	height: 500,
									filebrowserUploadUrl: '/Smilevle/review_upload.do'
								});
					</script>					
				</div>				
				<button class="btn btn-outline-info rounded" onclick="submit">게시글 쓰기</button>
			</form>				
		</div>
    </section>

    <jsp:include page="/WEB-INF/views/include/common/footer.jsp"
		flush="false" />
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

  <script src="js/jquery.min.js"></script>
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