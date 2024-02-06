package DAY03;

import java.util.Scanner;

public class Ex15_Continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5개의 정수를 입력받아
		// 입력받은 수중 양수(+)만 합계를 구하여 출력하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {

			int num = sc.nextInt();
			if(num < 0) {
				// continue는 남은 실행문을 무시하고, 다음 반복으로 넘어간다.
				continue;
			}
			sum = sum + num;
		}
		System.out.println("양수의 합 : " + sum);
		sc.close();

	}
}
