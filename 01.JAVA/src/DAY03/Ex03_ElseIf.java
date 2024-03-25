package DAY03;

import java.util.Scanner;

//2024-02-02 
//MSA 기반 풀스택 교육 3일차

public class Ex03_ElseIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 학생의 성적을 입력받고, 성적에 따라 학점을 출력하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		char grade;
		
		if(score >= 90) {
			grade = 'A';
			//System.out.println("학점 : A");
		}
		else if(score >= 80 && score < 90) {
			grade = 'B';
			//System.out.println("학점 : B");
		}
		else if(score >= 70 && score < 80) {
			grade = 'C';
			//System.out.println("학점 : C");
		}
		else if(score >= 60 && score < 70) {
			grade = 'D';
			//System.out.println("학점 : D");
		}
		else {
			grade = 'F';
			//System.out.println("학점 : F");
		}
		sc.close();
		System.out.println("학점 : " + grade);
	}

}
