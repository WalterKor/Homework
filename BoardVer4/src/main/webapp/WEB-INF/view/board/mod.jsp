<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>수정</h1>
		<a href="/board/list">리스트로 돌아가기</a>
		<br>
		<a href="/board/del?iboard=${param.iboard}">삭제</a>
	<div>
		<form action="mod" method="post">
			<input type="hidden" name="iboard" value="${param.iboard}" readonly="readonly"> 			
			<div><input type="text" name="title" value="${data.title}"></div>
			<div><textarea rows="30" cols="30" name="ctnt">${data.ctnt}</textarea></div>
			
			<div>
				<input type="submit" value="등록">
				<input type="reset" value="초기화">
			</div>
		</form>
	</div>
</body>
</html>