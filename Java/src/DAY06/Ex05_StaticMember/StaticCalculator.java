package DAY06.Ex05_StaticMember;

//2024-02-07 
//MSA 기반 풀스택 교육 6일차

class Calculator {
		// 아래 연산 결과를 구하는 Static 메소드를 정의하시오.
		// 1. 절댓값
		// 2. 최댓값
		// 3. 최솟값
		
		// 1. 절댓값
		public static int abs(int val) {
			return val >= 0 ? val : -val;
		}
		
		// 2. 최댓값
		public static int max(int[] arr) {
			int max = Integer.MIN_VALUE;
			for (int i : arr) {
				if(i > max) {
					max = i;
				}
			}
			return max;
		}
		
		// 3. 최솟값
		public static int min(int[] arr) {
			int min = Integer.MAX_VALUE;
			for (int i : arr) {
				if(i < min) {
					min = i;
				}
			}
			return min;
		}
}


public class StaticCalculator {
	
	public static void main(String[] args) {
		int arr[] = {70, 65, 90, 85, 100};
		
		// 다른 클래스의 static 메소드를 호출하는 방법
		System.out.println("abs(-123) : " + Calculator.abs(-123));
		System.out.println("max(arr) : " + Calculator.max(arr));
		System.out.println("min(arr) : " + Calculator.min(arr));
		
	}
}
