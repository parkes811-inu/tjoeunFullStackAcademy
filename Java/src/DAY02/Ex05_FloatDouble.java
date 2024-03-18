package DAY02;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex05_FloatDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 실수 타입 변수 선언
		// float 타입 리터럴 		: 실수F;
		// double 타입 리터럴		: 실수D;
		// double 타입 리터럴 D는 생략이 가능하다.
		
		double var1 = 3.14;
		double var2 = 3.14D;
		
		double var3 = 3.14F;
		
		// 실수형 정밀도
		double var4 = 0.123456789123456789D;
		float var5 = 0.123456789123456789F;

		System.out.println("var1 : " + var1);
		System.out.println("var2 : " + var2);
		System.out.println("var3 : " + var3);
		System.out.println("var4 : " + var4);
		System.out.println("var5 : " + var5);
		
	}

}
