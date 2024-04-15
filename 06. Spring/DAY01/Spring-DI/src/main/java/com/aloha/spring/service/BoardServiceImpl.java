package com.aloha.spring.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class BoardServiceImpl implements BoardService {
	
	// BoardServiceImpl --> BoardDAO에 의존
	private BoardDAO boardDAO;
	
	// 의존성 자동 주입
	// - BoardDAO 빈을 참조한다면,
	// <bean><constructor-arg ref="baordDAO(참조할 빈)"/></bean>
	@Autowired
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
//	@Autowired
//	public BoardServiceImpl(int test) {
//		this.test = test;
//	}
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Override
	public List<Board> list() {
	    logger.info("BoardDAO injected: " + (boardDAO != null));
	    if (boardDAO == null) {
	        logger.error("BoardDAO is null");
	        return Collections.emptyList(); // 또는 적절한 예외 처리
	    }
	    return boardDAO.list();
	}
}
