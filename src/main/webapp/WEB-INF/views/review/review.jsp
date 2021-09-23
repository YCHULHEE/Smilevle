<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.smilevle.config.util.AreacodeConverter" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>리뷰 목록</title>
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
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

  </head>
  <body>
    
  <jsp:include page="/WEB-INF/views/include/common/menu.jsp"/>
    <!-- END nav -->
    
    <div class="hero-wrap js-fullheight" style="background-image: url(/static/images/bg_9.jpg);">
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
	    		<div class="container">
					<button id="reviewWriteButton" class="btn btn-primary rounded float-right" onclick="location.href='review_write'">리뷰 작성</button>
				</div>
				<p></p>
    			<div class="row d-flex">
    				<c:forEach var="review" items="${reviewPage}">
	    				<c:choose>
							<c:when test="${review.photo_url eq null }">
							<div class="col-md-3 d-flex ftco-animate">
					            <div class="blog-entry align-self-stretch">
					              <a onClick="location.href='review_read?no=${review.review_no }&nowPage=${reviewPageVO.nowPage }'" class="block-20" style="background-image: url(/static/images/no_image.jpg); cursor: pointer;"></a>
					              <div class="text p-4 d-block">
					              	<span class="tag">${AreacodeConverter.getKey(review.areacode) }</span>
					                <h3 class="heading mt-3"><a onClick="location.href='review_read?no=${review.review_no }&pageNo=${reviewPageVO.nowPage }'" style="cursor: pointer;">${review.title }</a></h3>
					                <div class="meta mb-3">
					                  <div><h6><fmt:formatDate value="${review.regDate}" pattern="yyyy.MM.dd HH:mm:ss"/></h6></div>
					                  <div>${review.writer_name }</div>
					                </div>
					              </div>
					            </div>
				          	</div>
							</c:when>
							<c:otherwise>
			    			<div class="col-md-3 d-flex ftco-animate">
					            <div class="blog-entry align-self-stretch">
					              <a onClick="location.href='review_read?no=${review.review_no }&nowPage=${reviewPageVO.nowPage }'" class="block-20" style="background-image: url('${review.photo_url}'); cursor: pointer;"></a>
					              <div class="text p-4 d-block">
					              	<span class="tag">${AreacodeConverter.getKey(review.areacode) }</span>
					                <h3 class="heading mt-3"><a onClick="location.href='review_read?no=${review.review_no }&pageNo=${reviewPageVO.nowPage }'" style="cursor: pointer;">${review.title }</a></h3>
					                <div class="meta mb-3">
					                  <div><h6><fmt:formatDate value="${review.regDate}" pattern="yyyy.MM.dd HH:mm:ss"/></h6></div>
					                  <div>${review.writer_name }</div>
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
   			<nav>
   			  <div class="block-27">
				  <ul>
				  	<c:if test="${reviewPageVO.nowPage != 1 }">
				  		<li> <a href="review?nowPage=1">&lt;&lt;</a> </li>
				  	</c:if>
				 
				  	<c:if test="${reviewPageVO.startPage > 5 }">
					  	<li>
					      <a href="review?nowPage=${reviewPageVO.startPage - 1 }" aria-label="이전">
					        <span>&lt;</span>
					      </a>
					    </li>
				  	</c:if>
					<c:forEach var="pNo" begin="${reviewPageVO.startPage }" end="${reviewPageVO.endPage }">
						<c:choose>
							<c:when test="${pNo == reviewPageVO.nowPage }">
								<li class="active"><a href="review?nowPage=${pNo }">${pNo }</a></li>
							</c:when>
							<c:otherwise>
				    			<li><a href="review?nowPage=${pNo }">${pNo }</a></li>								
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${reviewPageVO.endPage < reviewPageVO.lastPage }">
					    <li>
					      <a href="review?nowPage=${reviewPageVO.startPage + 5 }" aria-label="다음">
					        <span>&gt;</span>
					      </a>
					    </li>					
					</c:if>
					
					<c:if test="${reviewPageVO.nowPage != reviewPageVO.lastPage }">
						<li> <a href="review?nowPage=${reviewPageVO.lastPage }">&gt;&gt;</a> </li>
					</c:if>
				  </ul>
			  </div>
			</nav>
	    </div>
    </section>
    <footer class="ftco-footer ftco-bg-dark ftco-section">
    	<jsp:include page="/WEB-INF/views/include/common/footer.jsp" flush="false" />
    </footer>
    
  

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