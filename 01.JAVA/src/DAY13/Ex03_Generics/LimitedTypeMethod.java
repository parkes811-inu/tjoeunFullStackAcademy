package DAY13.Ex03_Generics;

//2024-02-21 
//MSA 기반 풀스택 교육 14일차

public class LimitedTypeMethod {
	// 제네릭 메소드 타입 제한
	// Number : 자식 클래스 ( Integer, Double 등 숫자 관련 클래스 )
	public <T extends Number> void method(T t) {
		
		System.out.println(t.intValue());
		System.out.println(t.doubleValue());
	}
	
	public static void main(String[] args) {
		LimitedTypeMethod ltm = new LimitedTypeMethod();
		
		
		ltm.method(1234);
		ltm.method(12.34);
		// (에러) ltm.method("1234");
		// 문자열은 Number 클래스의 자식 클래스가 아니므로 에러가 발생한다.
	}
}
