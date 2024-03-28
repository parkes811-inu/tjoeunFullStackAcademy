<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 - 아이디 저장</title>
</head>
<body>
	<!-- 쿠키 가져오기 -->
	<%
		Cookie[] cookies = request.getCookies();
		
		String userId = "";
		String remeberId = "";
		
		String rememberId = "";
		if( cookies != null )
		for(int i = 0 ; i < cookies.length ; i++) {
			// userID 라는 이름의 쿠키 가져오기
			if( cookies[i].getName().equals("userID)") ) {
				userId = cookies[i].getValue();
			} 
			// rememberID 라는 이름의 쿠키 가져오기
			if( cookies[i].getName().equals("rememberID") ) {
				rememberId = cookies[i].getValue();
			}
		}
	%>	
	
	<form action="cookie01_pro.jsp" method="post">
		<p> 아 이 디 : <input type="text" name="id" value="<%= userId %>"> </p>
		<p> 비밀번호 : <input type="text" name="passwd" value=""> </p>
		<p>
			<%
				if( rememberId.equals("on") ) {
			%>
			<input type="checkbox" name="rememberId" id="remember-id" checked />
			<%
				} else {
			%>
			<input type="checkbox" name="rememberId" id="remember-id" />
			<%
				}
			%>
			<label for="remember-id">아이디 저장</label>
		</p>
		<p><input type="submit" value="로그인"></p>
	</form>
</body>
</html>








