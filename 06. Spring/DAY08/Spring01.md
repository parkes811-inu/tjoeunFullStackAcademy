**<h5>04월 24일 Spring 8일차 수업1</h5>** <br>

# Spring Boot - Swagger <br>

![swagger](./img/swagger.png)

### API 개발 문서화 도구 - Swagger <br>
    : API 개발 문서화 도구는 API 엔드포인트, 요청, 응답 및 관련 정보를 문서화하여 
    개발자들에게 API 사용 방법을 제공하는 소프트웨어 도구입니다.

    REST API를 설계, 구축, 문서화 및 사용하는 데 도움이 될 수 있는 OpenAPI 사양을 기반으로 구축된 오픈 소스 도구 세트입니다.

    https://swagger.io/docs/specification/about/

    장점 : 
        • API 설계, 빌드, 문서화 및 테스트를 위한 통합 툴.  
        • OpenAPI 표준을 준수하며, RESTful API를 쉽게 디자인하고 관리할 수 있음.
<br>

<br>
<hr>

### MyBatis <br>

    - 마이바티스는 개발자가 지정한 SQL, 저장 프로시저, 고급 매핑 등을 지원하는 퍼피시스턴스 프레임워크이다.
<br>

- 자바 프로그램에서 데이터베이스 연동을 위해서 JDBC 드라이버를 사용하면, Java 코드와 SQL 코드가 같이 사용되기 때문에 유지보수성이 저하된다.

- 그래서 MyBatis를 사용하면 Java 코드에서 SQL을 분리해서 XML 관리를 하고, 자바의 인터페이스 호출에 따라서 XML의 특정 id에 해당하는 쿼리를 실행시키는 SQL Mapper 방식으로 DB 연동을 할 수 있다.
<br>

### 스프링 부트에서 MyBatis 사용

    1. build.gradle에 의존성 추가

    2. 마이바티스 설정 파일 - mybatis-config.xml

    3. 프로젝트 설정 - application.properties

    4. DB 구축

    5. 로직 작성

        a. DTO 작성
        b. SQL 작성
        c. Mapper Interface 작성
        d. Service 작성
        e. Controller 작성
<br>

### build.gradle에 의존성 추가하기 <br>
    - mysql 드라이버 의존성
    - Mybatis 의존성

```xml
<!-- mysql 드라이버 의존성 추가 - 프로젝트 생성 시 추가 하면 된다. -->
runtimeOnly 'com.mysql:mysql-connector-j'

<!-- mybatis 의존성 추가 -->
implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.3.1'

<!-- 마이바티스 설정 파일 - mybatis-config.xml -->
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

	<!-- 설정 -->
	<settings>
		<!-- 언더스코어 케이스인 컬럼을 카멜 케이스로 변환하는 설정  -->
		<!-- board_no - boardNo -->
		<setting name="mapUnderscoreToCamelCase" value="true"/>
	</settings>
	
	<!-- 타입 별칭 설정 -->
	<typeAliases>
		<!-- 테이블과 매핑할 DTO가 있는 패키지 경로 지정 -->
		<package name="com.aloha.spring.dto"/>
	</typeAliases>	
</configuration>

```
<br>

### Project 설정 - application.properties <br>
    - 데이터 소스 설정
    - mybatis-config.xml 파일 경로 설정

```properties
# 데이터 소스 - MySQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/joeun?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false&autoReconnection=true&autoReconnection=true
spring.datasource.username=joeun
spring.datasource.password=123456
# mybatis-config.xml 설정
# Mybatis 설정
# Mybatis 설정 경로      : ~/resources/mybatis-config.xml
mybatis.config-location=classpath:mybatis-config.xml

##########################################################################

# Mybatis 매퍼 파일 경로 : ~/메인패키지/mapper/**Mapper.xml
mybatis.mapper-locations=classpath:mybatis/mapper/**/**.xml

# classpath: 라고 지정하면 ~/resources 경로 하위부터 경로를 지정할 수 있다.
#   classpath:mybatis/mapper/**/**.xml  라고 지정하면, ~/resources 경로부터 모든 경로의 모든 하위 파일의 확장자가 .xml 이면 마이바티스 매퍼(SQL) 파일로 인식하도록 지정한다.
```
<br>

### DB 구축 - MySQL <br>
    - 스키마 생성 : joeun
    - 테이블 생성 : board, file 
<br>

```sql
-- board
CREATE TABLE `board` (
  `no` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `writer` varchar(100) NOT NULL,
  `content` text,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`no`)
) COMMENT='게시판';

-- file
CREATE TABLE `file` (
  `no` int NOT NULL AUTO_INCREMENT,
  `parent_table` varchar(45) NOT NULL,
  `parent_no` int NOT NULL,
  `file_name` text NOT NULL,
  `origin_name` text,
  `file_path` text NOT NULL,
  `file_size` int NOT NULL DEFAULT '0',
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `file_code` int NOT NULL DEFAULT '0',         
  PRIMARY KEY (`no`)
) COMMENT='파일';

```
<br>

