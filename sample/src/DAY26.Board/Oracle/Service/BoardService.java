package Board.Oracle.Service;

import java.util.List;

import Board.Oracle.DTO.Board;


//2024-02-23 
//MSA 기반 풀스택 교육 16일차

//비즈니스 로직 계층

/*
 * 게시판 프로그램의 인터페이스 
 * * 게시판의 기능 메소드
 * 
 * - 게시글 목록
 * - 게시글 조회
 * - 게시글 등록
 * - 게시글 수정
 * - 게시글 삭제
 */
public interface BoardService {
	// - 게시글 목록
	List<Board> list();
	
	// - 게시글 조회
	Board select(int no);
	
	// - 게시글 등록
	int insert(Board board);
	
	// - 게시글 수정
	int update(Board board);
	
	// - 게시글 삭제
	int delete(int no);
	
}
