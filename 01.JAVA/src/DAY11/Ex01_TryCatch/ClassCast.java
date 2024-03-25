package DAY11.Ex01_TryCatch;

/*
 * 예외처리
 * * ClassCastException
 * : 클래스 간의 타입 변환 시, 올바르지 않은 변환으로 발생하는 예외 상황
 *  ex) 업캐스팅이 전제되지 않은 다운캐스팅을 하는 경우
 *  	부모/자식의 관계가 아닌 클래스로 캐스팅 하는 경우
 *  
 */

class Animal { }

class Dog extends Animal { }

class Cat extends Animal { }

public class ClassCast {
	// 부모 클래스 			자식 클래스
	// Animal		<----		Dog, Cat
	// Animal = cat	으로 업캐스팅한 이후에
	// 다시 Animal을 Dog로 다운캐스팅 할 수 없다.
	// - Cat을 Dog로 타입 변환할 수 없다.
	public static void main(String[] args) {
		
		Dog dog = new Dog();		// 가능
		changeToDog(dog);
		
		Cat cat = new Cat();		// 불가능
		changeToDog(cat);
		
	}
	
	public static void changeToDog(Animal animal) {	// 매개 변수로 받는 과정에서 업캐스팅
		// 에외 메시지 : java.lang.ClassCastException
		try {
			Dog dog = (Dog) animal;	// 다운캐스팅	
		} catch (Exception e) {
			System.err.println("Cat을 Dog로 변환할 수 없습니다.");
		}
	}
}
