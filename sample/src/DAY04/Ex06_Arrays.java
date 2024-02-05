package DAY04;

import java.util.Scanner;

public class Ex06_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 정방 행렬
		// [] -> [][][]
		// [] -> [][][]
		// [] -> [][][]
		
		int arr[][] = new int[3][];
		// 비정방 행렬
		// [] -> [][]
		// [] -> [][][][]
		// [] -> [][][]
		
		
		arr[0] = new int[2];
		arr[1] = new int[4];
		arr[2] = new int[3];
		
		// 입력
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 출력
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j] + " ");
			}
		}
	
		sc.close();
	}

}
