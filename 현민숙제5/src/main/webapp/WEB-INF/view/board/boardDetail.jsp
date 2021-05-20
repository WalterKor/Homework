<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/res/css/boardList.css?ver=1">
<script defer="defer" src="/res/js/boardDetail.js" ></script>
<title>상세페이지</title>
</head>
<body>
		
	<h1>디테일화면입니다.</h1>
	<a href="/board/list">리스트화면으로 돌아가기</a>
	<div>${param.iboard}</div>
	
	<div>제목 : ${data.title}</div>
	<div>작성자 : ${data.unm}</div>
	<div>내용 : ${data.ctnt}</div>
	<div>작성일 : ${data.regdt}</div>
	
	<c:if test= "${loginUser.iuser == data.iuser}">
		<div>
			<a href="/board/del?iboard=${param.iboard}"><button>삭제</button></a>
			<a href="/board/mod?iboard=${param.iboard}"><button>수정</button></a>
		</div>
	</c:if>
	
	<h3>댓글창</h3>
	
	<form id="insFrm" action="/cmt" method="post">
		<input type="hidden" name="icmt" value="0">
		<input type="hidden" name="iboard" value="${data.iboard}">
		<div>
			<textarea name="cmt" placeholder="댓글을 작성해주세요"></textarea>
			<input type="submit" value="댓글작성">
		</div>
	</form>
	
	<table>
		<tr>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>비고</th>
		</tr>
		
		<c:forEach var="item" items="${cmtList}">
			<tr class="record">
				<td>${item.cmt}</td>
				<td>${item.unm}</td>
				<td>${item.regdate}</td>
				<td>
					<c:if test="${item.iuser == loginUser.iuser}">
						<input type="button" value="수정" onclick="udpCmdt(${item.icmt},${item.cmt.trim()})">
						<button onclick="delcmt(${data.iboard}, ${item.icmt})">삭제</button>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>