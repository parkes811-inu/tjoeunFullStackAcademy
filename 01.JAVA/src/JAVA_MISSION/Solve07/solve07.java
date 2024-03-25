package JAVA_MISSION.Solve07;

import java.util.Scanner;

public class solve07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] student = new int[5];
		
		for(int i = 0; i < 5; i++) {
			student[i] = sc.nextInt();
		}
		
		// 오름 차순
		for(int i = 1; i < student.length; i++) {
			for(int j = 0; j < student.length - 1; j++) {
				int temp = student[i];
				if(student[i] < student[j]) {
					student[i] = student[j];
					student[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < student.length; i++) {
			System.out.print(student[i] + " ");
		}
		System.out.println();
		
		// 내림 차순
		for(int i = 1; i < student.length; i++) {
			for(int j = 0; j < student.length - 1; j++) {
				int temp = student[i];
				if(student[i] > student[j]) {
					student[i] = student[j];
					student[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < student.length; i++) {
			System.out.print(student[i] + " ");
		}
		
	}
}
