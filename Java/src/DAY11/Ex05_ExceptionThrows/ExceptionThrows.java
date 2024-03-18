package DAY11.Ex05_ExceptionThrows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionThrows {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			// input() 메소드에서 예외를 전가해서,
			// 호출한 main() 메소드 내에서 예외처리를 해야한다.
			input();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("정수를 입력해주세요.");
		}
	}
	
	// 예외 전가(예외 던지기, 예외 떠넘기기) - throws
	// : 예외 처리에 대한 책임을 메소드를 호출한 곳으로 떠넘기는 것
	public static void input() throws InputMismatchException {
		
		System.out.println("입력 : ");
		// 입력 받을 때 int형이 아닌 다른 자료형을 받으면 에러 발생
		// java.util.InputMismatchException
		int input = sc.nextInt();		 
		System.out.println(input);
	}
}
