 **<h5>3월13일 CSS 수업</h5>**

---

**box model** </br> 

- HTML 요소를 감싸는 상자 <br>

|속성|설명|
|------|---|
|margin|외부여백|
|border|테두리|
|padding|내부 여백|
|content|내용 - text, image|

<br>

---

<br>

**margin** </br> 

- 요소의 외부 여백을 지정하는 속성 <br>

|속성|설명|
|------|---|
|auto|브라우저가 길이를 계산|
|length|px, em, pt, cm 등|
|%|상위 요소에 대한 비율 지정|
|inherit|부모 요소를 길이로 지정|

<br>

|개별 속성|설명|
|------|---|
|margin-top|위쪽 외부 여백|
|margin-right|오른쪽 외부 여백|
|margin-bottom|아래쪽 외부 여백|
|margin-left|왼쪽 외부 여백|

<br>

---

<br>

**margin collapse** </br> 

- 마진 상쇄 예외상황 <br>

|속성|설명|
|------|---|
|position:absolute;||
|float:left/right;||
|display:flex;|지정된 컨테이너의 자식요소 일 때|
|display:grid;|지정된 컨테이너의 자식요소 일 때|

<br>

------
------

**표현속성** </br> 

- display스타일 </br>

- overflow </br>

</br>

**display**

- 요소의 유형을 지정하는 속성 <br>

|속성|설명|
|----|----|
|block|블록 요소|
|inline|인라인 요소|
|inline-block|인라인 블록 요소|
|table|테이블 요소|
|grid|2차원 레이아웃|
|flex|반응형 레이아웃|
|none|표시하지 않음|

<br>

---

<br>

**overflow**

- 넘치는 컨텐츠에 대한 처리 유형을 지정하는 속성 <br>

|속성|설명|
|----|----|
|visible|컨테이너 외부에 출력|
|scroll|스크롤 영역에서 출력|
|auto|넘치는 경우에만 스크롤 영역에 출력|
|hidden|숨김|
|initial|기본값|
|inherit|부모 요소를 따름|