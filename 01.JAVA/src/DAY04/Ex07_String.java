package DAY04;

public class Ex07_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String은 참조 자료형
		// - 문자열 한 글자, 한 글자를 비교 시, equals() 메소드를 사용한다.
		String a = "Hello";
		String b = "Java";
		String c = "Hello";
		
		// 문자열 객체 생성
		String d = new String("Hello");
		String e = new String("Java");
		String f = new String("Java");
		
		System.out.println("a == c : " + (a == c));
		System.out.println("a == d : " + (a == d));
		System.out.println("문자열 비교 : " + a.equals(d));
		
		System.out.println("e == f : " + (e == f));
		System.out.println("문자열 비교 : " + e.equals(f));
	}

}
