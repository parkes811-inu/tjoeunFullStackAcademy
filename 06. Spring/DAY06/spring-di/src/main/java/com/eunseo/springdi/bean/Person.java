package com.eunseo.springdi.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 빈 등록
 * @Component
 */
@Data
@Component("person")
public class Person {
    private String name;
    private int age;

    // 기본 생성자
    public Person() {
        this.name = "김조은";
        this.age = 20;
    }
}
