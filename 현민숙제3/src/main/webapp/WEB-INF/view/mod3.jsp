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
		<a href="/del3?iboard=${param.iboard}">삭제</a>
		<a href="/mod3?iboard=${param.iboard}">수정</a>
	</div>

	<div>작성일 : ${data.date}</div>
	
	<form action="/mod3" method="post">
		<input type="hidden" name="iboard" value="${param.iboard}">
		<div>
			제목 : <input type="text" name="title" value="${data.title}">
		</div>
		<div>
			내용 : <textarea rows="30" cols="30" name="ctnt">${data.ctnt}</textarea>
		</div>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</form>
</body>
</body>
</html>