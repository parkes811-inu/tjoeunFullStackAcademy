package DAY12.Ex04_Util;

//2024-02-20 
//MSA 기반 풀스택 교육 13일차

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerSum {
	public static void main(String[] args) {
		// "1", "2", "3", "4", "5"
		// "," ---> 분리 : 1, 2, 3, 4, 5 (String)
		// 토큰을 int 타입으로 변환
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(input, ",");
		int sum = 0;
		
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			sum = sum + num;
		}
		
		
		System.out.println("합계 : " + sum);
		sc.close();
	}
}
