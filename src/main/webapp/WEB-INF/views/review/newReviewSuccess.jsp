<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	게시글을 등록했습니다. <br/>
	${ctxPath = pageContext.request.contextPath; "" }
	<a href="${ctxPath }/review.do">[게시글 목록 보기]</a>
	<a href="${ctxPath }/review_read.do?no=${newReviewNo }">[게시글 내용 보기]</a>
</body>
</html>