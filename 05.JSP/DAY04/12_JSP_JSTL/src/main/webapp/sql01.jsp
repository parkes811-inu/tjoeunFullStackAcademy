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
<title>JSTL sql</title>
</head>
<body>
	<h1>게시글 목록</h1>
	
	<!-- 데이터 소스 -->
	<sql:setDataSource
		var="dataSource"
		url="jdbc:oracle:thin:@localhost:1521:orcl"
		driver="oracle.jdbc.OracleDriver"
		user="joeun"
		password="123456"
	/>
	
	<!-- 목록 조회 -->
	<sql:query var="resultSet" dataSource="${dataSource}">
		SELECT * FROM board
	</sql:query>
	
	
	<table border="1">
		<tr>
			<c:forEach var="columnName" items="${resultSet.columnNames}">
				<th width="100"><c:out value="${columnName}" /></th>
			</c:forEach>
		</tr>
		<c:forEach var="row" items="${resultSet.rowsByIndex}">
		<tr>
			<c:forEach var="column" items="${row}" varStatus="i">
			<td>
				<c:if test="${column != null}">
					<c:out value="${column}" />
				</c:if> 
				<c:if test="${column == null}">
					&nbsp;
				</c:if>
			</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table>
</body>
</html>








