package DAY10.Ex03_AnonymousObject;

public class AnonymousPerson {

	// 익명 자식 객체 생성
	// - 부모클래스 객체명 = new 부모클래스() { 익명객체 정의 }
	Person person = new Person() {
		
		// 오버라이딩
		@Override
		void work() {
			System.out.println(name + "(" + age + ")");
			System.out.println("프로그래밍을 합니다.");
			System.out.println();
		}
	};
	
	Person person2 = new Person() {
		
		// 오버라이딩
		@Override
		void work() {
			System.out.println(name + "(" + age + ")");
			System.out.println("요리를 합니다.");
			System.out.println();
		}
	};
	
	void method() {
		person.name = "김조은";
		person.age = 20;
		person.work();
		
		person2.name = "고든 램지";
		person2.age = 40;
		person2.work();
	}
}
