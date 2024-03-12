 **<h5>3월11일 HTML 수업</h5>**

> **HTML, Hypertext Markup Language 개념과 구조** </br> </br>
      - 웹 페이지를 만들기 위한 표준 망크업 언어 </br>
      - 웹 페이지의 구조를 설명합니다. </br>
      - 일련의 element(요소)로 구성됩니다. </br>
      - element(요소)는 브라우저에 콘텐츠를 표시하는 방법을 알려줍니다. </br>

</br>

**HTML 파일의 기본 구조** </br> </br>

|코드|설명|
|------|---|
|\<!DOCTYPE html> | HTML5 문서임을 정의합니다.|
|\<html>| HTML 페이지의 루트 요소입니다.|
|\<head>| HTML 페이지에 대한 메타 정보를 포함합니다.|
|\<title>| 페이지의 제목을 지정합니다.|
|\<body>| 문서의 본문을 정의합니다.|
|charset| 해당 문서의 문자 인코등 방식을 명시합니다.|
|name| 메타데이터를 위한 이름을 명시합니다.|
|content|관련된 값을 명시합니다.|

</br>

---

> **HTML 요소 (Element)**
</br>

* HTML의 요소는 시작 태그 + 내용 + 종료 태그로 구성된다.
 ```html
 <h1> h1 태그를 가진 내용입니다.</h1>
 ```

</br>

---

> **HTML 속성 (Attribute)**
</br>

* HTML의 속성은 요소의 추가적인 정보를 제공한다. </br>
 ```html
    <tag 속성="속성값"> 요소 내용 </tag>
 ```

</br>

---

> **HTML 공통 속성**
</br>

* 모든 HTML 요소에서 지원되는 속성 </br>
 
|속성|설명|
|------|---|
|id|하나의 요소를 지정하는 고유 식별 속성|
|class|여러 요소를 지정하는 그룹 식별 속성|
|style|스타일을 지정하는 속성|
|title|요소에 대한 정보를 나타내는 속성(툴팁)|
|\<!-- -->|브라우저에 표시되지 않고 HTML 코드를 설명하는 내용이다.|
</br>

---

> **Web Standard, 웹 표준** </br>

    - 웹에서 사용되는 표준 기술이나 규칙
    - W3C 권고안에서 나오는 기술들
    - 필요성 : 과거에는 브라우저마다 웹 페이지가 다르게 보여지거나
        멀티미디어 기능이 작동하지 않는 문제 발생
        -> 모든 브라우저에서 웹페이지가 동일하게 보이고 정상 작동

</br>

---

> **Web Accessibility, 웹 접근성** </br>

    - 모든 사용자가 신체적, 환경적 조건에 관계없이 웹에 접근하여 이용할 수 있도록 보장하는 것

    - 신체적 : 일반인, 장애인, 고령자 등
    - 환경적 : 브라우저, 운영체제, 디바이스 등

</br>

---

> **Web Accessibility, 웹 접근성** </br>

    - 모든 사용자가 신체적, 환경적 조건에 관계없이 웹에 접근하여 이용할 수 있도록 보장하는 것

    - 신체적 : 일반인, 장애인, 고령자 등
    - 환경적 : 브라우저, 운영체제, 디바이스 등

</br>

---

> **Cross Browsing, 웹 호환성** </br>

    - 여러 브라우저에서 동일한 사용자 경험을 줄 수 있도록 웹 페이지를 제작하는 기술, 방법

    - 주로 MISE(인터넷 익스플로러)에서도 동작하도록 웹페이지를 제작하는 기술, 방법을 의미

</br>    

---

> **HTML 기본 태그** </br>

    - 텍스트
    - 리스트
    - 링크
    - 이미지
    - 테이블

</br>   

---

> **태그의 분류** </br>

|block 태그|inline 태그|
|------|---|
|h1 ~ h6|strong, b|
|p|l, em|
|br|q|
|hr|mark|
|blockquote|sapn|
|pre|ruby|
||abbr, cite, code, ...|

</br> 

---

> **리스트 태그** </br>

|태그|설명|기타|
|------|---|---|
|\<ul>|순서가 없는 목록태그|Unordered List|
|\<ol>|순서가 있는 목록 태그|Ordered List|
|\<dl>|정의 목록 태그|Definition List|

<br>

---

> **링크 태그** </br>

```html
<a href="이동할 위치"></a>

    - 절대 경로 : href="http://www.naver.com"
    - 상대 경로 : href=".01_text.html"
    - 내부 파일 : href="#top"

target="이동방식"

    - _self     : 현재 페이지에서 열기
    - _blank    : 새로운 탭, 창에서 열기
    - _parent   : 부모프레임으로 페이지 이동
    - _top      : 최상위 프레임에서 열기

title="설명"
```

