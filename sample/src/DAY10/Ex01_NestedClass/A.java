package DAY10.Ex01_NestedClass;

/*
 * 중첩 클래스 
 */

// Outer Class
public class A {
	int a, b;
	
	// Inner Class
	class B {
		int x, y;
		
		public void bMethod() {
			System.out.println("이너 클래스에서 아우터 클래스의 멤버 접근 가능");
			System.out.println("A의 a : " + a);
			System.out.println("A의 b : " + b);
		}
	}
	
		void aMethod() {
			System.out.println("아우터 클래스에서 이너 클래스의 멤버에 접근 불가능");
			// (에러) System.out.println("B의 x : " + x);
			// (에러) System.out.println("B의 y : " + y);
			// 클래스 B에 선언된 멤버 변수 x, y는 다른 클래스에서 접근이 불가능하다.
			
		}
}
