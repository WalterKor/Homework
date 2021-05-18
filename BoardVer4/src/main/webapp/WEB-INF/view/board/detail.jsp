<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
<script defer src="/res/js/boardDetail.js?ver=5"></script>
<link rel="stylesheet" href="/res/css/boardList.css?ver=1">

</head>
<body>
	<h1>디테일페이지</h1>
	<a href="/board/list">리스트로 돌아가기</a>
	<div>${param.iboard}</div>
	
	<div>제목 : ${data.title}</div>
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
	
		<form action="/board/cmt" method="post">
			<input type="hidden" name="iboard" value="${requestScope.data.iboard}">
		<div>
			<textarea name="cmt" placeholder="글을 작성해주세요"></textarea>
			<input type="submit" value="댓글등록">
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
							<input type="button" value="수정">
							<button onclick="delCmt(${requestScope.data.iboard}, ${item.icmt})">삭제</button> 
						</c:if>
					</td>
				</tr>
			</c:forEach>
			
						
		</table>
	
	
</body>
</html>