package com.aloha.product.service;

import com.aloha.product.dto.Product;
import java.util.List;

public interface ProductService {
    
    // create
    public int insert (Product product) throws Exception;

    // read
    public Product read(int no) throws Exception;

    // read all
    public List<Product> list() throws Exception;

    // update
    public int update(Product product) throws Exception;

    // delete
    public int delete(int no) throws Exception;
}
