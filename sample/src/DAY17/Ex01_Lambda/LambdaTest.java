package DAY17.Ex01_Lambda;

//2024-02-26 
//MSA 기반 풀스택 교육 17일차

/**
 *  익명 객체
 * 	- 익명 자식 객체
 * 	- 익명 구현 객체
 * 
 *  익명 함수
 * 	 
 *  ** 익명 자식 객체 VS 익명 구현 객체 VS 익명 함수
 */

// 익명 자식 객체의 부모 클래스 정의
class Television {
	void volumeUp() { System.out.println("UP"); };
	void volumeDown() { System.out.println("DOWN"); };
}

// 익명 구현 객체의 인터페이스 정의
interface RemoteControl {
	void volumeUp();
	void volumeDown();
}

// 함수형 인터페이스 정의
@FunctionalInterface
interface Calculator {
	int calc(int a, int b);
	
	// 함수형 인터페이스는 추상메소드가 2개 이상 존재하면 에러가 발생된다.
	// Error: double calc(int a, int b);
}

public class LambdaTest {
	public static void main(String[] args) {
		
		// 익명 자식 객체
		Television tv = new Television() {

			@Override
			void volumeUp() {
				System.out.println("UP - 구현");
			}

			@Override
			void volumeDown() {
				System.out.println("DOWN - 구현");
			}
		};
		tv.volumeUp();
		tv.volumeDown();
		
		// 익명 구현 객체
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void volumeUp() {
				System.out.println("UP - 구현");
			}
			
			@Override
			public void volumeDown() {
				System.out.println("DOWN - 구현");
			}
		};
		
		rc.volumeUp();
		rc.volumeDown();
		
		// 익명 구현 객체2 
		Calculator cal = new Calculator() {
			
			@Override
			public int calc(int a, int b) {
				return a + b;
			}
		};
		
		int result1 = cal.calc(10, 20);
		System.out.println("result1 : " + result1);
		
		// 람다식
		Calculator calcLambda = (a, b) -> { return a + b; };
		int result2 = cal.calc(30, 40);
		System.out.println("result1 : " + result2);
	}
}
