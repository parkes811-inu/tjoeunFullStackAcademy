<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("id");
	String user_pw = request.getParameter("passwd");
	String remember_id = request.getParameter("rememberId"); // 아이디 저장여부
	
	// checkbox 체크시, 기본값 on 이 넘어온다
	out.println("remember_id : " + remember_id + "<br>");
	
	// ✅아이디 저장 체크 시, 쿠키 생성
	if( remember_id != null && remember_id.equals("on") ) {
		Cookie cookie_id = new Cookie("userID", user_id);
		Cookie cookie_remember_id = new Cookie("rememberID", remember_id);
		response.addCookie(cookie_id);
		response.addCookie(cookie_remember_id);
		out.println("아이디를 쿠키에 저장했습니다.<br>");
	}
	// 🟩아이디 저장 미체크 시, 쿠키 삭제
	else {
		Cookie cookie_id = new Cookie("userID", user_id);
		Cookie cookie_remember_id = new Cookie("rememberID", remember_id);
		cookie_id.setMaxAge(0);
		cookie_remember_id.setMaxAge(0);
		response.addCookie(cookie_id);
		response.addCookie(cookie_remember_id);
		out.println("아이디를 쿠키에서 해제했습니다.");
	}
	if( user_id != null && user_pw != null ) {
		out.println(user_id + "님 환영합니다.");
	}
	else {
		out.println("로그인에 실패했습니다.");
	}
%>	

