<%@page import="Service.BoardServiceImpl"%>
<%@page import="Service.BoardService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Board"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<%
// 		List<Board> boardList = new ArrayList<Board>();
// 		boardList.add(new Board(1,"제목01","작성자01","내용01"));
// 		boardList.add(new Board(2,"제목02","작성자02","내용02"));
// 		boardList.add(new Board(3,"제목03","작성자03","내용03"));
		
		BoardService boardService = new BoardServiceImpl();
		List<Board> boardList = boardService.list();
	%>
	
	<h1>게시글 목록</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일자</th>
		</tr>
		<%-- 표현식으로 boardList 가져오기 --%>
<%-- 		<c:forEach var="board" items="<%= boardList %>"> --%>

		<%-- 표현언어(EL)로 boardList 가져오기 --%>
		<c:set var="boardList" value="<%= boardList %>"></c:set>
		<c:forEach var="board" items="${ boardList }">
			<tr>
				<td><c:out value="${board.no}"/></td>
				<td><c:out value="${board.title}" /></td>
				<td><c:out value="${board.writer}" /></td>
				<td>
					<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>








