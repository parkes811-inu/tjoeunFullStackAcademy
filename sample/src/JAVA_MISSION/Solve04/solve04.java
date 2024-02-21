package JAVA_MISSION.Solve04;

import java.util.Scanner;

public class solve04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// int n = 5;

        // 삼각형 출력
        for (int i = 0; i < n; i++) {
            // 왼쪽 공백 출력
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // 별표 출력
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // 줄 바꿈
            System.out.println();
        }
        
    sc.close();
	}
}
