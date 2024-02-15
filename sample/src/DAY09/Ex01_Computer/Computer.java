package DAY09.Ex01_Computer;

//2024-02-15 
//MSA 기반 풀스택 교육 9일차

public abstract class Computer {
	
	// 추상 메소드를 정의하려면, abstract 키워드를 붙혀야 한다.
	// 추상 메소드를 정의하려면, 클래스도 추상 클래스로 정의해야 한다.
	public abstract void  display();
	public abstract void typing();
	
	public void on() {
		System.out.println("전원을 켭니다.");
	}
	
	public void off() {
		System.out.println("전원을 끕니다.");
	}
	
}
