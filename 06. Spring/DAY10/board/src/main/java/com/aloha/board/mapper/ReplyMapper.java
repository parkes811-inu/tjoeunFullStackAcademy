package com.aloha.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.board.dto.Reply;

@Mapper     // MyBatis 의 매퍼 인터페이스로 지정하는 어노테이션
public interface ReplyMapper {

    // 댓글 목록
    public List<Reply> list() throws Exception;
    // 댓글 조회
    public Reply select(int no) throws Exception;
    // 댓글 등록
    public int insert(Reply reply) throws Exception;
    // 댓글 수정
    public int update(Reply reply) throws Exception;
    // 댓글 삭제
    public int delete(int no) throws Exception;
    // 댓글 번호
    public List<Reply> listByBoardNo(int no) throws Exception;


}