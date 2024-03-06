-- SQLBook: Markup
<h1>뷰, VIEW</h1>
-- SQLBook: Markup
> "가상 테이블"

하나 이상의 테이블을 조회하는 SELECT 문을 저장한 객체

* 물리적으로 저장되는 테이블이 아니라, 논리적으로만 기존의 테이블들의 조회결과를 정의한다.

**목적**
 1. **편리성** : 쿼리의 복잡도를 줄이기 위해서 사용
 2. **보안성** : 민감한 정보에 대한 노출을 방지하기 위해서 사용(ex 주민번호, 비밀번호)

 > 뷰 생성

```sql
CREATE [OR REPLACE] VIEW 뷰이름 (컬럼1, 컬럼2, 컬럼3, ...) 

    AS (SELECT 문); 
```

 > 뷰 삭제

```sql
 DROP VIEW 뷰이름;   
```


-- SQLBook: Code
-- 98.
-- employee, department 테이블을 조인하여,
-- 사원번호, 직원명, 부서번호, 부서명, 이메일, 전화번호
-- 주민번호, 입사일자, 급여, 연봉을 조회하시오.
-- CREATE OR REPLACE 객체
-- - 없으면, 새로 생성
-- - 있으면, 대체 (기존에 생성 되어 있어도 에러발생X)

-- 뷰 생성
CREATE OR REPLACE VIEW VE_EMP_DEPT AS
SELECT E.EMP_ID 
      ,E.EMP_NAME 
      ,D.DEPT_TITLE 
      ,E.EMAIL 
      ,E.PHONE 
      ,RPAD( SUBSTR(EMP_NO, 1, 8), 14, '*' ) EMP_NO
      ,TO_CHAR(HIRE_DATE, 'YYYY.MM.DD') HIRE_DATE
      ,E.SALARY 
      ,TO_CHAR( 
            (SALARY + (SALARY * NVL(BONUS,0) )) * 12
            , '999,999,999,999'
      ) YR_SALARY
FROM EMPLOYEE E
      LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID);

select * from VE_EMP_DEPT;

-- SQLBook: Code
