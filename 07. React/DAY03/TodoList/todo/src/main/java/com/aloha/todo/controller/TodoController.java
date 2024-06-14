package com.aloha.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aloha.todo.dto.Todo;
import com.aloha.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")     // ⭐ CORS 허용
@RequestMapping("/todos")
public class TodoController {
    
    @Autowired
    private TodoService todoService;
    
    /**
     * 전체 목록 조회
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> getAll() {
        try {
            List <Todo> todoList = todoService.list();
            return new ResponseEntity<>(todoList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * 단일 조회
     * @param no
     * @return
     */
    @GetMapping("/{no}")
    public ResponseEntity<?> getOneTodo(@PathVariable("no") int no) {
        try {
            Todo Todo = todoService.select(no);
            return new ResponseEntity<>(Todo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * 등록
     * @param Todo
     * @return
     */
    @PostMapping()
    public ResponseEntity<?> createTodo(@RequestBody Todo Todo) {
        try {
            Todo newTodo = todoService.insert(Todo);
            if(newTodo != null) {
                return new ResponseEntity<>(newTodo, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * 상태 업데이트
     * no가 -1 이면 전체 완료
     * no > 0 이면 특정 할 일 완료
     * @param Todo
     * @return
     */
    @PutMapping()
    public ResponseEntity<?> updateTodo(@RequestBody Todo Todo) {
        try {
            int num = Todo.getNo();
            int result = 0;

            if(num == -1) {
                result = todoService.updateAll();
            } else {
                result = todoService.update(Todo);                
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * 할 일 목록 삭제
     * no가 -1 이면 전체 삭제
     * no > 0 이면 특정 할 일 삭제
     * @param no
     * @return
     */
    @DeleteMapping("/{no}")
    public ResponseEntity<?> deleteTodo(@PathVariable("no") int no) {
        try {
            int result = 0;
            if(no == -1) {
                result = todoService.deleteAll();
            } else {
                result = todoService.delete(no);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
