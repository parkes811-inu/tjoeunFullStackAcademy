package com.eunseo.springnote.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunseo.springnote.dto.User;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {

    /**
     / [POST] - /test
     / data : (BODY) > (JSON) > { "data1" : "value1", "data2" : "value2" } 
     * @param map
     * @return
     *  ⭐ @RequestBody
     *      : HTTP 요청 메시지의 본문(BODY) 를 메소드의 파라미터로 매핑하는 어노테이션
     *      ✅ 주로 JSON, XML 데이터를 파라미터로 매핑하는 데 사용
     *      ❌ FORM[POST] 요청일 때는 사용하지 않는다.
     *          - FORM 요청일 때는, 객체나 컬렉션으로 자동 매핑된다.
     */
    @PostMapping("/json")
    public String jsonTest(@RequestBody Map<String, String> map) {
        log.info("[POST] - /json");
        log.info("map : " + map);
        Set<String> set = map.keySet();
        for (String key : set) {
            String value = map.get(key);
            log.info("key :  " + key + ", value : " + value);
        }
        return "test";
    }

    /**
     * data : (BODY) -> (FORM) -> formData
     * (요청) [POST]/test/form
     *  body : formData
     *  - POST로 요청 시, formData도 body에 담겨져서 보내진다.
     *  (spring)
     *  - 폼으로 전송도니 요청 body에 데이터가 있지만,
     *    스프링이 데이터를 처리하기 위해,
     *    내부적으로 body에 있는 데이터를 요청 파라미터에 매핑합니다.
     *    -> 그래서, 폼 요청 데이터는 @RequestParam으로 매핑 가능합니다.
     * @param map
     * @return
     */
    @PostMapping("/form")
    public String formTest(@RequestParam Map<String, String> map) {
        log.info("[POST] - /form");
        log.info("map : " + map);
        Set<String> set = map.keySet();
        for (String key : set) {
            String value = map.get(key);
            log.info("key :  " + key + ", value : " + value);
        }
        return "test";
    }
    
    /**
     * /test/form/user
     * data : (BODY) -> (FORM) -> formData
     * (@RequestParam) User user
     * - @RequestParam 생략 가능 - 스프링이 객체의 변수를 분석해서
     *    요청 파라미터명과 일치하는 변수에 자동 매핑한다.
     * @param user
     * @return
     */
    @PostMapping("/form/user")
    public String user(User user) {
        log.info("[POST] - /test/form/user");        
        log.info("user : " + user);
        return "test";
    }
    
    /**
     * /test/json/user
     * data : (BODY) -> (JSON) -> {"name" : "joeun", "age" : "20"}
     * - @RequestBody
     *  - 요청 본문의 데이터를 객체로 매핑한다.
     *  - 생략 시 자동 매핑이 되지 않는다.
     * @param user
     * @return
     */
    @PostMapping("/json/user")
    public String jsonUser(@RequestBody User user) {
        log.info("[POST] - /test/json/user");        
        log.info("user : " + user);
        return "test";
    }

    /**
     * - @ModelAttribute
     * 컨트롤러 메소드의 파라미터를 자동으로 모델에 등록해주는 어노테이션
     * 
     * name을 지정하지 않으면 변수명을 name으로 지정한다.
     * @param user
     * @return
     */
    @GetMapping("/model")
    public String testModel(@ModelAttribute User user) {
        user.setName("김조은");
        user.setAge(30);
        return "user";
    }


    /**
     * - @ResponseBody 
     *  - 응답 메세지 본문에 데이터를 담아서 전송해주는 어노테이션
     *  - 뷰 페이지를 응답하지 않고, 텍스트 데이터를 그대로 응답한다.
     * @return
     */
    @ResponseBody
    @GetMapping("/body")
    public String testBody() {
        return "TEST";
    }
}