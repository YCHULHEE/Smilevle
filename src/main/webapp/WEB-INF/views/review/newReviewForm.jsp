<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%
	String[] areas = {"서울", "인천", "대전", "대구", "광주", 
			"부산", "울산", "세종", "경기", "강원", "충북",
			"충남", "경북", "경남", "전북", "전남", "제주"};
	String[] areacodes = {"1", "2", "3", "4", "5", "6", "7", "8",
			"31", "32", "33", "34", "35", "36", "37", "38", "39"};
	String[] rates = {"0.0", "0.5", "1.0", "1.5", "2.0", 
			"2.5", "3.0", "3.5", "4.0", "4.5", "5.0"};
	Map<String, String> areacodeMap = new HashMap<>();
	for(int i = 0; i < areas.length; i++) {
		areacodeMap.put(areas[i], areacodes[i]);
	}
	
	pageContext.setAttribute("areacodes", areacodeMap);
	pageContext.setAttribute("rates", rates);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 글쓰기</title>
<script src="//cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
</head>
<body>
	<form action="review_write.do" method="post">
		<p>
			제목: <br/> <input type="text" name="title" value="${param.title }">
			<c:if test="${errors.title }">제목을 입력하세요!</c:if>
		</p>
		<p>
			지역(시/도): 
			<select id="areacode" name="areacode">
				<option value=null> -지역- </option>
				<c:forEach var="map" items="${areacodes }">
					<option value='${map.value }'> ${map.key } </option>
				</c:forEach>
			</select>
			<c:if test="${errors.areacode }">지역을 선택하세요!</c:if>
		</p>
		<p>
			건물 명: <input type="text" name="locationName" value="${param.loactionName }">
			<c:if test="${errors.locationName }">건물 명을 입력하세요!</c:if>
		</p>
		<p>
			별점: 
			<select id="rate" name="rate">
				<option value=null> -별점- </option>
				<c:forEach var="rate" items="${rates }">
					<option value='${rate }'> ${rate } </option>
				</c:forEach>
			</select>
			<c:if test="${errors.rate }">별점을 선택하세요!</c:if>
		</p>
		<p>
			내용: <br/>
			<textarea rows="5" cols="30" name="content" id="content">${param.content }</textarea>
			<script type="text/javascript">
			 CKEDITOR.replace('content', 
						{	height: 500,
							width: 850,
							filebrowserUploadUrl: '/Smilevle/review_upload.do'
						}
					 );
			</script>		
		</p>
		<input type="submit" value="새 글 등록">
	</form>
</body>
</html>