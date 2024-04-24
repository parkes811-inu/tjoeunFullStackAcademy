package com.eunseo.springmybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eunseo.springmybatis.dto.Files;
import com.eunseo.springmybatis.mapper.FileMapper;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper files;

    // 파일 목록
    @Override
    public List<Files> list() throws Exception {
        List<Files> fileList = files.list();
        return fileList;
    }

    // 파일 조회
    @Override
    public Files select(int no) throws Exception {
        Files result = files.select(no);
        if(result != null) {
            return result;
        }
        return null;
    }

    // 파일 등록

    @Override
    public int insert(Files file) throws Exception {
        int result = files.insert(file);

        if(result > 0) {
            return result;
        }
        return 0;
    }

    // 파일 수정
    @Override
    public int update(Files file) throws Exception {
        int result = files.update(file);

        if(result > 0) {
            return result;
        }
        return 0;
    }
    
    // 파일 삭제
    @Override
    public int delete(int no) throws Exception {
        int result = files.delete(no);

        if(result > 0) {
            return result;
        }
        return 0;
    }

    // 파일 목록 - 부모 기준
    @Override
    public List<Files> listByParent(Files file) throws Exception {
        List<Files> result = files.listByParent(file);

        if(result != null) {
            return result;
        }
        return null;
    }

    // 파일 삭제 - 부모 기준
    @Override
    public int deleteByParent(Files file) throws Exception {
        int result = files.deleteByParent(file);

        if(result > 0) {
            return result;
        }
        return 0;
    }

    @Override
    public int upload(String parentTable, int parentNo, List<MultipartFile> fileList) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upload'");
    }

    @Override
    public int download(int fileNo, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'download'");
    }
}
