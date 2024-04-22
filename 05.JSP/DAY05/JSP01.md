 **<h5>04월 04일 EL 수업1</h5>** <br>

# EL, Expression Language/JSTL, JavaServer Pages Standard
# Tag Library- 표현 언어와 표준 태그 라이브러리

- JSP 페이지에서 데이터를 출력하고 표현하기 위한 언어
- 목적 : JSP 페이지에서 자바 코드를 최소화 하기 위하 사용

### EL 기본 문법 <br>
```HTML
<!-- 기본 문법 -->
${ 표현식 }

<!-- 변수 참조 -->
${ 변수명 }

<!-- 연산 -->
${ a + b }

<!-- 객체의 속성 참조 -->
${ 객체명.속성명 }

<!-- 컬렉션 요소 참조 -->
${ 컬렉션명[index].속성명 }

<!-- 논리 연산 -->
${ condition ? A :  B }

```
<br>

### EL 내장 객체 <br>

|내장 객체|사용 예시|설명|
|---|---|---|
|pageScope|${pageScope.attributeName}|현재 JSP 페이지 스코프의 속성에 접근합니다.|
|requestScope|${requestScope.attributeName}|현재 HTTP 요청 스코프의 속성에 접근합니다.|
|sessionScope|${sessionScope.attributeName}|현재 사용자 세션 스코프의 속성에 접근합니다.|
|applicationScope|${applicationScope.attributeName}|웹 애플리케이션 스코프의 속성에 접근합니다.|
|param|${param.parameterName}|HTTP 요청 매개변수에 접근합니다.|
|paramValues|${paramValues.parameterName}|HTTP 요청 매개변수의 값 목록에 접근합니다.|
|header|${header.headerName}|HTTP 요청 헤더에 접근합니다.|
|initParam|${initParam.paramName}|웹 애플리케이션 초기 매개변수에 접근합니다.|
|pageContext|주로 포워딩, 인클루딩, 리다이렉트와 관련된 작업에 사용됩니다.|현재 페이지 컨텍스트에 접근합니다.|

<br>

### JSP 내장 객체 vs EL 내장 객체 <br>

|JSP 내장 객체|EL 내장 객체|
|---|---|
|pageContext|${pageContext}|
|page|-|
|request|${requestScope}|
|response|-|
|session|${sessionScope}|
|application|${applicationScope}|
|out|${out}|
|config|${pageContext.config}|

<br>
<hr>
<br>

### JSTL 종류 <br>

|종류|설명|
|-----|---|
|Core (<c:> 태그)|변수 설정, 반복문, 조건문 등 JSP의 기본 제어 구조를 제공합니다. 예를 들어, <c:forEach>, <c:if>, <c:set> 등의 태그가 포함됩니다.|
|XML (<x:> 태그)|XML 데이터를 처리하는데 사용되며, XML 파싱, 검색, 변환 등의 작업을 수행할 수 있습니다. <x:parse>, <x:out>, <x:forEach> 등의 태그가 포함됩니다.|
|Formatting (<fmt:> 태그)|날짜, 시간, 숫자 등의 데이터 형식을 다루는데 사용됩니다. 데이터 포맷팅 및 다국어 지원을 위한 태그들이 포함됩니다. <fmt:formatDate>, <fmt:parseDate>, <fmt:setTimeZone> 등의 태그가 있습니다.|
|SQL (<sql:> 태그)|데이터베이스와 연동할 때 사용되며, SQL 쿼리 실행 및 결과 처리를 지원합니다. <sql:setDataSource>, <sql:query>, <sql:update> 등의 태그가 있습니다.|
|Function (<fn:> 함수)|문자열 처리 및 비교를 위한 함수들을 제공합니다. 예를 들어, <fn:length>, <fn:toUpperCase>, <fn:substring> 등의 함수가 있으며, 이러한 함수는 <c:out>와 함께 사용됩니다.|

<br>

### taglib 디렉티브 태그 <br>

- taglib 디렉티브 태그는 JSP에서 JSTL, EL, 커스텀 태그 등 태그 라이브러리를 설정하는 태그

|JSTL 라이브러리|디렉티브 태그|
|---|---|
|Core (<c:> 태그)|<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>|
|XML (<x:> 태그)|<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>|
|Formatting (<fmt:> 태그)|<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>|
|SQL (<sql:> 태그)|<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>|
|Functions (<fn:> 함수)|<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>|

<br>

### taglib 라이브러리 사용 
```javascript
<%-- taglib 디렉티브 태그 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>taglib 디렉티브 - JSTL</title>
</head>
<body>
	<%-- WEB-INF > lib : jstl-xxx-impl.jar 라이브러리 추가 --%>
	<c:forEach var="k" begin="1" end="10" step="1">
		<c:out value="${k}" />
	</c:forEach>
</body>
</html>
```