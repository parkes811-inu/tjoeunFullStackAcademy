package DAY03;

import java.util.Scanner;
//2024-02-02 
//MSA 기반 풀스택 교육 3일차
public class Ex07_SwitchBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		
		int num = sc.nextInt();
		
		// 입력 받은 정수를 5로 나눈 나머지가 
		// 2보다 작으면 "*" 출력
		// 그렇지 않으면 "**" 출력
		// - switch 문을 사용하여 작성하시오.
		
		switch (num % 5) {
		case 0: 
		case 1: {
			System.out.println("*");
			break;
		}
		default:
			System.out.println("**");
			break;
		}
		
		sc.close();

	}

}
