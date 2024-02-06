package DAY03;

public class Ex10_OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 ~ 20 까지 정수 중,
		// 홀수의 합계, 짝수의 합계를 각각 구하여 출력하시오.
		
		int a = 1;
		int evenSum = 0;
		int oddSum = 0;
		
		while( a != 21 ) {
			
			if(a % 2 == 0) {	// 짝수
				evenSum += a;
			}
			else {				// 홀수
				oddSum += a;
			}
			a++;
		}
		
		System.out.println("홀수의 합계 : " + oddSum);
		System.out.println("짝수의 합계 : " + evenSum);
	}

}
