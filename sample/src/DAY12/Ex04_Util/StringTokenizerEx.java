package DAY12.Ex04_Util;

//2024-02-20 
//MSA 기반 풀스택 교육 13일차

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		// StringTokenizer
		// : 구분 문자를 기준으로 문자열을 분리하는 클래스
		// "문자열을 토근화하는 클래스"
		// - 구분 문자 		: (탭) / . 등등
		// - 토큰(Token)		: 구분 문자로 분리된 문자열
		
		String java = "클래스/생성자.상속,오버로딩-오버라이딩,추상클래스,인터페이스";
		StringTokenizer st = new StringTokenizer(java, "/.,-");
	
		
		
		// countTokens() : 분리한 토큰의 개수
		System.out.println("토큰의 개수 : " + st.countTokens());
		
		// 토큰 반복하기
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.print(token + " ");
		}
		System.out.println();
		
		
	}
}
