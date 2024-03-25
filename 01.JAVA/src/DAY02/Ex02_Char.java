package DAY02;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex02_Char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 리터럴(Literal) : 소스코드에 표기하는 데이터(숫자인지, 문자인지, 문자열인지)
		// 문자 데이터 : char
		char c1 = 'A';			// 문자 리터럴 : 'A' (작은 따옴표)로 표기
		char c2 = 65; 			// 십진수 --> ASCII 코드에 매핑된 문자 'A'
		char c3 = '\u0041';		// 유니코드로 지정
		
		char c4 = '가';		
		char c5 = 44032;		
		char c6 = '\uac00';
		
		// char 자료형 b에 문자열 65 + (int) 1 연산이 실행 되기 때문에
		// (char) + (int) = int 형으로 자동 형변환이 발생해 오류가 발생한다.
		// char b = (c2 + 1); 			// 자동 형변환
		// char b = (char) (c2 + 1);	// 강제 형변환 	
		
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		System.out.println("c3 : " + c3);
		System.out.println("c4 : " + c4);
		System.out.println("c5 : " + c5);
		System.out.println("c6 : " + c6);
		
	}
}


