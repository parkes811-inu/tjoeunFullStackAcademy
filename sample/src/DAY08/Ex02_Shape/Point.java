package DAY08.Ex02_Shape;

//2024-02-14 
//MSA 기반 풀스택 교육 8일차

/*
* 추상 클래스란?
* - 어떠한 대상(구현 클래스)들로 부터 공통된 특징을 뽑아 정의한 클래스
* - ex) 도형 클래스 (둘레, 넓이를 가지는 클래스)
* - ex) 구현 클래스 ( 삼각형, 사각형, 원형 클래스 등)
* 
* - 객체의 특성을 코드로 구현하지 않고, 추상화하여 선언만 해놓은 클래스 또는 메소드
* - 키워드 : abstract
* 
*/

public class Point {

	/*
	 * 추상 메소드란?
	 * public void show() {추상메소드는 바디가 없다} 와 같은 추상 메소드가 클래스 내에 존재할 경우
	 * 해당 클래스는 추상 클래스로 정의해야 한다. 
	 *  
	 *  
	 */
	
	// 멤버 변수 x, y
	int x, y;
	
	// Default(기본) 생성자
	Point() {
		
	}
	
	// 매개변수가 있는 생성자
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// toString() 메소드 정의
	@Override
	public String toString() {
		return "Point [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}



	
