-- SQLBook: Code
-- 72.
-- MS_BOARD 의 WRITER 속성을 NUMBER 타입으로 변경하고
-- MS_USER 의 USER_NO 를 참조하는 외래키로 지정하시오.

-- 1)
-- 데이터 타입 변경
-- ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입;
ALTER TABLE MS_BOARD MODIFY WRITER NUMBER;

-- 외래키 지정
-- ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명
-- FOREIGN KEY (외래키컬럼) REFERENCES 참조테이블(기본키);
ALTER TABLE MS_BOARD ADD CONSTRAINT MS_BOARD_WRITER_FK
FOREIGN KEY (WRITER) REFERENCES MS_USER(USER_NO);

-- 2) 외래키 : MS_FILE (BOARD_NO)  ---->  MS_BOARD (BOARD_NO)
ALTER TABLE MS_FILE ADD CONSTRAINT MS_FILE_BOARD_NO_FK
FOREIGN KEY (BOARD_NO) REFERENCES MS_BOARD(BOARD_NO);

-- 3) 외래키 : MS_REPLY (BOARD_NO)  ---->  MS_BOARD (BOARD_NO)
ALTER TABLE MS_REPLY ADD CONSTRAINT MS_REPLY_BOARD_NO_FK
FOREIGN KEY (BOARD_NO) REFERENCES MS_BOARD(BOARD_NO);
-- 제약조건 삭제
-- ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;

-- 73. 테이블 MS_USER 에 아래 <예시> 과 같이 속성을 추가하는 SQL문을 작성하시오.
ALTER  TABLE MS_USER ADD CTZ_NO CHAR(14) NOT NULL UNIQUE;

ALTER TABLE MS_USER ADD GENDER CHAR(6) NOT NULL;
COMMENT ON COLUMN MS_USER.CTZ_NO IS '주민번호';
COMMENT ON COLUMN MS_USER.GENDER IS '성별';

-- 74.
-- MS_USER 의 GENDER 속성이 ('여', '남', '기타') 값만 갖도록
-- 제약조건을 추가하시오.
-- CHECK 제약조건 추가
ALTER TABLE MS_USER 
ADD CONSTRAINT MS_USER_GENDER_CHECK
CHECK (GENDER IN ('여', '남', '기타'));

-- 75.
-- MS_FILE 테이블에 확장자(EXT) 속성을 추가하시오.
ALTER TABLE MS_FILE ADD EXT VARCHAR2(10) NULL;
COMMENT ON COLUMN MS_FILE.EXT IS '확장자';

SELECT * FROM MS_FILE;


-- 76.
-- 테이블 MS_FILE 의 FILE_NAME 속성에서 확장자를 추출하여 
-- EXT 속성에 UPDATE 하는 SQL 문을 작성하시오. 
MERGE INTO MS_FILE T      -- 대상 테이블 지정
-- 사용할 데이터 자원을 지정
USING ( SELECT FILE_NO, FILE_NAME FROM MS_FILE ) F 
-- ON (UPDATE 조건)
ON (T.FILE_NO = F.FILE_NO)
-- 매치조건
WHEN MATCHED THEN
    -- 이미지 파일 확장자를 추출하여 수정
    UPDATE SET T.EXT = SUBSTR( F.FILE_NAME, INSTR(F.FILE_NAME, '.', -1) + 1 )
    -- 이미지 확장자 'jpeg', 'jpg', 'gif', 'png', 'webp'가 아니면 삭제
    DELETE WHERE LOWER(SUBSTR( F.FILE_NAME, INSTR(F.FILE_NAME, '.', -1) + 1 ))
          NOT IN ('jpeg', 'jpg', 'gif', 'png', 'webp')

-- 매치가 안됐을 때 조건
-- WHEN NOT MATCHED THEN 

-- 77. 테이블 MS_FILE 의 EXT 속성이 (‘jpg’, ‘jpeg’, ‘gif’, ‘png’) 
-- 값을 갖도록 하는 제약조건을 추가하는 SQL문을 작성하시오. 
-- 파일 추가
INSERT INTO MS_FILE ( 
            FILE_NO, BOARD_NO, FILE_NAME, FILE_DATA, REG_DATE, UPD_DATE, EXT
            )
VALUES (1, 1, '강아지.png', '123', sysdate, sysdate, 'jpg' );
INSERT INTO MS_FILE ( 
            FILE_NO, BOARD_NO, FILE_NAME, FILE_DATA, REG_DATE, UPD_DATE, EXT
            )
VALUES (2, 1, 'main.html', '123', sysdate, sysdate, 'jpg' );

