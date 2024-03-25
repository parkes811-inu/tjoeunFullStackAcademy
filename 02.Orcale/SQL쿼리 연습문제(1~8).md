**<h1>오라클 데이터베이스</h1>**
</br>
<h2> 1. SQL Developer 설치 링크</h2>
 </br>
 • https://www.oracle.com/database/sqldeveloper/technologies/download/
 </br>
 - version : 19c version install
 </br>
• 오라클 홈페이지에 접속하여 SQL Developer 다운로드 

</br>

----------------------------------------------------------------------
</br>

 <h2> 2. 사용자 계정 생성<h2> 
 
 </br>
	 
 : 오라클 11g 버전 이하는 어떤 이름으로도 계정 생성이 가능했으나, 12c 버전 이상부터는 'c##' 접두어를 붙여서 계정을 생성하도록 정책이 변경됨. </br>

 **c## 을 붙히지 않고 계정 생성 시 아래 오류 발생**  
 
 **- ORA-65096: 공통 사용자 또는 롤 이름이 부적합합니다.**
 
</br>

> • c## 정책을 없애기 위한 쿼리

```sql
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
```
</br>

> • HR 계정 생성
</br>

-- CREATE USER 계정명 IDENTIFIED BY 비밀번호;

```sql 
CREATE USER HR IDENTIFIED BY 123456;
```

</br>

> • 테이블 스페이스 변경

 </br>
 
 : HR 계정의 기본 테이블 영역을 users 영역으로 지정 						  	

```sql
-- ALTER USER 계정명 DEFAULT TABLESPACE users;
ALTER USER HR DEFAULT TABLESPACE users;
```

</br>

> • 계정이 사용할 수 있는 용량 설정

 </br>
 
 : HR 계정의 사용 용량을 무한대로 지정

```sql 
-- ALTER USER 계정명 QUOTA UNLIMIED ON 테이블스페이스;
ALTER USER HR QUOTA UNLIMITED ON users;
```
</br>

> • 계정에 권한을 부여

```sql
-- GRANT 권한명1, 권한명2 TO 계정명;
GRANT connect, resource TO HR;
```

</br>

> • 계정 삭제 : HR 계정 삭제

```sql
-- DROP USER 계정명 [CASCADE];
DROP USER HR CASCADE;
```

</br>

> • 계정 잠금 해제 </br>

```sql
-- ALTER USER 계정명 ACCOUNT UNLOCK;
ALTER USER HR ACCOUNT UNLOCK;
```

</br>

----------------------------------------------------------------------

<h2>3. 데이터베이스 기본</h2>

</br>

 • 데이터 : 측정 및 수집한 값들을 의미
 
 • 정보 : 데이터를 가공하여 의미를 부여한 형태
 
 • 데이터 베이스 : 데이터가 저장된 저장소 
 
 • 데이터의 집합
  : 공유하기 위해 통합하여 저장한 운영 데이터의 집합
</br>
>- 세부 정의 					 \-내용

• 공유 데이터			: 여러 응용 시스템이 공유하여 사용하는 데이터

• 통합 데이터 			: 중복된 자료를 최소화하여 효율적으로 사용할 수 있는 데이터

• 저장 데이터			: 컴퓨터의 저장 장치에 저장하여 관리하는 데이터

• 운영 데이터 			: 조직이 시스템을 운영하기 위해 필요한 데이터

><h4>• 데이터베이스 특징</h4>
</br>

>- 특징 							 	 -내용
• Realtime Accessibility : 사용자가 요청한 질의에 대하여 실시간으로 처리하여 응답한다.

• Continuous evolution : 데이터를 추가, 수정, 삭제하여 동적인 상태로 항상 최신의 데이터를 유지한다.

• Concurrent Sharing : 여러 사용자가 동시에 데이터를 공유할 수 있다.

• Content Reference : 데이터를 참조할 떄, 튜플의 주소 혹은 위치를 참조하는 것이 아니라 데이터 내용을 이용하여 참조한다.

• Independence : 응용 프로그램으로부터 독립되어 있기 때문에, 데이터의 논리적인 구조가 변경되어도
								  응용 프로그램은 변경되지 않는다.
