<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<h1>hello world</h1>
	<ul>
		<li><a href="<%= root %>/board/list.do">list 게시글 목록</a></li>
		<li><a href="<%= root %>/board/read.do">board read</a></li>
		
	</ul>
</body>
</html>