package DAY01;


//2024-01-31 
//MSA 기반 풀스택 교육 1일차
// Token : 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


import java.util.Scanner;
// import : 외부 클래스를 포함시키기
// import 패키지명.클래스명;

//[import 하는 방법]
// 1. 클래스| 	 : ctr + space
// 2. 전체 import	 : ctr + shift + O

public class Ex02_Scanner {

	public static void main(String[] args) {
		
		// (에러)			- 빨간색 밑줄로 표시된 라인 
		//				- 에러가 발생하면, 프로그램 실행이 불가능하다.
		
		// (경고) 		- 노란색 밑줄로 표시된 라인
		// 				- 경고가 발생해도 프로그램은 실행이 가능하다.
		
		
		// TODO Auto-generated method stub
		// 객체 생성 키워드 : new
		// 클래스타입 객체명 = new 클래스명();
		// Scanner : 표준 입력 객체
		Scanner sc = new Scanner(System.in);
		
		System.out.println("a : ");
		int a = sc.nextInt();
		
		System.out.println("a : " + a);
		
		// close() : Scanner 객체를 메모리에서 해제하는 메소드
		sc.close();
		
		// sc.nextInt();
		// Scanner 객체를 해제한 후에는 더이상 입력을 받을 수 없다.
		
		// 주석(indentent) : 프로그램에 영향이 없는 메모 (코드 설명, 기록 등)
		// 주석 사용 방법 : ctr + /, ctr + shift + C
		// 코드 이동 : alt + ↑/↓
				
	}

}
