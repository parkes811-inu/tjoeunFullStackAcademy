package DAY02;

import java.util.Scanner;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex08_Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 상수 : 프로그램 실행 동안 값을 변경하지 않고 사용할 값
		// * 상수 선언 시, 반드시 값을 초기화 해야한다.
		// * 선언 후에 값을 변경하면 에러가 발생한다.
		// 키워드 : final
		final double PI = 3.141592;
		
		// PI = 3.14; 		// -> PI 상수 선언 후 값을 변경하려고 해서 에러가 발생
		Scanner sc = new Scanner(System.in);
		// 원의 넓이 = (원주율) * (반지름)^2
		System.out.println("반지름 : ");
		double radius = sc.nextDouble();
		double area = PI * radius * radius;
		
		System.out.println("원의 넓이 : " + area);
		sc.close();
	}

}
