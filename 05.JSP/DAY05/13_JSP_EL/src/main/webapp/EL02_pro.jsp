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
<title>requestScope name 속성</title>
</head>
<body>
	<h1>EL 에서 사용하는 내장 객체</h1>
	<% pageContext.setAttribute("pname", "123"); %>
	<h2>page Scope 속성 : ${ pname }</h2>
	<h2>request Scope 속성 : ${ requestScope.name }</h2>
</body>
</html>