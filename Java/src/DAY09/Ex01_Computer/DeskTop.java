package DAY09.Ex01_Computer;

//2024-02-15 
//MSA 기반 풀스택 교육 9일차

// 부모 클래스의 추상 메소드는 반드시 오버라이딩 해야한다.
public class DeskTop extends Computer {

	@Override
	public void display() {
		System.out.println("Desktop - display");
	}

	@Override
	public void typing() {

		System.out.println("Desktop - typing");
	}

	
}
