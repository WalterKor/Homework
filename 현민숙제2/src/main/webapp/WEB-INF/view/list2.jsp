<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<style>
		table, th, td{
			border: 1px solid black;
			border-collapse: collapse;
		}
		.record:hover {background: red; }
		
		
		
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/write2">글쓰기</a>
	<div>
		<table>
			<tr>
				<th>number</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
			
			<c:forEach var="item" items="${list}">
			<tr class="record" onclick="Movedetail(${item.iboard})">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.regdt}</td>				
			</tr>
			
			</c:forEach>
			
		</table>
	</div>
	<script>
		function Movedetail(iboard) {
			location.href='/detail2?iboard=' + iboard;
		}
	</script>
</body>
</html>