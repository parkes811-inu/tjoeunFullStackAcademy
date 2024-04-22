package com.aloha.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
    private int no;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    private int views;
    
    public Board() {
        
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
    
}