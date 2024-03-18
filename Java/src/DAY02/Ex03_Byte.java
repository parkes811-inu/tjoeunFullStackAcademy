package DAY02;

//2024-02-01 
//MSA 기반 풀스택 교육 2일차

public class Ex03_Byte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// byte는 1byte 범위의 정수 데이터를 표현
		// 8bits는 (0000 0000) : 2^8 : 256개
		// 양수와 음수로 나누면, 1 byte는 -128 ~ 127까지 범위로 표현이 가능하다.
		
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		// byte var5 = 128; 로 선언하면 오류가 나온다.
		// 자료형 (타입)이 불일치하기 때문에 데이터 범위를 벗어난다.
		// var5 = (byte) 형으로 강제 형변환하게 되면 데이터 범위를 벗어나
		// Overflow가 발생하여 -128이 출력된다.
		byte var5 = (byte) 128;
		
		System.out.println("var1 : " + var1);
		System.out.println("var2 : " + var2);
		System.out.println("var3 : " + var3);
		System.out.println("var4 : " + var4);
		System.out.println("var5 : " + var5);
		
	}

}
