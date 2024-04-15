package com.aloha.spring.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 서비스 역할을 하는 Bean으로 등록
@Service
public class BoardServiceImpl implements BoardService {
	
	// BoardServiceImpl --> BoardDAO에 의존
	@Autowired
	private BoardDAO boardDAO;
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
