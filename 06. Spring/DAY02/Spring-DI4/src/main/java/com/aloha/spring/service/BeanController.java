package com.aloha.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloha.spring.config.Config;
import com.aloha.spring.dto.Board;

@Controller
public class BeanController {
	
	// @RequestMapping
	// bean으로 요청이 오면 실행되는 메소드로 지정
	@RequestMapping(value= "/bean", method = RequestMethod.GET)
	public String bean(Model model) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.aloha.spring"); // 패키지 이름 지정
		Board board = context.getBean(Board.class);
		
		//  자바 빈 설정 파일로 컨텍스트 객체 생성
		ApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);
		Board baord2 = context.getBean(Board.class);
		model.addAttribute("board2", board);
		return "bean";
	}
	
	
}
