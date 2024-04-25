package com.eunseo.springnote.dto;

import lombok.Data;

@Data
public class User {
    private String name;
    private int age;


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }

}
