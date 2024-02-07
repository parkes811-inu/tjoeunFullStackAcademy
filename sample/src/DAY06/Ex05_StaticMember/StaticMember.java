package DAY06.Ex05_StaticMember;

//2024-02-07 
//MSA 기반 풀스택 교육 6일차

public class StaticMember {
	
	// static 변수
	static int a;
	static int b;
	int c;
	static final double PI = 3.141592;
	
	// static 메소드
	public static int sum(int x, int y) {
		int sum = a + b + x + y;
		// sum = sum + c;
		// c 는 static 변수가 아니고 인스턴스 변수이기 때문에, 
		// 객체 생성 시 메모리에 할당되므로, static 메소드 내에서 접근할 수 없다.
		return sum;
	}
	
	
	public static void main(String[] args) {
		// * static 메소드는 객체 생성없이 호출 가능
		int sum = sum(10, 20);
		
		a = 100;
		StaticMember s1 = new StaticMember();
		StaticMember s2 = new StaticMember();
		
		int a1 = s1.a;
		int c1 = s1.c = 10;
		int a2 = s2.a;
		int c2 = s2.c = 20;
		
		// PI는 위에서 상수로 지정하는 final 키워드를 사용하여 선언한 변수이기 때문에 
		// 값을 바꾸려고할 때 에러가 발생된다.
		// : 한 번 값을 초기화한 이후에는 값을 변경할 수 없다.
		// PI = 100;
		
		System.out.println("a1 : " + a1);		// 100
		System.out.println("c1 : " + c1);		// 10
		System.out.println("a2 : " + a2);		// 100
		System.out.println("c2 : " + c2);		// 20
	}
}
