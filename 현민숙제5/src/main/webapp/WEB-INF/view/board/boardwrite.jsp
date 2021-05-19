<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
	<h1>글쓰기화면입니다.</h1>
	<a href="/board/list">리스트로돌아가기</a>
	<div>
	
		<form action="/board/wirte" method="post">
			<div>
				<input type="text" name="title" placeholder="글 제목을 작성하시오">
			</div>
			<br>
			<div>
				<textarea rows="30" cols="30" placeholder="글을 작성하시오" name="ctnt"></textarea>
			</div>
			
			<div>
				<input type="submit" value="글등록">
				<input type="reset" value="초기화">
			</div>
		</form>
		
	</div>
</body>
</html>