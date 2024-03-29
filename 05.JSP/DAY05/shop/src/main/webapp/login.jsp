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
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="login_pro.jsp" method="post">
		<p> 아 이 디 : <input type="text" name="id" value=""> </p>
		<p> 비밀번호 : <input type="password" name="password" value=""> </p>
		<p>
			<input type="checkbox" name="rememberId" id="remember-id" checked />
			<label for="remember-id">아이디 저장</label>
		</p>
		<c:if test="${ param.msg == 0 }">
			<p style="color:red;">
				아이디 또는 비밀번호가 일치하지 않습니다.
			</p>
		</c:if>
		<p><input type="submit" value="로그인"></p>
	</form>
</body>
</html>









