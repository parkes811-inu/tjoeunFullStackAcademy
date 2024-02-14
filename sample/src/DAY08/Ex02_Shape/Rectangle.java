package DAY08.Ex02_Shape;

//2024-02-14 
//MSA 기반 풀스택 교육 8일차

// 추상 클래스: 추상 메소드는 구현 클래스에서 반드시 오버라이딩 해야한다.
public class Rectangle extends Shape {

	double width, height;
	
	public Rectangle() {
		this(0, 0);
	}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	double area() {
		// 가로 X 세로
		return width * height;
	}

	
	@Override
	double round() {
		// (가로 + 세로) * 2
		return (width + height) * 2; 
	}

	// getter, setter
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

	// toString()
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
}
