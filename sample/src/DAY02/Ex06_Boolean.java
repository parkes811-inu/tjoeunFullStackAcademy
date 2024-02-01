package DAY02;

import java.util.Scanner;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex06_Boolean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean check1 = false;
		boolean check2 = true;
		
		Scanner sc = new Scanner(System.in);
		
		// 논리값(true, false)를 입력받는 메소드 
		boolean on = sc.nextBoolean();		
		sc.close();

		System.out.println("on : " + on);
		
		// 조건에 따라 프로그램에 실행을 제어하는 조건문
		if(on) {
			System.out.println("Power On");
		}
		else {
			System.out.println("Power Off");
		}
		
	}
}
