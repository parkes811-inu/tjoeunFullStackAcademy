package com.aloha.security5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    
    @GetMapping({"/", ""})
    public String index() {
        log.info("/user");

        return "/user/index";
    }
    
}
