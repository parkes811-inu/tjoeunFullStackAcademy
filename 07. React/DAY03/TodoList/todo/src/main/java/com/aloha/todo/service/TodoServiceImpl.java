package com.aloha.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.todo.dto.Todo;
import com.aloha.todo.mapper.TodoMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoMapper todoMapper;

    @Override
    public List<Todo> list() throws Exception {
        List<Todo> TodoList = todoMapper.list();
        return TodoList;
    }

    @Override
    public Todo select(int no) throws Exception {
        Todo Todo = todoMapper.select(no);
        return Todo;
    }

    @Override
    public Todo insert(Todo Todo) throws Exception {
        int result = todoMapper.insert(Todo);
        log.info("todo : " + Todo);
        int newTodoNo = Todo.getNo(); 
        Todo newTodo = todoMapper.select(newTodoNo);
        return newTodo;
    }

    @Override
    public int update(Todo Todo) throws Exception {
        int result = todoMapper.update(Todo);
        return result;
    }

    @Override
    public int delete(int no) throws Exception {
        int result = todoMapper.delete(no);
        return result;
    }
    
    @Override
    public int deleteAll() throws Exception {
        int result = todoMapper.deleteAll();
        return result;
    }

    // Todo 전체 수정
    public int updateAll() throws Exception {
        int result = todoMapper.updateAll();
        return result;
    }
}
