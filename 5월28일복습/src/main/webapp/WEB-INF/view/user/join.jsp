<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	div{
		margin: 5px;
	}
</style>

<body>


	<br>
	<div>
		<form action="/user/join" method="post"  id="frm" onsubmit="return frmChk();">
			<div>
				<input type="text" placeholder="아이디를 입력하세요" name="uid">
				<input type="button" value="아이디중복체크">
			</div>
			<div id="chkUidResult"></div>
			<div>
				<input type="password" placeholder="비밀번호를 입력하세요" name="upw"><br>
				<input type="password" placeholder="비밀번호를 확인해주세요" name="chkupw"><br>			
			</div>
			
			<div>
				<input type="text" placeholder="이름을 입력하세요" name="unm">
			</div>
			
			<div>
				성별 :
				<label>남<input type="radio" value="0" name="gender" checked="checked">	</label>
				<label></label>여<input type="radio" value="1" name="gender">	
			</div>
			
			<div>
				<input type="submit" value="회원가입">
				<input type="reset" value="초기화">				
			</div>
		</form>
	</div>
	
	<script src="/res/js/userJoin.js"></script>
	
</body>
