package DAY07.Review;

//2024-02-08 
//MSA 기반 풀스택 교육 7일차

public class Ex02_ThreeSixNine {
	
	public static void main(String[] args) {
		// 정수 1 ~ 100 까지의 수를 반복하여 출력하면서,
		// 해당 수가 3 또는 6 또는 9가 될 때 
		// 3 6 9의 개수 만큼 정수 대신 "*"을 출력하는 프로그램을 작성하시오.
		// ex) 3	-> 		"*"
		// 	   33 	-> 		"**"
		//	   99 	->		"**"
		//	   45	-> 		 45
		
		// 1. 정수를 1 ~ 100까지 출력
		for(int i = 1; i <= 100; i++) {
			
			// 2. 해당 수가 369가 몇개 인지 판단
			int a, b;
			a = (i / 10);
			b = (i % 10);
			System.out.print(i + " ");
			
			// 3. 그 개수만큼 "*" 출력
			if(a == 3 || a == 6 || a == 9) {
				System.out.print("*");
			}
			if(b == 3 || b == 6 || b == 9) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
