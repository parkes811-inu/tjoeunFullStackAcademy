package controller;

import javax.servlet.http.HttpServletRequest;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardInsertController {
	
	public String process(HttpServletRequest request) throws Exception {
		String view = "/board/insert.jsp";
		return view;
	}
}