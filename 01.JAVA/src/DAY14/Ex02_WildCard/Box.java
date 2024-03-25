package DAY14.Ex02_WildCard;

//2024-02-20 
//MSA 기반 풀스택 교육 13일차

/*
 * 제네릭 기법으로 클래스 정의하기 
 * - 클래스 뒤에 타입 매개변수 <E>, <T>, <K, V> 등을 작성한다.
 * * 클래스의 변수나 메소드의 타입을 클래스를 정의할 때가 아닌, 
 * 객체를 생성할 때 타입을 확정하는 클래스 정의 기법
 * 
 */

public class Box <T> {
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
