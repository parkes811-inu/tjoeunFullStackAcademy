package DAY03;

//2024-02-02 
//MSA 기반 풀스택 교육 3일차

import java.util.Scanner;

public class Ex08_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1부터 10까지 공백을 두고 출력하시오.
		
		int a = 1;
		
		// while(조건) { 반복 실행문 }
		// - 반복문에는 반드시 종료조건이 성립하도록 작성해야한다.
		// - 종료조건이 만족하지 않는 경우 무한 루프에 빠진다.
		while( a <= 10 ) {
			System.out.print(a++ + " ");
		}
	}

}
