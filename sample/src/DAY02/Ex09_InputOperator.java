package DAY02;

import java.util.Scanner;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex09_InputOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Scanner sc = new Scanner(System.in);

		System.out.println("x : ");
		int x = sc.nextInt();
		
		System.out.println("y : ");
		int y = sc.nextInt();
		
		System.out.println("z : ");
		int z = sc.nextInt();
		
		// 합계, 평균
		int sum = x + y + z;
		
		// 큰 자료형 + 작은 작료형 = 큰 자료형이 된다.
		// 서로 다른 자료형 연산 시, 결과는 큰 자료형으로 변환된다.
		// (double) = (int) / (int);
		// int는 정수 자로형으로, 실수의 소수부분을 표현할 수 없어 강제 형변환을 해줘야 한다.
		double avg = (double)sum / 3;		// == sum / 3.0;
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
	
		sc.close();
		
	}
}
