package DAY08.Ex01_Singleton;

import java.util.Scanner;

//2024-02-14 
//MSA 기반 풀스택 교육 8일차

/* 디자인 패턴이란 ? 
 * 디자인 (=설계)
 * 
 * 프로그램 코드를 효율적으로 작성하기 위한 모범 답안
 */

/* 싱글톤 패턴 (Singleton Pattern)
 * - 디자인 패턴 중 하나로, 프로그램이 시작 될 때,
 *   최초로 한 번만 메모리를 할당해서 인스턴스를 사용하는 패턴
 * - 객체가 필요할 때, 새로운 객체를 생성하지 않고, 기존의 인스턴스를 활용하는 코드 패턴
 * - 객체를 하나만 생성하기 때문에, 메모리를 효율적으로 사용할 수 있다.
 */

public class SingleTon {
	
	// static 키워드로 유일한 객체를 생성
	private static SingleTon instance = new SingleTon();
	
	// 외부에서 임의로 객체(Instance)를 생성하지 못하게 private 키워드를 사용해 생성자 정의한다.
	private SingleTon() {
		
	}
	
	// 유일한 객체를 가져오는 메소드 정의
	public static SingleTon getInstance() {
		
		if(instance == null) {
			instance = new SingleTon();
		}
		
		return instance;
	}
	
}
