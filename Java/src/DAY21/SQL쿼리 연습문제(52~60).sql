-- SQLBook: Markup
<H1>DDL, Data Definition Language - 데이터 정의어</H1>
-- SQLBook: Markup
• CREATE

• ALTER

• DROP
-- SQLBook: Markup
* CREATE TABLE - 테이블생성

- 테이블 생성

CREATE TABLE 계정.테이블명 (

	     컬럼명1  데이터타입  [NULL/NOT NULL] [DEFAULT 기본값]   [PRIMARY KEY | UNIQUE] ,

	     컬럼명1  데이터타입  [NULL/NOT NULL] [DEFAULT 기본값]   [PRIMARY KEY | UNIQUE] ,

	     컬럼명1  데이터타입  [NULL/NOT NULL] [DEFAULT 기본값]   [PRIMARY KEY | UNIQUE]
         
	);
-- SQLBook: Markup
* 기존 테이블을 조회(복사) 하여 테이블 생성

CREATE TABLE 테이블명 

AS SELECT * FROM 기존 테이블명

[WHERE 조건];

* WHERE 조건은 필요시 사용!
-- SQLBook: Markup
* ALTER TABLE - 테이블 변경

ALTER TABLE 테이블명 ADD 컬럼명 데이터타입;


* 테이블에 컬럼 추가

ALTER TABLE 테이블명 RENAME COLUMN 기존컬럼명 TO 변경할컬럼명;

 
* 테이블의 컬럼명을 변경

ALTER TABLE 테이블명 MODIFY 컬럼명 변경할데이터타입;


* 테이블의 컬럼 데이터타입을 변경

ALTER TABLE 테이블명 MODIFY 컬럼명 변경할데이터타입;


* 테이블의 컬럼 삭제

ALTER TABLE 테이블명 DROP COLUMN 컬럼명;
-- SQLBook: Markup
* 테이블 삭제

* DROP TABLE 테이블명;

 \- CASCADE CONSTRAINTS : 테이블 삭제 시, 정의한 제약조건도 자동으로 삭제


* 테이블 데이터 삭제

TRUNCATE TABLE 테이블명;

