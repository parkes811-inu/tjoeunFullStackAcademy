package DAY09.Ex02_Board;

public class BoardAccess implements BoardInterface {

//	Board[] boardList = new Board[10];
//	boardList[0] = new Board("제목01", "작성자01", "내용01");	
//	boardList[1] = new Board("제목02", "작성자02", "내용02");
//	boardList[2] = new Board("제목03", "작성자03", "내용03");
//	boardList[3] = new Board("제목04", "작성자04", "내용04");
//	boardList[4] = new Board("제목05", "작성자05", "내용05");	

	int count = 5;
	Board[] boardList = {	new Board("제목01", "작성자01", "내용01"),	
							new Board("제목02", "작성자02", "내용02"),
							new Board("제목03", "작성자03", "내용03"),
							new Board("제목04", "작성자04", "내용04"),
							new Board("제목05", "작성자05", "내용05")	
						};
	
	
	@Override
	public Board create(Board board) {
		if(this.count == 5) {
			System.out.println("게시글 목록이 꽉 찼습니다.");
			return null;
		}
		
		// 게시글 등록
		int boardNo = ++count;
		String regDate = "2024/02/15 - 12:00";
		String updDate = "2024/02/15 - 12:00";
		board.setNo(boardNo);
		board.setRegDate(regDate);
		board.setUpdDate(updDate);
		boardList[count - 1] = board;
		
		System.out.println(board);
		System.out.println("게시글이 등록되었습니다.");
		
		return board;
	}

	@Override
	public Board[] list() {
		if(this.count == 0) {
			System.out.println("조회된 게시글이 없습니다.");
			return null;
		}
		System.out.println("게시글 목록을 조회합니다.");
		return boardList;
	}

	@Override
	public Board read(int no) {
		if(no > 5 || no < 0) {
			System.out.println("1 ~ 5번의 게시글만 존재합니다.");
			return null;
		}
		System.out.println(no + " 번 게시글을 조회합니다.");
		return boardList[no - 1];
	}

	@Override
	public int update(Board board) {
		int no = board.getNo(); 	// 수정할 게시글 번호
		if(no > 5 || no < 0) {
			System.out.println("1 ~ 5번의 게시글만 존재합니다.");
			return 0;
		}
		// 게시글 수정
		board.setUpdDate("2024/02/15 - 14:00");
		boardList[no - 1] = board;
		return 1;					// 수정된 게시글 개수 1건
	}

	@Override
	public int delete(int no) {
		if(no > 5 || no < 0) {
			System.out.println("1 ~ 5번의 게시글만 존재합니다.");
			return 0;
		}
		
		// 게시글이 없을 때,
		if(count == 0) {
			System.out.println("삭제할 게시글이 없습니다.");
			return 0;
		}
		
		// 게시글 삭제
		boardList[no - 1] = null;	// null : 데이터가 없음을 의미
		
		// i 시작값 : 삭제할 글 index + 1
		for(int i = no; i < boardList.length; i++) {
			// 바로 앞의 위치 = 현재 접근한 글
			boardList[i - 1] = boardList[i];
		}
		
		// 앞으로 당기고 남은 가장 마지막 글 위치를 비운다.
		boardList[count - 1]  = null;
		
		// 삭제 후, 게시글 개수 1 감소
		count--;
		
		return 1;	// 삭제한 게시글 개수
	}

}
