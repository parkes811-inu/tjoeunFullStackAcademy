package DAY08.Ex02_Shape;

//2024-02-14 
//MSA 기반 풀스택 교육 8일차

public class Triangle extends Shape{
	
	double width, height;
	
	// 생성자
	public Triangle() {
		
	}
	
	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	double area() {
		
		// 가로 X 세로 / 2
		return (width * height) / 2;
	}

	@Override
	double round() {
		// 정삼각형 : 한 변의 길이 * 3
		return width * 3;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

		
	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + "]";
	}
	
	
	
}