-- SQLBook: Code
-- 52. 아래 <예시>의 TABLE 기술서를 참고하여 MS_STUDECREATE TABLE MS_STUDENT (
CREATE TABLE MS_STUDENT (
      ST_NO NUMBER NOT NULL 
      , NAME VARCHAR2(20) NOT NULL 
      , CTZ_NO CHAR(14) NOT NULL 
      , EMAIL VARCHAR2(100) NOT NULL 
      , ADDRESS VARCHAR2(1000) 
      , DEPT_NO NUMBER NOT NULL 
      , MJ_NO NUMBER NOT NULL 
      , REG_DATE DATE DEFAULT SYSDATE NOT NULL 
      , UPD_DATE DATE DEFAULT SYSDATE NOT NULL 
      , ETC VARCHAR2(1000) NOT NULL 
      , CONSTRAINT MS_STUDENT_PK PRIMARY KEY 
      (
            ST_NO 
      )
      ENABLE 
);

ALTER TABLE MS_STUDENT
ADD CONSTRAINT MS_STUDENT_UK1 UNIQUE 
(
  EMAIL 
)
ENABLE;

COMMENT ON COLUMN MS_STUDENT.ST_NO IS '학생번호';
COMMENT ON COLUMN MS_STUDENT.NAME IS '이름';
COMMENT ON COLUMN MS_STUDENT.CTZ_NO IS '주민등록번호';
COMMENT ON COLUMN MS_STUDENT.EMAIL IS '이메일';
COMMENT ON COLUMN MS_STUDENT.ADDRESS IS '주소';
COMMENT ON COLUMN MS_STUDENT.DEPT_NO IS '학부번호';
COMMENT ON COLUMN MS_STUDENT.MJ_NO IS '전공번호';
COMMENT ON COLUMN MS_STUDENT.REG_DATE IS '등록일자';
COMMENT ON COLUMN MS_STUDENT.UPD_DATE IS '수정일자';
COMMENT ON COLUMN MS_STUDENT.ETC IS '특이사항';

-- 53. 아래 <예시> 를 참고하여 MS_STUDENT 테이블에 속성을 추가하는 SQL 문을 작성하시오.
-- 테이블에 속성 추가
-- ALTER TABLE 테이블명 ADD 컬럼명 타입 DEFAULT 기본값 [NOT NULL];
-- 성별 속성 추가
ALTER TABLE MS_STUDENT ADD GENDER CHAR(6) DEFAULT '기타' NOT NULL;
COMMENT ON COLUMN MS_STUDENT.GENDER IS '성별';
-- 재적 속성 추가
ALTER TABLE MS_STUDENT ADD STATUS CHAR(6) DEFAULT '대기' NOT NULL;
COMMENT ON COLUMN MS_STUDENT.STATUS IS '재적';
-- 입학일자 속성 추가
ALTER TABLE MS_STUDENT ADD GENDER CHAR(6) DEFAULT '기타' NOT NULL;
COMMENT ON COLUMN MS_STUDENT.GENDER IS '성별';
-- 졸업일자 속성 추가
ALTER TABLE MS_STUDENT ADD GENDER CHAR(6) DEFAULT '기타' NOT NULL;
COMMENT ON COLUMN MS_STUDENT.GENDER IS '성별';

-- 54. MS_STUDENT 테이블의 CTZ_NO 속성을 BIRTH 로 이름을 변경하고
-- 데이터 타입을 DATE 로 수정하시오.
-- 그리고, 설명도 '생년월일'로 변경하시오.

-- CTZ_NO ➡ BIRTH  이름 변경
ALTER TABLE MS_STUDENT RENAME COLUMN CTZ_NO TO BIRTH;
-- DATE 타입으로 변경
ALTER TABLE MS_STUDENT MODIFY BIRTH DATE;
-- 설명을 '생년월일'로 변경
COMMENT ON COLUMN MS_STUDENT.BIRTH IS '생년월일';

-- 55. MS_STUDENT 테이블의 학부 번호(DEPT_NO) 속성을 삭제하시오.
ALTER TABLE MS_STUDENT DROP COLUMN DEPT_NO;

-- 56. MS_STUDENT 테이블을 삭제하는 SQL 문을 작성하시오.
DROP TABLE MS_STUDENT ;

-- 57. 테이블 정의서 대로 학생테이블(MS_STUDENT) 를 생성하시오.
CREATE TABLE MS_STUDENT (
     ST_NO      NUMBER          NOT NULL 
    ,NAME       VARCHAR2(20)    NOT NULL
    ,BIRTH      DATE            NOT NULL
    ,EMAIL      VARCHAR2(100)   NOT NULL
    ,ADDRESS    VARCHAR2(1000)  NULL
    ,MJ_NO      NUMBER          NOT NULL
    ,GENDER     CHAR(6)         DEFAULT '기타'    NOT NULL
    ,STATUS     VARCHAR2(10)    DEFAULT '대기'    NOT NULL
    ,ADM_DATE   DATE    NULL
    ,GRD_DATE   DATE    NULL
    ,REG_DATE   DATE    DEFAULT sysdate NOT NULL
    ,UPD_DATE   DATE    DEFAULT sysdate NOT NULL
    ,ETC        VARCHAR2(1000)  DEFAULT '없음' NULL
    ,
    CONSTRAINT MS_STUDENT_PK PRIMARY KEY(ST_NO) ENABLE
);
-- UQ (고유키) 추가
ALTER TABLE MS_STUDENT ADD CONSTRAINT MS_STUDENT_UK1 UNIQUE ( EMAIL ) ENABLE;

COMMENT ON TABLE MS_STUDENT IS '학생들의 정보를 관리한다.';
COMMENT ON COLUMN MS_STUDENT.ST_NO IS '학생 번호';
COMMENT ON COLUMN MS_STUDENT.NAME IS '이름';
COMMENT ON COLUMN MS_STUDENT.BIRTH IS '생년월일';
COMMENT ON COLUMN MS_STUDENT.EMAIL IS '이메일';
COMMENT ON COLUMN MS_STUDENT.ADDRESS IS '주소';
COMMENT ON COLUMN MS_STUDENT.MJ_NO IS '전공번호';
COMMENT ON COLUMN MS_STUDENT.GENDER IS '성별';
COMMENT ON COLUMN MS_STUDENT.STATUS IS '재적';
COMMENT ON COLUMN MS_STUDENT.ADM_DATE IS '입학일자';
COMMENT ON COLUMN MS_STUDENT.GRD_DATE IS '졸업일자';
COMMENT ON COLUMN MS_STUDENT.REG_DATE IS '등록일자';
COMMENT ON COLUMN MS_STUDENT.UPD_DATE IS '수정일자';
COMMENT ON COLUMN MS_STUDENT.ETC IS '특이사항';

-- 58. 아래 <예시> 를 참고하여 MS_STUDENT 테이블에 데이터를 삽입하는 SQL 문을 작성하시오.
-- 전공 번호(NUMBER) --> CHAR(4)
ALTER TABLE MS_STUDENT MODIFY MJ_NO CHAR(4); 
INSERT INTO MS_STUDENT ( 
                              ST_NO, NAME, BIRTH, EMAIL, ADDRESS, MJ_NO, GENDER,
                              STATUS, ADM_DATE, GRD_DATE, REG_DATE, UPD_DATE, ETC
                        )
VALUES ( '20180001', '최서아', '991005', 'csa@univ.ac.kr', '서울', 'I01',
         '여', '재학', '2018/03/01', NULL, sysdate, sysdate, NULL );

-- MS_STUDENT 데이터 추가
INSERT INTO ms_student ( 
                              ST_NO, NAME, BIRTH, EMAIL, ADDRESS, MJ_NO, GENDER,
                              STATUS, ADM_DATE, GRD_DATE, REG_DATE, UPD_DATE, ETC
                        )
VALUES ( '20180001', '최서아', '1999/10/05', 'csa@univ.ac.kr', '서울', 'I01', '여', 
        '재학', '2018/03/01', NULL, sysdate, sysdate, NULL );

-- '1999/10/05' -> TO_DATE('1999/10/05', 'YYYY/MM/DD') 도 가능
-- SQL Developer 에서 INSERT 한다면, COMMIT 을 실행해줘야 LOCK 걸리지 않고 적용됨.


INSERT INTO MS_STUDENT ( ST_NO, NAME, BIRTH, EMAIL, ADDRESS, MJ_NO, 
                        GENDER, STATUS, ADM_DATE, GRD_DATE, REG_DATE, UPD_DATE, ETC )
VALUES ( '20210001', '박서준', TO_DATE('2002/05/04', 'YYYY/MM/DD'), 'psj@univ.ac.kr', '서울', 'B02',
         '남', '재학', TO_DATE('2021/03/01', 'YYYY/MM/DD'), NULL, sysdate, sysdate, NULL );


INSERT INTO MS_STUDENT ( ST_NO, NAME, BIRTH, EMAIL, ADDRESS, MJ_NO, 
                        GENDER, STATUS, ADM_DATE, GRD_DATE, REG_DATE, UPD_DATE, ETC )
VALUES ( '20210002', '김아윤', TO_DATE('2002/05/04', 'YYYY/MM/DD'), 'kay@univ.ac.kr', '인천', 'S01',
         '여', '재학', TO_DATE('2021/03/01', 'YYYY/MM/DD'), NULL, sysdate, sysdate, NULL );

INSERT INTO MS_STUDENT ( ST_NO, NAME, BIRTH, EMAIL, ADDRESS, MJ_NO, 
                        GENDER, STATUS, ADM_DATE, GRD_DATE, REG_DATE, UPD_DATE, ETC )
VALUES ( '20160001', '정수안', TO_DATE('1997/02/10', 'YYYY/MM/DD'), 'jsa@univ.ac.kr', '경남', 'J01',
         '여', '재학', TO_DATE('2016/03/01', 'YYYY/MM/DD'), NULL, sysdate, sysdate, NULL );

INSERT INTO MS_STUDENT ( ST_NO, NAME, BIRTH, EMAIL, ADDRESS, MJ_NO, 
                        GENDER, STATUS, ADM_DATE, GRD_DATE, REG_DATE, UPD_DATE, ETC )
VALUES ( '20150010', '윤도현', TO_DATE('1996/03/11', 'YYYY/MM/DD'), 'ydh@univ.ac.kr', '제주', 'K01',
         '남', '재학', TO_DATE('2016/03/01', 'YYYY/MM/DD'), NULL, sysdate, sysdate, NULL );


INSERT INTO MS_STUDENT ( ST_NO, NAME, BIRTH, EMAIL, ADDRESS, MJ_NO, 
                        GENDER, STATUS, ADM_DATE, GRD_DATE, REG_DATE, UPD_DATE, ETC )
VALUES ( '20130007', '안아람', TO_DATE('1994/11/24', 'YYYY/MM/DD'), 'aar@univ.ac.kr', '경기', 'Y01',
         '여', '재학', TO_DATE('2013/03/01', 'YYYY/MM/DD'), NULL, sysdate, sysdate, '영상예술 특기자' );


INSERT INTO MS_STUDENT ( ST_NO, NAME, BIRTH, EMAIL, ADDRESS, MJ_NO, 
                        GENDER, STATUS, ADM_DATE, GRD_DATE, REG_DATE, UPD_DATE, ETC )
VALUES ( '20110002', '한성호', TO_DATE('1992/10/07', 'YYYY/MM/DD'), 'hsh@univ.ac.kr', '서울', 'E03',
         '남', '재학', TO_DATE('2015/03/01', 'YYYY/MM/DD'), NULL, sysdate, sysdate, NULL );

-- 59. MS_STUDENT 테이블의 데이터를 수정
-- UPDATE
/*
    UPDATE 테이블명
       SET 컬럼1 = 변경할 값,
           컬럼2 = 변경할 값,
           ...
   [WHERE] 조건;
*/
-- 1) 학생번호가 20160001 인 학생의 주소를 '서울'로,
--    재적상태를 '휴학'으로 수정하시오.
UPDATE MS_STUDENT
   SET ADDRESS = '서울'
      ,STATUS = '휴학'
