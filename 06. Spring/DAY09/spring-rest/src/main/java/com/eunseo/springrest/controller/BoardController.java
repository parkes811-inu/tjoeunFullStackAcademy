package com.eunseo.springrest.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eunseo.springrest.dto.Board;
import com.eunseo.springrest.service.BoardService;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    // Controller --> Service   (데이터 요청)
    // Controller <-- Service   (데이터 전달)
    // Controller --> Model     (모델 등록)
    // View <-- Model           (데이터 출력)
    
    @Autowired                          // 의존성 자동 주입
    private BoardService boardService;  // @Service를 boardServiceImpl에 등록했기 때문에
    
    /**
     * 게시글 목록
     * [GET]
     * /board/list
     * - model : boardList
     * @param model
     * @return
     * @throws Exception 
     */
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        log.info("[GET] - /board/list");

        // 데이터 요청
        List<Board> boardList = new ArrayList<>();
        boardList = boardService.list();
        
        // 모델 등록
        model.addAttribute("boardList", boardList);

        // 뷰 페이지 지정
        return "/board/list";   // /board/list.html
    }
    
    /**
     * 게시글 조회
     * [GET]
     * /board/read?no=?
     * - model : board
     * @param model
     * @param no
     * @return
     * @throws Exception 
     * 
     * @RequestParam("파라미터명")
     * - 스프링 부트 3.2 버전 이하, 생략해도 자동 매핑이 가능
     * - 스프링 부트 3.2 버전 이상, 필수로 @RquestParam을 명시해야 함.
     */
    @GetMapping("/read")
    public String select(Model model, @RequestParam("no") int no) throws Exception {
        log.info("[GET] - /board/read");

        // 데이터 요청
        //Board board = new Board(no, "제목", "김은식", "내용");
        Board board = boardService.select(no);
        // 모델 등록
        model.addAttribute("board", board);

        // 뷰 페이지 지정
        return "/board/read";   // //board/read.html
    }

    /**
     * 게시글 등록 화면
     * @return
     */
    @GetMapping("/insert")
    public String insert() {
        log.info("[GET] - /board/insert");

        return "/board/insert";   // //board/insert.html
    }

    /**
     * 게시글 수정
     * [GET]
     * /board/uppdate?no=?
     * - model : board
     * @param model
     * @param no
     * @return
     * @throws Exception 
     */
    @GetMapping("/update") 
    public String update(Model model, @RequestParam("no") int no) throws Exception {
        log.info("[GET] - /board/update");

        // 데이터 요청
        // Board board = new Board(no, "제목", "김은식", "내용");
        Board board = boardService.select(no);

        // 모델 등록
        model.addAttribute("board", board);

        // 뷰 페이지 지정
        return "/board/update";   // //board/uppdate.html
    }

    /**
     * 게시글 쓰기 처리
     * [POST]
     * /board/insert
     * model : ❌
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        log.info("[POST] - /board/insert");
        log.info(board.toString());
        
        // 데이터 처리
        int result = boardService.insert(board);

        // 게시글 쓰기 실패 ➡ 게시글 쓰기 화면
        if( result == 0 ) return "redirect:/board/insert?error";

        // 뷰 페이지 지정
        return "redirect:/board/list";
    }

    /**
     * 게시글 수정 처리
     * [POST]
     * /board/update
     * model : board
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {
        log.info("[POST] - /board/update");
        log.info(board.toString());

        // 데이터 처리
        int result = boardService.update(board);

        // 게시글 수정 실패 ➡ 게시글 수정 화면
        if( result == 0 ) return "redirect:/board/update?no=" + board.getNo() + "&error";
        
        // 뷰 페이지 지정
        return "redirect:/board/list";
    }    

    /**
     * 게시글 삭제 처리
     * [POST]
     * /board/delete
     * model : ❌
     * @param boardNo
     * @return
     * @throws Exception
     */
    @PostMapping("/delete")
    public String deletePro(Board board) throws Exception {
        log.info("[POST] - /board/delete");
        int no = board.getNo();
        log.info(no + "번 글을 삭제합니다.");
        
        // 데이터 처리
        int result = boardService.delete(no);
        
        // 게시글 삭제 실패 ➡ 게시글 수정 화면
        if( result == 0 ) return "redirect:/board/update?no=" + no;

        // 뷰 페이지 지정
        return "redirect:/board/list";
    }

    // 게시글 수정 처리 - [PUT]
    @PutMapping("")
    public ResponseEntity<String> PutUpdate(Board board) throws Exception {
        log.info("[PUT] - /board");
        log.info(board.toString());

        // 게시글 수정 처리
        int result = boardService.update(board);

        if( result == 0 ) return new ResponseEntity<>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
        
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
    
    // 게시글 삭제 처리 - [DELETE]
    @DeleteMapping("")
    public ResponseEntity<String> Delete(@RequestParam("no") int no) throws Exception {
        log.info("[DELETE] - /board?no=10");
        log.info(no + " 번 게시글 삭제합니다.");

        // 게시글 삭제 처리
        int result = boardService.delete(no);

        if( result == 0 ) return new ResponseEntity<>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
        
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}