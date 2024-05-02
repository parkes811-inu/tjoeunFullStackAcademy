-- Active: 1714007442487@@127.0.0.1@3306@joeun
DROP TABLE board;

CREATE TABLE `board` (
  `no` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `writer` varchar(100) NOT NULL,
  `content` text,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`no`)
) COMMENT='게시판';

-- 테이블 데이터 전체 삭제
TRUNCATE board;


-- board, file 테이블 조인 조회
SELECT b.*
      ,f.no file_no
      ,f.file_name
      ,f.file_path
      ,f.file_code
FROM board b LEFT JOIN ( 
                         SELECT *
                         FROM file
                         WHERE parent_table = "board"
                           AND file_code = 1          # file_code = 1 (대표 썸네일)
                        ) f
             ON (b.no = f.parent_no)
;




TRUNCATE board;
TRUNCATE file;

-- 게시글 목록 페이징
SELECT *
  FROM board
 LIMIT 0, 10;

-- 샘플 데이터 등록
TRUNCATE board;
INSERT INTO board( title, writer, content )
VALUES ('제목01', '작성자01', '내용01')
      ,('제목02', '작성자02', '내용02')
      ,('제목03', '작성자03', '내용03')
      ,('제목04', '작성자04', '내용04')
      ,('제목05', '작성자05', '내용05')

INSERT INTO board( title, writer, content )
SELECT title, writer, content
  FROM board;

-- 게시글 목록 검색
SELECT *
  FROM board
 WHERE title LIKE '%keyword%'
    OR writer LIKE '%keyword%'
    OR content LIKE '%keyword%';

