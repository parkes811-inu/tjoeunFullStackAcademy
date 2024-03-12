 **<h5>3월12일 CSS 수업</h5>**

> **CSS, Cascading Style Sheets** </br> </br>
    : 웹 페이지의 스타일을 지정하는 언어 </br>
      HTML요소가 표시되는 방식을 설명 </br>
      * 스타일 : 속성을 이용하여 웹 페이지를 디자인하는 것 </br>
      * 스타일 시트 : 반복되는 스타일들을 모아 놓은 것 </br>

</br>

**선택자, Selector** </br> </br>

    - HTML 문성의 특정 영역이나 요소 등을 선택해줄 수 있는 키워드 
    - 종류 

|기본|관계|기타|
|------|---|---|
|전체 선택자|종속 선택자|기타 선택자|
|태그 선택자|하위선택자|속성 선택자|
|클래스 선택자|자식 선택자|
|아이디 선택자|인접 선택자|
|그룹 선택자|형제 선택자|

</br>

**스타일 적용 우선 순위** </br>
    1. 웹 브라우저 디폴트 값 </br>
    2. 인라인 스타일 </br>
    3. 내부 스타일 시트 </br>
    4. 외부 스타 시트 </br>
</br> 

**선택자 중복 지정 시, 마지막에 지정한 스타일이 적용된다!** </br>   

**CSS 스타일 기초** </br>

    - 색상
    - 폰트
    - 텍스트 스타일

<br>

---

<br>

> **선택자의 종류** </br> </br>

|종류|내용|예시|
|------|---|---|
|전체 선택자|전체 문서 선택|*|
|태그 선택자|HTML 태그 선택|p, table, body, nav 등|
|아이디 선택자|#(id 속성)|#header, #footer|
|클래스 선택자|.(class 속성)|.btn, .container, .item|
|그룹 선택자|여러 선택자를 복합 적용|p.class, #id, table|
|종속 선택자|선택자에 종속된 선택자|p.content, div#wrap|
|하위 선택자|선택자 내부의 후손 선택자|p a, .container h2, p #id|
|자식 선택자|선택자 바로 밑의 자식 선택자|div>p, p>a|
|인접 선택자|특정요소와 붙어있는 선택자 지정|h1 + p|
|형제자매 선택자|형제자매 관계에 있는 선택자 지정|div~table|
|가상 선택자|특정 이벤트에 대한 선택자 지정|a:hover, button:active|
|속성 선택자|태그의 속성을 지정하는 선택자|[name='email'], [data='1']|

<br>

---

<br>

> **가상 선택자** </br> </br>

* 가상(클래스) 선택자; 의사(클래스) 선택자

|종류|내용|
|------|---|
|:hover|마우스 커서가 링크에 올라가 있는 상태|
|:active|마우스 커서를 클릭한 순간부터 놓기 직전까지 상태|
|:link|링크를 클릭하지 않은 상태|
|:visited|링크를 눌러서 방문한 후 상태|
|:focus|입력 폼에서 키보드 입력을 기다리는 상태|
|:first-line|첫 번째 문장에만 적용|
|:first-letter|첫 번째 글자에만 적용|
|:before|문장이 시작되기 전|
|:after|문장이 끝난 다음|
|:lang|언어별로 속성을 적용하기 위한 선택자|
|:first-of-type|선택자 중 맨 처음에 나오는 요소를 선택|
|:last-of-type|선택자 중 맨 마지막에 나오는 요소를 선택|
|:only-of-type|지정한 태그 선택자로만 구성된 요소 하나만을 선택|
|:nth-of-type(n)|특정 택의 n번째 자식을 선택|
|:nth-last-of-type(n)|맨 마지막부터 계산하여 특정 태그의 n번째 자식을 선택|
|:only-child|지정한 태그 선택자의 오직 자식만을 선택|
|:nth-child(n)|지정한 태그의 n번째 자식을 선택|
|:nth-last-child(n)|마지막 자식을 선택|
|:first-child|첫번째 자식을 선택|
|:last-child|마지막 자식을 선택|
|:root|웹 페이지의 최상위 root를 선택|
|:emtpy|아무런 내용이 없는 특정 태그를 선택|
|:target|내부에서 링크를 이용하여 문서의 특정 부분으로 이동할 때 사용|
|:enabled|활성화한 태그를 선택|
|:disabled|비활성화한 태그를 선택|
|:checked|체크된 태그를 선택|
|:not(x)|X 선택자를 제외한 나머지를 선택|
|:section|웹 페이지에서 마우스를 이용하여 텍스트 등을 선택한 경우를 선택|

<br>

---

<br>

**스타일 적용 방법** </br>

    - 인라인 스타일 : <h1 style="color : red;">Hello</h1>
    - 내부 스타일 : <style></style>
    - 외부 스타일 시트 : <link href="css/style.css">

</br>

---

<br>

**텍스트 태그** </br>

|block 태그|inline 태그|
|------|---|
|h1 ~ h6|strong, b|
|p|l, em|
|br|q|
|hr|mark|
|blockquote|sapn|
|pre|ruby|
||abbr, cite, code, ...|

<br>

**타이포그래피**

    - 활자 서체의 배열
    - 활자의 서체나 글자 배치 따위를 구성하고 표현하는 일
<br>

|글자 속성(font)|문단 속성|
|------|---|
|font-family|text-align|
|font-size|text-indent|
|line-height|text-decoration|
|font-weight|text-transform|
|font-style|vertical-align|
|font-variant|letter-spacing|
||word-spacing|
||white-space|
||word-break|

<br>

**font** <br>

    : 글자와 관련된 스타일을 지정하는 속성

```html
font: italic small-caps bold 12px/30px Georgia, serif;


font: [font-style], [font-variant], [font-weight], [font-size/line-height], [font-family]
```

<br>

**리스트 속성** <br>

    - 목록 스타일 속성
        - list-style
            - list-style-type : 리스트 요소의 스타일을 지정하는 속성
            - list-style-position 
            - list-style-image
