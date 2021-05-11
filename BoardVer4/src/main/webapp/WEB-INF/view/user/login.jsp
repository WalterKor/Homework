<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
	.errMsg{ color: red};
	body{
		background-color: coral;
	}
</style>
</head>

<body>
	<div>
	<div class="errMsg">${errMsg}</div> <!--페이지컨텍스 리퀘스트 세션 어플리케이션 EL식  -->
		<div>							
			<form action="/user/login" method="post">
				<div><input type="text" name="uid" placeholder="아이디"></div>
				<div><input type="password" name="upw" placeholder="비밀번호"></div>
				<div>
					<input type="submit" value="login">
				</div>
			</form>
		</div>
		<div>
			<a href="join">회원가입</a>
		</div>
	</div>
</body>
</html>

