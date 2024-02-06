package CodeUp;

import java.util.Scanner;

public class CodeUp1351 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = n - 2; i >= 0; i--) {
			for(int j = i; j >= 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
