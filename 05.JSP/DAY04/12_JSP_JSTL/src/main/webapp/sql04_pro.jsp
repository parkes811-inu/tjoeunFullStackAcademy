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
<title>JSTL sql - 게시글 삭제</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
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
		DELETE FROM board
		 WHERE no = ? 
		<sql:param value="<%= no %>"></sql:param>
	</sql:update>
	
	<!-- JSTL을 이용한 외부 페이지 포함하기 -->
	<c:import url="sql01.jsp" var="url" />
	${url}
</body>
</html>









