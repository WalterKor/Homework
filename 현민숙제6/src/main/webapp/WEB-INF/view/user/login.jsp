<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인jsp</title>
</head>
<body>
	 <h1>로그인페이지</h1>
	 
	 <div>
	 	<form action="login" method="post" >
	 	
		 	<div>
		 		<input type="text" placeholder="아이디" name="uid">
		 	</div>
		 	<div>
		 		<input type="password" placeholder="비밀번호" name="upw">
		 	</div>
		 	
		 	<div>
		 		<input type="submit" value="로그인">
		 	</div>
		 	
	 	</form>
	 </div>
	 
	 <div>
	 	<button><a href="join">회원가입</a></button>
	 </div>
	 
</body>
</html>