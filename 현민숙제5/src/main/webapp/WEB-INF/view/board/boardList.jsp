<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer="defer" src="/res/js/boardList.js"></script>
<link rel="stylesheet" href="/res/css/boardList.css">
<title>리스트</title>
</head>
<body>
	<h1>리스트화면입니다.</h1>
	<h3>반갑습니다. ${loginUser.unm}님</h3>
	<div><button><a href="/user/logout">로그아웃</a></button></div>
	
	<a href="/board/wirte">글쓰기</a>
	
	<div>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
			</tr>
			
			<c:forEach var="item" items="${list}">
				<tr class="record" onclick="gotoDetail(${item.iboard})">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.unm}</td>					
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>