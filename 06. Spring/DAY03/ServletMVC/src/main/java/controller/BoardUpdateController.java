package controller;

import javax.servlet.http.HttpServletRequest;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardUpdateController {
	private BoardService boardService = new BoardServiceImpl();

	public String process(HttpServletRequest request) throws Exception {
		String reqNo = request.getParameter("no");
		int no = reqNo == null ? 0 : Integer.parseInt(reqNo);
		Board board = boardService.select(no);
		request.setAttribute("boardRead", board);
		String view = "/board/update.jsp";
		return view;
	}
}