package DAY03;

import java.util.Scanner;

public class Ex11_DoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 메뉴판						
		// 1. 마라탕
		// 2. 김밥
		// 3. 돈까스
		// 4. 치킨
		
		// 변수 선언 : 메뉴 번호, 메뉴 이름
		int menuNo = 0;
		String menuName = "";
		
		Scanner sc = new Scanner(System.in);

		int cnt = 0;
		
		// do ~ while문
		// : 무조건 1회는 실행 후, 조건을 검사하여 반복하는 문장 
		do {
			System.out.println("#############메뉴판#############");
			System.out.println("1. 맥도날드");
			System.out.println("2. 김밥");
			System.out.println("3. 돈까스");
			System.out.println("4. 짜장면");
			System.out.println("5. 물만난면");
			System.out.println("0. 종료");
			System.out.println("메뉴 번호 : ");
			
			// 메뉴 번호 
			menuNo = sc.nextInt();
			
			if(menuNo != 0) {
				cnt++;
			}
			
			switch (menuNo) {
				case 1: {
					menuName = "맥도날드";
					break;
				}
				case 2: {
					menuName = "김밥";
					break;
				}
				case 3: {
					menuName = "돈까스";
					break;
				}
				case 4: {
					menuName = "짜장면";
					break;
				}
				case 5: {
					menuName = "물만난면";
					break;
				}
			}
			
			// if(menuNo != 0) {
			// System.out.println(menuName + "(을/를) 먹었습니다.");
			// }
		
			// if( menuNo > 0 && menuNo <= 5) {
			// System.out.println(menuName + "(을/를) 먹었습니다.");
			// }
			
			// return 값;
			// 1. 메소드를 종료
			// 2. 메모리 공간 해제
			// 3. (값) 메소드를 호출한 곳으로 반환
			if(menuNo == 0) {
				System.out.println(cnt + " 개의 메뉴를 주문하였습니다.");
				System.out.println("메뉴판을 종료합니다.");
				return;
			}
			else {
				System.out.println("(0 ~ 5)번 사이의 번호를 입력해주세요.");
			}
			
		} while ( menuNo != 0 );
		

		sc.close();
	}

}
