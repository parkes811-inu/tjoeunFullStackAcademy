package DAY08.Ex01_Singleton;

//2024-02-14 
//MSA 기반 풀스택 교육 8일차

public class SingleTonTest {
	public static void main(String[] args) {
		
		// SingleTon s = new SingleTon();
		// 위와 같은 코드로 객체를 생성 시 private 접근지정자에 의해 오류가 발생한다.
		
		// 객체를 따로 생성하지 않고, getInstance() 메소드를 통해 가져온다.
		SingleTon s01 = SingleTon.getInstance();
		SingleTon s02 = SingleTon.getInstance();
		
		System.out.println("s01과 s02가 같은지 여부 : ");
		System.out.println(s01 == s02);
		
	}
}
