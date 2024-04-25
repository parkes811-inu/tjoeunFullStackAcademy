**<h5>04월 25일 Spring 9일차 수업2</h5>** <br>

# Spring 주요 어노테이션 정리 <br>

## Spring 주요 어노테이션 <br>

### @Component <br>
    스프링 컨테이너에게 해당 클래스가 컴포넌트임을 알려줍니다. 보통 일반적인 클래스에 사용되며, 자동으로 검색하여 Bean으로 등록합니다.
<br>

### @Controller
    MVC 구조에서 컨트롤러 클래스임을 나타냅니다.
<br>

### @RestController
    @Controller와 유사하지만, 해당 컨트롤러가 JSON 또는 XML과 같은 데이터를 반환하는 RESTful 웹 서비스에서 사용됩니다.
<br>

### @Service <br>
    비즈니스 로직을 처리하는 서비스 클래스임을 표시합니다.
<br>

### @Repository <br>
    데이터 액세스 계층의 DAO(Data Access Object) 클래스임을 표시합니다.
<br>

### @Autowired <br>
    스프링에서 의존성 주입(Dependency Injection)을 위해 사용됩니다. 해당 어노테이션이 
    있는 필드나 메소드에 해당하는 Bean을 자동으로 주입합니다.
<br>

### @RequestMapping <br>
    요청 매핑을 지정하는 데 사용됩니다. 클래스 레벨에서는 기본 경로를 지정하고, 메소드 
    레벨에서는 경로와 HTTP 메소드를 지정합니다.
    
    • 속성
        ◦ value
        ◦ method
        ◦ headers
        ◦ consumes
        ◦ produces
        ◦ name

    속성을 명시하지 않고 생략해서 쓰면, 기본 URL 경로만 매핑할 수 있다.
    @RequestMapping("/path/sub")

<br>

|속성|설명|예시|
|-|----------|---|
|value 또는 path|요청을 처리할 경로를 지정합니다.|@RequestMapping(value = "/example")|
|method|요청을 처리할 HTTP 메소드를 지정합니다.|@RequestMapping(value = "/example", method = RequestMethod.GET)|
|params|요청 파라미터의 존재 여부 및 값에 따라 매핑을 제한합니다.|@RequestMapping(value = "/example", params = "id=1")|
|headers|요청 헤더의 속성에 따라 매핑을 제한합니다.|@RequestMapping(value = "/example", headers = "content-type=application/json")|
|consumes|소비할 미디어 타입을 지정합니다.|@RequestMapping(value = "/example", consumes = MediaType.APPLICATION_JSON_VALUE)|
|produces|생성할 미디어 타입을 지정합니다.|@RequestMapping(value = "/example", produces = MediaType.APPLICATION_JSON_VALUE)|
|name|매핑의 이름을 지정합니다.|@RequestMapping(value = "/example", name = "exampleMapping")|
<br>

### @GetMapping, @PostMapping 
### @PutMapping, @DeleteMapping <br>
    각각 GET, POST, PUT, DELETE HTTP 요청에 대한 매핑을 지정합니다.

    @RequsetMapping 의 속성들을 동일하게 사용할 수 있다. (method 제외)
<br>

### @RequestParam <br>
    HTTP 요청 파라미터를 메소드의 파라미터로 전달합니다.

    • 요청 URL
        http://localhost:8080/example?param=100&par
<br>

### @PathVariable <br>
    URI 템플릿 변수 값을 메소드의 파라미터로 전달합니다.

```url
http://localhost:8080/example/{A}/{B}
    
```
<br>

### @RequestBody <br>
    HTTP 요청 본문을 메소드의 파라미터로 매핑합니다.

    클라이언트가 POST 방식으로 요청할 때, 요청 메세지의 body에 담긴 데이터를 객체 또는 컬렉션에 매핑 해준다.

    JSON, XML [POST] -> @RequestBody
    form-data [POST] -> @RequestParam
    form의 POST 방식으로 요청해도 역시 요청 메세지의 body에 데이터가 담기는데, 
    스프링이 폼 데이터를 변환하여 요청 파라미터에 담아준다.
    그래서, @RequestParam으로 객체나 컬렉션에 매핑 가능하다.

    직접 정의한 클래스의 경우, 요청 파라미터 이름과 객체의 변수명이 일치하면 @RequestParam을 쓰지 않아도 자동 매핑해준다.
<br>

### @ModelAttribute <br>
    요청 처리 메소드의 파라미터에 바인딩될 객체를 지정합니다. 주로 폼 데이터를 객체로 
    변환할 때 사용됩니다.
<br>

### @ResponseBody <br>
    응답 메세지 본문(body)에 데이터를 매핑하는 어노테이션
    
    템플릿 엔진(thymelaef, jsp)를 사용한다면, String 반환 타입으로 "View" 파일 경로를 지정하면, 해당 뷰 파일을 html로 렌더링하여 응답한다.

    컨트롤러 메소드에 @ResponseBody를 사용하면, 템플릿 엔진을 통해 뷰 페이지를 사용하지 않고, 지정한 문자열을 응답 메세지 본문에 담아서 전송한다.
<br>
