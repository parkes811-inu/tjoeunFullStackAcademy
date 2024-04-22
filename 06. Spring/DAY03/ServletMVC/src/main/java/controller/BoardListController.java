package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardListController {

	private BoardService boardService = new BoardServiceImpl();
	
	public String process(HttpServletRequest request) throws Exception {
		List<Board> boardList = boardService.list();
		request.setAttribute("boardList", boardList);
		String view = "/board/list.jsp";
		return view;
	}
}