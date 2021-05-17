<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<!--?ver=1 캐쉬데이터로인해 제대로 작동하지 않았을경우-->
<link rel="stylesheet" href="/res/css/boardList.css?ver=1">
<script defer="defer" src="/res/js/boardList.js"></script>
</head>
<body></body>
	<div>로그인 성공</div>
	<div>${loginUser.unm}님 (${loginUser.uid})환영합니다.</div>
	<a href="/user/logout">로그아웃</a>

	<div>
		<a href="write">글쓰기</a>
	</div>
	
	<div>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
			</tr>
			
			<c:forEach var ="item" items="${list}">
					<tr class="record" onclick="moveToDetail(${item.iboard})">
						<td>${item.iboard}</td>
						<td>${item.title}</td>
						<td>${item.unm}</td>
						<td>${item.regdt}</td>
					</tr>			
			</c:forEach>
		</table>
	
	</div>
</html>