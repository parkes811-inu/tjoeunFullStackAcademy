package com.aloha.server.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.aloha.server.dto.Board;
import com.aloha.server.dto.Files;
import com.aloha.server.service.BoardService;
import com.aloha.server.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/boards")
public class BoardController {
    
    @Autowired
    private BoardService boardService;

    @Autowired
    private FileService fileService;


    @GetMapping()
    public ResponseEntity<?> getAll() {
        try {
            List <Board> BoardList = boardService.list();
            return new ResponseEntity<>(BoardList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{no}")
    public ResponseEntity<?> getOne(@PathVariable("no") int no) {
        try {
            // 게시글 
            Board board = boardService.select(no);

            // 파일 목록
            Files file = new Files();
            file.setParentTable("board");
            file.setParentNo(no);
            List<Files> fileList = fileService.listByParent(file);

            Map<String, Object> response = new HashMap<>();
            response.put("board", board);
            response.put("fileList", fileList);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping()
    // public ResponseEntity<?> create(@RequestBody Board board) {      // Content-Type : application/json
    public ResponseEntity<?> create(Board board) {                      // Content-Type : multipart/form-data
        try {
            Board newBoard = boardService.insert(board);
            if(newBoard != null) {
                log.info("newBoard 성공");
                return new ResponseEntity<>(newBoard, HttpStatus.OK);
            }
            else {
                log.info("newBoard는 null");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            log.info("newBoard 예외 발생 !!!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping()
    public ResponseEntity<?> update(Board board) {
        try {
            int result = boardService.update(board);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{no}")
    public ResponseEntity<?> delete(@PathVariable("no") int no) {
        try {
            int result = boardService.delete(no);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
