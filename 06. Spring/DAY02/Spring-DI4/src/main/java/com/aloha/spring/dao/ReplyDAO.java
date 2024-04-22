package com.aloha.spring.dao;

import org.springframework.stereotype.Repository;

// DAO 역할로 빈 등록
@Repository
public class ReplyDAO extends BoardDAO {
	public void test() {
		System.out.println("ReplyDAO");
	}
}
