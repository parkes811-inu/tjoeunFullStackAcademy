package DAY12.Ex03_Lang;

//2024-02-19 
//MSA 기반 풀스택 교육 12일차

public class MathEx {
	public static void main(String[] args) {
		
		System.out.println(Math.PI);			// 3.141592653589793 (원주율)
		System.out.println(Math.ceil(3.125));	// 올림 : 해당 수보다 큰 정수 중 가장 작은 수
		System.out.println(Math.floor(3.75));	// 내림 : 해당 수보다 작은 정수 중 가장 큰 수
		System.out.println(Math.sqrt(9));		// 제곱근(루트)
		System.out.println(Math.pow(3, 2));		// 3의 2제곱
		System.out.println(Math.exp(2));		// e의 2승
		System.out.println(Math.round(3.14));	// 반올림
		
		System.out.println("----------------------------");
		
		// 로또 번호 6/45
		// [1,45] 사이의 정수형 난수 6개 만들기
		// Math.random()					: 0.0 보다 크거나 같고 1.0 보다 작은 임의의 실수
		// Math.random()					: 0.xxx ~ 0.9xx
		// (0.xxx ~ 0.9xx) * 10 			: 0.xxx ~ 9.xxx  (0 ~ 9) -  10 개
		// (0.xxx ~ 0.9xx) * 20 			: 0.xxx ~ 19.xxx (0 ~ 19) -  20 개
		// (0.xxx ~ 0.9xx) * 45 			: 0.xxx ~ 44.xxx
		// (0.xxx ~ 0.9xx) * 45 + 1 		: 1.xxx ~ 45.xxx
		// (int)(Math.random() * 45 + 1) 	: 1 ~ 45
		
		// [공식]
		// (int)(Math.random() * [개수] + [시작숫자] ) 
		for (int i = 0; i < 6; i++) {
			int random = (int)(Math.random() * 45 + 1);
			System.out.print(random + " ");
		}
		System.out.println();
		
		System.out.println("----------------------------");
		// -50 ~ 50 사이의 랜덤 정수 1개를 구하시오.
		int result3 = (int) (Math.random() * 100) - 50;
		System.out.println(result3);
		
		System.out.println("----------------------------");
		// 아래 정수 중 최댓값을 구하시오.
		// ** Math.max()
		double[] arr = {90.12, 12.45, 33.22, 64.12, 70.45};
		
		double max = Double.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);	// 아래 if 비교 연산 대신에 max() 메소드 사용
			// if (max < arr[i])
			//		max = arr[i];
		}
		System.out.println("max(최댓값) : " + max);
		
	}
}
