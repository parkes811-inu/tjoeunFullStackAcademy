package DAY04;

import java.util.Scanner;

//2024-02-05 
//MSA 기반 풀스택 교육 4일차
public class Ex03_Min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 첫째 줄에 입력할 개수 N 입력 받고, 
		// 둘째 줄에 N 개의 정수를 공백을 두고 입력받으시오.
		// N 개의 정수 중, 최솟값을 출력하시오.
		// (입력예시)
		// 5
		// 90 60 70 100 55
		// (출력예시)
		// 최솟값 : 55
		
		// (순서도)
		// 1. 정수 하나를 입력받아 변수 N에 대입한다.
		// 2. N번 반복하여 N개의 정수를 입력받는다.
		// 3. 입력받은 N개의 정수를 배열 arr에 저장한다.
		// 4. 배열 arr을 반복하여, 최솟값을 담는 변수 max와 i번째 배열 요소를 비교한다.
		// 5. 두 요소 중 더 작은 요소를 min에 대입한다.
		// 6. 반복이 끝나고, 변수 min를 출력한다.
		
		// int max = -999;
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int num[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
			if(num[i] < min) {
				min = num[i];
				minIdx = i;
			}
		}
		
		System.out.println("최솟값은 " + min + " 이고, 배열의 " + minIdx +
				" 번째 인덱스입니다.");
		sc.close();
	}

}

