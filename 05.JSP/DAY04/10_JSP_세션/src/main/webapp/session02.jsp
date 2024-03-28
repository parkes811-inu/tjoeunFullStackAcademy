<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 가져오기</title>
</head>
<body>
	<h1>세션 정보 가져오기</h1>
	<%
		String user_id = (String) session.getAttribute("userID");
		String user_pw = (String) session.getAttribute("userPW");
		
		out.println("설정된 세션 속성 값 [1] - user_id : " + user_id + "<br>");
		out.println("설정된 세션 속성 값 [2] - user_pw : " + user_pw + "<br>");
	
	%>
</body>
</html>









