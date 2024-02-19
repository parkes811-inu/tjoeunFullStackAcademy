package DAY12.Ex02_Wrapper;

//2024-02-19 
//MSA 기반 풀스택 교육 12일차

public class DoubleEx {
	public static void main(String[] args) {
		// Double
		// double -> Double
		// : 실수타입인 double 기본타입을 객체화한 클래스
		Double d = 3.14;
		System.out.println( d.toString() + 0.06 );					// 실수형 -> 문자열
		System.out.println( Double.parseDouble("3.14") + 0.06 );	// 문자열 -> 실수형
	}
}
