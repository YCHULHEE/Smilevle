<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	게시글을 수정했습니다. <br/>
	${ctxPath = pageContext.request.contextPath ; "" }
	<a href="${ctxPath }/review.do">[목록으로]</a>
	<a href="${ctxPath }/review_read.do?no=${modReq.reviewNumber }">[게시글 내용 보기]</a>
</body>
</html>