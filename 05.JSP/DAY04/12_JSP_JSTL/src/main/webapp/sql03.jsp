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
<title>JSTL sql - 게시글 수정</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="sql03_pro.jsp" method="post">
		<p>번호 : <input type="text" name="no"/></p>
		<p>제목 : <input type="text" name="title"/></p>
		<p>작성자 : <input type="text" name="writer"/></p>
		<p>내용 : <input type="text" name="content"/></p>
		<p><input type="submit" value="수정"> </p>
	</form>
</body>
</html>










