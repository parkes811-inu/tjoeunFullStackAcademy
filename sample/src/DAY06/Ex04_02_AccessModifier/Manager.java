package DAY06.Ex04_02_AccessModifier;

//2024-02-07 
//MSA 기반 풀스택 교육 6일차

import DAY06.Ex04_01_AccessModifier.Person;

public class Manager {
	public static void main(String[] args) {
		Student student = new Student();
		student.defaultSetting();
		System.out.println("name : " + student.name);
		System.out.println("age : " + student.getAge());
		System.out.println("height : " + student.getHeight());
		System.out.println("weight : " + student.getWeight());
		System.out.println();
		
		// Manager 에서 Student의 default 접근지정자 변수인 height를 접근할 수 없는 이유는
		// - 같은 패키지에 있지만, 실질적으로 height를 선언한 곳은 
		// 다른 패키지인 Person에서 선언을 했기 때문에 접근이 불가능하다.
		// * 선언한 클래스를 기준으로 접근지정자가 적용된다.
		Person person = new Person("김조은", 20, 170, 60);
		System.out.println("name : " + person.name);
		System.out.println("age : " + person.getAge());
		System.out.println("height : " + person.getHeight());
		System.out.println("weight : " + person.getWeight());
		System.out.println();
	}
}
