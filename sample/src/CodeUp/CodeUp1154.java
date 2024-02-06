package CodeUp;

import java.util.Scanner;

public class CodeUp1154 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		if(a >= 60 && a <= 70 || a % 6 == 0) {
			System.out.println("win");
		}
		else {
			System.out.println("lose");
		}
		sc.close();

	}

}
