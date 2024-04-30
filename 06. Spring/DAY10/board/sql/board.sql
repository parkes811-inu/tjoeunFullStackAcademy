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