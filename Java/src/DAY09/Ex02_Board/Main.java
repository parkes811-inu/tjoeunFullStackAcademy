package DAY09.Ex02_Board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BoardInterface boardInterface = new BoardAccess();
		
		int menuNo;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("====== 게시판 ======");
			System.out.println("1. 게시글 목록");
			System.out.println("2. 게시글 등록");
			System.out.println("3. 게시글 조회");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 게시글 삭제");
			System.out.println("0. 프로그램 종료");
			
			menuNo = sc.nextInt();
			sc.nextLine();		// 엔터를 입력 버퍼에서 제거 하기 위해 사용
			
			switch(menuNo) {
				case 1:			// 게시글 목록
					Board[] boardList = boardInterface.list();
					for (Board board : boardList) {
						System.out.println(board);
					}
					break;
					
				case 2:			// 게시글 등록
					String title, writer, content;
					System.out.println("제목 : ");
					
					title = sc.nextLine();
					
					System.out.println("작성자 : ");
					writer =  sc.nextLine();
					
					System.out.println("내용 : ");
					content = sc.nextLine();
					
					Board board = new Board(title, writer, content);
					Board createBoard = boardInterface.create(board);
					
					if(createBoard != null) {
						System.out.println("생성된 게시글 정보 : ");
						System.out.println(createBoard);
					}
					break;
					
				case 3:			// 게시글 조회
					System.out.println("조회할 글 번호 : ");
					int no = sc.nextInt();
					sc.nextLine();			// 엔터 제거
					Board selectedBoard = boardInterface.read(no);
					
					if(selectedBoard != null) {
						System.out.println("조회된 게시글 정보");
						System.out.println(selectedBoard);
					}
					break;
					
				case 4:			// 게시글 수정
					// 수정할 게시글 번호,  수정 게시글 정보입력
					System.out.println("수정할 글 번호 : ");
					int updateNo = sc.nextInt();
					sc.nextLine();			// 엔터 제거
					
					System.out.println("제목 : ");
					String updateTitle = sc.nextLine();
					
					System.out.println("작성자 : ");
					String updateWriter = sc.nextLine();
					
					System.out.println("내용 : ");
					String updateContent = sc.nextLine();
					
					Board updateBoard = new Board(updateTitle, updateWriter, updateContent);
					updateBoard.setNo(updateNo);
					
					int result = boardInterface.update(updateBoard);
					
					if(result > 0) {
						System.out.println("게시글 수정을 완료하였습니다.");
						System.out.println("수정한 게시글 정보");
						System.out.println(updateBoard);
					}
					else {
						System.err.println("게시글 수정에 실패하였습니다.");
					}
					break;
					
				case 5:			// 게시글 삭제
					System.out.println("삭제할 글 번호 : ");
					int deleteNo = sc.nextInt();
					sc.nextLine();			// 엔터 제거
					result = boardInterface.delete(deleteNo);
					
					if(result > 0) {
						System.out.println(deleteNo + "번의 게시글 삭제를 완료하였습니다.");
					}
					else {
						System.err.println("게시글 삭제에 실패하였습니다.");
					}
					break;
					
				case 0:			// 프로그램 종료
					System.out.println("프로그램이 종료되었습니다.");
					break;
			}
			
		} while (menuNo !=0 );
		
		System.out.println("프로그램이 종료됩니다.......");
	}
}
