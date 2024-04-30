-- Active: 1714007442487@@127.0.0.1@3306@joeun
CREATE TABLE `file` (
  `no` int NOT NULL AUTO_INCREMENT,
  `parent_table` varchar(45) NOT NULL,
  `parent_no` int NOT NULL,
  `file_name` text NOT NULL,
  `origin_name` text,
  `file_path` text NOT NULL,
  `file_size` int NOT NULL DEFAULT '0',
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `file_code` int NOT NULL DEFAULT '0',     # 파일 종류 코드       
  PRIMARY KEY (`no`)
) COMMENT='파일';

-- 파일 조회
select * from file;

truncate file;










