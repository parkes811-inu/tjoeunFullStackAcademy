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
<title>메인 페이지</title>
</head>
<body>
	<h1>shop</h1>
	<h3>메인 화면</h3>
	
	<c:if test="${ sessionScope.loginId != null }">
		<h5>${ sessionScope.loginId } 님 환영합니다.</h5>
		<a href="logout.jsp">로그아웃</a>
	</c:if>
	
	<a href="join.jsp">회원가입</a>
	<a href="login.jsp">로그인</a>
	
	
	
	
</body>
</html>








