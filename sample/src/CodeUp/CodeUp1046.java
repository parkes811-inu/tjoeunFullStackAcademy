package CodeUp;

import java.util.Scanner;

public class CodeUp1046 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		sc.close();
		double answer = (a+b+c)/3.0;
		System.out.println(a+b+c);
		System.out.printf("%.1f", answer);
	}

}
