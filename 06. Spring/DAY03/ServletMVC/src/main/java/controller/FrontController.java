package controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardController;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
   
   private static final long serialVersionUID = 1L;
   
   public FrontController() {
      super();
   }

   // doGet(): GET 메소드 방식으로 요청이 왔을 때 실행되는 메소드
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // jsp 응답하기
      String view = "index.jsp";
      boolean redirect = false;
      ModelView modelView = null;
      
      // 요청 정보 확인
      String requestURI = request.getRequestURI();
      String pathInfo = request.getPathInfo();
      StringBuffer requestURL = request.getRequestURL();
      System.out.println("요청 URL : " + requestURI);
      System.out.println("requestURL : " + requestURL.toString());
      System.out.println("pathInfo : " + pathInfo);
      
      // 컨트롤러 선택
      if( requestURI.contains("/board") ) {
         BoardController boardController = new BoardController();
         
         try { modelView = boardController.process(request);
         } catch (Exception e) {
            e.printStackTrace();
         }
         view = modelView.getView();
         redirect = modelView.isRedirect();
         
      }
      
      // 모델 등록
       createModel(modelView, request);
      
//      // 컨트롤러 선택
//      if( requestURI.contains("/board/list.do")) {
//         BoardListController boardListController = new BoardListController();
//         try {
//            view = boardListController.process(request);
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
//      }
//      
//      // 컨트롤러 선택
//      if( requestURI.contains("/board/read.do")) {
//         BoardReadController boardReadController = new BoardReadController();
//         try {
//            view = boardReadController.process(request);
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
//      }
//      
//      // 컨트롤러 선택
//      if( requestURI.contains("/board/insert.do")) {
//         BoardInsertController boardInsertController = new BoardInsertController();
//         try {
//            view = boardInsertController.process(request);
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
//      }
//      
//      // 컨트롤러 선택
//      if( requestURI.contains("/board/insertPro.do")) {
//         BoardInsertProController boardInsertProController = new BoardInsertProController();
//         try {
//            view = boardInsertProController.process(request);
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
//         redirect = true;
//      }
//      
//      // 컨트롤러 선택
//      if( requestURI.contains("/board/update.do")) {
//         BoardUpdateController boardUpdateController = new BoardUpdateController();
//         try {
//            view = boardUpdateController.process(request);
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
//      }
//            
//      // 컨트롤러 선택
//      if( requestURI.contains("/board/updatePro.do")) {
//         BoardUpdateProController boardUpdateProController = new BoardUpdateProController();
//         try {
//            view = boardUpdateProController.process(request);
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
//         redirect = true;
//      }
//      
//      // 컨트롤러 선택
//      if( requestURI.contains("/board/delete.do")) {
//         BoardDeleteController boardDeleteController = new BoardDeleteController();
//         try {
//            view = boardDeleteController.process(request);
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
//         redirect = true;
//      }

      
      // 페이지 이동
      // 1. redirectO
      // 2. forward
      if( redirect ) {
         response.sendRedirect(request.getContextPath() + view);
      }
      else {
         RequestDispatcher dispatcher = request.getRequestDispatcher(view);
         dispatcher.forward(request, response);
      }
   }

   // doPost(): POST 메소드 방식으로 요청이 왔을 때 실행되는 메소드
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
   
   /**
    * 모델 등록 메소드
    * @param modelView
    * @param request
    */
   public void createModel(ModelView modelView, HttpServletRequest request) {
      if( modelView == null ) return;
      Map<String, Object> model = modelView.getModel();
      
      if( model == null ) return;
   
      Set<String> keySet = model.keySet();
      for (String key : keySet) {
         Object value = model.get(key);
         request.setAttribute(key,value);
      }
      // Board board = boardService.select(10);
      // request.setAttribute("board", board);
   }
   
}