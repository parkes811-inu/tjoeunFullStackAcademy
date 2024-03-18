package DAY06.Ex01_ObjectArray;

//2024-02-07 
//MSA 기반 풀스택 교육 6일차

/*
 * 반지름이 1 ~ 5인 Circle 객체를 5개 가지는 객체 배열을 생성하고,
 * 배열 요소에 있는 모든 Circle 객체의 넓이를 출력하세요.
 *  
 */

class Circle {
	// 변수		: 반지름	
	int radius;
	
	public Circle(int radius) {
		// TODO Auto-generated constructor stub
		this.radius = radius;
	}

	// 메소드 	: 넓이
	public double area() {
		// (원의 넓이) = (원주율) * (반지름) ^ 2
		// * 원주율 (파이) = 3.141592.... : Math.PI
		return Math.PI * Math.pow(radius, 2);
	}	
}


public class CircleArray {
	public static void main(String[] args) {
		Circle[] c;
		c = new Circle[5];
		
		for(int i = 0; i < c.length; i++) {
			
			// 반지름 1 ~ 5까지 Circle 객체를 생성
			c[i] = new Circle(i + 1);	// i + 1 = 1, 2, 3, 4, 5
		}
		for (Circle circle : c) {
			System.out.println("넓이 : " + circle.area());
		}
	}
}
