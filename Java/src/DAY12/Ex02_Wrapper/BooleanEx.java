package DAY12.Ex02_Wrapper;

//2024-02-19 
//MSA 기반 풀스택 교육 12일차

import java.util.Scanner;

public class BooleanEx {
	public static void main(String[] args) {
		
		// Boolean
		// boolean -> Boolean
		// : 불타입인 boolean 기본타입을 객체화한 클래스
		Integer i = 100;
		Boolean b = (i < 40);
		System.out.println( Boolean.toString(b) + "입니다." );	// "true"
		System.out.println( Boolean.parseBoolean("false") );	// "false" --> false
		
		Scanner sc = new Scanner(System.in);
		boolean check = Boolean.parseBoolean(sc.nextLine());
		if(check) {
			System.out.println("\"true\" 를 입력하였습니다.");
		}
		else {
			System.out.println("\"true\" 가 아닙니다.");
		}
		
		sc.close();
	} 
}
