package DAY13.Ex03_Generics;

import DAY05.Class.Pikachu;
import DAY05.Class.Raichu;

//2024-02-20 
//MSA 기반 풀스택 교육 13일차

public class BoxEx {
	public static void main(String[] args) {

		Box<String> box1 = new Box<String> ();
		box1.setT("쿠팡 택배");
		String boxName = box1.getT();
		System.out.println("box1 name : " + boxName);
		
		Box<Integer> box2 = new Box<Integer> ();
		box2.setT(200);
		int value = box2.getT();
		System.out.println("box2 weight : " + value);
		
		Box<Pikachu> monsterBall = new Box<Pikachu> ();
		monsterBall.setT(new Pikachu());
		Pikachu pikachu = monsterBall.getT();
		System.out.println("pikachu : " + pikachu);
		
		// 제네릭 와일드카드
		// - 알 수 없는 타입을 대체하여 사용하는 기호
		// - 주로 타입 제한을 주기 위해서 사용한다.
		//   1) ? super T 	: 해당 클래스부터 상위 클래스를 허용하도록 제한
		//   2) ? extends T : 해당 클래스부터 하위 클래스를 허용하도록 제한
		Box<?> wildCardBox = new Box<>();
		
		Box<?> wBox = box1;
		Box<? extends Number> wBox2 = box2;			// Number 클래스와 하위클래스들 허용
		Box<? super Raichu> wBox3 =  monsterBall;	// Raichu 클래스와 상위클래스들 허용
		// (에러) Box<? super Raichu> wBox4 = box1;
		
	}
}
