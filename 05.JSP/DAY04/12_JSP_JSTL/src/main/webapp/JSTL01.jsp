<%-- taglib 디렉티브 태그 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>taglib 디렉티브 - JSTL</title>
</head>
<body>
	<%-- WEB-INF > lib : jstl-xxx-impl.jar 라이브러리 추가 --%>
	<%
		for( int k = 1 ; k <= 10 ; k++ ) {
			out.println(k + " ");
		}
		out.println("<br>");
	%>
	
	<c:forEach var="k" begin="1" end="10" step="1">
		<c:out value="${k}" />
	</c:forEach>
</body>
</html>









