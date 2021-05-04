<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		
		<a href="/list3">목록으로 돌아가기</a>
		<a href="/mod3?iboard=${param.iboard}">수정</a>
		<a href="/del3?iboard=${param.iboard}">삭제</a>
	</div>

	<div>작성일 : ${data.date}</div>
	<div>
		제목 : ${data.title}
	</div>
	<div>
		내용 : ${data.ctnt}
	</div>
</body>
</html>