### 로직 작성 <br>
    • DTO 작성

    • SQL Mapper 작성

    • Mapper 인터페이스 작성

    • Service 작성

    • Controller 작성
<br>

- DTO 작성 <br>

```java
// Board.java
/**
 * Board 
 * - 게시글 정보
 */
@Data
public class Board {
    private int no;        
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    private int views;
}
 
// Files.java
@Data
public class Files {
    private int no;
    private String parentTable;
    private int parentNo;
    private String fileName;
    private String originName;
    private String filePath;
    private long fileSize;
    private Date regDate;
    private Date updDate;
    private int fileCode;
}
```
<br>

### SQL Mapper 작성 <br>
    - BoardMapper.xml
    - FilesMapper.xml

```xml
<!-- 기본 Mapper 파일 형식 -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace="매퍼 인터페이스 경로" --> 
<mapper namespace="com.aloha.spring.mapper.XXXMapper">


</mapper>

<!-- BoardMapper.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace="매퍼 인터페이스 경로" --> 
<mapper namespace="com.aloha.spring.mapper.BoardMapper">

    <!-- 게시글 목록 -->
    <select id="list" resultType="Board">
        SELECT *
        FROM board
        ORDER BY reg_date DESC
    </select>

    <!-- 게시글 조회 -->
    <select id="select" resultType="Board">
        SELECT *
        FROM board
        WHERE no = #{no}
    </select>

    <!-- 게시글 등록 -->
    <insert id="insert">
        INSERT INTO board( title, writer, content)
        VALUES ( #{title}, #{writer}, #{content} )
    </insert>

    <!-- 게시글 수정 -->
    <update id="update">
        UPDATE board
           SET title = #{title}
              ,writer = #{writer}
              ,content = #{content}
        WHERE no = #{no}
    </update>

    <!-- 게시글 삭제 -->
    <delete id="delete">
        DELETE FROM board
        WHERE no = #{no}
    </delete>

    <!-- 게시글 번호 최댓값 -->
    <select id="maxPk" resultType="int">
        SELECT MAX(no)
        FROM board
    </select>
</mapper>

<!-- FilesMapper.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace="매퍼 인터페이스 경로" --> 
<mapper namespace="com.aloha.spring.mapper.FileMapper">

    <!-- 파일 목록 -->
    <select id="list" resultType="Files">
        SELECT *
        FROM file
        ORDER BY reg_date DESC
    </select>

    <!-- 파일 목록 - 부모 테이블 기준 -->
    <!-- * 파일이 종속되는 테이블을 기준으로 파일 목록을 조회 -->
    <!-- * 게시글 번호 10 
           📄 파일 번호 1
           📄 파일 번호 2
           📄 파일 번호 3
     -->
    <select id="listByParent" resultType="Files">
        SELECT *
        FROM file
        WHERE parent_table = #{parentTable}
          AND parent_no = #{parentNo}
        ORDER BY reg_date DESC
    </select>

    <!-- 파일 조회 -->
    <select id="select" resultType="Files">
        SELECT *
        FROM file
        WHERE no = #{no}
    </select>

    <!-- 파일 등록 -->
    <insert id="insert">
        INSERT INTO file( parent_table, parent_no, file_name, origin_name, file_path, file_size, file_code )
        VALUES ( #{parentTable}, #{parentNo}, #{fileName}, #{originName}, #{filePath}, #{fileSize}, #{fileCode} )
    </insert>

    <!-- 파일 수정 -->
    <update id="update">
        UPDATE file
           SET parent_table = #{parentTable}
              ,parent_no = #{parentNo}
              ,file_name = #{fileName}
              ,origin_name = #{originName}
              ,file_path = #{filePath}
              ,file_size = #{fileSize}
              ,file_code = #{fileCode}
        WHERE no = #{no}
    </update>

    <!-- 파일 삭제 -->
    <delete id="delete">
        DELETE FROM file
        WHERE no = #{no}
    </delete>


    <!-- 파일 목록 삭제 - 부모 테이블 기준 파일 목록 삭제 -->
    <delete id="deleteByParent">
        DELETE FROM file
        WHERE parent_table = #{parentTable}
          AND parent_no = #{parentNo}
    </delete>
</mapper>

<!-- 기본 CRUD Mapper 파일 형식 -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace="매퍼 인터페이스 경로" -->
<mapper namespace="com.aloha.spring.mapper.BaseMapper">
   
    <!-- 기본 등록 -->
    <insert id="insert">
        INSERT INTO base( base_id, base_name )
        VALUES ( #{baseId}, #{baseName} )
    </insert>

    <!-- 기본 조회 -->
    <select id="select" resultType="base">
        SELECT *
        FROM base
        WHERE base_no = #{baseNo}
    </select>

    <!-- 기본 수정 -->
    <update id="update">
        UPDATE base
           SET base_id = #{baseId}
              ,base_name = #{baseName}
        WHERE base_no = #{baseNo}
    </update>


    <!-- 기본 수정 -->
    <delete id="delete">
        DELETE FROM base
        WHERE base_no = #{baseNo}
    </delete>
</mapper>
```

<br>
