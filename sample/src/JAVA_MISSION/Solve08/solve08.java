package JAVA_MISSION.Solve08;

import java.util.Scanner;

public class solve08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정수 N을 입력받기
		int n = sc.nextInt();
		
		// N행 N열의 2차원 배열 선언
		int[][] arr = new int [n][n];
		
		// 배열요소의 들어갈 값 (*1부터 시작)
		int num = 1;
		
		// 2차원 배열의 행 크기 N번 반복
		for(int i = 0; i < n; i++) {
			// 인덱스가 0부터 시작이라고 할 때,
			// 홀수번째 값들을 역순으로 넣어주기 위해
			// i % 2 != 0 조건 추가
			if(i % 2 != 0) {
				for(int j = n - 1; j >= 0; j--) {
					arr[i][j] = num++;
				}
			}
			// 짝수번째 값들일 경우, 정상적으로 추가
			else {
				for(int j = 0; j < n; j++) {
					arr[i][j] = num++;
				}
			}
		}
		
		// 출력
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
