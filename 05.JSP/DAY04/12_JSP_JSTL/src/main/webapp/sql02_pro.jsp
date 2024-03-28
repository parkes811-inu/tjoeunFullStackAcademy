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
<title>JSTL sql - 게시글 등록</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
	%>
	<!-- ctrl + alt + shift + L : 퀵서치 -->
	<!-- 데이터 소스 -->
	<sql:setDataSource
		var="dataSource"
		url="jdbc:oracle:thin:@localhost:1521:orcl"
		driver="oracle.jdbc.OracleDriver"
		user="joeun"
		password="123456"
	/>
	
	<sql:update dataSource="${dataSource}" var="resultSet">
		INSERT INTO board( no, title, writer, content )
		VALUES( SEQ_BOARD.nextval, ?, ?, ? )
		<sql:param value="<%= title %>"></sql:param>
		<sql:param value="<%= writer %>"></sql:param>
		<sql:param value="<%= content %>"></sql:param>
	</sql:update>
	
	<!-- JSTL을 이용한 외부 페이지 포함하기 -->
	<c:import url="sql01.jsp" var="url" />
	${url}
</body>
</html>









