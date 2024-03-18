package DAY02;

public class Ex12_LogicalOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 논리 연산자 
		
		// AND (&&)
		// A AND B 			: A와 B 둘 다 TRUE 일 때, 결과가 TURE
		// A		B		결과
		// --------------------
		// F		F		F
		// F		T		F
		// T		F		F
		// T		T		T
		System.out.println(true && true);		// T
		System.out.println(false && true);		// F
		System.out.println(true && false);		// F
		System.out.println(false && false);		// F
		
		// OR (||)
		// A OR B 			: A와 B 둘 중 하나가 TRUE 일 때, 결과가 TURE
		// A		B		결과
		// --------------------
		// F		F		F
		// F		T		T
		// T		F		T
		// T		T		T
		System.out.println(true || true);		// T
		System.out.println(false || true);		// T
		System.out.println(true || false);		// T
		System.out.println(false || false);		// F
		System.out.println();
		
		// NOT (!)
		// !A 				: A가 true이면 false, false이면 true로 변환
		System.out.println(!true);		// F
		System.out.println(!false);		// T
		
		// 쇼트 서킷 : 논리 연산의 결과를 미리 알아서, 남은 논리식을 확인하지 않는다. 
		int value1 = 3;
		System.out.println(false && ++value1 > 10);
		System.out.println("value1 : " + value1);
		
		int value2 = 3;
		System.out.println(false || ++value2 > 10);
		System.out.println("value2 : " + value2);
		
		// 비트 연산자의 경우, 쇼트 서킷이 적용되지 않는다. 
		int value3 = 3;
		System.out.println(false & ++value3 > 10);
		System.out.println("value3 : " + value3);
		
		int value4 = 3;
		System.out.println(false | ++value4 > 10);
		System.out.println("value4 : " + value4);
	}

}
