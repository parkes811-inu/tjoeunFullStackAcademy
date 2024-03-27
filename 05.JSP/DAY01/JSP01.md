 **<h5>3월25일 JSP 1일차 수업1</h5>** <br>

## 1장 JSP, Java Server Page

<br>

### - Servlet 소개 <br>
    • Java 프로그래밍 언어를 기반으로 하는 웹 응용 프로그램 개발을 위한 기술

    웹 서버와 상호 작용하여 동적 웹 페이지를 생성하고 관리하는데 사용

    웹 애플리케이션의 서버 측 로직을 처리하는데 사용
    
    클라이언트의 요청을 받고, 그 요청에 따라 데이터베이스와 상호작용거나, 다양한 계산을 수행하여 동적으로 HTML을 생성

<br>

### - 웹 컨테이너(서블릿 컨테이너) 소개 <br>
    • 웹 컨테이너는 서블릿과 JSP(Java Server Pages)같은 웹 컴포넌트를 실행하는데 사용되는 소프트웨어 구성요소

    주로 동적 웹 애플리케이션의 서버 측 로직을 처리

    Servlet과 JSP 코드를 실행하고 HTTP 요청을 처리하며, 클라이언트의 요청을 받아들이고 응답을 생성
<br>

### - Tomcat <br>
    • 웹 서버 및 서블릿 컨테이너
    
    Java 웹 애플리케이션을 실행하고 관리하기 위한 높은 성능을 제공하는 소프트 웨어

    • 주요 기능

        - 서블릿 컨테이너
        - 정적 및 동적 웹 콘텐츠 제공
        - 웹 서버
        - 웹 애플리케이션 호스팅
<br>     

### - Eclips X Tomcat 연동 <br>
    • 이클립스 프로그램과 톰캣 서버 연동 후 서버 실행 시 기본 포트인 8080이 이미 실행중이라고 나오는 경우
        
        1. 명령 프롬포트 창을 관리자 권한으로 실행하여
        netstat -ano | findstr 8080 명령어로 8080포트가 사용중인지 확인

        2. taskkill /f /pid "위 명령어로 찾은 pid" 명령어를 통해 8080 포트를 사용중인 프로그램 종료

        3. 톰캣 서버 재실행
<br>

---

### - 서블릿 생명주기 <br>
    - 로딩 단계

    - 초기화 단계

    - 실행 단계

    - 소멸 단계
<br>

- 로딩 단계 <br>

    최초 요청 시, 새로운 서블릿 객체를 생성,

    2번째 요청부터는 메모리에 존재하는 객체를 불러와서 사용한다.
<br>

- 초기화 단계 <br>

    init()메소드가 호출되는 단계로, 서블릿 객체가 최로로 한 번 생성될 때 실행된다.

    매 요청마다 실행되지 않고, 객체 생성 시에만 실행된다. 

    초기화 작업을 진행하는 메소드
<br>

- 실행 단계 <br>

    - doGet()  

        : 클라이언트로부터 GET 요청 방식으로 요청이 왔을 때, 호출되는 메소드

    - doPost()
        
        : 클라이언트로부터 POST 요청 방식으로 요청이 왔을 때, 호출되는 메소드
<br>

- 소멸 단계 <br>

    서블릿 클래스가 사용되지 않을 때, 서블릿 컨테이너로부터 서블릿을 제거하기 위해서 

    destroy() 메소드를 호출하는 단계
<br>

---

### - 요청 경로 매핑 <br>
    - 요청 경로 매핑 방법은 web.xml 사용, 어노테이션 사용 2 가지 방법이 있다.
<br>

- web.xml을 사용한 매핑
```xml
<!--
    BoardListServlet이라는 서블릿을 /board/list 경로로 매핑합니다.
    /board/list 경로로 요청이 오면 BoardListServlet 이 요청을 전달 받습니다.
 -->
<web-app>
    <servlet>
        <servlet-name>BoardListServlet</servlet-name>
        <servlet-class>com.example.BoardListServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>BoardListServlet</servlet-name>
        <url-pattern>/board/list</url-pattern>
    </servlet-mapping>
</web-app>
```

<br>

