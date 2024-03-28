<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <p><h4>---- 세션 삭제하기 전 ----</h4></p>
    <%
        String user_id = (String) session.getAttribute("userID");
        String user_pw = (String) session.getAttribute("userPW");
        out.println("설정된 세션 속성 userID : " + user_id + "<br>");
        out.println("설정된 세션 속성 userPW : " + user_pw + "<br>");
        // 세션 속성 제거
        session.removeAttribute("userID");
        session.removeAttribute("userPW");
    %>
    <p><h4>---- 세션을 삭제한 후 ----</h4></p>
    <%
        user_id = (String) session.getAttribute("userID");
        user_pw = (String) session.getAttribute("userPW");
        out.println("설정된 세션 속성 userID : " + user_id + "<br>");
        out.println("설정된 세션 속성 userPW : " + user_pw + "<br>");
    %>

</body>
</html>