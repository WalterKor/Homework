<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		table, th, td {
			border: 1px solid black;
			border-collapse: collapse; 
		}
		.record{cursor: pointer;}
		.record:hover {background: red; }
		
	</style>

</head>
<body>
	<a href="/write3">글쓰기</a>
	
	
	<div>
		<table>
			<tr>
				<th>number</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
				
			<c:forEach var="item" items="${list}" >
				<tr class="record" onclick="moveDetail(${item.iboard});">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.date}</td>			
				</tr>	
			</c:forEach>
			
		</table>
	</div>
	<script>
		function moveDetail(iboard) {
			location.href='/detail3?iboard=' + iboard;
		}
	</script>
</body>
</html>