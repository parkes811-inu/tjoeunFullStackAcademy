package DAY10.Ex02_NestedInterface;

public class InnerInterfaceEx {
	public static void main(String[] args) {
		
		// 중첩 인터페이스의 아우터 클래스 객체 생성
		I i = new I();
		
		// 구현 객체를 메소드를 통해 저장
		i.setInterface(new ImplClass());
		i.method();
	}
}
