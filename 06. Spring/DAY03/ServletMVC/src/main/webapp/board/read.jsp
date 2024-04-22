<%@page import="dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   Board board = (Board) request.getAttribute("board");
   String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
</head>
<body>
   <h1>게시글 조회</h1>
   <h3>board/read.jsp</h3>
   <h2><%= board.getTitle() %></h2>
   <h3><%= board.getWriter() %></h3>
   <p>
      <%= board.getContent() %>
   </p>
   <a href="<%= root %>/board/update.do?no=1">수정</a>
   <form action="<%= root %>/board/deletePro.do">
      <input type="submit" value="삭제">
   </form>
</body>
</html>