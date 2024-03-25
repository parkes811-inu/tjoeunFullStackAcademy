package DAY13.Ex03_Generics;

//2024-02-20 
//MSA 기반 풀스택 교육 13일차

class Student {}
class Developer {}

class Person {
	
	private Object object = new Object();

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}

public class ObjectProduct {
	public static void main(String[] args) {
		Person person1 = new Person();
		
		person1.setObject(new Student());
		person1.setObject(new Developer());
		
		// * Object 타입으로 모든 타입을 다루는 데에 
		// 한계점이 존재하기 때문에 Generics을 사용한다.
		// 다양한 타입을 사용하기 위해서
		// Object 타입으로 인스턴스를 저장할 수는 있지만, 
		// 타입 변환이 불가능한 상황이 발생할 수 있다.
		// ClassCastException 이 발생할 수 있다.
		
	}
}
