<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.smilevle.config.util.AreacodeConverter" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>${reviewData.title }</title>
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
    <style type="text/css">
    	.btn-space {
			margin-right: 10px;
		}
    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			loadComment();
		});
		function loadComment() {
			$.getJSON('/comment_list?no=${reviewData.reviewNo}', function(data) {
				console.log(data);
				if(data == "") {
					$('#comment').append('<li class=comment><h5 class=text-center>작성된 댓글이 없습니다!</h5></li>');
				}
				else {
					$.each(data, function() {
						if(this.writerId == '${authUser.memberId}') {
							$('#comment').append('<li class=comment><div class=comment-body><h4>' + this.writerId +
									'</h4><div class=meta>' + this.regdate + '</div><p>' + this.content + '</p><p>' + 
									'<form method=POST action=/comment_delete target=iframe1>' + 
									'<input type=hidden name=commentNo id=commentNo value=' + this.commentNo + '>' + 
									'<input type=submit id=commentDelete value=삭제 class="btn btn-secondary btn-sm float-right" onclick=deleteCommentAlert();></form></p></div></li>');
						} else {
							$('#comment').append('<li class=comment><div class=comment-body><h3>' + this.writerId +
									'</h3><div class=meta>' + this.regdate + '</div><p>' + this.content + '</p></div></li>');

						}
						
					})	
				}
				
			})
		}
		function deleteCommentAlert(){
			alert("댓글이 삭제되었습니다!");
			location.href="/comment_delete";
			window.location.reload();
		}
	</script>
  </head>
  <body>
    
  <jsp:include page="/WEB-INF/views/include/common/menu.jsp"/>
    <!-- END nav -->
    
    <div class="hero-wrap js-fullheight" style="background-image: url(/static/images/bg_7.jpg);">
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
    
    
    
   <section class="ftco-section ftco-degree-bg">
      <div class="container">
   		<div class="container">
   			&nbsp;
   		</div>      	
        <div class="row">
          <div class="col-md-8 ftco-animate">
            <h2 class="mb-3">${reviewData.title }</h2>
            <p>
              ${reviewData.content }
            </p>
            <div class="container">
    			<c:if test="${authUser.memberId == reviewData.writerId }">
    			    <button type="button" class="btn btn btn-primary rounded float-right" data-toggle="modal" data-target="#myModal">삭제</button>
    				<button type="button" class="btn btn btn-info rounded float-right btn-space" onclick="location.href='/review_modify?no=${reviewData.reviewNo}'">수정</button>
    			</c:if>
    		</div>

            <div class="pt-5 mt-5">
              <h3 class="mb-5">댓글 목록</h3>      
              <ul id ="comment" class="comment-list">

              </ul>
              <!-- END comment-list -->
              <div class="comment-form-wrap pt-5">
                <h3 class="mb-5">댓글작성</h3>
                <form id="commentForm" class="p-5 bg-light" method="post" action="/comment_write?no=${reviewData.reviewNo}" target="iframe1">
                <c:choose>
					<c:when test="${authUser == null }">
					  <div class="form-group">
	                    <label for="content">내용</label>
	                    <textarea class="form-control" name="content" id="content" cols="30" rows="5" disabled="disabled">로그인 후 작성 가능합니다!</textarea>
	                  </div>
					</c:when>
					<c:otherwise>
						<h6>${authUser.memberId }</h6>
						<div class="form-group">
		                    <label for="content">내용</label>
		                    <textarea name="content" id="content" cols="30" rows="5" class="form-control"></textarea>
                  		</div>
		                <div class="form-group">
		                	<input type="submit" value="댓글 작성" class="btn py-2 px-4 btn-primary float-right" onclick="window.location.reload();">
		                </div>
					</c:otherwise>
                </c:choose>
                </form>
              </div>
            </div>

          </div> <!-- .col-md-8 -->
          <div class="col-md-4 sidebar ftco-animate">
           	<div class="container">
   				<button class="btn btn-outline-info float-right" onclick="location.href='/review'">목록으로</button>
   		 	</div>          	
            <div class="sidebar-box ftco-animate">
              <div class="categories">
                <h3>리뷰 게시글 정보</h3>
				<table class="table thead-light">
					<tr>
						<th scope="row" class="text-left">No.</th>
						<td class="text-right">${reviewData.reviewNo }</td>	
					</tr>
					<tr>
						<th scope="row" class="text-left">작성일시</th>
						<td class="text-right"><fmt:formatDate value="${reviewData.regDate}" pattern="yyyy.MM.dd HH:mm:ss"/></td>				
					</tr>					
					<tr>
						<th scope="row" class="text-left">작성자</th>
						<td class="text-right">${reviewData.writerName }</td>				
					</tr>
					<tr>
						<th scope="row" class="text-left">지역</th>
						<td class="text-right">${AreacodeConverter.getKey(reviewData.areacode) }</td>
					</tr>
					<tr>
						<th scope="row" class="text-left">숙소 명</th>
						<td class="text-right">${reviewData.locationName }</td>
					</tr>
					<tr>	
						<th class="text-left">별점</th>
						<c:choose>							
							<c:when test="${reviewData.rate == '1.0' }">
							<td class="text-right">
								<p class="rate">
									<span>
										<i class="icon-star"></i>
										<i class="icon-star-o"></i>
										<i class="icon-star-o"></i>
										<i class="icon-star-o"></i>
										<i class="icon-star-o"></i>
									</span>
								</p>
							</td>
							</c:when>
							<c:when test="${reviewData.rate == '2.0' }">
							<td class="text-right">
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
							<td class="text-right">
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
							<td class="text-right">
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
							<td class="text-right">
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
			  	</table>			
              </div>
            </div>
          </div>
        </div>
      </div>
    </section> <!-- .section -->
	
    <jsp:include page="/WEB-INF/views/include/common/footer.jsp"
		flush="false" />
		
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
		<button type="button" id="toList" class="btn btn-default" data-dismiss="modal">취소</button>
		<button type="button" id="toContent" class="btn btn-danger" onclick="location.href='/review_deleteAction?no=${reviewData.reviewNo}'">삭제</button>
	      </div>
	    </div>
	  </div>
	</div>

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
  <script src="/static/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="/static/js/google-map.js"></script>
  <script src="/static/js/main.js"></script>


    
  </body>
  <iframe name="iframe1" style="display:none;"></iframe>
</html>