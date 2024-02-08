package DAY07.Review;

//2024-02-08 
//MSA 기반 풀스택 교육 7일차

import java.util.Scanner;

public class Ex01_multiple {
	
	// main : ctrl + space 
	// main 메소드는 프로그램 실행 시, 가장 먼저 실행되는 메소드
	public static void main(String[] args) {
		// 정수 하나를 입력받아서,
		// 입력받은 수가 3의 배수인지 아닌지,
		// 판단하고 그 여부를 출력하는 프로그램을 작성하시오.
		// 3의 배수 O : "3의 배수입니다."
		// 3의 배수 X : "3의 배수가 아닙니다."
		
		// 1. 정수 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 2. 3의 배수인지 판단	
		if(n % 3 == 0) {
			System.out.println("3의 배수입니다.");
		}
		else {
			System.out.println("3의 배수가 아닙니다.");
		}
		
		sc.close();
	}
}
