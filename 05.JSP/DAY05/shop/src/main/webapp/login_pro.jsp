<%@page import="shop.Service.UserServiceImpl"%>
<%@page import="shop.Service.UserService"%>
<%@page import="shop.DAO.UserDAO"%>
<%@page import="shop.DTO.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	Users user = new Users();
	user.setId(id);
	user.setPassword(password);
	
	// 로그인 요청
	UserService userService = new UserServiceImpl();
	Users loginUser = userService.login(user);
	
	if( loginUser != null ) {
		// 로그인 성공
		// 세션에 아이디 등록 후, 메인 페이지로 이동
		session.setAttribute("loginId", loginUser.getId());
		response.sendRedirect("index.jsp");
	}
	else {
		// 로그인 실패
		response.sendRedirect("login.jsp?msg=0");
	}
	
	
	

%>