<br>

---

> **이미지 태그** </br>

```html
<image src="이미지 위치" alt="대체 텍스트" />

    - width         : 가로 크기
    - height        : 세로 크기
    - 이미지 종류    : JPEG, PNG, GIF

관련 태그 : <figure>, <figcaption>

경로 
    - 절대 경로 : 최상위 위치 부터 모든 상위 경로를 포함한 고유 경로
                C:/ALOHA/WEB/IMG/강아지.jpg
 
    - 상대 경로 : 해당 파일이 위치한 곳을 기준으로 한 경로
                ./IMG/강아지.png
```

---

> **테이블 태그** </br>
    
    - 표 형태의 데이터를 표시하는 태그

<br>

|태그|설명|
|------|---|
|tr|표의 행을 표시|
|th, td|표의 열을 표시|
|caption|표의 제목|
|thead, tbody, tfoot|표의 머리/몸/꼬리 영역 구분|
|colgroup|열을 그룹지어서 속성을 적용| 

<br>

---

<br>

**<h4>멀티미디어 태그</b4>** </br>
    
    - 오디오
    - 비디오
    - iframe

<br>

> **오디오 태그** </br>

    - HTML에서 오디오를 재생할 수 있는 태그
    - 속성 : autoplay, controls, loop, preload, src, volume
    - 오디오 파일 형식 : mp3, wav, ogg
        - 브라우저 마다 지원되는 파일 형식이 다르다. 
        -> <source> : 여러가지 오디오 파일 형식을 동시에 제공

<br>

> **비디오 태그** </br>

    - HTML에서 비디오를 재생할 수 있는 태그
    - 속성 : autoplay, controls, loop, poster, preload, muted, src, volume, width, height

    - 비디오 파일 형식 : mp4, WebM, ogg
        - 브라우저 마다 지원되는 파일 형식이 다르다. 
        -> <source> : 여러가지 비디오 파일 형식을 동시에 제공

<br>

> **iframe** </br>

    - 페이지 내부에 다른 웹 페이지를 표시하는 태그
    - iframe(Inline Frame)
    - 속성 : src, width, height

---

<br>

> **입력 양식 태그** </br>    

    - <form>
        - HTML 입력 양식을 생성하는 태그
        - 속성 : action, method, enctype
        - 입력 : <input>, <textarea>, <select>, <fieldset>, <lable>, ...

<br>

> **WEB의 3요소** </br>    

    - HyperText를 전송하는 규약
    - 클라이언트와 서버 간 요청과 응답을 주고 받는 약속
    - 클라이언트 : 서비스를 요청하는 프로그램
    - 서버 : 클라이언트의 요청에 응답하는 프로그램

<br>

---

<br>

> **레이아웃 태그** </br>    

* 블록 요소와 인라인 요소
* div & span
* 시맨틱 요소

<br>

> **블록 요소 VS 인라인 요소** </br>    

> **block 요소**
 
 - 가능한 전체 너비를 차지
 - 항상 새로운 줄에서 시작
 - width, height, margin, padding 등을 사용하여 크기와 간격을 변경할 수 있음.
 - 블록 요소의 종류
  : address, article, aside, audio, blockqutoe, canvas, dd, div, dl, fieldset, figcaption, figure, footer, form, h1, h2, h3, h4, h5, h6, header, hgroup, hr, noscript, ol, output, p, pre, section, table, ul, video

>**inline 요소**

 - 컨텐츠 크기만큼 너비를 차지
 - 새로운 줄에서 시작하지 않음
 - width, height로 크기를 변경할 수 없음
 - line-height로 줄의 높이를 변경
 - text-align으로 수평 정렬
 - 인라인 요소의 종류 : a, abbr, acronum, b, bdo, big, br, button, cite, code, dfn, em, i, img, input, kbd, label, map, object, q, samp, small, script, select, span, strong, sub, sup, textarea, tt, var

<br>

**div**
 : 공간 분할 태그로, 블록 형식으로 공간 분할

<br>

**span**
 : 공간 분할 태그로, 인라인 형식으로 공간 분할

<br>

<br>

> **Semantic element** </br>    

* 브라우저에 의미나 목적을 명확하게 알려주는 요소

|태그|설명|
|------|---|
|\<header>|문서의 머리말|
|\<hgroup>|h1 ~ h6 요소의 그룹|
|\<nav>|네비게이션 링크|
|\<article>|문서의 내용이나 포스트|
|\<section>|문서의 섹션|
|\<aside>|사이드 바|
|\<footer>|문서의 꼬리말|
|\<figure>|그림이나 도표|
|\<time>|날짜와 시간 표시|
