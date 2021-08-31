<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>${reviewData.title }</title>
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
    <style type="text/css">
    	.btn-space {
			margin-right: 10px;
		}
    </style>
   
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			loadComment()
		});
		function loadComment() {
			$.getJSON('/Smilevle/review_comment_list.do?no=${reviewData.number}', function(data) {
				/* $('#comment').append('<thead><tr class=thead-black><th width=20%>작성자</th><th width=40%>내용</th><th colspan=2 width=20%>작성일시</th></tr></thead>'); */
				console.log(data);
				if(data == "") {
					$('#comment').append('<tr><td colspan=3 style=text-align:center>작성된 댓글이 없습니다!</td></tr>');
				}
				else {
					$.each(data, function() {
						$('#comment').append('<tr><td>' + this.writerId +
 /* 삭제 버튼 */					'</td><td>' + this.content + '</td><td>' + this.regDate +
								'</td><td><form method=POST action=review_comment_delete.do>' + 
								'<input type=hidden name=commNo id=commNo value=' + this.commentNo + '>' + 
								'<input type=hidden name=rvwNum id=rvwNum value=' + this.reviewNo + '>' + 
								'<input type=submit value=삭제  class="btn btn-secondary btn-sm" style="float: right;"></form></td></tr>');
					})	   
				}
				
			})
		}
	</script>
  </head>
  <body>
    
  <jsp:include page="/WEB-INF/views/include/common/menu.jsp"/>
    <!-- END nav -->
    
    <div class="hero-wrap js-fullheight" style="background-image: url(images/bg_7.jpg);">
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
    	<div class="container" >
    	    <button class="btn btn-outline-info" onclick="location.href='review.do'">목록으로</button>
    		<div class="container" >
    			&nbsp;
    		</div>
    		<div class="container" >
    		
    		<div class="m-5">
    		
				<table class="table table-bordered table-sm thead-light">
				
					<tr>
						<th scope="row" class="table-primary  text-center " width="10%">작성자</th>
						<td>${reviewData.writer.name }</td>
						<th scope="row" class="table-primary text-center" width="10%">No.</th>
						<td colspan="3" width="10%">${reviewData.number }</td>					
					</tr>
					<tr>
						<th scope="row" class="table-primary text-center ">제목</th>
						<td colspan="5">${reviewData.title }</td>
					</tr>
					<tr>
						<th scope="row" class="table-primary text-center">건물 명</th>
						<td colspan="5">${reviewData.locationName }</td>
					</tr>
					<tr>	
						<th scope="row" class="table-primary text-center">별점</th>
						<c:choose>
							<c:when test="${reviewData.rate == '1.0' }">
									<td colspan="5">
										<p class="rate">
											<span>
												<i class="icon-star-o"></i>
												<i class="icon-star-o"></i>
												<i class="icon-star-o"></i>
												<i class="icon-star-o"></i>
												<i class="icon-star-o"></i>
											</span>
										</p>
									</td>
							</c:when>
							<c:when test="${reviewData.rate == '2.0' }">
									<td colspan="5">
										<p class="rate">
											<span>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
												<i class="icon-star-o"></i>
												<i class="icon-star-o"></i>
												<i class="icon-star-o"></i>
											</span>
										</p>
									</td>
							</c:when>
							<c:when test="${reviewData.rate == '3.0' }">
									<td colspan="5">
										<p class="rate">
											<span>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
												<i class="icon-star-o"></i>
												<i class="icon-star-o"></i>
											</span>
										</p>
									</td>
							</c:when>
							<c:when test="${reviewData.rate == '4.0' }">
									<td colspan="5">
										<p class="rate">
											<span>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
												<i class="icon-star-o"></i>
											</span>
										</p>
									</td>
							</c:when>
							<c:when test="${reviewData.rate == '5.0' }">
									<td colspan="5">
										<p class="rate">
											<span>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
												<i class="icon-star"></i>
											</span>
										</p>
									</td>
							</c:when>																																																						
						</c:choose>
					</tr>				
					<tr>
						<th scope="row" class="table-primary  text-center">내용</th>
						<td colspan="5">${reviewData.content }</td>											
				</table>
			</div>
			</div>
			</div>
    		<div class="container">
    			<c:if test="${authUser.id == reviewData.writer.id }">
    			    <button type="button" class="btn btn btn-primary rounded float-right" data-toggle="modal" data-target="#myModal">삭제</button>
    				<button type="button" class="btn btn btn-info rounded float-right btn-space" onclick="location.href='review_modify.do?no=${reviewData.number}'">수정</button>
    			</c:if>
    		</div>
    	</div>
    </section>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">주의!</h4>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          		<span aria-hidden="true">&times;</span>
       		</button>
	      </div>
	      <div class="modal-body">
			정말로 삭제하시겠습니까? <br/>
			삭제 후 취소할 수 없습니다!
	      </div>
	      <div class="modal-footer">
		<button type="button" id="toList" class="btn btn-default" data-dismiss="modal" >취소</button>
		<button type="button" id="toContent" class="btn btn-primary" onclick="location.href='review_delete.do?no=${reviewData.number}'">삭제</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 여기 -----------------------------------------------------------------------------주물주물 -->
	
	<div class="container" >
    	<div class="m-5">
			<div class="container my-3" >
				<table id="comment" class="table table-sm table-hover">
			        <thead>
				        <tr class="table-primary">
				            <th width=20%>작성자</th>
				            <th width=40%>내용</th>
				            <th colspan="2" width=20%>작성일시</th>
				        </tr>
			        </thead>
	 			</table>
	 		</div>
	 	</div>
	 	<form class="m-5" id="commentForm" method="post" action="review_comment_write.do">
			<c:choose>
				<c:when test="${authUser == null }">
					<textarea class="form-control" name="content" id="content" disabled="disabled">로그인 후 작성 가능합니다...</textarea>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="rwNum" id="rwNum" value="${reviewData.number }">
					<label for="content"><h4>댓글작성</h4></label>
					<textarea class="form-control" name="content" id="content"></textarea>   <!-- 댓글 박스 크기 -->
					<input type="submit" class="btn btn-outline-info" value="댓글 작성" style="float: right;">
				</c:otherwise>
			</c:choose>
		</form>
	 </div>
	



	<!-- 여기 --------------------------------------------------------------------------------까지 -->
	
	<div class="form-row align-items-center">

	</div>
	
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
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>


    
  </body>
</html>