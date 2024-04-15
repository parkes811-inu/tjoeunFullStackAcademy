<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	<hr>
	<table border="1">
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
		</tr>
		<c:forEach var="board" items="${ boardList }">
			<tr>
				<td>${ board.title }</td>
				<td>${ board.writer }</td>
				<td>${ board.content }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
