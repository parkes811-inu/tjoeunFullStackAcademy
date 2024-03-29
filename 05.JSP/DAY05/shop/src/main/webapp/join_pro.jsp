<%@page import="shop.Service.UserServiceImpl"%>
<%@page import="shop.Service.UserService"%>
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
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String birth = request.getParameter("birth");
	String mail = request.getParameter("mail");
	
	Users user = new Users();
	user.setId(id);
	user.setPassword(password);
	user.setName(name);
	user.setGender(gender);
	user.setBirth(birth);
	user.setMail(mail);
	
	// 회원 정보 등록 요청
	UserService userService = new UserServiceImpl();
	int result = userService.join(user);
	
	// 회원가입 성공
	if( result > 0 ) {
		response.sendRedirect("index.jsp");
		session.setAttribute("loginId", user.getId());
	}
	
	// 회원가입 실패
	else {
		response.sendRedirect("join.jsp?msg=0");		// msg=0 은 회원가입 실패
	}
%>






