<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 태그</title>
</head>
<body>
	<%-- 선언문 --%>
	<%-- : 변수 선언이나 메소드를 정의하는 자바 코드를 작성 --%>
	<%!
		String greeting = "환영합니다~ !";
		String tagline = "Welcome to Web Page ~!";
	%>
	
	<%-- 표현문 --%>
	<%-- : 변수 접근, 수식 계산, 메소드 호출 등의 자바 코드 작성 --%>
	<h1><%= greeting %></h1>
	<h1><%= tagline %></h1>	
</body>
</html>