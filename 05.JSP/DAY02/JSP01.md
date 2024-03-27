 **<h5>3월26일 JSP 2일차 수업1</h5>** <br>

## 2장 JSP 태그

<br>

### - JSP 태그 <br>
    • 스크립트 태그 : JSP 에서 자바 코드를 실행하기 위해 사용하는 태그

    • 디렉티브 태그 : JSP 페이지의 속성과 구성을 설정하는 태그

    • 액션 태그 : JSP 페이지에서 특정 작업을 수행하는 태그

<br>

- 스크립트 태그 <br>
    • 선언문 : <!% 코드 %> -> 와 같은 형태로 변수나 메소드 정의
    
    • 스크립틀릿 : <% 코드 %> -> 와 같은 형태의 자바 코드 로직

    • 표현문 : <%= 코드 %> -> 와 같은 형태로 작성되는 변수, 계산 수식, 메소드 호출에 사용

<br>

- 선언문 변수 VS 스크립틀릿 변수 선언 <br>
    - 선언문에서 변수를 선언 : 서블릿으로 변환 시, _jspService() 메소드 외부에 선언
    
    - 스크립틀릿 변수 선언 : 서블릿으로 변환 시, _jspService() 메소드 내부에 선언

<br>

- 디렉티브 태그 <br>

|태그|형태|의미|
|----|----|----|
|page|<%@page...%>|JSP 페이지에 대한 정보|
|include|<%@include...>|외부 JSP 페이지를 현재 페이지 내부로 포함 시킴|
|taglib|<%@taglib ...%>|JSP페이지엣어 사용할 태그 라이브러리를 지정|

<br>

- Page 디렉티브 태그 <br>

|속성(Attribute)|설명|기본값|
|---|---|---|
|language|JSP 페이지에서 사용할 스크립트 언어를 설정||
|contentType|응답의 콘텐츠 타입과 문자 인코딩 설정||
|pageEncoding|JSP 페이지의 문자 인코딩 설정||
|import|다른 클래스나 패키지를 JSP 페이지로 가져옴||
|session|true, false 값을 가질 수 있고, true로 설정 시 JSP 페이지에서 세션 사용 가능||
|buffer|버퍼 크기 설정||
|autoFlush|true, false 값을 가질 수 있고, true로 설정 시 버퍼가 가득찰 경우 자동 출력||
|isThreadSafe|true, false 값을 가질 수 있고, true로 설정 시 JSP 페이지 스레드가 안전하게 처리||
|info|JSP 페이지에 대한 설명 제공||
|errorPage|오류 페이지로 이동할 URL 설정||
|isErrorPage|true, false 값을 가질 수 있고, true로 설정 시 이 페이지가 오류 페이지임을 지정||
|isElIgnored|true, false 값을 가질 수 있고, ture 설정 시 EL을 비활성화||
|extends|||

<br>

- pageEncoding 속성 <br>
    : 한글 출력을 위해 지정해야하는 속성 값

    - UTF-8
    - EUC-KR
    *위의 UTF-8, EUC-KR 인코딩 타입이 아닌 기본값 ISO-8859-1이 적용되어 있으면, 한글이 깨짐*
<br>

---
 
### - include 디렉티브 태그 <br>
    - JSP에 외부 파일을 포함 시키는 태그
    - 포함 가능 파일 : HTML, JSP, TXT 파일 등

```jsp
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include</title>
</head>
<body>
	<%@ include file="include01_header.jsp" %> <!--include 태그를 활용해 jsp 파일 포함-->
	<div class="container">
		<h1>컨텐츠 영역</h1>
		<h3><%= new Date() %></h3>
	</div>
	<%@ include file="include01_footer.jsp" %>
</body>
</html>
```

<br>
