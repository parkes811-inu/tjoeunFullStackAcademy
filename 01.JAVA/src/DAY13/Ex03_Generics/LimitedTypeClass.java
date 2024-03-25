package DAY13.Ex03_Generics;

//2024-02-21 
//MSA 기반 풀스택 교육 14일차

class X { }

class A extends X { }		// X를 상속한 A 클래스
class B extends A { }		// A를 상속한 B 클래스
class C extends A { }		// A를 상속한 C 클래스

class D <T extends A> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}

// 1) Integer 클래스만 타입 매개변수로 사용가능하도록 제한하고 싶은 경우
// 2) Number 클래스로 제한 ( Double, Integer 등 숫자 타입 클래스만 사용 가능하도록 제한 )
class E <T extends Number> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}

public class LimitedTypeClass {
	public static void main(String[] args) {
		D<A> d1 = new D<A>();
		D<B> d2 = new D<B>();
		D<C> d3 = new D<C>();
		
		// 에러 메시지 
		// : Bound mismatch: The type X is not a valid substitute 
		//   for the bounded parameter <T extends A> of the type D<T>
		// D 클래스는 타입 매개 변수를 A 클래스로 제한하고 있기 때문에,
		// X 클래스는 타입 매개 변수로 사용이 불가능
		// A, B, C 클래스는 타입 매개 변수로 사용 가능
		// (에러) D<X> d4 = new D<X>();
		
		d1.setT(new A());
		d2.setT(new B());
		d3.setT(new C());
		
		// d1<A> <---- 자식 객체인 B, C는 대입이 가능 (업캐스팅)
		d1.setT(new B());
		d1.setT(new C());
		
		// d2<B>, d3<C> <---- 부모 객체인 A에 대입 불가
		// (에러) d2.setT(new A());
		// (에러) d3.setT(new A());
		
		// * 타입 지정을 생략하려면,
		// 제네릭 타입을 제한한 A클래스를 기본으로 생성한다.
		D d5 = new D();			// D<A> d5 = new D<A> (); 
		d5.setT(new B());
		d5.setT(new C());
		
		// Wrapper
		E<Integer> e1 = new E<Integer> ();
		E<Double> e2 = new E<Double> ();
		E<Byte> e3 = new E<Byte> ();
		// (에러 : Boolean은 숫자 타입 X) E<Boolean> e4 = new E<Boolean> ();
		
		e1.setT(100);
		System.out.println(e1.getT());
		
		e2.setT(12.34);
		System.out.println(e2.getT());
		
		e3.setT((byte) 127);
		System.out.println(e3.getT());
	}
}
