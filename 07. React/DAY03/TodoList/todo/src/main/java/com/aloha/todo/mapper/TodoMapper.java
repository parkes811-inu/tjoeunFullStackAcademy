package com.aloha.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.todo.dto.Todo;

@Mapper
public interface TodoMapper {
    // Todo 목록 
    public List<Todo> list() throws Exception;
    // Todo 조회
    public Todo select(int no) throws Exception;
    // Todo 등록
    public int insert(Todo todo) throws Exception;
    // Todo 수정
    public int update(Todo todo) throws Exception;
    // Todo 전체 수정
    public int updateAll() throws Exception;
    // Todo 삭제    
    public int delete(int no) throws Exception;
    // Todo 전체 삭제    
    public int deleteAll() throws Exception;

}
