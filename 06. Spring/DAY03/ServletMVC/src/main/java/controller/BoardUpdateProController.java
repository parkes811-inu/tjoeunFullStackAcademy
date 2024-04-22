package controller;

import javax.servlet.http.HttpServletRequest;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardUpdateProController {

	private BoardService boardService = new BoardServiceImpl();
	
	public String process(HttpServletRequest request) throws Exception {
		String reqNo = request.getParameter("no");
		int no = reqNo == null ? 0 : Integer.parseInt(reqNo);
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board(title, writer, content);
		board.setNo(no);
		
		int result = boardService.update(board);
		request.setAttribute("result", result);
		String view = "/board/list.do";
		return view;
	}
}