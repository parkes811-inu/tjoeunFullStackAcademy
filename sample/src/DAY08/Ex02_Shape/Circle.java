package DAY08.Ex02_Shape;
//2024-02-14 
//MSA 기반 풀스택 교육 8일차
public class Circle extends Shape{
		double radius;
		
		public Circle() {
			this(0);
		}
		
		public Circle(double radius) {
			this.radius = radius;
		}
		
		
		@Override
		double area() {
			// 원주율 * 반지름 * 반지름
			return Math.PI * radius * radius;
		}

		@Override
		double round() {
			// 2 * 원주율 * 반지름
			return 2 * Math.PI * radius;
		}


		// getter, setter
		public double getRadius() {
			return radius;
		}


		public void setRadius(double radius) {
			this.radius = radius;
		}

		// toString()
		@Override
		public String toString() {
			return "Circle [radius=" + radius + "]";
		}
		
}
