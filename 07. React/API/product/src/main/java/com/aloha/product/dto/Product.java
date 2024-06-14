package com.aloha.product.dto;

import java.util.Date;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Product {
    
    public int no;
    public String id;          
    public String name;
    public int price;   
    public String img;       
    public Date created_at; 
    public Date updated_at;
}
