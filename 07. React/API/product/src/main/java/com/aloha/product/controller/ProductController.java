package com.aloha.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aloha.product.dto.Product;
import com.aloha.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Product> productList = productService.list();
            if (!productList.isEmpty()) {
                return new ResponseEntity<>(productList, HttpStatus.OK);
            } else {
                log.info("시발");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No products found
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{no}")
    public ResponseEntity<?> getOne(@PathVariable Integer no) {
        try {
            Product product = productService.read(no);
            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Product not found
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product) {
        try {
            int result = productService.insert(product);
            if (result > 0) {
                return new ResponseEntity<>(result, HttpStatus.CREATED); // Product created
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Failed to create product
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Product product) {
        try {
            int result = productService.update(product);
            if (result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK); // Product updated
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Failed to update product
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<?> destroy(@PathVariable Integer no) {
        try {
            int result = productService.delete(no);
            if (result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK); // Product deleted
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Product not found
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
