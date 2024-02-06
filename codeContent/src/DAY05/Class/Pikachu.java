package DAY05.Class;

public class Pikachu {
		// 클래스 		: 객체를 정의하는 설계도
		// 멤버			: 변수, 메소드
		
		// 변수 
		public int energy;
		public String type;
		
		// 생성자 
		// : 객체가 생성될 때, 실행되는 메소드
		// - 객체의 변수를 초기화하는 역할
		// - 생성자의 이름은 클래스의 이름과 동일하다.
		// - 생성자는 반환타입을 지정하지 않고 선언한다.
		public Pikachu() {
			// this() : 생성자에서 다른 생성자를 호출하는 메소드
			// this() 메소드는 생성자 내에서 첫 문장이 되어야 한다.
			this(100, "전기");
			// this.energy = 100;
			// this.type = "전기";
		}
		

		// 기본 생성자 : 매개변수가 없는 생성자 
		// - 생성자를 선언하지 않는 클래스의 경우 자바 컴파일러가
		// - Default 생성자를 자동으로 생성한다.
		// - 매개변수가 있는 생성자를 정의하면, 더 이상 컴파일러가 기본 생성자를 
		// - 자동생성하지 않는다.
		public Pikachu(int energy, String type) {
			this.energy = energy;
			this.type = type;
			System.out.println("매개변수가 있는 생성자가 실행된다.");
		}
		
		// 메소드
		// - 접근지정자 반환타입 메소드명 ( 매개변수 ) {}
		public String aAttack() {
			return "십만볼트";
		}
		
		public String bAttack() {
			return "전광석화";
		}
}

