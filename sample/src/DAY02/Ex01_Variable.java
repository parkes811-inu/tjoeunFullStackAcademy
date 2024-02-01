package DAY02;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex01_Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 변수 선언
		// 자료형 변수명; 과 같은 형식으로 사용
		
		// int형 변수 x, y 선언
		int x, y; 
		
		
		// 변수 선언 및 초기화 
		// 자료형 변수명 = 값; 과 같은 형식으로 사용
		
		// int형 변수 i는 10, j는 20으로 선언
		int i = 10, j = 20;
		
		// 변수 선언 후 = (대입 연산자)를 이용해 값을 넣어줄 수 있다.
		x = 100; y = 200;
		
		// string과 + 연결 연산자가 만나 x, y가 string으로 Type Casting 
		// 되었기 때문에 ()를 하지 않으면 문자열 100200이 나오게 된다.
		System.out.println("x + y = " + (x + y));
		
		System.out.println("x + y / 2 = " + (x + y) / 2);
	}

}
