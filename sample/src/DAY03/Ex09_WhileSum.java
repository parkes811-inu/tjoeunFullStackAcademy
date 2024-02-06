package DAY03;

public class Ex09_WhileSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1 부터 100 까지의 합계를 구하시오.
		// 1 + 2 + 3 + 4 + ... + 100 = 5050
		int a = 1;
		int sum = 0;
		
		while(a != 101) {
			sum = sum + a++;
		}
		
		System.out.println("합계 : " + sum);
	}

}
