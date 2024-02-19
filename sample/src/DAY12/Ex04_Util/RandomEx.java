package DAY12.Ex04_Util;

import java.util.Random;

//2024-02-19 
//MSA 기반 풀스택 교육 12일차

/*
 * Random 클래스 
 * : 타입별로 난수(랜덤수)를 생성하는 클래스
 * * 주요 메소드
 * - nextInt()		: int 형 랜덤수를 반환하는 메소드
 * - nextBoolean()	: boolean 형 랜덤수를 반환하는 메소드	
 * - nextDouble()	: double 형 랜덤수를 반환하는 메소드
 * 
 */

public class RandomEx {
	public static void main(String[] args) {
		Random random = new Random();
		
		boolean randomTF = random.nextBoolean();
		System.out.println("동전 앞, 뒤 : " + randomTF);
		
		System.out.println("동전 던지기 ...");
		if(randomTF) {
			System.out.println("앞면");
		}
		else {
			System.out.println("뒷면");
		}
		
		// 정수형 랜덤 수
		// * 4byte 범위 (-21억.xxx ~ 21억.xxx) 사이의 난수를 반환
		int fourByteRandom = random.nextInt();
		System.out.println("fourByteRandom : " + fourByteRandom);
		
		// nextInt( N ) 	: ()안에 N을 입력하면 0부터 N-1 사이의 난수를 반환한다.
		// 주사위 던지기 ( 1부터 6 사이 )
		int dice = random.nextInt(6) + 1;
		System.out.println("주사위 : " + dice);
		
		int lotto = random.nextInt(45) + 1;
		System.out.println("lottoe 번호 : " + lotto);
		
		double randomDouble = random.nextDouble();
		System.out.println("실수 랜덤 수 : " + randomDouble);
	}
}
