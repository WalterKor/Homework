<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userlogin</title>
<style>
	.errMsg{color: red};
</style>
</head>
<body>
	<h1>로그인화면</h1>
	<div class="errMsg">${errMsg}</div>
	<div>
		<form action="/user/login" method="post">
			<div>
				<input type="text" name="uid" placeholder="아이디를 입력하세요">
			</div>
			<div>			
				<input type="password" name="upw" placeholder="비밀번호를 입력하세요">
			</div>
			<div>
				<input type="submit" value="로그인">
				<input type="reset" value="초기화">
			</div>			
		</form>	
		<button><a href="/user/join">회원가입</a></button>
	</div>
</body>
</html>