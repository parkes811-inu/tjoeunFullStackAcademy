package DAY05.Ex03_Car;

//2024-02-06 
//MSA 기반 풀스택 교육 5일차

public class Car {
	// 모델명, 속도
	String model;
	private int speed;
	
	// 생성자
	// * 생성자 자동완성 단축키 : alt + shift + S, O
	
	// - 기본 생성자
	public Car() {
		
	}

	// - model 매개변수 생성자
	public Car(String model) {
		this.model = model;
	}

	// - 전체 매개변수 생성자
	public Car(String model, int speed) {
		super();
		this.model = model;
		this.speed = speed;
	}
	
	// getter				: 변수의 값을 가져오는 메소드
	// setter				: 변수의 값을 지정하는 메소드
	// getter/setter name 	: getXXX(), setXXX(value)
	//						ex) getName(), setName("박은서");
	// - get/set 뒤에 변수명을 첫글자를 대문자로 해서 정의하는 것이 관례
	// * getter/setter 메소드 자동완성 단축키 : alt + shift + S, R
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if(speed < 0) {
			speed = 0;
			System.err.println("속도는 음수가 될 수 없습니다.");
		}
		if(speed >= 300) {
			speed = 300;
			System.err.println("최대 속도는 300km/h 입니다.");
		}
		this.speed = speed;
	}
	
}
