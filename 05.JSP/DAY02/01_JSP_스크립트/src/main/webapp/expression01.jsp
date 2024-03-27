<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식 </title>
</head>
<body>
	<!-- 
		선언문	: 변수 선언 O, 메소드 정의 O
				__jspService() 외부에 변수 선언 
	
		스크립틀릿	: 변수 선언 O, 메소드 정의 X
				__jspService() 내부에 변수 선언
				
		표현식	: 변수 사용, 메소드 호출
		
	-->
	
	<%-- 선언문 --%>
	<%!
		int a = 100;
	%>
	
	<%-- 스크립틀릿 --%>
	<%
		int a = 10;
		int b = 20;
		int c = 30;
		int sum = a + b + c;
	%>
	
	<%-- 표현식 --%>
	<%= a + b + c %>
	<%= sum %>
	<h3>sum : <%= sum %></h3>
</body>
</html>