</br>

	  
> <h4>• File System VS Database</h4>

</br>

 : 데이터를 파일 시스템으로 관리하면 데이터가 중복 및 누락될 가능성이 비교적 크고,여러 시스템 간의 데이터를 공유하는 것이 어렵다.

   데이터베이스를 사용하면, 여러 시스템을 사용하더라도 데이터를 중복 및 누락을 최소화할 수 있으며 시스템 간 실시간 공유가 가능하다.
   
</br>

> <h4>• 데이터베이스 시스템</h4>
 : 사용자 + 인터페이스 + DBMS + 데이터베이스(Data Dictionary, 저장 DB)
 
 - 사용자 : 일반 사용자, 개발자, SQL 사용자, DBA
  
 - Interface : UI, DB, DB TOOL
  
 	• UI : 사용자가 데이터를 요청하는 화면 (ex) Web, App, Program UI

 	• DB API : 개발자가 개발하는 프로그램과 연결된 인터페이스 (ex) DB Driver (JDBC)

 	• DB TOOL : 데이터 관리자가 DBMS를 사용하는 프로그램 (ex) SQL Developer, Workbench, DBeaver, Toad


 - 데이터베이스 : 데이터 사전 + 저장 데이터 베이스
  
 	• Data Dictionary, 데이터 사전 : 메타 데이터가 저장되는 곳,
 								  메타 데이터 -> 데이터베이스 구조, 스키마, 테이블 정의, 제약 조건, 인덱스 등
 	• 저장 데이터베이스 : 실제 데이터가 저장되는 곳

 - DBMS, Database Management System : 데이터베이스를 관리하는 시스템 (ex) ORACLE, My-SQL, MS-SQL
  
</br>

----------------------------------------------------------------------

</br>

3. 데이터 모델
 
 : 데이터를 저장하는 방식을 간단하게 설명해주는 구조
</br>

• 데이터 모델의 종류 

 - 계층형
 
 - 네트워크형
  
 - 객체지향형
  
 - 관계형
  
 </br> 
 
• 관계형 데이터 모델 : ERD, 행과 열을 갖는 2차원 구조의 테이븗 형태를 통하여 자료를 표현하는 모델

</br>

• 관계형 데이터 모델의 핵심 구성 요소 

 - 개체(Entity) = 릴레이션(실제 DB의 테이블과 대응)
  
 - 속성(Attribute)
  
 - 관계(Relation)

</br>

• 릴레이션의 구성요소

</br>

 - Relation 	: 데이터들을 2차원 테이블의 구조로 저장한 테이블
  
 - Attribute 	: 릴레이션의 열(= column)
  
 - Tuple		: 릴레이션의 행(= row)

 - Degree		: 릴레이션 속성의 개수

 - Cardinality	: 릴레이션의 입력된 튜플의 개수

 - Domain 		: 하나의 속성이 가질 수 있는 값의 범위
  
</br> 

• 릴레이션의 특징

</br>

 - 튜플의 속성은 하나의 데이터만 저장한다.

 - 튜플은 모두 다른 데이터로 유일한 값을 갖는다.

 - 튜플 간의 순서는 의미가 없다.

 - 속성 간의 순서는 의미가 없다.

 - 속성은 분해되지 않는 원자 값을 갖는다. (하나의 속성은 하나의 값만 갖는다!)
</br>
  
----------------------------------------------------------------------

</br>

4. 관계형 데이터베이스

 : 관계형 데이터 모델에 기반한 데이터베이스
</br>
• RDBMS(Relation Database Management System)

 : 관계형 데이터 모델을 바탕으로 데이터를 저장 및 관리하는 시스템
</br>
• SQL(Structured Query Language)

 : 구조화된 질의어, RDBMS에서 데이터를 다루고 관리하는 질의 언어
 
</br>

• 관계형 데이터베이스 제품

 : ORACLE, MySQL, MS-SQL

----------------------------------------------------------------------

<h2>5. SQL 분류 </h2>

</br>

