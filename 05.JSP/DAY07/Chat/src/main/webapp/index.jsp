<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		var socket = new WebSocket("ws://localhost:8080/Chat/chatting");
		
		socket.onopen = function() {
			console.log("WebSocket 연결 성공.");
		};
		
		socket.onmessage = function(event) {
			var chatArea.innerHTML += "<div>" + event.data + "</div>";
			chatArea.scrollTop = chatArea.scrollHeight;
		};
		
		socket.onclose = function() {
			console.log("WebSocket 연결 종료.");
		};
		
		function sendMessage() {
			var messageInput = document.getElementById("messageInput");
			var message = messageInput.value;
			var name = document.getElementById("name").value;
			
			if( name == '' ) {
				alert('이름을 입력해주세요');
				return
			}
			socket.send(name + " : " + message);
			
			maeesageInput.value = "";
			
			var chatArea = document.getElementById("chatArea");
			chatArea.scrollTop = chatArea.scrollHeight;
		}
		
		function handleKeyPress(event) {
			console.log(event); // ㅇㅎㅇㅎㅇㅎㅇㅎㅇㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅇㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅇㅎㅇㅎㅇㅎㅇㅎㅇㅇㅇㅎㅇㅎㅇㅎㅇㅎㅇㅇ오ㅗ오오오옹오오ㅗㅇ오ㅗㅇ옴농라ㅓㅁ ㄴㄴㅇㅈ도갸ㅕㄴ어라ㅗㄷ쟈ㅕ론어
			// 후움 후우우우움휴우뭉휴움ㅁ,,, 휴우ㅡㅁ,,,휴우우우움,,,, 흉,ㅁ,,ㅁㄴㅇ로 3ㅑㅈㄱ뎌ㅗ능로뱌ㅕㅈㄷ곡ㄴ어ㅜㄹ ㅑㅕㅈ독ㄹㄴ어루 ㅑㅗ라ㅓㄴ어ㅜㄹㅈ로ㅓㄴ아루ㅏ먼우ㅑㅕㅈ도거ㅏㅗ2ㅑㄴ어라ㅘ너오ㅑ젿곤ㅇ
			// 흠,,,, 타건감... 흐음...조금 무거울지도.. 아닌강 ㅁㅎㅎㅎㅎㅎ
			// 이거 비싼 키보드잖아요~~~ 캬캬ㅑㅑ캬ㅑ캬캬캬ㅑ카ㅓㄴㅇㄹ ㅏ재갸ㅓㄹ나ㅣㅇㄹ ㅐㅈ덜ㄴ
			// 글자가 왜케 째꼼해요 눈알 빠지겠어요
			if(event.keyCode === 13) { 
				sendMessage();
			}
		}
 	</script>
</head>
<body>
	<div id="chatArea" style="height: 200px; overflow-y: scroll;"></div>
	<input type="text" id="name" name="name" placeholder="이름"/> <br>
	<input type="text" id="messageInput" placeholder="메시지를 입력하세요." onkeypress="handleKeyPress(event)">
	<button onclick="sendMessage()">보내기</button>
</body>
</html>