<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form" onsubmit="return checkForm()">
        <p>제목 : <input type="text" name="title" /> </p>
        
        <p>아이디 : <input type="text" name="id" /> </p>
        <p>이름 : <input type="text" name="name" /> </p>
        
        <p>전화번호 : <select name="phone1">
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="016">016</option>
                        <option value="017">017</option>
                        <option value="019">019</option>
                    </select> 
                    - <input type="text" maxlength="4" size="4" name="phone2"> 
                    - <input type="text" maxlength="4" size="4" name="phone3">
                    
        <p>이메일 : <input type="text" name="email" /> </p>
        
        <p><input type="submit" value="등록" /> </p>
    </form>
    
	<script>
		function checkForm() {
			
			// 아이디 패턴 : 영문자, 한글 시작
			let regExpId = /^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]+$/
			
			// 이름 패턴 : 한글
			let regExpName = /^[가-힣]*$/
			
			// 전화번호 패턴 : [3자리 숫자]-[3 ~ 4자리 숫자]-[4자리 숫자]
			let regExpPhone = /^\d{3}-\d{3, 4}-\d{4}$/
			
			// 이메일 패턴 [숫자, 영문자]@[숫자, 영문자].~~.[영문자2~3자리]
			// ooo@oooo.com, ooo@oooo.co.kr, ooo@oooo.ac.kr, ooo@oooo.org, ...
			let regExpEmail = /^[0-9a-xA-Z](-_\.)?[0-9a-zA-Z]*@[0-9a-xA-Z](-_\.)?[0-9a-zA-Z]*\.[a-zA-Z]{2,3}$/i
					
			let id = form.id.value;
			let name = form.name.value;
			let phone = form.phone1.value + "-" + form.phone2.value + "-" + form.phone3.value;
			let email = form.email.value;
			
			// test() : 부합하면 true, 부합하지 않으면 false
			if(!regExpId.test(id)) {
				alert('아이디를 형식에 맞게 입력해주세요.');
				return false;
			}
			
			if(!regExpName.test(name)) {
				alert('이름 형식에 맞게 입력해주세요.');
				return false;
			}
			
			if(!regExpName.test(phone)) {
				alert('전화번호 형식에 맞게 입력해주세요.');
				return false;
			}
			
			if(!regExpEmail.test(email)) {
				alert('이메일 형식에 맞게 입력해주세요.');
				return false;
			}
			
			return true;
		}
	</script>
	
</body>
</html>