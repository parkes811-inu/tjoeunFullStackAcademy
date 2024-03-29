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
<title>회원 가입</title>
</head>
<body>
	<h1>회원 가입</h1>
	<c:if test="${ param.msg == 0 }">
		<p style="color: red;">회원가입에 실패하였습니다.</p>
	</c:if>
	<form action="join_pro.jsp" method="post">
		<p>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" />
		</p>
		<p>
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password" />
		</p>
		<p>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" />
		</p>
		<p>
			<label for="gender">성별</label>
			<input type="text" name="gender" id="gender" />
		</p>
		<p>
			<label for="birth">생년월일</label>
			<input type="text" name="birth" id="birth" />
		</p>
		<p>
			<label for="mail">메일</label>
			<input type="text" name="mail" id="mail" />
		</p>
		
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>










