package com.aloha.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.board.dto.Files;
import com.aloha.board.service.FileService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("${upload.path}")
    private String uploadPath;

    /**
     * 파일 다운로드
     * @param no
     * @param response
     * @throws Exception
     */
    @GetMapping("/{no}")
    public void fileDownload(@PathVariable("no") int no
                              ,HttpServletResponse response) throws Exception {
        
        Files downloadFile = fileService.download(no);

        // 파일이 없으면,
        if( downloadFile == null ) {
            return;
        }

        String fileName = downloadFile.getFileName();   // 파일 이름
        String filePath  = downloadFile.getFilePath();  // 파일 경로

        // 다운로드를 위한 응답 헤더 세팅
        // - ContentType            : application/octect-stream
        // - Content-Disposition    : attachment; filename="파일명.확장자"
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

        fileName = URLEncoder.encode(fileName, "UTF-8");
        
        response.setHeader("Content-Disposition"
                              , "attachment; filename=\"" + fileName + "\"");

        // 파일 다운로드
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);            // 파일 입력
        ServletOutputStream sos = response.getOutputStream();       // 파일 출력
        FileCopyUtils.copy(fis, sos);

        fis.close();
        sos.close();
    }
    
    /**
     * 파일 삭제
     * @param no
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{no}")
    public ResponseEntity<String> deleteFile(@PathVariable("no") int no) throws Exception {
        log.info("[DELETE] - /file/" + no);

        // 파일 삭제 요청
        int result = fileService.delete(no);

        // ✅ 삭제 성공
        if( result > 0 ) {
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }

        // ❌ 삭제 실패
        return new ResponseEntity<>("FAIL", HttpStatus.OK);
    }
    
    /**
     * 이미지 썸네일
     * @param param
     * @return
     * @throws Exception 
     */
    @GetMapping("/img/{no}")
    public ResponseEntity<byte[]> thumbnailImg(@PathVariable("no") int no) throws Exception {

        // 파일 번호로 파일 정보 조회
        Files file = fileService.select(no);

        // Null 체크
        if( file == null ) {
            String filePath = uploadPath + "/no-image.png";
            File noImageFile = new File(filePath);
            byte[] noImageFileData = FileCopyUtils.copyToByteArray(noImageFile);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(noImageFileData, headers, HttpStatus.OK);
        }

        // 파일 정보 중에서 파일 경로 가져오기
        String filePath = file.getFilePath();

        // 파일 객체 생성
        File f = new File(filePath);
        
        // 파일 데이터
        byte[] fileData = FileCopyUtils.copyToByteArray(f);

        // 이미지 컨텐츠 타입 지정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);        

        // new ResponseEntity<>( 데이터, 헤더, 상태코드 )
        return new ResponseEntity<>( fileData, headers, HttpStatus.OK );
    }
    
}
