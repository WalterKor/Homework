<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
<script defer src="/res/js/boardDetail.js?ver=7"></script>
<link rel="stylesheet" href="/res/css/boardList.css?ver=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
 .hidden{ display: none; }
 .fa-heart{ color: red}
</style>
</head>
<body>
	<h1>디테일페이지</h1>
	<a href="/board/list">리스트로 돌아가기</a>
	<div>${param.iboard}</div>
	

	<h1>	
		${data.title}
		<c:if test="${data.isFav eq 0}">		
			<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a>
		</c:if>
		<c:if test="${data.isFav eq 1}">
			<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart"></i></a>				
		</c:if>
	</h1>

	<div>작성자 : ${data.unm}</div>
	<div>내용 : ${data.ctnt}</div>
	<div>작성일 : ${data.regdt}</div>
	
	<c:if test="${loginUser.iuser == data.iuser}">
		<div>
			<a href="/board/del?iboard=${param.iboard}"><button>삭제</button></a>
			<a href="/board/mod?iboard=${param.iboard}"><button>수정</button></a>			
		</div>
	</c:if>	
	
	<h3>댓글</h3>
		
	<form id="insFrm" action="cmt" method="post">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${requestScope.data.iboard}">
		<div>
			<textarea name="cmt" placeholder="글을 작성해주세요"></textarea>
			<input type="submit" value="댓글등록">
		</div>
	</form>
		
	<form id="updFrm" action="cmt" method="post" class="hidden">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${requestScope.data.iboard}">
		<div>
			<textarea name="cmt" placeholder="댓글내용"></textarea>
			<input type="submit" value="댓글수정">
			<input type="button" value="수정취소" onclick="showInsFrm()">
		</div>
	</form>
		
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr> 
			
			
			<c:forEach var="item" items="${requestScope.cmtList}">
				<tr class="record">
					<td>${item.cmt}</td>
					<td>${item.unm}</td>
					<td>${item.regdate}</td>
					<td>
						<c:if test="${item.iuser == sessionScope.loginUser.iuser}">
							<input type="button" value="수정" onclick="updCmt(${item.icmt},'${item.cmt.trim()}')">
							<button onclick="delCmt(${requestScope.data.iboard}, ${item.icmt})">삭제</button> 
						</c:if>
					</td>
				</tr>
			</c:forEach>
			
						
		</table>
	
	
</body>
</html>