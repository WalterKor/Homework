<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
	<a href="/list2">리스트로 돌아가기</a>
	
	<form action="/mod2" method="post">
		<input type="hidden" name="iboard" value="${param.iboard}">
		<div>
			제목 : <input type="text" name="title" value="${data.title}">
		</div>
	
		<div>
			내용 : <textarea rows="30" cols="30">${data.ctnt}</textarea> 
		</div>
	
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</form>
</body>
</html>