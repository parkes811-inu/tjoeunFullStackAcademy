package JAVA_MISSION.Solve02;

import java.util.Scanner;

public class solve02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		
		// 홀수 
		for(int i = 1; i <= n; i++) {
			if(i % 2 != 0) {
				sum = sum + i;
				System.out.print(i);
				
				if(i != n) {
					System.out.print("+");
				}
			}
		}
		System.out.println("=" + sum);
		
		// 짝수
		sum = 0;
		for(int i = 1; i <= n; i++) {
			if(i % 2 == 0) {
				sum = sum + i;
				System.out.print(i);
				
				if(i != n) {
					System.out.print("+");
				}
			}
		}
		System.out.println("=" + sum);
		
		// 약수
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
