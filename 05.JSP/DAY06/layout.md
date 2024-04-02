 **<h5>04월 02일 JSP 7일차 수업1</h5>** <br>

# 프로젝트 - 레이아웃
<br>

# JSP 페이지 레이아웃

- 헤더  - header
- 푸터  - footer
- CSS   - link
- JS    - script
- meta  


---

### 외부 페이지 포함하기
📁 layout
 - 📄 header.jsp
 - 📄 footer.jsp
 - 📄 script.jsp
 - 📄 link.jsp
 - 📄 meta.jsp


#### index.jsp
```jsp
<head>
    <jsp:include page="/layout/meta.jsp" />
    <jsp:include page="/layout/link.jsp" />

</head>
...
<jsp:include page="/layout/header.jsp" />

<div class="container">
    컨텐츠 영역
</div>

<jsp:include page="/layout/footer.jsp" />
<!-- 스트립트 -->
<jsp:include page="/layout/script.jsp" />

```