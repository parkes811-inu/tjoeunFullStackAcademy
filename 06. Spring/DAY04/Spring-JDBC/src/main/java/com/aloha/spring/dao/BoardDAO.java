package com.aloha.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aloha.spring.dto.Board;

@Repository      // 데이터 엑세스 객체로 빈등록
public class BoardDAO {
   
   @Autowired
   private JdbcTemplate jdbcTemplate;

   
   /**
    * 게시글 목록 조회
    * @return
    */
   public List<Board> list() {
      
      String sql = " SELECT * FROM board ";
      List<Board> boardList = jdbcTemplate.query(sql, new RowMapper<Board>() {
    	  
         @Override
         public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
            Board board = new Board();
            board.setNo( rs.getInt("no") );
            board.setTitle( rs.getString("title") );
                board.setWriter( rs.getString("writer") );
                board.setContent( rs.getString("content") );
                board.setRegDate( rs.getTimestamp("reg_date") );
                board.setUpdDate( rs.getTimestamp("upd_date") );
                board.setViews( rs.getInt("views") );
                return board;
         }
      });
      
      return boardList;
   }
   
   /**
    * 게시글 번호 조회
    * @param no
    * @return
    */
   public Board select(int no) {
	   String sql = " SELECT * FROM board WHERE no = ? ";
	   		
	   Board board = jdbcTemplate.queryForObject(sql, new RowMapper<Board>() {
		   @Override
		   public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
		         Board board = new Board();
		         board.setNo(rs.getInt("no"));
		         board.setTitle(rs.getString("title"));
		         board.setWriter(rs.getString("writer"));
		         board.setContent(rs.getString("content"));
		         board.setRegDate(rs.getTimestamp("reg_date"));
		         board.setUpdDate(rs.getTimestamp("upd_date"));
		         board.setViews(rs.getInt("views"));
		         return board;
		    }
	   }, no );
	   
	   String update = " UPDATE board SET views = views + 1 "
					 + " WHERE no = ? ";
	    jdbcTemplate.update(update, no);

	    // 업데이트된 조회수를 반영하기 위해 board 객체의 조회수를 수동으로 증가시킵니다.
	    board.setViews(board.getViews() + 1);
	    return board;
   }
   
   /**
    * 게시글 추가
    * @param board
    * @return
    */
   public int insert(Board board) {
	  String sql = " INSERT INTO board( title, writer, content) "
	  			 + " VALUES(?, ?, ?) ";
	  
	  Object[] args = new Object[] { board.getTitle(), board.getWriter(), board.getContent() };
	  int result = jdbcTemplate.update(sql, args);
	  
      return result;
   }
   
   /**
    * 게시글 수정
    * @param board
    * @return
    */
   public int update(Board board) {
	  String sql = " UPDATE board "
	  			 + "SET title = ?, writer = ?, content = ?, upd_date = NOW() "
	  			 + " WHERE no = ? ";
	  
	  Object[] args = new Object[] { board.getTitle(), board.getWriter(), 
			  						board.getContent(), board.getNo() };
	  int result = jdbcTemplate.update(sql, args);
	  
	  return result;
   }
   
   /**
    * 게시글 삭제
    * @param no
    * @return
    */
   public int delete(int no) {
	  String sql = " DELETE FROM board "
	  			 + " WHERE no = ? ";
	  
	  int result = jdbcTemplate.update(sql, no);
	  
	  return result;
   }
   

}