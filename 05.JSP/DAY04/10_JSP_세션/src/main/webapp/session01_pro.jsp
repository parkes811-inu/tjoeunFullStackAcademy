<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 로그인</title>
</head>
<body>
	<%
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("passwd");
		
		if( user_id.equals("admin") && user_pw.equals("1234") ) {
			session.setAttribute("userID", user_id);
			session.setAttribute("userPW", user_pw);
			out.println("세션 설정 성공!!");
			out.println(user_id + "님 환영합니다.");
		} else {
			out.println("세션 설정 실패!");
		}
	%>
	<a href="<%= request.getContextPath() %>/session02.jsp">session02.jsp</a>
</body>
</html>












