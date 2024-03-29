-- SQLBook: Markup
<H1>숫자함수</H1>

-- SQLBook: Markup
CEIL(인자)           : 인자보다 크거나 같은 정수 중 제일 작은 수를 반환하는 함수

FLOOR(인자)          : 인자보다 작거나 같은 정수 중 제일 큰 수를 반환하는 함수

ROUND(인자, 자리수)   : 인자를 지정한 자리수에서 반올림한 값을 반환하는 함수

MOD(인자1, 인자2)     : 인자1을 인자2로 나눈 나머지를 반환하는 함수

POWER(인자1, 인자2)   : 인자1을 인자2로 제곱하는 값을 반환하는 함수

SQRT(인자)           : 인자의 제곱근을 구한 값을 반환하는 함수

TRUNC(인자, 자리수)   : 인자를 자리수에서 절삭한 값을 반환하는 함수

ABS(인자)             : 인자의 절댓값을 반환하는 함수
-- SQLBook: Code
-- 21. 12.45, -12.45 보다 크거나 같은 정수 중 제일 작은 수를
-- 계산하는 SQL문을 각각 작성하시오.
-- * DUAL : 산술 연산, 함수 결과 등을 확인해볼 수 있는 임시 테이블
SELECT CEIL(12.45) ,CEIL(-12.45)
  FROM DUAL;

-- 22. 12.55와 -12.55 보다 작거나 같은 정수 중 
-- 가장 큰 수를 계산하는 SQL 문을 각각 작성하시오.
SELECT CEIL(12.55) ,CEIL(-12.55)
  FROM DUAL;

-- 23. 각 소문제에 제시된 수와 자리 수를 이용하여 반올림하는 SQL문을 작성하시오.
--  1. 0.54 를 소수점 아래 첫째 자리에서 반올림하시오. → 결과 : 1
SELECT ROUND(0.54, 0)
  FROM DUAL;

--  2. 0.54 를 소수점 아래 둘째 자리에서 반올림하시오. → 결과 : 0.5
SELECT ROUND(0.54, 1)
  FROM DUAL;

--  3. 125.67 을 일의 자리에서 반올림하시오. → 결과 : 130
SELECT ROUND(125.67, -1)
  FROM DUAL;

--  4. 125.67 을 십의 자리에서 반올림하시오. → 결과 : 100
SELECT ROUND(125.67, -2)
  FROM DUAL;

-- 24. 각 소문제에 제시된 두 수를 이용하여 나머지를 구하는 SQL문을 작성하시오.
--  1. 3을 8로 나눈 나머지를 구하시오. → 결과 : 3
SELECT MOD(3, 8) 
  FROM DUAL;

--  2. 30을 4로 나눈 나머지를 구하시오. → 결과 : 2
SELECT MOD(30, 4) 
  FROM DUAL;

-- 25. 각 소문제에 제시된 두 수를 이용하여 제곱수를 구하는 SQL문을 작성하시오.
--  1. 2의 10제곱을 구하시오. → 결과 : 1024
SELECT POWER(2, 10) 
  FROM DUAL;

--  2. 2의 31제곱을 구하시오. → 결과 : 2147483648
SELECT POWER(2, 31) 
  FROM DUAL;

-- 26. 각 소문제에 제시된 수를 이용하여 제곱근을 구하는 SQL문을 작성하시오.
--  1. 2의 제곱근을 구하시오. → 결과 : 1.41421...
SELECT SQRT(2) 
  FROM DUAL;

--  2. 100의 제곱근을 구하시오. → 결과 : 10
SELECT SQRT(100) 
  FROM DUAL;

-- 27. 각 소문제에 제시된 수와 자리 수를 이용하여 해당 수를 절삭하는 SQL문을 작성하시오.
--  1. 527425.1234 을 소수점 아래 첫째 자리에서 절삭하시오.
SELECT TRUNC(527425.1234, 1)
  FROM DUAL;

--  2. 527425.1234 을 소수점 아래 둘째 자리에서 절삭하시오.
SELECT TRUNC(527425.1234, 2)
  FROM DUAL;

--  3. 527425.1234 을 일의 자리에서 절삭하시오.
SELECT TRUNC(527425.1234, -1)
  FROM DUAL;

--  4. 527425.1234 을 십의 자리에서 절삭하시오.  
SELECT TRUNC(527425.1234, -2)
  FROM DUAL;

-- 28. 각 소문제에 제시된 수를 이용하여 절댓값을 구하는 SQL문을 작성하시오.
--  1. -20 의 절댓값을 구하시오.
SELECT ABS(-20)
  FROM DUAL;

--  2. -12.456 의 절댓값을 구하시오.
SELECT ABS(-12.456)
  FROM DUAL;

  
-- SQLBook: Markup
<H1>문자함수</H1>

-- SQLBook: Markup
UPPER(인자) : 인자(영문자를) 대문자로 변환하는 함수

LOWER(인자) : 인자(영문자를) 소문자로 변환하는 함수

INITCAP(인자) : 인자(영문자)를 단어를 기준으로 첫글자를 대문자로 변환하는 함수