-- 게시글 추가
INSERT INTO MS_BOARD (
                BOARD_NO, TITLE, CONTENT, WRITER, HIT, LIKE_CNT,
                DEL_YN, DEL_DATE, REG_DATE, UPD_DATE
                )
VALUES (
        1, '제목', '내용', 1, 0, 0, 'N', NULL, sysdate, sysdate
        );

-- 유저 추가
INSERT INTO MS_USER(
                USER_NO, USER_ID, USER_PW, USER_NAME, BIRTH,
                TEL, ADDRESS, REG_DATE, UPD_DATE,
                CTZ_NO, GENDER
                )
VALUES ( 1, 'ALOHA', '123456', '김조은', TO_DATE('2003/01/01', 'YYYY/MM/DD'),
         '010-1234-1234', '부평', sysdate, sysdate,
         '030101-3334444', '기타');

-- 77. Answer
ALTER TABLE MS_FILE 
  ADD CONSTRAINT MS_FILE_EXT_CHECK
CHECK (EXT IN ('jpeg', 'jpg', 'gif', 'png', 'webp'));

-- 78. 아래 <예시> 에 주어진 테이블의 모든 행을 삭제하는 SQL 문을 작성하시오.
-- <예시>
-- DDL - TRUNCATE
-- DML - DELETE
-- 1. [MS_USER] 테이블의 모든 행을 삭제하시오.
TRUNCATE TABLE MS_USER;
DELETE FROM MS_USER;

-- 2. [MS_BOARD] 테이블의 모든 행을 삭제하시오.
TRUNCATE TABLE MS_BOARD;
DELETE FROM MS_BOARD;

-- 3. [MS_FILE] 테이블의 모든 행을 삭제하시오.
TRUNCATE TABLE MS_FILE;
DELETE FROM MS_FILE;

-- 4. [MS_REPLY] 테이블의 모든 행을 삭제하시오.
TRUNCATE TABLE MS_REPLY;
DELETE FROM MS_REPLY;

-- DELETE vs TRUNCATE
-- * DELETE - 데이터 조작어(DML)
--   - 한 행 단위로 데이터를 삭제한다.
--   - COMMIT, ROLLBACK 를 이용하여 변경사항을 적용하거나 되돌릴 수 있음

-- * TRUNCATE - 데이터 정의어(DDL)
--   - 모든 행을 삭제한다.
--   - 삭제된 데이터를 되돌릴 수 없음

-- 79.
-- 테이블의 속성을 삭제하시오.
-- * MS_BOARD 테이블의 WRITER 속성
-- * MS_FILE 테이블의 BOARD_NO 속성
-- * MS_REPLY 테이블의 BOARD_NO 속성
ALTER TABLE MS_BOARD DROP COLUMN WRITER;
ALTER TABLE MS_FILE DROP COLUMN BOARD_NO;
ALTER TABLE MS_REPLY DROP COLUMN BOARD_NO ;

-- 80.
-- 각 테이블에 속성들을 추가한 뒤, 외래키로 지정하시오.
-- 해당 외래키에 대하여 참조 테이블의 데이터 삭제 시,
-- 연결된 속성의 값도 삭제하는 옵션도 지정하시오.

-- 1)
-- MS_BOARD 에 WRITER 속성 추가
ALTER TABLE MS_BOARD ADD WRITER NUMBER NOT NULL;

-- WRITER 속성을 외래키로 지정
-- + 참조 테이블 데이터 삭제 시, 연쇄적으로 함께 삭제하는 옵션 지정
ALTER TABLE MS_BOARD
ADD CONSTRAINT MS_BOARD_WRITER_FK
FOREIGN KEY (WRITER) REFERENCES MS_USER(USER_NO)
ON DELETE CASCADE;
-- ON DELETE CASCADE[NO ACTION, RESTRICT, CASCADE, SET NULL]
-- * NO ACTION : 아무 행위도 안함.
-- * RESTRICT  : 자식 테이블의 데이터가 존재하면, 삭제 안함
-- * SET NULL  : 자식 테이블의 데이터를 NULL 로 지정

-- 2)
-- MS_FILE 에 BOARD_NO 속성 추가
ALTER TABLE MS_FILE ADD BOARD_NO NUMBER NOT NULL;
-- BOARD_NO 속성을 외래키로 추가
-- 참조테이블 : MS_BOARD, 참조 속성 : BOARD_NO
-- + 참조 테이블 데이터 삭제 시, 연쇄적으로 함께 삭제하는 옵션 지정
ALTER TABLE MS_FILE
ADD CONSTRAINT MS_BOARD_BOARD_FK
FOREIGN KEY (BOARD_NO) REFERENCES MS_BOARD(BOARD_NO)
ON DELETE CASCADE;

