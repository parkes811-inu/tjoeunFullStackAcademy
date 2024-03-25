-- 9. 테이블 EMPLOYEES의 'JOB_ID'가 'FI_ACCOUNT' 이거나 'IT_PROG' 인 
--    사원의 모든 컬럼을 조회하는 SQL 문을 작성하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE JOB_ID = 'FI_ACCOUNT' 
    OR JOB_ID = 'IT_PROG';
       
-- 10. 테이블 EMPLOYEES의 'JOB_ID'가 'FI_ACCOUNT' 이거나 'IT_PROG' 인 
--     사원의 모든 컬럼을 조회하는 SQL 문을 작성하시오.
-- <조건> IN 키워드를 사용하여 SQL 쿼리를 완성하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE JOB_ID IN ('FI_ACCOUNT', 'IT_PROG');
 
-- 11. 테이블 EMPLOYEES의 JOB_ID가 'FI_ACCOUNT' 이거나 'IT_PROG' 아닌
--     사원의 모든 컬럼을 조회하는 SQL문을 작성하시오.
-- <조건> IN 키워드를 사용하여 SQL 쿼리를 완성하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE JOB_ID NOT IN ('FI_ACCOUNT', 'IT_PROG');
 
-- 12. 테이블 EMPLOYEES의 JOB_ID가 'IT_PROG' 이면서 SALARY가 6,000이상인 사원의
-- 모든 컬럼을 조회하는 SQL문을 작성하시오.
SELECT * 
  FROM EMPLOYEES 
 WHERE JOB_ID = 'IT_PROG' 
   AND SALARY >= 6000;

-- 13. 테이블 EMPLOYEES의 FIRST_NAME이 'S'로 시작하는 사원의 
--     모든 컬럼을 조회하는 SQL문을 작성하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE 'S%';

-- 14. 테이블 EMPLOYEES의 FIRST_NAME이 's'로 끝나는 사원의
--     모든 컬럼을 조회하는 SQL문을 작성하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '%s';
 
-- 15. 테이블 EMPLOYEES의 FIRST_NAME이 's'가 포함되는 사원의
--     모든 컬럼을 조회하는 SQL문을 작성하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '%s%';

-- 16. 테이블 EMPLOYEES의 FIRST_NAME이 5글자인 사원의
--     모든 컬럼을 조회하는 SQL문을 작성하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE LENGTH(FIRST_NAME) = 5; -- LENGTH(컬럼명) : 글자 수를 반환하는 함수
-- WHERE FIRST_NAME LIKE '_____'; LIKE 키워드 사용, _ 언더바 한 개가 한 글자를 의미

-- 17. 테이블 EMPLOYEES의 COMMISSION_PCT가 NULL인 사원의
--     모든 컬럼을 조회하는 SQL문을 작성하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL;
 
-- 18. 테이블 EMPLOYEES의 COMMISSION_PCT가 NULL이 아닌 사원의
--     모든 컬럼을 조회하는 SQL문을 작성하시오.
SELECT * 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL; 
 
-- 19. 테이블 EMPLOYEES의 사원의 HIRE_DATE가 04년 이상인
--     모든 컬럼을 조회하는 SQL문을 작성하시오.
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE >= TO_DATE('04/01/01', 'YY/MM/DD')
ORDER BY HIRE_DATE ASC;

-- 20. 테이블 EMPLOYEES의 사원의 HIRE_DATE가 04년도 부터 05년도인
--     모든 컬럼을 조회하는 SQL문을 작성하시오.
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE >= TO_DATE('04/01/01', 'YY/MM/DD')
   AND HIRE_DATE <= TO_DATE('05/12/31', 'YY/MM/DD')
ORDER BY HIRE_DATE ASC;


 
 
