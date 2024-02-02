package DAY03;

import java.util.Scanner;

//2024-02-02 
//MSA 기반 풀스택 교육 3일차

public class Ex04_Nested {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학년 : ");
		int year = sc.nextInt();
		
		System.out.println("점수 : ");
		int score = sc.nextInt();
		
		
		// 중첩 조건문 Nested 구문이란
		// if문과 같은 조건문 내 조건문이 중첩되어서 존재하는 경우
		
		if(year == 4 && score >= 60) {
			System.out.println("합격");
		}
		else if(year == 4 && score < 60) {
			System.out.println("불합격");
		}
		else {
			System.out.println("응시자격 요건에 해당되지 않습니다.");
		}

		
	}
}
