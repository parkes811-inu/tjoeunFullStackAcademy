package CodeUp;

import java.util.Scanner;

public class CodeUp1501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[][] = new int[n][n];
		int num = 1;
		
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = num++;
				}
			}
			else {
				for(int j = n - 1; j >= 0; j--) {
					arr[i][j] = num++;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
