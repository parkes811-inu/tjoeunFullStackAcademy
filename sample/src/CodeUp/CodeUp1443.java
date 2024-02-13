package CodeUp;

import java.util.Scanner;

//2024-02-13 
//MSA 기반 풀스택 교육 8일차
//버블정렬 문제 풀기

/*
* 삽입 정렬  
* 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여,
* 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘
*  
* 
*  
*/

public class CodeUp1443 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int [10001];
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int i, j;
		for(i = 1; i < n; i++) {
			
			int key = arr[i];
			
			for(j = i - 1; j >= 0; j--) {
				if(key < arr[j]) {
					arr[j + 1] = arr[j];
				}
				else {
					break;
				}
			}
			arr[j + 1] = key;
		}
		
		for(i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}		
	}

}
