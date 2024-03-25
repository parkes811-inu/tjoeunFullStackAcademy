package DAY06.Ex03_PassingArgument;

//2024-02-07 
//MSA 기반 풀스택 교육 6일차

public class CallByValue {
	
	// 메소드 정의
	// - 접근지정자 (static) 반환타입 메소드명(매개변수)
	public static int sum(int a, int b) {
		a = 100;
		b = 200;
		int sum = a + b;
		System.out.println("---------- sum() 메소드 ----------");
		System.out.println("(a, b) : " + a + ", " + b);
		return sum;
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println("---------- main() 메소드 ----------");
		System.out.println("(a, b) : " + a + ", " + b);
		
		// 값에 의한 호출 : Call By Value
		// - 기본 자료형을 인자로 전달하는 방식
		int sum = sum(a, b);
		System.out.println("sum : " + sum);
		System.out.println("---------- sum() 메소드 호출 후 ----------");
		System.out.println("(a, b) : " + a + ", " + b);
	}
}
