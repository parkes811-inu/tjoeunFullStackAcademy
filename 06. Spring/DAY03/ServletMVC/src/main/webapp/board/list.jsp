<%@page import="java.util.List"%>
<%@page import="dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   List<Board> boardList = (List<Board>) request.getAttribute("boardList");
   String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>게시글 목록</h1>
   <h3>/board/list.jsp</h3>
   <a href="<%= root %>/board/insert.do">글쓰기</a>
   <table border="1">
      <tr>
         <th>번호</th>
         <th>제목</th>
         <th>작성자</th>
         <th>등록일자</th>
      </tr>
      <%
         if( boardList != null ) 
            for( int i = 0; i < boardList.size(); i++ ) {
               Board board = boardList.get(i);
      %>
         <tr>
            <td><%= board.getNo() %></td>
            <td>
               <a href="<%= root %>/board/read.do?no=1"> </a>
               		<%= board.getTitle() %></td>
            <td><%= board.getWriter() %></td>
            <td><%= board.getRegDate() %></td>
         </tr>
      <%
            }
      %>
   </table>
</body>
</html>