package DAY02;

import java.util.Scanner;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex07_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삼각형의 넓이");
		System.out.println("밑변 : ");
		double width = sc.nextDouble();
		
		System.out.println("높이 : ");
		double height = sc.nextDouble();
		
		// 삼각형의 넓이 구하는 공식
		// (넓이) = (밑변) * (높이) / 2
		double area = width * height / 2;
		System.out.print("넓이 : " + area);
		
		
		sc.close();
		
	}

}
