**<h5>04월 26일 Spring 10일차 수업1</h5>** <br>

# Thymeleaf Dialect Layout <br>
    : 미리 정의된 공통 레이아웃 페이지

###  <br>
    : 자원의 상태를 표현하여 전달하는 아키텍처
    
    • 프론트엔드 및 백엔드의 독립성과 확장성 향상시킵니다.
<br>




<br>
<hr>
<br>

### 파일 업로드 <br>

### 파일 관련 기능 <br>
    1. 파일 업로드
    2. 파일 다운로드
    3. 이미지 썸네일

### 파일 업로드 <br>

    1. 파일 구성
    
    2. 작업
        - file 테이블 생성
        - DTO -> Files.java
        - Mapper
            FileMappjer.xml - (SQL)
            FileMapper.java - (Interface)
        - Service
            - FileService.java
            - FileServiceImpl.java
        - Controller
            - FileController.java