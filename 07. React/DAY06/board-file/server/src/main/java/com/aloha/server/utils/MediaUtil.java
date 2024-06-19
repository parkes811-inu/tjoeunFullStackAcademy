package com.aloha.server.utils;

import org.springframework.http.MediaType;
import java.util.Map;
import java.util.HashMap;

/**
 * 확장자로 컨텐츠 타이 매핑
 * Win ext -> HTTP Content-Type
 */
public class MediaUtil {
    private static Map<String, MediaType> mediaType;
  
    static {
        mediaType = new HashMap<String, MediaType>();
        mediaType.put("JPG", MediaType.IMAGE_JPEG);
        mediaType.put("JPEG", MediaType.IMAGE_JPEG);
        mediaType.put("GIF", MediaType.IMAGE_GIF);
        mediaType.put("PNG", MediaType.IMAGE_PNG);
        mediaType.put("WEBP",  MediaType.parseMediaType("img/webp") );    // MediaType.IMAGE_WEBP 상수는 존재하지 않음 
    }
    
    // 확장자로 컨텐트타입을 확인하는 메소드
    public static MediaType getMediaType(String ext) {
        return mediaType.get(ext.toUpperCase());
    }
}
