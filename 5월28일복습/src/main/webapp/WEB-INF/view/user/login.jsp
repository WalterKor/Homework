<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<br>
	<div>
		<button>
			<a href="/user/join">회원가입</a>
		</button>
	</div>
	<form action="login" method="post">	
		<div>
			<input type="text" placeholder="아이디" name="uid" >
		</div>
		<div>
			<input type="text" placeholder="비밀번호" name="upw" >
		</div>
		
		<div>
			<input type="submit" value="등록">
			<input type="reset" value="다시작성">
		</div>
	</form>
</body>