> <h4>• DDL, Data Definition Language</h4>

 : 테이블을 포함한 여러 객체 생성, 수정, 삭제 등을 하는 명령어
 </br>

 - CREATE 		: 객체 생성

 - ALTER		: 객체 수정

 - DROP			: 객체 삭제

 - TURUNCATE	: 내부의 내용을 삭제
 </br>

> <h4>• DML, Data Management Language</h4>

 : 테이블 내의 데이터를 조회, 추가, 수정, 삭제하는 명령어</br>
 
 - SELECT		: 데이터 조회

 - INSERT		: 데이터 추가

 - UPDATE		: 데이터 수정

 - DELETE		: 데이터 삭제
 </br>
 
> <h4>• DCL, Data Control Language</h4>

 : 데이터에 대한 사용 권한을 부여하거나 해제하는 명령어</br>

 - GRANT		: 권한 부여

 - REVOKE		: 권한 해제
  
 </br>
 
> <h4>• TCL, Transaction Control Language</h4>

 : 트랜잭션 단위로 데이터 변경사항을 영구 저장하거나 되돌리는 명령어
 
 * 트랜잭션 : DBMS에서 발생하는 하나의 논리적인 작업 단위</br>

 - COMMIT		: 트랜잭션에서 변경 사항을 영구적으로 저장하는 명령어

 - ROLLBACK		: 트랜잭션에서 변경 사항을 취소하고, 이전 상태로 되돌리는 명령어
 </br>
 
> <h4>• 트랜잭션의 특징 - ACID</h4>

 : 트랜잭션의 특징으로 인해, 데이터베이스의 무결성과 일관성을 보장할 수 있다.</br>
 
 - Atomicity 	: 하나의 트랜잭션은 모든 연산이 완전히 수행되거나, 아무런 연산도 수행되지 않은 상태로 유지되어야 한다.
 				  * 즉, 트랜잭션 내의 모든 작업은 함께 실행되거나 아무것도 실행되지 않아야 한다.</br>	

 - Consistency 	: 트랜잭션 완료 후에 데이터베이스는 미리 정의된 일관된 상태가 되어야 한다.</br>

 - Isolation	: 동시에 여러 트랜잭션이 실행될 때, 한 트랜잭션의 작업이 다른 트랜잭션에 영향을 끼쳐서는 안된다.
 				  * 각 트랜잭션은 다른 트랜잭션의 작업을 모르고 독립적으로 처리되어야 한다.</br>
				  	
 - Durability	: 트랜잭션이 성공적으로 완료되면 그 결과는 영구적으로 데이터베이스에 저장되어야 한다.
 				  * 시스템 장애 또는 비정상 종료가 발생하더라도 데이터의 지속성이 보장되어야 한다.</br>
 				  
----------------------------------------------------------------------
</br>

<h2>6. 데이터 타입</h2>

 : 컬럼이 저장되는 데이터 유형</br>

> <h4>• 문자 데이터 타입</h4>


 - CHAR(크기)			: 고정길이 문자 (최대 2,000byte, 기본 값이 1byte)

 - VARCHAR2(크기)		: 가변길이 문자 (최대 4,000byte, 기본 값이 1byte) 

 - NCHAR(크기)		: 고정길이 유니코드 문자

 - NVARCHAR2(크기)	: 가변길이 유니코드 문자

 - LONG				: 최대 2GB의 가변길이 문자형 </br>

</br>

> <h4>• 숫자 데이터 타입</h4>

</br>

 - NUMBER(크기, 자리)	: 가변숫자 (최대 22byte)

 - FLOAT(크기)		: 가변숫자, 이진수 기준 크기 지정 (최대 22byte)

 - BINARY_FLOAT		: 32비트 부동소수점 수

 - BINARY_DOUBLE	: 64비트 부동소수점 수 </br>
 

> <h4>• 날짜 데이터 타입</h4>  </br>

 - DATE			: 연, 월, 일, 시, 분, 초 까지 입력 가능, 기원전 4712년 1월 1일 ~ 9999년12월 31일 까지

 - TIMESTAMP	: 연, 월, 일, 시, 분, 초, 밀리초 까지 입력 가능 (11byte) </br>

 </br>

