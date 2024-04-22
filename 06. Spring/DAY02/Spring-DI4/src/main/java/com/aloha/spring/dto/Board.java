package com.aloha.spring.dto;

import org.springframework.stereotype.Component;

@Component
public class Board {
	private String title;
	private String writer;
	private String content;
	
	public Board() {
		this.title = "제목없음";
		this.writer = "작성자없음";
		this.content = "내용없음";
	}
	
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}
	
	
	
}
