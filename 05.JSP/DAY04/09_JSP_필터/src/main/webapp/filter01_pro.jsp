<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증 필터</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
	%>
	<p>입력된 name 값 : : <%= name %></p>
</body>
</html>