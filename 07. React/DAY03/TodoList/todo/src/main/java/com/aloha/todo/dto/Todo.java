package com.aloha.todo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Todo {
    private int no;
    private String name;
    private int status;
    private Date reg_date; 
    private Date upd_date;

}
