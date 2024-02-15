package _1회차;

public class Main {
	public static void main(String[] args) {
		// 게시글 정보를 생성
		// -> Board 객체 생성
		// 클래스타입 객체명 = new 클래스명();
		Board board = new Board();
		
			
		// 객체 초기화하면서 생성
		Board board2 = new Board("제목", "작성자", "내용");
		System.out.println(board2.getWriter());
		
		// 작성자를 "김조은"으로 수정하세요.
		board2.setWriter("김조은");
		System.out.println(board2.getWriter());
		
		System.out.println(board2);
		
	}
}
