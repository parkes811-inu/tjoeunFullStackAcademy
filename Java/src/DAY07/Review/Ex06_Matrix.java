package DAY07.Review;

import java.util.Scanner;

//2024-02-08 
//MSA 기반 풀스택 교육 7일차

public class Ex06_Matrix {
	public static void main(String[] args) {
		// 양의 정수 M과 N을 입력받아 저장하고,
		// M행 N열의 2차원 배열을 생성한다.
		// 각 요소의 값을 입력받고, 그대로 출력하시오.
		// (입력 예시)
		// M : 2
		// N : 3
		// 1 2 3
		// 4 5 6
		// (출력 예시)
		// 1 2 3
		// 4 5 6
		
		Scanner sc = new Scanner(System.in);
		System.out.println("M : ");
		int m = sc.nextInt();
		System.out.println("N : ");
		int n = sc.nextInt();
		
		int arr[][] = new int [m][n];
		
		// 입력
		// 2차원 배열은 이중반복문으로 접근한다.
		// 바깥쪽 반복문 		: - 반복변수 i : 행에 대한 접근 
		// 안쪽  반복문		: - 반복변수 j : 열에 대한 접근
		// arr.length		: - 행 크기
		// arr[i].length	: - 열 크기
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 출력
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		
		System.out.println("------------------------");
		
		// foreach 문으로 2차원 배열 출력
		for (int[] row : arr) {
			for (int col  : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
