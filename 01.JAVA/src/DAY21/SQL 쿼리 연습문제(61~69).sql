-- SQLBook: Markup
* PRIMARY KEY 

-- SQLBook: Markup
> PRIMARY KEY - 테이블 생성 시, PRIMARY 키로 지정

CREATE TABLE 테이블명 (

        컬럼1 데이터타입 PRIMARY KEY,

        컬럼2 데이터타입 PRIMARY KEY,

        ...
        
);

> PRIMARY KEY - 테이블 생성 시, 제약조건으로 추가

CREATE TABLE 테이블명 (

        컬럼1 데이터타입 CONSTRAINT 제약조건명1,

        컬럼2 데이터타입 CONSTRAINT 제약조건명2,

        ...

);

> PRIMARY KEY - 테이블 생성 후, PRIMARY 키로 지정

ALTER TABLE 테이블명 MODIFY (컬럼 PRIMARY KEY);

> PRIMARY KEY - 테이블 생성 후, 제약조건으로 추가

ALTER TABLE 테이블명 MODIFY (컬럼 CONSTRAINT 제약조건명);
-- SQLBook: Markup
* FOREIGN KEY 

> FOREIGN KEY - 테이블 생성 시, FOREIGN KEY 지정

CREATE TABLE 테이블명 (

            컬럼1 데이터타입 REFERENCES 참조테이블(참조 컬럼),

            컬럼2 데이터타입,

            ...

);

> FOREIGN KEY - 테이블 생성 시, 제약조건으로 지정

CREATE TABLE 테이블명 (

            컬럼1 데이터타입 CONSTRAINT 제약조건명1,

            컬럼2 데이터타입 CONSTRAINT 제약조건명2,

            ...

        );

> FOREIGN KEY - 테이블 생성 후, 제약조건으로 지정

ALTER TABLE 테이블명 MODIFY (컬럼 CONSTRAINT 제약조건명);        
-- SQLBook: Markup
* CHECK

> CHECK - 테이블 생성 시, 제약조건으로 지정

CREATE TABLE 테이블명 (

            컬럼명1 데이터타입 CONSTRAINT 제약조건명 CHECK (조건),

            컬럼명2 데이터타입 ,

            ...

        );

> CHECK - 테이블 생성 후, CHECK 지정

ALTER TABLE 테이블명 MODIFY (컬럼 CHECK 조건);

> CHECK - 테이블 생성 후, 제약조건으로 지정

ALTER TABLE 테이블명 MODIFY CONSTRAINT 제약조건명 CHECK 조건;
-- SQLBook: Code
-- 60. MS_STUDENT 테이블에서 학번이 20110002 인 학생을 삭제하시오.
DELETE FROM MS_STUDENT 
WHERE ST_NO = '20110002';

-- 61. MS_STUDENT 테이블의 모든 속성을 조회하시오.
SELECT *
FROM MS_STUDENT;

-- 62. MS_STUDENT 테이블을 조회하여 MS_STUDENT_BACK 테이블 생성하시오.
-- 백업 테이블 만들기
CREATE TABLE MS_STUDENT_BACK
AS SELECT * FROM MS_STUDENT;

-- 63. MS_STUDENT 테이블의 튜플을 삭제하시오.
-- 데이터 삭제
DELETE FROM MS_STUDENT;
-- 데이터 및 내부 구조 삭제
TRUNCATE TABLE MS_STUDENT;
-- 구조 삭제
DROP TABLE MS_STUDENT;

-- 64. MS_STUDENT_BACK 테이블의 모든 속성을 조회하여 
-- MS_STUDENT 테이블에 삽입하는 SQL 문을 작성하시오.
INSERT INTO MS_STUDENT ADDRESS
SELECT * 
  FROM MS_STUDENT_BACK;

-- 65. MS_STUDENT 테이블의 성별 속성이 (‘여’, ‘남‘, ‘기타‘ ) 값만 
-- 입력가능하도록 하는 제약조건을 추가하시오.
ALTER TABLE MS_STUDENT
ADD CONSTRAINT MS_STUDENT_GENDER_CHECK
CHECK (GENDER IN ('여', '남', '기타'));