LENGTH(인자) : 인자의 글자 수를 반환하는 함수

LENGTHB(인자) : 인자의 바이트 수를 반환하는 함수

CONCAT(인자1, 인자2) : 인자1과 인자2를 연결하는 함수 || : 2개 이상의 문자열을 연결하는 기호

SUBSTR(문자열, 시작번호, 글자수) : 문자열에서 시작 번호부터 지정한 글자 수만큼의 문자열을 추출하여 반환하는 함수

SUBSTRB(문자열, 시작번호, 바이트수) : 문자열에서 시작 번호부터 지정한 바이트 수만큼의 문자열을 추출하여 반환하는 함수

INSTR(문자열, 문자, 시작번호, 순서) : 문자열 안에서 지정한 시작번호부터 문자를 찾아서, 지정한 순서에서 있는 문자의 위치를 반환하는 함수

INSTRB(문자열, 문자, 시작번호, 순서) : 문자열 안에서 지정한 시작번호부터 문자를 찾아서, 지정한 순서에서 있는 문자의 위치를 바이트로 반환하는 함수

LPAD(문자열, 칸, 문자) : 지정한 칸에서 왼쪽에 빈공간을 특정 문자로 채우는 함수

RPAD(문자열, 칸, 문자) : 지정한 칸에서 오른쪽에 빈공간을 특정 문자로 채우는 함수

-- SQLBook: Code
-- 29. <예시>와 같이 문자열을 대문자, 소문자, 첫글자만 대문자로 변환하는 SQL문을 작성하시오.
-- <예시>
-- 원문             대문자          소문자            첫글자만 대문자
-- AlOhA WoRlD~!    ALOHA WORLD~!  aloha world~!    Aloha World~!
SELECT UPPER('AlOhA WoRlD~!') AS "대문자",
       UPPER('aloha world~!')
  FROM DUAL;

-- 30. <예시>와 같이 문자열의 글자 수와 바이트 수를 출력하는 SQL문을 작성하시오.
-- <예시1>
-- 문자열 : ‘ALOHA WORLD’
-- 글자 수      바이트 수 
--   11         11
SELECT LENGTH('ALOHA WORLD') AS "글자 수"
      ,LENGTHB('ALOHA WORLD') AS "바이트 수"
FROM DUAL;

-- <예시2>
-- 문자열 : ‘알로하 월드’
-- 글자 수      바이트 수 
--   6           16
SELECT LENGTH('알로하 월드') AS "글자 수"
      ,LENGTHB('알로하 월드') AS "바이트 수"
FROM DUAL;

-- 31. <예시>와 같이 각각 함수와 기호를 이용하여 두 문자열을 병합하여 출력하는 SQL문을 작성하시오.
-- <예시>
-- 문자열1 : ‘ALOHA’
-- 문자열2 : ‘WORLD’

--    함수            기호
-- ALOHAWORLD      ALOHAWORLD
SELECT CONCAT('ALOHA', 'WORLD') AS "함수"
      , 'ALOHA' || 'CLASS' AS "기호"
  FROM DUAL;

-- 32. <예시>와 같이 주어진 문자열의 일부만 출력하는 SQL문을 작성하시오.
-- <예시>
-- 문자열 : ‘www.alohacampus.com’
-- 1           2            3
-- www    alohacampus      com

-- 문자열 : ‘www.알로하캠퍼스.com’
-- 1           2            3
-- www    알로하캠퍼스      com
SELECT SUBSTR('www.alohacampus.com', 1, 3) AS "1"
     , SUBSTR('www.alohacampus.com', 5, 11) AS "2"
     , SUBSTR('www.alohacampus.com', 17, 3) AS "3"
  FROM DUAL;

-- 33. <예시>와 같이 문자열에서 특정 문자의 위치를 구하는 SQL문을 작성하시오.
-- <예시>
-- 문자열 : ‘ALOHACAMPUS’
-- 함수 – 문자함수
-- 1번째 A        2번째 A      3번째 A
--    1             5            7
SELECT INSTR('ALOHACLASS', 'A', 1, 1) AS "1번째 A"
     , INSTR('ALOHACLASS', 'A', 1, 2) AS "2번째 A"
     , INSTR('ALOHACLASS', 'A', 1, 3) AS "3번째 A"
     , INSTR('ALOHACLASS', 'A', 1, 4) AS "4번째 A"
  FROM DUAL;


-- 34. <예시>와 같이 대상 문자열을 왼쪽/오른쪽에 출력하고 빈공간을 
-- 특정 문자로 채우는 SQL문을 작성하시오.
-- <예시>
-- 문자열: ‘ALOHACAMPUS’
-- 문자 : ‘#’
-- 왼쪽                             오른쪽
-- #########ALOHACAMPUS       ALOHACMAPUS######### 

SELECT LPAD('ALOHACLASS', 20, '#') AS "왼쪽"
     , RPAD('ALOHACLASS', 20, '#') AS "오른쪽"
  FROM DUAL;   

SELECT RPAD(SUBSTR('020415-3123456', 1, 7),  14, '#')
  FROM DUAL;  