- 어노테이션을 사용한 매핑
```java
// Java EE 6이상 버전부터는 어노테이션을 사용하여 서블릿을 매핑할 수 있습니다.

import javax.servlet.annotation.WebServlet;

// @WebServlet("/board/list")
@WebServlet(name = "BoardListServlet", urlPatterns = {"/board/list"})
public class BoardListServlet extends HttpServlet {
		// doGet, doPost, ...
}
```

<br>

---

### - 요청 처리 <br>
    - HttpServletRequest : 클라이언트의 HTTP 요청 정보를 나타내는 객체
    - HttpServletRequest를 사용하면, 다양한 메서드와 속성을 통해 요청 정보를 확인할 수 있습니다.
<br>

```java
// HttpServletRequest 예제 코드
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("Hello, World!");

        // 클라이언트의 요청 메서드를 확인
        String method = request.getMethod();
        response.getWriter().println("HTTP 요청 메서드: " + method);

        // 요청 파라미터 가져오기
        String paramValue = request.getParameter("paramName");
        response.getWriter().println("파라미터 값: " + paramValue);

        // 요청 URI와 URL 가져오기
        String requestURI = request.getRequestURI();
        response.getWriter().println("요청 URI: " + requestURI);
        StringBuffer requestURL = request.getRequestURL();
        response.getWriter().println("요청 URL: " + requestURL.toString());

        // 특정 HTTP 헤더 값 가져오기
        String userAgent = request.getHeader("User-Agent");
        response.getWriter().println("User-Agent 헤더: " + userAgent);

        // 클라이언트 IP 주소 확인
        String remoteAddr = request.getRemoteAddr();
        response.getWriter().println("클라이언트 IP 주소: " + remoteAddr);
    }
}
```

- 주요 메소드

|메소드|설명|
|-----|-----|
|getMethod()|HTTP 요청 메서드 반환 (GET, POST, PUT, 등)|
|getProtocol()|프로토콜 및 버전 정보 반환 (예: HTTP/1.1)|
|getRequestURL()|요청 URL 반환|
|getRequestURI()|요청 URI 반환 (컨텍스트 경로 포함)|
|getContextPath()|웹 애플리케이션의 컨텍스트 경로 반환 (루트 경로)|
|getQueryString()|쿼리 문자열 반환 (URL의 ? 이후 부분)|
|getHeader(String name)|지정된 HTTP 헤더의 값을 반환|
|getParameter(String name)|지정된 이름의 요청 파라미터 값을 반환|
|getParameterMap()|모든 요청 파라미터를 맵 형태로 반환|
|getParameterNames()|모든 요청 파라미터의 이름을 나열|
|getCookies()|클라이언트가 보낸 모든 쿠키를 가져옴|
|getSession()|현재 요청에 대한 세션 객체를 반환|
|getRemoteAddr()|클라이언트의 IP 주소 반환|
|getRemoteHost()|클라이언트의 호스트명 반환|
|getLocalAddr()|서버의 IP 주소 반환|
|getLocalPort()|서버의 포트 번호 반환|
|getScheme()|프로토콜 스킴 반환 (예: http, https)|
|getServerName()|서버 호스트명 반환|
|getServerPort()|서버 포트 번호 반환|
|getCharacterEncoding()|요청의 문자 인코딩 반환|
|getInputStream()|요청의 입력 스트림을 가져옴|
|setAttribute(String name, Object value)|요청 속성 설정|
|getAttribute(String name)|요청 속성을 가져옴|

<br>

---

<br>

### - 응답 처리 <br>
    - PrintWriter : 텍스트 데이터를 출력하기 위한 표준 출력 스트림
    - 주로 문자열, 텍스트 데이터, 또는 HTML과 같은 텍스트 기반의 데이터를 출력하는 데 사용
    - 주요 기능
        1. 텍스트 데이터 출력

        2. 자동 줄 바꿈 처리

        3. 문자 인코딩 처리
    - PrintWriter는 주로 웹 애플리케이션 HTTP응답을 생성할 때 또는 텍스트 파일에 데이터를 기록할 때 사용됩니다.
<br>

```java
// PrintWriter 메소드 예제 코드
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 응답의 콘텐츠 타입을 HTML로 설정
        response.setContentType("text/html");

        // PrintWriter를 사용하여 HTML 응답을 생성
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>My HTML Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, World from My HTML Servlet!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
```