<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>
	<h1>디테일 상세페이지</h1>
	
	<div>
		<a href="/list2">리스트로 돌아가기</a>
		<a href="/del2?iboard=${param.iboard}">삭제</a>
		<a href="/mod2?iboard=${param.iboard}">수정</a>
	</div>
	
	<div>제목 : ${data.title}</div>
	<div>작성일 : ${data.regdt}</div>
	<div>내용 : ${data.ctnt}</div>
</body>
</html>