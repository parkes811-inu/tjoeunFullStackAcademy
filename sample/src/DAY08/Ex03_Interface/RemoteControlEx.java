package DAY08.Ex03_Interface;

//2024-02-15 
//MSA 기반 풀스택 교육 9일차

public class RemoteControlEx {
	
	public static void main(String[] args) {
		// 인터페이스를 구현한 클래스 객체를 만드는 법
		//  - 인터페이스타입 객체명 = new 구현클래스();
		// RC카
		RemoteControl carRc = new RcCar();
		carRc.turnOn(); 			// 시동 걸기
		// 디폴트 메소드 (parking) 는 구현하지(오버라이딩) 않아도 바로 호출 가능 
		carRc.parking(false);		// 주행 모드
		carRc.setSpeed(20);			// 가속
		carRc.parking(true);		// 주차
		carRc.turnOff();			// 시동 끄기
		System.out.println();
		
		// static 메소드는 객체 생성 없이도 바로 호출이 가능
		RemoteControl.changeBattery();		// 배터리 교체
		System.out.println();
		
		// 드론
		RemoteControl droneRc = new Drone();
		droneRc.turnOn();
		droneRc.parking(false);
		droneRc.setSpeed(15);
		droneRc.parking(true);
		droneRc.turnOff();
		System.out.println();
	}
}
