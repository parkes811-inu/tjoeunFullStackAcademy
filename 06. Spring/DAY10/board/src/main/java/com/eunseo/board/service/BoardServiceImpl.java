package com.eunseo.board.service;
import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.eunseo.board.dto.Board;
import com.eunseo.board.dto.Files;
import com.eunseo.board.mapper.BoardMapper;
import com.eunseo.board.mapper.FileMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FileService fileService;

    @Override
    public List<Board> list() throws Exception {
        /*
         * TODO : boardMapper 로 list() 호출
         *        ➡ List<Board> boardList 로 받아옴
         *        ➡ return boardList
         */
        // 힌트 
        List<Board> boardList = boardMapper.list();
        return boardList;
        // ...

    }

    @Override
    public Board select(int no) throws Exception {
        /*
         * TODO : boardMapper 로 select(no) 호출
         *        ➡ Board board 로 받아옴
         *        ➡ return board
         */
        Board board = new Board();
        board = boardMapper.select(no); 
        return board;

    }

    @Override
    public int insert(Board board) throws Exception {
         /*
         * TODO : boardMapper 로 insert(Board) 호출
         *        ➡ int result 로 데이터 처리 행(개수) 받아옴
         *        ➡ return result
         */

        // 파일 업로드 
        int result = boardMapper.insert(board);

        String parentTable = "board";
        int parentNo = boardMapper.maxPk();
        List<MultipartFile> fileList = board.getFile();

        if(!fileList.isEmpty()) {
            for (MultipartFile file : fileList) {
                if( file.isEmpty() ) continue;
                
                // 파일 업로드 요청
                Files uploadFile = new Files();
                    
                uploadFile.setParentTable(parentTable);
                uploadFile.setParentNo(parentNo);
                uploadFile.setFile(file);

                fileService.upload(uploadFile);
            }
        }
        return parentNo;
    }

    @Override
    public int update(Board board) throws Exception {
        /*
         * TODO : boardMapper 로 update(Board) 호출
         *        ➡ int result 로 데이터 처리 행(개수) 받아옴
         *        ➡ return result
         */
        int result = boardMapper.update(board);

        if(result > 0) {
            return result;
        }
        return 0;

    }

    @Override
    public int delete(int no) throws Exception {
        /*
         * TODO : boardMapper 로 delete(no) 호출
         *        ➡ int result 로 데이터 처리 행(개수) 받아옴
         *        ➡ return result
         */
        int result = boardMapper.delete(no);
        
        if(result > 0) {
            return result;
        }
        return 0;
    }

}