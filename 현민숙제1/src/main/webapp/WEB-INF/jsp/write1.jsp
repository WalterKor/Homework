<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>글작성</h1>
	
	<form action="/write1" method="post">
		
		<div>
			제목 : <input type="text" name = "title">
		</div>
		
		<div>
			내용 <textarea rows="30" cols="30" name="ctnt"></textarea>
		</div>
		
		<input type="submit" value="글등록">
		<input type="reset" value="초기화">
		
	</form>
	
</body>
</html>