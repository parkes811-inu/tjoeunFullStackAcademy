<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿</title>
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
	<%
		for(int i = 1; i <= 10; i++) {
			out.println("<h3>" + i + "</h3>");
		}
	%>
	<hr>
	<%
		for(int i = 1; i <= 10; i++) {
	%>
		<h3><%= i %></h3>
	<%
		}
	%>
	
</body>
</html>