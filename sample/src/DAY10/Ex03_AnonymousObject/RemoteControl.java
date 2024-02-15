package DAY10.Ex03_AnonymousObject;

public interface RemoteControl {

	// 상수 
	// 최저 속력, 최고 속력 상수를 선언하시오.
	
	// interface 파일로 선언된 모든 변수는 상수로 선언되기 때문에 초기화를 해야한다.
	// * 인터페이스는 변수 선언 시, (public static final)이 자동으로 선언된다.
	int MAX_SPEED = 300;
	int MIN_SPEED = 0;

	
	// interface 메소드에는 추상 메소드, 디폴트 메소드, 스태틱 메소드를 선언할 수 있다. 
	
	// 추상 메소드
	// * (public abstract) 가 자동으로 선언된다.
	void turnOn();
	void turnOff();
	void setSpeed(int speed);
	
	// default 메소드
	// : 구현한 객체가 기본으로 사용할 수 있는 메소드
	default void parking(boolean check) {
		if(check) {
			System.out.println("주차 되었습니다.");
			setSpeed(MIN_SPEED);
		}
		else {
			System.out.println("주행 모드 입니다.");
			setSpeed(10);
		}
	}

	// static 메소드
	// : 구현 객체가 없어도 인터페이스만으로 호출이 가능한 메소드
	static void changeBattery() {
		System.out.println("배터리를 교환하였습니다.");
	}
	
	
	
}
