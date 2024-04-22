<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
</head>
<body>
	<h1>게시글 조회</h1>
	<form action="${pageContext.request.contextPath }/board/delete" method="POST">
		<input type="hidden" name="no" value="${board.no}" />
		<table>
			<tr>
				<td><label for="title">제목</label></td>
				<td><input type="text" name="title" value="${board.title}" /></td>
			</tr>
			<tr>
				<td><label for="writer">작성자</label></td>
				<td><input type="text" name="writer" value="${board.writer}" /></td>
			</tr>
			<tr>
				<td><label for="content">내용</label></td>
				<td>
					<textarea rows="5" cols="20" name="content" >${board.content}</textarea>
				</td>
			</tr>
		</table>
		<div>
			<a href="${pageContext.request.contextPath }/board/update?no=${board.no}">수정</a>
			<input type="submit" value="삭제" />
		</div>
	</form>
</body>
</html>