<!-- taglib 디렉티브 태그 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태그 라이브러리 디렉티브 - JSTL</title>
</head>
<body>
	<%-- WEB-INF -> lib : jstl_xxx-impl.jar 라이브러리 추가 --%>
	<%
		for(int k = 1; k <= 10; k++) {
	%>	
		<span style="color: blue;"><%= k %></span>
	<%	
		}
	%>
	
	<hr>
	
	<c:forEach var="k" begin="1" end="10" step="1">
		<span style="color: red;"> ${k} </span>
		<c:out value="${k}"></c:out>
	</c:forEach>
</body>
</html>