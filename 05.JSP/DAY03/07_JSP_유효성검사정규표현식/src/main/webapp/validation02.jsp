<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 비밀번호 유효성 검사</title>
</head>
<body>
	<h1>회원가입</h1>
	<h3>유효성 검사</h3>
	
	<form name="joiniForm" onsubmit="return checkJoin()" action="validation02_pro.jsp" method="post">
	<p>아이디 : <input type="text" name="id" maxlength="20"/></p>
	<p>비밀번호 : <input type="password" name="pw"/></p>
	<p>이름 : <input type="text" name="name"/></p>
	<p>나이 : <input type="text" name="age" onkeyup="checkNumber()"/></p>
	<p><input type="submit" value="회원가입"></p>
	</form>
	
	<script>
		
		// 회원 가입 유효성 검사
		function checkJoin() {
			
			let form = document.joiniForm; // name이 joinForm인 폼 요소를 가져옴.
			let id = form.id.value;
			let pw = form.pw.value;
			let name = form.name.value;
			let age = form.age.value;
			
			// 1. 아이디는 필수 값, 6 ~ 20자 이내
			// 아이디 입력여부 검증
			if(id == "") {
				alert('아이디를 입력해주세요.');
				return false;
			}
			
			// 아이디 글자 수 검증
			if(id.length < 6 || id.length > 20) {
				alert('아이디는 6 ~ 20자 이내로 입력 가능합니다.');
				form.id.select();	// id 입력 값을 선택
				return false;
			}
			
			// 2. 비밀번호는 필수 값, 6자 이상
			// 아이디 입력여부 검증
			if(pw == "") {
				alert('비밀번호를 입력해주세요.');
				return false;
			}
			
			// 비밀번호 글자 수 검증
			if(id.length < 6 || id.length > 20) {
				alert('비밀번호는 6 ~ 20자 이내로 입력 가능합니다.');
				form.pw.select();	// pw 입력 값을 선택
				return false;
			}
			
			// 3. 이름은 필수 값이고, 첫 글자는 숫자로 사용 불가
			if(name == "") {
				alert('이름을 입력해주세요.')
				return false;
			}
			
			// isNaN() : 숫자가 아니면 true
			if(!isNaN(name.substr(0, 1))) {
				alert('이름은 숫자로 시작할 수 없습니다.');
				return false;
			}
			
			// 4. 나이 검증
			//if(!checkNumber()) {
				//alert('나이는 숫자로만 시작할 수 있습니다.');
				//return false;
			//}
			return true;	
		}
		
		// 나이 유효성 검사
		function checkNumber() {
			let form = document.joinForm;
			
			console.log( event.keyCode );
			
			// 숫자가 아닌 경우
			if( !(event.keyCode >= 48 && event.keyCode <= 57)) {
				alert('숫자만 입력 가능합니다.');
				form.age.value = ''; 
				event.returnValue = false;
			}
			
			
		}
	</script>
</body>
</html>