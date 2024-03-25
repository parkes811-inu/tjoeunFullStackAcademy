package DAY08.Ex03_Interface;

//2024-02-14 
//MSA 기반 풀스택 교육 8일차


// interface를 구현하는 키워드 : implements
public class RcCar implements RemoteControl{
	
	int speed;
	
	@Override
	public void turnOn() {
		System.out.println("RC 카 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("RC 카 전원을 끕니다.");
	}

	@Override
	public void setSpeed(int speed) {
		
		// 최대 속력 이상을 넘지 못하게 지정
		if(speed > RemoteControl.MAX_SPEED) {
			this.speed = RemoteControl.MAX_SPEED;
		}
		// 최저 속력 미만이 되지 못하도록 지정
		else if(speed < RemoteControl.MIN_SPEED) {
			this.speed = RemoteControl.MIN_SPEED;
		}
		else {
			this.speed = speed;
		}
		System.out.println("현재 속도 : " + this.speed);
	}
	
	
}
