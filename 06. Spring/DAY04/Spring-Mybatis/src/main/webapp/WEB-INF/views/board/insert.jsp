<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 쓰기</title>
</head>
<body>
	<h1>게시글 쓰기</h1>
	<form action="${pageContext.request.contextPath }/board/insert" method="POST">
		<table>
			<tr>
				<td><label for="title">제목</label></td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td><label for="writer">작성자</label></td>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<td><label for="content">내용</label></td>
				<td>
					<textarea rows="5" cols="20" name="content" ></textarea>
				</td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록" />
		</div>
	</form>
	
	
</body>
</html>