-- 3)
-- MS_REPLY 에 BOARD_NO 속성 추가
ALTER TABLE MS_REPLY ADD BOARD_NO NUMBER NOT NULL;

-- BOARD_NO 속성을 외래키로 추가
-- 참조테이블 : MS_BOARD, 참조 속성 : BOARD_NO
-- + 참조 테이블 데이터 삭제 시, 연쇄적으로 함께 삭제하는 옵션 지정
ALTER TABLE MS_REPLY
ADD CONSTRAINT MS_REPLY_BOARD_FK
FOREIGN KEY (BOARD_NO) REFERENCES MS_BOARD(BOARD_NO)
ON DELETE CASCADE;

-- 회원 탈퇴 (회원 번호 : 1)
DELETE FROM MS_USER WHERE USER_NO = 1;

-- 외래키 제약 조건
-- ALTER TABLE 테이블명
-- ADD CONSTRAINT 제약조건명 FOREIGN KEY (외래키 속성)
-- REFERENCES 참조 테이블 (참조 속성)
-- ON UPDATE [NO ACTION | RESTRICT | CASCADE | SET NULL]
-- ON DELETE [NO ACTION | RESTRICT | CASCADE | SET NULL]
-- 옵션
-- ON UPDATE            -- 참조 테이블 수정 시,
--  * CASCADE           : 자식 데이터 수정
--  * SET NULL          : 자식 데이터는 NULL 
--  * SET DEFAULT       : 자식 데이터는 기본값
--  * RESTRICT          : 자식 테이블의 참조하는 데이터가 존재하면, 부모 데이터 수정 불가
--  * NO ACTION         : 아무런 행위도 취하지 않는다 (기본값)

-- ON DELETE            -- 참조 테이블 삭제 시,
--  * CASCADE           : 자식 데이터 삭제
--  * SET NULL          : 자식 데이터는 NULL 
--  * SET DEFAULT       : 자식 데이터는 기본값
--  * RESTRICT          : 자식 테이블의 참조하는 데이터가 존재하면, 부모 데이터 삭제 불가
--  * NO ACTION         : 아무런 행위도 취하지 않는다 (기본값)

-- 81.
-- EMPLOYEE, DEPARTMENT, JOB 테이블을 사용하여
-- 스칼라 서브쿼리로 출력결과와 같이 조회하시오.
SELECT E.EMP_ID 사원번호, E.EMP_NAME 직원명
      ,(SELECT DEPT_TITLE 
          FROM DEPARTMENT D 
         WHERE E.DEPT_CODE = D.DEPT_ID) 부서명
      ,(SELECT JOB_NAME 
          FROM JOB J 
         WHERE E.JOB_CODE = J.JOB_CODE) 직급명
  FROM EMPLOYEE E;
 
-- 82. <예시> 의 테이블 구조와 출력결과를 참고하여, 
-- 인라인 뷰를 이용하여 부서별로 최고급여를 받는 직원을 조회하는 SQL 문을작성하시오. 
-- (단, 부서코드는 DEPT_CODE, DEPT_ID 이다. )

-- 1. 부서별로 최고 급여를 조회 (서브 쿼리)
SELECT DEPT_CODE
     , MAX(SALARY) 최고급여
     , MIN(SALARY) 최저급여
     , AVG(SALARY) 평균급여
  FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2. 부서별로 최고급여 조회결과를 서브쿼리 (인라인 뷰로 지정)
SELECT B.EMP_ID 사원번호, B.EMP_NAME 직원명, A.DEPT_TITLE 부서명
     , B.SALARY 급여, C.최고급여, C.최저급여, C.평균급여
  FROM DEPARTMENT A, EMPLOYEE B, 
      (SELECT DEPT_CODE
            , MAX(SALARY) 최고급여
            , MIN(SALARY) 최저급여
            , ROUND(AVG(SALARY), 2) 평균급여
      FROM EMPLOYEE
      GROUP BY DEPT_CODE) C 
WHERE A.DEPT_ID = C.DEPT_CODE
  AND B.SALARY = C.최고급여;

-- 83. <예시> 의 테이블 구조와 출력결과를 참고하여, 중첩 서브쿼리를 이용하여 
-- 직원명이 ‘이태림'인 사원과 같은 부서의 직원들 을 조회하는 SQL 문을 작성하시오.
SELECT EMP_ID, EMP_NAME, EMAIL, PHONE
  FROM EMPLOYEE
 WHERE DEPT_CODE = (SELECT DEPT_CODE
                      FROM EMPLOYEE
                     WHERE EMP_NAME = '이태림');

