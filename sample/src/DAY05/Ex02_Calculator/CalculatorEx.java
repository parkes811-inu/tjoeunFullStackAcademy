package DAY05.Ex02_Calculator;

//2024-02-06 
//MSA 기반 풀스택 교육 5일차

import java.util.Scanner;

public class CalculatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator = new Calculator();
		// int a = 10; int b = 20;
		Scanner sc = new Scanner(System.in);
		System.out.println(" a : ");
		int a = sc.nextInt();
		System.out.println(" b : ");
		int b = sc.nextInt();
		
		System.out.println(" x : ");
		double x = sc.nextDouble();
		System.out.println(" y : ");
		double y = sc.nextDouble();
		sc.close();
		int scores[] = {10, 20, 30, 40, 50};
		
		// 덧셈 메소드 호출
		System.out.println("a + b : " + calculator.plus(a, b));
		
		// 뺄셈 메소드 호출
		System.out.println("a - b : " + calculator.minus(a, b));
		
		// 곱셈 메소드 호출
		System.out.println("a * b : " + calculator.multiple(x, y));
		System.out.printf("a * b = %5.2f\n", calculator.multiple(x, y));
		
		// 나눗셈 메소드 호출
		System.out.println("a / b : " + calculator.divide(x, y));
		System.out.printf("a / b = %5.2f\n", calculator.divide(x, y));
		
		// 나머지 메소드 호출
		System.out.println("a % b : " + calculator.remain(x, y));
		
		// 합계 메소드 호출
		System.out.println("Sum 연산의 결과는 : " + calculator.sum(scores));
		
		// 평균 메소드 호출
		System.out.println("Avg 연산의 결과는 : " + calculator.avg(scores));
	}

}
