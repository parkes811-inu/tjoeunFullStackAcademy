package DAY09.Ex01_Computer;

//2024-02-15 
//MSA 기반 풀스택 교육 9일차

// 추상 클래스의 추상 메소드를 구현하지 않으면
// 해당 클래스도 추상클래스로 정의해야 한다.
public abstract class Laptop extends Computer {

	@Override
	public void display() {
		System.out.println("Laptop - display");
	}

//	@Override
//	public void typing() {
//
//		System.out.println("Laptop - typing");
//	}
	

}
