<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Spring JDBC!  
	</h1>
	
	<ul>
		<li>
		    <a href="${ pageContext.request.contextPath }/board/list">게시판</a>
		</li>
	</ul>
</body>
</html>
