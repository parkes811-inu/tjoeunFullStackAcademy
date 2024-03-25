package DAY02;

public class Ex14_TernaryOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3, b = 5;
		
		// a와 b 두 수의 차이(절댓값)를 구하시오.
		// a - b = -2
		// b - a = 2
		
		// 조건 연산자
		int result = (a > b) ? a - b : b - a;
		System.out.println("두 수의 차 : " + result);

		// if문으로 표현
		if(a > b) {
			result = a - b;
		}
		else {
			result = b - a;
		}
		
		System.out.println("두 수의 차 : " + result);
		
	}

}
