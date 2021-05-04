<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/write3" method="post">
		<div>
			제목 : <input type="text" name="title">		
		</div>
		<div>
			내용 : <textarea rows="30" cols="30" name="ctnt"></textarea>		
		</div>	
	
		<input type="submit" value="제출">
		<input type="reset" value="초기화">
	</form>
</body>
</html>