package CodeUp;

import java.util.Scanner;

// 2024-02-13 
// MSA 기반 풀스택 교육 8일차
// 버블정렬 문제 풀기

/*
 * 버블 정렬  
 * 맨 왼쪽 원소부터 바로 이웃한 오른쪽 원소와 비교해가며 
 * 큰 수가 오른쪽으로 가도록 교환 하는 정렬 방식
 * 
 * 이중 for 문을 활용하여 0부터 바로 인접한 인덱스와 
 * 값을 비교해가며 정렬하는 방식
 *  
 */

public class CodeUp1441 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
 		int arr[] = new int [100001];
 		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}

	}

}
