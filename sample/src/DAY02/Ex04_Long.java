package DAY02;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex04_Long {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Long 타입은 8byte(64bits)이고, 
		// Long의 표현 범위는 -42억xxx개 ~ 42억xxx개 까지
		
		long ln1 = 1000;
		long ln2 = 2100000000;
		// long 타입 리터럴 : 숫자L
		// ** L을 붙이지 않으면 기본 정수는 int 타입으로 취급한다.
		
		long ln3 = 2200000000L;
		
		System.out.println("ln1 : " + ln1);
		System.out.println("ln2 : " + ln2);
		System.out.println("ln3 : " + ln3);
		
	}

}
