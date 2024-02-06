package DAY05.Ex02_Calculator;

//2024-02-06 
//MSA 기반 풀스택 교육 5일차

public class Calculator {
	
	/* 계산기
	 * - 피연산자를 2개로 하는 계산기
	 * - 기능 
	 *   1. 덧셈			: 	정수 2개 덧셈
	 *   2. 뺄셈			:	정수 인자1 - 정수 인자2 연산을 하는 뺄셈
	 *   3. 곱셈			:	실수 2개 곱셈
	 *   4. 나눗셈		:	실수 인자1 / 실수 인자2 연산을 하는 나눗셈
	 *   5. 나머지		:	실수 인자1 % 실수 인자2 연산을 하는 나머지 연산
	 *   6. 합계			:	배열을 매개변수로 전달받아, 모든 요소의 합을 구함
	 *   7. 평균			:	배열을 매개변수로 전달받아, 모든 요소의 평균을 구함	
	 */
	
	// 메소드명
	// : plus, minus, multiple, divide, remain, sum, avg
	// 1. 덧셈			: 	정수 2개 덧셈
	public int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	// 2. 뺄셈			:	정수 인자1 - 정수 인자2 연산을 하는 뺄셈
	public int minus(int x, int y) {
		int result = x - y;
		return result;
	}
	
	// 3. 곱셈			:	실수 2개 곱셈
	public double multiple(double x, double y) {
		double result = x * y;
		return result;
	}
	  
	// 4. 나눗셈		:	실수 인자1 / 실수 인자2 연산을 하는 나눗셈
	public double divide(double x, double y) {
		double result = x / y;
		return result;
	}
	
	 
	// 5. 나머지		:	실수 인자1 % 실수 인자2 연산을 하는 나머지 연산 
	public double remain(double x, double y) {
		double result = x % y;
		return result;
	}
	 
	// 6. 합계			:	배열을 매개변수로 전달받아, 모든 요소의 합을 구함
	public double sum(int[] scores) {
		double sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		return sum;
	}
	
	// 7. 평균			:	배열을 매개변수로 전달받아, 모든 요소의 평균을 구함	
	public double avg(int[] scores) {
		double result = sum(scores);
		return result / scores.length;
	}
}
