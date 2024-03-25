package DAY08.Ex02_Shape;
//2024-02-14 
//MSA 기반 풀스택 교육 8일차

import java.util.List;
import java.util.Scanner;

//2024-02-14 
//MSA 기반 풀스택 교육 8일차

public class ShapeMaker {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		// 입력 변수
		double width = 0.0, height = 0.0, radius = 0.0;
		
		// 입력 받은 도형 배열
		//Triangle[] triangleList = new Triangle[3];
		Shape[] shapeList = new Shape[3];
		
		int index = 0;
		
		while(true) {
			
			if(index == 3) {
				break;
			}
			
			System.out.println("1. 삼각형, 2. 사각형, 3. 원형");
			System.out.print(">> ");
			String input = sc.next();			// next() : 반환타입이 문자열(String)
			
			if(input.equals("그만")) {
				break;
			}
			
			// 도형 선택
			switch(input) {
				// 삼각형
				case "1":
					System.out.println("가로를 입력해주세요 : ");
					width = sc.nextDouble();

					System.out.println("세로를 입력해주세요 : ");
					height = sc.nextDouble();
					
					//triangleList[0] = new Triangle(width, height);
					// triangleList는 Triangle 객체이기 때문에 담을 수 없다.
					// Shape 클래스의 객체를 선언하고 받아야 한다.
					//triangleList[1] = new Rectangle(width, height);
					shapeList[index++] = new Triangle(width, height);
					break;
				// 사각형	
				case "2":
					System.out.println("가로를 입력해주세요");
					width = sc.nextDouble();

					System.out.println("세로를 입력해주세요");
					height = sc.nextDouble();
					shapeList[index++] = new Rectangle(width, height);
					break;
					
				// 사각형	
				case "3":
					System.out.println("반지름을 입력해주세요 : ");
					radius = sc.nextDouble();
					shapeList[index++] = new Circle(radius);
					break;
			}
			
			
			
		}
		
		
		// 넓이 총합, 둘레 총합
		double areaSum = 0.0;
		double roundSum = 0.0;
		
		for (Shape shape : shapeList) {
			
			// instanceof : 인스턴스를 비교하는 연산
			// instanceof 키워드로 객체가 어떤 객체인지 파악할 수 있다.
			// - 같은 인스턴스면 True 아니면 False를 반환한다.
			if(shape instanceof Triangle) {
				System.out.println("삼각형");
			}
			if(shape instanceof Rectangle) {
				System.out.println("사각형");
			}
			if(shape instanceof Circle) {
				System.out.println("원형");
			}
			if(shape == null) {
				continue; 
			}
			
			// 합계
			areaSum = areaSum + shape.area();
			roundSum = roundSum + shape.round();
		}
		System.out.println("넓이 총합 : " + areaSum);
		System.out.println("둘레 총합 : " + roundSum);
		sc.close();
	}
}