> <h4>• LOB타입, (Large Object)</h4>

: 대용량 데이터를 저장할 수 있는 데이터 타입 </br>

 - CLOB		: 문자형 대용량 객체, 고정길이/가변길이

 - NCLOB	: 다국어를 지원하는 문자형 대용량 객체

 - BLOB		: 이진형 대용량 객체(파일)

 - BFILE	: 대용량 이진 파일에 위치/이름 등을 저장하는 타입 (최대 4GB)
  
</br>

```sql

-- SQL 쿼리 실습 (1번 ~ 8번)

-- 1. system 계정에 접속하는 SQL
conn system/orcl;

-- 2. HR 계정이 있는지 확인하는 SQL
SELECT * 
  FROM ALL_USERS
 WHERE USERNAME = 'HR';
 
-- 2-1. 계정이 있는 경우 계정 잠금 해제
ALTER USER HR ACCOUNT UNLOCK;

-- 2-2. 계정이 없는 경우 계정 생성
-- c## 없이 계정 생성
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- CREATE USER 계정명 IDENTIFIED BY 비밀번호;
CREATE USER HR IDENTIFIED BY 123456;

-- 테이블 스페이스 변경
ALTER USER HR DEFAULT TABLESPACE users;

-- 계정이 사용할 수 있는 용량 설정 (무한대)
ALTER USER HR QUOTA UNLIMITED ON users;

-- 계정에 권한 부여 
GRANT connect, resource TO HR;

-- 계정 삭제
DROP USER HR CASCADE;

-- 3. 테이블 EMPLOYEES의 테이블 구조를 조회하는 SQL문을 작성하시오.
-- (HR 계정 샘플데이터)
DESC EMPLOYEES;

-- 3-1. 테이블 EMPLOYEES에서 EMPLOYEE_ID, FIRST_NAME(회원번호, 이름)을 조회하는 
-- SQL문을 작성하시오.
SELECT EMPLOYEE_ID, FIRST_NAME 
  FROM EMPLOYEES;

-- 4. 테이블 EMPLOYEES이 <예시>와 같이 출력되도록 조회하는 SQL문을 작성하시오.
-- AS (Alias) : 별칭, 출력되는 컬럼명에 별명을 짓는 명령어
-- 형식 : AS 별칭
SELECT EMPLOYEE_ID AS "사원번호"
       ,FIRST_NAME AS 이름
       ,LAST_NAME AS 성
       , EMAIL AS 이메일
       ,PHONE_NUMBER AS 전화번호
       ,HIRE_DATE AS 입사일자
       ,SALARY AS 급여
  FROM EMPLOYEES;  

-- * (애스터리크) : 모든 컬럼을 조회
SELECT *
  FROM EMPLOYEES;
  
-- 5. 테이블 EMPLOYEES에서 JOB_ID를 중복된 데이터를 제거하고,
-- 조회하는 SQL문을 작성하시오.
SELECT DISTINCT JOB_ID
  FROM EMPLOYEES;
  
-- 6. 테이블 EMPLOYEES의 SALARY(급여)가 6,000원을 초과하는 
-- 사원의 모든 컬럼을 조회하는 SQL문을 조회하시오.
SELECT *
  FROM EMPLOYEES
 WHERE SALARY > 6000
ORDER BY SALARY ASC;

-- 7. 테이블 EMPLOYEES의 SALARY(급여)가 10,000원인 사원의 모든 컬럼을 조회하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE SALARY = 10000;

-- 8. 테이블 EMPLOYEES의 모든 속성들을 SALARY를 기준으로 내림차순 정렬하고, 
--    FIRST_NAME을 기준으로 오름차순 정렬하여 조회하는 SQL문을 작성하시오.
-- 정렬 
-- ORDER BY 컬럼명 [ASC/DESC];
-- *ASC : ASCENDING, 오름차순(기본값으로 생략 가능)
-- *DESC : DESCENDING, 내림차순
SELECT *
  FROM EMPLOYEES
ORDER BY SALARY DESC, FIRST_NAME ASC;
```
