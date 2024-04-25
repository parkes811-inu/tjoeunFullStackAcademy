package com.eunseo.springrest.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.eunseo.springrest.dto.Files;

import jakarta.servlet.http.HttpServletResponse;

public interface FileService {

    // 파일 목록
    public List<Files> list() throws Exception;
    // 파일 조회
    public Files select(int boardNo) throws Exception;
    // 파일 등록
    public int insert(Files board) throws Exception;
    // 파일 수정
    public int update(Files board) throws Exception;
    // 파일 삭제
    public int delete(int boardNo) throws Exception;

    // 파일 목록 - 부모 기준
    public List<Files> listByParent(Files file) throws Exception;
    // 파일 삭제 - 부모 기준
    public int deleteByParent(Files file) throws Exception;
    
    // 파일 업로드
    public int upload(String parentTable, int parentNo, List<MultipartFile> fileList) throws Exception;

    // 파일 다운로드
    public int download(int fileNo, HttpServletResponse response) throws Exception;
    
} 
