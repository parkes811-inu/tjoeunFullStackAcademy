package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;
import controller.ModelView;


// /board 경로로 요청이 오면, 처리하는 컨트롤러
public class BoardController {
   
   private BoardService boardService = new BoardServiceImpl();
   
   public ModelView process(HttpServletRequest request) throws Exception {
      String requserURI = request.getRequestURI();
      ModelView modelView = new ModelView();
      
      // 게시글 목록 - /board/list/do
      if( requserURI.contains("list.do") ) {
         list(modelView);
      }
      
      // 게시글 조회- /board/read/do
      if( requserURI.contains("read.do") ) {
         read(modelView, request);
      }
      
      // 게시글 등록
      if( requserURI.contains("insert.do") ) {
         insert(modelView);
      }
      
      // 게시글 등록 처리
      if( requserURI.contains("insertPro.do") ) {
         insertPro(modelView, request);
      }
      
      // 게시글 수정
      if( requserURI.contains("update.do") ) {
         update(modelView, request);
      }
      
      // 게시글 수정 처리
      if( requserURI.contains("updatePro.do") ) {
         updatePro(modelView, request);
      }
      
      // 게시글 삭제 처리
      if( requserURI.contains("deletePro.do") ) {
         deletePro(modelView, request);
      }
      
      return modelView;
      
   }
   

   // 게시글 목록
   private void list(ModelView modelView) throws Exception {
      List<Board> boardList = boardService.list();
      // 모델
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("boardList", boardList);
      //뷰
      String view = "/board/list.jsp";
      modelView.setModel(model);
      modelView.setView(view);
      
   }
   
   // 게시글 조회
   private void read(ModelView modelView, HttpServletRequest request) throws Exception {
      String reqNo = request.getParameter("no");
      int no = reqNo == null ? 0 : Integer.parseInt(reqNo);
      Board board= boardService.select(no);
      // 모델
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("board", board);
      //뷰
      String view = "/board/read.jsp";
      modelView.setModel(model);
      modelView.setView(view);
      
   }
   
   // 게시글 등록
   private void insert(ModelView modelView) {
      String view = "/board/insert.jsp";
      modelView.setView(view);
   }
   
   // 게시글 등록 처리
   private void insertPro(ModelView modelView, HttpServletRequest request) throws Exception {
      
         String title = request.getParameter("title");
         String writer = request.getParameter("writer");
         String content = request.getParameter("content");
         
         Board board = new Board(title, writer, content);
         int result = boardService.insert(board);
         
         // 모델
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("result", result);

         // 뷰
         String view = "/board/list.do";
         
         modelView.setModel(model);
         modelView.setView(view);
         modelView.setRedirect(true);
      }
   
   // 게시글 수정
   private void update(ModelView modelView, HttpServletRequest request) {
      
      String reqNo = request.getParameter("no");
      int no = reqNo == null ? 0 : Integer.parseInt(reqNo);
      Board board = boardService.select(no);
      
      // 모델
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("board", board);

      // 뷰
      String view = "/board/update.jsp";
      modelView.setModel(model);
      modelView.setView(view);
   }
   
   // 게시글 수정 처리
   private void updatePro(ModelView modelView, HttpServletRequest request) throws Exception {
         
      String reqNo = request.getParameter("no");
      int no = reqNo == null ? 0 : Integer.parseInt(reqNo);
      
      String title = request.getParameter("title");
      String writer = request.getParameter("writer");
      String content = request.getParameter("content");
      
      Board board = new Board(title, writer, content);
      board.setNo(no);
      int result = boardService.update(board);
      
      // 모델
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("result", result);

      // 뷰
      String view = "/board/list.do";
      modelView.setModel(model);
      modelView.setView(view);
      modelView.setRedirect(true);
   }
   
   // 게시글 수정 처리
   private void deletePro(ModelView modelView, HttpServletRequest request) throws Exception {
         
      String reqNo = request.getParameter("no");
      int no = reqNo == null ? 0 : Integer.parseInt(reqNo);
      int result = boardService.delete(no);
      
      // 모델
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("result", result);

      // 뷰
      String view = "/board/list.do";
      modelView.setModel(model);
      modelView.setView(view);
      modelView.setRedirect(true);
   }
         
      
   
}
