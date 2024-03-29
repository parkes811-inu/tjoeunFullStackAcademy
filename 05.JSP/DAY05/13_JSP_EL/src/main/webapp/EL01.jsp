<%@page import="DTO.Board"%>
<%@page import="java.util.ArrayList"%>
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
<title>EL - 표현언어</title>
</head>
<body>
	<%-- 변수 선언 --%>
	<% 
		int num1 = 10;
		int num2 = 20;
		pageContext.setAttribute("num1", num1);
		pageContext.setAttribute("num2", num2);
	%>
<%-- 	<c:set var="num1" value="10" /> --%>
	<%-- EL 을 사용하여 변수 값 표시 --%>
	<h1>첫 번째 숫자 : ${num1}</h1>
	<h1>두 번째 숫자 : ${num2}</h1>
	
	<%-- EL 을 사용하여 변수 값 변경 --%>
	<h1>num1 + num2 = ${num1 + num2}</h1>
	<h1>num1 - num2 = ${num1 - num2}</h1>
	
	<%-- 문자열 연결 --%>
	<% 
		String name1 = "THE";
		String name2 = "JOEUN"; 
		pageContext.setAttribute("name1", name1);
		pageContext.setAttribute("name2", name2);
	%>
	<h1>이름 : ${name1} ${name2}</h1>
		
	<%
		Board board = new Board();
		pageContext.setAttribute("board", board);
	%>
	<%-- 객체 접근 --%>
	<h1>${board.title}</h1>
	
	<%-- 객체 리스트 접근 --%>
	<% 
 		Board board1 =  new Board("제목01", "작성자01", "내용01");
 		Board board2 =  new Board("제목02", "작성자02", "내용02");
 		Board board3 =  new Board("제목03", "작성자03", "내용03");
 		List<Board> boardList = new ArrayList<Board>();
 		boardList.add(board1);
 		boardList.add(board2);
 		boardList.add(board3);
 		pageContext.setAttribute("boardList", boardList);
 	%>
	<h1>board 객체 리스트 접근</h1>
	<ul>
	<c:forEach var="board" items="${boardList}">
		<li>${board.title}</li>
	</c:forEach>
	</ul>

</body>
</html>





