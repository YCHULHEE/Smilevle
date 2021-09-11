<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kr.co.smilevle.util.AreacodeConverter" %>
<%@ page import="kr.co.smilevle.util.DateFormatConverter" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>리뷰 목록</title>
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
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

  </head>
  <body>
    
  <jsp:include page="/WEB-INF/views/include/common/menu.jsp"/>
    <!-- END nav -->
    
    <div class="hero-wrap js-fullheight" style="background-image: url(images/bg_9.jpg);">
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
    		<div class="container">
				<button id="reviewWriteButton" class="btn btn-primary rounded" onclick="location.href='review_write.do'">리뷰 작성</button>
			</div>
			<p></p>
    		<div class="container">
    			<div class="row d-flex">
    			<c:if test="${reviewPage.hasNoReviews() }">
	    			<div class="text-center">
		    			<h2>리뷰 게시글이 존재하지 않습니다!</h2>
	    			</div>
    			</c:if>
    				<c:forEach var="review" items="${reviewPage.content }">
	    				<c:choose>
							<c:when test="${review.photoUrl eq null }">
							<div class="col-md-3 d-flex ftco-animate">
					            <div class="blog-entry align-self-stretch">
					              <a onClick="location.href='review_read.do?no=${review.number }&pageNo=${reviewPage.currentPage }'" class="block-20" style="background-image: url(images/no_image.jpg); cursor: pointer;"></a>
					              <div class="text p-4 d-block">
					              	<span class="tag">${AreacodeConverter.getKey(review.areacode) }</span>
					                <h3 class="heading mt-3"><a onClick="location.href='review_read.do?no=${review.number }&pageNo=${reviewPage.currentPage }'" style="cursor: pointer;">${review.title }</a></h3>
					                <div class="meta mb-3">
					                  <div><h6>${DateFormatConverter.convertDate(review.regDate) }</h6></div>
					                  <div>${review.writer.name }</div>
					                </div>
					              </div>
					            </div>
				          	</div>
							</c:when>
							<c:otherwise>
			    			<div class="col-md-3 d-flex ftco-animate">
					            <div class="blog-entry align-self-stretch">
					              <a onClick="location.href='review_read.do?no=${review.number }&pageNo=${reviewPage.currentPage }'" class="block-20" style="background-image: url('${review.photoUrl}'); cursor: pointer;"></a>
					              <div class="text p-4 d-block">
					              	<span class="tag">${AreacodeConverter.getKey(review.areacode) }</span>
					                <h3 class="heading mt-3"><a onClick="location.href='review_read.do?no=${review.number }&pageNo=${reviewPage.currentPage }'" style="cursor: pointer;">${review.title }</a></h3>
					                <div class="meta mb-3">
					                  <div><h6>${DateFormatConverter.convertDate(review.regDate) }</h6></div>
					                  <div>${review.writer.name }</div>
					                </div>
					              </div>
					            </div>
				          	</div>						
							</c:otherwise>
						</c:choose>
		          	</c:forEach>
    			</div>
    		</div>
    	</div>
	    <div class="text-center">
	   		<c:if test="${reviewPage.hasReviews() }">
	   			<nav>
	   			  <div class="block-27">
					  <ul>
					  	<c:if test="${reviewPage.startPage > 5 }">
						  	<li>
						      <a class="page-link" href="review.do?pageNo=${reviewPage.startPage - 1 }" aria-label="이전">
						        <span aria-hidden="true">&lt;</span>
						      </a>
						    </li>
					  	</c:if>
						<c:forEach var="pNo" begin="${reviewPage.startPage }" end="${reviewPage.endPage }">
							<c:choose>
								<c:when test="${pNo == reviewPage.currentPage }">
									<li class="active"><a href="review.do?pageNo=${pNo }">${pNo }</a></li>
								</c:when>
								<c:otherwise>
					    			<li><a href="review.do?pageNo=${pNo }">${pNo }</a></li>								
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${reviewPage.endPage < reviewPage.totalPages }">
						    <li>
						      <a href="review.do?pageNo=${reviewPage.startPage + 5 }" aria-label="다음">
						        <span aria-hidden="true">&gt;</span>
						      </a>
						    </li>					
						</c:if>
					  </ul>
				  </div>
				</nav>
	   		</c:if>
	    </div>
    </section>

    <footer class="ftco-footer ftco-bg-dark ftco-section">
    	<jsp:include page="/WEB-INF/views/include/common/footer.jsp" flush="false" />
    </footer>
    
  

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