package CodeUp;

import java.util.Scanner;

public class CodeUp1116 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a + "+" + b + "=" + (a+b));
		System.out.println(a + "-" + b + "=" + (a-b));
		System.out.println(a + "*" + b + "=" + (a*b));
		System.out.println(a + "/" + b + "=" + (a/b));
		
		sc.close();
	}

}
