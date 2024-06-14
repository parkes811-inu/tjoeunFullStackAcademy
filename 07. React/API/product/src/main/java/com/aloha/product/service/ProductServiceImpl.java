package com.aloha.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.product.dto.Product;
import com.aloha.product.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public int insert(Product product) throws Exception {
        return productMapper.insert(product);
    }

    @Override
    public Product read(int no) throws Exception {
        return productMapper.read(no);
    }

    @Override
    public List<Product> list() throws Exception {
        List<Product> productList = productMapper.list();
        return productList;
    }

    @Override
    public int update(Product product) throws Exception {
        return productMapper.update(product);
    }

    @Override
    public int delete(int no) throws Exception {
        return productMapper.delete(no);
    }

 

    
}
