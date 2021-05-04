<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>

	<div>
		<a href="/write2">글쓰기</a>
	</div>
	
	<form action="/write2" method="post">
		
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea rows="30" cols="30"></textarea>
		</div>
		
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	
	</form>
	
</body>
</html>