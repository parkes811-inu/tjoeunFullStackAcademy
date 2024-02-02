package DAY03;

import java.util.Scanner;

public class Ex16_Break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		
		// 무한 루프
		// 반복문 사용 시 반드시 종료조건을 추가해줘야 한다.
		while (true) {
			System.out.println("입력 : ");
			String str = sc.nextLine();  	//	문자열 한 줄 입력받는 메소드

			// 문자열.equals("비교문자열")
			// - 문자열이 비교 문자열과 일치하는지 여부를 알려주는 메소드 (반환값은 true, false)
			if(str.equals("STOP")) {
				break;
			}
			
			System.out.println(">> " + str);
		}
		
		sc.close();
	}
}
