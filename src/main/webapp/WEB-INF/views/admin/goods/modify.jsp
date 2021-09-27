<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<title>관리자모드</title>

<script src="/static/js/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/proj4js/2.7.2/proj4.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="/static/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/bootstrap/bootstrap-theme.min.css">
<script src="/static/bootstrap/bootstrap.min.js"></script>

<script src="/static//ckeditor/ckeditor.js"></script>

<link rel="stylesheet" href="/static/css/admin/index.css">
<link rel="stylesheet" href="/static/css/admin/goods/register.css">

<link rel="icon" href="/static/images/gun.png" />

<script>
	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrCoordUrl.do)를 호출하게 됩니다.
		var pop = window.open("jusoPopup", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");
	}

	function jusoCallBack(roadFullAddr, entX, entY) {
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		let coord_X = Math.round(entX * 1000000) / 1000000;
		let coord_Y = Math.round(entY * 1000000) / 1000000;
		let point = [ coord_X, coord_Y ];

		proj4.defs["EPSG:5179"] = "+proj=tmerc +lat_0=38 +lon_0=127.5 +k=0.9996 +x_0=1000000 +y_0=2000000 +ellps=GRS80 +units=m +no_defs";//제공되는 좌표

		let grs80 = proj4.Proj(proj4.defs["EPSG:5179"])
		let wgs84 = proj4.Proj(proj4.defs["EPSG:4326"]); //경위도

		let p = proj4.toPoint(point);
		p = proj4.transform(grs80, wgs84, p);

		document.form.address.value = roadFullAddr;
		document.form.mapX.value = p.x;
		document.form.mapY.value = p.y;
	}
</script>

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
				<h2>숙소 수정</h2>
				<div id="list"></div>
				<div id="callBackDiv">
					<form role="form" id="form" name="form" method="post"
						autocomplete="off" enctype="multipart/form-data"
						class="registerForm">

						<div class="inputArea">
							<label>지역분류</label> <select class="category1" name="areaCode">
								<c:forEach var="map" items="${areaMap}">
									<option value="${map.key}"
										${map.key == areaCode ? 'selected="selected"' : '' }>${map.value}</option>
								</c:forEach>
							</select>    <label>1차분류</label> <select class="category2"
								name="smallCategory">
								<c:forEach var="map" items="${itemMap}">
									<option value="${map.key}"
										${map.key == areaCode ? 'selected="selected"' : '' }>${map.value}</option>
								</c:forEach>
							</select>
						</div>

						<div class="inputArea">
							<label for="title">숙소이름</label> <input type="text" id="title"
								name="title" value="${item.title}" />
						</div>

						<div class="inputArea">
							<label for="address"> </label> <input type="button"
								onClick="goPopup();" style="width: 90px;" value="주소등록"
								class="btn btn-primary" />
						</div>
						<div class="inputArea">
							<label for="address">주소</label> <input type="text" id="address"
								name="address" readonly value="${item.address}"
								style="width: 300px; background-color: #e9ecef;" />
						</div>
						<div class="inputArea">
							<label for="address">X값</label> <input type="text" id="mapX"
								name="mapX" readonly value="${item.mapX}"
								style="width: 200px; background-color: #e9ecef;" />
						</div>
						<div class="inputArea">
							<label for="address">Y값</label> <input type="text" id="mapY"
								name="mapY" readonly value="${item.mapY}"
								style="width: 200px; background-color: #e9ecef;" />
						</div>


						<div class="inputArea">
							<label for="tel">전화번호</label> <input type="text" id="tel"
								name="tel" value="${item.tel}" />
						</div>

						<div class="inputArea">
							<label for="gdsStock">홈페이지 주소</label> <input type="text"
								id="homepage" name="homepage" value="${item.homepage}" />
						</div>

						<div class="inputArea">
							<label for="content">상품소개</label>
							<textarea rows="5" cols="50" id="content" name="content">${item.content}</textarea>
							<input type="hidden" name="contentTypeId" value="${item.contentTypeId}" />
							<input type="hidden" name="middleCategory" value="${item.middleCategory}" />
							<input type="hidden" name="readCnt" value="${item.readCnt}">
							

							<script>
								var ckeditor_config = {
									resize_enaleb : false,
									enterMode : CKEDITOR.ENTER_BR,
									shiftEnterMode : CKEDITOR.ENTER_P,
									filebrowserUploadUrl : "/admin/goods/ckUpload"
								};

								CKEDITOR.replace("content", ckeditor_config);
							</script>
						</div>

						<div class="inputArea">
							<label for="gdsImg">이미지</label> <input type="file"
								id="firstImage" name="file" />
							<div class="select_img">
								<img src="${item.firstImage}" /> <input type="hidden"
									name="firstImage" value="${item.firstImage}" />
							</div>

							<script>
								$("#firstImage")
										.change(
												function() {
													if (this.files
															&& this.files[0]) {
														var reader = new FileReader;
														reader.onload = function(
																data) {
															$(".select_img img")
																	.attr(
																			"src",
																			data.target.result)
																	.width(500);
														}
														reader
																.readAsDataURL(this.files[0]);
													}
												});
							</script>

							<%=request.getRealPath("/")%>
						</div>

						<div class="inputArea" align="right" style="margin-right: 20px">
						
							<button type="submit" id="back_Btn" class="btn btn-warning">돌아가기</button>
							<script>
								$("#back_Btn").click(function(){
									location.href="/admin/goods/list;
								});
							</script>
							
							<button type="button" id="register_Btn" class="btn btn-primary">수정</button>
							<script>
								$("#register_Btn").click(function() {
									var regConfirm = confirm("정말로 등록하시겠습니까?");

									if (regConfirm == true) {
										$(".registerForm").submit();
									} else {
										return;
									}
								});
							</script>
						</div>
					</form>
				</div>
			</div>
		</section>
	</div>
	<%@ include file="../include/TopBtn.jsp"%>
</body>
</html>
