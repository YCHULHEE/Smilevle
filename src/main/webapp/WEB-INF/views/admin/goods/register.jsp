<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

	<title>관리자모드</title>
	
	<script src="/static/css/jquery-3.2.1.min.js"></script>
	
	<link rel="stylesheet" href="/static/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/static/bootstrap/bootstrap-theme.min.css">
	<script src="/static/bootstrap/bootstrap.min.js"></script>
	
	<script src="/static//ckeditor/ckeditor.js" ></script>

	<link rel="stylesheet" href="/static/css/admin/index.css">
	<link rel="stylesheet" href="/static/css/admin/goods/register.css">
	
	<link rel="icon" href="/static/images/gun.png" />

</head>

<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>
	
		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>
	
		<section id="container">
			<aside>
				<%@ include file="../include/aside.jsp"%>
			</aside>
			<div id="container_box">
				<h2>상품 등록</h2>
	
				<form role="form" method="post" autocomplete="off" enctype="multipart/form-data" class="registerForm">
	
				<div class="inputArea"> 
					<label>1차 분류</label>
					<select class="category1">
						<option value="">전체</option>
					</select>
				
					<label>2차 분류</label>
					<select class="category2" name="cateCode">
						<option value="">전체</option>
					</select>
				</div>
				
				<div class="inputArea">
					<label for="gdsName">상품명</label>
					<input type="text" id="gdsName" name="gdsName" />
				</div>
				
				<div class="inputArea">
					<label for="gdsPrice">상품가격</label>
					<input type="text" id="gdsPrice" name="gdsPrice" />
				</div>
				
				<div class="inputArea">
					<label for="gdsStock">상품수량</label>
					<input type="text" id="gdsStock" name="gdsStock" />
				</div>
				
				<div class="inputArea">
					<label for="gdsDes">상품소개</label>
					<textarea rows="5" cols="50" id="gdsDes" name="gdsDes"></textarea>
					
					<script>
						var ckeditor_config = {
							resize_enaleb : false,
							enterMode : CKEDITOR.ENTER_BR,
							shiftEnterMode : CKEDITOR.ENTER_P,
							filebrowserUploadUrl : "/admin/goods/ckUpload"
						};
	
						CKEDITOR.replace("gdsDes", ckeditor_config);
					</script>
				</div>
				
				<div class="inputArea">
					<label for="gdsImg">이미지</label>
					<input type="file" id="gdsImg" name="file" />
					<div class="select_img"><img src="" /></div>
					
					<script>
						$("#gdsImg").change(function(){
							if(this.files && this.files[0]) {
								var reader = new FileReader;
								reader.onload = function(data){
									$(".select_img img").attr("src", data.target.result).width(500);
								}
								reader.readAsDataURL(this.files[0]);
							}
						});
					</script>
					
					<%=request.getRealPath("/") %>
				</div>
				
				<div class="inputArea">
					<button type="button" id="register_Btn" class="btn btn-primary">등록</button>
					<script>
						$("#register_Btn").click(function(){
							var regConfirm = confirm("정말로 등록하시겠습니까?");

							if(regConfirm == true){
								$(".registerForm").submit();
							} else{
								return;
							}
						});
					</script>
				</div>
				
				</form>
			</div>
		</section>
	</div>
	
	<%@ include file="../include/TopBtn.jsp" %>

	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../include/footer.jsp"%>
		</div>
	</footer>
</body>
</html>
