<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문</title>
</head>
<body>
	<!-- 2개의 숫자를 더해주는 메소드 -->
	<%!	
		int sum(int a, int b) {
			return a + b;
		}	
	%>
	
	<h1><% out.println( sum(10, 20 )); %></h1>
</body>
</html>