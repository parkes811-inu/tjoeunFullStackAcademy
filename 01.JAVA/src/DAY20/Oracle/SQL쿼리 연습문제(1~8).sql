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
