package DAY11.Ex06_UserException;

public class AccountEx {
	public static void main(String[] args) {
		Account account = new Account();
		
		// 10,000원 입금
		account.deposit(10000);

		// 20,000원 출금
		try {
			account.withdraw(20000);
		} catch (BalanceException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
