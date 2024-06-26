 **<h5>04월 22일 Spring 6일차 수업1</h5>** <br>

# Spring
<br>

### Spring Boot란? <br>
    - 스프링 부트는 자바 기반의 오픈 소스 프레임워크로, 웹 애플리케이션을 쉽고 빠르게 구축할 수 있게 하는 프레임워크
    - 스프링 프레임워크를 기반으로 개발자들이 설정을 최소화하고 개발에 집중할 수 있도록 제공되었습니다.
    - 스프링 부트는 웹 애플리케이션 및 마이크로 서비스 개발에 널리 사용됩니다.
<br>

### Spring Boot VS Spring <br>
    - 스프링 부트와 스프링 프레임워크는 비슷한 기반을 가지고 있지만 목표와 사용 방식에서 차이가 있습니다.
    - 스프링 부트는 개발자들이 빠르고 쉽게 애플리케이션을 구축할 수 있도록 도와주는 것에 중점을 두고 있고,
    - 이를 위해 스프링 부트는 설정을 최소화하고 개발 생산성을 높이는 다양한 기능을 제공합니다.
<br>

### Spring Boot의 특징 <br>

1. Auto Configuration : 
    - 자동 구성은 스프링 부트가 애플리케이션의 클래스패스를 스캔하고, 필요한 빈을 자동으로 구성하는 것을 의미합니다. 이를 통해 개발자는 복잡한 설정을 하지 않고, 빠르게 개발에 집중할 수 있습니다.
<br>

2.  Embedded Server : 
    - 내장형 서버는 별도의 웹 서버를 설치하지 않아도 애플리케이션을 실행할 수 있다는 장점을 제공합니다.
    - 내장형 서버에는 톰캣, 제티, 언더토우 등 다양한 웹 서버를 지원합니다.
<br>

3. Starter Dependency :
    - 다양한 종류의 프로젝트에 필요한 의존성을 미리 정의한 스타터 의존성을 제공합니다. 
    - 이를 통해 필요한 라이브러리 및 설정을 간편하게 추가할 수 있습니다.
<br>

4. Actuator Module :
    - 액추에이터는 애플리케이션의 운영 환경에서 애플리케이션 상태 모니터링, 메트릭 수집, 로그 레벨 조정 등 유용한 기능을 실시간으로 제공하는 모듈입니다.
<br>

### Spring Boot Starter Site <br>
- 아래 사이트에서 웹 인터페이스를 통해 프로젝트를 구성을 할 수 있고, 필요한 의존성을 선택하고, 설정 파일을 생성할 수 있습니다.
- https://start.spring.io/

<br>

---

<br>

# Eclips X Spring Boot
<br>

### Eclips에 스프링 부트 설치하기 <br>
    1. 이클립스 실행 후 우측 상단에 Help - Eclips Marketplace 클릭
    2. 검색 창에 Spring 검색 후 Spring Tools Suite 클릭 후 install
<br>

### Spring Boot 프로젝트 생성하기 <br>
1. [File] -> [Other] -> [Spring Starter Project]

2. 프로젝트 정보 입력 <br>
    a. Project Name : sample <br>
    b. Spring Boot Version : 3.x.x <br>
    c. Build Tool : gradle <br>
    d. Java Version : 17 <br>
    e. Group ID : sample <br>
    f. Artifact ID : sample <br>
    g. Dependencies <br>
    
        i. Spring Web <br>
        ii. Spring Boot DevTools <br>
        iii. Thymeleaf <br>

<br>




