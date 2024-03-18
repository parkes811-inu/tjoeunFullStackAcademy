package DAY05.Ex01_Student;

//2024-02-06 
//MSA 기반 풀스택 교육 5일차

public class Student {
	
	// 학생의 속성 : 이름, 나이, 학번, 전공
	// 학생의 행동 : 공부하기, 성적 평균 구하기
	
	// 변수 
	String name;
	int age;
	String stdNo;
	String major;
	
	// 생성자 
	public Student() {
		this("이름 없음", 1, "0000000", "없음");
	}
	
	public Student(String name, int age, String stdNo, String major) {
		super();
		this.name = name;
		this.age = age;
		this.stdNo = stdNo;
		this.major = major;
	}
	
	// 메소드
	// - 공부하기
	public void study(String subject) {
		System.out.println(subject + "(을/를) 공부합니다.");
		// void : 반환 타입이 없음을 의미 -> return 생략 가능
	}
	


	// - 성적 평균 구하기
	public double getAverage(int score1, int score2) {
		double average = 0.0;
		
		// 평균 = 합계 / 과목 수
		average = (double) (score1 + score2) / 2;
		return average;
	}
	
	public double getAverage(int score1, int score2, int score3) {
		double average = 0.0;
		
		// 평균 = 합계 / 과목 수
		average = (double) (score1 + score2 + score3) / 3;
		return average;
	}
	
	// 메소드 오버로딩
	public double getAverage(int[] score) {
		double average = 0.0;
		int sum = 0;
		// 평균 = 합계 / 과목 수
		// 합계 
		// 합계를 구해보세요.
		for (int i = 0; i < score.length; i++) {
			sum = sum + score[i];
		}
		
		// 평균
		// 평균을 구해보세요.
		average = (double) sum / score.length; 
		
		return average;
	}
}