-- 84. 테이블 EMPLOYEE 와 DEPARTMENT 의 DEPT_CODE 와 DEPT_ID 속성이 
-- 일치하는 행이 존재하는 경우, 테이블 DEPARTMENT 의 데이터를 조회하는 SQL 문을 작성하시오.                      
-- 1) 서브쿼리
 SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID
  FROM DEPARTMENT
 WHERE DEPT_ID IN ( SELECT DISTINCT(DEPT_CODE)
                      FROM EMPLOYEE
                     WHERE DEPT_CODE IS NOT NULL);

-- 2) EXISTS
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID
  FROM DEPARTMENT D
 WHERE EXISTS (
                 SELECT *
                   FROM EMPLOYEE E
                  WHERE D.DEPT_ID = E.DEPT_CODE
              );

-- 85. 테이블 EMPLOYEE 와 DEPARTMENT 의 DEPT_CODE 와 DEPT_ID 속성이 일치하는 
-- 행이 존재하지 않는 경우, 테이블 DEPARTMENT 의 데이터를 조회하는 SQL 문을 작성하시오.
-- 1) 서브쿼리
 SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID
  FROM DEPARTMENT
 WHERE DEPT_ID NOT IN ( SELECT DISTINCT(DEPT_CODE)
                      FROM EMPLOYEE
                     WHERE DEPT_CODE IS NOT NULL);

-- 2) EXISTS
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID
  FROM DEPARTMENT D
 WHERE NOT EXISTS (
                 SELECT *
                   FROM EMPLOYEE E
                  WHERE D.DEPT_ID = E.DEPT_CODE
              );

-- 86. 테이블 EMPLOYEE 의 DEPT_CODE 가 ‘D1’인 부서의 최대급여보다 
-- 더 큰 급여를 받는 사원을 조회하는 SQL 문을 작성하시오.
SELECT A.EMP_ID, A.EMP_NAME, B.DEPT_ID ,B.DEPT_TITLE, A.SALARY
  FROM EMPLOYEE A, DEPARTMENT B
 WHERE A.DEPT_CODE = B.DEPT_ID
   AND A.SALARY > (
                      SELECT MAX(SALARY)
                        FROM EMPLOYEE
                       WHERE DEPT_CODE = 'D1'
                  )
ORDER BY A.SALARY

-- 87. 테이블 EMPLOYEE 의 DEPT_CODE 가 ‘D9’인 부서의 최저급여보다 
-- 더 큰 급여를 받는 사원을 조회하는 SQL 문을 작성하시오.
SELECT A.EMP_ID, A.EMP_NAME, B.DEPT_ID ,B.DEPT_TITLE, A.SALARY
  FROM EMPLOYEE A, DEPARTMENT B
 WHERE A.DEPT_CODE = B.DEPT_ID
   AND A.SALARY > (
                      SELECT MIN(SALARY)
                        FROM EMPLOYEE
                       WHERE DEPT_CODE = 'D9'
                  )
ORDER BY A.SALARY DESC

-- 88. 테이블 EMPLOYEE 와 DEPARTMENT 를 조인하여 출력하되, 
-- 부서가 없는 직원도 포함하여 출력하는 SQL 문을 작성하시오. 
SELECT NVL(A.EMP_ID, '(없음)')
     , NVL(A.EMP_NAME, '(없음)')
     , B.DEPT_ID
     , B.DEPT_TITLE
  FROM EMPLOYEE A 
  LEFT JOIN DEPARTMENT B
  ON A.DEPT_CODE = B.DEPT_ID;

-- 89. 테이블 EMPLOYEE 와 DEPARTMENT 를 조인하여 출력하되, 
-- 직원이 없는 부서도 포함하여 출력하는 SQL 문을 작성하시오.
SELECT NVL(A.EMP_ID, '(없음)')
     , NVL(A.EMP_NAME, '(없음)')
     , B.DEPT_ID
     , B.DEPT_TITLE
  FROM EMPLOYEE A 
  RIGHT JOIN DEPARTMENT B
  ON A.DEPT_CODE = B.DEPT_ID;

-- 90. 테이블 EMPLOYEE 와 DEPARTMENT 를 조인하여 출력하되, 
-- 직원 및 부서 유무에 상관없이 출력하는 SQL 문을 작성하시오.
SELECT NVL(A.EMP_ID, '(없음)')
     , NVL(A.EMP_NAME, '(없음)')
     , B.DEPT_ID, B.DEPT_TITLE
  FROM EMPLOYEE A FULL OUTER JOIN DEPARTMENT B
  ON A.DEPT_CODE = B.DEPT_ID;
