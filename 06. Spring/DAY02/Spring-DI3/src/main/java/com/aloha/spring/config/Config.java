package com.aloha.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aloha.spring.dto.Board;

@Configuration
public class Config {
	
	@Bean
	public Board board() {
		return new Board("제목", "작성자", "내용");
	}
}
