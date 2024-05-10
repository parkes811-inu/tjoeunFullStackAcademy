package com.aloha.board.dto;

import java.util.Date;
import lombok.Data;
import java.util.*;;

/**
 * Board 
 * - 게시글 정보
 */
@Data
public class Reply {
    private int no;
    private int boardNo;
    private int parentNo;        
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    
    List<Reply> childList;
}
 