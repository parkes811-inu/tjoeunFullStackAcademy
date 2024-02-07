package CodeUp;

import java.util.Scanner;

public class CodeUp1358 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int space = (num - 1) / 2;
		
		for (int i = 1; i <= num; i += 2) {
			if (num % 2 == 1) {
				for (int j = 1; j <= space; j++) {
					System.out.print(" ");
				}
				for (int k = 1; k <= i; k++) {
					System.out.print("*");
				}
				System.out.println();
				space--;

			}

		}
	}

}
