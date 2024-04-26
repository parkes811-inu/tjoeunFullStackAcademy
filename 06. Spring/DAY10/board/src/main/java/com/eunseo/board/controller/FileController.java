package com.eunseo.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eunseo.board.dto.Files;
import com.eunseo.board.service.FileService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {
    
    @Autowired
    private FileService fileService;

    @GetMapping("/{no}")
    public void fileDownload(@PathVariable("no") int no
                              , HttpServletResponse response) throws Exception {
        
        Files downloadFile = fileService.download(no);
        
        // 파일이 없는 경우!
        if(downloadFile == null) {
            return;
        }

        // 파일이 있는 경우
        // 파일 경로, 파일 명
        String fileName = downloadFile.getFileName();
        String filePath = downloadFile.getFilePath();
        
        fileName = URLEncoder.encode(fileName, "UTF-8");

        // 다운로드를 위한 응답 헤더 세팅
        // - ContentType            : application/octect-stream
        // - Content-Disposition    : attachment, filename="파일명.확장자"
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=\""
        + fileName + "\"");

        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        ServletOutputStream sos = response.getOutputStream();
        FileCopyUtils.copy(fis, sos);

        fis.close();
        sos.close();
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<String> deleteFile(@PathVariable("no") int no) throws Exception {
        
        int result = fileService.delete(no);

        if(result > 0) {
            // 삭제 성공 시 
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK); 
        }
        return new ResponseEntity<>("FAILED", HttpStatus.OK);
    }
    
}
