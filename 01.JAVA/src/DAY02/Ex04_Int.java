package DAY02;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex04_Int {

	public static void main(String[] args) {
		
		// int 타입은 4byte(64bits)이고, 
		// int의 표현 범위는 -21억xxx ~ 21억xxx까지이다.
		
		// TODO Auto-generated method stub
		// Literal : 프로그램에서 직접적인 표현 값
		
		// 정수 리터럴 
		// 10진수 		: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		//  8진수 		: 0, 1, 2, 3, 4, 5, 6, 7
		//				  * 리터럴 : 0+숫자 	
		// 16진수 		: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F 
		//				  * 리터럴 : 0x숫자
	
		// 10진수
		int var1 = 10;
		System.out.println("var1 : " + var1);
		
		// 8진수
		int var2 = 010;
		System.out.println("var2 : " + var2);
		
		// 16진수
		int var3 = 0x10;
		System.out.println("var3 : " + var3);

	
	}	
}
