package DAY08.Ex02_Shape;

//2024-02-14 
//MSA 기반 풀스택 교육 8일차

/*
 * 아래 <조건>에 따라 Shape 클래스를 작성하세요.
 * 
 * - 추상클래스로 정의하시오.
 * - 멤버변수로 Point 객체를 선언하시오.
 * - 넓이와 둘레를 구하는 메소드 원형을 정의하시오.
 * - getter, setter 메소드를 정의하시오.
 * 
 */

// 추상 클래스
public abstract class Shape {
	
	// Point 멤버변수를 선언하시오.
	Point point;
	
	// 넓이(area)와 둘레(round)를 구하는 메소드 원형을 정의하시오.
	// * 키워드 : abstract
	// 추상 메소드 : abstract 반환타입 메소드명 (매개변수);
	abstract double area();
	abstract double round();
	
	// getter, setter 메소드를 정의하시오.
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
}
