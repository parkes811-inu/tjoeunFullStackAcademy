**<h5>04월 23일 Spring 7일차 수업2</h5>** <br>

# Spring Boot Response <br>

### @Controller <br>
    :  : Spring MVC 의 HTTP 요청에 응답하는 컨트롤러 클래스로 지정하는 어노테이션
<br>

```sql
--  Thymeleaf 의존성을 추가하면, 스프링 부트는 타임리프를 뷰 템플릿으로 자동 설정합니다.

implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
```
<br>

### 응답 타입 <br>
- void
    : URL 과 동일한 경로의 뷰를 응답한다.
<br>

- String
    : 문자열로 응답할 뷰의 경로를 지정한다.
<br>

- @ResponseBody
    : 컨트롤러 메소드 위에 붙여, 메소드가 반환하는 객체를 응답 메시지 본문에 포함시키는 어노테이션 ( 뷰를 응답하지 않는다. )
<br>

### 응답 상태 코드 <br>
    : HTTP 응답 상태 코드는 클라이언트에게 요청이 성공적으로 처리되었는지를 알려주는 역할을 합니다. 
    
    몇 가지 일반적인 상태 코드는 다음과 같습니다:
    
    • 200 OK: 요청이 성공적으로 처리되었음을 나타냅니다.

    • 201 Created: 요청이 성공적으로 처리되었고, 새로운 리소스가 성되었음을 나타냅니다.

    • 400 Bad Request: 잘못된 요청으로 인해 서버가 요청을 이해할 수 없음을 나타냅니다.

    • 403 Forbidden :  클라이언트가 요청한 리소스에 접근할 권한이 없음을 나타냅니다. 서버는 요청을 이해하고 있지만, 클라이언트에게 해당 리소스에 접근할 권한이 없다는 것을 알려줍니다.

    • 404 Not Found: 요청한 리소스가 서버에서 찾을 수 없음을 나타냅니다. 클라이언트가 잘못된 URL을 요청한 경우나 요청한 리소스가 삭제되었거나 이동되었을 때 발생합니다.

    • 500 Internal Server Error: 서버 내부에서 오류가 발생하여 요청을 처리할 수 없음을 나타냅니다.

    각 상태 코드는 다른 의미를 가지고 있으며, 클라이언트는 이러한 코드를 통해 요청에 대한 적절한 조치를 취할 수 있습니다.
<br>

```java
// 200 OK : 요청이 성공적으로 처리되었음을 나타냅니다.
@GetMapping("/200")
public ResponseEntity<String> ok() {
    log.info("[GET] - /200 - 서버가 클라이언트의 요청을 성공적으로 처리했을 때 응답하는 상태코드 입니다.");
    return ResponseEntity.ok("서버가 클라이언트의 요청을 성공적으로 처리했을 때 응답하는 상태코드 입니다.");
}

// 201 Created : 요청이 성공적으로 처리되었고, 새로운 리소스가 생성되었음을 나타냅니다.
@GetMapping("/201")
public ResponseEntity<String> created() {
    log.info("[GET] - /200 - 서버가 새로운 리소스를 성공적으로 생성 했을 때 응답하는 상태코드입니다.");
    return ResponseEntity.status(HttpStatus.CREATED).body("서버가 새로운 리소스를 성공적으로 생성 했을 때 응답하는 상태코드입니다.");
}

// 400 Bad Request : 잘못된 요청으로 인해 서버가 요청을 이해할 수 없음을 나타냅니다.
@GetMapping("/400")
public ResponseEntity<String> badRequest() {
    log.info("[GET] - /400 - 클라이언트 요청이 잘못됨을 알려주는 상태코드입니다.");
    return ResponseEntity.badRequest().body("클라이언트 요청이 잘못됨을 알려주는 상태코드입니다.");
}

// 403 Forbidden : 클라이언트가 요청한 리소스에 접근할 권한이 없음을 나타냅니다. 서버는 요청을 이해하고 있지만, 클라이언트에게 해당 리소스에 접근할 권한이 없다는 것을 알려줍니다.
@GetMapping("/403")
public ResponseEntity<String> forbidden() {
    log.info("[GET] - /403 - 클라이언트가 자원 접근에 거부되었음을 알려주는 상태코드입니다. (주로 권한이 없을 때, 응답하는 상태코드입니다.)");
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("클라이언트가 자원 접근에 거부되었음을 알려주는 상태코드입니다. (주로 권한이 없을 때, 응답하는 상태코드입니다.)");
}

// 404 Not Found : 요청한 리소스가 서버에서 찾을 수 없음을 나타냅니다. 클라이언트가 잘못된 URL을 요청한 경우나 요청한 리소스가 삭제되었거나 이동되었을 때 발생합니다.
@GetMapping("/404")
public ResponseEntity<String> notFound() {
    log.info("[GET] - /404 - 클라이언트가 요청한 리소스가 서버에 없거나, 요청한 경로가 존재하지 않을 때 응답하는 상태코드 입니다.");
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("클라이언트가 요청한 리소스가 서버에 없거나, 요청한 경로가 존재하지 않을 때 응답하는 상태코드 입니다.");
}

// 500 Internal Server Error : 서버 내부에서 오류가 발생하여 요청을 처리할 수 없음을 나타냅니다.
@GetMapping("/500")
public ResponseEntity<String> internalServerError() {
    log.info("[GET] - /500 - 서버 측에서 에러나 예외가 발생했을 때 응답하는 상태코드 입니다.");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 측에서 에러나 예외가 발생했을 때 응답하는 상태코드 입니다.");
}
```