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
<title>JSTL</title>
</head>
<body>
	<h1>문자열 검색</h1>
	<h3>Hello JSTL~!</h3>
	<h5>${fn:contains("Hello JSTL~!","Hello")}</h5>
	<c:set var="check" value=""></c:set>
	
	<c:if test="${fn:contains('Hello JSTL~!','Hello') }">
		Hello 포함되어 있습니다.
	</c:if>
</body>
</html>






