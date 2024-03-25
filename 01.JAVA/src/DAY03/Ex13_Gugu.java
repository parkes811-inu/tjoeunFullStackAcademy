package DAY03;

import java.util.Scanner;

public class Ex13_Gugu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 구구단 ( 1 ~ 9단 )
		// 원하는 단을 입력받아 아래와 같이, 구구단 수식을 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i < 10; i++) {
			System.out.println( num + "*" + i + "=" + num * i );
		}
		
		sc.close();
	}

}
