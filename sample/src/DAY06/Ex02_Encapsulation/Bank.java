package DAY06.Ex02_Encapsulation;

//2024-02-07 
//MSA 기반 풀스택 교육 6일차

public class Bank {
	public static void main(String[] args) {
		Account account = new Account(0, "국민은행", "282401-04-109955", "한성호");
		
		// deposit 변수는 private 으로 지정했기 때문에, 직접 접근할 수 없다.
		// (에러 발생) account.deposit = 10000;
		account.setDeposit(10000);
		
		int money = account.getDeposit();
		System.out.println(account);
		System.out.println("예금액 : " + money);
		
	}
}