WHERE ST_NO = '20160001';

-- 2) 학생번호가 20150010 인 학생의 주소를 '서울'로,
--    재적 상태를 '졸업', 졸업일자를 '20200220', 수정일자 현재날짜로 
--    그리고 특이사항을 '수석'으로 수정하시오.
UPDATE MS_STUDENT
   SET ADDRESS = '서울'
      , STATUS = '졸업'
      , GRD_DATE = '20200220'
      , UPD_DATE = SYSDATE
      , ETC = '수석'
 WHERE ST_NO = '20150010';

-- 3) 학생번호가 20130007 인 학생의 재적 상태를 '졸업', 졸업일자를 '20200220', 
--    수정일자 현재날짜로 수정하시오.
UPDATE MS_STUDENT
   SET STATUS = '졸업'
      , GRD_DATE = '20200220'
      , UPD_DATE = SYSDATE
 WHERE ST_NO = '20130007';

-- 4) 학생번호가 20110002 인 학생의 재적 상태를 '퇴학', 
--    수정일자를 현재날짜, 특이사항 '자진 퇴학' 으로 수정하시오.
UPDATE MS_STUDENT
   SET STATUS = '퇴학'
      , UPD_DATE = SYSDATE
      , ETC = '자진 퇴학'
 WHERE ST_NO = '20110002';

