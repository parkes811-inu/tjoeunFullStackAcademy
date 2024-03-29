<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 무효화
	session.invalidate();

	// 메인 페이지로 이동
	// i) jsp를 지정하여 이동
	response.sendRedirect("index.jsp");
	// ii) url 경로를 지정하여 root 페이지로 이동
	// response.sendRedirect(request.getContextPath() + "/");
	
%>






