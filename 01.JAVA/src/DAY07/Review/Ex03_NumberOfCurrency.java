package DAY07.Review;

//2024-02-08 
//MSA 기반 풀스택 교육 7일차

import java.util.Scanner;

/*
 * 더조은컴퓨터 아카데미에서 김조은 대리를 출장보낸다. 
 * 이 때, 출장비를 다음과 같이 지급한다.
 * 출장비 : 537,620
 * 
 * 50,000		: 10개
 * 10,000		: 3개	
 * 5,000		: 1개
 * 1,000		: 2개
 * 500			: 1개
 * 100			: 1개
 * 50			: 0개
 * 10			: 2개
 * 5			: 0개
 * 1			: 0개
 *  
 * 위와 같이 입력하면, 큰 화폐부터 계산하여, 화폐단위별로 화폐매수를 출력하는 프로그램을 작성하시오. 
 */

public class Ex03_NumberOfCurrency {

	public static void main(String[] args) {
		
		/* 
		   수도 코드 작성
		  
		   1. 필요한 변수 선언
		    - (입력금액), (화폐매수), (화폐단위)
		   
		   2. (입력금액) 입력
		   
		   3. 화폐매수 계산
		    [조건] : 큰 화페단위부터 계산한다.
		     3-1. 화폐매수 계산 수식
		       10  =  537620  /  50000
		     (화폐매수) = (입력금액) / (화폐단위)
		 
		     3-2. 잔액 계산
		      (잔   액) = 537620 - 50000 = 37620
		      i) (잔  액) = (입력금액) - ((화폐단위) * (화폐매수))
		      ii) (잔  액) = (입력금액) % (화폐단위)
		     
		     3-3. 화폐단위 변환
		         번갈아 가면서, /5, /2 연산을 반복한다.
		         (화폐단위) = (화폐단위) / 5
		         (화폐단위) = (화폐단위) / 2
		            		  
		    4. 3번의 과정을 반복
		     - 반복 조건 : (화폐단위)가 1보다 크거나 같으면 반복
		    
		    5. 3-1 과정에서 화폐매수를 출력한다. 
		 */
		
		// 1번째 방법
//		int input, count, money = 50000;
//		// 입력금액 입력
//		System.out.println("출장비 : ");
//		Scanner sc = new Scanner(System.in);
//		input = sc.nextInt();
//		boolean sw = true;
//		
//		while(money >= 1) {
//			// 화폐매수 계산
//			count = input / money;
//			System.out.println(money + "\t : " + count + " 개");
//			
//			// 잔액 계산
//			input = input - (money * count);
//			// input = input % money;
//			
//			// 화폐단위 변환
//			if(sw)
//				money = money / 5;
//			else 
//				money = money / 2;
//			sw = !sw;
//		}
//		
//		sc.close();
		
		
		// 2번째 방법 
		Scanner sc = new Scanner(System.in);
		System.out.println("출장비 : ");
		int price = sc.nextInt();
		
		int money[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1}; 
		
		for(int i = 0; i < 10; i++) {
			int cnt = 0;
			if(price >= money[i]) {
				while(price >= money[i]) {
					price = price - money[i];
					cnt++;
				}
			}
			System.out.println(money[i] + "원	" + cnt + "개");
		}
		sc.close();
	}
}
