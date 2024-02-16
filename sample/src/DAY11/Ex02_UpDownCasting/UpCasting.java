package DAY11.Ex02_UpDownCasting;

public class UpCasting {
	public static void main(String[] args) {
		// * 업캐스팅 (자동 타입 변환)
		// (부모 클래스) = (자식 클래스)
		Person person = new Student("김조은", 20, 1, "정보통신공학");
		
		// Person		: name, age
		// Student		: name, age, grade, major
		System.out.println("name : " + person.name);
		System.out.println("age : " + person.age);
		
		// Person 객체에서는 grade, major 변수를 접근할 수 없다.
		// Person Class에 선언된게 아니라 Student Class에서 정의되었기 때문에 오류 발생
		// System.out.println("grade : " + person.grade);
		// System.out.println("major : " + person.major);
		
		// 클래스를 업캐스팅 하면, 
		// 변수는 부모 클래스에 있는 변수만 접근 가능하고,
		// 메소드는 자식 클래스의 메소드가 우선하여 실행된다.
		System.out.println(person);
		System.out.println(person.work());
		
		// Binding
		// : 프로그램에서 사용되는 요소에 실제 값을 결정짓는 행위
		
		// - 정적 바인딩
		// : 컴파일 시간에 결정
		// 변수 등
		
		// - 동적 바인딩
		// : 실행 시간에 결정
		// 오버라이딩 등
	}
}
