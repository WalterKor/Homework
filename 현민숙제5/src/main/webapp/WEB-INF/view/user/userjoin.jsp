<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userjoin</title>
</head>
<body>
	<h1>회원가입화면입니다.</h1>
	<button><a href="/user/login">로그인페이지로 돌아가기</a></button>
	
	<div>
		<form action="/user/join" method="post">
			<div>
				<input type="text" name="uid" placeholder="아이디를 입력해주세요">
			</div>
			<div>
				<input type="password" name="upw" placeholder="비밀번호를 입력해주세요">
			</div>
			<div>
				<input type="text" name="unm" placeholder="성함을 입력해주세요">
			</div>
			
			<div>
				<label>남<input type="radio" name="gender" checked="checked" value="0"></label>
				<label>여<input type="radio" name="gender" value="1"></label>
			</div>
			
			<div>
				<input type="submit" value="회원가입">
				<input type="reset" value="초기화">
			</div>
		</form>
	</div>
</body>
</html>