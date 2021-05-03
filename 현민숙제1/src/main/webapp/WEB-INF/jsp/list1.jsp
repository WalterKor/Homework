<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록</title>
<style>
	table, th, td{
		border: 1px solid black;
		border-collapse: collapse;
	}
	.record{cursor: pointer;}
	.record:hover {background: navy;}
	
	
</style>
</head>
<body>
		<h1>리스트</h1>
		<a href="/write1">글등록</a>
		
		<div>
			<table>
				<tr>
					<th>number</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
				<c:forEach var="item" items="${list}">
					<tr class="record" onclick="moveTodetail(${item.iboard});">
						<td>${item.iboard}</td>
						<td>${item.title}</td>
						<td>${item.regdt}</td>
					</tr>
				</c:forEach>
				
				
			</table>
		</div>
		
		<script>
			function moveTodetail(iboard) {
				location.href='/detail1?iboard='+iboard;
			}
		</script>
		
</body>
</html>