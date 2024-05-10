-- 댓글
-- * 게시글(board)에 종속된 테이블
CREATE TABLE reply (
    no              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,        -- 댓글번호
    board_no        INT NOT NULL,                                   -- 글번호
    parent_no       INT NOT NULL,                                   -- 부모번호
    writer          VARCHAR(100) NOT NULL,                          -- 작성자
    content         TEXT NOT NULL,                                  -- 내용
    reg_date        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 등록일자
    upd_date        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,    -- 수정일자
    FOREIGN KEY (board_no) REFERENCES board(no)
                           ON DELETE CASCADE -- CASCADE, RESTRICT, SET NULL
                           ON UPDATE CASCADE
);


-- reply 테이블에 외래키 추가
ALTER TABLE reply
ADD CONSTRAINT FK_REPLY_BOARD_NO
FOREIGN KEY(board_no)
REFERENCES board(no)
ON DELETE CASCADE ;     -- 게시글 삭제 시, 종속된 댓글 삭제