package _1회차;

public class Ex03_foreach {
	
	public static void main(String[] args) {

		// 배열 선언
		int arr[] = {1, 2, 3, 4, 5};
		
		// foreach 문
		// - for( 자료형 요소변수 : 배열 ) { }
		// * 요소 변수를 반복문 내에 쓰면, index 0 ~ 끝가지 모든 항목을 대신한다.
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