-- 60. 아래 <예시> 를 참고하여 MS_STUDENT 테이블에 데이터를 삭제하는 SQL 문을 작성하시오.
DELETE FROM MS_STUDENT
WHERE ST_NO = '20110002';
-- SQLBook: Markup
* 제약조건

\- 테이블에 저장할 데이터를 제약하는 조건

\- 데이터 무결성 : 데이터 정확성 + 데이터 일관성을 보장하는 성질

* 오라클 제약조건 종류

\- NOT NULL : NULL을 저장할 수 없도록 하는 제약조건

\- UNIQUE : 유일한 값을 갖도록 하는 제약조건(중복불가), NULL은 허용

\- PRIMARY KEY : 기본키로 지정, UNIQUE + NOT NULL

\- FOREIGN KEY : 참조 테이블의 열에 존재하는 값만 저장할 수 있도록 지정하는 제약조건

\- CHECK : 설정한 조건에 해당하는 데이터만 저장할 수 있도록 하는 제약조건

* 데이터 무결성 종류

\- 개체 무결성 : 기본 키는 반드시 유일한 값, NULL 불가, 중복이 불가능

\- 참조 무결성 : 외래키의 값이 참조 테이블에 기본 키의 값으로만 존재, NULL 가능

\- 도메인 무결성 : 지정된 값의 범위 안에서만 데이터를 저장

* 제약조건 추가

ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건;

* 제약조건 삭제 

ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;

* 제약조건 이름 변경

ALTER TABLE 테이블명 RENAME CONSTRAINT 기존이름 TO 변경이름;
-- SQLBook: Markup
* NOT NULL

* NOT NULL - 테이블 생성 시, NOT NULL 지정

CREATE TABLE 테이블명 (
        컬럼1 데이터타입 NOT NULL,
        컬럼2 데이터타입 NOT NULL,
        ...
);

* NOT NULL - 테이블 생성 시, 제약조건으로 지정

CREATE TABLE 테이블명 (
        컬럼1 데이터타입 CONSTRAINT 제약조건명1,
        컬럼2 데이터타입 CONSTRAINT 제약조건명2,
        ...
);

* NOT NULL - 테이블 생성 후, NOT NULL로 수정

ALTER TABLE 테이블명 MODIFY (컬럼 NOT NULL);

* NOT NULL - 테이블 생성 후, 제약조건 추가

ALTER TABLE 테이블명 MODIFY (컬럼 CONSTRAINT 제약조건명);
-- SQLBook: Markup
* UNIQUE

* UNIQUE - 테이블 생성 시, UNIQUE 지정

CREATE TABLE 테이블명 (
        컬럼1 데이터타입 UNIQUE,
        컬럼2 데이터타입 UNIQUE,
        ...
);

* UNIQUE - 테이블 생성 시, 제약조건으로 지정

CREATE TABLE 테이블명 (
        컬럼1 데이터타입 CONSTRAINT 제약조건명1,
        컬럼2 데이터타입 CONSTRAINT 제약조건명2,
        ...
);

* UNIQUE - 테이블 생성 후, UNIQUE 수정

ALTER TABLE 테이블명 MODIFY (컬럼 UNIQUE);

* UNIQUE - 테이블 생성 후, 제약조건으로 추가

ALTER TABLE 테이블명 MODIFY (컬럼 CONSTRAINT 제약조건명);