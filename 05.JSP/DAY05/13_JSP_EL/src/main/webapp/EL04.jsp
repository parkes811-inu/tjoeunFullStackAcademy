<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
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
<title>EL applicationScope </title>
</head>
<body>
	<h1>EL applicationScope 사용</h1>
	
	<%
		// application 객체에서 접속자 수를 가져오거나 초기화
		AtomicInteger visitorCount = (AtomicInteger) application.getAttribute("visitorCount");
		if( visitorCount == null ) {
			visitorCount = new AtomicInteger(0);
			application.setAttribute("visitorCount", visitorCount);
		}
		
		// 접속자 수를 1 증가시킵니다.
		int currentCount = visitorCount.incrementAndGet();
		// -> 세션이 생성될 때, 접속자 수를 증가하는 로직으로 변경
	%>
	<h1>사이트 접속자 수 : ${ applicationScope.visitorCount }</h1>
	
	
</body>
</html>









