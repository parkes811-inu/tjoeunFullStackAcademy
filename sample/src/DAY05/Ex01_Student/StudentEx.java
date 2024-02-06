package DAY05.Ex01_Student;

//2024-02-06 
//MSA 기반 풀스택 교육 5일차

public class StudentEx {
	public static void main(String[] args) {
		Student student = new Student();
		
		
		// student의 변수에 접근하여, name, age, stdNo, major 값을 지정해보세요.
		student.name = "김조은";
		student.age = 28;
		student.stdNo = "T100201";
		student.major = "Computer";
		int scores[] = {100, 80, 90, 50, 75}; 
		
		System.out.println("##### 학생1 #####");
		System.out.println("학생1 - 이름 : " + student.name);
		System.out.println("학생1 - 나이 : " + student.age);
		System.out.println("학생1 - 학번 : " + student.stdNo);
		System.out.println("학생1 - 전공 : " + student.major);
		student.study("Java Programming");
		System.out.println("학생1 - 중간고사 점수 : " + student.getAverage( 100, 90 ));
		System.out.println("학생1 - 기말고사 점수 : " + student.getAverage( 100, 85, 70 ));
		System.out.println("학생1 - 최정 점수 : " + student.getAverage( scores ));
		System.out.println();
		
		// 학생2 (student2) 객체를 생성하면서, 아래와 같이 객체를 초기화하세요.
		// - 이름 : 내이름
		// - 나이 : 20
		// - 학번 : T100200
		// - 전공 : 내전공
		Student student2 = new Student("백승헌", 20, "T202012", "영어영문학과");
		int scores2[] = {55, 80, 60, 35, 90}; 

		Student student3 = new Student("박은서", 28, "T202013", "임베디드시스템공학과");
		
		System.out.println("##### 학생2 #####");
		System.out.println("학생2 - 이름 : " + student2.name);
		System.out.println("학생2 - 나이 : " + student2.age);
		System.out.println("학생2 - 학번 : " + student2.stdNo);
		System.out.println("학생2 - 전공 : " + student2.major);
		student2.study("음운론");
		System.out.println("학생1 - 중간고사 점수 : " + student2.getAverage( 100, 90 ));
		System.out.println("학생1 - 기말고사 점수 : " + student2.getAverage( 100, 85, 70 ));
		System.out.println("학생1 - 최정 점수 : " + student2.getAverage( scores2 ));
		System.out.println();
		
	}
}
