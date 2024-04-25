package com.eunseo.springnote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/rest")
public class TestRestController {

    /**
     * - @RestController = @Controller + @ResponseBody
     *  - @ResponseBody가 없어도, 데이터를 응답 본문(Body)에 담아서 전송한다.
     * @return
     */
    @GetMapping("/body")
    public String restBody() {
        return "REST";
    }
    
}th