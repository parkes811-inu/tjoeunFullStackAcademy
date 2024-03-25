package CodeUp;

import java.util.Scanner;

// 2024-02-13 
// MSA 기반 풀스택 교육 8일차
// 선택정렬 문제 풀기

/*
 * 오름차순 선택 정렬은 가장 작은 원소를 찾아 첫번째 위치로 옮기고, 
 * 남은 원소를 다시 탐색하여 그 다음 작은 원소를 찾아 두번째 위치로 옮기고,
 * 결국 남은 원소들을 모두 찾아 n 번째 원소까지 옮기는 방식의 정렬 방법이다.
 * 
 * 이중 for 문을 활용하여 0부터 n번째 위치에 원소를 옮기는 방법을 사용 
 */

public class CodeUp1442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[100001];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = 0;
		
		// n번 반복하여 배열의 값을 채워준다.
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();

		// 2중 for문을 활용하여 오름차순으로 데이터를 선택 정렬한다.
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(arr[i] > arr[j]) {
	                temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}

	}

}
