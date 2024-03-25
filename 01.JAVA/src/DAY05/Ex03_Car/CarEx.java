package DAY05.Ex03_Car;

import javax.swing.text.DefaultEditorKit.CutAction;

//2024-02-06 
//MSA 기반 풀스택 교육 5일차

public class CarEx {
	public static void main(String[] args) {
		// 객체 생성
		// - 클래스타입 객체명 = new 클래스명();
		Car car = new Car();
		car.model = "볼보";
		
		// car.speed = 200;
		// private으로 지정한 변수는 외부에서 접근이 불가능하다.
		car.setSpeed(200);
		System.out.println("model : " + car.getModel());
		System.out.println("speed : " + car.getSpeed());
		
		car.setSpeed(-50);
		System.out.println("model : " + car.getModel());
		System.out.println("speed : " + car.getSpeed());
		
		car.setSpeed(400);
		System.out.println("model : " + car.getModel());
		System.out.println("speed : " + car.getSpeed());
		
		car.setSpeed(200);
		System.out.println("model : " + car.getModel());
		System.out.println("speed : " + car.getSpeed());
	}
}

