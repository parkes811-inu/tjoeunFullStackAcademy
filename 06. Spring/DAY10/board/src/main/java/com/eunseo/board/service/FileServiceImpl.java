package com.eunseo.board.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.eunseo.board.dto.Files;
import com.eunseo.board.mapper.FileMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;
    
    @Value("${upload.path}")
    private String uploadPath;
    
    // 파일 목록
    @Override
    public List<Files> list() throws Exception {
        List<Files> fileList = fileMapper.list();
        return fileList;
    }

    // 파일 조회
    @Override
    public Files select(int no) throws Exception {
        Files result = fileMapper.select(no);
        if(result != null) {
            return result;
        }
        return null;
    }

    // 파일 등록
    @Override
    public int insert(Files file) throws Exception {
        int result = fileMapper.insert(file);
        return result;
    }

    // 파일 수정
    @Override
    public int update(Files file) throws Exception {
        int result = fileMapper.update(file);

        if(result > 0) {
            return result;
        }
        return 0;
    }
    
    // 파일 삭제
    @Override
    public int delete(int no) throws Exception {
        // 파일 정보 조회
        Files file = fileMapper.select(no);
        
        // DB 파일 정보 삭제
        int result = fileMapper.delete(no);

        // 파일 시스템의 파일 삭제
        if (result > 0) {
            String filePath = file.getFilePath();
            File deleteFile = new File(filePath);
            // 파일 존재 확인
            if (!deleteFile.exists()) {
                return result;
            }
            // 파일 삭제
            if (deleteFile.delete()) {
                log.info("파일이 정상적으로 삭제 되었습니다.");
                log.info("file : " + filePath);
            } else {
                log.info("파일 삭제에 실패하였습니다.");
    
            }
        }
        return result;
    }

    // 파일 목록 - 부모 기준
    @Override
    public List<Files> listByParent(Files file) throws Exception {
        List<Files> fileList = fileMapper.list();
        return fileList;
    }

    // 파일 삭제 - 부모 기준
    @Override
    public int deleteByParent(Files file) throws Exception {
        
        List<Files> fileList = fileMapper.listByParent(file);
        
        for (Files deleteFile : fileList) {
            int no = deleteFile.getNo();
            delete(no);
        }
        
        int result = fileMapper.deleteByParent(file);
        log.info(result + "개의 파일을 삭제하였습니다.");

        return result;
    }

    @Override
    public boolean upload(Files file) throws Exception {

        log.info("file : " + file);
        // 파일 정보 : 원본 파일명, 파일 용량, 파일 데이터
        MultipartFile mf = file.getFile();

        String orginName = mf.getOriginalFilename();
        long fileSize = mf.getSize();
        byte[] fileData = mf.getBytes();

        log.info("원본 파일명 : " + orginName);
        log.info("파일 용량 : " + fileSize);
        log.info("파일 데이터 : " + fileData);
        
        // - 파일의 정보를 DB에 등록
        // 업로드 경로 - application.properties (upload.path)
        // File uploadFile = new File(업로드 경로, 파일명)
        String fileName = UUID.randomUUID().toString() + "_" + orginName;
        File uploadFile = new File(uploadPath, fileName);

        // File Upload
        FileCopyUtils.copy(fileData, uploadFile);

        // 파일 정보 등록
        file.setFileName(fileName);
        file.setOriginName(orginName);
        // filePath = C:/upload/UUID_원본파일명.xxx
        String filePath = uploadPath + "/" + fileName;
        file.setFilePath(filePath);
        file.setFileSize(fileSize);
        file.setFileCode(0);
        
        fileMapper.insert(file);

        return true;
    }

    @Override
    public Files download(int no) throws Exception {
        Files file = fileMapper.select(no);

        // 다운 로드 시, 추가 작업
        // ...

        return file;
    }
}
