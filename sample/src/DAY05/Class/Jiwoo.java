package DAY05.Class;

public class Jiwoo {
	public static void main(String[] args) {
		// 객체 생성
		// - 클래스타입 객체명 = new 클래스명();
		Pikachu pikachu = new Pikachu();
		
		// (.) 접근 연산자 : 객체의 변수, 메소드에 접근하는 연산자
		pikachu.energy = 100;
		pikachu.type = "전기";
		
		System.out.println("######### 피카츄 #########");
		System.out.println("에너지 : " + pikachu.energy);
		System.out.println("타입 : " + pikachu.type);
		System.out.println("공격 A : " + pikachu.aAttack());
		System.out.println("공격 B : " + pikachu.bAttack());

	}
	 
}
