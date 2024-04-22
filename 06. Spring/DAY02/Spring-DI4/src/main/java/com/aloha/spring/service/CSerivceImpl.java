package com.aloha.spring.service;

import org.springframework.stereotype.Service;

// Bean 등록 어노테이션("Bean name")
// : * 빈 이름을 지정하지 않으면 클래스명을 기본으로 지정
// 	 * "빈 이름"을 지정하면 @Qualifier("지정한 빈 이름") 으로 타입 기반 주입(빈 이름 지정하여 주입)
@Service("C")
public class CSerivceImpl implements MyService {

	@Override
	public void test() {
		System.out.println("CServiceImpl");
	}

}
