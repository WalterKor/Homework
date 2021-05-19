<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/res/css/boardList.css?ver=1">
<title>상세페이지</title>
</head>
<body>
		
	<h1>디테일화면입니다.</h1>
	<a href="/board/list">리스트화면으로 돌아가기</a>
	<div>${param.iboard}</div>
	
	<div>제목 : ${data.title}</div>
	<div>작성자 : ${data.unm}</div>
	<div>내용 : ${data.ctnt}</div>
	<div>작성일 : ${data.regdt}</div>
	
	<c:if test= "${loginUser.iuser == data.iuser}">
		<div>
			<a href="/board/del?iboard=${param.iboard}"><button>삭제</button></a>
			<a href="/board/mod?iboard=${param.iboard}"><button>수정</button></a>
		</div>
	</c:if>
	
	<h3>댓글창</h3>
</body>
</html>