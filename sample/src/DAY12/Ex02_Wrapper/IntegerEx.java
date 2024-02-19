package DAY12.Ex02_Wrapper;

//2024-02-19 
//MSA 기반 풀스택 교육 12일차

public class IntegerEx {
	public static void main(String[] args) {
		// int -> Integer
		// : 정수 타입인 int 기본 타입을 객체화한 클래스
		int a = 10;
		Integer A = 100;
		
		// * 주요 메소드
		// 문자열 --> 정수
		// 정수 --> 문자열
		// 정수 --> 다른 타입
		
		// 문자열을 정수 타입으로 변경해주는 parseInt() 메소드
		System.out.println(Integer.parseInt("28"));
		
		// 정수를 문자열 타입으로 변경해주는 toString() 메소드
		System.out.println(Integer.toString(28) + 2);
		
		// 정수를 더블 타입으로 변경해주는 doubleValue() 메소드
		System.out.println(A.doubleValue() + 2.5);
		
		// 정수를 2진수 타입으로 변경해주는 toBinaryString() 메소드
		System.out.println(Integer.toBinaryString(28));
		
		// 정수를 2진수 타입으로 변경하고, 1인 bit를 세는 bitCount() 메소드
		System.out.println(Integer.bitCount(28));
		
		// deprecated 
		// : 더 이상 사용을 권장하지 않는 문법
		// * Auto Boxing 
		// : 자바 5버전 부터는 객체로 생성하여 사용하지 않아도 자동으로 객체로 감싸준다.
		// Integer i = new Integer(8);
		Integer i = 10; 			// Auto Boxing
		int value = i.intValue();	// UnBoxing
		
		System.out.println("객체로 생성한 Integer : " + i);
		System.out.println("기본 타입 int : " + value);
		
		
	}
}
