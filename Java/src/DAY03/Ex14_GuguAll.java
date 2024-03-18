package DAY03;

import java.util.Scanner;

public class Ex14_GuguAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 구구단 ( 1 ~ 9단 )
		// 단에 대한 반복 : 1 ~ 9
		// 각 단의 곱 : 1 ~ 9
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}
			System.out.println("------------" + i + "단 입니다.");
		}
	}
}
