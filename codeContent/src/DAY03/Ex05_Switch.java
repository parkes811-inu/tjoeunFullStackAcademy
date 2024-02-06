package DAY03;

import java.util.Scanner;

//2024-02-02 
//MSA 기반 풀스택 교육 3일차

public class Ex05_Switch {
	
	// switch 문 : switch(조건)과 case 로 나뉘는 구문
	// 조건값이 case가 일치될 때 문장들이 실행된다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("채널을 선택하세요.");
		int channel = sc.nextInt();
		
		switch (channel) {
		case 11: {
			System.out.println("MBC - 나혼자 산다");
			break;
		}
		case 7: {
			System.out.println("KBS - 1박 2일");
			break;
		}
		case 6: {
			System.out.println("SBS - 런닝맨");
			break;
		}
		case 100: {
			System.out.println("TVING - 환승연애");
			break;
		}
		default:
			System.out.println("요청하신 채널이 없습니다.");
			break;
		}
		sc.close();
	}
}
