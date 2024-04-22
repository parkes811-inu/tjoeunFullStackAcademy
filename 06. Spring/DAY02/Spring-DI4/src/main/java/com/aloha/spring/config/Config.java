package com.aloha.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aloha.spring.dto.Board;

// 빈 설정 클래스로 지정
@Configuration
public class Config {
	
	// 빈 등록 메소드로 지정
	@Bean
	public Board getBoard() {
		return new Board("제목 있음", "작성자 있음", "내용 있음");
	}
}
