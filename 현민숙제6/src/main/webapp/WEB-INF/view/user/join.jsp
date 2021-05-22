<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<div>
		<form action="/user/join" method="post">
			<div>
				<input type="text" placeholder="아이디를 입력해주세요" name="uid">
			</div>
			<div>
				<input type="password" placeholder="비밀번호를 입력해주세요" name="upw">
			</div>
			<div>
				<input type="text" placeholder="성함을 입력해주세요" name="unm">
			</div>
			
			<div>
				성별 : 
				남<input type="radio" name="gender" value="0" checked="checked">
				여<input type="radio" name="gender" value="1" checked="checked">
			</div>
			
			<div>
				<input type="submit" value="회원가입">
				<input type="reset" value="초기화">
			</div>
		</form>
	</div>
</body>
</html>