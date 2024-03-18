package DAY03;

import java.util.Scanner;

//2024-02-02 
//MSA 기반 풀스택 교육 3일차

public class Ex02_IfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		// 입력받은 값이 홀수인지, 짝수인지 판단하시오.
		// 홀수, 짝수 조건?
		if(num % 2 != 0) {
			System.out.println("홀수입니다.");
		}
		else {
			System.out.println("짝수입니다.");
		}
		sc.close();

	}

}
