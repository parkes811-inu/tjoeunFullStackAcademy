<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>예외 에러 페이지</h1>
	<h3>시스템 작업 처리 중 예외가 발생하였습니다.</h3>
	<a href="<%= request.getContextPath() %>">메인 화면</a>
	</body>
	<form action="exception_pro.jsp" method="post">
        <p> 숫자1 : <input type="text" name="num1">
        <p> 숫자2 : <input type="text" name="num2">
        <p> <input type="submit" value="나누기">
    </form>
</body>
</html>